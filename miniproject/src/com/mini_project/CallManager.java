package com.mini_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CallManager {
	private static final CallManager instance = new CallManager();
    private final Map<String, Customer> customers = new HashMap<>();
    private final Map<Customer, List<CallLog>> callLogs = new HashMap<>();
 
    private CallManager() {}
 
    public static CallManager getInstance() {
        return instance;
    }
 
    public void addCustomer(Customer c) {
        customers.put(c.getId(), c);
        callLogs.put(c, new ArrayList<>());
    }
 
    public void removeCustomer(String id) {
        Customer c = customers.remove(id);
        if (c != null) callLogs.remove(c);
    }
 
    public void updateCustomer(String id, String newName) {
        Customer c = customers.get(id);
        if (c != null) {
            customers.put(id, new Customer(id, newName));
        }
    }
 
    public void activatePlan(String id, PlanType type) {
        Customer c = customers.get(id);
        if (c != null) {
            c.setPlan(PlanFactory.getPlan(type));
        }
    }
 
    public void simulateCall(String callerId, String receiverId, int seconds) {
        Customer caller = customers.get(callerId);
        Customer receiver = customers.get(receiverId);
        if (caller == null || receiver == null) return;
 
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
 
        CallLog log = new CallLog(callerId, receiverId, start, end);
        callLogs.get(caller).add(log);
    }
 
    public List<CallLog> getLogsForCustomer(String customerId) {
        Customer c = customers.get(customerId);
        return callLogs.getOrDefault(c, Collections.emptyList());
    }
 
    public void generateBill(String customerId) {
        Customer c = customers.get(customerId);
        if (c == null || c.getPlan() == null) {
            System.out.println("Customer or plan not found.");
            return;
        }
        List<CallLog> logs = callLogs.get(c);
        double total = 0;
        for (CallLog log : logs) {
            total += log.getDurationInMinutes() * c.getPlan().getRatePerMinute();
        }
        System.out.println("Bill for " + c.getName() + ": Rs. " + total);
    }
 
    public void listAllCustomers() {
        for (Customer c : customers.values()) {
            System.out.println("ID: " + c.getId() + ", Name: " + c.getName());
        }
    }
 

}
