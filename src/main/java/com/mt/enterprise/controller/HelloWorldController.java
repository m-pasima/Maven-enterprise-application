package com.mt.enterprise.controller;

import com.mt.enterprise.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello")
    public String sayHello() {
        return helloWorldService.getHelloMessage();
    }
}
