package com.mini.tradingapp.util;

import java.util.Comparator;

/**
 * SellOrderComparator is used to sort the all the SELL orders.
 */

public class SellOrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {

        if (Double.compare(o1.getPrice(), o2.getPrice()) == 0)
            return o1.getCreationDate().compareTo(o2.getCreationDate());
        else
            return Double.compare(o1.getPrice(), o2.getPrice());

    }
}
