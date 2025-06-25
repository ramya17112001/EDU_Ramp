package com.day12;

import java.util.HashMap;
import java.util.Map;

public class TelecomService {
	Map<String, Customer> customerMap = new HashMap();

	public void addCustomer(String mobileNumber) {
		customerMap.putIfAbsent(mobileNumber, new Customer(mobileNumber));
		System.out.println("Customer added: " + mobileNumber);
	}

	public void recharge(String mobileNumber, double amount) {
		Customer customer = customerMap.get(mobileNumber);
		if (customer != null) {
			customer.recharge(amount);
			System.out.println("Recharged Rs." + amount + " for " + mobileNumber);
		} else {
			System.out.println("Customer not found.");
		}
	}

	public void makeCall(String mobileNumber, double cost) {
		Customer customer = customerMap.get(mobileNumber);
		if (customer != null) {
			if (customer.makeCall(cost)) {
				System.out.println("Call successful. Rs " + cost + " deducted.");
			} else {
				System.out.println("Insufficient balance.");
			}
		} else {
			System.out.println("Customer not found.");
		}
	}

	public void showAllBalances() {
		System.out.println("\n--- Customer Balances ---");
		for (Customer c : customerMap.values()) {
			System.out.println("Mobile: " + c.getMobileNumber() + "  Balance: Rs." + c.getBalance());
		}
	}
}


