package com.assignment;

import java.util.ArrayList;
import java.util.List;

public class Customer {
private int id;
private String name;
private List<Call> callHistory;
private List<String> subscribedVAS;
private List<Complaint> complaints;

public Customer(int id, String name) {
    this.id = id;
    this.name = name;
    this.callHistory = new ArrayList<>();
    this.subscribedVAS = new ArrayList<>();
    this.complaints = new ArrayList<>();
}

public int getId() {
    return id;
}

public void addCall(String phoneNumber, int duration) {
    callHistory.add(new Call(phoneNumber, duration));
}

public void subscribeVAS(String vas) {
    if (!subscribedVAS.contains(vas)) {
        subscribedVAS.add(vas);
        System.out.println(name + " subscribed to " + vas);
    } else {
        System.out.println(name + " is already subscribed to " + vas);
    }
} 

public void unsubscribeVAS(String vas) {
    if (subscribedVAS.remove(vas)) {
        System.out.println(name + " unsubscribed from " + vas);
    } else {
        System.out.println(name + " is not subscribed to " + vas);
    }
}

public void fileComplaint(String message) {
    complaints.add(new Complaint(message));
}

public void viewComplaints() {
    System.out.println("\nComplaints for " + name + ":");
    for (Complaint c : complaints) {
        System.out.println(c);
    } 
}

public void displaySummary() {
    System.out.println("\nCustomer ID: " + id + ", Name: " + name);
    System.out.println("Subscribed VAS: " + subscribedVAS);
    System.out.println("Call History:");
    for (Call call : callHistory) {
        System.out.println(call);
    }
    System.out.println("Total Complaints: " + complaints.size());
}
}
