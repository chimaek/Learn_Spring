package com.example.learnSpring.repository;

import com.example.learnSpring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

//    User findByUsernameAndPassword(String username,String password);

}
