package com.example.session_1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GreetingPrinter implements CommandLineRunner {
    @Value("${greeting.message")
    private String greetingMessage;

    @Override
    public void run(String... args) {
        System.out.println(greetingMessage);

    }
}
