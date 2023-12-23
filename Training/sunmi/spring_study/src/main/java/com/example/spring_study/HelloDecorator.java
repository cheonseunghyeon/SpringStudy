package com.example.spring_study;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class HelloDecorator implements HelloService {

    private HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }
    @Override
    public String sayHello(String name) {
        return helloService.sayHello(name) + "*";
    }
}