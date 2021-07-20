package com.techleads.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
@EnableKafka
@SpringBootApplication
public class AvroConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvroConsumerAppApplication.class, args);
	}

}
