/*
 * ProvideSpectsToPatient.java
 *
 * Created on May 30, 2011, 10:27 AM
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.rmi.*;
import java.awt.geom.*;
import javax.print.PrintService;
import java.awt.print.*;
import javax.print.attribute.*;
import java.awt.font.*;

/**
 *
 * @author  Administrator
 */
public class ProvideSpectsToPatient extends javax.swing.JInternalFrame {
    
    /** Creates new form ProvideSpectsToPatient */
    public ProvideSpectsToPatient(JDesktopPane jDesktopPane1) {
    	System.out.println("I m running 1234  .....");;
        initComponents();
        jButton4.setEnabled(false);
        r=new Refraction();
        r.setBounds(10,190,430,175);
        this.getContentPane().add(r);
        r.show();
        ppp=new PanelOfProvideSpectsToPatient();
        ppp.setBounds(447,10,154,353);
        this.getContentPane().add(ppp);
        ppp.show();
        boolean flag=true,flag1=true;
        int pNo=0;
        String pid=JOptionPane.showInputDialog(null,"Enter Patient ID");
        if(pid!=null)
        {
        	try
        	{
        		pNo=Integer.parseInt(pid);	
        		//flag1=false;
        	}
        	catch(Exception e)
        	{
        		System.out.println("Error in constuctor of ProvideSpectsToPatient class...."+e);
        		flag=false;
        	}
        }
        if(flag)
        {
        	try
        	{
        	
        ///	ZedInterface inf2=(ZedInterface)Naming.lookup(getIPaddress.IP());
        ZedInterface inf2=null;
        try
							{
								inf2=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
									getIPaddress.changeIP();
									try
									{
										inf2=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
        
           String arr=inf2.getSingleValue("select patientid from patient_Profile where patientid="+pNo);
            if(arr!=null)
            {
            	int patientID=pNo;
            	patientid=patientID;
            	arr=inf2.getSingleValue("select name from patient_Profile where patientid="+patientID);
            	//lbl_Label.setText(""+patientID+"#"+arr);
            	setTitle("Provide Spectacles To "+""+patientID+"#"+arr);
            }
            else
            {
            	JOptionPane.showMessageDialog(null,"You Have Wrong ID\nPlease Input Correct ID");
            	flag=false;
            }
            
            
            }
            catch(Exception e)
            {
            	System.out.println("Error...SKM R...."+e);
            }
        }
        
        	
        setCategoryOfGlass();
        setCategoryOfFrame();
        try
    	{
    	//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
    	
    	
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
    		String query="select cmpName from spectsCmpMaster order by cmpName";
        	String []arr=inf.getResultSetAs_1D_Array(query);
        	//System.out.println("1.."+arr.length);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        		{
        			jComboBox3.addItem(arr[i]);
        			jComboBox6.addItem(arr[i]);
        		}
        	}
        }
    	catch(Exception e)
    	{
    		System.out.println("Error..1..."+e);
    	}
    	
    	if(flag)
        {
        	reshape(50,100,621,470);
        	jDesktopPane1.add(this);
        	show();
        	desk=jDesktopPane1;
        }
    }
    private void setCategoryOfFrame()
    {
    	
    	try
    	{
    	//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
    	
    	
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
    		//if(jComboBox2.getSelectedItem()!=null)
    		{
    			//System.out.println("1..");
    			//if(jComboBox1!=null)
    				//jComboBox3.removeAllItems();
    			//System.out.println("2..");
    			String query="select gpCode from spectsGroupMaster where gpNm='Frame'";
    			//System.out.println("3..");
    			String cd=inf.getSingleValue(query);
    			//System.out.println("4..");
    			if(cd!=null)
    			{
    				int code=Integer.parseInt(cd);
    				//System.out.println("5..");
    				query="select catNm from spectsCatMaster where gpCode="+code+" order by catNm ";
        			String arr[]=inf.getResultSetAs_1D_Array(query);
        			//System.out.println("length.."+arr.length);
        			if(arr!=null)
        			{
        				for(int i=0;i<arr.length;i++)
        				{
        					//System.out.println("2..");
        					jComboBox1.addItem(arr[i]);
        				}
        			}
        		}
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error..2..."+e);
    	}
    }
    private void setCategoryOfGlass()
    {
    	
    	try
    	{
    	///	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
    		//if(jComboBox2.getSelectedItem()!=null)
    		{
    			//System.out.println("1..");
    			//if(jComboBox3!=null)
    				//jComboBox3.removeAllItems();
    			//System.out.println("2..");
    			String query="select gpCode from spectsGroupMaster where gpNm='Glass'";
    			//System.out.println("3..");
    			String cd=inf.getSingleValue(query);
    			//System.out.println("4..");
    			if(cd!=null)
    			{
    				int code=Integer.parseInt(cd);
    				//System.out.println("5..");
    				query="select catNm from spectsCatMaster where gpCode="+code+" order by catNm ";
        			String arr[]=inf.getResultSetAs_1D_Array(query);
        			//System.out.println("length.."+arr.length);
        			if(arr!=null)
        			{
        				for(int i=0;i<arr.length;i++)
        				{
        					//System.out.println("2..");
        					jComboBox4.addItem(arr[i]);
        				}
        			}
        		}
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error..2..."+e);
    	}
    	setInitInfo();
    	r.jComboBox1.setEnabled(false);
    	r.jComboBox2.setEnabled(false);
    	r.jComboBox3.setEnabled(false);
    	r.jComboBox4.setEnabled(false);
    	r.jComboBox5.setEnabled(false);
    	r.jComboBox6.setEnabled(false);
    	r.jComboBox7.setEnabled(false);
    	r.jComboBox8.setEnabled(false);
    	r.jComboBox9.setEnabled(false);
    	r.jComboBox10.setEnabled(false);
    	r.jComboBox11.setEnabled(false);
    	r.jComboBox12.setEnabled(false);
    }
    
    private void setInitInfo()
    {
    	try
    	{
    ///		ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
    		String query="select D_RE_Sph,D_RE_Cyl,D_RE_Axis,D_RE_Va,D_LE_Sph,D_LE_Cyl,D_LE_Axis,D_LE_Va,N_RE_1,N_RE_Va,N_LE_2,N_LE_Va from previous_Prescription where Patient_ID="+patientid+" order by prescription_date,prescription_time desc";
    		String arr[][]=inf.getResultSetAs_2D_Array(query,12);
    		if(arr!=null)
    		{
    			String temp=arr[0][0];
    			r.jComboBox1.addItem(temp);
    			r.jComboBox1.setSelectedItem(temp);
    			temp=arr[0][1];
    			r.jComboBox2.addItem(temp);
    			r.jComboBox2.setSelectedItem(temp);
    			temp=arr[0][2];
    			r.jComboBox3.addItem(temp);
    			r.jComboBox3.setSelectedItem(temp);
    			temp=arr[0][3];
    			r.jComboBox4.addItem(temp);
    			r.jComboBox4.setSelectedItem(temp);
    			temp=arr[0][4];
    			r.jComboBox5.addItem(temp);
    			r.jComboBox5.setSelectedItem(temp);
    			temp=arr[0][5];
    			r.jComboBox6.addItem(temp);
    			r.jComboBox6.setSelectedItem(temp);
    			temp=arr[0][6];
    			r.jComboBox7.addItem(temp);
    			r.jComboBox7.setSelectedItem(temp);
    			temp=arr[0][7];
    			r.jComboBox8.addItem(temp);
    			r.jComboBox8.setSelectedItem(temp);
    			temp=arr[0][8];
    			r.jComboBox9.addItem(temp);
    			r.jComboBox9.setSelectedItem(temp);
    			temp=arr[0][9];
    			r.jComboBox10.addItem(temp);
    			r.jComboBox10.setSelectedItem(temp);
    			temp=arr[0][10];
    			r.jComboBox11.addItem(temp);
    			r.jComboBox11.setSelectedItem(temp);
    			temp=arr[0][11];
    			r.jComboBox12.addItem(temp);
    			r.jComboBox12.setSelectedItem(temp);
    		}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in setInitInfo of ProvideSpectsToPatient class..no problem working..."+e);
    	}
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setBackground(new java.awt.Color(60, 220, 220));
        setClosable(true);
        setTitle("Giving Spectacles To Patient");
        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 1, true), "Frame Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153)));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jLabel1.setText("Select Category");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 25, 100, 14);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(90, 20, 130, 22);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jLabel2.setText("Select Item");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(230, 25, 80, 14);

        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });

        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(290, 20, 130, 22);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jLabel5.setText("Size");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(230, 55, 50, 14);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField1);
        jTextField1.setBounds(290, 50, 130, 19);

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox3KeyPressed(evt);
            }
        });

        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(90, 50, 130, 22);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jLabel8.setText("Of Company");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 55, 90, 14);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 430, 80);

        jPanel2.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 1, true), "Glass Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153)));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jLabel3.setText("Select Category");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 25, 100, 14);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jLabel4.setText("Select Item");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(230, 25, 80, 14);

        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jComboBox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox4KeyPressed(evt);
            }
        });

        jPanel2.add(jComboBox4);
        jComboBox4.setBounds(90, 20, 130, 22);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jPanel2.add(jTextField2);
        jTextField2.setBounds(290, 50, 130, 19);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jLabel6.setText("Lens No.");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(230, 55, 60, 14);

        jComboBox5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox5KeyPressed(evt);
            }
        });

        jPanel2.add(jComboBox5);
        jComboBox5.setBounds(290, 20, 130, 22);

        jComboBox6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox6KeyPressed(evt);
            }
        });

        jPanel2.add(jComboBox6);
        jComboBox6.setBounds(90, 50, 130, 22);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 12));
        jLabel7.setText("Of Company");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(10, 55, 90, 14);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 100, 430, 80);

        jPanel3.setLayout(null);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 0), 1, true));
        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.gif")));
        jButton1.setMnemonic('s');
        jButton1.setText("Save");
        jButton1.setToolTipText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jPanel3.add(jButton1);
        jButton1.setBounds(20, 10, 110, 30);

        jButton2.setForeground(new java.awt.Color(0, 0, 153));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reset.gif")));
        jButton2.setMnemonic('r');
        jButton2.setText("Refresh");
        jButton2.setToolTipText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jPanel3.add(jButton2);
        jButton2.setBounds(310, 10, 110, 30);

        jButton3.setForeground(new java.awt.Color(0, 0, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton3.setMnemonic('c');
        jButton3.setText("Close");
        jButton3.setToolTipText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton3KeyPressed(evt);
            }
        });

        jPanel3.add(jButton3);
        jButton3.setBounds(460, 10, 110, 30);

        jButton4.setForeground(new java.awt.Color(0, 0, 153));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/PRINT.GIF")));
        jButton4.setMnemonic('p');
        jButton4.setText("Print");
        jButton4.setToolTipText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });

        jPanel3.add(jButton4);
        jButton4.setBounds(160, 10, 110, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 375, 590, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
		if(evt.getKeyCode()==10)
		{
			printReceipt PRT=new printReceipt(desk);
		}
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
		//print();
		printReceipt PRT=new printReceipt(desk);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
// TODO add your handling code here:
        setItemNmOfGlass();
    }//GEN-LAST:event_jComboBox4ActionPerformed
	private void setItemNmOfGlass()
    {
    	
    	try
    	{
    ///		ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
    		if(jComboBox4.getSelectedItem()!=null)
    		{
    			//System.out.println("1..");
    			if(jComboBox5!=null)
    				jComboBox5.removeAllItems();
    			//System.out.println("2..");
    			String query="select catCode from spectsCatMaster where catNm='"+""+jComboBox4.getSelectedItem()+"'";
    			//System.out.println("3..");
    			String cd=inf.getSingleValue(query);
    			//System.out.println("4..");
    			if(cd!=null)
    			{
    				int code=Integer.parseInt(cd);
    				//System.out.println("5..");
    				query="select itmNm from spectsItemMaster where catCode="+code+" order by itmNm ";
        			String arr[]=inf.getResultSetAs_1D_Array(query);
        			//System.out.println("length.."+arr.length);
        			if(arr!=null)
        			{
        				for(int i=0;i<arr.length;i++)
        				{
        					//System.out.println("2..");
        					jComboBox5.addItem(arr[i]);
        				}
        			}
        		}
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error..3..."+e);
    	}
    }
    private void jComboBox6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox6KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
        jTextField2.requestFocus();
    }//GEN-LAST:event_jComboBox6KeyPressed

    private void jComboBox5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox5KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
        jComboBox6.requestFocus();
    }//GEN-LAST:event_jComboBox5KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
           dispose();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            reset();
        }
    }//GEN-LAST:event_jButton2KeyPressed
    private void reset()
    {
        jButton1.setEnabled(true);
        jButton4.setEnabled(false);
        jTextField1.setText("");
        jTextField2.setText("");
        ppp.jTextField1.setText("");
        ppp.jTextField2.setText("");
        ppp.jTextField3.setText("");
        ppp.jTextField4.setText("");
        ppp.jLabel6.setText("0.00");
        ppp.jLabel10.setText("0.00");
        jComboBox1.requestFocus();
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        save();
    }//GEN-LAST:event_jButton1ActionPerformed
	private boolean save()
	{
		try
		{
			int res=JOptionPane.showConfirmDialog(null,"Are You Sure ?");
			if(res==JOptionPane.YES_OPTION)
			{
				ppp.calculationOfAmt ();
				
				///	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
					int max=inf.getMaxValue("select max(srno) from patient_SpectsProvidation");
					max+=1;
					//-----frame dtl
					int catcodeF=0;
					String temp=inf.getSingleValue("select catCode from spectsCatMaster where catNm='"+""+jComboBox1.getSelectedItem()+"'");
					if(temp!=null)
						catcodeF=Integer.parseInt(temp);
					int itmcodeF=0;
					temp=inf.getSingleValue("select itmCode from spectsItemMaster where itmNm='"+""+jComboBox2.getSelectedItem()+"' and catCode="+catcodeF+"");
					if(temp!=null)
						itmcodeF=Integer.parseInt(temp);
					int cmpcodeF=0;
					temp=inf.getSingleValue("select cmpCode from spectsCmpMaster where cmpName='"+""+jComboBox3.getSelectedItem()+"'");
					if(temp!=null)
						cmpcodeF=Integer.parseInt(temp);
					String size=jTextField1.getText();
					//---glass dtl
					int catcodeG=0;
					temp=inf.getSingleValue("select catCode from spectsCatMaster where catNm='"+""+jComboBox4.getSelectedItem()+"'");
					if(temp!=null)
						catcodeG=Integer.parseInt(temp);
					int itmcodeG=0;
					temp=inf.getSingleValue("select itmCode from spectsItemMaster where itmNm='"+""+jComboBox5.getSelectedItem()+"' and catCode="+catcodeG+"");
					if(temp!=null)
						itmcodeG=Integer.parseInt(temp);
					int cmpcodeG=0;
					temp=inf.getSingleValue("select cmpCode from spectsCmpMaster where cmpName='"+""+jComboBox6.getSelectedItem()+"'");
					if(temp!=null)
						cmpcodeG=Integer.parseInt(temp);
					String lens=jTextField2.getText();
					java.util.Date dt=new java.util.Date();
					String curDt=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);
					//taking given date of spectacles-----
        			String temp1[]=ppp.jLabel8.getText().split("/");
        			String givenDt=temp1[1]+"/"+temp1[0]+"/"+temp1[2];
        			//System.out.println("daate="+givenDt);
        			
        			//----amount related code--------
        			double frameAmt=0,glassAmt=0,extraAmt=0;
        		//	int quantity=0;
        			if(ppp.jTextField1.getText().equals(""))
        			{}
        			else
        			{
        				frameAmt=Double.valueOf(ppp.jTextField1.getText());
        			}
        			if(ppp.jTextField2.getText().equals(""))
        			{}
        			else
        			{
        				glassAmt=Double.valueOf(ppp.jTextField2.getText());
        			}
        			if(ppp.jTextField3.getText().equals(""))
        			{}
        			else
        			{
        				extraAmt=Double.valueOf(ppp.jTextField3.getText());
        			}
        			double totalAmt=Double.valueOf(ppp.jLabel6.getText());
        			double dueAmt=Double.valueOf(ppp.jLabel10.getText());
        			
					String query="insert into patient_SpectsProvidation values("+max+","+patientid+",#"+curDt+"#,"+catcodeF+","+itmcodeF+","+cmpcodeF+",'"+size+"',"+frameAmt+","+catcodeG+","+itmcodeG+","+cmpcodeG+",'"+lens+"',"+glassAmt+","+extraAmt+",#"+givenDt+"#,"+totalAmt+","+dueAmt+","+false+")";
					inf.executeUpdateQuery(query);
					javax.swing.JOptionPane.showMessageDialog(this,"Data Saved Successfully.","CONGRATS !!!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
					jButton1.setEnabled(false);
					jButton4.setEnabled(true);
					
					
					/////////////code updated here by S_CHK/////////////////////
				/*	String qry="Select qty from purchaseDtlOfSpects where catCode="+catcodeF+" and itmCode="+itmcodeF+" and cmpCode="+cmpcodeF+"";
					String getqty=inf.getSingleValue(qry);
					System.out.println("getqty  "+getqty);
					quantity=Integer.parseInt(getqty);
					quantity--;
					
					qry="update purchaseDtlOfSpects set qty="+quantity+" where catCode="+catcodeF+" and itmCode="+itmcodeF+" and cmpCode="+cmpcodeF+"";
					boolean successful=inf.executeUpdateQuery(qry);
					System.out.println("successful....1"+successful);
					
					qry="Select qty from purchaseDtlOfSpects where catCode="+catcodeG+" and itmCode="+itmcodeG+" and cmpCode="+cmpcodeG+"";
					getqty=inf.getSingleValue(qry);
					System.out.println("getqty  "+getqty);
					quantity=Integer.parseInt(getqty);
					quantity--;
					
					qry="update purchaseDtlOfSpects set qty="+quantity+" where catCode="+catcodeG+" and itmCode="+itmcodeG+" and cmpCode="+cmpcodeG+"";
					successful=inf.executeUpdateQuery(qry);
					System.out.println("successful.....2"+successful);*/
					
					
					int quanty=0;
					String qry="Select qty from spectsStockHolding where cmpCode="+cmpcodeF+" and itmCode="+itmcodeF+" and size_lense_No='"+size+"'";
					String quantity=inf.getSingleValue(qry);
					System.out.println("quantity    "+quantity);
					
					if(quantity!=null)
					{
						quanty=Integer.parseInt(quantity);
						quanty--;
						qry="update spectsStockHolding set qty="+quanty+" where cmpCode="+cmpcodeF+" and itmCode="+itmcodeF+" and size_lense_No='"+size+"'";
						inf.executeUpdateQuery(qry);
						System.out.println("database updated here ");
						
					}
					quanty=0;
					qry="Select qty from spectsStockHolding where cmpCode="+cmpcodeG+" and itmCode="+itmcodeG+" and size_lense_No='"+lens+"'";
					quantity=inf.getSingleValue(qry);
					System.out.println("quantity  of glass "+quantity);
					if(quantity!=null)
					{
						quanty=Integer.parseInt(quantity);
						quanty--;
						qry="update spectsStockHolding set qty="+quanty+" where cmpCode="+cmpcodeG+" and itmCode="+itmcodeG+" and size_lense_No='"+lens+"'";
						inf.executeUpdateQuery(qry);
						System.out.println("database updated here ");
						
					}
					
					
					///////////////////////////////////////////////////////
					
					
					
					return true;
					
				
				}
			
		}
		catch(Exception e)
		{
			System.out.println("Error in save..."+e);
			return false;
		}
		return true;
	}
    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            save();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            ppp.jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jComboBox4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox5.requestFocus();
        }
    }//GEN-LAST:event_jComboBox4KeyPressed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox4.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox3.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
