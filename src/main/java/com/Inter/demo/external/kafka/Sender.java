/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "26.02.2022, 14:50"
 * @version V 1.0.0
 */

package com.Inter.demo.external.kafka;

import lombok.extern.slf4j.Slf4j;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Sender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String data) {
        log.debug("sending data='{}' to topic='{}'", data, topic);
        kafkaTemplate.send(topic, data);
    }
}