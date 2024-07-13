package com.xcode.javas.zedsoftware.applets;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Calculator extends JApplet implements ActionListener
{
	JButton bt_1,bt_2,bt_3,bt_,bt_4,bt_5,bt_6,bt_7,bt_8,bt_9,bt_0,bt_dot,bt_add,bt_sub,bt_mul,bt_div,bt_back,bt_exit,bt_eq,bt_ca;
	String temp="",operator="";
	JTextField tf1;
	public void init()
	{
		Container cn=getContentPane();
		cn.setLayout(null);
		Font fn=new Font("Times New Roman",Font.PLAIN, 24);
		Color cl_blue=new Color(128,128,255);
		Color cl_red=new Color(255,0,0);
		Color cl_lightred=new Color(255,128,128);
		
		tf1=new JTextField();
		tf1.setFont(fn);
		tf1.setHorizontalAlignment(tf1.RIGHT);
		
		tf1.setBackground(Color.pink);
		tf1.setForeground(Color.red);
		
		bt_1=new JButton("1");
		bt_2=new JButton("2");
		bt_3=new JButton("3");
		bt_4=new JButton("4");
		bt_5=new JButton("5");
		bt_6=new JButton("6");		
		bt_7=new JButton("7");
		bt_8=new JButton("8");
		bt_9=new JButton("9");
		bt_0=new JButton("0");
		bt_dot=new JButton(".");
		bt_div=new JButton("/");
		bt_mul=new JButton("*");
		bt_sub=new JButton("-");
		bt_add=new JButton("+");
		bt_back=new JButton("<=");
		bt_eq=new JButton("=");
		bt_ca=new JButton("CA");
		bt_exit=new JButton("Exit");
		
		
		tf1.setBounds(10,10,290,50);
		
		
		bt_7.setBounds(10,70,50,50);
		bt_8.setBounds(70,70,50,50);
		bt_9.setBounds(130,70,50,50);
		
		bt_4.setBounds(10,130,50,50);
		bt_5.setBounds(70,130,50,50);
		bt_6.setBounds(130,130,50,50);
		
		bt_1.setBounds(10,190,50,50);
		bt_2.setBounds(70,190,50,50);
		bt_3.setBounds(130,190,50,50);
		
		
		bt_0.setBounds(10,250,110,50);
		bt_dot.setBounds(130,250,50,50);
		bt_div.setBounds(190,70,50,50);
		bt_mul.setBounds(190,130,50,50);
		bt_sub.setBounds(190,190,50,50);
		bt_add.setBounds(190,250,50,50);
		bt_back.setBounds(250,70,50,50);
		bt_ca.setBounds(250,130,50,50);
		bt_eq.setBounds(250,190,50,110);
		bt_exit.setBounds(10,310,290,50);
		
		
		bt_exit.setBackground(cl_red);
		bt_eq.setBackground(Color.GREEN);
		bt_back.setBackground(cl_blue);
		bt_1.setBackground(cl_blue);
		bt_2.setBackground(cl_blue);
		bt_3.setBackground(cl_blue);
		bt_4.setBackground(cl_blue);
		bt_5.setBackground(cl_blue);
		bt_6.setBackground(cl_blue);
		bt_7.setBackground(cl_blue);
		bt_8.setBackground(cl_blue);
		bt_9.setBackground(cl_blue);
		bt_0.setBackground(cl_blue);
		bt_dot.setBackground(cl_blue);
		bt_div.setBackground(cl_blue);
		bt_add.setBackground(cl_blue);
		bt_sub.setBackground(cl_blue);
		bt_mul.setBackground(cl_blue);
		bt_ca.setBackground(cl_lightred);
		
		
		cn.add(bt_1);
		cn.add(bt_2);
		cn.add(bt_3);
		cn.add(bt_4);
		cn.add(bt_5);
		cn.add(bt_6);
		cn.add(bt_7);
		cn.add(bt_8);
		cn.add(bt_9);
		cn.add(bt_0);
		cn.add(bt_div);
		cn.add(bt_mul);
		cn.add(bt_sub);
		cn.add(bt_add);
		cn.add(bt_back);
		cn.add(bt_dot);
		cn.add(bt_ca);
		cn.add(bt_eq);
		cn.add(bt_exit);
		cn.add(tf1);
		
		bt_1.addActionListener(this);
		bt_2.addActionListener(this);
		bt_3.addActionListener(this);
		bt_4.addActionListener(this);
		bt_5.addActionListener(this);
		bt_6.addActionListener(this);
		bt_7.addActionListener(this);
		bt_8.addActionListener(this);
		bt_9.addActionListener(this);
		bt_0.addActionListener(this);
		bt_dot.addActionListener(this);
		bt_back.addActionListener(this);
		bt_ca.addActionListener(this);
		bt_eq.addActionListener(this);
		bt_add.addActionListener(this);
		bt_div.addActionListener(this);
		bt_sub.addActionListener(this);
		bt_mul.addActionListener(this);
		bt_exit.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt_1)
		{
			tf1.setText(tf1.getText()+"1");
			temp=tf1.getText();
		}
			
		if(ae.getSource()==bt_2)
		{
			tf1.setText(tf1.getText()+"2");
			temp=tf1.getText();
		}
		if(ae.getSource()==bt_3)
		{
			tf1.setText(tf1.getText()+"3");
			temp=tf1.getText();
		}
		if(ae.getSource()==bt_4)
		{
			tf1.setText(tf1.getText()+"4");
			temp=tf1.getText();
		}
		if(ae.getSource()==bt_5)
		{
			tf1.setText(tf1.getText()+"5");
			temp=tf1.getText();
		}
		if(ae.getSource()==bt_6)
		{
			tf1.setText(tf1.getText()+"6");
			temp=tf1.getText();
		}
		if(ae.getSource()==bt_7)
		{
			tf1.setText(tf1.getText()+"7");
			temp=tf1.getText();
		}
		if(ae.getSource()==bt_8)
		{
			tf1.setText(tf1.getText()+"8");
			temp=tf1.getText();
		}
		if(ae.getSource()==bt_9)
		{
			tf1.setText(tf1.getText()+"9");
			temp=tf1.getText();
		}
		if(ae.getSource()==bt_0)
		{
			tf1.setText(tf1.getText()+"0");
			temp=tf1.getText();
		}
		if(ae.getSource()==bt_dot)
		{
			tf1.setText(tf1.getText()+".");
			temp=tf1.getText();
		}
			
		
		if(ae.getSource()==bt_add)
		{
			
			operator="+";
			temp=tf1.getText();
			tf1.setText("");
		}
		
		if(ae.getSource()==bt_sub)
		{
			operator="-";
			temp=tf1.getText();
			tf1.setText("");
		}
		
		if(ae.getSource()==bt_mul)
		{
			operator="*";
			temp=tf1.getText();
			tf1.setText("");
		}
		
		if(ae.getSource()==bt_div)
		{
			operator="/";
			temp=tf1.getText();
			tf1.setText("");
		}
		
		if(ae.getSource()==bt_eq)
		{
			double i=Double.valueOf(temp);
			double j=Double.valueOf(tf1.getText());
			if(operator.equals("+"))
			tf1.setText(""+(i+j));
			
			if(operator.equals("-"))
			tf1.setText(""+(i-j));
			
			if(operator.equals("*"))
			tf1.setText(""+(i*j));
			
			if(operator.equals("/"))
			tf1.setText(""+(i/j));
			
			temp=tf1.getText();	
		
		}
		
		
		if(ae.getSource()==bt_back)
		{
			String operand=tf1.getText();
			int l=operand.length();
			tf1.setText(operand.substring(0,l-1));
		}
		
		if(ae.getSource()==bt_ca)
		{
			tf1.setText("");
		}
	}
}