/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "27.02.2022, 16:01"
 * @version V 1.0.0
 */

package com.Inter.demo.external.openlibrary.model;

import com.Inter.demo.model.books.BookDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Mapper book open library.
 */
@Component
@NoArgsConstructor
public class MapperBookOpenLibrary {

    /**
     * openLibrary book to dto book (Конвертация книги из openLibrary в DTO)
     *
     * @param library the library
     * @return the book dto
     *
     * @see BookDto
     * @see Library
     */
    public BookDto olToDto (Library library){
        BookDto book= new BookDto();
        book.setName(library.getTitle());
        book.setPage(library.getNumber_of_pages_median());
        book.setIsbn(library.getISBN());
        book.setWriter(library.getAuthor_name());
        return book;
    }

    /**
     * openLibrary  list to list dto (Конвертация книги из openLibrary в DTO)
     *
     * @param library the library
     * @return the book dto
     *
     * @see BookDto
     * @see Library
     */
    public List<BookDto> listOlToDto (List<Library> library){
        List<BookDto> books = new ArrayList<>();
        for (Library book : library) {
            books.add(olToDto(book));
        }
        return books;
    }
}
