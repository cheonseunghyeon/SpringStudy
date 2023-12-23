package com.example.spring_study;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RequestMapping("/hello")
@RestController
public class HelloController {

    private HelloService helloService;
    public HelloController(HelloService service) {
        helloService = service;
    }

    @GetMapping
    @ResponseBody
    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
