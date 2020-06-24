package com.small.consumers.config.annotation;

/**
 * 这个注解用于过滤Ribbon负载配置或者Feign自定义配置，确认是有用的，配置就可以放springboot启动类饱含饭碗了
 * @FeignClient(name = "pro",configuration = {FeignClient01Config.class})
 * @ComponentScan(excludeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION,value = ExcludeRules.class)})
 */
public @interface ExcludeRules {
}
