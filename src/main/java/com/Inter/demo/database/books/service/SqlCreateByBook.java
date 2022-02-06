package com.Inter.demo.database.books.service;

import com.Inter.demo.model.books.BookDao;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class SqlCreateByBook {

    private final MapSqlParameterSource params = new MapSqlParameterSource();
    private final String[] column = new String[7];
    private final String[] param = new String[7];

    public int set (BookDao bookDao) {
        int i=0;

        //long
        i = setField(bookDao.getId(),"id", i);

       //int
        i = setField(bookDao.getPage(),"page", i);
        i = setField(bookDao.getPrice(),"price", i);

        //double
        i = setField(bookDao.getWeight(),"weight", i);

        //string
        i = setField(bookDao.getIsbn(),"isbn", i);
        i = setField(bookDao.getWriter(),"writer", i);
        i = setField(bookDao.getName(),"name", i);
        return i;
    }

    private int setField (String inString, String nameColum, int counter) {
        if (!inString.isEmpty()) {
            params.addValue(nameColum, param);
            column[counter] = nameColum;
            param[counter] = " :" + nameColum;
            counter++;
            return counter;
        }
        return counter;
    }
    private int setField (int inInt, String nameColum, int counter) {
            if (inInt!=0){
        params.addValue(nameColum, inInt);
        column[counter] = nameColum;
        param[counter] = " :" + nameColum;
                counter++;
                return counter;
            }
        return counter;
    }

    private int setField (double inDouble, String nameColum, int counter) {
        if (inDouble!=0){
            params.addValue(nameColum, inDouble);
            column[counter] = nameColum;
            param[counter] = " :" + nameColum;
            counter++;
            return counter;
        }
        return counter;
    }

    private int setField (Long inLong, String nameColum, int counter) {
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
