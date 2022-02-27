/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "27.02.2022, 14:08"
 * @version V 1.0.0
 */

package com.Inter.demo.config.mvcInterceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public MvcConfig() {
        super();
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new MvcInterceptor(kafkaTemplate));
    }
}
