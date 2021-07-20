package com.example.learnSpring.dto;

import com.example.learnSpring.model.Board;
import com.example.learnSpring.model.Reply;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplySaveRequestDto {
    private int userId;
    private int boardId;
    private String content;
}
