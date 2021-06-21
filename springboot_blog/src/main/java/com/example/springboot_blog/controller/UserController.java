package com.example.springboot_blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/joinForm.jsp")
    public String joinForm(){
        return "user/joinForm.jsp";
    }
}
