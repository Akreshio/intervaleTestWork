/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "27.02.2022, 15:16"
 * @version V 1.0.0
 */

package com.Inter.demo.model.books;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Mapper book dto dao.
 */
@Component
@NoArgsConstructor
public class MapperBookDtoDao {

    /**
     * Book dto to book dao (Конвертация книги из DTO в DAO)
     *
     * @param book the bookDto
     * @return the bookDao
     *
     * @see BookDao
     * @see BookDto
     */
    public BookDao dtoToDao (BookDto book){
        BookDao bookDao = new BookDao();
        bookDao.setPage(book.getPage());
        bookDao.setPrice(book.getPrice());
        bookDao.setWeight(book.getWeight());
        bookDao.setIsbn(book.getIsbn());
        bookDao.setWriter(book.getWriter());
        bookDao.setName(book.getName());
        return bookDao;
    }

    /**
     * Book dao to book dto (Конвертация книги из DAO в DTO)
     *
     * @param book the bookDao
     * @return the bookDto
     *
     * @see BookDao
     * @see BookDto
     */
    public BookDto daoToDto (BookDao book){
        BookDto bookDto = new BookDto();
        bookDto.setPage(book.getPage());
        bookDto.setPrice(book.getPrice());
        bookDto.setWeight(book.getWeight());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setWriter(book.getWriter());
        bookDto.setName(book.getName());
        return bookDto;
    }

    /**
     * List dao to dto list (Конвертация листа книг из DAO в DTO)
     *
     * @param booksDao  list of books dao
     * @return the list of books dto
     *
     * @see BookDao
     * @see BookDto
     */
    public List<BookDto> listDaoToDto (List<BookDao> booksDao){
        List<BookDto> books = new ArrayList<>();
        for (BookDao book:booksDao) {
            books.add(daoToDto(book));
        }
        return books;
    }

    /**
     * List dto to dao list (Конвертация листа книг из DTO в DAO)
     *
     * @param booksDto  list of books dto
     * @return the list of books dao
     *
     * @see BookDao
     * @see BookDto
     */
    public List<BookDao> listDtoToDao (List<BookDto> booksDto){
        List<BookDao> books = new ArrayList<>();
        for (BookDto book:booksDto) {
            books.add(dtoToDao(book));
        }
        return books;
    }

}
