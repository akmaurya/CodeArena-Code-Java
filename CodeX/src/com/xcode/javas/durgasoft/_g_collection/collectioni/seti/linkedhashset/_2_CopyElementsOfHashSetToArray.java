package com.xcode.javas.durgasoft._g_collection.collectioni.seti.linkedhashset;

/**
 * Created by jarvis on 6/7/17.
 */
/*
  Copy all elements of Java LinkedHashSet to an Object Array Example
  This Java Example shows how to copy all elements of Java LinkedHashSet object to an
  array of Objects using toArray method.
*/

import java.util.LinkedHashSet;

public class _2_CopyElementsOfHashSetToArray {

    public static void main(String[] args) {

        //create object of LinkedHashSet
        LinkedHashSet lhashSet = new LinkedHashSet();

        //add elements to LinkedHashSet object
        lhashSet.add(new Integer("1"));
        lhashSet.add(new Integer("2"));
        lhashSet.add(new Integer("3"));

    /*
      To copy all elements of java LinkedHashSet object into array use
      Object[] toArray() method.
    */

        System.out.println(lhashSet);
        Object[] objArray = lhashSet.toArray();

        //display contents of Object array
        System.out.println("LinkedHashSet elements are copied into an Array. Now Array Contains..");
        for(int index=0; index < objArray.length ; index++)
            System.out.println(objArray[index]);
    }
}

/*
Output would be
LinkedHashSet elements are copied into an Array. Now Array Contains..
1
2
3
*/