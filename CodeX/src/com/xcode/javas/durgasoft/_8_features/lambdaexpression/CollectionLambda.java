package com.xcode.javas.durgasoft._8_features.lambdaexpression;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionLambda
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
        al.add(10);
        al.add(80);

        al.add(30);
        al.add(20);
        al.add(40);
        Collections.sort(al,(a,b)->((int)a>(int)b)?-1:((int)a<(int)b)?1:0);
        System.out.println(al);
        System.out.println(al.stream().count());


    }
}

