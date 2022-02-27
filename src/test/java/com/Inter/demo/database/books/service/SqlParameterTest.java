package com.Inter.demo.database.books.service;

import com.Inter.demo.model.books.BookDao;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import static org.mockito.Mockito.*;

/**
 * The type Sql parameter test.
 */
class SqlParameterTest {
//    @Mock
//    MapSqlParameterSource params;

    /**
     * The Query.
     */
    @Mock
    SqlCreateByBook query;
    /**
     * The Sql parameter.
     */
    @InjectMocks
    SqlParameter sqlParameter;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test set.
     */
    @Test
    void testSet() {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("isbn","isbn");
        params.addValue("writer","writer");
        String [] str = {"isbn","writer"};

        when(query.set(any(BookDao.class))).thenReturn(2);
        when(query.getParams()).thenReturn(params);
        when(query.getParam()).thenReturn(str);
        when(query.getColumn()).thenReturn(str);

        boolean result = sqlParameter.set(new BookDao(null, 0,0, 0d, "isbn", "writer", ""  ), SqlQuerty.get_by);
        Assert.assertEquals(true, result);
    }
}