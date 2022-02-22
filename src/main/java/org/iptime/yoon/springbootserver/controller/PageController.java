package org.iptime.yoon.springbootserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author rival
 * @since 2022-02-21
 */
@Controller
public class PageController {
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("msg","Hello");
        return "index";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }
}
