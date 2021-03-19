package com.mini.tradingapp.dto;


/**
 * OrderStatus is enum represent the different order status.
 * OPEN
 * CANCEL
 * COMPLETED
 * PARTIALLY_COMPLETED
 */
public enum OrderStatus {
    OPEN(0), CANCEL(1), COMPLETED(2), PARTIALLY_COMPLETED(3);

    private final int status;

    OrderStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
