package net.gwy.rabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import net.gwy.rabbitmq.util.RabbitConstans;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author guoweiyang
 * @date 2019-06-07
 * @desc 消息2
 */
@Slf4j
@Component
public class MessageReceive2 {

    @RabbitListener(queues = {RabbitConstans.QUEUE_01})
    public void receiveMsg(String msg){
       log.info("===========>消费端消费消息<===============,msg:{}",msg);
    }
}
