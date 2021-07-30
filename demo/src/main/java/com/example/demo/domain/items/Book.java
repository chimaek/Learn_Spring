package com.example.demo.domain.items;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "Book")
public class Book extends Item {

    private String author;

    private String isbn;


    public static Book createBook(String name, String author, String isbn, int price, int quantity) {
        Book book = new Book();
        book.setName(name);
        book.setIsbn(isbn);
        book.setPrice(price);
        book.setAuthor(author);
        book.setStockQuantity(quantity);
        return book;
    }
}
