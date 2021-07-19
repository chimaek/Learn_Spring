package com.example.learnSpring.service;

import com.example.learnSpring.model.RollType;
import com.example.learnSpring.model.User;
import com.example.learnSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public int signUser(User user) {
        String Encpassword = encoder.encode(user.getPassword());
        user.setPassword(Encpassword);
        user.setRole(RollType.USER);
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("회원가입" + e.getMessage());
            return -1;
        }
    }

    @Transactional
    public void update(User requestUser) {
        User user = userRepository.findById(requestUser.getId()).orElseThrow(() -> {
            return new IllegalArgumentException("유저가 없습니다.");
        });
        user.setEmail(requestUser.getEmail());
        user.setPassword(encoder.encode(requestUser.getPassword()));

    }

    @Transactional(readOnly = true)
    public User findUser(String username){
        return userRepository.findByUsername(username).orElseGet(()->{
            return new User();
        });
    }

//    @Transactional(readOnly = true)
//    public User login(User user) {
//        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//
//    }
}
