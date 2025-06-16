package com.project;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Market {
	
    private final Map<String, Stock> stocks = new HashMap<>();

    public void addStock(Stock stock) {
        stocks.put(stock.getStockId(), stock);
    }

    public synchronized Stock getStock(String stockId) throws StockNotFoundExce {
        Stock stock = stocks.get(stockId);
        if (stock == null) throw new StockNotFoundExce("Stock not found: " + stockId);
        return stock; 
    } 
 
    public Collection<Stock> getAllStocks() {
        return stocks.values();
    }
}


