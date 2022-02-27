package com.Inter.demo.service.book;


import com.Inter.demo.database.books.BooksDao;
import com.Inter.demo.model.books.BookDao;
import com.Inter.demo.model.books.BookDto;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Books service test.
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BooksServiceTest {

    /**
     * The Books service.
     */
    @InjectMocks
    BooksService booksService;

    /**
     * The Mokdao.
     */
    @Mock
    BooksDao mokdao;

    /**
     * Get.
     */
    @Test
    void get() {
    }

    /**
     * Test get.
     */
    @Test
    void testGet() {
        BookDto bookDto = new BookDto();
        bookDto.setIsbn("154-1874-158");

        BookDto bookDtoFull = new BookDto();
        bookDtoFull.setIsbn("154-1874-158");
        bookDtoFull.setName("book");
        bookDtoFull.setWriter("bee");
        bookDtoFull.setWeight(158.01);
        bookDtoFull.setPrice(3008);
        bookDtoFull.setPage(158);

        BookDao bookDao = new BookDao();
        bookDao.setIsbn("154-1874-158");

        BookDao bookDaoFull = new BookDao();
        bookDaoFull.setIsbn("154-1874-158");
        bookDaoFull.setName("book");
        bookDaoFull.setWriter("bee");
        bookDaoFull.setWeight(158.01);
        bookDaoFull.setPrice(3008);
        bookDaoFull.setPage(158);

        List<BookDao> daoList = new ArrayList<>();
        daoList.add(bookDaoFull);

        List<BookDto> dtoList = new ArrayList<>();
        dtoList.add(bookDtoFull);

        Mockito.doReturn(daoList).when(mokdao).get(Mockito.any(BookDao.class));

        Assert.assertEquals(booksService.get(bookDto), dtoList);

        Mockito.verify(mokdao).get(Mockito.any(BookDao.class));
    }

    /**
     * Add.
     */
    @Test
    void add() {
        BookDto bookDto = new BookDto();
        bookDto.setIsbn("154-1874-158");
        bookDto.setName("book");
        bookDto.setWriter("bee");
        bookDto.setWeight(158.01);
        bookDto.setPrice(3008);
        bookDto.setPage(158);

        Mockito.doReturn(true).when(mokdao).add(Mockito.any(BookDao.class));
        boolean isBookAdd = booksService.add(bookDto);
        Assert.assertTrue(isBookAdd);
    }

    /**
     * Remove.
     */
    @Test
    void remove() {
        BookDto bookDto = new BookDto();
        bookDto.setIsbn("154-1874-158");
        bookDto.setName("book");
        bookDto.setWriter("bee");
        bookDto.setWeight(158.01);
        bookDto.setPrice(3008);
        bookDto.setPage(158);

        Mockito.when(mokdao.delete( Mockito.any(BookDao.class))).thenReturn(true);

        boolean isBookAdd = booksService.remove(bookDto);
        Assert.assertTrue(isBookAdd);
    }

    /**
     * Update.
     */
    @Ignore
    @Test
    void update() {
        //not relizet
    }

}