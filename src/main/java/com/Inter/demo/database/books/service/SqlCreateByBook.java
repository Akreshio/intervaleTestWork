/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 14:06"
 * @version V 1.0.0
 */

package com.Inter.demo.database.books.service;

import com.Inter.demo.model.books.BookDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * Definition the params without null fields by book.
 * Определение параметров книги без нулевых полей.
 */
@Getter
@NoArgsConstructor
@Component
public class SqlCreateByBook {

    private final MapSqlParameterSource params = new MapSqlParameterSource();
    private final String[] column = new String[7];
    private final String[] param = new String[7];

    /**
     * Selects not null params (Выбирает не нулевые параметры)
     *
     * @param bookDao the book dao
     * @return the number of not null params (количество ненулевых параметров)
     */
    public int set (BookDao bookDao) {
        int i=0;
        i = setField(bookDao.getId(),       "id",       i); //long
        i = setField(bookDao.getPage(),     "page",     i); //int
        i = setField(bookDao.getPrice(),    "price",    i); //int
        i = setField(bookDao.getWeight(),   "weight",   i); //double
        i = setField(bookDao.getIsbn(),     "isbn",     i); //string
        i = setField(bookDao.getWriter(),   "writer",   i); //string
        i = setField(bookDao.getName(),     "name",     i); //string
        return i;
    }

    private int setField (String inString,  String nameColum, int counter) {
        if (!inString.isEmpty()) {
            params.addValue(nameColum, inString);
            column[counter] = nameColum;
            param[counter] = " :" + nameColum;
            counter++;
            return counter;
        }
        return counter;
    }
    private int setField (int inInt,        String nameColum, int counter) {
        if (inInt!=0){
            params.addValue(nameColum, inInt);
            column[counter] = nameColum;
            param[counter] = " :" + nameColum;
            counter++;
            return counter;
        }
        return counter;
    }
    private int setField (double inDouble,  String nameColum, int counter) {
        if (inDouble!=0){
            params.addValue(nameColum, inDouble);
            column[counter] = nameColum;
            param[counter] = " :" + nameColum;
            counter++;
            return counter;
        }
        return counter;
    }
    private int setField (Long inLong,      String nameColum, int counter) {
        if (inLong!=null){
            params.addValue(nameColum, inLong);
            column[counter] = nameColum;
            param[counter] = " :" + nameColum;
            counter++;
            return counter;
        }
        return counter;
    }

}
