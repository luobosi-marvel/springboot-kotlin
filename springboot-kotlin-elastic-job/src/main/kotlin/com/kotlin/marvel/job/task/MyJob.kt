package com.kotlin.marvel.job.task

import com.dangdang.ddframe.job.api.ShardingContext
import com.dangdang.ddframe.job.api.simple.SimpleJob
import com.dangdang.elasticjob.lite.annotation.ElasticSimpleJob
import org.springframework.stereotype.Component

/**
 * @author marvel
 * @description
 * @date 2018/5/22
 */
@ElasticSimpleJob(cron = "* * * * * ?", jobName = "test123", shardingTotalCount = 2, jobParameter = "测试参数", shardingItemParameters = "0 = A,1 = B")
@Component
class MyJob : SimpleJob {

    override fun execute(content: ShardingContext) {
        //do something
        println("JobName:" + content.jobName)
        println("JobParameter:" + content.jobParameter)
        println("ShardItem:" + content.shardingItem)
        println("ShardParameter:" + content.shardingParameter)
        println("ShardTotalCount:" + content.shardingTotalCount)
        println("TaskId:" + content.taskId)
        println("---------------------------------------")
    }
}