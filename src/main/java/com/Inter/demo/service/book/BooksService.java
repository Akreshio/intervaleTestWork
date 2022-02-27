/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 15:40"
 * @version V 1.0.0
 */

package com.Inter.demo.service.book;

import com.Inter.demo.database.books.BooksDao;
import com.Inter.demo.model.books.BookDto;
import com.Inter.demo.model.books.MapperBookDtoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * The type Books service.
 */
@Service
public class BooksService implements BookService {

    /**
     * The Books dao.
     */
    @Autowired
    BooksDao booksDao;
    @Autowired
    MapperBookDtoDao mapperBook;

    @Override
    public List<BookDto> get() {
        return mapperBook.listDaoToDto(
                booksDao.get()
        );
    }

    @Override
    public List<BookDto> get(BookDto book) {
        return mapperBook.listDaoToDto(
                booksDao.get(
                        mapperBook.dtoToDao(book)
                )
        );
    }

    @Override
    public boolean add(BookDto book) {
        return booksDao.add(
                mapperBook.dtoToDao(book)
        );
    }

    @Override
    public boolean remove(BookDto book) {
        return booksDao.delete(
                mapperBook.dtoToDao(book)
        );
    }

    @Override
    public boolean update(BookDto oldBook, BookDto newBook) {
        return booksDao.update(
                mapperBook.dtoToDao(oldBook),
                mapperBook.dtoToDao(newBook)
        );
    }
}
