package com.example.learnSpring.repository;

import com.example.learnSpring.dto.ReplySaveRequestDto;
import com.example.learnSpring.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Modifying
    @Query(value = "INSERT INTO reply(userId,BoardId,content,createDate,updateDate) VALUES(?1,?2,?3,now(),now())", nativeQuery = true)
    int mSave(int userId, int boardId, String content);
}
