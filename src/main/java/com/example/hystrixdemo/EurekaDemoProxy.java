package com.example.hystrixdemo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("EUREKA-CLIENT-DEMO")
public interface EurekaDemoProxy {


    @GetMapping(value = "/hello")
    public String hi();
}
