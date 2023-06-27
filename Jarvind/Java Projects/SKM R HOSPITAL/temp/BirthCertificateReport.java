import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class BirthCertificateReport implements ActionListener,KeyListener
{	
	JLabel jl1,jl2,jl3,jl5,jl6;
	JTable jt;
	JCheckBox cb;
	JButton show,close,date1,date2;
	DefaultTableModel dtm;
	TableColumn column;
	JInternalFrame jtf;
	ZedInterface inf;
	int d=0,m=0,y=0,sno,count=0;
	String arr[][],arr1[],date,month,year,hdate;
		
	public BirthCertificateReport(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("Birth Certificate Details",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		jl1=new JLabel("Enter Date Range");
		jl2=new JLabel("From");
		jl3=new JLabel("To");
		
		jl5=new JLabel("",JLabel.CENTER);
		jl6=new JLabel("",JLabel.CENTER);
		
		jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl2.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl3.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		
		jl5.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl6.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
	
		cb=new JCheckBox();
		
		String head[]={"S.No.","Issue Date","Name","Wife Of","Child Name","Village","Post","District"};
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
		
		column=jt.getColumn("Issue Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(110);

		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);
		
		column=jt.getColumn("Wife Of");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(140);

		column=jt.getColumn("Child Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);
		
		column=jt.getColumn("Village");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);

		column=jt.getColumn("Post");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(100);

		column=jt.getColumn("District");
      		column.setCellRenderer(CRLeft);
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

		show.setBounds(420,38,135,30);
		show.setToolTipText("Show");
		cn.add(show);
		close.setBounds(567,38,135,30);
		close.setToolTipText("Close");
		cn.add(close);
		
		jsp.setBounds(15,80,690,270);
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
		date1.setToolTipText("Select Issue Date1");
		date2.setToolTipText("Select Issue Date2");
	
		show.addActionListener(this);
		date1.addActionListener(this);
		date2.addActionListener(this);
		close.addActionListener(this);
		cb.addActionListener(this);
		
		show.addKeyListener(this);
		
		date1.addKeyListener(this);
		date2.addKeyListener(this);
		close.addKeyListener(this);
		
		jtf.setBackground(new Color(60,220,220));
		jtf.reshape(150,100,730,400);
		
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
			
			arr1=new String[8];
			if(cb.isSelected()==false)
			{	
				/*For Getting Oldest Date*/
				String str1[]=inf.getResultSetAs_1D_Array("select date from birthCertificate order by date");
				
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
			String pid[]=inf.getResultSetAs_1D_Array("select certificateNo from birthCertificate where date>=#"+hdate1+"# and date<=#"+hdate2+"# order by date");
			if(pid!=null && pid.length!=0)
			{
				for(int l=0;l<pid.length;l++)
				{
					if(pid[l]!=null)
					{
						arr=inf.getResultSetAs_2D_Array("select date,name,wifeOf,childName,vill,post,distt from birthCertificate where certificateNo="+Integer.parseInt(pid[l])+"",7);
						if(arr!=null)
						{
							hdate=arr[0][0];
							str=hdate.split("-");
							year=str[0];
							month=str[1];
							date=str[2];
							str=date.split("00:00:00");
							date=str[0];
							
							arr1[0]=""+(++sno);						
							arr1[1]=date+"-"+month+"-"+year;
							arr1[2]=arr[0][1];
							arr1[3]=arr[0][2];
							arr1[4]=arr[0][3];	
							arr1[5]=arr[0][4];
							arr1[6]=arr[0][5];
						        arr1[7]=arr[0][6];
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
	}					
}