package com.xcode.javas.durgasoft._k_serialization;

import java.io.*;

public class Dog implements Serializable{
    int i = 10;
    int j = 20;

    public int getI()
    {
        return i;
    }

    public void setI(int i)
    {
        this.i = i;
    }

    public int getJ()
    {
        return j;
    }

    public void setJ(int j)
    {
        this.j = j;
    }

    @Override
    public String toString()
    {
        return "Dog{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
class SerializeDemo{
    public static void main(String[] args)
    {
        Dog d1 = new Dog();
        FileOutputStream fos;
        ObjectOutputStream oos;
        FileInputStream fis;
        ObjectInputStream ois;
        try
        {
            fos = new FileOutputStream("abc.ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(d1);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            fis = new FileInputStream("abc.ser");
            ois = new ObjectInputStream(fis);
            Dog d = (Dog) ois.readObject();
            System.out.println(d);
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
