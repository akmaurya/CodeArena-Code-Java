import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.rmi.*;
import java.rmi.registry.*;

public class editYAGMaster extends javax.swing.JInternalFrame implements ActionListener,KeyListener
{
	Container cn;
//	JDialog DG;
//	JLabel categoryL,drugL,drugtypeL,strengthL;
	JTextField YAGT,AMT,strengthT;
	JButton Edit,Close,Delete;
	JComboBox cb1;
//	String temparr[]=null;
	String setip,st="";
	ZedInterface inf=null;
	boolean flag=true;
	public editYAGMaster()
	{
		Font fntdialog=new Font("Arial Narrow",Font.BOLD,14);
		cn=getContentPane();
		cn.setLayout(null);
 		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
			
	//	System.out.println("right");
	    setTitle("YAG MASTER WINDOW");
		JLabel categoryL=new JLabel("YAG Category");
		categoryL.setOpaque(false);
		categoryL.setBounds(10,20,90,20);
		categoryL.setFont(fntdialog);
//		categoryT=new JTextField();
		
		
/*		JLabel YAGL=new JLabel("Add New");
		YAGL.setOpaque(false);
		YAGL.setBounds(10,60,90,20);
		YAGL.setFont(fntdialog);*/
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
		
	/*	JLabel strengthL=new JLabel("Strenth");
		strengthL.setOpaque(false);
		strengthL.setBounds(10,140,90,20);
		strengthL.setFont(fntdialog);
		strengthT=new JTextField();
		strengthT.setBounds(110,140,140,20);*/
		
		
		Edit=new JButton("Edit",new ImageIcon ("icons\\save.gif"));
		Edit.setMnemonic('e');
		Edit.setBounds(15,120,140,30);
		Edit.setToolTipText("Save");
		
		
		Delete=new JButton("Delete",new ImageIcon("icons\\delete.gif"));
		Delete.setMnemonic('d');
		Delete.setBounds(180,120,130,30);
		Delete.setToolTipText("Delete");
		
		
		Close=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		Close.setMnemonic('c');
		Close.setBounds(330,120,140,30);
		Close.setToolTipText("Close");
		
		cn.add(categoryL);
		cn.add(YAGT);
		cn.add(cb1);
		cn.add(AmountL);
		cn.add(AMT);
	//	cn.add(drugtypeL);
	//	cn.add(drugtypeT);
	//	cn.add(strengthL);
	//	cn.add(strengthT);
		cn.add(Edit);
		cn.add(Delete);
		cn.add(Close);
		
		Edit.addActionListener(this);
		Close.addActionListener(this);
		Delete.addActionListener(this);
		cb1.addActionListener(this);
		
		YAGT.addKeyListener(this);
		AMT.addKeyListener(this);
		//drugtypeT.addKeyListener(this);
	//	strengthT.addKeyListener(this);
		
		YAGT.requestFocus();
	
	
		loadInitialInfo();	
	//	setip=getIPaddress.IP();
	//	System.out.println("setip "+setip);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Edit)
		{
		
			if((YAGT.getText().equals(st)))
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Please Enter YAG Category","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
				YAGT.requestFocus();
			}
			else if((AMT.getText().equals(st)))
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Please Input Amount","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(this,"Error !\n Please Input Only Number Type Value ","Message",JOptionPane.ERROR_MESSAGE);
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
		else if(ae.getSource()==Delete)
		{
			if((YAGT.getText().equals(st))||(AMT.getText().equals(st)))
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Message\nPlease select the item!","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
				cb1.requestFocus();
			}
			else
			{
				
				String getYAG=""+cb1.getSelectedItem();
				if(!(""+cb1.getSelectedItem()).equals("SELECT"))
				{
					deleteYAG();
				}
			}
			
		}
		else if(ae.getSource()==cb1)
		{
			ZedInterface inf=null;
			try
			{
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				}
				catch(Exception e)
				{
					System.out.println("Error at the time of connection with server "+getIPaddress.IP()+e);
					getIPaddress.changeIP();
					try
					{
						inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
					}
					catch(Exception ex)
					{
						System.out.println("Error at the time of connection with ip-rmi//127.0.0.1/ExtendedZedServer"+ex);
					}
				}
				
				
				String qry="Select YAG_charge from YAGlaser_feeDetail where YAG_techName='"+(""+cb1.getSelectedItem())+"'";
				String getAmt=inf.getSingleValue(qry);
				if(getAmt!=null)
				{
					String setAmt=(""+(new java.math.BigDecimal(getAmt).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
					AMT.setText(setAmt);
					YAGT.setText(""+cb1.getSelectedItem());
				}
			}
			catch(Exception e)
			{
				System.out.println("Error...");
			}
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
			Edit.requestFocus();
		}
		else if(ke.getSource()==Edit && ke.getKeyCode()==ke.VK_ENTER)
		{
				try
				{
					double getAmr=Double.valueOf(AMT.getText().trim());	
					SaveYAGInfo();
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,"Error !\n Please Input Only Number Type Value ","Message",JOptionPane.ERROR_MESSAGE);
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
			
			//	ZedInterface patientsd=(ZedInterface)Naming.lookup(getIPaddress.IP());
			
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
			
			
				String getCode=null;
			/*	String qry="Select YAG_techName from YAGlaser_feeDetail where YAG_techName='"+(""+cb1.getSelectedItem())+"'";
				String loadYAG=inf.getSingleValue(qry);*/
				
			
				String qry="Select YAG_code from YAGlaser_feeDetail where YAG_techName='"+(""+cb1.getSelectedItem())+"'";
				System.out.println("qry  "+qry);
				getCode=inf.getSingleValue(qry);
				System.out.println("getCode  "+getCode);
				
				if(getCode!=null)
				{
					
						
					
					int variable=JOptionPane.showConfirmDialog(this,"Message\nAre you sure to edit this item?","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
					if(variable==JOptionPane.YES_OPTION)
					{
					
								
					qry="Update YAGlaser_feeDetail set YAG_techName='"+YAGT.getText().trim()+"',YAG_charge="+Double.valueOf(AMT.getText())+" where YAG_code="+Integer.parseInt(getCode)+"";
					System.out.println("qry "+qry);
					inf.executeUpdateQuery(qry);
										
					javax.swing.JOptionPane.showMessageDialog(this,"Data Saved Successfuly","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
					cb1.removeAllItems();
					loadInitialInfo();
					YAGT.setText("");
					AMT.setText("");
					}
				}
				else
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error\nAlready exists","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					YAGT.requestFocus();
				}
				//	String qry="insert into drug_Master values('"+str1+"','"+str2+"','"+str3+"','"+str4+"')";
			/*	String	qry="insert into drug_Master values('"+categoryT.getText()+"','"+drugT.getText()+"','"+drugtypeT.getText()+"','"+strengthT.getText()+"')";
				boolean successful=inf.executeUpdateQuery(qry);
				//	System.out.println("successful"+successful);
				
				categoryT.setText(st);
				drugT.setText(st);
				drugtypeT.setText(st);
				strengthT.setText(st);*/
			}
			catch(Exception ex)
			{
				System.out.println("ERROR..IN SaveDrugInfo Method"+ex);
			}
	}
	private void loadInitialInfo()
	{
		
		ZedInterface inf=null;
		try
		{
			try
			{
				inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			}
			catch(Exception ex)
			{
				System.out.println("Error at the time of connection with server"+getIPaddress.IP()+ex);
				getIPaddress.changeIP();
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				}
				catch(Exception e)
				{
					System.out.println("Error at the time of connection with ip-rmi://127.0.0.1/ExtendedZedServer");
				}
			}
			
			String qry="Select YAG_techName from YAGlaser_feeDetail";
			String loadYAG[]=inf.getResultSetAs_1D_Array(qry);
			cb1.addItem("SELECT");
			if(loadYAG!=null)
			{
				for(int i=0;i<loadYAG.length;i++)
				{
					cb1.addItem(loadYAG[i]);
					System.out.println(i+" "+loadYAG[i]);
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error.......In loadInitailInfo Method");
		}
	}
	private void deleteYAG()
	{
		String getYAG=""+cb1.getSelectedItem();
		System.out.println("getYAG  "+getYAG);
		ZedInterface inf=null;
		try
		{
			try
			{
				inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			}
			catch(Exception e)
			{
				System.out.println("Error at the time of connection with server"+getIPaddress.IP());
				getIPaddress.changeIP();
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connection with ip-rmi://127.0.0.1/ExtendedZedServer"+ex);
				}
			}
			
		String getCode=null;	
	/*	String qry="Select YAG_techName from YAGlaser_feeDetail where YAG_techName='"+YAGT.getText().trim()+"'";
		String loadYAG=inf.getSingleValue(qry);*/
		String qry="Select YAG_code from YAGlaser_feeDetail where YAG_techName='"+YAGT.getText().trim()+"'";
		getCode=inf.getSingleValue(qry);
		System.out.println("getCode  "+getCode);
		if(getCode!=null)
		{
			
			int variable=JOptionPane.showConfirmDialog(this,"Message\nDo you want to delete this item?","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
			if(variable==JOptionPane.YES_OPTION)
			{
			
				qry="delete * from YAGlaser_feeDetail where YAG_code="+Double.valueOf(getCode)+"";
				inf.executeUpdateQuery(qry);
				javax.swing.JOptionPane.showMessageDialog(this,"Message\nItem deleted succesfully","Message",javax.swing.JOptionPane.INFORMATION_MESSAGE);
					cb1.removeAllItems();
					loadInitialInfo();
					YAGT.setText("");
					AMT.setText("");
					
			}
		
			
		}				
					
		}
		catch(Exception e)
		{
			System.out.println("Error ...In updateYAGInfo Method");
		}
	}

}