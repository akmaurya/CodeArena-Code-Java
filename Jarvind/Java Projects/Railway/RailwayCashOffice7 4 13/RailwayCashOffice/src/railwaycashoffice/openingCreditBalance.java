/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * openingCreditBalance.java
 *
 * Created on May 24, 2012, 6:42:29 PM
 */

package railwaycashoffice;

/**
 *
 * @author Shweta
 */
public class openingCreditBalance extends javax.swing.JInternalFrame {

    /** Creates new form openingCreditBalance */
    public openingCreditBalance() {
        initComponents();
        jTextField1.setText("");
        loadInitialInfo();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(191, 163, 113));
        setTitle("Opening Credit Balance");
        getContentPane().setLayout(null);

        jComboBox1.setToolTipText("Please select cashier number");
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
        jComboBox1.setBounds(160, 30, 240, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Cashier Number");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 130, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Opening Credit Balanace In Rs.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 210, 20);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("jTextField1");
        jTextField1.setToolTipText("Please input credit balance");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(240, 80, 160, 25);

        jButton1.setMnemonic('u');
        jButton1.setText("Update");
        jButton1.setToolTipText("Update Information");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton1FocusLost(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(30, 160, 160, 30);

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
        jButton2.setBounds(240, 160, 160, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        uploadDetail();
}//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jTextField1.requestFocus();
        }
}//GEN-LAST:event_jComboBox1KeyPressed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        jTextField1.selectAll();
}//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jButton1.requestFocus();
        }
}//GEN-LAST:event_jTextField1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Save();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusGained
        // TODO add your handling code here:
        //jButton1.setForeground(Color.red);
}//GEN-LAST:event_jButton1FocusGained

    private void jButton1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusLost
        // TODO add your handling code here:
       // jButton1.setForeground(Color.black);
}//GEN-LAST:event_jButton1FocusLost

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            Save();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        // TODO add your handling code here:
        //jButton2.setForeground(Color.red);
}//GEN-LAST:event_jButton2FocusGained

    private void jButton2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusLost
        // TODO add your handling code here:
       // jButton2.setForeground(Color.black);
}//GEN-LAST:event_jButton2FocusLost

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            this.dispose();
    }//GEN-LAST:event_jButton2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
private void loadInitialInfo()
{
    try
    {

       // interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
        String qry="Select cashier_number from cashier_detail order by cashier_number";
        String load[]=object1.getResultSetAs_1D_Array(qry,Main.year);
        if(load!=null)
        {
            for(int i=0;i<load.length;i++)
            {
                jComboBox1.addItem(load[i]);
            }
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method."+e);
    }

}
private boolean Save()
{
    try
    {
      //  interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
         if(jTextField1.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Please input credit amount.");
            jTextField1.requestFocus();
            return false;
        }
        if(object1.isDouble(jTextField1.getText().trim())==false)
        {
              javax.swing.JOptionPane.showMessageDialog(null,"Please input number type(credit amount) value.");
              jTextField1.requestFocus();
              jTextField1.selectAll();
              return false;
        }

        String qry="Select cashier_code from cashier_detail where cashier_number="+Integer.parseInt(""+jComboBox1.getSelectedItem())+"";
        String getCode=object1.getSigetngleValue(qry, Main.year);

        qry="select creditbalance from cashier_creditbalance where cashier_code="+Integer.parseInt(getCode);
        String getAmt=object1.getSigetngleValue(qry, Main.year);

        if(getAmt!=null)
        {
            qry="update cashier_creditbalance set creditbalance="+Double.valueOf(jTextField1.getText().trim())+" where cashier_code="+Integer.parseInt(getCode)+"";
            boolean bn=object1.saveInformation(qry, Main.year);
            if(bn)
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Process Completed");
                jTextField1.setText("");
                uploadDetail();
                jComboBox1.requestFocus();
            }
        }


    }
    catch(Exception e)
    {
        System.out.println("Error ! In cashierCode Method."+e);
    }
    return true;
}
private void uploadDetail()
{
    try
    {
      //  interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
        String qry="Select cashier_code from cashier_detail where cashier_number="+Integer.parseInt(""+jComboBox1.getSelectedItem());
        String getCode=object1.getSigetngleValue(qry,Main.year);
        qry="Select creditbalance from cashier_creditbalance where cashier_code="+Integer.parseInt(getCode);
        String getOpening=object1.getSigetngleValue(qry,Main.year);
        jTextField1.setText((""+new java.math.BigDecimal(Double.valueOf(getOpening)).setScale(2,5)));
        jTextField1.selectAll();

    }
    catch(Exception e)
    {
        System.out.println("Error ! In uploadDetail Method."+e);
    }

}
}
