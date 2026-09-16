package com.example.session_1.BeanWiring;

import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{
    @Override
    public void notify(String message) {
        System.out.println("Notification sent: " + message);
    }
}
