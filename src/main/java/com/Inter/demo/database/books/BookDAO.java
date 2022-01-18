package com.Inter.demo.database.books;

import com.Inter.demo.model.books.Book;

import java.sql.*;
import java.util.HashMap;

public class BookDAO {


    private static final String CON_STR = "jdbc:sqlite:./data/timesheet.s3db";  // адрес подключения
    private static BookDAO instance = null;   // экземпляров класса DbHandler
    private Connection connection;  // Соединение с БД

    public static synchronized BookDAO getInstance() throws SQLException {
        if (instance == null)
            instance = new BookDAO();
        return instance;
    }

    public BookDAO() throws SQLException {

//        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    // Чиение
    public HashMap<String, Book> get() throws SQLException {
        try (Statement statement = this.connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM books" );
            HashMap<String, Book> booksMap = new HashMap<>();
                    while (result.next()) {
                        Book book = new Book(result.getString("isbn"),
                                result.getString("name"),
                                result.getString("writer"),
                                result.getInt("page"),
                                result.getInt("price"),
                                result.getDouble("weight")
                        );
                        booksMap.put(book.getIsbn(), book);
                    }
            return booksMap;
        }
    }


    // Добавление
    public boolean add(Book book) {
        String insert = "INSERT INTO books (`isbn`, `name`, `writer`, `page`, `price`, `weight`) VALUES(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = this.connection.prepareStatement(insert)) {
            statement.setObject(1, book.getIsbn());
            statement.setObject(2, book.getName());
            statement.setObject(3, book.getWriter());
            statement.setObject(4, book.getPage());
            statement.setObject(5, book.getPrice());
            statement.setObject(6, book.getWeight());
            statement.execute();
            return true;
        } catch (SQLException e) {e.printStackTrace();}
        return false;
    }

    // Удаление по id
    public void deleteProduct(String isbn) {
        try (PreparedStatement statement = this.connection.prepareStatement("DELETE FROM books WHERE isbn = ?")) {
            statement.setObject(1, isbn);
            statement.execute();
        } catch (SQLException e) {e.printStackTrace();}
    }

  /*  // Поиск
    private String search (String name) {
        try (Statement statement = this.connection.createStatement()) {
            ResultSet result = statement.executeQuery("SELECT * FROM books WHERE " + insert +"='" + name + "'");
            if (result.next()) return result.getInt("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

   */
}
