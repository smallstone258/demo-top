package com.small.consumers;
import com.small.consumers.config.annotation.ExcludeRules;
import com.small.consumers.config.DFRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(value = "PRO",configuration = {DFRibbonRule.class} )//其中服务名必须大写才能匹配
@EnableFeignClients()
@ComponentScan(excludeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION,value = ExcludeRules.class)})
@EnableCircuitBreaker
public class ConsumersApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumersApplication.class, args);
    }

    @Bean
    public RestTemplate   getRestTemplat(){

        return  new RestTemplate();
    }

}
