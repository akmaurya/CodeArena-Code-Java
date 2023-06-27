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
public class AddDoctorCategory extends JInternalFrame implements ActionListener,KeyListener//,MouseListener
{
	JButton btn1,btn2,btn3;
	
	JTextField tf1;
	Container cn;
	JInternalFrame frm;
	DefaultTableModel dtm;
   	JTable tab1;
	JScrollPane jsp;
	
	public AddDoctorCategory(JDesktopPane dp)
	{
		frm=new JInternalFrame("Add New Doctor Category ",false,true,false,true);
		cn=frm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		JLabel lbl1,lbl2,lbl3,lbl4;
		Font fn1=new Font("Microsoft Sans Serif",Font.PLAIN,11);
		lbl1=new JLabel("Enter Doctor Category");
	//	lbl1.setForeground(new Color(236,233,216));
	//	lbl1.setFont(fn1);
		lbl1.setBounds(20,20,200,25);
		cn.add(lbl1);
		
	
		tf1=new JTextField();
		
		tf1.setBounds(170,20,250,25);
		cn.add(tf1);
		
			
		ImageIcon i1=new ImageIcon("icons\\save.gif");
		btn1=new JButton("Save",i1);
		//btn1.setBounds(160,75,120,30);
		btn1.setBounds(10,75,120,30);
		cn.add(btn1);
		
		ImageIcon i3=new ImageIcon("icons\\reset.gif");
		btn3=new JButton("Refresh",i3);
		//btn3.setBounds(300,75,120,30);
		btn3.setBounds(140,75,120,30);
		cn.add(btn3);
		
		ImageIcon i2=new ImageIcon("icons\\exit.gif");
		btn2=new JButton("Close",i2);
		//btn2.setBounds(300,75,120,30);
		btn2.setBounds(270,75,120,30);
		cn.add(btn2);
		
		
		
		btn1.setMnemonic('S');
		btn2.setMnemonic('L');
		btn3.setMnemonic('R');
		
		tf1.setToolTipText("Please Enter Doctor Category Name");
		btn1.setToolTipText("Save");
		btn2.setToolTipText("Close");
		btn3.setToolTipText("Refresh");
		
		String heading[]={"-: List Of Category :-"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
         tab1=new JTable(dtm);
         jsp=new JScrollPane(tab1);
         jsp.setBounds(440,10, 280,100);
         cn.add(jsp);
         addingValueInJTable();
         
         
         DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
      		TableColumn column;
		
			column=tab1.getColumn("-: List Of Category :-");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(40);
		tab1.setEnabled(false);
		frm.reshape(90,90,750,150);
	 	dp.add(frm);
	 	frm.setVisible(true);
	 	
	 
	 	tf1.addKeyListener(this);
	 	btn1.addKeyListener(this);
	 	btn2.addKeyListener(this);
	 	btn3.addKeyListener(this);
	 	
	 	btn1.addActionListener(this);
	 	btn3.addActionListener(this);
	 	btn2.addActionListener(this);
			
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
               btn1.requestFocus();  
             }
             else if(ke.getSource()==btn1 && ke.getKeyCode()==10)	
             {
             	
                save();
             }   
            
             else if(ke.getSource()==btn2 && ke.getKeyCode()==10)	
             {
                frm.dispose();
             }
             else if(ke.getSource()==btn3 && ke.getKeyCode()==10)	
             {
                reset();
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
    	
    }    
 	private void save()
 	{
 				try
             	{
             		if(tf1.getText().equals(""))
             		{
             			JOptionPane.showMessageDialog(null,"Please Enter Doctor Category");  
                        tf1.requestFocus(); 
             		}
             		else
             		{
             			
             			boolean flag=checkExistance();
             			
             		
             			if(flag)
             			{
             				JOptionPane.showMessageDialog(null,"Doctor Category is already existed..");  
                       		 tf1.requestFocus(); 
                        	 tf1.selectAll();
             			}
             			if(!flag)
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
       							//obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       							int cat_Code=inf.getMaxValue("select max(drCatCode) from drCategory");
       							cat_Code+=1;
       							inf.executeUpdateQuery("insert into drCategory values("+cat_Code+",'"+tf1.getText()+"')");
       						}
							catch(Exception ex)
      						 {
       							 System.out.println("Error at save method..."+ex);
       						}
             			
             				JOptionPane.showMessageDialog(null,"New Doctor Category Created Successfully.");
             			
             				addingValueInJTable();
             				tf1.setText("");
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
       	String s[]=new String[1];
       	ZedInterface inf=null;
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
     String str[]=inf.getResultSetAs_1D_Array("select drCatName from drCategory");
       for(int i=0;i<str.length;i++)
       {
       		s[0]=str[i];
       		dtm.addRow(s);
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
}
	