package com.xcode.javas.hackerrank.java.introduction;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by jarvis on 7/11/16.
 */
public class JavaDateAndTime
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));

        System.out.println(new DateFormatSymbols().getWeekdays()[calendar.get(Calendar.DAY_OF_WEEK)].toUpperCase());
    }
}


        /*
            Sample Input

            08 05 2015
            Sample Output

            WEDNESDAY
        */