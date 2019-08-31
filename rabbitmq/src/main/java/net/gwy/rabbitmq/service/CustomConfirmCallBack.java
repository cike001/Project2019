package net.gwy.rabbitmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author gwy
 * @time 2019-08-31 20:13
 * @desc 消息发送确认
 **/
@Slf4j
@Component
public class CustomConfirmCallBack implements RabbitTemplate.ConfirmCallback {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        //指定 ConfirmCallback
        rabbitTemplate.setConfirmCallback(this);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            log.info("--------->消费成功发送到服务器<---------");
        } else {
            log.info("--------->消费发送服务器失败:{}<--------",s);
        }
    }
}
