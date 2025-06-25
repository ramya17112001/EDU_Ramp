package com.day12;

import java.util.Scanner;

public class MainMethod {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TelecomService service = new TelecomService();

         while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Recharge Account");
            System.out.println("3. Make a Call");
            System.out.println("4. Show All Balances");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter mobile number: ");
                    service.addCustomer(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter mobile number: ");
                    String rechargeNum = scanner.nextLine();
                    System.out.print("Enter amount: Rs");
                    double amount = Double.parseDouble(scanner.nextLine());
                    service.recharge(rechargeNum, amount);
                    break;
                case 3:
                    System.out.print("Enter mobile number: ");
                    String callNum = scanner.nextLine();
                    System.out.print("Enter call cost: Rs.");
                    double cost = Double.parseDouble(scanner.nextLine());
                    service.makeCall(callNum, cost);
                    break;
                case 4:
                    service.showAllBalances();
                    break;
                case 5:
                    System.out.println("Exiting");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
