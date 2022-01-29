package com.Inter.demo.service.book;

import com.Inter.demo.model.books.BookDao;
import com.Inter.demo.model.books.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> get ();
    List<BookDto> get (BookDto book);

    boolean add (BookDto book);
    boolean remove (BookDto book);
    boolean update (BookDto oldBook, BookDto newBook);

}
