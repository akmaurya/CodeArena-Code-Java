package com.xcode.javas.durgasoft._g_collection.collectioni.listi.vector;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by jarvis on 5/7/17.
 */
public class _17_IteratThroughVectorUsingEnumaration
{
    public static void main(String[] args)
    {
        Vector v = new Vector();
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        v.add("5");

        System.out.println(v);

        Enumeration en = v.elements();
        System.out.println("Elements by Enumeration");
        while (en.hasMoreElements())
            System.out.println(en.nextElement());
    }
}
