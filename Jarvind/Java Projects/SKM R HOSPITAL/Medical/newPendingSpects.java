import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class newPendingSpects implements ActionListener,KeyListener
{
	JLabel jl1,jl2,jl3;
	JButton show,close,dte;
	JComboBox cmb1;
	JTable jt;
	DefaultTableModel dtm;
	TableColumn column;
	ZedInterface inf;
	JInternalFrame jtf;
	
	int count,sno,d,m,y;
	String arr[][],arr1[],id,date,name,month,year;
	public newPendingSpects(JDesktopPane desk)
	{
		
		jtf=new JInternalFrame("Pending Spect Details",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		
		jl1=new JLabel("Select Given Date:");
		jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl2=new JLabel("",JLabel.CENTER);
		
		jl3=new JLabel("Select Category");
		jl3.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		
		cmb1=new JComboBox();
			

		String head[]={"S.No.","ID","Name","Surgeon","Lens No","Total Amount","Due Amount"};
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
		
		column=jt.getColumn("ID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(165);

		column=jt.getColumn("Surgeon");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(140);

		column=jt.getColumn("Lens No");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

		column=jt.getColumn("Total Amount");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(120);
		
		column=jt.getColumn("Due Amount");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(120);


              	
		show=new JButton("SHOW",new ImageIcon("icons\\save1.gif"));
		dte=new JButton(new ImageIcon("icons\\calendar.gif"));
		
		close=new JButton("CLOSE",new ImageIcon("icons\\exit.gif"));
		
		JScrollPane jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		show=new JButton("SHOW",new ImageIcon("icons\\save1.gif"));
		close=new JButton("CLOSE",new ImageIcon("icons\\exit.gif"));
		jl1.setBounds(10,25,130,30);
		jl2.setBounds(150,27,120,28);

		jl2.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		jl2.setBackground(new Color(255,255,220));
		jl2.setOpaque(true);
		dte.setBounds(275,28,21,23);
		
		jl3.setBounds(415,25,160,25);
		cn.add(jl3);
		
				
		cmb1.setBounds(550,25,130,25);
		cn.add(cmb1);
		cmb1.addItem("Select");
		cmb1.addItem("Patient");
		cmb1.addItem("Customer");
	
			
		//show.setBounds(450,26,110,30);
		show.setBounds(10,70,300,30);
		
	//	jsp.setBounds(10,70,670,300);
		jsp.setBounds(10,120,670,300);
		//close.setBounds(570,26,110,30);
		close.setBounds(380,70,300,30);
		cn.add(jl1);
		cn.add(jl2);
		cn.add(dte);	
		cn.add(close);
		cn.add(show);
		cn.add(jsp);

		Date dt=new Date();
		d=dt.getDate();
		m=1+dt.getMonth();
		y=1900+dt.getYear();
		if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)
		{
			if(d==31)
			{
				d=1;
				m=m+1;
			}
			else
				d=1+dt.getDate();
		}
		else if(m!=2)
		{
			if(d==30)
			{
				d=1;
				m=m+1;
			}
			else
				d=1+dt.getDate();	
		}
		if(m==2)
		{
			if(d==28)
			{
				if(y%4==0)
				{
					d=29;
				}
				else
				{
					d=1;
					m=m+1;
				}
			}
			else if(d==29)
			{
				d=1;
				m=m+1;
			}
			else
				d=1+dt.getDate();
		}		
		date=d+"/"+m+"/"+y;
		jl2.setText(date);
		
		dte.setToolTipText("Select Given Date");
		close.setMnemonic('c');
		close.setToolTipText("Close");	
		
		close.addActionListener(this);
		show.addActionListener(this);
		close.addKeyListener(this);
		show.addKeyListener(this);
		dte.addActionListener(this);
		dte.addKeyListener(this);

		
		jtf.setBackground(new Color(60,220,220));
	//	jtf.reshape(100,100,700,420);
		jtf.reshape(100,100,700,470);
		
		desk.add(jtf);
		jtf.setVisible(true);
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
		if(ae.getSource()==dte)
		{
			Cal calender=new Cal();
 			jl2.setText(calender.getdate());
		}
	}
	public void keyPressed(KeyEvent ke)
	{	
		if(ke.getSource()==dte && ke.getKeyCode()==KeyEvent.VK_ENTER)
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
	private void showButton()
	{
		try
		{	
			String hdate1=jl2.getText();
			String str[]=new String[3];
			arr1=new String[7];
			str=hdate1.split("/");
			date=str[0];
			month=str[1];
			year=str[2];
			hdate1=month+"/"+date+"/"+year;
			
			if((""+cmb1.getSelectedItem()).equals("Patient"))
			{
							sno=0;
				dtm.setRowCount(0);
				String pid[]=inf.getResultSetAs_1D_Array("select distinct pID from patient_SpectsProvidation where givenDt=#"+hdate1+"# and status=false");
				/*for(int l=0;l<pid.length;l++)
				{		
					System.out.println("pid[]="+pid[l]);
				}*/
				
				if(pid!=null && pid.length!=0)
				{
					for(int l=0;l<pid.length;l++)
					{
						arr=inf.getResultSetAs_2D_Array("select glassLensNo,amt,dueAmt from patient_SpectsProvidation where pID="+Integer.parseInt(pid[l])+"",3);
						if(arr!=null)
						{
							
							String pname=inf.getSingleValue("select name from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
						
							name=inf.getSingleValue("select drCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
							name=inf.getSingleValue("select drName from drDetail where drCode="+Integer.parseInt(name)+"");
								
							arr1[0]=""+(++sno);						
							arr1[1]=pid[l];
							arr1[2]=pname;
							arr1[3]=name;
							arr1[4]=arr[0][0];
							arr1[5]=""+(new java.math.BigDecimal(arr[0][1]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
							arr1[6]=""+(new java.math.BigDecimal(arr[0][2]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
							dtm.addRow(arr1);						
						}
					}
				}
				else
					JOptionPane.showMessageDialog(jt,"No Pending Spects","Message",JOptionPane.INFORMATION_MESSAGE);		
			}
			else if((""+cmb1.getSelectedItem()).equals("Customer"))
			{
				
					sno=0;
			dtm.setRowCount(0);
			String cid[]=inf.getResultSetAs_1D_Array("select cID from customer_SpectsProvidation where givenDt=#"+hdate1+"# and status=false");
			/*for(int l=0;l<pid.length;l++)
			{		
				System.out.println("pid[]="+pid[l]);
			}*/
			
			if(cid!=null && cid.length!=0)
			{
				for(int l=0;l<cid.length;l++)
				{
					arr=inf.getResultSetAs_2D_Array("select glassLensNo,amt,dueAmt from customer_SpectsProvidation where cID='"+(cid[l])+"'",3);
					if(arr!=null)
					{
						
						String cname=inf.getSingleValue("select cName from customer_SpectsProvidation where cID='"+(cid[l])+"'");
						
					//	name=inf.getSingleValue("select drCode from patient_Profile where patientid="+Integer.parseInt(pid[l])+"");
					//	name=inf.getSingleValue("select drName from drDetail where drCode="+Integer.parseInt(name)+"");
					name="";	
						arr1[0]=""+(++sno);						
						arr1[1]=cid[l];
						arr1[2]=cname;
						arr1[3]=name;
						arr1[4]=arr[0][0];
						arr1[5]=""+(new java.math.BigDecimal(arr[0][1]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						arr1[6]=""+(new java.math.BigDecimal(arr[0][2]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
						dtm.addRow(arr1);						
					}
				}
			}
			else
				JOptionPane.showMessageDialog(jt,"No Pending Spects","Message",JOptionPane.INFORMATION_MESSAGE);	
				
			}
			/*else
			{
				javax.swing.JOptionPane.showMessageDialog(jt,"ERROR !\nPlease Select The Category","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
				
			}*/
			
		
		}
		catch(Exception e)
		{
			System.out.println("Error" +e);
		}
	}
}