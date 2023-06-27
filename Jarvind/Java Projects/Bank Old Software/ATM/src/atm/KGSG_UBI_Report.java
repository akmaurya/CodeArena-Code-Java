/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * KGSG_UBI_Report.java
 *
 * Created on Jul 22, 2013, 2:33:27 PM
 */

package atm;

/**
 *
 * @author welcome
 */
public class KGSG_UBI_Report extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm,dtm1,dtm2,dtm3;
String pay1=null;
int flag1=0,flag2=0;
    /** Creates new form KGSG_UBI_Report */
    public KGSG_UBI_Report(String paymentno) {
        initComponents();
        pay1=paymentno;
        jPanel6.setVisible(false);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        String heading[]={"Sr.No","Date","Txn ID","Card No/Record No","Debit","Credit","Balance"," ","KGSG Date","K Txn ID","KGSG Card No/Record No","KGSG Debit","KGSG Credit","KGSG Balance","Traced(Y/N)","Comment","Date","Reversed to A/c","Txn ID"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);

        jTable1.setModel(dtm);
        jTable1.setRowHeight(25);
        javax.swing.table.TableColumn column;

//jTable1.getTableHeader().setFont(new Font("Vardana", Font.BOLD, 12));
        column=jTable1.getColumn("Sr.No");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(45);
        column=jTable1.getColumn("Txn ID");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(70);
        column=jTable1.getColumn("Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Card No/Record No");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(200);
        column=jTable1.getColumn("Debit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Credit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Balance");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Traced(Y/N)");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(70);
        column=jTable1.getColumn("Comment");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Reversed to A/c");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(50);
        column=jTable1.getColumn("Txn ID");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(60);
        column=jTable1.getColumn(" ");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(2);
        column=jTable1.getColumn("K Txn ID");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(60);
        column=jTable1.getColumn("KGSG Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("KGSG Card No/Record No");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(200);
        column=jTable1.getColumn("KGSG Debit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("KGSG Credit");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("KGSG Balance");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(90);
        //jTable2.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        String heading1[]={"",""};
        dtm1=new javax.swing.table.DefaultTableModel(heading1,0);

        jTable2.setModel(dtm1);
        jTable2.setRowHeight(25);

        String heading2[]={"",""};
        dtm2=new javax.swing.table.DefaultTableModel(heading2,0);

        jTable3.setModel(dtm2);
        jTable3.setRowHeight(25);

        String heading3[]={"Date","Amount","Dr/Cr","Entry No"};
        dtm3=new javax.swing.table.DefaultTableModel(heading3,0);

        jTable4.setModel(dtm3);
        jTable4.setRowHeight(25);
        column=jTable4.getColumn("Date");
        column.setCellRenderer(CRCenter);
        column=jTable4.getColumn("Amount");
        column.setCellRenderer(CRRight);
        column=jTable4.getColumn("Dr/Cr");
        column.setCellRenderer(CRCenter);
        column=jTable4.getColumn("Entry No");
        column.setCellRenderer(CRCenter);

//jTable1.getTableHeader().setFont(new Font("Vardana", Font.BOLD, 12));
        class task1 extends Thread
        {
            public void run()
            {
                try
                {
                    jPanel3.setVisible(false);
                    jPanel6.setVisible(true);
                    table4(pay1);
                    table(pay1);
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
        
        //table4(paymentno);
        //table(paymentno);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(203, 249, 203));
        setClosable(true);
        setIconifiable(true);
        setTitle("UBI And KGSG Matching Report");

        jPanel1.setBackground(new java.awt.Color(250, 245, 216));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(254, 254, 237));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        jTable4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable4.setRowHeight(21);
        jScrollPane4.setViewportView(jTable4);

        jPanel2.add(jScrollPane4);
        jScrollPane4.setBounds(10, 30, 540, 90);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("CD 360601020050007 Amount Tallied =");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 10, 280, 20);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("jLabel6");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(290, 10, 160, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("Date");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(560, 30, 120, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("Reversed to A/c");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(560, 60, 110, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel9.setText("TXN Id");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(560, 90, 90, 20);

        jTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jTextField3);
        jTextField3.setBounds(670, 90, 160, 25);

        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jTextField2);
        jTextField2.setBounds(670, 60, 160, 25);

        jTextField1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(670, 30, 160, 25);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/show.gif"))); // NOI18N
        jButton1.setMnemonic('d');
        jButton1.setText("Done");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jButton1);
        jButton1.setBounds(840, 30, 140, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/Close1.gif"))); // NOI18N
        jButton2.setMnemonic('x');
        jButton2.setText("Close (x)");
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
        jPanel2.add(jButton2);
        jButton2.setBounds(840, 85, 140, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 990, 130);

        jPanel3.setBackground(new java.awt.Color(254, 254, 237));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 170, 990, 290);

        jPanel4.setBackground(new java.awt.Color(254, 254, 237));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jTable2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        jTable2.setRowHeight(21);
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 500, 400, 130);

        jPanel5.setBackground(new java.awt.Color(254, 254, 237));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTable3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.setRowHeight(18);
        jScrollPane3.setViewportView(jTable3);

        jPanel5.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(620, 460, 380, 170);

        jLabel1.setBackground(new java.awt.Color(250, 250, 246));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel1.setText("Opening of UBI Balance =");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 150, 190, 20);

        jLabel2.setBackground(new java.awt.Color(250, 250, 246));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(460, 150, 150, 20);

        jLabel3.setBackground(new java.awt.Color(250, 250, 246));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel3.setText("Opening of KGSG Balance =");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(670, 150, 200, 20);

        jLabel4.setBackground(new java.awt.Color(250, 250, 246));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(870, 150, 140, 20);

        jPanel6.setBackground(new java.awt.Color(254, 254, 237));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel10.setBackground(new java.awt.Color(254, 254, 237));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/atm/wait.gif"))); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.add(jLabel10, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 150, 990, 340);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
           jTextField1.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
           jTextField2.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
           jTextField3.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
           int n=jTable1.getSelectedRow();
           jTable1.setRowSelectionInterval(n-1, n-1);
           jTextField1.requestFocus();
    }//GEN-LAST:event_jTable1KeyPressed

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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    public void table(String paymentno)
    {
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

            double udebit=0,ucredit=0,ubalance=0,kdebit=0,kcredit=0,kbalance=0;
            String qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balanceamt from ubi_bill_of_kgsg_cards where ubi_payment_no="+Integer.parseInt(paymentno)+" order by entry_no asc";
            System.out.println(qry);
            String load[][]=object1.getInformationDD(qry, 6);
            System.out.println(load.length);
            String ar[]=null;
            double wid=0;
            double dop=0;
            qry="select withdrawal,Deposit from ubi_account_statement where ubi_payment_no="+Integer.parseInt(paymentno)+"";
             System.out.println(qry);
            String totpay[][]=object1.getInformationDD(qry, 2);
            if(totpay.length>0)
            {
                ar=new String[2];
                for(int i=0;i<totpay.length;i++)
                {
                    wid=wid+Double.valueOf(totpay[i][0]);
                    dop=dop+Double.valueOf(totpay[i][1]);
                }
                jLabel6.setText(""+(wid-dop));
            }
            jLabel6.setText(""+(wid-dop));
            String upart[]=load[0][2].split("/");
            String uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
            qry="select ubi_payment_no from kgsg_n_ubi where ubi_payment_no="+(Integer.parseInt(paymentno)-1)+"";
             System.out.println(qry);
            String pay=object1.getSingleValue(qry);
            System.out.println("pay = "+pay);
            String start=null;
            if(pay==null || pay.equals(""))
            {
                pay="0";
                qry="select max(ubi_payment_no) from kgsg_n_ubi where ubi_payment_no<"+(Integer.parseInt(paymentno))+"";
                 System.out.println(qry);
                pay=object1.getSingleValue(qry);
                System.out.println("pay ====== "+pay);
                if(pay.equals(""))
                    pay="0";
                
            }
            if(Integer.parseInt(pay) <= 0)
            {
                start=pay;
                //qry="select min(entry_no) from kgsg_n_ubi where ubi_payment_no="+(Integer.parseInt(paymentno))+"";
                //System.out.println("else if quer ............. "+qry);
                //start=""+(Integer.parseInt(object1.getSingleValue(qry))-1);
                //System.out.println(start);
            }
            else
            {
                qry="select max(entry_no) from kgsg_n_ubi where ubi_payment_no="+(Integer.parseInt(pay))+"";
                 System.out.println(qry);
                start=object1.getSingleValue(qry);
            }
            System.out.println("start    = "+start);
            if(start==null)
            {
                start="0";
            }
            upart=load[load.length-1][2].split("/");
            uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
            qry="select max(entry_no) from kgsg_n_ubi where ubi_payment_no="+Integer.parseInt(paymentno)+" ";
            System.out.println(qry);
            String last=object1.getSingleValue(qry);
            System.out.println("Start="+start+"   last="+last);
            if(last==null && start==null)
            {
                last=start="0";
            }
            if(last==null)
            {
                last=start;
            }

            System.out.println("Start="+start+"   last="+last);
            qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balance_amt,comment from kgsg_n_ubi where entry_no<="+Integer.parseInt(last)+" and entry_no>"+Integer.parseInt(start)+" ";
            System.out.println(qry);
            String load1[][]=object1.getInformationDD(qry, 7);
            System.out.println("load1.length == "+load1.length);
            
            String arr[]=null;
            //int total=0;
            int flag=0;
            dtm.setRowCount(0);
            String  dt[]=null;
            
 
            if(load.length>0 && load1.length!=0)
            {
                 System.out.println("load.length>0 && load1.length==0 load.length ="+load.length);
                 arr=new String[16];
                for(int i=0;i<load.length;i++)
                {
                   // System.out.println("in load part start ");
                                arr[0]=""+(dtm.getRowCount()+1);
                                dt=load[i][0].split("-");
                                arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                                arr[2]=load[i][1];
                                arr[3]=load[i][2];
                                arr[4]=load[i][3];
                                arr[5]=load[i][4];
                                arr[6]=load[i][5];
                                arr[8]="";
                                arr[9]="";
                                arr[10]="";
                                arr[11]="";
                                arr[12]="";
                                arr[13]="";
                                arr[14]="N";
                                arr[15]="";
                                udebit=udebit+Double.valueOf(arr[4]);
                                ucredit=ucredit+Double.valueOf(arr[5]);
                                //System.out.println("load part completed ");
                                upart=load[i][2].split("/");
                                uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
                                qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balance_amt,comment from kgsg_n_ubi where (particular like '"+uparticular+"%' ) and tran_credit_amt="+Double.valueOf(arr[4])+" and tran_debit_amt="+Double.valueOf(arr[5])+" ";
                                String lo[][]=object1.getInformationDD(qry, 7);
                                if(lo.length>0)
                                {
                                    //for(int j=0;j<1;j++)
                                    //{
                                        dt=lo[0][0].split("-");
                                    arr[8]=dt[2]+"-"+dt[1]+"-"+dt[0];
                                    arr[9]=lo[0][1];
                                    arr[10]=lo[0][2];
                                    arr[11]=lo[0][3];
                                    arr[12]=lo[0][4];
                                    arr[13]=lo[0][5];
                                    arr[15]=lo[0][6];
                                    kdebit=udebit+Double.valueOf(arr[11]);
                                    kcredit=kcredit+Double.valueOf(arr[12]);
                                    arr[14]="Y";
                                    
                                    //}
                                    
                                }
                                dtm.addRow(arr);
                                
                }
                //System.out.println("records are inserted ");
            }
            
           
                System.out.println("in else load.length="+load.length+"   load1.length="+load1.length);
            if (load1.length > load.length)
            {
                //System.out.println("load1.length > load.length");
                qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balance_amt,recon_status,comment from kgsg_n_ubi where entry_no<="+Integer.parseInt(last)+" and entry_no>="+Integer.parseInt(start)+" and recon_status<>"+2+"  ";
                //System.out.println(qry);
                String lo[][]=object1.getInformationDD(qry, 8);
                //System.out.println("lo.length ===== "+lo.length);
                
                for(int i=0;i<lo.length;i++)
                {
                    arr[0]=""+(dtm.getRowCount()+1);
                        arr[1]="";
                        arr[2]="";
                        arr[3]="";
                        arr[4]="";
                        arr[5]="";
                        arr[6]="";
                        dt=lo[i][0].split("-");
                        arr[8]=dt[2]+"-"+dt[1]+"-"+dt[0];
                        arr[9]=lo[i][1];
                        arr[10]=lo[i][2];
                        arr[11]=lo[i][3];
                        arr[12]=lo[i][4];
                        arr[13]=lo[i][5];
                        arr[15]=lo[i][7];
                        kdebit=udebit+Double.valueOf(arr[11]);
                        
                        if(lo[i][6].equals("2"))
                        {
                            arr[14]="PT";
                        }
                        else
                        {
                            arr[14]="N";
                            kcredit=kcredit+Double.valueOf(arr[12]);
                        }
                        
                        dtm.addRow(arr);
                        
                }
            }
                System.out.println("load1.length=========== condition");
                arr=null;
            if(load.length>0 && load1.length<=0)
            {
                System.out.println(load1.length+"  load1.length===========0 load .length "+load.length);
                arr=new String[16];
                for(int i=0;i<load.length;i++)
                {
                                arr[0]=""+(dtm.getRowCount()+1);
                                dt=load[i][0].split("-");
                                arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                                arr[2]=load[i][1];
                                arr[3]=load[i][2];
                                arr[4]=load[i][3];
                                arr[5]=load[i][4];
                                arr[6]=load[i][5];
                                arr[8]="";
                                arr[9]="";
                                arr[10]="";
                                arr[11]="";
                                arr[12]="";
                                arr[13]="";
                                arr[14]="N";
                                arr[15]="";
                                dtm.addRow(arr);
                           }
                           
            }
                //System.out.println("load.length="+load.length+"   load1.length="+load1.length);



            /*if (load.length > jTable1.getRowCount() && flag==0)
            {
                System.out.println("load.length > load1.length");
                qry="select entry_no from ubi_bill_of_kgsg_cards where particular='"+jTable1.getValueAt(jTable1.getRowCount()-1, 3).toString()+"'";
                System.out.println(qry);

                String eno=object1.getSingleValue(qry);
                System.out.println("eno = "+eno);
                qry="select tran_date,tran_id,particular,tran_debit_amt,tran_credit_amt,balanceamt from ubi_bill_of_kgsg_cards where entry_no>"+Integer.parseInt(eno)+"";
                System.out.println(qry);
                String lo[][]=object1.getInformationDD(qry, 6);
                System.out.println("lo.length ===== "+lo.length);

                for(int i=0;i<(load.length-load1.length);i++)
                {
                    arr[0]=""+(dtm.getRowCount()+1);
                                dt=lo[i][0].split("-");
                                arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                                arr[2]=lo[i][1];
                                arr[3]=lo[i][2];
                                arr[4]=lo[i][3];
                                arr[5]=lo[i][4];
                                arr[6]=lo[i][5];
                                System.out.println("load part completed ");
                                udebit=udebit+Double.valueOf(arr[4]);
                                ucredit=ucredit+Double.valueOf(arr[5]);
                                

                                arr[8]="";
                                arr[9]="";
                                arr[10]="";
                                arr[11]="";
                                arr[12]="";
                                arr[13]="";
                                arr[14]="N";
                                dtm.addRow(arr);
                }
            }*/

            //}
            
            String UDebit=""+(new java.math.BigDecimal(udebit)).setScale(2,5);
            String KDebit=""+(new java.math.BigDecimal(kdebit)).setScale(2,5);
            String arr1[]=new String[14];

            dtm.addRow(arr1);

            
            //System.out.println("Udebit = "+UDebit);
            String UCredit=""+(new java.math.BigDecimal(ucredit)).setScale(2,5);
            String KCredit=""+(new java.math.BigDecimal(kcredit)).setScale(2,5);
            //System.out.println("UCredit = "+UCredit);
            String UBalance=""+(new java.math.BigDecimal(ubalance)).setScale(2,5);
            String KBalance=""+(new java.math.BigDecimal(kbalance)).setScale(2,5);
            //System.out.println("UBalance = "+UBalance);





            jTable1.setValueAt("Summation =", jTable1.getRowCount()-1, 3);
            jTable1.setValueAt(UDebit, jTable1.getRowCount()-1, 4);
            jTable1.setValueAt(UCredit, jTable1.getRowCount()-1, 5);
            //jTable1.setValueAt(UBalance, jTable1.getRowCount()-1, 6);

            
            //jTable1.setValueAt(KBalance, jTable1.getRowCount()-1, 13);
            int n=dtm.getRowCount();
            jTable1.setRowSelectionInterval(n-1, n-1);//
            int starten=Integer.parseInt(start);
            String startbal=null;
            String ubal;
            if(load1.length>0)
            {
                jTable1.setValueAt(KDebit, jTable1.getRowCount()-1, 11);
                jTable1.setValueAt(KCredit, jTable1.getRowCount()-1, 12);
                if(starten==0)
                {
                    starten=1;
                    qry="select balance_amt from kgsg_n_ubi where entry_no="+starten+"";
                    //System.out.println(qry);
                    startbal=object1.getSingleValue(qry);
                }
                else
                {
                    qry="select balance_amt from kgsg_n_ubi where entry_no>"+starten+"";
                    //System.out.println(qry);
                    startbal=object1.getSingleValue(qry);
                }

            if(!load1[0][4].equals("0"))
            {
                //System.out.println("load1[0][3].equals(0)"+load1[0][4]);
                double tot=Double.valueOf(startbal)-Double.valueOf(load1[0][4]);
                jLabel4.setText(""+(new java.math.BigDecimal(tot)).setScale(2,5));
            }
            else if(!load1[0][3].equals("0") )
            {
                //System.out.println("load1[0][4].equals(0)"+load1[0][3]);
                double tot=Double.valueOf(startbal)+Double.valueOf(load1[0][3]);
                jLabel4.setText(""+(new java.math.BigDecimal(tot)).setScale(2,5));
            }
            
                
            }
            else
            {
                startbal="0";
                jTable1.setValueAt("0", jTable1.getRowCount()-1, 11);
                jTable1.setValueAt("0", jTable1.getRowCount()-1, 12);
                jLabel4.setText("0");
            }
                
             
            //System.out.println("load1[0][3]="+load1[0][3]+"   load1[0][4]="+load1[0][4]+"   startbal="+startbal);
            System.out.println("................................................");
            if(Integer.parseInt(pay)<=0)
            {
                qry="select min(entry_no) from ubi_bill_of_kgsg_cards where ubi_payment_no="+paymentno+"";
                //System.out.println(qry);
                String uen=object1.getSingleValue(qry);
                qry="select balanceamt from ubi_bill_of_kgsg_cards where entry_no="+Integer.parseInt(uen)+"";
                ubal=object1.getSingleValue(qry);
            }
            else
            {
                qry="select max(entry_no) from ubi_bill_of_kgsg_cards where ubi_payment_no="+Integer.parseInt(pay)+"";
                System.out.println(qry);
                String uen=object1.getSingleValue(qry);
                qry="select balanceamt from ubi_bill_of_kgsg_cards where entry_no>"+Integer.parseInt(uen)+"";
                ubal=object1.getSingleValue(qry);
            }

            System.out.println("................................................111111111111111111");
            //System.out.println("load[0][3]="+load[0][3]+"   load[0][4]="+load[0][4]+"   bal="+ubal);
            if(Double.valueOf(load[0][4])!=0)
            {
                //System.out.println("load[0][4].equals(0)"+load[0][4]);
                double tot=Double.valueOf(ubal)+Double.valueOf(load[0][4]);
                jLabel2.setText(""+(new java.math.BigDecimal(tot)).setScale(2,5));
            }
            else if(Double.valueOf(load[0][3])!=0 )
            {
                //System.out.println("load1[0][3].equals(0)"+load[0][3]);
                double tot=Double.valueOf(ubal)-Double.valueOf(load[0][3]);
                jLabel2.setText(""+(new java.math.BigDecimal(tot)).setScale(2,5));
            }

            //jTable1.getSelectionModel().setSelectionInterval(jTable1.getRowCount()-1, jTable1.getColumnCount()-1);
        jTable1.scrollRectToVisible(new java.awt.Rectangle(jTable1.getCellRect(dtm.getRowCount()-1, 0, true)));

        String arr2[]=new String[2];
        arr2[0]="Total Card Debit";
        arr2[1]=jTable1.getValueAt(dtm.getRowCount()-1, 4).toString();
        dtm1.addRow(arr2);
        String arr3[]=new String[2];
        arr3[0]="Total Card Use";
        arr3[1]=jTable1.getValueAt(dtm.getRowCount()-1, 12).toString();
        dtm2.addRow(arr3);
        double total=0;
        for(int a=0;a<dtm.getRowCount()-1;a++)
        {
            //System.out.println(jTable1.getValueAt(a, 5));
            if(!(jTable1.getValueAt(a, 5).equals("")))
            if(Double.valueOf(jTable1.getValueAt(a, 5).toString())!=0 && (jTable1.getValueAt(a, 5).equals(""))==false)
            {
                String part=jTable1.getValueAt(a, 3).toString();
                //System.out.println("part = "+part);
                for(int b=0;b<dtm.getRowCount()-1;b++)
                {
                    if(!(jTable1.getValueAt(b, 4).equals("")))
                    {
                    //System.out.println(jTable1.getValueAt(b, 3)+"                part="+part+"         "+Double.valueOf(jTable1.getValueAt(a, 5).toString())+"        "+Double.valueOf(jTable1.getValueAt(b, 4).toString()));
                    //boolean bn=jTable1.getValueAt(b, 3).equals(part) && (Double.valueOf(jTable1.getValueAt(a, 5).toString())==Double.valueOf(jTable1.getValueAt(b, 4).toString()));
                        if(jTable1.getValueAt(b, 3).equals(part) && jTable1.getValueAt(b, 4).equals(jTable1.getValueAt(a, 5)) )
                        {
                           // System.out.println("total auto reversal =");
                            total=total+Double.valueOf(jTable1.getValueAt(b, 4).toString());
                            //System.out.println("total auto reversal ="+total);
                            break;
                        }
                    }
                }
            }
        }

        
        arr2[0]="Total Auto Reversal ";
        arr2[1]=""+(new java.math.BigDecimal(total)).setScale(2,5);
        dtm1.addRow(arr2);


            arr2[0]="Net Reversed by UBI";
            String temp1=""+(Double.valueOf(jTable2.getValueAt(0, 1).toString())-Double.valueOf(jTable2.getValueAt(1, 1).toString()));
            arr2[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
            dtm1.addRow(arr2);
            //System.out.println("third Table Calculating Start");
            total=0;

            for(int a=0;a<dtm.getRowCount()-1;a++)
            {
                if(!(jTable1.getValueAt(a, 11).equals("")))
                {
                if(Double.valueOf(jTable1.getValueAt(a, 11).toString())!=0 && (jTable1.getValueAt(a, 11).equals(""))==false)
                {
                    String part=jTable1.getValueAt(a, 10).toString();
                    for(int b=0;b<dtm.getRowCount()-1;b++)
                    {
                        if(!(jTable1.getValueAt(b, 12).equals("")) && (jTable1.getValueAt(b, 12)!=null) )
                        {
                           if(jTable1.getValueAt(b, 10).equals(part) && jTable1.getValueAt(a, 11).equals(jTable1.getValueAt(b, 12)) )
                           {
                                total=total+Double.valueOf(jTable1.getValueAt(a, 11).toString());
                                break;
                           }
                        }
                    }
                }
                }
            }
            arr3[0]="Total Auto Reversal ";
            arr3[1]=""+(new java.math.BigDecimal(total)).setScale(2,5);
            dtm2.addRow(arr3);


            arr3[0]="Net Card Use ";
            temp1=""+(Double.valueOf(jTable3.getValueAt(0, 1).toString())-Double.valueOf(jTable3.getValueAt(1, 1).toString()));
            arr3[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
            dtm2.addRow(arr3);

            arr3[0]="CD A/C Debited ";
            arr3[1]=jTable2.getValueAt(jTable2.getRowCount()-1, 1).toString();
            dtm2.addRow(arr3);

            arr3[0]="Net Difference ";
            temp1=""+(Double.valueOf(jTable3.getValueAt(2, 1).toString())-Double.valueOf(jTable3.getValueAt(3, 1).toString()));
            arr3[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
            dtm2.addRow(arr3);
            System.out.println("Third Table difference Calculating Start");
            total=0;
            String breakup=null;
            double temp3=0;
            for(int a=0;a<dtm.getRowCount()-1;a++)
            {
                if(!(jTable1.getValueAt(a, 12).equals("")) && jTable1.getValueAt(a, 14).equals("N"))
                {
                    if(Double.valueOf(jTable1.getValueAt(a, 12).toString())!=0 && (jTable1.getValueAt(a, 12).equals(""))==false)
                    {
                        String part=jTable1.getValueAt(a, 10).toString();
                        double cre=Double.valueOf(jTable1.getValueAt(a, 12).toString());
                        //System.out.println("part = "+part+"   cre= "+cre);


                        boolean addflag=false;
                        for(int b=0;b<dtm.getRowCount()-1;b++)
                        {
                            if(!(jTable1.getValueAt(b, 11).equals("")))
                            {
                                double deb=Double.valueOf(jTable1.getValueAt(b, 11).toString());
                                String kpart=jTable1.getValueAt(b, 10).toString();
                                //System.out.println(part+"    "+kpart+"cre = "+cre+"     deb= "+deb+"           "+dtm.getRowCount());
                                
                                //if((cre!=deb || !part.equals(kpart)) && jTable1.getValueAt(b, 14).equals("N"))
                                if((cre==deb && part.equals(kpart)) && jTable1.getValueAt(b, 14).equals("N"))
                                {
                                    System.out.println("Break Up Of Net Difference = "+cre);
                                    addflag=true;
                                    break;
                                }
                             }
                            //System.out.println(".................................... = "+cre);
                        }
                        if(addflag==false)
                        {
                                    //System.out.println("part = " + part + "     kpart=" + kpart + "   cre= " + cre + "     deb=" + deb);
                            System.out.println("Break Up Of Net Difference = "+cre);
                            arr3[0]="Break Up Of Net Difference";
                                    arr3[1]=""+cre;
                                    dtm2.addRow(arr3);
                                    System.out.println("Break Up Of Net Difference = "+arr3[1]);

                        }
                    }
                }
            }
            arr3[0]="New Total Auto Reversal ";
            arr3[1]=""+(new java.math.BigDecimal(Double.valueOf(jTable3.getValueAt(1, 1).toString())+Double.valueOf(jTable3.getValueAt(4, 1).toString()))).setScale(2,5);
            String newrev=arr3[1];
            dtm2.addRow(arr3);
            arr3[0]="Net Card Use ";
            temp1=""+(Double.valueOf(jTable3.getValueAt(0, 1).toString())-Double.valueOf(newrev));
            arr3[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
            dtm2.addRow(arr3);
            String totu=temp1;
            arr3[0]="CD A/C Debited ";
            arr3[1]=jTable2.getValueAt(jTable2.getRowCount()-1, 1).toString();
            arr3[1]=""+(new java.math.BigDecimal(jTable2.getValueAt(jTable2.getRowCount()-1, 1).toString())).setScale(2,5);
            dtm2.addRow(arr3);
            arr3[0]="Net Difference ";
            System.out.println((jTable3.getValueAt(jTable3.getRowCount()-2, 1))+" ............... "+(jTable3.getValueAt(jTable3.getRowCount()-1, 1)));
            temp1=""+(Double.valueOf(jTable3.getValueAt(jTable3.getRowCount()-2, 1).toString())-Double.valueOf(jTable3.getValueAt(jTable3.getRowCount()-1, 1).toString()));
            arr3[1]=""+(new java.math.BigDecimal(temp1)).setScale(2,5);
            dtm2.addRow(arr3);
            flag1=1;
            normal();
        }
        catch(Exception ae)
        {
            System.out.println("Error in table method"+ae);
        }
    }
    java.math.BigDecimal bd=null;
    public boolean table4(String paymentno)
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
            qry="Select date,withdrawal,Deposit,sl_no from ubi_account_statement where ubi_payment_no="+Integer.parseInt(paymentno)+"";
            System.out.println(qry);
            String load[][]=object1.getInformationDD(qry,4);
            System.out.println(load.length);
            String arr[]=null;
            dtm.setRowCount(0);
            if(load.length>0)
            {
                arr=new String[5];
                for(int i=0;i<load.length;i++)
                {
                    String dt[]=load[i][0].split("-");
                    arr[0]=dt[2]+"-"+dt[1]+"-"+dt[0];
                    String wid=load[i][1];
                    String dep=load[i][2];
                    if(Double.valueOf(wid)==0)
                    {
                        arr[1]=dep;
                        arr[2]="Cr.";
                    }
                    if(Double.valueOf(dep)==0)
                    {
                        arr[1]=wid;
                        arr[2]="Dr.";
                    }
                    arr[3]=load[i][3];

                    dtm3.addRow(arr);
                    System.out.println("hello   "+i);
                }

            }
            flag2=1;
            normal();
            return true;

        }
        catch(Exception ae)
        {
            System.out.println("Eror in Save Information111....."+ae);
        }
        return true;


    }
    public void normal()
    {
        System.out.println("flag1="+flag1+"   flag2="+flag2);
        if(flag1==1 && flag2==1)
        {
            System.out.println("All Is Well");
            jPanel6.setVisible(false);
            jPanel3.setVisible(true);
        }
        
    }
}
