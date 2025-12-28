package com.billing_service.observer;

public interface NotificationObserver {
	void notify(Long userId, String message);
}
 