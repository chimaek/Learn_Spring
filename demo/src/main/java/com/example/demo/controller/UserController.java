package com.example.demo.controller;

import com.example.demo.dto.JoinReqeustDto;
import com.example.demo.dto.UpdateRequestDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin()
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public UserDto<List<User>> findAll() {
        log.info("검색 호출....");
        try {
            return new UserDto<>(HttpStatus.OK.value(), userService.getAll());
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
        return null;
    }

    @GetMapping("/user/{id}")
    public UserDto<User> findById(@PathVariable int id) {
        log.info("유저 검색 호출");
        try {
            return new UserDto<>(HttpStatus.OK.value(), userService.getUser(id));
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
        return null;

    }

    @PostMapping("/user")
    public UserDto<String> save(@RequestBody JoinReqeustDto userRequest) {
        User user = userService.saveUser(userRequest);
        if (user != null) {
            return new UserDto<>(HttpStatus.CREATED.value(), "회원가입이 완료되었습니다.");
        }
        log.info("이미 존재하는 사용자입니다.");
        return new UserDto<>(HttpStatus.BAD_REQUEST.value(), "이미 존재하는 사용자DU다.");
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable int id) {

    }

    @PutMapping("/user/{id}")
    private UserDto<?> update(@PathVariable int id, @RequestBody UpdateRequestDto dto) {
        User user;
        user = userService.updateUser(id, dto);
        return new UserDto<User>(HttpStatus.OK.value(),user);
    }
}

