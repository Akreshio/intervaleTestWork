/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "26.02.2022, 14:50"
 * @version V 1.0.0
 */

package com.Inter.demo.external.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * The type Sender.
 */
@Slf4j
@Component
public class Sender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Send message in topic
     *
     * @param topic the topic
     * @param message the message
     */
    public void send(String topic, String message) {
        log.debug("sending message = {} to topic = {}", message, topic);
        kafkaTemplate.send(topic, message);
    }
}