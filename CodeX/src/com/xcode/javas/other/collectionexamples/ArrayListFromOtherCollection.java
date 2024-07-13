package com.xcode.javas.other.collectionexamples;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by jarvis on 13/12/16.
 */
public class ArrayListFromOtherCollection
{
    public static void main(String[] args)
    {
        HashSet hs = new HashSet();
        hs.add(10);
        hs.add(20);
        hs.add(30);
        ArrayList al = new ArrayList(hs);
        al.add(1);
        al.add(2);
        al.add(3);
        System.out.println(al);
        al.add(hs);
        al.add(2,5);
        al.addAll(hs);
        System.out.println(al);
    }
}
