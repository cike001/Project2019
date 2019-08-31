package net.gwy.rabbitmq.config;

import net.gwy.rabbitmq.util.RabbitConstans;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoweiyang
 * @date 2019-06-07
 */
@Configuration
public class QueueConf {

    @Bean
    public Queue queue(){
        return new Queue(RabbitConstans.QUEUE_01);
    }

}
