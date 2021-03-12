package com.mini.tradingapp.trader;

import com.mini.tradingapp.util.Trader;

public interface TraderRegistration {
    Trader add(String name, String contactNo, String address);
    boolean delete(Trader trader);
    Trader modify(String name, String contactNo, String address,String traderID);

}
