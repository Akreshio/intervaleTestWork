package com.Inter.demo.database.books;

import com.Inter.demo.model.books.BookDao;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Book mapper.
 */
@Component
public class BookMapper  implements RowMapper<BookDao> {

    @Override
    public BookDao mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new BookDao(
                rs.getLong("id"),
                rs.getInt("page"),
                rs.getInt("price"),
                rs.getDouble("weight"),
                rs.getString("isbn"),
                rs.getString("writer"),
                rs.getString("name")
        );
    }
}