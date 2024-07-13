package com.xcode.javas.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by jarvis on 7/11/16.
 */
class JavaEndOfFile
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int i = 0;
        while (input.hasNext())
        {
            System.out.println(++i+" "+input.nextLine());
        }
    }
}


        /*
            Sample Input

            Hello world
            I am a file
            Read me until end-of-file.
            Sample Output

            1 Hello world
            2 I am a file
            3 Read me until end-of-file.
        */