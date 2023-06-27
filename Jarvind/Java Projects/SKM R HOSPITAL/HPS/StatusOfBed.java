import java.rmi.*;
import java.rmi.registry.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class StatusOfBed implements ActionListener
{
	JLabel jl1;
	JButton close;
	JButton[][] bed;
	JComboBox cmb;
	String arr1[],arr2[],name,id,numbed[],ward,room,bed1;
	ZedInterface inf;
	JInternalFrame jtf;
	JDesktopPane desk1;
	Container cn;
	RoomAllotement rmallot;
	int count,l=25,m=80,r=0,c=0;
	public StatusOfBed(JDesktopPane desk)
	{
		jtf=new JInternalFrame("Status Of Bed",false,true,false,true);
		desk1=new JDesktopPane();
		jtf.setContentPane(desk1);
		cn=jtf.getContentPane();
		cn.setLayout(null);
		cmb=new JComboBox();
		jl1=new JLabel("Select Ward Category:");
		jl1.setFont(new Font("Microsoft Sans Serif",Font.BOLD,13));
		close=new JButton("CLOSE",new ImageIcon("icons\\exit.gif"));
		jl1.setBounds(130,25,160,30);
		cmb.setBounds(300,28,180,28);
		cmb.setFont(new Font("Microsoft Sans Serif",Font.PLAIN,15));
		close.setBounds(700,25,110,30);
		cn.add(jl1);
		cn.add(cmb);
		cn.add(close);
		close.setMnemonic('c');
		close.setToolTipText("Close");	
		close.addActionListener(this);
		cmb.addActionListener(this);
		desk1.setBackground(new Color(60,220,220));
		jtf.reshape(80,80,900,600);
		//jtf.setVisible(true);
		try
		{
		//	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
			bed=new JButton[6][11];
			for(int j=0;j<6;j++)
			{	
				l=25;
				for(int k=0;k<11;k++)
				{
					bed[j][k]=new JButton();
					bed[j][k].setBounds(l,m,40,50);
					bed[j][k].setBackground(new Color(60,220,220));
					cn.add(bed[j][k]);
					bed[j][k].setVisible(false);
					bed[j][k].addActionListener(this);
					l=l+80;
				}
				m=m+90;
			}
			count=0;
			count=inf.getCountValue("select count(wardCatName) from wardCategory");                                                             
			arr1=new String[count];
			arr1=inf.getResultSetAs_1D_Array("select wardCatName from wardCategory order by wardCatName");
			for(int i=0;i<arr1.length;i++)
				cmb.addItem(arr1[i]);
			cmb.requestFocus();
		}
		catch(Exception e)
		{
			System.out.println("Error "+e);
		}
		if(count==0)
		{
			try
			{
				Thread t=new Thread();
				t.sleep(100);
				JOptionPane.showMessageDialog(jtf,"No Category Exists","Message",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(Exception e)
			{
				System.out.println("Error" +e);
			}
		}
		
		desk.add(jtf);
		jtf.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{	
			
		if(ae.getSource()==close)
		{	
			jtf.dispose();
		}
		if(ae.getSource()==cmb)
		{
			try
			{	
				for(int j=0;j<6;j++)
				{	
					for(int k=0;k<11;k++)
					{	
						bed[j][k].setVisible(false);
						
					}

				}
				name=(String)cmb.getSelectedItem();
				id=inf.getSingleValue("select wardCatCode from wardCategory where wardCatName='"+name+"'");
				count=inf.getCountValue("select count(roomNo) from roomDetails");
				arr2=new String[count];
				arr2=inf.getResultSetAs_1D_Array("select roomNo from roomDetails where wardCatCode="+Integer.parseInt(id));
				r=0;
				c=0;
				for(int j=0;j<arr2.length;j++)
				{	
					numbed=inf.getResultSetAs_1D_Array("select bedNo from bedDetails where roomNo="+Integer.parseInt(arr2[j]));
					for(int k=0;k<numbed.length;k++)
					{
						String status=inf.getSingleValue("select bedStatus from bedDetails where bedNo="+Integer.parseInt(numbed[k]));
						if(status.equals("0"))
						{
							bed[r][c].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
							bed[r][c].setToolTipText("Room Number="+arr2[j]+",Bed Number="+numbed[k]);
							bed[r][c].setIcon(new ImageIcon("icons\\greenshd.gif"));
							bed[r][c].setVisible(true);
							c++;
							if(c==11)
							{
								c=0;
								r++;
							}
							
						}
						else
						{	
							bed[r][c].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
							bed[r][c].setToolTipText("Room Number="+arr2[j]+",Bed Number="+numbed[k]);
							bed[r][c].setIcon(new ImageIcon("icons\\redshd.gif"));
							bed[r][c].setVisible(true);
							c++;
							if(c==11)
							{
								c=0;
								r++;
							}
						}
					}
				}	
			}
	     		catch(Exception e)
	    		{
				System.out.println("Error "+e);
	     		}
		}
		for(int j=0;j<6;j++)
		{	
			for(int k=0;k<11;k++)
			{	
				if(ae.getSource()==bed[j][k])
				{	
						
					String img1="icons\\redshd.gif"; 
					if(img1.equals(bed[j][k].getIcon().toString()))
					{	
						
						JOptionPane.showMessageDialog(rmallot,"Bed is Full can not be Allot","Message",JOptionPane.INFORMATION_MESSAGE);
						
					}
					else
					{	
						ward=name;
						String str=bed[j][k].getToolTipText();
						arr1=str.split(",");
						room=arr1[0];
						bed1=arr1[1];
						arr1=room.split("=");
						room=arr1[1];
						arr1=bed1.split("=");
						bed1=arr1[1];
						System.out.println("room="+room);
						System.out.println("bed="+bed1);
						new RoomAllotementThroughBed(desk1,ward,room,bed1);
						//bed[j][k].setIcon(new ImageIcon("icons\\redshd.gif"));
					}
				}
			}
		}	
	}
}