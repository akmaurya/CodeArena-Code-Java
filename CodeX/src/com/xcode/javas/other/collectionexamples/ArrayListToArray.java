package com.xcode.javas.other.collectionexamples;

import java.util.ArrayList;

/**
 * Created by jarvis on 13/12/16.
 */
public class ArrayListToArray
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        System.out.println(al);
        Object ob[];
        ob = al.toArray();

        for (int i = 0; i < ob.length; i++)
        {
            System.out.println(ob[i]);
        }
        System.out.println(al);
    }
}
