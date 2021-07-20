package com.example.learnSpring.service;

import com.example.learnSpring.dto.ReplySaveRequestDto;
import com.example.learnSpring.model.Board;
import com.example.learnSpring.model.Reply;
import com.example.learnSpring.model.User;
import com.example.learnSpring.repository.BoardRepository;
import com.example.learnSpring.repository.ReplyRepository;
import com.example.learnSpring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //이걸 붙이면 파이널에 있는  값들을 di해줌
public class BoardService {

    private final BoardRepository boardRepository;

    private final ReplyRepository replyRepository;

    private final UserRepository userRepository;

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

    @Transactional
    public void saveReply(ReplySaveRequestDto replySaveRequestDto) {

//        User user = userRepository.findById(replySaveRequestDto.getUserId()).orElseThrow(() -> {
//            return new IllegalArgumentException("해당 유저가 존재하지 않습니다.");
//        });
//
//        Board board = boardRepository.findById(replySaveRequestDto.getBoardId()).orElseThrow(() -> {
//            return new IllegalArgumentException("해당 목록이 없습니다.");
//        });
//        Reply reply = new Reply();
//        reply.update(user, board, replySaveRequestDto.getContent());

        // -----------------------------------------------------------------------------------------------
//        Reply reply = Reply.builder()
//                .user(user)
//                .board(board)
//                .content(replySaveRequestDto.getContent())
//                .build();


        replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent().trim());
    }

    @Transactional
    public void deleteReply(int replyId) {
        replyRepository.deleteById(replyId);
    }
}
