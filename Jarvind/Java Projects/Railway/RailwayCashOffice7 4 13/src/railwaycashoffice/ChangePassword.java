/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChangePassword.java
 *
 * Created on Jun 5, 2012, 11:02:51 AM
 */

/**
 *
 * @author user2
 */
package railwaycashoffice;
public class ChangePassword extends javax.swing.JInternalFrame {

    /** Creates new form ChangePassword */
    public ChangePassword() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(131, 170, 165));
        setClosable(true);
        setIconifiable(true);
        setTitle("Change Password");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(198, 238, 238));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel2.setText("Re - Enter New Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 130, 180, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel3.setText("Enter User ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 10, 180, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Enter Current Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 50, 180, 30);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel5.setText("Enter New Password");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 90, 180, 30);

        jTextField1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jTextField1.setToolTipText("Please Enter User ID");
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
        jPanel1.add(jTextField1);
        jTextField1.setBounds(250, 10, 260, 30);

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jPasswordField1.setToolTipText("Please Enter Currrent Password");
        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusLost(evt);
            }
        });
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(250, 50, 260, 30);

        jPasswordField2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jPasswordField2.setToolTipText("Please Enter New Password");
        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusLost(evt);
            }
        });
        jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyPressed(evt);
            }
        });
        jPanel1.add(jPasswordField2);
        jPasswordField2.setBounds(250, 90, 260, 30);

        jPasswordField3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jPasswordField3.setToolTipText("Please Re Enter Password");
        jPasswordField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField3FocusLost(evt);
            }
        });
        jPasswordField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField3KeyPressed(evt);
            }
        });
        jPanel1.add(jPasswordField3);
        jPasswordField3.setBounds(250, 130, 260, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 530, 170);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton1.setMnemonic('S');
        jButton1.setText("Save");
        jButton1.setToolTipText("Save");
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
        jPanel2.add(jButton1);
        jButton1.setBounds(20, 10, 140, 40);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton2.setMnemonic('R');
        jButton2.setText("Refresh");
        jButton2.setToolTipText("Refresh");
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
        jPanel2.add(jButton2);
        jButton2.setBounds(195, 10, 140, 40);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton3.setMnemonic('C');
        jButton3.setText("Close");
        jButton3.setToolTipText("Close");
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
        jPanel2.add(jButton3);
        jButton3.setBounds(370, 10, 140, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 190, 530, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jPasswordField1.requestFocus();
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jPasswordField2.requestFocus();
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jPasswordField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jPasswordField3.requestFocus();
    }//GEN-LAST:event_jPasswordField2KeyPressed

    private void jPasswordField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jButton1.requestFocus();
    }//GEN-LAST:event_jPasswordField3KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            refresh();
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            this.dispose();
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            if(changePassword())
                javax.swing.JOptionPane.showMessageDialog(this,"Password changed successfully.");
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(changePassword())
            javax.swing.JOptionPane.showMessageDialog(this,"Password changed successfully.");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
          jTextField1.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        jTextField1.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_jTextField1FocusLost

    private void jPasswordField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusGained
        // TODO add your handling code here:
        jPasswordField1.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_jPasswordField1FocusGained

    private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusLost
        // TODO add your handling code here:
        jPasswordField1.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_jPasswordField1FocusLost

    private void jPasswordField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusGained
        // TODO add your handling code here:
        jPasswordField2.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_jPasswordField2FocusGained

    private void jPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusLost
        // TODO add your handling code here:
         jPasswordField2.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_jPasswordField2FocusLost

    private void jPasswordField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField3FocusGained
        // TODO add your handling code here:
         jPasswordField3.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_jPasswordField3FocusGained

    private void jPasswordField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField3FocusLost
        // TODO add your handling code here:
        jPasswordField3.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_jPasswordField3FocusLost

    private void jButton1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusGained
        // TODO add your handling code here:
        jButton1.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_jButton1FocusGained

    private void jButton1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton1FocusLost
        // TODO add your handling code here:
         jButton1.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_jButton1FocusLost

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        // TODO add your handling code here:
         jButton2.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_jButton2FocusGained

    private void jButton2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusLost
        // TODO add your handling code here:
        jButton2.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_jButton2FocusLost

    private void jButton3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusGained
        // TODO add your handling code here:
        jButton3.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_jButton3FocusGained

    private void jButton3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusLost
        // TODO add your handling code here:
        jButton3.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_jButton3FocusLost
private void refresh()
{
    jTextField1.setText("");
    jPasswordField1.setText("");
    jPasswordField2.setText("");
    jPasswordField3.setText("");
    jButton1.setEnabled(true);
    jTextField1.requestFocus();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
private boolean changePassword()
{
    if(jTextField1.getText().equals(""))
    {
        javax.swing.JOptionPane.showMessageDialog(this,"Please input user id ?");
        jTextField1.requestFocus();
        return false;
    }
    else if(jPasswordField1.getText().equals(""))
    {
        javax.swing.JOptionPane.showMessageDialog(this,"Please input current password ?");
        jPasswordField1.requestFocus();
        return false;
    }
    else if(jPasswordField2.getText().equals(""))
    {
        javax.swing.JOptionPane.showMessageDialog(this,"Please input new password ?");
        jPasswordField2.requestFocus();
        return false;
    }
    else if(jPasswordField3.getText().equals(""))
    {
        javax.swing.JOptionPane.showMessageDialog(this,"Please input again new password ?");
        jPasswordField3.requestFocus();
        return false;
    }
    else if(!(jPasswordField2.getText().equals(jPasswordField3.getText())))
    {
        javax.swing.JOptionPane.showMessageDialog(this,"Both password should be same ?");
        jPasswordField3.requestFocus();
        jPasswordField3.selectAll();
        return false;
    }
    else
    {
        try
        {
            if(checkID())
            {
                if(checkPws())
                {
                    //interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
                    String qry="update loginMaster set uPws='"+jPasswordField2.getText()+"' where uId='"+jTextField1.getText()+"'";
                    object1.saveInformation(qry,Main.year);
                    jButton1.setEnabled(false);
                    return true;
                }
                else
                {
                    javax.swing.JOptionPane.showMessageDialog(this,"Please input correct password ?");
                    jPasswordField1.requestFocus();
                    jPasswordField1.selectAll();
                    return false;
                }
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Please input correct user id ?");
                jTextField1.requestFocus();
                jTextField1.selectAll();
                return false;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in changePassword Method of ChangePassword class...."+e);
            return false;
        }
    }
}
private boolean checkID()
    {
        try
        {
            //interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
            String qry="select uId from loginMaster where uId='"+jTextField1.getText()+"'";
            String chk=object1.getSigetngleValue(qry, Main.year);
            if(chk.equals(""))
                return false;
            else
                return true;
        }
        catch(Exception e)
        {
            System.out.println("Errrror....."+e);
            return false;
        }
    }
    private boolean checkPws()
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
            String qry="select uId from loginMaster where uId='"+jTextField1.getText()+"' and uPws='"+jPasswordField1.getText()+"'";
            String chk=object1.getSigetngleValue(qry, Main.year);
            if(chk.equals(""))
                return false;
            else
                return true;
        }
        catch(Exception e)
        {
            System.out.println("Errrror....."+e);
            return false;
        }
    }
}
