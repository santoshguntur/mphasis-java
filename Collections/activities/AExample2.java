package com.company.collections.activities;

import java.util.ArrayDeque;

public class AExample2 {
    /*
    public static void main(String args[]) {
    // Create a collection.
    XxxxxXxxxx<String> adq = new XxxxxXxxxx<String>();

    // Use the collection like a stack.
    adq.xxxx("A");
    adq.xxxx("B");
    adq.xxxx("D");
    adq.xxxx("E");
    adq.xxxx("F");

    System.out.print("Popping the stack: ");

    while(adq.xxxx() != null)
      System.out.print(adq.xxx() + " ");

    System.out.println();
  }
    * */
    public static void main(String args[]) {
        // Create a collection.
        ArrayDeque<String> adq = new ArrayDeque<String>();

        // Use the collection like a stack.
        adq.add("A");
        adq.add("B");
        adq.add("D");
        adq.add("E");
        adq.add("F");

        System.out.print("Popping the stack: ");

        while(adq.peek() != null)
            System.out.print(adq.poll() + " ");

        System.out.println();
    }
}
