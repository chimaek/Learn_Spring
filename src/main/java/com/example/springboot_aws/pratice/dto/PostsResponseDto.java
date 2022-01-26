package com.example.springboot_aws.pratice.dto;

import com.example.springboot_aws.pratice.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;

    public PostsResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.author = posts.getAuthor();
        this.content = posts.getContent();
    }
}
