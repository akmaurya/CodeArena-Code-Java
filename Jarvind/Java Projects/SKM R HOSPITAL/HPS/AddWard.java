import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.sql.*;
import java.rmi.*;
import java.util.*;
import java.rmi.registry.*;
import java.util.Date.*;
import javax.swing.table.*;
public class AddWard extends JInternalFrame implements ActionListener,KeyListener//,MouseListener
{
	JButton btn1,btn2,btn3;
	
	JTextField tf1,tf2;
	Container cn;
	JInternalFrame frm;
	DefaultTableModel dtm;
   	JTable tab1;
	JScrollPane jsp;
	
	public AddWard(JDesktopPane dp)
	{
		frm=new JInternalFrame("Add New Ward ",false,true,false,true);
		cn=frm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		JLabel lbl1,lbl2,lbl3,lbl4;
		Font fn1=new Font("Microsoft Sans Serif",Font.PLAIN,11);
		lbl1=new JLabel("Enter Ward Name");
		lbl1.setBounds(20,20,200,25);
		cn.add(lbl1);
		
	
		tf1=new JTextField();
		
		tf1.setBounds(170,20,250,25);
		cn.add(tf1);
		
		lbl2=new JLabel("Charge Per Bed (In Rs.)");
		lbl2.setBounds(20,60,200,25);
		cn.add(lbl2);
		
	
		tf2=new JTextField();
		tf2.setHorizontalAlignment(JTextField.RIGHT);
		tf2.setBounds(170,60,250,25);
		cn.add(tf2);
		
			
		ImageIcon i1=new ImageIcon("icons\\save.gif");
		btn1=new JButton("Save",i1);
		btn1.setBounds(10,125,120,30);
		cn.add(btn1);
		
		ImageIcon i3=new ImageIcon("icons\\reset.gif");
		btn3=new JButton("Refresh",i3);
		//btn3.setBounds(300,75,120,30);
		btn3.setBounds(140,125,120,30);
		cn.add(btn3);
		
		ImageIcon i2=new ImageIcon("icons\\exit.gif");
		btn2=new JButton("Close",i2);
		btn2.setBounds(270,125,120,30);
		cn.add(btn2);
		
		btn1.setMnemonic('S');
		btn2.setMnemonic('L');
		btn3.setMnemonic('R');
		tf1.setToolTipText("Please Enter Ward Name");
		btn1.setToolTipText("Save");
		btn2.setToolTipText("Close");
		btn3.setToolTipText("Refresh");
		
		String heading[]={"Ward Name","Charges Per Bed"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
         tab1=new JTable(dtm);
         jsp=new JScrollPane(tab1);
         jsp.setBounds(440,10, 280,150);
         cn.add(jsp);
         addingValueInJTable();
         
         
         DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
      		TableColumn column;
		
			column=tab1.getColumn("Ward Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(50);
       		column=tab1.getColumn("Charges Per Bed");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(30);
		tab1.setEnabled(false);
		frm.reshape(90,90,750,200);
	 	dp.add(frm);
	 	frm.setVisible(true);
	 	
	 
	 	tf1.addKeyListener(this);
	 	tf2.addKeyListener(this);
	 	btn1.addKeyListener(this);
	 	btn2.addKeyListener(this);
	 	btn3.addKeyListener(this);
	 	
	 	btn1.addActionListener(this);
	 	btn2.addActionListener(this);
	 	btn3.addActionListener(this);
			
		//tab1.addActionListener(this);
		//tab1.addKeyListener(this);
		tf1.requestFocus();
		//tab1.addMouseListener(this);
	}
	
	public void keyPressed(KeyEvent ke)
         {
         	boolean flag=true;
            
             if(ke.getSource()==tf1 && ke.getKeyCode()==10)	
             {
               tf2.requestFocus();  
             }
             if(ke.getSource()==tf2 && ke.getKeyCode()==10)	
             {
               btn1.requestFocus();  
             }
             else if(ke.getSource()==btn1 && ke.getKeyCode()==10)	
             {
             	
                save();
             }   
            else if(ke.getSource()==btn3 && ke.getKeyCode()==10)	
             {
             	
               reset();
             }   
             else if(ke.getSource()==btn2 && ke.getKeyCode()==10)	
             {
                frm.dispose();
             }
             else if(ke.getSource()==btn2 && ke.getKeyCode()=='L')	
             {
                frm.dispose();
             }
         }
     public void keyTyped(KeyEvent ke)	
       {
       }
     public void keyReleased(KeyEvent ke)
     {
       		
      }  
       
       public void actionPerformed(ActionEvent ae)
       {
         if(ae.getSource()==btn1)
          {
          		save();
          }
            else if(ae.getSource()==btn2)	
             {
                frm.dispose();
             }
             else if(ae.getSource()==btn3)	
             {
                reset();
             }
        }  
     private void reset()
    {
    	tf1.setText("");
    	tf2.setText("");
    }     
 	private void save()
 	{
 				try
             	{
             		if(tf1.getText().trim().equals(""))
             		{
             			JOptionPane.showMessageDialog(null,"Please Enter Ward Name");  
                        tf1.requestFocus(); 
             		}
             		else if(tf2.getText().trim().equals(""))
             		{
             			JOptionPane.showMessageDialog(null,"Please Enter Charges");  
                        tf2.requestFocus(); 
             		}
             		else if(checkFeeValidation())
             		{
             			
             			boolean flag=checkExistance();
             			
             		
             			if(flag)
             			{
             				JOptionPane.showMessageDialog(null,"Ward is already existed..");  
                       		 tf1.requestFocus(); 
                        	 tf1.selectAll();
             			}
             			if(!flag)
             			{
             				ZedInterface inf=null;
       						try
       						{
       						//	obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       						
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
       						
       						
       						
       							int cat_Code=inf.getMaxValue("select max(wardCatCode) from wardCategory");
       							cat_Code+=1;
       							inf.executeUpdateQuery("insert into wardCategory values("+cat_Code+",'"+tf1.getText()+"','"+tf2.getText()+"')");
       						}
							catch(Exception ex)
      						 {
       							 System.out.println("Error at save method..."+ex);
       						}
             			
             				JOptionPane.showMessageDialog(null,"New Ward Created Successfully.");
             			
             				addingValueInJTable();
             				tf1.setText("");
             				tf2.setText("");
             				tf1.requestFocus();
             			}
             		}
             	 }
             	 catch(Exception x)
                 {
                    System.out.println(""+x);
                 }
 	}
 	private void addingValueInJTable()
 	{
 		 //Adding Value in JTable(tab1)
       try
       {
       	while(tab1.getRowCount()>0)  dtm.removeRow(0);
       	ZedInterface inf=null;
       	try
       {
       		//obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       		
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
		catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       }
     String str[][]=inf.getResultSetAs_2D_Array("select wardCatName,wardCatCharge from wardCategory order by wardCatName",2);
       for(int i=0;i<str.length;i++)
       {
       		dtm.addRow(str[i]);
       }
       
		//---------end--------
		
		}
	catch(Exception ex)
       {
       	 System.out.println("Error1122.1..."+ex);
       }
       
 	}
 	
 	private boolean checkExistance()
 	{
 		for(int i=0;i<tab1.getRowCount();i++)
 		{
 			if((""+tab1.getValueAt(i,0)).equalsIgnoreCase(tf1.getText().trim()))
 			{
 				return true;
 			}
 		}
 		return false;
 	}
 	private boolean checkFeeValidation()
 	{
 		try
 		{
 			int a=Integer.parseInt(tf2.getText().trim());
 			return true;
 		}
 		catch(Exception e)
 		{
 			//System.out.println("Please ");
 			JOptionPane.showMessageDialog(null,"Please Input Valid Bed Charge (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);
 			tf2.requestFocus();
 			tf2.selectAll();
 			return false;
 		}
 	}
}
	