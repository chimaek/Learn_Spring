package com.example.springboot_react_backend.service;

import com.example.springboot_react_backend.domain.Book;
import com.example.springboot_react_backend.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // 서비스는 레포에 의존적인데 단위테스트를 위해 이 어노테이션을 붙인다.
public class BookServiceUnitTest {

    @InjectMocks //해당 어노테이션은 만들어질때 @mock으로 선언된 모든 애들을 주입받는다.
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void 저장하기_테스트(){

        Book book = new Book();

        book.setTitle("얍!");
        book.setAuthor("허허");

        when(bookRepository.save(book)).thenReturn(book);

        Book bookEntity = bookService.saveBook(book);

        assertThat(bookEntity).isEqualTo(book);
    }
}
