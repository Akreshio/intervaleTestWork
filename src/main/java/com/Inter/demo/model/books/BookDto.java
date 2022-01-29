package com.Inter.demo.model.books;

import com.Inter.demo.controller.deserializer.BookDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@Data
@JsonDeserialize(using = BookDeserializer.class)
public class BookDto implements Book {

    @NotNull(message = "not be null")
    @Min(value = 0, message = "not be 0")
    private final int page;

    @NotNull(message = "not be null")
    @Min(value = 0, message = "not be 0")
    private final int price;

    @Min(value = 0, message = "not be 0")
    private final double weight;

    @Size(min = 9, max = 12, message = "ISBN not corection")
    private final String isbn;

    @NotEmpty(message = "not be empty")
    private final String writer;

    @NotEmpty(message = "not be empty")
    private final String name;


    public BookDto() {
        this.page = 0;
        this.price = 0;
        this.weight = 0.0;
        this.isbn = "";
        this.writer = "";
        this.name = "";
    }


    public BookDto(String isbn, String name, String writer, int page, int price, double weight) {
        this.isbn = isbn;
        this.name = name;
        this.writer = writer;
        this.page = page;
        this.price = price;
        this.weight = weight;
    }
    public BookDto(String isbn) {
        this.page = 0;
        this.price = 0;
        this.weight = 0.0;
        this.isbn = isbn;
        this.writer = "";
        this.name = "";
    }
    public BookDto(BookDao book) {
        this.page = book.getPage();
        this.price = book.getPrice();
        this.weight = book.getWeight();
        this.isbn = book.getIsbn();
        this.writer = book.getWriter();
        this.name = book.getName();
    }



}
