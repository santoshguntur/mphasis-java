package com.mini.tradingapp.order;

import com.mini.tradingapp.exchange.ExchangeOrderService;
import com.mini.tradingapp.exchange.ExchangeOrderServiceImpl;
import com.mini.tradingapp.util.Order;
import com.mini.tradingapp.util.OrderType;
import com.mini.tradingapp.util.Stock;
import com.mini.tradingapp.util.Trader;

import java.util.concurrent.atomic.AtomicLong;

public class OrderManagementImpl implements OrderManagement{
    final static OrderManagementImpl orderImpl=new OrderManagementImpl();

    final static ExchangeOrderServiceImpl exchangeOrderService=ExchangeOrderServiceImpl.getInstance();

    private AtomicLong orderIDCounter=new AtomicLong(1);

    public static OrderManagementImpl getInstance(){
        return orderImpl;
    }

    private OrderManagementImpl() {
    }

    @Override
    public Order createOrder(double price, OrderType orderType, long qty, Stock stockID, String traderID) {

        Order order= new Order(generateOrderID(),price,orderType,qty,stockID,traderID);
        exchangeOrderService.acceptOrder(order);
        return order;
    }

    @Override
    public boolean cancel(Order order) {


        return false;
    }

    @Override
    public boolean modify(Order order,double price, long qty) {
        return false;
    }


    private boolean placeOrder(Order order) {
        return false;
    }

    private  long generateOrderID(){
        return orderIDCounter.getAndIncrement();
    }
}
