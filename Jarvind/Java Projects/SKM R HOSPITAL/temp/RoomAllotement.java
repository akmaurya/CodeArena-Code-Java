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

class RoomAllotement extends JFrame implements KeyListener,ActionListener
{
	JInternalFrame roomfrm;
	JPanel pn;
	Date dt1,dt2;
	JTextField tf_patientID;
	JComboBox cb_Ward,cb_BedNo;
	JLabel lbl_Pname,lbl_Addr,lbl_RoomNo;
	JButton bt_ADMIT,bt_CLOSE;
	String qry,setip,getward,bedNo,st="",dischargedate="0000",dischargetime="0000";
	int wardCharge=0; 
	ZedInterface inf;
	public RoomAllotement(JDesktopPane dp1)
	{
	//	String getID=""+ID;
	//	flag=FLAG;
		System.out.println("SHWETA..................Shweta...................");
		roomfrm=new JInternalFrame("ROOM ALLOTEMENT WINDOW",true,true,false,true);
		Container cn=roomfrm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		roomfrm.setBounds(100,50,400,400);
	//	cn.setBounds(100,50,400,480);
	//	setTitle("FEE DETAIL WINDOW");
	
		Color fcl=new Color(0,0,128);
	//	Color clB=new Color(0,225,225);
		Font fnt=new Font("Arial NArrow",Font.BOLD,9);
		pn=new JPanel();
		pn.setBounds(10,20,370,320);
		pn.setLayout(null);
	//	p1.setBackground(cl);
		pn.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Room Detail");
		pn.setBorder(tb);
		pn.setOpaque(false);
		
		pn.setFont(fnt);
		
		Color clBK=new Color(225,248,137);
		JLabel lb1=new JLabel("Enter Patient ID");
		lb1.setForeground(fcl);
		lb1.setOpaque(false);
		lb1.setBounds(10,20,100,20);
		
		tf_patientID=new JTextField();
		tf_patientID.setBounds(163,20,160,20);
		
	
		JLabel lb2=new JLabel("Patient Name");
		lb2.setForeground(fcl);
		lb2.setOpaque(false);
		lb2.setBounds(10,50,120,20);
		
		lbl_Pname=new JLabel();
		lbl_Pname.setForeground(fcl);
		lbl_Pname.setOpaque(true);
		lbl_Pname.setBackground(clBK);
		lbl_Pname.setBounds(163,50,160,20);
		
		JLabel lb3=new JLabel("Address");
		lb3.setForeground(fcl);
		lb3.setOpaque(false);
		lb3.setBounds(10,80,120,20);
		
		lbl_Addr=new JLabel();
		lbl_Addr.setForeground(fcl);
		lbl_Addr.setOpaque(true);
		lbl_Addr.setBackground(clBK);
		lbl_Addr.setBounds(163,80,160,20);
		

		JLabel lb4=new JLabel("Select Ward");
		lb4.setForeground(fcl);
		lb4.setOpaque(false);
		lb4.setBounds(10,110,150,20);
		
		cb_Ward=new JComboBox();
		cb_Ward.setBounds(163,110,160,20);
		
		
		JLabel lb5=new JLabel("Select Bed No.");
		lb5.setForeground(fcl);
		lb5.setOpaque(false);
		lb5.setBounds(10,140,120,20);
		
		
		cb_BedNo=new JComboBox();
		cb_BedNo.setBounds(163,140,160,20);
		cb_BedNo.addItem("SELECT");
		
		JLabel lb6=new JLabel("Room No.");
		lb6.setForeground(fcl);
		lb6.setOpaque(false);
		lb6.setBounds(10,170,100,20);
		
		lbl_RoomNo=new JLabel("",JLabel.CENTER);
		lbl_RoomNo.setForeground(fcl);
		lbl_RoomNo.setOpaque(true);
		lbl_RoomNo.setBackground(clBK);
		lbl_RoomNo.setBounds(163,170,160,20);
		
		bt_ADMIT=new JButton("ADMIT",new ImageIcon("icons\\save.gif"));
		bt_ADMIT.setMnemonic('a');
		bt_ADMIT.setBounds(25,250,150,30);
		bt_ADMIT.setToolTipText("Admit");
		
		bt_CLOSE=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
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
		
	//	setip=getIPaddress.IP();
	//	System.out.println("setip "+setip);
		
	
		
		
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
			cb_Ward.addItem("SELECT");
			for(int i=0;i<loadward.length;i++)
			{
				cb_Ward.addItem(loadward[i]);
			}
			
			
			
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
		//	cb_BedNo.addItem("SELECT");
			if(!getward.equals("SELECT"))
			{
			//	cb_BedNo.addItem("SELECT");
				SelectWardFun();
			}
			
		}
		else if(ae.getSource()==cb_BedNo)
		{
			bedNo=""+cb_BedNo.getSelectedItem();
			if(!bedNo.equals("SELECT") || bedNo!=null)
			{
				SelectBedNoFun();
			}
			else if((""+cb_BedNo.getSelectedItem())==null)
			{
				JOptionPane.showMessageDialog(this,"You Have No Bed To Admit Patient","Message",JOptionPane.PLAIN_MESSAGE);
			}
		
		}
		else if(ae.getSource()==bt_ADMIT)
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
		else if(ae.getSource()==bt_CLOSE)
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
		else if(ke.getSource()==cb_BedNo && ke.getKeyCode()==ke.VK_ENTER)
		{
			bt_ADMIT.requestFocus();
		}
		else if(ke.getSource()==bt_ADMIT && ke.getKeyCode()==ke.VK_ENTER)
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
		if(tf_patientID.equals(st))
		{
			JOptionPane.showMessageDialog(this,"Please Enter Patient ID","Message",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			if(ke.getSource()==tf_patientID && ke.getKeyCode()==ke.VK_ENTER)
			{
				String st="";
				String ID=tf_patientID.getText();
				int chkCORRECTID=0,pid=0,CHECKEDid=0;
				
			if(ID.equals(st))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient ID","Message",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
							
				lbl_Pname.setText("");
				lbl_Addr.setText("");
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
						{
								chkCORRECTID=1;
								CHECKEDid=Integer.parseInt(ID);
						}
																			
					}			
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong ID","Message",JOptionPane.ERROR_MESSAGE);						
					}
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Please Input CorrectID (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);
				}
				if(chkCORRECTID==1)
				{
				//		System.out.println("YYYYYYYYY");
						chkCORRECTID=0;
						FetchPatientInfoFun(CHECKEDid);
				}
			}
		    }
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
				
		//			ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
					qry="Select wardCatCode,wardCatCharge from wardCategory where wardCatName='"+getward+"'";
					String loadWRDCode[][]=inf.getResultSetAs_2D_Array(qry,2);
				//	System.out.println("WARD CODE "+loadWRDCode[0][0]);
				//	System.out.println("WARD CODE charge"+loadWRDCode[0][1]);
					wardCharge=Integer.parseInt(loadWRDCode[0][1]);
				//	System.out.println("WARD charge"+wardCharge);
					
					qry="Select roomNo from roomDetails where wardCatCode="+Integer.parseInt(loadWRDCode[0][0])+"";
					String loadRMNo[]=inf.getResultSetAs_1D_Array(qry);
					
				//	qry="Select bedNo from bedDetails BD,roomDetails RD,wardCategory WD where WD.wardCatCode=RD.wardCatCode And RD.roomNo=BD.roomNo And BD.status="+false+"";
				//	System.out.println("qry BED"+qry);
					
					if(loadRMNo!=null)			
					{
									
						for(int i=0;i<loadRMNo.length;i++)
						{
						//	System.out.println(loadRMNo[i]);
						
							qry="Select bedNo from bedDetails where roomNo="+Integer.parseInt(loadRMNo[i])+" And bedStatus="+false+"";
							String loadBedNo[]=inf.getResultSetAs_1D_Array(qry);
						
							if(loadBedNo!=null)
							{
							
								for(int k=0;k<loadBedNo.length;k++)
								{
									System.out.println("bedno "+loadBedNo[k]);
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
			qry="Select roomNo from bedDetails where bedNo="+Integer.parseInt(bedNo)+"";
		//	System.out.println("qry "+qry);
			String getRoomNo=inf.getSingleValue(qry);
	//		System.out.println("getRoomNo "+getRoomNo);
			lbl_RoomNo.setText(getRoomNo);
						
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
		int year=1900+(dt.getYear());
		int hr=dt.getHours();
		int min=dt.getMinutes();
		int sec=dt.getSeconds();
		String currentdate=mon+"/"+day+"/"+year;
		String currenttime=hr+":"+min+":"+sec;
				//	System.out.println("currentdate "+currentdate);
			
		//	int setZero=0;
		//	String Disdate=setZero;
			
			
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
			
			qry="Select id from admit_Patient_Info where id="+Integer.parseInt(tf_patientID.getText())+" And status="+true+"";
			String chkid=inf.getSingleValue(qry);
			if(chkid!=null)
			{
				JOptionPane.showMessageDialog(this,"Already Admitted ","Message",JOptionPane.PLAIN_MESSAGE);	
			}
			else
			{
					
				qry="insert into admit_Patient_Info values("+Integer.parseInt(tf_patientID.getText())+","+Integer.parseInt((""+cb_BedNo.getSelectedItem()))+","+wardCharge+",#"+currentdate+"#,#"+currenttime+"#,"+dischargedate+","+dischargetime+","+true+")";
			//	System.out.println("qry "+qry);
				boolean successful=inf.executeUpdateQuery(qry);
				//---send into invoice temporary ---
						
						qry="insert into patient_admit_Invoice_Temp values(#"+currentdate+"#,"+Integer.parseInt(tf_patientID.getText())+",0)";
						inf.executeUpdateQuery(qry);
					//	System.out.println("successful "+successful);
				
				qry="Update bedDetails set bedStatus="+true+" where roomNo="+Integer.parseInt(lbl_RoomNo.getText())+" and bedNo="+Integer.parseInt(""+cb_BedNo.getSelectedItem())+"";
					//	System.out.println("qry "+qry);
				boolean successfull=inf.executeUpdateQuery(qry);
					//	System.out.println("successful "+successful);
				
				
				//	cb_BedNo.setSelectedItem("SELECT");
				//	cb_Ward.setSelectedItem("SELECT");
				if(successful==true)
				{
				
					JOptionPane.showMessageDialog(this,"Patient Admitted Successfully","Message",JOptionPane.PLAIN_MESSAGE);
					tf_patientID.setText(st);
				lbl_Pname.setText(st);
				lbl_Addr.setText(st);
				lbl_RoomNo.setText(st);
				cb_Ward.setSelectedItem("SELECT");
				}
				
			}
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..In AdmitPatientFun Method"+ex);
		}
	}
		
	private void FetchPatientInfoFun(int CHECKEDid)
	{
	//	String ID=tf_patientID.getText();
	//	int chkCORRECTID=0,pid=0;
		int pid=0;
		dt1=new Date();
		dt2=new Date();
			
		try
		{
			pid=CHECKEDid;
		
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
				
		
				//		System.out.println("CorrectID ");
						qry="Select name,address from patient_Profile where patientid="+pid+"";
				//		System.out.println("qry "+qry);
						String loadDetail[][]=inf.getResultSetAs_2D_Array(qry,2);
				
						if(loadDetail!=null)
						{
					//		System.out.println(loadDetail[0][0]);
					//		System.out.println(loadDetail[0][1]);
							lbl_Pname.setText(loadDetail[0][0]);
							lbl_Addr.setText(loadDetail[0][1]);
						}
		
					cb_Ward.requestFocus();
		}
		catch(Exception ex)
		{ 
				System.out.println("ERROR..IN FetchPatientInfoFun Method"+ex);
		}
				
	}

}
		