package com.packtpub.angularspringbook.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = GreetingServiceAutoConfiguration.class)
//@SpringBootApplication(exclude = GreetingServiceAutoConfiguration.class)
public class GreetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingApplication.class, args);
    }

}
//
//@Component
//class CustomGreetingService implements GreetingService {
//    @Override
//    public String sayHello(String name) {
//        return "Say Hello to " + name + ", from CustomGreetingService";
//    }
//}

@RestController
@RequestMapping("")
class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String sayHello(@RequestParam String name) {
        return this.greetingService.sayHello(name);
    }
}
