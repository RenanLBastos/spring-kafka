package com.example.kafka.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PayloadDto {

    @JsonProperty("value")
    private Value value;
}
