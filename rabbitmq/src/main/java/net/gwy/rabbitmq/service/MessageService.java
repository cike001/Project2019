package net.gwy.rabbitmq.service;

import net.gwy.rabbitmq.util.RabbitConstans;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author guoweiyang
 * @date 2019-06-07
 */
@Component
public class MessageService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg){
        try {
            Thread.sleep(1000*30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        rabbitTemplate.convertAndSend(RabbitConstans.QUEUE_01,msg);
    }

}
