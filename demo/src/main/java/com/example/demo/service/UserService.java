package com.example.demo.service;

import com.example.demo.dto.JoinReqeustDto;
import com.example.demo.dto.UpdateRequestDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 유저가 없습니다.");
        });
    }

    @Transactional
    public User saveUser(JoinReqeustDto userRequest) {
        User user = userRepository.findByUsername(userRequest.getUsername());
        if (user == null) {
            user = User.builder()
                    .email(userRequest.getEmail())
                    .username(userRequest.getUsername())
                    .password(userRequest.getPassword())
                    .build();
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Transactional
    public User updateUser(int id, UpdateRequestDto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 사용자는 없습니다.");
        });
        //더티체킹
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
