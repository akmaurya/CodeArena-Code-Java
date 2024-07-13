package com.xcode.javas.durgasoft._g_collection.collectioni.seti.hashset;

/**
 * Created by jarvis on 6/7/17.
 */
/*
  Iterate through elements of Java HashSet example
  This Java Example shows how to iterate through elements Java HashSet object.
*/

import java.util.HashSet;
import java.util.Iterator;

public class _4_IterateThroughElementsOfHashSet {

    public static void main(String[] args) {

        //create object of HashSet
        HashSet hSet = new HashSet();

        //add elements to HashSet object
        hSet.add(new Integer("1"));
        hSet.add(new Integer("2"));
        hSet.add(new Integer("4"));
        hSet.add(new Integer("3"));

        System.out.println(hSet);


        //get the Iterator

        Iterator itr = hSet.iterator();

        System.out.println("HashSet contains : ");
        while(itr.hasNext())
            System.out.println(itr.next());
    }
}

/*
Output would be
HashSet contains :
3
2
1
*/