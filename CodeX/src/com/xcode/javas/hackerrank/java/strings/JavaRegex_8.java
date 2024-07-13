package com.xcode.javas.hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by jarvis on 7/1/17.
 */
public class JavaRegex_8
{
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex
{
    String pattern = "(\\d{1,2}|[01]\\d{2}|2[0-5]\\d)\\.(\\d{1,2}|[01]\\d{2}|2[0-5]\\d)\\.(\\d{1,2}|[01]\\d{2}|2[0-5]\\d)\\.(\\d{1,2}|[01]\\d{2}|2[0-5]\\d)";
}


        /*
            Sample Input

            000.12.12.034
            121.234.12.12
            23.45.12.56
            00.12.123.123123.123
            122.23
            Hello.IP
            Sample Output

            true
            true
            true
            false
            false
            false
        */