package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class appToGph extends JApplet implements ActionListener
{
	Graphics g;
	JTextField tf;
	JButton bt;
	Container cn;
	String str1="",str2;
	Color containerColor;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		g=cn.getGraphics();
		tf=new JTextField();
		bt=new JButton("OK");
		tf.setBounds(10,10,200,30);
		bt.setBounds(220,10,60,30);
		cn.add(tf);
		cn.add(bt);
		
		containerColor=new Color(238,238,238);
		
		tf.addActionListener(this);
		bt.addActionListener(this);
	}
		
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt)
		{
			g.setColor(containerColor);
			g.drawString(str1,50,50);
			g.setColor(Color.red);
			str1=str2="Hello Mr. "+tf.getText();
			g.drawString(str2,50,50);
			
			
			
		}
	}
	
}