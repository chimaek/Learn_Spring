package com.example.demo.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class helloDtoTest {

    @Test
    public void 롬복테스트(){
        helloDto helloDto = new helloDto("me",1000);


        assertThat(helloDto.getName()).isEqualTo("me");
        assertThat(helloDto.getAmount()).isEqualTo(1000);
    }

}