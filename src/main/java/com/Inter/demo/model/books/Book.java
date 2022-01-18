package com.Inter.demo.model.books;

import com.Inter.demo.controller.deserializer.BookDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@JsonDeserialize(using = BookDeserializer.class)
public class Book {

    @NotNull (message = "not be null")
    @Min( value = 0, message = "not be 0")
    int  page;
    @NotNull (message = "not be null")
    @Min( value = 0, message = "not be 0")
    int price;
    @NotNull
    double weight;
    @Size (min = 9, max = 12, message = "ISBN not corection")
    String isbn;
    @NotEmpty (message = "not be empty")
    String name, writer;

    public Book(String isbn, String name,String writer, int page, int price, double weight) {
        this.page = page;
        this.price = price;
        this.weight = weight;
        this.isbn = isbn;
        this.name = name;
        this.writer = writer;
    }


    @Override
    public String toString() {
        return "isbn=" + isbn + ", name=" + name + ", writer=" + writer +
                " page=" + page + ", price=" + price + ", weight=" + weight + '\n';
    }
}

