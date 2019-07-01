package com.kafka;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import com.kafka.constants.Constants;
import com.kafka.model.JsonProducer;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class MenuApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		new JsonProducer(Constants.JSON_FILE);
		
		SpringApplication.run(MenuApplication.class, args);
	}

}
