package com.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	import java.util.ArrayList;
	 
	public class NotificationManager {
		   private ArrayList<Notification> notifications;
	 
		   public NotificationManager() {
		       notifications = new ArrayList<>();
		   } 
	 
		   public void addNotification(String message) {
		       notifications.add(new Notification(message));
		       System.out.println(" Notification added.");
		   }
	 
		   public void viewNotifications() {
		       if (notifications.isEmpty()) {
		           System.out.println("️ No notifications.");
		       } else {
		           System.out.println(" All Notifications:");
		           for (int i = 0; i < notifications.size(); i++) {
		               System.out.println((i + 1) + ". " + notifications.get(i));
		           }
		       }
		   }
	 
		   public void removeNotification(int index) {
		       if (index >= 1 && index <= notifications.size()) {
		           notifications.remove(index - 1);
		           System.out.println(" Notification removed.");
		       } else {
		           System.out.println(" Invalid index.");
		       }
		   }
		}
	 
		
	 