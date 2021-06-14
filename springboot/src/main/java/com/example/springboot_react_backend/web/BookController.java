package com.example.springboot_react_backend.web;


import com.example.springboot_react_backend.domain.Book;
import com.example.springboot_react_backend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;


    // security (라이브러리 적용) - CORS정책을 가지고 있음.
    @CrossOrigin
    @GetMapping("/book")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.saveBook(book),HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/book/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getOneBook(id),HttpStatus.OK);
    }
    @CrossOrigin
    @PutMapping("/book/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody Book book){
        return new ResponseEntity<>(bookService.ModifyBook(id,book),HttpStatus.OK);
    }
    @CrossOrigin
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.deleteBook(id),HttpStatus.OK);
    }

}
