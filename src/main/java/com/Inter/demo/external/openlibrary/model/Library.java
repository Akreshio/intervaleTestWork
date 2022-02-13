/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 17:02"
 * @version V 1.0.0
 */

package com.Inter.demo.external.openlibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


/**
 * The type Library.
 */
@Getter
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Library {
    private String title;
    private ArrayList<String> author_name;
    private int number_of_pages_median;
    private ArrayList<String> isbn;

    /**
     * Gets isbn.
     *
     * @return the isbn
     */
    public String getISBN() {
        if (isbn!=null){
            return isbn.get(isbn.size()-1);
        }
        return "";
    }

    /**
     * Gets author name.
     *
     * @return the author name
     */
    public String getAuthor_name() {
        return author_name.toString();
    }
}
