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

class staffLogin extends JFrame implements ActionListener,KeyListener
{
	JInternalFrame staffloginfrm;
	JPanel p1;
	JLabel lb_Date;
	JButton bt_pre;
	int getCode=0;
	ZedInterface inf;
	public staffLogin(JDesktopPane dp1,int ID)
	{
		getCode=ID;
		System.out.println("getID "+getCode);
		Color c1=new Color(60,220,220);
		staffloginfrm=new JInternalFrame("STAFF ATTENDANCE WINDOW",true,true,false,true);
		Container cn=staffloginfrm.getContentPane();
		cn.setLayout(null);
		
 		cn.setBackground(c1);
		staffloginfrm.setBounds(200,100,350,180);
		
		Color fcl=new Color(0,0,128);
		Font fnt=new Font("Arial Narrow",Font.BOLD,9);
		p1=new JPanel();
		p1.setBounds(10,15,320,120);
		p1.setLayout(null);
		p1.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Staff Login");
		p1.setBorder(tb);
		p1.setOpaque(true);
		
		p1.setFont(fnt);
		
		Color clBK=new Color(128,255,225);
	
		JLabel lb1=new JLabel("DATE");
		lb1.setForeground(fcl);
		lb1.setOpaque(false);
		lb1.setBounds(30,25,80,20);
		p1.add(lb1);
		
		java.util.Date DT=new Date();
		String setDate=(DT.getDate())+"/"+(DT.getMonth()+1)+"/"+(DT.getYear()+1900);
		
		lb_Date=new JLabel(setDate,JLabel.CENTER);
		lb_Date.setForeground(fcl);
		lb_Date.setOpaque(true);
		lb_Date.setBackground(clBK);
		lb_Date.setBounds(130,25,148,25);
		p1.add(lb_Date);
		
		bt_pre=new JButton("Present",new ImageIcon("icons\\save.gif"));
		bt_pre.setMnemonic('s');
		bt_pre.setBounds(40,70,235,30);
		bt_pre.setToolTipText("Save");
		p1.add(bt_pre);
		
		cn.add(p1);
		dp1.add(staffloginfrm);
		staffloginfrm.setVisible(true);
		
		bt_pre.addActionListener(this);
                bt_pre.addKeyListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt_pre)
		{
			loginRegister();
		}
	}
        public void keyPressed(KeyEvent ke)
	{
		if(ke.getSource()==bt_pre && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			loginRegister();
		}
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	private void loginRegister()
	{
		try
		{
			 //   ZedInterface patientsd=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
			
			
			
			
			
			
			
			String qry="Select attend_Dt from staff_AttendanceRegister where s_Code="+getCode+" order by attend_Dt desc";
			System.out.println("qry "+qry);
			String getdt=inf.getSingleValue(qry);
			System.out.println("last date"+getdt);
			if(getdt!=null)
			{
				String split_wholeDate[]=getdt.split("-");
				System.out.println("0 "+split_wholeDate[0]);
				int Y=Integer.parseInt(split_wholeDate[0]);
		
				System.out.println("1 "+split_wholeDate[1]);
				int M=Integer.parseInt(split_wholeDate[1]);
		
				System.out.println("2 "+split_wholeDate[2]);
		
					
				String split_Date[]=split_wholeDate[2].split(" ");
				System.out.println("0 "+split_Date[0]);
				int D=Integer.parseInt(split_Date[0]);
		
				System.out.println("1 "+split_Date[1]);
		
				String split_Time[]=split_Date[1].split(":");
				System.out.println("0 "+split_Time[0]);
				int H=Integer.parseInt(split_Time[0]);
		
				System.out.println("1 "+split_Time[1]);
				int MIN=Integer.parseInt(split_Time[1]);
		
				System.out.println("2 "+split_Time[2]);
				int S=Integer.parseInt(split_Time[2]);
		
			//	String set_Date=M+"/"+D+"/"+Y+" "+H+":"+MIN+":"+S;
			String set_Date=M+"/"+D+"/"+Y;
				System.out.println("set_Date "+set_Date);
				
				java.util.Date dt=new Date();
			String setdate=(dt.getMonth()+1)+"/"+(dt.getDate())+"/"+(dt.getYear()+1900);
				if(!set_Date.equals(setdate))
				{
					
				
					qry=("insert into staff_AttendanceRegister values("+getCode+",#"+setdate+"#)");
					boolean successful1=inf.executeUpdateQuery(qry);
					System.out.println("successful 1"+successful1);
					staffloginfrm.dispose();	
				}
				else 
				{
					JOptionPane.showMessageDialog(this,"Already Attended Today","MESSAGE",JOptionPane.ERROR_MESSAGE);
					
				}
			
				
				
				
			}
			if(getdt==null)
			{
				java.util.Date dt=new Date();
			String setdate=(dt.getMonth()+1)+"/"+(dt.getDate())+"/"+(dt.getYear()+1900);
			
					
				
					qry=("insert into staff_AttendanceRegister values("+getCode+",#"+setdate+"#)");
					boolean successful1=inf.executeUpdateQuery(qry);
					System.out.println("successful 1"+successful1);
					staffloginfrm.dispose();	
			
			
			
			}
			
			
			
			
			
			
			
			
			
			
			
				
				
		}
		catch(Exception ex)	
		{
			System.out.println("EEROR IN LOGIN METHOD"+ex);
		}
		
	}
	
}