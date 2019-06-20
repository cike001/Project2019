package net.gwy.test.test.controller;

import net.gwy.test.test.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoweiyang
 * @date 2019-05-18
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    UserClient  userClient;

    @RequestMapping(value = "/checkUser/{id}",method = RequestMethod.GET)
    public Boolean judgeUser(@PathVariable("id") String id){
        System.out.println("test-service:"+id);
        return userClient.isExistsUser(id);
    }
}
