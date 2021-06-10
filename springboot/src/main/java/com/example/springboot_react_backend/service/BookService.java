package com.example.springboot_react_backend.service;

import com.example.springboot_react_backend.domain.Book;
import com.example.springboot_react_backend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;

    @Transactional()
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional(readOnly = true)
    public Book getOneBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id를 확인해주세요"));
    }

    @Transactional(readOnly = true)
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book ModifyBook(Long id, Book book) {
        //더티체킹
        Book bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("id를 확인해주세요!")); //영속화
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        return bookEntity;

    }

    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "ok";
    }
}
