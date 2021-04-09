package com.chimaek.board.Domain;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class PostsRepoTest {

    @Autowired
    PostsRepo postsRepo;

    @Test
    public void load_content(){
        //given
        String title = "asdsa";
        String content = "dasdad";

        postsRepo.save(Posts.builder()
        .title(title)
        .content(content)
        .author("asmdamdamdamamdamdmas")
        .build());

        //when

        List<Posts> postsList = postsRepo.findAll();

        //then

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}