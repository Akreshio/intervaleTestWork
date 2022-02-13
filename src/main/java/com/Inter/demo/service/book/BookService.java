/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 15:39"
 * @version V 1.0.0
 */

package com.Inter.demo.service.book;

import com.Inter.demo.model.books.BookDto;

import java.util.List;

/**
 * The interface Book service.
 */
public interface BookService {

    /**
     * Loading the all books list (Загрузка списка всех книг)
     *
     * @return the list of Book
     */
    List<BookDto> get ();

    /**
     * Loading the books list by benchmark book (Загрузка списка книг по эталонной книге)
     *
     * @param book the benchmark book (Эталонная книга)
     * @return the list of Book
     */
    List<BookDto> get (BookDto book);

    /**
     * Add the book (Добавить книгу).
     *
     * @param book the book for add
     * @return the execution result (boolean)
     */
    boolean add (BookDto book);

    /**
     * Remove the book(s) (Удалить книгу(и)).
     *
     * @param book the book for remove
     * @return the execution result (boolean)
     */
    boolean remove (BookDto book);

    /**
     * Update the book(s) (Обновить книгу(и)).
     *
     * @param oldBook the book for remove
     * @param newBook the book for add
     * @return the execution result (boolean)
     */
    boolean update (BookDto oldBook, BookDto newBook);

}
