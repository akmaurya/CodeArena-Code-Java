/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Opening_Stock.java
 *
 * Created on Dec 11, 2013, 1:23:11 PM
 */

package golden_shoap;
import java.sql.SQLException;

/**
 *
 * @author user1
 */
public class Distribute_Polish_Material extends javax.swing.JInternalFrame {
String userId="Zed";
    /** Creates new form Opening_Stock */
    public Distribute_Polish_Material(){
        initComponents();

         addItem();
         jComboBox1.requestFocus();
         jTextField1.setText("0");
         setDate();
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
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Distribute Polish Material");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel1.setText("Material Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 50, 100, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(150, 130, 180, 30);

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
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(150, 50, 180, 30);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel2.setText("Current Stock");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 90, 100, 30);

        jLabel3.setBackground(new java.awt.Color(235, 217, 254));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(260, 90, 70, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/savefile.gif"))); // NOI18N
        jButton1.setMnemonic('a');
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed1(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed1(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 240, 150, 30);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(260, 60, 70, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel6.setText("Given Material");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 130, 100, 30);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel7.setText("Remaining Stock");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 170, 120, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.gif"))); // NOI18N
        jButton2.setMnemonic('c');
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
        getContentPane().add(jButton2);
        jButton2.setBounds(180, 240, 150, 30);

        jLabel8.setBackground(new java.awt.Color(235, 217, 254));
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(150, 170, 180, 30);

        jLabel9.setBackground(new java.awt.Color(235, 217, 254));
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(150, 90, 100, 30);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel10.setText("Distribute Date");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 10, 110, 30);

        jLabel11.setBackground(new java.awt.Color(235, 217, 254));
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(150, 10, 150, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/golden_shoap/cal.png"))); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(300, 10, 30, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeskTopTextureEdit11.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 350, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setDate()
    {
        java.util.Date dt=new java.util.Date();
        int date=dt.getDate();
        int month=dt.getMonth()+1;
        int year=dt.getYear()+1900;
        String d=""+date;
        if(d.length()==1)
        {
            d=0+d;
        }
        String setDate=d+"-"+month+"-"+year;
        jLabel11.setText(setDate);

    }
    public void addItem()
    {
                      String qry="select material_name from polish_material";
                      String[][] data=Utility.getInformationDD(qry,1);
                      int length= data.length;
                      for(int i=0;i<length;i++)
                      {   jComboBox1.addItem(data[i][0]);
                      }
    }
    public boolean distribute()
    {
               
               if((jTextField1.getText()).equals(""))
               {
                    javax.swing.JOptionPane.showMessageDialog(this,"Opening stock does not blank.Minimum zero is required." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);

               }
               else
               {    System.out.println("Else part=");
                    String qry1="update polish_material set quantity="+(Double.valueOf(jLabel8.getText()))+" where material_name='"+(jComboBox1.getSelectedItem())+"'";
                    Utility.saveInformation(qry1);
                    jTextField1.setText("");
               }

         return true;
    }
    public boolean save()
    {
        String date=jLabel11.getText();
        String d[]=date.split("-");
        date=d[1]+"/"+d[0]+"/"+d[2];
           
        String materialName=""+jComboBox1.getSelectedItem();
        double stock=Double.valueOf(jLabel9.getText());
              System.out.println("Stock="+stock);
        double givenMaterial=Double.valueOf(jTextField1.getText());
              System.out.println("Given Material"+givenMaterial);
        double remainingStock=Double.valueOf(jLabel8.getText());
              System.out.println("Remaining stock"+remainingStock);

        //userId="Zed";
        //System.out.println("Save here...................");
        String qry="insert into distribute_polish_materials values('"+date+"','"+materialName+"',"+stock+","+givenMaterial+","+remainingStock+",'"+userId+"')";
        boolean b=Utility.saveInformation(qry);
        System.out.println("Save here...................");
        return true;

    }
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField1.requestFocus();
        }


    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==10)
        {
            jButton1.requestFocus();
        }

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
                      String qry="select material_unit from polish_material where material_name='"+(""+jComboBox1.getSelectedItem())+"'";
                      String data=Utility.getSingleValue(qry);
                      jLabel3.setText(data);
                      String qry1="select quantity from polish_material where material_name='"+(""+jComboBox1.getSelectedItem())+"'";
                      String data1=Utility.getSingleValue(qry1);
                      System.out.println("Data="+data1);
                      java.math.BigDecimal bd=new java.math.BigDecimal(data1);
                      int scale=Utility.manageUnitDecimal("polish_material_unit","material_unit","scale",jLabel3.getText());
                      jLabel9.setText(""+bd.setScale(scale,5));
                      jTextField1.requestFocus();
                      bd=new java.math.BigDecimal(data1);
                      scale=Utility.manageUnitDecimal("polish_material_unit","material_unit","scale",jLabel3.getText());
                      jLabel8.setText(""+bd.setScale(scale,5));
      
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1KeyPressed

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

