package com.xcode.javas.zedsoftware.swing.progress;

import java.awt.*;
import javax.swing.*;

class Prgss1 extends JFrame
{
    JToggleButton bt1;
    JProgressBar pb1;
	public static void main(String[] args)
	{
		Prgss1 frm=new Prgss1();
		frm.setSize(300,400);
		frm.setVisible(true);
	}
	public Prgss1()
	{
        Container cn=getContentPane();
		cn.setLayout(null);
		bt1=new JToggleButton("Start");

		bt1.setBounds(20,100,100,30);

		cn.add(bt1);

        pb1=new JProgressBar();
        pb1.setBounds(20,50,200,30);


    //    bt1.addActionListener(this);


	}
}
