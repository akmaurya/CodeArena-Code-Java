package com.xcode.javas.other.swing.frontend;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JButton;

public class Front extends JFrame
{
	JButton ok,cancel;

	public static void main(String[] args)
	{
		Front ob=new Front();
		ob.setSize(600, 500);
		ob.setVisible(true);

	}
	public Front()
	{
		Container obj=getContentPane();
		obj.setLayout(null);
		ok=new JButton("Ok");
		ok.setBounds(180, 380, 80, 30);
		obj.add(ok);
		cancel=new JButton("Cancel");
		cancel.setBounds(300, 380, 80, 30);
		obj.add(cancel);				
	}

}
