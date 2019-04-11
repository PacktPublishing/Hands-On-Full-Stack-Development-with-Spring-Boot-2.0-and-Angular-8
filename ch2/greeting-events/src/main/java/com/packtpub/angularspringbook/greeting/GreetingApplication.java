package com.packtpub.angularspringbook.greeting;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;

@SpringBootApplication
public class GreetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingApplication.class, args);
    }

}


//@Component
//class AppInitializer implements ApplicationListener<ApplicationReadyEvent> {
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//        System.out.println("AppInitializer:: on ApplicationReadyEvent");
//    }
//}

@Component
class AppInitializer {

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyEvent(ApplicationReadyEvent event) {
        System.out.println("AppInitializer:: on ApplicationReadyEvent");
    }

}

@Component
class CommandLineRunnerInitializer implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunnerInitializer::");
    }
}

@Component
class ApplicationRunnerInitializer implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (String optionName : args.getOptionNames()) {
            System.out.println("Option[" + optionName + ":" + args.getOptionValues(optionName) + "]");
        }

        System.out.println("ApplicationRunnerInitializer::");
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
