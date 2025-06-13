package com.day4;
class BankAccount {
    int balance = 10000;
    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + "withdraw " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal.");
            System.out.println("Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " cannot withdraw " + amount);
            System.out.println("Insufficient funds. Balance left: " + balance);
        } 
    }   
}

public class ATMWithdrawalMultithreading extends Thread { 
    static BankAccount account;       
    int amount;

    ATMWithdrawalMultithreading(int amount) {
        this.amount = amount;
    }

    public void run() {
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        account = new BankAccount();

        ATMWithdrawalMultithreading user1 = new ATMWithdrawalMultithreading(7000);
        user1.setName("User 1");
        user1.start();

        ATMWithdrawalMultithreading user2 = new ATMWithdrawalMultithreading(4000);
        user2.setName("User 2");
        user2.start();

        ATMWithdrawalMultithreading user3 = new ATMWithdrawalMultithreading(3000);
        user3.setName("User 3");
        user3.start();
    }

  
}
