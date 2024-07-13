package com.xcode.javas.durgasoft._j_internationalization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jarvis on 10/4/17.
 */
public class DateAndStyle {
    public static void main(String[] args) {
        System.out.println("Full    --- "+ DateFormat.getDateInstance(0, Locale.US).format(new Date()));
        System.out.println("Long    --- "+ DateFormat.getDateInstance(1, Locale.US).format(new Date()));
        System.out.println("Medium  --- "+ DateFormat.getDateInstance(2, Locale.US).format(new Date()));
        System.out.println("Short   --- "+ DateFormat.getDateInstance(3, Locale.US).format(new Date()));
        System.out.println("Default --- "+ DateFormat.getDateInstance(0, Locale.US).format(new Date()));


        System.out.println("UK Format");
        DateFormat uk = DateFormat.getDateInstance(0,Locale.UK);
        System.out.println(uk.format(new Date()));

        System.out.println("Italy Format");
        DateFormat it = DateFormat.getDateInstance(0,Locale.ITALY);
        System.out.println(it.format(new Date()));

        System.out.println("India Format");
        DateFormat in = DateFormat.getDateInstance(0,new Locale("hi","IN"));
        System.out.println(in.format(new Date()));
    }
}
