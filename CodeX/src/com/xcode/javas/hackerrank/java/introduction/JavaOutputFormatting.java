package com.xcode.javas.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by jarvis on 21/10/16.
 */
class JavaOutputFormatting
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
            String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s",s1);
            System.out.printf("%03d\n",(int)x);
            //Complete this line
        }
        System.out.println("================================");

    }
}


        /*
            Sample Input

            java 100
            cpp 65
            python 50
            Sample Output

            ================================
            java           100
            cpp            065
            python         050
            ================================
        */