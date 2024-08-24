package com.appsdeveloperblog.ws.emailnotification.handler;

import com.appsdeveloperblog.ws.core.ProductCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = "${event.product.topic-create.name}")
public class ProductCreatedEventHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Value("${event.product.topic-create.name}")
    private String topic;

    @KafkaHandler
    public void handle(ProductCreatedEvent productCreatedEvent){
        LOGGER.info("Product created event: {}", productCreatedEvent.getTitle());
    }
}
