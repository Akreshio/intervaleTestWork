/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 14:38"
 * @version V 1.0.0
 */

package com.Inter.demo.database.books.service;

import com.Inter.demo.model.books.BookDao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * Creating sql query without null fields by book.
 * Создание sql-запроса без нулевых полей по книге.
 */
@Getter
@NoArgsConstructor
@Component
public class SqlParameter {

    private MapSqlParameterSource params;
    private String querySql;


    /**
     * Definition the params without null fields by book.
     * Определение параметров книги без нулевых полей.
     */
    @Autowired
    SqlCreateByBook query;

    /**
     * Set.
     *
     * @param sqlQuerty the sql query
     */
    public void set (SqlQuerty sqlQuerty){
        if (sqlQuerty == SqlQuerty.get) {
            querySql = sqlQuerty.sql();
        }
    }

    /**
     * Setting the parameters sql query (Установка параметров sql запроса)
     *
     * @param bookDao   the book dao
     * @param sqlQuerty the sql query
     * @return the boolean
     */
    public boolean set (BookDao bookDao, SqlQuerty sqlQuerty){
        StringBuilder sql = new StringBuilder(sqlQuerty.sql());

        int count = query.set(bookDao);
        params = query.getParams();

        switch (sqlQuerty) {
            case get_by:
            case delete:
                for (int j=0; j<count; j++){
                    sql.append(query.getColumn()[j])
                            .append(" =")
                            .append(query.getParam()[j])
                            .append(" AND ");
                }
                sql.setLength(sql.length()-5);
                querySql = sql.toString();
                return true;
            case insert:
                StringBuilder sqlColumn = new StringBuilder();
                StringBuilder sqlParam  = new StringBuilder();

                for (int j=0; j<=count; j++){
                    sqlColumn.append(query.getColumn()[j]).append(", ");
                    sqlParam.append(query.getParam()[j]).append(", ");
                }
                sqlColumn.setLength(sqlColumn.length()-2);
                sqlParam.setLength(sqlParam.length()-2);
                sql.append("(")
                        .append(sqlColumn)
                        .append(") values (")
                        .append(sqlParam)
                        .append(")");

                querySql = sql.toString();
                return true;
            default:
                return false;
        }
    }
}
