package com.Inter.demo.database.books;

import com.Inter.demo.model.books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

@Repository
public class BookDaoImpl implements BooksDao{

    private static final String TABLE_NAME = "books ";

    private static final String SQL_GET_PROFILE_BY_ID =
            "select * from " + TABLE_NAME ;


    private static final String SQL_GET_BOOK = "select * from " + TABLE_NAME;
    // select * from profiles where id = :id";

    private static final String SQL_INSERT_BOOK = "insert into " + TABLE_NAME;
    //(first_name, last_name, age) values (:firstName, :lastName, :age)";

    private static final String SQL_UPDATE_BOOK = "update " + TABLE_NAME + "set ";
    // set first_name = :firstName, last_name = :lastName, age = :age where id = :id";

    private static final String SQL_DELETE_BOOK = "delete from " + TABLE_NAME + "where ";
    // id = :id ;



    private final BookMapper bookMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(BookMapper bookMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.bookMapper = bookMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<HashMap <Long, Book>> get() {
        int id = 1;
        MapSqlParameterSource params = new MapSqlParameterSource();
        try {return  Optional.ofNullable(
                jdbcTemplate.queryForObject(
                        SQL_GET_BOOK,
                        params,
                        bookMapper
                ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }



/*
        HashMap<Long, Book> hashMap;
        MapSqlParameterSource params = new MapSqlParameterSource();
        try {hashMap = Optional.ofNullable(
                jdbcTemplate.queryForObject(
                        SQL_GET_BOOK,
                        params,
                        bookMapper
                )).orElseThrow();
            return hashMap;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

 */
    }

    @Override
    public HashMap<String, Book> search(Book book) {
        return null;
    }

    @Override
    public boolean add(Book book) {
        return false;
    }

    @Override
    public boolean delete(Book book) {
        return false;
    }

    // id = :id ;
    private String sqlFormate (Book book) {
        if (book.getId()!=null)     {return "id = :id";}
        if (book.getPage()!=0)      {return "page = :page";}
        if (book.getPrice()!=0)     {return "price = :price";}
        if (book.getWeight()!=0)    {return "weight = :weight";}
        if (book.getWriter()!=null) {return "writer = :writer";}
        if (book.getName()!=null)   {return "name = :name";}
        return "";
    }
}
