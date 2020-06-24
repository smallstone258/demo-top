package com.small.exclude;

import feign.Contract;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeiLoggerConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        //FeignClientsConfiguration
        return Logger.Level.FULL;
    }

}
