package com.kafka.service;


import com.kafka.constants.Constants;
import com.kafka.model.Menu;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	@KafkaListener(topics = {Constants.KAFKA_TOPIC })
    public void consume(Menu menu){
        System.out.println("Consumed Message :"+menu);
    }
}