package com.day18;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class RechargePlan {
    private int id;
    private String name;
    private double price;
    private String validity;
    private String benefits; 

    public RechargePlan(int id, String name, double price, String validity, String benefits) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.validity = validity;
        this.benefits = benefits;
    }
    public int getId() { 
    	return id; 
    	}
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getValidity() { return validity; }
    public String getBenefits() { return benefits; }

    @Override
    public String toString() {
        return String.format("Plan ID: %d | Name: %s | Price: ₹%.2f | Validity: %s | Benefits: %s",
                             id, name, price, validity, benefits);
    }
}

public class TelecomRecharge {
	 private static List<RechargePlan> getAllPlans() {
	        return Arrays.asList(
	            new RechargePlan(1, "Basic Plan", 149, "28 Days", "1GB/day, 100 SMS/day, Unlimited Calls"),
	            new RechargePlan(2, "Value Plan", 249, "28 Days", "2GB/day, 100 SMS/day, Unlimited Calls"),
	            new RechargePlan(3, "Super Plan", 399, "56 Days", "2GB/day, 100 SMS/day, Unlimited Calls"),
	            new RechargePlan(4, "Mega Plan", 599, "84 Days", "3GB/day, 100 SMS/day, Unlimited Calls")
	        ); 
	    }
	 private static void showAllPlans(List<RechargePlan> plans) {
	        System.out.println("Available Recharge Plans:");
	        plans.forEach(System.out::println);
	    }

	    // Choose a plan by ID using Optional and filter
	    private static Optional<RechargePlan> choosePlanById(List<RechargePlan> plans, int id) {
	        return plans.stream()
	                    .filter(plan -> plan.getId() == id)
	                    .findFirst();
	    }
	    public static void main(String[] args) {
	        List<RechargePlan> plans = getAllPlans();
	        showAllPlans(plans);

	        Scanner scanner = new Scanner(System.in);
	        System.out.print("\nEnter Plan ID to select your recharge plan: ");
	        int selectedId = scanner.nextInt();

	        Optional<RechargePlan> selectedPlan = choosePlanById(plans, selectedId);

	        selectedPlan.ifPresentOrElse(
	            plan -> System.out.println("You have selected: " + plan),
	            () -> System.out.println(" Invalid Plan ID. Please try again.")
	        );
	        scanner.close(); 
	    } 
	}
    

