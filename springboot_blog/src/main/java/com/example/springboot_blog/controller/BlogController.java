package com.example.springboot_blog.controller;

import com.example.springboot_blog.domain.Role;
import com.example.springboot_blog.domain.User;
import com.example.springboot_blog.repository.UserRepository;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BlogController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자는 없습니다."));


    }

    @GetMapping("/dummy/user")
    public Page<User> pageList(@PageableDefault(size = 2, sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage;
    }

    @GetMapping("/dummy/users")
    public List<User> userList() {
        return userRepository.findAll();
    }


    @PostMapping("/dummy/join")
    public User join(@RequestBody User user) {

        user.setRole(Role.ADMIN);
        return userRepository.save(user);

    }
    @Transactional //더티 체킹 영속화....
    @PutMapping("/dummy/user/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        User user1 = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("계정이 없습니다."));
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        return user1;
    }

    @Transactional
    @DeleteMapping("/dummy/user/delete/{id}")
    public String delete(@PathVariable int id){
        try {
            userRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return "삭제에 실패하였습니다.";
        }
        return "삭제 성공";
    }

}
