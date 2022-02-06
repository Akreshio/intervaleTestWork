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


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BooksServiceTest {

    @InjectMocks
    BooksService booksService;

    @Mock
    BooksDao mokdao;

    @Test
    void get() {
    }

    @Test
    void testGet() {
        BookDto bookDto = new BookDto("154-1874-158");
        BookDto bookDtoFull = new BookDto("154-1874-158","book","bee",158,3008,158.01);
        BookDao bookDao = new BookDao(bookDto);
        BookDao bookDaoFull = new BookDao(bookDtoFull);

        List<BookDao> daoList = new ArrayList<>();
        daoList.add(bookDaoFull);

        List<BookDto> dtoList = new ArrayList<>();
        dtoList.add(bookDtoFull);

        Mockito.doReturn(daoList).when(mokdao).get(Mockito.any(BookDao.class));

        Assert.assertEquals(booksService.get(bookDto), dtoList);

        Mockito.verify(mokdao).get(Mockito.any(BookDao.class));
    }

    @Test
    void add() {
        BookDto bookDto = new BookDto("154-1874-158","book","bee",158,3008,158.01);

        Mockito.doReturn(true).when(mokdao).add(Mockito.any(BookDao.class));

        boolean isBookAdd = booksService.add(bookDto);

        Assert.assertTrue(isBookAdd);
    }

    @Test
    void remove() {
        BookDto bookDto = new BookDto("154-1874-158","book","bee",158,3008,158.01);
        BookDao bookDao = new BookDao(bookDto);

        Mockito.when(mokdao.delete( Mockito.any(BookDao.class))).thenReturn(true);


        boolean isBookAdd = booksService.remove(bookDto);
        Assert.assertTrue(isBookAdd);

    }

    @Ignore
    @Test
    void update() {
        //not relizet
    }
}