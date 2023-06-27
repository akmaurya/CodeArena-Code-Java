import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.Date;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

class staffLeave extends JFrame implements ActionListener
{
	JInternalFrame staffleavefrm;
	JPanel p1;
	JLabel lb_Date1,lb_Date2;
	JButton bt_pre,bt_addDt1,bt_addDt2;
	JTextField tft_Purpose;
	int getCode=0;
	ZedInterface inf;
	public staffLeave(JDesktopPane dp1,int ID)
	{
		getCode=ID;
		System.out.println("getID "+getCode);
		Color c1=new Color(60,220,220);
		staffleavefrm=new JInternalFrame("STAFF LEAVE WINDOW",true,true,false,true);
		Container cn=staffleavefrm.getContentPane();
		cn.setLayout(null);
		
 		cn.setBackground(c1);
		staffleavefrm.setBounds(200,100,530,240);
		
		Color fcl=new Color(0,0,128);
		Font fnt=new Font("Arial Narrow",Font.BOLD,9);
		p1=new JPanel();
		p1.setBounds(10,15,500,170);
		p1.setLayout(null);
		p1.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Staff Leave");
		p1.setBorder(tb);
		p1.setOpaque(true);
		
		p1.setFont(fnt);
		
		Color clBK=new Color(128,255,225);
	
		JLabel lb1=new JLabel("From");
		lb1.setForeground(fcl);
		lb1.setOpaque(false);
		lb1.setBounds(30,25,80,20);
		p1.add(lb1);
		
		java.util.Date DT=new Date();
		String setDate=(DT.getDate())+"/"+(DT.getMonth()+1)+"/"+(DT.getYear()+1900);
		
		lb_Date1=new JLabel(setDate,JLabel.CENTER);
		lb_Date1.setForeground(fcl);
		lb_Date1.setOpaque(true);
		lb_Date1.setBackground(clBK);
		lb_Date1.setBounds(80,25,148,25);
		p1.add(lb_Date1);
		
		bt_addDt1=new JButton(new ImageIcon("icons\\calendar.gif"));
		bt_addDt1.setBounds(225,25,20,25);
		p1.add(bt_addDt1);
		bt_addDt1.addActionListener(this);
		
		JLabel lb2=new JLabel("To");
		lb2.setForeground(fcl);
		lb2.setOpaque(false);
		lb2.setBounds(260,25,30,20);
		p1.add(lb2);
		
		
		lb_Date2=new JLabel(setDate,JLabel.CENTER);
		lb_Date2.setForeground(fcl);
		lb_Date2.setOpaque(true);
		lb_Date2.setBackground(clBK);
		lb_Date2.setBounds(290,25,148,25);
		p1.add(lb_Date2);
		
		bt_addDt2=new JButton(new ImageIcon("icons\\calendar.gif"));
		bt_addDt2.setBounds(440,25,20,25);
		p1.add(bt_addDt2);
		bt_addDt2.addActionListener(this);
		
		
		JLabel lb3=new JLabel("Enter Purpose");
		lb3.setForeground(fcl);
		lb3.setOpaque(false);
		lb3.setBounds(30,60,120,20);
		p1.add(lb3);
		
		tft_Purpose=new JTextField();
		tft_Purpose.setBounds(120,60,350,30);
		p1.add(tft_Purpose);
		
		
		bt_pre=new JButton("Leave",new ImageIcon("icons\\save.gif"));
		bt_pre.setMnemonic('a');
		bt_pre.setBounds(40,120,430,30);
		bt_pre.setToolTipText("Save");
		p1.add(bt_pre);
		
		cn.add(p1);
		dp1.add(staffleavefrm);
		staffleavefrm.setVisible(true);
		
		bt_pre.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt_addDt1)
		{
			Cal calender=new Cal();
 			String date=calender.getdate();
 			System.out.println("date "+date);
 			lb_Date1.setText(date);
		}
		else if(ae.getSource()==bt_addDt2)
		{
			Cal calender=new Cal();
 			String date=calender.getdate();
 			System.out.println("date "+date);
 			lb_Date2.setText(date);
		}
		else if(ae.getSource()==bt_pre)
		{
			String st="";
			if(!(tft_Purpose.getText().equals(st)))
			{
				leave();
			}
			
		}
		
	}
	private void leave()
	{
		try
		{
			  ///  ZedInterface patientsd=(ZedInterface)Naming.lookup(getIPaddress.IP());
try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
									getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}						  
				
				String getDate1=lb_Date1.getText();
				String getDate2=lb_Date2.getText();
				
				String qry=("insert into staff_LeaveRegister values("+getCode+",#"+getDate1+"#,#"+getDate2+"#,'"+tft_Purpose.getText()+"')");
				boolean successful1=inf.executeUpdateQuery(qry);
				System.out.println("successful 1"+successful1);
				staffleavefrm.dispose();
		}
		catch(Exception ex)	
		{
			System.out.println("EEROR IN LEAVE METHOD"+ex);
		}
		
	}
	
}