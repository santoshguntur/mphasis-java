package com.mini.tradingapp.masterdata;

import com.mini.tradingapp.util.Trader;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class TraderMasterData {
    private AtomicInteger traderIDCounter =new AtomicInteger(100);
    private static TraderMasterData tMasterData=new TraderMasterData();
    private ArrayList<Trader> traderArrayList=new ArrayList<>();

    private TraderMasterData() {
    }

    public static TraderMasterData getInstance(){
        return tMasterData;
    }
    public Trader add(Trader trader){
        trader.setTraderID(Integer.toString(getNextTraderId()));
        traderArrayList.add(trader);
        return trader;
    }
    public Optional<Trader> getById(String traderId){
        return traderArrayList.stream()
                .filter(trader -> trader.getTraderID().equals(traderId)).findFirst();
    }

    private int getNextTraderId(){
        return  traderIDCounter.incrementAndGet();
    }

    public ArrayList<Trader> getAllTraders(){
        return traderArrayList;
    }

}
