import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class GynecSurgeryDetail implements ActionListener,KeyListener
{	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	JTable jt;
	JCheckBox cb;
	JComboBox cmb;
	JButton show,close,date1,date2;
	DefaultTableModel dtm;
	TableColumn column;
	JInternalFrame jtf;
	ZedInterface inf=null;
	int d=0,m=0,y=0,sno,count=0;
	double amount=0.0,total;
	String arr[][],arr1[],date,month,year,hdate,drcode[],name;
	
	public GynecSurgeryDetail(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("Gynec Surgery Details",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		jl1=new JLabel("Enter Date Range");
		jl2=new JLabel("From");
		jl3=new JLabel("To");
		jl4=new JLabel("Select Releted Doctor");
		jl5=new JLabel("",JLabel.CENTER);
		jl6=new JLabel("",JLabel.CENTER);
		jl7=new JLabel("Total Charge:");
		jl8=new JLabel("",JLabel.RIGHT);
		jl8.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl2.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl3.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl4.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl5.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl6.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl7.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));

		cb=new JCheckBox();
		cmb=new JComboBox();
		cmb.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		String head[]={"S.No.","OPDate","PID","Name","Delivery","D&C","Surgery","Charge"};
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
		
		column=jt.getColumn("OPDate");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(110);
		
		column=jt.getColumn("PID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(70);

		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);

		column=jt.getColumn("Delivery");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);

		column=jt.getColumn("D&C");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(90);
		
		column=jt.getColumn("Surgery");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);

			column=jt.getColumn("Charge");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(110);

              	JScrollPane jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		show=new JButton("SHOW",new ImageIcon("icons\\save1.gif"));
		date1=new JButton(new ImageIcon("icons\\calendar.gif"));
		date2=new JButton(new ImageIcon("icons\\calendar.gif"));
		close=new JButton("CLOSE",new ImageIcon("icons\\exit.gif"));
		
		jl1.setBounds(15,40,150,25);
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
		cn.add(date2);

		jl4.setBounds(420,40,160,25);
		cn.add(jl4);
		cmb.setBounds(585,40,120,25);
		cn.add(cmb);
		
		show.setBounds(15,80,300,30);
		show.setToolTipText("Show");
		cn.add(show);		
		
		close.setBounds(405,80,300,30);
		close.setToolTipText("Close");
		cn.add(close);
		
		jsp.setBounds(15,125,690,270);
		cn.add(jsp);
		
		jl7.setBounds(420,410,130,25);
		cn.add(jl7);

		jl8.setBounds(540,410,161,25);
		jl8.setBackground(new Color(255,255,220));
		jl8.setOpaque(true);
		cn.add(jl8);

		Date dt=new Date();
		d=dt.getDate();
		m=1+dt.getMonth();
		y=1900+dt.getYear();
		date=d+"/"+m+"/"+y;
		jl5.setText(date);
		jl6.setText(date);
		date1.setEnabled(false);
		jl5.setEnabled(false);
		date1.setToolTipText("Select visit Date1");
		date2.setToolTipText("Select visit Date2");
	
		show.addActionListener(this);
		date1.addActionListener(this);
		date2.addActionListener(this);
		close.addActionListener(this);
		cb.addActionListener(this);
		cmb.addActionListener(this);
		show.addKeyListener(this);
		cmb.addKeyListener(this);
		date1.addKeyListener(this);
		date2.addKeyListener(this);
		close.addKeyListener(this);
		
		jtf.setBackground(new Color(60,220,220));
		jtf.reshape(150,100,730,480);
		
		try
		{	
		///	zedint=(ZedInterface)Naming.lookup(getIPaddress.IP());
		
		
try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							
									try
									{
										inf=(ZedInterface)Naming.lookup("rmi://127.0.0.1/ExtendZedServer");
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}			
		
			count=0;
			count=inf.getCountValue("select count(drCode) from drDetail where drCatCode=2");
			drcode=new String[count];
			drcode=inf.getResultSetAs_1D_Array("select drName from drDetail where drCatCode=2");
			cmb.addItem("All");
			for(int i=0;i<drcode.length;i++)
				cmb.addItem(drcode[i]);
		}
	    	catch(Exception e)
		{
			System.out.println("Error" +e);
		}
		desk.add(jtf);
		jtf.setVisible(true);
		jl8.setText("0.00");
	}
	public void keyPressed(KeyEvent ke)
	{
	
		if(ke.getSource()==date1 && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			date2.requestFocus();
		}
		if(ke.getSource()==date2 && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			cmb.requestFocus();
		}
		if(ke.getSource()==cmb && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			show.requestFocus();
		}
		if(ke.getSource()==show && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			showButton();
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
		if(ae.getSource()==date1)
		{
			Cal calender=new Cal();
 			jl5.setText(calender.getdate());
		}
		if(ae.getSource()==date2)
		{
			Cal calender=new Cal();
 			jl6.setText(calender.getdate());
		}
		if(ae.getSource()==cb)
		{
			if(cb.isSelected()==true)
			{
				date1.setEnabled(true);
				jl5.setEnabled(true);
			}
			else
			{
				date1.setEnabled(false);
				jl5.setEnabled(false);
			}
		}
		if(ae.getSource()==close)
		{
			jtf.dispose();
		}
		if(ae.getSource()==show)
		{
			showButton();
		}	
	}
	private void showButton()
	{
		try
		{	
			dtm.setRowCount(0);
			jl8.setText("0.00");
			String hdate1=jl5.getText();
			String hdate2=jl6.getText();
			String str[]=new String[3];
			arr1=new String[8];
			if(cb.isSelected()==false)
			{	
				/*For Getting Oldest Date*/
				String str1[]=inf.getResultSetAs_1D_Array("select date from gianec_Surgery_Detail order by date");
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
			String pid[]=inf.getResultSetAs_1D_Array("select distinct Patient_Id from gianec_Surgery_Detail where date>=#"+hdate1+"# and date<=#"+hdate2+"#");
			if(pid!=null && pid.length!=0)
			{
			name=(String)cmb.getSelectedItem();
			total=0.0;
			if(name.equals("All"))
			{
				for(int l=0;l<pid.length;l++)
				{
					if(pid[l]!=null)
					{
						arr=inf.getResultSetAs_2D_Array("select delivery,dc,surgery,total_charges from gianec_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"",4);
					//	System.out.println("arr-------- "+arr);
						String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
					
						hdate=inf.getSingleValue("select Operation_Date from gianec_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"");
						str=hdate.split("-");
						year=str[0];
						month=str[1];
						date=str[2];
						str=date.split("00:00:00");
						date=str[0];
					/*	String drcatname=zedint.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
						drcatname=zedint.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");*/
						if(arr!=null)
						{
						
							amount=Double.valueOf(arr[0][3]);
							arr1[0]=""+(++sno);						
							arr1[1]=date+"-"+month+"-"+year;
							arr1[2]=pid[l];
							arr1[3]=pname;
							arr1[4]=arr[0][0];
							arr1[5]=arr[0][1];
							arr1[6]=arr[0][2];
							arr1[7]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
							dtm.addRow(arr1);
							total=total+amount;
							jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
						}					
					}
				}
			}
			else
			{
				name=(String)cmb.getSelectedItem();
				System.out.println("name ----"+name);
				String code=inf.getSingleValue("select drCode from drDetail where drName='"+name+"'");
				//String ppid[]=zedint.getResultSetAs_1D_Array("select patientid from patient_Profile where drCode="+Integer.parseInt(code));
				//pid=zedint.getResultSetAs_1D_Array("select distinct Patient_Id from eye_Surgery_Detail where date>=#"+hdate1+"# and date<=#"+hdate2+"# and Surgeon_name='"+name+"'");
				pid=inf.getResultSetAs_1D_Array("select distinct Patient_Id from gianec_Surgery_Detail where date>=#"+hdate1+"# and date<=#"+hdate2+"#");
				total=0.0;
				if(pid!=null)
				{
				
					
				for(int l=0;l<pid.length;l++)
				{
					
					String getID=inf.getSingleValue("Select distinct patientid from patient_Profile where drCode="+Integer.parseInt(code)+" and patientid="+Integer.parseInt(pid[l])+"");
				//	System.out.println("getID "+getID);
					
					if(getID!=null)
					{
						arr=inf.getResultSetAs_2D_Array("select delivery,dc,surgery,total_charges from gianec_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"",4);
					//	System.out.println("arr-------- "+arr);
						String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");	
				//	arr=zedint.getResultSetAs_2D_Array("select Surgeon_name,Surgery_SISSC,Surgery_PHACO,Surgery_TRAB,Surgery_DCR,Surgery_SQUINT,Surgery_ENT,Surgery_PTR,Surgery_SecIOL,amount from eye_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+" and Surgeon_name='"+name+"'",10);
					
					hdate=inf.getSingleValue("select Operation_Date from gianec_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"");
					str=hdate.split("-");
					year=str[0];
					month=str[1];
					date=str[2];
					str=date.split("00:00:00");
					date=str[0];	
				//	String pname=zedint.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
				//	String drcatname=zedint.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
				//		drcatname=zedint.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
				
						
						////////////////working if loop
					if(arr!=null)
					{
						
						
					/*	amount=Double.valueOf(arr[0][9]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						arr1[2]=pid[l];
						arr1[3]=pname;
						arr1[4]=drcatname;
						arr1[7]=arr[0][0];
						arr1[8]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;*/
						
						///////////////working code
						amount=Double.valueOf(arr[0][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						arr1[2]=pid[l];
						arr1[3]=pname;
						arr1[4]=arr[0][0];
						arr1[5]=arr[0][1];
						arr1[6]=arr[0][2];
						arr1[7]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
						//////////////////////////////
					}
						
					}
				
					
											
				}
				}
				else
					jl8.setText("");
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
	/*private void code()
	{
		try
		{
			hdate=zedint.getSingleValue("select Operation_Date from eye_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"");
			str=hdate.split("-");
			year=str[0];
			month=str[1];
			date=str[2];
			str=date.split("00:00:00");
			date=str[0];	
			String pname=zedint.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
			String right=zedint.getSingleValue("select Selected_eye_RE from eye_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"");
			if(Integer.parseInt(right)==1)
			{
				right="Right";
				arr1[4]="Right";
			}
			String left=zedint.getSingleValue("select Selected_eye_LE from eye_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"");
			if(Integer.parseInt(left)==1)
			{
				left="Left";
				arr1[4]="Left";
			}
			if(right.equals("Right") && left.equals("Left"))
				arr1[4]="Both";
			if(arr!=null)
			{
				if(Integer.parseInt(arr[0][1])==1)
				{
					arr1[5]=""+"SISSC";
				}
				if(Integer.parseInt(arr[0][2])==1)
				{
					arr1[5]=arr1[5]+","+"PHACO";
				}
				if(Integer.parseInt(arr[0][3])==1)
				{
					arr1[5]=arr1[5]+","+"TRAB";
				}
				if(Integer.parseInt(arr[0][4])==1)
				{
					arr1[5]=arr1[5]+","+"DCR";
				}
				if(Integer.parseInt(arr[0][5])==1)
				{
					arr1[5]=arr1[5]+","+"SQUNIT";
				}
				if(Integer.parseInt(arr[0][6])==1)
				{
					arr1[5]=arr1[5]+","+"ENT";
				}
				if(Integer.parseInt(arr[0][7])==1)
				{
					arr1[5]=arr1[5]+","+"PTR";
				}
				if(Integer.parseInt(arr[0][8])==1)
				{
					arr1[5]=arr1[5]+","+"SecIOL";
				}
				amount=Double.valueOf(arr[0][9]);
				arr1[0]=""+(++sno);						
				arr1[1]=date+"-"+month+"-"+year;
				arr1[2]=pid[l];
				arr1[3]=pname;
				arr1[6]=arr[0][0];
				arr1[7]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
				dtm.addRow(arr1);
				total=total+amount;
				jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
			}
		}
		catch(Exception e)
		{
			System.out.println("Error" +e);
		}
	}*/
}