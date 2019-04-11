package com.packtpub.angularspringbook.greeting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GreetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingApplication.class, args);
    }

}

@RestController
@RequestMapping("")
class GreetingController {
    private final Logger LOG = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping
    public String sayHello() {
        LOG.error("print ERROR message::");
        LOG.info("print INFO message::");
        LOG.warn("print WARN message::");
        LOG.debug("print DEBUG message::");
        LOG.trace("print TRACE message::");

        return "Hello Spring Boot";
    }
}
