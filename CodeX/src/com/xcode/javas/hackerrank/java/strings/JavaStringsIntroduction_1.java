package com.xcode.javas.hackerrank.java.strings;

import java.util.Scanner;

/**
 * Created by jarvis on 6/1/17.
 */
public class JavaStringsIntroduction_1
{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length()+B.length());
        System.out.println(A.compareTo(B)>0?"Yes":"No");
        System.out.println((A.charAt(0)+"").toUpperCase()+A.substring(1,A.length())+" "+(B.charAt(0)+"").toUpperCase()+B.substring(1,B.length()));



    }
}


    /*
        Sample Input

            hello
            java
        Sample Output

            9
            No
            Hello Java
    */