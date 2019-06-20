package net.gwy.elasticjob.config;

import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import net.gwy.elasticjob.job.SimpleDemoJob;
import net.gwy.elasticjob.listener.MyJobListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author guoweiyang
 * @date 2019-06-07
 */
@Configuration
public class ElasticJobConfig {

    @Autowired
    private ZookeeperRegistryCenter regCenter;

    @Bean
    public MyJobListener myJobListener(){
        return new MyJobListener();
    }

    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                        final String cron,
                                                        final int shardingTotalCount,
                                                         final String shardingItemParameters){
        return LiteJobConfiguration.newBuilder(
                new SimpleJobConfiguration(
                        JobCoreConfiguration
                                .newBuilder(jobClass.getName(),cron,shardingTotalCount)
                                .shardingItemParameters(shardingItemParameters)
                                .build(),jobClass.getCanonicalName()
                ))
                .overwrite(true)
                .build();
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(final SimpleDemoJob simpleJob,
                                           @Value("${simpleDemoJob.cron}") final String cron,
                                           @Value("${simpleDemoJob.shardingTotalCount}") final int shardingTotalCount,
                                           @Value("${simpleDemoJob.shardingItemParameters}") final String shardingItemParameters){

        MyJobListener myJobListener = new MyJobListener();

        return new SpringJobScheduler(simpleJob,regCenter,
                getLiteJobConfiguration(simpleJob.getClass(),cron,
                shardingTotalCount,shardingItemParameters),myJobListener);
    }

}
