package com.Inter.demo.controller;

import com.Inter.demo.model.books.Book;
import com.Inter.demo.service.book.BookMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
@RequestMapping("/book")
@Validated
public class BookContoller {




    BookMap bookMap;

    @Autowired
    public BookContoller(BookMap bookMap) {
        this.bookMap = bookMap;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public  String get(@RequestParam (value = "id", required = false) String id) {
         //   log.info("Получение списка книг");
           /* if (bookMap.isId(id) && id!=null) {
                BookMap bookMapOne = new BookMap();
                bookMapOne.put(bookMap.getForId(id));
              //  log.info("по id = " + id);
                return bookMapOne;
            }

            */
        return  bookMap.toString();
    }

    @PutMapping
    public ResponseEntity<Void> add(@Valid @RequestBody Book newBook, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        System.out.println(newBook + " | " + bindingResult.hasErrors());
       // log.info("Добавление книги " + newBook);
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

