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

class SqlParameterTest {
//    @Mock
//    MapSqlParameterSource params;

    @Mock
    SqlCreateByBook query;
    @InjectMocks
    SqlParameter sqlParameter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

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

        boolean result = sqlParameter.set(new BookDao(null, "isbn", "", "writer", 0, 0, 0d), SqlQuerty.get_by);
        Assert.assertEquals(true, result);
    }
}