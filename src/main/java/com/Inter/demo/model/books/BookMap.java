package com.Inter.demo.model.books;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class BookMap {

    int mapIterator = 0;
    HashMap<String, Book> bookMap = new HashMap<>();

    public BookMap() {
    }

    public boolean  isId(String id){
        bookMap.containsKey(id);
        return  bookMap.containsKey(id);
    }

    public Book getForId(String id){
        return bookMap.get(id);
    }

    public void put(Book book){
        bookMap.put(book.isbn, book);
    }

    public void  remove(String id){
        bookMap.remove(id);
    }

    @Override
    public String toString() {
        bookMap.size();

        return "BookMap{" +
                "bookMap=" + bookMap +
                '}';
    }
}
