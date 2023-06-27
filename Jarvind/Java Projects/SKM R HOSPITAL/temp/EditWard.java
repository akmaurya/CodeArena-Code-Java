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
public class EditWard implements ActionListener,KeyListener,MouseListener
{
	JButton btn1,btn2,btn3;
	
	JTextField tf1,tf2;
	Container cn;
	JInternalFrame frm;
	DefaultTableModel dtm;
   	JTable tab1;
	JScrollPane jsp;
	ZedInterface inf;
	public EditWard(JDesktopPane dp)
	{
		frm=new JInternalFrame("Edit Ward ",false,true,false,true);
		cn=frm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		JLabel lbl1,lbl2,lbl3,lbl4;
		Font fn1=new Font("Microsoft Sans Serif",Font.PLAIN,11);
		lbl1=new JLabel("Enter Ward Name");
	//	lbl1.setForeground(new Color(236,233,216));
	//	lbl1.setFont(fn1);
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
			
		ImageIcon i1=new ImageIcon("icons\\edit.gif");
		btn1=new JButton("Update",i1);
		btn1.setBounds(20,125,120,30);
		cn.add(btn1);
		
		ImageIcon i2=new ImageIcon("icons\\exit.gif");
		btn2=new JButton("Close",i2);
		btn2.setBounds(300,125,120,30);
		cn.add(btn2);
		
		ImageIcon i3=new ImageIcon("icons\\delete.gif");
		btn3=new JButton("Delete",i3);
		btn3.setBounds(160,125,120,30);
		cn.add(btn3);
		
		btn1.setMnemonic('U');
		btn2.setMnemonic('L');
		btn3.setMnemonic('D');
		
		tf1.setToolTipText("Please Select Any Ward And Enter Ward Name To Update/Delete With Selected Ward");
		btn1.setToolTipText("Update");
		btn3.setToolTipText("Delete");
		btn2.setToolTipText("Close");
		
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
		//tab1.setEnabled(false);
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
		tab1.addKeyListener(this);
		tf1.requestFocus();
		tab1.addMouseListener(this);
	}
	
