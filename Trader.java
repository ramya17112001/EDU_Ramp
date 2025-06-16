package com.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Trader extends Thread implements Tradeable {
    private int traderId;
    private String name;
    private Market market;
    private Map<String, Integer> portfolio = new HashMap<>();

    public Trader(int traderId, String name, Market market) {
        this.traderId = traderId;
        this.name = name;
        this.market = market;
    }

    @Override
    public void buyStock(String stockId, int quantity) {
        try {
            Stock stock = market.getStock(stockId);
            stock.decreaseShares(quantity);
            synchronized (portfolio) {
                portfolio.put(stockId, portfolio.getOrDefault(stockId, 0) + quantity);
            }
            System.out.println(name + " bought " + quantity + " shares of " + stock.getStockName());
        } catch (Exception e) {
            System.err.println(name + " failed to buy: " + e.getMessage());
        }
    }

    @Override
    public void sellStock(String stockId, int quantity) {
        try {
            Stock stock = market.getStock(stockId);
            synchronized (portfolio) {
                int owned = portfolio.getOrDefault(stockId, 0);
                if (owned < quantity) {
                    throw new InsufficientSharesExce("You don't own enough shares of " + stock.getStockName());
                }
                portfolio.put(stockId, owned - quantity);
            }
            stock.increaseShares(quantity);
            System.out.println(name + " sold " + quantity + " shares of " + stock.getStockName());
        } catch (Exception e) {
            System.err.println(name + " failed to sell: " + e.getMessage());
        }
    }

    public void displayPortfolio() {
        System.out.println("Portfolio of " + name + ":");
        if (portfolio.isEmpty()) {
            System.out.println("  No stocks.");
        } else {
            for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
                try {
                    Stock stock = market.getStock(entry.getKey());
                    System.out.println("  " + stock.getStockName() + ": " + entry.getValue() + " shares");
                } catch (StockNotFoundExce e) {
                    System.out.println("  Unknown stock: " + entry.getKey());
                }
            }
        }
    }

    @Override
    public void run() {
        String[] stockIds = market.getAllStocks().stream().map(Stock::getStockId).toArray(String[]::new);
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            String stockId = stockIds[rand.nextInt(stockIds.length)];
            int qty = rand.nextInt(5) + 1;
            if (rand.nextBoolean()) buyStock(stockId, qty);
            else sellStock(stockId, qty);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.err.println(name + " interrupted.");
            }
        }
    } 
 
 
}
