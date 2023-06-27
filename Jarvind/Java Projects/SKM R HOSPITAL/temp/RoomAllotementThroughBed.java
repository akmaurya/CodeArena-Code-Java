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

class RoomAllotementThroughBed extends JFrame implements KeyListener,ActionListener
{
	JInternalFrame roomfrm;
	JPanel pn;
	Date dt1,dt2;
	JTextField tf_patientID;
	JComboBox cb_Ward,cb_BedNo;
	JLabel lbl_Pname,lbl_Addr,lbl_RoomNo;
	JButton bt_ADMIT,bt_CLOSE;
	ZedInterface inf;
	String qry,setip,getward,bedNo,st="",dischargedate=null,room1,bed1,ward1,dischargetime=null;
	int wardCharge=0; 
	
	public RoomAllotementThroughBed(JDesktopPane dp1,String ward,String room,String bed)
	{
		
		roomfrm=new JInternalFrame("ROOM ALLOTEMENT WINDOW",true,true,false,true);
		Container cn=roomfrm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		roomfrm.setBounds(100,50,400,400);
		room1=room;
		bed1=bed;
		ward1=ward;
		Color fcl=new Color(0,0,128);
		Font fnt=new Font("Arial NArrow",Font.BOLD,9);
		pn=new JPanel();
		pn.setBounds(10,20,370,320);
		pn.setLayout(null);
	
		pn.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Room Detail");
		pn.setBorder(tb);
		pn.setOpaque(false);
		pn.setFont(fnt);
		
		Color clBK=new Color(225,248,137);
		JLabel lb1=new JLabel("Enter Patient ID:");
		lb1.setForeground(fcl);
		lb1.setOpaque(false);
		lb1.setBounds(10,20,100,20);
		
		tf_patientID=new JTextField();
		tf_patientID.setBounds(163,20,160,20);
		
		JLabel lb2=new JLabel("Patient Name :");
		lb2.setForeground(fcl);
		lb2.setOpaque(false);
		lb2.setBounds(10,50,120,20);
		
		lbl_Pname=new JLabel();
		lbl_Pname.setForeground(fcl);
		lbl_Pname.setOpaque(true);
		lbl_Pname.setBackground(clBK);
		lbl_Pname.setBounds(163,50,160,20);
		
		JLabel lb3=new JLabel("Address of Patient:");
		lb3.setForeground(fcl);
		lb3.setOpaque(false);
		lb3.setBounds(10,80,120,20);
		
		lbl_Addr=new JLabel();
		lbl_Addr.setForeground(fcl);
		lbl_Addr.setOpaque(true);
		lbl_Addr.setBackground(clBK);
		lbl_Addr.setBounds(163,80,160,20);

		JLabel lb4=new JLabel("Ward Category:");
		lb4.setForeground(fcl);
		lb4.setOpaque(false);
		lb4.setBounds(10,110,150,20);
		
		cb_Ward=new JComboBox();
		cb_Ward.setBounds(163,110,160,20);
		
		JLabel lb5=new JLabel(" Bed Number:");
		lb5.setForeground(fcl);
		lb5.setOpaque(false);
		lb5.setBounds(10,140,120,20);
	
		cb_BedNo=new JComboBox();
		cb_BedNo.setBounds(163,140,160,20);
		
		JLabel lb6=new JLabel("Room Number:");
		lb6.setForeground(fcl);
		lb6.setOpaque(false);
		lb6.setBounds(10,170,100,20);
		
		lbl_RoomNo=new JLabel("",JLabel.CENTER);
		lbl_RoomNo.setForeground(fcl);
		lbl_RoomNo.setOpaque(true);
		lbl_RoomNo.setBackground(clBK);
		lbl_RoomNo.setBounds(163,170,160,20);
		
		bt_ADMIT=new JButton("ADMIT",new ImageIcon("icons\\save1.gif"));
		bt_ADMIT.setMnemonic('a');
		bt_ADMIT.setBounds(25,250,150,30);
		bt_ADMIT.setToolTipText("Admit");
		
		bt_CLOSE=new JButton("Close",new ImageIcon("icons\\reset.gif"));
		bt_CLOSE.setMnemonic('c');
		bt_CLOSE.setBounds(190,250,150,30);
		bt_CLOSE.setToolTipText("Close");
		
		pn.add(lb1);
		pn.add(tf_patientID);
		pn.add(lb2);
		pn.add(lbl_Pname);
		pn.add(lb3);
		pn.add(lbl_Addr);
		pn.add(lb4);
		pn.add(cb_Ward);
		pn.add(lb5);
		pn.add(cb_BedNo);
		pn.add(lb6);
		pn.add(lbl_RoomNo);
		pn.add(bt_ADMIT);
		pn.add(bt_CLOSE);
		cn.add(pn);
		dp1.add(roomfrm);
		roomfrm.setVisible(true);	
		try
		{
		//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
			qry="Select wardCatName from wardCategory";	
			String loadward[]=inf.getResultSetAs_1D_Array(qry);
			//cb_Ward.addItem("SELECT");
			//for(int i=0;i<loadward.length;i++)
			//{
				//cb_Ward.addItem(loadward[i]);
			//}
			cb_Ward.addItem(ward);
			cb_BedNo.addItem(bed1);
			lbl_RoomNo.setText(room1);
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..IN Constructor"+ex);
		}
		bt_ADMIT.addActionListener(this);
		cb_Ward.addActionListener(this);
		cb_BedNo.addActionListener(this);
		tf_patientID.addKeyListener(this);
		bt_CLOSE.addActionListener(this);
		
		tf_patientID.addKeyListener(this);
		cb_Ward.addKeyListener(this);
		cb_BedNo.addKeyListener(this);
		bt_ADMIT.addKeyListener(this);
		
		tf_patientID.requestFocus();	
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cb_Ward)
		{
			getward=""+cb_Ward.getSelectedItem();
			cb_BedNo.removeAllItems();
			if(!getward.equals("SELECT"))
			{
				//SelectWardFun();
				cb_BedNo.addItem(bed1);
			}
		}
		if(ae.getSource()==cb_BedNo)
		{
			bedNo=""+cb_BedNo.getSelectedItem();
			if(!bedNo.equals("SELECT"))
			{
				//SelectBedNoFun();
			}
			else if((""+cb_BedNo.getSelectedItem())==null)
			{
				JOptionPane.showMessageDialog(this,"You Have No Bed To Admit Patient","Message",JOptionPane.PLAIN_MESSAGE);
			}
		}
		if(ae.getSource()==bt_ADMIT)
		{
			
			if(tf_patientID.getText().equals(st)||(lbl_Addr.getText().equals(st))||(lbl_Pname.getText().equals(st)))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient Id And Select Ward,Room No.","Message",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(lbl_RoomNo.getText().equals(st))
				{
					JOptionPane.showMessageDialog(this,"Patient Can't Be Admited ","Message",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
						AdmitPatientFun();	
				}
			}
		}
		if(ae.getSource()==bt_CLOSE)
		{
			roomfrm.dispose();
		}
		
	}
	public void keyPressed(KeyEvent ke)
	{
		
		if(ke.getSource()==cb_Ward && ke.getKeyCode()==ke.VK_ENTER)
		{
			cb_BedNo.requestFocus();
		}
		if(tf_patientID.equals(st))
		{
			JOptionPane.showMessageDialog(this,"Please Enter Patient ID","Message",JOptionPane.ERROR_MESSAGE);
			tf_patientID.requestFocus();
		}
		else
		{
			if(ke.getSource()==tf_patientID && ke.getKeyCode()==ke.VK_ENTER)
			{
				
				FetchPatientInfoFun();
		    	}
		}
		if(ke.getSource()==tf_patientID && ke.getKeyCode()==ke.VK_ENTER)
		{
			bt_ADMIT.requestFocus();
		}
		if(ke.getSource()==bt_ADMIT && ke.getKeyCode()==ke.VK_ENTER)
		{
			AdmitPatientFun();
		}
	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}
	private void SelectWardFun()
	{
		try
		{	
			
			qry="Select wardCatCode,wardCatCharge from wardCategory where wardCatName='"+getward+"'";
			String loadWRDCode[][]=inf.getResultSetAs_2D_Array(qry,2);
			wardCharge=Integer.parseInt(loadWRDCode[0][1]);		
			qry="Select roomNo from roomDetails where wardCatCode="+Integer.parseInt(loadWRDCode[0][0])+"";
			String loadRMNo[]=inf.getResultSetAs_1D_Array(qry);		
			if(loadRMNo!=null)			
			{
									
				for(int i=0;i<loadRMNo.length;i++)
				{
						
					qry="Select bedNo from bedDetails where roomNo="+Integer.parseInt(loadRMNo[i])+" And bedStatus="+false+"";
					String loadBedNo[]=inf.getResultSetAs_1D_Array(qry);	
					if(loadBedNo!=null)
					{
						for(int k=0;k<loadBedNo.length;k++)
						{
								
							cb_BedNo.addItem(loadBedNo[k]);
						}
					}	
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"No Beds Are Available","Message",JOptionPane.PLAIN_MESSAGE);
			}			
		}
		catch(Exception ex)
		{
				System.out.println("ERROR..IN SelectWardFun Method"+ex);
		}
	}
	private void SelectBedNoFun()
	{
		try
		{	
		//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());	
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
			qry="Select roomNo from bedDetails where bedNo="+Integer.parseInt(bedNo)+"";
			String getRoomNo=inf.getSingleValue(qry);
			lbl_RoomNo.setText(room1);				
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..IN SelectBedNoFun Method"+ex);
		}
	}
	private void AdmitPatientFun()
	{
		Date dt=new Date();
		int day=dt.getDate();
		int mon=dt.getMonth()+1;
		int year=1900+dt.getYear();
		int hr=dt.getHours();
		int min=dt.getMinutes();
		int sec=dt.getSeconds();
		String currentdate=mon+"/"+day+"/"+year;
		String currenttime=hr+":"+min+":"+sec;		
		try
		{
	//		ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());	
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
			String charge=inf.getSingleValue("select wardCatCharge from wardCategory where wardCatName='"+ward1+"'");
			qry="insert into admit_Patient_Info values("+Integer.parseInt(tf_patientID.getText())+","+Integer.parseInt((""+cb_BedNo.getSelectedItem()))+","+Double.valueOf(charge)+",#"+currentdate+"#,#"+currenttime+"#,"+dischargedate+","+dischargetime+","+true+")";
			boolean successful=inf.executeUpdateQuery(qry);
			System.out.println("successful="+successful);	
			qry="Update bedDetails set bedStatus="+true+" where bedNo="+Integer.parseInt((""+cb_BedNo.getSelectedItem()))+"";		
			boolean successfull=inf.executeUpdateQuery(qry);	
			tf_patientID.setText(st);
			lbl_Pname.setText(st);
			lbl_Addr.setText(st);
			lbl_RoomNo.setText(st);
			cb_Ward.removeAllItems();
			cb_BedNo.removeAllItems();
			if(successful==true)
			{
				JOptionPane.showMessageDialog(this,"Patient Admitted Successfully","Message",JOptionPane.PLAIN_MESSAGE);	
			}	
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..In AdmitPatientFun Method"+ex);
		}
	}
	private void FetchPatientInfoFun()
	{
		String ID=tf_patientID.getText();
		int chkCORRECTID=0,pid=0;
		dt1=new Date();
		dt2=new Date();	
		try
		{
	///		ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());	
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
			pid=Integer.parseInt(ID);							
			qry="Select patientid from patient_Profile where patientid="+pid+"";
			String loadID=inf.getSingleValue(qry);
			if(loadID!=null)
			{
				if(ID.equals(loadID))
				chkCORRECTID=1;
														
			}			
			else
			{
				JOptionPane.showMessageDialog(this,"Wrong ID","Message",JOptionPane.ERROR_MESSAGE);						
			}
			if(chkCORRECTID==1)
			{
				
				qry="Select name,address from patient_Profile where patientid="+pid+"";
				String loadDetail[][]=inf.getResultSetAs_2D_Array(qry,2);
				if(loadDetail!=null)
				{
					System.out.println(loadDetail[0][0]);
					System.out.println(loadDetail[0][1]);
					lbl_Pname.setText(loadDetail[0][0]);
					lbl_Addr.setText(loadDetail[0][1]);
				}
			}
			cb_Ward.requestFocus();
		}
		catch(Exception ex)
		{ 
				System.out.println("ERROR..IN FetchPatientInfoFun Method"+ex);
		}				
	}
}		