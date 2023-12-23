package com.example.spring_study.HelloBoot;

public class SimpleHelloService implements HelloService {
    @Override
    public String sayHello(String name) {
        return "say hello"+name;
    }
}
