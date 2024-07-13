package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

/**
 * Created by jarvis on 5/7/17.
 */
/*
  Remove an element from specified index of Java Vector Example
  This Java Example shows how to remove an element at specified index of java
  Vector object using remove and removeElementAt methods.
*/

import java.util.Vector;

public class _10_RemoveElementFromVectorByIndex {

    public static void main(String[] args) {
        //create a Vector object
        Vector v = new Vector();

        //Add elements to Vector
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");

        System.out.println(v);
    /*
      To remove an element from the specified index of Vector use
      Object remove(int index) method.
      It returns the element that was removed from the Vector.
    */
        Object obj = v.remove(1);
        System.out.println(obj + " is removed from Vector");

        System.out.println("Vector contents after remove call...");
        System.out.println(v);
        //display elements of Vector
        for(int index=0; index < v.size(); index++)
            System.out.println(v.get(index));

    /*
       void removeElement(int index) is also identical to the remove method but
       remove method returns the element that was removed while return type of
       removeElementAt method is void.
    */
        v.removeElementAt(2);

        v.remove(2);
        System.out.println("Vector contents after removeElementAt call...");
        System.out.println(v);
        //display elements of Vector
        for(int index=0; index < v.size(); index++)
            System.out.println(v.get(index));


    }
}

/*
Output would be
2 is removed from Vector
Vector contents after remove call...
1
3
4
5
Vector contents after removeElementAt call...
1
3
5
*/