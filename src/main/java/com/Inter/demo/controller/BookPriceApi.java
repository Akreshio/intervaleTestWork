/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "20.02.2022, 17:10"
 * @version V 1.0.0
 */

package com.Inter.demo.controller;


import com.Inter.demo.external.alfabank.model.BookCurrency;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * The interface Book price api.
 */
public interface BookPriceApi {

    /**
     * Get list.
     *
     * @param name the name
     * @return the list
     */
    @ApiOperation(value = "Курсы валют Национального банка Республики Беларусь", nickname = "getNationalRates", notes = "Возвращает курсы валют, установленные Национальным банком Республики Беларусь", tags={ "public", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешное выполнение запроса"),
            @ApiResponse(code = 400, message = "Некорректный запрос"),
            @ApiResponse(code = 500, message = "Ошибка выполнения запроса") })
    @RequestMapping(value = "/price",
            produces = { "application/json;charset=UTF-8" },
            method = RequestMethod.GET)
    List<BookCurrency> get(
            @ApiParam(value = "Наименование книги")
            @Valid @RequestParam(value = "name") String name);


}


