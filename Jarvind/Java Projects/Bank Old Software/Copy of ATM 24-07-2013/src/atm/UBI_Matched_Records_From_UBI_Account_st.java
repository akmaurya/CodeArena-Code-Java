/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UBI_Matched_Records_From_UBI_Account_st.java
 *
 * Created on Jun 29, 2013, 5:58:22 PM
 */

package atm;

/**
 *
 * @author welcome
 */
public class UBI_Matched_Records_From_UBI_Account_st extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm,dtm1;
    /** Creates new form UBI_Matched_Records_From_UBI_Account_st */
    public UBI_Matched_Records_From_UBI_Account_st() {
        initComponents();
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        String heading[]={"Sr. No","Particular","Date","Withdrawal","Deposit","Balance","Payment No"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);

        jTable1.setModel(dtm);
        jTable1.setRowHeight(25);
        javax.swing.table.TableColumn column;

//jTable1.getTableHeader().setFont(new Font("Vardana", Font.BOLD, 12));
        column=jTable1.getColumn("Sr. No");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(50);
        column=jTable1.getColumn("Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Particular");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(400);
        column=jTable1.getColumn("Withdrawal");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Deposit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Balance");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Payment No");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(6).setMinWidth(0);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(0);
        table();
        jTable2.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        String heading1[]={"Sr. No","Entry No","Particular","Debit","Credit","Payment Ballence Register"};
        dtm1=new javax.swing.table.DefaultTableModel(heading1,0);

        jTable2.setModel(dtm1);
        jTable2.setRowHeight(25);

//jTable1.getTableHeader().setFont(new Font("Vardana", Font.BOLD, 12));
        column=jTable2.getColumn("Sr. No");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(60);
        column=jTable2.getColumn("Particular");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(300);
        column=jTable2.getColumn("Debit");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(110);
        column=jTable2.getColumn("Credit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("Payment Ballence Register");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(170);
        column=jTable2.getColumn("Entry No");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(70);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(0);
        jTable2.getColumnModel().getColumn(1).setMinWidth(0);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(186, 221, 221));
        setClosable(true);
        setIconifiable(true);
        setTitle("UBI Reconsile Report");
        getContentPane().setLayout(null);

        jTable1.setBackground(new java.awt.Color(216, 238, 238));
        jTable1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 102));
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 50, 760, 120);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel1.setText("Enter Date");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 80, 20);

        jTextField1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTextField1.setOpaque(false);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(90, 10, 110, 22);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/calendar.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 10, 30, 20);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton2.setText("Done");
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
        jButton2.setBounds(260, 10, 250, 25);

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(530, 10, 240, 25);

        jTable2.setBackground(new java.awt.Color(216, 238, 238));
        jTable2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 51, 102));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setRowHeight(20);
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 190, 760, 450);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 180, 790, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 40, 790, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        table();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        Cal X=new Cal();
        jTextField1.setText(X.getdate());
        jButton1.requestFocus();
        //selectedDate=X.getmonth()+"/"+X.getday()+"/"+X.getyear();
    }//GEN-LAST:event_jButton1MousePressed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        table2();
    }//GEN-LAST:event_jTable1MousePressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            Cal X=new Cal();
            jTextField1.setText(X.getdate());
            jButton2.requestFocus();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            table();
        }
    }//GEN-LAST:event_jButton2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
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
            String dt[]=jTextField1.getText().trim().split("/");
            String date=dt[2]+"-"+dt[1]+"-"+dt[0];
            qry="Select date,particulars,withdrawal,Deposit,balance,ubi_payment_no from ubi_account_statement where recon_status="+2+" and date='"+date+"'";
            System.out.println(qry);
            String load[][]=object1.getInformationDD(qry,6);
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
                    arr[3]=load[i][2];
                    dt=load[i][0].split("-");
                    date=dt[2]+"-"+dt[1]+"-"+dt[0];
                    arr[2]=date;
                    arr[1]=load[i][1];
                    arr[4]=load[i][3];
                    arr[5]=load[i][4];
                    arr[6]=load[i][5];
                    //arr[7]=load[i][6];

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
    private boolean table2()
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
            String dt[]=jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString().split("-");
            String date=dt[2]+"-"+dt[1]+"-"+dt[0];
            qry="Select entry_no,particular,tran_debit_amt,tran_credit_amt,ubi_payment_no from ubi_bill_of_kgsg_cards where recon_status="+2+" and ubi_payment_no='"+jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString()+"'";
            System.out.println(qry);
            String load[][]=object1.getInformationDD(qry,5);
            System.out.println(load.length);
            String arr[]=null;
            //int total=0;
            dtm1.setRowCount(0);
            if(load.length>0)
            {
                //System.out.println("hello111111111111111111111111111");
                arr=new String[7];
                for(int i=0;i<load.length;i++)
                {

                    arr[0]=""+(dtm1.getRowCount()+1);
                    arr[1]=load[i][0];
                    arr[2]=load[i][1];;
                    arr[3]=load[i][2];
                    arr[4]=load[i][3];
                    qry="select withdrawal from ubi_account_statement where ubi_payment_no="+Integer.parseInt(load[i][4])+"";
                    String amt=object1.getSingleValue(qry);
                    arr[5]=amt;
                    

                    dtm1.addRow(arr);
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
}
