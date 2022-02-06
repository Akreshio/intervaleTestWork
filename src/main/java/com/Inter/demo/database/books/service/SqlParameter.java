package com.Inter.demo.database.books.service;

import com.Inter.demo.model.books.BookDao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Getter
@NoArgsConstructor
@Component
public class SqlParameter {

    private MapSqlParameterSource params;
    private String querySql;

    private StringBuilder sql;

    @Autowired
    SqlCreateByBook query;

    public void set (SqlQuerty sqlQuerty){
        if (sqlQuerty == SqlQuerty.get) {
            sql = new StringBuilder("");
        }
    }

    public boolean set (BookDao bookDao, SqlQuerty sqlQuerty){

        int count = query.set(bookDao);
        params = query.getParams();

        sql = new StringBuilder(sqlQuerty.sql());

        switch (sqlQuerty) {
            case get_by:
            case delete:
                for (int j=0; j<count; j++){
                    sql.append(query.getColumn()[j] + " =" + query.getParam()[j] + " AND ");
                }
                sql.setLength(sql.length()-5);
                querySql = sql.toString();
                return true;
            case insert:
                StringBuilder sqlColumn = new StringBuilder("");
                StringBuilder sqlParam = new StringBuilder("");

                System.out.println(count);

                for (int j=0; j<=count; j++){

                    sqlColumn.append(query.getColumn()[j]).append(", ");

                    sqlParam.append(query.getParam()[j]).append(", ");
                }

                sqlColumn.setLength(sqlColumn.length()-2);
                sqlParam.setLength(sqlParam.length()-2);

                sql.append("(").append(sqlColumn).append(") values (").append(sqlParam).append(")");
                querySql = sql.toString();
                return true;
            default:
                return false;
        }
    }
}
