/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "20.02.2022, 19:53"
 * @version V 1.0.0
 */

package com.Inter.demo.external.alfabank.model;

import com.Inter.demo.model.books.BookDao;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

/**
 * The type Book currency.
 */
@Data
@NoArgsConstructor
public class BookCurrency {

    private int page;

    private Map <String, BigDecimal> price;

    private double weight;

    private String isbn;

    private String writer;

    private String name;

    /**
     * Instantiates a new Book currency.
     *
     * @param book  the book
     * @param price the price
     */
    public BookCurrency(BookDao book, Map<String, BigDecimal> price) {
        this.isbn = book.getIsbn();
        this.name = book.getName();
        this.writer = book.getWriter();
        this.page = book.getPage();
        this.price = price;
        this.weight = book.getWeight();
    }

    @Override
    public String toString() {
        return "isbn=" + isbn + ", name=" + name + ", writer=" + writer +
                " page=" + page + ", price=" + price + ", weight=" + weight + '\n';
    }
}

