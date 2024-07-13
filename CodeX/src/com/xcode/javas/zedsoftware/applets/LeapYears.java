package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LeapYears extends JApplet implements MouseListener
{
	int i=0;
	JLabel lb;
	String m[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
	JComboBox cmby,cmbm,cmbd;
	Container cn;
	Graphics g;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		g=cn.getGraphics();
		
		cmby=new JComboBox();
		cmbm=new JComboBox();
		cmbd=new JComboBox();
		
		lb=new JLabel("Select Your Age");
		lb.setBounds(10,10,150,30);
		
		cmby.setBounds(10,50,150,30);
		cmbm.setBounds(170,50,150,30);
		cmbd.setBounds(330,50,150,30);
		
		cmby.addItem("Select Year");
		for(int i=1960;i<=2014;i++)
		cmby.addItem(""+i);
		
		
		cmbm.addItem("Select Month");
		for( i=0;i<12;i++)
		cmbm.addItem(m[i]);
		
		cmbd.addItem("Select Day");
		for(int i=1;i<=31;i++)
		cmbd.addItem(""+i);
		
		cn.add(lb);
		cn.add(cmby);
		cn.add(cmbm);
		cn.add(cmbd);
		
		cmbm.addMouseListener(this);
	}
	
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource()==cmbm)
		{
			System.out.println("\n\n\n"+cmby.getSelectedIndex());
			if(cmby.getSelectedIndex()==55)
			for(i=12;i>6;i--)
			cmbm.removeItemAt(i);
		}
	}
	
	public void mouseClicked(MouseEvent me)
	{
	}
	
	public void mouseReleased(MouseEvent me)
	{
	}
	
	public void mouseEntered(MouseEvent me)
	{
	}
	
	public void mouseExited(MouseEvent me)
	{
	}
}