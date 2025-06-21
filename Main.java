package com.day9;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	       NotificationManager manager = new NotificationManager();
	       Scanner scanner = new Scanner(System.in);
	       int choice;  

	       do {
	           System.out.println("\n--- Notification Manager ---");
	           System.out.println("1. Add Notification");
	           System.out.println("2. View Notifications");
	           System.out.println("3. Remove Notification");
	           System.out.println("4. Exit");
	           System.out.print("Enter choice: ");
	           while (!scanner.hasNextInt()) {
	               System.out.print("Please enter a valid number: ");
	               scanner.next();
	           }
	           choice = scanner.nextInt();
	           scanner.nextLine();

	           switch (choice) {
	               case 1:
	                   System.out.print("Enter notification message: ");
	                   String message = scanner.nextLine();
	                   manager.addNotification(message);
	                   break;
	               case 2:
	                   manager.viewNotifications();
	                   break;
	               case 3:
	                   System.out.print("Enter notification index to remove: ");
	                   while (!scanner.hasNextInt()) {
	                       System.out.print("Please enter a valid number: ");
	                       scanner.next();
	                   }
	                   int index = scanner.nextInt();
	                   manager.removeNotification(index);
	                   break;
	               case 4:
	                   System.out.println(" Exiting...");
	                   break;
	               default:
	                   System.out.println(" Invalid choice.");
	           }

	       } while (choice != 4);

	       scanner.close();
	   }
	}







