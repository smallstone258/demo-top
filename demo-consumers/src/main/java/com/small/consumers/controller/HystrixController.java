package com.small.consumers.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.small.consumers.Feign.HystrixFeignIn;
import com.small.consumers.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "hystrix")
public class HystrixController {

    @Autowired
    HystrixFeignIn  hystrixFeignIn;

    //@HystrixCommand(fallbackMethod = "breker1")
    @RequestMapping(value ="/stu",method = RequestMethod.POST)
    public Student   stuInfo(@RequestBody Student  student){
        return   hystrixFeignIn.hystrix(student);
    }


    public Student   breker1(@RequestBody Student  student){
        student.name="undefined";
        student.age=-100;
        return  student;
    }

    //@HystrixCommand(fallbackMethod = "breker2")
    @RequestMapping(value ="/info/{age}",method = RequestMethod.GET)
    public String  stuInfo(@PathVariable Long  age){
        return   hystrixFeignIn.info(age);
    }

    public String  breker2(Long  age){
        return   "请求失败:"+age;
    }

}
