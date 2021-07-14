package com.example.learnSpring.service;

import com.example.learnSpring.model.Board;
import com.example.learnSpring.model.User;
import com.example.learnSpring.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void writeBoard(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }
    @Transactional(readOnly = true)
    public List<Board> boardList(){

        return boardRepository.findAll();
    }
}
