package com.mini.tradingapp.masterdata;

import com.mini.tradingapp.util.Trader;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
* This class will store the all the Traders master data.
* */

public class TraderMasterData {
    private AtomicInteger traderIDCounter =new AtomicInteger(100);
    private static TraderMasterData tMasterData=new TraderMasterData();
    private HashSet<Trader> traderArrayList=new HashSet<>();

    /**
     * private constructor defined to restrict the multiple instantiation of the class.*/
    private TraderMasterData() {
    }

    /**Factory method returns TraderMasterData object.
     * @return tMasterData
     * */
    public static TraderMasterData getInstance(){
        return tMasterData;
    }
    /**
     * add will store the trader information datastructures/database.
     * @param trader  pojo object of class Trader
     * @return trader
     * */
    public Trader add(Trader trader){
        trader.setTraderID(Integer.toString(getNextTraderId()));
        traderArrayList.add(trader);
        return trader;
    }
    /**
     * @return Returns the trader object by iteration the datastructures
     * @param traderId key value for the Trader class
     */

    public Trader getById(String traderId){
        return traderArrayList.stream()
                .filter(trader -> trader.getTraderID().equals(traderId))
                .findFirst().orElse(null);

    }

    /**
     * @return Return the next available value by increment one.
     */

    private int getNextTraderId(){
        return  traderIDCounter.incrementAndGet();
    }

    /**
     * @return Returns the all the traders
     * */

    public HashSet<Trader> getAllTraders(){
        return traderArrayList;
    }

}
