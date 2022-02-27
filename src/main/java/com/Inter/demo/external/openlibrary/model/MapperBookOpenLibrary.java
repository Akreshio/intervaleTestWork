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

@Component
@NoArgsConstructor
public class MapperBookOpenLibrary {

    public BookDto olToDto (Library library){
        BookDto book= new BookDto();
        book.setName(library.getTitle());
        book.setPage(library.getNumber_of_pages_median());
        book.setIsbn(library.getISBN());
        book.setWriter(library.getAuthor_name());
        return book;
    }

    public List<BookDto> listOlToDto (List<Library> library){
        List<BookDto> books = new ArrayList<>();
        for (Library book : library) {
            books.add(olToDto(book));
        }
        return books;
    }
}
