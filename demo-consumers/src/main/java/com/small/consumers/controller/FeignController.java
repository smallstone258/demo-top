package com.small.consumers.controller;

import com.netflix.discovery.converters.Auto;
import com.small.consumers.Feign.InfoFeign;
import com.small.consumers.Feign.UrlFeign;
import com.small.consumers.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feign")
public class FeignController {

    @Autowired
    InfoFeign   infoFeign;
    @Autowired
    UrlFeign   urlFeign;

    @RequestMapping("info/{param}")
    public  String    info(@PathVariable Long  param){
        return  infoFeign.info(param);
    }

    @RequestMapping(value = "stu",method =RequestMethod.POST)
    public  Student    stu(@RequestBody Student stu){
        return  infoFeign.stu(stu);
    }


    @RequestMapping("url/{serviceName}")
    public  String    urlInfo(@PathVariable String  serviceName){
        return  urlFeign.getAppsInfo(serviceName);
    }




}
