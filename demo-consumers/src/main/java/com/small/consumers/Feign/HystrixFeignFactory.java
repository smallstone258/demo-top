package com.small.consumers.Feign;

import com.small.consumers.entity.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixFeignFactory  implements FallbackFactory<HystrixFeignIn> {

    @Override
    public HystrixFeignIn create(Throwable throwable) {
        return  new HystrixFeignIn() {
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
        };
    }
}
