package com.day5;

import java.util.Scanner;

class TelecomSystem {
	
    private boolean isBillGenerated = false;
    private String customerName;
    private int callDuration;
    private double billAmount;
 
    public void setCustomerInfo(String name, int duration) {
        this.customerName = name;
        this.callDuration = duration;
    }  
  
   
    public synchronized void generateBill() { 
        System.out.println("\nGenerating bill for " + customerName + "...");
        billAmount = callDuration * 1.2;  
        try {
            Thread.sleep(1000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isBillGenerated = true;
        System.out.println("Bill generated: ₹" + billAmount);
        notify();  
    }
 
    
    public synchronized void processPayment() {
        if (!isBillGenerated) {
            System.out.println("\nWaiting for bill to be generated...");
            try {
                wait();  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Processing payment of ₹" + billAmount + " for " + customerName + "...");
        try {
            Thread.sleep(2000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Payment successful!");
    }
}

class BillThread extends Thread { 
    TelecomSystem telecom;
    public BillThread(TelecomSystem telecom) {    
        this.telecom = telecom; 
    }
 
    public void run() {
        telecom.generateBill();
    }
} 
 

class PaymentThread extends Thread { 
    TelecomSystem telecom;
    public PaymentThread(TelecomSystem telecom) {
        this.telecom = telecom;
    }
 
    public void run() {
        telecom.processPayment();
    } 
}
 
public class TelecomBillingSystem {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        TelecomSystem telecom = new TelecomSystem();
 
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
  
        System.out.print("Enter call duration (in minutes): ");
        int duration = scanner.nextInt();
 
        telecom.setCustomerInfo(name, duration);
 
        BillThread billThread = new BillThread(telecom);
        PaymentThread paymentThread = new PaymentThread(telecom);

        paymentThread.start(); 
        Thread.sleep(400);     
        billThread.start();    
     
        billThread.join();
        paymentThread.join();
 
        System.out.println(" Transaction Completed ---");
    }
} 
 