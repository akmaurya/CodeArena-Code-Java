/*
 * ChangePassword.java
 *
 * Created on May 23, 2010, 11:17 PM
 */

//package medretail;
import java.rmi.*;
import javax.swing.*;
/**
 *
 * @author  Deep Pal
 */
public class ChangePasswordOfDoctors extends javax.swing.JInternalFrame {
    
    /** Creates new form ChangePassword */
    public ChangePasswordOfDoctors(javax.swing.JDesktopPane jDesktopPane1) {
        initComponents();
        JLabel lbl=new JLabel();
        lbl.setFont(new java.awt.Font("Arial", 1, 11));
        lbl.setText("Enter Doctor Code");
        jPanel1.add(lbl);
        lbl.setBounds(20, 20, 130, 20);
        
        tf1=new JTextField("");
        jPanel1.add(tf1);
        tf1.setBounds(180, 20, 300, 20);
        tf1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf1KeyPressed(evt);
            }
        });
        
        java.awt.Cursor cursor;
        cursor = new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR);
        
        jButton4.setCursor(cursor);
        jButton5.setCursor(cursor);
        
        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        reshape((dm.width-800)/2,(dm.height-600)/2,540,290);
        jDesktopPane1.add(this);
        setVisible(true);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 0)));
        //setMaximizable(true);
        //setResizable(true);
        setClosable(true);
        setTitle("Change Password");
        jPanel1.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel1.setText("Old password");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 50, 130, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel2.setText("New password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 80, 130, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel3.setText("Re-enter new password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 150, 20);

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 204));
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyPressed(evt);
            }
        });

        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(180, 50, 300, 20);

        jPasswordField2.setBackground(new java.awt.Color(204, 255, 255));
        jPasswordField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField2KeyPressed(evt);
            }
        });

        jPanel1.add(jPasswordField2);
        jPasswordField2.setBounds(180, 80, 300, 20);

        jPasswordField3.setBackground(new java.awt.Color(204, 255, 204));
        jPasswordField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField3KeyPressed(evt);
            }
        });

        jPanel1.add(jPasswordField3);
        jPasswordField3.setBounds(180, 110, 300, 20);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.gif")));
        jButton4.setMnemonic('w');
        jButton4.setText("Change Password");
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

        jPanel1.add(jButton4);
        jButton4.setBounds(150, 170, 210, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton5.setMnemonic('c');
        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });

        jPanel1.add(jButton5);
        jButton5.setBounds(370, 170, 110, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 500, 230);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jButton4.requestFocus();
    }//GEN-LAST:event_jPasswordField3KeyPressed

    private void jPasswordField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jPasswordField3.requestFocus();

    }//GEN-LAST:event_jPasswordField2KeyPressed

	private void tf1KeyPressed(java.awt.event.KeyEvent evt) {
			if(evt.getKeyCode()==10)
            jPasswordField1.requestFocus();
		}
    private void jPasswordField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jPasswordField2.requestFocus();
    }//GEN-LAST:event_jPasswordField1KeyPressed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)    updatePassword();
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        updatePassword();
    }//GEN-LAST:event_jButton4ActionPerformed
    private void updatePassword()
    {
        try
        {
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs;*/
            String ps=jPasswordField1.getText().trim();
            String newps=jPasswordField2.getText().trim();
            String cnfps=jPasswordField3.getText().trim();
            //utilityClass uc=new utilityClass();
           // ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
           	
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
										System.out.println("Error at the time of connection with server ip-rmi://127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
           
           
           
           
           
           
           
           
           
           
           
            //ZedInterfaceForMedical uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
            ZedInterfaceForMedical uc=null;
       	try
		{
								uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
				
				
		}
		catch(Exception e)
		{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							getIPaddress.changeIP();
									try
									{
										uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
		}
            if(uc.isBlank(ps)==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter old password.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jPasswordField1.requestFocus();
            }
            else if(uc.isBlank(newps)==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter new password.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jPasswordField2.requestFocus();
            }
            else if(uc.isBlank(cnfps)==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter confirm password.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jPasswordField3.requestFocus();
            }
            else if(newps.equals(cnfps)==false)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nNew password and Confirm password must be same.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jPasswordField2.requestFocus();                
                jPasswordField2.selectAll();
            }
            else
            {
            	int dr_code;
            	dr_code=Integer.parseInt(tf1.getText());
                String qry="select drPws from drDetail where drPws='"+ps+"' and drCode="+dr_code+"";
                String rs=inf.getSingleValue(qry);
                if(rs!=null)
                {
                    inf.executeUpdateQuery("update drDetail set drPws='"+newps+"' where drCode="+dr_code+"");
                    javax.swing.JOptionPane.showMessageDialog(this,"Congratulation!\nPassword changed successfully.");
                
                    //connection.close();
                    this.dispose();
                }
                else
                {
                    javax.swing.JOptionPane.showMessageDialog(this,"Error!\nWrong existing id or password found.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                    jPasswordField1.requestFocus();
                    jPasswordField1.selectAll();
                }
            }    
            //connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...291..."+ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    JTextField tf1;
    ZedInterface inf;
    // End of variables declaration//GEN-END:variables
    
}