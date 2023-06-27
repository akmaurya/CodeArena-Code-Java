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

class staffSalary extends JFrame implements ActionListener,MouseListener,KeyListener
{
	JInternalFrame salaryfrm;
	
	DefaultTableModel dtm;
	JTable table;
	JPanel pn;
	Date dt1,dt2;
	JTextField tf_Pay,tf_PayAdv;
	JComboBox cb_Month,cb_Year;
	JLabel lb_Date,lb_Pay;
	JButton bt_ADVANCE,bt_PAID,bt_CLOSE,bt_Date;
	String qry,setip,getward,bedNo,ID,st="";
	String Mon="",Yer="";
	double totamount=00.0,paidAmt=0.0;
	ZedInterface inf;
	//	String warname;
	//	dt1=new Date();
	//	dt2=new Date();; 
	int totalPaidAmt=0,cnt=0,chk=0,getrwcount=0,getCOUNT=0;
	double otheramt=0,totalAmt=0;
	String loadIDandATTD[][]=null;
	public staffSalary(JDesktopPane dp1)
	{
		
		String head[]={"Sno.","Staff Code","Name","Salary","Paid Salary","Due Salary","Advance"};
		dtm=new DefaultTableModel(head,0);
		table=new JTable(dtm);
		JScrollPane jsp_Table=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);	
	//	String getID=""+ID;
	//	flag=FLAG;
		
		salaryfrm=new JInternalFrame("STAFF SALARY WINDOW",true,true,false,true);
		Container cn=salaryfrm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		salaryfrm.setBounds(100,50,830,570);
	//	cn.setBounds(100,50,400,480);
	//	setTitle("FEE DETAIL WINDOW");
	
		Color fcl=new Color(0,0,128);
	///	Color clB=new Color(0,225,225);
		Font fnt=new Font("Arial Narrow",Font.BOLD,9);
		pn=new JPanel();
		pn.setBounds(10,30,800,480);
		pn.setLayout(null);
	//	p1.setBackground(cl);
		pn.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Salary Detail");
		pn.setBorder(tb);
		pn.setOpaque(false);
		
		pn.setFont(fnt);
		
		Color clBK=new Color(225,248,137);
		JLabel lb1=new JLabel("Date");
		lb1.setForeground(fcl);
		lb1.setOpaque(false);
		lb1.setBounds(600,5,60,20);
		cn.add(lb1);
		
		java.util.Date Dt=new Date();
		int date=Dt.getDate();
		int mon=Dt.getMonth()+1;
		int year=Dt.getYear()+1900;
		String currentdt=date+"/"+mon+"/"+year;
		
		lb_Date=new JLabel(currentdt,JLabel.CENTER);
		lb_Date.setForeground(fcl);
		lb_Date.setOpaque(true);
		lb_Date.setBackground(clBK);
		lb_Date.setBounds(663,5,100,20);
		cn.add(lb_Date);
		
	
		bt_Date=new JButton(new ImageIcon("icons\\calendar.gif"));
		bt_Date.setBounds(765,5,20,20);
		cn.add(bt_Date);
		
		JLabel lb2=new JLabel("Select Month");
		lb2.setForeground(fcl);
		lb2.setOpaque(false);
		lb2.setBounds(360,30,100,20);
		pn.add(lb2);
		
		cb_Month=new JComboBox();
		cb_Month.setBounds(440,30,120,20);
		pn.add(cb_Month);
		
