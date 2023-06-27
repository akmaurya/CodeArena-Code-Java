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
public class EditDoctorCategory extends JInternalFrame implements ActionListener,KeyListener,MouseListener
{
	JButton btn1,btn2,btn3;
	
	JTextField tf1;
	Container cn;
	JInternalFrame frm;
	DefaultTableModel dtm;
   	JTable tab1;
	JScrollPane jsp;
	ZedInterface inf=null;
	public EditDoctorCategory(JDesktopPane dp)
	{
		frm=new JInternalFrame("Edit Doctor Category ",false,true,false,true);
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
		
			
		ImageIcon i1=new ImageIcon("icons\\edit.gif");
		btn1=new JButton("Update",i1);
		btn1.setBounds(20,75,120,30);
		cn.add(btn1);
		
		ImageIcon i2=new ImageIcon("icons\\exit.gif");
		btn2=new JButton("Close",i2);
		btn2.setBounds(300,75,120,30);
		cn.add(btn2);
		
		ImageIcon i3=new ImageIcon("icons\\delete.gif");
		btn3=new JButton("Delete",i3);
		btn3.setBounds(160,75,120,30);
		cn.add(btn3);
		
		btn1.setMnemonic('U');
		btn2.setMnemonic('L');
		btn3.setMnemonic('D');
		
		tf1.setToolTipText("Please Select Any Category And Enter Doctor Category To Update/Delete With Selected Doctor");
		btn1.setToolTipText("Update");
		btn3.setToolTipText("Delete");
		btn2.setToolTipText("Close");
		
		String heading[]={"-: List Of Category :-"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
         tab1=new JTable(dtm);
         tab1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         jsp=new JScrollPane(tab1);
         jsp.setBounds(440,10, 280,100);
         cn.add(jsp);
         addingValueInJTable();
         
         tab1.setToolTipText("Select Any Category And Press->( DEL for DELETE ) ( Choose Update/Update Button ) To Update/Delete Doctor Category");
         
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
		
		frm.reshape(90,90,750,150);
	 	dp.add(frm);
	 	frm.setVisible(true);
	 	
	 
	 	tf1.addKeyListener(this);
	 	btn1.addKeyListener(this);
	 	btn2.addKeyListener(this);
	 	btn3.addKeyListener(this);
	 	
	 	btn1.addActionListener(this);
	 	btn2.addActionListener(this);
		btn3.addActionListener(this);
			
		//tab1.addActionListener(this);
		tab1.addKeyListener(this);
		tf1.requestFocus();
		tab1.addMouseListener(this);
	}
	
	public void keyPressed(KeyEvent ke)
    {
    		if(ke.getSource()==tf1 && ke.getKeyCode()==10)	
             {
                btn1.requestFocus();
             }		
    		else if(ke.getSource()==btn1 && ke.getKeyCode()==10)	
             {
                update();
             }		
             else if(ke.getSource()==btn2 && ke.getKeyCode()==10)	
             {
                frm.dispose();
             }
             else if(ke.getSource()==btn3 && ke.getKeyCode()==10)	
             {
                delete();
             }
             else if(ke.getSource()==tab1 && ke.getKeyCode()==KeyEvent.VK_DELETE)
             {
             	delete();
             }
             else if(ke.getSource()==tab1 && ke.getKeyCode()==10)
             {
             	ke.consume();
             	tf1.setText(""+tab1.getValueAt(tab1.getSelectedRow(),0));
             	tf1.requestFocus();
             	tf1.selectAll();
             	
             	//btn1.requestFocus();
             }
             
             
         }
     public void keyTyped(KeyEvent ke)	
       {
       }
     public void keyReleased(KeyEvent ke)
     {
       	if(ke.getSource()==tab1)
       	{
       		ke.consume();
            tf1.setText(""+tab1.getValueAt(tab1.getSelectedRow(),0));
       	}
       		
      }  
       
       public void mouseExited(MouseEvent me)  
       {}
       public void mouseEntered(MouseEvent me)  
       {}
       		
       public void mouseReleased(MouseEvent me)  
       {}
       
       public void mousePressed(MouseEvent me)  
       {}
       
       public void mouseClicked(MouseEvent me)  
       {
       		if(me.getSource()==tab1)
       		{
       			try
       			{
       				tf1.setText(""+tab1.getValueAt(tab1.getSelectedRow(),0));
       				tf1.selectAll();
       			}
       			catch(Exception e)
       			{
       				System.out.println("Error At mouse clicked1..."+e);
       			}
       		}
            
            
       }
       public void actionPerformed(ActionEvent ae)
       {
         	if(ae.getSource()==btn1)
          	{
          		update();
            }
            else if(ae.getSource()==btn2)	
             {
                frm.dispose();
             }
             else if(ae.getSource()==btn3)	
             {
                delete();
             }
        }  
     
     
    private boolean update()
    {
    	try
        {
        	if(tab1.getRowCount()>0)
        	{
        	int j= -1;
 		    j=tab1.getSelectedRow();
			if(j != -1)
			{
				//tf1.setText(""+tab1.getValueAt(tab1.getSelectedRow(),0));
				if(tf1.getText()==null || tf1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter New Doctor Category");  
                    tf1.requestFocus();
                    return false;
				}
				int res=JOptionPane.showConfirmDialog(this,"Are you sure about this updation?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            	if(res==JOptionPane.YES_OPTION)
            	{	
            		boolean flag=true;
            		String preProblem=""+tab1.getValueAt(tab1.getSelectedRow(),0);
             			flag=checkExistance();
             			if(flag)
             			{
             				
             				String c1=""+tf1.getText();
             				String c2=""+tab1.getValueAt(tab1.getSelectedRow(),0);
             				if(c1.equalsIgnoreCase(c2))
             				{
    						/*	ZedInterface obj=null;
       							try
       							{
       								obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       								obj.executeUpdateQuery("update drCategory set drCatName='"+tf1.getText()+"' where drCatName='"+preProblem+"'");
       							}
								catch(Exception ex)
      						 	{
       								 System.out.println("Error at save method..."+ex);
       							}*/
       							ZedInterface inf=null;
       							try
       							{
       									

										try
										{
												inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
										}
										catch(Exception e)
										{
											System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
											getIPaddress.changeIP();
												try
												{
														inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
														inf.executeUpdateQuery("update drCategory set drCatName='"+tf1.getText()+"' where drCatName='"+preProblem+"'");
												}
												catch(Exception ex)
												{
														System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
												}
										}	
       							}
       							catch(Exception ex)
       							{
       								System.out.println("Error at save method..."+ex);
       							}
             					JOptionPane.showMessageDialog(null,"Doctor Category Updated Successfully.");
             				}
             				else
             				{
             					JOptionPane.showMessageDialog(null,"Doctor Category is already existed..");  
                        		tf1.requestFocus();
                        		tf1.selectAll();
                        		return false; 
             				}
             			}
            			if(!flag)
            			{
            			//		ZedInterface obj=null;
       					/*		try
       							{
       								obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       								obj.executeUpdateQuery("update drCategory set drCatName='"+tf1.getText()+"' where drCatName='"+preProblem+"'");
       							}
								catch(Exception ex)
      						 	{
       								 System.out.println("Error at save method..."+ex);
       							}*/
       							
       						try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
							inf.executeUpdateQuery("update drCategory set drCatName='"+tf1.getText()+"' where drCatName='"+preProblem+"'");
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
										inf.executeUpdateQuery("update drCategory set drCatName='"+tf1.getText()+"' where drCatName='"+preProblem+"'");
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}		
       							
       							
             					JOptionPane.showMessageDialog(null,"Doctor Category Updated Successfully.");
            			}
					
    			}
    			addingValueInJTable();
    			tf1.setText("");
 			}
 			else
 			{
 				JOptionPane.showMessageDialog(null,"No Category Selected.\n Please Select A Category To Update");
                tab1.requestFocus();
                tab1.setRowSelectionInterval(0,0);
                return false;
 			}
 			}
 			else
      		{
      			JOptionPane.showMessageDialog(null,"No Category Found To Update/Delete");
      		}
 		}
 		catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       }
        
        tf1.requestFocus();
        tf1.selectAll();
        return true;
    }   
 	private boolean delete()
 	{
 		try
        {
        	if(tab1.getRowCount()>0)
        	{
        	int j= -1;
 		    j=tab1.getSelectedRow();
			if(j != -1)
			{
				tf1.setText(""+tab1.getValueAt(tab1.getSelectedRow(),0));
				int res=JOptionPane.showConfirmDialog(this,"Are you sure about this updation?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            	if(res==JOptionPane.YES_OPTION)
            	{	
				/*	ZedInterface obj=null;
       				try
       				{
       					obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       					obj.executeUpdateQuery("delete * from drCategory where drCatName='"+tf1.getText()+"'");
       				}
					catch(Exception ex)
      				{
       					System.out.println("Error at save method..."+ex);
       				}*/
       				
       				try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				inf.executeUpdateQuery("delete * from drCategory where drCatName='"+tf1.getText()+"'");
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
										inf.executeUpdateQuery("delete * from drCategory where drCatName='"+tf1.getText()+"'");	
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
       				
       				
       				
       				
       				
             		JOptionPane.showMessageDialog(null,"Doctor Category Deleted Successfully.");
    			}
    			addingValueInJTable();
    			tf1.setText("");
 			}
 			else
 			{
 				JOptionPane.showMessageDialog(null,"No Category Selected.\n Please Select Category To Delete");
                tab1.requestFocus();
                tab1.setRowSelectionInterval(0,0);
                return false;
 			}
 			}
 			else
      		{
      			JOptionPane.showMessageDialog(null,"No Doctor Category Found To Update/Delete");
      		}
 		}
 		catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       }
        
        tf1.requestFocus();
        tf1.selectAll();
        return true;
 	}
 	private void addingValueInJTable()
 	{
 		 //Adding Value in JTable(tab1)
       try
       {
       	while(tab1.getRowCount()>0)  dtm.removeRow(0);
       	String s[]=new String[1];
      /* 	ZedInterface obj=null;
       	try
       {
       		obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       }
		catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       }*/
       
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
	