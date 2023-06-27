import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class StaffRegistration implements ActionListener,KeyListener
{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11;
	JTextField tf_name,tf_age,tf_contact,tf_salary;
	JButton save,refresh,close,but_deg,butt_calender;
	JRadioButton rb_male,rb_female,rb_daily,rb_monthly;
	JComboBox cmb_designation;
	ButtonGroup jbg1,jbg2;
	JScrollPane jsp;
	JTextArea tex_address;
	String arr[],arr1[],date,month,year;
	int count=0,d,m,y;
	boolean flag=true;
	JInternalFrame jtf;
	ZedInterface inf;
	String drCategory="",drQualification="";
	
	public StaffRegistration(JDesktopPane desk)
	{	
		jtf=new JInternalFrame("STAFF REGISTRATION",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		jl1=new JLabel("Enter Name Of Staff:");
		jl2=new JLabel("Enter Age(in Year):");
		jl3=new JLabel("Enter Contact No :");
		jl4=new JLabel("Enter Salary ( In Rs.):");
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
		
		tex_address=new JTextArea();
		tex_address.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		jsp=new JScrollPane(tex_address);

		save=new JButton("Save",new ImageIcon("icons\\save1.gif"));
		refresh=new JButton("Refresh",new ImageIcon("icons\\reset.gif"));
		close=new JButton("Close",new ImageIcon("icons\\exit.gif"));
		but_deg=new JButton(new ImageIcon("icons\\new1.gif"));
		butt_calender=new JButton(new ImageIcon("icons\\calendar.gif"));
		
		jl1.setBounds(20,40,140,25);
		cn.add(jl1);
		
		tf_name.setBounds(170,40,220,25);
		cn.add(tf_name);
		
		jl2.setBounds(20,80,140,25);
		cn.add(jl2);
		
		tf_age.setBounds(170,80,100,25);
		tf_age.setHorizontalAlignment(JLabel.RIGHT);
		cn.add(tf_age);
		
		jl10.setBounds(275,80,60,25);
		cn.add(jl10);
		
		jl5.setBounds(20,120,140,25);
		cn.add(jl5);
		
		rb_male.setBounds(170,120,100,25);
		rb_female.setBounds(290,120,100,25);
		rb_male.setBackground(new Color(60,220,220));
		rb_female.setBackground(new Color(60,220,220));
		jbg1.add(rb_male);
		jbg1.add(rb_female);
		cn.add(rb_male);
		cn.add(rb_female);

		jl9.setBounds(20,160,140,25);
		cn.add(jl9);
		
		jsp.setBounds(170,160,220,68);
		cn.add(jsp);
		
		jl3.setBounds(20,250,120,25);
		cn.add(jl3);
		JLabel lbl=new JLabel("+91");
		lbl.setHorizontalAlignment(JLabel.RIGHT);
		lbl.setBounds(140,250,30,25);
		cn.add(lbl);
		
		tf_contact.setBounds(170,250,220,25);
		cn.add(tf_contact);
		
		jl8.setBounds(20,290,140,25);
		cn.add(jl8);
		
		cmb_designation.setBounds(170,290,190,25);
		cn.add(cmb_designation);
		
		but_deg.setBounds(365,290,25,25);
		cn.add(but_deg);
		
		jl4.setBounds(20,330,140,25);
		cn.add(jl4);
		
		tf_salary.setBounds(170,330,220,25);
		cn.add(tf_salary);
		
		jl6.setBounds(20,370,140,25);
		cn.add(jl6);		
		
		rb_daily.setBounds(170,370,100,25);
		rb_monthly.setBounds(290,370,100,25);
		rb_daily.setBackground(new Color(60,220,220));
		rb_monthly.setBackground(new Color(60,220,220));
		jbg2.add(rb_daily);
		jbg2.add(rb_monthly);
		cn.add(rb_daily);
		cn.add(rb_monthly);

		jl7.setBounds(20,410,140,25);
		cn.add(jl7);
		
		jl11.setBounds(170,410,100,25);
		jl11.setBackground(new Color(255,255,220));
		jl11.setOpaque(true);
		cn.add(jl11);
		
		butt_calender.setBounds(275,412,22,22);
		cn.add(butt_calender);
		
		save.setBounds(20,450,110,33);
		save.setToolTipText("Save");
		cn.add(save);		
		
		refresh.setBounds(147,450,115,33);
		refresh.setToolTipText("Refresh");
		cn.add(refresh);
				
		close.setBounds(280,450,110,33);
		close.setToolTipText("Close");
		cn.add(close);
		
		butt_calender.addActionListener(this);
		close.addActionListener(this);
		save.addActionListener(this);
		refresh.addActionListener(this);
		but_deg.addActionListener(this);

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

		jtf.setBackground(new Color(60,220,220));
		jtf.reshape(250,110,425,550);
		
		desk.add(jtf);
		jtf.setVisible(true);
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
			count=inf.getCountValue("select count(designation) from staff_Designation");
			if(count==0)
			{
				JOptionPane.showMessageDialog(tf_name,"No Designation Exists","Error",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				arr1=new String[count];
				arr1=inf.getResultSetAs_1D_Array("select designation from staff_Designation");
				for(int i=0;i<arr1.length;i++)
					cmb_designation.addItem(arr1[i]);
			}
			Date dt=new Date();
			d=dt.getDate();
			m=1+dt.getMonth();
			y=1900+dt.getYear();
			date=d+"/"+m+"/"+y;
			jl11.setText(date);
			tf_name.requestFocus();
			
		}
		catch(Exception e)
		{
			System.out.println("Error "+e);
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
			saveButton();
		}
		if(ae.getSource()==refresh)
		{	
			tf_name.setText("");
			tf_age.setText("");
			tf_contact.setText("");
			tf_salary.setText("");
			tex_address.setText("");
			//jl11.setText("");
			tf_name.requestFocus();
		}
		if(ae.getSource()==but_deg)
		{	
			String designation=JOptionPane.showInputDialog(but_deg,"Enter Designation","Designation",JOptionPane.ERROR_MESSAGE);		
			if(designation.equals(""))
			{
				JOptionPane.showMessageDialog(but_deg,"Please Input Designation","Error",JOptionPane.ERROR_MESSAGE);		
			}
			else
			{
				cmb_designation.addItem(designation);
				try
				{
					inf.executeUpdateQuery("insert into staff_Designation values('"+designation+"')");
					JOptionPane.showMessageDialog(but_deg,"Designation Saved Successfully","Thanks !!",JOptionPane.INFORMATION_MESSAGE);		
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
		if(ke.getSource()==save && ke.getKeyCode()==KeyEvent.VK_ENTER)
		{		
			saveButton();
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
					JOptionPane.showMessageDialog(tf_age,"Please Input Correct Age (Numbers Only)","Error",JOptionPane.ERROR_MESSAGE);
					//tf_age.setText("");
					tf_age.requestFocus();
					tf_age.selectAll();
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
					JOptionPane.showMessageDialog(tf_contact,"Please Input Correct Contact No.","Error",JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(tf_salary,"Please Input Correct Salary","Error",JOptionPane.ERROR_MESSAGE);
					tf_salary.setText("");
					tf_salary.requestFocus();
					flag=false;
					return false;
				}
			}
			if(jl11.getText().trim().length()==0)
			{	
				JOptionPane.showMessageDialog(jl11,"Please Input Correct Date Of Joining","Error",JOptionPane.ERROR_MESSAGE);	
				butt_calender.requestFocus();
				flag=false;
			}
			if(flag)
			{	
				arr=new String[6];
				arr[0]=tf_name.getText();
				String name=inf.getSingleValue("select s_Name from staff_Details where s_Name='"+arr[0]+"'");	
				if(name!=null && name.equalsIgnoreCase(arr[0]))
				{	
					JOptionPane.showMessageDialog(jtf,"Staff Existed Before","Error",JOptionPane.ERROR_MESSAGE);	
					tf_name.setText("");
					tf_name.requestFocus();
				}
				else
				{	
					int Maxid=0;
					Maxid=inf.getMaxValue("select MAX(s_Code) from staff_Details");	
					if(Maxid!=0)
					{	
						Maxid=Maxid+1;
					}
					else
					{	
						Maxid=1;
					}
					arr[0]=tf_name.getText();
					if(rb_male.isSelected())
					{
						arr[1]="Male";
					}
					else
					{
						arr[1]="Female";
					}
					arr[2]=tex_address.getText();
					arr[3]=tf_contact.getText();
					arr[4]=(String)cmb_designation.getSelectedItem();
					if(rb_daily.isSelected())
					{
						arr[5]="Daily";
					}
					else
					{
						arr[5]="Monthly";
					}	
					String date=jl11.getText();
					String str[]=new String[3];
					str=date.split("/");
					date=str[0];
					month=str[1];
					year=str[2];
					date=month+"/"+date+"/"+year;
					
					
					///------------updated here-------------
					if(arr[4].equalsIgnoreCase("Doctor"))
					{
						InputDoctorDetail dr=new InputDoctorDetail();
						String drcatc=inf.getSingleValue("select drCatCode from drCategory where drCatName='"+drCategory+"'");
						if(drcatc!=null)
						{
							int drcatcode=Integer.parseInt(drcatc);
							int drcode=inf.getMaxValue("select max(drCode) from drDetail");
							//if(drcode!=null)
							{
								drcode+=1;
								inf.executeUpdateQuery("insert into drDetail values("+drcatcode+","+drcode+",'"+arr[0]+"','"+tf_age.getText()+"','"+drQualification+"')");
								JOptionPane.showMessageDialog(jtf,"Note Please :-\nDoctor ID= "+drcode+"\nPassword= "+tf_age.getText(),"Congratulation !!!",JOptionPane.INFORMATION_MESSAGE);	
							}
						}
						
							
					}
					
					//=======================================
					inf.executeUpdateQuery("insert into staff_Details values("+Maxid+",'"+arr[0]+"',"+age+",'"+arr[1]+"','"+arr[2]+"','"+arr[3]+"','"+arr[4]+"',"+salary+",'"+arr[5]+"',#"+date+"#,null)");
					JOptionPane.showMessageDialog(jtf,"Note Please :-\nStaff ID= "+Maxid,"Congratulation !!!",JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(jtf,"Staff Added Successfully ","Congratulation !!!",JOptionPane.INFORMATION_MESSAGE);	
					tf_name.setText("");
					tf_age.setText("");
					tf_contact.setText("");
					tf_salary.setText("");
					tex_address.setText("");
					//jl11.setText("");
					tf_name.requestFocus();
					
				}
			}
		}
		catch(Exception sql)
		{
			System.out.println("Error" +sql);
		}
		return true;	
	}
	
	class InputDoctorDetail	extends JFrame implements ActionListener,KeyListener
	{
		JButton btn_ok;
		JComboBox cb_drCategory;
		JTextField tf_ql;
		JDialog dg;
		public InputDoctorDetail()
		{
			dg=new JDialog(new JFrame(),"Input Related Info",true);
			dg.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			Container cn1=dg.getContentPane();
			cn1.setLayout(null);
			JLabel lbl1,lbl2;
			lbl1=new JLabel("Select Category");
			lbl1.setBounds(10,10,120,20);
			cn1.add(lbl1);
			cb_drCategory=new JComboBox();
			try
			{
			//	inferface inf=(inferface)Naming.lookup(getIPaddress.IP());
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
				String sqlQry="select drCatName from drCategory order by drCatName";
            	String []rs=inf.getResultSetAs_1D_Array(sqlQry);
            	if(rs!=null)
            	{
            		for(int i=0;i<rs.length;i++)
            		{
            			cb_drCategory.addItem(rs[i]);
            		}
            	}
			}
			catch(Exception e)
			{
				System.out.println("Error...."+e);
			}
			cb_drCategory.setBounds(130,10,120,20);
			cn1.add(cb_drCategory);
			lbl2=new JLabel("Qualification");
			lbl2.setBounds(10,45,120,20);
			cn1.add(lbl2);
			tf_ql=new JTextField();
			tf_ql.setBounds(130,45,120,20);
			cn1.add(tf_ql);
			
			btn_ok=new JButton("OK",new ImageIcon("icons\\save1.gif"));
			btn_ok.setMnemonic('o');
			btn_ok.setToolTipText("OK");
			btn_ok.setBounds(85,80,100,30);
			cn1.add(btn_ok);
			
			dg.setBounds(100,200,270,155);
			cb_drCategory.addKeyListener(this);
			tf_ql.addKeyListener(this);
			btn_ok.addKeyListener(this);
			btn_ok.addActionListener(this);
			dg.setLocation(250,130);
			dg.show();
		}
		public void keyReleased(KeyEvent ke)
		{}
		public void keyTyped(KeyEvent ke)
		{}
		public void keyPressed(KeyEvent ke)
		{
			if(ke.getSource()==cb_drCategory && ke.getKeyCode()==KeyEvent.VK_ENTER)
			{
				tf_ql.requestFocus();
			}
			else if(ke.getSource()==tf_ql && ke.getKeyCode()==KeyEvent.VK_ENTER)
			{
				btn_ok.requestFocus();
			}
			else if(ke.getSource()==btn_ok && ke.getKeyCode()==KeyEvent.VK_ENTER)
			{
				sendDrDetail();
			}
		}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==btn_ok)
			{
				sendDrDetail();
			}
		}
		private boolean sendDrDetail()
		{
			if(cb_drCategory.getSelectedItem()!=null)
			{
				if(tf_ql.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(jtf,"Please Input Doctor Qualification","Error",JOptionPane.ERROR_MESSAGE);	
					tf_ql.requestFocus();
					return false;
				}
				drCategory=""+cb_drCategory.getSelectedItem();
				drQualification=tf_ql.getText();
				dg.dispose();
			}
			return true;
		}
	}
}