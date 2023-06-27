//ListOfMemberToIssueCheck.java

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.sql.*;
import java.math.*;
import java.awt.print.*;
import javax.print.attribute.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.font.*;
import javax.print.PrintService;
import java.util.Date.*;
import java.rmi.*;
import java.rmi.registry.*;
class ListOfPatientForSeeDoctor implements ActionListener,KeyListener,MouseListener
{
	JInternalFrame frm;
	JPanel p;	
	JLabel lbl,lbl1,wholeMoney;
	JButton btn1;
	JToggleButton btn2;
	DefaultTableModel dtm1;
	JTable tab1;
	JScrollPane jsp1;
	JDesktopPane dp;
	int doctorCode;
	task5 t;
	ZedInterface inf;
	public ListOfPatientForSeeDoctor(JDesktopPane dp1,int drCode)
	{
		frm=new JInternalFrame("List Of Patients For Treatment",false,true,false,false);
		Container cn=frm.getContentPane();
		frm.setBackground(new Color(60,220,220));
		//cn.setLayout(null);
		dp=dp1;
		//System.out.println("s222ss1.....");
		doctorCode=drCode;
		LineBorder lb=new LineBorder(Color.RED,1);
		TitledBorder tb=new TitledBorder(lb,"");
		p=new JPanel();
		p.setBackground(new Color(60,220,220));
		p.setOpaque(true);
		p.setLayout(null);
		ImageIcon i=new ImageIcon("icons\\exit.gif");		
		btn1=new JButton("Close",i);
		btn1.setToolTipText("Close");
		btn1.setMnemonic('e');
		btn1.setBounds(250,500,160,30);
		btn1.requestFocus();
		p.add(btn1);
		ImageIcon i2=new ImageIcon("icons\\new.gif");		
		btn2=new JToggleButton("Waiting Patient",i2);
		btn2.setToolTipText("Patients");
		btn2.setMnemonic('p');
		btn2.setBounds(50,500,160,30);
		btn2.requestFocus();
		p.add(btn2);
//System.out.println("s333ss1.....");
		String head1[]={"Sr.No.","Patient ID","Patient Name"};
		dtm1=new DefaultTableModel(head1,0);
		tab1=new JTable(dtm1);
		jsp1=new JScrollPane(tab1);
		jsp1.setBounds(30,30,410,420);
		p.add(jsp1);
		
		lbl1=new JLabel("T o t a l  P a t i e n t s  - > ");
		lbl1.setHorizontalAlignment(JLabel.RIGHT);
		lbl1.setBounds(125,450,200,25);
		p.add(lbl1);
		
	//System.out.println("sss1.....");
		wholeMoney=new JLabel("0");
		wholeMoney.setBackground(new Color(174,200,230));
		//wholeMoney.setFont(fn);
		wholeMoney.setBounds(340,450,100,25);
		wholeMoney.setOpaque(true);
		wholeMoney.setHorizontalAlignment(JLabel.RIGHT);
		p.add(wholeMoney);
		
			DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
      		TableColumn column;
		
			column=tab1.getColumn("Sr.No.");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(40);

      		column=tab1.getColumn("Patient ID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(50);
  
      		column=tab1.getColumn("Patient Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);
  
	//	System.out.println("sss1.....");
		Font fn11=new Font("Arial",Font.BOLD|Font.ITALIC,25);
		lbl=new JLabel("No Patient Available");
		lbl.setHorizontalAlignment(JLabel.CENTER);
		lbl.setFont(fn11);
		lbl.setBounds(0,250,485,50);
		p.add(lbl);
		p.setBounds(25,15,420,560);
		p.setBorder(tb);
		cn.add(p);
		frm.reshape(120,50,485,620);
		dp1.add(frm);
		//System.out.println("s1.....");
	//	System.out.println("1.....");
		frm.setVisible(true);
		btn1.addActionListener(this);
		btn1.addKeyListener(this);
		btn2.addActionListener(this);
		btn2.addKeyListener(this);
		tab1.addMouseListener(this);
		
		//...
			frm.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
		
		//...
		
       	btn2.requestFocus();
       	initActionForWaitingPatients();
		t=new task5();
		t.start();
		
	}
	public void keyPressed(KeyEvent ke)
	{
		int code=ke.getKeyCode();
		if(ke.getSource()==btn1&& code==KeyEvent.VK_ENTER )
		{
			t.stop();
			frm.dispose();
		}
		if(ke.getSource()==btn2&& code==KeyEvent.VK_ENTER)
		{
			try
            {
                
                 if(btn2.isSelected())
                 {
                      btn2.setText("All Patient");
                      initActionForAllPatients();
                 }
                 else
                 {
                      btn2.setText("Waiting Patient");
                      initActionForWaitingPatients();
                      //System.out.println("stop"); 
                 }
            }
            catch(Exception x)
            {
                 System.out.println(""+x); 
            }   
		}
	}
	public void keyTyped(KeyEvent ke)
	{}
	public void keyReleased(KeyEvent ke)
	{}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btn1)
		{
			t.stop();
			frm.dispose();
		}
		if(ae.getSource()==btn2)
		{
			try
              {
                
                 if(btn2.isSelected())
                
                    {
                      btn2.setText("All Patient");
                      initActionForAllPatients();
                    }
              
                  else
                    {
                      btn2.setText("Waiting Patient");
                      initActionForWaitingPatients();
                      //System.out.println("stop"); 
                    }
               }
            
            catch(Exception x)
                 {
                     System.out.println(""+x); 
                 }   
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
       			System.out.println("in1");
       			if(me.getModifiers()==4)
       			//if(me.getClickCount()==2)
       			{
       				System.out.println("in2");
       				int drCategoryCode=0;
       				int patientID=Integer.parseInt(""+tab1.getValueAt(tab1.getSelectedRow(),1));
       				try
       				{
       				///	ZedInterface obj=null;
       					try
       					{
       					///	obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       					
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
       					
       					
       					
       					
       					
       					
       					
       						String dcode=inf.getSingleValue("select drCatCode from drDetail where drCode="+doctorCode);
       						drCategoryCode=Integer.parseInt(dcode);
       					}
						catch(Exception ex)
       					{
       	 					System.out.println("Error.1..s11."+ex);
       					}
       				}
					catch(Exception ex)
       				{
       	 				System.out.println("Error.1..s12."+ex);
       				}
       				if(drCategoryCode==1)
       				{
       					String hold=null;
       					PatientPrescription p=new PatientPrescription(dp,patientID,hold);	
       				}
       				else
       				{
       					String hold=null;
       					NewPatientPrescGianec frm=new NewPatientPrescGianec(dp,patientID,hold);
        			//	frm.setBounds(50,50,812,519);
        			//	dp.add(frm);
        			//	frm.show();
       				}
       			}
       		}
            
            
       }
	
