package com.atlantico.desafio.users.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.atlantico.desafio.users.config.RabbitConfig.queueName;

@Slf4j
@Service
public class EmailConsumer {

    @RabbitListener(queues = queueName)
    public void receiveMessage(final Message message) {
        log.info("Received message as generic: {}", message.toString());
    }

}
