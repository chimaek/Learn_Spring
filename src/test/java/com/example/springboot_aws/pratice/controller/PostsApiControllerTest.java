package com.example.springboot_aws.pratice.controller;

import com.example.springboot_aws.pratice.domain.posts.Posts;
import com.example.springboot_aws.pratice.dto.PostsSaveRequestDto;
import com.example.springboot_aws.pratice.dto.PostsUpdateRequestDto;
import com.example.springboot_aws.pratice.repository.PostsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;
    @Autowired
    private PostsRepository postsRepository;


    @AfterEach
    void tearDown() {
        postsRepository.deleteAll();
    }

    @Test
    void posts등록된다() {
        String title = "me";
        String author = "승주";
        String content = "내용";

        PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts";

        ResponseEntity<Long> responseEntity = template.postForEntity(url, dto, Long.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Posts> postsList = postsRepository.findAll();

        assertThat(postsList.get(0).getClass()).isEqualTo(Posts.class);
        assertThat(postsList.get(0).getTitle()).isEqualTo(title);
        assertThat(postsList.get(0).getContent()).isEqualTo(content);
        assertThat(postsList.get(0).getAuthor()).isEqualTo(author);

    }

    @Test
    void 수정된다() {
        Posts savePosts = postsRepository.save(Posts.builder().content("내용1").title("제목1").author("저자").build());
        Long updateId = savePosts.getId();

        PostsUpdateRequestDto dto = PostsUpdateRequestDto.builder().title("제목2").content("내용2").build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;

        HttpEntity<PostsUpdateRequestDto> dtoHttpEntity = new HttpEntity<>(dto);

        ResponseEntity<Long> responseEntity = template.exchange(url, HttpMethod.PUT, dtoHttpEntity, Long.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Posts> postsList = postsRepository.findAll();
        assertThat(postsList.get(0).getTitle()).isNotEqualTo("제목1");
        assertThat(postsList.get(0).getContent()).isNotEqualTo("내용1");
        assertThat(postsList.get(0).getAuthor()).isEqualTo(savePosts.getAuthor());
    }
}