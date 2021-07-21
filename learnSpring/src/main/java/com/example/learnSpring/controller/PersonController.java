package com.example.learnSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/person")
    public void findAll() {

    }
    @GetMapping("/person/{id}")
    public void findAll(@PathVariable int id) {

    }
}
