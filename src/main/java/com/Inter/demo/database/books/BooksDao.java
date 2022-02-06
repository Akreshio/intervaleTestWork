package com.Inter.demo.database.books;

import com.Inter.demo.model.books.BookDao;
import com.Inter.demo.model.books.BookDto;

import java.util.List;
//import java.util.Optional;

public interface BooksDao {

    //Optional<Book> getBookById(int id);

    List<BookDao> get();
    List<BookDao> get(BookDao bookDao);

    boolean add(BookDao bookDao);
    boolean delete(BookDao bookDao);
    boolean update(BookDao oldBook, BookDao newBook);
}
