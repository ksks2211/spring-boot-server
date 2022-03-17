package org.iptime.yoon.springbootserver.service;

import org.iptime.yoon.springbootserver.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import static org.assertj.core.api.Assertions.assertThat;

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
    void board_id_find_test(){
        Board board = boardService.findBoardById(1L);
        System.out.println(board);

        assertThat(board).isNotNull();
    }

    @Test
    void board_page_find_test(){
        Page<Board> boardList = boardService.findBoardList(pageable);
        boardList.forEach(System.out::println);
        assertThat(boardList).hasSize(10);
    }



}