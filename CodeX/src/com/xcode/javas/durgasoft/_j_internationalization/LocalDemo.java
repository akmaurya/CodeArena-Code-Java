package com.xcode.javas.durgasoft._j_internationalization;

/**
 * Created by jarvis on 17/10/16.
 */

import java.util.*;
class LocalDemo
{
    public static void main(String[] args)
    {
        Locale l1 = Locale.getDefault();
        System.out.println(l1.getCountry()+"-----"+l1.getLanguage());
        System.out.println(l1.getDisplayCountry()+"-----"+l1.getDisplayName());
        Locale l2 = new Locale("pa", "IN");
        Locale.setDefault(l2);
        System.out.println(Locale.getDefault().getDisplayLanguage());
        String s3[] = Locale.getISOLanguages();
        for (String s4 : s3)
        {
            System.out.println(s4);
        }
        String s4[] = Locale.getISOCountries();
        for (String s5 : s4)
        {
            System.out.println(s5);
        }
        Locale s[] = Locale.getAvailableLocales();
        int i=0;
        for (Locale s1 : s)
        {
            i++;
            //System.out.println(s1.getDisplayCountry()+"------"+s1.getDisplayLanguage());
            System.out.printf("%25s  --%4d --  %-15s\n",s1.getDisplayCountry(),i,s1.getDisplayLanguage());
        }
    }
}
