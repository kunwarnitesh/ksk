package com.ksk.service.impl;

import com.ksk.dto.MessageDto;
import com.ksk.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    private KafkaTemplate<String,MessageDto> kafkaTemplate;
    private static final String TOPIC = "kafka-topic-1";

    @Override
    public void publish(MessageDto messageDto) {

        CompletableFuture<SendResult<String, MessageDto>> result = kafkaTemplate.send(TOPIC, messageDto);
        result.whenComplete((data,ex)->{
            if (ex==null){
                log.info("Message Published Successfully");
            }else{
                log.info("Message Published Fail");
            }
        });

    }
}
