package com.etrackhis.autoproject.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class ScheduleConfig {

    @Value("${etrack.auto.poolSize}")
    private int poolSize;

    @Value("${etrack.auto.threadName}")
    private String threadName;

    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        // 定时任务执行线程池核心线程数
        if (poolSize<0){poolSize = 10;}
        taskScheduler.setPoolSize(poolSize);
        taskScheduler.setRemoveOnCancelPolicy(true);
        if (StringUtils.isEmpty(threadName)){threadName="TaskThread";}
        taskScheduler.setThreadNamePrefix(threadName + "-");
        return taskScheduler;
    }
}