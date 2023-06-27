import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.*;
public class StaffDetails implements ActionListener,KeyListener
{
	JLabel jl1;
	JButton show,close;
	JComboBox cmb;
	JTable jt;
	DefaultTableModel dtm;
	TableColumn column;
	ZedInterface inf;
	JInternalFrame jtf;
	
	int count,sno;
	String desig[],arr[][],arr1[],name;
	public StaffDetails(JDesktopPane desk)
	{
		jtf=new JInternalFrame("Staff Details",false,true,false,true);
		Container cn=jtf.getContentPane();
		cn.setLayout(null);
		cmb=new JComboBox();
		jl1=new JLabel("Select Staff Designation :");
		jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));

		String head[]={"S.N.","ID","Name","Address","Contact No","Salary","Salary Basis","Date Of Joining"};
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

		column=jt.getColumn("ID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(60);

      		column=jt.getColumn("Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);
		
		column=jt.getColumn("Address");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(180);
		
		column=jt.getColumn("Contact No");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);
		
		column=jt.getColumn("Salary");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(110);

		column=jt.getColumn("Salary Basis");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(100);

                column=jt.getColumn("Date Of Joining");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(180);
		
		JScrollPane jsp=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		show=new JButton("SHOW",new ImageIcon("icons\\save1.gif"));
		close=new JButton("CLOSE",new ImageIcon("icons\\exit.gif"));
		jl1.setBounds(10,25,180,30);
		cmb.setBounds(200,28,180,28);
		show.setBounds(390,26,110,30);
		cmb.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		jsp.setBounds(10,70,610,300);
		close.setBounds(510,26,110,30);
		cn.add(jl1);
		cn.add(cmb);
		cn.add(close);
		cn.add(show);
		cn.add(jsp);
		close.setMnemonic('c');
		close.setToolTipText("Close");	
		close.addActionListener(this);
		cmb.addActionListener(this);
		show.addActionListener(this);

		close.addKeyListener(this);
		cmb.addKeyListener(this);
		show.addKeyListener(this);
		jtf.setBackground(new Color(60,220,220));
		jtf.reshape(100,100,640,420);
		
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
			count=0;
			count=inf.getCountValue("select count(designation) from staff_Designation");
			desig=new String[count];
			desig=inf.getResultSetAs_1D_Array("select designation from staff_Designation");
			cmb.addItem("All");
			for(int i=0;i<desig.length;i++)
				cmb.addItem(desig[i]);
		}
		catch(Exception e)
		{
			System.out.println("Error "+e);
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
	}
	public void keyPressed(KeyEvent ke)
	{	
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
	private void showButton()
	{
		try
		{
			name=(String)cmb.getSelectedItem();
			arr1=new String[8];
			count=inf.getCountValue("select count(s_Code) from staff_Details");
			arr=new String[count][7];
			if(count>0)
			{
				if(name.equals("All"))
				{
					arr=inf.getResultSetAs_2D_Array("select s_Code,s_Name,s_Ads,s_Contact,s_Salary,s_SalaryBasis,s_DOJ from staff_Details",7);
					dtm.setRowCount(0);
					sno=0;
					for(int i=0;i<arr.length;i++)
					{
						arr1[0]=""+(++sno);
						arr1[1]=arr[i][0];						
						arr1[2]=arr[i][1];
						arr1[3]=arr[i][2];
						arr1[4]=arr[i][3];
						arr1[5]=arr[i][4];
						arr1[6]=arr[i][5];
                                                System.out.println("arr[0][6]="+arr[0][6]);
                                                String itm[]=arr[i][6].split(" ");
                                                String itm1[]=itm[0].split("-");
                                                String tm[]=itm[1].split(":");
                                                int hour=Integer.parseInt(tm[0]);
                                                String tfor="AM";
                                                if(hour>=12)
                                                {
                                                    hour=hour-12;
                                                    tfor="PM";
                                                }
                                                String time=hour+":"+tm[1]+":"+tm[2];
                                                arr1[7]=itm1[2]+"/"+itm1[1]+"/"+itm1[0]+"  "+time+" "+tfor;

						dtm.addRow(arr1);
					}
				}	
				else
				{
					arr=inf.getResultSetAs_2D_Array("select s_Code,s_Name,s_Ads,s_Contact,s_Salary,s_SalaryBasis,s_DOJ from staff_Details where s_Designation='"+name+"'",7);
					dtm.setRowCount(0);
					sno=0;
					for(int i=0;i<arr.length;i++)
					{
						arr1[0]=""+(++sno);
						arr1[1]=arr[i][0];						
						arr1[2]=arr[i][1];
						arr1[3]=arr[i][2];
						arr1[4]=arr[i][3];
						arr1[5]=arr[i][4];
						arr1[6]=arr[i][5];

                                                String itm[]=arr[i][6].split(" ");
                                                String itm1[]=itm[0].split("-");
                                                String tm[]=itm[1].split(":");
                                                int hour=Integer.parseInt(tm[0]);
                                                String tfor="AM";
                                                if(hour>=12)
                                                {
                                                    hour=hour-12;
                                                    tfor="PM";
                                                }
                                                String time=hour+":"+tm[1]+":"+tm[2];
                                                arr1[7]=itm1[2]+"/"+itm1[1]+"/"+itm1[0]+"  "+time+" "+tfor;

						dtm.addRow(arr1);
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(jt,"No Record Exists","Message",JOptionPane.INFORMATION_MESSAGE);	
			}
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
		}
	}
}