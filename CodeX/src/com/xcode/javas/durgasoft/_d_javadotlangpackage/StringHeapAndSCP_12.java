package com.xcode.javas.durgasoft._d_javadotlangpackage;

/**
 * Created by jarvis on 27/12/16.
 */
public class StringHeapAndSCP_12
{
    public static void main(String[] args)
    {
        String s1 = new String("Durga");//Object is created in both area Heap and String Constand Pool but s1 object pointing to Heap object.
        String s2 = "Durga";    //Object is created in only String Constant Pool and s2 is pointing to SCP object

        System.out.println(s1 == s2); // false because s1 pointing to heap object.
        System.out.println(s1.equals(s2));
    }
}
