package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MoveStop extends JApplet implements ActionListener
{
	th t=new th();
	int ch=0;
	JToggleButton bt1;
	public void init()
	{
		Container cn=getContentPane();
		cn.setLayout(null);
		bt1=new JToggleButton("Start");

		bt1.setBounds(10,10,100,30);

		cn.add(bt1);

		bt1.addActionListener(this);


	}

	class th extends Thread
	{
		public void run()
		{
			for(int i=10;i<=390;i++)
			{
				if(i<390)
				{
					bt1.setBounds(i,10,100,30);
					try
					{
						sleep(10);
					}
					catch(Exception e)
					{
						System.out.println("Error! "+e);
					}

				}


				if(i==390)
				{
					for(i=390;i>=10;i--)
					{
						bt1.setBounds(i,10,100,30);
						try
						{
							sleep(10);
						}
						catch(Exception e)
						{
							System.out.println("Error! "+e);
						}
					}
				}
			}
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt1)
		{

			if(bt1.isSelected()&&ch==0)
			{

				bt1.setText("Stop");
				t.start();
				ch=1;
			}
			if(bt1.isSelected()&&ch==1)
			{
				bt1.setText("Stop");
				t.resume();
			}
			if(!bt1.isSelected())
			{
				bt1.setText("Start");
				t.suspend();
			}
		}
	}
}
