package com.example.learnSpring.controller;

import com.example.learnSpring.dto.ResponseDto;
import com.example.learnSpring.model.User;
import com.example.learnSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    public User join(@RequestBody User user) {

        userRepository.save(user);

        return user;
    }

    @Transactional(readOnly = true)
    @GetMapping("/user/{id}")
    public User selectUser(@PathVariable int id) {

        return userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 사용자는 없습니다.");
        });

    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable int id) {

        try {
            userRepository.deleteById(id);

        } catch (IllegalArgumentException e) {
            return "삭제에 실패";
        }

        return "삭제됨....";
    }



    @GetMapping("/user")
    public Page<User> users(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.ASC) Pageable page) {

        Page<User> test = userRepository.findAll(page);
        if (test.isLast()) {
            System.out.println("마지마기여");
        }
        return test;
    }

    @Transactional()
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("사용자가 없습니다.");
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
        return userRepository.save(user);

    }





}
