package com.project;

public class Main {

	    public static void main(String[] args) {
	        Market market = new Market();
            market.addStock(new Stock("S1", "TCS", 3200.0,100));
	        market.addStock(new Stock("S2", "Infosys", 1450.0, 150));
	        market.addStock(new Stock("S3", "Infovision", 2500.0, 120));

	        Trader t1 = new Trader(1, "ram", market);
	        Trader t2 = new Trader(2, "ravi", market);
	        Trader t3 = new Trader(3, "venkat", market);
 
	        t1.start();  
	        t2.start();
	        t3.start(); 

	        try {
	            t1.join();
	            t2.join();
	            t3.join();
	        } catch (InterruptedException e) {
	            System.err.println("Main thread interrupted.");
	        }

	        System.out.println("\n--- Final Portfolio Summary ---");
	        t1.displayPortfolio();
	        t2.displayPortfolio();
	        t3.displayPortfolio();

	        System.out.println("\n--- Remaining Stocks in Market ---");
	        for (Stock stock : market.getAllStocks()) {
	            System.out.println(stock);
	        }
	    }   
	}    
 

