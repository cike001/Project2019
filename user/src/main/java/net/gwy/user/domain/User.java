package net.gwy.user.domain;

import lombok.Data;

/**
 * @author guoweiyang
 * @date 2019-04-27
 */
@Data
public class User {

    private String id;
    private String name;
    private Integer age;
    private String email;
    private Integer sex;
    private String token;
}
