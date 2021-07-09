package com.example.learnSpring.controller;

import com.example.learnSpring.dto.ResponseDto;
import com.example.learnSpring.model.RollType;
import com.example.learnSpring.model.User;
import com.example.learnSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ApiController {
    @Autowired
    private UserService userService;

    //    @Autowired
//    private HttpSession session;


    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("save 호출됨");
        userService.signUser(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //레거시 로그인 without security
//    @PostMapping("/api/user/login")
//    public ResponseDto<Integer> login(@RequestBody User user) {
//        System.out.println("로그인 호출");
//        User principal = userService.login(user);
//        if (principal != null) {
//            session.setAttribute("principal", principal);
//        }
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }

}
