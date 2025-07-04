package com.day15;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ECommercePlatform {
	
	private EmailService emailService;
    private Map<String, User> userDatabase;
 
    public ECommercePlatform() { 
        this.emailService = new EmailService();
        this.userDatabase = new HashMap<>();
    }
 
   
    public void registerUser(String emailInput) {
        try {
         
            String formattedEmail = emailService.validateAndFormatEmail(emailInput);
 
           
            if (userDatabase.containsKey(formattedEmail)) {
                throw new UserAlreadyExistsException("Email is already registered: " + formattedEmail);
            }
            User newUser = new User(formattedEmail);  
            userDatabase.put(formattedEmail, newUser);
 
  
          
            System.out.println("Formatted Email: " + formattedEmail);
            System.out.println("User registered successfully!");
 
        } catch (IllegalArgumentException e) {
            System.out.println("Validation Error: " + e.getMessage());
        } catch (UserAlreadyExistsException e) {
            System.out.println("Duplicate Email: " + e.getMessage());
        }
    }
 
   
    public void showAllUsers() {
        if (userDatabase.isEmpty()) {
            System.out.println("📭 No users registered.");
        } else {
        	System.out.println("\n📋 Registered Emails:");
            for (User user : userDatabase.values()) {
                System.out.println("- " + user.getEmail());
            }
        }
    }
 
   
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("------------ E-Commerce Email Registration -------------");
 
        while (true) {
            System.out.print("\nEnter email to register (or type 'exit'): ");
            String input = scanner.nextLine();
 
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
 
            platform.registerUser(input);
        }
 
        platform.showAllUsers();
        System.out.println("Thank you !");
        scanner.close();
    }

        }

