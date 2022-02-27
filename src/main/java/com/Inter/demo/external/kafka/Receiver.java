/*
 * @author Виктор Дробышевский
 * E-mail: akreshios@gmail.com
 * @since "26.02.2022, 14:49"
 * @version V 1.0.0
 */

package com.Inter.demo.external.kafka;

import java.util.concurrent.CountDownLatch;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Getter
public class Receiver {

    @Autowired
    Sender sender;

    private final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "mvcIn", groupId = "groupIdName")
    public void receive(ConsumerRecord<?, ?> consumerRecord) {
        log.debug("received data='{}'", consumerRecord.value());
        sender.send("mvcLog", consumerRecord.value().toString());
        latch.countDown();
    }

    @KafkaListener(topics = "mvcLog", groupId = "groupIdName")
    public void receives(ConsumerRecord<?, ?> consumerRecord) {
        log.debug("received data='{}'", consumerRecord.value());
        latch.countDown();
    }
}
