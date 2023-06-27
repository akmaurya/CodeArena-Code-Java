/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Customer_Screen.java
 *
 * Created on Dec 9, 2013, 1:09:26 PM
 */

package golden_shoap;

/**
 *
 * @author user1
 */
public class Customer_Screen extends javax.swing.JInternalFrame {
    javax.swing.table.DefaultTableModel dtm;
    /** Creates new form Customer_Screen */
    public Customer_Screen() {
        initComponents();
         dtm=new javax.swing.table.DefaultTableModel();

            javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
            CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
            CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
            CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
            javax.swing.table.TableColumn column;
            String heading1[]={"S.No","A/C Group","A/C Category","A/C Name","A/C Address","A/C Contact","A/C Email ID"};
            dtm=new javax.swing.table.DefaultTableModel(heading1,0);
            jTable1.setModel(dtm);
            column=jTable1.getColumn("S.No");
            column.setCellRenderer(CRCenter);
            column.setPreferredWidth(40);

            column=jTable1.getColumn("A/C Group");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(80);

            column=jTable1.getColumn("A/C Category");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(90);


            column=jTable1.getColumn("A/C Name");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(150);

            column=jTable1.getColumn("A/C Address");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(190);

            column=jTable1.getColumn("A/C Contact");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(100);

            column=jTable1.getColumn("A/C Email ID");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(150);


            //add item in combo box
            categoryComboItem();
            groupComboItem();
            loadItemsInTable();
            jTextField1.requestFocus();

            jTable1.setEnabled(false);
    }
    public int setAccountCode()
    {
                                  

        int accountCode=0;
        String qry="select max(ac_code) from ac_master";
        String str=Utility.getSingleValue(qry);
         if(str==null)
         {   accountCode=1;
              
         }
        else
         {  accountCode=Integer.parseInt(str);

             accountCode=accountCode+1;
        }
        return accountCode;
    }

