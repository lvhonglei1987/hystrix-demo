package com.example.hystrixdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private EurekaDemoProxy eurekaDemoProxy;


    //熔断，超时时间
    @HystrixCommand(fallbackMethod = "fallbackMethod",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")})
    @GetMapping(value = "/hi")
    public String hi(){
        return  eurekaDemoProxy.hi();
    }

    public String fallbackMethod(){
        return "触发超时熔断";
    }
}
