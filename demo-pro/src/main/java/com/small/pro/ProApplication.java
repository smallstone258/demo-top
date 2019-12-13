package com.small.pro;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ProApplication.class).web(WebApplicationType.SERVLET).run(args);
        //SpringApplication.run(DemoProApplication.class, args);
    }

}
