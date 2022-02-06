package com.Inter.demo.model.library;

import com.Inter.demo.model.books.BookDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class LibraryList {
    private List<Library> docs;
    private int num_found;

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
