package org.iptime.yoon.springbootserver.service;

import org.iptime.yoon.springbootserver.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author rival
 * @since 2022-03-17
 */
@SpringBootTest
class BoardServiceTest {

    @Autowired
    BoardService boardService;

    Pageable pageable = PageRequest.of(0,10);


    @Test
    void board_id조회_테스트(){
        Board board = boardService.findBoardById(1L);
        System.out.println(board);
        assertThat(board).isNotNull();
    }

    @Test
    void board_page조회_테스트(){
        Page<Board> boardList = boardService.findBoardList(pageable);
        boardList.forEach(System.out::println);
        assertThat(boardList).hasSize(10);
    }



}