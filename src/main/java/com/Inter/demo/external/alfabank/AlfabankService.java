/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "20.02.2022, 17:22"
 * @version V 1.0.0
 */

package com.Inter.demo.external.alfabank;

import com.Inter.demo.database.books.BooksDao;
import com.Inter.demo.external.alfabank.model.BookCurrency;
import com.Inter.demo.external.alfabank.model.MapperBookAlfaBank;
import com.Inter.demo.external.alfabank.model.RateListResponse;
import com.Inter.demo.model.books.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;


/**
 * The type Alfabank service.
 */
@Service
public class AlfabankService {

    /**
     * The Rest template.
     */
    @Autowired
    @Qualifier("alfaBank")
    RestTemplate restTemplate;

    @Autowired
    MapperBookAlfaBank mapperBook;

    public List<BookCurrency> get(List<BookDto> books) {

        //https://ibapi.alfabank.by:8273/
        String URI = "partner/1.0.1/public/rates";
        RateListResponse rateList = restTemplate.getForEntity(URI, RateListResponse.class).getBody();

        return mapperBook.dtoListToCurrencyList(books,rateList);
    }
}

