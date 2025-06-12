package com.day3;

import java.util.Scanner;

abstract class BankAccount1 {
	private static int accountNumber=1000;
	private String accountHolderName;
	private String mobileNumber;
	protected double balance;
	
	public BankAccount1(String accountHolderName, String mobileNumber, double initialDeposit) {
		this.accountNumber = ++accountNumber;
 		this.accountHolderName=accountHolderName;
		this.mobileNumber=mobileNumber;
	   	this.balance=initialDeposit; 
	}
	public abstract boolean validate();
	public abstract double calculateInterest(int years);
	public abstract boolean withdraw(double amount);
	public void displayAccountDetails() {
		System.out.println("acc details");
		System.out.println("Acc number:"+accountNumber);
		System.out.println("holder name:"+accountHolderName);
		System.out.println("mobile nbr:"+mobileNumber);
		System.out.println("balance:"+balance);
	}
	public int getAccountNumber() {
		return accountNumber;
	}   
	public double getBalance() { 
		return balance;
	} 
	
}
class SavingsAccount extends BankAccount1 { 
	private static final double MIN_DEPOSIT=1000;
	private static final double INTEREST_RATE=0.04;
	private int withdrawals;

public SavingsAccount(String name, String mobile, double deposit) {
	super(name,mobile, deposit);
	this.withdrawals=0;
}
@Override
public boolean validate() {
	return balance >=MIN_DEPOSIT;
}

@Override
public double calculateInterest(int years) {
	return balance*INTEREST_RATE*years;
}
@Override
public boolean withdraw(double amount) {
	if (withdrawals >=3) {
		System.out.println("withdraw limit exceed");
		return false;
	}
	if (amount <=balance) {
		balance-=amount;
		withdrawals++;
		System.out.println("withdrawal of"+amount+"success.");
		return true;
 	}else {
		System.out.println("insu amount.");
		return false;
	}
}
}
class CurrentAccount extends BankAccount1 {
	private static final double MIN_DEPOSIT=5000;
	private static final double MIN_BALANCE=2000;
	private static final double PENALTY=500;


public CurrentAccount(String name, String mobile, double deposit) {
	super(name,mobile, deposit);
	
}
@Override
public boolean validate() {
	return balance >=MIN_DEPOSIT;
}

@Override
public double calculateInterest(int years) {
	return 0;
}
@Override
public boolean withdraw(double amount) {

	if (amount <=balance) {
		balance-=amount;
		if(balance < MIN_BALANCE) {
			System.out.println("mini blnc 500 penalty applied");
			balance-=PENALTY;
			
		}
		
		System.out.println("withdrawal of"+amount+"success.");
		return true;
 	}else {
		System.out.println("insu amount.");
		return false;
	}
} 
} 

public class BankAccount {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("national bank==");
		System.out.println("enter acc type (savings/current):==");
		String type=sc.nextLine().trim().toLowerCase();
		System.out.println("enter acc holder name):==");
		String name=sc.nextLine();
		System.out.println("enter mbl nbr):==");
		String mobile=sc.nextLine();
		if(!mobile.matches("\\d{10}")){
			System.out.println("invalid mbl nbr");
			return;
		}
	   System.out.println("initial deposit:");
	   double deposit;
	   try {
		   deposit=Double.parseDouble(sc.nextLine());
	   }catch (NumberFormatException e) {
		   System.out.println("invalid deposit");
		   return;
	   }
	 	BankAccount1 account=null;
		
		switch(type) {
		case "savings":
			account=new SavingsAccount(name, mobile, deposit);
			break; 
		case "current":
			account=new CurrentAccount(name,mobile,deposit);
			break;
			 
		default:
			System.out.println("invalid acc");
			return;
		}
		if(type.equals("savings")) {
			account=new SavingsAccount(name, mobile, deposit);

		}else if (type.equals("current")) {

			account=new CurrentAccount(name,mobile,deposit);
		} else {
			System.out.println("invalid acc:");
			return;
		}  
			
		
//		if(!account.validate()) {
//			System.out.println("acc creation failed due to mnm blc");
//			return;
//		} 
		System.out.println("acc created"); 
		account.displayAccountDetails(); 
		if(account instanceof SavingsAccount) {
			double interest=account.calculateInterest(1);
			System.out.println("interest of 2 yrs:"+interest);
			
		}     
		System.out.println("\n do u want withdraw?(yes/no):");
		String withdrawChoice=sc.nextLine().trim().toLowerCase();
		if (withdrawChoice.equals("yes")) {
			System.out.println("enter withdraw:");
			double amt=sc.nextDouble();
			account.withdraw(amt);
			account.displayAccountDetails();
		}
	//	sc.close();   
		}
}  
  

