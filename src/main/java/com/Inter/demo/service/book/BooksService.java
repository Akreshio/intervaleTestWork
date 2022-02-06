package com.Inter.demo.service.book;

import com.Inter.demo.database.books.BooksDao;
import com.Inter.demo.model.books.BookDao;
import com.Inter.demo.model.books.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService implements BookService {

    @Autowired
    BooksDao booksDao;

    @Override
    public List<BookDto> get() {
        return booksListToDTO(booksDao.get());
    }

    @Override
    public List<BookDto> get(BookDto book) {
        return booksListToDTO(booksDao.get(bookToDAO(book)));
    }

    @Override
    public boolean add(BookDto book) {
        return booksDao.add(bookToDAO(book));
    }

    @Override
    public boolean remove(BookDto book) {
        return booksDao.delete(bookToDAO(book));
    }

    @Override
    public boolean update(BookDto oldBook, BookDto newBook) {
        return booksDao.update(bookToDAO(oldBook),bookToDAO(newBook));
    }


    private List<BookDto> booksListToDTO(List<BookDao> booksListDao){
        List<BookDto> booksList = new ArrayList<>();
        for (BookDao book:booksListDao) {
            booksList.add(new BookDto(book));
        }
        return booksList;
    }
    private BookDao bookToDAO(BookDto book){
        return new BookDao(book);
    }
}
