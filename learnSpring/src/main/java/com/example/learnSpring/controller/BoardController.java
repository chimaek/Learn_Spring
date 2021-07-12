package com.example.learnSpring.controller;

import com.example.learnSpring.auth.PrincipalDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @Autowired
    private PrincipalDetail principalDetail;

    @GetMapping({"/",""})
    public String index() {
        return "index";
    }



}
