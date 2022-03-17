package org.iptime.yoon.springbootserver.service;

import org.iptime.yoon.springbootserver.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * @author rival
 * @since 2022-03-17
 */
public interface BoardService {

    public Page<Board> findBoardList(Pageable pageable);

    public Board findBoardById(Long id);
}
