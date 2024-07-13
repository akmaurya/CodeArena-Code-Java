package com.xcode.javas.durgasoft._g_collection.collectioni.seti.treeset;

/**
 * Created by jarvis on 7/7/17.
 */
/*
  Iterate through elements of Java TreeSet example
  This Java Example shows how to iterate through elements Java TreeSet object.
*/

import java.util.TreeSet;
import java.util.Iterator;

public class _8_IterateThroughElementsOfTreeSet {

    public static void main(String[] args) {

        //create object of TreeSet
        TreeSet tSet = new TreeSet();

        //add elements to TreeSet object
        tSet.add(new Integer("1"));
        tSet.add(new Integer("2"));
        tSet.add(new Integer("3"));

        //get the Iterator
        System.out.println(tSet);
        Iterator itr = tSet.iterator();

        System.out.println("TreeSet contains : ");
        while(itr.hasNext())
            System.out.println(itr.next());
    }
}

/*
Output would be
TreeSet contains :
1
2
3
*/