  public void categoryComboItem()
  {
         String qry="select ac_category_name from ac_category"  ;
                      String[][] data=Utility.getInformationDD(qry,1);
                      int length= data.length;
                      for(int i=0;i<length;i++)
                      {   jComboBox2.addItem(data[i][0]);
                      }

  }
  public void groupComboItem()
  {
        String qry="select ac_group_name from ac_group"  ;
                      String[][] data=Utility.getInformationDD(qry,1);
                      int length= data.length;
                      for(int i=0;i<length;i++)
                      {   jComboBox1.addItem(data[i][0]);
                      }


  }
  public void save()
  {
        int flag=0;
        String acName=(jTextField1.getText()).toUpperCase();
        String qry1="select ac_name from ac_master";
        String[][] data=Utility.getInformationDD(qry1,1);
        int length= data.length;
        if(length>0)
        {
            for(int i=0;i<length;i++)
            {
                 if(acName.equals(data[i][0]))
                 {
                     flag=1;
                     break;
                }
            }
        }
        if(flag==0)
        {
                    String acAddress=jTextField2.getText();
                    String acContact=jTextField3.getText();
                    String acEmailId=jTextField4.getText();
                    String acGroup=""+jComboBox1.getSelectedItem();
                    String acCategory=""+jComboBox2.getSelectedItem();
                    Utility.makeConnection();
                    qry1="select ac_group_code from ac_group where ac_group_name='"+acGroup+"'";
                    int groupCode=Integer.parseInt(""+Utility.getSingleValue(qry1));
                    qry1="select ac_category_code from ac_category where ac_category_name='"+acCategory+"'";
                    int categoryCode=Integer.parseInt(""+Utility.getSingleValue(qry1));
  
                    int acCode=setAccountCode();
  
                                        qry1="insert into ac_master values("+groupCode+","+categoryCode+","+acCode+",'"+acName+"','"+acAddress+"','"+acContact+"','"+acEmailId+"')";
                                        Utility.saveInformation(qry1);
                                        qry1="insert into ac_smry values("+acCode+","+0+","+0+","+0+")";
                                        Utility.saveInformation(qry1);

                                        //loadItemsInTable();
                                        jTextField1.setText("");
                                        jTextField2.setText("");
                                        jTextField3.setText("");
                                        jTextField4.setText("");
                                        jComboBox1.setSelectedItem("Customer");
                                        jComboBox2.setSelectedItem("Polish");
                                        javax.swing.JOptionPane.showMessageDialog(this,"Record sucessfully save." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                        jTextField1.requestFocus();
                    dtm.setRowCount(0);
                    loadItemsInTable();
         }
        else
        {
             javax.swing.JOptionPane.showMessageDialog(this,"Error... Record already exist." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
             jTextField1.requestFocus();
        }

  }
  public void delete()
    {
       try
        {
             int selectedRow=jTable1.getSelectedRow();
             String ac_name=""+jTable1.getValueAt(selectedRow,3);
             Utility.makeConnection();
             String qry1="delete * from ac_master where ac_name='"+ac_name+"'";
                int check=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure to delete '"+ac_name+"' record from the table?" ,"Confirm Window",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
                if(check==javax.swing.JOptionPane.YES_OPTION)
                {
                    Utility.saveInformation(qry1);
                    loadItemsInTable();
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jComboBox1.setSelectedItem("Customer");
                    jComboBox2.setSelectedItem("Polish");
                    jTextField1.requestFocus();
                 }
                if(check==javax.swing.JOptionPane.NO_OPTION)
                {
                    jTextField1.requestFocus();
                }
        }
        catch(Exception ex)
        {
                    javax.swing.JOptionPane.showMessageDialog(this,"Please select record from the table." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    jComboBox1.setSelectedItem("Customer");
                    jComboBox2.setSelectedItem("Polish");

        }
    }

     public void loadItemsInTable()
    {
      if((jTable1.getRowCount())>(-1))
      {
       dtm.setRowCount(0);
       String qry="select ac_group_code,ac_category_code,ac_name,ac_address,ac_contact,ac_email from ac_master where ac_code>10 order by ac_name";
       String[][] data=Utility.getInformationDD(qry,6);
       int length= data.length;
       String arr[]=new String[7];
       int c=1;
       for(int i=0;i<length;i++)
       {   arr[0]=""+c;
           c++;
           int groupCode=Integer.parseInt(data[i][0]);
           String qry1="select ac_group_name from ac_group where ac_group_code="+groupCode+"";
           arr[1]=""+Utility.getSingleValue(qry1);
           int categoryCode=Integer.parseInt(data[i][1]);
           qry1="select ac_category_name from ac_category where ac_category_code="+categoryCode+"";
           arr[2]=""+Utility.getSingleValue(qry1);
           arr[3]=data[i][2];
           arr[4]=data[i][3];
           arr[5]=data[i][4];
           arr[6]=data[i][5];
           dtm.addRow(arr);
       }
      }
      }
     public void update()
     {
        int flag=0;
        Utility.makeConnection();
        if(jTable1.getSelectedRow()!=(-1))
        {
            int selectedRow=jTable1.getSelectedRow();
            String acName=(""+jTable1.getValueAt(selectedRow,3)).toUpperCase();
            String qry1="select ac_code from ac_master where ac_name='"+acName+"'";
            int acCode=Integer.parseInt(""+Utility.getSingleValue(qry1));
            if((jTextField1.getText()).isEmpty())
            {
               javax.swing.JOptionPane.showMessageDialog(this,"Account name does not blank." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
               jTextField1.requestFocus();
            }
            else
            {         //to restrict duplicate entry start
                    String acGroup=""+jComboBox1.getSelectedItem();
                    qry1="select ac_group_code from ac_group where ac_group_name='"+acGroup+"'";
                    int groupCode=Integer.parseInt(""+Utility.getSingleValue(qry1));

                    String acCategory=""+jComboBox2.getSelectedItem();
                    qry1="select ac_category_code from ac_category where ac_category_name='"+acCategory+"'";
                    int categoryCode=Integer.parseInt(""+Utility.getSingleValue(qry1));
                    //int acCode=setAccountCode();
                    if(acName.equals((jTextField1.getText()).toUpperCase()))
                    {
                          int check=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure to update record ?" ,"Confirm Window",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
                          if(check==javax.swing.JOptionPane.YES_OPTION)
                          {           String qry="update ac_master set ac_group_code="+groupCode+",ac_category_code="+categoryCode+",ac_address='"+(jTextField2.getText())+"',ac_contact='"+(jTextField3.getText())+"',ac_email='"+(jTextField4.getText())+"' where ac_code="+acCode+"";
                                      Utility.saveInformation(qry);
                                      jTextField1.requestFocus();
                                      loadItemsInTable();
                          }
                    }
                    else
                    {
                             qry1="select ac_name from ac_master";
                             String data[][]=Utility.getInformationDD(qry1,1);
                             int length=data.length;
                             for(int i=0;i<length;i++)
                             {
                                 if((data[i][0]).equals((jTextField1.getText()).toUpperCase()))
                                 {
                                  flag=1;
                                 }
                                 
                             }
                             if(flag==0)
                             {
                                         int check=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure to update record ?" ,"Confirm Window",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
                                         if(check==javax.swing.JOptionPane.YES_OPTION)
                                        qry1="update ac_master set ac_group_code="+groupCode+",ac_category_code="+categoryCode+",ac_name='"+(jTextField1.getText().toUpperCase())+"',ac_address='"+(jTextField2.getText())+"',ac_contact='"+(jTextField3.getText())+"',ac_email='"+(jTextField4.getText())+"' where ac_code="+acCode+"";
                                         Utility.saveInformation(qry1);
                                         jTextField1.requestFocus();
                                         loadItemsInTable();
                             }
                             else
                             {
                                        javax.swing.JOptionPane.showMessageDialog(this,"Error.... Name already exist." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);

                                 }
                    }
            }
         }
        else
        {
               javax.swing.JOptionPane.showMessageDialog(this,"Please select record from the table. " ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
               jTextField1.requestFocus();
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

        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Accounts");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Customer Details");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 270, 120, 20);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 290, 610, 340);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(390, 140, 190, 25);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(140, 140, 150, 25);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(140, 100, 440, 25);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(140, 60, 440, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Email ID");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(300, 140, 100, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Contact Number");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 140, 100, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Address");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 100, 90, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("A/C Category");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(300, 20, 90, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("A/C Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 60, 110, 20);

        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(390, 20, 190, 25);

        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(140, 20, 150, 25);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("A/C Group");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 20, 100, 20);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.gif"))); // NOI18N
        jButton4.setMnemonic('c');
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
        jPanel1.add(jButton4);
        jButton4.setBounds(450, 200, 130, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/savefile.gif"))); // NOI18N
        jButton1.setMnemonic('a');
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
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 200, 130, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.gif"))); // NOI18N
        jButton3.setMnemonic('d');
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
        jPanel1.add(jButton3);
        jButton3.setBounds(310, 200, 130, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.gif"))); // NOI18N
        jButton2.setMnemonic('u');
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
        jPanel1.add(jButton2);
        jButton2.setBounds(170, 200, 130, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 610, 250);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeskTopTextureEdit11.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 640, 660);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10)
        {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10)
        {
            jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10)
        {
           jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10)
        {
            jButton1.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       save();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
             save();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {

            this.dispose();
        }
   
    }//GEN-LAST:event_jButton4KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int selectedRow=jTable1.getSelectedRow();
        jComboBox1.setSelectedItem(""+jTable1.getValueAt(selectedRow,1));
        jComboBox2.setSelectedItem(""+jTable1.getValueAt(selectedRow,2));
        jTextField1.setText(""+jTable1.getValueAt(selectedRow,3));
        jTextField2.setText(""+jTable1.getValueAt(selectedRow,4));
        jTextField3.setText(""+jTable1.getValueAt(selectedRow,5));
        jTextField4.setText(""+jTable1.getValueAt(selectedRow,6));
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       delete();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
      if(evt.getKeyCode()==10)
        {

                delete();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
             update();
        }
        
    }//GEN-LAST:event_jButton2KeyPressed

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
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
