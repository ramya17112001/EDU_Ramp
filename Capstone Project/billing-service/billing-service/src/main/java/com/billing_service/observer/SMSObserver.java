package com.billing_service.observer;

import org.springframework.stereotype.Component;

@Component 
public class SMSObserver  implements NotificationObserver {
    @Override
    public void notify(Long userId, String message) {
        // Simulate sending an SMS
        System.out.println("[SMS]: Sent to user " + userId + ": " + message);
    }  
 
}
