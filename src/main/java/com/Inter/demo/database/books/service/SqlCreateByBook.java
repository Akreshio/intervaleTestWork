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

    private MapSqlParameterSource params = new MapSqlParameterSource();
    private String[] column = new String[7];
    private String[] param = new String[7];
    private int i = 0;

    public void set (BookDao bookDao) {
        i=0;

        if((bookDao.getId()!=null)){
            params.addValue("id", bookDao.getId());
            column[i] = "id ";
            param[i] = " :id";
            i++;
        }
        if (bookDao.getPage()!=0){
            params.addValue("page", bookDao.getPage());
            column[i] = "page";
            param[i] = " :page";
            i++;
        }
        if (bookDao.getPrice()!=0){
            params.addValue("price", bookDao.getPrice());
            column[i] = "price";
            param[i] = " :price";
            i++;
        }
        if (bookDao.getWeight()!=0){
            params.addValue("weight", bookDao.getWeight());
            column[i] = "weight";
            param[i] = " :weight";
            i++;
        }
        if (!bookDao.getIsbn().isEmpty())   {
            params.addValue("isbn", bookDao.getIsbn());
            column[i] = "isbn";
            param[i] = " :isbn";
            i++;
        }
        if (!bookDao.getWriter().isEmpty()) {
            params.addValue("writer", bookDao.getWriter());
            column[i] = "writer";
            param[i] = " :writer";
            i++;
        }
        if (!bookDao.getName().isEmpty())   {
            params.addValue("name", bookDao.getName());
            column[i] = "name";
            param[i] = " :name";
        }
    }
}
