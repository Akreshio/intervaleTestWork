package com.Inter.demo.controller;

import com.Inter.demo.model.books.BookDto;

import com.Inter.demo.service.library.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/library")
public class LibraryController {


    @Autowired
    LibraryService libraryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> get(@RequestParam(value = "AuthorName", required = false) String authorName) {
        //   log.info("Получение списка книг");
        if (authorName!=null) {

            return libraryService.get(authorName);
        }
        return  null;
    }

}





