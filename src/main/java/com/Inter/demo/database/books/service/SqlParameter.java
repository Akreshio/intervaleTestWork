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
    private StringBuffer sql;

    @Autowired
    SqlCreateByBook query;

    public void set (SqlQuerty sqlQuerty){
        if (sqlQuerty == SqlQuerty.get) {
            sql = new StringBuffer(sqlQuerty.sql());
        }
    }

    public boolean set (BookDao bookDao, SqlQuerty sqlQuerty){

        query.set(bookDao);
        params = query.getParams();

        sql = new StringBuffer(sqlQuerty.sql());

        switch (sqlQuerty) {
            case get_by:
            case delete:
                for (int j=0; j<query.getI(); j++){
                    sql.append(query.getColumn()[j] + " =" + query.getParam()[j] + " AND ");
                }
                sql.setLength(sql.length()-5);
                return true;
            case insert:
                StringBuilder sqlColumn = new StringBuilder("");
                StringBuilder sqlParam = new StringBuilder("");

                System.out.println(query.getI());

                for (int j=0; j<=query.getI(); j++){

                    sqlColumn.append(query.getColumn()[j]).append(", ");

                    sqlParam.append(query.getParam()[j]).append(", ");
                }

                sqlColumn.setLength(sqlColumn.length()-2);
                sqlParam.setLength(sqlParam.length()-2);

                sql.append("(").append(sqlColumn).append(") values (").append(sqlParam).append(")");
                return true;
            default:
                return false;
        }
    }
  /*
    public void set (BookDao oldBookDao, BookDao newBookDao, SqlQuerty sqlQuerty){
        if (sqlQuerty == SqlQuerty.update) {
            sql = new StringBuffer(sqlQuerty.sql());
            query.set(bookDao);
            params = query.getParams();
            for (int j=0; j<=query.getI(); j++){
                sql.append(query.getColumn()[j] + "=" + query.getParam()[j] + " AND ");
            }
            sql.setLength(sql.length()-5);

        }
        // first_name = :firstName, last_name = :lastName, age = :age where id = :id";
    }

   */
}
