/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 16:44"
 * @version V 1.0.0
 */

package com.Inter.demo.controller;

import com.Inter.demo.model.books.BookDto;
import com.Inter.demo.service.book.BooksService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type Book contoller.
 */
@Slf4j
@RestController
@RequestMapping("/book")
@Validated
public class BookContoller {


    /**
     * The Books.
     */
    @Autowired
    BooksService books;

    /**
     * Getting the books list by request (Получение списка книг по запросу)
     *
     * @param isbn the string has formatted isbn
     * @return the list of Book
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> get(@RequestParam (value = "isbn", required = false) String isbn) {
            log.info("Получение списка книг");
            if (isbn!=null) {
                return books.get(new BookDto(isbn));
            }
        return  books.get();
    }

    /**
     * Add the book by request (Добавление книги по запросу)
     *
     * @param newBook       the new book
     * @param bindingResult the binding result
     * @return the response entity
     */
    @PutMapping
    public ResponseEntity<Void> add(@Valid @RequestBody BookDto newBook, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        log.info("Добавление книги " + newBook);
        books.add(newBook);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    /**
     * Update the book by request (Обновление книги по запросу)
     *
     * @param dtoList the dto list
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<Void> update(@RequestBody List<BookDto> dtoList) {
        if (dtoList.size()==2){
            books.update(dtoList.get(0),dtoList.get(1));
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }

    /**
     * Delete the book by request (Удаление книги по запросу)
     *
     * @param newBook the new book
     * @return the response entity
     */
    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody BookDto newBook) {
        log.info("Удаление книги " + newBook);
        books.remove(newBook);
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }



}

