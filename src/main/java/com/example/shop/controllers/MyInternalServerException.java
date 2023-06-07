package com.example.shop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class MyInternalServerException extends RuntimeException {
    public MyInternalServerException() {
    }

    public MyInternalServerException(String message) {
        super(message);
    }
}
