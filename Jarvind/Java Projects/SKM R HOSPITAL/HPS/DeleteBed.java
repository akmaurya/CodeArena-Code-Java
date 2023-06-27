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
public class DeleteBed extends JInternalFrame implements ActionListener,KeyListener,MouseListener
{
	JButton btn1,btn2;
	JComboBox cb1,cb2;
	Container cn;
	JInternalFrame frm;
	DefaultTableModel dtm;
   	JTable tab1;
	JScrollPane jsp;
	String str[]=null;
	int initroom=0,lastroom=0;
	public DeleteBed(JDesktopPane dp)
	{
		frm=new JInternalFrame("Delete Bed",false,true,false,true);
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
							
							
		try
		{
							
     String str[]=inf.getResultSetAs_1D_Array("select wardCatName from wardCategory order by wardCatName");
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
		
	JLabel lbl11=new JLabel("Select Room No.");
		lbl11.setBounds(20,60,200,25);
		cn.add(lbl11);
		
		cb2=new JComboBox();
		cb2.setBounds(150,60,250,25);
		cn.add(cb2);	
		
		ImageIcon i3=new ImageIcon("icons\\delete.gif");
		btn1=new JButton("Delete",i3);
		//btn1.setBounds(20,125,120,30);
		btn1.setBounds(50,220,120,30);
		cn.add(btn1);
		
		ImageIcon i2=new ImageIcon("icons\\exit.gif");
		btn2=new JButton("Close",i2);
		btn2.setBounds(250,220,120,30);
		cn.add(btn2);
		
		
		
		btn1.setMnemonic('S');
		btn2.setMnemonic('L');
	
		btn1.setToolTipText("Delete");
		btn2.setToolTipText("Close");
		
		cb1.setToolTipText("Please Select Ward");
		cb2.setToolTipText("Please Select Room No.");
		String heading[]={"-: List Of Beds :-"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
         tab1=new JTable(dtm);
         tab1.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
         jsp=new JScrollPane(tab1);
         jsp.setBounds(20,110, 380,100);
         cn.add(jsp);
        
       //  tab1.setEnabled(false);
         tab1.setToolTipText("Select Any Row And  ( Choose Delete Button ) To Delete Bed");
         
         DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
      		TableColumn column;
		
			column=tab1.getColumn("-: List Of Beds :-");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(40);			
		
		
		frm.reshape(90,90,430,300);
	 	dp.add(frm);
	 	frm.setVisible(true);
	 	
	 	
	 	btn1.addKeyListener(this);
	 	btn2.addKeyListener(this);
	 	cb1.addKeyListener(this);
	 	cb2.addKeyListener(this);
	 	tab1.addMouseListener(this);
	 	tab1.addKeyListener(this);
	 	
	 	btn1.addActionListener(this);
	 	btn2.addActionListener(this);
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		
		cb1.requestFocus();
		getRoom();
		addingValueInJTable();	
	}
	
	public void keyPressed(KeyEvent ke)
         {
         	boolean flag=true;
            
             if(ke.getSource()==cb1 && ke.getKeyCode()==10)	
             {
             	cb2.requestFocus(); 
             }
             else if(ke.getSource()==cb2 && ke.getKeyCode()==10)	
             {
             	btn1.requestFocus(); 
             }
             else if(ke.getSource()==btn1 && ke.getKeyCode()==10)	
             {
             	delete();
                
             }
             else if(ke.getSource()==btn2 && ke.getKeyCode()==10)	
             {
                frm.dispose();
             }
             else if(ke.getSource()==tab1 && ke.getKeyCode()==10)	
             {
             	btn1.requestFocus(); 
             }
             
         }
     public void keyTyped(KeyEvent ke)	
       {
       }
     public void keyReleased(KeyEvent ke)
       {
       		if(ke.getSource()==tab1)
       		{
       			/*ke.consume();
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
       			//	tf1.selectAll();*/
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
       		/*	try
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
       			}*/
       		}
       }
       public void actionPerformed(ActionEvent ae)
       {
         if(ae.getSource()==btn1)
          {
          		delete();
          }
            else if(ae.getSource()==btn2)	
             {
                frm.dispose();
             }
             
             else if(ae.getSource()==cb1)	
             {
             	getRoom();
                addingValueInJTable();
             }
             else if(ae.getSource()==cb2)	
             {
                addingValueInJTable();
             }
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
				int res=JOptionPane.showConfirmDialog(null,"Are you sure about this updation?","Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            	if(res==JOptionPane.YES_OPTION)
            	{	
					ZedInterface inf=null;
       				try
       				{
       					int ind[]=tab1.getSelectedRows();
       					int roomno[]=new int[ind.length];
       					for(int i=0;i<ind.length;i++)
       					{
       						String val=""+tab1.getValueAt(ind[i],0);
       						String value[]=val.split("No. ");
       						System.out.println(""+value[1]);
       						roomno[i]=Integer.parseInt(value[1]);	
       					}
       					
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
       				
       				
       				
       				
       				
       				
       				
       				
       					for(int i=0;i<ind.length;i++)
     					{
     						String query="delete * from bedDetails where bedNo=";
     						query+=roomno[i];
     						//System.out.println(""+query);
     						inf.executeUpdateQuery(query);
     					}
       				}
					catch(Exception ex)
      				{
       					System.out.println("Error at save method..."+ex);
       				}
             		JOptionPane.showMessageDialog(null,"Bed Deleted Successfully.");
    			}
    			addingValueInJTable();
 			}
 			else
 			{
 				JOptionPane.showMessageDialog(null,"No Bed Selected.\n Please Select Bed No. To Delete");
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
     int roomno=Integer.parseInt(""+cb2.getSelectedItem());
     str=inf.getResultSetAs_1D_Array("select bedNo from bedDetails where roomNo="+roomno+" order by bedNo asc");
     int fir=0;
     //System.out.println("len="+str.length);
     if(str.length>0)
     fir=Integer.parseInt(str[0]);
     String tb[]=new String[1];
       for(int i=0;i<str.length;i++)
       {
       		tb[0]="Bed No. "+str[i];
       		dtm.addRow(tb);
       }
		
	}
	catch(Exception ex)
       {
       	 System.out.println("Error1122.1..skm."+ex);
       }
    }
    public void getRoom()
	{
		cb2.removeAllItems();
		try
       {
       	ZedInterface inf=null;
       
       //		obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       
       
       
       
       
       
	
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
       		String wardCode=inf.getSingleValue("select wardCatCode from wardCategory where wardCatName='"+""+cb1.getSelectedItem()+"'");
       		System.out.println("wardCode="+wardCode);
       		String str[]=inf.getResultSetAs_1D_Array("select roomNo from roomDetails where wardCatCode="+wardCode+" order by roomNo");
       		
       		for(int i=0;i<str.length;i++)
       		{
       			cb2.addItem(str[i]);
       		}
       		
       }
		catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       }
	}
}
	