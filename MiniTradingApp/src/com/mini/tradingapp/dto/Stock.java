package com.mini.tradingapp.dto;

/**
 * Class holds all the stock details.
 */
public class Stock {

    /**
     * unique for each stock
     */
    private final int stockCode;
    private final String stockName;
    /**
     * unique for each stock
     */
    private final String stockTickerCode;

    public Stock(int stockCode, String stockName, String stockTickerCode) {
        this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockTickerCode = stockTickerCode;
    }

    public int getStockCode() {
        return stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public String getStockTickerCode() {
        return stockTickerCode;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockCode=" + stockCode +
                ", stockName='" + stockName + '\'' +
                ", stockTickerCode='" + stockTickerCode + '\'' +
                '}';
    }
}
