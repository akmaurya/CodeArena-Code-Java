package com.xcode.javas.durgasoft._d_javadotlangpackage;

/**
 * Created by jarvis on 27/12/16.
 */
public class ShallowCloning_7
{
    public static void main(String[] args)throws CloneNotSupportedException
    {
        Cat c = new Cat(20);
        Dog d1 = new Dog(c,10);
        Dog d2 = (Dog)d1.clone();
        d2.i = 888;
        d2.c.j = 999;

        System.out.println(d1.i+"----"+d1.c.j);//c object is not cloned because it is reference (In shallow cloning it is not cloned)
    }
}

class Dog implements Cloneable
{
    Cat c;
    int i;
    Dog(Cat c, int i)
    {
        this.c = c;
        this.i = i;
    }
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
//        Cat c1 = new Cat(c.j);
//        Dog d = new Dog(c1,i);
//        return d;
    }
}

class Cat
{
    int j;
    Cat(int j)
    {
        this.j = j;
    }
}