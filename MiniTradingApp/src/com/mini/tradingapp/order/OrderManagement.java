package com.mini.tradingapp.order;

import com.mini.tradingapp.util.Order;
import com.mini.tradingapp.util.OrderType;
import com.mini.tradingapp.util.Stock;

public interface OrderManagement {

    Order createOrder(double price, OrderType orderType, long qty, Stock stockID, String traderID);
    boolean cancel(Order order);
    boolean modify(Order order,double price, long qty);

}
