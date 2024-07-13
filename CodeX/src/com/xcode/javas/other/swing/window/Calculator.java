package com.xcode.javas.other.swing.window;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener
{

	JButton ok, cancle;
	JTextField name;
	public static void main(String[] args)
	{
		Calculator frm=new Calculator();
		frm.setSize(300, 200);
		frm.setVisible(true);
	}
	
	public Calculator()
	{
		Container cn=getContentPane();
		cn.setLayout(null);
		ok=new JButton("OK");
		ok.setBounds(10, 10, 100, 30);
		cn.add(ok);
		
		cancle=new JButton("Cancle");
		cancle.setBounds(120, 10, 100, 30);
		cn.add(cancle);
		
		name=new JTextField("Enter Name");
		name.setBounds(10, 50, 210, 40);
		cn.add(name);
		
		ok.addActionListener(this);
		cancle.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==ok)
		{
			name.setText("It is working"+name.getText());
		}
		if(e.getSource()==cancle)
		{
			System.exit(0);
		}
	}

}
