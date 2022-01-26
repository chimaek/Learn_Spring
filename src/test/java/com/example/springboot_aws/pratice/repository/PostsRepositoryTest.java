package com.example.springboot_aws.pratice.repository;

import com.example.springboot_aws.pratice.domain.posts.Posts;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {
    @Autowired
    private PostsRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    public void post저장() {
        String title = "제목";
        String content = "내용";
        String author = "저자";
        Posts p1 = Posts.builder().title(title).content(content).author(author).build();
        repository.save(p1);

        //when
        List<Posts> all = repository.findAll();

        assertThat(all.size()).isEqualTo(1);
        assertThat(all.get(0).getClass()).isEqualTo(p1.getClass());
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getAuthor()).isEqualTo(author);

    }

    @Test
    public void 타임등록() {
        LocalDateTime now = LocalDateTime.now();
        repository.save(Posts.builder().title("title").content("내영").author("저자").build());
        List<Posts> postsList = repository.findAll();

        Posts posts = postsList.get(0);
        System.out.println(posts.getCreateDateTime());
        System.out.println(posts.getModifiedDate());
        assertThat(posts.getCreateDateTime()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}