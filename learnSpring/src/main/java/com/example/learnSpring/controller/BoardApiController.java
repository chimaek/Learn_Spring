package com.example.learnSpring.controller;

import com.example.learnSpring.auth.PrincipalDetail;
import com.example.learnSpring.dto.ReplySaveRequestDto;
import com.example.learnSpring.dto.ResponseDto;
import com.example.learnSpring.model.Board;
import com.example.learnSpring.model.Reply;
import com.example.learnSpring.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
public class BoardApiController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){

        boardService.writeBoard(board,principal.getUser());

        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id){
        boardService.delete(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }
    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> updateBoard(@PathVariable int id,@RequestBody Board board){
        boardService.updateBoard(id,board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    // 데이터를 받을 때 컨트롤러에서 dto를 만들어서 받는게 좋다.
    @PostMapping("/api/board/{boardId}")
    public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto){
        System.out.println(replySaveRequestDto);
        boardService.saveReply(replySaveRequestDto);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

    @DeleteMapping("/api/board/{boardId}/reply/{replyId}")
    public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
        boardService.deleteReply(replyId);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

}
