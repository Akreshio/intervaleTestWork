/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "13.02.2022, 17:47"
 * @version V 1.0.0
 */

package com.Inter.demo.model.books;

import com.Inter.demo.controller.deserializer.BookDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * The type Book dto.
 */
@Getter
@Setter
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@JsonDeserialize(using = BookDeserializer.class)
public class BookDto implements Book {

    @NotNull(message = "not be null")
    @Min(value = 0, message = "not be 0")
    private int page = 0;

    @NotNull(message = "not be null")
    @Min(value = 0, message = "not be 0")
    private int price = 0;

    @Min(value = 0, message = "not be 0")
    private double weight = 0.0 ;

    @Size(min = 9, max = 12, message = "ISBN not corection")
    private String isbn = "";

    @NotEmpty(message = "not be empty")
    private String writer = "";

    @NotEmpty(message = "not be empty")
    private String name = "";

    @Override
    public String toString() {
        return "isbn=" + isbn + ", name=" + name + ", writer=" + writer +
                " page=" + page + ", price=" + price + ", weight=" + weight + '\n';
    }
}
