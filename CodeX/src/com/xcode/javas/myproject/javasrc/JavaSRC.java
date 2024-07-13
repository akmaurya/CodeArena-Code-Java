package com.xcode.javas.myproject.javasrc;

import java.lang.reflect.Method;

public class JavaSRC
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        int count=0;

        Class c= Class.forName("java.util.LinkedList");
        System.out.println("Class Name : "+c.getName());
        Method[] m=c.getDeclaredMethods();
        System.out.println("Methods : ");
        for(Method m1:m)
        {
            count++;
            System.out.println(count+" - "+m1.getName());
        }
        System.out.println("Total methods of Class class = "+count);
    }
}
