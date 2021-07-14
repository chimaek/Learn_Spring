package com.example.learnSpring.controller;

import com.example.learnSpring.auth.PrincipalDetail;
import com.example.learnSpring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
//
//    @Autowired
//    private PrincipalDetail principalDetail;

    @Autowired
    private BoardService boardService;

    @GetMapping({"/", ""})
    public String index(Model model) {
        model.addAttribute("boards",boardService.boardList());
        System.out.println(boardService.boardList());
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }


}
