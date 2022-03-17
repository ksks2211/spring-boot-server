package org.iptime.yoon.springbootserver.controller;

import lombok.RequiredArgsConstructor;
import org.iptime.yoon.springbootserver.domain.Board;
import org.iptime.yoon.springbootserver.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rival
 * @since 2022-03-17
 */
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ApiController {
    private final BoardService boardService;


    @GetMapping({"","/"})
    public Board board(@RequestParam(value = "id",defaultValue = "0") Long id, Model model){
        Board board = boardService.findBoardById(id);
        return board;
    }

    @GetMapping("/list")
    public Page<Board> list(@PageableDefault Pageable pageable, Model model){
        Page<Board> boardList = boardService.findBoardList(pageable);
        return boardList;
    }

}
