package com.Inter.demo.database.books;

import com.Inter.demo.database.books.service.SqlParameter;
import com.Inter.demo.model.books.BookDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * The type Book dao impl test.
 */
@SpringBootTest
public class BookDaoImplTest {
    /**
     * The Book mapper.
     */
    @Mock
    BookMapper bookMapper;
    /**
     * The Jdbc template.
     */
    @Mock
    NamedParameterJdbcTemplate jdbcTemplate;
    /**
     * The Query param.
     */
    @Mock
    SqlParameter queryParam;
    /**
     * The Book dao.
     */
    @InjectMocks
    BookDaoImpl bookDaoImpl;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test get.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGet() throws Exception {
        List<BookDao> daoList = new ArrayList<>();
        daoList.add(new BookDao(Long.valueOf(1),  0,0, 0d, "isbn", "writer", ""));

        when(jdbcTemplate.query(anyString(), any(BookMapper.class))).thenReturn(daoList);

        List<BookDao> result = bookDaoImpl.get();
        Assert.assertEquals(daoList, result);
    }

    /**
     * Test get 2.
     */
    @Test
    public void testGet2() {
        String sql = "select * from books ";
        MapSqlParameterSource params = new MapSqlParameterSource();
        List<BookDao> daoList = new ArrayList<>();
        daoList.add(new BookDao(Long.valueOf(1),  0,0, 0d, "isbn", "writer", ""));


        when(queryParam.set(any(), any())).thenReturn(true);
        when(queryParam.getParams()).thenReturn(params);
        when(queryParam.getQuerySql()).thenReturn("getQuerySqlResponse");
        when(jdbcTemplate.query(anyString(),any(MapSqlParameterSource.class),any(BookMapper.class))).thenReturn(daoList);

        List<BookDao> result = bookDaoImpl.get(new BookDao(Long.valueOf(1),  0,0, 0d, "isbn", "writer", ""));
        Assert.assertEquals(daoList, result);
    }

    /**
     * Test delete.
     *
     * @throws Exception the exception
     */
    @Test
    public void testDelete() throws Exception {

        when(queryParam.set(any(), any())).thenReturn(true);
        when(queryParam.getParams()).thenReturn(null);
        when(queryParam.getQuerySql()).thenReturn("getQuerySqlResponse");
        when(jdbcTemplate.update(anyString(),any(MapSqlParameterSource.class))).thenReturn(1);

        boolean result = bookDaoImpl.delete(new BookDao(Long.valueOf(1),  0,0, 0d, "isbn", "writer", ""));
        Assert.assertEquals(true, result);
    }

    /**
     * Test add.
     *
     * @throws Exception the exception
     */
    @Test
    public void testAdd() throws Exception {
        StringBuilder sql = new StringBuilder("select * from books ");
        MapSqlParameterSource params = new MapSqlParameterSource();

        when(queryParam.set(any(), any())).thenReturn(true);
        when(queryParam.getParams()).thenReturn(params);
        when(queryParam.getQuerySql()).thenReturn(sql.toString());

        boolean result = bookDaoImpl.add(new BookDao(Long.valueOf(1),  0,0, 0d, "isbn", "writer", ""));
        Assert.assertEquals(true, result);
    }
}
