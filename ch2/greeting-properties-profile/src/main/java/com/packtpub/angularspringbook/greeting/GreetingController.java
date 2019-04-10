package com.packtpub.angularspringbook.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
class GreetingController {

    //	@GetMapping
//	public String sayHello(@Value("${greeting.message}") String message,
//						   @RequestParam("name") String name){
//		return String.format(message, name);
//	}
    private final GreetingProperties greetingProperties;

    public GreetingController(GreetingProperties greetingProperties) {
        this.greetingProperties = greetingProperties;
    }

    @GetMapping
    public String sayHello(@RequestParam("name") String name) {
        return String.format(greetingProperties.getMessage(), name);
    }

}
