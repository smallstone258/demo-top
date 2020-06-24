package com.small.consumers.Feign;

import com.small.consumers.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//@FeignClient(name = "pro",fallback = HystrixFeignIn.HystrixFeignInFallBack.class)
@FeignClient(name = "pro",fallbackFactory = HystrixFeignFactory.class)
public interface HystrixFeignIn {


    @PostMapping(value = "/hystrix")
    Student hystrix(@RequestBody Student   student);

    @GetMapping(value = "/info/{value}")
    String    info(@PathVariable Long   value);

/**
 * 这种方式调用feign的时候注入会报红表示有两个一样的额实例
 */
 /*   @Component
    class HystrixFeignInFallBack implements  HystrixFeignIn{

        @Override
        public Student hystrix(Student student) {
            student.name="feign-hystrix-fallback:"+student.name;
            student.age=-200;
            return student;
        }

        @Override
        public String info(Long value) {
            return "feign-hystrix-fallback:"+value;
        }
    }
*/

}





