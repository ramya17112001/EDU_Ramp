package com.mini_project;

import java.util.List;
import java.util.Scanner;

public class TelecomSystem {

 public static void main(String[] args) {

	        CallManager manager = CallManager.getInstance();

	        Scanner scanner = new Scanner(System.in);

	         boolean running = true;    
	 
	        while (running) {

	            System.out.println("\n1. Add Customer\n2. Delete Customer\n3. Activate Plan\n4. Simulate Call\n5. View Call Logs\n6. Generate Bill\n7. List Customers\n8. Exit\nChoose an option: ");

	            int choice = scanner.nextInt();

	            scanner.nextLine(); // consume newline
	 
	            switch (choice) {

	                case 1:

	                    System.out.print("Enter ID: ");

	                    String id = scanner.nextLine();

	                    System.out.print("Enter Name: ");

	                    String name = scanner.nextLine();

	                    manager.addCustomer(new Customer(id, name));

	                    break;

	                case 2:

	                    System.out.print("Enter Customer ID to Delete: ");

	                    manager.removeCustomer(scanner.nextLine());

	                    break;

	                case 3:

	                    System.out.print("Enter Customer ID: ");

	                    String cid = scanner.nextLine();

	                    System.out.print("Enter Plan (PREPAID/POSTPAID): ");

	                    PlanType type = PlanType.valueOf(scanner.nextLine().toUpperCase());

	                    manager.activatePlan(cid, type);

	                    break;

	                case 4:

	                    System.out.print("Caller ID: ");

	                    String caller = scanner.nextLine();

	                    System.out.print("Receiver ID: ");

	                    String receiver = scanner.nextLine();

	                    System.out.print("Call duration in seconds: ");

	                    int seconds = scanner.nextInt();

	                    scanner.nextLine();

	                    Thread t = new Thread(() -> manager.simulateCall(caller, receiver, seconds));

	                    t.start();

	                    try { t.join(); } catch (InterruptedException e) { e.printStackTrace(); }

	                    break;

	                case 5:

	                    System.out.print("Enter Customer ID: ");

	                    String cust = scanner.nextLine();

	                    List<CallLog> logs = manager.getLogsForCustomer(cust);

	                    logs.forEach(System.out::println);

	                    break;

	                case 6:

	                    System.out.print("Enter Customer ID: ");

	                    manager.generateBill(scanner.nextLine());

	                    break;

	                case 7:

	                    manager.listAllCustomers();

	                    break;

	                case 8:

	                    running = false;

	                    break;

	                default:

	                    System.out.println("Invalid choice.");

	            }

	        }

	        scanner.close();

	    }

	}

	 

 