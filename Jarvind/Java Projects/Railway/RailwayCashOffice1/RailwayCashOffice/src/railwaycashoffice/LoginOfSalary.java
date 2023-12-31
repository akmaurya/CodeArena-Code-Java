/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CheckDetailsForEditInfoShow.java
 *
 * Created on Jun 12, 2012, 5:05:28 PM
 */

package railwaycashoffice;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author user2
 */
public class LoginOfSalary extends javax.swing.JDialog {
javax.swing.JDesktopPane dpp;
String pfNo;
    /** Creates new form CheckDetailsForEditInfoShow */
    public LoginOfSalary(java.awt.Frame parent, boolean modal,javax.swing.JDesktopPane dp) {
        super(parent, modal);
        initComponents();
        dpp=dp;
        
        jComboBox1.addItem("Existing Employee");
        jComboBox1.addItem("New Employee Entry");
        //jComboBox1.setSelectedIndex(1);
        javax.swing.ButtonGroup bg=new javax.swing.ButtonGroup();
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        jTextField2.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login For Salary");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Select option to show");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 100, 150, 30);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setToolTipText("Please Enter Employee P.F. No.");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(240, 10, 400, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setToolTipText("Please Select Option");
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
        jComboBox1.setBounds(240, 100, 400, 30);

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Enter P.F. No.");
        jRadioButton1.setToolTipText("Select For Input P.F. No.");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(10, 10, 190, 30);

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton2.setText("Enter Employee Name");
        jRadioButton2.setToolTipText("Select For Input Employee Name");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(10, 50, 190, 30);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField2.setToolTipText("Please Enter Employee Name");
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(240, 50, 400, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 670, 150);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(null);

        jButton1.setMnemonic('l');
        jButton1.setText("Login");
        jButton1.setToolTipText("Login");
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
        jPanel2.add(jButton1);
        jButton1.setBounds(40, 10, 150, 30);

        jButton2.setMnemonic('R');
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
        jPanel2.add(jButton2);
        jButton2.setBounds(260, 10, 150, 30);

        jButton3.setMnemonic('C');
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
        jPanel2.add(jButton3);
        jButton3.setBounds(480, 10, 150, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 170, 670, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton1.requestFocus();
        }

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jButton1.requestFocus();
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            this.dispose();
        }
}//GEN-LAST:event_jButton3KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            refresh();
        }
}//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        refresh();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            login();
            
        }
}//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        login();
}//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton1.isSelected())
        {
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(false);
            jTextField1.setText("");
            jTextField1.requestFocus();
        }
        else
        {
            jTextField2.setEnabled(true);
            jTextField1.setEnabled(false);
            jTextField2.setText("");
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex()==0)
        {
            jRadioButton1.setEnabled(true);
            jRadioButton2.setEnabled(true);
            //jTextField1.setEnabled(true);
            //jTextField2.setEnabled(true);
        }
        else
        {
            jRadioButton1.setEnabled(false);
            jRadioButton2.setEnabled(false);
            jTextField1.setEnabled(false);
            jTextField2.setEnabled(false);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton1.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton2.isSelected())
        {
            jTextField2.setEnabled(true);
            jTextField1.setEnabled(false);
            jTextField2.setText("");
            jTextField2.requestFocus();
        }
        else
        {
            jTextField1.setEnabled(true);
            jTextField2.setEnabled(false);
            jTextField1.setText("");
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginOfSalary dialog = new LoginOfSalary(new javax.swing.JFrame(), true,new javax.swing.JDesktopPane());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    private boolean checkID()
    {
        if(jComboBox1.getSelectedIndex()==0)
        {
            String qry="select pfno from salaryinfo where ";
            if(jRadioButton1.isSelected())
            {
                if(jTextField1.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Enter P.F. No. ?","Error !!!",JOptionPane.ERROR_MESSAGE);
			jTextField1.requestFocus();
			return false;
		}
                else
                {
                       qry+="pfNo='"+jTextField1.getText()+"'" ;
                }
            }
            else if(jRadioButton2.isSelected())
            {
                if(jTextField2.getText().trim().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Enter Employee Name ?","Error !!!",JOptionPane.ERROR_MESSAGE);
			jTextField2.requestFocus();
			return false;
		}
                else
                {
                       qry+="empName='"+jTextField2.getText().toUpperCase()+"'" ;
                }
            }
            try
            {
                interfaceRailway inf=null;
		try
		{
			inf=(interfaceRailway)java.rmi.Naming.lookup(getIPaddress.IP());
		}
		catch(Exception e)
		{
				System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
				getIPaddress.changeIP();
				try
				{
					inf=(interfaceRailway)java.rmi.Naming.lookup(getIPaddress.IP());
				}
				catch(Exception ex)
				{
					System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
                                        return false;
				}
		}
		String check1=inf.getSigetngleValue(qry,Main.year);
                if(check1.equals("") || check1==null)
		{
                        System.out.println("No Info Found...");
                        if(jTextField1.isEnabled())
                        {
                            JOptionPane.showMessageDialog(null,"Wrong P.F. No.\nPlease Input Valid P.F. No.","Error !!!",JOptionPane.ERROR_MESSAGE);
                            jTextField1.requestFocus();
                            jTextField1.selectAll();
                        }
                        else if(jTextField2.isEnabled())
                        {
                            JOptionPane.showMessageDialog(null,"Wrong Employee Name.\nPlease Input Correct Employee Name.","Error !!!",JOptionPane.ERROR_MESSAGE);
                            jTextField2.requestFocus();
                            jTextField2.selectAll();
                        }
			return false;
                }
                else
                {
                    pfNo=check1;
                    return true;
                }
            }
            catch(Exception e)
            {
                System.out.println("Er....123456..."+e);
                return false;
            }
        }
        else
        {
            pfNo=null;
            return true;
        }
    }
    private void refresh()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jComboBox1.setSelectedIndex(0);
        jRadioButton1.setSelected(true);
        jTextField2.setEnabled(false);
        jTextField1.requestFocus();
    }
    private void login()
    {
        if(checkID()) {
            this.dispose();
            if(jComboBox1.getSelectedIndex()==0)
            {
                SalaryWindow MNF=new SalaryWindow(pfNo,"");
                dpp.add(MNF);
                MNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                MNF.setBounds(250,30, 900, 520);
                MNF.show();
            }
            else
            {
                SalaryWindow MNF=new SalaryWindow(pfNo,"");
                dpp.add(MNF);
                MNF.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                MNF.setBounds(250,30, 900, 520);
                MNF.show();
            }
        }
    }
}
