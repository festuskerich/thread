package com.kerich.thread.configuration;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import lombok.Value;

@Configuration
@EnableAsync
public class AssyncTaskJob {

    @Value("${async.config.corepoolsize}")
    private String corePoolSize;
    
    @Value("${async.config.maxpoolsize}")
    private String maxPoolSize;

    @Value("${async.config.queueCapacity}")
    private String queueCapacity;



    @Bean("asyncExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Integer.parseInt(corePoolSize));
        executor.setMaxPoolSize(Integer.parseInt(maxPoolSize));
        executor.setQueueCapacity(Integer.parseInt(queueCapacity));
        executor.setKeepAliveSeconds(30);
        executor.setAllowCoreThreadTimeOut(true);
        executor.setThreadNamePrefix("Async-");
        executor.initialize();
        return executor;
    }
    
}
