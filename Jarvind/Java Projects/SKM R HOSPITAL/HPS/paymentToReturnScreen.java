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

class paymentToReturnScreen extends JFrame implements ActionListener,KeyListener
{
	JInternalFrame Searchfrm;
	
	DefaultTableModel dtm;
	JTable table;
	JPanel pn;
	JTextField tf_patientID,tf_customerID;
	JTextField jTextField1,jTextField2;
	JComboBox cb_Ward,cb_BedNo;
	//JLabel lbl_Room,lbl_Ward,lbl_BedNo;
	JLabel lb2,lb4;
	JButton bt_Save,bt_CLOSE,bt_Search;
	JButton bt_CloseDG=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
	ButtonGroup genGp=new ButtonGroup();
	JRadioButton rb1,rb2;
	String qry,setip,getward,bedNo,ID,st="",wardNM,room_No,bed_No;
	boolean flag=true;
	int chkCORRECTID=0,pid=0;
			String gotid="";
//	SetDialog SD;
	ZedInterface inf;
	//	String warname;
	//	dt1=new Date();
	//	dt2=new Date();; 

	public paymentToReturnScreen(JDesktopPane dp1)
	{
		
		
	//	String head[]={"Sno.","Patient ID","Name","Address","Phone No."};
	//	dtm=new DefaultTableModel(head,0);
	//	table=new JTable(dtm);
	//	JScrollPane jsp_Table=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	//	String getID=""+ID;
	//	flag=FLAG;
		
		Searchfrm=new JInternalFrame("PATIENT SEARCH WINDOW",true,true,false,true);
		Container cn=Searchfrm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		Searchfrm.setBounds(100,50,500,380);
	//	cn.setBounds(100,50,400,480);
	//	setTitle("FEE DETAIL WINDOW");
	
		Color fcl=new Color(0,0,128);
	///	Color clB=new Color(0,225,225);
		Font fnt=new Font("Arial NArrow",Font.BOLD,9);
		pn=new JPanel();
		pn.setBounds(10,20,470,300);
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
		rb2=new JRadioButton("Search By Customer ID");
		rb2.setOpaque(false);
		rb2.setBounds(10,55,170,20);
		genGp.add(rb1);
		genGp.add(rb2);
		
		tf_patientID=new JTextField();
		tf_patientID.setBounds(180,25,170,20);
		
		tf_customerID=new JTextField();
		tf_customerID.setBounds(180,55,170,20);
		
		
		bt_Search=new JButton("Search",new ImageIcon("\\icons\\search.gif"));
		bt_Search.setMnemonic('s');
		bt_Search.setBounds(360,25,100,60);
		bt_Search.setToolTipText("Search");
		
		
		JLabel lb1=new JLabel("ID");
		lb1.setForeground(fcl);
		lb1.setOpaque(false);
		lb1.setBounds(20,115,30,20);
		
		lb2=new JLabel("",JLabel.CENTER);
		lb2.setForeground(fcl);
		lb2.setOpaque(true);
		lb2.setBackground(Color.red);
		lb2.setBounds(45,115,120,20);
		
		JLabel lb3=new JLabel("Name");
		lb3.setForeground(fcl);
		lb3.setOpaque(false);
		lb3.setBounds(180,115,60,20);
		
		lb4=new JLabel("",JLabel.LEFT);
		lb4.setForeground(fcl);
		lb4.setOpaque(true);
		lb4.setBackground(Color.red);
		lb4.setBounds(230,115,220,20);
		
		JLabel lb5=new JLabel("Purpose To Pay");
		lb5.setForeground(fcl);
		lb5.setOpaque(false);
		lb5.setBounds(20,160, 100,20);
		
		jTextField1=new JTextField();
		jTextField1.setBounds(130,160,320,20);
		
		JLabel lb6=new JLabel("Amount To Pay");
		lb6.setForeground(fcl);
		lb6.setOpaque(false);
		lb6.setBounds(20,200,100,20);
		
		
		jTextField2=new JTextField();
		jTextField2.setBounds(130,200,200,20);
		jTextField2.setHorizontalAlignment(JTextField.RIGHT);
		
		
		
	//	jsp_Table.setBounds(20,140,515,200);
		
		bt_Save=new JButton("Save",new ImageIcon("\\icons\\save.gif"));
		bt_Save.setMnemonic('a');
		bt_Save.setBounds(20,250,180,30);
		bt_Save.setToolTipText("Search");
		
		bt_CLOSE=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		bt_CLOSE.setMnemonic('c');
		bt_CLOSE.setBounds(270,250,180,30);
		bt_CLOSE.setToolTipText("Close");
		
	
		pn.add(rb1);
		pn.add(rb2);
		pn.add(tf_patientID);
		pn.add(tf_customerID);
		pn.add(bt_Search);
	//	pn.add(jsp_Table);
		pn.add(lb1);
		pn.add(lb2);
		pn.add(lb3);
		pn.add(lb4);
		pn.add(lb5);
		pn.add(lb6);
		pn.add(jTextField1);
		pn.add(jTextField2);
		pn.add(bt_Save);
		pn.add(bt_CLOSE);
	
			
		cn.add(pn);
		dp1.add(Searchfrm);
		Searchfrm.setVisible(true);
		
	/*	setip=getIPaddress.IP();
		System.out.println("setip "+setip);*/
		
		tf_patientID.addKeyListener(this);
		tf_customerID.addKeyListener(this);
		bt_Save.addActionListener(this);
		bt_CloseDG.addActionListener(this);
		bt_CLOSE.addActionListener(this);
		bt_Search.addActionListener(this);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
		jTextField1.addKeyListener(this);
		jTextField2.addKeyListener(this);
	/*	bt_DISCHARGE.addActionListener(this);
		bt_CLOSE.addActionListener(this);
		
		tf_patientID.addKeyListener(this);*/
	//	bt_DISCHARGE.addKeyListener(this);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==bt_Save)
		{
			 
			if(jTextField1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Error !\nPlease Enter The Purpose","Message",JOptionPane.ERROR_MESSAGE);
				jTextField1.requestFocus();
			}
			else if(jTextField2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Error !\nPlease Enter The Amount","Message",JOptionPane.ERROR_MESSAGE);
				jTextField2.requestFocus();
			}
			else
			{
				try
				{
					double amt=Double.valueOf(jTextField2.getText());
					flag=true;
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,"Error !\nPlease Input Correct ID(Number Only)","Message",JOptionPane.ERROR_MESSAGE);
				//	jTextField2.setText("");
					jTextField2.requestFocus();
					flag=false;
				}
				if(flag)
					save();	
				
			}
			
		}

