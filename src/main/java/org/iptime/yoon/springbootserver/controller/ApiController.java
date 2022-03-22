package org.iptime.yoon.springbootserver.controller;

import lombok.RequiredArgsConstructor;
import org.iptime.yoon.springbootserver.domain.Post;
import org.iptime.yoon.springbootserver.service.PostService;
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
    private final PostService postService;


//    @GetMapping({"","/"})
//    public Post board(@RequestParam(value = "id",defaultValue = "0") Long id, Model model){
//        // Post post = postService.findPost(id);
//        return post;
//    }
//
//    @GetMapping("/list")
//    public Page<Post> list(@PageableDefault Pageable pageable, Model model){
//        // Page<Post> boardList = postService.findPosts(pageable);
//        return boardList;
//    }

}
