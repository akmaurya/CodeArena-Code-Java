import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
class AboutUs
{
	JInternalFrame frm;
	JPanel p;
	public AboutUs(JDesktopPane dp1)
	{
		frm=new JInternalFrame("About Us",false,true,false,false);
		Container cn=frm.getContentPane();
		frm.setBackground(new Color(154,238,166));
		cn.setLayout(new BorderLayout());
		LineBorder lb=new LineBorder(Color.RED,1);
		p=new JPanel();
		p.setBorder(lb);
		p.setOpaque(true);
		p.setLayout(new BorderLayout());
		//p.setBounds(25,15,620,560);
		cn.add(p);
		
		JLabel msg=new JLabel(new ImageIcon("logo.gif"));
		msg.setHorizontalAlignment(JLabel.CENTER);
		//msg.setBounds(30,5,555,25);
		p.add(msg);
		
		frm.reshape(120,50,569,400);
		dp1.add(frm);
		frm.setVisible(true);
	}
}
