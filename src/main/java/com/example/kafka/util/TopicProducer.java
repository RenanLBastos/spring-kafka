package com.example.kafka.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.core.io.Resource;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private final KafkaTemplate<String, Object> kafkaTemplate;



    public void send(UserDto message){
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(topicName, message);
    }

}