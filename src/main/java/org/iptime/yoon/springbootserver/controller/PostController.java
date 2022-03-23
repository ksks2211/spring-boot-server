package org.iptime.yoon.springbootserver.controller;

import lombok.RequiredArgsConstructor;
import org.iptime.yoon.springbootserver.dto.PageRequestDto;
import org.iptime.yoon.springbootserver.dto.PostsResultDto;
import org.iptime.yoon.springbootserver.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author rival
 * @since 2022-03-17
 */
@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping({"","/"})
    public String posts(Model model){
        PageRequestDto pageRequestDto = PageRequestDto.builder()
            .size(10)
            .page(1).build();
        PostsResultDto resultDto = postService.findPosts(pageRequestDto);

        model.addAttribute("posts",resultDto.getPosts());
        model.addAttribute("pageList",resultDto.getPageList());

        return "post";
    }


//    @GetMapping("/list")
//    public String list(@PageableDefault Pageable pageable, Model model){
//        Page<Post> boardList = postService.findPosts(pageable);
//        model.addAttribute("boardList",boardList);
//        return "/board/list";
//    }

}
