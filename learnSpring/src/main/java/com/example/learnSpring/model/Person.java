package com.example.learnSpring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private int id;
    private String username;
    private String password;
    private String email;
}
