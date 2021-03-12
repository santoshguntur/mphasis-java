package com.mini.tradingapp.util;

public enum OrderType {
    BUY(0,"BUY"),SELL(1,"SELL");

    private final int typeValue;
    private final String type;

    OrderType(int i,String type) {
        this.typeValue=i;
        this.type=type;
    }

    public int getTypeValue() {
        return typeValue;
    }

    public String getType() {
        return type;
    }
}
