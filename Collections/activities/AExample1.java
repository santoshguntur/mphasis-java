package com.company.collections.activities;

import java.util.LinkedList;
/*
* public static void main(String args[]) {

    XxxxxxXxxx<String> result = new XxxxxxXxxx<String>();

    // Add elements to the collection.
    result.xxx("B");
    result.xxx("C");
    result.xxx("D");
    result.xxx("X");
    result.xxx("Y");
    result.xxxXxxx("Z");
    result.xxxXxxxx("A");

    result.xxx(1, "A2");

    System.out.println("Original contents of result: " + result);

    // Remove elements from the collection.
    result.xxxxxx("F");
    result.xxxxxx(2);

    System.out.println("Contents of result after deletion: "
                       + result);

    // Remove first and last elements.
    result.xxxxxxXxxxx();
    result.xxxxxxXxxx();

    System.out.println("result after deleting first and last: "
                       + result);

    // Get and set a value.
    String val = result.xxx(2);
    result.xxx(2, val + " Changed");

    System.out.println("result after change: " + result);
  }
* */

public class AExample1 {

    public static void main(String args[]) {

        LinkedList<String> result = new LinkedList<String>();

        // Add elements to the collection.
        result.add("B");
        result.add("C");
        result.add("D");
        result.add("X");
        result.add("Y");
        result.addLast("Z");
        result.addFirst("A");

        result.add(1, "A2");

        System.out.println("Original contents of result: " + result);

        // Remove elements from the collection.
        result.remove("F");
        result.remove(2);

        System.out.println("Contents of result after deletion: "
                + result);

        // Remove first and last elements.
        result.pollFirst();
        result.pollLast();

        System.out.println("result after deleting first and last: "
                + result);

        // Get and set a value.
        String val = result.get(2);
        result.set(2, val + " Changed");

        System.out.println("result after change: " + result);
    }
}
