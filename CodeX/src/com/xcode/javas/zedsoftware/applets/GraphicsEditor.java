package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GraphicsEditor extends JApplet implements KeyListener
{
	int i=0,k;
	Graphics g;
	JTextField tf;
	Container cn;
	String str1="",str2;
	Color containerColor;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		g=cn.getGraphics();
		tf=new JTextField();
		tf.setBounds(10,10,200,30);
		cn.add(tf);
		
		containerColor=new Color(238,238,238);
		tf.addKeyListener(this);
	}
		
	
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode()!=ke.VK_BACK_SPACE)
		{
			i=i+8;
			g.setColor(Color.red);
			str1=str2=""+ke.getKeyChar();
			g.drawString(str2,50+i,50);
		}
		
		if(ke.getKeyCode()==ke.VK_BACK_SPACE)
		{
			g.setColor(containerColor);
			g.fillRect(50+i,40,8,12);
			i=i-8;
		}
		
	}
	
	public void keyTyped(KeyEvent ke)
	{
	}
	
	public void keyReleased(KeyEvent ke)
	{
	}
	
}