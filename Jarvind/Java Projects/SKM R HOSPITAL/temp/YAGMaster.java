import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.rmi.*;
import java.rmi.registry.*;

class YAGMaster extends JDialog implements ActionListener,KeyListener
{
	Container cn;
	JTextField YAGT,AMT,strengthT;
	JButton Save,Close,Update;
	JComboBox cb1;
	String setip,st="";
	ZedInterface inf=null;
	boolean flag=true;
	public YAGMaster()
	{
		Font fntdialog=new Font("Arial Narrow",Font.BOLD,14);
		cn=getContentPane();
		cn.setLayout(null);
 		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
			

	    setTitle("YAG MASTER WINDOW");
		JLabel categoryL=new JLabel("YAG Category");
		categoryL.setOpaque(false);
		categoryL.setBounds(10,20,90,20);
		categoryL.setFont(fntdialog);

		
		
		YAGT=new JTextField();
		YAGT.setBounds(110,20,180,25);
		
				
		JLabel AmountL=new JLabel("Amount");
		AmountL.setOpaque(false);
		AmountL.setBounds(10,60,90,20);
		AmountL.setFont(fntdialog);
		AMT=new JTextField();
		AMT.setBounds(110,60,180,25);
		AMT.setHorizontalAlignment(JTextField.RIGHT);
		
		cb1=new JComboBox();
		cb1.setBounds(310,20,170,30);
		

		
		Save=new JButton("Save",new ImageIcon ("icons\\save.gif"));
		Save.setMnemonic('a');
		Save.setBounds(15,120,140,30);
		Save.setToolTipText("Save");
		
			
		Close=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		Close.setMnemonic('c');
		Close.setBounds(200,120,140,30);
		Close.setToolTipText("Close");
		
		cn.add(categoryL);
		cn.add(YAGT);
		cn.add(AmountL);
		cn.add(AMT);
		cn.add(Save);
		cn.add(Close);

		
		Save.addActionListener(this);
		Close.addActionListener(this);

		YAGT.addKeyListener(this);
		AMT.addKeyListener(this);
	
		YAGT.requestFocus();
	

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Save)
		{
		
			if((YAGT.getText().equals(st)))
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Please Enter YAG Category","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
				YAGT.requestFocus();
			}
			else if((AMT.getText().equals(st)))
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Please Enter The Amount","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
				AMT.requestFocus();
			}
			else
			{
				try
				{
					double getAmr=Double.valueOf(AMT.getText().trim());	
					flag=true;
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,"Error !\n Please Input Only Number Type Value","Message",JOptionPane.ERROR_MESSAGE);
					flag=false;
					AMT.requestFocus();
				}
				if(flag)
				SaveYAGInfo();
			
			}
		}
		else if(ae.getSource()==Close)
		{
			this.dispose();
		}
	
	
	}
	
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getSource()==YAGT && ke.getKeyCode()==ke.VK_ENTER)
		{
			AMT.requestFocus();
		}
		else if(ke.getSource()==AMT && ke.getKeyCode()==ke.VK_ENTER)
		{
			Save.requestFocus();
		}
		else if(ke.getSource()==Save && ke.getKeyCode()==ke.VK_ENTER)
		{
			if((YAGT.getText().equals(st)))
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Please Enter YAG Category","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
				YAGT.requestFocus();
			}
			else if((AMT.getText().equals(st)))
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Please Enter The Amount","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
				AMT.requestFocus();
			}
			else
			{
				try
				{
					double getAmt=Double.valueOf(AMT.getText().trim());	
					
					SaveYAGInfo();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,"Error !\n Please Input Only Number Type Value ","Message",JOptionPane.ERROR_MESSAGE);
					AMT.requestFocus();
				}
			}
		}
		

	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}
	private void SaveYAGInfo()
	{
			try
			{
			
		
			
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
										System.out.println("Error at the time of connection with server ip-rmi://127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
			
			
			
				String qry="Select YAG_techName from YAGlaser_feeDetail where YAG_techName='"+YAGT.getText().trim()+"'";
				String loadYAG=inf.getSingleValue(qry);
				if(loadYAG==null)
				{
					qry="Select max(YAG_code) from YAGlaser_feeDetail";
					int YAGcode=inf.getMaxValue(qry);
					qry="insert into YAGlaser_feeDetail values("+(++YAGcode)+",'"+YAGT.getText().trim()+"',"+Double.valueOf(AMT.getText())+")";
					inf.executeUpdateQuery(qry);
					javax.swing.JOptionPane.showMessageDialog(this,"Data Saved Successfuly","Message",javax.swing.JOptionPane.INFORMATION_MESSAGE);
					YAGT.setText("");
					AMT.setText("");
				}
				else
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error\nAlready exists","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					YAGT.requestFocus();
				}
			
			}
			catch(Exception ex)
			{
				System.out.println("ERROR..IN SaveYAGInfo Method"+ex);
			}
	}



}