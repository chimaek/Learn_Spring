package com.example.learnSpring.repository;


import com.example.learnSpring.model.Board;
import com.example.learnSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Integer> {
}
