package com.Inter.demo.database.books;

import com.Inter.demo.model.books.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Component
public class BookMapper  implements RowMapper<HashMap <Long, Book>> {
  /*
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getLong("id"));
            book.setPage(rs.getInt("page"));
            book.setPrice(rs.getInt("price"));
            book.setWeight(rs.getDouble("weight"));
            book.setIsbn(rs.getString("isbn"));
            book.setWriter(rs.getString("writer"));
            book.setName(rs.getString("name"));
        return book;

    }
    */

    @Override
    public HashMap <Long, Book> mapRow(ResultSet rs, int rowNum) throws SQLException {
        HashMap<Long, Book> bookMap = new HashMap<>();
        System.out.println(rs.next());
        while (rs.next()) {
            Book book = new Book();
            book.setId(rs.getLong("id"));
            book.setPage(rs.getInt("page"));
            book.setPrice(rs.getInt("price"));
            book.setWeight(rs.getDouble("weight"));
            book.setIsbn(rs.getString("isbn"));
            book.setWriter(rs.getString("writer"));
            book.setName(rs.getString("name"));
            System.out.println(book);
            bookMap.put(rs.getLong("id"),book);
        }

        return bookMap;
    }


}