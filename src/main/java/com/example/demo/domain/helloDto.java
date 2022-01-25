package com.example.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class helloDto {

    private final String name;
    private final int amount;
}
