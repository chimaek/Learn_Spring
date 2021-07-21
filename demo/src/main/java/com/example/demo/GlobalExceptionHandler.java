package com.example.demo;

import com.example.demo.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public UserDto<String> error(IllegalArgumentException e) {
        return new UserDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }
}
