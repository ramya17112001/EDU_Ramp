package com.day13Practice;

import java.util.ArrayList;
import java.util.List;

class UsageRecord1{
    private String customerId;
    private String usageType; 
    private long timestamp;    
    private int duration;      

    public UsageRecord1(String customerId, String usageType, long timestamp, int duration) {
        this.customerId = customerId;
        this.usageType = usageType;
        this.timestamp = timestamp;
        this.duration = duration;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getUsageType() {
        return usageType;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Customer: " + customerId + ", Type: " + usageType + ", Time: " + timestamp + ", Duration: " + duration;
    }
}

public class TelecomDept {

    public static void bubbleSort(List<UsageRecord1> records) {
        int n = records.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                UsageRecord1 current = records.get(j);
                UsageRecord1 next = records.get(j + 1);
                if (current.getTimestamp() > next.getTimestamp() ||
                    (current.getTimestamp() == next.getTimestamp() &&
                     current.getCustomerId().compareTo(next.getCustomerId()) > 0)) {
                  
                    records.set(j, next);
                    records.set(j + 1, current);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<UsageRecord1> Record = new ArrayList<>(); 
        Record.add(new UsageRecord1("1", "call", 98544537645L, 180));
     Record.add(new UsageRecord1("3", "Message", 98544511210L, 0));
      Record.add(new UsageRecord1("2", "message", 7676400000L, 60));
       Record.add(new UsageRecord1("1", "data", 768321540L, 0));
        Record.add(new UsageRecord1("3", "call", 1687698705L, 120));

        System.out.println("Before Sorting:"); 
        for (UsageRecord1 r : Record) {
            System.out.println(r); 
        }
   
        bubbleSort(Record); 

        System.out.println("\nAfter Sorting:");
        for (UsageRecord1 r : Record) {
            System.out.println(r);
        }
    }
}