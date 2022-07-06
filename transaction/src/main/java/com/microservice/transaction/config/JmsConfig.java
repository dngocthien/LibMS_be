package com.microservice.transaction.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {

    @Bean
    public ActiveMQQueue queue(){
        return new ActiveMQQueue("test-queue");
    }
}
