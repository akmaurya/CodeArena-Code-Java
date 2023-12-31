/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Create_Sale_Party.java
 *
 * Created on Nov 20, 2012, 1:10:57 PM
 */

package tagada;

import java.awt.Color;


/**
 *
 * @author user2
 */
public class Create_Sale_Party extends javax.swing.JInternalFrame {
    Color cl1=new Color(232,232,164);
    Color cl3=new Color(255,255,204);

    /** Creates new form Create_Sale_Party */
    public Create_Sale_Party() {
        initComponents();
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        dtm=new javax.swing.table.DefaultTableModel();

        javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        javax.swing.table.TableColumn column;
        String heading1[]={"S.No.","Party Name","Address","Contact No.","Area Name"};
        dtm=new javax.swing.table.DefaultTableModel(heading1,0);
        jTable1.setModel(dtm);

        column=jTable1.getColumn("S.No.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(56);
        column=jTable1.getColumn("Party Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(170);
        column=jTable1.getColumn("Address");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(200);
        column=jTable1.getColumn("Contact No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(150);
        column=jTable1.getColumn("Area Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(150);

        loadInitialInfo();
        uploadDetail();
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
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(tagada.TagadaApp.class).getContext().getResourceMap(Create_Sale_Party.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setClosable(true);
        setIconifiable(true);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 10, 200, 30);

        jTextField1.setFont(resourceMap.getFont("jTextField1.font")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(240, 10, 480, 30);

        jLabel2.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 90, 130, 30);

        jComboBox1.setFont(resourceMap.getFont("jTextField1.font")); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.setName("jComboBox1"); // NOI18N
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jComboBox1FocusLost(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(240, 90, 320, 30);

        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setName("jButton1"); // NOI18N
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
        jButton1.setBounds(580, 90, 140, 30);

        jLabel3.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 50, 100, 30);

        jTextField2.setFont(resourceMap.getFont("jTextField1.font")); // NOI18N
        jTextField2.setName("jTextField2"); // NOI18N
        jTextField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField2FocusLost(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(240, 50, 220, 30);

        jLabel4.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(480, 50, 100, 30);

        jTextField3.setFont(resourceMap.getFont("jTextField1.font")); // NOI18N
        jTextField3.setName("jTextField3"); // NOI18N
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(580, 50, 140, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 750, 130);

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(null);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setBackground(resourceMap.getColor("jTable1.background")); // NOI18N
        jTable1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
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
        jTable1.setName("jTable1"); // NOI18N
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTable1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 0, 730, 380);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 210, 750, 390);

        jButton2.setBackground(resourceMap.getColor("jButton2.background")); // NOI18N
        jButton2.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton2FocusLost(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(610, 160, 150, 35);

        jButton3.setBackground(resourceMap.getColor("jButton3.background")); // NOI18N
        jButton3.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setName("jButton3"); // NOI18N
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
        getContentPane().add(jButton3);
        jButton3.setBounds(250, 160, 150, 35);

        jButton4.setBackground(resourceMap.getColor("jButton4.background")); // NOI18N
        jButton4.setFont(resourceMap.getFont("jButton4.font")); // NOI18N
        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setName("jButton4"); // NOI18N
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
        getContentPane().add(jButton4);
        jButton4.setBounds(430, 160, 150, 35);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jTextField2.requestFocus();
        }
}//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBox1FocusGained

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        // TODO add your handling code here:
}//GEN-LAST:event_jComboBox1FocusLost

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jButton3.requestFocus();
        }
}//GEN-LAST:event_jComboBox1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Save();
}//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusGained
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField2FocusGained

    private void jTextField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField2FocusLost
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField2FocusLost

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jTextField3.requestFocus();
        }
}//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField3FocusGained

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField3FocusLost

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jComboBox1.requestFocus();
        }
}//GEN-LAST:event_jTextField3KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        CreateArea ca=new CreateArea();
        ca.reshape(150, 10, 785, 645);
        TagadaView.jDesktopPane1.add(ca);
        ca.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            Save();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            this.dispose();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            CreateArea ca=new CreateArea();
            ca.reshape(300, 10, 410, 660);
            TagadaView.jDesktopPane1.add(ca);
            ca.setVisible(true);
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusGained
        // TODO add your handling code here:
        jButton3.setBackground(cl1);
    }//GEN-LAST:event_jButton3FocusGained

    private void jButton3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton3FocusLost
        // TODO add your handling code here:
        jButton3.setBackground(cl3);
    }//GEN-LAST:event_jButton3FocusLost

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        // TODO add your handling code here:
        jButton2.setBackground(cl1);
    }//GEN-LAST:event_jButton2FocusGained

    private void jButton2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusLost
        // TODO add your handling code here:
        jButton2.setBackground(cl3);
    }//GEN-LAST:event_jButton2FocusLost

    private void jTable1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusGained
        // TODO add your handling code here:
        jTable1.setBackground(cl3);
    }//GEN-LAST:event_jTable1FocusGained

    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
        // TODO add your handling code here:
        jTable1.setBackground(cl1);
    }//GEN-LAST:event_jTable1FocusLost

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_DELETE)
        {
            deleteSaleParty();
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        setSaleParty();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        updateSale();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4FocusGained

    private void jButton4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4FocusLost

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            updateSale();
        }
    }//GEN-LAST:event_jButton4KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
