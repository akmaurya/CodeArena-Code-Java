package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Shapes extends JApplet implements ActionListener, MouseMotionListener
{
	JLabel l_shape,l_color;
	JComboBox cmb_shape,cmb_color;
	Container cn;
	Graphics g;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		g=cn.getGraphics();
		
		l_shape=new JLabel("Shape");
		l_color=new JLabel("Color");
		
		l_shape.setBounds(10,10,100,30);
		l_color.setBounds(10,50,100,30);
		
		cmb_shape=new JComboBox();
		cmb_color=new JComboBox();
		
		cmb_shape.setBounds(110,10,150,30);
		cmb_color.setBounds(110,50,150,30);
		
		cmb_shape.addItem("Select Shape");
		cmb_shape.addItem("Circle");
		cmb_shape.addItem("Square");
		cmb_shape.addItem("Line");
		
		cmb_color.addItem("Select Color");
		cmb_color.addItem("Red");
		cmb_color.addItem("Green");
		cmb_color.addItem("Blue");
		
		cn.add(l_shape);
		cn.add(l_color);
		cn.add(cmb_shape);
		cn.add(cmb_color);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cn)
		{
			if((""+cmb_shape.getSelectedItem()).equals("Circle"))
			cmb_shape.addItem("circle");
		}
	}
	
	public void mouseMoved(MouseEvent me)
	{
	}
	
	public void mouseDragged(MouseEvent me)
	{
	}
}