/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 16:34"
 * @version V 1.0.0
 */

package com.Inter.demo.database.books;

import com.Inter.demo.model.books.BookDao;

import java.util.List;

/**
 * The interface Books dao.
 */
public interface BooksDao {

    /**
     * Loading the all books list from database (загрузка списка всех книг из базы данных)
     *
     * @return the list of BookDAO
     */
    List<BookDao> get();

    /**
     * Loading the books list from database by benchmark book (Загрузка списка книг из базы данных по эталонной книге)
     *
     * @param bookDao the BookDAO
     * @return the list of BookDAO
     */
    List<BookDao> get(BookDao bookDao);

    /**
     * Add the book for database (Добавить книгу в базу).
     *
     * @param bookDao the book for add
     * @return the execution result (boolean)
     */
    boolean add(BookDao bookDao);

    /**
     * Delete the book(s) from database (Удалить книгу(и) из базы).
     *
     * @param bookDao the book with params for delete
     * @return the execution result (boolean)
     */
    boolean delete(BookDao bookDao);

    /**
     * Update the book(s) in database (Обновить книгу(и) в базе).
     *
     * @param oldBook the book with params for delete
     * @param newBook the book with params for add
     * @return the execution result (boolean)
     */
    boolean update(BookDao oldBook, BookDao newBook);
}
