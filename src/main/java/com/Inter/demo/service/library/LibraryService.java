package com.Inter.demo.service.library;

import com.Inter.demo.database.books.BooksDao;
import com.Inter.demo.model.books.BookDao;
import com.Inter.demo.model.books.BookDto;
import com.Inter.demo.model.library.LibraryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    @Autowired
    BooksDao booksDao;

    @Autowired
    RestTemplate restTemplate;


    public List<BookDto> get(String authorName) {
        BookDto book = new BookDto();
        book.setWriter(authorName);
        List<BookDto> dtoList;

        dtoList = booksListToDTO(booksDao.get(bookToDAO(book)));

        String URI_AUTHOR = "http://openlibrary.org/search.json?author=";
        LibraryList libraryList = restTemplate.getForEntity(URI_AUTHOR + authorName, LibraryList.class).getBody();

        assert libraryList != null;
        dtoList.addAll(libraryList.getBookDTO());

        return dtoList;
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