		String arr[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
		System.out.println(arr.length);
		for(int i=0;i< arr.length;i++)
		{
			cb_Month.addItem(arr[i]);
		}
		
		
		JLabel lb3=new JLabel("Select Year");
		lb3.setForeground(fcl);
		lb3.setOpaque(false);
		lb3.setBounds(590,30,100,20);
		pn.add(lb3);
		
		cb_Year=new JComboBox();
		cb_Year.setBounds(660,30,120,20);
		pn.add(cb_Year);
		
		String arr1[]={"2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024"
		,"2025","2026","2027","2028","2029","2030","2031","2032","2033","2034","2035","2036","2037","2038","2039","2040"
		,"2041","2042","2043","2044","2045","2046","2047","2048","2049","2050"};
		System.out.println(arr.length);
		for(int i=0;i< arr1.length;i++)
		{
			cb_Year.addItem(arr1[i]);
		}
		
			
		jsp_Table.setBounds(20,80,760,200);
		pn.add(jsp_Table);
		
		JLabel lb4=new JLabel("Enter amount to pay (in Rs.)");
		lb4.setForeground(fcl);
		lb4.setOpaque(false);
		lb4.setBounds(450,290,180,20);
		pn.add(lb4);
		
		tf_Pay=new JTextField();
		tf_Pay.setBounds(620,290,160,25);
		pn.add(tf_Pay);
		tf_Pay.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel lb5=new JLabel("Adjust with advance payment (in Rs.)");
		lb5.setForeground(fcl);
		lb5.setOpaque(false);
		lb5.setBounds(395,320,210,20);
		pn.add(lb5);
		
		tf_PayAdv=new JTextField();
		tf_PayAdv.setBounds(620,320,160,25);
		pn.add(tf_PayAdv);
		tf_PayAdv.setHorizontalAlignment(JTextField.RIGHT);
		
		JLabel lb6=new JLabel("Adjust cash amount to pay ");
		lb6.setForeground(fcl);
		lb6.setOpaque(false);
		lb6.setBounds(450,350,180,20);
		pn.add(lb6);
		
		lb_Pay=new JLabel("",JLabel.RIGHT);
		lb_Pay.setForeground(fcl);
		lb_Pay.setOpaque(true);
		lb_Pay.setBackground(clBK);
		lb_Pay.setBounds(620,350,160,25);
		pn.add(lb_Pay);
		
		
		bt_ADVANCE=new JButton("Advance");//,new ImageIcon("icons\\forward.gif")
		bt_ADVANCE.setMnemonic('a');
		bt_ADVANCE.setBounds(165,420,150,30);
		bt_ADVANCE.setToolTipText("Advance");
		pn.add(bt_ADVANCE);
		
		
		bt_PAID=new JButton("Paid");//,new ImageIcon("icons\\forward.gif")
		bt_PAID.setMnemonic('d');
		bt_PAID.setBounds(325,420,150,30);
		bt_PAID.setToolTipText("Paid");
		pn.add(bt_PAID);
		
		bt_CLOSE=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		bt_CLOSE.setMnemonic('c');
		bt_CLOSE.setBounds(485,420,150,30);
		bt_CLOSE.setToolTipText("Close");
		pn.add(bt_CLOSE);
		
		
		cn.add(pn);
		dp1.add(salaryfrm);
		salaryfrm.setVisible(true);
		
		bt_Date.addActionListener(this);
		//setip=getIPaddress.IP();
	//	System.out.println("setip "+setip);
		
		cb_Month.addActionListener(this);
		cb_Year.addActionListener(this);
		bt_ADVANCE.addActionListener(this);
		bt_PAID.addActionListener(this);
		bt_CLOSE.addActionListener(this);
		table.addMouseListener(this);
		
		tf_Pay.addKeyListener(this);
		tf_PayAdv.addKeyListener(this);
		
		getInitialInfo();
		
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt_Date)
		{
			Cal calender=new Cal();
			String date=calender.getdate();
			lb_Date.setText(date);
			
		}
		else if(ae.getSource()==cb_Month)
		{
			Mon=""+cb_Month.getSelectedIndex();
		//	System.out.println("Mon "+Mon);
			int MONTH=1+(Integer.parseInt(Mon));
			Yer=""+cb_Year.getSelectedItem();
		//	System.out.println("Yer "+Yer);
			staffAttendance(MONTH,Yer);
		}
		else if(ae.getSource()==cb_Year)
		{
			Mon=""+cb_Month.getSelectedIndex();
		//	System.out.println("Mon "+Mon);
			int MONTH=1+(Integer.parseInt(Mon));
			Yer=""+cb_Year.getSelectedItem();
		//	System.out.println("Yer "+Yer);
			staffAttendance(MONTH,Yer);
		}
		else if(ae.getSource()==bt_ADVANCE)
		{
			if(!(tf_PayAdv.equals("")))
			{
				
				
				advancePaymentFun();
			}
			//	System.out.println("getrwValue "+getrwValue);
				
		/*	else
			{
				JOptionPane.showMessageDialog(this,"Please Enter Value","Mesage",JOptionPane.ERROR_MESSAGE);	
			}*/
		}
		else if(ae.getSource()==bt_PAID)
		{
			staffMonthlyPaymentFun();	
		}
		else if(ae.getSource()==bt_CLOSE)
		{
			salaryfrm.dispose();
		}
	
			
	}
	public void mousePressed(MouseEvent me)
	{
		System.out.println("go");
		if(me.getSource()==table)
		{
			getrwcount=table.getRowCount();
			System.out.println("getrwcount "+getrwcount);
			if(getrwcount!=-1)
			{
				getCOUNT=table.getSelectedRow();
				System.out.println("getCOUNT "+getCOUNT);
				String getdueSAL=""+table.getValueAt(getCOUNT,5);
				System.out.println("getdueSAL "+getdueSAL);
				java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
				sum1.add(new java.math.BigDecimal(getdueSAL));
				tf_Pay.setText(((""+(new java.math.BigDecimal(getdueSAL).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)))));
				if(tf_Pay.getText().equals("0.00"))
				{
					bt_PAID.setEnabled(false);
				}
				else
				{
					tf_Pay.requestFocus();
					bt_PAID.setEnabled(true);
				}
				
			}      
		}
		
	}
	public void mouseClicked(MouseEvent me)
	{}
	public void mouseReleased(MouseEvent me)
	{}
	public void mouseEntered(MouseEvent me)
	{
		
	}
	public void mouseExited(MouseEvent me)
	{}
	public void keyPressed(KeyEvent ke)
	{
	
		if(ke.getSource()==tf_Pay && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_PayAdv.requestFocus();
		
		}
		
		else if(ke.getSource()==tf_PayAdv && ke.getKeyCode()==ke.VK_ENTER)
		{
			if((tf_PayAdv.getText().trim().equals("")))
			{
				tf_PayAdv.setText("0");
			}
			if(!tf_PayAdv.getText().trim().equals(""))
			{
				try
				{
				
				//	String getrwValue=""+table.getValueAt(getCOUNT,1);
				//	System.out.println("getrwValue "+getrwValue);
					String getpay=tf_Pay.getText();
					java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
					sum1.add(new java.math.BigDecimal(getpay));
					String setpay=(""+(new java.math.BigDecimal(getpay).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					tf_Pay.setText(setpay);
				
				
					String getadvpay=tf_PayAdv.getText();
				
					sum1.add(new java.math.BigDecimal(getadvpay));
					String setadvpay=(""+(new java.math.BigDecimal(getadvpay).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					tf_PayAdv.setText(setadvpay);
				
					double showdiff=Double.valueOf(setpay)-Double.valueOf(setadvpay);
					System.out.println("showdiff "+showdiff);
				
					sum1.add(new java.math.BigDecimal(showdiff));
					String totalpay=(""+(new java.math.BigDecimal(showdiff).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					lb_Pay.setText(totalpay);
					}
				catch(Exception ex)
				{
					System.out.println("ERROR.. IN "+ex);
				}
				
											
			}
			else
			{
				try
				{
				
					String getpay=tf_Pay.getText();
					java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
					sum1.add(new java.math.BigDecimal(getpay));
					String setpay=(""+(new java.math.BigDecimal(getpay).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					tf_Pay.setText(setpay);
					
					
					double setadv=00.0;
					sum1.add(new java.math.BigDecimal(setadv));
					String setadpay=(""+(new java.math.BigDecimal(setadv).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					double showdiff=Double.valueOf(setpay)-Double.valueOf(setadpay);
					
					
					sum1.add(new java.math.BigDecimal(showdiff));
					String totalpay=(""+(new java.math.BigDecimal(showdiff).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					lb_Pay.setText(totalpay);
				}
				catch(Exception ex)
				{
					System.out.println("ERROR.. IN "+ex);
				}
					
					
			}
			
		
		}
	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}
	
	private void staffAttendance(int MONTH,String Yer)
	{
		int MON1=MONTH;
		
		String YER1=Yer;
	//	System.out.println("MON1 "+MON1);
		String dt1=YER1+"/"+MON1+"/"+"1";
		
	//	System.out.println("dt1 "+dt1);
		String dt2=YER1+"/"+MON1+"/"+"30";
		
	//	System.out.println("dt2 "+dt2);
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
			String qry="Select s_Code from staff_Details";
	//		System.out.println("qry "+qry);
			String loadSCode[]=inf.getResultSetAs_1D_Array(qry);
	//		System.out.println("lenofloadSCode "+loadSCode.length);
			loadIDandATTD=new String[loadSCode.length][2];
			for(int i=0;i<loadSCode.length;i++)
			{
			//	System.out.println(i+" "+loadSCode[i]);
				int c=0;
				String qry1="Select count(s_Code) from staff_AttendanceRegister where attend_Dt>=#"+dt1+"# And attend_Dt<=#"+dt2+"# And s_Code="+loadSCode[i]+"";
			//	System.out.println("qry1 "+qry1);
				String loadATTD=inf.getSingleValue(qry1);
				
			//	System.out.println("ATTENDANCE");
			//	System.out.println(loadATTD);
				if(loadATTD!=null)
				{
					loadIDandATTD[i][c]=loadSCode[i];
				loadIDandATTD[i][++c]=loadATTD;
				}
				else
				{
					
					loadIDandATTD[i][c]=loadSCode[i];
				loadIDandATTD[i][++c]=(""+(new java.math.BigDecimal("0.0").setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
				}
				
				
			
			}
			
			
			//	double convrt=Double.valueOf(loadStaffDetail[R][++h]);
			//		loadDetail[R][++c]=""+(((int)convrt)/30);
			
			//int ind1=0;
			int getrwcnt=dtm.getRowCount();
		//	System.out.println("getrwcnt "+getrwcnt);
		//	String loadSal[][]=new String[getrwcnt][];
			qry="Select s_Code,s_Salary from staff_Details";
			String loadSCandSalary[][]=inf.getResultSetAs_2D_Array(qry,2);
			if(loadSCandSalary!=null)
			{
				for(int j=0;j<loadSCandSalary.length;j++)
				{
					int k=0;
				//	System.out.println(j+""+loadSCandSalary[j][k]);
					String scode=loadSCandSalary[j][k];
					//System.out.println(j+""+loadSCandSalary[j][++k]);
					String salary=loadSCandSalary[j][++k];
					double convrt=Double.valueOf(salary);
					for(int s=0;s<loadIDandATTD.length;s++)
					{
						if((Integer.parseInt(scode))==Integer.parseInt(loadIDandATTD[s][0]))
						{
							java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
							double cntdays=convrt/30;
							double cntsal=cntdays*(Double.valueOf(loadIDandATTD[s][1]));
						//	System.out.println("cntsal "+cntsal);
							String setsal=""+cntsal;
						//	System.out.println("setsal "+setsal);
							sum1.add(new java.math.BigDecimal(cntsal));
						//	System.out.println("sum1="+""+sum1);
							//table.setValueAt((""+sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP)),s,3);
							table.setValueAt((""+(new java.math.BigDecimal(cntsal).setScale(2,java.math.BigDecimal.ROUND_HALF_UP))),s,3);
							
							//table.setValueAt(setsal,s,3);
						}
					}
					
				}
			}
			
			String qry1="Select s_Code from staff_SalaryDetails";
			String loadSCode1[]=inf.getResultSetAs_1D_Array(qry);
			if(loadSCode1!=null)
			{
				for(int i=0;i<loadSCode1.length;i++)
				{
				
					String qry2="Select sum(s_PaidAmt) from staff_SalaryDetails where s_Code="+loadSCode1[i]+" AND s_Month="+MON1+" AND s_Year="+Integer.parseInt(YER1)+"";
				//	System.out.println("qry2 "+qry2);
				//	String loadStafDetail[][]=inf.getResultSetAs_2D_Array(qry2,1);
					String loadstafSAL=inf.getSingleValue(qry2);
				//	System.out.println("lenof sal sum "+loadstafSAL);
				
					
					
							if(loadstafSAL!=null)
							{
									//////////////////PAID SALARY////////////////
									java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
								//	double loadPaidsal=Double.valueOf(loadStafDetail[0][0]);
									double loadPaidsal=Double.valueOf(loadstafSAL);
							//		System.out.println("loadPaidsal= "+loadPaidsal);
									sum1.add(new java.math.BigDecimal(loadPaidsal));
									table.setValueAt((""+(new java.math.BigDecimal(loadPaidsal).setScale(2,java.math.BigDecimal.ROUND_HALF_UP))),i,4);
									/////////////////////////////////////////////
							}
							else
							{
								java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
								double loadPaidsal=00.0;
								sum1.add(new java.math.BigDecimal(loadPaidsal));
								table.setValueAt((""+(new java.math.BigDecimal(loadPaidsal).setScale(2,java.math.BigDecimal.ROUND_HALF_UP))),i,4);
							}		
							
							
							
									////////////////////DUE SALARY///////////////
									java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
									String gettotsalary=""+table.getValueAt(i,3);
									double covrtSALARY=Double.valueOf(gettotsalary);
									String getpaidsalary=""+table.getValueAt(i,4);
									double convrtpaidsalary=Double.valueOf(getpaidsalary);
																	
									double SLADIFF=covrtSALARY-convrtpaidsalary;
								//	System.out.println("SLADIFF "+SLADIFF);
									sum1.add(new java.math.BigDecimal(SLADIFF));
									table.setValueAt((""+(new java.math.BigDecimal(SLADIFF).setScale(2,java.math.BigDecimal.ROUND_HALF_UP))),i,5);
									
									////////////////////////////////////////////
									
									//////////////////ADVANCE///////////////////
									
									String qry3="Select s_AdvanceAmt from staff_AdvancePaymentDetails where s_Code="+loadSCode1[i]+"";
								//	System.out.println("qry3 "+qry3);
									String loadADV=inf.getSingleValue(qry3);
									if(loadADV!=null)
									{
										
										sum1.add(new java.math.BigDecimal(loadADV));
										table.setValueAt((""+(new java.math.BigDecimal(loadADV).setScale(2,java.math.BigDecimal.ROUND_HALF_UP))),i,6);
									}
									else
									{
										double loadAD=00.0;
										sum1.add(new java.math.BigDecimal(loadAD));
										table.setValueAt((""+(new java.math.BigDecimal(loadAD).setScale(2,java.math.BigDecimal.ROUND_HALF_UP))),i,6);
										
									}
									
									////////////////////////////////////////////
									
				}
			}
			else
			{
				System.out.println("NO DATA AVAILABLE");
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR...IN staffAttendance Fun"+ex);
		}
		int lenof=loadIDandATTD.length;
	
		
		
	}
	private void getInitialInfo()
	{
		try
		{
		///	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
			String qry="Select s_Code,s_Name from staff_Details";
		//	System.out.println("qry "+qry);
			String loadStaffDetail[][]=inf.getResultSetAs_2D_Array(qry,2);
			if(loadStaffDetail!=null)
			{
				int lenofSD=loadStaffDetail.length;
				System.out.println("lenofSD "+lenofSD);
			
				
				int ind=1;
				String loadDetail[][]=new String[loadStaffDetail.length][4];
				for(int R=0;R<loadDetail.length;R++)
				{
					int c=0,h=0;
					loadDetail[R][c]=""+(ind++);
					loadDetail[R][++c]=loadStaffDetail[R][h];
					loadDetail[R][++c]=loadStaffDetail[R][++h];
					dtm.addRow(loadDetail[R]);
				
				}	
			}
			else
			{
				System.out.println("not loaded");
			}
			
		}
		catch(Exception ex)
		{
				System.out.println("ERROR..IN getInitialInfo Fun"+ex);
		}
	}
	private void advancePaymentFun()
	{
		
		int chkSCODE=0,chkSCODE1=0,chkSCODE2=0;
		String getrwValue=""+table.getValueAt(getCOUNT,1);
		
		
			if(lb_Pay.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Blank Box Can't Be Saved Pres Enter To Calculate Salary","Message",JOptionPane.ERROR_MESSAGE);
				tf_Pay.requestFocus();
			}
			else
			{
		int variable=JOptionPane.showConfirmDialog(this,"Do You Want To Save This Record","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
				if(variable==JOptionPane.YES_OPTION)
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
						String qry1="Select s_Code from staff_AdvancePaymentDetails";
						String loadSTAFFCD[]=inf.getResultSetAs_1D_Array(qry1);
					//	System.out.println("lenofloadSTAFFCD "+loadSTAFFCD.length);
						if(loadSTAFFCD!=null)
						{
							for(int j=0;j<loadSTAFFCD.length;j++)
							{
							//	System.out.println("loadSTAFFCD "+loadSTAFFCD[j]);
								if(getrwValue.equals(loadSTAFFCD[j]))
								{
									chkSCODE=1;
							//		System.out.println("chkSCODE   "+chkSCODE);
								}
							
							}
						}
					
				
					
					if(chkSCODE==1)
					{
					//	System.out.println("already exists.....");
						String getADV=lb_Pay.getText();
					//	System.out.println("getADV "+getADV);
						java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
						sum1.add(new java.math.BigDecimal(getADV));
				//		System.out.println("sum1 "+sum1);
						String getadv=(""+(new java.math.BigDecimal(getADV).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
				//		System.out.println("getadv "+getadv);
						
						String qry2="Update staff_AdvancePaymentDetails set s_AdvanceAmt=s_AdvanceAmt+"+Double.valueOf(getadv)+" where s_Code="+getrwValue+"";
				//		System.out.println("qry2 "+qry2);
						
						boolean successful=inf.executeUpdateQuery(qry2);
				//		System.out.println("successful "+successful);
						
					}
					else
					{
					//	System.out.println("First entry.....");
						String getADV=lb_Pay.getText();
					//	System.out.println("getADV "+getADV);
						java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
						sum1.add(new java.math.BigDecimal(getADV));
					//	sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
						String getadv=(""+(new java.math.BigDecimal(getADV).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
				//		System.out.println("getadv "+getadv);
						
						String qry2="insert into staff_AdvancePaymentDetails values("+getrwValue+","+Double.valueOf(getadv)+")";
				//		System.out.println("qry2 "+qry2);
						
						boolean successful=inf.executeUpdateQuery(qry2);
				//		System.out.println("successful "+successful);	
					}
				
				}
				catch(Exception ex)
				{
					System.out.println("ERROR..."+ex);
					JOptionPane.showMessageDialog(null,"Please Input value if you want to advance");
				}
						
				}
				
				
			}
			}
		private void staffMonthlyPaymentFun()
		{
		
			if(lb_Pay.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Blank Box Can't Be Saved Pres Enter To Calculate Salary","Message",JOptionPane.ERROR_MESSAGE);
				tf_Pay.requestFocus();
			}
			else
			{
			
				int variable=JOptionPane.showConfirmDialog(this,"Do You Want To Save This Record","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
				if(variable==JOptionPane.YES_OPTION)
				{	
					try
					{
					///	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
						String getdt=lb_Date.getText();
						String resetdate[]=getdt.split("/");
						String setDATE=resetdate[1]+"/"+resetdate[0]+"/"+resetdate[2];
					//	System.out.println("setDATE "+setDATE);
					
						java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
						String getSALARY=lb_Pay.getText();
				//	double convrt=Double.valueOf(getSALARY);
						sum1.add(new java.math.BigDecimal(getSALARY));
						String getSAL=(""+(new java.math.BigDecimal(getSALARY).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
						double totsalary=Double.valueOf(getSAL);
						
						Mon=""+cb_Month.getSelectedIndex();
				//	System.out.println("Mon "+Mon);
						int MONTH=1+(Integer.parseInt(Mon));
						Yer=""+cb_Year.getSelectedItem();
						int YER1=Integer.parseInt(Yer);
					
						String qry="Select MAX(sno) from staff_SalaryDetails";
						int getsno=inf.getMaxValue(qry);
						int setmaxsno=(++getsno);
					//	System.out.println("setmaxno "+setmaxsno);
						String qry1="insert into staff_SalaryDetails values("+setmaxsno+",#"+setDATE+"#,"+(""+table.getValueAt(getCOUNT,1))+",'"+(""+table.getValueAt(getCOUNT,2))+"',"+totsalary+",'"+"SALARY"+"',"+MONTH+","+YER1+")";
					//	System.out.println("qry1 "+qry1);
						boolean successful=inf.executeUpdateQuery(qry1);
					//	System.out.println("successful "+successful);
						
						
						String getAdvance=tf_PayAdv.getText();
						sum1.add(new java.math.BigDecimal(getAdvance));
						String getADVS=(""+(new java.math.BigDecimal(getAdvance).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					
						
						int getrw=table.getSelectedRow();
						String gettotalad=""+table.getValueAt(getrw,6);
						sum1.add(new java.math.BigDecimal(gettotalad));
						String getTOTALADVS=(""+(new java.math.BigDecimal(gettotalad).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					 	
					 	if(!getTOTALADVS.equals("0.00"))
					 	{
					 		double showdiff=Double.valueOf(getTOTALADVS)-Double.valueOf(getADVS);
					 	//	System.out.println("showdiff "+showdiff);
					 	
					 		String qry2="Update staff_AdvancePaymentDetails set s_AdvanceAmt="+showdiff+" where s_Code="+(""+table.getValueAt(getrw,1))+"";
					 	//	System.out.println("qry2 "+qry2);
					 		boolean successful1=inf.executeUpdateQuery(qry2);
					 	//	System.out.println("successful1 "+successful1);
					 		
					 	}
					 
										
						tf_Pay.setText("");
						tf_PayAdv.setText("");
						lb_Pay.setText("");
						dtm.setRowCount(0);
						getInitialInfo();
						
					}
					catch(Exception ex)
					{
						System.out.println("ERROR..."+ex);
					}
				}
			}
			
		}
			
	
		
	
}
		