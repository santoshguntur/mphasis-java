package com.mini.tradingapp.trader;

import com.mini.tradingapp.util.Trader;

/**
 * TraderRegistration interface have the add,delete and modify API
 * Implementation classes should implement all the abstract methods.
 */


public interface TraderRegistration {
    Trader add(String name, String contactNo, String address);
    boolean delete(String traderIDr);
    Trader modify(String name, String contactNo, String address,String traderID);

}
