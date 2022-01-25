package com.example.springboot_aws.pratice.controller;

import com.example.springboot_aws.pratice.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "헬로";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);

    }
}