// TODO add your handling code here:
        setItemNmOfFrame();
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    private void setItemNmOfFrame()
    {
    	
    	try
    	{
    	//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
    		if(jComboBox1.getSelectedItem()!=null)
    		{
    			//System.out.println("1..");
    			if(jComboBox2!=null)
    				jComboBox2.removeAllItems();
    			//System.out.println("2..");
    			String query="select catCode from spectsCatMaster where catNm='"+""+jComboBox1.getSelectedItem()+"'";
    			//System.out.println("3..");
    			String cd=inf.getSingleValue(query);
    			//System.out.println("4..");
    			if(cd!=null)
    			{
    				int code=Integer.parseInt(cd);
    				//System.out.println("5..");
    				query="select itmNm from spectsItemMaster where catCode="+code+" order by itmNm ";
        			String arr[]=inf.getResultSetAs_1D_Array(query);
        			//System.out.println("length.."+arr.length);
        			if(arr!=null)
        			{
        				for(int i=0;i<arr.length;i++)
        				{
        					//System.out.println("2..");
        					jComboBox2.addItem(arr[i]);
        				}
        			}
        		}
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error..3..."+e);
    	}
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    Refraction r;
    PanelOfProvideSpectsToPatient ppp;
    int patientid;
    JDesktopPane desk;
    ZedInterface inf=null;
     //printing start from here-------
     
     class printReceipt extends JFrame 
   {
        	JInternalFrame pchallanf;
	        Container contentPane;
        	GridBagLayout gbl;
	        GridBagConstraints gbc;
        	JButton printButton;
	        JButton pageSetupButton,exitButton;

			PrintPanel canvas;
	        PageFormat pageFormat;

        	public printReceipt(JDesktopPane desk)
        	{
                pchallanf=new JInternalFrame("Printing of Invoice",false,true,true,true);
                contentPane=pchallanf.getContentPane();
				gbl=new GridBagLayout();
				gbc=new GridBagConstraints();
                contentPane.setLayout(new BorderLayout());

                addWindowListener(new WindowAdapter()
                {
                        public void windowClosing(WindowEvent e)
                        {
                                System.exit(0);
                        }
                }
                );

                canvas=new PrintPanel();
                contentPane.add(canvas,"Center");
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new GridLayout(2,1));

                //pageSetupButton.addActionListener(this);

                contentPane.add(buttonPanel,"East");

                                PrinterJob printJob=PrinterJob.getPrinterJob();
                                double width=3.8*72;//8.27 * 72;
                                double height=5.11*72;//(11.69 * 72);
                                Paper paper=new Paper();                                
                                paper.setSize(width,height);

                                PageFormat page=new PageFormat();
                                paper.setImageableArea(5,10,paper.getWidth(),paper.getHeight());
                                //page.setOrientation(PageFormat.LANDSCAPE);
                                page.setPaper(paper);
                                pageFormat=printJob.defaultPage(page);
                                pageFormat.setPaper(paper);
                                printJob.setPrintable(canvas,pageFormat);
								
                                try
                                {
										System.out.println("W="+paper.getWidth()+"H="+paper.getHeight());
										currentpg=1;
										printJob.print();
	                            }
                                catch(Exception exception)
                                {
                                        JOptionPane.showMessageDialog(this,exception);
                                }
        		}
	}
	
	
		int currentpg,totalpg, rem;
	boolean firsttime=false;
	boolean complete=false;
	int currentrec=0,startno=0,endno=0;
    
    class PrintPanel extends JPanel implements Printable
	{
		int currentpg,totalpg, rem;
	boolean firsttime=false;
	boolean complete=false;
	int currentrec=0,startno=0,endno=0;
        //Connection connection;
        //Statement st,st1;
        //ResultSet rs,rs1;
        int page=100;
		TextLayout layout;
		Font f,f1,f2,f3,f4,f5,f6;
		Graphics2D g2;
		int row=0;		
		FontRenderContext context;
        
        
        public PrintPanel()
        {
                //ChallanNo=JOptionPane.showInputDialog(null,"Enter Challan Number:");
        }
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                Graphics2D g2=(Graphics2D)g;
                drawPage(g2);
        }
        public int print(Graphics g,PageFormat pf,int page) throws PrinterException
        {
                if(page>=1)
                        return Printable.NO_SUCH_PAGE;
                Graphics2D g2=(Graphics2D)g;
                g2.setPaint(Color.black);
                g2.translate(pf.getImageableX(),pf.getImageableY());
                //g2.draw(new Rectangle2D.Double(0,0,pf.getImageableWidth(),pf.getImageableHeight()));
                System.out.println("W1="+pf.getImageableWidth()+"H1="+pf.getImageableHeight());
                drawPage(g2);
                return Printable.PAGE_EXISTS;
        }
        
    
        public void drawPage(Graphics2D g2)
        {
			this.g2=g2;
			//System.out.println("inside draw page..."+totalamt);	
			
            context=g2.getFontRenderContext();
            f1=new Font("Times New Roman",Font.BOLD,10);
            //f1=new Font("Arial",Font.BOLD,120);
            f2=new Font("Arial",Font.PLAIN,9);
            f3=new Font("Arial",Font.PLAIN,10);
            f4=new Font("Arial",Font.BOLD,10);
            f5=new Font("Times New Roman",Font.PLAIN,11);
            f6=new Font("Times New Roman",Font.BOLD,11);
            Font f7=new Font("Times New Roman",Font.BOLD,12);
            Font f8=new Font("Times New Roman",Font.BOLD,25);
            FontMetrics fm;
            GeneralPath clipShape=new GeneralPath();

            String str=" fdfg dfg dfg";
            String str1="d fgf dgdfg df";                                        
            g2.setFont(f1);
            layout=new TextLayout(str,f1,context);
            AffineTransform transform=AffineTransform.getTranslateInstance(10,20);
			
			if(firsttime==false)
			{
				firsttime=true;
			}
			else
			{			
		        try
        		{
        			System.out.println("dhananjay.............1");
        			
        			
		        	/*FinDatab1aseFile dbfile1=new FinDatab1aseFile();
					Connection con1=dbfile1.connectDatab1ase();
					Statement st=con1.createStatement();								
					con1.close();*/
					
					System.out.println("dhananjay.............2");
					
					/*Datab1aseFile confile=new Datab1aseFile();
					Connection connection=confile.connectDatab1ase();
					Statement stobj=connection.createStatement();
					stobj.close();
					connection.close();								
					System.out.println("dhananjay.............3");*/
					
					fm=g2.getFontMetrics();				
					String temp="";
					
					
		            int top=120;
		            
		            
		            
		            currentpg=1;
		            if(currentpg==1)
		            {
		            
						System.out.println("s......");

		            
		            
		            g2.setFont(f3);
		            fm=g2.getFontMetrics();
		            
		            g2.drawRect(8,top-15,255,45);
		            
		            temp="ReceiptNo.";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,15,top);
        		    int recNo=0,opdNo=0;
        		    String name="",gender="",age="";
        		    try
        		    {
        		    ///	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
        		    	recNo=inf.getMaxValue("select max(srno) from patient_SpectsProvidation");
        		    	recNo+=1;
        		    	String ttt[]=getTitle().split("To");
        		    	String title[]=ttt[1].split("#");
        		    	opdNo=Integer.parseInt(title[0].trim());
        		    	name=title[1];
        		    	String str11[][]=inf.getResultSetAs_2D_Array("select age,gender from patient_Profile where patientid="+opdNo,2);
        		    	if(str11!=null)
        		    	{
        		    		age=str11[0][0];
        		    		gender=str11[0][1];
        		    	}
        		    	
        		    }
        		    catch(Exception e)
        		    {
        		    	System.out.println("Error...in drwPage..."+e);
        		    }
        		    //recNo
        		    g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            temp=""+recNo;
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,65,top);
        		    
        		    g2.setFont(f3);
		            fm=g2.getFontMetrics();
		            
		            temp="OPD No.";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,(270-fm.stringWidth(temp) -fm.stringWidth(""+opdNo))/2-10,top);
		            //opdNo
		            g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            
		            temp=" "+opdNo;
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,140,top);
        		    
        		    g2.setFont(f3);
		            fm=g2.getFontMetrics();
		            
		            //date
		            java.util.Date dt=new java.util.Date();
		            String date=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		            temp=" Date:  ";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp) -fm.stringWidth(date)),top);
        		    
        		    g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            
		            temp=date;
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp)),top);
        		    
        		    //...
        		    top+=2;
        		    g2.setFont(f6);
					g2.drawLine(60,top,100,top);
					g2.drawLine(140,top,180,top);
        		    g2.drawLine(210,top,258,top);
        		    
        		    //.......
        		    top+=20;
        		    
        		    g2.setFont(f3);
		            fm=g2.getFontMetrics();
		            
		            temp="Name :";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,15,top);
        		    //name
        		    g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            temp=""+name;
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,55,top);
        		    
        		    g2.setFont(f3);
		            fm=g2.getFontMetrics();
        		    
        		    temp=" Age/Sex :  ";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp) -fm.stringWidth(age+"/"+gender)),top);
		            
                    
                   	g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            
		            temp=age+"/"+gender;
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp)),top);
				
					//...
        		    top+=2;
        		    g2.setFont(f6);
					g2.drawLine(50,top,160,top);
					//g2.drawLine(140,top,180,top);
        		    g2.drawLine(210,top,258,top);
        		    
        		    //..........
        		    g2.drawRect(8,top+5,255,23);
        		    
        		    //System.out.println("top="+top);
        		    g2.drawLine(200,top+6,200,top+103);
        		    //------
        		    top+=20;
        		    
        		    g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            
		            temp="Particular";
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(130-fm.stringWidth(temp)),top);
        		    
        		    temp="Amount";
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(250-fm.stringWidth(temp)),top);
        		    
        		    //....
        		    g2.setFont(f6);
        		    g2.drawRect(8,top+8,255,75);
        		    
        		    //.....
        		    top+=18;
        		    g2.setFont(f3);
		            fm=g2.getFontMetrics();
        		    
        		    temp="Frame Details :";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,15,top);
        		    
        		    //..
        		    top+=12;
        		    g2.setFont(f4);
		            fm=g2.getFontMetrics();
		            temp=""+jComboBox1.getSelectedItem()+"#"+jComboBox2.getSelectedItem()+" :"+jTextField1.getText();
		            layout=new TextLayout(temp,f4,context);
        		    g2.drawString(temp,20,top);
        		    
        		    
        		    if(ppp.jTextField1.getText().trim().equals(""))
        		    	ppp.jTextField1.setText("0.00");
        		    temp=""+(new java.math.BigDecimal(ppp.jTextField1.getText()).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
        		   	layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp)),top);
        		    
					//.....
        		    top+=18;
        		    g2.setFont(f3);
		            fm=g2.getFontMetrics();
        		    
        		    temp="Glass Details :";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,15,top);
        		    
        		    //..
        		    top+=12;
        		    g2.setFont(f4);
		            fm=g2.getFontMetrics();
		            temp=""+jComboBox4.getSelectedItem()+"#"+jComboBox5.getSelectedItem()+" :"+jTextField2.getText();
		            layout=new TextLayout(temp,f4,context);
        		    g2.drawString(temp,20,top);
        		    
        		    
        		    if(ppp.jTextField2.getText().trim().equals(""))
        		    	ppp.jTextField2.setText("0.00");
        		    temp=""+(new java.math.BigDecimal(ppp.jTextField2.getText()).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
        		   	layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp)),top);
        		    
        		    //.....
        		    top+=18;
        		    g2.setFont(f3);
		            fm=g2.getFontMetrics();
        		    
        		    temp="Others :";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,15,top);
        		    
        		    g2.setFont(f4);
		            fm=g2.getFontMetrics();
        		    if(ppp.jTextField3.getText().trim().equals(""))
        		    	ppp.jTextField3.setText("0.00");
        		    temp=""+(new java.math.BigDecimal(ppp.jTextField3.getText()).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
        		   	layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp)),top);
        		    
        		    
        		    //.....
        		    top+=18;
        		    g2.setFont(f4);
		            fm=g2.getFontMetrics();
		            temp="Total  :-";
		            layout=new TextLayout(temp,f4,context);
        		    g2.drawString(temp,(180-fm.stringWidth(temp)),top);
        		    
        		    g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            temp=ppp.jLabel6.getText();
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp)),top);
        		    
        		    //......
        		    top+=18;
        		    g2.setFont(f4);
		            fm=g2.getFontMetrics();
		            temp="Advance  :-";
		            layout=new TextLayout(temp,f4,context);
        		    g2.drawString(temp,(180-fm.stringWidth(temp)),top);
        		    
        		    g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            if(ppp.jTextField4.getText().trim().equals(""))
        		    	ppp.jTextField4.setText("0.00");
		            temp=""+(new java.math.BigDecimal(ppp.jTextField4.getText()).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp)),top);
        		    
        		    //.......
        		    top+=18;
        		    g2.setFont(f4);
		            fm=g2.getFontMetrics();
		            temp="Due Amount  :-";
		            layout=new TextLayout(temp,f4,context);
		            System.out.println(""+((260-fm.stringWidth(temp))/2));
        		    g2.drawString(temp,(180-fm.stringWidth(temp)),top);
        		    
        		    g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            temp=ppp.jLabel10.getText();
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(260-fm.stringWidth(temp)),top);
        		    
        		    //.....
        		    top+=22;
        		    g2.setFont(f3);
		            fm=g2.getFontMetrics();
		            temp="Delivery Date :-";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,15,top);
        		    
        		    g2.setFont(f7);
		            fm=g2.getFontMetrics();
		            
		            temp=ppp.jLabel8.getText();
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,100,top);
        		    
        		    top+=2;
        		    g2.setFont(f6);
					g2.drawLine(90,top,160,top);
					
					top+=22;
        		    g2.setFont(f3);
		            fm=g2.getFontMetrics();
		            temp="Booked By :-";
		            layout=new TextLayout(temp,f3,context);
        		    g2.drawString(temp,15,top);
        		    
        		    top+=2;
        		    g2.setFont(f6);
					g2.drawLine(80,top,160,top);
        		    
					}
         		}
         		catch(Exception x)
         		{
	        		System.out.println("Error2193821..."+x);
         		}
         
         	}
      	}
	}
}
