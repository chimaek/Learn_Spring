package com.example.learnSpring.controller;

import com.example.learnSpring.dto.ResponseDto;
import com.example.learnSpring.model.RollType;
import com.example.learnSpring.model.User;
import com.example.learnSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private UserService userService;


    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
//        System.out.println("호출됨");
        user.setRole(RollType.USER);
        int result = userService.signUser(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
    }

}
