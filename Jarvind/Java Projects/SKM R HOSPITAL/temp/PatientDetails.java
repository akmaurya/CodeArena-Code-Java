import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class PatientDetails implements ActionListener,KeyListener
{	
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtex1,jtex2;
	JTable jt;
	JCheckBox cb;
	JComboBox cmb;
	JButton show,close,date1,date2;
	DefaultTableModel dtm;
	TableColumn column;
	JInternalFrame jtf;
	ZedInterface inf=null;
	int d=0,m=0,y=0,sno,count=0;
	double amount=0.0;
	String arr[][],arr1[],date,month,year,hdate,drcode[],name;
	
	public PatientDetails(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("Patient:Receive Payment Details",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		jl1=new JLabel("Enter Date Range");
		jl2=new JLabel("From");
		jl3=new JLabel("To");
		jl4=new JLabel("Select Releted Doctor");
		jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl2.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl3.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl4.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jtex1=new JTextField();
		jtex2=new JTextField();
		jtex1.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		jtex2.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		cb=new JCheckBox();
		cmb=new JComboBox();
		cmb.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		String head[]={"S.No.","Date","Name","Age","Sex","Address","Related With","Paid Fee","New/Old"};
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
       		column.setPreferredWidth(40);
		
		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);

		column=jt.getColumn("Age");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(70);

		column=jt.getColumn("Sex");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(90);

		column=jt.getColumn("Address");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(200);
			
		column=jt.getColumn("Related With");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);

		column=jt.getColumn("Paid Fee");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(110);

      		column=jt.getColumn("New/Old");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

              	JScrollPane jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		show=new JButton("SHOW",new ImageIcon("icons\\save.gif"));
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

		date1.setToolTipText("Select visit HistoryDate1");
		date2.setToolTipText("Select visit HistoryDate2");
		//date2.setEnabled(false);
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
		jtex1.addKeyListener(this);
		jtex2.addKeyListener(this);
		jtf.setBackground(new Color(60,220,220));
		jtf.reshape(150,100,730,450);
		
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
	}
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getSource()==jtex1 && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			date1.requestFocus();
		}
		if(ke.getSource()==date1 && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			jtex2.requestFocus();
		}
		if(ke.getSource()==jtex2 && ke.getKeyCode()==KeyEvent.VK_ENTER)
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
		{	String str1[];
			dtm.setRowCount(0);
			String hdate1=jtex1.getText();
			String hdate2=jtex2.getText();
			String str[]=new String[3];
			arr1=new String[9];
			if(cb.isSelected()==false)
			{
				str1=inf.getResultSetAs_1D_Array("select history_date from history_Patient order by history_date");
				System.out.println("str1="+str1[0]);
				hdate1=str1[0];
				str=hdate1.split("-");
				year=str[0];
				month=str[1];
				date=str[2];
				str=date.split("00:00:00");
				date=str[0];
				hdate1=date+"/"+month+"/"+year;
			}
			str1=inf.getResultSetAs_1D_Array("select history_date from history_Patient order by history_date");
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
			arr=new String[str1.length][5];
			String charge;
			name=(String)cmb.getSelectedItem();
			if(name.equals("All"))
			{
				for(int l=0;l<pid.length;l++)
				{
					if(pid[l]!=null)
					{
						amount=0.0;
			
						charge="";
						charge=inf.getSingleValue("select amt from receive_Patient_Charges where patientID="+Integer.parseInt(pid[l])+" and status=true");
						if(charge!=null)
							amount=Double.valueOf(charge);
					
						charge="";	
						charge=inf.getSingleValue("select amount from eye_Surgery_Detail where Patient_id="+Integer.parseInt(pid[l])+" and status=true");
						if(charge!=null)
							amount=amount+Double.valueOf(charge);
					
						charge="";	
						charge=inf.getSingleValue("select rate from admit_Patient_info where id="+Integer.parseInt(pid[l])+" and status=true");
						if(charge!=null)
							amount=amount+Double.valueOf(charge);
					
						charge="";	
						charge=inf.getSingleValue("select amt from other_Payment_Detail where patient_id="+Integer.parseInt(pid[l])+" and status=true");
						if(charge!=null)
							amount=amount+Double.valueOf(charge);
						
						charge="";
						charge=inf.getSingleValue("select amt from patient_SpectsProvidation where pID="+Integer.parseInt(pid[l])+" and status=true");
						if(charge!=null)
							amount=amount+Double.valueOf(charge);
						
						hdate=inf.getSingleValue("select history_date from history_Patient where patient_id="+Integer.parseInt(pid[l])+" and history_date>=#"+hdate1+"# and history_date<=#"+hdate2+"#");
						str=hdate.split("-");
						year=str[0];
						month=str[1];
						date=str[2];
						str=date.split("00:00:00");
						date=str[0];
						count=0;
						count=inf.getCountValue("select count(patient_id) from history_Patient where patient_id="+Integer.parseInt(pid[l])+"");
						arr=inf.getResultSetAs_2D_Array("select name,age,gender,address from patient_Profile where patientid="+Integer.parseInt(pid[l])+"",4);
						String amt=inf.getSingleValue("select total_amount from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l]));
						String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
						drcatname=inf.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
						if(arr!=null && amt!=null && drcatname!=null)
						{	
						
							arr1[0]=""+(++sno);						
							arr1[1]=date+"-"+month+"-"+year;
							arr1[2]=arr[0][0];
							arr1[3]=arr[0][1];
							arr1[4]=arr[0][2];
							arr1[5]=arr[0][3];
							arr1[6]=drcatname;
							arr1[7]=""+(amount+Double.valueOf(amt));
							if(count>1)
							{
								arr1[8]="old";	
							}
							else
							{	
								arr1[8]="New";	
							}
							dtm.addRow(arr1);
							
						}
					}
				}
			}
			else
			{
				name=(String)cmb.getSelectedItem();
				String code=inf.getSingleValue("select drCode from drDetail where drName='"+name+"'");
				/*System.out.println("name="+name);
				System.out.println("code="+code);*/
				String ppid[]=inf.getResultSetAs_1D_Array("select patientid from patient_Profile where drCode="+Integer.parseInt(code));
				
				for(int l=0;l<pid.length;l++)
				{	
					for(int m=0;m<ppid.length;m++)
					{
						if(Integer.parseInt(pid[l])==Integer.parseInt(ppid[m]))
						{	
							amount=0.0;
							
							charge="";
							charge=inf.getSingleValue("select amt from receive_Patient_Charges where patientID="+Integer.parseInt(pid[l])+" and status=true");
							if(charge!=null)
								amount=Double.valueOf(charge);
							
							charge="";
							charge=inf.getSingleValue("select amount from eye_Surgery_Detail where Patient_id="+Integer.parseInt(pid[l])+" and status=true");
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
						
							charge="";
							charge=inf.getSingleValue("select rate from admit_Patient_info where id="+Integer.parseInt(pid[l])+" and status=true");
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
						
							charge="";
							charge=inf.getSingleValue("select amt from other_Payment_Detail where patient_id="+Integer.parseInt(pid[l])+" and status=true");
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
						
							charge="";
							charge=inf.getSingleValue("select amt from patient_SpectsProvidation where pID="+Integer.parseInt(pid[l])+" and status=true");
							if(charge!=null)
								amount=amount+Double.valueOf(charge);
							hdate=inf.getSingleValue("select history_date from history_Patient where patient_id="+Integer.parseInt(pid[l])+" and history_date>=#"+hdate1+"# and history_date<=#"+hdate2+"#");
							
							str=hdate.split("-");
							year=str[0];
							month=str[1];
							date=str[2];
							str=date.split("00:00:00");
							date=str[0];
							count=0;
							count=inf.getCountValue("select count(patient_id) from history_Patient where patient_id="+Integer.parseInt(pid[l])+"");
							arr=inf.getResultSetAs_2D_Array("select name,age,gender,address from patient_Profile where patientid="+Integer.parseInt(pid[l])+"",4);
							String amt=inf.getSingleValue("select total_amount from receivingPatient_FeeDetail where patientID="+Integer.parseInt(pid[l]));
							String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
							drcatname=inf.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
							if(arr!=null && amt!=null && drcatname!=null)
							{
								arr1[0]=""+(++sno);						
								arr1[1]=date+"-"+month+"-"+year;
								arr1[2]=arr[0][0];
								arr1[3]=arr[0][1];
								arr1[4]=arr[0][2];
								arr1[5]=arr[0][3];
								arr1[6]=drcatname;
								arr1[7]=""+(amount+Double.valueOf(amt));
								if(count>1)
								{
									arr1[8]="old";	
								}
								else
								{	
									arr1[8]="New";	
								}
								dtm.addRow(arr1);
							}
						}
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