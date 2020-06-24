package com.small.pro.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.small.pro.entity.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
public class InfoController {


    @Value("${server.port}")
    Integer   port;

    @GetMapping(value = "/info/{value}")
    public   String    info(@PathVariable  Long   value){

        return  port.toString()+"    value:"+value;
    }


    @RequestMapping(value = "stu",method =RequestMethod.POST)
    public   Student    stu(@RequestBody Student stu){
        return  stu;
    }

    @RequestMapping(value = "stuu",method =RequestMethod.POST)
    public   Student    stuu(@RequestBody Student stuu){
        return  stuu;
    }



    @PostMapping(value = "/hystrix")
    @HystrixCommand(fallbackMethod = "break1")
    public   Student    hystrix(@RequestBody  Student   student){
        student.name="hello"+student.name;
        return  student;
    }

    public   Student    break1(Student   student){
        student.name="undefined";
        student.age=-100;
        return  student;
    }

}
