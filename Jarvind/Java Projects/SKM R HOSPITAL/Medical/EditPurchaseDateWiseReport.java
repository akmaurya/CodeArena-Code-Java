/*
 * ListOfPurchaseing.java
 *
 * Created on May 15, 2010, 10:18 PM
 */

//package medretail;
import java.rmi.*;
/**
 *
 * @author  Deep Pal
 */
public class EditPurchaseDateWiseReport extends javax.swing.JInternalFrame {
    
    /** Creates new form ListOfPurchaseing */
    public EditPurchaseDateWiseReport(javax.swing.JDesktopPane jDesktopPane1) {
        initComponents();

        this.jDesktopPane1=jDesktopPane1;
        java.awt.Cursor cursor;
        cursor = new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR);
        
        jButton1.setCursor(cursor);
        jButton2.setCursor(cursor);
        jButton3.setCursor(cursor);
        jButton4.setCursor(cursor);
        jTable1.setCursor(cursor);

        vc=new java.util.Vector();
        
        String heading[]={"S.No.","EditNo.","eDate","eTime","Party Name","Address","Book No.","Serial No.","Total Items","Net Amt."};
        dtm1=new javax.swing.table.DefaultTableModel(heading,0);
        jTable1.setModel(dtm1);
                javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
      		javax.swing.table.TableColumn column;

      		column=jTable1.getColumn("S.No.");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(30);
                
                column=jTable1.getColumn("EditNo.");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(80);
                
                column=jTable1.getColumn("eDate");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(150);
                
                column=jTable1.getColumn("eTime");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(150);
                
