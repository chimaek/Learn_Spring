package com.example.springboot_aws.pratice.controller;


import com.example.springboot_aws.pratice.dto.PostsResponseDto;
import com.example.springboot_aws.pratice.dto.PostsSaveRequestDto;
import com.example.springboot_aws.pratice.dto.PostsUpdateRequestDto;
import com.example.springboot_aws.pratice.service.PostsService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
public class PostsApiController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PostsService postsService;

    @Autowired
    public PostsApiController(PostsService postsService) {
        this.postsService = postsService;
    }
    @CrossOrigin
    @PostMapping(value = "/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto) {
        return postsService.update(id, postsUpdateRequestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto dto(@PathVariable Long id) {
        return postsService.findById(id);
    }

}
