package com.xcode.javas.hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class TimeConversion
{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        String result="";
        String time=sc.nextLine();

        if(time.charAt(8)=='P')
        {
            int h=Integer.parseInt(time.substring(0,2));
            if(h>=1&&h<12)
                h=h+12;
            result=""+h+(time.substring(2,8));
        }
        else if(time.charAt(8)=='A')
        {
            int h=Integer.parseInt(time.substring(0,2));
            if(h==12)
            {
                h=0;
                result="00"+(time.substring(2,8));
            }
            else
                result=""+(time.substring(0,8));
        }
        System.out.println(""+result);
    }
}


        /*
            Sample Input

            07:05:45PM
            Sample Output

            19:05:45
        */