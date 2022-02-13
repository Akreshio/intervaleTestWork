package com.Inter.demo.controller;

import com.Inter.demo.model.books.BookDto;
import com.Inter.demo.external.openlibrary.LibraryService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Get list.
     *
     * @param authorName the author name
     * @return the list of book
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> get(@RequestParam(value = "AuthorName", required = false) String authorName) {
        if (authorName!=null) {
            log.info("get book list from openlibrary with author name: " + authorName);
            return new ResponseEntity<List<BookDto>>(libraryService.get(authorName), HttpStatus.OK);
        }
        log.error("get book list from openlibrary with null author name");
        return  new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
}





