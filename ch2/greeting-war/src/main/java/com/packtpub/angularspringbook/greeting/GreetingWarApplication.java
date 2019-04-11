package com.packtpub.angularspringbook.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GreetingWarApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingWarApplication.class, args);
    }

}

@RestController
@RequestMapping("")
class GreetingController {

    @GetMapping
    public String sayHello() {
        return "Hello Spring Boot";
    }

}

