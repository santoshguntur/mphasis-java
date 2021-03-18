package com.mini.tradingapp.exchange;

import com.mini.tradingapp.util.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ExchangeOrderServiceImpl class implements the ExchangeOrderService.
 */
public class ExchangeOrderServiceImpl implements ExchangeOrderService {

    static final Logger logger = Logger.getLogger(ExchangeOrderServiceImpl.class.getName());
    static final ExchangeOrderServiceImpl exchangeOrderService = new ExchangeOrderServiceImpl();
    /**
     * allOrdersList will holds all the orders.
     */
    ArrayList<Order> allOrdersList = new ArrayList<>();
    /**
     * <b>allOrdersBYStock</b> datastructure store the order on below format.
     * <table>
     *   <col width="25%"/>
     *   <col width="75%"/>
     *   <thead>
     *     <tr><th>StockID</th><th>OrderType</th><th>OrdersList</th></tr>
     *   <thead>
     *   <tbody>
     *      <tr><td>STOCK1</td><td>BUY</td><td>BuyOrdersList</td></tr>
     *      <tr><td></td><td>SELL</td><td>SellOrdersList</td></tr>
     *       <tr><td>STOCK2</td><td>BUY</td><td>BuyOrdersList</td></tr>
     *       <tr><td></td><td>SELL</td><td>SellOrdersList</td></tr>
     *
     *   </tbody>
     */
    HashMap<String, ConcurrentHashMap<String, ConcurrentSkipListSet<Order>>> allOrdersBYStock = new HashMap<>();
    /**
     * <b>executedOrderedList</b> is used to store the processed orders,
     */
    ArrayList<ArrayList<Order>> executedOrderedList = new ArrayList<>();


    private ExchangeOrderServiceImpl() {
    }

    public static ExchangeOrderServiceImpl getInstance() {
        return exchangeOrderService;
    }

    /**
     * <b>acceptOrder</b> method inserts the data into collection.
     *
     * @param order order object should all the required information.
     */

    @Override
    public void acceptOrder(Order order) {

        try {
            //Adding order to the All orders list
            allOrdersList.add(order);


            //Checking existing map is available or not
            if (allOrdersBYStock.get(order.getStockID().getStockName()) == null) {

                ConcurrentHashMap<String, ConcurrentSkipListSet<Order>> stockBuySellMap = new ConcurrentHashMap<>();
                stockBuySellMap.put(OrderType.SELL.getType(), new ConcurrentSkipListSet<>(new SellOrderComparator()));
                stockBuySellMap.put(OrderType.BUY.getType(), new ConcurrentSkipListSet<>(new BuyOrderComparator()));

                allOrdersBYStock.put(order.getStockID().getStockName(), stockBuySellMap);
            }


            //Adding order to the list
            synchronized (allOrdersBYStock.get(order.getStockID().getStockName())
                    .get(order.getOrderType().getType())) {

                allOrdersBYStock.get(order.getStockID().getStockName())
                        .get(order.getOrderType().getType()).add(order);
                allOrdersBYStock.get(order.getStockID().getStockName())
                        .get(order.getOrderType().getType()).notify();

            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception occurred while creating/placing order", e);
        }

    }

    /**
     * After the adding the order to <b>acceptOrder</b> should call the <b>processOrder<b> to initiate
     * the matching process.
     */
    @Override
    public void processOrder() {
        allOrdersBYStock.entrySet().forEach(s -> matchingEngine(s.getValue()));
        executedOrderedList.stream().forEach(System.out::println);
    }

    /**
     * <b>matchingEngine</b> will do the matching by comparing the BUY and SELL orders.
     * If matched criteria found then it will process the order and remove the order from <b>allOrdersBYStock</b>
     * and added to the <b>executedOrderedList</b>.
     * <u>Matching criteria:</u>
     * 1) Buy order price should be greater then or equal to the sell order.
     */
    @Override
    public void matchingEngine(ConcurrentHashMap<String, ConcurrentSkipListSet<Order>> ordersByStock) {

        Order firstBuyOrder = ordersByStock.get(OrderType.BUY.getType()).first();// Get the first element from the Buy order book
        Order firstSellOrder = ordersByStock.get(OrderType.SELL.getType()).first();//Get the first element from thr Sell order book
        ArrayList<Order> completedTransaction;
        Order clonedOrder;

        //If Stock Buy price is greater or equal to stock sell price. then we will execute the order
        if (firstBuyOrder.getPrice() >= firstSellOrder.getPrice()) {

            completedTransaction = new ArrayList<Order>();//We will store the completed the transactions.

            //If price criteria matches the we will check the quantity and updated the order accordingly.
            if (firstBuyOrder.getQty().equals(firstSellOrder.getQty())) {
                logger.log(Level.INFO, "Both Buy and Sell order quantity is matched.");
                firstBuyOrder.setOrderStatus(OrderStatus.COMPLETED);
                firstSellOrder.setOrderStatus(OrderStatus.COMPLETED);
                completedTransaction.add(ordersByStock.get(OrderType.BUY.getType()).pollFirst());
                completedTransaction.add(ordersByStock.get(OrderType.SELL.getType()).pollFirst());
                executedOrderedList.add(completedTransaction);
                matchingEngine(ordersByStock);

            } else if (firstBuyOrder.getQty() > firstSellOrder.getQty()) {
                logger.log(Level.INFO, "Buy Order quantity is greater than the Sell order.");
                firstBuyOrder.setOrderStatus(OrderStatus.PARTIALLY_COMPLETED);
                firstSellOrder.setOrderStatus(OrderStatus.COMPLETED);
                try {
                    clonedOrder = (Order) firstBuyOrder.clone();
                    clonedOrder.setQty(firstSellOrder.getQty());
                } catch (CloneNotSupportedException e) {
                    logger.log(Level.SEVERE, "Error occurred while cloning order object", e);
                    clonedOrder = firstBuyOrder;
                }
                firstBuyOrder.setQty(firstBuyOrder.getQty() - firstSellOrder.getQty());
                completedTransaction.add(ordersByStock.get(OrderType.SELL.getType()).pollFirst());//Sell leg
                completedTransaction.add(clonedOrder);//Buy leg
                executedOrderedList.add(completedTransaction);
                matchingEngine(ordersByStock);

            } else {
                logger.log(Level.INFO, "Sell Order quantity is greater than the Buy order.");
                firstSellOrder.setOrderStatus(OrderStatus.PARTIALLY_COMPLETED);
                firstBuyOrder.setOrderStatus(OrderStatus.COMPLETED);

                try {
                    clonedOrder = (Order) firstSellOrder.clone();
                    clonedOrder.setQty(firstBuyOrder.getQty());
                } catch (CloneNotSupportedException e) {
                    logger.log(Level.SEVERE, "Error occurred while cloning order object", e);
                    clonedOrder = firstSellOrder;
                }
                firstSellOrder.setQty(firstSellOrder.getQty() - firstBuyOrder.getQty());
                completedTransaction.add(ordersByStock.get(OrderType.BUY.getType()).pollFirst());//BUY leg
                completedTransaction.add(clonedOrder);//Sell leg
                executedOrderedList.add(completedTransaction);
                matchingEngine(ordersByStock);

            }


        }

    }


}
