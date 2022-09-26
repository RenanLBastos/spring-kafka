package com.example.kafka.Controllers;


import com.example.kafka.dtos.PlantDto;
import com.example.kafka.util.Producer;
import com.example.kafka.dtos.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaController {

    @Autowired
    private Producer producer;

    @PostMapping("/kafka")
    public void messageProducer(){
        UserDto userDto = new UserDto();
        userDto.setName("Renan");
        userDto.setAge("33");

        PlantDto plantDto = new PlantDto();
        plantDto.setName("samanbaia");
        plantDto.setHasfruit(Boolean.FALSE);
        producer.send(userDto, plantDto, "{\"value\": {\"name\": \"Renan\"}}");
    }
}
