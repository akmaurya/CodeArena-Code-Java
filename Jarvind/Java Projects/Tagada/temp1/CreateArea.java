/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreateArea.java
 *
 * Created on Nov 5, 2012, 12:29:52 PM
 */

package tagada;

/**
 *
 * @author zed
 */
import java.sql.*;
public class CreateArea extends javax.swing.JInternalFrame {
public javax.swing.table.DefaultTableModel dtm;
    /** Creates new form CreateArea */
    public CreateArea() {
        initComponents();

        String heading1[]={"S.No","Area Name","Rout"};
        dtm =new javax.swing.table.DefaultTableModel(heading1,0);
        jTable1.setModel(dtm);


        try
            {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection conn=DriverManager.getConnection("jdbc:odbc:tagada");
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select * from tagadadb");
                int ind=0;
                
                while(rs.next()==true)
                {
                    String data[]=new String [4];

                    data[0]=""+(ind+1);
                    data[1]=""+rs.getString("area name");
                    data[2]=""+rs.getString("rout");
                    dtm.addRow(data);
                    jTable1.setValueAt(data[0],ind,0);
                    jTable1.setValueAt(data[1],ind,1);
                    jTable1.setValueAt(data[2],ind,2);


                    ind++;
                }
        }
             catch(Exception ae1)
             {
                String error=""+ae1;
                /*if(error.equalsIgnoreCase("errerjava.sql.SQLException: General error"));
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Area name already exists! Please enter a unique area name");

                }*/
                System.out.println("errer"+ae1);

               jTextField1.requestFocus();
               //jTextField1.setText("");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(tagada.TagadaApp.class).getContext().getResourceMap(CreateArea.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setName("Form"); // NOI18N

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(null);

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, resourceMap.getColor("jPanel2.border.highlightOuterColor"), resourceMap.getColor("jPanel2.border.highlightInnerColor"), resourceMap.getColor("jPanel2.border.shadowOuterColor"), resourceMap.getColor("jPanel2.border.shadowInnerColor"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(null);

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 20, 150, 16);

        jTextField1.setFont(resourceMap.getFont("jTextField1.font")); // NOI18N
        jTextField1.setToolTipText(resourceMap.getString("jTextField1.toolTipText")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(155, 20, 218, 22);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 50, 90, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NA" }));
        jComboBox1.setToolTipText(resourceMap.getString("jComboBox1.toolTipText")); // NOI18N
        jComboBox1.setName("jComboBox1"); // NOI18N
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(155, 50, 150, 20);

        jButton1.setIcon(resourceMap.getIcon("jButton1.icon")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setToolTipText(resourceMap.getString("jButton1.toolTipText")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jPanel2.add(jButton1);
        jButton1.setBounds(300, 50, 70, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 20, 380, 90);

        jPanel4.setBackground(resourceMap.getColor("jPanel4.background")); // NOI18N
        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, resourceMap.getColor("jPanel4.border.highlightOuterColor"), resourceMap.getColor("jPanel4.border.highlightInnerColor"), resourceMap.getColor("jPanel4.border.shadowOuterColor"), resourceMap.getColor("jPanel4.border.shadowInnerColor"))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setLayout(null);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setBackground(resourceMap.getColor("jTable1.background")); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "S. No", "Area Name", "Rout"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(3, 3, 374, 450);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 160, 380, 460);

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 140, 100, 20);

        jButton2.setFont(resourceMap.getFont("jButton3.font")); // NOI18N
        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
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
        jButton2.setBounds(140, 120, 140, 25);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(tagada.TagadaApp.class).getContext().getActionMap(CreateArea.class, this);
        jButton3.setAction(actionMap.get("quit")); // NOI18N
        jButton3.setFont(resourceMap.getFont("jButton3.font")); // NOI18N
        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton3KeyTyped(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(290, 120, 100, 25);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        //System.out.println(""+evt.getKeyCode());
        int count=jTable1.getRowCount();
            try
            {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection conn=DriverManager.getConnection("jdbc:odbc:tagada");
                Statement st=conn.createStatement();
                String areaname=jTextField1.getText();
                String rout=""+jComboBox1.getSelectedItem();
                if(rout.equals("NA"))
                         {
                            rout=" ";

                         }
                st.executeUpdate("insert into tagadadb values('"+areaname+"','"+rout+"')");
                conn.close();
                javax.swing.JOptionPane.showMessageDialog(this, "Congratulations! New area name has been created");
                
                System.out.println(count);
                jTextField1.requestFocus();
                jTextField1.setText("");
                /*

                }*/

                
            }
            catch(Exception ae)
            {
                String error=""+ae;
                /*if((jTextField1.getText()).equals(" "))
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Area name can't be blank");
                }
                */

                if(error.equalsIgnoreCase("errerjava.sql.SQLException: General error"));
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Area name already exists or it contains null value! Please enter a unique area name");
                    
                }
                System.out.println("errer"+ae);

               jTextField1.requestFocus();
               jTextField1.setText("");
            }
            try
            {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection conn=DriverManager.getConnection("jdbc:odbc:tagada");
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select * from tagadadb");
                int ind=0;
                String data[]=new String [4];
                while(rs.next()==true)
                {
                    

                    data[0]=""+(ind+1);
                    data[1]=""+rs.getString("area name");
                    data[2]=""+rs.getString("rout");
                    //dtm.addRow(data);
                    

                       //da[0]=""+(ind);
                    ind++;
                }
                String co=""+count;
                String dt=""+jTable1.getValueAt(count-1, 0);
                if((""+data[0]).equals(co)==false){
                //System.out.println("hello");
                    dtm.addRow(data);
                    jTable1.setValueAt(data[0],count,0);
                    jTable1.setValueAt(data[1],count,1);
                    jTable1.setValueAt(data[2],count,2);
                }
        }
             catch(Exception ae1)
             {
                String error=""+ae1;
                /*if(error.equalsIgnoreCase("errerjava.sql.SQLException: General error"));
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Area name already exists! Please enter a unique area name");

                }*/
                System.out.println("errer"+ae1);

               jTextField1.requestFocus();
               //jTextField1.setText("");
            }



            
            
            
            
            /*if(evt.getKeyCode()==10)
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Congratulations! New area name has been created");

                jTextField1.requestFocus();
                jTextField1.setText("");

             }*/
    }//GEN-LAST:event_jButton2KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jComboBox1.requestFocus();
        }
}//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        jButton2.requestFocus();
}//GEN-LAST:event_jComboBox1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            int count=jTable1.getRowCount();
            try
            {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection conn=DriverManager.getConnection("jdbc:odbc:tagada");
                Statement st=conn.createStatement();
                String areaname=jTextField1.getText();
                String rout=""+jComboBox1.getSelectedItem();
                if(rout.equals("NA"))
                         {
                            rout=" ";

                         }
                st.executeUpdate("insert into tagadadb values('"+areaname+"','"+rout+"')");
                conn.close();
                javax.swing.JOptionPane.showMessageDialog(this, "Congratulations! New area name has been created");

                System.out.println(count);
                jTextField1.requestFocus();
                jTextField1.setText("");
                /*

                }*/


            }
            catch(Exception ae)
            {
                String error=""+ae;
                /*if((jTextField1.getText()).equals(" "))
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Area name can't be blank");
                }
                */

                if(error.equalsIgnoreCase("errerjava.sql.SQLException: General error"));
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Area name already exists or it contains null value! Please enter a unique area name");

                }
                System.out.println("errer"+ae);

               jTextField1.requestFocus();
               jTextField1.setText("");
            }
            try
            {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection conn=DriverManager.getConnection("jdbc:odbc:tagada");
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select * from tagadadb");
                int ind=0;
                String data[]=new String [4];
                while(rs.next()==true)
                {


                    data[0]=""+(ind+1);
                    data[1]=""+rs.getString("area name");
                    data[2]=""+rs.getString("rout");
                    //dtm.addRow(data);


                       //da[0]=""+(ind);
                    ind++;
                }
                String co=""+count;
                String dt=""+jTable1.getValueAt(count-1, 0);
                if((""+data[0]).equals(co)==false){
                //System.out.println("hello");
                    dtm.addRow(data);
                    jTable1.setValueAt(data[0],count,0);
                    jTable1.setValueAt(data[1],count,1);
                    jTable1.setValueAt(data[2],count,2);
                }
        }
             catch(Exception ae1)
             {
                String error=""+ae1;
                /*if(error.equalsIgnoreCase("errerjava.sql.SQLException: General error"));
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Area name already exists! Please enter a unique area name");

                }*/
                System.out.println("errer"+ae1);

               jTextField1.requestFocus();
               //jTextField1.setText("");
            }


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //jButton3.setAction(.get("quit"));
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyTyped
        // TODO add your handling code here:


        
    }//GEN-LAST:event_jButton3KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    
}
