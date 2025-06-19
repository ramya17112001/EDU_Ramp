package com.day9;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Notification {
	private String message;
	   private LocalDateTime timestamp;
	 
	   public Notification(String message) {
	       this.message = message;
	       this.timestamp = LocalDateTime.now();
	   }
	 
	   public String getMessage() {
	       return message;
	   }
	 
	   public String getTimestamp() {
	       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	       return timestamp.format(formatter);
	   }
	 
	   @Override
	   public String toString() {
	       return "Notification: \"" + message + "\" at " + getTimestamp();
	   }
	}
 
