package com.example.springboot_aws.pratice.controller;


import com.example.springboot_aws.pratice.dto.PostsSaveRequestDto;
import com.example.springboot_aws.pratice.service.PostsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PostsApiController {

    private final PostsService postsService;

    @Autowired
    public PostsApiController(PostsService postsService) {
        this.postsService = postsService;
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }

}
