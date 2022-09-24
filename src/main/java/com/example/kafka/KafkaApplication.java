package com.example.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.kafka.annotation.EnableKafka;

import java.io.IOException;


@SpringBootApplication
@EnableKafka
public class KafkaApplication {

	@Value("classpath:path/to/file/in/classpath")
	Resource resourceFile;

	public static void main(String[] args) throws IOException {


		SpringApplication.run(KafkaApplication.class, args);
	}

}
