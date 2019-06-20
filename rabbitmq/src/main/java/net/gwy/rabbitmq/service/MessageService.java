package net.gwy.rabbitmq.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guoweiyang
 * @date 2019-06-07
 */
@Component
public class MessageService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMsg(String msg){
        amqpTemplate.convertAndSend("queue",msg);
    }

}
