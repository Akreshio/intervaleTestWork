/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "27.02.2022, 16:12"
 * @version V 1.0.0
 */

package com.Inter.demo.external.alfabank.model;

import com.Inter.demo.model.books.BookDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Mapper book alfa bank.
 */
@Component
@NoArgsConstructor
public class MapperBookAlfaBank {

    /**
     * Dto to currency book currency.
     *
     * @param book   the book
     * @param prices the prices
     * @return the book currency
     *
     * @see BookCurrency
     * @see BookDto
     */
    public BookCurrency dtoToCurrency (BookDto book, Map<String, BigDecimal> prices){
        BookCurrency bookCurrency = new BookCurrency();

        bookCurrency.setPage(book.getPage());
        bookCurrency.setPrice(prices);
        bookCurrency.setWeight(book.getWeight());
        bookCurrency.setIsbn(book.getIsbn());
        bookCurrency.setWriter(book.getWriter());
        bookCurrency.setName(book.getName());
        return bookCurrency;
    }

    /**
     * Dto list to currency list.
     *
     * @param booksListDao the books list dao
     * @param ratesList    the rates list
     * @return the list
     *
     * @see BookCurrency
     * @see BookDto
     * @see RateListResponse
     */
    public List<BookCurrency> dtoListToCurrencyList (List<BookDto> booksListDao, RateListResponse ratesList){
        List<BookCurrency> booksList = new ArrayList<>();
        for (BookDto book:booksListDao) {

            Map<String, BigDecimal> prices = new HashMap<>();
            BigDecimal byn = BigDecimal.valueOf(book.getPrice()/100);
            prices.put("BYN", byn);
            prices.putAll(ratesList.toCurrency(byn));

            booksList.add(dtoToCurrency(book, prices));
        }
        return booksList;
    }
}
