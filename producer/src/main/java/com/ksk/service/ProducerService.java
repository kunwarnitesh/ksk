package com.ksk.service;

import com.ksk.dto.MessageDto;

public interface ProducerService {

    void publish(MessageDto messageDto);
}
