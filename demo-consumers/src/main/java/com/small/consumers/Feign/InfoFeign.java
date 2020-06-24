package com.small.consumers.Feign;

import com.small.consumers.config.FeignClient01Config;
import com.small.consumers.entity.Student;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

//@FeignClient("pro")//这个服务名可以大小写
@FeignClient(name = "proff",configuration = {FeignClient01Config.class})
public interface InfoFeign {

    /**
     * 用了feign中的contract自定义协议就不能使用requestMaping了并且
     * @pathvalue传递参数也要改成@Param 其中requstBody也可以省略
     * @param value
     * @return
     */
     /*  //改变前
    @GetMapping(value = "/info/{value}")
    String    info(@PathVariable Long  value);*/

    @RequestLine("GET /info/{value}")
    String    info(@Param("value") Long  value);

    /* //改变前
    @RequestMapping(value = "stu",method =RequestMethod.POST)
    Student    stu(@RequestBody Student stu);*/

    @RequestLine("POST  /stu")
    Student    stu(Student stu);
}