javax.swing.table.DefaultTableModel dtm;
    private void loadInitialInfo()
{
    String qry="";
    try
    {
       qry="Select area_name from area_Master order by route_nm";
       String load[][]=Utility.getInformationDD(qry,1);
       if(load.length>0)
       {
           jComboBox1.removeAllItems();
           jComboBox1.addItem("NA");
           for(int i=0;i<load.length;i++)
           {
               jComboBox1.addItem(load[i][0]);
           }
       }

       String arr[]=null;
       qry="Select * from sale_Party_Master order by party_name";
       load=Utility.getInformationDD(qry, 4);
       if(load.length>0)
       {
           arr=new String[5];
           for(int i=0;i<load.length;i++)
           {
                arr[0]=""+(dtm.getRowCount()+1)+".";
                arr[1]=load[i][1];
                arr[2]=load[i][2];
                arr[3]=load[i][3];
                arr[4]=load[i][4];
                dtm.addRow(arr);
           }
       }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method."+e);
    }
 }
boolean Save()
{
    String qry="";
    try
    {
        if(Utility.isBlank(jTextField1.getText().trim())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Please enter a Party Name.");
            jTextField1.requestFocus();
            return false;
        }

        if(Utility.isBlank(jTextField2.getText().trim())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Please enter an Address.");
            jTextField2.requestFocus();
            return false;
        }

        if(Utility.isBlank(jTextField3.getText().trim())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Please enter a Contact No.");
            jTextField3.requestFocus();
            return false;
        }

        qry="select party_name from  sale_Party_Master where party_name='"+jTextField1.getText().trim()+"'";
        String getName=Utility.getSingleValue(qry);
        if(getName.length()>0)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Sorry! This Party Name already exists.");
            jTextField1.selectAll();
            jTextField1.requestFocus();
            return false;
        }
        else
        {
            String arr[]=new String[5];
            qry="insert into sale_Party_Master values('"+jTextField1.getText().trim()+"','"+jTextField2.getText().trim()+"','"+jTextField3.getText().trim()+"','"+(jComboBox1.getSelectedItem().toString())+"')";
            boolean bn=Utility.saveInformation(qry);
            qry="insert into party_Account values('"+jTextField1.getText().trim()+"',0,0)";
            bn=Utility.saveInformation(qry);
            if(bn)
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Process Completed.");
                uploadDetail();
                
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jComboBox1.setSelectedIndex(0);
                jTextField1.requestFocus();
            }
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In Save Method."+e);
    }
    return true;
}

