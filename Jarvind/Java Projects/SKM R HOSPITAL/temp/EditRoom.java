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
public class EditRoom extends JInternalFrame implements ActionListener,KeyListener,MouseListener
{
	JButton btn1,btn2,btn3;
	JComboBox cb1;
	JTextField tf1,tf2;
	Container cn;
	JInternalFrame frm;
	DefaultTableModel dtm;
   	JTable tab1;
	JScrollPane jsp;
	String str[]=null;
	int initroom=0,lastroom=0;
	ZedInterface inf=null;
	
	public EditRoom(JDesktopPane dp)
	{
		frm=new JInternalFrame("Add Room",false,true,false,true);
		cn=frm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
		Font fn1=new Font("Microsoft Sans Serif",Font.PLAIN,11);
		
		
		
		lbl1=new JLabel("Select Ward");
	//	lbl1.setForeground(new Color(236,233,216));
	//	lbl1.setFont(fn1);
		lbl1.setBounds(20,20,200,25);
		cn.add(lbl1);
		
		cb1=new JComboBox();
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
		try
		{
			
     String str[]=inf.getResultSetAs_1D_Array("select wardCatName from wardCategory");
       for(int i=0;i<str.length;i++)
       {
       		cb1.addItem(str[i]);
       }
		cb1.setBounds(150,20,250,25);
		cn.add(cb1);
		
		}
	catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       }
		
		lbl2=new JLabel("Enter Room No.");
	//	lbl1.setForeground(new Color(236,233,216));
	//	lbl1.setFont(fn1);
		lbl2.setBounds(20,75,200,25);
		cn.add(lbl2);
		
		lbl5=new JLabel("From");
		lbl5.setFont(new Font("Times New Roman",Font.PLAIN,12));
		lbl5.setBounds(150,60,115,15);
		cn.add(lbl5);
			
		tf1=new JTextField();
		tf1.setHorizontalAlignment(JTextField.RIGHT);
		tf1.setBounds(150,75,115,25);
		cn.add(tf1);
		
		
		lbl6=new JLabel("To");
		lbl6.setFont(new Font("Times New Roman",Font.PLAIN,12));
		lbl6.setBounds(285,60,115,15);
		cn.add(lbl6);
		tf2=new JTextField();
		tf2.setHorizontalAlignment(JTextField.RIGHT);
		tf2.setBounds(285,75,115,25);
		cn.add(tf2);
		
		ImageIcon i1=new ImageIcon("icons\\edit.gif");
		btn1=new JButton("Update",i1);
		//btn1.setBounds(20,125,120,30);
		btn1.setBounds(160,125,120,30);
		cn.add(btn1);
		
		ImageIcon i2=new ImageIcon("icons\\exit.gif");
		btn2=new JButton("Close",i2);
		btn2.setBounds(300,125,120,30);
		cn.add(btn2);
		
		ImageIcon i3=new ImageIcon("icons\\delete.gif");
		btn3=new JButton("Delete",i3);
		btn3.setBounds(160,125,120,30);
		//cn.add(btn3);
		
		btn1.setMnemonic('S');
		btn2.setMnemonic('L');
		btn3.setMnemonic('D');
		
		tf1.setToolTipText("Please Enter Starting Room No.");
		tf2.setToolTipText("Please Enter Ending Room No.");
		btn1.setToolTipText("Save");
		btn3.setToolTipText("Delete");
		btn2.setToolTipText("Close");
		
		cb1.setToolTipText("Please Select Ward");
		
