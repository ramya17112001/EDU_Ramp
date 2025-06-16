package com.project;

import java.util.*;

public class Stock {
	private String stockId;
    private String stockName;
    private double pricePerShare;
    private int availableShares;

    public Stock(String stockId, String stockName, double pricePerShare, int availableShares) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.pricePerShare = pricePerShare;
        this.availableShares = availableShares;
    }

    public String getStockId() {
        return stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    public synchronized int getAvailableShares() {
        return availableShares;
    }

    public synchronized void decreaseShares(int quantity) throws InsufficientMarketSharesExce {
        if (quantity > availableShares) {
            throw new InsufficientMarketSharesExce("Not enough shares available for: " + stockName);
        }
        availableShares -= quantity;
    }
 
    public synchronized void increaseShares(int quantity) {
        availableShares += quantity;
    } 

    @Override
    public String toString() {
        return stockName + " (₹" + pricePerShare + ", Shares: " + availableShares + ")";
    }
}