	private void initActionForWaitingPatients()
	{
		try
       {
       	jsp1.setVisible(true);
       	lbl1.setVisible(true);
       	wholeMoney.setVisible(true);
       	while(tab1.getRowCount()>0)  dtm1.removeRow(0);
      // 	ZedInterface obj=null;
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
       
      
       	//	String[][] str=obj.getResultSetAs_2D_Array("select patientid,name from patient_Profile where drCode="+doctorCode+" order by patientid asc",2);
       		
       	//		if(str!=null)
       	//		{
       				int ind=1;
       				
       					String qry="Select patient_id,history_date from history_Patient where status="+true+" ORDER by patient_id asc";
       					String getdate[][]=inf.getResultSetAs_2D_Array(qry,2);
       			
       					int lenofdate=getdate.length;
       					//System.out.println("lenof "+lenofdate);
       			
       					if(getdate!=null)
       					{
       					
       							int lenof=getdate.length;
       							//System.out.println("lenof "+lenof);
       							for(int i=0;i<getdate.length;i++)
       							{
       								int c=0;
       									String getid=getdate[i][c];
       									//System.out.println("getid "+getid);
       									String get_Date=getdate[i][++c];
										//System.out.println("getdate "+get_Date);
							
		
										String split_wholeDate[]=get_Date.split("-");
										//System.out.println("0 "+split_wholeDate[0]);
										int Y=Integer.parseInt(split_wholeDate[0]);
		
										//System.out.println("1 "+split_wholeDate[1]);
										int M=Integer.parseInt(split_wholeDate[1]);
		
										//System.out.println("2 "+split_wholeDate[2]);
		
					
										String split_Date[]=split_wholeDate[2].split(" ");
										//System.out.println("0 "+split_Date[0]);
										int D=Integer.parseInt(split_Date[0]);
		
										//System.out.println("1 "+split_Date[1]);
						
										String matchdate=split_wholeDate[1]+"/"+split_Date[0]+"/"+split_wholeDate[0];
										//System.out.println("matchdate "+matchdate);
						
										String MDATE=M+"/"+D+"/"+Y;
										//System.out.println("MDATE "+MDATE);
										java.util.Date date=new java.util.Date();
       									String curDate=(date.getMonth()+1)+"/"+""+date.getDate()+"/"+(date.getYear()+1900);
       									//System.out.println("curDate "+curDate);
       									if(curDate.equals(MDATE))
       									{
       									//	System.out.println("DATE MATCHED");
       									//	String getstr="Select patientid,name from patient_Profile where drCode="+doctorCode+" And patientid="+Integer.parseInt(getid)+" order by patientid asc";
       										String getstr="Select patientid,name from patient_Profile where drCode="+doctorCode+" And patientid="+Integer.parseInt(getid)+"";
       									//	System.out.println("getstr "+getstr);
       									//	String[][] str=obj.getResultSetAs_2D_Array("Select patientid,name from patient_Profile where drCode="+doctorCode+" And patientid="+Integer.parseInt(getdate[0][0])+" order by patientid asc",2);
       										String[][] str=inf.getResultSetAs_2D_Array(getstr,2);
     									//	String getname=obj.getSingleValue(getstr);
       										int lenofstr=str.length;
       									//	System.out.println("lenofstr "+lenofstr);
       									
       										if(str!=null)
       										{
       											String row[]=new String[3] ;
       											for(int j=0,k=0;j<lenofstr;j++)
       											{
       												row[0]=""+(ind++)+" .";
       												row[1]=str[j][0];
       												row[2]=str[j][1];
       												dtm1.addRow(row);
       											}
       							
       								
       										}
       									}
       						
       					
       			}
       	}
       	else
       	{
       		jsp1.setVisible(false);
       		lbl1.setVisible(false);
       		wholeMoney.setVisible(false);
       		lbl.setVisible(true);
       	}
       	if(dtm1.getRowCount()<1)
       	{
       		jsp1.setVisible(false);
       		lbl1.setVisible(false);
       		wholeMoney.setVisible(false);
       		lbl.setVisible(true);
       	}
       	else
       	{
       		wholeMoney.setText(""+dtm1.getRowCount());
       	}
       	//System.out.println("fff");
       }
       catch(Exception ex)
       {
       	 System.out.println("Error.1.s2.."+ex);
       }
	}
	private void initActionForAllPatients()
	{
		try
       {
       	jsp1.setVisible(true);
       	lbl1.setVisible(true);
       	wholeMoney.setVisible(true);
       	while(tab1.getRowCount()>0)  dtm1.removeRow(0);
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
        int ind=1;
        String[][] str=inf.getResultSetAs_2D_Array("Select patientid,name from patient_Profile where drCode="+doctorCode+" Order by patientid asc",2);
       	int lenofstr=str.length;
       	//System.out.println("lenofstr "+lenofstr);
       	if(str!=null)
       	{
       		String row[]=new String[3] ;
       		for(int j=0,k=0;j<lenofstr;j++)
       		{
       			row[0]=""+(ind++)+" .";
       			row[1]=str[j][0];
       			row[2]=str[j][1];
       			dtm1.addRow(row);
       		}
       							
       		      						
       	}
       	else
       	{
       		jsp1.setVisible(false);
       		lbl1.setVisible(false);
       		wholeMoney.setVisible(false);
       		lbl.setVisible(true);
       	}
       	if(dtm1.getRowCount()<1)
       	{
       		jsp1.setVisible(false);
       		lbl1.setVisible(false);
       		wholeMoney.setVisible(false);
       		lbl.setVisible(true);
       	}
       	else
       	{
       		wholeMoney.setText(""+dtm1.getRowCount());
       	}
       	//System.out.println("fff");
       }
       catch(Exception ex)
       {
       	 System.out.println("Error.1.s2.."+ex);
       }
	}
	
	private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
// TODO add your handling code here:
		//System.out.println("thread stop1");
		t.stop();
		//System.out.println("thread stop2");
    }
	
	class task5 extends Thread
  {
       
       public void run()
      
       {
         for(int i=1;i>0;i++)
           {     
                 try
                 {
                   Thread.sleep(10000);
                   if(btn2.isSelected())
                   {
                   		initActionForAllPatients();
                   }
                   else
                   {
                   		initActionForWaitingPatients ();
                   }
                   System.out.println("......SKM R......");
                 }
                catch(Exception Ex)
                 {
                     System.out.println("error found...."+Ex);
                 }
           }
       }
       
  }
}
