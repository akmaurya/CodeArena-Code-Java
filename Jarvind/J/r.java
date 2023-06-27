class task1 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		System.out.println("Task1="+i);
	}
}

class task2 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		System.out.println("Task2_________="+i);
	}
}

class threadDemo
{
	public static void main(String a[])
	{
		System.out.println("Start");
		task1 t1=new task1();
		System.out.println("A");
		task2 t2=new task2();
		System.out.println("B");
		t1.start();
		System.out.println("C");
		t2.start();
		System.out.println("End");
	}
}