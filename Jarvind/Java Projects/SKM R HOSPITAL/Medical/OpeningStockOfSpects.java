/*
 * OpeningStockOfSpects.java
 *
 * Created on May 28, 2011, 10:10 AM
 */

//package skm;
import java.rmi.*;
/**
 *
 * @author  Administrator
 */
public class OpeningStockOfSpects extends javax.swing.JInternalFrame {
    
    /** Creates new form OpeningStockOfSpects */
    public OpeningStockOfSpects() {
    	System.out.println("Opening Stock of Spects ");
        initComponents();
     //   jDesktopPane1.add(this);
    // setVisible(true);
    	try
    	{
    		ZedInterface inf=null;
ZedInterfaceForMedical uc=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
    		String query="select gpNm from spectsGroupMaster order by gpNm";
        	String arr[]=inf.getResultSetAs_1D_Array(query);
        	System.out.println("1.."+arr.length);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        		{
        			jComboBox1.addItem(arr[i]);
        		}
        	}
        	query="select cmpName from spectsCmpMaster order by cmpName";
        	arr=inf.getResultSetAs_1D_Array(query);
        	System.out.println("1.."+arr.length);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        		{
        			jComboBox4.addItem(arr[i]);
        		}
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error..1..."+e);
    	}
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
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        getContentPane().setLayout(null);
		setBackground(new java.awt.Color(60, 220, 220));
        setClosable(true);
        setTitle("Opening Stock : Spects");
        jLabel1.setText("Select Group");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 120, 14);

        jLabel2.setText("Select Category");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 45, 120, 14);

        jLabel3.setText("Select Item Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 75, 120, 14);

        jLabel4.setText("Select Related Company");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 105, 150, 14);

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12));
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 140, 120, 15);

        jLabel6.setText("Quantity (In Pcs.)");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 170, 120, 14);

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

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(170, 10, 190, 22);

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });

        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(170, 40, 190, 22);

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

        getContentPane().add(jComboBox3);
        jComboBox3.setBounds(170, 70, 190, 22);

        jComboBox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox4KeyPressed(evt);
            }
        });

        getContentPane().add(jComboBox4);
        jComboBox4.setBounds(170, 100, 190, 22);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField1);
        jTextField1.setBounds(170, 140, 80, 19);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField2);
        jTextField2.setBounds(170, 170, 80, 19);

        jButton1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.gif")));
        jButton1.setMnemonic('S');
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

        getContentPane().add(jButton1);
        jButton1.setBounds(30, 210, 130, 30);

        jButton2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton2.setForeground(new java.awt.Color(0, 0, 153));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton2.setMnemonic('C');
        jButton2.setText("Close");
        jButton2.setToolTipText("Closel");
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
        jButton2.setBounds(210, 210, 130, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
         if(evt.getKeyCode()==10)
        {
            dispose();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        save();
    }//GEN-LAST:event_jButton1ActionPerformed
	private boolean save()
	{
		try
		{
			if(jComboBox1.getSelectedItem()!=null || jComboBox2.getSelectedItem()!=null || jComboBox3.getSelectedItem()!=null || jComboBox4.getSelectedItem()!=null )
			{
				if(jTextField1.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter "+jLabel5.getText(),"Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField1.requestFocus();
					return false;
				}
				if(jTextField2.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField2.requestFocus();
					return false;
				}
				try
				{
					int qty=Integer.parseInt(jTextField2.getText());
					ZedInterface inf=null;
ZedInterfaceForMedical uc=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
					String query="select cmpCode from spectsCmpMaster where cmpName='"+""+jComboBox4.getSelectedItem()+"'";
					String temp=inf.getSingleValue(query);
					int cmpcode=Integer.parseInt(temp);
					query="select catCode from spectsCatMaster where catNm='"+""+jComboBox2.getSelectedItem()+"'";
					temp=inf.getSingleValue(query);
					int catcode=Integer.parseInt(temp);
					query="select itmCode from spectsItemMaster where itmNm='"+""+jComboBox3.getSelectedItem()+"' and catCode="+catcode+"";
					temp=inf.getSingleValue(query);
					int itmcode=Integer.parseInt(temp);
					query="insert into spectsOpeningDtl values("+cmpcode+","+itmcode+",'"+jTextField1.getText()+"',"+qty+")";
					inf.executeUpdateQuery(query);
					///////////code Updated here by S_CHK////////////////
					int quanty=0;
					String qry="Select qty from spectsStockHolding where cmpCode="+cmpcode+" and itmCode="+itmcode+" and size_lense_No='"+jTextField1.getText()+"'";
					String quantity=inf.getSingleValue(qry);
					System.out.println("quantity    "+quantity);
					
					if(quantity!=null)
					{
						quanty=Integer.parseInt(quantity);
						quanty=quanty+qty;
						qry="update spectsStockHolding set qty="+quanty+" where cmpCode="+cmpcode+" and itmCode="+itmcode+" and size_lense_No='"+jTextField1.getText()+"'";
						System.out.println("update qry....."+qry);
						inf.executeUpdateQuery(qry);
						System.out.println("database updated here ");
						
					}
					else
					{
						quanty=qty;
						qry="insert into spectsStockHolding values("+cmpcode+","+itmcode+",'"+jTextField1.getText()+"',"+qty+")";;
						System.out.println("insert qry...."+qry);
						inf.executeUpdateQuery(qry);
						System.out.println("one row inserted here");
					}
										
					
					////////////////////////////////////////////////////
					javax.swing.JOptionPane.showMessageDialog(this,"Data Saved Successfully.","Congratulation !!!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
					jTextField1.setText("");
					jTextField2.setText("");
					return true;
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty (Numbers Only)","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField2.requestFocus();
					jTextField2.selectAll();
					return false;
				}
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Error!\nYou have loss of data.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
				jComboBox1.requestFocus();
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error..save.."+e);
			return false;
		}
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
            jButton1.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
// TODO add your handling code here:
         if(evt.getKeyCode()==10)
        {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jComboBox4KeyPressed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox4.requestFocus();
        }
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox3.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
// TODO add your handling code here:
        setItemNm();
    }//GEN-LAST:event_jComboBox2ActionPerformed
	private void setItemNm()
    {
    	
    	try
    	{
    		ZedInterface inf=null;
ZedInterfaceForMedical uc=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
    		if(jComboBox2.getSelectedItem()!=null)
    		{
    			//System.out.println("1..");
    			if(jComboBox3!=null)
    				jComboBox3.removeAllItems();
    			//System.out.println("2..");
    			String query="select catCode from spectsCatMaster where catNm='"+""+jComboBox2.getSelectedItem()+"'";
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
        					jComboBox3.addItem(arr[i]);
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
    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
// TODO add your handling code here:
		String gpNm=""+jComboBox1.getSelectedItem();
		if(gpNm!=null)
		{
			if(gpNm.equalsIgnoreCase("Frame"))
			{
				jLabel5.setText("Size");
			}
			else if(gpNm.equalsIgnoreCase("Glass"))
			{
				jLabel5.setText("Lens No.");
			}
		}
        setCategory();
    }//GEN-LAST:event_jComboBox1ActionPerformed
    private void setCategory()
    {
    	
    	try
    	{
    		ZedInterface inf=null;
ZedInterfaceForMedical uc=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
    		if(jComboBox1.getSelectedItem()!=null)
    		{
    			//System.out.println("1..");
    			if(jComboBox2!=null)
    				jComboBox2.removeAllItems();
    			//System.out.println("2..");
    			String query="select gpCode from spectsGroupMaster where gpNm='"+""+jComboBox1.getSelectedItem()+"'";
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
        					jComboBox2.addItem(arr[i]);
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    
}