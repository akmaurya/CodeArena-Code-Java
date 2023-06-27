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

class SearchPatient extends JFrame implements ActionListener,KeyListener
{
	JInternalFrame Searchfrm;
	
	DefaultTableModel dtm;
	JTable table;
	JPanel pn;
	JTextField tf_patientID,tf_patientNAME;
	JComboBox cb_Ward,cb_BedNo;
	JLabel lbl_Room,lbl_Ward,lbl_BedNo;
	JButton bt_Admitted,bt_CLOSE,bt_Search;
	JButton bt_CloseDG=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
	ButtonGroup genGp=new ButtonGroup();
	JRadioButton rb1,rb2;
	String qry,setip,getward,bedNo,ID,st="",wardNM,room_No,bed_No;
	int chkCORRECTID=0,pid=0;
	SetDialog SD;
	ZedInterface inf;
	//	String warname;
	//	dt1=new Date();
	//	dt2=new Date();; 

	public SearchPatient(JDesktopPane dp1)
	{
		
		String head[]={"Sno.","Patient ID","Name","Address","Phone No."};
		dtm=new DefaultTableModel(head,0);
		table=new JTable(dtm);
		JScrollPane jsp_Table=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	//	String getID=""+ID;
	//	flag=FLAG;
		
		Searchfrm=new JInternalFrame("PATIENT SEARCH WINDOW",true,true,false,true);
		Container cn=Searchfrm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		Searchfrm.setBounds(100,50,585,500);
	//	cn.setBounds(100,50,400,480);
	//	setTitle("FEE DETAIL WINDOW");
	
		Color fcl=new Color(0,0,128);
	///	Color clB=new Color(0,225,225);
		Font fnt=new Font("Arial NArrow",Font.BOLD,9);
		pn=new JPanel();
		pn.setBounds(10,20,555,420);
		pn.setLayout(null);
	//	p1.setBackground(cl);
		pn.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Patient Search");
		pn.setBorder(tb);
		pn.setOpaque(false);
		
		pn.setFont(fnt);
		
		Color clBK=new Color(225,248,137);
		
		rb1=new JRadioButton("Search By Patient ID");
		rb1.setOpaque(false);
		rb1.setBounds(10,25,160,20);
		rb2=new JRadioButton("Search By Patient Name");
		rb2.setOpaque(false);
		rb2.setBounds(10,55,170,20);
		genGp.add(rb1);
		genGp.add(rb2);
		
		tf_patientID=new JTextField();
		tf_patientID.setBounds(180,25,170,20);
		
		tf_patientNAME=new JTextField();
		tf_patientNAME.setBounds(180,55,170,20);
		
		
		bt_Search=new JButton("Search",new ImageIcon("\\icons\\search.gif"));
		bt_Search.setMnemonic('s');
		bt_Search.setBounds(380,30,150,30);
		bt_Search.setToolTipText("Search");
		
		
		JLabel lb1=new JLabel("Patient Details:");
		lb1.setForeground(fcl);
		lb1.setOpaque(false);
		lb1.setBounds(20,115,100,20);
		
		jsp_Table.setBounds(20,140,515,200);
		
		bt_Admitted=new JButton("Is Admitted",new ImageIcon("\\icons\\info.gif"));
		bt_Admitted.setMnemonic('a');
		bt_Admitted.setBounds(125,360,150,30);
		bt_Admitted.setToolTipText("Search");
		
		bt_CLOSE=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		bt_CLOSE.setMnemonic('c');
		bt_CLOSE.setBounds(285,360,150,30);
		bt_CLOSE.setToolTipText("Close");
		
	
		

		pn.add(rb1);
		pn.add(rb2);
		pn.add(tf_patientID);
		pn.add(tf_patientNAME);
		pn.add(bt_Search);
		pn.add(jsp_Table);
		pn.add(lb1);
		pn.add(bt_Admitted);
		pn.add(bt_CLOSE);
	
	
		
		cn.add(pn);
		dp1.add(Searchfrm);
		Searchfrm.setVisible(true);
		
		setip=getIPaddress.IP();
		System.out.println("setip "+setip);
		
		tf_patientID.addKeyListener(this);
		tf_patientNAME.addKeyListener(this);
		bt_Admitted.addActionListener(this);
		bt_CloseDG.addActionListener(this);
		bt_CLOSE.addActionListener(this);
		bt_Search.addActionListener(this);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
	
	/*	bt_DISCHARGE.addActionListener(this);
		bt_CLOSE.addActionListener(this);
		
		tf_patientID.addKeyListener(this);*/
	//	bt_DISCHARGE.addKeyListener(this);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt_Admitted)
		{
			if((tf_patientNAME.getText().equals(st))&&(tf_patientID.getText().equals(st)))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient ID OR Patient Name AND Press Search Button","Message",JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
			
				int getRW=dtm.getRowCount();
				System.out.println("row Count "+getRW);
				if(getRW!=0)
				{
					int SelectedRow=table.getSelectedRow();
					System.out.println("Selected Row"+SelectedRow);
					if(SelectedRow!=-1)
					{
					
						String ValueAtTB=""+table.getValueAt(SelectedRow,1);
						System.out.println("ValueAtTB "+ValueAtTB);
					
						try
						{
							//ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
							qry="Select status from admit_Patient_info where id="+Integer.parseInt(ValueAtTB)+"";
							System.out.println("qry "+qry);
							String getStatus=inf.getSingleValue(qry);
							System.out.println("getstatus "+getStatus);
							if(getStatus==null)
							{
								JOptionPane.showMessageDialog(this,"This Patient Is Not Admitted ","Message",JOptionPane.PLAIN_MESSAGE);
							}
							else if(getStatus.equals("0"))
							{
								JOptionPane.showMessageDialog(this,"This Patient Is Discharged ","Message",JOptionPane.PLAIN_MESSAGE);
							}
							else if(getStatus.equals("1"))
							{
								qry="Select bedNo,rate from admit_Patient_info where id="+Integer.parseInt(ValueAtTB)+"";
								System.out.println("qry "+qry);
								String admitPT[][]=inf.getResultSetAs_2D_Array(qry,2);
								System.out.println("bed no"+admitPT[0][0]);
								bed_No=admitPT[0][0];
								System.out.println("bed no"+admitPT[0][1]);
								if(admitPT!=null)
								{
									qry="Select roomNo from BedDetails where bedNo="+Integer.parseInt(admitPT[0][0])+" And bedStatus="+true+"";
									System.out.println("qry "+qry);
									room_No=inf.getSingleValue(qry);
									System.out.println("getroomNo "+room_No);
									
									qry="Select wardCatName from wardCategory where wardCatCharge="+Integer.parseInt(admitPT[0][1])+"";
									System.out.println("qry "+qry);
									wardNM=inf.getSingleValue(qry);
									System.out.println("wardNM "+wardNM);
								}
								
								SD=new SetDialog(wardNM,room_No,bed_No);
								SD.setBounds(400,300,300,300);
								SD.setVisible(true);
							}
						
						
						}
						catch(Exception ex)
						{
							System.out.println("ERROR.."+ex);
						}
						
					}
					else
					{
						JOptionPane.showMessageDialog(this,"Please Select The Row","Message",JOptionPane.PLAIN_MESSAGE);
					}
				}
				else
				{
				
				}
			
			}
			
			
		}
		else if(ae.getSource()==bt_CloseDG)
		{
			SD.dispose();
		}
		else if(ae.getSource()==bt_CLOSE)
		{
			Searchfrm.dispose();
		}
		else if(rb1.isSelected())
		{
			System.out.println("inside rb1");
			tf_patientID.setEditable(true);
			tf_patientID.requestFocus();
			tf_patientNAME.setText(st);
			tf_patientNAME.setEditable(false);
		}
		else if(rb2.isSelected())
		{
			System.out.println("inside rb2");
			
			tf_patientNAME.setEditable(true);
			tf_patientNAME.requestFocus();
			tf_patientID.setText(st);
			tf_patientID.setEditable(false);
		}
		if(ae.getSource()==bt_Search)
		{
			dtm.setRowCount(0);
			if((rb1.isSelected()==true)&&(tf_patientID.getText().equals(st)))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient ID","Message",JOptionPane.PLAIN_MESSAGE);
			}
			else if((rb1.isSelected()==false)&&(!tf_patientID.getText().equals(st)))
			{
				JOptionPane.showMessageDialog(this,"Please Select RadioButton Search By Patient ID","Message",JOptionPane.PLAIN_MESSAGE);
			}
			else if((rb1.isSelected()==true)&&(!tf_patientID.getText().equals(st)))
			{
					String ID=tf_patientID.getText();
					int getid=0;
			try
			{
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
				
				
				
				
				
				
					pid=Integer.parseInt(ID);
										
					qry="Select patientid from patient_Profile where patientid="+pid+"";
					String loadID=inf.getSingleValue(qry);
					if(loadID!=null)
					{
						if(ID.equals(loadID))
						{
							chkCORRECTID=1;
							getid=Integer.parseInt(ID);
						}
							
														
					}			
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong ID","Message",JOptionPane.ERROR_MESSAGE);						
					}
					if(chkCORRECTID==1)
					{
						chkCORRECTID=0;
						LoadPateintInfoByID(getid);
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Please Input CorrectID (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if((rb2.isSelected()==true)&&(tf_patientNAME.getText().equals(st)))	
			{
				JOptionPane.showMessageDialog(this,"Please Enter Patient Name","Message",JOptionPane.PLAIN_MESSAGE);
			}
			else if((rb2.isSelected()==false)&&(!tf_patientNAME.getText().equals(st)))	
			{
				JOptionPane.showMessageDialog(this,"Please Select RadioButton Search By Patient Name","Message",JOptionPane.PLAIN_MESSAGE);
			}
			else if((rb2.isSelected()==true)&&(!tf_patientNAME.getText().equals(st)))	
			{
				
				LoadPatientInfoByName();
			}
				
		}
		
		
	}
	public void keyPressed(KeyEvent ke)
	{
		
		if(ke.getSource()==tf_patientID && ke.getKeyCode()==ke.VK_ENTER)
		{
			bt_Search.requestFocus();
		}
		else if(ke.getSource()==tf_patientNAME && ke.getKeyCode()==ke.VK_ENTER)
		{
			bt_Search.requestFocus();
		}
		
		
		
	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}

	class SetDialog extends JDialog
	{
		Container cnDIALOG;
		
		
		public SetDialog(String Ward,String RoomNo,String BedNo)
		{
			String WARDName=Ward;
			String Room=RoomNo;
			String Bed=BedNo;
			Color clBK=new Color(225,248,137);
			Font fnt=new Font("Arial NArrow",Font.BOLD,9);
			Color fcl=new Color(0,0,128);
			cnDIALOG=getContentPane();
			cnDIALOG.setLayout(null);
			Color c1=new Color(60,220,220);
 			cnDIALOG.setBackground(c1);
			cnDIALOG.setFont(fnt);
			
	    	setTitle("Patient Ward Detail");
	    	
	    			
	    	JLabel lb1=new JLabel("Ward");
	    	lb1.setForeground(fcl);
			lb1.setOpaque(false);
			lb1.setBounds(10,15,80,20);
			lbl_Ward=new JLabel(WARDName,JLabel.CENTER);
			lbl_Ward.setForeground(fcl);
			lbl_Ward.setOpaque(true);
			lbl_Ward.setBackground(clBK);
			lbl_Ward.setBounds(90,15,160,20);
			
			JLabel lb2=new JLabel("Room No.");
			lb2.setForeground(fcl);
			lb2.setOpaque(false);
			lb2.setBounds(10,60,80,20);
			lbl_Room=new JLabel(Room,JLabel.CENTER);
			lbl_Room.setForeground(fcl);
			lbl_Room.setOpaque(true);
			lbl_Room.setBackground(clBK);
			lbl_Room.setBounds(90,60,160,20);
			
			JLabel lb3=new JLabel("Bed No.");
			lb3.setForeground(fcl);
			lb3.setOpaque(false);
			lb3.setBounds(10,105,80,20);
			lbl_BedNo=new JLabel(Bed,JLabel.CENTER);
			lbl_BedNo.setForeground(fcl);
			lbl_BedNo.setOpaque(true);
			lbl_BedNo.setBackground(clBK);
			lbl_BedNo.setBounds(90,105,160,20);
			
			
			
			bt_CloseDG.setMnemonic('c');
			bt_CloseDG.setBounds(70,180,150,30);
			bt_CloseDG.setToolTipText("Close");
		
			
				
			cnDIALOG.add(lb1);
			cnDIALOG.add(lbl_Ward);
			cnDIALOG.add(lb2);
			cnDIALOG.add(lbl_Room);
			cnDIALOG.add(lb3);
			cnDIALOG.add(lbl_BedNo);
			cnDIALOG.add(bt_CloseDG);
	
		}
	}
	
	private void LoadPateintInfoByID(int getid)
	{
			try
			{
				int pid=getid;
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
				qry="Select patientid,name,address,phone_no from patient_Profile where patientid="+pid+"";
				String loadDetail[][]=inf.getResultSetAs_2D_Array(qry,4);
				
				if(loadDetail!=null)
				{
					int lenof=loadDetail.length;
							
					String loadPDt[][]=new String[lenof][5];
					int ind=1,C=0;
					for(int R=0;R<lenof;R++)
					{
						
						loadPDt[R][C++]=""+(ind++);
						loadPDt[R][C++]=loadDetail[0][0];
						loadPDt[R][C++]=loadDetail[0][1];
						loadPDt[R][C++]=loadDetail[0][2];
						loadPDt[R][C++]=loadDetail[0][3];
						dtm.addRow(loadPDt[R]);
					}
							
				}
			
			}
			catch(Exception ex)
			{
					System.out.println("ERROR..IN LoadPateintInfoByID Method"+ex);
			}
	}
	
	private void LoadPatientInfoByName()
	{
		String Pname=tf_patientNAME.getText();
	
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
					
										
					qry="Select patientid from patient_Profile where name='"+Pname+"'";
		
					String loadID[]=inf.getResultSetAs_1D_Array(qry);
					if(loadID!=null)
					{
							chkCORRECTID=1;
														
					}			
					else
					{
						JOptionPane.showMessageDialog(this,"Patient Doesn't Exist","Message",JOptionPane.ERROR_MESSAGE);						
					}
					if(chkCORRECTID==1)
					{
						int lenofLD=loadID.length;
				
						for(int i=0;i<lenofLD;i++)
						{
							
							qry="Select patientid,name,address,phone_no from patient_Profile where patientid="+loadID[i]+"";
					
							String loadDetail[][]=inf.getResultSetAs_2D_Array(qry,4);
				
							if(loadDetail!=null)
							{
								int lenof=loadDetail.length;
							
								String loadPDt[][]=new String[lenof][5];
								int ind=1,C=0;
								for(int R=0;R<lenof;R++)
								{
									System.out.println(loadDetail[0][0]);
									System.out.println(loadDetail[0][1]);
									loadPDt[R][C++]=""+(ind++);
									loadPDt[R][C++]=loadDetail[0][0];
									loadPDt[R][C++]=loadDetail[0][1];
									loadPDt[R][C++]=loadDetail[0][2];
									loadPDt[R][C++]=loadDetail[0][3];
									dtm.addRow(loadPDt[R]);
								}
							
							}
						}
						
					}
		}
		catch(Exception ex)
		{
				System.out.println("ERROR..IN LoadPatientInfoByName Method"+ex);
		}
	}
}