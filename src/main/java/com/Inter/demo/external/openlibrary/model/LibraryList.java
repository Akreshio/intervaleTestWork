/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 17:02"
 * @version V 1.0.0
 */

package com.Inter.demo.external.openlibrary.model;

import com.Inter.demo.model.books.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Library list.
 */
@Getter
@Setter
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class LibraryList {
    private List<Library> docs;
    private int num_found;

    /**
     * Gets book dto.
     *
     * @return the book dto
     */
    public List<BookDto> getBookDTO () {
        List<BookDto> booksList = new ArrayList<>();
        for (Library library:docs) {
            BookDto book = new BookDto();
            book.setName(library.getTitle());
            book.setPage(library.getNumber_of_pages_median());
            book.setIsbn(library.getISBN());
            book.setWriter(library.getAuthor_name());
            booksList.add(book);
        }
        return booksList;
    }
}
