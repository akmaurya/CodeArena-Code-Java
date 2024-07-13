package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class word extends JApplet implements KeyListener
{
	JTextField tf;
	Container cn;
	public void init()
	{
		cn=getContentPane();
		cn.setLayout(null);
		
		tf=new JTextField();
		tf.setBounds(10,10,200,30);
		cn.add(tf);
		
		tf.addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent ke)
	{
		String setWord, totalWord;
		if(ke.getKeyCode()==ke.VK_SPACE)
		{
			setWord="";
			totalWord=tf.getText();
			String splitWord[]=totalWord.split(" ");
			int l=splitWord.length;
			//System.out.println("it is ok-1, len = "+l);
			if(l>1)
			{
			//	System.out.println("it is ok-2, len= "+l);
				splitWord[l-1]="zed";
				for(int i=0;i<l;i++)
				setWord=setWord+splitWord[i]+" ";
				tf.setText(setWord);
			}
			else
			tf.setText("zed");
		}
		
	}
	
	public void keyTyped(KeyEvent ke)
	{
	}
	
	public void keyReleased(KeyEvent ke)
	{
	}
	
}