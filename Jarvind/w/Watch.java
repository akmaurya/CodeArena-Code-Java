import java.awt.*;
import javax.swing.*;

class Watch extends JFrame
{
	public static void main(String a[])
	{
		JFrame watchWindow=new JFrame("Watch");
		watchWindow.setSize(300,300);
		watchWindow.setVisible(true);
	//	Container cn=watchWindow.getContentPane();
		Graphics g=watchWindow.getGraphics();
		g.setColor(Color.red);
		g.drawLine(25,25,200,200);
	//	cn.setLayout(null);
		
		JButton bt=new JButton("Check");
		bt.setBounds(50,50,100,30);
	//	cn.add(bt);
	}
}