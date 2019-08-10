package net.gwy.apolloclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoweiyang
 * @date 2019-08-10
 */
@Slf4j
@RestController
@RequestMapping("/apollo")
public class TestController {

    @Value("${apollo.desc}")
    String desc;

    @Value("${myapp.name}")
    String name;

    @RequestMapping("/info")
    public void info(){
        log.info("desc:{},name:{}",desc,name);
    }

}
