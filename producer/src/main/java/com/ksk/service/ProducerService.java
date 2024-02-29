package com.ksk.service;

import com.ksk.aop.Loggable;
import com.ksk.dto.MessageDto;

public interface ProducerService {

    void publish(MessageDto messageDto);
}