	public void keyPressed(KeyEvent ke)
    {
    		if(ke.getSource()==tf1 && ke.getKeyCode()==10)	
             {
                tf2.requestFocus();
             }	
             else if(ke.getSource()==tf2 && ke.getKeyCode()==10)	
             {
                btn1.requestFocus();
             }		
    		else if(ke.getSource()==btn1 && ke.getKeyCode()==10)	
             {
                update();
             }		
             else if(ke.getSource()==btn2 && ke.getKeyCode()==10)	
             {
             	//System.out.println("in");
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
            tf2.setText(""+tab1.getValueAt(tab1.getSelectedRow(),1));
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
       				tf2.setText(""+tab1.getValueAt(tab1.getSelectedRow(),1));
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
             	//System.out.println("in");
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
				if(tf1.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter New Ward Name");  
                    tf1.requestFocus();
                    return false;
				}
				else if(tf2.getText().trim().equals(""))
             	{
             		JOptionPane.showMessageDialog(null,"Please Enter Charges");  
                    tf2.requestFocus();
                    return false;
             	}
             	boolean isValid=checkFeeValidation();
             	if(isValid==false)
             	{
             		return false;
             	}
				int res=JOptionPane.showConfirmDialog(null,"Are you sure about this updation?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
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
       								obj.executeUpdateQuery("update wardCategory set wardCatName='"+tf1.getText()+"',wardCatCharge="+Integer.parseInt(tf2.getText())+" where wardCatName='"+preProblem+"'");
       							}
								catch(Exception ex)
      						 	{
       								 System.out.println("Error at save method..."+ex);
       							}*/
       							
       							
       							
       	try
		{
			inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			inf.executeUpdateQuery("update wardCategory set wardCatName='"+tf1.getText()+"',wardCatCharge="+Integer.parseInt(tf2.getText())+" where wardCatName='"+preProblem+"'");
		}
		catch(Exception e)
		{
				System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
				getIPaddress.changeIP();
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
					inf.executeUpdateQuery("update wardCategory set wardCatName='"+tf1.getText()+"',wardCatCharge="+Integer.parseInt(tf2.getText())+" where wardCatName='"+preProblem+"'");
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
				}
		}
             					JOptionPane.showMessageDialog(null,"Ward Updated Successfully.");
             				}
             				else
             				{
             					JOptionPane.showMessageDialog(null,"Ward is already existed..");  
                        		tf1.requestFocus();
                        		tf1.selectAll();
                        		return false; 
             				}
             			}
            			if(!flag)
            			{
            				/*	ZedInterface obj=null;
       							try
       							{
       								obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       								obj.executeUpdateQuery("update wardCategory set wardCatName='"+tf1.getText()+"',wardCatCharge="+Integer.parseInt(tf2.getText())+" where wardCatName='"+preProblem+"'");
       							}
								catch(Exception ex)
      						 	{
       								 System.out.println("Error at save method..."+ex);
       							}*/
       							
       							try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
					inf.executeUpdateQuery("update wardCategory set wardCatName='"+tf1.getText()+"',wardCatCharge="+Integer.parseInt(tf2.getText())+" where wardCatName='"+preProblem+"'");
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
									inf.executeUpdateQuery("update wardCategory set wardCatName='"+tf1.getText()+"',wardCatCharge="+Integer.parseInt(tf2.getText())+" where wardCatName='"+preProblem+"'");		
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
       							
       							
             					JOptionPane.showMessageDialog(null,"Ward Updated Successfully.");
            			}
					
    			}
    			addingValueInJTable();
    			tf1.setText("");
    			tf2.setText("");
 			}
 			else
 			{
 				JOptionPane.showMessageDialog(null,"No Ward Selected.\n Please Select Any Ward To Update");
                tab1.requestFocus();
                tab1.setRowSelectionInterval(0,0);
                return false;
 			}
 			}
 			else
      		{
      			JOptionPane.showMessageDialog(null,"No Ward Found To Update/Delete");
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
				tf2.setText(""+tab1.getValueAt(tab1.getSelectedRow(),1));
				int res=JOptionPane.showConfirmDialog(null,"Are you sure about this updation?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            	if(res==JOptionPane.YES_OPTION)
            	{	
					//ZedInterface obj=null;
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
       				
       				
       					String wardCode=inf.getSingleValue("select wardCatCode from wardCategory where wardCatName='"+tf1.getText()+"'");
       					inf.executeUpdateQuery("delete * from wardCategory where wardCatName='"+tf1.getText()+"'");
       					String room[]=inf.getResultSetAs_1D_Array("select roomNo from roomDetails where wardCatCode="+wardCode+"");
       					for(int i=0;i<room.length;i++)
       					{
       						int roomno=Integer.parseInt(room[i]);
       						String query="delete *from roomDetails where roomNo="+roomno;
       						inf.executeUpdateQuery(query);
       						query="delete *from bedDetails where roomNo="+roomno;
       						inf.executeUpdateQuery(query);
       					}
       				}
					catch(Exception ex)
      				{
       					System.out.println("Error at save method..."+ex);
       				}
             		JOptionPane.showMessageDialog(null,"Ward Deleted Successfully.");
    			}
    			addingValueInJTable();
    			tf1.setText("");
    			tf2.setText("");
 			}
 			else
 			{
 				JOptionPane.showMessageDialog(null,"No Ward Selected.\n Please Select Ward To Delete");
                tab1.requestFocus();
                tab1.setRowSelectionInterval(0,0);
                return false;
 			}
 			}
 			else
      		{
      			JOptionPane.showMessageDialog(null,"No Ward Found To Update/Delete");
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
       //	ZedInterface obj=null;
      /* 	try
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
	