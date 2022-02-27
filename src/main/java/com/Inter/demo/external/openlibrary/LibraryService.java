/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 17:02"
 * @version V 1.0.0
 */

package com.Inter.demo.external.openlibrary;

import com.Inter.demo.external.openlibrary.model.MapperBookOpenLibrary;
import com.Inter.demo.model.books.BookDto;
import com.Inter.demo.external.openlibrary.model.LibraryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * The type Library service.
 */
@Service
public class LibraryService {

    /**
     * The mapper book
     */
    @Autowired
    MapperBookOpenLibrary mapperBook;

    /**
     * The RestTemplate with base url "openLibrary" (RestTemplate с базовым URL "openLibrary")
     */
    @Autowired
    @Qualifier("openLibrary")
    RestTemplate restTemplate;

    /**
     * Getting the book list from openLibrary (Получение списка книг из openLibrary)
     *
     * @param authorName the author name
     * @return the list of BookDto
     *
     * @see BookDto
     */
    public List<BookDto> get(String authorName) {
        LibraryList libraryList;
        String URI_AUTHOR = "search.json?author=";

        libraryList = restTemplate.getForEntity(URI_AUTHOR + authorName, LibraryList.class).getBody();

        if (libraryList != null) {
            return mapperBook.listOlToDto(libraryList.getDocs());
        }
        return null;
    }
}

