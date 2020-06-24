package com.small.pro;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class ProApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ProApplication.class).web(WebApplicationType.SERVLET).run(args);
        //SpringApplication.run(DemoProApplication.class, args);
    }
    @Bean
    public RestTemplate  restTemplate(){

        return   new RestTemplate();
    }

}