      		column=jTable1.getColumn("Party Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);

      		column=jTable1.getColumn("Address");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(150);
                
      		column=jTable1.getColumn("Book No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);
                
                column=jTable1.getColumn("Serial No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

                column=jTable1.getColumn("Total Items");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(60);

                column=jTable1.getColumn("Net Amt.");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(80);
                
                java.util.Date dt=new java.util.Date();
        jTextField1.setText(dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
        jTextField2.setText(dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
        selectedDate1=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);
        selectedDate2=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);

        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        reshape(((dm.width-800)/2)-75,(dm.height-450)/2,800,380);
        jDesktopPane1.add(this);
        setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Purchase Report - Date Wise");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton3.setMnemonic('c');
        jButton3.setText("Close");
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
        jButton3.setBounds(660, 13, 110, 30);

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 750, 250);

        jLabel4.setBackground(new java.awt.Color(204, 255, 204));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(660, 320, 110, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel2.setText("Total Purchase Amount (In. Rs.)");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(450, 320, 200, 20);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel1.setText("Select date ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 70, 20);

        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jCheckBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCheckBox1KeyPressed(evt);
            }
        });

        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(80, 20, 20, 20);

        jTextField1.setBackground(new java.awt.Color(232, 232, 169));
        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jTextField1.setForeground(new java.awt.Color(0, 51, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(100, 20, 90, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton1.setMnemonic('d');
        jButton1.setToolTipText("Click here to select reporting date");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        jButton1.setBounds(200, 20, 20, 20);

        jLabel5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabel5.setText("to");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 20, 20, 14);

        jTextField2.setBackground(new java.awt.Color(232, 232, 169));
        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jTextField2.setForeground(new java.awt.Color(0, 51, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(250, 20, 90, 20);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton5.setMnemonic('d');
        jButton5.setToolTipText("Click here to select reporting date");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        getContentPane().add(jButton5);
        jButton5.setBounds(350, 20, 20, 20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.gif")));
        jButton2.setMnemonic('s');
        jButton2.setText("Show");
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
        jButton2.setBounds(380, 13, 130, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.gif")));
        jButton4.setMnemonic('n');
        jButton4.setText("Next >>");
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
        jButton4.setBounds(520, 13, 130, 30);

        jInternalFrame1.getContentPane().setLayout(null);

        jInternalFrame1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jInternalFrame1.setClosable(true);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setTitle("Purchase Report - Date Wise");
        jInternalFrame1.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                jInternalFrame1InternalFrameOpened(evt);
            }
        });

        jButton6.setMnemonic('c');
        jButton6.setText("Close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton6KeyPressed(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jButton6);
        jButton6.setBounds(680, 20, 90, 23);

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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(jTable2);

        jInternalFrame1.getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 60, 750, 250);

        jLabel6.setBackground(new java.awt.Color(204, 255, 204));
        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setOpaque(true);
        jInternalFrame1.getContentPane().add(jLabel6);
        jLabel6.setBounds(660, 320, 110, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel3.setText("Total Purchase Amount (In. Rs.)");
        jInternalFrame1.getContentPane().add(jLabel3);
        jLabel3.setBounds(450, 320, 200, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel7.setText("Select date ");
        jInternalFrame1.getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 20, 70, 20);

        jCheckBox2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox2.setMargin(new java.awt.Insets(0, 0, 0, 0));
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

        jInternalFrame1.getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(80, 20, 20, 20);

        jTextField3.setBackground(new java.awt.Color(232, 232, 169));
        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jTextField3.setForeground(new java.awt.Color(0, 51, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jInternalFrame1.getContentPane().add(jTextField3);
        jTextField3.setBounds(100, 20, 90, 20);

        jButton7.setIcon(new javax.swing.ImageIcon("D:\\MedicalRetail\\MedRetail\\images\\dateimg.jpg"));
        jButton7.setMnemonic('d');
        jButton7.setToolTipText("Click here to select reporting date");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton7KeyPressed(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jButton7);
        jButton7.setBounds(200, 20, 20, 20);

        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabel8.setText("to");
        jInternalFrame1.getContentPane().add(jLabel8);
        jLabel8.setBounds(230, 20, 20, 14);

        jTextField4.setBackground(new java.awt.Color(232, 232, 169));
        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jTextField4.setForeground(new java.awt.Color(0, 51, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jInternalFrame1.getContentPane().add(jTextField4);
        jTextField4.setBounds(250, 20, 90, 20);

        jButton8.setIcon(new javax.swing.ImageIcon("D:\\MedicalRetail\\MedRetail\\images\\dateimg.jpg"));
        jButton8.setMnemonic('d');
        jButton8.setToolTipText("Click here to select reporting date");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton8KeyPressed(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jButton8);
        jButton8.setBounds(350, 20, 20, 20);

        jButton9.setMnemonic('s');
        jButton9.setText("Show");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton9KeyPressed(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jButton9);
        jButton9.setBounds(390, 20, 160, 23);

        jButton10.setMnemonic('n');
        jButton10.setText("Next >>");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jButton10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton10KeyPressed(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jButton10);
        jButton10.setBounds(570, 20, 80, 23);

        getContentPane().add(jInternalFrame1);
        jInternalFrame1.setBounds(0, 0, 97, 32);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
// TODO add your handling code here:
         jCheckBox1.setSelected(false);
        jTextField1.setEnabled(false);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_formInternalFrameOpened

    private void jInternalFrame1InternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrame1InternalFrameOpened
// TODO add your handling code here:
       
    }//GEN-LAST:event_jInternalFrame1InternalFrameOpened

    private void jButton10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton10KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton10KeyPressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton9KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton9KeyPressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton8KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton8KeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton7KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton7KeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jCheckBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox2KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2KeyPressed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            callNextScrean();
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        callNextScrean();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            setDataInTable();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        setDataInTable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            Cal X=new Cal();
            jTextField2.setText(X.getdate());
            selectedDate2=X.getmonth()+"/"+X.getday()+"/"+X.getyear();
        }
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        Cal X=new Cal();
        jTextField2.setText(X.getdate());
        selectedDate2=X.getmonth()+"/"+X.getday()+"/"+X.getyear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            Cal X=new Cal();
            jTextField1.setText(X.getdate());
            selectedDate1=X.getmonth()+"/"+X.getday()+"/"+X.getyear();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        Cal X=new Cal();
        jTextField1.setText(X.getdate());
        selectedDate1=X.getmonth()+"/"+X.getday()+"/"+X.getyear();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            if(jCheckBox1.isSelected()) {
                jTextField1.setEnabled(true);
                jButton1.setEnabled(true);
            } else {
                jTextField1.setEnabled(false);
                jButton1.setEnabled(false);
            }
        }
    }//GEN-LAST:event_jCheckBox1KeyPressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
// TODO add your handling code here:
        if(jCheckBox1.isSelected()) {
            jTextField1.setEnabled(true);
            jButton1.setEnabled(true);
        } else {
            jTextField1.setEnabled(false);
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
                    this.dispose();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
// TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
                    callNextScrean();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
    
   private void setDataInTable()
    {
        try {
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs=null;*/
            ZedInterface inf=null;
ZedInterfaceForMedical uc=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
            int flag=0;
            //utilityClass uc=new utilityClass();
            
            while(dtm1.getRowCount()>0)     dtm1.removeRow(0);
            double temp=0,tNetAmt=0;
            vc.removeAllElements();
            String rs[][]=null;
            String query="select partyNm,partyAds,bookNo,srNo,totalitems,netAmt,editNo from purchaseSmryEdit";
            System.out.println("1.........");
            if(jCheckBox1.isSelected())
            {
		System.out.println("2.........");
		query+=" where entryDt>=#"+selectedDate1+"# and entryDt<=#"+selectedDate2+"# order by entryDt,editNo";
                System.out.println("Query="+query);
		rs=inf.getResultSetAs_2D_Array(query,7);
				}
            if(!jCheckBox1.isSelected())
            {
		System.out.println("3.........");
		query+=" where entryDt<=#"+selectedDate2+"# order by entryDt,editNo";
                System.out.println("Query="+query);
		rs=inf.getResultSetAs_2D_Array(query,7);
            }
            if(rs!=null)
            for(int i=0;i<rs.length;i++) {
                flag=1;
                String arr[]=new String[10];
                arr[0]=""+(dtm1.getRowCount()+1)+". ";
                arr[4]=rs[i][0];
                arr[5]=rs[i][1];
                arr[6]=rs[i][2];
                arr[7]=rs[i][3];
                arr[8]=rs[i][4];
                
                temp=Double.valueOf(rs[i][5]);
                arr[9]=""+(new java.math.BigDecimal(temp)).setScale(2,5);
                tNetAmt+=temp;
                
                arr[1]=rs[i][6];
                String dbDate=takeDate(Integer.parseInt(arr[1]));
                //System.out.println("DBDate="+dbDate);
                //java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd/MM/yyyy");
                arr[2]=(dbDate);
                //sdf=new java.text.SimpleDateFormat("h:mm a");
                //arr[3]=(sdf.format(dbDate));
                dbDate=takeTime(Integer.parseInt(arr[1]));
                //System.out.println("DB time="+dbDate);
                
                //sdf=new java.text.SimpleDateFormat("h:mm a");
                arr[3]=(dbDate);
                //System.out.println("1......");
                dtm1.addRow(arr);
                //System.out.println("2......");
                vc.addElement(arr[1]);
                //System.out.println("3......");
            }
            jLabel4.setText(""+(new java.math.BigDecimal(tNetAmt)).setScale(2,5));
            //connection.close();
            if(flag==0) {
                javax.swing.JOptionPane.showMessageDialog(this,"Oh!\nNo purchase bill found.","Information",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jButton1.requestFocus();
            }
        } catch(Exception ex) {
            System.out.println("Error..783sss.."+ex);
        }        
    } 
   
   private String takeDate(int editNo)
    {
        String dt11=null;
        try
        {
            System.out.println("editNo="+editNo);
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=null;*/
            ZedInterface inf=null;
ZedInterfaceForMedical uc=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
            String query="select editDtTime from logFileForUpdate where editNo="+editNo+"";
            String rs=inf.getSingleValue(query);
            if(rs!=null)
            {
                //dt11=rs.getDate(1);
                //dt11=new java.util.Date();
                String dat[]=rs.split("-");
                String dd[]=dat[2].split(" ");
                String date=dd[0]+"/"+dat[1]+"/"+dat[0];
                dt11=date;
            }
        }
        catch(Exception e)
        {
            System.out.println("error in takeDate method...."+e);
        }
        return dt11;
    }
    private String takeTime(int editNo)
    {
        String dt11=null;
        try
        {
            System.out.println("editNo="+editNo);
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=null;*/
            ZedInterface inf=null;
ZedInterfaceForMedical uc=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
            String query="select editDtTime from logFileForUpdate where editNo="+editNo+"";
            String rs=inf.getSingleValue(query);
            if(rs!=null)
            {
                //dt11=rs.getDate(1);
                //dt11=new java.util.Date();
                String dat[]=rs.split("-");
                String dd[]=dat[2].split(" ");
                String date=dd[1];
                dt11=date;
            }
        }
        catch(Exception e)
        {
            System.out.println("error in takeTime method...."+e);
        }
        return dt11;
    }
   
    private void callNextScrean()
    {
        //utilityClass uc=new utilityClass();
        try
        {
        ZedInterface inf=null;
ZedInterfaceForMedical uc=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
        if(uc.isBlank(jTextField1.getText().trim()))
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect billing date.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jButton1.requestFocus();
        }
        else if(jTable1.getSelectedRow()<0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect a bill.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTable1.requestFocus();
        }
        else
        {
            int pno=Integer.parseInt(""+vc.elementAt(jTable1.getSelectedRow()));
            ShowIndividualPurchaseBill emp=new ShowIndividualPurchaseBill(jDesktopPane1,pno,"purchaseSmryEdit");
        }
        }
        catch(Exception e)
        {
        	System.out.println("Error into callNextScreen ..."+e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
    javax.swing.table.DefaultTableModel dtm1;
    String selectedDate1;
    String selectedDate2;
    java.util.Vector vc;
    javax.swing.JDesktopPane jDesktopPane1;
}