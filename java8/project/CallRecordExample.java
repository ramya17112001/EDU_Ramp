package com.java8.project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner; 
import java.util.stream.Collectors;

public class CallRecordExample {
	private static final List<CallRecord> records = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Telecom Customer Call Records Analyzer!");
        boolean exit = false;

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add call record");
            System.out.println("2. Show all records");
            System.out.println("3. Filter records by customer ID");
            System.out.println("4. Show top N longest calls");
            System.out.println("5. Show most frequent callers");
            System.out.println("6. Group records by operator");
            System.out.println("7. Group records by location");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addCallRecord();
                case 2 -> showAllRecords();
                case 3 -> filterByCustomerId();
                case 4 -> showTopLongestCalls();
                case 5 -> showMostFrequentCallers();
                case 6 -> groupByOperator();
                case 7 -> groupByLocation();
                case 0 -> exit = true;
                default -> System.out.println("Invalid choice! Try again.");
            }
        }

        System.out.println("Thank you for using the analyzer. Goodbye!");
    }

    private static void addCallRecord() {
        try {
            System.out.print("Enter Customer ID: ");
            String customerId = scanner.nextLine();

            System.out.print("Enter Operator: ");
            String operator = scanner.nextLine();

            System.out.print("Enter Location: ");
            String location = scanner.nextLine();

            System.out.print("Enter Call Start Time (yyyy-MM-ddTHH:mm:ss): ");
            LocalDateTime startTime = LocalDateTime.parse(scanner.nextLine());

            System.out.print("Enter Call End Time (yyyy-MM-ddTHH:mm:ss): ");
            LocalDateTime endTime = LocalDateTime.parse(scanner.nextLine());

            if (endTime.isBefore(startTime)) {
                System.out.println("End time cannot be before start time.");
                return;
            }

            CallRecord record = new CallRecord(customerId, operator, location, startTime, endTime);
            records.add(record);

            System.out.println("Call record added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Please follow the correct format.");
        }
    }

    private static void showAllRecords() {
        if (records.isEmpty()) {
            System.out.println("No records to show.");
            return;
        }
        records.forEach(System.out::println);
    }

    private static void filterByCustomerId() {
        System.out.print("Enter Customer ID to filter: ");
        String customerId = scanner.nextLine();

        List<CallRecord> filtered = records.stream()
                .filter(r -> r.getCustomerId().equalsIgnoreCase(customerId))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            System.out.println("No records found for Customer ID: " + customerId);
        } else {
            filtered.forEach(System.out::println);
        }
    }

    private static void showTopLongestCalls() {
        System.out.print("Enter number of top longest calls to show: ");
        int n = Integer.parseInt(scanner.nextLine());

        records.stream()
                .sorted(Comparator.comparingLong(CallRecord::getDurationSeconds).reversed())
                .limit(n)
                .forEach(System.out::println);
    }

    private static void showMostFrequentCallers() {
        Map<String, Long> freq = records.stream()
                .collect(Collectors.groupingBy(CallRecord::getCustomerId, Collectors.counting()));

        freq.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEach(entry -> System.out.println("CustomerID: " + entry.getKey() + ", Calls: " + entry.getValue()));
    }

    private static void groupByOperator() {
        Map<String, List<CallRecord>> grouped = records.stream()
                .collect(Collectors.groupingBy(CallRecord::getOperator));

        grouped.forEach((operator, recs) -> {
            System.out.println("\nOperator: " + operator);
            recs.forEach(System.out::println);
        });
    }

    private static void groupByLocation() {
        Map<String, List<CallRecord>> grouped = records.stream()
                .collect(Collectors.groupingBy(CallRecord::getLocation));

        grouped.forEach((location, recs) -> {
            System.out.println("\nLocation: " + location);
            recs.forEach(System.out::println);
        });
    }  
} 
