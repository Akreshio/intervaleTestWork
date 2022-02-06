package com.Inter.demo.model.library;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Getter
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Library {
    private String title;
    private ArrayList<String> author_name;
    private int number_of_pages_median;
    private ArrayList<String> isbn;

    public String getISBN() {
        if (isbn!=null){
            return isbn.get(isbn.size()-1);
        }
        return "";
    }

    public String getAuthor_name() {
        return author_name.toString();
    }
}
