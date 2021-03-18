package com.mini.tradingapp.exchange;

import com.mini.tradingapp.util.Order;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * ExchangeOrderService interface will accept the order and process further.
 * it have three API methods acceptOrder,processOrder and matchingEngine.
 */
public interface ExchangeOrderService {
    void acceptOrder(Order order);

    void processOrder();

    void matchingEngine(ConcurrentHashMap<String, ConcurrentSkipListSet<Order>> ordersByStock);
}
