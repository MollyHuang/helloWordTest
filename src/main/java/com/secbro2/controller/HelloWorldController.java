package com.secbro2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Molly Huang
 */
@RestController
public class HelloWorldController {

    /**
     * http://localhost:8080/hello
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!";
    }
}
