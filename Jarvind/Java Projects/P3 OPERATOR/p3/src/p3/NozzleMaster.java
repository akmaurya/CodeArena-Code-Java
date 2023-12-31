/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NozzleMaster.java
 *
 * Created on Jun 6, 2014, 1:56:57 PM
 */

package p3;

/**
 *
 * @author welcome
 */
public class NozzleMaster extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm;

    /** Creates new form NozzleMaster */
    public NozzleMaster(String uid,String cnm,String fyear) {
        
        initComponents();
        
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        String heading[]={"S.No.","Tank Name","Nozzle No.","Opening","Something","Leverage Type"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
        jTable1.setModel(dtm);

        javax.swing.table.TableColumn column;


        column=jTable1.getColumn("S.No.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(55);
        column=jTable1.getColumn("Tank Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(120);
        column=jTable1.getColumn("Nozzle No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(120);
        column=jTable1.getColumn("Opening");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(120);
        column=jTable1.getColumn("Something");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(120);
        column=jTable1.getColumn("Leverage Type");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(120);

        loadTank();
        loadJTable();
        jComboBox1.requestFocus();
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
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Nozzle Master Window");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel1.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true), javax.swing.BorderFactory.createTitledBorder("")));
        jPanel4.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(null);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(100, 20, 160, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Nozzle No.");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(270, 20, 70, 30);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(340, 20, 110, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Opening Meter Reading");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 70, 160, 30);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(340, 70, 110, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setText("Close");
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
        jButton1.setBounds(330, 250, 110, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setText("Save");
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
        jButton2.setBounds(10, 250, 110, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton3.setText("Delete");
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
        jButton3.setBounds(120, 250, 110, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton4.setText("Clear");
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
        jPanel2.add(jButton4);
        jButton4.setBounds(230, 250, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Tank Name");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 20, 90, 30);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField2);
        jTextField2.setBounds(170, 70, 170, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("Leverage Type Of Nozzle");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 120, 160, 30);

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Cash", "Reverse InFlow" }));
        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox3KeyPressed(evt);
            }
        });
        jPanel2.add(jComboBox3);
        jComboBox3.setBounds(170, 120, 140, 30);

        jCheckBox2.setBackground(new java.awt.Color(247, 247, 234));
        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jCheckBox2.setText("I have O.K. meter");
        jCheckBox2.setOpaque(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jCheckBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCheckBox2KeyPressed(evt);
            }
        });
        jPanel2.add(jCheckBox2);
        jCheckBox2.setBounds(310, 120, 140, 30);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(10, 10, 460, 300);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel3.setLayout(new java.awt.BorderLayout());

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel3);
        jPanel3.setBounds(480, 10, 450, 300);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 10, 945, 320);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        loadNozzle();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select Tank Name.");
            jComboBox1.requestFocus();
        }

        else if(jComboBox2.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select Nozzle Number.");
            jComboBox2.requestFocus();
        }

        else if(jTextField1.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter after Opening Meter Reading.");
            jTextField1.requestFocus();
        }

        else if(jTextField2.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter Opening Meter Reading.");
            jTextField2.requestFocus();
        }

        else if(jComboBox3.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select Leverage Type Of Nozzle.");
            jComboBox3.requestFocus();
        }

        else if(redundantTank()==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Tank Name already exist.");
            jComboBox1.requestFocus();
        }

        else
        {
            if(jTable1.getSelectedRowCount()>0)
            {
                int c=javax.swing.JOptionPane.showConfirmDialog(this, "This Unit is already exists.", "Save record", javax.swing.JOptionPane.YES_NO_OPTION);
                if(c==javax.swing.JOptionPane.YES_OPTION)
                {
                    save();
                }
            }
            else
            {
                save();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRowCount()<1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Record is not selected.");
        }

        else if(dtm.getRowCount() > 0)
        {
            int c=javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Delete record", javax.swing.JOptionPane.YES_NO_OPTION);
            if(c==javax.swing.JOptionPane.YES_OPTION)
            {
                deleteRecord();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clearWindow();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox3.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select Tank Name.");
            jComboBox1.requestFocus();
        }

        else if(jComboBox2.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select Nozzle Number.");
            jComboBox2.requestFocus();
        }

        else if(jTextField1.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter Opening.");
            jTextField1.requestFocus();
        }

        else if(redundantTank()==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Tank Name already exist.");
            jComboBox1.requestFocus();
        }

        else
        {
            if(jTable1.getSelectedRowCount()>0)
            {
                int c=javax.swing.JOptionPane.showConfirmDialog(this, "This Unit is already exists.", "Save record", javax.swing.JOptionPane.YES_NO_OPTION);
                if(c==javax.swing.JOptionPane.YES_OPTION)
                {
                    save();
                }
            }
            else
            {
                save();
            }
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(jTable1.getSelectedRowCount()<1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Record is not selected.");
        }

        else if(dtm.getRowCount() > 0)
        {
            int c=javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Delete record", javax.swing.JOptionPane.YES_NO_OPTION);
            if(c==javax.swing.JOptionPane.YES_OPTION)
            {
                deleteRecord();
            }
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        clearWindow();
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jCheckBox2.requestFocus();
}//GEN-LAST:event_jComboBox3KeyPressed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jButton2.requestFocus();
}//GEN-LAST:event_jCheckBox2KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i=jTable1.getSelectedRow();

        jComboBox1.setSelectedItem(jTable1.getValueAt(i, 1).toString());
        jComboBox2.setSelectedItem(jTable1.getValueAt(i, 2).toString());

        jTextField2.setText(jTable1.getValueAt(i, 3).toString());
        jTextField1.setText(jTable1.getValueAt(i, 4).toString());

        int leverage=Integer.parseInt(jTable1.getValueAt(i, 5).toString());
        if(leverage==1)
        {
            jComboBox3.setSelectedIndex(1);
            jCheckBox2.setSelected(false);
        }
        else if(leverage==2)
        {
            jComboBox3.setSelectedIndex(2);
            jCheckBox2.setSelected(false);
        }
        else if(leverage==3)
        {
            jComboBox3.setSelectedIndex(0);
            jCheckBox2.setSelected(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

public void loadTank()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String qry="select TankName from tank_master order by TankName";
        String arr[]=object1.getResultSetAs_1D_Array(qry, Main.year);

        jComboBox1.removeAllItems();
        jComboBox1.addItem("Select");

        if(arr.length>0)
        {
            for(int i=0;i<arr.length;i++)
            {
                jComboBox1.addItem(arr[i]);
            }
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In getrecord Method "+e);
    }
}

public void loadNozzle()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String qry="select NoOfNozzle from tank_master where TankName='"+jComboBox1.getSelectedItem().toString()+"'";
        String arr=object1.getSigetngleValue(qry, Main.year);

        jComboBox2.removeAllItems();
        jComboBox2.addItem("Select");

        for(int i=0;i<Integer.parseInt(arr);i++)
        {
            jComboBox2.addItem(""+(i+1));
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In getrecord Method "+e);
    }
}

public void loadJTable()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String qry="select * from nozzle_master";
        String arr[][]=object1.getInformationDD(qry, 5, Main.year);

        String arr1[]=new String[6];
        for(int i=0;i<arr.length;i++)
        {
            arr1[0]=""+(i+1);
            arr1[1]=arr[i][0];
            arr1[2]=arr[i][1];
            arr1[3]=arr[i][2];
            arr1[4]=arr[i][3];
            arr1[5]=arr[i][4];
            dtm.addRow(arr1);
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method "+e);
    }
}

public void save()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String tank_name=jComboBox1.getSelectedItem().toString();
        int nozzle_no=Integer.parseInt(jComboBox2.getSelectedItem().toString());
        Double opening=Double.valueOf(jTextField2.getText());
        Double something=Double.valueOf(jTextField1.getText());
        int leverage_type=Integer.parseInt(""+jComboBox3.getSelectedIndex());

        if(jCheckBox2.isSelected()==true)
            leverage_type=3;

        String qry="insert into nozzle_master values ('"+tank_name+"',"+nozzle_no+","+opening+","+something+","+leverage_type+")";
        System.out.println("qry="+qry);
        boolean bn=object1.saveInformation(qry, Main.year);

        if(bn==true)
        {
            dtm.setRowCount(0);
            loadJTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Saving process completed.");
            clearWindow();
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In getrecord Method "+e);
    }
}

public void clearWindow()
{
    jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(0);
    jTextField1.setText("");
    jComboBox1.requestFocus();
}

public void deleteRecord()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String qry="delete from nozzle_master where TankName='"+jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString()+"'";
        boolean bn=object1.saveInformation(qry, Main.year);

        if(bn==true)
        {
            dtm.setRowCount(0);
            loadJTable();
            clearWindow();
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method "+e);
    }
}

public boolean redundantTank()
{
    boolean check=false;
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String qry="select TankName from nozzle_master where TankName='"+jComboBox1.getSelectedItem().toString()+"' and Nozzle_No="+Integer.parseInt(jComboBox2.getSelectedItem().toString())+"";
        String arr[]=object1.getResultSetAs_1D_Array(qry, Main.year);
        
        if(arr.length>0)
        {
             check=true;
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method "+e);
    }

    return check;
}
}