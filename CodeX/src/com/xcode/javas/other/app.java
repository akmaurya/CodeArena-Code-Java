package com.xcode.javas.other;
import javax.swing.*;
import java.awt.*;
class app extends JApplet
{
	String nm;
	public void init()
	{
		nm="Java Applet";
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		//g.drawString(nm,25,25);
		g.drawLine(100,100,200,200);
		g.setColor(Color.blue);
		g.drawLine(110,100,210,200);
		g.setColor(Color.green);
		g.drawLine(50,25,100,125);
	}
}