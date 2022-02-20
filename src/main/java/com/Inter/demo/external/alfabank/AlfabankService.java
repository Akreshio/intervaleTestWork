/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "20.02.2022, 17:22"
 * @version V 1.0.0
 */

package com.Inter.demo.external.alfabank;

import com.Inter.demo.database.books.BooksDao;
import com.Inter.demo.external.alfabank.model.BookCurrency;
import com.Inter.demo.external.alfabank.model.RateListResponse;
import com.Inter.demo.model.books.BookDao;
import com.Inter.demo.model.books.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Alfabank service.
 */
@Service
public class AlfabankService {

    /**
     * The Books dao.
     */
    @Autowired
    BooksDao booksDao;

    /**
     * The Rest template.
     */
    @Autowired
    RestTemplate restTemplate;


    /**
     * Get list.
     *
     * @param name the book name
     * @return the list of book currency
     */
    public List<BookCurrency> get(String name) {

        BookDto book = new BookDto();
        book.setName(name);

        String URI = "https://ibapi.alfabank.by:8273/partner/1.0.1/public/rates";
        RateListResponse rateList = restTemplate.getForEntity(URI, RateListResponse.class).getBody();

        return booksListToCurrency(booksDao.get(bookToDAO(book)), rateList);
    }



    private List<BookCurrency> booksListToCurrency(List<BookDao> booksListDao,  RateListResponse ratesList){
        List<BookCurrency> booksList = new ArrayList<>();
        for (BookDao book:booksListDao) {

            Map<String, BigDecimal> prices = new HashMap<String, BigDecimal>();
            BigDecimal byn = BigDecimal.valueOf(book.getPrice()/100);
            prices.put("BYN", byn);
            prices.putAll(ratesList.toCurrency(book.getPrice()/100));
            booksList.add(new BookCurrency(book, prices));
        }
        return booksList;
    }
    private BookDao bookToDAO(BookDto book){
        return new BookDao(book);
    }

}

