package com.mini.tradingapp;

import com.mini.tradingapp.exchange.ExchangeOrderService;
import com.mini.tradingapp.exchange.ExchangeOrderServiceImpl;
import com.mini.tradingapp.masterdata.TraderMasterData;
import com.mini.tradingapp.order.OrderManagement;
import com.mini.tradingapp.order.OrderManagementImpl;
import com.mini.tradingapp.trader.TraderRegistration;
import com.mini.tradingapp.trader.TraderRegistrationImpl;
import com.mini.tradingapp.util.OrderType;
import com.mini.tradingapp.util.Stock;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TradingApp {

    static Logger logger=Logger.getLogger(TradingApp.class.getName());
    static TraderRegistration traderRegistration=new TraderRegistrationImpl();//TraderRegistrationImpl.getInstance();
    static OrderManagement orderManagement=OrderManagementImpl.getInstance();
    static ExchangeOrderService exchangeOrderService=ExchangeOrderServiceImpl.getInstance();


    static {
        logger.log(Level.INFO,"Trader registration process started");
        traderRegistration.add("Santosh G","99999-99999","Hyderabad");
        traderRegistration.add("Pravesh J","99999-99999","Pune");
        traderRegistration.add("Rakha","99999-99999","Bangalore");

        traderRegistration.modify("Rekha G","88888-888888","Bangalore","103");
        TraderMasterData.getInstance().getAllTraders().forEach(e->logger.log(Level.INFO,e.toString()));
        orderManagement.createOrder(100, OrderType.BUY,100, Stock.INFOSYS,"101");
        orderManagement.createOrder(99, OrderType.BUY,100, Stock.INFOSYS,"101");
        orderManagement.createOrder(101, OrderType.BUY,90, Stock.INFOSYS,"101");
        orderManagement.createOrder(100, OrderType.SELL,100, Stock.INFOSYS,"101");
        orderManagement.createOrder(99, OrderType.SELL,20, Stock.INFOSYS,"101");
        orderManagement.createOrder(80, OrderType.BUY,100, Stock.INFOSYS,"101");
        orderManagement.createOrder(103, OrderType.SELL,100, Stock.INFOSYS,"101");
        orderManagement.createOrder(50, OrderType.BUY,100, Stock.INFOSYS,"101");
        orderManagement.createOrder(34, OrderType.BUY,100, Stock.INFOSYS,"101");
        orderManagement.createOrder(99, OrderType.BUY,100, Stock.INFOSYS,"101");




        logger.log(Level.INFO,"Trader registration process Ended");
    }
    public static void main(String[] args) throws InterruptedException {
        logger.log(Level.INFO,"Application Started.....");
        Thread.sleep(10_000);
        exchangeOrderService.processOrder();
        logger.log(Level.INFO,"Application Ended.....");
    }
}
