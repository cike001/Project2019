package net.gwy.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author guoweiyang
 * @date 2019-07-21
 */
@Data
@Document(indexName = "testuser",type = "users")
public class User implements Serializable {

    private String id;
    private String name;
    private String sex;
    private Integer age;
    private String email;

}
