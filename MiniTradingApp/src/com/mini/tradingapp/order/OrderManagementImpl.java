package com.mini.tradingapp.order;

import com.mini.tradingapp.exchange.ExchangeOrderServiceImpl;
import com.mini.tradingapp.util.Order;
import com.mini.tradingapp.util.OrderType;
import com.mini.tradingapp.util.Stock;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * provides the api for order creation,modification and deletion by implementing the
 * OrderManagement interface.
 * */


public class OrderManagementImpl implements OrderManagement{

    private static final Logger logger=Logger.getLogger(OrderManagementImpl.class.getName());
    private final static OrderManagementImpl orderImpl=new OrderManagementImpl();

    private final static ExchangeOrderServiceImpl exchangeOrderService=ExchangeOrderServiceImpl.getInstance();

    private AtomicLong orderIDCounter=new AtomicLong(1);

   /**
    * Returns the object of OrderManagementImpl class
    * */
    public static OrderManagementImpl getInstance(){
        return orderImpl;
    }

    /**
     * private constructor to restrict the instantiation
     * */
    private OrderManagementImpl() {
    }

    /**
     * @param price stock ask/bid price
     * @param orderType Buy/sell order
     * @param qty quantity
     * @param stockID stockID
     * @param traderID traderID
     * @return returns the order
     * */
    @Override
    public Order createOrder(double price, OrderType orderType, long qty, Stock stockID, String traderID) {
        logger.log(Level.INFO,"Order request received");
        Order order= new Order(generateOrderID(),price,orderType,qty,stockID,traderID);
        logger.log(Level.INFO,"Order Generated placing with orderservice with ref order id:"+order.getOrderId());
        exchangeOrderService.acceptOrder(order);
        logger.log(Level.INFO,"Placed successfully");
        return order;
    }


    @Override
    public boolean cancel(Order order) {
        //TODO comment

        return false;
    }

    @Override
    public boolean modify(Order order,double price, long qty) {
        return false;
    }
    //TODO comment

    private boolean placeOrder(Order order) {
        return false;
    }
    /**
     * Generates unique order id*/
    private  long generateOrderID(){
        return orderIDCounter.getAndIncrement();
    }
}
