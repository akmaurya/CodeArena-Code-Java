/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MasterScreen.java
 *
 * Created on Apr 26, 2014, 1:00:55 PM
 */

package p3;

/**
 *
 * @author welcome
 */
public class MasterScreen extends javax.swing.JFrame {
String userid;
String cName=null;
String finyear=null;
    /** Creates new form MasterScreen */
    public MasterScreen(String uid,int ulevel,String cnm,String finyer) {
        initComponents();
        userid=uid;
        cName=cnm;
        finyear=finyer;
        setTitle("W E L C O M E   I N   "+cnm+"   R U N N I N G   F I N A N C I A L   Y E A R   "+finyear.substring(0,2)+"-"+finyear.substring(2,4)+".");
        if(ulevel==0)
        {}
        else
        {
            //jMenuItem26.setVisible(false);//Since only admin can create new financial year
            //providedMenuItem();
        }
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
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Master               ");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Company Master");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setText("Create Compound Unit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenu7.setText("Inventry Master");

        jMenuItem1.setText("Item Master");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem1);

        jMenuItem3.setText("Tank Master");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem3);

        jMenuItem6.setText("Nozzle Master");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem6);

        jMenu1.add(jMenu7);

        jMenu5.setText("Account");

        jMenuItem10.setText(" Ledger");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);

        jMenuItem11.setText(" Ledger Group");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenu1.add(jMenu5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Purchase Transaction               ");

        jMenuItem7.setText("Purchase Ledger");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Purza Purchase Ledger");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setText("Purza Payment Ledger");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sales Transaction               ");

        jMenuItem5.setText("Point Of Sales");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem12.setText("Sale Register");
        jMenu4.add(jMenuItem12);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Daily Work               ");

        jMenuItem13.setText("Nozzle Sale Entry");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem13);

        jMenuItem14.setText("Deep Entry ");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem14);

        jMenuBar1.add(jMenu6);

        jMenu2.setForeground(new java.awt.Color(204, 0, 0));
        jMenu2.setText("Exit                ");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        ItemMaster tm=new ItemMaster(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-320, ((sd.height-100)/2)-300, 1000, 640);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        // TODO add your handling code here:
        int x=javax.swing.JOptionPane.showConfirmDialog(this, "Do you want to exit it?", "Exit Confirmation", javax.swing.JOptionPane.YES_NO_OPTION);
        if(x==javax.swing.JOptionPane.YES_OPTION)
        System.exit(0);
    }//GEN-LAST:event_jMenu2MousePressed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        Purchase_Ledger tm=new Purchase_Ledger(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-290, ((sd.height-100)/2)-330, 940, 690);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        CompanyMaster tm=new CompanyMaster(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-100, ((sd.height-100)/2)-280, 700, 445);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        TankMaster tm=new TankMaster(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-328, ((sd.height-100)/2)-280, 1017, 433);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        CreateCompoundUnit cu=new CreateCompoundUnit(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        cu.setBounds((sd.width-100)/2-320, ((sd.height-170)/2)-280, 720, 650);
        jDesktopPane1.add(cu);
        cu.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        NozzleMaster tm=new NozzleMaster(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-328, ((sd.height-100)/2)-280, 975, 370);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        PurzaPurchaseLedger tm=new PurzaPurchaseLedger(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-300, ((sd.height-100)/2)-330, 940, 690);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        PurzaPayment tm=new PurzaPayment(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-320, ((sd.height-100)/2)-330, 1000, 690);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        SalesLedger_PointOfSales tm=new SalesLedger_PointOfSales(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-320, ((sd.height-100)/2)-330, 945, 690);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        Ledger tm=new Ledger(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-320, ((sd.height-100)/2)-300, 1000, 560);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        LedgerGroup tm=new LedgerGroup(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-300, ((sd.height-100)/2)-200, 950, 360);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        NozzleSaleEntry tm=new NozzleSaleEntry(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-315, ((sd.height-100)/2)-332, 990, 695);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        Deep_Entry tm=new Deep_Entry(userid,cName,finyear);
        java.awt.Dimension sd=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        tm.setBounds((sd.width-360)/2-290, ((sd.height-100)/2)-300, 932, 420);
        jDesktopPane1.add(tm);
        tm.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    /**
    * @param args the command line arguments
    */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasterScreen().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables

}