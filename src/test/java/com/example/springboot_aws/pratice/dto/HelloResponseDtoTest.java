package com.example.springboot_aws.pratice.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {

    @Test
    public void 롬복테스트(){
        HelloResponseDto 김승주 = new HelloResponseDto("김승주", 1000);


        assertThat(김승주.getName()).isEqualTo("김승주");
        assertThat(김승주.getAmount()).isEqualTo(1000);
    }

}