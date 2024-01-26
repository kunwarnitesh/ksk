package com.ksk.controller;

import com.ksk.dto.MessageDto;
import com.ksk.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
public class ProducerController {


    @Autowired
    private ProducerService producerService;
    @GetMapping("/publish/{message}")
    public String postMessage(@PathVariable("message") final String message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setMessage(message);
        producerService.publish(messageDto);
        return "Message Published successfully";
    }
}
