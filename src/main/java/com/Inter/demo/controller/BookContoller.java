package com.Inter.demo.controller;

import com.Inter.demo.model.books.Book;
import com.Inter.demo.model.books.BookMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;


@RestController
@RequestMapping("/book")
@Validated
public class BookContoller {

    private static final Logger log = Logger.getLogger(BookContoller.class);

    BookMap bookMap = new BookMap();
    {
        bookMap.put( new Book("nsqw","book1","not me", 10, 158, 15));
        bookMap.put( new Book("nsqq","book2","not me", 15, 1558, 115));
        bookMap.put( new Book("nsqe","book3","not me", 19, 158789, 135));
    }



    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  BookMap get(@RequestParam (value = "id", required = false) String id) {
            log.info("Получение списка книг");
            if (bookMap.isId(id) && id!=null) {
                BookMap bookMapOne = new BookMap();
                bookMapOne.put(bookMap.getForId(id));
                log.info("по id = " + id);
                return bookMapOne;
            }
        return  bookMap;
    }

    @PutMapping
    public ResponseEntity<Void> add(@Valid @RequestBody Book newBook, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        System.out.println(newBook + " | " + bindingResult.hasErrors());
        log.info("Добавление книги " + newBook);
        bookMap.put(newBook);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<String> update(@Valid @RequestBody Book book) {
        bookMap.remove(book.getIsbn());
        bookMap.put(book);
        return new ResponseEntity<String>(book.getIsbn(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody String id) {
        if (bookMap.isId(id)) { bookMap.remove(id);
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
}

