/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Supplier_Screen.java
 *
 * Created on Dec 10, 2013, 2:13:47 PM
 */

package golden_shoap;

/**
 *
 * @author user1
 */
public class Supplier_Screen extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm;
    /** Creates new form Supplier_Screen */
    public Supplier_Screen() {
        initComponents();

        dtm=new javax.swing.table.DefaultTableModel();
            javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
            CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
            CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
            CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
            javax.swing.table.TableColumn column;
            String heading1[]={"Supplier Name","Contact","Address","Email ID"};
            dtm=new javax.swing.table.DefaultTableModel(heading1,0);
            jTable1.setModel(dtm);
            column=jTable1.getColumn("Supplier Name");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(150);

            column=jTable1.getColumn("Contact");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(80);

            column=jTable1.getColumn("Address");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(150);

            column=jTable1.getColumn("Email ID");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(150);

           loadItemsInTable();

    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Supplier Screen");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Supplier Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 90, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setText("Suplier Address");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 50, 90, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel3.setText("Contact");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(340, 20, 70, 15);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savefile.gif"))); // NOI18N
        jButton1.setText("Add");
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
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 320, 100, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.gif"))); // NOI18N
        jButton2.setText("Update");
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
        jButton2.setBounds(10, 370, 100, 40);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.gif"))); // NOI18N
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
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 420, 100, 40);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.gif"))); // NOI18N
        jButton4.setText("Close");
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
        getContentPane().add(jButton4);
        jButton4.setBounds(10, 470, 100, 40);

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
        getContentPane().add(jTextField1);
        jTextField1.setBounds(120, 20, 200, 20);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(400, 20, 180, 20);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(120, 50, 460, 20);

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
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 140, 460, 370);

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(120, 80, 230, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel4.setText("E-mail Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 80, 80, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BillPayment.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 130, 90, 120);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(120, 110, 460, 2);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel6.setText("Supplier Details");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(120, 120, 120, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1ActionPerformed
     public void loadItemsInTable()
    {
        dtm.setRowCount(0);
        String qry="select * from supplier_master";
        String[][] data=Utility.getInformationDD(qry,4);
       int length= data.length;
       String arr[]=new String[4];
       for(int i=0;i<length;i++)
       {   for(int j=0;j<4;j++)
           {
               arr[j]=data[i][j];
           }
           dtm.addRow(arr);
       }
      }



    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String supplierName=jTextField1.getText();
        String supplierAddress=jTextField2.getText();
        String supplierContact=jTextField3.getText();
        String supplierEmailId=jTextField4.getText();

        if(supplierName.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Supplier name must be entered." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();

        }
        else if(supplierContact.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Contact  must be entered." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField3.requestFocus();

        }
        else
        {       //to check id duplicate record
                int flag=0;
                 String qry="select supplier_name from supplier_master";
                 String[][] data=Utility.getInformationDD(qry,1);
                 int len= data.length;
                 String arr=null;
                 for(int i=0;i<len;i++)
                 {    if((data[0][0]).equals(supplierName))
                      {
                          flag=1;
                      }
                 }
            //End
            if(flag==0)
            {
            Utility.makeConnection();
            String qry1="insert into supplier_master values('"+supplierName.toUpperCase()+"','"+supplierContact+"','"+supplierAddress+"','"+supplierEmailId+"')";
            Utility.saveInformation(qry1);
            loadItemsInTable();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            javax.swing.JOptionPane.showMessageDialog(this,"Record sucessfully save." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();
            }
            else
            {
            javax.swing.JOptionPane.showMessageDialog(this,"Record already exist" ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField2.requestFocus();
        }

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton1.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String supplierName=jTextField1.getText();
        if(supplierName.equalsIgnoreCase(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Plese select record from the table." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();
        }
        else
        {
             int flag=0;
             String qry1="select * from supplier_master";
             String[][] data=Utility.getInformationDD(qry1,1);
             int length= data.length;
             for(int i=0;i<length;i++)
             {  if(data[i][0].equals(supplierName))
                {
                   flag=1;
                   break;
                }
             }
            if(flag==1)
            {
                Utility.makeConnection();
                String qry="delete * from supplier_master where supplier_name='"+supplierName+"'";
                int check=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure you want to delete record from the table ?" ,"Confirm Window",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
                if(check==javax.swing.JOptionPane.YES_OPTION)
                {
                    Utility.saveInformation(qry);
                    loadItemsInTable();
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField1.requestFocus();
                }
                if(check==javax.swing.JOptionPane.NO_OPTION)
                {
                    jTextField1.requestFocus();
                }
             }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Record does not exist. Please select from the table. " ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jTextField1.requestFocus();
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
     
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
           int selectedRow=jTable1.getSelectedRow();System.out.println(selectedRow);
        String supplierName=""+jTable1.getValueAt(selectedRow,0);
        String supplierAddress=""+jTable1.getValueAt(selectedRow,2);
        String supplierContact=""+jTable1.getValueAt(selectedRow,1);
        String supplierEmailId=""+jTable1.getValueAt(selectedRow,3);
        jTextField1.setText(supplierName);
        jTextField3.setText(supplierAddress);
        jTextField2.setText(supplierContact);
        jTextField4.setText(supplierEmailId);
        jTextField1.requestFocus();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int flag=0;
        Utility.makeConnection();
        if(jTable1.getSelectedRow()!=(-1))
        {
        int selectedRow=jTable1.getSelectedRow();
        String supplierName=(jTextField1.getText()).toUpperCase();
        String supplierContact=jTextField2.getText();
        String supplierAddress=jTextField3.getText();
        String supplierEmailId=jTextField4.getText();
        String selectedSupplierName=""+jTable1.getValueAt(selectedRow,0);

        if(supplierName.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Supplier name does not blank." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();

        }
        else if(supplierContact.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Contact number does not blank" ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();

        }
        else
        {            //to restrict duplicate entry start
                     String qry1="select * from supplier_master";
                     String[][] data=Utility.getInformationDD(qry1,1);
                      int length= data.length;
                     for(int i=0;i<length;i++)
                      {   if(data[i][0].equals(supplierName))
                          {
                             flag=1;
                             break;
                           }
                       }
                     //End
              if(flag==0)
              {
                 int check=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure to update supplier record ?" ,"Confirm Window",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
                 if(check==javax.swing.JOptionPane.YES_OPTION)
                 {    String qry="update supplier_master set supplier_name='"+supplierName+"',supplier_contact='"+supplierContact+"',supplier_address='"+supplierAddress+"',supplier_email_id='"+supplierEmailId+"' where supplier_name='"+selectedSupplierName+"'";
                      jTextField1.requestFocus();
                      loadItemsInTable();
                 }
                 if(check==javax.swing.JOptionPane.NO_OPTION)
                 {
                      jTextField1.setText(selectedSupplierName);
                 }
              }
              else
              {
                javax.swing.JOptionPane.showMessageDialog(this,"Record already exist." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jTextField1.requestFocus();
                jTextField1.setText(selectedSupplierName);

              }
        }
     }
    else
    {
         javax.swing.JOptionPane.showMessageDialog(this,"Please select record from the table. " ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
         jTextField1.requestFocus();
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        String supplierName=jTextField1.getText();
        String supplierAddress=jTextField2.getText();
        String supplierContact=jTextField3.getText();
        String supplierEmailId=jTextField4.getText();

        if(supplierName.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Supplier name must be entered." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();

        }
        else if(supplierContact.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Contact  must be entered." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField3.requestFocus();

        }
        else
        {       //to check id duplicate record
                int flag=0;
                 String qry="select supplier_name from supplier_master";
                 String[][] data=Utility.getInformationDD(qry,1);
                 int len= data.length;
                 String arr=null;
                 for(int i=0;i<len;i++)
                 {    if((data[0][0]).equals(supplierName))
                      {
                          flag=1;
                      }
                 }
            //End
            if(flag==0)
            {
            Utility.makeConnection();
            String qry1="insert into supplier_master values('"+supplierName.toUpperCase()+"','"+supplierContact+"','"+supplierAddress+"','"+supplierEmailId+"')";
            Utility.saveInformation(qry1);
            loadItemsInTable();
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            javax.swing.JOptionPane.showMessageDialog(this,"Record sucessfully save." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();
            }
            else
            {
            javax.swing.JOptionPane.showMessageDialog(this,"Record already exist" ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();

            }
        }

    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
         int flag=0;
        Utility.makeConnection();
        if(jTable1.getSelectedRow()!=(-1))
        {
        int selectedRow=jTable1.getSelectedRow();
        String supplierName=jTextField1.getText();
        String supplierContact=jTextField2.getText();
        String supplierAddress=jTextField3.getText();
        String supplierEmailId=jTextField4.getText();
        String selectedSupplierName=""+jTable1.getValueAt(selectedRow,0);

        if(supplierName.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Supplier name does not blank." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();

        }
        else if(supplierContact.isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Contact number does not blank" ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();

        }
        else
        {            //to restrict duplicate entry start
                     String qry1="select * from supplier_master";
                     String[][] data=Utility.getInformationDD(qry1,1);
                      int length= data.length;
                     for(int i=0;i<length;i++)
                      {   if(data[i][0].equals(supplierName))
                          {
                             flag=1;
                             break;
                           }
                       }
                     //End
              if(flag==0)
              {
                 int check=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure to update supplier record ?" ,"Confirm Window",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
                 if(check==javax.swing.JOptionPane.YES_OPTION)
                 {    String qry="update supplier_master set supplier_name='"+supplierName.toUpperCase()+"',supplier_contact='"+supplierContact+"',supplier_address='"+supplierAddress+"',supplier_email_id='"+supplierEmailId+"' where supplier_name='"+selectedSupplierName+"'";
                      jTextField1.requestFocus();
                      loadItemsInTable();
                 }
                 if(check==javax.swing.JOptionPane.NO_OPTION)
                 {
                      jTextField1.setText(selectedSupplierName);
                 }
              }
              else
              {
                javax.swing.JOptionPane.showMessageDialog(this,"Record already exist." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jTextField1.requestFocus();
                jTextField1.setText(selectedSupplierName);

              }
        }
     }
    else
    {
         javax.swing.JOptionPane.showMessageDialog(this,"Please select record from the table. " ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
         jTextField1.requestFocus();
    }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
         String supplierName=jTextField1.getText();
        if(supplierName.equalsIgnoreCase(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Plese select record from the table." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jTextField1.requestFocus();
        }
        else
        {
             int flag=0;
             String qry1="select * from supplier_master";
             String[][] data=Utility.getInformationDD(qry1,1);
             int length= data.length;
             for(int i=0;i<length;i++)
             {  if(data[i][0].equals(supplierName))
                {
                   flag=1;
                   break;
                }
             }
            if(flag==1)
            {
                Utility.makeConnection();
                String qry="delete * from supplier_master where supplier_name='"+supplierName+"'";
                int check=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure you want to delete record from the table ?" ,"Confirm Window",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
                if(check==javax.swing.JOptionPane.YES_OPTION)
                {
                    Utility.saveInformation(qry);
                    loadItemsInTable();
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jTextField1.requestFocus();
                }
                if(check==javax.swing.JOptionPane.NO_OPTION)
                {
                    jTextField1.requestFocus();
                }
             }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Record does not exist. Please select from the table. " ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jTextField1.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton3KeyPressed


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}