package net.gwy.elasticsearch.repository;

import net.gwy.elasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author guoweiyang
 * @date 2019-07-21
 */
@Component
public interface UserRepository extends ElasticsearchRepository<User,String> {
}
