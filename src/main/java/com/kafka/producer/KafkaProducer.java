package com.kafka.producer;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.kafka.config.KafkaProducerConfig;
import com.kafka.constants.Constants;
import com.kafka.model.Menu;

public class KafkaProducer {
	
	private KafkaTemplate<String, Menu> kafkaTemplate = KafkaProducerConfig.kafkaTemplate();

	public void send(Menu pojo) throws InterruptedException, ExecutionException {
		Message<Menu> recordResponse = MessageBuilder.withPayload(pojo)
				.setHeader(KafkaHeaders.TOPIC, Constants.KAFKA_TOPIC).build();
		RecordMetadata metadata = kafkaTemplate.send(recordResponse).get().getRecordMetadata();
		System.out.println("Record sent to partition: " + metadata.partition() + ", Offset: " + metadata.offset() +
				", Timestamp: " + metadata.timestamp());
	}

}
