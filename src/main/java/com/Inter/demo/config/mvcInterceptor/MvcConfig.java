/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "27.02.2022, 14:08"
 * @version V 1.0.0
 */

package com.Inter.demo.config.mvcInterceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * The type Mvc config.
 */
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Instantiates a new Mvc config.
     *
     * @param kafkaTemplate the kafka template
     */

    public MvcConfig(KafkaTemplate<String, String> kafkaTemplate) {
        super();
        this.kafkaTemplate = kafkaTemplate;
    }

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(
                new MvcInterceptor(kafkaTemplate)
        );
    }
}
