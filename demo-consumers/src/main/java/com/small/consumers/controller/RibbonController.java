package com.small.consumers.controller;
import com.netflix.discovery.EurekaClient;
import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "ribbon")
public class RibbonController {

    /**
     * http调用接口
     */
    @Autowired
    RestTemplate restTemplate;

    /**
     * 可以获取注册服务的信息如url port
     */
    @Autowired
    EurekaClient eurekaClient;

    @Autowired
    LoadBalancerClient  loadBalancerClient;


    @RequestMapping(value = "info")
    public   String    getRibbonInfo(){

        // InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("consumers",false);
        ServiceInstance serviceInstance=loadBalancerClient.choose("PRO");
        System.out.println(serviceInstance);
        String info= restTemplate.getForObject(serviceInstance.getUri()+"/info/1",String.class);
        System.out.println(serviceInstance);
        return info;
    }

    /**
     * 测试springboot启动配置Ribbon
     * @RibbonClient(value = "PRO",configuration = {StoneRules.class} )
     * @ComponentScan(excludeFilters={@ComponentScan.Filter(type= FilterType.ANNOTATION, value = ExcludeRules.class)})
     * @return
     */
    @RequestMapping(value = "random")
    public   String    getRandom(){
        // InstanceInfo instanceInfo=eurekaClient.getNextServerFromEureka("consumers",false);
        ServiceInstance serviceInstance=loadBalancerClient.choose("PRO");
        System.out.println(serviceInstance.getUri());
        String info= restTemplate.getForObject(serviceInstance.getUri()+"/info/1",String.class);
        System.out.println(serviceInstance);
        return info;
    }

    /**
     * 测试不同的应用名（spring.application.name）应用不同的算法
     * @return
     */
    @RequestMapping(value = "dbRule")
    public   String    dbRule(){
        ServiceInstance serviceInstance=loadBalancerClient.choose("PRO2");
        System.out.println(serviceInstance.getUri());
        String info= restTemplate.getForObject(serviceInstance.getUri()+"/info/1",String.class);
        return info;
    }

    @RequestMapping(value = "test/{applicationName}")
    public   String    test(@PathVariable String  applicationName){
        ServiceInstance serviceInstance=loadBalancerClient.choose(applicationName);
        System.out.println(serviceInstance.getUri());
        String info= restTemplate.getForObject(serviceInstance.getUri()+"/info/1",String.class);
        return info;
    }


}