		if(ae.getSource()==bt_CLOSE)
		{
			Searchfrm.dispose();
		}
		else if(rb1.isSelected())
		{
		//	System.out.println("inside rb1");
			tf_patientID.setEditable(true);
			tf_patientID.requestFocus();
			tf_customerID.setText(st);
			tf_customerID.setEditable(false);
			lb2.setText("");
			lb4.setText("");
		//	jTextField1.setText("");
		//	jTextField2.setText("");
		//	System.out.println("val inside rb1  "+tf_patientID.getText());
		}
		else if(rb2.isSelected())
		{
		//	System.out.println("inside rb2");
			
			tf_customerID.setEditable(true);
			tf_customerID.requestFocus();
			tf_patientID.setText("");
			tf_patientID.setEditable(false);
			lb2.setText("");
			lb4.setText("");
		//	jTextField1.setText("");
		//	jTextField2.setText("");
		//	System.out.println("val inside rb2   "+tf_customerID.getText());
		
		}
		if(ae.getSource()==bt_Search)
		{
			
		//	dtm.setRowCount(0);
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
			else if((rb2.isSelected()==true)&&(tf_customerID.getText().equals(st)))	
			{
				JOptionPane.showMessageDialog(this,"Please Enter Customer ID","Message",JOptionPane.PLAIN_MESSAGE);
			}
			else if((rb2.isSelected()==false)&&(!tf_customerID.getText().equals(st)))	
			{
				JOptionPane.showMessageDialog(this,"Please Select RadioButton Search By Customer ID","Message",JOptionPane.PLAIN_MESSAGE);
			}
			else if((rb2.isSelected()==true)&&(!tf_customerID.getText().equals(st)))	
			{
				
				
			checkCustomerID();
				
				
		//		LoadPatientInfoByName();
			}
				
		}
		
		
	}
	public void keyPressed(KeyEvent ke)
	{
		
		if(ke.getSource()==tf_patientID && ke.getKeyCode()==ke.VK_ENTER)
		{
			bt_Search.requestFocus();
		}
		else if(ke.getSource()==tf_customerID && ke.getKeyCode()==ke.VK_ENTER)
		{
			bt_Search.requestFocus();
		}
		else if(ke.getSource()==jTextField1 && ke.getKeyCode()==ke.VK_ENTER)
		{
			jTextField2.requestFocus();
		}
		else if(ke.getSource()==jTextField2 && ke.getKeyCode()==ke.VK_ENTER)
		{
			bt_Save.requestFocus();
		}
		
		
		
	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}

	
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
				qry="Select patientid,name from patient_Profile where patientid="+pid+"";
				String loadDetail[][]=inf.getResultSetAs_2D_Array(qry,2);
				
				if(loadDetail!=null)
				{
				//	int lenof=loadDetail.length;
				
					lb2.setText(loadDetail[0][0]);
					lb4.setText(loadDetail[0][1]);
					
							
					/*String loadPDt[][]=new String[lenof][5];
					int ind=1,C=0;
					for(int R=0;R<lenof;R++)
					{
						
						loadPDt[R][C++]=""+(ind++);
						loadPDt[R][C++]=loadDetail[0][0];
						loadPDt[R][C++]=loadDetail[0][1];
						loadPDt[R][C++]=loadDetail[0][2];
						loadPDt[R][C++]=loadDetail[0][3];
						dtm.addRow(loadPDt[R]);
					}*/
							
				}
			
			}
			catch(Exception ex)
			{
					System.out.println("ERROR..IN LoadPateintInfoByID Method"+ex);
			}
	}
	
	private void LoadCustomerDetail(String Cust_id)
	{
		String Custid=Cust_id;
		try
		{
			
			try
			{
				inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			}
			catch(Exception e)
			{
				System.out.println("Error at the time of connection with server  "+getIPaddress.IP()+e);
				getIPaddress.changeIP();
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connecton with rmi//127.0.0.1/ExtendedZedServer"+ex);
					
				}
			}
			
			String qry="Select cID,cName from customer_SpectsProvidation where cID='"+Custid+"'";
	//		System.out.println("qry  "+qry);
			String arr[][]=inf.getResultSetAs_2D_Array(qry,2);
			if(arr!=null)
			{
				lb2.setText(arr[0][0]);
				lb4.setText(arr[0][1]);
			}
		}
		catch(Exception e)
		{
			System.out.println("ERROR......"+e);
		}
	}
	
	private void save()
	{
		System.out.println("inside save");

		
		if(rb1.isSelected())
		{
				gotid=tf_patientID.getText().trim();
				System.out.println("getid  "+gotid);
		}
		else if(rb2.isSelected())
		{
			gotid=tf_customerID.getText().trim();
			System.out.println("getid of cust  "+gotid);
		}
			
		try
		{
			try
			{
				inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			}
			catch(Exception e)
			{
				System.out.println("Error at the time of connection with server "+getIPaddress.IP()+e);
				getIPaddress.changeIP();
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connection with ip rmi//127.0.0.1/ExtendedZedServer"+ex);
				}
			}
			
		java.util.Date dt=new java.util.Date();
			int getdt=dt.getDate();
		//	System.out.println("date "+getdt);
			int getmon=1+dt.getMonth();
		//	System.out.println("getmon  "+getmon);
			int getYr=dt.getYear()+1900;
		//	System.out.println("getYr  "+getYr);
			String curdt=getmon+"/"+getdt+"/"+getYr;
		//	System.out.println("curdt  "+curdt);
			
			if(rb1.isSelected())
			{
				String qry="insert into payment_ToReturn values('"+gotid+"',#"+curdt+"#,'"+jTextField1.getText().trim()+"',"+Double.valueOf(jTextField2.getText().trim())+",'"+lb4.getText()+"')";
		//		System.out.println("qry  "+qry);
				inf.executeUpdateQuery(qry);
		//		System.out.println("successful  ");
				JOptionPane.showMessageDialog(this,"Data Saved Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
				tf_patientID.setText("");
				lb2.setText("");
				lb4.setText("");
				jTextField1.setText("");
				jTextField2.setText("");
			}
			else if(rb2.isSelected())
			{
				String qry="insert into payment_ToReturn values('"+gotid+"',#"+curdt+"#,'"+jTextField1.getText().trim()+"',"+Double.valueOf(jTextField2.getText().trim())+",'"+lb4.getText()+"')";
			//	System.out.println("qry  "+qry);
				inf.executeUpdateQuery(qry);
		//		System.out.println("successful entry ");
				JOptionPane.showMessageDialog(this,"Data Saved Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
				tf_customerID.setText("");
				lb2.setText("");
				lb4.setText("");
				jTextField1.setText("");
				jTextField2.setText("");
			}	
			
					
		}
		catch(Exception e)
		{
			System.out.println("ERROR IN save method");
		}
	}
	private void checkCustomerID()
	{
	
		System.out.println("val inside fun  "+tf_customerID.getText());
			char getstr=tf_customerID.getText().charAt(tf_customerID.getText().length()-tf_customerID.getText().length());
				System.out.println("getstr   "+getstr);
				if((""+getstr).equalsIgnoreCase("C"))
				{
					
					try
					{
					
						try
						{
							inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
						}
						catch(Exception e)
						{
							System.out.println("Error at the time of connection with server"+getIPaddress.IP()+e);
							getIPaddress.changeIP();
							try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
							}
							catch(Exception ex)
							{
								System.out.println("Error at the time of connection with rmi//127.0.0.1/ExtendedZedServer"+ex);
							}
						}
					
					
				
						String qry="Select cID from customer_SpectsProvidation where cID='"+(tf_customerID.getText().trim())+"'";
					//	System.out.println("qry  "+qry);
						String getCust_ID[]=inf.getResultSetAs_1D_Array(qry);
					//	System.out.println("getCust   "+getCust_ID[0]);
						String Cust_id=getCust_ID[0];
					//	System.out.println("Cust_id "+Cust_id);
						if(getCust_ID==null)
							JOptionPane.showMessageDialog(this,"Error..!\nWrong ID","Message",JOptionPane.ERROR_MESSAGE);
						else
							LoadCustomerDetail(Cust_id);		
									
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(this,"Error..!\nWrong ID","Message",JOptionPane.ERROR_MESSAGE);
					}
				
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Error..!\nPlease Enter Correct Id(e.g. C1)","Message",JOptionPane.ERROR_MESSAGE);
				}
				
	}
	

}