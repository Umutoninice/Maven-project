package com.example.session_1.Dependency_injection;

import org.springframework.stereotype.Service;

@Service("FormalGreetingService")
public class FormalGreetingService implements GreetingService {
    @Override
    public String greet(String name) {
        return "Good day, " + name + " . It's a pleasure to meet you!";
    }
}
