package org.iptime.yoon.springbootserver.service;

import lombok.RequiredArgsConstructor;
import org.iptime.yoon.springbootserver.domain.Board;
import org.iptime.yoon.springbootserver.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author rival
 * @since 2022-03-17
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;


    @Override
    public Page<Board> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(
            pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
            pageable.getPageSize() > 20 ? 20 : pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }

    @Override
    public Board findBoardById(Long id) {
        return boardRepository.findById(id).orElse(new Board());
    }
}
