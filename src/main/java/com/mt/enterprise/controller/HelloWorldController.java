package com.mt.enterprise.controller;

import com.mt.enterprise.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final SomeService someService;

    @Autowired
    public HelloWorldController(SomeService someService) {
        this.someService = someService;
    }

    @GetMapping("/hello")
    public String hello() {
        return someService.getMessage();
    }
}
