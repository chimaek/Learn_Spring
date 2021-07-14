package com.example.learnSpring.controller;

import com.example.learnSpring.auth.PrincipalDetail;
import com.example.learnSpring.model.Board;
import com.example.learnSpring.model.User;
import com.example.learnSpring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {
//
//    @Autowired
//    private PrincipalDetail principalDetail;

    @Autowired
    private BoardService boardService;

    @GetMapping({"/", ""})
    public String index(Model model,@PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Board> userPage = boardService.boardList(pageable);
        model.addAttribute("boards",userPage);
//        System.out.println(boardService.boardList());
        return "index";
    }

    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id,Model model){
        model.addAttribute("board",boardService.seeContent(id));
        return "board/detail";
    }


}
