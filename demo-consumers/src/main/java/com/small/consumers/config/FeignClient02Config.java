package com.small.consumers.config;

import com.small.consumers.config.annotation.ExcludeRules;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ExcludeRules
public class FeignClient02Config {
    /**
     * 添加登录验证配置
     * @return
     */
    @Bean
    public BasicAuthRequestInterceptor  basicAuthRequestInterceptor(){

        return  new BasicAuthRequestInterceptor("admin","111111");
    }

    /**
     * 定义日志搭配yml中的日志级别使用
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
