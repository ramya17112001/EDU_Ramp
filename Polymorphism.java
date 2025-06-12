package com.day3;
class Bank{
	String getBankName() {
		return "bank";
	}
	double getInterestRate() {
		return 100.0;
	}
}
	 class sbi extends Bank {
		 @Override
		 String getBankName() {
			 return "sbi bank";
			 
		 }
		 @Override
		 double getInterestRate (){
			 return 4.4;
		 }
	 }
		 class icici extends Bank {
			 @Override
			 String getBankName() {
				 return "icici bank";
				 
			 }
			 @Override
			 double getInterestRate(){
				 return 2.2;
			 }
	 
}
public class Polymorphism {
	public static  void main (String[] args) {
		Bank bank;
		bank=new sbi();
		System.out.println(bank.getBankName()+"Interest Rate."+bank.getInterestRate()+"%");
		bank=new icici();
		System.out.println(bank.getBankName()+"Interest Rate."+bank.getInterestRate()+"%");
		
	} 
} 
