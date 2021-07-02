package com.example.learnSpring.controller;

import com.example.learnSpring.model.User;
import com.example.learnSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/join")
    public String join(@RequestBody User user){

    }
}
