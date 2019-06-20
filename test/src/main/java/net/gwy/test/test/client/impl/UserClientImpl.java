package net.gwy.test.test.client.impl;

import net.gwy.test.test.client.UserClient;
import org.springframework.stereotype.Component;

/**
 * @author guoweiyang
 * @date 2019-05-18
 */
@Component
public class UserClientImpl implements UserClient {

    @Override
    public Boolean isExistsUser(String id) {
        System.out.println("服务不可用~");
        return null;
    }
}
