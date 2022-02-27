package com.Inter.demo.database.books.service;

import com.Inter.demo.model.books.BookDao;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import static org.mockito.Mockito.*;

/**
 * The type Sql create by book test.
 */
class SqlCreateByBookTest {
    /**
     * The Params.
     */
    @Mock
    MapSqlParameterSource params;
    /**
     * The Sql create by book.
     */
    @InjectMocks
    SqlCreateByBook sqlCreateByBook;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    /**
//     * Test set.
//     */
//    @Test
//    void testSet() {
//
//        int result = sqlCreateByBook.set(new BookDao(null, "isbn", "name", "writer", 0, 5000, 0d));
//        Assertions.assertEquals(4, result);
//    }
}
