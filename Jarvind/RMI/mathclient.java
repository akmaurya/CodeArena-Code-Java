import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.*;
import java.rmi.registry.*;
class math extends JFrame implements ActionListener
{
	JLabel lb1,lb2,lb3;
	JTextField tf1,tf2,tf3;
	JButton bt1,bt2;
	public static void main(String a[])
	{
		math frm=new math();
		frm.setSize(500,400);
		frm.setVisible(true);
	}
	public math()
	{
		Container cn=getContentPane();
		cn.setLayout(null);
		
		lb1=new JLabel("Enter First No."); 	
		lb2=new JLabel("Enter Second No.");
		lb3=new JLabel("Result");
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		
		bt1=new JButton("Add");
		bt2=new JButton("Average");
		
		lb1.setBounds(40,70,100,25);
		lb2.setBounds(40,100,100,25);
		lb3.setBounds(40,150,100,25);
		
		tf1.setBounds(170,70,150,25);
		tf2.setBounds(170,100,150,25);
		tf3.setBounds(170,150,150,25);
		
		
		
	//	tf1.setBackground(Color.GRAY);
		bt1.setBounds(80,220,100,25);
		bt2.setBounds(220,220,100,25);
		
		tf3.setEditable(false);
		
		cn.add(lb1);
		cn.add(lb2);
		cn.add(lb3);
		
		cn.add(tf1);
		cn.add(tf2);
		cn.add(tf3);
		
		cn.add(bt1);
		cn.add(bt2);
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		System.out.println("This is Performed");
		if(ae.getSource()==bt1)
		{
			try
			{
				int x=Integer.parseInt(tf1.getText());
				int y=Integer.parseInt(tf2.getText());
				mathmenu mt= (mathmenu)Naming.lookup("rmi://127.0.0.1:5000/mathdemo");
				int sm=mt.addition(x,y);
				tf3.setText(""+sm);
			}
			catch(Exception e)
			{
			}
		}
		
		if(ae.getSource()==bt2)
		{
			try
			{
				double x=Double.valueOf(tf1.getText());
				double y=Double.valueOf(tf2.getText());
				mathmenu mt= (mathmenu)Naming.lookup("rmi://127.0.0.1:5000/mathdemo");
				double sm=mt.getaverage(x,y);
				tf3.setText(""+sm);
			}
			catch(Exception e)
			{
			}
		}
	}
}
