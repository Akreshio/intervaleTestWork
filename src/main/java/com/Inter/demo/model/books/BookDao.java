package com.Inter.demo.model.books;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
public class BookDao implements Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "page", nullable = false)
    int  page;


    @Column(name = "price", nullable = false)
    int price;

    @Column(name = "weight", nullable = false)
    double weight;

    @Column(name = "isbn", nullable = false)
    String isbn;

    @Column(name = "writer", nullable = false)
    String writer;

    @Column(name = "name", nullable = false)
    String name;

    public BookDao() {}

    public BookDao(Long id, String isbn, String name, String writer, int page, int price, double weight) {
        this.id = id;
        this.page = page;
        this.price = price;
        this.weight = weight;
        this.isbn = isbn;
        this.writer = writer;
        this.name = name;
    }

    public BookDao(BookDto book) {
        this.page = book.getPage();
        this.price = book.getPrice();
        this.weight = book.getWeight();
        this.isbn = book.getIsbn();
        this.writer = book.getWriter();
        this.name = book.getName();
    }

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

