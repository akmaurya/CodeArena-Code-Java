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

public class FeeDetails extends JFrame implements ActionListener,KeyListener
{
	JInternalFrame feefrm;
	JDesktopPane dpp;
	JPanel pn;
	Date dt1,dt2;
	JTextField tf_patientID,tf_extrachr,tf_charge,tf_charge1,lbl_consfee,lbl_YAG;
	JComboBox cb_YAGtech;
	JLabel lbl_lastVisitdt,lbl_difftdt,lbl_Amt,lbl_refer;
	JCheckBox chk_fee,chk_YAG,chk_extracharges,chk_charge;
	JButton bt_fee,bt_YAG,bt_total,bt_SAVE,bt_CANCEL,bt_ID;
	String qry,setip,currentdate,setdate,add_name,st="",getID,getdt;
	int flag,MFLAG,dateflag,addfee=0,addYAGfee=0,addexcharge=0,addMorecharges=0,TOTFlag=0,pid=0,chkCORRECTID=0,Flag_lessthan=0,FlagZero=0,add=0,getID1=0;
	Date dt;
	ZedInterface inf=null;
	public FeeDetails(JDesktopPane dp1,int ID,int FLAG,String objDT)
	{
		dpp=dp1;
		getID=""+ID;
		getID1=ID;
		flag=FLAG;
		getdt=objDT;
		feefrm=new JInternalFrame("FEE DETAIL WINDOW",true,true,false,true);
		if(flag!=3)
		{
			feefrm.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
		
		Container cn=feefrm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		feefrm.setBounds(100,50,400,520);
	//	cn.setBounds(100,50,400,480);
	//	setTitle("FEE DETAIL WINDOW");
	
		Color fcl=new Color(0,0,128);
	//	Color clB=new Color(0,225,225);
		Font fnt=new Font("Arial Narrow",Font.BOLD,9);
		pn=new JPanel();
		pn.setBounds(10,20,370,440);
		pn.setLayout(null);
	//	p1.setBackground(cl);
		pn.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Fee Detail");
		pn.setBorder(tb);
		pn.setOpaque(false);
		
		pn.setFont(fnt);
		
		Color clBK=new Color(225,248,137);
		JLabel lb1=new JLabel("Patient ID");
		lb1.setForeground(fcl);
		lb1.setOpaque(false);
		lb1.setBounds(10,20,80,20);
		
		tf_patientID=new JTextField();
		tf_patientID.setBounds(163,20,160,20);
		
		bt_ID=new JButton(new ImageIcon("icons\\info.gif"));
		bt_ID.setBounds(325,20,20,20);
		
		
	/*	JLabel lb2=new JLabel("Refered Dr.Name");
		lb2.setForeground(fcl);
		lb2.setOpaque(false);
		lb2.setBounds(10,50,100,20);
		
		lbl_refer=new JLabel();
		lbl_refer.setBounds(163,50,160,20);*/
		
		
				
		JLabel lb3=new JLabel("Last Visiting Date");
		lb3.setForeground(fcl);
		lb3.setOpaque(false);
		lb3.setBounds(10,50,120,20);
		
		lbl_lastVisitdt=new JLabel("",JLabel.CENTER);
		lbl_lastVisitdt.setForeground(fcl);
		lbl_lastVisitdt.setOpaque(true);
		lbl_lastVisitdt.setBackground(clBK);
		lbl_lastVisitdt.setBounds(163,50,160,20);
		
		JLabel lb4=new JLabel("Diffrence");
		lb4.setForeground(fcl);
		lb4.setOpaque(false);
		lb4.setBounds(10,80,120,20);
		
		lbl_difftdt=new JLabel("",JLabel.RIGHT);
		lbl_difftdt.setForeground(fcl);
		lbl_difftdt.setOpaque(true);
		lbl_difftdt.setBackground(clBK);
		lbl_difftdt.setBounds(163,80,160,20);
		
		JLabel lb5=new JLabel("day(s)");
		lb5.setForeground(fcl);
		lb5.setOpaque(false);
		lb5.setBounds(325,80,40,20);
		
		chk_fee=new JCheckBox("Consultant Fee(in Rs.)");
		chk_fee.setBounds(10,110,150,20);
		
		
		
		
		/////////////updated here/////////////////////
		
		lbl_consfee=new JTextField();
		lbl_consfee.setBounds(163,110,160,20);
		lbl_consfee.setHorizontalAlignment(JTextField.RIGHT);
		 
		 
/*		lbl_consfee=new JLabel("",JLabel.RIGHT);
		lbl_consfee.setOpaque(true);
		lbl_consfee.setBackground(clBK);
		lbl_consfee.setBounds(163,110,160,20);*/
		/////////////////////////////////////////////
		bt_fee=new JButton(new ImageIcon("icons\\new.gif"));
		bt_fee.setBounds(327,110,20,20);
		
		chk_YAG=new JCheckBox("YAG Laser");
		chk_YAG.setBounds(10,140,120,20);
		
		cb_YAGtech=new JComboBox();
		cb_YAGtech.setBounds(163,140,160,20);
		cb_YAGtech.setEnabled(false);
		
		bt_YAG=new JButton(new ImageIcon("icons\\new.gif"));
		bt_YAG.setBounds(327,140,20,20);
		/////////////updates here by S_CHK/////////////
		lbl_YAG=new JTextField();
		lbl_YAG.setBounds(163,170,160,20);
		lbl_YAG.setHorizontalAlignment(JTextField.RIGHT);
		///////////////////////////////////////////////
	/*	lbl_YAG=new JLabel("",JLabel.RIGHT);
		lbl_YAG.setOpaque(true);
		lbl_YAG.setBackground(clBK);
		lbl_YAG.setBounds(163,170,160,20);*/
		
		JLabel lb6=new JLabel("Rs.");
		lb6.setOpaque(false);
		lb6.setBounds(327,170,20,20);
		
		chk_extracharges=new JCheckBox("Extra Charges");
		chk_extracharges.setBounds(10,200,120,20);
		
		tf_extrachr=new JTextField();//SwingUtilities.RIGHT);
	//	tf_extrachr=new JTextField(javax.swing.JTextField.RIGHT);
		tf_extrachr.setBounds(163,200,160,20);
		tf_extrachr.setEnabled(false);
		 tf_extrachr.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel lb7=new JLabel("Rs.");
		lb7.setOpaque(false);
		lb7.setBounds(327,200,20,20);
		
		chk_charge=new JCheckBox();
		chk_charge.setBounds(10,230,25,20);
		
		tf_charge=new JTextField();
		tf_charge.setBounds(36,230,100,20);
		tf_charge.setEnabled(false);
		
		JLabel lbl_charg=new JLabel("Charge");
		lbl_charg.setOpaque(false);
		lbl_charg.setBounds(140,230,60,20);
		
		tf_charge1=new JTextField();
		tf_charge1.setBounds(203,230,120,20);
		tf_charge1.setEnabled(false);
		tf_charge1.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel lb8=new JLabel("Rs.");
		lb8.setOpaque(false);
		lb8.setBounds(327,230,20,20);
		
		
		bt_total=new JButton("Calculate Total Amount");
		//lb9.setOpaque(false);
		bt_total.setBounds(10,300,170,20);
		
		lbl_Amt=new JLabel("",JLabel.RIGHT);
		lbl_Amt.setOpaque(true);
		lbl_Amt.setBackground(clBK);
		lbl_Amt.setBounds(185,300,138,20);
		
		JLabel lb9=new JLabel("Rs.");
		lb9.setOpaque(false);
		lb9.setBounds(327,300,20,20);
		
		bt_SAVE=new JButton("Save",new ImageIcon("icons\\save.gif"));
		bt_SAVE.setMnemonic('s');
		bt_SAVE.setBounds(25,360,150,30);
		bt_SAVE.setToolTipText("Save");
	//	bt_SAVE.setBounds(100,360,70,20);
		
		bt_CANCEL=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		
	//	bt_CANCEL.setBounds(175,360,80,20);
		bt_CANCEL.setMnemonic('c');
		bt_CANCEL.setBounds(190,360,150,30);
		bt_CANCEL.setToolTipText("Close");
		
			bt_CANCEL.setEnabled(false);
		
		
		pn.add(lb1);
		pn.add(tf_patientID);
		pn.add(bt_ID);
	//	pn.add(lb2);
	//	pn.add(lbl_refer);
		pn.add(lb3);
		pn.add(lbl_lastVisitdt);
		pn.add(lb4);
		pn.add(lbl_difftdt);
		pn.add(lb5);
		pn.add(chk_fee);
		pn.add(lbl_consfee);
		pn.add(bt_fee);
		pn.add(chk_YAG);
		pn.add(cb_YAGtech);
		pn.add(bt_YAG);
		pn.add(lbl_YAG);
		pn.add(lb6);
		pn.add(chk_extracharges);
		pn.add(tf_extrachr);
		pn.add(lb7);
		pn.add(chk_charge);
		pn.add(tf_charge);
		pn.add(lbl_charg);
		pn.add(tf_charge1);
		pn.add(lb8);
		pn.add(bt_total);
		pn.add(lbl_Amt);
		pn.add(lb9);
		pn.add(bt_SAVE);
		pn.add(bt_CANCEL);
		
		cn.add(pn);
		dp1.add(feefrm);
		feefrm.setVisible(true);
		
		dt=new Date();
		System.out.println("dt "+dt);
		int day=dt.getDate();
		int mon=dt.getMonth()+1;
		int year=1900+dt.getYear();
			
		currentdate=day+"/"+mon+"/"+year;
		setdate=year+"-"+mon+"-"+day;
//		System.out.println("currentdate "+currentdate);
		
		
	//	setip=getIPaddress.IP();
	//	System.out.println("setip "+setip);
		
		chk_fee.addActionListener(this);
		chk_YAG.addActionListener(this);
		cb_YAGtech.addActionListener(this);
		chk_extracharges.addActionListener(this);
		chk_charge.addActionListener(this);
		bt_total.addActionListener(this);
		bt_SAVE.addActionListener(this);
		tf_patientID.addKeyListener(this);
		bt_ID.addActionListener(this);
		bt_CANCEL.addActionListener(this);
		bt_YAG.addActionListener(this);
		
		chk_fee.addKeyListener(this);
		chk_YAG.addKeyListener(this);
		cb_YAGtech.addKeyListener(this);
		chk_extracharges.addKeyListener(this);
		tf_extrachr.addKeyListener(this);
		chk_charge.addKeyListener(this);
		tf_charge.addKeyListener(this);
		tf_charge1.addKeyListener(this);
		bt_total.addKeyListener(this);
		
		if(flag==1)///////////holding ID from new patient form
		{
			tf_patientID.setEditable(false);
			tf_patientID.setText(getID);
					
			lbl_lastVisitdt.setText(getdt);
			String setdiffdt=""+0;
			lbl_difftdt.setText(setdiffdt);
		//	chk_fee.setSelected(true);
			
	
		}
		else if(flag==2)///////holding ID from existing patient form
		{
			tf_patientID.setEditable(true);
			tf_patientID.setText(getID);
			MFLAG=1;
			LoadInfo();
		//	chk_fee.setSelected(true);
			
		}
		else if(flag==3)//////for Menu Side
		{
			tf_patientID.setEditable(true);
			tf_patientID.requestFocus();
			JOptionPane.showMessageDialog(this,"Please Enter Patient ID And Press Enter","Message",JOptionPane.ERROR_MESSAGE);
		//	chk_fee.setSelected(true);
		}
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==chk_fee)
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
			
			
			
			
			
			
				if(flag==1)
				{
				
					qry="Select Initial from consfee_Detail";
					String getInitial=inf.getSingleValue(qry);
					lbl_consfee.setText(getInitial);
				}
				else if(flag==2)
				{
					if(Flag_lessthan==1)
					{
					
						qry="Select Next from consfee_Detail";
						String getInitial=inf.getSingleValue(qry);
						lbl_consfee.setText(getInitial);
					}
					else if(FlagZero==1)
					{
						
						lbl_consfee.setText("0");
					}
				}
			}
			catch(Exception ex)
			{
				System.out.println("ERROR.."+ex);
			}
		}
		else if(ae.getSource()==chk_YAG)
		{
			cb_YAGtech.removeAllItems();
			
			if(chk_YAG.isSelected()==true)
			{
				cb_YAGtech.setEnabled(true);
				bt_YAG.setEnabled(false);
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
			
			
					qry="Select YAG_techName from YAGlaser_feeDetail";
					String getYAGName[]=inf.getResultSetAs_1D_Array(qry);
				
				//	if(getYAGName==null)
				//		System.out.println("not found");
				//	else
				//		System.out.println("ok");
					
					if(getYAGName!=null)
					{
						int getlen=getYAGName.length;
						cb_YAGtech.addItem("SELECT");
						for(int k=0;k<getlen;k++)
						{
							cb_YAGtech.addItem(getYAGName[k]);
						}
					}
					
				}
				catch(Exception ex)
				{
					System.out.println("ERROR.."+ex);
				}
			}
			else
			{
				cb_YAGtech.setEnabled(false);
				bt_YAG.setEnabled(true);
			}
			
		
		}
		else if(ae.getSource()==cb_YAGtech)
		{
			String getSelected=""+cb_YAGtech.getSelectedItem();
			
			if(getSelected.equals("SELECT"))
			{
				JOptionPane.showMessageDialog(this,"Please Select the Item","Message",JOptionPane.ERROR_MESSAGE);
			}
			else
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
					qry="Select YAG_charge from YAGlaser_feeDetail where YAG_techName='"+getSelected+"'";
					String getYAGcharge=inf.getSingleValue(qry);
					lbl_YAG.setText(getYAGcharge);
					TOTFlag=0;
					
				}
				catch(Exception ex)
				{
					System.out.println("ERROR.."+ex);
				}
			}
			
				
		}
		else if(ae.getSource()==chk_extracharges)
		{
			if(chk_extracharges.isSelected()==true)
			{
				tf_extrachr.setEnabled(true);
				TOTFlag=0;
			}
			else
			{
				tf_extrachr.setEnabled(false);
			}
		}
		else if(ae.getSource()==chk_charge)
		{
			if(chk_charge.isSelected()==true)
			{
				tf_charge.setEnabled(true);
				tf_charge1.setEnabled(true);
				TOTFlag=0;
			}
			else
			{
				tf_charge.setEnabled(false);
				tf_charge1.setEnabled(false);
			}
			
		}
		else if(ae.getSource()==bt_ID)
		{
			if(!tf_patientID.getText().equals(st))
			{
				chk_fee.setSelected(false);
				chk_YAG.setSelected(false);
				cb_YAGtech.setSelectedItem("SELECT");
				lbl_YAG.setText(st);
				chk_extracharges.setSelected(false);
				chk_charge.setSelected(false);
				
				
			String ID=tf_patientID.getText();
			if(ID.equals(st))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient ID","Message",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				lbl_lastVisitdt.setText("");
				lbl_difftdt.setText("");
				lbl_consfee.setText("0");
				try
				{
					MFLAG=1;
					pid=Integer.parseInt(ID);
			
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
					qry="Select patientid from patient_Profile where patientid="+pid+"";
					String loadID=inf.getSingleValue(qry);
					if(loadID!=null)
					{
						if(ID.equals(loadID))
						{
								chkCORRECTID=1;
						    //	break;			
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
					
			}
			
			if(chkCORRECTID==1)
			{
			//	chkCORRECTID=0;
				LoadInfo();
			}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient ID","Message",JOptionPane.ERROR_MESSAGE);	
			}
			
		}
		else if(ae.getSource()==bt_total)
		{
			GetTotalFun();
				
	
		}
		else if(ae.getSource()==bt_YAG)
		{
			System.out.println("Correct");
		YAGMaster YM=new YAGMaster();
		YM.setBounds(300,300,360,200);
		YM.setVisible(true);
	
		
		}
		else if(ae.getSource()==bt_CANCEL)
		{
			System.out.println("inside close");
			/////////////updated here by S_CHK/////////////
			addnewpatient.hold_Dt=getdt;
			System.out.println("hold_Dt "+addnewpatient.hold_Dt);
		
			addnewpatient frm=new addnewpatient(dpp,addnewpatient.hold_Dt);
			//this.dispose();
			//////////////////////////////////////////////
			feefrm.dispose();
		}
		else if(ae.getSource()==bt_SAVE)
		{
			if(TOTFlag!=1)
			{
				JOptionPane.showMessageDialog(this,"Please Click On Calculate Button","Message",JOptionPane.ERROR_MESSAGE);	
			}
			else
			{
				SavePatientFeeDetailFun();
				
			}
		}
		
	}
	public void keyPressed(KeyEvent ke)
	{
		
		if(ke.getSource()==chk_fee && ke.getKeyCode()==ke.VK_ENTER)
		{
			chk_YAG.requestFocus();
		}
		else if(ke.getSource()==chk_YAG && ke.getKeyCode()==ke.VK_ENTER)
		{
			cb_YAGtech.requestFocus();
		}
		else if(ke.getSource()==cb_YAGtech && ke.getKeyCode()==ke.VK_ENTER)
		{
			chk_extracharges.requestFocus();
		}
		else if(ke.getSource()==chk_extracharges && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_extrachr.requestFocus();
		}
		else if(ke.getSource()==tf_extrachr && ke.getKeyCode()==ke.VK_ENTER)
		{
			chk_charge.requestFocus();
		}
		else if(ke.getSource()==chk_charge && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_charge.requestFocus();//////
		}
		else if(ke.getSource()==tf_charge && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_charge1.requestFocus();//////
		}
		else if(ke.getSource()==tf_charge1 && ke.getKeyCode()==ke.VK_ENTER)
		{
			bt_total.requestFocus();
		}
		else if(ke.getSource()==bt_total && ke.getKeyCode()==ke.VK_ENTER)
		{
			bt_SAVE.requestFocus();
		}
		else if(ke.getSource()==tf_patientID && ke.getKeyCode()==ke.VK_ENTER)
		{
					
			String ID=tf_patientID.getText();
			if(ID.equals(st))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient ID","Message",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				lbl_lastVisitdt.setText("");
				lbl_difftdt.setText("");
				lbl_consfee.setText("0");
				try
				{
					MFLAG=1;
					pid=Integer.parseInt(ID);
			
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
					qry="Select patientid from patient_Profile where patientid="+pid+"";
					String loadID=inf.getSingleValue(qry);
					if(loadID!=null)
					{
						if(ID.equals(loadID))
						{
								chkCORRECTID=1;
						    //	break;			
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
					
			}
			
			if(chkCORRECTID==1)
			{
               //chkCORRECTID=0;
				LoadInfo();
			}
			
		}
	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}
	
	private void LoadInfo()
	{
	//	String ID=tf_patientID.getText();
		
		dt1=new Date();
		dt2=new Date();
		if(getID1==0)
		{
			
		int pid=Integer.parseInt(tf_patientID.getText());
		}
		else
		{
			int pid=Integer.parseInt(getID);
		}
		
		
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
						qry="Select e_date from patient_Date where PatientID="+pid+" Order By e_date desc";
				//		System.out.println("qry "+qry);
						String DBdate=inf.getSingleValue(qry);
						System.out.println("DBdate "+DBdate);
					
						if(DBdate!=null)
						{
							String condt[]=DBdate.split("-");
							int len=condt.length;
						//	System.out.println("len "+len);
						
					
							String dtt[]=condt[2].split(" ");
					
							int len1=dtt.length;
					//		System.out.println("len1 "+len1);
						
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
							String db_date=D+"/"+M+"/"+Y;
					//	System.out.println("Date "+dt1);
				
				
					
					
							long ddb=java.sql.Date.parse((dt1.getMonth())+"/"+(dt1.getDate())+"/"+(dt1.getYear()));
						//	System.out.println("ddb "+ddb);
							long curdt=java.sql.Date.parse((dt2.getMonth()+1)+"/"+(dt2.getDate())+"/"+(dt2.getYear()+1900));
						//	System.out.println("curdt "+curdt);
							long oneDayValue=86400000; //the long value of 24 hours(one day) is 86400000
					//	long exp30=oneDayValue*30;
						
							long diffr=curdt-ddb;
							System.out.println("diffr "+diffr);
						
					
							long day=(diffr/oneDayValue);
						System.out.println("day "+day);
					
							int daydiff=(int)day;
					
							String day_diff=""+daydiff;
							if(daydiff>30)
							{
					
								qry="Select Initial from consfee_Detail";
								String getInitial=inf.getSingleValue(qry);
								lbl_consfee.setText(getInitial);
								lbl_lastVisitdt.setText(db_date);
								lbl_difftdt.setText(day_diff);
					
							}
							else if(daydiff>15)
							{
					  			qry="Select Next from consfee_Detail";
								String getInitial=inf.getSingleValue(qry);
								lbl_consfee.setText(getInitial);
								lbl_lastVisitdt.setText(db_date);
								lbl_difftdt.setText(day_diff);
								Flag_lessthan=1;
							}
							else 
							{
								lbl_consfee.setText("0");
								System.out.println("dbdate    "+db_date);
								lbl_lastVisitdt.setText(db_date);
							//	lbl_lastVisitdt.setText(getdt);						
								lbl_difftdt.setText(day_diff);
								FlagZero=1;
							}
							chk_fee.requestFocus();
					
						}
						else
						{
							JOptionPane.showMessageDialog(this,"No Data Available In PatientDate Table","Message",JOptionPane.ERROR_MESSAGE);		
						}
					}
					catch(Exception ex)
					{
						System.out.println("ERROR...IN LoadInfo Method"+ex);
					}
		}
						
			//	}
		//		catch(Exception ex)
		//		{ 
		//			System.out.println("ERROR..IN LoadInfo Method"+ex);
		//		}
				
		//	}
//	}
	private void GetTotalFun()
	{
			lbl_Amt.setText(st);
			int tot=0;
			
			if(chk_fee.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this,"Please Check The Consultant Fee","Message",JOptionPane.ERROR_MESSAGE);	
			}
			else
			{
				String fee=lbl_consfee.getText();
				try
				{
					addfee=Integer.parseInt(fee);// use here Double.valueOf(fee) n collect vale in double type variable
				tot=tot+addfee;
				}
				catch(Exception ex)
				{
					lbl_consfee.requestFocus();
					JOptionPane.showMessageDialog(null,"Please Input (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);	
				}
				
				if(chk_YAG.isSelected()==true)
				{
				
					String YAGfee=lbl_YAG.getText();
					if(YAGfee.equals(st)&&(chk_YAG.isSelected()==true))
					{
						JOptionPane.showMessageDialog(this,"Please Select The YAG ","Message",JOptionPane.ERROR_MESSAGE);	
					}
					else
					{
						try
						{
							addYAGfee=Integer.parseInt(YAGfee);
							tot=tot+addYAGfee;
						}
						catch(Exception ex)
						{
							lbl_YAG.requestFocus();
							JOptionPane.showMessageDialog(null,"Please Input (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);	
						}
						
					}
				}
				else
				{
					
					addYAGfee=0;
					tot=tot+addYAGfee;
				}
				if(chk_extracharges.isSelected()==true)
				{
					String excharge=tf_extrachr.getText();
					if(excharge.equals(st)&&(chk_extracharges.isSelected()==true))
					{
						JOptionPane.showMessageDialog(this,"Please Enter Extra Charges ","Message",JOptionPane.ERROR_MESSAGE);	
					}
					else
					{
						try
						{
							addexcharge=Integer.parseInt(excharge);
							tot=tot+addexcharge;
						}
						catch(Exception ex)
						{
							tf_extrachr.requestFocus();
							JOptionPane.showMessageDialog(null,"Please Input (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);	
						}
						
					}
					
				}
				else
				{
					addexcharge=0;
					tot=tot+addexcharge;
				}
				if(chk_charge.isSelected()==true)
				{
					String add_name=tf_charge.getText();
					String additional=tf_charge1.getText();
					if(additional.equals(st)&&(add_name.equals(st))&&(chk_charge.isSelected()==true))
					{
						JOptionPane.showMessageDialog(this,"Please Enter Additional Charges And Details ","Message",JOptionPane.ERROR_MESSAGE);	
					}
					else
					{
						try
						{
							addMorecharges=Integer.parseInt(additional);
							tot=tot+addMorecharges;
						}
						catch(Exception ex)
						{
							tf_charge1.requestFocus();
							JOptionPane.showMessageDialog(null,"Please Input (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);	
						}
						
					}
				}
				else
				{
					addMorecharges=0;
					tot=tot+addMorecharges;
				}
				//int tot=addfee+addYAGfee+addexcharge+addMorecharges;
				String setTotal=""+tot;
			
				lbl_Amt.setText(setTotal);
				TOTFlag=1;
			}
			
		
	}
	private void SavePatientFeeDetailFun()
	{
		int sendID=0;
		String YAGName;
		if(chk_YAG.isSelected()==false)
			YAGName="";
		else
			YAGName=""+cb_YAGtech.getSelectedItem();
			
				
		String ID=tf_patientID.getText();
		
			//	String reference=lbl_refer.getText();
		String last_Vdate=lbl_lastVisitdt.getText();
		String difft=lbl_difftdt.getText();
		int consfee=addfee;
		int YAGfee=addYAGfee;
		
		int extracharge=addexcharge;
			//	String add_chargeName=tf_charge.getText();
			//	int add_charge=tf_charge1.getText();
		String gettot=lbl_Amt.getText();
		int TOTAL=Integer.parseInt(gettot);//use double.valueOf(gettot) collect value in double type variable
				
		int variable=JOptionPane.showConfirmDialog(this,"Do You Want To Save This Record","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
		if(variable==JOptionPane.YES_OPTION)
		{
			add=1;
		}
		if(add==1)
		{
			
			try
			{
					sendID=Integer.parseInt(ID);
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
					qry="insert into receivingPatient_FeeDetail values("+sendID+",#"+last_Vdate+"#,"+addfee+",'"+YAGName+"',"+addYAGfee+","+addexcharge+",'"+tf_charge.getText()+"',"+addMorecharges+","+TOTAL+")";
					System.out.println("qry...."+qry);
					//---send into invoice---
						//ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
						int max=inf.getMaxValue("select max(receiptNo) from patient_All_Invoice where status=0");
						max+=1;
						java.util.Date dt=new java.util.Date();
						String curDt=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);
						String query="insert into patient_All_Invoice values("+max+",#"+curDt+"#,"+sendID+",'Through OPD',"+TOTAL+",0)";
						inf.executeUpdateQuery(query);
				//	System.out.println("qry "+qry);
					boolean successful=inf.executeUpdateQuery(qry);
					System.out.println("successful "+successful);
				
		//-updated by skm			if(MFLAG==1)
					if(MFLAG==1)
					{
							int D1=dt2.getDate();
						//	System.out.println("D1 "+D1);
							int M1=(dt2.getMonth()+1);
						//	System.out.println("M1 "+M1);
							int Y1=1900+dt2.getYear();
						//	System.out.println("Y1 "+Y1);
							int H=dt2.getHours();
							int MIN=dt2.getMinutes();
							int S=dt2.getSeconds();
							String curtdate=M1+"/"+D1+"/"+Y1;
							String curttime=H+":"+MIN+":"+S;
							qry="Update patient_Date set e_date=#"+curtdate+"#,e_time=#"+curttime+"# where PatientID="+sendID+"";
							successful=inf.executeUpdateQuery(qry);
							bt_CANCEL.setEnabled(true);
							JOptionPane.showMessageDialog(this,"Data Saved Successfully...","Message",JOptionPane.INFORMATION_MESSAGE);
							System.out.println("successful "+successful);
							this.dispose();
					}
					else if(flag==1)
					{
						bt_CANCEL.setEnabled(true);
						JOptionPane.showMessageDialog(this,"Data Saved Successfully...","Message",JOptionPane.INFORMATION_MESSAGE);
					//	this.dispose();
						
						//////////////updated here by S_CHK//////////////
						
					
						////////////////////////////////////////////////
					}
					
					
				
			}
			catch(Exception ex)
			{
					System.out.println("ERROR..IN SavePatientFeeDetailFun Method"+ex);
			}
		}
	}
/*	private void reLoadYAG()
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
			
			
					qry="Select YAG_techName from YAGlaser_feeDetail";
					String getYAGName[]=inf.getResultSetAs_1D_Array(qry);
				
				//	if(getYAGName==null)
				//		System.out.println("not found");
				//	else
				//		System.out.println("ok");
					
					if(getYAGName!=null)
					{
						int getlen=getYAGName.length;
						cb_YAGtech.addItem("SELECT");
						for(int k=0;k<getlen;k++)
						{
							cb_YAGtech.addItem(getYAGName[k]);
						}
					}
					
				}
				catch(Exception ex)
				{
					System.out.println("ERROR.."+ex);
				}
	}*/
	

}
		