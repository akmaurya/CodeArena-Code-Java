package com.xcode.javas.other.collectionexamples;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by jarvis on 13/12/16.
 */
public class ArrayListWithIterator
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        System.out.println(al);
        HashSet hs = new HashSet();
        hs.add(10);
        hs.add(20);
        hs.add(30);
        al.addAll(2,hs);
        System.out.println(al);
        Iterator itr = al.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

        ListIterator litr = al.listIterator();
        while (litr.hasNext())
            System.out.println(litr.next());
    }
}
