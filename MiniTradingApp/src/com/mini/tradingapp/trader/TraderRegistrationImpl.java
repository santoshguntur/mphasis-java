package com.mini.tradingapp.trader;

import com.mini.tradingapp.masterdata.TraderMasterData;
import com.mini.tradingapp.util.Trader;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TraderRegistrationImpl class implements the TraderRegistration Interface.
 * This will be responsible for the handling the CURD operations.
 *
 */


public class TraderRegistrationImpl implements TraderRegistration{
    private final static TraderRegistrationImpl traderRegistration=new TraderRegistrationImpl();
    Logger logger=Logger.getLogger(TraderRegistrationImpl.class.getName());

    TraderMasterData masterData=TraderMasterData.getInstance();

    /**
    * @param name
    * @param contactNo
     * @param address
     * @return Trader
    *
    */

    @Override
    public Trader add(String name, String contactNo, String address) {
        return   masterData.add(new Trader(null,name,contactNo,address));

    }

    /**
     * @param traderID
     * @return Trader
     */

    @Override
    public boolean delete(String traderID) {

        Trader trader=masterData.getById(traderID);
        if(trader!=null) {
            masterData.getAllTraders().remove(trader);
            return true;
        }else {
            logger.log(Level.INFO,"TraderID is not available.");
        }

        return false;
    }
    /**
     * @param name
     * @param contactNo
     * @param address
     * @param traderID
     * @return Trader
     */

    @Override
    public Trader modify(String name, String contactNo, String address,String traderID) {

        Trader trader=masterData.getById(traderID);
        if(trader!=null) {
            trader.setTraderName(name);
            trader.setTraderContactNumber(contactNo);
            trader.setTraderAddress(address);
        }else {
            logger.log(Level.INFO,"TraderID is not available.");
        }

        return trader;
    }

    /**
     * @return TraderRegistrationImpl
     */

    public static TraderRegistrationImpl getInstance(){

        return traderRegistration;
    }
}
