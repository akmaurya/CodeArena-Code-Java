package com.xcode.javas.durgasoft._i_multithreading;

public class ThreadPriority
{
    public static void main(String[] args)
    {
        MyThreadA t1 = new MyThreadA();
        MyThreadB t2 = new MyThreadB();
        MyThreadC t3 = new MyThreadC();
        t3.setPriority(10);
        t1.start();
        t2.start();
        t3.start();
    }
}
class MyThreadA extends Thread{
    public void run(){
        for(int i=1;i<=10;i++)
        {
            System.out.println("MyThreadA-------------"+i);
            try
            {
                sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}class MyThreadB extends Thread{
    public void run(){
        for(int i=1;i<=10;i++)
        {
            System.out.println("MyThreadB-------------"+i);
            try
            {
                sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}class MyThreadC extends Thread{
    public void run(){
        for(int i=1;i<=10;i++)
        {
            System.out.println("MyThreadC-------------"+i);
            try
            {
                sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
