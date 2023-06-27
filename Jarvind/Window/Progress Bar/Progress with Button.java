
import java.awt.*;
import javax.swing.*;

class prgss extends JFrame
{
    JToggleButton bt1;
    JProgressBar pb1;
	public static void main(String[] args)
	{
		prgss frm=new prgss();
		frm.setSize(300,400);
		frm.setVisible(true);
	}
	public void prg()
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
