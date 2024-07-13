package com.xcode.javas.durgasoft._j_internationalization;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by jarvis on 7/4/17.
 */
public class LocaleCurrency
{
    public static void main(String[] args)
    {
        double d = 123456.789;
        Locale india = new Locale("hi", "IN");
        NumberFormat nf = NumberFormat.getCurrencyInstance(india);
        System.out.println(nf.format(d));
    }
}
