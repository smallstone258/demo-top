package com.small.consumers.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.small.consumers.config.annotation.ExcludeRules;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeRules
public class DFRibbonRule {

    @Bean
    public IRule myRule(){
        return   new RandomRule();
    }

}
