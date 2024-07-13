package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class RadioColor extends JApplet implements ActionListener
{
	JRadioButton rb_red,rb_green,rb_blue,rb_black,rb_yellow;
	JPanel pl,pl2;
	Container cn;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		
		pl=new JPanel();
		pl.setBounds(10,110,400,250);
		pl2=new JPanel();
		
		pl2.setBounds(10,10,400,90);
		pl.setLayout(null);
		pl2.setLayout(null);
		pl2.setBorder(new BevelBorder(BevelBorder.RAISED));
		pl.setOpaque(true);
		pl.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JLabel lb=new JLabel("Change Background Color");
		pl.setBackground(Color.red);
		lb.setBounds(10,10,300,30);
		
		rb_red=new JRadioButton("Red",true);
		rb_green=new JRadioButton("Green");
		rb_blue=new JRadioButton("Blue");
		rb_black=new JRadioButton("Black");
		rb_blue=new JRadioButton("Blue");
		rb_yellow=new JRadioButton("Yellow");
		rb_red.setBounds(10,50,70,30);
		rb_green.setBounds(90,50,70,30);
		rb_blue.setBounds(170,50,70,30);
		rb_black.setBounds(250,50,70,30);
		rb_yellow.setBounds(320,50,70,30);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb_red);
		bg.add(rb_green);
		bg.add(rb_black);
		bg.add(rb_blue);
		bg.add(rb_yellow);
		
		
		
		cn.add(pl);
		cn.add(pl2);
		pl2.add(lb);
		pl2.add(rb_red);
		pl2.add(rb_green);
		pl2.add(rb_black);
		pl2.add(rb_blue);
		pl2.add(rb_yellow);
		
		
		rb_red.addActionListener(this);
		rb_green.addActionListener(this);
		rb_blue.addActionListener(this);
		rb_yellow.addActionListener(this);
		rb_black.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("Printed");
		if(rb_red.isSelected())
		pl.setBackground(Color.red);
		
		if(ae.getSource()==rb_black)
		pl.setBackground(Color.black);
		if(rb_blue.isSelected())
		pl.setBackground(Color.blue);
		
		if(rb_green.isSelected())
		pl.setBackground(Color.green);
		
		if(rb_yellow.isSelected())
		pl.setBackground(Color.yellow);
		

		
	}
}