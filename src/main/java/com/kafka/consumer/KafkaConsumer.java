package com.kafka.consumer;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

import com.kafka.constants.Constants;
import com.kafka.model.Menu;


public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	  private CountDownLatch latch = new CountDownLatch(1);

	  public CountDownLatch getLatch() {
	    return latch;
	  }

	  @KafkaListener(topics = {Constants.KAFKA_TOPIC })
	  public void receive(Menu menu) {
	    LOGGER.info("received menu='{}'", menu.toString());
	    latch.countDown();
	  }

}




