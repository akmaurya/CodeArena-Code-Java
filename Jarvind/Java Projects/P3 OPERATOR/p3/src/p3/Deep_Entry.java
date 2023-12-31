/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Deep_Entry.java
 *
 * Created on Jun 11, 2014, 4:59:49 PM
 */

package p3;
import javax.swing.text.MaskFormatter;
/**
 *
 * @author welcome
 */
public class Deep_Entry extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm;
static int i=0;

    /** Creates new form Deep_Entry */
    public Deep_Entry(String uid,String cnm,String fyear) {
        initComponents();

        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);


        String heading[]={"S.No.","Date","Entry No.","Received Qty","Deep in cm","Current Tank Qty","Pseudo No."};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
        jTable1.setModel(dtm);

        javax.swing.table.TableColumn column;


        column=jTable1.getColumn("S.No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(45);
        column=jTable1.getColumn("Date");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Entry No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Received Qty");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(110);
        column=jTable1.getColumn("Deep in cm");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Current Tank Qty");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(150);
        column=jTable1.getColumn("Pseudo No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(100);

        jComboBox1.removeAllItems();
        jComboBox1.addItem(1);

        java.util.Date dt=new java.util.Date();
        int date=dt.getDate();
        int month=dt.getMonth()+1;
        int year=dt.getYear()+1900;
        int hour=dt.getHours();
        int min=dt.getMinutes();
        int sec=dt.getSeconds();
        String setdate=date+"-"+month+"-"+year;
        String d=""+date,m=""+month;
        if(d.length()==1)
            d="0"+d;
        if(m.length()==1)
            m="0"+m;
        setdate=d+"-"+m+"-"+year;
        System.out.println(setdate);
        jFormattedTextField1.setText(setdate);

        loadJTable();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        MaskFormatter mask1=null;
        try{
            mask1=new MaskFormatter("##-##-####");
            mask1.setPlaceholderCharacter('_');
        }
        catch(Exception ae)
        {
            System.out.println("error in setting jFormating textField");
        }
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Deep Entry Window");

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(219, 219, 186));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true), javax.swing.BorderFactory.createTitledBorder("")));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(219, 219, 186));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13));
        jLabel1.setText("Date");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(14, 14, 70, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13));
        jLabel2.setText("Entry No.");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(230, 10, 70, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 13));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(300, 10, 70, 30);

        jButton2.setMnemonic('n');
        jButton2.setText("New");
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
        jButton2.setBounds(370, 10, 70, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton3.setText("<<");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(730, 10, 60, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton4.setText(">>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(790, 10, 60, 30);

        jFormattedTextField1 = new javax.swing.JFormattedTextField(mask1);
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyPressed(evt);
            }
        });
        jPanel3.add(jFormattedTextField1);
        jFormattedTextField1.setBounds(60, 10, 110, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/calendar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(170, 10, 30, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(20, 20, 860, 50);

        jPanel4.setBackground(new java.awt.Color(219, 219, 186));
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), javax.swing.BorderFactory.createTitledBorder("")));
        jPanel4.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Received Qty.");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(20, 20, 110, 30);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel4.add(jTextField2);
        jTextField2.setBounds(190, 20, 230, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Deep in cm.");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(20, 70, 120, 30);

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        jPanel4.add(jTextField3);
        jTextField3.setBounds(190, 70, 230, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Current Tank Qty.");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(20, 120, 120, 20);

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        jPanel4.add(jTextField4);
        jTextField4.setBounds(190, 120, 230, 30);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/savefile.gif"))); // NOI18N
        jButton5.setMnemonic('s');
        jButton5.setText("Save");
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
        jPanel4.add(jButton5);
        jButton5.setBounds(10, 230, 110, 30);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/dustbeen.gif"))); // NOI18N
        jButton6.setMnemonic('d');
        jButton6.setText("Delete");
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
        jPanel4.add(jButton6);
        jButton6.setBounds(120, 230, 110, 30);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/refresh.gif"))); // NOI18N
        jButton7.setMnemonic('c');
        jButton7.setText("Clear");
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
        jPanel4.add(jButton7);
        jButton7.setBounds(230, 230, 100, 30);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/Close1.gif"))); // NOI18N
        jButton8.setMnemonic('x');
        jButton8.setText("Close");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8);
        jButton8.setBounds(330, 230, 100, 30);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(20, 70, 440, 280);

        jPanel5.setBackground(new java.awt.Color(219, 219, 186));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setLayout(new java.awt.BorderLayout());

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

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(460, 70, 420, 280);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 900, 370);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Cal c=new Cal();
        jFormattedTextField1.setText(c.getdate());
        dtm.setRowCount(0);
        loadJTable();
}//GEN-LAST:event_jButton1ActionPerformed

    private void jFormattedTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox1.requestFocus();
            dtm.setRowCount(0);
            loadJTable();
        }
    }//GEN-LAST:event_jFormattedTextField1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

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
            jButton5.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            save();
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        incrementByOne();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            incrementByOne();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        clearWindow();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton7KeyPressed
        // TODO add your handling code here:
        clearWindow();
    }//GEN-LAST:event_jButton7KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
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
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
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
    }//GEN-LAST:event_jButton6KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i=jTable1.getSelectedRow();

        jFormattedTextField1.setText(jTable1.getValueAt(i, 1).toString());
        jComboBox1.setSelectedItem(jTable1.getValueAt(i, 2).toString());
        jTextField2.setText(jTable1.getValueAt(i, 3).toString());
        jTextField3.setText(jTable1.getValueAt(i, 4).toString());
        jTextField4.setText(jTable1.getValueAt(i, 5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        previousRecord();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        nextRecord();
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
public boolean save()
{
    try
    {
        if(jFormattedTextField1.getText().isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter the date.");
            jFormattedTextField1.requestFocus();
            return false;
        }
        if(jTextField2.getText().isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter received qty.");
            jTextField2.requestFocus();
            return false;
        }
        if(jTextField3.getText().isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter deep in centimeter.");
            jTextField3.requestFocus();
            return false;
        }
        if(jTextField4.getText().isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter curent tank qty.");
            jTextField4.requestFocus();
            return false;
        }

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

        if(object1.isDouble(jTextField2.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter received qty in number format.");
            jTextField2.requestFocus();
            return false;
        }
        if(object1.isDouble(jTextField3.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter deep in centimeter in number format.");
            jTextField3.requestFocus();
            return false;
        }
        if(object1.isDouble(jTextField4.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter curent tank qty in number format.");
            jTextField4.requestFocus();
            return false;
        }

        int sno=0;
        String q="select max(sno) from deep_entry";
        String sn=object1.getSigetngleValue(q, Main.year);
        if(sn==null || sn.isEmpty())
        {
            sn="0";
        }

        String str=jFormattedTextField1.getText().trim();
        String date[]=str.split("-");

       
        sno=Integer.parseInt(sn)+1;
        System.out.println("sno="+sno);
        String qry="insert into deep_entry values ("+sno+",'"+(date[2]+"-"+date[1]+"-"+date[0])+"',"+Integer.parseInt(jComboBox1.getSelectedItem().toString())+","+Double.valueOf(jTextField2.getText().trim())+","+Double.valueOf(jTextField3.getText().trim())+","+Double.valueOf(jTextField4.getText().trim())+")";
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
    return true;
}

public void clearWindow()
{
    jComboBox1.setSelectedIndex(0);
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    java.util.Date dt=new java.util.Date();
    int date=dt.getDate();
    int month=dt.getMonth()+1;
    int year=dt.getYear()+1900;
    int hour=dt.getHours();
    int min=dt.getMinutes();
    int sec=dt.getSeconds();
    String setdate=date+"-"+month+"-"+year;
    String d=""+date,m=""+month;
    if(d.length()==1)
       d="0"+d;
    if(m.length()==1)
       m="0"+m;
    setdate=d+"-"+m+"-"+year;
    System.out.println(setdate);
    jFormattedTextField1.setText(setdate);
    jFormattedTextField1.requestFocus();
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

        String str=jFormattedTextField1.getText().trim();
        String date[]=str.split("-");
        str=date[2]+"-"+date[1]+"-"+date[0];
        
        String qry="select * from deep_entry where Date='"+str+"'";
        String arr[][]=object1.getInformationDD(qry, 6, Main.year);

        String arr1[]=new String[7];

        for(int i=0;i<arr.length;i++)
        {
            arr1[0]=""+(i+1);

            String str2=""+arr[i][1];
            String arr2[]=str2.split("-");
            arr1[1]=arr2[2]+"-"+arr2[1]+"-"+arr2[0];
            
            arr1[2]=""+arr[i][2];
            arr1[3]=""+arr[i][3];
            arr1[4]=""+arr[i][4];
            arr1[5]=""+arr[i][5];
            arr1[6]=""+arr[i][0];
            dtm.addRow(arr1);
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method "+e);
    }
}

public void incrementByOne()
{
    int j=Integer.parseInt(""+jComboBox1.getItemCount());
    jComboBox1.addItem(""+(j+1));
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

            int i=jTable1.getSelectedRow();
            String pseudo_no=(""+jTable1.getValueAt(i, 6));

            int pseudo=Integer.parseInt(pseudo_no);

            String qry="delete from deep_entry where sno="+pseudo+"";
            boolean bn=object1.saveInformation(qry, Main.year);

            if(bn==true)
            {
                dtm.setRowCount(0);
                loadJTable();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error ! In loadInitialInfo Method "+e);
        }
    }

public void previousRecord()
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

        String qry="select distinct Date from deep_entry order by Date";
        System.out.println(""+qry);
        String arr[]=object1.getResultSetAs_1D_Array(qry, Main.year);

        String str=jFormattedTextField1.getText().trim();
        String date[]=str.split("-");
        str=date[2]+"-"+date[1]+"-"+date[0];

        for(int z=0;z<arr.length;z++)
        {
            if(arr[z].equals(""+str)==true)
            {
                i=z;
                break;
            }
        }

        if(i==0)
        {
            jButton3.setEnabled(false);
        }

        else
        {
            String str2=arr[--i];
            String date2[]=str2.split("-");
            jFormattedTextField1.setText(date2[2]+"-"+date2[1]+"-"+date2[0]);
            dtm.setRowCount(0);
            loadJTable();
            jButton4.setEnabled(true);
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method "+e);
    }
}

public void nextRecord()
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

        String qry="select distinct Date from deep_entry order by Date";
        System.out.println(""+qry);
        String arr[]=object1.getResultSetAs_1D_Array(qry, Main.year);

        String str=jFormattedTextField1.getText().trim();
        String date[]=str.split("-");
        str=date[2]+"-"+date[1]+"-"+date[0];

        for(int z=0;z<arr.length;z++)
        {
            if(arr[z].equals(""+str)==true)
            {
                i=z;
                break;
            }
        }

        if(i==(arr.length)-1)
        {
            jButton4.setEnabled(false);
        }

        else
        {
            String str2=arr[++i];
            String date2[]=str2.split("-");
            jFormattedTextField1.setText(date2[2]+"-"+date2[1]+"-"+date2[0]);
            dtm.setRowCount(0);
            loadJTable();
            jButton3.setEnabled(true);
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method "+e);
    }
}
}