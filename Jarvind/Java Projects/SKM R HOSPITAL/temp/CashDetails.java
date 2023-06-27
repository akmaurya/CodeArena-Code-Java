import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class CashDetails implements ActionListener,KeyListener
{	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JTextField jtex1,jtex2;
	JTable jt;
	JCheckBox cb;
	JComboBox cmb1,cmb2;
	JButton show,close,date1,date2;
	DefaultTableModel dtm;
	TableColumn column;
	JInternalFrame jtf;
	ZedInterface inf;
	int d=0,m=0,y=0,sno,count=0;
	double amount=0.0,total=0.0;
	String arr1[],date,month,year,hdate,drcode[],name,charge;
	boolean flag=true;	
	public CashDetails(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("Source Of Payment:",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		jl1=new JLabel("Enter Date Range:");
		jl2=new JLabel("From");
		jl3=new JLabel("To");
		jl4=new JLabel("Select Releted Doctor:");
		jl5=new JLabel("Select Releted With:");
		jl6=new JLabel("Total Collection:");
		jl7=new JLabel("",JLabel.RIGHT);
		jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl2.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl3.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl4.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl5.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl6.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		
		jtex1=new JTextField();
		jtex2=new JTextField();
		
		jtex1.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		jtex2.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		
		cb=new JCheckBox();
		cmb1=new JComboBox();
		cmb2=new JComboBox();
		cmb1.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		cmb2.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		String head[]={"S.No.","Date","Patient ID","Name","Related With","Money"};
		dtm=new DefaultTableModel(head,0);
		jt=new JTable(dtm);
		jt.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,14));
		jt.setEnabled(false);
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
		
		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
		
		column=jt.getColumn("Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(110);
		
		column=jt.getColumn("S.No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(50);
		
		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(160);
	
		column=jt.getColumn("Related With");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(130);

		column=jt.getColumn("Patient ID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(90);
		
		column=jt.getColumn("Money");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(130);
		

              	JScrollPane jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		show=new JButton("SHOW",new ImageIcon("icons\\save1.gif"));
		date1=new JButton(new ImageIcon("icons\\calendar.gif"));
		date2=new JButton(new ImageIcon("icons\\calendar.gif"));
		close=new JButton("CLOSE",new ImageIcon("icons\\exit.gif"));
		
		jl1.setBounds(15,40,150,25);
		cn.add(jl1);
		cb.setBounds(150,42,20,20);
		cn.add(cb);
		jtex1.setBounds(175,40,85,25);
		cn.add(jtex1);
		jl2.setBounds(200,20,60,25);
		cn.add(jl2);
		jl3.setBounds(320,20,30,25);
		cn.add(jl3);
		date1.setBounds(267,41,21,23);
		cn.add(date1);
		jtex2.setBounds(295,40,85,25);
		cn.add(jtex2);
		date2.setBounds(387,41,21,23);
		cn.add(date2);

		jl4.setBounds(415,40,160,25);
		cn.add(jl4);
		cmb1.setBounds(575,40,130,25);
		cn.add(cmb1);
		
		jl5.setBounds(15,80,160,25);
		cn.add(jl5);
		cmb2.setBounds(170,80,170,25);
		cn.add(cmb2);
		
		show.setBounds(360,78,160,30);
		show.setToolTipText("Show");
		cn.add(show);		
		
		close.setBounds(543,78,160,30);
		close.setToolTipText("Close");
		cn.add(close);
		
		jsp.setBounds(15,125,690,270);
		cn.add(jsp);
		
		jl6.setBounds(410,410,130,25);
		cn.add(jl6);

		jl7.setBounds(540,410,161,25);
		jl7.setBackground(new Color(255,255,220));
		jl7.setOpaque(true);
		cn.add(jl7);

		jtex1.setEditable(false);
		jtex2.setEditable(false);
		Date dt=new Date();
		d=dt.getDate();
		m=1+dt.getMonth();
		y=1900+dt.getYear();
		date=d+"/"+m+"/"+y;
		jtex2.setText(date);
		jtex1.setText(date);
		jtex1.setEnabled(false);
		date1.setEnabled(false);
		//date2.setEnabled(false);
		date1.setToolTipText("Select visit Date1");
		date2.setToolTipText("Select visit Date2");
		show.addActionListener(this);
		date1.addActionListener(this);
		date2.addActionListener(this);
		close.addActionListener(this);
		cb.addActionListener(this);
		cmb1.addActionListener(this);
		show.addKeyListener(this);
		date1.addKeyListener(this);
		date2.addKeyListener(this);
		close.addKeyListener(this);
		jtex1.addKeyListener(this);
		jtex2.addKeyListener(this);
		jtf.setBackground(new Color(60,220,220));
		jtf.reshape(150,100,730,480);
		
		jl7.setText("0.00");
		try
		{	
		//	inf=(inferface)Naming.lookup(getIPaddress.IP());
		
		
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
		
		
		
		
		
		
		
		
		
		
			count=0;
			count=inf.getCountValue("select count(drCode) from drDetail");
			drcode=new String[count];
			drcode=inf.getResultSetAs_1D_Array("select drName from drDetail");
			cmb1.addItem("All");
			for(int i=0;i<drcode.length;i++)
				cmb1.addItem(drcode[i]);
			cmb2.addItem("Through OPD");
			cmb2.addItem("Through Bed Charges");
			cmb2.addItem("YAG Laser Charges");
			cmb2.addItem("Through Surgery");
			cmb2.addItem("Through Receiving");
			cmb2.addItem("Through Spects");
			cmb2.addItem("Extra Charges");
		}
	    	catch(Exception e)
		{
			System.out.println("Error" +e);
		}
		desk.add(jtf);
		jtf.setVisible(true);
	}
	public void keyPressed(KeyEvent ke)
	{	
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==close)
		{
			jtf.dispose();
		}
		if(ae.getSource()==show)
		{
			showButton();
		}
		if(ae.getSource()==date1)
		{
			Cal calender=new Cal();
 			jtex1.setText(calender.getdate());
		}
		if(ae.getSource()==date2)
		{
			Cal calender=new Cal();
 			jtex2.setText(calender.getdate());
		}
		if(ae.getSource()==cb)
		{
			if(cb.isSelected()==true)
			{
				date1.setEnabled(true);
				jtex1.setEnabled(true);
			}
			else
			{
				date1.setEnabled(false);
				jtex1.setEnabled(false);
			}
		}
	}
	
	private void showButton()
	{
		try
		{	
			dtm.setRowCount(0);
			jl7.setText("0.00");
			String hdate1=jtex1.getText();
			String hdate2=jtex2.getText();
			String str[]=new String[3];
			String id[]={""};
			arr1=new String[8];
			if(cb.isSelected()==false)
			{
				String str1[]=inf.getResultSetAs_1D_Array("select history_date from history_Patient order by history_date");
				hdate1=str1[0];
				str=hdate1.split("-");
				year=str[0];
				month=str[1];
				date=str[2];
				str=date.split("00:00:00");
				date=str[0];
				hdate1=date+"/"+month+"/"+year;
			}
			str=hdate1.split("/");
			date=str[0];
			month=str[1];
			year=str[2];
			hdate1=month+"/"+date+"/"+year;
			str=hdate2.split("/");
			date=str[0];
			month=str[1];
			year=str[2];
			hdate2=month+"/"+date+"/"+year;
				
			sno=0;
			dtm.setRowCount(0);
			String pid[]=inf.getResultSetAs_1D_Array("select distinct patient_id from history_Patient where history_date>=#"+hdate1+"# and history_date<=#"+hdate2+"#");
			if(pid!=null && pid.length!=0)
			{
			name=(String)cmb1.getSelectedItem();
			total=0.0;
			if(name.equals("All"))
			{
				for(int l=0;l<pid.length;l++)
				{
					if(pid[l]!=null)
					{
						String depart=(String)cmb2.getSelectedItem();
						if(depart.equals("Through OPD"))
						{
							charge=inf.getSingleValue("select cons_fee from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l])+"");
							amount=0.0;
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
								System.out.println("amount "+amount);
						}
						if(depart.equals("Through Surgery"))
						{
							id=inf.getResultSetAs_1D_Array("select distinct Patient_id from eye_Surgery_Detail where status=true");
							charge=inf.getSingleValue("select amount from eye_Surgery_Detail where Patient_id="+Integer.parseInt(pid[l])+" and status=true");
							amount=0.0;
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
						}
						if(depart.equals("Through Receiving"))
						{	
							id=inf.getResultSetAs_1D_Array("select distinct patientID from receive_Patient_Charges where status=true");
							charge=inf.getSingleValue("select amt from receive_Patient_Charges where patientID="+Integer.parseInt(pid[l])+" and status=true");
							amount=0.0;
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
						}
						if(depart.equals("Through Bed Charges"))
						{	
							id=inf.getResultSetAs_1D_Array("select distinct id from admit_Patient_info where status=true");
							charge=inf.getSingleValue("select rate from admit_Patient_info where id="+Integer.parseInt(pid[l])+" and status=true");
							amount=0.0;
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
		
						}
						if(depart.equals("YAG Laser Charges"))
						{
							charge=inf.getSingleValue("select YAG_charge from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l])+"");
							amount=0.0;
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
						}
						if(depart.equals("Extra Charges"))
						{
							charge=inf.getSingleValue("select extra_charge from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l])+"");
							amount=0.0;
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
							charge=inf.getSingleValue("select additional_charge from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l])+"");
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
						}
						if(depart.equals("Through Spects"))
						{
							id=inf.getResultSetAs_1D_Array("select distinct pID from patient_SpectsProvidation where date>=#"+hdate1+"# and date<=#"+hdate2+"#");
							amount=0.0;
							for(int k=0;k<id.length;k++)
							{
								amount=0.0;
								charge=inf.getSingleValue("select amt from patient_SpectsProvidation where pID="+Integer.parseInt(id[k])+" and status=true");
								if(charge!=null)
								{
									amount=amount+Double.valueOf(charge);
									hdate=inf.getSingleValue("select date from patient_SpectsProvidation where pID="+Integer.parseInt(id[k])+" and date>=#"+hdate1+"# and date<=#"+hdate2+"#");
									str=hdate.split("-");
									year=str[0];
									month=str[1];
									date=str[2];
									str=date.split("00:00:00");
									date=str[0];
									name=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(id[k]));
									String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(id[k]));
									drcatname=inf.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname));
									System.out.println("drcatname "+drcatname);
									if(name!=null)
									{
										arr1[0]=""+(++sno);						
										arr1[1]=date+"-"+month+"-"+year;
										arr1[2]=id[k];
										arr1[3]=name;
										arr1[4]=drcatname;
										arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
										System.out.println("here is the problem");
										dtm.addRow(arr1);
										total=total+amount;
										jl7.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
									}		
								}
							}
							flag=false;
						}
						if(flag==false)
						{
							flag=true;
							break;
						}
						if(flag)
						{
							hdate=inf.getSingleValue("select history_date from history_Patient where patient_id="+Integer.parseInt(pid[l])+"and history_date>=#"+hdate1+"# and history_date<=#"+hdate2+"#");
							str=hdate.split("-");
							year=str[0];
							month=str[1];
							date=str[2];
							str=date.split("00:00:00");
							date=str[0];
							name=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
							String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
							drcatname=inf.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
							System.out.println("drcatname "+drcatname);
							for(int m=0;m<id.length;m++)
							{
								if(name!=null && Integer.parseInt(pid[l])==Integer.parseInt(id[m]))
								{
									arr1[0]=""+(++sno);						
									arr1[1]=date+"-"+month+"-"+year;
									arr1[2]=pid[l];
									arr1[3]=name;
									arr1[4]=drcatname;
									arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
									dtm.addRow(arr1);
									total=total+amount;
									jl7.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
								}
							}
						}	
					}
				}
			}
			else
			{
				name=(String)cmb1.getSelectedItem();
				String code=inf.getSingleValue("select drCode from drDetail where drName='"+name+"'");
				/*System.out.println("name="+name);
				System.out.println("code="+code);*/
				String ppid[]=inf.getResultSetAs_1D_Array("select patientid from patient_Profile where drCode="+Integer.parseInt(code));
				total=0.0;
				for(int l=0;l<pid.length;l++)
				{	
					for(int m=0;m<ppid.length;m++)
					{
						if(Integer.parseInt(pid[l])==Integer.parseInt(ppid[m]))
						{
							String depart=(String)cmb2.getSelectedItem();
							if(depart.equals("Through OPD"))
							{
								charge=inf.getSingleValue("select cons_fee from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l])+"");
								amount=0.0;
								if(charge!=null)
									amount=amount+Double.valueOf(charge);
							}
							if(depart.equals("Through Surgery"))
							{
								id=inf.getResultSetAs_1D_Array("select distinct Patient_id from eye_Surgery_Detail where status=true");
								charge=inf.getSingleValue("select amount from eye_Surgery_Detail where Patient_id="+Integer.parseInt(pid[l])+" and status=true");
								amount=0.0;
								if(charge!=null)
									amount=amount+Double.valueOf(charge);
							}
							if(depart.equals("Through Receiving"))
							{	
								id=inf.getResultSetAs_1D_Array("select distinct patientID from receive_Patient_Charges where status=true");
								charge=inf.getSingleValue("select amt from receive_Patient_Charges where patientID="+Integer.parseInt(pid[l])+" and status=true");
								amount=0.0;
								if(charge!=null)
									amount=amount+Double.valueOf(charge);
							}
							if(depart.equals("Through Bed Charges"))
							{	
								id=inf.getResultSetAs_1D_Array("select distinct id from admit_Patient_info where status=true");
								charge=inf.getSingleValue("select rate from admit_Patient_info where id="+Integer.parseInt(pid[l])+" and status=true");
								amount=0.0;
								if(charge!=null)
									amount=amount+Double.valueOf(charge);
		
							}
							if(depart.equals("YAG Laser Charges"))
							{
								charge=inf.getSingleValue("select YAG_charge from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l])+"");
								amount=0.0;
								if(charge!=null)
									amount=amount+Double.valueOf(charge);
							}
							if(depart.equals("Extra Charges"))
							{
								charge=inf.getSingleValue("select extra_charge from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l])+"");
								amount=0.0;
								if(charge!=null)
									amount=amount+Double.valueOf(charge);
								charge=inf.getSingleValue("select additional_charge from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l])+"");
								if(charge!=null)
									amount=amount+Double.valueOf(charge);
							}
							if(depart.equals("Through Spects"))
							{
								id=inf.getResultSetAs_1D_Array("select distinct pID from patient_SpectsProvidation where date>=#"+hdate1+"# and date<=#"+hdate2+"#");
								amount=0.0;
								for(int k=0;k<id.length;k++)
								{
									for(int c=0;c<ppid.length;c++)
									{
										if(id!=null &&  id[k]!="" && Integer.parseInt(id[k])==Integer.parseInt(ppid[c]))
										{
											amount=0.0;
											charge=inf.getSingleValue("select amt from patient_SpectsProvidation where pID="+Integer.parseInt(id[k])+" and status=true");
											if(charge!=null)
											{
												amount=amount+Double.valueOf(charge);
												hdate=inf.getSingleValue("select date from patient_SpectsProvidation where pID="+Integer.parseInt(id[k]));
												str=hdate.split("-");
												year=str[0];
												month=str[1];
												date=str[2];
												str=date.split("00:00:00");
												date=str[0];
												name=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(id[k]));
												String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(id[k]));
												drcatname=inf.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname));
												if(name!=null)
												{
													arr1[0]=""+(++sno);						
													arr1[1]=date+"-"+month+"-"+year;
													arr1[2]=id[k];
													arr1[3]=name;
													arr1[4]=drcatname;
													arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
													dtm.addRow(arr1);
													total=total+amount;
													jl7.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
												}		
											}
										}
									}
								}
								flag=false;
							}
							if(flag==false)
							{
								break;
							}
							if(flag)
							{
								hdate=inf.getSingleValue("select history_date from history_Patient where patient_id="+Integer.parseInt(pid[l])+"and history_date>=#"+hdate1+"# and history_date<=#"+hdate2+"#");
								str=hdate.split("-");
								year=str[0];
								month=str[1];
								date=str[2];
								str=date.split("00:00:00");
								date=str[0];
								name=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
								String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
								drcatname=inf.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
								for(int r=0;r<id.length;r++)
								{
									if(name!=null && id!=null && id[r]!="" && Integer.parseInt(ppid[m])==Integer.parseInt(id[r]))
									{
										arr1[0]=""+(++sno);						
										arr1[1]=date+"-"+month+"-"+year;
										arr1[2]=pid[l];
										arr1[3]=name;
										arr1[4]=drcatname;
										arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
										dtm.addRow(arr1);
										total=total+amount;
										jl7.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
									}
								}
							}	
						}
					}
					if(flag==false)
					{
						flag=true;
						break;
					}
				}
			}
			}
			else
				JOptionPane.showMessageDialog(jt,"No Record Exists","Message",JOptionPane.INFORMATION_MESSAGE);	
		}
	    	catch(Exception e)
		{
			System.out.println("Error" +e);
		}
	}
}