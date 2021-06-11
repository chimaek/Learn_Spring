package com.example.springboot_react_backend.web;

import com.example.springboot_react_backend.domain.Book;
import com.example.springboot_react_backend.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@AutoConfigureMockMvc
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BookIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void 각테스트초기화() {
//        entityManager.createNativeQuery("ALTER TABLE book ALTER COLUMN id RESTART WITH 1").executeUpdate(); //h2문법
        entityManager.createNativeQuery("ALTER TABLE book AUTO_INCREMENT=1").executeUpdate();
    }

    @Test
    public void save_테스트() throws Exception {
        log.info("save_테스트() 시작============================================");
        Book book = new Book(null, "스프링따라하기", "코스");
        //given 테스트하기 위한 준비
        String content = new ObjectMapper().writeValueAsString(book); // JSON데이터가 됨
        //stub 행동지정하기
        //when(bookService.saveBook(book)).thenReturn(new Book(1L, "스프링따라하기", "코스")); 통합에서는 필요없음

        //when( 테스트 실행)
        ResultActions resultActions = mockMvc.perform(post("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .accept(MediaType.APPLICATION_JSON));

        //then(검증)
        resultActions
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("스프링따라하기"))
                .andExpect(jsonPath("$.author").value("코스"))
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void find_all테스트() throws Exception {
        //given
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "스", "ㅋㅋ"));
        books.add(new Book(2L, "프", "ㅠㅠ"));
        books.add(new Book(3L, "링", "교교"));
        //STUB
        bookRepository.saveAll(books);

        //WHEN
        ResultActions resultActions = mockMvc.perform(get("/book")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        //then

        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(3)))
                .andExpect(jsonPath("$.[0].title").value("스"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void find_getOneBook() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "스", "ㅋㅋ"));
        books.add(new Book(2L, "프", "ㅠㅠ"));
        books.add(new Book(3L, "링", "교교"));
        //STUB
        bookRepository.saveAll(books);

        //given
        Long id = 1L;

        ResultActions resultActions = mockMvc.perform(get("/book/{id}", id)
                .accept(MediaType.APPLICATION_JSON));

        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("스"))
                .andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void 북업데이트테스트() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(new Book(null, "스", "ㅋㅋ"));
        books.add(new Book(null, "프", "ㅠㅠ"));
        books.add(new Book(null, "링", "교교"));
        //STUB
        bookRepository.saveAll(books);

        Long id = 1L;
        Book book = new Book(null, "c++따라하기", "코스");
        //given 테스트하기 위한 준비
        String content = new ObjectMapper().writeValueAsString(book); // JSON데이터가 됨


        ResultActions resultActions = mockMvc.perform(put("/book/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content)
                .accept(MediaType.APPLICATION_JSON));

        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("c++따라하기"))
                .andDo(MockMvcResultHandlers.print());


    }

    @Test
    public void 삭제테스트() throws Exception {
        Long id = 1L;
        //stub 행동지정하기
        bookRepository.save(new Book(null, "name", "me"));

        ResultActions resultActions = mockMvc.perform(delete("/book/{id}", id));

        resultActions
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        MvcResult result = resultActions.andReturn();
        String fin = result.getResponse().getContentAsString();

        assertEquals("ok", fin);

    }

}
