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
@KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
public class TopicListener {

    @Value("${topic.name.consumer}")
    private String topicName;



    @KafkaHandler
    public void consume(@Payload UserDto payload){
        log.info(payload.toString());

    }

}
