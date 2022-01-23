package com.Inter.demo.database.books;

import com.Inter.demo.model.books.Book;

import java.util.HashMap;
import java.util.Optional;
//import java.util.Optional;

public interface BooksDao {

    //Optional<Book> getBookById(int id);

    Optional<HashMap <Long, Book>> get();
    HashMap<String, Book> search (Book book);
    boolean add(Book book);
    boolean delete(Book book);
}
