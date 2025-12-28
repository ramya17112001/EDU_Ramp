package TelecomProject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainMethod {
	public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Customer> customers = new HashMap<>();
        CallManager callManager = CallManager.getInstance();
        BillingEngine billingEngine = BillingEngine.getInstance();

        billingEngine.addObserver(msg -> System.out.println("[NOTIFICATION] " + msg));

        System.out.println("==== Telecom Call Management System ====");

        while (true) {
            System.out.println("\n1. Register Customer");
            System.out.println("2. Activate Plan");
            System.out.println("3. Make Call");
            System.out.println("4. View Call Logs");
            System.out.println("5. Generate Bills");
            System.out.println("6. Exit");
            System.out.print("Select option: ");
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    customers.put(id, new Customer(id, name));
                    System.out.println("[INFO] Customer registered.");
                    break;

                case 2:
                    System.out.print("Enter customer ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    Customer cust = customers.get(id);
                    if (cust == null) {
                        System.out.println("[ERROR] Customer not found.");
                        break;
                    }
                    System.out.print("Enter plan type (Prepaid/Postpaid): ");
                    String type = sc.nextLine();
                    try {
                        cust.setPlan(PlanFactory.getPlan(type));
                        System.out.println("[INFO] Plan activated: " + cust.getPlan().getType());
                    } catch (IllegalArgumentException e) {
                        System.out.println("[ERROR] Invalid plan type.");
                    }
                    break;

                case 3:
                    System.out.print("Enter caller ID: ");
                    int callerId = sc.nextInt();
                    System.out.print("Enter receiver ID: ");
                    int receiverId = sc.nextInt();
                    System.out.print("Enter call duration in minutes: ");
                    int duration = sc.nextInt();

                    Customer caller = customers.get(callerId);
                    Customer receiver = customers.get(receiverId);

                    if (caller == null || receiver == null || caller.getPlan() == null) {
                        System.out.println("[ERROR] Caller/receiver invalid or plan not activated.");
                        break;
                    }

                    callManager.simulateCall(caller, receiver, duration);
                    System.out.println("[INFO] Call started.");
                    break;

                case 4:
                    System.out.print("Enter customer ID: ");
                    id = sc.nextInt();
                    cust = customers.get(id);
                    if (cust == null) {
                        System.out.println("[ERROR] Customer not found.");
                        break;
                    }
                    List<CallLog> logs = callManager.getLogs(cust);
                    System.out.println("Call logs for " + cust.getName() + ":");
                    for (CallLog log : logs) System.out.println(log);
                    break;

                case 5:
                    System.out.println("[INFO] Generating all bills...");
                    Thread.sleep(2000);
                    billingEngine.generateBills(callManager.getAllLogs());
                    break;

                case 6:
                    System.out.println("Exiting system.");
                     sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
	}}