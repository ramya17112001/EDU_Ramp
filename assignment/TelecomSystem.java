package com.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TelecomSystem {
	private static Map<Integer, Customer> customerMap = new HashMap<>();
    private static int customerIdCounter = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nTelecom Management System");
            System.out.println("1. Add New Customer");
            System.out.println("2. Record Call");
            System.out.println("3. Subscribe to VAS");
            System.out.println("4. Unsubscribe from VAS");
            System.out.println("5. File Complaint");
            System.out.println("6. View Complaints");
            System.out.println("7. Display All Customer Summaries");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    Customer newCustomer = new Customer(customerIdCounter, name);
                    customerMap.put(customerIdCounter, newCustomer);
                    System.out.println("Customer added with ID: " + customerIdCounter);
                    customerIdCounter++;
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    int callId = scanner.nextInt();
                    scanner.nextLine();
                    Customer caller = customerMap.get(callId);
                    if (caller != null) {
                        System.out.print("Enter phone number called: ");
                        String phone = scanner.nextLine();
                        System.out.print("Enter duration in seconds: ");
                        int duration = scanner.nextInt();
                        caller.addCall(phone, duration);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int sid = scanner.nextInt();
                    scanner.nextLine();
                    Customer subCustomer = customerMap.get(sid);
                    if (subCustomer != null) {
                        System.out.print("Enter VAS name to subscribe: ");
                        String vas = scanner.nextLine();
                        subCustomer.subscribeVAS(vas);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    int usid = scanner.nextInt();
                    scanner.nextLine();
                    Customer unsubCustomer = customerMap.get(usid);
                    if (unsubCustomer != null) {
                        System.out.print("Enter VAS name to unsubscribe: ");
                        String vas = scanner.nextLine();
                        unsubCustomer.unsubscribeVAS(vas);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    int cid = scanner.nextInt();
                    scanner.nextLine();
                    Customer complaintCustomer = customerMap.get(cid);
                    if (complaintCustomer != null) {
                        System.out.print("Enter complaint message: ");
                        String complaint = scanner.nextLine();
                        complaintCustomer.fileComplaint(complaint);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter Customer ID: ");
                    int compId = scanner.nextInt();
                    scanner.nextLine();
                    Customer viewCustomer = customerMap.get(compId);
                    if (viewCustomer != null) {
                        viewCustomer.viewComplaints();
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 7:
                    for (Customer c : customerMap.values()) {
                        c.displaySummary();
                    }
                    break;

                case 8:
                    running = false; 
                    break;

                default:
                    System.out.println("Invalid option.");
            } 
        }

        scanner.close();
        System.out.println("System exited."); 
    } 

}
