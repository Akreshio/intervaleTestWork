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
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "isbn=" + isbn + ", name=" + name + ", writer=" + writer +
                " page=" + page + ", price=" + price + ", weight=" + weight + '\n';
    }


}

