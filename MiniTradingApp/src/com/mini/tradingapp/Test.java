package com.mini.tradingapp;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> d = new ArrayList<>();

         d.add("Rekha");

        System.out.println(d);

        //Get the object from collection
            //find the index of the existing object(Rekha)
        int i=0;boolean found=false;
      /*  for (String q : d) {
              *//*  if(q.equals("Rekha")){
                    found=true;
                    break;
                }
                i++;*//*

        }*/
        //Updating the collection
        if(found)
        d.set(i,"Rekha G");

        System.out.println(d);
    }

}
