package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GraphicsTextEditor extends JApplet implements KeyListener
{
	int i=0,j=0;
	Graphics g;
	Container cn;
	String str1="",str2;
	Color containerColor;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		g=cn.getGraphics();
		cn.requestFocus();
		containerColor=new Color(238,238,238);
		cn.addKeyListener(this);
	}
		
	
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode()!=ke.VK_BACK_SPACE)
		{
			g.setColor(Color.red);
			str1=str2=""+ke.getKeyChar();
			if(i>=0&&i<=300)
			{
				i=i+8;
				g.drawString(str2,50+i,50+j);
			}
			if(i>300)
			{
				System.out.println(""+ke.getKeyCode());
				i=0;
				j=j+15;
			}
		}
		
		if(ke.getKeyCode()==ke.VK_BACK_SPACE)
		{
			g.setColor(containerColor);
			g.fillRect(50+i,40+j,8,12);
			if(i>=8)
			i=i-8;
			if(i<5&&j>=0)
			{
				i=300;
				j=j-15;
			}
		}
		
		if(ke.getKeyCode()==ke.VK_ENTER)
		{
			i=0;
			j=j+15;
		}
		
	}
	
	public void keyTyped(KeyEvent ke)
	{
	}
	
	public void keyReleased(KeyEvent ke)
	{
	}
	
}