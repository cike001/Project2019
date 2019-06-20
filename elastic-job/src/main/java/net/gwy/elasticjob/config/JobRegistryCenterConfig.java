package net.gwy.elasticjob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义zookeeper
 * @author guoweiyang
 * @date 2019-06-07
 */

@Configuration
@ConditionalOnExpression("'${regCenter.serverList}'.length() > 0 ")
public class JobRegistryCenterConfig {


    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(@Value("${regCenter.serverList}") final String serverList,
                                                  @Value("${regCenter.namespace}") final String namespace){

        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList,namespace));
    }
}
