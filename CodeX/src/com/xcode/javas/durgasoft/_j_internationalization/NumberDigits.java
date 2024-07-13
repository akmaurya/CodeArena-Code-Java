package com.xcode.javas.durgasoft._j_internationalization;

import java.text.NumberFormat;

/**
 * Created by jarvis on 7/4/17.
 */
public class NumberDigits
{
    public static void main(String[] args)
    {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(1234.5678));
        System.out.println(nf.format(1234.5));

        nf.setMinimumFractionDigits(2);
        System.out.println(nf.format(1234.5678));
        System.out.println(nf.format(1234.5));

        nf.setMaximumIntegerDigits(3);
        System.out.println(nf.format(123456.789));
        System.out.println(nf.format(1.2345));

        nf.setMinimumIntegerDigits(3);
        System.out.println(nf.format(123456.789));
        System.out.println(nf.format(1.2345));
    }
}
