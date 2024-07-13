package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

/**
 * Created by jarvis on 24/10/16.
 */
class Day21Generics
{
    public static <T> void printArray(T a[])
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }

    }
    public static void main(String args[]){
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };

        printArray( intArray  );
        printArray( stringArray );

        if(Day21Generics.class.getDeclaredMethods().length > 2){
            System.out.println("You should only have 1 method named printArray.");
        }
    }
}
