/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 17:48"
 * @version V 1.0.0
 */

package com.Inter.demo.model.books;

import lombok.*;

import javax.persistence.*;

/**
 * The type Book dao.
 */
@Entity
@Table(name = "books")
@Getter
@Setter
public class BookDao implements Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * The Page.
     */
    @Column(name = "page", nullable = false)
    int  page;


    /**
     * The Price.
     */
    @Column(name = "price", nullable = false)
    int price;

    /**
     * The Weight.
     */
    @Column(name = "weight", nullable = false)
    double weight;

    /**
     * The Isbn.
     */
    @Column(name = "isbn", nullable = false)
    String isbn;

    /**
     * The Writer.
     */
    @Column(name = "writer", nullable = false)
    String writer;

    /**
     * The Name.
     */
    @Column(name = "name", nullable = false)
    String name;

    /**
     * Instantiates a new Book dao.
     */
    public BookDao() {}

    /**
     * Instantiates a new Book dao.
     *
     * @param id     the id
     * @param isbn   the isbn
     * @param name   the name
     * @param writer the writer
     * @param page   the page
     * @param price  the price
     * @param weight the weight
     */
    public BookDao(Long id, String isbn, String name, String writer, int page, int price, double weight) {
        this.id = id;
        this.page = page;
        this.price = price;
        this.weight = weight;
        this.isbn = isbn;
        this.writer = writer;
        this.name = name;
    }

    /**
     * Instantiates a new Book dao.
     *
     * @param book the book
     */
    public BookDao(BookDto book) {
        this.page = book.getPage();
        this.price = book.getPrice();
        this.weight = book.getWeight();
        this.isbn = book.getIsbn();
        this.writer = book.getWriter();
        this.name = book.getName();
    }

    /**
     * Instantiates a new Book dao.
     *
     * @param id     the id
     * @param page   the page
     * @param price  the price
     * @param weight the weight
     * @param isbn   the isbn
     * @param writer the writer
     * @param name   the name
     */
    public BookDao(long id, int page, int price, double weight, String isbn, String writer, String name) {
        this.id = id;
        this.page = page;
        this.price = price;
        this.weight = weight;
        this.isbn = isbn;
        this.writer = writer;
        this.name = name;
    }

    @Override
    public String toString() {
        return "isbn=" + isbn + ", name=" + name + ", writer=" + writer +
                " page=" + page + ", price=" + price + ", weight=" + weight + '\n';
    }


}

