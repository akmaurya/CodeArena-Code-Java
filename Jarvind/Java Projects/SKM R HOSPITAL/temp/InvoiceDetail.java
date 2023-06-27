import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class InvoiceDetail implements ActionListener//,KeyListener
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
	
	public InvoiceDetail(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("Invoice Details",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		jl1=new JLabel("Enter Date Range");
		jl2=new JLabel("From");
		jl3=new JLabel("To");
		jl4=new JLabel("Select From The List");
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
		String head[]={"S.No.","Receipt Date","PID","Name","Through","Amount"};
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
		
		column=jt.getColumn("Receipt Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(110);
		
		column=jt.getColumn("PID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(70);

		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);

		column=jt.getColumn("Through");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);

		column=jt.getColumn("Amount");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(90);
		
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
	//	show.addKeyListener(this);
	//	cmb.addKeyListener(this);
	//	date1.addKeyListener(this);
	//	date2.addKeyListener(this);
	//	close.addKeyListener(this);
		
		jtf.setBackground(new Color(60,220,220));
		jtf.reshape(150,100,730,480);
		
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
		
		
			String arrType[]={"Not Decided","Sale Invoice","Tax Invoice"};
			cmb.addItem("SELECT");
			for(int i=0;i<arrType.length;i++)
				cmb.addItem(arrType[i]);
		}
	    	catch(Exception e)
		{
			System.out.println("Error" +e);
		}
		desk.add(jtf);
		jtf.setVisible(true);
		jl8.setText("0.00");
	}
/*	public void keyPressed(KeyEvent ke)
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
	}*/
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
			arr1=new String[6];
			if(cb.isSelected()==false)
			{	
			////////////////	For Getting Oldest Date
				String str1[]=inf.getResultSetAs_1D_Array("select receiptDt from patient_All_Invoice order by receiptDt");
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
			name=(String)cmb.getSelectedItem();
		
			System.out.println("name....."+name);
			if(name.equals("Tax Invoice"))
			{
			//	dtm.setRowCount(0);
				String pid[][]=inf.getResultSetAs_2D_Array("select receiptDt,patientID,throughPaymentCome,amount from patient_All_Invoice where receiptDt>=#"+hdate1+"# and receiptDt<=#"+hdate2+"# and status=2",4);
				System.out.println("pid....."+pid[0][0]);
			if(pid!=null && pid.length>0)
			{
			
			total=0.0;
				int l;
				for(l=0;l<pid.length;l++)
				{
					
					int c=0;
				/*	System.out.println("0......."+pid[l][c]);
					System.out.println("1......."+pid[l][++c]);
					System.out.println("2......."+pid[l][++c]);
					System.out.println("3......."+pid[l][++c]);*/
					
						
				//	str=hdate.split("-");
						str=pid[l][0].split("-");
						year=str[0];
						month=str[1];
						date=str[2];
						str=date.split("00:00:00");
						date=str[0];//////////
					String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l][1])+"");
					if(Integer.parseInt(pid[l][1])==-1)
					{
						amount=Double.valueOf(pid[l][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						//String nm="Direct Sale";
						arr1[2]="Direct Sale";
						arr1[3]=pname;
						arr1[4]=pid[l][2];
						arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
					}
					else if(Integer.parseInt(pid[l][1])==-2)
					{
						amount=Double.valueOf(pid[l][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						//String nm="Sale To HPS";
						arr1[2]="Sale To HPS";
						arr1[3]=pname;
						arr1[4]=pid[l][2];
						arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
					}
					else
					{
						amount=Double.valueOf(pid[l][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						arr1[2]=pid[l][1];
						arr1[3]=pname;
						arr1[4]=pid[l][2];
						arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					}
					}
					System.out.println("total length----"+l);
			    }
			    
			}
			else if(name.equals("Sale Invoice"))
			{
			//	dtm.setRowCount(0);
				String pid[][]=inf.getResultSetAs_2D_Array("select receiptDt,patientID,throughPaymentCome,amount from patient_All_Invoice where receiptDt>=#"+hdate1+"# and receiptDt<=#"+hdate2+"# and status=1",4);
				System.out.println("pid....."+pid[0][0]);
			if(pid!=null && pid.length>0)
			{
			
			total=0.0;
			int l;
				for(l=0;l<pid.length;l++)
				{
					
					int c=0;
				/*	System.out.println("0......."+pid[l][c]);
					System.out.println("1......."+pid[l][++c]);
					System.out.println("2......."+pid[l][++c]);
					System.out.println("3......."+pid[l][++c]);*/
						str=pid[l][0].split("-");
						year=str[0];
						month=str[1];
						date=str[2];
						str=date.split("00:00:00");
						date=str[0];//////////
					String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l][1])+"");
					if(Integer.parseInt(pid[l][1])==-1)
					{
						amount=Double.valueOf(pid[l][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						//String nm="Direct Sale";
						arr1[2]="Direct Sale";
						arr1[3]=pname;
						arr1[4]=pid[l][2];
						arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
					}
					else if(Integer.parseInt(pid[l][1])==-2)
					{
						amount=Double.valueOf(pid[l][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						//String nm="Sale To HPS";
						arr1[2]="Sale To HPS";
						arr1[3]=pname;
						arr1[4]=pid[l][2];
						arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
					}
					else
					{
						amount=Double.valueOf(pid[l][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						arr1[2]=pid[l][1];
						arr1[3]=pname;
						arr1[4]=pid[l][2];
						arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					}
								
				}	
					System.out.println("total length ..."+l);
			}
			}
			
			else if(name.equals("Not Decided"))	
			{
			//	dtm.setRowCount(0);
				String pid[][]=inf.getResultSetAs_2D_Array("select receiptDt,patientID,throughPaymentCome,amount from patient_All_Invoice where receiptDt>=#"+hdate1+"# and receiptDt<=#"+hdate2+"# and status=0",4);
				System.out.println("pid....."+pid[0][0]);
			if(pid!=null && pid.length>0)
			{
			
			total=0.0;
			int l;
				for(l=0;l<pid.length;l++)
				{
					
					int c=0;
				/*	System.out.println("0......."+pid[l][c]);
					System.out.println("1......."+pid[l][++c]);
					System.out.println("2......."+pid[l][++c]);
					System.out.println("3......."+pid[l][++c]);*/
					
					
					
						str=pid[l][0].split("-");
						year=str[0];
						month=str[1];
						date=str[2];
						str=date.split("00:00:00");
						date=str[0];//////////
					String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l][1])+"");
					if(Integer.parseInt(pid[l][1])==-1)
					{
						amount=Double.valueOf(pid[l][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						//String nm="Direct Sale";
						arr1[2]="Direct Sale";
						arr1[3]=pname;
						arr1[4]=pid[l][2];
						arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
					}
					else if(Integer.parseInt(pid[l][1])==-2)
					{
						amount=Double.valueOf(pid[l][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						//String nm="Sale To HPS";
						arr1[2]="Sale To HPS";
						arr1[3]=pname;
						arr1[4]=pid[l][2];
						arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));	
					}
					else
					{
						amount=Double.valueOf(pid[l][3]);
						arr1[0]=""+(++sno);						
						arr1[1]=date+"-"+month+"-"+year;
						arr1[2]=pid[l][1];
						arr1[3]=pname;
						arr1[4]=pid[l][2];
						arr1[5]=""+(new java.math.BigDecimal(amount).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);
						total=total+amount;
						jl8.setText(""+(new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					}
					
					
					}
					System.out.println("total length ..."+l);
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