    private void jButton1ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed1
        // TODO add your handling code here:
       if(jTextField1.getText().isEmpty()==false)
       {    if(Utility.isDouble(jTextField1.getText()))
            {           boolean b1=save();
                        boolean b=distribute();
                        if(b==true && b1==true)
                        {           int check=javax.swing.JOptionPane.showConfirmDialog(this,"Material Sucessfully Delivered. Do you want to continue ? " ,"Message Box",javax.swing.JOptionPane.YES_NO_OPTION);
                                    System.out.println("Check="+check);
                                    if(check==0)
                                     {   jComboBox1.requestFocus();
                                         jTextField1.setText("0");
                                          String qry1="select quantity from polish_material where material_name='"+(""+jComboBox1.getSelectedItem())+"'";
                                          String data1=Utility.getSingleValue(qry1);
                                          System.out.println("Data============"+data1);
                                          java.math.BigDecimal bd=new java.math.BigDecimal(data1);
                                          int scale=Utility.manageUnitDecimal("polish_material_unit","material_unit","scale",jLabel3.getText());
                                          System.out.println("Scale="+scale);
                                          jLabel9.setText(""+bd.setScale(scale,5));

                                     }
                                    if(check==1)
                                    {
                                        this.dispose();
                                    }
                             
                        }
           }
           else
           {
                  javax.swing.JOptionPane.showMessageDialog(this,"Error............Invalied entry." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                  jTextField1.requestFocus();
           }
       }
       else
       {
              javax.swing.JOptionPane.showMessageDialog(this,"Error............ Distribution quantity does not blank. Minimum '0' is required." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
              jTextField1.requestFocus();
       }
    }//GEN-LAST:event_jButton1ActionPerformed1

    private void jButton1KeyPressed1(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed1
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            if(jTextField1.getText().isEmpty()==false)
            {    if(Utility.isDouble(jTextField1.getText()))
                 {           Boolean b=distribute();
                            if(b==true)
                            {             int check=javax.swing.JOptionPane.showConfirmDialog(this,"Material Sucessfully Delivered.Do you want to continue ?" ,"Message Box",javax.swing.JOptionPane.YES_NO_OPTION);
                                    if(check==0)
                                     {   jComboBox1.requestFocus();
                                         jTextField1.setText("0");
                                          String qry1="select quantity from polish_material where material_name='"+(""+jComboBox1.getSelectedItem())+"'";
                                          String data1=Utility.getSingleValue(qry1);
                                          //System.out.println("Data="+data1);
                                          java.math.BigDecimal bd=new java.math.BigDecimal(data1);
                                          int scale=Utility.manageUnitDecimal("polish_material_unit","material_unit","scale",jLabel3.getText());
                                          jLabel9.setText(""+bd.setScale(scale,5));

                                      }
                                    else
                                    {
                                        this.dispose();
                                    }
                            }
                   }
                  else
                   {
                          javax.swing.JOptionPane.showMessageDialog(this,"Error............Invalied entry." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                          jTextField1.requestFocus();
                   }
       }
       else
       {              javax.swing.JOptionPane.showMessageDialog(this,"Error............ Distribution quantity does not blank. Minimum '0' is required." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                      jTextField1.requestFocus();
       }
    }
    }//GEN-LAST:event_jButton1KeyPressed1

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
          if(Utility.isBlank(jTextField1.getText())==false)
                {
                        if((Double.valueOf(jTextField1.getText())>(Double.valueOf(jLabel9.getText()))))
                        {
                            javax.swing.JOptionPane.showMessageDialog(this,"Error.......given material is not greater than remaining stock.","Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                            jTextField1.setText("0");
                            jLabel8.setText(jLabel9.getText());
                        }
                        else
                        {
                                            if((Utility.isDouble(jTextField1.getText())))
                                             {
                                                         if((Double.valueOf(jTextField1.getText()))>=0)
                                                           {    double remainingStock=(Double.valueOf(jLabel9.getText()));
                                                                java.math.BigDecimal bd4=new java.math.BigDecimal(remainingStock);
                                                                remainingStock=Double.valueOf(""+bd4.setScale(0,java.math.BigDecimal.ROUND_HALF_UP));

                                                                double a=((remainingStock)-(Double.valueOf(jTextField1.getText())));
                                                                java.math.BigDecimal bd=new java.math.BigDecimal(a);
                                                                int scale=Utility.manageUnitDecimal("polish_material_unit","material_unit","scale",jLabel3.getText());
                                                                jLabel8.setText(""+bd.setScale(scale,5));
                                                            }
                                            }
                                            else
                                            {
                                                if((evt.getKeyCode())==127 || (evt.getKeyCode())==8)
                                                {
                                                    if(Utility.isBlank(jTextField1.getText()))
                                                    {
                                                        jLabel8.setText(""+(jLabel9.getText()));
                                                    }
                                                }
                                                else
                                                {
                                                  javax.swing.JOptionPane.showMessageDialog(this,"Discount is not valid." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                                  String str=jTextField1.getText().substring(0, jTextField1.getText().length()-1);
                                                  jTextField1.setText(str);
                                                }
                                             }
                        }
                 }
               else
                {
                        jLabel8.setText(""+(jLabel9.getText()));
                }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        // TODO add your handling code here:
        jTextField1.selectAll();
    }//GEN-LAST:event_jTextField1FocusGained

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
        calenderDate();
    }//GEN-LAST:event_jButton3MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
 public void calenderDate()
    {   Calender c=new Calender();
        jLabel11.setText(c.getdate());
    }
}
