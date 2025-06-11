package com.day2;

import java.util.Scanner;

abstract class BankAccount{
	String accountHolder;
	String branchName;
	double balance;
	public BankAccount(String accountHolder, String branchName) {
		this.accountHolder=accountHolder;
		this.branchName=branchName;
		this.balance=1000.0;  
	}
	public void deposit(double amount) {    
		if(amount >0) {
			balance+=amount;
			System.out.println(+ amount +"deposit amount");
		}else {
			System.out.println("invalid deposit amount");	
		}
	}
	public abstract void withdraw(double amount);
	public void displayDetails() {
		System.out.println("\n account details");
		System.out.println("Account Holder:" +accountHolder);
		System.out.println(" Branch:"+branchName);
		System.out.println("Account Type:"+this.getClass().getSimpleName());
		System.out.println("current balance:" +balance);
		
	}
}
class SavingsAccount extends BankAccount{
	private final double interestRate = 0.04;
	public SavingsAccount(String accountHolder, String branchName) {
		super(accountHolder, branchName); 
	}
	public void addInterest() {
		double interest=balance*interestRate;
		balance +=interest;
		System.out.println(+interest+"interest add to savings account");
	}
	@Override
	public void withdraw(double amount) {
		if (amount <=balance) {
			balance-=amount;
			System.out.println(+amount+"withdraw savings acc");
		}else {
			System.out.println("insuffiient balance in savings acc");
		}
	}}
class CurrentAccount extends BankAccount{ 
	private final double overdraft=100.0;
	public CurrentAccount(String accountHolder, String branchName) {
		super(accountHolder, branchName);
	}
	@Override
	public void withdraw(double amount) {
		if (amount <=balance+overdraft) {
			balance-=amount;
			System.out.println(+amount+"withdraw from current acc");
		}else {
			System.out.println("withdrawal overdraft");
		}
}}
public class Bank {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("sbi bank");
		System.out.println("enter acc holder name:");
		String name=sc.nextLine();
		System.out.println("branch name(like sbi hyderabad, delhi):");
		String branch =sc.nextLine();
		System.out.println("select acc type:");
		System.out.println("1.savings acc");
		System.out.println("2.current acc");
		int choice=sc.nextInt();
		BankAccount account=null;
		if(choice==1) {
			account=new SavingsAccount(name,branch);
			System.out.println("saving acc created" +branch);
			
		}else if(choice==2) {
			account=new CurrentAccount(name,branch);
			System.out.println("current acc created" +branch);
			
		}
		while(true) {
			System.out.println("\n details:");
			System.out.println("1. deposit");

			System.out.println("2. withdraw");
			System.out.println("\n display details:");
			int option=sc.nextInt();
			
			switch(option) {
			case 1:
				System.out.println("enter amount to deposit:");
				double dep=sc.nextDouble();
				account.deposit(dep);
				break;
			case 2:
				System.out.println("enter amount to withdraw:");
				double withdraw=sc.nextDouble();
				account.withdraw(withdraw);
				break;
			case 3:
				account.displayDetails();
				if(account instanceof SavingsAccount) {
					((SavingsAccount)account).addInterest();
				}
		}
    

		}
		
	} 
}  
 