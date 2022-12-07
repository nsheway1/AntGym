package com.natnael.antGym.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// Bean - an instance of the class managed by the spring container
@RestController
public class SampleController {
    // GET: retrieve, POST: save, PUT: update, DELETE: delete
    @GetMapping("/")
    public String index() {
        return "Welcome!";
    }

    @GetMapping("/greet")
    public String greet() {
        return "Hello";
    }
    @GetMapping("/logout")
    public String logout(){
        return "Bye";
    }

}
