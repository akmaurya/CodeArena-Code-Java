class task11 extends Thread
{
	public void run()
	{
		task22 t2=new task22();
		for(int i=1;i<=10;i++)
		{
			System.out.println("Task1="+i);
			
			if(i==5)
			{
				try
				{
					t2.join();	
				}
				catch(Exception ex)
				{
					System.out.println("Error in Thread");
				}
				
			}
			
		}
		
	}
}

class task22 extends Thread
{
	public void run()
	{
		for(int i=1;i<=10;i++)
		System.out.println("Task2_________="+i);
		try
		{
			sleep(3000);	
		}
		
		catch(Exception e)
		{
			System.out.println("Error! "+e);
		}
	}
}

class threadDemo22
{
	public static void main(String a[])
	{
		try
		{
			System.out.println("Start");
			task11 t1=new task11();
			System.out.println("A");
			task22 t2=new task22();
			System.out.println("B");
			t1.start();
			System.out.println("C");
			t2.start();
			t2.join();			//main join task2
			System.out.println("End");
		}
		catch(Exception ex)
		{
			System.out.println("Error in thread");
		}
	}
}