		String heading[]={"-: List Of Rooms :-"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
         tab1=new JTable(dtm);
         tab1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         jsp=new JScrollPane(tab1);
         jsp.setBounds(440,10, 280,150);
         cn.add(jsp);
        addingValueInJTable();
       //  tab1.setEnabled(false);
         tab1.setToolTipText("Select Any Row And Press->( DEL for DELETE ) ( Choose Update/Update Button ) To Update/Delete Item");
         
         DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
      		TableColumn column;
		
			column=tab1.getColumn("-: List Of Rooms :-");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(40);			
		
		
		frm.reshape(90,90,750,200);
	 	dp.add(frm);
	 	frm.setVisible(true);
	 	
	 	
	 	tf1.addKeyListener(this);
	 	tf2.addKeyListener(this);
	 	btn1.addKeyListener(this);
	 	btn2.addKeyListener(this);
	 	btn3.addKeyListener(this);
	 	cb1.addKeyListener(this);
	 	tab1.addMouseListener(this);
	 	tab1.addKeyListener(this);
	 	
	 	btn1.addActionListener(this);
	 	btn2.addActionListener(this);
		btn3.addActionListener(this);
		cb1.addActionListener(this);
		
		cb1.requestFocus();
		//tab1.requestFocus();
        //tab1.setRowSelectionInterval(0,0);	
	}
	
