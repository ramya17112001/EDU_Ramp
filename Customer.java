package com.day12;

public class Customer {
	 private String mobileNumber;
	    private double balance;

	    public Customer(String mobileNumber) {
	        this.mobileNumber = mobileNumber;
	        this.balance = 0.0;
	    }

	    public String getMobileNumber() {
	        return mobileNumber;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public void recharge(double amount) {
	        balance += amount;
	    }

	    public boolean makeCall(double cost) {
	        if (balance >= cost) {
	            balance -= cost;
	            return true;
	        }
	        return false;
	    }
	}


  
