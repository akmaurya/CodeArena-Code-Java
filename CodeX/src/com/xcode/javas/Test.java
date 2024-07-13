package com.xcode.javas;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Test
{
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Statement-1");
            System.out.println(10/0);
            System.out.println("Statement-1");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }

    }
}
