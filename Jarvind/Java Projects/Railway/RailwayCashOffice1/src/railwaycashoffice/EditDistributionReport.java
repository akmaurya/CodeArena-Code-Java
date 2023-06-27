/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditDistributionReport.java
 *
 * Created on Jun 13, 2012, 11:09:11 AM
 */

package railwaycashoffice;

/**
 *
 * @author user2
 */
public class EditDistributionReport extends javax.swing.JInternalFrame {

    /** Creates new form EditDistributionReport */
    public EditDistributionReport() {
        initComponents();
        java.util.Date dt=new java.util.Date();
        String curDate=dt.getDate()+"-"+(dt.getMonth()+1)+"-"+(dt.getYear()+1900);
        jLabel3.setText(curDate);
        jLabel6.setText(curDate);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        jTable2.setAutoResizeMode(jTable2.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        javax.swing.table.TableColumn column;
        String head[]={"Sr.No.","Dept. Name","Bill Date","PMR No.","CO7","CO6","Cashier No.","Party Name","Amount","Amount Type","Edit Date","Edit Time","Edited By ID"};
        dtm1=new javax.swing.table.DefaultTableModel(head,0);
        jTable1.setModel(dtm1);

        column=jTable1.getColumn("Sr.No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(50);
        
        column=jTable1.getColumn("Dept. Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Bill Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("PMR No.");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        
        column=jTable1.getColumn("CO7");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("CO6");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Cashier No.");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        
        column=jTable1.getColumn("Party Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(130);
        column=jTable1.getColumn("Amount");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Amount Type");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        
        column=jTable1.getColumn("Edit Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Edit Time");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Edited By ID");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(90);
        

        String head1[]={"Sr.No.","Dept. Name","Bill Date","PMR No.","CO7","CO6","Cashier No.","Party Name","Amount","Amount Type","Delete Date","Delete Time","Deleted By ID"};
        dtm2=new javax.swing.table.DefaultTableModel(head1,0);
        jTable2.setModel(dtm2);

        column=jTable2.getColumn("Sr.No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(50);
        column=jTable2.getColumn("Dept. Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(90);
        column=jTable2.getColumn("Bill Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable2.getColumn("PMR No.");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable2.getColumn("CO7");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable2.getColumn("CO6");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable2.getColumn("Cashier No.");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable2.getColumn("Party Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(120);
        column=jTable2.getColumn("Amount");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("Amount Type");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable2.getColumn("Delete Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable2.getColumn("Delete Time");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(90);
        column=jTable2.getColumn("Deleted By ID");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(90);
        


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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Edit Distribution Report");
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("To");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(330, 10, 30, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Edit Date");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 90, 30);

        jLabel3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 10, 140, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("From");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(80, 10, 50, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("From");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(80, 10, 50, 30);

        jLabel6.setBackground(new java.awt.Color(153, 153, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("jLabel6");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(360, 10, 140, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railwaycashoffice/images/calendar.png"))); // NOI18N
        jButton1.setToolTipText("Select starting date");
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
        jPanel1.add(jButton1);
        jButton1.setBounds(270, 8, 40, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railwaycashoffice/images/calendar.png"))); // NOI18N
        jButton2.setToolTipText("Select last date");
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
        jPanel1.add(jButton2);
        jButton2.setBounds(500, 8, 40, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton3.setMnemonic('S');
        jButton3.setText("Show");
        jButton3.setToolTipText("Show");
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
        jPanel1.add(jButton3);
        jButton3.setBounds(580, 10, 110, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton4.setMnemonic('c');
        jButton4.setText("Close");
        jButton4.setToolTipText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton4FocusLost(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(710, 10, 110, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 830, 60);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Edit Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 80, 830, 180);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Delete Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 51, 0))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

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
        jScrollPane2.setViewportView(jTable2);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 270, 830, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Cal date1=new Cal();
           jLabel3.setText(date1.getdate());
           jButton2.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            Cal date1=new Cal();
           jLabel3.setText(date1.getdate());
           jButton2.requestFocus();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Cal date1=new Cal();
           jLabel6.setText(date1.getdate());
           jButton3.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            Cal date1=new Cal();
           jLabel6.setText(date1.getdate());
           jButton3.requestFocus();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            this.dispose();
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        showEditDetails();
        showDeleteDetails();
        if(dtm1.getRowCount()<=0 && dtm2.getRowCount()<=0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"No Record found");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            showEditDetails();
            showDeleteDetails();
            if(dtm1.getRowCount()<=0 && dtm2.getRowCount()<=0)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"No Record found");
            }
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusGained
        // TODO add your handling code here:
        jButton3.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_jButton3FocusGained

    private void jButton3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusLost
        // TODO add your handling code here:
        jButton3.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_jButton3FocusLost

    private void jButton4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton4FocusGained
        // TODO add your handling code here:
        jButton4.setBackground(java.awt.Color.yellow);
    }//GEN-LAST:event_jButton4FocusGained

    private void jButton4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton4FocusLost
        // TODO add your handling code here:
        jButton4.setBackground(java.awt.Color.white);
    }//GEN-LAST:event_jButton4FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
    javax.swing.table.DefaultTableModel dtm1;
    javax.swing.table.DefaultTableModel dtm2;


    private void showEditDetails()
    {
        dtm1.setRowCount(0);
        try
        {
           // interfaceRailway inf=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
				}
		}
            String temp[]=jLabel3.getText().split("-");
            String date1=temp[2]+"-"+temp[1]+"-"+temp[0];
            temp=jLabel6.getText().split("-");
            String date2=temp[2]+"-"+temp[1]+"-"+temp[0];
            String qry="select * from build_distribution_edit where editDate>='"+date1+"' and editDate<='"+date2+"' and operation='UPDATE'";
            String data[][]=inf.getInformationDD(qry,13,Main.year);
            if(data!=null && data.length>0)
            {
                String tab[]=new String[13];
                for(int i=0;i<data.length;i++)
                {
                    tab[0]=""+(i+1)+".";
                    qry="select dp_name from department_detail where dp_code="+Integer.parseInt(data[i][0])+"";
                    tab[1]=inf.getSigetngleValue(qry,Main.year);
                    temp=data[i][1].split("-");
                    tab[2]=temp[2]+"-"+temp[1]+"-"+temp[0];
                    tab[3]=data[i][2];
                    tab[4]=data[i][3];
                    tab[5]=data[i][4];
                    qry="select cashier_number from cashier_detail where cashier_code="+Integer.parseInt(data[i][5])+"";
                    tab[6]=inf.getSigetngleValue(qry,Main.year);
                    tab[7]=data[i][6];
                    tab[8]=""+(new java.math.BigDecimal(data[i][7]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
                    tab[9]=data[i][8];
                    temp=data[i][9].split("-");
                    tab[10]=temp[2]+"-"+temp[1]+"-"+temp[0];
                    tab[11]=data[i][10];
                    tab[12]=data[i][12];
                    dtm1.addRow(tab);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error...1234567...."+e);
        }
    }
    private void showDeleteDetails()
    {
        dtm2.setRowCount(0);
        try
        {
           // interfaceRailway inf=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
				}
		}
            String temp[]=jLabel3.getText().split("-");
            String date1=temp[2]+"-"+temp[1]+"-"+temp[0];
            temp=jLabel6.getText().split("-");
            String date2=temp[2]+"-"+temp[1]+"-"+temp[0];
            String qry="select * from build_distribution_edit where editDate>='"+date1+"' and editDate<='"+date2+"' and operation='DELETE'";
            String data[][]=inf.getInformationDD(qry,13,Main.year);
            if(data!=null && data.length>0)
            {
                String tab[]=new String[13];
                for(int i=0;i<data.length;i++)
                {
                    tab[0]=""+(i+1)+".";
                    qry="select dp_name from department_detail where dp_code="+Integer.parseInt(data[i][0])+"";
                    tab[1]=inf.getSigetngleValue(qry,Main.year);
                    temp=data[i][1].split("-");
                    tab[2]=temp[2]+"-"+temp[1]+"-"+temp[0];
                    tab[3]=data[i][2];
                    tab[4]=data[i][3];
                    tab[5]=data[i][4];
                    qry="select cashier_number from cashier_detail where cashier_code="+Integer.parseInt(data[i][5])+"";
                    tab[6]=inf.getSigetngleValue(qry,Main.year);
                    tab[7]=data[i][6];
                    tab[8]=""+(new java.math.BigDecimal(data[i][7]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
                    tab[9]=data[i][8];
                    temp=data[i][9].split("-");
                    tab[10]=temp[2]+"-"+temp[1]+"-"+temp[0];
                    tab[11]=data[i][10];
                    tab[12]=data[i][12];
                    dtm2.addRow(tab);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error...1del7...."+e);
        }
    }
}
