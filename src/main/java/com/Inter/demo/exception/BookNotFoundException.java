package com.Inter.demo.exception;

public class BookNotFoundException extends RuntimeException {



    public BookNotFoundException() {

    }

    @Override
    public String getMessage() {
        return "Books not found";
    }
}
