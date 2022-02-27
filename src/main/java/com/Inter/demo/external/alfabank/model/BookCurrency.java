/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "20.02.2022, 19:53"
 * @version V 1.0.0
 */

package com.Inter.demo.external.alfabank.model;

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

    @Override
    public String toString() {
        return "isbn=" + isbn + ", name=" + name + ", writer=" + writer +
                " page=" + page + ", price=" + price + ", weight=" + weight + '\n';
    }
}

