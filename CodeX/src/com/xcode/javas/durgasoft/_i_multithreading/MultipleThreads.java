package com.xcode.javas.durgasoft._i_multithreading;

public class MultipleThreads
{
    public static void main(String[] args) throws InterruptedException
    {
        for(int i=1;i<10;i++){
            Thread t = new Thread(new MyMultipleThread());
            t.start();
            System.out.println("Thread Name-------------"+t.getName());
            t.sleep(1);
        }
    }
}

class MyMultipleThread implements Runnable{
    public void run(){
        System.out.println("Inside Thread");
    }
}
