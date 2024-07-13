package com.xcode.javas.durgasoft._g_collection.concurrent_collection.concurrent_hashmap;

import java.util.ArrayList;
import java.util.Iterator;

public class _1_NeedOfConcurrentCollection extends Thread
{
    static ArrayList al = new ArrayList();
    public void run(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException ie){

        }
        System.out.println("Other thread modifying");
        al.add("D");
        System.out.println("Modified");
        System.out.println(al);

    }
    public static void main(String[] args)
    {
        al.add("A");
        al.add("B");
        al.add("C");

        _1_NeedOfConcurrentCollection mt = new _1_NeedOfConcurrentCollection();
        mt.start();
        Iterator itr = al.iterator();
        while (itr.hasNext())
        {
            System.out.println("In Main Thread");
            System.out.println(al);
            String str = (String)itr.next();
            System.out.println("Main Thread----"+str);
            //al.add("E");
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(al);
    }
}
