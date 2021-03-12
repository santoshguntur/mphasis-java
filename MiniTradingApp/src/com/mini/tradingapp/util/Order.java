package com.mini.tradingapp.util;

import java.util.Date;

public class Order implements Cloneable{

    private Long orderId;
    private double price;
    private OrderType orderType;
    private Long qty;
    private Stock stockID;
    private Date creationDate=new Date();
    private OrderStatus orderStatus;
    private String traderCode;

    public Order(Long orderId, double price, OrderType orderType, Long qty, Stock stockID,String traderCode) {
        this.orderId = orderId;
        this.price = price;
        this.orderType = orderType;
        this.qty = qty;
        this.stockID = stockID;
        this.traderCode=traderCode;
        this.traderCode=traderCode;
        this.orderStatus=OrderStatus.OPEN;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public void setStockID(Stock stockID) {
        this.stockID = stockID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Stock getStockID() {
        return stockID;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTraderCode() {
        return traderCode;
    }

    public void setTraderCode(String traderCode) {
        this.traderCode = traderCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", price=" + price +
                ", orderType=" + orderType +
                ", qty=" + qty +
                ", stockID=" + stockID +
                ", creationDate=" + creationDate +
                ", orderStatus=" + orderStatus +
                ", traderCode='" + traderCode + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
