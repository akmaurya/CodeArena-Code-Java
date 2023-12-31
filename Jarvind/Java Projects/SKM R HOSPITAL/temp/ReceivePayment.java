/*
 * ReceivePayment.java
 *
 * Created on May 10, 2011, 3:41 PM
 */

/**
 *
 * @author  SKM R
 */
 import java.rmi.*;
 import javax.swing.*;
 import java.awt.*;
 import java.util.*;
public class ReceivePayment extends javax.swing.JInternalFrame {
    
    /** Creates new form ReceivePayment */
    public ReceivePayment() {
        initComponents();
        setBackground(new Color(60,220,220));
        jButton1.setIcon(new ImageIcon("icons\\new1.gif"));
        jButton2.setIcon(new ImageIcon("icons\\save.gif"));
        jButton3.setIcon(new ImageIcon("icons\\exit.gif"));
        /*jTextField2.setForeground(Color.RED);
        jTextField3.setForeground(Color.RED);
        jTextField4.setForeground(Color.RED);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);*/
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setClosable(true);
        setTitle("Receive Payment");
        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12));
        jLabel1.setText("Enter Patient ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 150, 20);

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12));
        jLabel2.setText("Total Payable Amount");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 50, 150, 20);

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12));
        jLabel3.setText("Total Paid Amount");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 80, 150, 20);

        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12));
        jLabel4.setText("Total Due Amount");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 110, 150, 20);

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12));
        jLabel5.setText("Amount Paid Now");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 140, 150, 20);

        jTextField1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jTextField1.setForeground(new java.awt.Color(255, 0, 51));
        jTextField1.setToolTipText("Please Enter Patient ID");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 20, 130, 20);

        jTextField2.setBackground(new java.awt.Color(255, 204, 204));
        jTextField2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(180, 50, 160, 20);

        jTextField3.setBackground(new java.awt.Color(204, 204, 255));
        jTextField3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(180, 80, 160, 20);

        jTextField4.setBackground(new java.awt.Color(255, 255, 153));
        jTextField4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(180, 110, 160, 20);

        jTextField5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jTextField5.setForeground(new java.awt.Color(0, 255, 51));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField5.setText(" ");
        jTextField5.setToolTipText("Please Enter Amount To Paid");
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField5);
        jTextField5.setBounds(180, 140, 160, 20);

        jButton1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton1.setForeground(new java.awt.Color(0, 0, 102));
        jButton1.setToolTipText("Show");
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

        getContentPane().add(jButton1);
        jButton1.setBounds(310, 16, 30, 30);

        jButton2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton2.setForeground(new java.awt.Color(0, 0, 102));
        jButton2.setMnemonic('P');
        jButton2.setText("Paid");
        jButton2.setToolTipText("Paid");
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

        getContentPane().add(jButton2);
        jButton2.setBounds(60, 180, 100, 30);

        jButton3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton3.setForeground(new java.awt.Color(0, 0, 102));
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

        getContentPane().add(jButton3);
        jButton3.setBounds(190, 180, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            dispose();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
        	save();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        save();
    }//GEN-LAST:event_jButton2ActionPerformed
	private boolean save()
	{
		try
		{
			if(showInitInfo())
			{
				try
				{
					double d=Double.valueOf(jTextField5.getText());
					if(d>(Double.valueOf(jTextField4.getText())))
					{
						JOptionPane.showMessageDialog(null,"You are giving more amount...");
						jTextField5.requestFocus();
						jTextField5.selectAll();
						return false;
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Please Input Correct Amount To Pay ?");
					jTextField5.requestFocus();
					jTextField5.selectAll();
					return false;
				}
				java.util.Date dt=new java.util.Date();
				String curDt=(dt.getMonth()+1)+"/"+(dt.getDate())+"/"+(dt.getYear()+1900);
			///	ZedInterface obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
			
			
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
				inf.executeUpdateQuery("insert into receive_Patient_Charges values("+Integer.parseInt(jTextField1.getText())+","+Double.valueOf(jTextField5.getText())+",#"+curDt+"#,"+false+")");
				//---send into invoice---
						//ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
						int max=inf.getMaxValue("select max(receiptNo) from patient_All_Invoice where status=0");
						max+=1;
						//java.util.Date dt=new java.util.Date();
						//String curDt=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);
						String query="insert into patient_All_Invoice values("+max+",#"+curDt+"#,"+Integer.parseInt(jTextField1.getText())+",'Through Receiving',"+Double.valueOf(jTextField5.getText())+",0)";
						inf.executeUpdateQuery(query);
				JOptionPane.showMessageDialog(null,"Data Saved Successfully....");
				jTextField1.setText("");
				jTextField2.setText("");
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jTextField1.requestFocus();
			}
		}
		catch(Exception e)
		{
			System.out.println("Error in save method of ReceivePayment class..."+e);
		}
		return true;
	}
    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            showInitInfo();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        showInitInfo();
    }//GEN-LAST:event_jButton1ActionPerformed
	private boolean showInitInfo()
	{
		int pid=0;
		totalAmt=0;
		totalPaidAmt=0;
		if(jTextField1.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Input Patient ID");
			jTextField1.requestFocus();
			return false;
		}
		try
		{
			pid=Integer.parseInt(jTextField1.getText());
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Please Input Correct Patient ID ( Numbers Only )");
			jTextField1.requestFocus();
			jTextField1.selectAll();
			return false;
		}
		try
        {
        	double eyeSurCharge=0,gianecSurCharge=0,otherCharge=0,medicineCharge=0,bedCharge=0;
        ///	ZedInterface obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
        	String query="select amount from eye_Surgery_Detail where Patient_Id="+pid+" and status="+false;
        	String amt[]=inf.getResultSetAs_1D_Array(query);
        	if(amt!=null)
        		for(int i=0;i<amt.length;i++)
        			eyeSurCharge+=Double.valueOf(amt[i]);
        	query="select total_charges from gianec_Surgery_Detail where Patient_Id="+pid+" and status="+false;
        	amt=inf.getResultSetAs_1D_Array(query);
        	if(amt!=null)
        		for(int i=0;i<amt.length;i++)
        			gianecSurCharge+=Double.valueOf(amt[i]);
        	query="select amt from other_Payment_Detail where patient_id="+pid+" and status="+false;
        	amt=inf.getResultSetAs_1D_Array(query);
        	if(amt!=null)
        		for(int i=0;i<amt.length;i++)
        			otherCharge+=Double.valueOf(amt[i]);
        	query="select netAmt from saleSmry_ByHPS where patientID="+pid+" and status="+false;
        	amt=inf.getResultSetAs_1D_Array(query);
        	if(amt!=null)
        		for(int i=0;i<amt.length;i++)
        			medicineCharge+=Double.valueOf(amt[i]);
        	///......
        	Date dt1=new Date();
			Date dt2=new Date();
			System.out.println("1...................");
        	String qry="Select bedNo,rate,bookingdt from admit_Patient_Info where id="+pid+" And status="+true+"";
								String load_admitPatient[][]=inf.getResultSetAs_2D_Array(qry,3);
								if(load_admitPatient!=null && load_admitPatient.length>0)
								{
									System.out.println("2..................."+load_admitPatient.length);
									if(load_admitPatient.length>=0)
									{
									
									if(load_admitPatient[0][0]!=null)
									{
									
									System.out.println("3...................");
									//System.out.println("a......"+load_admitPatient[0][0]);
									//lbl_BedNo.setText(load_admitPatient[0][0]);
									if(load_admitPatient[0][1]!=null)
									{
									System.out.println("4..................."+load_admitPatient[0][1]);
									Double WardCharge=Double.valueOf(load_admitPatient[0][1]);
									if(load_admitPatient[0][2]!=null)
									{
									System.out.println("5..................."+load_admitPatient[0][2]);
									String condt[]=load_admitPatient[0][2].split("-");
									String dtt[]=condt[2].split(" ");
									int len1=dtt.length;
									for(int j=0;j<len1;j++)
									{
										System.out.println(""+dtt[j]);
									}
									int D=Integer.parseInt(dtt[0]);
									int M=Integer.parseInt(condt[1]);
									int Y=Integer.parseInt(condt[0]);
									dt1.setDate(D);
									dt1.setMonth(M);
									dt1.setYear(Y);
									String dbdate=D+"/"+M+"/"+Y;
									
									long ddb=java.sql.Date.parse((dt1.getMonth())+"/"+(dt1.getDate())+"/"+(dt1.getYear()));
									long curdt=java.sql.Date.parse((dt2.getMonth()+1)+"/"+(dt2.getDate())+"/"+(dt2.getYear()+1900));
									long oneDayValue=86400000; //the long value of 24 hours(one day) is 86400000						
									long diffr=curdt-ddb;
									long day=(diffr/oneDayValue);
									int daydiff=(int)day;
							
									if(daydiff==0)
									{
										daydiff=1;
									}
									else
									{
										daydiff=daydiff;
									}
									bedCharge=WardCharge*daydiff;
									System.out.println("bedCharge========="+bedCharge);
									}
									}
									}
									}
								}
        	///.......
        	//taking total amt
        	totalAmt=eyeSurCharge+gianecSurCharge+otherCharge+medicineCharge+bedCharge;
        	//taking total paid amt
        	double paidAmt=0;
        	query="select amt from receive_Patient_Charges where patientID="+pid+" and status="+false;
        	amt=inf.getResultSetAs_1D_Array(query);
        	if(amt!=null)
        		for(int i=0;i<amt.length;i++)
        			paidAmt+=Double.valueOf(amt[i]);
        	
        	//setting to jTextField---
        	
        	java.math.BigDecimal sum1=new java.math.BigDecimal("0.00");
        	sum1=sum1.add(new java.math.BigDecimal(""+totalAmt));
        	//System.out.println("")
        	jTextField2.setText(""+(sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        	sum1=new java.math.BigDecimal("0.00");
        	sum1=sum1.add(new java.math.BigDecimal(""+paidAmt));
        	jTextField3.setText(""+(sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        	double totalDueAmt=totalAmt-paidAmt;
        	sum1=new java.math.BigDecimal("0.00");
        	sum1=sum1.add(new java.math.BigDecimal(""+totalDueAmt));
        	jTextField4.setText(""+(sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        	
        	
        }
        catch(Exception e)
        {
        	System.out.println("Error in showInitInfo of ReceivePayment class...."+e);
        	return false;
        }
        return true;
	}
    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton2.requestFocus();
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
        	if(showInitInfo());
            	jTextField5.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
    double totalAmt=0,totalPaidAmt=0;
    ZedInterface inf=null;
}
