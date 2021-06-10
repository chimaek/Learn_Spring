package com.example.springboot_react_backend.domain;


import com.example.springboot_react_backend.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Replace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) //가짜 db로 테스트 왜? 단위 테스트니까? 통합에서는 none으로 주기
@DataJpaTest //mock을 안해도 되는 이유는 이 어노테이션이 Repository들을 다 IoC에 등록해줌
public class BookRepositoryUnitTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void save_테스트(){
        Book book = new Book();
        book.setTitle("제목");
        book.setAuthor("저자");

        Book book1 = bookRepository.save(book);

        assertThat("제목").isEqualTo(book1.getTitle());
    }


}
