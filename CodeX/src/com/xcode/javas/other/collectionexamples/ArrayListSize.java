package com.xcode.javas.other.collectionexamples;

import java.util.ArrayList;

/**
 * Created by jarvis on 13/12/16.
 */
public class ArrayListSize
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        System.out.println(al);
        for (int i = 0; i < al.size(); i++)
        {
            System.out.println(al.get(i));
        }
    }
}
