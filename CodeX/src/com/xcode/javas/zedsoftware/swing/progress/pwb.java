package com.xcode.javas.zedsoftware.swing.progress;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Prgss2 extends JFrame implements ActionListener
{
    th t=new th();
    JToggleButton bt1,bt2;
    JProgressBar pb1;
    char ch=0;
	public static void main(String[] args)
	{
		Prgss2 frm=new Prgss2();
		frm.setSize(300,400);
		frm.setVisible(true);
	}
	public Prgss2()
	{
        Container cn=getContentPane();
		cn.setLayout(null);
		bt1=new JToggleButton("Pause");

		bt1.setBounds(200,100,100,30);

		cn.add(bt1);
		bt2=new JToggleButton("Start");

		bt2.setBounds(20,100,100,30);

		cn.add(bt2);

        pb1=new JProgressBar();
        pb1.setBounds(20,50,300,30);

        cn.add(pb1);

        bt1.addActionListener(this);
        bt2.addActionListener(this);


	}

	class th extends Thread
	{
		public void run()
		{
			for(int i=10;i<=390;i++)
			{
				if(i<390)
				{
					pb1.setValue(i);
					try
					{
						sleep(500);
					}
					catch(Exception e)
					{
						System.out.println("Error! "+e);
					}

				}


			}
		}
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt1)
		{
                System.out.println("it is ok");
			if(bt1.isSelected()&&ch==0)
			{
				bt1.setText("Pause");
				t.start();
				ch=1;
			}
			if(bt1.isSelected()&&ch==1)
			{
				bt1.setText("Pause");
				t.resume();
			}
			if(!bt1.isSelected())
			{
				bt1.setText("Continue");
				t.suspend();
			}
		}

		if(ae.getSource()==bt2)
		{

			if(bt2.isSelected()&&ch==0)
			{
				bt2.setText("Start");
				t.start();
				ch=1;
			}
			if(bt2.isSelected()&&ch==1)
			{
				bt2.setText("Start");
				t.resume();
			}
			if(!bt2.isSelected())
			{
				bt2.setText("Stop");
				pb1.setValue(0);
				t.stop();
			}
		}
	}
}
