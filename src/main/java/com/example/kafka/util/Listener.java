package com.example.kafka.util;

import com.example.kafka.dtos.PayloadDto;
import com.example.kafka.dtos.PlantDto;
import com.example.kafka.dtos.UserDto;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
@KafkaListener(groupId = "${spring.kafka.consumer.group-id}", topics = "${topic.name.consumer}")
public class Listener {

    @KafkaHandler
    public void handlerUser(UserDto userDto) {
        System.out.println("User received: " + userDto);
    }

    @KafkaHandler
    public void handlerPlant(PlantDto plantDto) {
        System.out.println("Plant received: " + plantDto);
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {

        if (object.getClass().equals(String.class)){
            try {
                PayloadDto teste = new Gson().fromJson(object.toString(), PayloadDto.class);
                System.out.println(teste.getValue());
            }catch (Exception e){
                System.out.println("Objeto não é json " + object);
            }

        }else {
            System.out.println("Formato desconhecido " + object);
        }
    }

}
