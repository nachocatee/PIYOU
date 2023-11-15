package com.b106_402jeoung.PIYOU.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class ScheduledConfig {

    @Bean
    public TaskScheduler scheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        int POOL_SIZE = 1000;
        scheduler.setPoolSize(POOL_SIZE);
        return scheduler;
    }
}
