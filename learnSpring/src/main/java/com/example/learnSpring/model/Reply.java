package com.example.learnSpring.model;

import com.example.learnSpring.dto.ReplySaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 200)
    private String content;

    @JoinColumn(name="boardId")
    @ManyToOne
    private Board board;

    @JoinColumn(name="userId")
    @ManyToOne
    private User user;

    @CreationTimestamp
    private Timestamp createDate;

    @UpdateTimestamp
    private Timestamp updateDate;

    public void update(User user,Board board,String content){
        setUser(user);
        setBoard(board);
        setContent(content);
    }


}
