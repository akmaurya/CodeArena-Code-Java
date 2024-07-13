package com.xcode.javas.durgasoft._d_javadotlangpackage;

/**
 * Created by jarvis on 27/12/16.
 */
public class DeepCloning_8
{
    public static void main(String[] args) throws CloneNotSupportedException
    {
        Cat c = new Cat(20);
        Dog d1 = new Dog(c,10);
        Dog d2 = (Dog)d1.clone();
        d2.i = 888;
        d2.c.j = 999;
                                                //reverse uncomment into the Dog Class clone() method.
        System.out.println(d1.i+"----"+d1.c.j);//c object is also cloned because it is reference and clone into overriden
                                                // clone() method (In shallow cloning it is not cloned)
    }
}
