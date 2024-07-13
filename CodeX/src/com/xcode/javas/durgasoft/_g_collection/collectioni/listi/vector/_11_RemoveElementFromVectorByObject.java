package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Remove specified element from Java Vector Example
  This Java Example shows how to remove a specified element java Vector object
  using remove and removeElement methods.
*/

import java.util.Vector;

public class _11_RemoveElementFromVectorByObject {

    public static void main(String[] args) {
        //create a Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");

    /*
      To remove a specified element from Vector use
      boolean remove(Object o) method. It removes the first occurrence of
      the object if found in the Vector. If not, Vector remains unchanged.
      It returns true if Vector contained the specified object.
    */
        System.out.println(v);
        boolean blnElementFound = v.remove("2");
        System.out.println("Was 2 removed from Vector ? " + blnElementFound);

        System.out.println("Vector contents after remove call...");
        //display elements of Vector
        for(int index=0; index < v.size(); index++)
            System.out.println(v.get(index));

    /*
       boolean removeElement(Object o) is also identical to the remove method.
    */
        v.removeElement("3");

        System.out.println("Was 3 removed from Vector ? " + blnElementFound);
        System.out.println("Vector contents after removeElement call...");
        //display elements of Vector
        for(int index=0; index < v.size(); index++)
            System.out.println(v.get(index));


    }
}

/*
Output would be
Was 2 removed from Vector ? true
Vector contents after remove call...
1
3
4
5
Was 3 removed from Vector ? true
Vector contents after removeElement call...
1
4
5
*/