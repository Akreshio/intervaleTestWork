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

@Component
@NoArgsConstructor
public class MapperBookAlfaBank {

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

        public List<BookCurrency> dtoListToCurrencyList (List<BookDto> booksListDao, RateListResponse ratesList){
        List<BookCurrency> booksList = new ArrayList<>();
        for (BookDto book:booksListDao) {

            Map<String, BigDecimal> prices = new HashMap<String, BigDecimal>();
            BigDecimal byn = BigDecimal.valueOf(book.getPrice()/100);
            prices.put("BYN", byn);
            prices.putAll(ratesList.toCurrency(byn));

            booksList.add(dtoToCurrency(book, prices));
        }
        return booksList;
    }
}
