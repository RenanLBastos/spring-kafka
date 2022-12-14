package com.example.kafka.Controllers;


import com.example.kafka.util.TopicProducer;
import com.example.kafka.util.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    @Autowired
    private TopicProducer topicProducer;

    @PostMapping("/kafka")
    public void messageProducer(){
        UserDto userDto = new UserDto();
        userDto.setName("Renan");

        topicProducer.send(userDto);
    }
}
