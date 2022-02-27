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

@Component
@NoArgsConstructor
public class MapperBookDtoDao {

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

    public List<BookDto> listDaoToDto (List<BookDao> booksDao){
        List<BookDto> books = new ArrayList<>();
        for (BookDao book:booksDao) {
            books.add(daoToDto(book));
        }
        return books;
    }

    public List<BookDao> listDtoToDao (List<BookDto> booksDto){
        List<BookDao> books = new ArrayList<>();
        for (BookDto book:booksDto) {
            books.add(dtoToDao(book));
        }
        return books;
    }

}
