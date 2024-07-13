package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class moveable extends JApplet implements KeyListener
{
	JButton bt1;
	JTextField tf1,tf2;
	public void init()
	{
		Container cn=getContentPane();
		cn.setLayout(null);
		bt1=new JButton("Catch Me");
		tf1=new JTextField();
		tf2=new JTextField();
		
		bt1.setBounds(10,10,100,30);
		tf1.setBounds(150,50,200,30);
		tf2.setBounds(150,90,200,30);
		
		
		cn.add(bt1);
		cn.add(tf1);
		cn.add(tf2);
		
		
		th t=new th();
		t.start();
		
		
		tf1.addKeyListener(this);
		tf2.addKeyListener(this);
	}
	
	class th extends Thread
	{
		public void run()
		{
			for(int i=10;i<=390;i++)
			{
				if(i<390)			
				{	
					bt1.setBounds(i,250,100,30);
					tf1.setBounds(150,500-i,200,30);
					tf2.setBounds(150,90+i,200,30);
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
						bt1.setBounds(i,250,100,30);
						tf1.setBounds(150,500-i,200,30);
						tf2.setBounds(150,90+i,200,30);
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
	
	
	public void keyPressed(KeyEvent ke)
	{
	}
	public void keyTyped(KeyEvent kt)
	{
	}
	public void keyReleased(KeyEvent kr)
	{
		if(kr.getSource()==tf1)
		{
			tf2.setText(tf1.getText());
		}
		
		if(kr.getSource()==tf2)
		{
			tf1.setText(tf2.getText());
		}
	}
}