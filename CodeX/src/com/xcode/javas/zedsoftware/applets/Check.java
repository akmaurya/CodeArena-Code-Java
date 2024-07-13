package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Check extends JApplet implements ActionListener
{
	JCheckBox ch_play,ch_read,ch_sing,ch_dance;
	JPanel pl1,pl2;
	Container cn;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		
		
		pl1=new JPanel();
		pl1.setBounds(10,10,400,150);
	
		pl2=new JPanel();
		pl2.setBounds(10,180,400,80);
		
		pl1.setLayout(null);
		pl2.setLayout(null);
		
		pl1.setBorder(new BevelBorder(BevelBorder.RAISED));
		pl2.setOpaque(true);
		pl2.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JLabel lb=new JLabel("Select Your Hobies");
		lb.setBounds(10,10,300,30);
			
		pl2.setBackground(Color.red);
		
		ch_play=new JCheckBox("Play");
		ch_read=new JCheckBox("Read");
		ch_sing=new JCheckBox("Sing");
		ch_dance=new JCheckBox("Dance");
		
		ch_play.setBounds(50,50,100,30);
		ch_read.setBounds(50,100,100,30);
		ch_sing.setBounds(180,50,100,30);
		ch_dance.setBounds(180,100,100,30);
		
		ButtonGroup bg=new ButtonGroup();
		cn.add(ch_play);
		cn.add(ch_read);
		cn.add(ch_sing);
		cn.add(ch_dance);
		
		
		
		cn.add(pl1);
		cn.add(pl2);
		pl1.add(lb);
		pl1.add(ch_play);
		pl1.add(ch_read);
		pl1.add(ch_sing);
		pl1.add(ch_dance);
		
		
		ch_play.addActionListener(this);
		ch_read.addActionListener(this);
		ch_sing.addActionListener(this);
		ch_dance.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("Printed");
		/*if(rb_red.isSelected())
		pl.setBackground(Color.red);
		
		if(ae.getSource()==rb_black)
		pl.setBackground(Color.black);
		if(rb_blue.isSelected())
		pl.setBackground(Color.blue);
		
		if(rb_green.isSelected())
		pl.setBackground(Color.green);
		
		if(rb_yellow.isSelected())
		pl.setBackground(Color.yellow);
		*/

		
	}
}