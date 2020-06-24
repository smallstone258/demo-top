package com.small.consumers.Feign;

import com.small.consumers.config.FeignClient02Config;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 转发规则：如果添加了url，将从url中拿取服务访问，如果没有去eureka中name中获取
 * 添加url后name不能和eureka中服务名相同
 */
@FeignClient(name = "prozz",url = "http://simple:7004",configuration = FeignClient02Config.class)
public interface UrlFeign {

    @RequestMapping(value = "/eureka/apps/{serviceName}")
    public  String   getAppsInfo(@PathVariable String serviceName);

}
