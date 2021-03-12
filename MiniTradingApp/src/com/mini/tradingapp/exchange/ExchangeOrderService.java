package com.mini.tradingapp.exchange;

import com.mini.tradingapp.util.Order;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public interface  ExchangeOrderService {
    void acceptOrder(Order order);
    void processOrder();
    void matchingEngine(ConcurrentHashMap<String, ConcurrentSkipListSet<Order>> ordersByStock);
}
