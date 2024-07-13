package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class mouse extends JApplet implements MouseMotionListener
{
	Container cn;
	JTextField tf1;
	JLabel lb;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		tf1=new JTextField();
		tf1.setBounds(10,10,100,30);
		
		lb=new JLabel();
		cn.add(tf1);
		cn.add(lb);
		
		cn.addMouseMotionListener(this);
		
	}
	
	public void mouseMoved(MouseEvent me)
	{
		int x=me.getX();
		int y=me.getY();
		tf1.setText(x+", "+y);
		
		lb.setBounds(x+10,y+10,100,30);
		lb.setText(x+", "+y);
				
	}
	
	public void mouseDragged(MouseEvent me)
	{
		
	}
	

}