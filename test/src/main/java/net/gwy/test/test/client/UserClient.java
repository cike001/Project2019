package net.gwy.test.test.client;

import net.gwy.test.test.client.impl.UserClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author guoweiyang
 * @date 2019-05-18
 */
@FeignClient(name="user-service",fallback = UserClientImpl.class)
public interface UserClient {

    @RequestMapping("/user/isExistsUser")
    public Boolean isExistsUser(@RequestParam("id") String id);

}
