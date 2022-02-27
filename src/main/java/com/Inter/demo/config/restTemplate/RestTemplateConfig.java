/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "19.02.2022, 17:28"
 * @version V 1.0.0
 */

package com.Inter.demo.config.restTemplate;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import javax.annotation.Resource;

/**
 * The type Rest template config.
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.Inter.demo.config.restTemplate")
public class RestTemplateConfig {

    /**
     * Rest template rest template.
     *
     * @param builder the builder
     * @return the rest template
     */
    @Bean("alfaBank")
    @Resource
    public RestTemplate restTemplateAlfaBank(RestTemplateBuilder builder) {
        return builder
                .uriTemplateHandler(new DefaultUriBuilderFactory("https://ibapi.alfabank.by:8273"))
                .additionalInterceptors(new CustomClientHttpRequestInterceptor())
                .build();
    }
    @Bean("openLibrary")
    @Resource
    public RestTemplate restTemplateOpenLibrary(RestTemplateBuilder builder) {
        return builder
                .uriTemplateHandler(new DefaultUriBuilderFactory("http://openlibrary.org"))
                .additionalInterceptors(new CustomClientHttpRequestInterceptor())
                .build();
    }

}
