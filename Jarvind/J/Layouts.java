import javax.swing.*;
import java.awt.*;
public class Layouts extends JApplet
{
	public void init()
	{
		Container cn=getContentPane();
	//	FlowLayout fl=new FlowLayout();
	//	BorderLayout bl=new BorderLayout();
	//	GridLayout gl=new GridLayout(2,2);
		cn.setLayout(null);
		JButton bt1=new JButton("Rajat");
		bt1.setBounds(10,10,100,30);
		
		JButton bt2=new JButton("Suraj");
		bt2.setBounds(10,50,100,30);
		
		JButton bt3=new JButton("Surajat");
		bt3.setBounds(10,90,100,30);
		
		JButton bt4=new JButton("S.K. Maurya");
		bt4.setBounds(10,130,100,30);
	
		JButton bt5=new JButton("R.K. Maurya");
		bt5.setBounds(10,170,100,30);
		cn.add(bt1);
		cn.add(bt2);
		cn.add(bt3);
		cn.add(bt4);
		cn.add(bt5);
	}
	
}