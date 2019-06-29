package com.packtpub.angularspringbook.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.PropertySourcesPlaceholdersResolver;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@PropertySource("classpath:custom.properties")
public class GreetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingApplication.class, args);
    }

}

@RestController
@RequestMapping("")
class GreetingController {

    @Autowired
    private Environment env;

    @GetMapping
    public String sayHello(@RequestParam("name") String name) {
        return String.format(env.getProperty("greeting.message"), name);
    }

    //    @GetMapping
    //    public String sayHello(@Value("${greeting.message}") String message,
    //                           @RequestParam("name") String name) {
    //        return String.format(message, name);
    //    }

}

