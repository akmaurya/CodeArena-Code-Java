import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class PendingSurgeryDetails implements ActionListener,KeyListener
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
	
	String arr1[],date,month,year,hdate,drcode[],name,opdate,opmonth,opyear;
		
	public PendingSurgeryDetails(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("Pending Surgery Details",false,true,false,true);
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
		String head[]={"S.No.","SurgeryDate","Patient ID","Name","Related Surgeon"};
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
		
		column=jt.getColumn("SurgeryDate");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(110);
		
		column=jt.getColumn("Patient ID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(165);
			
		column=jt.getColumn("Related Surgeon");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(145);

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
		//	zedint=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
			count=inf.getCountValue("select count(drCode) from drDetail where drCatCode=1");
			drcode=new String[count];
			drcode=inf.getResultSetAs_1D_Array("select drName from drDetail where drCatCode=1");
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
			dtm.setRowCount(0);
			String hdate1=jl5.getText();
			String hdate2=jl6.getText();
			String str[]=new String[3];
			arr1=new String[5];
			if(cb.isSelected()==false)
			{	
				/*For Getting Oldest Date*/
				String str1[]=inf.getResultSetAs_1D_Array("select date from eye_Surgery_Detail order by date");
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
			
			String pid[]=inf.getResultSetAs_1D_Array("select distinct Patient_Id from eye_Surgery_Detail where date>=#"+hdate1+"# and date<=#"+hdate2+"#");
			if(pid!=null && pid.length!=0)
			{
				name=(String)cmb.getSelectedItem();
			
				if(name.equals("All"))
				{
					boolean flag=true;
					for(int l=0;l<pid.length;l++)
					{
						if(pid[l]!=null)
						{
				
							hdate=inf.getSingleValue("select Operation_Date from eye_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"");
							str=hdate.split("-");
							opyear=str[0];
							opmonth=str[1];
							opdate=str[2];
							str=opdate.split("00:00:00");
							opdate=str[0];
							opdate=opdate.trim();
						
							if(Integer.parseInt(penmn)<=Integer.parseInt(opmonth))
							{
								if(Integer.parseInt(pendt)<=Integer.parseInt(opdate))
								{	
									name=inf.getSingleValue("select Surgeon_name from eye_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"");
									String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
									String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
									//drcatname=zedint.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
									arr1[0]=""+(++sno);						
									arr1[1]=opdate+"-"+opmonth+"-"+opyear;
									arr1[2]=pid[l];
									arr1[3]=pname;
								//	arr1[4]=drcatname;
									arr1[4]=name;
									dtm.addRow(arr1);
									flag=false;
								}	
							}						
						}
					}
					if(flag)
						JOptionPane.showMessageDialog(jt,"No Pending Surgery","Message",JOptionPane.INFORMATION_MESSAGE);	
				}
				else
				{
					name=(String)cmb.getSelectedItem();
					String code=inf.getSingleValue("select drCode from drDetail where drName='"+name+"'");
				
					pid=inf.getResultSetAs_1D_Array("select distinct Patient_Id from eye_Surgery_Detail where date>=#"+hdate1+"# and date<=#"+hdate2+"# and Surgeon_name='"+name+"'");
				
					boolean flag=true;
					for(int l=0;l<pid.length;l++)
					{
						if(pid[l]!=null)
						{
				
							hdate=inf.getSingleValue("select Operation_Date from eye_Surgery_Detail where Patient_Id="+Integer.parseInt(pid[l])+"");
							str=hdate.split("-");
							opyear=str[0];
							opmonth=str[1];
							opdate=str[2];
							str=opdate.split("00:00:00");
							opdate=str[0];
							opdate=opdate.trim();
						
							if(Integer.parseInt(penmn)<=Integer.parseInt(opmonth))
							{
								if(Integer.parseInt(pendt)<=Integer.parseInt(opdate))
								{	
									String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
									String drcatname=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
								//	drcatname=zedint.getSingleValue("select drCatName from drCategory where drCatCode="+Integer.parseInt(drcatname)+"");
									arr1[0]=""+(++sno);						
									arr1[1]=opdate+"-"+opmonth+"-"+opyear;
									arr1[2]=pid[l];
									arr1[3]=pname;
							//		arr1[4]=drcatname;
									arr1[4]=name;
									dtm.addRow(arr1);
									flag=false;
								}	
							}						
						}
					}
					if(flag)
						JOptionPane.showMessageDialog(jt,"No Pending Surgery","Message",JOptionPane.INFORMATION_MESSAGE);
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