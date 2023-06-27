import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class StaffEdit implements ActionListener,KeyListener,MouseListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
	JTextField tf_name,tf_age,tf_contact,tf_salary;
	JButton save,refresh,close,but_deg,butt_calender;
	JRadioButton rb_male,rb_female,rb_daily,rb_monthly;
	JComboBox cmb_designation;
	ButtonGroup jbg1,jbg2;
	JScrollPane jsp;
	JTextArea tex_address;
	JTable jt;
	DefaultTableModel dtm;
	TableColumn column;
	String arr[][],arr1[],arr2[],date,month,year,name,str[],desig[];
	int count=0,d,m,y,sno;
	boolean flag=true;
	JInternalFrame jtf;
	ZedInterface inf;
	public StaffEdit(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("STAFF UPDATION",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		jl1=new JLabel("Enter Name Of Staff:");
		jl2=new JLabel("Enter Age(in Year):");
		jl3=new JLabel("Enter Contact No :");
		jl4=new JLabel("Enter Salary(in Rs.):");
		jl5=new JLabel("Sex :");
		jl6=new JLabel("On The Basis Of :");
		jl7=new JLabel("Date Of Joining :");
		jl8=new JLabel("Select Designation :");
		jl9=new JLabel("Enter Address :");
		jl10=new JLabel("Year");
		jl11=new JLabel("",JLabel.CENTER);
		/*jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl2.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl3.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl4.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl5.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl6.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl7.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl8.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl9.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl10.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		jl11.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));*/

		String head[]={"S.N.","Name","Age","Sex","Address","Contact No","Designation","Salary","Basis","Joining Date"};
		dtm=new DefaultTableModel(head,0);
		jt=new JTable(dtm);
		jt.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,14));
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
		
		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
		
		column=jt.getColumn("S.N.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(40);

      		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);

               	column=jt.getColumn("Age");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(50);
		
		column=jt.getColumn("Sex");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(80);
		
		column=jt.getColumn("Address");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(180);
		
		column=jt.getColumn("Contact No");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);
		
		column=jt.getColumn("Designation");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(100);

		column=jt.getColumn("Salary");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);

		column=jt.getColumn("Basis");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

		column=jt.getColumn("Joining Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(140);
		
		JScrollPane jsp1=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		tf_name= new JTextField();
		tf_age= new JTextField();
		tf_contact= new JTextField();
		tf_salary= new JTextField();

		tf_name.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		tf_age.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		tf_contact.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		tf_salary.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));

		rb_male=new JRadioButton("Male",true);
		rb_female=new JRadioButton("Female");
		rb_daily=new JRadioButton("Daily");
		rb_monthly=new JRadioButton("Monthly",true);

		rb_male.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		rb_female.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		rb_daily.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		rb_monthly.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));

		ButtonGroup jbg1=new ButtonGroup();
		ButtonGroup jbg2=new ButtonGroup();

		cmb_designation=new JComboBox();
		cmb_designation.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		try
		{
			///inf=(inferface)Naming.lookup(getIPaddress.IP());
			
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
			
			desig=inf.getResultSetAs_1D_Array("select designation from staff_Designation");
			for(int i=0;i<desig.length;i++)
				cmb_designation.addItem(desig[i]);
		}
		catch(Exception e)
		{
			System.out.println("Error "+e);
		}
		tex_address=new JTextArea();
		tex_address.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		jsp=new JScrollPane(tex_address);

		save=new JButton("EDIT",new ImageIcon("icons\\save1.gif"));
		refresh=new JButton("REFRESH",new ImageIcon("icons\\reset.gif"));
		close=new JButton("CLOSE",new ImageIcon("icons\\exit.gif"));
		but_deg=new JButton(new ImageIcon("icons\\new1.gif"));
		butt_calender=new JButton(new ImageIcon("icons\\calendar.gif"));
		
		jl1.setBounds(10,40,140,25);
		cn.add(jl1);
		
		tf_name.setBounds(140,40,150,25);
		cn.add(tf_name);
		
		jl2.setBounds(10,80,140,25);
		cn.add(jl2);
		
		tf_age.setBounds(140,80,70,25);
		cn.add(tf_age);
		
		jl10.setBounds(215,80,60,25);
		cn.add(jl10);
		
		jl5.setBounds(10,120,140,25);
		cn.add(jl5);
		
		rb_male.setBounds(140,120,70,25);
		rb_female.setBounds(210,120,80,25);
		rb_male.setBackground(new Color(60,220,220));
		rb_female.setBackground(new Color(60,220,220));
		jbg1.add(rb_male);
		jbg1.add(rb_female);
		cn.add(rb_male);
		cn.add(rb_female);

		jl9.setBounds(10,160,140,25);
		cn.add(jl9);
		
		jsp.setBounds(140,160,150,68);
		cn.add(jsp);
		
		jl3.setBounds(10,250,140,25);
		cn.add(jl3);
		
		tf_contact.setBounds(140,250,150,25);
		cn.add(tf_contact);
		
		jl8.setBounds(10,290,140,25);
		cn.add(jl8);
		
		cmb_designation.setBounds(140,290,125,25);
		cn.add(cmb_designation);
		
		but_deg.setBounds(270,290,22,25);
		cn.add(but_deg);
		
		jl4.setBounds(10,330,140,25);
		cn.add(jl4);
		
		tf_salary.setBounds(140,330,150,25);
		cn.add(tf_salary);
		
		jl6.setBounds(10,370,140,25);
		cn.add(jl6);		
		
		rb_daily.setBounds(140,370,70,25);
		rb_monthly.setBounds(210,370,80,25);
		rb_daily.setBackground(new Color(60,220,220));
		rb_monthly.setBackground(new Color(60,220,220));
		jbg2.add(rb_daily);
		jbg2.add(rb_monthly);
		cn.add(rb_daily);
		cn.add(rb_monthly);

		jl7.setBounds(10,410,140,25);
		cn.add(jl7);
		
		jl11.setBounds(140,410,80,25);
		jl11.setBackground(new Color(255,255,220));
		jl11.setOpaque(true);
		cn.add(jl11);
		
		butt_calender.setBounds(225,412,22,22);
		cn.add(butt_calender);
		
		save.setBounds(10,450,110,33);
		save.setToolTipText("Save");
		cn.add(save);		
		
		refresh.setBounds(130,450,115,33);
		refresh.setToolTipText("Refresh");
		cn.add(refresh);
				
		close.setBounds(255,450,110,33);
		close.setToolTipText("Close");
		cn.add(close);
		
		jsp1.setBounds(300,40,670,400);
		cn.add(jsp1);
		
		tf_name.setEditable(false);
		tf_age.setEditable(false);
		tf_contact.setEditable(false);
		tf_salary.setEditable(false);
		tex_address.setEditable(false);
		jl11.setEnabled(false);
		rb_male.setEnabled(false);
		rb_female.setEnabled(false);
		cmb_designation.setEnabled(false);
		rb_daily.setEnabled(false);
		rb_monthly.setEnabled(false);
		but_deg.setEnabled(false);
		butt_calender.setEnabled(false);
		
		butt_calender.addActionListener(this);
		close.addActionListener(this);
		save.addActionListener(this);
		refresh.addActionListener(this);
		but_deg.addActionListener(this);
		jt.addMouseListener(this);

		tf_name.addKeyListener(this);
		tf_age.addKeyListener(this);
		tf_contact.addKeyListener(this);
		tf_salary.addKeyListener(this);
		tex_address.addKeyListener(this);
		cmb_designation.addKeyListener(this);
		rb_male.addKeyListener(this);
		rb_female.addKeyListener(this);
		rb_daily.addKeyListener(this);
		rb_monthly.addKeyListener(this);
		butt_calender.addKeyListener(this);
		save.addKeyListener(this);
		jt.addKeyListener(this);
		jtf.setBackground(new Color(60,220,220));
		jtf.reshape(10,50,990,530);
		
		desk.add(jtf);
		jtf.setVisible(true);
		try
		{	
			str=new String[3];
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
		
			count=inf.getCountValue("select count(s_Name) from staff_Details");		
			arr=new String[count][11];
			arr1=new String[11];
			arr=inf.getResultSetAs_2D_Array("select * from staff_Details",11);
			if(arr!=null)
			{	
				sno=0;
				dtm.setRowCount(0);
				for(int i=0;i<arr.length;i++)
				{	
					arr1[0]=""+(++sno);
					arr1[1]=arr[i][1];						
					arr1[2]=arr[i][2];
					arr1[3]=arr[i][3];
					arr1[4]=arr[i][4];
					arr1[5]=arr[i][5];
					arr1[6]=arr[i][6];
					arr1[7]=arr[i][7];
					arr1[8]=arr[i][8];
					date=arr[i][9];
					str=date.split("-");
					year=str[0];
					month=str[1];
					date=str[2];
					str=date.split("00:00:00");
					date=str[0];
					arr1[9]=date+"-"+month+"-"+year;
					dtm.addRow(arr1);
				}
			}
			Date dt=new Date();
			d=dt.getDate();
			m=1+dt.getMonth();
			y=1900+dt.getYear();
			date=d+"/"+m+"/"+y;
			jl11.setText(date);	
		}
	    	catch(Exception e)
		{
			System.out.println("Error" +e);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==butt_calender)
		{
			Cal calender=new Cal();
 			jl11.setText(calender.getdate());
		}
		if(ae.getSource()==close)
		{	
			jtf.dispose();
		}
		if(ae.getSource()==save)
		{	
			if(jt.getSelectedRow()>=0)
			{
				saveButton();
			}
			else
			{
				JOptionPane.showMessageDialog(jt,"First Select The Record","Message",JOptionPane.INFORMATION_MESSAGE);		
				jt.requestFocus();
				if(jt.getRowCount()!=0)
					jt.setRowSelectionInterval(0,0);
			}	
		}
		if(ae.getSource()==refresh)
		{	
			tf_name.setText("");
			tf_age.setText("");
			tf_contact.setText("");
			tf_salary.setText("");
			tex_address.setText("");
			jl11.setText("");
			tf_name.setEditable(false);
			tf_age.setEditable(false);
			tf_contact.setEditable(false);
			tf_salary.setEditable(false);
			tex_address.setEditable(false);
			jl11.setEnabled(false);
			rb_male.setEnabled(false);
			rb_female.setEnabled(false);
			cmb_designation.setEnabled(false);
			rb_daily.setEnabled(false);
			rb_monthly.setEnabled(false);
			but_deg.setEnabled(false);
			butt_calender.setEnabled(false);
			
		}
		if(ae.getSource()==but_deg)
		{	
			String designation=JOptionPane.showInputDialog(but_deg,"Enter Designation","Designation",JOptionPane.INFORMATION_MESSAGE);		
			if(designation.equals(""))
			{
				JOptionPane.showMessageDialog(but_deg,"Please Input Designation","Error",JOptionPane.ERROR_MESSAGE);		
			}
			else
			{
				try
				{
					inf.executeUpdateQuery("insert into staff_Designation values('"+designation+"')");
					cmb_designation.addItem(designation);
					JOptionPane.showMessageDialog(but_deg,"Designation Entered","Error",JOptionPane.ERROR_MESSAGE);		
				}
				catch(Exception e)
				{
					System.out.println("Error"+e);
				}
			}
		}
	}
	public void keyPressed(KeyEvent ke)
	{	
		if(ke.getSource()==tf_name && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			tf_age.requestFocus();
		}
		if(ke.getSource()==tf_age && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			rb_male.requestFocus();
		}	
		if(ke.getSource()==rb_male && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			rb_male.setSelected(true);
			tex_address.requestFocus();
		}
		if(ke.getSource()==rb_female && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			rb_female.setSelected(true);
			tex_address.requestFocus();
		}
		if(ke.getSource()==tex_address && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{	
			ke.consume();
			tf_contact.requestFocus();	
		}
		if(ke.getSource()==tf_contact && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			cmb_designation.requestFocus();	
		}
		if(ke.getSource()==cmb_designation && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			tf_salary.requestFocus();	
		}
		if(ke.getSource()==tf_salary && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			rb_monthly.requestFocus();
		}
		if(ke.getSource()==rb_monthly && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{	
			rb_monthly.setSelected(true);
			butt_calender.requestFocus();
		}
		if(ke.getSource()==rb_daily && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{	
			rb_daily.setSelected(true);
			butt_calender.requestFocus();
		}
		if(ke.getSource()==butt_calender && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{		
			save.requestFocus();
		}
		if(ke.getSource()==jt && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			try
			{
				ke.consume();
				int r=jt.getSelectedRow();
				name=(String)jt.getValueAt(r,1);
				arr=inf.getResultSetAs_2D_Array("select * from staff_Details where s_Name='"+name+"'",10);
				
				tf_name.setEditable(true);
				tf_age.setEditable(true);
				tf_contact.setEditable(true);
				tf_salary.setEditable(true);
				tex_address.setEditable(true);
				jl11.setEnabled(true);
				rb_male.setEnabled(true);
				rb_female.setEnabled(true);
				cmb_designation.setEnabled(true);
				rb_daily.setEnabled(true);
				rb_monthly.setEnabled(true);
				but_deg.setEnabled(true);
				butt_calender.setEnabled(true);
			
				tf_name.setText(arr[0][1]);
				tf_age.setText(arr[0][2]);
				if(arr[0][3].equals("Male"))
					rb_male.setSelected(true);
				else
					rb_female.setSelected(true);
				tex_address.setText(arr[0][4]);
				tf_contact.setText(arr[0][5]);
				cmb_designation.setSelectedItem(arr[0][6]);
				tf_salary.setText(arr[0][7]);
				if(arr[0][8].equals("Daily"))
					rb_daily.setSelected(true);
				else
					rb_monthly.setSelected(true);
				date=arr[0][9];
				str=date.split("-");
				year=str[0];
				month=str[1];
				date=str[2];
				str=date.split("00:00:00");
				date=str[0];
				date=date+"/"+month+"/"+year;
				jl11.setText(date);
				tf_name.requestFocus();
			}
			catch(Exception sql)
			{
				System.out.println("Error" +sql);
			}
				
		}
		if(ke.getSource()==save && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{
			
			if(jt.getSelectedRow()>=0)
			{
				saveButton();
			}
			else
			{
				JOptionPane.showMessageDialog(jt,"First Select The Record","Message",JOptionPane.INFORMATION_MESSAGE);		
				jt.requestFocus();
				if(jt.getRowCount()!=0)
					jt.setRowSelectionInterval(0,0);
			}
		}	
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	private boolean saveButton()
	{
		try
		{	
			int age=0;
			double salary=0;
			if(tf_name.getText().trim().length()==0)
			{	
				JOptionPane.showMessageDialog(tf_name,"Please Input Staff Name","Error",JOptionPane.ERROR_MESSAGE);		
				tf_name.requestFocus();
				flag=false;
				return false;
			}
			else if(tf_age.getText().trim().length()==0)
			{	
				JOptionPane.showMessageDialog(tf_age,"Please Input Age","Error",JOptionPane.ERROR_MESSAGE);		
				tf_age.requestFocus();
				flag=false;
				return false;
			}
			else if(tf_age.getText().trim().length()!=0)
			{
				try
				{
					age=Integer.parseInt(tf_age.getText());
					if(10<=age && age<=90)
					{	
						flag=true;
					}
					else
					{
						JOptionPane.showMessageDialog(tf_age,"Age Should Be In Between 10-90","Error",JOptionPane.ERROR_MESSAGE);
						tf_age.setText("");
						tf_age.requestFocus();
						flag=false;
						return false;
					}
				}
				catch(Exception e)
				{	
					JOptionPane.showMessageDialog(tf_age,"Please Input Correct Age","Error",JOptionPane.ERROR_MESSAGE);
					tf_age.setText("");
					tf_age.requestFocus();
					flag=false;
					return false;	
				}
			}
			if(tex_address.getText().trim().length()==0)
			{	
				JOptionPane.showMessageDialog(tex_address,"Please Input Address","Error",JOptionPane.ERROR_MESSAGE);		
				tex_address.requestFocus();
				flag=false;
				return false;
			}
			if(tf_contact.getText().trim().length()!=0)
			{
				try
				{
					Double.valueOf(tf_contact.getText());
					flag=true;
				}
				catch(Exception e)
				{	
					JOptionPane.showMessageDialog(tf_contact,"Contact Number Must Be Integer","Error",JOptionPane.ERROR_MESSAGE);
					tf_contact.setText("");
					tf_contact.requestFocus();
					flag=false;
					return false;	
				}
			}
			if(tf_salary.getText().trim().length()==0)
			{
				JOptionPane.showMessageDialog(tf_salary,"Please Input Salary","Error",JOptionPane.ERROR_MESSAGE);	
				tf_salary.requestFocus();
				return false;
			}
			else if(tf_salary.getText().trim().length()!=0)
			{	
				try
				{
					salary=Double.valueOf(tf_salary.getText());
					flag=true;
				}
				catch(Exception e)
				{	
					JOptionPane.showMessageDialog(tf_salary,"Salary Must Be Integer","Error",JOptionPane.ERROR_MESSAGE);
					tf_salary.setText("");
					tf_salary.requestFocus();
					flag=false;
					return false;
				}
			}
			if(jl11.getText().trim().length()==0)
			{	
				JOptionPane.showMessageDialog(jl11,"Please Input Date Of Joining","Error",JOptionPane.ERROR_MESSAGE);	
				butt_calender.requestFocus();
				flag=false;
				return false;
			}
			if(flag)
			{	
				arr2=new String[6];
				int r=jt.getSelectedRow();
				name=(String)jt.getValueAt(r,1);
				String id=inf.getSingleValue("select s_Code from staff_Details where s_Name='"+name+"'");
				arr2[0]=tf_name.getText();
				if(rb_male.isSelected())
				{
					arr2[1]="Male";
				}
				else
				{
					arr2[1]="Female";
				}
				arr2[2]=tex_address.getText();
				arr2[3]=tf_contact.getText();
				arr2[4]=(String)cmb_designation.getSelectedItem();
				if(rb_daily.isSelected())
				{
					arr2[5]="Daily";
				}
				else
				{
					arr2[5]="Monthly";
				}
				arr=inf.getResultSetAs_2D_Array("select * from staff_Details where s_Code="+Integer.parseInt(id),11);
				/*for(int i=0;i<arr.length;i++)
				{
					for(int j=0;j<10;j++)
					{
						System.out.println("arr["+i+"]["+j+"]="+arr[i][j]);
					}
				}*/
				date=arr[0][9];
				str=date.split("-");
				year=str[0];
				month=str[1];
				date=str[2];
				str=date.split("00:00:00");
				date=str[0];
				arr[0][9]=date+"-"+month+"-"+year;
				if(arr[0][1].equalsIgnoreCase(arr2[0]) &&  arr[0][2].equalsIgnoreCase(""+age) && arr[0][3].equalsIgnoreCase(arr2[1]) && arr[0][4].equalsIgnoreCase(arr2[2]) && arr[0][5].equalsIgnoreCase(arr2[3]) && arr[0][6].equalsIgnoreCase(arr2[4]) && arr[0][7].equalsIgnoreCase(""+salary) && arr[0][8].equalsIgnoreCase(arr2[5]) && arr[0][9].equalsIgnoreCase(jl11.getText()))
				{		
					tf_name.requestFocus();
					jt.setRowSelectionInterval(jt.getSelectedRow(),jt.getSelectedRow());
					JOptionPane.showMessageDialog(jtf,"Entered Staff Exist","Error",JOptionPane.ERROR_MESSAGE);
				}
				else
				{	
           				int editNo=inf.getMaxValue("select max(editNo) from logFileForUpdate");
           				editNo+=1;
            				
            				java.util.Date dt=new java.util.Date();
           				String dateAndTime=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900)+" "+dt.getHours()+":"+dt.getMinutes()+":"+dt.getSeconds();

					inf.executeUpdateQuery("insert into logFileForUpdate values('"+dateAndTime+"','EditStaff',"+editNo+")");
					arr=inf.getResultSetAs_2D_Array("select * from staff_Details where s_Code="+Integer.parseInt(id),11);
					
					inf.executeUpdateQuery("insert into staff_DetailsEdit values("+Integer.parseInt(arr[0][0])+",'"+arr[0][1]+"',"+Integer.parseInt(arr[0][2])+",'"+arr[0][3]+"','"+arr[0][4]+"','"+arr[0][5]+"','"+arr[0][6]+"',"+Double.valueOf(arr[0][7])+",'"+arr[0][8]+"',#"+arr[0][9]+"#,null,"+editNo+")");
					
					if(arr2[3].equals(""))
						arr2[3]=null;
					date=jl11.getText();
					str=date.split("/");
					date=str[0];
					month=str[1];
					year=str[2];
					date=month+"/"+date+"/"+year;
					inf.executeUpdateQuery("update staff_Details set s_Name='"+arr2[0]+"',s_Age="+age+",s_Sex='"+arr2[1]+"',s_Ads='"+arr2[2]+"',s_Contact='"+arr2[3]+"',s_Designation='"+arr2[4]+"',s_Salary="+salary+",s_SalaryBasis='"+arr2[5]+"',s_DOJ=#"+date+"#,s_DOResign=null where s_Code="+Integer.parseInt(id));
					arr=inf.getResultSetAs_2D_Array("select * from staff_Details",11);	
					if(arr!=null)
					{	
						sno=0;
						dtm.setRowCount(0);
						for(int i=0;i<arr.length;i++)
						{	
							arr1[0]=""+(++sno);
							arr1[1]=arr[i][1];						
							arr1[2]=arr[i][2];
							arr1[3]=arr[i][3];
							arr1[4]=arr[i][4];
							arr1[5]=arr[i][5];
							arr1[6]=arr[i][6];
							arr1[7]=arr[i][7];
							arr1[8]=arr[i][8];
							date=arr[i][9];
							str=date.split("-");
							year=str[0];
							month=str[1];
							date=str[2];
							str=date.split("00:00:00");
							date=str[0];
							arr1[9]=date+"-"+month+"-"+year;
							dtm.addRow(arr1);
						}
					}
					tf_name.setText("");
					tf_age.setText("");
					tf_contact.setText("");
					tf_salary.setText("");
					tex_address.setText("");
					jl11.setText("");
					tf_name.setEditable(false);
					tf_age.setEditable(false);
					tf_contact.setEditable(false);
					tf_salary.setEditable(false);
					tex_address.setEditable(false);
					jl11.setEnabled(false);
					rb_male.setEnabled(false);
					rb_female.setEnabled(false);
					cmb_designation.setEnabled(false);
					rb_daily.setEnabled(false);
					rb_monthly.setEnabled(false);
					but_deg.setEnabled(false);
					butt_calender.setEnabled(false);
					JOptionPane.showMessageDialog(jtf,"Record Updated ","Message",JOptionPane.INFORMATION_MESSAGE);	
				}
			}
		}
		catch(Exception sql)
		{
			System.out.println("Error" +sql);
		}
		return true;	
	}
	public void mousePressed(MouseEvent me)
	{	
		try
		{
			me.consume();
			int r=jt.getSelectedRow();
			name=(String)jt.getValueAt(r,1);
			arr=inf.getResultSetAs_2D_Array("select * from staff_Details where s_Name='"+name+"'",11);	
			tf_name.setEditable(true);
			tf_age.setEditable(true);
			tf_contact.setEditable(true);
			tf_salary.setEditable(true);
			tex_address.setEditable(true);
			jl11.setEnabled(true);
			rb_male.setEnabled(true);
			rb_female.setEnabled(true);
			cmb_designation.setEnabled(true);
			rb_daily.setEnabled(true);
			rb_monthly.setEnabled(true);
			but_deg.setEnabled(true);
			butt_calender.setEnabled(true);
			
			tf_name.setText(arr[0][1]);
			tf_age.setText(arr[0][2]);
			if(arr[0][3].equals("Male"))
				rb_male.setSelected(true);
			else
				rb_female.setSelected(true);
			tex_address.setText(arr[0][4]);
			tf_contact.setText(arr[0][5]);
			cmb_designation.setSelectedItem(arr[0][6]);
			tf_salary.setText(arr[0][7]);
			if(arr[0][8].equals("Daily"))
				rb_daily.setSelected(true);
			else
				rb_monthly.setSelected(true);
			date=arr[0][9];
			str=date.split("-");
			year=str[0];
			month=str[1];
			date=str[2];
			str=date.split("00:00:00");
			date=str[0];
			date=date+"/"+month+"/"+year;
			jl11.setText(date);
			tf_name.requestFocus();
			
		} 
		catch(Exception sql)
		{
			System.out.println("Error" +sql);
		}			
	}
	public void mouseClicked(MouseEvent me)
	{
	}
	public void mouseReleased(MouseEvent me)
	{
	}
	public void mouseEntered(MouseEvent me)
	{
	}
	public void mouseExited(MouseEvent me)
	{
	}					
}