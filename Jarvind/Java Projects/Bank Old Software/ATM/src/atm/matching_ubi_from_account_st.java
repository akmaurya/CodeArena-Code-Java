package atm;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * matching_ubi_from_account_st.java
 *
 * Created on May 14, 2013, 3:13:56 PM
 */

/**
 *
 * @author user2
 */
public class matching_ubi_from_account_st extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm;
    /** Creates new form matching_ubi_from_account_st */
    public matching_ubi_from_account_st() {
        initComponents();
        jPanel4.setVisible(false);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        String heading[]={"Sr. No","Entry No","Date","Particular","Withdrawals","Deposits","Total Amount"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);

        jTable1.setModel(dtm);
        jTable1.setRowHeight(25);
        javax.swing.table.TableColumn column;

//jTable1.getTableHeader().setFont(new Font("Vardana", Font.BOLD, 12));
        column=jTable1.getColumn("Sr. No");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(60);
        column=jTable1.getColumn("Entry No");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(60);
        column=jTable1.getColumn("Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Particular");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(400);
        column=jTable1.getColumn("Withdrawals");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Deposits");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Total Amount");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(110);
        //jTable(jTable1.getColumnModel().getColumn(1).se);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(0);
        table();
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(179, 200, 200));
        setClosable(true);
        setIconifiable(true);
        setTitle("UBI Breaking Process Window");

        jPanel1.setBackground(new java.awt.Color(250, 245, 216));
        jPanel1.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(254, 254, 237));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/wait.gif"))); // NOI18N
        jPanel4.add(jLabel1, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 10, 930, 640);

        jPanel2.setBackground(new java.awt.Color(254, 254, 237));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 90, 910, 560);

        jPanel3.setBackground(new java.awt.Color(254, 254, 237));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(null);

        jButton1.setBackground(new java.awt.Color(254, 254, 237));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 16));
        jButton1.setForeground(new java.awt.Color(79, 77, 77));
        jButton1.setMnemonic('b');
        jButton1.setText("Click Here for Breaking UBI Records");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        jButton1.setBounds(30, 18, 460, 35);

        jButton2.setBackground(new java.awt.Color(254, 254, 237));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jButton2.setMnemonic('x');
        jButton2.setText("Close (x)");
        jButton2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        jButton2.setBounds(500, 18, 380, 35);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 10, 910, 70);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
                     braek();
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
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MousePressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
             class task1 extends Thread
        {
            public void run()
            {
                try
                {
                    jPanel4.setVisible(true);
                    jPanel2.setVisible(false);
                    jPanel3.setVisible(false);
                     braek();
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
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            this.dispose();
        }
    }//GEN-LAST:event_jButton2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
            String tem="519408250304000";
            int len=2;
            qry="Select entry_no,date,particulars,withdrawal,Deposit,balance from ubi_account_statement where recon_status="+0+" and (particulars like '%"+tem+"%')order by entry_no asc";
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
                    arr[1]=load[i][0];
                    String dt[]=load[i][1].split("-");
                    arr[2]=dt[2]+"-"+dt[1]+"-"+dt[0];
                    arr[3]=load[i][2];
                    arr[4]=load[i][3];
                    arr[5]=load[i][4];
                    arr[6]=load[i][5];
                    //arr[6]=load[i][6];
                    
                   
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
private void braek()
{
    String qry="";
    jButton1.setEnabled(false);
    double tot=0;
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
                String dt[]=jTable1.getValueAt(0, 2).toString().split("-");
                String date=dt[2]+"-"+dt[1]+"-"+dt[0];
                System.out.println(date);
                double regamt=0;
                double wid=0;
                double dep=0;
                


             qry="select ubi_payment_no from ubi_account_statement where entry_no="+Integer.parseInt(jTable1.getValueAt(0, 1).toString())+" and particulars='"+jTable1.getValueAt(0, 3)+"' and date='"+date+"' and withdrawal="+Double.valueOf(jTable1.getValueAt(0, 4).toString())+"";
            System.out.println(qry);
            String Paymentno=object1.getSingleValue(qry);
            System.out.println("PAYMENT NO = "+Paymentno+"     ballance register= "+Double.valueOf(jTable1.getValueAt(0, 4).toString()));


            int selRow[]=jTable1.getSelectedRows();
            double item1=0,item2=0;
            System.out.println(selRow.length);
                   if(selRow.length>0)
                   {
                       for(int i=0;i<selRow.length;i++)
                       {
                           //System.out.println(selRow[0]+"  "+selRow[selRow.length-1]);
                           if(selRow[0]==0 && (selRow.length-1)==selRow[selRow.length-1])
                           {
                               System.out.println(selRow[0]+"  "+selRow[selRow.length-1]);
                               wid=wid+Double.valueOf(jTable1.getValueAt(i, 4).toString());
                               dep=dep+Double.valueOf(jTable1.getValueAt(i, 5).toString());
                               regamt=wid-dep;
                               System.out.println("total widrawl="+wid+"   total dep="+dep+"    widrawl-deposite"+regamt);
                               
                           }
                           else
                           {
                               javax.swing.JOptionPane.showMessageDialog(this,"!Error:\nRows are not sellected in sequenced manner");
                               flag=5;
                               System.out.println(flag);
                               jPanel4.setVisible(false);
                               jPanel2.setVisible(true);
                               jPanel3.setVisible(true);
                               break;

                           }

                       }
                       
                   }

                   System.out.println(regamt);
                   if(flag!=5)
                   {
                       System.out.println("matching process start");
                        int temp=object1.breakAmtUBI(Integer.parseInt(Paymentno),regamt );
                        System.out.println("temp = "+temp);
                        //int temp=object1.breakAmtUBI(Integer.parseInt(Paymentno),Double.valueOf(jTable1.getValueAt(0, 3).toString()) );
                        if(temp==1)
                        {
                            for(int i=0;i<jTable1.getSelectedRows().length;i++)
                            {
                                String dt1[]=jTable1.getValueAt(i, 2).toString().split("-");
                                String date1=dt1[2]+"-"+dt1[1]+"-"+dt1[0];
                                System.out.println(date1);
                                qry="update ubi_account_statement set recon_status="+1+",ubi_payment_no="+Integer.parseInt(Paymentno)+" where entry_no="+Integer.parseInt(jTable1.getValueAt(i, 1).toString())+" and particulars='"+jTable1.getValueAt(i, 3)+"' and date='"+date1+"' and withdrawal="+Double.valueOf(jTable1.getValueAt(i, 4).toString())+" and balance="+Double.valueOf(jTable1.getValueAt(i, 6).toString())+" ";
                                System.out.println(qry);
                                boolean bn=object1.saveInformation(qry);
                                System.out.println(bn);
                            }
                            javax.swing.JOptionPane.showMessageDialog(this,"!Congratulation\nBreaking process completed.");
                            jPanel4.setVisible(false);
                            jPanel2.setVisible(true);
                            jPanel3.setVisible(true);
                            table();
                        }
                        else
                        {
                              javax.swing.JOptionPane.showMessageDialog(this,"!Error\nMatching process not completed.\nMay be register amount not matched");
                              jPanel4.setVisible(false);
                              jPanel2.setVisible(true);
                              jPanel3.setVisible(true);
                        }
                    }
                   jButton1.setEnabled(true);
                   jPanel4.setVisible(false);
                   jPanel2.setVisible(true);
                   jPanel3.setVisible(true);
             /*   int x=javax.swing.JOptionPane.showConfirmDialog(this, "Are you want to select multiple Colloumns ?", "Verification Window", javax.swing.JOptionPane.YES_NO_OPTION);
                System.out.println("javax.swing.JOptionPane.showConfirmDialog x= "+x);
                if((x==0))
                {
                    int selRow[]=jTable1.getSelectedRows();
                   if(selRow.length>0)
                   {
                       for(int i=0;i<selRow.length;i++)
                       {
                           System.out.println(selRow[0]+"  "+selRow[selRow.length-1]);
                           if(selRow[0]==0 && selRow[selRow.length]==selRow[selRow.length-1])
                           {
                               System.out.println(selRow[0]+"  "+selRow[selRow.length-1]);
                               regamt=regamt+Integer.parseInt(jTable1.getValueAt(i, 3).toString());
                               System.out.println(regamt);
                               
                           }
                           else
                           {
                               javax.swing.JOptionPane.showMessageDialog(this,"!Error:\nRows are not sellected in sequenced manner");
                           }

                       }
                       
                   }
                    temp=object1.breakAmtUBI(Integer.parseInt(Paymentno),Double.valueOf(""+regamt) );
                    System.out.println("temp = "+temp);
                }
                //
            }*/

        }
        catch(Exception ae)
        {
            System.out.println("Eror in Save Information111....."+ae);
            jPanel4.setVisible(false);
            jPanel2.setVisible(true);
            jPanel3.setVisible(true);
        }

}
int flag=0;
}