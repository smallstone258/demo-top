package com.small.consumers.config;
import com.small.consumers.config.annotation.ExcludeRules;
import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeRules
public class FeignClient01Config {

    @Bean
    public Contract feignContract(){
        return   new  feign.Contract.Default();
    }



}
