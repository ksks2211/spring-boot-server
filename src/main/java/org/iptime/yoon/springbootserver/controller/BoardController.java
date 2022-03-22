package org.iptime.yoon.springbootserver.controller;

import lombok.RequiredArgsConstructor;
import org.iptime.yoon.springbootserver.domain.Post;
import org.iptime.yoon.springbootserver.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author rival
 * @since 2022-03-17
 */
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final PostService postService;


    @GetMapping({"","/"})
    public String board(@RequestParam(value = "id",defaultValue = "0") Long id, Model model){
        model.addAttribute("board", postService.findPost(id));
        return "/board/form";
    }

//    @GetMapping("/list")
//    public String list(@PageableDefault Pageable pageable, Model model){
//        Page<Post> boardList = postService.findPosts(pageable);
//        model.addAttribute("boardList",boardList);
//        return "/board/list";
//    }

}
