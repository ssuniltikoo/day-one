package com.spring.training.dayone.controller;

import com.spring.training.dayone.entity.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class HelloRest {

    @GetMapping(path = "/greet")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name ){
        return new Greeting(String.format("hello, %s", name));
    }
}
