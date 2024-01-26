package com.ksk.service;

import com.ksk.dto.MessageDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "kafka-topic-1", groupId = "consumer-group-2", containerFactory = "userKafkaListenerFactory")
    public void consumer(@Payload MessageDto message) {
        System.out.println("Received Message: \n" + message + "\nfrom partition: ");
    }

}