private void uploadDetail()
{
    String qry="";
    dtm.setRowCount(0);
    try
    {
        qry="Select * from sale_Party_Master order by party_name asc";
        String load[][]=Utility.getInformationDD(qry, 4);
        String arr[]=null;

        if(load.length>0)
        {
            arr=new String[5];
            for(int i=0;i<load.length;i++)
            {
                arr[0]=""+(dtm.getRowCount()+1)+".";
                arr[1]=load[i][0];
                arr[2]=load[i][1];
                arr[3]=load[i][2];
                arr[4]=load[i][3];
                dtm.addRow(arr);
            }
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In uploadDetail Method."+e);
    }
}

private void deleteSaleParty()
{
    String qry="";

    try
    {
        if(jTable1.getSelectedRowCount()<1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please! Select a Party Name.");
        }

        else if(dtm.getRowCount() > 0)
        {
            int c=javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this Party Name?", "Delete Party Name", javax.swing.JOptionPane.YES_NO_OPTION);
            if(c==javax.swing.JOptionPane.YES_OPTION)
            {
                qry="delete * from sale_Party_Master where party_name='"+jTable1.getValueAt(jTable1.getSelectedRow(), 1)+"'";
                Utility.saveInformation(qry);
                javax.swing.JOptionPane.showMessageDialog(this, "Party Name Deleted Successfully.");
                dtm.removeRow(jTable1.getSelectedRow());

                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jComboBox1.setSelectedItem(jTable1.getValueAt(jTable1.getSelectedRow(), 4));
                jTextField1.requestFocus();
            }
        }
    }

    catch(Exception ae)
    {
        System.out.println(ae);
    }
}

private void setSaleParty()
{
    int i=jTable1.getSelectedRow();
    jTextField1.setText(""+jTable1.getValueAt(i, 1));
    jTextField2.setText(""+jTable1.getValueAt(i, 2));
    jTextField3.setText(""+jTable1.getValueAt(i, 3));
    jComboBox1.setSelectedItem(""+jTable1.getValueAt(i, 4));
}

private void updateSale()
{
    String qry="";

    if(jTable1.getSelectedRowCount()<1)
    {
        javax.swing.JOptionPane.showMessageDialog(this, "Record is not selected.");
    }

    else if(dtm.getRowCount() > 0)
    {
        if(jTextField1.getText().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter the Party Name.");
            jTextField1.requestFocus();
        }


        if(jTextField2.getText().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter the Address.");
            jTextField2.requestFocus();
        }

        if(jTextField3.getText().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter the Phone Number.");
            jTextField3.requestFocus();
        }

        if(jComboBox1.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select an Area Name.");
            jComboBox1.requestFocus();
        }

        qry="select party_name from sale_Party_Master where party_name='"+(jTextField1.getText())+"'";
        String str=Utility.getSingleValue(qry);

        if(str.length()>0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Party Name already exists! Please enter another Party Name.");
            jTextField1.requestFocus();
        }
        else
        {
            int c=javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to update this Sale Party?", "Update Sale Party", javax.swing.JOptionPane.YES_NO_OPTION);
            if(c==javax.swing.JOptionPane.YES_OPTION)
            {
                qry="update sale_Party_Master set party_name='"+jTextField1.getText().trim()+"', address='"+jTextField2.getText().trim()+"', phone='"+jTextField3.getText().trim()+"', area_name='"+jComboBox1.getSelectedItem().toString()+"' where party_name='"+(""+jTable1.getValueAt(jTable1.getSelectedRow(), 1))+"'";
                Utility.saveInformation(qry);

                dtm.setRowCount(0);
                uploadDetail();

                javax.swing.JOptionPane.showMessageDialog(this, "Sale Party Updated Successfully.");
            }
        }
    }
}
}
