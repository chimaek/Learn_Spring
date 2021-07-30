package com.example.demo.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BookForm {

    private Long id;
    @NotEmpty(message = "책이름은 필수 입니다.")
    private String name;
    @NotEmpty(message = "가격을 입력하세요.")
    private int price;
    @NotEmpty(message = "재고 수량을 입력하세요")
    private int stockQuantity;
    @NotEmpty(message = "저자를 입력하세요.")
    private String author;

    private String isbn;
}
