/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "20.02.2022, 21:36"
 * @version V 1.0.0
 */

package com.Inter.demo.controller;

import com.Inter.demo.external.alfabank.AlfabankService;
import com.Inter.demo.external.alfabank.model.BookCurrency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Book price api controller.
 */
@Slf4j
@RestController
public class BookPriceApiController implements BookPriceApi {

    /**
     * The Alfabank service.
     */
    @Autowired
    AlfabankService alfabankService;

    public List<BookCurrency> get(String name) {
        return alfabankService.get(name);
    }

}
