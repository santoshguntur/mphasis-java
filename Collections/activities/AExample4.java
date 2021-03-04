package com.company.collections.activities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Account{
    Double balance;

    public Account(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
public class AExample4 {
    /*
    * public static void main(String args[]) {

    // Use a data structure.
    XxxxXxx<Xxxxxx, Xxxxxx> hm = new XxxxXxx<Xxxxxx, Xxxxxx>();

    // Place elements to the data structure
    hm.xxx("John Doe", new Xxxxxx(3434.34));
    hm.xxx("Tom Smith", new Xxxxxx(123.22));
    hm.xxx("Jane Baker", new Xxxxxx(1378.00));
    hm.xxx("Tod Hall", new Xxxxxx(99.22));
    hm.xxx("Ralph Smith", new Xxxxxx(-19.08));

    // Get a set of the entries.
    Xxx<Map.Entry<Xxxxxx, Xxxxxx>> set = hm.xxxxxXxx();

    // Display the set.
    for(Map.Entry<Xxxxxx, Xxxxxx> me : set) {
      System.out.print(me.xxxXxx() + ": ");
      System.out.println(me.xxxXxxxx());
    }

    System.out.println();

    // Deposit 1000 into John Doe's account.
    xxxxxx balance = hm.xxx("John Doe");
    hm.xxx("John Doe", balance + 1000);

    System.out.println("John Doe's new balance: " +
      hm.xxx("John Doe"));
  }
    * */
    public static void main(String args[]) {

        // Use a data structure.
        HashMap<String, Account> hm = new HashMap<String, Account>();

        // Place elements to the data structure
        hm.put("John Doe", new Account(3434.34));
        hm.put("Tom Smith", new Account(123.22));
        hm.put("Jane Baker", new Account(1378.00));
        hm.put("Tod Hall", new Account(99.22));
        hm.put("Ralph Smith", new Account(-19.08));

        // Get a set of the entries.
        Set<Map.Entry<String, Account>> set = hm.entrySet();

        // Display the set.
        for(Map.Entry<String, Account> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }

        System.out.println();

        // Deposit 1000 into John Doe's account.
        double balance = hm.get("John Doe").getBalance();
        hm.put("John Doe", new Account(balance + 1000));

        System.out.println("John Doe's new balance: " +
                hm.get("John Doe"));
    }
}
