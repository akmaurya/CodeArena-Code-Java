package com.xcode.javas.zedsoftware.applets;

public class th extends Thread
{
	public void run()
	{
		moveable m=new moveable();
		System.out.println("Ok it is in run");
		for(int i=10;i<=490;i++)
		{
			if(i<=490)			
			m.bt1.setBounds(i,10,100,30);
			try
			{
				sleep(500);
			}
			catch(Exception e)
			{
				System.out.println("Error! "+e);
			}
			
		}
	}
	
}