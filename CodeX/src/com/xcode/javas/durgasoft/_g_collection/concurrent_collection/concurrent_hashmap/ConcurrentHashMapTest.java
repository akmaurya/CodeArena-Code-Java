package com.xcode.javas.durgasoft._g_collection.concurrent_collection.concurrent_hashmap;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest
{
    public static void main(String[] args)
    {
        ConcurrentHashMap chm = new ConcurrentHashMap();
        chm.put(101,"A");
        chm.put(102,"B");
        chm.put(103,"C");

        chm.putIfAbsent(103,"C");
        chm.putIfAbsent(104,"D");


    }
}
