import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class spectsStockReport implements ActionListener,KeyListener
{	
	JLabel jl1,jl2,jl3,jl5,jl6,lb1;
	JTable jt;
	JCheckBox chk,chk1,chk2;
	JComboBox cb1,cb2,cb3,cb4;
	JButton show,close,date1,date2;
	DefaultTableModel dtm;
	TableColumn column;
	JInternalFrame jtf;
	String loadarr[]=null;
	String load;
//	ZedInterface zedint;
	int d=0,m=0,y=0,sno,count=0,Flag=0;
	String arr[][],arr1[],date,month,year,hdate,bed,room,ward;
	ZedInterface inf=null;	
	public spectsStockReport(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("Spects Report",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		
		Font f1=new Font("Microsoft Sans Serif",Font.BOLD,13);
	/*	jl1=new JLabel("Enter Date Range");
		jl2=new JLabel("From");
		jl3=new JLabel("To");
		
		jl5=new JLabel("",JLabel.CENTER);
		jl6=new JLabel("",JLabel.CENTER);
		
		jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl2.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl3.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		
		jl5.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl6.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));*/
	
		chk=new JCheckBox("Group");
		chk.setOpaque(false);
		chk.setBounds(15,15,150,20);
		chk.setFont(f1);
		cn.add(chk);
		cb1=new JComboBox();
		cb1.setBounds(15,40,150,30);//10
		cn.add(cb1);
		cb1.setEnabled(false);
		
		chk1=new JCheckBox("Category");
		chk1.setOpaque(false);
		chk1.setBounds(190,15,160,20);//140
		cn.add(chk1);
		cb2=new JComboBox();
		cb2.setBounds(190,40,160,30);
		cn.add(cb2);
		cb2.setEnabled(false);
		
		lb1=new JLabel("Item Name");
		lb1.setOpaque(false);
		//1b.setBounds(270,15,100,20);
		lb1.setBounds(540,15,150,20);//400
		lb1.setFont(f1);
		cn.add(lb1);
		cb3=new JComboBox();
		cb3.setBounds(540,40,165,30);
		cn.add(cb3);
		
		
		chk2=new JCheckBox("Company");
		chk2.setOpaque(false);
		//chk2.setBounds(400,15,100,20);
		chk2.setBounds(370,15,150,20);//270
		cn.add(chk2);
		cb4=new JComboBox();
		cb4.setBounds(370,40,150,30);
		cn.add(cb4);
		cb4.setEnabled(false);
		
		String head[]={"S.No.","Group Name","Category","Company","Item Name","Quantity"};
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
		
		column=jt.getColumn("S.No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(40);
		
		column=jt.getColumn("Group Name");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(120);
		
		column=jt.getColumn("Category");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(120);

		column=jt.getColumn("Company");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);
		
		column=jt.getColumn("Item Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);

		column=jt.getColumn("Quantity");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);
		
		/*column=jt.getColumn("Room No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(60);

		column=jt.getColumn("Bed No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(60);*/

              	JScrollPane jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		show=new JButton("SHOW",new ImageIcon("icons\\save1.gif"));
	/*	date1=new JButton(new ImageIcon("icons\\calendar.gif"));
		date2=new JButton(new ImageIcon("icons\\calendar.gif"));*/
		close=new JButton("CLOSE",new ImageIcon("icons\\exit.gif"));
		
	/*	jl1.setBounds(15,40,150,25);
		cn.add(jl1);
		cb.setBounds(150,42,20,20);
		cn.add(cb);
		jl5.setBounds(175,40,85,25);
		jl5.setBackground(new Color(255,255,220));
		jl5.setOpaque(true);
		cn.add(jl5);
		jl2.setBounds(200,20,60,25);
		cn.add(jl2);
		jl3.setBounds(320,20,30,25);
		cn.add(jl3);
		date1.setBounds(267,41,21,23);
		cn.add(date1);
		jl6.setBounds(295,40,85,25);
		jl6.setBackground(new Color(255,255,220));
		jl6.setOpaque(true);
		cn.add(jl6);
		date2.setBounds(387,41,21,23);
		cn.add(date2);*/

	/*	show.setBounds(15,70,325,30);
		show.setToolTipText("Show");
		cn.add(show);
		close.setBounds(365,70,325,30);
		close.setToolTipText("Close");
		cn.add(close);*/
		
		
		
		
		jsp.setBounds(15,90,690,270);//80
		cn.add(jsp);

		Date dt=new Date();
		d=dt.getDate();
		m=1+dt.getMonth();
		y=1900+dt.getYear();
		date=d+"/"+m+"/"+y;
	/*	jl5.setText(date);
		jl6.setText(date);
		date1.setEnabled(false);
		jl5.setEnabled(false);
		date1.setToolTipText("Select visit AdmitDate1");
		date2.setToolTipText("Select visit AdmitDate2");*/
	
	
		close.setBounds(190,370,350,30);
		close.setToolTipText("Close");
		cn.add(close);
	
	
	
		/*show.addActionListener(this);
		date1.addActionListener(this);
		date2.addActionListener(this);
		
		cb.addActionListener(this);
		
		show.addKeyListener(this);
		
	date1.addKeyListener(this);
		date2.addKeyListener(this);
		close.addKeyListener(this);*/
		
		chk.addActionListener(this);
		chk1.addActionListener(this);
		chk2.addActionListener(this);
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		cb3.addActionListener(this);
		cb4.addActionListener(this);
		close.addActionListener(this);
		
		
		jtf.setBackground(new Color(60,220,220));
		jtf.reshape(150,100,730,440);///400
		
	
		
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
		desk.add(jtf);
		jtf.setVisible(true);
		setInitialInfo();
	}
	public void keyPressed(KeyEvent ke)
	{
	
		if(ke.getSource()==date1 && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			date2.requestFocus();
		}
		if(ke.getSource()==date2 && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			show.requestFocus();
		}
		if(ke.getSource()==show && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
//			 showButton();
		}
		if(ke.getSource()==close && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			jtf.dispose();
		}	
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	public void actionPerformed(ActionEvent ae)
	{
	/*	if(ae.getSource()==date1)
		{
			Cal calender=new Cal();
 	//		jl5.setText(calender.getdate());
		}
		if(ae.getSource()==date2)
		{
			Cal calender=new Cal();
 	//		jl6.setText(calender.getdate());
		}
		if(ae.getSource()==cb)
		{
			if(cb.isSelected()==true)
			{
				date1.setEnabled(true);
	///			jl5.setEnabled(true);
			}
			else
			{
				date1.setEnabled(false);
		//		jl5.setEnabled(false);
			}
		}
	
		if(ae.getSource()==show)
		{
			showButton();
		}	*/
		
		if(ae.getSource()==close)
		{
			jtf.dispose();
		}
		if(ae.getSource()==chk)
		{
			if(chk.isSelected()==true)
			{
				cb1.setEnabled(true);
				cb2.setEnabled(false);
				cb3.setEnabled(false);
				cb4.setEnabled(false);
				chk1.setSelected(false);
				chk2.setSelected(false);
//				chk3.setSelected(false);
			}
			else
			{
				cb1.setEnabled(false);
			}
			
		}
		if(ae.getSource()==chk1)
		{
			if(chk1.isSelected()==true)
			{
				cb2.setEnabled(true);
				cb4.setEnabled(false);
				cb3.setEnabled(false);
				chk2.setSelected(false);
				chk.setSelected(false);
				
			}
			else
			{
				cb2.setEnabled(false);
			}
		
		}
		if(ae.getSource()==chk2)
		{
			if(chk2.isSelected()==true)
			{
				cb4.setEnabled(true);
				cb3.setEnabled(false);
				cb2.setEnabled(false);
				cb1.setEnabled(false);
				chk1.setSelected(false);
				chk.setSelected(false);
			}
			else
			{
				cb4.setEnabled(false);
			}
			
		}
		if(ae.getSource()==cb3)
		{
				setDefaultInfo();
		
		}
		if(ae.getSource()==cb4)
		{
			String cmpnm=""+cb4.getSelectedItem();
			System.out.println("cmpm...."+cmpnm);
			if(!cmpnm.equals("SELECT"))
				comanyWiseInfo(cmpnm);
/*			else
				JOptionPane.showMessageDialog(this,"Please Select the company name","Message",JOptionPane.ERROR_MESSAGE);*/
		}
		if(ae.getSource()==cb2)
		{
			String catnm=""+cb2.getSelectedItem();
			System.out.println("catnm  "+catnm);
			if(!catnm.equals("SELCT"))
				categoryWiseInfo(catnm);
		}
		if(ae.getSource()==cb1)
		{
			String grpnm=""+cb1.getSelectedItem();
			System.out.println("grpnm  "+grpnm);
			
			if(!grpnm.equals("SELECT"))
				groupWiseInfo(grpnm);
		}
		
		
		
	}
/*	private void showButton()
	{
		try
		{	
			dtm.setRowCount(0);
			String hdate1=jl5.getText();
			String hdate2=jl6.getText();
			String str[]=new String[3];
			arr1=new String[8];
			if(cb.isSelected()==false)
			{	
				///////For Getting Oldest Date///////
				String str1[]=inf.getResultSetAs_1D_Array("select bookingdt from admit_Patient_Info order by bookingdt ");
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
			String pid[]=inf.getResultSetAs_1D_Array("select id from admit_Patient_Info where bookingdt>=#"+hdate1+"# and bookingdt<=#"+hdate2+"# and status=true order by bookingdt");
			if(pid!=null && pid.length!=0)
			{
			for(int l=0;l<pid.length;l++)
			{
				if(pid[l]!=null)
				{
					String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
					String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
					drcatname=inf.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
					arr=inf.getResultSetAs_2D_Array("select bedNo,bookingdt from admit_Patient_Info where id="+Integer.parseInt(pid[l])+"",2);
					if(arr!=null)
					{
						bed=arr[0][0];
						room=inf.getSingleValue("select roomNo from bedDetails where bedNo="+Integer.parseInt(bed));
						ward=inf.getSingleValue("select wardCatCode from roomDetails where roomNo="+Integer.parseInt(room));
						ward=inf.getSingleValue("select wardCatName from wardCategory where wardCatCode="+Integer.parseInt(ward));		

						hdate=arr[0][1];
						str=hdate.split("-");
						year=str[0];
						month=str[1];
						date=str[2];
						str=date.split("00:00:00");
						date=str[0];
							
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						arr1[2]=pid[l];
						arr1[3]=pname;
						arr1[4]=drcatname;	
						arr1[5]=ward;
						arr1[6]=room;
						arr1[7]=bed;
						dtm.addRow(arr1);
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
	}*/	
	private void setInitialInfo()				
	{
		try
		{
			
					
						ZedInterface inf=null;
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
										System.out.println("Error at the time of connection with server ip-rmi://127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}				
							
							cb1.addItem("SELECT");
							String qry="Select gpNm from spectsGroupMaster";
							String arr[]=inf.getResultSetAs_1D_Array(qry);
							if(arr!=null)
								for(int i=0;i<arr.length;i++)
								{
									cb1.addItem(arr[i]);
								}
							cb2.addItem("SELECT");
							qry="Select catNm from spectsCatMaster";
							arr=inf.getResultSetAs_1D_Array(qry);
							if(arr!=null)
								for(int i=0;i<arr.length;i++)
								{
									cb2.addItem(arr[i]);
								}
							cb3.addItem("All");
							qry="Select itmNm from spectsItemMaster";
							arr=inf.getResultSetAs_1D_Array(qry);
							if(arr!=null)
								for(int i=0;i<arr.length;i++)
								{
									cb3.addItem(arr[i]);
								}
							
							cb4.addItem("SELECT");
							qry="Select cmpName from spectsCmpMaster";
							arr=inf.getResultSetAs_1D_Array(qry);
							if(arr!=null)
								for(int i=0;i<arr.length;i++)
								{
									cb4.addItem(arr[i]);
								}
							
							
							
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Error.... IN setInitialInfo Method");
		}
	}
	private void setDefaultInfo()
	{
			String getStr=""+cb3.getSelectedItem();
			System.out.println("getStr......."+getStr);
			
			
			loadarr=new String[6];
			sno=0;
			dtm.setRowCount(0);
			String itemname,catname,gpname,cmpname,qry;
			int quantity=0;
			String arr[][]=null;
			
			
			
			
		try
		{
			ZedInterface inf=null;
			try
			{
				inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			}
			catch(Exception e)
			{
				System.out.println("Error at the time of connection with server"+getIPaddress.IP()+"    "+e);
				getIPaddress.changeIP();
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connection ip-rmi://127.0.0.1/ExtendedZedServer....."+ex);
				}
			}
			
			
			if(getStr.equals("All"))
			{
				
				qry="Select itmCode,cmpCode,qty from spectsStockHolding order by cmpCode";
			arr=inf.getResultSetAs_2D_Array(qry,3);
			if(arr!=null && arr.length>0)
			{
				for(int i=0;i<arr.length;i++)
				{
					
					System.out.println(i+"   "+arr[i][0]);
					System.out.println(i+"   "+arr[i][1]);
					System.out.println(i+"   "+arr[i][2]);
					quantity=Integer.parseInt(arr[i][2]);
					String qry1="Select itmNm from spectsItemMaster where itmCode="+Integer.parseInt(arr[i][0])+"";
					itemname=inf.getSingleValue(qry1);
					System.out.println("Itemname    "+itemname);
					//////cat code/////
					qry1="Select catCode from spectsItemMaster where itmCode="+Integer.parseInt(arr[i][0])+"";
					String catcd=inf.getSingleValue(qry1);
					System.out.println("catcd  "+catcd);
					////////catname///
					qry1="Select catNm from spectsCatMaster where catCode="+Integer.parseInt(catcd)+"";
					catname=inf.getSingleValue(qry1);
					System.out.println("catname   "+catname);
					
					qry1="Select gpCode from spectsCatMaster where catCode="+Integer.parseInt(catcd)+"";
					String gpcd=inf.getSingleValue(qry1);
					System.out.println("gpcd  "+gpcd);
					
					qry1="Select gpNm from spectsGroupMaster where gpCode="+Integer.parseInt(gpcd)+"";
					gpname=inf.getSingleValue(qry1);
					System.out.println("gpname  "+gpname);
					
					
					qry1="Select cmpName from spectsCmpMaster where cmpCode="+Integer.parseInt(arr[i][1])+"";
					cmpname=inf.getSingleValue(qry1);
					System.out.println("cmpname   "+cmpname);
					
					
					loadarr[0]=""+(++sno);
					loadarr[1]=gpname;
					loadarr[2]=catname;
					loadarr[3]=cmpname;
					loadarr[4]=itemname;
					loadarr[5]=""+quantity;
					
					dtm.addRow(loadarr);
				}
				
				
				
			}
			
							
			}
			else
			{
				int i=0;
				dtm.setRowCount(0);
				getStr=""+cb3.getSelectedItem();
				
				
							
				qry="Select itmCode from spectsItemMaster where itmNm='"+getStr+"'";
				String arrNt[]=inf.getResultSetAs_1D_Array(qry);
				if(arrNt!=null && arrNt.length>0)
				{
					
					
					for(i=0;i<arrNt.length;i++)
					{
					
						System.out.println(i+"  "+arrNt[i]);
						qry="Select qty from spectsStockHolding where itmCode="+Integer.parseInt(arrNt[i])+"";
						System.out.println("qry........."+qry);
						//arr1=inf.getResultSetAs_1D_Array(qry);
						String qty1=inf.getSingleValue(qry);
						
						System.out.println("qty1    "+qty1);
						
						if(qty1!=null)
						{
								qry="Select itmCode from spectsStockHolding where itmCode="+Integer.parseInt(arrNt[i])+"";
						String itcd=inf.getSingleValue(qry);
						System.out.println("Itemcode   "+itcd);
						
						
						if(itcd!=null)
						{
							qry="Select cmpCode from spectsStockHolding where itmCode="+Integer.parseInt(itcd)+"";
						String cmpcd=inf.getSingleValue(qry);
						System.out.println("cmpcd    "+cmpcd);
						
						qry="Select cmpName from spectsCmpMaster where cmpCode="+Integer.parseInt(cmpcd)+"";
						cmpname=inf.getSingleValue(qry);
						System.out.println("cmpname   "+cmpname);
						
												
						qry="Select catCode from spectsItemMaster where itmCode="+Integer.parseInt(itcd)+"";
						String catcd=inf.getSingleValue(qry);
						System.out.println("catcd  "+catcd);	
						
						qry="Select catNm from spectsCatMaster where catCode="+Integer.parseInt(catcd)+"";
						catname=inf.getSingleValue(qry);
						System.out.println("catname   "+catname);	
					
					
						qry="Select gpCode from spectsCatMaster where catCode="+Integer.parseInt(catcd)+"";
						String gpcd=inf.getSingleValue(qry);
						System.out.println("gpcd  "+gpcd);
						
						qry="Select gpNm from spectsGroupMaster where gpCode="+Integer.parseInt(gpcd)+"";
						gpname=inf.getSingleValue(qry);
						System.out.println("gpname  "+gpname);	
						
						
						itemname=getStr;
						
					
						loadarr[0]=""+(++sno);
						loadarr[1]=gpname;
						loadarr[2]=catname;
						loadarr[3]=cmpname;
						loadarr[4]=itemname;
						loadarr[5]=qty1;
					
						dtm.addRow(loadarr);
						}
						
						}
																		
					}
							
				}
							
			}
					
		}
		catch(Exception e)
		{
			System.out.println("Error .....in setDefaultInfo Method");
		}
	}
	private void comanyWiseInfo(String cmp)
	{
		int i=0;
		sno=0;
		dtm.setRowCount(0);
		String cmpnm=cmp;
		String getStr=""+cb3.getSelectedItem();
		loadarr=new String[6];
		String itemname,catname,gpname,cmpname,qry;
		
		try
		{
			ZedInterface inf=null;
			try
			{
				inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			}
			catch(Exception ex)
			{
				System.out.println("Error at the time of connection with server"+getIPaddress.IP()+ex);
				getIPaddress.changeIP();
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
					
				}
				catch(Exception e)
				{
					System.out.println("Error at the time of connection with ip-rmi://127.0.0.1/ExtendedZedServer......."+e);
				}
				
			}
			
			qry="Select cmpCode from spectsCmpMaster where cmpName='"+cmp+"'";
			load=inf.getSingleValue(qry);
			System.out.println("load cmpcode    "+load);
			
			qry="Select itmCode from spectsStockHolding where cmpCode="+Integer.parseInt(load)+" order by itmCode";
			String arrNew[]=inf.getResultSetAs_1D_Array(qry);
			if(arrNew!=null && arrNew.length>0)
			{
				for(i=0;i<arrNew.length;i++)
				{
					System.out.println(i+"   "+arrNew[i]);
					
					qry="Select qty from spectsStockHolding where itmCode="+Integer.parseInt(arrNew[i])+"";
					String quantity=inf.getSingleValue(qry);
					System.out.println("quantity  "+quantity);
										
					String qry1="Select itmNm from spectsItemMaster where itmCode="+Integer.parseInt(arrNew[i])+"";
					itemname=inf.getSingleValue(qry1);
					System.out.println("Itemname    "+itemname);
					//////cat code/////
					qry1="Select catCode from spectsItemMaster where itmCode="+Integer.parseInt(arrNew[i])+"";
					String catcd=inf.getSingleValue(qry1);
					System.out.println("catcd  "+catcd);
					////////catname///
					qry1="Select catNm from spectsCatMaster where catCode="+Integer.parseInt(catcd)+"";
					catname=inf.getSingleValue(qry1);
					System.out.println("catname   "+catname);
					
					qry1="Select gpCode from spectsCatMaster where catCode="+Integer.parseInt(catcd)+"";
					String gpcd=inf.getSingleValue(qry1);
					System.out.println("gpcd  "+gpcd);
					
					qry1="Select gpNm from spectsGroupMaster where gpCode="+Integer.parseInt(gpcd)+"";
					gpname=inf.getSingleValue(qry1);
					System.out.println("gpname  "+gpname);
					
					
					
					
					loadarr[0]=""+(++sno);
					loadarr[1]=gpname;
					loadarr[2]=catname;
					loadarr[3]=cmp;
					loadarr[4]=itemname;
					loadarr[5]=quantity;
					
					dtm.addRow(loadarr);
					
				}
			}
			
			
			
			
			
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("ERROR....in companyWiseInfo Method");
		}
		
		
		
	}
	private void categoryWiseInfo(String cat)
	{
			int i=0;
		sno=0;
		dtm.setRowCount(0);
		String catnm=cat;
	//	String getStr=""+cb2.getSelectedItem();
		loadarr=new String[6];
		String itemname,catname,gpname,cmpname,qry;
		ZedInterface inf=null;
		try
		{
			try
			{
				inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
			
			}
			catch(Exception e)
			{
				System.out.println("Error at the time of connection in with server "+getIPaddress.IP()+e);
				getIPaddress.changeIP();
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connection ip-rmi://127.0.0.1/ExtendedZedServer....."+ex);
				}
			}
			
			
			qry="Select catCode from spectsCatMaster where catNm='"+catnm+"'";
			String catcode=inf.getSingleValue(qry);
			if(catcode!=null )
			{
			/*	for(i=0;i<arrNew.length;i++)
				{*/
					System.out.println("catcode  "+catcode);
					qry="Select itmCode from spectsStockHolding";
					String loadITM[]=inf.getResultSetAs_1D_Array(qry);
					if(loadITM!=null)
					{
						for(int j=0;j<loadITM.length;j++)
						{
							System.out.println(j+" "+loadITM[j]);
							
												
							qry="Select itmNm from spectsItemMaster where itmCode="+Integer.parseInt(loadITM[j])+" and catCode="+Integer.parseInt(catcode)+"";
							itemname=inf.getSingleValue(qry);
							System.out.println("itemName  "+itemname);
							if(itemname!=null)
							{
								qry="Select cmpCode from spectsStockHolding where itmCode="+Integer.parseInt(loadITM[j])+"";
								String cmpcd=inf.getSingleValue(qry);
								System.out.println("cmpcd  "+cmpcd);
								
								qry="Select cmpName from spectsCmpMaster where cmpCode="+Integer.parseInt(cmpcd)+"";
								cmpname=inf.getSingleValue(qry);
								System.out.println("cmpnm  "+cmpname);
									
								qry="Select qty from spectsStockHolding where itmCode="+Integer.parseInt(loadITM[j])+"";
								String quantity=inf.getSingleValue(qry);
								System.out.println("quantity  "+quantity);
								
								
								qry="Select gpCode from spectsCatMaster where catCode="+Integer.parseInt(catcode)+"";
								String gpcode=inf.getSingleValue(qry);
								System.out.println("gpcde "+gpcode);
										
									
								qry="Select gpNm from spectsGroupMaster where gpCode="+Integer.parseInt(gpcode)+"";
								gpname=inf.getSingleValue(qry);
								System.out.println("gpname  "+gpname);
							
							
							
								loadarr[0]=""+(++sno);
								loadarr[1]=gpname;
								loadarr[2]=catnm;
								loadarr[3]=cmpname;
								loadarr[4]=itemname;
								loadarr[5]=quantity;
						
								dtm.addRow(loadarr);		
								
								
							}
							
							
							
							
						}
					}
					
				//}
				
			}
			
			
		}
		catch(Exception ex) 
		{
			System.out.println("ERROR...in categoryWiseInfo Method");
		}
		
	}
	private void groupWiseInfo(String grpnm)
	{
				int i=0;
		sno=0;
		dtm.setRowCount(0);
		String gpnm=grpnm;
	//	String getStr=""+cb2.getSelectedItem();
		loadarr=new String[6];
		String itemname,catname,gpname,cmpname,qry;
		ZedInterface inf=null;
		String loadCatcode[]=null;
		
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
					System.out.println("Error at the time of connection ip-rmi://127.0.0.1/ExtendedZedServer........"+ex);
				}
			}
			
			qry="Select gpCode from spectsGroupMaster where gpNm='"+gpnm+"'";
			String gpcd=inf.getSingleValue(qry);
			System.out.println("gpcd  "+gpcd);
			
			
			
			
			qry="Select itmCode from spectsStockHolding";
			String arrNext[]=inf.getResultSetAs_1D_Array(qry);
			if(arrNext!=null && arrNext.length>0)
			{
				for(i=0;i<arrNext.length;i++)
				{
					System.out.println(i+" "+arrNext[i]);
				/*	qry="Select catCode from spectsItemMaster where itmCode="+Integer.parseInt(arrNext[i])+"";
					loadCatcode=inf.getResultSetAs_1D_Array(qry);
					if(loadCatcode!=null)
					{
						for(int k=0;k<loadCatcode.length;k++)
						{
							System.out.println(k+" "+loadCatcode[k]);
						}
						
					}*/
					
					qry="Select catCode from spectsItemMaster where itmCode="+Integer.parseInt(arrNext[i])+"";
					String catcd=inf.getSingleValue(qry);
					System.out.println("catcd "+catcd);
					
					if(catcd!=null)
					{
						qry="Select catNm from spectsCatMaster where catCode="+Integer.parseInt(catcd)+" and gpCode="+Integer.parseInt(gpcd)+"";
						catname=inf.getSingleValue(qry);
						System.out.println("catname  "+catname);
						if(catname!=null)
						{
								qry="Select qty from spectsStockHolding where itmCode="+Integer.parseInt(arrNext[i])+"";
								String quantity=inf.getSingleValue(qry);
								System.out.println("quantity  "+quantity);
														
								String qry1="Select itmNm from spectsItemMaster where itmCode="+Integer.parseInt(arrNext[i])+"";
								itemname=inf.getSingleValue(qry1);
								System.out.println("Itemname    "+itemname);
					//////cat code/////
							/*	qry1="Select catCode from spectsItemMaster where itmCode="+Integer.parseInt(arrNext[i])+"";
								String catcd=inf.getSingleValue(qry1);
								System.out.println("catcd  "+catcd);
					////////catname///
								qry1="Select catNm from spectsCatMaster where catCode="+Integer.parseInt(catcd)+"";
								catname=inf.getSingleValue(qry1);
								System.out.println("catname   "+catname);*/
					
								qry="Select cmpCode from spectsStockHolding where itmCode="+Integer.parseInt(arrNext[i])+"";
								String cmpcd=inf.getSingleValue(qry);
								System.out.println("cmpcd  "+cmpcd);
							
								qry="Select cmpName from spectsCmpMaster where cmpCode="+Integer.parseInt(cmpcd)+"";
								cmpname=inf.getSingleValue(qry);
								System.out.println("cmpnm  "+cmpname);
								
								
								
									loadarr[0]=""+(++sno);
					loadarr[1]=gpnm;
					loadarr[2]=catname;
					loadarr[3]=cmpname;
					loadarr[4]=itemname;
					loadarr[5]=quantity;
					
					dtm.addRow(loadarr);
						
							
							
						}
						
						
					}
					
					
					
					
					
					
				}
			}
			
			
			
		/*	qry="Select gpCode from spectsGroupMaster where gpNm='"+gpnm+"'";
			String gpcode=inf.getSingleValue(qry);
			System.out.println("gpcode  "+gpcode);
			if(gpcode!=null)
			{
				
				for(i=0;i<loadCatcode.length;i++)
				{
					qry="Select catNm from spectsCatMaster where gpCode="+Integer.parseInt(gpcode)+" and catCode="+Integer.parseInt(loadCatcode[i])+"";
					catname=inf.getSingleValue(qry);	
					System.out.println("catname  "+catname);
					if(catname!=null)
					{
						
						qry="Select qty from spectsStockHolding where itmCode="+Integer.parseInt(arrNext[i])+"";
					String quantity=inf.getSingleValue(qry);
					System.out.println("quantity  "+quantity);
										
					String qry1="Select itmNm from spectsItemMaster where itmCode="+Integer.parseInt(arrNext[i])+"";
					itemname=inf.getSingleValue(qry1);
					System.out.println("Itemname    "+itemname);
					//////cat code/////
					qry1="Select catCode from spectsItemMaster where itmCode="+Integer.parseInt(arrNext[i])+"";
					String catcd=inf.getSingleValue(qry1);
					System.out.println("catcd  "+catcd);
					////////catname///
					qry1="Select catNm from spectsCatMaster where catCode="+Integer.parseInt(catcd)+"";
					catname=inf.getSingleValue(qry1);
					System.out.println("catname   "+catname);
					
					qry="Select cmpCode from spectsStockHolding where itmCode="+Integer.parseInt(arrNext[i])+"";
					String cmpcd=inf.getSingleValue(qry);
					System.out.println("cmpcd  "+cmpcd);
							
					qry="Select cmpName from spectsCmpMaster where cmpCode="+Integer.parseInt(cmpcd)+"";
					cmpname=inf.getSingleValue(qry);
					System.out.println("cmpnm  "+cmpname);
					
					
					
					
					loadarr[0]=""+(++sno);
					loadarr[1]=gpnm;
					loadarr[2]=catname;
					loadarr[3]=cmpname;
					loadarr[4]=itemname;
					loadarr[5]=quantity;
					
					dtm.addRow(loadarr);
						
						
					}
				}
				
				
				
			}*/
			
			
			
			
			
			
			
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR .....in groupWiseInfo MEthod"+ex);
		}
		
	}
	
	
}