package com.billing_service.observer;

import org.springframework.stereotype.Component;

@Component 
public class EmailObserver implements NotificationObserver {
    @Override
    public void notify(Long userId, String message) {
        // Simulate sending an email
        System.out.println("[EMAIL]: Sent to user " + userId + ": " + message);
    }  

}
 