package com.mini.tradingapp.trader;

import com.mini.tradingapp.masterdata.TraderMasterData;
import com.mini.tradingapp.util.Trader;

import java.util.ArrayList;

public class TraderRegistrationImpl implements TraderRegistration{
    private final static TraderRegistrationImpl traderRegistration=new TraderRegistrationImpl();

    TraderMasterData masterData=TraderMasterData.getInstance();

    @Override
    public Trader add(String name, String contactNo, String address) {
        return   masterData.add(new Trader(null,name,contactNo,address));

    }

    @Override
    public boolean delete(Trader trader) {
        return false;
    }

    @Override
    public Trader modify(String name, String contactNo, String address,String traderID) {
        ArrayList<Trader> listOfTraders = masterData.getAllTraders();
        Trader trader=null;
        for(Trader t:listOfTraders){
            if(t.getTraderID().equals(traderID))
                trader=t;
        }
        trader.setTraderName(name);
        trader.setTraderContactNumber(contactNo);
        trader.setTraderAddress(address);

        return trader;
    }

    public static TraderRegistrationImpl getInstance(){
        return traderRegistration;
    }
}
