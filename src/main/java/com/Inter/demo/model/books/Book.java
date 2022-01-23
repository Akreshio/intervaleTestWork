package com.Inter.demo.model.books;

import com.Inter.demo.controller.deserializer.BookDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
@JsonDeserialize(using = BookDeserializer.class)
@Entity
@Table(name = "Books")
public class Book {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull (message = "not be null")
    @Min( value = 0, message = "not be 0")
    @Column(name = "page", nullable = false)
    int  page;

    @NotNull (message = "not be null")
    @Min( value = 0, message = "not be 0")
    @Column(name = "price", nullable = false)
    int price;

    @NotNull
    @Column(name = "weight", nullable = false)
    double weight;

    @Size (min = 9, max = 12, message = "ISBN not corection")
    @Column(name = "isbn", nullable = false)
    String isbn;

    @Column(name = "writer", nullable = false)
    @NotEmpty (message = "not be empty")
    String writer;

    @Column(name = "name", nullable = false)
    @NotEmpty (message = "not be empty")
    String name;

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

