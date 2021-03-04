package com.company.collections.activities;

import java.util.*;

public class AExample7 {
    /*
    * public static void main(String args[]) {

    // initial size of 3 and increment of 2
    Xxxxxx<Xxxxxxx> v = new Xxxxxx<Xxxxxxx>(3, 2);

    System.out.println("Initial size: " + v.xxxx());
    System.out.println("Initial capacity: " +
                       v.xxxxxxxx());

    v.xxxXxxxxxx(1);
    v.xxxXxxxxxx(2);
    v.xxxXxxxxxx(3);
    v.xxxXxxxxxx(4);

    System.out.println("Capacity after four additions: " +
                       v.xxxxxxx());
    v.xxxXxxxxxx(5);
    System.out.println("Current capacity: " +
                       v.xxxxxxxx());
    v.xxxXxxxxxx(6);
    v.xxxXxxxxxx(7);

    System.out.println("Current capacity: " +
                       v.xxxxxxxx());
    v.xxxXxxxxxx(9);
    v.xxxXxxxxxx(10);

    System.out.println("Current capacity: " +
                       v.capacity());
    v.xxxXxxxxxx(11);
    v.xxxXxxxxxx(12);


    System.out.println("First element: " + v.xxxxxXxxxxxx());
    System.out.println("Last element: " + v.xxxxXxxxxxx());

    if(v.xxxxxxxx(3))
      System.out.println("Collection contains 3.");

    // traverse through the elements in the collection.
    Xxxxxxxxxxx vE = v.xxxxxxxx();

    System.out.println("\nElements in collection:");
    while(vE.xxxXxxxXxxxxxxx())
      System.out.print(vE.xxxxXxxxxxx() + " ");
    System.out.println();
  }
    * */

    public static void main(String args[]) {

        // initial size of 3 and increment of 2
        Vector<Integer> v = new Vector<Integer>(3,2);

        System.out.println("Initial size: " + v.size());
        System.out.println("Initial capacity: " +
                v.capacity());

        v.addElement(1);
        v.addElement(2);
        v.addElement(3);
        v.addElement(4);

        System.out.println("Capacity after four additions: " +
                v.capacity());
        v.addElement(5);
        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(6);
        v.addElement(7);

        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(9);
        v.addElement(10);

        System.out.println("Current capacity: " +
                v.capacity());
        v.addElement(11);
        v.addElement(12);


        System.out.println("First element: " + v.firstElement());
        System.out.println("Last element: " + v.lastElement());

        if(v.size()==3)
            System.out.println("Collection contains 3.");

        // traverse through the elements in the collection.
        Iterator<Integer> vE = v.iterator();

        System.out.println("\nElements in collection:");
        while(vE.hasNext())
            System.out.print(vE.next() + " ");
        System.out.println();
    }
}
