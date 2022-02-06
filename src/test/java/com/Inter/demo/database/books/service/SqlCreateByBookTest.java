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

class SqlCreateByBookTest {
    @Mock
    MapSqlParameterSource params;
    @InjectMocks
    SqlCreateByBook sqlCreateByBook;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testSet() {

        int result = sqlCreateByBook.set(new BookDao(null, "isbn", "name", "writer", 0, 5000, 0d));
        Assertions.assertEquals(4, result);
    }
}
