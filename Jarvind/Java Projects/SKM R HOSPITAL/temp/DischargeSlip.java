/*
 *This File is treated as RECEIPT 
 *of HPS
 */


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
import javax.swing.table.*;
import javax.print.PrintService;
import javax.print.attribute.*;
import java.awt.print.*;
import java.awt.font.*;
import java.awt.geom.*;




class DischargeSlip extends JFrame implements KeyListener,ActionListener
{
	JInternalFrame dischargefrm;
	
	DefaultTableModel dtm;
	JTable table;
	
	JPanel pn;
	Date dt1,dt2;
	JTextField tf_patientID,tf_DischargeDt;
	JComboBox cb_Ward,cb_BedNo;
	JLabel lbl_Pname,lbl_Addr,lbl_RoomNo,lbl_Age,lbl_Gender,lbl_WardNM,lbl_BedNo,lbl_Admitdt,lbl_TotalAmt;
	JButton bt_DISCHARGE,bt_CLOSE,bt_ID,bt_PRINT;
	String qry,setip,getward,bedNo,ID,st="";
	int wardCharge=0,chkCORRECTID=0,chkWRONGID=0,pid=0;
	double totamount=00.0,paidAmt=0.0,medicineCharge=0;
	ZedInterface inf;
	//	String warname;
	//	dt1=new Date();
	//	dt2=new Date();; 
	int totalPaidAmt=0,cnt=0,chk=0;
	double otheramt=0,totalAmt=0,eyeSurCharge=0,gianecSurCharge=0,otherCharge=0,WardCharge=0.00,cons_fee=0.00;
	JDesktopPane desk;
	public DischargeSlip(JDesktopPane dp1)
	{
		
		String head[]={"Sno.","Particulars","Charge","Remarks","Amount"};
		dtm=new DefaultTableModel(head,0);
		table=new JTable(dtm);
		JScrollPane jsp_Table=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	//	String getID=""+ID;
	//	flag=FLAG;
		
		dischargefrm=new JInternalFrame("PATIENT RECEIVING WINDOW",true,true,false,true);
		Container cn=dischargefrm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		dischargefrm.setBounds(100,50,630,600);
	//	cn.setBounds(100,50,400,480);
	//	setTitle("FEE DETAIL WINDOW");
	
		Color fcl=new Color(0,0,128);
	///	Color clB=new Color(0,225,225);
		Font fnt=new Font("Arial NArrow",Font.BOLD,9);
		pn=new JPanel();
		pn.setBounds(10,20,600,520);
		pn.setLayout(null);
	//	p1.setBackground(cl);
		pn.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Admit Patient Detail");
		pn.setBorder(tb);
		pn.setOpaque(false);
		
		pn.setFont(fnt);
		
		Color clBK=new Color(225,248,137);
		JLabel lb1=new JLabel("Enter Patient ID");
		lb1.setForeground(fcl);
		lb1.setOpaque(false);
		lb1.setBounds(10,20,100,20);
		
		tf_patientID=new JTextField();
		tf_patientID.setBounds(120,20,160,20);
		
		bt_ID=new JButton(new ImageIcon("icons\\info.gif"));
		bt_ID.setBounds(283,20,20,20);
		
	
		JLabel lb2=new JLabel("Patient Name");
		lb2.setForeground(fcl);
		lb2.setOpaque(false);
		lb2.setBounds(320,20,100,20);
		
		lbl_Pname=new JLabel();
		lbl_Pname.setForeground(fcl);
		lbl_Pname.setOpaque(true);
		lbl_Pname.setBackground(clBK);
		lbl_Pname.setBounds(420,20,160,20);
		
		JLabel lb3=new JLabel("Address");
		lb3.setForeground(fcl);
		lb3.setOpaque(false);
		lb3.setBounds(10,50,120,20);
		
		lbl_Addr=new JLabel();
		lbl_Addr.setForeground(fcl);
		lbl_Addr.setOpaque(true);
		lbl_Addr.setBackground(clBK);
		lbl_Addr.setBounds(120,50,160,20);
		

		JLabel lb4=new JLabel("Age");
		lb4.setForeground(fcl);
		lb4.setOpaque(false);
		lb4.setBounds(283,50,40,20);
		
		lbl_Age=new JLabel();
		lbl_Age.setForeground(fcl);
		lbl_Age.setOpaque(true);
		lbl_Age.setBackground(clBK);
		lbl_Age.setBounds(320,50,70,20);
		
		
		JLabel lb5=new JLabel("Gender");
		lb5.setForeground(fcl);
		lb5.setOpaque(false);
		lb5.setBounds(393,50,50,20);
		
		
	    lbl_Gender=new JLabel();
		lbl_Gender.setForeground(fcl);
		lbl_Gender.setOpaque(true);
		lbl_Gender.setBackground(clBK);
		lbl_Gender.setBounds(445,50,133,20);
		
		JLabel lb6=new JLabel("Ward Name");
		lb6.setForeground(fcl);
		lb6.setOpaque(false);
		lb6.setBounds(10,80,100,20);
		
		lbl_WardNM=new JLabel();
		lbl_WardNM.setForeground(fcl);
		lbl_WardNM.setOpaque(true);
		lbl_WardNM.setBackground(clBK);
		lbl_WardNM.setBounds(120,80,160,20);
		
		JLabel lb7=new JLabel("Room No.");
		lb7.setForeground(fcl);
		lb7.setOpaque(false);
		lb7.setBounds(283,80,70,20);
		
		lbl_RoomNo=new JLabel();
		lbl_RoomNo.setHorizontalAlignment(JLabel.CENTER);
		lbl_RoomNo.setForeground(fcl);
		lbl_RoomNo.setOpaque(true);
		lbl_RoomNo.setBackground(clBK);
		lbl_RoomNo.setBounds(350,80,80,20);
		
		JLabel lb8=new JLabel("Bed No.");
		lb8.setForeground(fcl);
		lb8.setOpaque(false);
		lb8.setBounds(443,80,70,20);
		
		lbl_BedNo=new JLabel();
		lbl_BedNo.setHorizontalAlignment(JLabel.CENTER);
		lbl_BedNo.setForeground(fcl);
		lbl_BedNo.setOpaque(true);
		lbl_BedNo.setBackground(clBK);
		lbl_BedNo.setBounds(500,80,78,20);
		
		JLabel lb9=new JLabel("Admit Date");
		lb9.setForeground(fcl);
		lb9.setOpaque(false);
		lb9.setBounds(10,110,100,20);
		
		lbl_Admitdt=new JLabel();
		lbl_Admitdt.setHorizontalAlignment(JLabel.CENTER);
		lbl_Admitdt.setForeground(fcl);
		lbl_Admitdt.setOpaque(true);
		lbl_Admitdt.setBackground(clBK);
		lbl_Admitdt.setBounds(120,110,160,20);
		
		JLabel lb10=new JLabel("Discharge Date");
		lb10.setForeground(fcl);
		lb10.setOpaque(false);
		lb10.setBounds(285,110,100,20);
		
		tf_DischargeDt=new JTextField();
		tf_DischargeDt.setHorizontalAlignment(JTextField.CENTER);
		tf_DischargeDt.setBounds(390,110,190,20);
		
		
		jsp_Table.setBounds(20,160,560,200);
		
		JLabel lb11=new JLabel("Total Amount (in Rs.)");
		lb11.setForeground(fcl);
		lb11.setOpaque(false);
		lb11.setBounds(280,380,120,20);
		
		lbl_TotalAmt=new JLabel("",JLabel.RIGHT);
		lbl_TotalAmt.setForeground(fcl);
		lbl_TotalAmt.setOpaque(true);
		lbl_TotalAmt.setBackground(clBK);
		lbl_TotalAmt.setBounds(400,380,180,20);
		
		bt_DISCHARGE=new JButton("Receipt",new ImageIcon("icons\\forward.gif"));
		bt_DISCHARGE.setMnemonic('a');
		bt_DISCHARGE.setBounds(65,450,150,30);
		bt_DISCHARGE.setToolTipText("Discharge");
		
		bt_PRINT=new JButton("Print",new ImageIcon("icons\\PRINT.gif"));
		bt_PRINT.setMnemonic('p');
		bt_PRINT.setBounds(227,450,150,30);
		bt_PRINT.setToolTipText("Print");
		
		
		bt_CLOSE=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		bt_CLOSE.setMnemonic('c');
		bt_CLOSE.setBounds(390,450,150,30);
		bt_CLOSE.setToolTipText("Close");
		
		
		pn.add(lb1);
		pn.add(tf_patientID);
		pn.add(bt_ID);
		pn.add(lb2);
		pn.add(lbl_Pname);
		pn.add(lb3);
		pn.add(lbl_Addr);
		pn.add(lb4);
		pn.add(lbl_Age);
		pn.add(lb5);
		pn.add(lbl_Gender);
		pn.add(lb6);
		pn.add(lbl_WardNM);
		pn.add(lb7);
		pn.add(lbl_RoomNo);
		pn.add(lb8);
		pn.add(lbl_BedNo);
		pn.add(lb9);
		pn.add(lbl_Admitdt);
		pn.add(lb10);
		pn.add(tf_DischargeDt);
		pn.add(jsp_Table);
		pn.add(lb11);
		pn.add(lbl_TotalAmt);
		pn.add(bt_DISCHARGE);
		pn.add(bt_PRINT);
		pn.add(bt_CLOSE);
	
		
		cn.add(pn);
		dp1.add(dischargefrm);
		dischargefrm.setVisible(true);
		
		setip=getIPaddress.IP();
		System.out.println("setip "+setip);
		
		tf_patientID.addKeyListener(this);
		bt_ID.addActionListener(this);
		bt_DISCHARGE.addActionListener(this);
		bt_CLOSE.addActionListener(this);
		bt_PRINT.addActionListener(this);
		
		tf_patientID.addKeyListener(this);
	//	bt_DISCHARGE.addKeyListener(this);
	bt_PRINT.setEnabled(false);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt_ID)
		{
			int checkedID=0;
			dtm.setRowCount(0);
			ID=tf_patientID.getText();
				if(ID.equals(st))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient ID","Message",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try
				{
					lbl_Pname.setText("");
					lbl_Addr.setText("");
					lbl_Age.setText("");
					lbl_Gender.setText("");
					tf_DischargeDt.setText("");
					lbl_Admitdt.setText("");
					lbl_WardNM.setText("");
					lbl_RoomNo.setText("");
					lbl_BedNo.setText("");
					lbl_TotalAmt.setText("");
					
					
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
				
				
				
				
				
					pid=Integer.parseInt(ID);
					
					
					qry="Select id from admit_Patient_Info where id="+pid+"";
				//	System.out.println("qry "+qry);
					String loadID=inf.getSingleValue(qry);
				//	System.out.println("loadID "+loadID);
					if(loadID!=null)
					{
						if(ID.equals(loadID))
						{
						
							chkCORRECTID=1;
							checkedID=Integer.parseInt(ID);
							loadInfo(checkedID,chkCORRECTID);
						}
					}			
					else if(loadID==null)
					{
						qry="Select Patient_Id from eye_Surgery_Detail where Patient_Id="+ID+" And status="+false+"";
						System.out.println("qry "+qry);
						loadID=inf.getSingleValue(qry);
						if(loadID!=null)
						{
								chkCORRECTID=2;
								checkedID=Integer.parseInt(loadID);	
								loadInfo(checkedID,chkCORRECTID);
						}
						else if(loadID==null)
						{
							qry="Select Patient_Id from gianec_Surgery_Detail where Patient_Id="+ID+" And status="+false+"";
						//	System.out.println("qry "+qry);
							loadID=inf.getSingleValue(qry);
							if(loadID!=null)
							{
								chkCORRECTID=2;
								checkedID=Integer.parseInt(loadID);
								loadInfo(checkedID,chkCORRECTID);	
							}
							else if(loadID==null)
							{
								qry="Select patientID from receivingPatient_FeeDetail where patientID="+ID+" Order By visit_dt desc";
								System.out.println(qry);
								loadID=inf.getSingleValue(qry);
								if(loadID!=null)
								{
									chkCORRECTID=3;
									checkedID=Integer.parseInt(loadID);	
									loadInfo(checkedID,chkCORRECTID);
								}
								else
								{
									JOptionPane.showMessageDialog(this," Wrong ID Or Patient Discharged ","Message",JOptionPane.ERROR_MESSAGE);		
									tf_patientID.setText("");
								}
							
							}
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(this," Wrong ID Or Patient Discharged ","Message",JOptionPane.ERROR_MESSAGE);		
						tf_patientID.setText("");
					}
					
				/*	if(chkCORRECTID==1)
					{
						chkCORRECTID=1;	
						loadInfo(checkedID,chkCORRECTID);
					}
					else if(chkCORRECTID==2)
					{
						chkCORRECTID=2;	
						loadInfo(checkedID,chkCORRECTID);
					}
					else if(chkCORRECTID==3)
					{
						chkCORRECTID=3;	
						loadInfo(checkedID,chkCORRECTID);
					}*/
				
				}
				catch(Exception ex)
				{
					tf_patientID.requestFocus();
					JOptionPane.showMessageDialog(null,"Please Input CorrectID (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);
				}
			}
		//	loadInfo();
		}
		else if(ae.getSource()==bt_DISCHARGE)
		{
			 if((tf_DischargeDt.getText().equals(st))||(tf_patientID.getText().equals(st)))
			 {
			 	JOptionPane.showMessageDialog(this,"Please Enter Patient ID ","Message",JOptionPane.ERROR_MESSAGE);	
			 }
			 else
			 {
			 	PatientDischargeFun();
			 }
		}
		else if(ae.getSource()==bt_CLOSE)
		{
			dischargefrm.dispose();
		}
		else if(ae.getSource()==bt_PRINT)
		{
			printDischargeSlip DS=new printDischargeSlip(desk);
		}
		
	}
	public void keyPressed(KeyEvent ke)
	{
	//	ID=tf_patientID.getText();
		
	
		if(ke.getSource()==tf_patientID && ke.getKeyCode()==ke.VK_ENTER)
		{
			int checkedID=0;
			dtm.setRowCount(0);
			ID=tf_patientID.getText();
				if(ID.equals(st))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient ID","Message",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try
				{
					lbl_Pname.setText("");
					lbl_Addr.setText("");
					lbl_Age.setText("");
					lbl_Gender.setText("");
					tf_DischargeDt.setText("");
					lbl_Admitdt.setText("");
					lbl_WardNM.setText("");
					lbl_RoomNo.setText("");
					lbl_BedNo.setText("");
					lbl_TotalAmt.setText("");
					
					
					
				//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
				ZedInterface inf=null;

try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
				
				
				
				
					pid=Integer.parseInt(ID);
					
					
					qry="Select id from admit_Patient_Info where id="+pid+"";
				//	System.out.println("qry "+qry);
					String loadID=inf.getSingleValue(qry);
				//	System.out.println("loadID "+loadID);
					if(loadID!=null)
					{
						if(ID.equals(loadID))
						{
						
							chkCORRECTID=1;
							checkedID=Integer.parseInt(ID);
							loadInfo(checkedID,chkCORRECTID);
					//		System.out.println("chkCORRECTID "+chkCORRECTID);
						}
					//	else
					//	{
					//		chkWRONGID=1;							
					//	}
									
					}
					else if(loadID==null)
					{
						qry="Select Patient_Id from eye_Surgery_Detail where Patient_Id="+ID+" And status="+false+"";
					//	System.out.println("qry "+qry);
						loadID=inf.getSingleValue(qry);
						if(loadID!=null)
						{
								chkCORRECTID=2;
							checkedID=Integer.parseInt(loadID);	
							loadInfo(checkedID,chkCORRECTID);
						}
						else if(loadID==null)
						{
							qry="Select Patient_Id from gianec_Surgery_Detail where Patient_Id="+ID+" And status="+false+"";
						//	System.out.println("qry "+qry);
							loadID=inf.getSingleValue(qry);
							if(loadID!=null)
							{
								chkCORRECTID=2;
								checkedID=Integer.parseInt(loadID);	
								loadInfo(checkedID,chkCORRECTID);
							}
							else if(loadID==null)
							{
								qry="Select patientID from receivingPatient_FeeDetail where patientID="+ID+" Order By visit_dt desc";
								System.out.println(qry);
								loadID=inf.getSingleValue(qry);
								if(loadID!=null)
								{
									chkCORRECTID=3;
									checkedID=Integer.parseInt(loadID);
									loadInfo(checkedID,chkCORRECTID);	
								}
								else
								{
									JOptionPane.showMessageDialog(this," Wrong ID Or Patient Discharged ","Message",JOptionPane.ERROR_MESSAGE);		
									tf_patientID.setText("");
								}
							
							}
						}
						
											
					}
									
				/*	if(chkCORRECTID==1)
					{
						chkCORRECTID=1;	
						loadInfo(checkedID,chkCORRECTID);
					}
					else if(chkCORRECTID==2)
					{
						chkCORRECTID=2;	
						loadInfo(checkedID,chkCORRECTID);
					}
					else if(chkCORRECTID==3)
					{
						chkCORRECTID=3;	
						loadInfo(checkedID,chkCORRECTID);
					}*/
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Please Input CorrectID (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);
					tf_patientID.setText("");
				}
			}
		
		}
	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}
	
	private void loadInfo(int checkedID,int chkCORRECTID)
	{
		//int chkCORRECTID=0,pid=0,WardCharge=0,totamount=0;
		int pid=0;
	//	ID=tf_patientID.getText();
		int chkID=chkCORRECTID;
		System.out.println("chkID "+chkID);
		String warname;
		dt1=new Date();
		dt2=new Date();
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
			
			
				
				pid=checkedID;
				java.math.BigDecimal sum=new java.math.BigDecimal("0.00");	
					
			
								totalAmt=0;
								totalPaidAmt=0;	
								if(chkCORRECTID==1)			
							{
									cons_fee=0.00;
									String query="Select cons_fee from receivingPatient_FeeDetail where patientID="+pid+" Order By visit_dt desc";
									String amt[]=inf.getResultSetAs_1D_Array(query); 
									if(amt!=null)
									for(int i=0;i<amt.length;i++)
										cons_fee=Double.valueOf(amt[i]);
										String temp=(""+(new java.math.BigDecimal(cons_fee).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
								//	System.out.println("cons_fee "+cons_fee);
									
									int indx=1,C=0;
									String loadConsFee[][]=new String[1][5];
									for(int R=0;R<1;R++)
									{
									//	loadTable[R][C++]=""+(ind++);
										loadConsFee[R][C]=""+(indx++);
										loadConsFee[R][++C]="Consultation Fee";
										loadConsFee[R][++C]="";
										loadConsFee[R][++C]="";
										loadConsFee[R][++C]=temp;
										dtm.addRow(loadConsFee[R]);
								
									}
									
									
									
										qry="Select bedNo,rate,bookingdt from admit_Patient_Info where id="+pid+" And status="+true+"";
										System.out.println("qry "+qry);
								String load_admitPatient[][]=inf.getResultSetAs_2D_Array(qry,3);
								if(load_admitPatient!=null)
								{
									
								//	System.out.println(load_admitPatient[0][0]);
									lbl_BedNo.setText(load_admitPatient[0][0]);
								//	System.out.println(load_admitPatient[0][1]);
									WardCharge=Double.valueOf(load_admitPatient[0][1]);
								//	System.out.println(load_admitPatient[0][2]);
							
							
									String condt[]=load_admitPatient[0][2].split("-");
							
							
									String dtt[]=condt[2].split(" ");
					
									int len1=dtt.length;
							//		System.out.println("len1 "+len1);
									for(int j=0;j<len1;j++)
									{
										System.out.println(""+dtt[j]);
									}
								//	System.out.println("D ii"+dtt[0]);
									int D=Integer.parseInt(dtt[0]);
								//	System.out.println("D "+D);
									int M=Integer.parseInt(condt[1]);
								//	System.out.println("M "+M);
									int Y=Integer.parseInt(condt[0]);
								//	System.out.println("Y "+Y);
									dt1.setDate(D);
									dt1.setMonth(M);
									dt1.setYear(Y);
									String dbdate=D+"/"+M+"/"+Y;
							
									lbl_Admitdt.setText(dbdate);
							
									tf_DischargeDt.setText((dt2.getDate())+"/"+(dt2.getMonth()+1)+"/"+(dt2.getYear()+1900));
							
									long ddb=java.sql.Date.parse((dt1.getMonth())+"/"+(dt1.getDate())+"/"+(dt1.getYear()));
								//System.out.println("ddb "+ddb);
									long curdt=java.sql.Date.parse((dt2.getMonth()+1)+"/"+(dt2.getDate())+"/"+(dt2.getYear()+1900));
								//	System.out.println("curdt "+curdt);
									long oneDayValue=86400000; //the long value of 24 hours(one day) is 86400000
								//	long exp30=oneDayValue*30;
						
									long diffr=curdt-ddb;
								//	System.out.println("diffr "+diffr);
					
									long day=(diffr/oneDayValue);
								//	System.out.println("day "+day);
					
									int daydiff=(int)day;
							
									if(daydiff==0)
									{
										daydiff=1;
									}
									else
									{
										daydiff=daydiff;
									}
							
									qry="Select roomNo from bedDetails where bedNo="+Integer.parseInt(load_admitPatient[0][0])+" And bedStatus="+true+"";
							//		System.out.println("qry "+qry);
									String roomno=inf.getSingleValue(qry);
								//	System.out.println("roomno "+roomno);
									lbl_RoomNo.setText(roomno);
							
									qry="Select wardCatCode from roomDetails where roomNo="+Integer.parseInt(roomno)+"";
									String wardno=inf.getSingleValue(qry);
								//	System.out.println("wardno "+wardno);
							
									qry="Select wardCatName from wardCategory where wardCatCode="+Integer.parseInt(wardno)+"";
								//	System.out.println("qry "+qry);
									String wardname=inf.getSingleValue(qry);
								//	System.out.println("wardname "+wardname);
									lbl_WardNM.setText(wardname);
							
									
								//	int ind=1;
									
									
									String loadTable[][]=new String[1][5];
									int getcnt=dtm.getRowCount();
									System.out.println("getcnt "+getcnt);
									indx=(++getcnt);
									int WardChr=(int)WardCharge;
									double totbedChr=Double.valueOf(WardChr*daydiff);
									temp=(""+(new java.math.BigDecimal(totbedChr).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
									
									for(int R=0;R<1;R++)
									{
										C=0;
										loadTable[R][C]=""+(indx++);
										loadTable[R][++C]=wardname;
										loadTable[R][++C]=""+load_admitPatient[0][1];
										loadTable[R][++C]=""+daydiff;
								//		loadTable[R][++C]=""+(WardChr*daydiff);
										loadTable[R][++C]=temp;
										dtm.addRow(loadTable[R]);
								
									}
									
								}	
									
									
								//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
									eyeSurCharge=0.00;								
        							query="select amount from eye_Surgery_Detail where Patient_Id="+pid+" and status="+false;
        							String amt1[]=inf.getResultSetAs_1D_Array(query);
        							int lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        						
        							for(int i=0;i<amt1.length;i++)
        							eyeSurCharge+=Double.valueOf(amt1[i]);
        					//	System.out.println("eyeSurCharge "+eyeSurCharge);
        							temp=(""+(new java.math.BigDecimal(eyeSurCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        							int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadSurgery[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												C=0;
												loadSurgery[R][C]=""+(index++);
												loadSurgery[R][++C]="Eye Surgery";
												loadSurgery[R][++C]="";
												loadSurgery[R][++C]="";
												loadSurgery[R][++C]=temp;
												dtm.addRow(loadSurgery[R]);
											}
        							
        							}
        							else if(amt1==null || lenof==0)
        							{
        								sum=new java.math.BigDecimal("0.00");
        								temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
        								int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadSurgery[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												C=0;
												loadSurgery[R][C]=""+(index++);
												loadSurgery[R][++C]="Eye Surgery";
												loadSurgery[R][++C]="";
												loadSurgery[R][++C]="";
												loadSurgery[R][++C]=temp;
												dtm.addRow(loadSurgery[R]);
											}
        								
        							}
									
										double YAG=0.00;
        							qry="Select YAG_charge from receivingPatient_FeeDetail where patientID="+pid+" Order By visit_dt desc";
        							amt1=inf.getResultSetAs_1D_Array(qry);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        								for(int i=0;i<amt1.length;i++)
        							YAG+=Double.valueOf(amt1[i]);
        						//	System.out.println("eyeSurCharge "+eyeSurCharge);
        							temp=(""+(new java.math.BigDecimal(YAG).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        							int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadYAG[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												C=0;
												loadYAG[R][C]=""+(index++);
												loadYAG[R][++C]="YAG Laser";
												loadYAG[R][++C]="";
												loadYAG[R][++C]="";
												loadYAG[R][++C]=temp;
												dtm.addRow(loadYAG[R]);
											}
        							}
        							else if(amt1==null || lenof==0)
        							{
        								sum=new java.math.BigDecimal("0.00");
        								temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
        								int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadYAG[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												C=0;
												loadYAG[R][C]=""+(index++);
												loadYAG[R][++C]="Eye Surgery";
												loadYAG[R][++C]="";
												loadYAG[R][++C]="";
												loadYAG[R][++C]=temp;
												dtm.addRow(loadYAG[R]);
											}
        								
        							}
									
									
									
									double Ans=0.00;
						
									String qry2="Select purposeOfPay,count(amt),sum(amt) from other_Payment_Detail where patient_id="+pid+" And status="+false+" And purposeOfPay='"+"Anesthesia Charges"+"' Group by purposeOfPay";//(Select distinct purposeOfPay from other_Payment_Detail where patient_id="+pid+")";
								//	System.out.println("qry2"+qry2 );		
									String loadamt[][]=inf.getResultSetAs_2D_Array(qry2,3);
									lenof=loadamt.length;
									if(loadamt!=null && lenof>0)
									{
											Ans=Double.valueOf(loadamt[0][2]);
										temp=(""+(new java.math.BigDecimal(Ans).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
									//	System.out.println("lenof loadamt "+loadamt.length);
											
										int getcnt=dtm.getRowCount();
										indx=(++getcnt);
										String loadNext[][]=new String[loadamt.length][5];
									//	System.out.println("lenof loadNext "+loadNext.length);
									
										for(int R=0;R<loadamt.length;R++)
										{
											int k=0;
											C=0;
										;
											loadNext[R][C]=""+(indx++);
											loadNext[R][++C]=loadamt[R][k];
											loadNext[R][++C]="";
											loadNext[R][++C]=loadamt[R][++k];
											loadNext[R][++C]=temp;
											dtm.addRow(loadNext[R]);	
										}								
													
									}
									else if(loadamt==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
										int getcnt=dtm.getRowCount();
										indx=(++getcnt);
										String loadNext[][]=new String[1][5];
									//	System.out.println("lenof loadNext "+loadNext.length);
									
										for(int R=0;R<1;R++)
										{
											int k=0;
											C=0;
										;
											loadNext[R][C]=""+(indx++);
											loadNext[R][++C]="Anesthesia";
											loadNext[R][++C]="";
											loadNext[R][++C]="";
											loadNext[R][++C]=temp;
											dtm.addRow(loadNext[R]);	
										}	
									}
									
									double IOL=0.00;
								//	 purpose="Intra Ocular Lens (IOL)";
									qry2="Select purposeOfPay,count(amt),sum(amt) from other_Payment_Detail where patient_id="+pid+" And status="+false+" And purposeOfPay='"+"Intra Ocular Lens(IOL)"+"' Group by purposeOfPay";//(Select distinct purposeOfPay from other_Payment_Detail where patient_id="+pid+")";
								//	System.out.println("qry2"+qry2 );		
									String loadamt1[][]=inf.getResultSetAs_2D_Array(qry2,3);
									lenof=loadamt1.length;
									if(loadamt1!=null && lenof>0)
									{
										IOL=Double.valueOf(loadamt1[0][2]);
										temp=(""+(new java.math.BigDecimal(IOL).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
									//	System.out.println("lenof loadamt "+loadamt.length);
												
										int getcnt=dtm.getRowCount();
										indx=(++getcnt);
										String loadNext[][]=new String[loadamt1.length][5];
									//	System.out.println("lenof loadNext "+loadNext.length);
									
										for(int R=0;R<loadamt1.length;R++)
										{
											int k=0;
											C=0;
										;
											loadNext[R][C]=""+(indx++);
											loadNext[R][++C]=loadamt1[R][k];
											loadNext[R][++C]="";
											loadNext[R][++C]=loadamt1[R][++k];
											loadNext[R][++C]=temp;
											dtm.addRow(loadNext[R]);	
										}								
													
									}
									else if(loadamt1==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
										int getcnt=dtm.getRowCount();
										indx=(++getcnt);
										String loadNext[][]=new String[1][5];
									//	System.out.println("lenof loadNext "+loadNext.length);
									
										for(int R=0;R<1;R++)
										{
											int k=0;
											C=0;
										;
											loadNext[R][C]=""+(indx++);
											loadNext[R][++C]="Intra Ocular Lens(IOL)";
											loadNext[R][++C]="";
											loadNext[R][++C]="";
											loadNext[R][++C]=temp;
											dtm.addRow(loadNext[R]);	
										}		
									}
									
															
									medicineCharge=0.0;
									String query1="select netAmt from saleSmry_ByHPS where patientID="+pid+" and status="+false;
								//	System.out.println("query1 "+query1);
        							amt1=inf.getResultSetAs_1D_Array(query1);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        								for(int i=0;i<amt1.length;i++)
        									medicineCharge+=Double.valueOf(amt1[i]);
        						//		System.out.println("medicineCharge "+medicineCharge);
        									temp=(""+(new java.math.BigDecimal(medicineCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        									int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadmedi[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												C=0;
												int k=0;
												loadmedi[R][C]=""+(index++);
												loadmedi[R][++C]="Medicines";
												loadmedi[R][++C]="";
												loadmedi[R][++C]="";
												loadmedi[R][++C]=temp;
												dtm.addRow(loadmedi[R]);
											}
									
        							}
        							else if(amt1==null || lenof==0)
        							{
        								sum=new java.math.BigDecimal("0.00");
        								temp=""+(sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
        								int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadmedi[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												C=0;
												int k=0;
												loadmedi[R][C]=""+(index++);
												loadmedi[R][++C]="Medicines";
												loadmedi[R][++C]="";
												loadmedi[R][++C]="";
												loadmedi[R][++C]=temp;
												dtm.addRow(loadmedi[R]);
											}
        							}
        							
        																				
        						//	System.out.println("eyeSurCharge "+eyeSurCharge);
        							gianecSurCharge=0.00;
        							query="select total_charges from gianec_Surgery_Detail where Patient_Id="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        							
        								for(int i=0;i<amt1.length;i++)
        								gianecSurCharge+=Double.valueOf(amt1[i]);
        						//		System.out.println("gianecSurCharge "+gianecSurCharge);
        								temp=(""+(new java.math.BigDecimal(gianecSurCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        								int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadGianecSurgery[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												C=0;
												loadGianecSurgery[R][C]=""+(index++);
												loadGianecSurgery[R][++C]="Gianec Surgery";
												loadGianecSurgery[R][++C]="";
												loadGianecSurgery[R][++C]="";
												loadGianecSurgery[R][++C]=temp;
												dtm.addRow(loadGianecSurgery[R]);
											}
        								
        							}
        							else if(amt1==null || lenof==0)
        							{
        								sum=new java.math.BigDecimal("0.00");
        								System.out.println("entering into gianec.......");
        								temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
        									int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadGianecSurgery[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												C=0;
												loadGianecSurgery[R][C]=""+(index++);
												loadGianecSurgery[R][++C]="Gianec Surgery";
												loadGianecSurgery[R][++C]="";
												loadGianecSurgery[R][++C]="";
												loadGianecSurgery[R][++C]=temp;
												dtm.addRow(loadGianecSurgery[R]);
											}
        							}
        							
        							//		System.out.println("gianecSurCharge "+gianecSurCharge);
        							String p1="Anesthesia",p2="Intra Ocular Lens(IOL)";
        							otherCharge=0.00;
        							query="select amt from other_Payment_Detail where patient_id="+pid+" And status="+false+" And purposeOfPay<>'"+"Anesthesia Charges"+"' And purposeOfPay<>'"+"Intra Ocular Lens(IOL)"+"'";
        							amt1=inf.getResultSetAs_1D_Array(query);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        							
        								for(int i=0;i<amt1.length;i++)
        								otherCharge+=Double.valueOf(amt1[i]);
        						//		System.out.println("otherCharge "+otherCharge);
        								temp=(""+(new java.math.BigDecimal(otherCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        									int countrow=dtm.getRowCount();
        							
        							
        									int index=(++countrow);
											String loadOtherCharge[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												C=0;
												loadOtherCharge[R][C]=""+(index++);
												loadOtherCharge[R][++C]="Other Charge";
												loadOtherCharge[R][++C]="";
												loadOtherCharge[R][++C]="";
												loadOtherCharge[R][++C]=temp;
												dtm.addRow(loadOtherCharge[R]);
											}
        								
        								
        							}
        							else if(amt1==null || lenof==0)
        							{
        								sum=new java.math.BigDecimal("0.00");
        							 temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
        									int countrow=dtm.getRowCount();
        							
        							
        									int index=(++countrow);
											String loadOtherCharge[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												C=0;
												loadOtherCharge[R][C]=""+(index++);
												loadOtherCharge[R][++C]="Other Charge";
												loadOtherCharge[R][++C]="";
												loadOtherCharge[R][++C]="";
												loadOtherCharge[R][++C]=temp;
												dtm.addRow(loadOtherCharge[R]);
											}
        							}
        							
        											
        						//	System.out.println("otherCharge "+otherCharge);
        							 							
        															
									if(dtm.getRowCount()!=0)
									{
										totamount=0.0;
										int getrwcount=dtm.getRowCount();
										System.out.println("getrwcount "+getrwcount);
										for(int j=0;j<getrwcount;j++)
										{
											String getAmount=""+table.getValueAt(j,4);
											if(totamount!=0)
											{
												totamount =totamount+(Double.valueOf(getAmount));
											}									
											else
											{
												totamount=Double.valueOf(getAmount);
									//			System.out.println("getAmount "+getAmount);
											}
										}
									}
									temp=(""+(new java.math.BigDecimal(totamount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
									lbl_TotalAmt.setText(temp);
									System.out.println("totamount "+totamount);
									
									
        						/*	medicineCharge=0.00;
        							query="select netAmt from saleSmry_ByHPS where patientID="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query);
        							if(amt1!=null)
        								for(int i=0;i<amt1.length;i++)
        									medicineCharge+=Double.valueOf(amt1[i]);*/
        	//taking total amt
        							
        						//	int bedCharge=daydiff*WardChr;
        						//	System.out.println("bedCharge "+bedCharge);
        							double getbedCharge=Double.valueOf(""+table.getValueAt(1,4));
        							System.out.println("getbedCharge "+getbedCharge);
        						totalAmt=getbedCharge+eyeSurCharge+gianecSurCharge+otherCharge+medicineCharge+Ans+IOL+YAG;
        							System.out.println("totalAmt "+totalAmt);
        	//taking total paid amt
        							paidAmt=0.00;
        							query="select amt from receive_Patient_Charges where patientID="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query);
        							if(amt1!=null)
        							for(int i=0;i<amt1.length;i++)
        								paidAmt+=Double.valueOf(amt1[i]);
        								
        						System.out.println("paidAmt "+paidAmt);
								qry="Select name,address,age,gender from patient_Profile where patientid="+pid+"";
							//	System.out.println("qry "+qry);
								String loadDetail[][]=inf.getResultSetAs_2D_Array(qry,4);
				
									if(loadDetail!=null)
									{
										lbl_Pname.setText(loadDetail[0][0]);
										lbl_Addr.setText(loadDetail[0][1]);
										lbl_Age.setText(loadDetail[0][2]);
										lbl_Gender.setText(loadDetail[0][3]);
									}
																	
									
								}
								else if(chkCORRECTID==2)
								{
								/*		qry="Select Patient_Id from eye_Surgery_Detail where Patient_Id="+ID+" And status="+false+"";
										System.out.println("qry "+qry);
										String loadID=inf.getSingleValue(qry);*/
										
										
										
										//////do all calculations here////
										
										cons_fee=0.00;
									String query="Select cons_fee from receivingPatient_FeeDetail where patientID="+pid+" Order By visit_dt desc";
									String amt[]=inf.getResultSetAs_1D_Array(query); 
									if(amt!=null)
									{
									sum=new java.math.BigDecimal("0.00");
									for(int i=0;i<amt.length;i++)
										cons_fee=Double.valueOf(amt[i]);
								//	System.out.println("cons_fee "+cons_fee);
									String temp=(""+(new java.math.BigDecimal(cons_fee).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
									
									int indx=1,C=0;
									
									String loadConsFee[][]=new String[1][5];
									for(int R=0;R<1;R++)
									{
										loadConsFee[R][C]=""+(indx++);
										loadConsFee[R][++C]="Consultation Fee";
										loadConsFee[R][++C]="";
										loadConsFee[R][++C]="";
										loadConsFee[R][++C]=temp;
										dtm.addRow(loadConsFee[R]);
								
									}
									}
									
									sum=new java.math.BigDecimal("0.00");
									String temp=""+(sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
									
									
										int getcnt=dtm.getRowCount();
									int indx=(++getcnt);
									String loadbedChr[][]=new String[1][5];
								//	System.out.println("lenof loadNext "+loadNext.length);
									
									for(int R=0;R<1;R++)
									{
										int k=0,C=0;
										
										loadbedChr[R][C]=""+(indx++);
										loadbedChr[R][++C]="Bed Charges";
										loadbedChr[R][++C]="";
										loadbedChr[R][++C]="";
										loadbedChr[R][++C]=temp;
										dtm.addRow(loadbedChr[R]);	
									}						
									
								//	System.out.println("successfull.......1");
									
										
										
										
										tf_DischargeDt.setText((dt2.getDate())+"/"+(dt2.getMonth()+1)+"/"+(dt2.getYear()+1900));
										
								
									
									
										eyeSurCharge=0.00;
								//	System.out.println("eyeSurCharge1....... "+eyeSurCharge);									
        						//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
        							query="select amount from eye_Surgery_Detail where Patient_Id="+pid+" and status="+false;
        							String amt1[]=inf.getResultSetAs_1D_Array(query);
        							int lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        							
        								for(int i=0;i<amt1.length;i++)
        									eyeSurCharge+=Double.valueOf(amt1[i]);
        							//		System.out.println("eyeSurCharge "+eyeSurCharge);
        									temp=(""+(new java.math.BigDecimal(eyeSurCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        									int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadEyeSurgery[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadEyeSurgery[R][C]=""+(index++);
												loadEyeSurgery[R][++C]="Eye Surgery Charge";
												loadEyeSurgery[R][++C]="";
												loadEyeSurgery[R][++C]="";
												loadEyeSurgery[R][++C]=temp;
												dtm.addRow(loadEyeSurgery[R]);
											}
        									
        									
									}
									else if(amt1==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
										int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadEyeSurgery[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												int C=0;
												loadEyeSurgery[R][C]=""+(index++);
												loadEyeSurgery[R][++C]="Eye Surgery Charge";
												loadEyeSurgery[R][++C]="";
												loadEyeSurgery[R][++C]="";
												loadEyeSurgery[R][++C]=temp;
												dtm.addRow(loadEyeSurgery[R]);
											}
									}
									
									
									
									
									double Ans=0.00;
									String qry2="Select purposeOfPay,count(amt),sum(amt) from other_Payment_Detail where patient_id="+pid+" And status="+false+" And purposeOfPay='"+"Anesthesia Charges"+"' Group by purposeOfPay";//(Select distinct purposeOfPay from other_Payment_Detail where patient_id="+pid+")";
								//	System.out.println("qry2"+qry2 );		
									String loadamt[][]=inf.getResultSetAs_2D_Array(qry2,3);
									lenof=loadamt.length;
									System.out.println("lenof "+lenof);
									if(loadamt!=null && lenof>0)
									{
										Ans=Double.valueOf(loadamt[0][2]);
										temp=(""+(new java.math.BigDecimal(Ans).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
										
											getcnt=dtm.getRowCount();
									indx=(++getcnt);
									String loadNext[][]=new String[loadamt.length][5];
								//	System.out.println("lenof loadNext "+loadNext.length);
									
									for(int R=0;R<loadamt.length;R++)
									{
										int k=0,C=0;
										
										loadNext[R][C]=""+(indx++);
										loadNext[R][++C]=loadamt[R][k];
										loadNext[R][++C]="";
										loadNext[R][++C]=loadamt[R][++k];
										loadNext[R][++C]=temp;
										dtm.addRow(loadNext[R]);	
									}										
													
									}
									else if(loadamt==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
											temp=""+(sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
										getcnt=dtm.getRowCount();
									//	System.out.println("getcnt"+getcnt);
										indx=(++getcnt);
									//	System.out.println("indx"+indx);
										String loadNext[][]=new String[1][5];
									//	System.out.println("lenof loadNext "+loadNext.length);
									
										for(int R=0;R<1;R++)
										{
											int k=0,C=0;
											loadNext[R][C]=""+(indx++);
											loadNext[R][++C]="Anesthesia";
											loadNext[R][++C]="";
											loadNext[R][++C]="";
											loadNext[R][++C]=temp;
											dtm.addRow(loadNext[R]);	
										}		
									}
									
								//	System.out.println("successfull.......2");
									double IOL=0.00;
									qry2="Select purposeOfPay,count(amt),sum(amt) from other_Payment_Detail where patient_id="+pid+" And status="+false+" And purposeOfPay='"+"Intra Ocular Lens(IOL)"+"' Group by purposeOfPay";//(Select distinct purposeOfPay from other_Payment_Detail where patient_id="+pid+")";
								//	System.out.println("qry2"+qry2 );		
									String loadamt1[][]=inf.getResultSetAs_2D_Array(qry2,3);
									lenof=loadamt1.length;
									if(loadamt1!=null && lenof>0)
									{
										IOL=Double.valueOf(loadamt1[0][2]);
										temp=(""+(new java.math.BigDecimal(IOL).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
								//		System.out.println("sum IOL "+loadamt1[0][2]);
								//		System.out.println("lenof loadamt "+loadamt1.length);
									
											getcnt=dtm.getRowCount();
									indx=(++getcnt);
									String loadNext[][]=new String[loadamt1.length][5];
								//	System.out.println("lenof loadNext "+loadNext.length);
									
									for(int R=0;R<loadamt1.length;R++)
									{
										int k=0,C=0;
										
										loadNext[R][C]=""+(indx++);
										loadNext[R][++C]=loadamt1[R][k];
										loadNext[R][++C]="";
										loadNext[R][++C]=loadamt1[R][++k];
										loadNext[R][++C]=temp;
										dtm.addRow(loadNext[R]);	
									}										
													
									}
									else if(loadamt1==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
										getcnt=dtm.getRowCount();
									indx=(++getcnt);
									String loadNext[][]=new String[1][5];
								//	System.out.println("lenof loadNext "+loadNext.length);
									
									for(int R=0;R<1;R++)
									{
										int k=0,C=0;
										
										loadNext[R][C]=""+(indx++);
										loadNext[R][++C]="Intra Ocular Lens(IOL)";
										loadNext[R][++C]="";
										loadNext[R][++C]="";
										loadNext[R][++C]=temp;
										dtm.addRow(loadNext[R]);	
									}					
									}
								//	System.out.println("successfull.......3");
									
									
									
									double YAG=0.00;
        							qry="Select YAG_charge from receivingPatient_FeeDetail where patientID="+pid+" Order By visit_dt desc";
        							amt1=inf.getResultSetAs_1D_Array(qry);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        								for(int i=0;i<amt1.length;i++)
        							YAG+=Double.valueOf(amt1[i]);
        						//	System.out.println("eyeSurCharge "+eyeSurCharge);
        							temp=(""+(new java.math.BigDecimal(YAG).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        							int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadYAG[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadYAG[R][C]=""+(index++);
												loadYAG[R][++C]="YAG Laser";
												loadYAG[R][++C]="";
												loadYAG[R][++C]="";
												loadYAG[R][++C]=temp;
												dtm.addRow(loadYAG[R]);
											}
        							}
        							else if(amt1==null || lenof==0)
        							{
        								sum=new java.math.BigDecimal("0.00");
        								temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
        								int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadYAG[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												int C=0;
												loadYAG[R][C]=""+(index++);
												loadYAG[R][++C]="Eye Surgery";
												loadYAG[R][++C]="";
												loadYAG[R][++C]="";
												loadYAG[R][++C]=temp;
												dtm.addRow(loadYAG[R]);
											}
        								
        							}
									
									
									
									
									
									medicineCharge=0.0;
									String query1="select netAmt from saleSmry_ByHPS where patientID="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query1);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        								for(int i=0;i<amt1.length;i++)
        									medicineCharge+=Double.valueOf(amt1[i]);
        									temp=(""+(new java.math.BigDecimal(medicineCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        							//		System.out.println("medicineCharge "+medicineCharge);
        									
        									int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadmedi[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadmedi[R][C]=""+(index++);
												loadmedi[R][++C]="Medicines";
												loadmedi[R][++C]="";
												loadmedi[R][++C]="";
												loadmedi[R][++C]=temp;
												dtm.addRow(loadmedi[R]);
											}
									
        							}
        							else if(amt1==null || lenof==0)
        							{
        								sum=new java.math.BigDecimal("0.00");
        								temp=""+(sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
        								int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadmedi[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												
												int k=0,C=0;
												loadmedi[R][C]=""+(index++);
												loadmedi[R][++C]="Medicines";
												loadmedi[R][++C]="";
												loadmedi[R][++C]="";
												loadmedi[R][++C]=temp;
												dtm.addRow(loadmedi[R]);
											}
        							}
        					//		System.out.println("successfull.......4");
        							
							//		System.out.println("successfull.......5");
									
									
        							
									
									
									gianecSurCharge=0.00;
									query="select total_charges from gianec_Surgery_Detail where Patient_Id="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query);
        							lenof=amt1.length;
        					//		System.out.println("gianec len"+lenof);
        							if(amt1!=null && lenof>0)
        							{
        							
        								for(int i=0;i<amt1.length;i++)
        								gianecSurCharge+=Double.valueOf(amt1[i]);
        					//			System.out.println("gianecSurCharge "+gianecSurCharge);
        								temp=(""+(new java.math.BigDecimal(gianecSurCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        									int countrow=dtm.getRowCount();
        									int index=(++countrow);
											String loadGianecCharg[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadGianecCharg[R][C]=""+(index++);
												loadGianecCharg[R][++C]="Gianec Surgery Charge";
												loadGianecCharg[R][++C]="";
												loadGianecCharg[R][++C]="";
												loadGianecCharg[R][++C]=temp;
												dtm.addRow(loadGianecCharg[R]);
											}
        								
        								
									}
									else if(amt1==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
											int countrow=dtm.getRowCount();
        									int index=(++countrow);
											String loadGianecCharg[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												int C=0;
												loadGianecCharg[R][C]=""+(index++);
												loadGianecCharg[R][++C]="Gianec Surgery Charge";
												loadGianecCharg[R][++C]="";
												loadGianecCharg[R][++C]="";
												loadGianecCharg[R][++C]=temp;
												dtm.addRow(loadGianecCharg[R]);
											}
									}
							//		System.out.println("successfull.......6");
										String p1="Anesthesia",p2="Intra Ocular Lens(IOL)";
									otherCharge=0.00;
									query="select amt from other_Payment_Detail where patient_id="+pid+" and status="+false+" And purposeOfPay<>'"+"Anesthesia Charges"+"' And purposeOfPay<>'"+"Intra Ocular Lens(IOL)"+"'" ;
							//		System.out.println("others   query "+query);
        							amt1=inf.getResultSetAs_1D_Array(query);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        								temp="";
        								for(int i=0;i<amt1.length;i++)
        								otherCharge+=Double.valueOf(amt1[i]);
        					//			System.out.println("otherCharge "+otherCharge);
        								temp=(""+(new java.math.BigDecimal(otherCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        								int countrow=dtm.getRowCount();
        									int index=(++countrow);
											String loadOtherCharg[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadOtherCharg[R][C]=""+(index++);
												loadOtherCharg[R][++C]="Other Charges";
												loadOtherCharg[R][++C]="";
												loadOtherCharg[R][++C]="";
												loadOtherCharg[R][++C]=temp;
												dtm.addRow(loadOtherCharg[R]);
											}
        								
        								
        								
									}
									else if(amt1==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
										int countrow=dtm.getRowCount();
        									int index=(++countrow);
											String loadOtherCharg[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												int C=0;
												loadOtherCharg[R][C]=""+(index++);
												loadOtherCharg[R][++C]="Other Charges";
												loadOtherCharg[R][++C]="";
												loadOtherCharg[R][++C]="";
												loadOtherCharg[R][++C]=temp;
												dtm.addRow(loadOtherCharg[R]);
											}
									}
									
									System.out.println("successfull.......7");						
									if(dtm.getRowCount()!=0)
									{
										totamount=0.0;
										int getrwcount=dtm.getRowCount();
									//	System.out.println("getrwcount "+getrwcount);
										for(int j=0;j<getrwcount;j++)
										{
											String getAmount=""+table.getValueAt(j,4);
											if(totamount!=0)
											{
												totamount =totamount+(Double.valueOf(getAmount));
											}									
										else
											{
												totamount=Double.valueOf(getAmount);
											//	System.out.println("getAmount "+getAmount);
											}
										}
									}
									temp=(""+(new java.math.BigDecimal(totamount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
									lbl_TotalAmt.setText(temp);
									
								//		System.out.println("totamount "+totamount);
									
									
								/*	medicineCharge=0.00;
        							query="select netAmt from saleSmry_ByHPS where patientID="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query);
        							if(amt!=null)
        								for(int i=0;i<amt1.length;i++)
        									medicineCharge+=Double.valueOf(amt1[i]);
        										System.out.println("medicineCharge "+medicineCharge);*/
        	//taking total amt
        							
        						//	int bedCharge=daydiff*WardChr;
        						//	System.out.println("bedCharge "+bedCharge);
        						//	double getbedCharge=Double.valueOf(bedCharge);
        						//	System.out.println("getbedCharge "+getbedCharge);
        							        							
									
        							totalAmt=eyeSurCharge+gianecSurCharge+otherCharge+medicineCharge+Ans+IOL+YAG;
        						
        							System.out.println("totalAmt "+totalAmt);
        	//taking total paid amt
        							paidAmt=0.00;
        							query="select amt from receive_Patient_Charges where patientID="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query);
        							if(amt1!=null)
        							for(int i=0;i<amt1.length;i++)
        								paidAmt+=Double.valueOf(amt1[i]);
        								
        							System.out.println("paidAmt "+paidAmt);
										qry="Select name,address,age,gender from patient_Profile where patientid="+pid+"";
									//	System.out.println("qry "+qry);
										String loadDetail[][]=inf.getResultSetAs_2D_Array(qry,4);
				
									if(loadDetail!=null)
									{
										lbl_Pname.setText(loadDetail[0][0]);
										lbl_Addr.setText(loadDetail[0][1]);
										lbl_Age.setText(loadDetail[0][2]);
										lbl_Gender.setText(loadDetail[0][3]);
									}
																	
																	
								}
								else if(chkCORRECTID==3)
								{
										cons_fee=0.00;
									String query="Select cons_fee from receivingPatient_FeeDetail where patientID="+pid+" Order By visit_dt desc";
									String amt[]=inf.getResultSetAs_1D_Array(query); 
									if(amt!=null)
									{
									sum=new java.math.BigDecimal("0.00");
									for(int i=0;i<amt.length;i++)
										cons_fee=Double.valueOf(amt[i]);
								//	System.out.println("cons_fee "+cons_fee);
									String temp=(""+(new java.math.BigDecimal(cons_fee).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
									
									int indx=1,C=0;
									
									String loadConsFee[][]=new String[1][5];
									for(int R=0;R<1;R++)
									{
										loadConsFee[R][C]=""+(indx++);
										loadConsFee[R][++C]="Consultation Fee";
										loadConsFee[R][++C]="";
										loadConsFee[R][++C]="";
										loadConsFee[R][++C]=temp;
										dtm.addRow(loadConsFee[R]);
								
									}
									}
									
									sum=new java.math.BigDecimal("0.00");
									String temp=""+(sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
									
									
										int getcnt=dtm.getRowCount();
									int indx=(++getcnt);
									String loadbedChr[][]=new String[1][5];
								//	System.out.println("lenof loadNext "+loadNext.length);
									
									for(int R=0;R<1;R++)
									{
										int k=0,C=0;
										
										loadbedChr[R][C]=""+(indx++);
										loadbedChr[R][++C]="Bed Charges";
										loadbedChr[R][++C]="";
										loadbedChr[R][++C]="";
										loadbedChr[R][++C]=temp;
										dtm.addRow(loadbedChr[R]);	
									}						
									
								//	System.out.println("successfull.......1");
									
										
										
										
										tf_DischargeDt.setText((dt2.getDate())+"/"+(dt2.getMonth()+1)+"/"+(dt2.getYear()+1900));
										
								
									
									
										eyeSurCharge=0.00;
								//	System.out.println("eyeSurCharge1....... "+eyeSurCharge);									
        						///	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
        							
        						ZedInterface inf=null;

try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}	
        							
        							
        							
        							
        							
        							query="select amount from eye_Surgery_Detail where Patient_Id="+pid+" and status="+false;
        							String amt1[]=inf.getResultSetAs_1D_Array(query);
        							int lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        							
        								for(int i=0;i<amt1.length;i++)
        									eyeSurCharge+=Double.valueOf(amt1[i]);
        							//		System.out.println("eyeSurCharge "+eyeSurCharge);
        									temp=(""+(new java.math.BigDecimal(eyeSurCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        									int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadEyeSurgery[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadEyeSurgery[R][C]=""+(index++);
												loadEyeSurgery[R][++C]="Eye Surgery Charge";
												loadEyeSurgery[R][++C]="";
												loadEyeSurgery[R][++C]="";
												loadEyeSurgery[R][++C]=temp;
												dtm.addRow(loadEyeSurgery[R]);
											}
        									
        									
									}
									else if(amt1==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
										int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadEyeSurgery[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												int C=0;
												loadEyeSurgery[R][C]=""+(index++);
												loadEyeSurgery[R][++C]="Eye Surgery Charge";
												loadEyeSurgery[R][++C]="";
												loadEyeSurgery[R][++C]="";
												loadEyeSurgery[R][++C]=temp;
												dtm.addRow(loadEyeSurgery[R]);
											}
									}
									
									
									
									
									double Ans=0.00;
									String qry2="Select purposeOfPay,count(amt),sum(amt) from other_Payment_Detail where patient_id="+pid+" And status="+false+" And purposeOfPay='"+"Anesthesia Charges"+"' Group by purposeOfPay";//(Select distinct purposeOfPay from other_Payment_Detail where patient_id="+pid+")";
								//	System.out.println("qry2"+qry2 );		
									String loadamt[][]=inf.getResultSetAs_2D_Array(qry2,3);
									lenof=loadamt.length;
									System.out.println("lenof "+lenof);
									if(loadamt!=null && lenof>0)
									{
										Ans=Double.valueOf(loadamt[0][2]);
										temp=(""+(new java.math.BigDecimal(Ans).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
										
											getcnt=dtm.getRowCount();
									indx=(++getcnt);
									String loadNext[][]=new String[loadamt.length][5];
								//	System.out.println("lenof loadNext "+loadNext.length);
									
									for(int R=0;R<loadamt.length;R++)
									{
										int k=0,C=0;
										
										loadNext[R][C]=""+(indx++);
										loadNext[R][++C]=loadamt[R][k];
										loadNext[R][++C]="";
										loadNext[R][++C]=loadamt[R][++k];
										loadNext[R][++C]=temp;
										dtm.addRow(loadNext[R]);	
									}										
													
									}
									else if(loadamt==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
											temp=""+(sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
										getcnt=dtm.getRowCount();
									//	System.out.println("getcnt"+getcnt);
										indx=(++getcnt);
									//	System.out.println("indx"+indx);
										String loadNext[][]=new String[1][5];
									//	System.out.println("lenof loadNext "+loadNext.length);
									
										for(int R=0;R<1;R++)
										{
											int k=0,C=0;
											loadNext[R][C]=""+(indx++);
											loadNext[R][++C]="Anesthesia";
											loadNext[R][++C]="";
											loadNext[R][++C]="";
											loadNext[R][++C]=temp;
											dtm.addRow(loadNext[R]);	
										}		
									}
									
								//	System.out.println("successfull.......2");
									double IOL=0.00;
									qry2="Select purposeOfPay,count(amt),sum(amt) from other_Payment_Detail where patient_id="+pid+" And status="+false+" And purposeOfPay='"+"Intra Ocular Lens(IOL)"+"' Group by purposeOfPay";//(Select distinct purposeOfPay from other_Payment_Detail where patient_id="+pid+")";
								//	System.out.println("qry2"+qry2 );		
									String loadamt1[][]=inf.getResultSetAs_2D_Array(qry2,3);
									lenof=loadamt1.length;
									if(loadamt1!=null && lenof>0)
									{
										IOL=Double.valueOf(loadamt1[0][2]);
										temp=(""+(new java.math.BigDecimal(IOL).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
								//		System.out.println("sum IOL "+loadamt1[0][2]);
								//		System.out.println("lenof loadamt "+loadamt1.length);
									
											getcnt=dtm.getRowCount();
									indx=(++getcnt);
									String loadNext[][]=new String[loadamt1.length][5];
								//	System.out.println("lenof loadNext "+loadNext.length);
									
									for(int R=0;R<loadamt1.length;R++)
									{
										int k=0,C=0;
										
										loadNext[R][C]=""+(indx++);
										loadNext[R][++C]=loadamt1[R][k];
										loadNext[R][++C]="";
										loadNext[R][++C]=loadamt1[R][++k];
										loadNext[R][++C]=temp;
										dtm.addRow(loadNext[R]);	
									}										
													
									}
									else if(loadamt1==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
										getcnt=dtm.getRowCount();
									indx=(++getcnt);
									String loadNext[][]=new String[1][5];
								//	System.out.println("lenof loadNext "+loadNext.length);
									
									for(int R=0;R<1;R++)
									{
										int k=0,C=0;
										
										loadNext[R][C]=""+(indx++);
										loadNext[R][++C]="Intra Ocular Lens(IOL)";
										loadNext[R][++C]="";
										loadNext[R][++C]="";
										loadNext[R][++C]=temp;
										dtm.addRow(loadNext[R]);	
									}					
									}
								//	System.out.println("successfull.......3");
									
									
									
									double YAG=0.00;
        							qry="Select YAG_charge from receivingPatient_FeeDetail where patientID="+pid+" Order By visit_dt desc";
        							amt1=inf.getResultSetAs_1D_Array(qry);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        								for(int i=0;i<amt1.length;i++)
        							YAG+=Double.valueOf(amt1[i]);
        						//	System.out.println("eyeSurCharge "+eyeSurCharge);
        							temp=(""+(new java.math.BigDecimal(YAG).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        							int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadYAG[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadYAG[R][C]=""+(index++);
												loadYAG[R][++C]="YAG Laser";
												loadYAG[R][++C]="";
												loadYAG[R][++C]="";
												loadYAG[R][++C]=temp;
												dtm.addRow(loadYAG[R]);
											}
        							}
        							else if(amt1==null || lenof==0)
        							{
        								sum=new java.math.BigDecimal("0.00");
        								temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
        								int countrow=dtm.getRowCount();
        						
        							
        									int index=(++countrow);
											String loadYAG[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												int C=0;
												loadYAG[R][C]=""+(index++);
												loadYAG[R][++C]="Eye Surgery";
												loadYAG[R][++C]="";
												loadYAG[R][++C]="";
												loadYAG[R][++C]=temp;
												dtm.addRow(loadYAG[R]);
											}
        								
        							}
									
									
									
									
									
									medicineCharge=0.0;
									String query1="select netAmt from saleSmry_ByHPS where patientID="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query1);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        								for(int i=0;i<amt1.length;i++)
        									medicineCharge+=Double.valueOf(amt1[i]);
        									temp=(""+(new java.math.BigDecimal(medicineCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        							//		System.out.println("medicineCharge "+medicineCharge);
        									
        									int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadmedi[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadmedi[R][C]=""+(index++);
												loadmedi[R][++C]="Medicines";
												loadmedi[R][++C]="";
												loadmedi[R][++C]="";
												loadmedi[R][++C]=temp;
												dtm.addRow(loadmedi[R]);
											}
									
        							}
        							else if(amt1==null || lenof==0)
        							{
        								sum=new java.math.BigDecimal("0.00");
        								temp=""+(sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
        								int countrow=dtm.getRowCount();
        							//		System.out.println("countrow "+countrow);
        							
        									int index=(++countrow);
											String loadmedi[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												
												int k=0,C=0;
												loadmedi[R][C]=""+(index++);
												loadmedi[R][++C]="Medicines";
												loadmedi[R][++C]="";
												loadmedi[R][++C]="";
												loadmedi[R][++C]=temp;
												dtm.addRow(loadmedi[R]);
											}
        							}
        					//		System.out.println("successfull.......4");
        							
							//		System.out.println("successfull.......5");
									
									
        							
									
									
									gianecSurCharge=0.00;
									query="select total_charges from gianec_Surgery_Detail where Patient_Id="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query);
        							lenof=amt1.length;
        					//		System.out.println("gianec len"+lenof);
        							if(amt1!=null && lenof>0)
        							{
        							
        								for(int i=0;i<amt1.length;i++)
        								gianecSurCharge+=Double.valueOf(amt1[i]);
        					//			System.out.println("gianecSurCharge "+gianecSurCharge);
        								temp=(""+(new java.math.BigDecimal(gianecSurCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        									int countrow=dtm.getRowCount();
        									int index=(++countrow);
											String loadGianecCharg[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadGianecCharg[R][C]=""+(index++);
												loadGianecCharg[R][++C]="Gianec Surgery Charge";
												loadGianecCharg[R][++C]="";
												loadGianecCharg[R][++C]="";
												loadGianecCharg[R][++C]=temp;
												dtm.addRow(loadGianecCharg[R]);
											}
        								
        								
									}
									else if(amt1==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
											int countrow=dtm.getRowCount();
        									int index=(++countrow);
											String loadGianecCharg[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												int C=0;
												loadGianecCharg[R][C]=""+(index++);
												loadGianecCharg[R][++C]="Gianec Surgery Charge";
												loadGianecCharg[R][++C]="";
												loadGianecCharg[R][++C]="";
												loadGianecCharg[R][++C]=temp;
												dtm.addRow(loadGianecCharg[R]);
											}
									}
							//		System.out.println("successfull.......6");
										String p1="Anesthesia",p2="Intra Ocular Lens(IOL)";
									otherCharge=0.00;
									query="select amt from other_Payment_Detail where patient_id="+pid+" and status="+false+" And purposeOfPay<>'"+"Anesthesia Charges"+"' And purposeOfPay<>'"+"Intra Ocular Lens(IOL)"+"'" ;
							//		System.out.println("others   query "+query);
        							amt1=inf.getResultSetAs_1D_Array(query);
        							lenof=amt1.length;
        							if(amt1!=null && lenof>0)
        							{
        								temp="";
        								for(int i=0;i<amt1.length;i++)
        								otherCharge+=Double.valueOf(amt1[i]);
        					//			System.out.println("otherCharge "+otherCharge);
        								temp=(""+(new java.math.BigDecimal(otherCharge).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        								int countrow=dtm.getRowCount();
        									int index=(++countrow);
											String loadOtherCharg[][]=new String[amt1.length][5];
											for(int R=0;R<amt1.length;R++)
											{
												int C=0;
												loadOtherCharg[R][C]=""+(index++);
												loadOtherCharg[R][++C]="Other Charges";
												loadOtherCharg[R][++C]="";
												loadOtherCharg[R][++C]="";
												loadOtherCharg[R][++C]=temp;
												dtm.addRow(loadOtherCharg[R]);
											}
        								
        								
        								
									}
									else if(amt1==null || lenof==0)
									{
										sum=new java.math.BigDecimal("0.00");
										temp=""+sum.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
										int countrow=dtm.getRowCount();
        									int index=(++countrow);
											String loadOtherCharg[][]=new String[1][5];
											for(int R=0;R<1;R++)
											{
												int C=0;
												loadOtherCharg[R][C]=""+(index++);
												loadOtherCharg[R][++C]="Other Charges";
												loadOtherCharg[R][++C]="";
												loadOtherCharg[R][++C]="";
												loadOtherCharg[R][++C]=temp;
												dtm.addRow(loadOtherCharg[R]);
											}
									}
									
									System.out.println("successfull.......7");						
									if(dtm.getRowCount()!=0)
									{
										totamount=0.0;
										int getrwcount=dtm.getRowCount();
									//	System.out.println("getrwcount "+getrwcount);
										for(int j=0;j<getrwcount;j++)
										{
											String getAmount=""+table.getValueAt(j,4);
											if(totamount!=0)
											{
												totamount =totamount+(Double.valueOf(getAmount));
											}									
										else
											{
												totamount=Double.valueOf(getAmount);
											//	System.out.println("getAmount "+getAmount);
											}
										}
									}
									temp=(""+(new java.math.BigDecimal(totamount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
									lbl_TotalAmt.setText(temp);
									
								//		System.out.println("totamount "+totamount);
									
									
								/*	medicineCharge=0.00;
        							query="select netAmt from saleSmry_ByHPS where patientID="+pid+" and status="+false;
        							amt1=inf.getResultSetAs_1D_Array(query);
        							if(amt!=null)
        								for(int i=0;i<amt1.length;i++)
        									medicineCharge+=Double.valueOf(amt1[i]);
        										System.out.println("medicineCharge "+medicineCharge);*/
        	//taking total amt
        							
        						//	int bedCharge=daydiff*WardChr;
        						//	System.out.println("bedCharge "+bedCharge);
        						//	double getbedCharge=Double.valueOf(bedCharge);
        						//	System.out.println("getbedCharge "+getbedCharge);
        							        							
									
        							totalAmt=eyeSurCharge+gianecSurCharge+otherCharge+medicineCharge+Ans+IOL+YAG;
        						
        							System.out.println("totalAmt "+totalAmt);
        	//taking total paid amt
        							paidAmt=0.00;
        							query="select amt from receive_Patient_Charges where patientID="+pid+" and status="+false;
        							System.out.println("query.................. "+query);
        							amt1=inf.getResultSetAs_1D_Array(query);
        							if(amt1!=null && amt1.length>0)
        							{
        							
        							for(int i=0;i<amt1.length;i++)
        								paidAmt+=Double.valueOf(amt1[i]);
        								System.out.println("paidAmt ...."+paidAmt);
        							}
        							else if(amt1==null ||amt1.length==0)
        							{
        									paidAmt=totalAmt;
        								System.out.println("paidAmt "+paidAmt);
        							}
        							
										qry="Select name,address,age,gender from patient_Profile where patientid="+pid+"";
									//	System.out.println("qry "+qry);
										String loadDetail[][]=inf.getResultSetAs_2D_Array(qry,4);
				
									if(loadDetail!=null)
									{
										lbl_Pname.setText(loadDetail[0][0]);
										lbl_Addr.setText(loadDetail[0][1]);
										lbl_Age.setText(loadDetail[0][2]);
										lbl_Gender.setText(loadDetail[0][3]);
									}
								}
						
								bt_DISCHARGE.requestFocus();
							}
						 	catch(Exception ex)
							{ 
								System.out.println("ERROR..IN loadInfo Method"+ex);
							}
				
	}
	private void PatientDischargeFun()
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
		 	
		 	
			 		
			 		Date dt=new Date();
					int day=dt.getDate();
					int mon=dt.getMonth()+1;
					int year=1900+dt.getYear();
					int hr=dt.getHours();
					int min=dt.getMinutes();
					int sec=dt.getSeconds();
					String currentdate=mon+"/"+day+"/"+year;
					String currenttime=hr+":"+min+":"+sec;
				//	System.out.println("currentdate "+currentdate);
			
			 		
			 		double remaining=paidAmt-totalAmt;
			 		System.out.println("remaining........."+remaining);
			 		
			 		if(remaining==00.0)
					{
						String query="Update eye_Surgery_Detail set status="+true+" where Patient_Id="+pid+"";
						boolean successful=inf.executeUpdateQuery(query);
										
						query="Update gianec_Surgery_Detail set status="+true+" where Patient_Id="+pid+"";
						boolean successful1=inf.executeUpdateQuery(query);
						query="Update other_Payment_Detail set status="+true+" where patient_id="+pid+"";
						boolean successful2=inf.executeUpdateQuery(query);
						if((!lbl_BedNo.getText().equals(""))&&(!lbl_RoomNo.getText().equals("")))
						{
							qry="Update bedDetails set bedStatus="+false+" where bedNo="+Integer.parseInt(lbl_BedNo.getText())+" And roomNo="+Integer.parseInt(lbl_RoomNo.getText())+"";
							boolean successful3=inf.executeUpdateQuery(qry);
						}
						
						qry="Update admit_Patient_Info set discharge_dt=#"+currentdate+"#,discharge_tm=#"+currenttime+"#,status="+false+" where id="+Integer.parseInt(tf_patientID.getText())+"";
						boolean successful4=inf.executeUpdateQuery(qry);
						qry="Update saleSmry_ByHPS set status="+false+" where patientID="+pid+"";
						boolean successful5=inf.executeUpdateQuery(qry);
						qry="delete * from patient_admit_Invoice_Temp where patientID="+pid;
						boolean successful6=inf.executeUpdateQuery(qry);
						
			 			
			 			
			 			qry="Select MAX(receiptNo) from patient_Receipt_Details";
			 			int receiptNo=inf.getMaxValue(qry);
			 			System.out.println("receiptNo "+receiptNo);
			 			
			 			qry="insert into patient_Receipt_Details values("+(++receiptNo)+",#"+currentdate+"#,"+pid+","+paidAmt+")";
			 			boolean successful7=inf.executeUpdateQuery(qry);
			 			
			 			JOptionPane.showMessageDialog(this,"Receipt Completed Susccefully","Message",JOptionPane.PLAIN_MESSAGE);
			 			
			 			bt_DISCHARGE.setEnabled(false);
			 			bt_PRINT.setEnabled(true);
			 										
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Payment Is Not Complete","Message",JOptionPane.INFORMATION_MESSAGE);
					}
			 		
			}
			catch(Exception ex)
			{
			 	System.out.println("ERROR..IN PatientDischargeFun Method"+ex);
			}
	}
	
	
    class printDischargeSlip extends JFrame 
   {
        	JInternalFrame pchallanf;
	        Container contentPane;
        	GridBagLayout gbl;
	        GridBagConstraints gbc;
        	JButton printButton;
	        JButton pageSetupButton,exitButton;

			PrintPanel canvas;
	        PageFormat pageFormat;

        	public printDischargeSlip(JDesktopPane desk)
        	{
                pchallanf=new JInternalFrame("Printing of Invoice",false,true,true,true);
                contentPane=pchallanf.getContentPane();
				gbl=new GridBagLayout();
				gbc=new GridBagConstraints();
                contentPane.setLayout(new BorderLayout());

                addWindowListener(new WindowAdapter()
                {
                        public void windowClosing(WindowEvent e)
                        {
                                System.exit(0);
                        }
                }
                );

                canvas=new PrintPanel();
                contentPane.add(canvas,"Center");
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new GridLayout(2,1));

                //pageSetupButton.addActionListener(this);

                contentPane.add(buttonPanel,"East");

                                PrinterJob printJob=PrinterJob.getPrinterJob();
                                double width=5.11 * 72;
                                double height=(7.8 * 72);
                                Paper paper=new Paper();                                
                                paper.setSize(width,height);

                                PageFormat page=new PageFormat();
                                paper.setImageableArea(5,10,paper.getWidth(),paper.getHeight());
                                //page.setOrientation(PageFormat.LANDSCAPE);
                                page.setPaper(paper);
                                pageFormat=printJob.defaultPage(page);
                                pageFormat.setPaper(paper);
                                printJob.setPrintable(canvas,pageFormat);
								
                                try
                                {
										System.out.println("W="+paper.getWidth()+"H="+paper.getHeight());
										currentpg=1;
										printJob.print();
	                            }
                                catch(Exception exception)
                                {
                                        JOptionPane.showMessageDialog(this,exception);
                                }
        		}
	}
	
	
		int currentpg,totalpg, rem;
	boolean firsttime=false;
	boolean complete=false;
	int currentrec=0,startno=0,endno=0;
 
  class PrintPanel extends JPanel implements Printable
  {
        int page=100;
		TextLayout layout;
		Font f,f1,f2,f3,f4,f5,f6;
		Graphics2D g2;
		int row=0;		
		FontRenderContext context;
        
        
        public PrintPanel()
        {
                //ChallanNo=JOptionPane.showInputDialog(null,"Enter Challan Number:");
        }
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                Graphics2D g2=(Graphics2D)g;
                drawPage(g2);
        }
        public int print(Graphics g,PageFormat pf,int page) throws PrinterException
        {
                if(page>=1)
                        return Printable.NO_SUCH_PAGE;
                Graphics2D g2=(Graphics2D)g;
                g2.setPaint(Color.black);
                g2.translate(pf.getImageableX(),pf.getImageableY());
                //g2.draw(new Rectangle2D.Double(0,0,pf.getImageableWidth(),pf.getImageableHeight()));
                System.out.println("W1="+pf.getImageableWidth()+"H1="+pf.getImageableHeight());
                drawPage(g2);
                return Printable.PAGE_EXISTS;
        }
        
    
        public void drawPage(Graphics2D g2)
        {
			this.g2=g2;
			//System.out.println("inside draw page..."+totalamt);	
			
            context=g2.getFontRenderContext();
            f1=new Font("Times New Roman",Font.BOLD,10);
            //f1=new Font("Arial",Font.BOLD,120);
            f2=new Font("Arial",Font.PLAIN,9);
            f3=new Font("Arial",Font.PLAIN,10);
            f4=new Font("Arial",Font.BOLD,10);
            f5=new Font("Times New Roman",Font.PLAIN,11);
            f6=new Font("Times New Roman",Font.BOLD,10);
            Font f7=new Font("Times New Roman",Font.BOLD,15);
            Font f8=new Font("Times New Roman",Font.BOLD,9);
            FontMetrics fm;
            GeneralPath clipShape=new GeneralPath();

            String str=" fdfg dfg dfg";
            String str1="d fgf dgdfg df";                                        
            g2.setFont(f1);
            layout=new TextLayout(str,f1,context);
            AffineTransform transform=AffineTransform.getTranslateInstance(10,20);
			
			if(firsttime==false)
			{
				firsttime=true;
			}
			else
			{			
		        try
        		{
        		
					
					fm=g2.getFontMetrics();				
					String temp="";
		            int top=80;
		            double totalAmt=0;
		            java.math.BigDecimal sum1=new java.math.BigDecimal("0.00");
		            if(currentpg==1)
		            {
		            
						System.out.println("s......");

		            
		            
		            g2.setFont(f6);
		            java.util.Date dt=new java.util.Date();
		            fm=g2.getFontMetrics();				
		            temp= +dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		            layout=new TextLayout(temp,f6,context);
					
                     
                     
                    //top+=40;
					g2.setFont(f3);
                    fm=g2.getFontMetrics(); 
                     
                     temp="Receipt No.";
                     layout=new TextLayout(temp,f3,context);
                     g2.drawString(temp,50,top);
                    
                  /// ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
                  
                  ZedInterface inf=null;

try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
                  
                  
                  
                   String loadConsfee[][]=null;
                    
                   qry="Select receiptNo,receiptDt from patient_Receipt_Details where patientID="+Integer.parseInt(tf_patientID.getText())+"";
                   System.out.println("qry "+qry);
                   String loadprt[][]=inf.getResultSetAs_2D_Array(qry,2);
                  	if(loadprt!=null && loadprt.length>0)
                   {
                   		System.out.println(loadprt[0][0]);
                   		System.out.println(loadprt[0][1]);
                   		
                   		
                   }
                   else if(loadprt==null || loadprt.length==0)
                   {
                   	   System.out.println("ERROR....! Receipt No. Is Not Generated");
                   }
                   
                   g2.setFont(f4);
                   fm=g2.getFontMetrics(); 
                   
                   temp=loadprt[0][0];
                   if(!temp.equals(""))
                   {
                   	layout=new TextLayout(temp,f4,context);
                   g2.drawString(temp,110,top);
                   
                   }
                   else
                   {
                   	temp=" ";
                   	layout=new TextLayout(temp,f4,context);
                   g2.drawString(temp,110,top);
                   
                   }
                   	
                   	
                   
                 
                   
                   g2.setFont(f3);
                   fm=g2.getFontMetrics(); 
                   
                   temp="Date";
                   layout=new TextLayout(temp,f3,context);
                   //g2.drawString(temp,280,top);
                   g2.drawString(temp,260,top);
                   
                 //  temp=loadprt[0][1];
                 g2.setFont(f4);
                  fm=g2.getFontMetrics(); 
                  
                  temp=" "+tf_DischargeDt.getText();
                  if(!temp.equals(""))
                  {
                  	layout=new TextLayout(temp,f4,context);
                  	g2.drawString(temp,(340-fm.stringWidth(temp)),top);
                  }
                  
                  
                  top+=2;
                 g2.drawLine(100,top,160,top);
                 g2.drawLine(290,top,365,top);
                   
                  top+=20;
                  g2.setFont(f3);
                  fm=g2.getFontMetrics();
                   
                  temp="Received from Shri/Smt";
                  layout=new TextLayout(temp,f3,context);
                  g2.drawString(temp,50,top);
                  
                  g2.setFont(f4);
                  fm=g2.getFontMetrics();  
                  temp=lbl_Pname.getText();
                  layout=new TextLayout(temp,f4,context);
                  g2.drawString(temp,180,top);
                  
                  top+=2;
                 g2.drawLine(160,top,365,top);
                 
                 //.....................................
                   
                  top+=20;
                  
                  int top1=top;
                  g2.drawRect(50,top,248,top+105);
                  
                  g2.drawLine(50,top1+25,298,top+25);
                  
                              
                  int top2=top;
                  System.out.println("top===="+top);
                  //g2.drawLine(200,top,200,top2+253);
                  g2.drawLine(200,top,200,top+229);
                  
                  
                  top+=17;
                  temp="Nature of Services";
                  layout=new TextLayout(temp,f7,context);
                  g2.drawString(temp,60,top);
                  
                  temp="Amount(Rs.)";
                  layout=new TextLayout(temp,f7,context);
                  g2.drawString(temp,212,top);
                  
                  g2.setFont(f3);
                  temp="in Cash/Cheque";
                  layout=new TextLayout(temp,f3,context);
                  g2.drawString(temp,300,top);
                  
                  top+=20;
                  temp="towards";
                  layout=new TextLayout(temp,f3,context);
                  g2.drawString(temp,320,top);
                  
                  
                  top+=25;
                  g2.drawLine(300,top,380,top);
                  
                  top+=25;
                  g2.drawLine(300,top,380,top);
                  
                  top-=50;
                  top+=10;
                  
                  g2.setFont(f2);
		          fm=g2.getFontMetrics();
                  
                  temp="1.Consultation";
                  layout=new TextLayout(temp,f2,context);
                  g2.drawString(temp,55,top);
                  
                  g2.setFont(f6);
		          fm=g2.getFontMetrics();
                  totalAmt+=Double.valueOf(""+table.getValueAt(0,4));
                  String temp1=""+table.getValueAt(0,4);
                  temp=(""+new java.math.BigDecimal(temp1).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
                  //System.out.println("temp="+temp);
                  //temp="3000.00";
                  temp=temp.trim();
                  layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                  
                  
                  top+=20;
                  g2.setFont(f2);
		          fm=g2.getFontMetrics();
                  temp="2.Bed/Room Charges";
                  layout=new TextLayout(temp,f2,context);
                  g2.drawString(temp,55,top);
                  
                  g2.setFont(f6);
		          fm=g2.getFontMetrics();
                  
                //  if(chkCORRECTID==1)			
				 // {
                  totalAmt+=Double.valueOf(""+table.getValueAt(1,4));
                  temp1=""+table.getValueAt(1,4);
                  temp=(""+new java.math.BigDecimal(temp1).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
                  //System.out.println("temp="+temp);
                  //temp="50.00";
                  temp=temp.trim();
                  layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                //  }
                /*  else
                  {
                  		sum1=new java.math.BigDecimal("0.00");
                  	temp=""+(sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
                  	layout=new TextLayout(temp,f6,context);
                  	g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                  }*/
                                    
                  top+=20;
                  g2.setFont(f2);
		          fm=g2.getFontMetrics();
		          
                  temp="3.Surgery Charges";
                  layout=new TextLayout(temp,f2,context);
                  g2.drawString(temp,55,top);
                  
                  g2.setFont(f6);
		          fm=g2.getFontMetrics();
		          
               //   if(eyeSurCharge!=0.00)
               //   {
                  //	sum1=0.0;
                  	
                  //	temp=""+eyeSurCharge;
                  totalAmt+=Double.valueOf(""+table.getValueAt(2,4));
                    sum1=new java.math.BigDecimal("0.00");
                  	sum1=sum1.add(new java.math.BigDecimal(""+table.getValueAt(2,4)));
                  	temp=""+(sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
                  	layout=new TextLayout(temp,f6,context);
                  	g2.drawString(temp,(290-fm.stringWidth(temp)),top);//230
                //  }
                 /* else
                  {
                  	sum1=new java.math.BigDecimal("0.00");
                  	temp=""+(sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
                  	layout=new TextLayout(temp,f6,context);
                  	g2.drawString(temp,(290-fm.stringWidth(temp)),top);//230
                  }*/
                  
                  
                  top+=20;
                  g2.setFont(f2);
		          fm=g2.getFontMetrics();
                  temp="4.Anesthesia Charges";
                  layout=new TextLayout(temp,f2,context);
                  g2.drawString(temp,55,top);
                  
                 	g2.setFont(f6);
		          fm=g2.getFontMetrics();
		          
                //  if(Anaethesis!=0.00)
                //  {
                 // 	sum1=0.0;
                 totalAmt+=Double.valueOf(""+table.getValueAt(3,4));
                 sum1=new java.math.BigDecimal("0.00");
                  	sum1=sum1.add(new java.math.BigDecimal(""+table.getValueAt(3,4)));
                  	temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);;
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                //  }
                /*  else
                  {
                  	sum1=new java.math.BigDecimal("0.00");
                  	temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                  }*/
                  
                  
                  top+=20;
                  g2.setFont(f2);
		          fm=g2.getFontMetrics();
                  temp="5.Intra Ocular Lens (IOL)";
                  layout=new TextLayout(temp,f2,context);
                  g2.drawString(temp,55,top);
                  
                  
                  g2.setFont(f6);
		          fm=g2.getFontMetrics();
		          
                 // if(IOL!=0.00)
                 // {
                 	totalAmt+=Double.valueOf(""+table.getValueAt(4,4));
                 	sum1=new java.math.BigDecimal("0.00");
                  	sum1=sum1.add(new java.math.BigDecimal(""+table.getValueAt(4,4)));
                  	temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);;
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                 // }
                 /* else
                  {
                  	sum1=new java.math.BigDecimal("0.00");
                  	temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                  }*/
                  
                  
                  top+=20;
                  g2.setFont(f2);
		          fm=g2.getFontMetrics();
                  temp="6.YAG Laser";
                  layout=new TextLayout(temp,f2,context);
                  g2.drawString(temp,55,top);
                  
                  g2.setFont(f6);
		          fm=g2.getFontMetrics();
                 
                  totalAmt+=Double.valueOf(""+table.getValueAt(5,4));
                  temp1=""+table.getValueAt(5,4);
                  sum1=sum1.add(new java.math.BigDecimal(temp1));
                  temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                  
                  top+=20;
                  g2.setFont(f2);
		          fm=g2.getFontMetrics();
                  temp="7.Medicines";
                  layout=new TextLayout(temp,f2,context);
                  g2.drawString(temp,55,top);
                  
                  g2.setFont(f6);
		          fm=g2.getFontMetrics();
                  
                //  if(Medicine!=0.00)
                //  {
                  	totalAmt+=Double.valueOf(""+table.getValueAt(6,4));
                  	sum1=new java.math.BigDecimal("0.00");
                  temp1=""+table.getValueAt(6,4);
                  sum1=sum1.add(new java.math.BigDecimal(temp1));
                  temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  	
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                //  }
                /*  else
                  {
                  	sum1=new java.math.BigDecimal("0.00");
                  	temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                  }*/
                  
                  top+=20;
                  g2.setFont(f2);
		          fm=g2.getFontMetrics();
		          
                  temp="8.Delivery Charges";
                  layout=new TextLayout(temp,f2,context);
                  g2.drawString(temp,55,top);
                  
                  g2.setFont(f6);
		          fm=g2.getFontMetrics();
                  
                  temp1=""+gianecSurCharge;
                  
                //  if(!temp1.equals("0.00"))
                //  {
                  		totalAmt+=Double.valueOf(""+table.getValueAt(7,4));
                  	sum1=new java.math.BigDecimal("0.00");
                  	temp1=""+table.getValueAt(7,4);
                  sum1=sum1.add(new java.math.BigDecimal(temp1));
                  temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  	
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
               //   }
               /*   else
                  {
                  	sum1=new java.math.BigDecimal("0.00");
                  	temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                  }*/
                  
                  top+=20;
                  g2.setFont(f2);
		          fm=g2.getFontMetrics();
                  temp="9.Others";
                  layout=new TextLayout(temp,f2,context);
                  g2.drawString(temp,55,top);
                  
                  g2.setFont(f6);
		          fm=g2.getFontMetrics();
		          
               //   if(other!=0.00)
                //  {
                  	totalAmt+=Double.valueOf(""+table.getValueAt(8,4));
                  	temp1=""+table.getValueAt(8,4);
                  	sum1=new java.math.BigDecimal("0.00");
                  	sum1=sum1.add(new java.math.BigDecimal(temp1));
                  	temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                //  }
                /*  else
                  {
                  	sum1=new java.math.BigDecimal("0.00");
                  	temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  	layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                  }*/
                  top+=6;
                  int top3=top;
                  g2.drawLine(50,top3,298,top3);
                  
                  top+=12;
                  g2.setFont(f6);
                  
                  temp="Total(in Rs.)";
                  layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,65,top);
                  
                  sum1=new java.math.BigDecimal("0.00");
                  sum1=sum1.add(new java.math.BigDecimal(totalAmt));
                  temp=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,(290-fm.stringWidth(temp)),top);
                  
                  
                  top+=20;
                  g2.setFont(f3);
		          fm=g2.getFontMetrics();
                  temp="The Sum of Rs.(in Words)";
                  layout=new TextLayout(temp,f3,context);
                  g2.drawString(temp,50,top);
                  
                  top3=top;
                  //g2.drawLine(215,top3,380,top3);
                  
                  top+=15;
                  g2.setFont(f8);
		          fm=g2.getFontMetrics();	
                  //----conversion totalAmt To word format....................
                  String str11=""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                  	double d=Double.valueOf(str11);
					str11=""+d;
					String s1=str11.substring(0,str11.indexOf("."));
					//System.out.println("s1="+s1);
					String s2=str11.substring(str11.indexOf(".")+1,str11.length());
					//System.out.println("s2="+s2);
					if(s2.length()==1)
					{
						s2+="0";
					}
					else if(s2.length()>2)
					{
						s2=s2.substring(0,2);
					}
					String word=ConversionOfNumberInWordFormat.splitting(s1);
					word=word+"Rupees And ";
					//System.out.println("\ns4  "+s);
					word+=ConversionOfNumberInWordFormat.splitting(s2);
					word+="Paise Only";
                  //..................
                  temp=""+word;
                  layout=new TextLayout(temp,f8,context);
                  g2.drawString(temp,50,top);
                  
                  top+=2;
                  g2.drawLine(50,top,367,top);
                  
                  top+=30;
                  g2.setFont(f6);
		          fm=g2.getFontMetrics();
                  temp="Signature :";
                  layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,50,top);
                  
                  top3=top+2;
                  g2.drawLine(113,top3,200,top3);
                  
                  temp="Seal :";
                  layout=new TextLayout(temp,f6,context);
                  g2.drawString(temp,270,top);
                  
                  top3=top+2;
                  g2.drawLine(298,top3,380,top3);
                  
                  
                  
		       	}
				}
         		catch(Exception x)
         		{
	        		System.out.println("Error2193821..."+x);
         		}
         
         	}
      	}
	}

}		