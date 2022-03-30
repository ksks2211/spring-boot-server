package org.iptime.yoon.springbootserver.controller;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author rival
 * @since 2022-03-30
 */

@Controller
public class SecurityController {
    @GetMapping("/")
    public String main(Model model, HttpSession session){

        if(session!=null) {
            model.addAttribute("sessionId", session.getId());
        }
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "denied";
    }


    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/user")
    public String userPage() throws AccessDeniedException {
        //if(true) throw new AccessDeniedException("Access Denied");
        return "user";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }

}
