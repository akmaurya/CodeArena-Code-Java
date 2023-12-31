/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChequeReceiveByDC.java
 *
 * Created on Jul 18, 2012, 10:27:52 AM
 */

package railwaycashoffice;

import java.awt.Color;
import java.math.BigInteger;

/**
 *
 * @author welcome
 */
public class ChequeReceiveByDC extends javax.swing.JInternalFrame {

    /** Creates new form ChequeReceiveByDC */
    public ChequeReceiveByDC() {
        initComponents();
        java.util.Date dt=new java.util.Date();
        int date=dt.getDate();
        int month=dt.getMonth()+1;
        int yr=dt.getYear()+1900;
        String setDate=date+"-"+month+"-"+yr;
        jLabel9.setText(setDate);
        addDepartmentNameInList();
        /*interfaceRailway object1=null;
		try
		{
			object1=(interfaceRailway)java.rmi.Naming.lookup(getIPaddress.IP());

                        String alterqry="ALTER TABLE dc_chq_details ADD chq_status INT";
                        object1.saveInformation(alterqry, Main.year);
                        alterqry="ALTER TABLE dc_chq_details ADD sq_no INT";
                        object1.saveInformation(alterqry, Main.year);
                        alterqry="ALTER TABLE dc_chq_details ADD clearance_date Date";
                        object1.saveInformation(alterqry, Main.year);
                        String updateqry="update dc_chq_details set chq_status=0";
                        object1.saveInformation(updateqry, Main.year);
                        //setDate=yr+"-"+month+"-"+date;
                        //updateqry="update dc_chq_details set clearance_date='"+setDate+"'";
                        //object1.saveInformation(updateqry, Main.year);

		}
		catch(Exception e)
		{
				System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
				getIPaddress.changeIP();
				try
				{
					object1=(interfaceRailway)java.rmi.Naming.lookup(getIPaddress.IP());
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
				}
		}
         *
         */

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("CHEQUE RECEIVING BY DC");
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Cheque Amount (In Rs.)");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 115, 170, 25);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Select Department");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 50, 140, 26);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel5.setText("Cheque Receiving Date");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 20, 170, 20);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel6.setText("Cheque No.");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 83, 140, 25);

        jLabel9.setBackground(new java.awt.Color(255, 255, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel9");
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(200, 20, 190, 25);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railwaycashoffice/images/calendar.png"))); // NOI18N
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
        jButton1.setBounds(390, 20, 30, 25);

        jComboBox1.setForeground(new java.awt.Color(0, 0, 255));
        jComboBox1.setToolTipText("Please select department");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(200, 50, 220, 26);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(200, 83, 220, 25);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(200, 115, 220, 25);

        jButton3.setMnemonic('s');
        jButton3.setText("Receive Cheque");
        jButton3.setToolTipText("Save Information");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton3FocusLost(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton3KeyPressed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(50, 180, 160, 30);

        jButton2.setMnemonic('c');
        jButton2.setText("Close");
        jButton2.setToolTipText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton2FocusLost(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(230, 180, 160, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Cal date1=new Cal();
        jLabel9.setText(date1.getdate());
        jComboBox1.requestFocus();
        
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            Cal date1=new Cal();
            jLabel9.setText(date1.getdate());
        }
}//GEN-LAST:event_jButton1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        //  javax.swing.JOptionPane.showMessageDialog(null,"coming here first.....");
        
        //setData();
}//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        // TODO add your handling code here:
        //jComboBox1.setForeground(Color.red);
        jComboBox1.setBackground(java.awt.Color.yellow);
}//GEN-LAST:event_jComboBox1FocusGained

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        // TODO add your handling code here:
        jComboBox1.setBackground(java.awt.Color.white);
        //jComboBox1.setForeground(Color.black);
}//GEN-LAST:event_jComboBox1FocusLost

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jTextField1.requestFocus();
        }
}//GEN-LAST:event_jComboBox1KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusGained
        // TODO add your handling code here:
        //jButton3.setForeground(Color.red);
        jButton3.setBackground(Color.yellow);
}//GEN-LAST:event_jButton3FocusGained

    private void jButton3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusLost
        // TODO add your handling code here:
        //jButton3.setForeground(Color.black);
        jButton3.setBackground(Color.white);
    }//GEN-LAST:event_jButton3FocusLost

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            saveData();
            
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        // TODO add your handling code here:
        //jButton2.setForeground(Color.red);
        jButton2.setBackground(Color.yellow);
    }//GEN-LAST:event_jButton2FocusGained

    private void jButton2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusLost
        // TODO add your handling code here:
        //jButton2.setForeground(Color.black);
        jButton2.setBackground(Color.white);
    }//GEN-LAST:event_jButton2FocusLost

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            this.dispose();
}//GEN-LAST:event_jButton2KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jTextField2.requestFocus();
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jButton3.requestFocus();
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        jTextField1.setBackground(Color.yellow);
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        jTextField1.setBackground(Color.white);
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
        jTextField2.setBackground(Color.yellow);
    }//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
        jTextField2.setBackground(Color.white);
    }//GEN-LAST:event_jTextField2FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables


    private void addDepartmentNameInList()
    {
        try
        {
             interfaceRailway object1=null;
		try
		{
			object1=(interfaceRailway)java.rmi.Naming.lookup(getIPaddress.IP());
		}
		catch(Exception e)
		{
				System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
				getIPaddress.changeIP();
				try
				{
					object1=(interfaceRailway)java.rmi.Naming.lookup(getIPaddress.IP());
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
				}
		}
             String qry="Select dp_name from department_detail order by dp_code";
             String[] load=object1.getResultSetAs_1D_Array(qry,Main.year);
             jComboBox1.removeAllItems();
            if(load!=null && load.length>0)
            {
                for(int i=0;i<load.length;i++)
                {
                    jComboBox1.addItem(load[i]);
                }
            }

        }
        catch(Exception ex)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error no 891..."+ex);
        }
    }

    private boolean saveData()
    {
        if(Utility.isBlank(jTextField1.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error!\nEnter cheque number.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            return false;
        }
        if(Utility.isBlank(jTextField2.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error!\nEnter cheque amount.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            return false;
        }
        if(Utility.isDouble(jTextField2.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error!\nInvalid cheque amount found.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            jTextField1.selectAll();
            return false;
        }
        try
        {
                interfaceRailway object1=null;
		try
		{
			object1=(interfaceRailway)java.rmi.Naming.lookup(getIPaddress.IP());
		}
		catch(Exception e)
		{
				System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
				getIPaddress.changeIP();
				try
				{
					object1=(interfaceRailway)java.rmi.Naming.lookup(getIPaddress.IP());
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
				}
		}

            String qry="Select dp_code from department_detail where dp_name='"+jComboBox1.getSelectedItem()+"'";
            int dpCode=Integer.parseInt(object1.getSigetngleValue(qry, Main.year));
            String d1[]=jLabel9.getText().split("-");
            String setDate=d1[2]+"-"+d1[1]+"-"+d1[0];
            String chqNo=jTextField1.getText().trim();
            double chqAmt=Double.valueOf(jTextField2.getText().trim());
            
            /*qry="select cash_amt from dc_cash_in_hand where rec_date>'"+setDate+"'";
            String str1=object1.getSigetngleValue(qry, Main.year);
            if(str1!=null && str1.equals("")==false)
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Error!\nEntry for selected date is not possible.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }
             *
             */
            qry="select count(sq_no) from dc_chq_details";
            int srno=Integer.parseInt(object1.getSigetngleValue(qry, Main.year))+1;
            qry="insert into dc_chq_details values("+dpCode+",'"+setDate+"','"+chqNo+"',"+chqAmt+",0,"+srno+",'"+setDate+"')";
            boolean response=object1.saveInformation(qry, Main.year);
            if(response==true)
            {
                /*
                qry="select cash_amt from dc_cash_in_hand where rec_date='"+setDate+"'";
                String str=object1.getSigetngleValue(qry, Main.year);
                if(str!=null && str.equals("")==false)
                {
                    java.math.BigDecimal bd=new java.math.BigDecimal(str);
                    bd=bd.add(new java.math.BigDecimal(jTextField2.getText().trim()));
                    qry="update dc_cash_in_hand set cash_amt="+bd+" where rec_date='"+setDate+"'";
                    response=object1.saveInformation(qry, Main.year);
                }
                else
                {
                    qry="select cash_amt from dc_cash_in_hand where rec_date<'"+setDate+"' order by rec_date desc";
                    String cash_amt_arr[]=object1.getResultSetAs_1D_Array(qry, Main.year);
                    if(cash_amt_arr!=null)
                    {
                        if(cash_amt_arr.length>0)
                        {
                            //get cash amt of last date &
                            //then add todays cheque amt.
                            java.math.BigDecimal bd=new java.math.BigDecimal(cash_amt_arr[0]);
                            bd=bd.add(new java.math.BigDecimal(jTextField2.getText().trim()));
                            //qry="update dc_cash_in_hand set cash_amt="+bd;
                             qry="insert into dc_cash_in_hand values("+bd+",'"+setDate+"')";
                             response=object1.saveInformation(qry, Main.year);
                        }
                        else
                        {
                            java.math.BigDecimal bd=new java.math.BigDecimal(jTextField2.getText().trim());                            
                            qry="insert into dc_cash_in_hand values("+bd+",'"+setDate+"')";
                            response=object1.saveInformation(qry, Main.year);
                        }
                    }
                }
                */
            }
            if(response==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Ok!\nCheque details saved successfully.", "Message",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jTextField1.setText("");
                jTextField2.setText("");
                jComboBox1.requestFocus();
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Error!\nSome problem found.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        }
        catch(Exception ex)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error no 891..."+ex);
        }
        return true;
    }
}
