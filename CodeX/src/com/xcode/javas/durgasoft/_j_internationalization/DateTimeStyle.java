package com.xcode.javas.durgasoft._j_internationalization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by jarvis on 11/4/17.
 */
public class DateTimeStyle {
    public static void main(String[] args) {
        DateFormat us = DateFormat.getDateTimeInstance(0,0, Locale.US);
        System.out.println("US style is: \n"+us.format(new Date()));
    }
}
