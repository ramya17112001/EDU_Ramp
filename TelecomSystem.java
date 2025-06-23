package com.day11;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TelecomSystem {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Using Set interface implementations
	        Set<String> customerNumbers = new HashSet<>();
	        Set<String> blockedSpamNumbers = new TreeSet<>();
	        Set<String> activeNetworkZones = new HashSet<>();

	        int choice;

	        do {
	            System.out.println("\n=== Telecom System Menu ===");
	            System.out.println("1. Add Customer Number");
	            System.out.println("2. Add Blocked Spam Number");
	            System.out.println("3. Add Active Network Zone");
	            System.out.println("4. View All Data");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice (1-5): ");
	            
	            while (!scanner.hasNextInt()) {
	                System.out.print("Invalid input. Enter a number between 1-5: ");
	                scanner.next();
	            }

	            choice = scanner.nextInt();
	            scanner.nextLine();  

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter customer number to add: ");
	                    String customer = scanner.nextLine();
	                    if (customerNumbers.add(customer)) {
	                        System.out.println("Customer number added.");
	                    } else {
	                        System.out.println("Customer number already exists.");
	                    }
	                    break;

	                case 2:
	                    System.out.print("Enter spam number to block: ");
	                    String spam = scanner.nextLine();
	                    if (blockedSpamNumbers.add(spam)) {
	                        System.out.println("Spam number blocked.");
	                    } else {
	                        System.out.println("Spam number already blocked.");
	                    }
	                    break;

	                case 3:
	                    System.out.print("Enter active network zone: ");
	                    String zone = scanner.nextLine();
	                    if (activeNetworkZones.add(zone)) {
	                        System.out.println("Network zone activated.");
	                    } else {
	                        System.out.println("Network zone already active.");
	                    }
	                    break;

	                case 4:
	                    System.out.println("\n--- Telecom Data Summary ---");
	                    System.out.println("Customer Numbers: " + customerNumbers);
	                    System.out.println("Blocked Spam Numbers (sorted): " + blockedSpamNumbers);
	                    System.out.println("Active Network Zones: " + activeNetworkZones);
	                    break;

	                case 5:
	                    System.out.println("Exiting the Telecom System. Goodbye!");
	                    break;

	                default:
	                    System.out.println("Invalid choice. Try again.");
	                    break;
	            }
	        } while (choice != 5);

	        scanner.close(); 
	    }
	}


