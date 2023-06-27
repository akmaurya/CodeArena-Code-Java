import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.rmi.*;
import java.rmi.registry.*;

class drugMaster extends JDialog implements ActionListener,KeyListener
{
	Container cn;
//	JDialog DG;
//	JLabel categoryL,drugL,drugtypeL,strengthL;
	JTextField categoryT,drugT,drugtypeT,strengthT;
	JButton Save,Close;
//	String temparr[]=null;
	String setip,st="";
	ZedInterface inf=null;
	public drugMaster()
	{
		
		Font fntdialog=new Font("Arial Narrow",Font.BOLD,14);
		cn=getContentPane();
		cn.setLayout(null);
 		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
	
	//	System.out.println("right");
	    setTitle("DRUG MASTER WINDOW");
		JLabel categoryL=new JLabel("Category");
		categoryL.setOpaque(false);
		categoryL.setBounds(10,20,90,20);
		categoryL.setFont(fntdialog);
		categoryT=new JTextField();
		categoryT.setBounds(110,20,140,20);
		
		JLabel drugL=new JLabel("Drug");
		drugL.setOpaque(false);
		drugL.setBounds(10,60,90,20);
		drugL.setFont(fntdialog);
		drugT=new JTextField();
		drugT.setBounds(110,60,140,20);
		
		JLabel drugtypeL=new JLabel("DrugType");
		drugtypeL.setOpaque(false);
		drugtypeL.setBounds(10,100,90,20);
		drugtypeL.setFont(fntdialog);
		drugtypeT=new JTextField();
		drugtypeT.setBounds(110,100,140,20);
		
		JLabel strengthL=new JLabel("Strenth");
		strengthL.setOpaque(false);
		strengthL.setBounds(10,140,90,20);
		strengthL.setFont(fntdialog);
		strengthT=new JTextField();
		strengthT.setBounds(110,140,140,20);
		
		
		Save=new JButton("Save",new ImageIcon ("icons\\save.gif"));
		Save.setMnemonic('s');
		Save.setBounds(10,200,130,30);
		Save.setToolTipText("Save");
		
		
		Close=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		Close.setMnemonic('c');
		Close.setBounds(150,200,130,30);
		Close.setToolTipText("Close");
		
		cn.add(categoryL);
		cn.add(categoryT);
		cn.add(drugL);
		cn.add(drugT);
		cn.add(drugtypeL);
		cn.add(drugtypeT);
		cn.add(strengthL);
		cn.add(strengthT);
		cn.add(Save);
		cn.add(Close);
		
		Save.addActionListener(this);
		Close.addActionListener(this);
		
		categoryT.addKeyListener(this);
		drugT.addKeyListener(this);
		drugtypeT.addKeyListener(this);
		strengthT.addKeyListener(this);
		
		categoryT.requestFocus();
		
	//	setip=getIPaddress.IP();
	//	System.out.println("setip "+setip);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==Save)
		{
		
			if((categoryT.getText().equals(st))||(drugT.getText().equals(st))||(drugtypeT.getText().equals(st))||(strengthT.getText().equals(st)))
			{
				JOptionPane.showMessageDialog(this,"Must Fill All The Fields","Message",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				SaveDrugInfo();
			
			}
		}
		else if(ae.getSource()==Close)
		{
			this.dispose();
		}
	}
	
	public void keyPressed(KeyEvent ke)
	{
		if(ke.getSource()==categoryT && ke.getKeyCode()==ke.VK_ENTER)
		{
			drugT.requestFocus();
		}
		else if(ke.getSource()==drugT && ke.getKeyCode()==ke.VK_ENTER)
		{
			drugtypeT.requestFocus();
		}
		else if(ke.getSource()==drugtypeT && ke.getKeyCode()==ke.VK_ENTER)
		{
			strengthT.requestFocus();
		}
		else if(ke.getSource()==strengthT && ke.getKeyCode()==ke.VK_ENTER)
		{
			Save.requestFocus();
		}

	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}
	private void SaveDrugInfo()
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
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
			
			
			
				//	String qry="insert into drug_Master values('"+str1+"','"+str2+"','"+str3+"','"+str4+"')";
				String	qry="insert into drug_Master values('"+categoryT.getText()+"','"+drugT.getText()+"','"+drugtypeT.getText()+"','"+strengthT.getText()+"')";
				boolean successful=inf.executeUpdateQuery(qry);
				//	System.out.println("successful"+successful);
				
				categoryT.setText(st);
				drugT.setText(st);
				drugtypeT.setText(st);
				strengthT.setText(st);
			}
			catch(Exception ex)
			{
				System.out.println("ERROR..IN SaveDrugInfo Method"+ex);
			}
	}
	
}