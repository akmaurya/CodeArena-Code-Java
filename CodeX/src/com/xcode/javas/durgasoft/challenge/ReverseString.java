package com.xcode.javas.durgasoft.challenge;

import java.lang.reflect.Field;

public class ReverseString
{
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException
    {
        String str = "Arvind";
        reverse(str);
        System.out.println(str);
    }

    private static void reverse(String str) throws IllegalAccessException, NoSuchFieldException
    {
        Field f = String.class.getDeclaredField("value");
        f.setAccessible(true);
        f.set(str, (""+new StringBuilder(str).reverse()).toCharArray());
    }
}
