package com.packtpub.angularspringbook.greeting;

public class DefaultGreetingService implements  GreetingService {
    @Override
    public String sayHello(String name) {
        String message = "Say Hello to " + name + ", from DefaultGreetingService";
        System.out.println(message);

        return message;
    }
}
