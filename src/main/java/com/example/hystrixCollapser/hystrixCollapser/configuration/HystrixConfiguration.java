package com.example.hystrixCollapser.hystrixCollapser.configuration;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixConfiguration {

    @Bean
    public HystrixRequestContext hystrixContext(){
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        return context;
    }

    @Bean
    public HystrixCommandAspect hystrixAspect() {
        return new HystrixCommandAspect();
    }
}
