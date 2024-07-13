package com.xcode.javas.hackerrank.java.introduction;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class JavaStdinAndStdoutII
{
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        double d = scan.nextDouble();
        String s1 = scan.nextLine();
        String s = scan.nextLine();

        // Write your code here.

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}


        /*
            Sample Input

            42
            3.1415
            Welcome to HackerRank's Java tutorials!
            Sample Output

            String: Welcome to HackerRank's Java tutorials!
            Double: 3.1415
            Int: 42
        */