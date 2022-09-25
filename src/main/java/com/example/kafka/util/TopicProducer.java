package com.example.kafka.util;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    KafkaTemplate<String, Object> multiTypeKafkaTemplate;
//    private final KafkaTemplate<Object, PlantDto> plantDtoKafkaTemplate;
//
//    private final KafkaTemplate<Object, String> stringKafkaTemplate;



    public void send(UserDto user, PlantDto plantDto, String message){
        log.info("Payload enviado: {}", user);
        this.multiTypeKafkaTemplate.send(topicName, user);
        this.multiTypeKafkaTemplate.send(topicName, plantDto);
        this.multiTypeKafkaTemplate.send(topicName, message);
    }

}