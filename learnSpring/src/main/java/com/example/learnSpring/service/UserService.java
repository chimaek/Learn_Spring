package com.example.learnSpring.service;

import com.example.learnSpring.model.RollType;
import com.example.learnSpring.model.User;
import com.example.learnSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @Transactional(readOnly = true)
//    public User login(User user) {
//        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//
//    }
}
