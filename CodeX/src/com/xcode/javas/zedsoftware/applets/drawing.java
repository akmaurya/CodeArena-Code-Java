package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class drawing extends JApplet implements /*MouseListener, MouseMotionListener*/ KeyListener
{
	Container cn;
	Graphics g;
	Color containerColor;
	int x,y;
	String str="";
	JButton cre,rem;
	JLabel crel,reml;
	JTextField jtf;
	static int i=10;

	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		g=cn.getGraphics();
		containerColor=new Color(238,238,238);
		
		cre=new JButton("Draw");
		rem=new JButton("Remove");
		jtf=new JTextField();
		
		cre.setBounds(10,10,70,30);
		rem.setBounds(90,10,70,30);
		reml=new JLabel();
		crel=new JLabel();
		cn.add(cre);
		cn.add(rem);
		cn.add(crel);
		cn.add(reml);
		jtf.requestFocus();
		
/*		cre.addMouseListener(this);
		rem.addMouseListener(this);
		
		cn.addMouseListener(this);
		cn.addMouseMotionListener(this);*/
		
		cn.addKeyListener(this);
	}
/*	
	public void mousePressed(MouseEvent me)
	{
		if((me.getSource()==cn)&&(str.equals("1")))
		{
			reml.setOpaque(false);
			x=me.getX();
			y=me.getY();
			
			System.out.println("This is Ok-1");
			g.setColor(Color.red);
			g.drawLine(x,y,x,y);
			
		}
		
		if((me.getSource()==cn)&&(str.equals("2")))
		{
			x=me.getX();
			y=me.getY();
			System.out.println("This is Ok-2");
			
			g.setColor(containerColor);
			g.drawLine(x-5,y-5,x,y);
		}
	}
	
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==cre)
		{
			str="1";
		}
		
		if(me.getSource()==rem)
		{
			str="2";
		}
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
	
	public void mouseMoved(MouseEvent me)
	{
		if(str.equals("2"))
		{
			x=me.getX();
			y=me.getY();
			reml.setBounds(x-5,y-5,10,10);
		//	reml.setOpaque(true);
			//reml.setBackground(Color.BLUE);
		}
		
	}
	
	public void mouseDragged(MouseEvent me)
	{
		if((me.getSource()==cn)&&(str.equals("1")))
		{
			reml.setOpaque(false);
			x=me.getX();
			y=me.getY();
			
			System.out.println("This is Ok-1");
			g.setColor(Color.red);
			g.drawLine(x,y,x,y);
			
		}
		if((me.getSource()==cn)&&(str.equals("2")))
		{
			x=me.getX();
			y=me.getY();
			System.out.println("This is Ok-2");
			reml.setBounds(x-5,y-5,10,10);
			reml.setOpaque(true);
			reml.setBackground(Color.BLUE);
			g.setColor(containerColor);
			g.drawLine(x-5,y-5,x,y);
		}
	}
*/


	public void keyPressed(KeyEvent ke)
	{
		if(ke.getSource()==cn)
		{
			
			g.drawString(""+ke.getKeyChar(),i++,130);	
			jtf.requestFocus();
		}
		
	}
	
	public void keyTyped(KeyEvent ke)
	{
	}
	
	public void keyReleased(KeyEvent ke)
	{
	}
}