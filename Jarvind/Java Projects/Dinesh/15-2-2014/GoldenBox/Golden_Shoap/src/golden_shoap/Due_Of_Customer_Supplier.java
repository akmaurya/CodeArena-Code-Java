/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Due_Of_Customer_Supplier.java
 *
 * Created on Feb 13, 2014, 3:10:37 PM
 */

package golden_shoap;

/**
 *
 * @author user1
 */
public class Due_Of_Customer_Supplier extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm;
    /** Creates new form Due_Of_Customer_Supplier */
    public Due_Of_Customer_Supplier() {
        initComponents();

            dtm=new javax.swing.table.DefaultTableModel();
            javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
            CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
            CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
            CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
            javax.swing.table.TableColumn column;
            String heading1[]={"S.No","Name","Contact","Address","Due Amount"};
            dtm=new javax.swing.table.DefaultTableModel(heading1,0);
            jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
            jTable1.setModel(dtm);
            column=jTable1.getColumn("S.No");
            column.setCellRenderer(CRCenter);
            column.setPreferredWidth(70);

            column=jTable1.getColumn("Name");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(230);

            column=jTable1.getColumn("Contact");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(120);

            column=jTable1.getColumn("Address");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(220);

            column=jTable1.getColumn("Due Amount");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(145);

            jTextField1.setText("0.00");
            jTextField1.setEditable(false);


 }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Due Status Of Customer and Supplier");
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial", 1, 12));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("All ");
        jPanel1.add(jRadioButton1);
        jRadioButton1.setBounds(20, 20, 130, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Arial", 1, 12));
        jRadioButton2.setText("Customer");
        jPanel1.add(jRadioButton2);
        jRadioButton2.setBounds(170, 20, 150, 23);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Arial", 1, 12));
        jRadioButton3.setText("Supplier");
        jPanel1.add(jRadioButton3);
        jRadioButton3.setBounds(340, 20, 100, 23);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.gif"))); // NOI18N
        jButton1.setText("View");
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
        jButton1.setBounds(480, 20, 150, 30);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12));
        jButton2.setText("Close");
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
        jButton2.setBounds(640, 20, 130, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeskTopTextureEdit11.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(2, -1, 790, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 790, 70);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("Total Due Amount -");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(550, 580, 130, 23);

        jTextField1.setFont(new java.awt.Font("Arial", 1, 12));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(679, 580, 120, 23);

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
        jTable1.setSelectionBackground(new java.awt.Color(255, 153, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 790, 480);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeskTopTexture.png"))); // NOI18N
        jLabel7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel7KeyPressed(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, -10, 810, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        getData();

         
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
         getData();
    }//GEN-LAST:event_jButton1KeyPressed

    private void jLabel7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel7KeyPressed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel7KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

     public void getData()
    {
        dtm.setRowCount(0);
        int catagory=0;
        int group=0;
        String qry="";
        if(jRadioButton2.isSelected())
        {
            group=11;
            catagory=1;
            qry="Select ac_code,ac_name,ac_address,ac_contact from ac_master where ac_category_code="+catagory+" and ac_group_code="+group+" order by ac_name";
        }
        else if(jRadioButton3.isSelected())
        {
            group=12;
            catagory=1;
            qry="Select ac_code,ac_name,ac_address,ac_contact from ac_master where ac_category_code="+catagory+" and ac_group_code="+group+" order by ac_name";
        }
        else
        {
            qry="Select ac_code,ac_name,ac_address,ac_contact from ac_master where ac_category_code=1 and (ac_group_code=11 or ac_group_code=12) order by ac_name";
        }



        System.out.println(qry);
        String load[][]=Utility.getInformationDD(qry,4);
        String arr[];
        double total=0;
        if(load.length>0)
        {
            arr=new String[5];
            for(int i=0;i<load.length;i++)
            {
                arr[0]=""+(i+1);
                arr[1]=load[i][1];
                arr[2]=load[i][3];
                arr[3]=load[i][2];

                String qry1="Select ac_dr,ac_cr from ac_smry where ac_code="+(Integer.parseInt(load[i][0]))+"";
                String load1[][]=Utility.getInformationDD(qry1,2);
                double dr=Double.valueOf(load1[0][0]);
                double cr=Double.valueOf(load1[0][1]);
                double due=(dr-cr);
                java.math.BigDecimal bd=new java.math.BigDecimal(due);
                arr[4]=(""+bd.setScale(2,5));
                total=total+due;
                dtm.addRow(arr);

            }

        }
         java.math.BigDecimal bd=new java.math.BigDecimal(total);
        jTextField1.setText(""+bd.setScale(2,5));
        

    }
}
