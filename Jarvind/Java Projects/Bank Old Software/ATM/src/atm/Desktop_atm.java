/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Desktop_atm.java
 *
 * Created on Apr 30, 2013, 6:40:04 PM
 */

package atm;

/**
 *
 * @author DEEP PAL
 */
public class Desktop_atm extends javax.swing.JFrame {

    /** Creates new form Desktop_atm */
    public Desktop_atm() {
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("KGSG ");
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setMnemonic('f');
        jMenu1.setText("Update Files          ");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Update KGSG Data");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed1(evt);
            }
        });
        jMenuItem1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItem1KeyPressed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Update UBI Data ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuItem2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItem2KeyPressed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem5.setText("Update UBI Account Statement");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem11.setForeground(new java.awt.Color(204, 0, 0));
        jMenuItem11.setText("Exit");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenuItem11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenuItem11KeyPressed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu5.setMnemonic('p');
        jMenu5.setText("Reconcile Process           ");

        jMenuItem3.setText("Start Breaking UBI Records");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed1(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem4.setText("Start Reconcile KGSG Records");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        jMenu4.setMnemonic('r');
        jMenu4.setText("Report               ");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem8.setText("UBI Account Statement");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed1(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuItem14.setText("UBI Account Statement Other Information");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);
        jMenu4.add(jSeparator1);

        jMenuItem9.setText("KGSG Not Reconcile  Report");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed1(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuItem13.setText("KGSG Reconcile Report");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem13);

        jMenuItem12.setText("Searching Records in KGSG");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed1(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem10.setText("KGSG Auto Reversal Report");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);
        jMenu4.add(jSeparator2);

        jMenuItem7.setText("UBI Reconcile Report");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem6.setText("UBI Not Reconcile Report");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);
        jMenu4.add(jSeparator3);

        jMenuItem15.setText("Last 100 Records In UBI KGSG And CD Files");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        DataBackupOfKGSGUsedInUBIAtm frm=new DataBackupOfKGSGUsedInUBIAtm();
        frm.reshape(20, 20, 400, 300);
        jDesktopPane1.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        DataBackupOfUBIBillOfUsedKGSGCard frm=new DataBackupOfUBIBillOfUsedKGSGCard();
        frm.reshape(100, 70, 789, 335);
        jDesktopPane1.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        matching_ubi_from_account_st fr1=new matching_ubi_from_account_st();
        fr1.reshape(130, 0, 744, 696);
        jDesktopPane1.add(fr1);
        fr1.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        matching_kgsg_From_account_st fr=new matching_kgsg_From_account_st();
        fr.reshape(30, 0, 953, 690);
        jDesktopPane1.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        ubi_account_statement fr=new ubi_account_statement();
        fr.reshape(100, 80, 800, 334);
        jDesktopPane1.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed1
        // TODO add your handling code here:
        matching_ubi_from_account_st fr2=new matching_ubi_from_account_st();
        fr2.reshape(30, 0, 960, 690);
        jDesktopPane1.add(fr2);
        fr2.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed1

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        UBI_Not_matched fr3=new UBI_Not_matched();
        fr3.reshape(0, 0, 1022, 690);
        jDesktopPane1.add(fr3);
        fr3.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        UBI_Matched_Records_From_UBI_Account_st fr4=new UBI_Matched_Records_From_UBI_Account_st();
        fr4.reshape(0, 0, 1022, 690);
        jDesktopPane1.add(fr4);
        fr4.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        UBI_Account_st_matched fr5=new UBI_Account_st_matched();
        fr5.reshape(50, 0, 911, 688);
        jDesktopPane1.add(fr5);
        fr5.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        KGSG_Not_Matched_With_UBI fr6=new KGSG_Not_Matched_With_UBI();
        fr6.reshape(50, 0, 1023, 692);
        jDesktopPane1.add(fr6);
        fr6.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem1ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed1
        // TODO add your handling code here:
        DataBackupOfKGSGUsedInUBIAtm frm=new DataBackupOfKGSGUsedInUBIAtm();
        frm.reshape(150, 100, 693, 311);
        jDesktopPane1.add(frm);
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed1

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        KGSG_autoReversal_Report ar= new KGSG_autoReversal_Report();
        ar.reshape(0, 0, 1023, 690);
        jDesktopPane1.add(ar);
        ar.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItem11KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem11KeyPressed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        KGSG_ReconcilewithUbi fr6=new KGSG_ReconcilewithUbi();
        fr6.reshape(35, 0, 1022, 690);
        jDesktopPane1.add(fr6);
        fr6.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem8ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed1
        // TODO add your handling code here:
        UBI_Account_st_matched fr5=new UBI_Account_st_matched();
        fr5.reshape(0, 0, 1022, 690);
        jDesktopPane1.add(fr5);
        fr5.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed1

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        KGSG_Reconcile_Report urr=new KGSG_Reconcile_Report();
        urr.reshape(0, 0, 1021, 692);
        jDesktopPane1.add(urr);
        urr.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        CD_Reversal_data ur=new CD_Reversal_data();
        ur.reshape(15, 0, 992, 691);
        jDesktopPane1.add(ur);
        ur.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItem1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            DataBackupOfKGSGUsedInUBIAtm frm=new DataBackupOfKGSGUsedInUBIAtm();
            frm.reshape(150, 100, 693, 311);
            jDesktopPane1.add(frm);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1KeyPressed

    private void jMenuItem2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenuItem2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            DataBackupOfUBIBillOfUsedKGSGCard frm=new DataBackupOfUBIBillOfUsedKGSGCard();
            frm.reshape(100, 70, 789, 335);
            jDesktopPane1.add(frm);
            frm.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2KeyPressed

    private void jMenuItem9ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed1
        // TODO add your handling code here:
        KGSG_Not_Matched_With_UBI fr6=new KGSG_Not_Matched_With_UBI();
        fr6.reshape(0, 0, 1023, 692);
        jDesktopPane1.add(fr6);
        fr6.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed1

    private void jMenuItem12ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed1
        // TODO add your handling code here:
        KGSG_ReconcilewithUbi fr6=new KGSG_ReconcilewithUbi();
        fr6.reshape(0, 0, 1022, 690);
        jDesktopPane1.add(fr6);
        fr6.setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed1

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
        last100Records lst=new last100Records();
        lst.reshape(2, 0, 1018, 695);
        jDesktopPane1.add(lst);
        lst.setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Desktop_atm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    // End of variables declaration//GEN-END:variables

}