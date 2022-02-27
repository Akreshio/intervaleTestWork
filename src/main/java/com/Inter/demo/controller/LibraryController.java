package com.Inter.demo.controller;

import com.Inter.demo.model.books.BookDto;
import com.Inter.demo.external.openlibrary.LibraryService;

import com.Inter.demo.service.book.BooksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Library controller.
 */
@Slf4j
@RestController
@RequestMapping("/library")
public class LibraryController {

    /**
     * The Library service.
     */
    @Autowired
    LibraryService libraryService;
    @Autowired
    BooksService books;

    /**
     * Get list.
     *
     * @param authorName the author name
     * @return the list of book
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> get(@RequestParam(value = "AuthorName") String authorName) {
        log.info("get book list from openlibrary with author name: " + authorName);

        List<BookDto> result = new ArrayList<>();
        BookDto book = new BookDto();
        book.setWriter(authorName);

        result.addAll(libraryService.get(authorName));
        result.addAll(books.get(book));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}





