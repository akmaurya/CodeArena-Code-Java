package com.xcode.javas.hackerrank.java.introduction;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by jarvis on 7/11/16.
 */
public class JavaCurrencyFormatter
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        String us = NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(payment);
        String india = NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment);
        String china = NumberFormat.getCurrencyInstance(new Locale("zh", "CN")).format(payment);
        String france = NumberFormat.getCurrencyInstance(new Locale("fr", "FR")).format(payment);
        /*NumberFormat usNumber = NumberFormat.getCurrencyInstance(CurrencyNames_en_US, payment);
        String us = usNumber.
*/
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}


        /*
            Sample Input

            12324.134
            Sample Output

            US: $12,324.13
            India: Rs.12,324.13
            China: ￥12,324.13
            France: 12 324,13 €
        */