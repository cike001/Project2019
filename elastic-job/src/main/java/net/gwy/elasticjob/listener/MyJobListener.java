package net.gwy.elasticjob.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 配置监听器
 * @author guoweiyang
 * @date 2019-06-07
 */
@Slf4j
public class MyJobListener implements ElasticJobListener {

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        log.info("===>{} job begin time:{} <===",shardingContexts.getJobName(),
                new Date());
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        log.info("===>{} job end time:{} <===",shardingContexts.getJobName(),
                new Date());
    }
}
