package com.xcode.javas.durgasoft._g_collection.concurrent_collection.copy_on_write_array_list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTest
{
    public static void main(String[] args)
    {
        CopyOnWriteArrayList cal = new CopyOnWriteArrayList();
        cal.add("A");
        cal.add("B");
        cal.add("C");

        Iterator itr = cal.iterator();
        while (itr.hasNext()){
            String str = (String)itr.next();
            System.out.println("Main----------"+str);
            cal.add("D");
            System.out.println("Added----------"+cal);
        }
    }
}
