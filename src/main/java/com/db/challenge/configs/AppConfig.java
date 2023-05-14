package com.db.challenge.configs;

import com.db.challenge.aspects.LoggerAspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public LoggerAspects loggerAspect() {
        return new LoggerAspects();
    }
}
