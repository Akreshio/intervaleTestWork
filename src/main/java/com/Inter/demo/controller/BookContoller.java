package com.Inter.demo.controller;

import com.Inter.demo.model.books.BookDto;
import com.Inter.demo.service.book.BooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.print.Book;
import java.util.List;


@RestController
@RequestMapping("/book")
@Validated
public class BookContoller {


    @Autowired
    BooksService books;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> get(@RequestParam (value = "isbn", required = false) String isbn) {
         //   log.info("Получение списка книг");
            if (isbn!=null) {
                return books.get(new BookDto(isbn));
            }
        return  books.get();
    }
    @PutMapping
    public ResponseEntity<Void> add(@Valid @RequestBody BookDto newBook, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
       // log.info("Добавление книги " + newBook);
        books.add(newBook);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
/*
    @PostMapping
    public ResponseEntity<String> update(@Valid @RequestBody Book book) {
        bookMap.remove(book.getIsbn());
        bookMap.put(book);
        return new ResponseEntity<String>(book.getIsbn(), HttpStatus.OK);
    }
 */
    @DeleteMapping
    public ResponseEntity<Void> delete(@Valid @RequestBody BookDto newBook, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        // log.info("Удаление книги " + newBook);
        books.remove(newBook);
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }



}

