package com.example.spring_study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HelloService helloService;
    public HelloController(HelloService service) {
        helloService = service;
    }

    @GetMapping("/hello")
    public String hello(String name){
        return helloService.sayHello(name);
    }
}
