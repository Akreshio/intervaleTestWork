/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "19.02.2022, 17:28"
 * @version V 1.0.0
 */

package com.Inter.demo.config.restTemplate;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;

public class CustomRestTemplateCustomizer implements RestTemplateCustomizer {
    @Override
    public void customize(RestTemplate restTemplate) {
        restTemplate.getInterceptors().add(new CustomClientHttpRequestInterceptor());
    }
}
