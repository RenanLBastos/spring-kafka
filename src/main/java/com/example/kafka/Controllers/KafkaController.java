package com.example.kafka.Controllers;


import com.example.kafka.util.PlantDto;
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
        userDto.setAge("33");

        PlantDto plantDto = new PlantDto();
        plantDto.setName("samanbaia");
        plantDto.setHasfruit(Boolean.FALSE);
        topicProducer.send(userDto, plantDto, "Simple string message");
    }
}
