package com.mini.tradingapp.util;

public enum Stock {
    RELIANCE(1,"RELIANCE","RILI"),
    YESBANK(2,"YES BANK","YESB"),
    MAJESCO(3,"MAJESCO","MAJS"),
    INFOSYS(4,"INFOSYS","INFY");


    private final int stockCode;
    private final String stockName;
    private final String stockTickerCode;

    Stock(int stockCode, String stockName, String stockTickerCode) {
        this.stockCode=stockCode;
        this.stockName=stockName;
        this.stockTickerCode=stockTickerCode;
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
}
