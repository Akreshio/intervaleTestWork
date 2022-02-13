package com.Inter.demo.service.library;

import com.Inter.demo.database.books.BooksDao;
import com.Inter.demo.external.openlibrary.LibraryService;
import com.Inter.demo.model.books.BookDao;
import com.Inter.demo.model.books.BookDto;
import com.Inter.demo.external.openlibrary.model.Library;
import com.Inter.demo.external.openlibrary.model.LibraryList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class LibraryServiceTest {
    @Mock
    BooksDao booksDao;
    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    LibraryService libraryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGet() throws MalformedURLException, URISyntaxException {
        LibraryList libraryList = new LibraryList();
        List <Library> libraries = new ArrayList<>();
        Library library = new Library();

        ArrayList<String> str = new ArrayList<>();
        str.add("name");
        str.add("isbn");

        library.setAuthor_name(str);
        library.setIsbn(str);
        library.setTitle("bookName");
        library.setNumber_of_pages_median(200);

        libraries.add(library);

        libraryList.setDocs(libraries);

        final String baseUrl = "http://openlibrary.org/search.json?author=authorName";
        URI uri = new URI(baseUrl);

        when(booksDao.get(any())).thenReturn(Arrays.<BookDao>asList(new BookDao(Long.valueOf(1), "isbn", "name", "writer", 0, 0, 0d)));

    //    when(restTemplate.getForEntity(uri, any())).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        when(restTemplate.getForEntity(uri, any()).getBody())
                .thenReturn(libraryList);

       // doReturn(libraryList).when(restTemplate.getForEntity(anyString(), eq(LibraryList.class)).getBody());

        List<BookDto> result = libraryService.get("authorName");
        Assertions.assertEquals(2, result.size());
    }
}
