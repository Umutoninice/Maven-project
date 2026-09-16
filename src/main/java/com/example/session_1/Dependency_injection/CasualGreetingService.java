package com.example.session_1.Dependency_injection;

import org.springframework.stereotype.Service;

@Service("CasualGreetingService")
public class CasualGreetingService implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello " + name + " ! what's up?";
    }
}
