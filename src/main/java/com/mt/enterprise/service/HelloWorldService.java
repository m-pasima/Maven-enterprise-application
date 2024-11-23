package com.mt.enterprise.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String getHelloMessage() {
        return "Hello, welcome to the Maven Enterprise Application!";
    }
}
