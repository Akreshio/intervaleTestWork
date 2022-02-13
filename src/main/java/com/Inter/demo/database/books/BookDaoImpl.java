/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 15:38"
 * @version V 1.0.0
 */

package com.Inter.demo.database.books;

import com.Inter.demo.database.books.service.SqlParameter;
import com.Inter.demo.database.books.service.SqlQuerty;
import com.Inter.demo.model.books.BookDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The type Book dao.
 */
@Slf4j
@Repository
public class BookDaoImpl implements BooksDao{

    private final BookMapper bookMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SqlParameter queryParam;

    /**
     * Instantiates a new Book dao.
     *
     * @param bookMapper   the book mapper
     * @param jdbcTemplate the jdbc template
     * @param queryParam   the query param
     */

    @Autowired
    public BookDaoImpl(BookMapper bookMapper, NamedParameterJdbcTemplate jdbcTemplate, SqlParameter queryParam) {
        this.bookMapper = bookMapper;
        this.jdbcTemplate = jdbcTemplate;
        this.queryParam = queryParam;
    }

    @Override
    public List <BookDao> get() {
        return jdbcTemplate.query(SqlQuerty.get.sql(), bookMapper);
    }

    @Override
    public List<BookDao> get(BookDao bookDao) {
        queryParam.set(bookDao, SqlQuerty.get_by);
        return jdbcTemplate.query(
                queryParam.getQuerySql(),
                queryParam.getParams(),
                bookMapper
        );
    }

    @Override
    public boolean delete(BookDao bookDao) {
        queryParam.set(bookDao, SqlQuerty.delete);
        try {
            jdbcTemplate.update(
                queryParam.getQuerySql(),
                queryParam.getParams()
            );
        return true;
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean update(BookDao oldBook, BookDao newBook) {
        try {
            delete(oldBook);
            add(newBook);
            return true;
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean add(BookDao bookDao) {
        queryParam.set(bookDao, SqlQuerty.insert);
        try {
            jdbcTemplate.update(
                queryParam.getQuerySql(),
                queryParam.getParams()
            );
            return true;
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
