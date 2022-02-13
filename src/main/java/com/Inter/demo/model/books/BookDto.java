/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 17:47"
 * @version V 1.0.0
 */

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


/**
 * The type Book dto.
 */
@Getter
@Setter
@Data
@JsonDeserialize(using = BookDeserializer.class)
public class BookDto implements Book {

    @NotNull(message = "not be null")
    @Min(value = 0, message = "not be 0")
    private int page;

    @NotNull(message = "not be null")
    @Min(value = 0, message = "not be 0")
    private int price;

    @Min(value = 0, message = "not be 0")
    private double weight;

    @Size(min = 9, max = 12, message = "ISBN not corection")
    private String isbn;

    @NotEmpty(message = "not be empty")
    private String writer;

    @NotEmpty(message = "not be empty")
    private String name;


    /**
     * Instantiates a new Book dto.
     */
    public BookDto() {
        this.page = 0;
        this.price = 0;
        this.weight = 0.0;
        this.isbn = "";
        this.writer = "";
        this.name = "";
    }


    /**
     * Instantiates a new Book dto.
     *
     * @param isbn   the isbn
     * @param name   the name
     * @param writer the writer
     * @param page   the page
     * @param price  the price
     * @param weight the weight
     */
    public BookDto(String isbn, String name, String writer, int page, int price, double weight) {
        this.isbn = isbn;
        this.name = name;
        this.writer = writer;
        this.page = page;
        this.price = price;
        this.weight = weight;
    }

    /**
     * Instantiates a new Book dto.
     *
     * @param isbn the isbn
     */
    public BookDto(String isbn) {
        this.page = 0;
        this.price = 0;
        this.weight = 0.0;
        this.isbn = isbn;
        this.writer = "";
        this.name = "";
    }

    /**
     * Instantiates a new Book dto.
     *
     * @param book the book
     */
    public BookDto(BookDao book) {
        this.page = book.getPage();
        this.price = book.getPrice();
        this.weight = book.getWeight();
        this.isbn = book.getIsbn();
        this.writer = book.getWriter();
        this.name = book.getName();
    }

    @Override
    public String toString() {
        return "isbn=" + isbn + ", name=" + name + ", writer=" + writer +
                " page=" + page + ", price=" + price + ", weight=" + weight + '\n';
    }
}
