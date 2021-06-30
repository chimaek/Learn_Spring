package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResouceNotFoundException(String message){
        super(message);
    }
}
