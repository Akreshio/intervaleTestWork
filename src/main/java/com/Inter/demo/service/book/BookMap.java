package com.Inter.demo.service.book;

import com.Inter.demo.database.books.BookDaoImpl;
import com.Inter.demo.database.books.BooksDao;
import com.Inter.demo.exception.BookNotFoundException;
import com.Inter.demo.model.books.Book;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Getter
@Service
public class BookMap {
    BooksDao booksDao;

    int mapIterator = 0;
    HashMap<Long, Book> bookMap = new HashMap<>();

    @Autowired
    public BookMap(BooksDao booksDao) {
        this.booksDao = booksDao;
       // bookMap.put(booksDao.get().get().getId(),booksDao.get().get());
        bookMap =booksDao.get().get();
        System.out.println(bookMap.toString());

    }

    public boolean  isId(String id){
        bookMap.containsKey(id);
        return  bookMap.containsKey(id);
    }

    public Book getForId(String id){
        return bookMap.get(id);
    }

    public void put(Book book){
        bookMap.put(book.getId(), book);
    }

    public void remove(String id){
        bookMap.remove(id);
    }

    @Override
    public String toString() {

            return "bookMap=" + bookMap.toString();
    }
}
