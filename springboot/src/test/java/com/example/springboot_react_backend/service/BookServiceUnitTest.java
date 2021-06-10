package com.example.springboot_react_backend.service;

import com.example.springboot_react_backend.repository.BookRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class) // 서비스는 레포에 의존적인데 단위테스트를 위해 이 어노테이션을 붙인다.
public class BookServiceUnitTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

}
