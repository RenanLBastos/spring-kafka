package com.example.kafka.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
@KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${topic.name.consumer}")
public class TopicListener {

    @KafkaHandler
    public void handleGreeting(UserDto userDto) {
        System.out.println("User received: " + userDto);
    }

    @KafkaHandler
    public void handleF(PlantDto plantDto) {
        System.out.println("Plant received: " + plantDto);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Unkown type received: " + object);
    }

}
