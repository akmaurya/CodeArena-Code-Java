package com.xcode.javas.pakistanuniversity;
import javax.swing.*;

class IO
{
	public static void main(String argsp[])
	{
		String input=JOptionPane.showInputDialog("Enter the value");
		int num=Integer.parseInt(input);
		int square=num*num;
		System.out.println("square"+square);
		JOptionPane.showMessageDialog(null,"Square:"+square);
		System.exit(0);

	}
}