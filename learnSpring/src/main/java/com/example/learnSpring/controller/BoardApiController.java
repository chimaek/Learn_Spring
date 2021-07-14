package com.example.learnSpring.controller;

import com.example.learnSpring.auth.PrincipalDetail;
import com.example.learnSpring.dto.ResponseDto;
import com.example.learnSpring.model.Board;
import com.example.learnSpring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardApiController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){

        boardService.writeBoard(board,principal.getUser());

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

}
