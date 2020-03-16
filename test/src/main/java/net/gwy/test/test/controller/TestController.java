package net.gwy.test.test.controller;

import net.gwy.test.test.client.UserClient;
import net.gwy.test.test.util.AAA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author guoweiyang
 * @date 2019-05-18
 */
@RestController
@RequestMapping("/test")
public class TestController {

//    @Autowired
//    UserClient  userClient;

    @RequestMapping(value = "/checkUser",method = RequestMethod.POST)
    public Boolean judgeUser(@RequestBody AAA aaa){
       /* System.out.println("test-service:"+id);
        return userClient.isExistsUser(id);*/
        System.out.println(aaa.getMobile());
       return true;
    }
}
