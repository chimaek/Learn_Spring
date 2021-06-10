package com.example.springboot_react_backend.repository;

import com.example.springboot_react_backend.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
