package net.gwy.user.controller;

import lombok.extern.slf4j.Slf4j;
import net.gwy.user.domain.User;
import net.gwy.user.utils.RestResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoweiyang
 * @date 2019-04-27
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    public RestResponse<User> getUserById(@RequestParam("id") String id){
        log.info("getUserById.id:{}",id);
        User user = new User();
        user.setId("123");
        user.setName("tom");
        user.setEmail("tom@qq.com");
        return new RestResponse<User>(user);
    }

    @RequestMapping("/isExistsUser")
    public Boolean isExistsUser(@RequestParam("id") String id){
        log.info("getUserById:{}",id);
        User user = new User();
        user.setId("123");
        user.setName("tom");
        user.setEmail("tom@qq.com");
        Boolean flag = false;
        if (id.equals("123")) {
            flag = true;
        }
        return flag;
    }

    @RequestMapping("/login")
    public RestResponse<User> login(){
        User user = new User();
        user.setId("123");
        user.setName("tom");
        user.setEmail("tom@qq.com");
        user.setToken("admin");
        return new RestResponse<User>(user);
    }


}
