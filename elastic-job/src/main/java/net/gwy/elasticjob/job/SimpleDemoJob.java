package net.gwy.elasticjob.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author guoweiyang
 * @date 2019-06-07
 */
@Slf4j
@Component
public class SimpleDemoJob implements SimpleJob {

    @Override
    public void execute(ShardingContext shardingContext) {
        log.info("***********线程ID:{},任务总片数:{}," +
                        "当前分片项:{},当前参数:{}," +
                        "当前任务名称:{}," +
                        "当前任务参数:{},任务ID:{}",
                 Thread.currentThread().getId(),
                shardingContext.getShardingTotalCount(),
                shardingContext.getShardingItem(),
                shardingContext.getShardingParameter(),
                shardingContext.getJobName(),
                shardingContext.getJobParameter(),
                shardingContext.getTaskId()
                );
    }
}
