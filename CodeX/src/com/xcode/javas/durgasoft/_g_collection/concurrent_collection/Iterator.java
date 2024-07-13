package com.xcode.javas.durgasoft._g_collection.concurrent_collection;

import java.util.ArrayList;

public class Iterator
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList<>();
        al.add("A");
        al.add("B");
        al.add("C");
        al.add("D");
        al.add("E");
        al.add("F");


        java.util.Iterator itr = al.iterator();
        while (itr.hasNext()){
            String str = (String)itr.next();
            System.out.println(str);
            if(str.equals("B")){
                al.add("K");
            }
        }
        System.out.println(al);

    }
}
