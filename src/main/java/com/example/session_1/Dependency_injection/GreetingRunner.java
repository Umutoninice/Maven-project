package com.example.session_1.Dependency_injection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;

public class GreetingRunner implements CommandLineRunner {

    private final GreetingService greetingService;

    public GreetingRunner(@Qualifier("formalGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void run(String... args) {
        System.out.println(greetingService.greet("Nice"));
    }
}
