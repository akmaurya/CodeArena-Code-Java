package com.xcode.javas.zedsoftware.rough;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class cmb4 extends JApplet implements MouseListener
{
	JComboBox cb1,cb2,cb3;
	int i;
	String str[]={"Jan","Feb","Mar","April","May","June","July","Agu","Sep","Oct","Nov","Dec"};
	public void init()
	{
		Container cn=getContentPane();
		cn.setLayout(null);
		cb1=new JComboBox();
		cb1.setBounds(50,50,100,25);
		cn.add(cb1);
		cb1.addItem("Select Year");
		for(i=1970;i<=2014;i++)
		{
			cb1.addItem(i);
		}
		cb2=new JComboBox();
		cb2.setBounds(200,50,100,25);
		cn.add(cb2);
		cb2.addItem("Select Month");
		for(i=0;i<12;i++)
		{
			cb2.addItem(str[i]);
		}
		cb3=new JComboBox();
		cb3.setBounds(350,50,100,25);
		cn.add(cb3);
		cb3.addItem("Select Date");
		cb3.addMouseListener(this);	
	}
/*	public void focusGained(FocusEvent me)
	{
		
	}
	public void focusLost(FocusEvent me)
	{
		if(cb2.getSelectedIndex()==1)
		{
			for(i=1;i<=31;i++)
			cb3.addItem(i);
		}
	}*/
	
	public void mousePressed(MouseEvent me)
	{
		if(cb2.getSelectedIndex()==1)
		{
			for(i=1;i<=31;i++)
			cb3.addItem(i);
		}
	}
	public void mouseReleased(MouseEvent me)
	{
	}
	public void mouseClicked(MouseEvent me)
	{
	}
	public void mouseEntered(MouseEvent me)
	{
	}
	public void mouseExited(MouseEvent me)
	{
	}
}