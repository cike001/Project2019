package net.gwy.rabbitmq.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import net.gwy.rabbitmq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoweiyang
 * @date 2019-06-07
 */

@Slf4j
@RestController
@RequestMapping("msg")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/sendMsg",method = RequestMethod.POST)
    public void sendMsg(@RequestBody String message){
        JSONObject jsonObject = JSON.parseObject(message);
        String msg = jsonObject.getString("message");
        log.info("=========>生产者发送消息:{}<=========",msg);
        messageService.sendMsg(msg);
        log.info("=========>消息发送成功<=========");
    }

}
