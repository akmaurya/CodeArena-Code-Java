/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UBI_Account_st_matched.java
 *
 * Created on Jul 2, 2013, 3:45:05 PM
 */

package atm;

/**
 *
 * @author welcome
 */
public class UBI_Account_st_matched extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm;
    /** Creates new form UBI_Account_st_matched */
    public UBI_Account_st_matched() {
        initComponents();
        jPanel4.setVisible(false);

        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        String heading[]={"Sr. No","Date","particular","Withdrawals","Deposits","Total Amount","Payment no"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
        jTable1.requestFocus();
        jTable1.setModel(dtm);
        jTable1.setRowHeight(25);
        javax.swing.table.TableColumn column;

        //jTable1.getTableHeader().setFont(new Font("Vardana", Font.BOLD, 12));
        column=jTable1.getColumn("Sr. No");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(50);
        column=jTable1.getColumn("Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("particular");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(410);
        column=jTable1.getColumn("Withdrawals");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(107);
        column=jTable1.getColumn("Deposits");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Total Amount");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(120);
        column=jTable1.getColumn("Payment no");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(78);

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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(186, 221, 221));
        setClosable(true);
        setIconifiable(true);
        setTitle("UBI Account Statement Report");

        jPanel1.setBackground(new java.awt.Color(250, 245, 216));
        jPanel1.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(254, 254, 237));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/wait.gif"))); // NOI18N
        jPanel4.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 80, 990, 540);

        jButton4.setBackground(new java.awt.Color(254, 254, 237));
        jButton4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton4.setMnemonic('n');
        jButton4.setText("Next");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jButton4.setBounds(510, 615, 240, 30);

        jButton5.setBackground(new java.awt.Color(254, 254, 237));
        jButton5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/Close1.gif"))); // NOI18N
        jButton5.setMnemonic('x');
        jButton5.setText("Cancel (x)");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jButton5.setBounds(760, 615, 240, 30);

        jPanel2.setBackground(new java.awt.Color(254, 254, 237));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable1.setBackground(new java.awt.Color(254, 254, 237));
        jTable1.setFont(new java.awt.Font("Verdana", 1, 12));
        jTable1.setForeground(new java.awt.Color(0, 87, 87));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(20);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 92, 990, 510);

        jPanel3.setBackground(new java.awt.Color(254, 254, 237));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(null);

        jButton3.setBackground(new java.awt.Color(254, 254, 237));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jButton3.setForeground(new java.awt.Color(1, 119, 119));
        jButton3.setText("Not  Reconcile Records");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jButton3.setBounds(20, 20, 300, 35);

        jButton1.setBackground(new java.awt.Color(254, 254, 237));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 16));
        jButton1.setForeground(new java.awt.Color(1, 119, 119));
        jButton1.setMnemonic('u');
        jButton1.setText(" Reconcile Records Only in UBI");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jButton1.setBounds(340, 20, 310, 35);

        jButton2.setBackground(new java.awt.Color(254, 254, 237));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 16));
        jButton2.setForeground(new java.awt.Color(1, 119, 119));
        jButton2.setMnemonic('k');
        jButton2.setText(" Reconcile Records (KGSG)");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jButton2.setBounds(670, 20, 300, 35);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 10, 990, 70);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        table1();
        jTable1.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        table();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            table();
            jTable1.requestFocus();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            table1();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        table3();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        table3();
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        class task1 extends Thread
        {
            public void run()
            {
                try
                {
                    jPanel4.setVisible(true);
                    jPanel2.setVisible(false);
                    jPanel3.setVisible(false);
                    jButton4.setVisible(false);
                    jButton5.setVisible(false);
                     status();
                     Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                     System.out.println("error..."+ex);
                }
            }
        }
        task1 t1=new task1();
        t1.start();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            class task1 extends Thread
        {
            public void run()
            {
                try
                {
                     status();
                     Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                     System.out.println("error..."+ex);
                }
            }
        }
        task1 t1=new task1();
        t1.start();
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            int n=jTable1.getSelectedRow();
            jTable1.setRowSelectionInterval(n-1, n-1);
            jButton4.requestFocus();
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            this.dispose();
    }//GEN-LAST:event_jButton5KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private boolean table()
{
    String qry="";
        try
        {
            interfaceATM object1=null;
            try
            {
		object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
            }
            catch(Exception e)
            {
		System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
                getIPaddress.changeIP();
		try
		{
			object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
		}
		catch(Exception ex)
		{
			System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
		}
            }
            //double total=0.0;
            java.math.BigDecimal bd=null;
            qry="Select entry_no,date,particulars,withdrawal,Deposit,balance,ubi_payment_no from ubi_account_statement where recon_status=1";
            System.out.println(qry);
            String load[][]=object1.getInformationDD(qry,7);
            System.out.println(load.length);
            String arr[]=null;
            //int total=0;
            dtm.setRowCount(0);
            if(load.length>0)
            {
                //System.out.println("hello111111111111111111111111111");
                arr=new String[8];
                for(int i=0;i<load.length;i++)
                {


                    arr[0]=""+(dtm.getRowCount()+1);
                    String dt[]=load[i][1].split("-");
                    arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                    arr[2]=load[i][2];
                    arr[3]=load[i][3];
                    arr[4]=load[i][4];
                    arr[5]=load[i][5];
                    arr[6]=load[i][6];


                    dtm.addRow(arr);
                    System.out.println("hello   "+i);
                }

            }
            return true;
        }
        catch(Exception ae)
        {
            System.out.println("Eror in Save Information111....."+ae);
        }
        return true;

}
    private boolean table1()
{
    String qry="";
        try
        {
            interfaceATM object1=null;
            try
            {
		object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
            }
            catch(Exception e)
            {
		System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
                getIPaddress.changeIP();
		try
		{
			object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
		}
		catch(Exception ex)
		{
			System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
		}
            }
            //double total=0.0;
            java.math.BigDecimal bd=null;
            qry="Select entry_no,date,particulars,withdrawal,Deposit,balance,ubi_payment_no from ubi_account_statement where recon_status=2";
            System.out.println(qry);
            String load[][]=object1.getInformationDD(qry,7);
            System.out.println(load.length);
            String arr[]=null;
            //int total=0;
            dtm.setRowCount(0);
            if(load.length>0)
            {
                //System.out.println("hello111111111111111111111111111");
                arr=new String[8];
                for(int i=0;i<load.length;i++)
                {


                    arr[0]=""+(dtm.getRowCount()+1);
                    String dt[]=load[i][1].split("-");
                    arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                    arr[2]=load[i][2];
                    arr[3]=load[i][3];
                    arr[4]=load[i][4];
                    arr[5]=load[i][5];
                    arr[6]=load[i][6];


                    dtm.addRow(arr);
                    System.out.println("hello   "+i);
                }

            }
            return true;
        }
        catch(Exception ae)
        {
            System.out.println("Eror in Save Information111....."+ae);
        }
        return true;

}
    private boolean table3()
{
    String qry="";
        try
        {
            interfaceATM object1=null;
            try
            {
		object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
            }
            catch(Exception e)
            {
		System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
                getIPaddress.changeIP();
		try
		{
			object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
		}
		catch(Exception ex)
		{
			System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
		}
            }
            //double total=0.0;
            java.math.BigDecimal bd=null;
            qry="Select entry_no,date,particulars,withdrawal,Deposit,balance,ubi_payment_no from ubi_account_statement where recon_status=0";
            System.out.println(qry);
            String load[][]=object1.getInformationDD(qry,7);
            System.out.println(load.length);
            String arr[]=null;
            //int total=0;
            dtm.setRowCount(0);
            if(load.length>0)
            {
                //System.out.println("hello111111111111111111111111111");
                arr=new String[8];
                for(int i=0;i<load.length;i++)
                {


                    arr[0]=""+(dtm.getRowCount()+1);
                    String dt[]=load[i][1].split("-");
                    arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                    arr[2]=load[i][2];
                    arr[3]=load[i][3];
                    arr[4]=load[i][4];
                    arr[5]=load[i][5];
                    arr[6]=load[i][6];


                    dtm.addRow(arr);
                    System.out.println("hello   "+i);
                }

            }
            return true;
        }
        catch(Exception ae)
        {
            System.out.println("Eror in Save Information111....."+ae);
        }
        return true;

}
    private boolean status()
    {
        try
        {
            jButton4.setEnabled(false);
            interfaceATM object1=null;
            try
            {
		object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
            }
            catch(Exception e)
            {
		System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
                getIPaddress.changeIP();
		try
		{
			object1=(interfaceATM)java.rmi.Naming.lookup(getIPaddress.IP());
		}
		catch(Exception ex)
		{
			System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/railwayMethods  ..."+ex);
		}
            }
            int paymentno=Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            String qry="select recon_status from ubi_account_statement where ubi_payment_no="+paymentno+"";
            String st=object1.getSingleValue(qry);
            if(Integer.parseInt(st)==0)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"!UBI Records are not reconcile..........");
                //this.dispose();
                jPanel4.setVisible(false);
                jPanel2.setVisible(true);
                jPanel3.setVisible(true);
                jButton4.setVisible(true);
                jButton5.setVisible(true);
                return false;
            }
            
            KGSG_UBI_Report ku=new KGSG_UBI_Report(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
            ku.setBounds(0, 2, 1022, 673);
            jButton4.setEnabled(true);
            Desktop_atm.jDesktopPane1.add(ku);
            jPanel4.setVisible(false);
            jPanel2.setVisible(true);
            jPanel3.setVisible(true);
            jButton4.setVisible(true);
            jButton5.setVisible(true);
            ku.setVisible(true);

            //jButton4.setVisible(true);
            }
        catch(Exception ae)
        {
            System.out.println("Eror in status method....."+ae);
            jPanel4.setVisible(false);
                    jPanel2.setVisible(true);
                    jPanel3.setVisible(true);
                    jButton4.setVisible(true);
                    jButton5.setVisible(true);
        }
        return true;
    }
}
