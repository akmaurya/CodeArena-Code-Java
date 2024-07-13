package com.xcode.javas.hackerrank.tutorials.thirtydaysofcodechallenge;

import java.util.Scanner;

/**
 * Created by jarvis on 18/10/16.
 */
class Day2Operators
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        // Write your calculation code here.
        double tip = (mealCost*tipPercent)/100;
        double tax = (mealCost*taxPercent)/100;

        // cast the result of the rounding operation to an int and save it as totalCost
        int totalCost = (int) Math.round(mealCost+tip+tax);
        System.out.println("The total meal cost is "+totalCost+" dollars.");
        // Print your result
    }
}


        /*
            Sample Input

            12.00
            20
            8
            Sample Output

            The total meal cost is 15 dollars.
        */