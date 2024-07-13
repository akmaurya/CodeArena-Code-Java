package com.xcode.javas.other.collectionexamples;

import java.util.ArrayList;

/**
 * Created by jarvis on 13/12/16.
 */
public class ArrayListSubList
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
        ArrayList lst = new ArrayList(al.subList(1,3));


        //display elements of sub list.
        System.out.println("Sub list contains : ");
            System.out.println(lst);

    /*
      Sub List returned by subList method is backed by original Arraylist. So any
      changes made to sub list will also be REFLECTED in the original Arraylist.
    */
        //remove one element from sub list
        Object obj = lst.remove(0);
        System.out.println(obj + " is removed from sub list");

        //print original ArrayList
        System.out.println("After removing " + obj + " from sub list, original ArrayList contains : ");
        System.out.println(al);
    }
}