	public void keyPressed(KeyEvent ke)
         {
         	boolean flag=true;
            
             if(ke.getSource()==cb1 && ke.getKeyCode()==10)	
             {
             	tf1.requestFocus();
             	tf1.selectAll(); 
             }
             else if(ke.getSource()==tf1 && ke.getKeyCode()==10)	
             {
               tf2.requestFocus();  
               tf2.selectAll();
             }
             else if(ke.getSource()==tf2 && ke.getKeyCode()==10)	
             {
               btn1.requestFocus();  
             }
             else if(ke.getSource()==btn1 && ke.getKeyCode()==10)	
             {
             	update();
                
             }
             else if(ke.getSource()==btn3 && ke.getKeyCode()==10)	
             {
                delete();
             }
             else if(ke.getSource()==btn2 && ke.getKeyCode()==10)	
             {
                frm.dispose();
             }
             else if(ke.getSource()==tab1 && ke.getKeyCode()==10)
             {
             	ke.consume();
             	String val=""+tab1.getValueAt(tab1.getSelectedRow(),0);
       				
       				String v[]=val.split("No.");
       				//System.out.println(""+v[0]);
       				//System.out.println(""+v[1]);
       				String init=v[1].substring(v[1].indexOf(" ")+1,v[1].indexOf("To")-1);
       				String sec=v[2].substring(v[2].indexOf(" ")+1,v[2].length());
       				initroom=Integer.parseInt(init);
       				lastroom=Integer.parseInt(sec);
       				tf1.setText(""+initroom);
       				tf2.setText(""+lastroom);
       			//	System.out.println(tf1.getText().length());
       			//	System.out.println(tf2.getText().length());
    				tf1.requestFocus();   	
       				tf1.selectAll();
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
           	 	String val=""+tab1.getValueAt(tab1.getSelectedRow(),0);
       				
       				String v[]=val.split("No.");
       				//System.out.println(""+v[0]);
       				//System.out.println(""+v[1]);
       				String init=v[1].substring(v[1].indexOf(" ")+1,v[1].indexOf("To")-1);
       				String sec=v[2].substring(v[2].indexOf(" ")+1,v[2].length());
       				initroom=Integer.parseInt(init);
       				lastroom=Integer.parseInt(sec);
       				tf1.setText(""+initroom);
       				tf2.setText(""+lastroom);
       			//	System.out.println(tf1.getText().length());
       			//	System.out.println(tf2.getText().length());
    			//	tf1.requestFocus();   	
       			//	tf1.selectAll();
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
       				String val=""+tab1.getValueAt(tab1.getSelectedRow(),0);
       				
       				String v[]=val.split("No.");
       				//System.out.println(""+v[0]);
       				//System.out.println(""+v[1]);
       				String init=v[1].substring(v[1].indexOf(" ")+1,v[1].indexOf("To")-1);
       				String sec=v[2].substring(v[2].indexOf(" ")+1,v[2].length());
       				initroom=Integer.parseInt(init);
       				lastroom=Integer.parseInt(sec);
       			//	System.out.println(""+initroom+" "+lastroom);
       				tf1.setText(""+initroom);
       				tf2.setText(""+lastroom);
       			//	System.out.println(tf1.getText().length());
       			//	System.out.println(tf2.getText().length());
    				//tf1.requestFocus();   	
       				//tf1.selectAll();
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
             else if(ae.getSource()==cb1)	
             {
                addingValueInJTable();
                tf1.setText("");
                tf2.setText("");
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
					if(tf1.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Enter Starting Room No.","Error !!",JOptionPane.ERROR_MESSAGE);
                    	tf1.requestFocus();
                    	return false;
					}
					else if(tf2.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,"Please Enter Ending Room No.","Error !!",JOptionPane.ERROR_MESSAGE);
                    	tf2.requestFocus();
                    	return false;
					}
					else
					{
						boolean checkRoomNo=checkRoomValidation(tf1.getText());
						if(checkRoomNo==false)
						{
							return false;
						}
						checkRoomNo=checkRoomValidation(tf2.getText());
						if(checkRoomNo==false)
						{
							return false;
						}
						int f=Integer.parseInt(tf1.getText());
						int s=Integer.parseInt(tf2.getText());
						if(f>s)
						{
							JOptionPane.showMessageDialog(null,"Please Enter Ending Room No. Which Is Greater Than Or Equal To Staring Room No.","Error !!",JOptionPane.ERROR_MESSAGE);
                    		tf2.requestFocus();
                    		return false;
						}
						checkRoomNo=checkRoomExistance();
						if(checkRoomNo==false)
						{
							JOptionPane.showMessageDialog(null,"Room No. Existed Before.\nPlease Input Valid Room No. (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);
							tf2.requestFocus();
							tf2.selectAll();
							return false;
						}
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
     					int wardID=Integer.parseInt(inf.getSingleValue("select wardCatCode from wardCategory where wardCatName='"+(""+cb1.getSelectedItem())+"'"));
     					//delete from roomDetails---
     
     					for(int i=initroom;i<=lastroom;i++)
     					{
     						String query="delete * from roomDetails where roomNo=";
     						query+=i;
     						//System.out.println(""+query);
     						inf.executeUpdateQuery(query);
     					}
     					//inerting values into roomDetails----
     					for(int initRoom=(Integer.parseInt(tf1.getText()));initRoom<=(Integer.parseInt(tf2.getText()));initRoom++)
     						inf.executeUpdateQuery("insert into roomDetails values("+wardID+","+initRoom+")");
						JOptionPane.showMessageDialog(null,"Room Updated Successfully");
						addingValueInJTable();
					//	System.out.println("ok");
					}	
				}
 				else
 				{
 					JOptionPane.showMessageDialog(null,"No Room Selected.\n Please Select Room To Update");
             	   tab1.requestFocus();
             	   tab1.setRowSelectionInterval(0,0);
           	       return false;
 				}
 			}
 			else
      		{
      			JOptionPane.showMessageDialog(null,"No Room Found To Update/Delete");
      		}

		}		
 		catch(Exception ex)
       	{
       	 	System.out.println("Error.1..."+ex);
       	}
       return true;
    }
    private boolean checkRoomValidation(String roomNo)
 	{
 		try
 		{
 			int a=Integer.parseInt(roomNo.trim());
 			return true;
 		}
 		catch(Exception e)
 		{
 			//System.out.println("Please ");
 			JOptionPane.showMessageDialog(null,"Please Input Valid Room No. (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);
 			tf2.requestFocus();
 			tf2.selectAll();
 			return false;
 		}
 	} 
 	private boolean checkRoomExistance()
 	{
 		int fRoom=Integer.parseInt(tf1.getText());
 		int lRoom=Integer.parseInt(tf2.getText());
 		if(((initroom==fRoom) && (lastroom==lRoom) )||((initroom==fRoom) && (lastroom>lRoom)))
 		{
 			//System.out.println("aaa");
 			return true;
 		}
 	/*	ZedInterface inf=null;
       	try
        {
       		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			str=inf.getResultSetAs_1D_Array("select roomNo from roomDetails order by roomNo asc");
		}
		catch(Exception ex)
       	{
       	 	System.out.println("Error.1..."+ex);
       	}*/
       	try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				str=inf.getResultSetAs_1D_Array("select roomNo from roomDetails order by roomNo asc");
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
										str=inf.getResultSetAs_1D_Array("select roomNo from roomDetails order by roomNo asc");	
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
       	
       	
       	
       	
       	
 		for(int i=0;i<str.length;i++)
 		{
 			for(int initRoom=(Integer.parseInt(tf1.getText()));initRoom<=(Integer.parseInt(tf2.getText()));initRoom++)
 			{
 				if(initRoom==(Integer.parseInt(str[i])))
 				{
 					if(initRoom==(Integer.parseInt(tf1.getText()))|| initRoom<=lastroom)
 					{
 						//System.out.println("a");
 					}
 					else
 					{
 						System.out.println("initroom="+initRoom+"   "+str[i]);
 						return false;
 					}
 				}
 			}
 		}
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
				String val=""+tab1.getValueAt(tab1.getSelectedRow(),0);
       				
       				String v[]=val.split("No.");
       				//System.out.println(""+v[0]);
       				//System.out.println(""+v[1]);
       				String init=v[1].substring(v[1].indexOf(" ")+1,v[1].indexOf("To")-1);
       				String sec=v[2].substring(v[2].indexOf(" ")+1,v[2].length());
       				initroom=Integer.parseInt(init);
       				lastroom=Integer.parseInt(sec);
       			//	System.out.println(""+initroom+" "+lastroom);
       				tf1.setText(""+initroom);
       				tf2.setText(""+lastroom);
				int res=JOptionPane.showConfirmDialog(null,"Are you sure about this updation?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            	if(res==JOptionPane.YES_OPTION)
            	{	
				//	ZedInterface inf=null;
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
       					for(int i=initroom;i<=lastroom;i++)
     					{
     						String query="delete * from roomDetails where roomNo=";
     						query+=i;
     						//System.out.println(""+query);
     						inf.executeUpdateQuery(query);
     					}
       				}
					catch(Exception ex)
      				{
       					System.out.println("Error at save method..."+ex);
       				}
             		JOptionPane.showMessageDialog(null,"Room Deleted Successfully.");
    			}
    			addingValueInJTable();
 			}
 			else
 			{
 				JOptionPane.showMessageDialog(null,"No Room Selected.\n Please Select Room No. To Delete");
                tab1.requestFocus();
                tab1.setRowSelectionInterval(0,0);
                return false;
 			}
 			}
 			else
      		{
      			JOptionPane.showMessageDialog(null,"No Room Found To Update/Delete");
      		}
 		}
 		catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       }
        
        cb1.requestFocus();
       // tf1.selectAll();
        return true;
 	}

 	private void addingValueInJTable()
 	{
 	try
       {
       	tf1.setText("");
    	tf2.setText("");
       	while(tab1.getRowCount()>0)  dtm.removeRow(0);
       	String s[]=new String[1];
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
     int wardID=Integer.parseInt(inf.getSingleValue("select wardCatCode from wardCategory where wardCatName='"+(""+cb1.getSelectedItem())+"'"));
     str=inf.getResultSetAs_1D_Array("select roomNo from roomDetails where wardCatCode="+wardID+" order by roomNo asc");
     int fir=0;
     //System.out.println("len="+str.length);
     if(str.length>0)
     fir=Integer.parseInt(str[0]);
       for(int i=0;i<str.length;i++)
       {
       	//System.out.println("aa="+i);
       		int sec=Integer.parseInt(str[i]);
       		if((i+1)==str.length)
       		{
       			s[0]="Room No. "+""+fir+" To Room No. "+""+sec;
       			dtm.addRow(s);
       		}
       		else if((i+1)<str.length)
       		{
       			if((sec+1)==Integer.parseInt(str[i+1]))
       			{}
       			else
       			{
       				s[0]="Room No. "+""+fir+" To Room No. "+""+sec;
       				dtm.addRow(s);
       				if(i<str.length)
       				fir=Integer.parseInt(str[i+1]);
       			}	
       		}
       		
       }
		
	}
	catch(Exception ex)
       {
       	 System.out.println("Error1122.1..."+ex);
       }
    }
}
	