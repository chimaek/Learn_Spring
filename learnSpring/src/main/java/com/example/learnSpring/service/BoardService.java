package com.example.learnSpring.service;

import com.example.learnSpring.model.Board;
import com.example.learnSpring.model.User;
import com.example.learnSpring.repository.BoardRepository;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void writeBoard(Board board, User user) {
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Board seeContent(int id) {
        return boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("아이디를 찾지못했습니다.");
        });
    }

    @Transactional
    public void delete(int id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void updateBoard(int id, Board requestBoard) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("글찾기 실패");
        }); // 영속화완료
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
    }
}
