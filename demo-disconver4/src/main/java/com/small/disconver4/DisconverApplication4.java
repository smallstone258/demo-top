package com.small.disconver4;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class DisconverApplication4 {

    public static void main(String[] args) {
        new SpringApplicationBuilder(DisconverApplication4.class).web(WebApplicationType.SERVLET).run(args);
    }


}
