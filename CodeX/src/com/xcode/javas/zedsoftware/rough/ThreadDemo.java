package com.xcode.javas.zedsoftware.rough;

class task111 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		System.out.println("Task1="+i);
	}
}

class task222 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		System.out.println("Task2_________="+i);
	}
}

class threadDemo222
{
	public static void main(String a[])
	{
		System.out.println("Start");
		task111 t1=new task111();
		System.out.println("A");
		task222 t2=new task222();
		System.out.println("B");
		t1.start();
		System.out.println("C");
		t2.start();
		System.out.println("End");
	}
}