import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class SpectDetails implements ActionListener,KeyListener
{	
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JTable jt;
	JCheckBox cb;
	JComboBox cmb;
	JButton show,close,date1,date2;
	DefaultTableModel dtm;
	TableColumn column;
	JInternalFrame jtf;
	ZedInterface inf;
	int d=0,m=0,y=0,sno,count=0;
	
	String arr[][],arr1[],date,month,year,hdate,drcode[],name,gdate,gmonth,gyear;
		
	public SpectDetails(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("Spects Details",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		jl1=new JLabel("Enter Date Range");
		jl2=new JLabel("From");
		jl3=new JLabel("To");
		jl4=new JLabel("Select Releted Doctor");
		jl5=new JLabel("",JLabel.CENTER);
		jl6=new JLabel("",JLabel.CENTER);
		
		
		jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl2.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl3.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl4.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl5.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl6.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		
		cb=new JCheckBox();
		cmb=new JComboBox();
		cmb.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		String head[]={"S.No.","Giving Date","PID","Name","Related With","Surgeon","Lens No","Total Amount","Due Amount","Pending"};
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
       		column.setPreferredWidth(50);
		
		column=jt.getColumn("Giving Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(110);
		
		column=jt.getColumn("PID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(165);
			
		column=jt.getColumn("Related With");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);

		column=jt.getColumn("Surgeon");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(140);

		column=jt.getColumn("Lens No");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

		column=jt.getColumn("Pending");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

		column=jt.getColumn("Total Amount");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(120);
		
		column=jt.getColumn("Due Amount");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(120);


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

		jl4.setBounds(415,40,160,25);
		cn.add(jl4);
		cmb.setBounds(575,40,130,25);
		cn.add(cmb);
		
		show.setBounds(15,80,300,30);
		show.setToolTipText("Show");
		cn.add(show);		
		
		close.setBounds(405,80,300,30);
		close.setToolTipText("Close");
		cn.add(close);
		
		jsp.setBounds(15,125,690,270);
		cn.add(jsp);

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
			String hdate1=jl5.getText();
			String hdate2=jl6.getText();
			String str[]=new String[3];
			arr1=new String[10];
			if(cb.isSelected()==false)
			{	
				/*For Getting Oldest Date*/
				String str1[]=inf.getResultSetAs_1D_Array("select date from patient_SpectsProvidation order by date");
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
			String pendt=date;
			String penmn=month;
			hdate2=month+"/"+date+"/"+year;
						
			sno=0;
			dtm.setRowCount(0);
			String pid[]=inf.getResultSetAs_1D_Array("select distinct pID from patient_SpectsProvidation where date>=#"+hdate1+"# and date<=#"+hdate2+"#");
			/*for(int l=0;l<pid.length;l++)
			{		
				System.out.println("pid[]="+pid[l]);
			}*/
			name=(String)cmb.getSelectedItem();
			if(pid!=null && pid.length!=0)
			{
				if(name.equals("All"))
				{
					for(int l=0;l<pid.length;l++)
					{
						arr=inf.getResultSetAs_2D_Array("select glassLensNo,givenDt,amt,dueAmt from patient_SpectsProvidation where pID="+Integer.parseInt(pid[l])+"",4);
						if(pid[l]!=null && arr!=null)
						{
							str=arr[0][1].split("-");
							gyear=str[0];
							gmonth=str[1];
							gdate=str[2];
							str=gdate.split("00:00:00");
							gdate=str[0];
							gdate=gdate.trim();
							String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
							String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
							drcatname=inf.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
						
							name=inf.getSingleValue("select drCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
							name=inf.getSingleValue("select drName from drDetail where drCode="+Integer.parseInt(name)+"");
							
							String status=inf.getSingleValue("select status from patient_SpectsProvidation where pID="+Integer.parseInt(pid[l]));
							System.out.println("status="+status);
							arr1[0]=""+(++sno);						
							arr1[1]=gdate+"-"+gmonth+"-"+gyear;
							arr1[2]=pid[l];
							arr1[3]=pname;
							arr1[4]=drcatname;
							arr1[5]=name;
							arr1[6]=arr[0][0];
							arr1[7]=""+(new java.math.BigDecimal(arr[0][2]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
							arr1[8]=""+(new java.math.BigDecimal(arr[0][3]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
							
							if(Integer.parseInt(status)==0)
							{	
								arr1[9]="Yes";		
							}
							else
								arr1[9]="No";
							/*if(Integer.parseInt(penmn)==Integer.parseInt(gmonth))
							{
								if(Integer.parseInt(status)==0 && Integer.parseInt(pendt)<Integer.parseInt(gdate))
								{		
									arr1[9]="Yes";
								}
								else
									arr1[9]="No";
							}*/
							dtm.addRow(arr1);
						}						
					}
				}
				else
				{
					name=(String)cmb.getSelectedItem();
					String code=inf.getSingleValue("select drCode from drDetail where drName='"+name+"'");
					pid=inf.getResultSetAs_1D_Array("select distinct pId from patient_SpectsProvidation where date>=#"+hdate1+"# and date<=#"+hdate2+"#");
					String ppid[]=inf.getResultSetAs_1D_Array("select patientid from patient_Profile where drCode="+Integer.parseInt(code));
				
					for(int l=0;l<pid.length;l++)
					{
						for(int m=0;m<ppid.length;m++)
						{
							if(pid!=null && Integer.parseInt(pid[l])==Integer.parseInt(ppid[m]))
							{
								arr=inf.getResultSetAs_2D_Array("select glassLensNo,givenDt,amt,dueAmt from patient_SpectsProvidation where pID="+Integer.parseInt(pid[l])+"",4);
								if(arr!=null)
								{
									str=arr[0][1].split("-");
									gyear=str[0];
									gmonth=str[1];
									gdate=str[2];
									str=gdate.split("00:00:00");
									gdate=str[0];
									gdate=gdate.trim();
									String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
									String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
									drcatname=inf.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
						
									name=inf.getSingleValue("select drName from drDetail where drCode="+Integer.parseInt(code)+"");
						
									String status=inf.getSingleValue("select status from patient_SpectsProvidation where pID="+Integer.parseInt(pid[l]));

									arr1[0]=""+(++sno);						
									arr1[1]=gdate+"-"+gmonth+"-"+gyear;
									arr1[2]=pid[l];
									arr1[3]=pname;
									arr1[4]=drcatname;
									arr1[5]=name;
									arr1[6]=arr[0][0];
									arr1[7]=""+(new java.math.BigDecimal(arr[0][2]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
									arr1[8]=""+(new java.math.BigDecimal(arr[0][3]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
									if(Integer.parseInt(status)==0)
									{	
										arr1[9]="Yes";		
									}
									else
										arr1[9]="No";
									/*if(Integer.parseInt(penmn)==Integer.parseInt(gmonth))
									{
										if(Integer.parseInt(pendt)<Integer.parseInt(gdate) && Integer.parseInt(status)==0)
										{		
											arr1[9]="Yes";
										}
										else
											arr1[9]="No";
									}*/
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