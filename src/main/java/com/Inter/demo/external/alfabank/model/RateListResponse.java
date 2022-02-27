package com.Inter.demo.external.alfabank.model;

import java.math.BigDecimal;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Generated;
import javax.validation.Valid;

/**
 * Выходная модель, содержащая основные курсы валют Альфа-Банка
 */
@ApiModel(description = "Выходная модель, содержащая основные курсы валют Альфа-Банка")
@Validated
@Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-02-18T13:29:10.146+02:00")

public class RateListResponse   {
  @JsonProperty("rates")
  @Valid
  private List<Rate> rates = null;

  /**
   * Rates rate list response.
   *
   * @param rates the rates
   * @return the rate list response
   */
  public RateListResponse rates(List<Rate> rates) {
    this.rates = rates;
    return this;
  }

  /**
   * Add rates item rate list response.
   *
   * @param ratesItem the rates item
   * @return the rate list response
   */
  public RateListResponse addRatesItem(Rate ratesItem) {
    if (this.rates == null) {
      this.rates = new ArrayList<Rate>();
    }
    this.rates.add(ratesItem);
    return this;
  }

  /**
   * Список основных курсов валют Альфа-Банка
   *
   * @return rates rates
   */
  @ApiModelProperty(value = "Список основных курсов валют Альфа-Банка")
  @Valid
  public List<Rate> getRates() {
    return rates;
  }

  /**
   * Sets rates.
   *
   * @param rates the rates
   */
  public void setRates(List<Rate> rates) {
    this.rates = rates;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RateListResponse {\n");
    
    sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * To currency map.
   *
   * @param price the price
   * @return the map
   */

  public Map<String, BigDecimal> toCurrency(BigDecimal price) {
    Map<String, BigDecimal> prices = new HashMap<String, BigDecimal>();

    for(Rate rate : rates) {
      if (rate.getName()!=null) {
        BigDecimal quantity =price.multiply(BigDecimal.valueOf(rate.getQuantity()));
        prices.put(rate.getSellIso(), quantity.divide(rate.getBuyRate(), 5, BigDecimal.ROUND_DOWN));
      }
    }
    return prices;
  }
}

