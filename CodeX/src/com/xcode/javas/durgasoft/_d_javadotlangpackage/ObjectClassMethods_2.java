package com.xcode.javas.durgasoft._d_javadotlangpackage;
import java.lang.reflect.*;
/**
 * Created by jarvis on 27/12/16.
 */
public class ObjectClassMethods_2
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        int i=0;
        Class c = Class.forName("java.lang.Object");
        Method[] m = c.getDeclaredMethods();
        Field[] f = c.getDeclaredFields();
        System.out.println("Total Methods of Object Class :");
        for (Method m1 : m)
        {
            System.out.println(++i+"--"+m1.getReturnType()+"  "+m1.getName());
        }
        System.out.println("Total "+i+" Methods.\n\n");
        System.out.println("Total Fields of Object Class :");
        i=0;
        for (Field f1 : f)
        {
            System.out.println(++i+"--"+f1.getName());
        }
        System.out.println("Total "+i+" Fields.");
    }
}
