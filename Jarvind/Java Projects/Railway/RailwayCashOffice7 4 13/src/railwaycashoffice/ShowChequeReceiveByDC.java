/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ChequeReceiveByDC.java
 *
 * Created on Jul 18, 2012, 10:27:52 AM
 */

package railwaycashoffice;

import java.awt.Color;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 *
 * @author welcome
 */
public class ShowChequeReceiveByDC extends javax.swing.JInternalFrame {

    /** Creates new form ChequeReceiveByDC */
    public ShowChequeReceiveByDC() {
        initComponents();
        java.util.Date dt=new java.util.Date();
        int date=dt.getDate();
        int month=dt.getMonth()+1;
        int yr=dt.getYear()+1900;
        String setDate=date+"-"+month+"-"+yr;
        jLabel9.setText(setDate);

        
        addDepartmentNameInList();

        String heading[]={"Sr. No.","Cheque No.","Amount"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
        jTable1.setModel(dtm);
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();
        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        javax.swing.table.TableColumn column;
        column=jTable1.getColumn("Sr. No.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(50);
        column=jTable1.getColumn("Cheque No.");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Amount");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);

        jTable1.setRowHeight(25);
        
        setChequeDetails();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("REPORT :: CHEQUE RECEIVING BY DC");
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel4.setText("Select Department");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 50, 140, 26);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel5.setText("Cheque Receiving Date");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 20, 170, 20);

        jLabel9.setBackground(new java.awt.Color(255, 255, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel9");
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(200, 20, 190, 25);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railwaycashoffice/images/calendar.png"))); // NOI18N
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
        jButton1.setBounds(390, 20, 30, 25);

        jComboBox1.setForeground(new java.awt.Color(0, 0, 255));
        jComboBox1.setToolTipText("Please select department");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
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
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(200, 50, 220, 26);

        jButton2.setMnemonic('c');
        jButton2.setText("Close");
        jButton2.setToolTipText("Close");
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
        jButton2.setBounds(290, 460, 130, 30);

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 410, 310);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("0.00");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 90, 90, 14);

        jLabel2.setText("Opening Amount (In Rs.)");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 90, 160, 14);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 153, 0));
        jLabel3.setText("0.00");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 110, 90, 20);

        jLabel6.setText("Closing Amount (In Rs.)");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 110, 160, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Cal date1=new Cal();
        jLabel9.setText(date1.getdate());
        jComboBox1.requestFocus();
        setChequeDetails();
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            Cal date1=new Cal();
            jLabel9.setText(date1.getdate());
            setChequeDetails();
        }
}//GEN-LAST:event_jButton1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        //  javax.swing.JOptionPane.showMessageDialog(null,"coming here first.....");
        
        //setData();
        setChequeDetails();
}//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        // TODO add your handling code here:
        //jComboBox1.setForeground(Color.red);
        jComboBox1.setBackground(Color.yellow);
}//GEN-LAST:event_jComboBox1FocusGained

    private void jComboBox1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusLost
        // TODO add your handling code here:
        //jComboBox1.setForeground(Color.black);
        jComboBox1.setBackground(Color.white);
}//GEN-LAST:event_jComboBox1FocusLost

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
     //   if(evt.getKeyCode()==10) {
      //      jTextField1.requestFocus();
       // }
}//GEN-LAST:event_jComboBox1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusGained
        // TODO add your handling code here:
        //jButton2.setForeground(Color.red);
    }//GEN-LAST:event_jButton2FocusGained

    private void jButton2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton2FocusLost
        // TODO add your handling code here:
        //jButton2.setForeground(Color.black);
    }//GEN-LAST:event_jButton2FocusLost

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            this.dispose();
}//GEN-LAST:event_jButton2KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        /*int row=jTable1.getSelectedRow();
        jTextField1.setText(""+jTable1.getValueAt(row, 1));
        jTextField2.setText(""+jTable1.getValueAt(row, 2));
        selectedChqAmt=jTextField2.getText();
        selectedChqNo=jTextField1.getText();
        jButton1.setEnabled(false);
        jComboBox1.setEnabled(false);
         *
         */
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
/*        if(evt.getKeyCode()==evt.VK_DELETE)
        {
            deleteInformation();
        }
 * 
 */
    }//GEN-LAST:event_jTable1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    javax.swing.table.DefaultTableModel dtm;
    String selectedChqAmt="";
    String selectedChqNo="";


    private void addDepartmentNameInList()
    {
        try
        {
             interfaceRailway object1=null;
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
             String qry="Select dp_name from department_detail order by dp_code";
             String[] load=object1.getResultSetAs_1D_Array(qry,Main.year);
             jComboBox1.removeAllItems();
            if(load!=null && load.length>0)
            {
                for(int i=0;i<load.length;i++)
                {
                    jComboBox1.addItem(load[i]);
                }
            }

        }
        catch(Exception ex)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error no 891..."+ex);
        }
    }

    /*private boolean saveData()
    {
        int res=javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirmation", javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
        if(res==javax.swing.JOptionPane.NO_OPTION)
        {
            return false;
        }
        if(Utility.isBlank(jTextField1.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error!\nEnter cheque number.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            return false;
        }
        if(Utility.isBlank(jTextField2.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error!\nEnter cheque amount.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            return false;
        }
        if(Utility.isDouble(jTextField2.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error!\nInvalid cheque amount found.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            jTextField1.selectAll();
            return false;
        }
        try
        {
                interfaceRailway object1=null;
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

            String qry="Select dp_code from department_detail where dp_name='"+jComboBox1.getSelectedItem()+"'";
            int dpCode=Integer.parseInt(object1.getSigetngleValue(qry, Main.year));
            String d1[]=jLabel9.getText().split("-");
            String setDate=d1[2]+"-"+d1[1]+"-"+d1[0];
            String chqNo=jTextField1.getText().trim();
            double chqAmt=Double.valueOf(jTextField2.getText().trim());
            
            qry="select cash_amt from dc_cash_in_hand where rec_date>'"+setDate+"'";
            String str1=object1.getSigetngleValue(qry, Main.year);
            if(str1!=null && str1.equals("")==false)
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Error!\nUpdation for selected date is not possible.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }

            qry="update dc_chq_details set chq_no='"+chqNo+"',chq_amt="+chqAmt+" where dp_code="+dpCode+" and receiving_date='"+setDate+"' and chq_no='"+selectedChqNo+"'";
            System.out.println(qry);
            boolean response=object1.saveInformation(qry, Main.year);
            if(response==true)
            {
                qry="select cash_amt from dc_cash_in_hand where rec_date='"+setDate+"'";
                String str=object1.getSigetngleValue(qry, Main.year);
                if(str!=null && str.equals("")==false)
                {
                    java.math.BigDecimal bd=new java.math.BigDecimal(str);
                    bd=bd.add(new java.math.BigDecimal(jTextField2.getText().trim()));
                    bd=bd.subtract(new java.math.BigDecimal(selectedChqAmt));
                    qry="update dc_cash_in_hand set cash_amt="+bd+" where rec_date='"+setDate+"'";
                    System.out.println(qry);
                    response=object1.saveInformation(qry, Main.year);
                }
            }
            if(response==true)
            {
                setChequeDetails();
                javax.swing.JOptionPane.showMessageDialog(this, "Ok!\nCheque details updated successfully.", "Message",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jTextField1.setText("");
                jTextField2.setText("");
                jComboBox1.requestFocus();
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Error!\nSome problem found.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        }
        catch(Exception ex)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error no 891..."+ex);
        }
        return true;
    }
*/

 /*   private boolean deleteInformation()
    {
        int row=jTable1.getSelectedRow();
        if(row<0)
        {
                javax.swing.JOptionPane.showMessageDialog(this, "Error!\nfirst you select a record for deletion.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;

        }
        //int row=jTable1.getSelectedRow();
        jTextField1.setText(""+jTable1.getValueAt(row, 1));
        jTextField2.setText(""+jTable1.getValueAt(row, 2));
        selectedChqAmt=jTextField2.getText();
        selectedChqNo=jTextField1.getText();

        int res=javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirmation", javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
        if(res==javax.swing.JOptionPane.NO_OPTION)
        {
            return false;
        }
        try
        {
                interfaceRailway object1=null;
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

            String qry="Select dp_code from department_detail where dp_name='"+jComboBox1.getSelectedItem()+"'";
            int dpCode=Integer.parseInt(object1.getSigetngleValue(qry, Main.year));
            String d1[]=jLabel9.getText().split("-");
            String setDate=d1[2]+"-"+d1[1]+"-"+d1[0];
            String chqNo=jTextField1.getText().trim();
            double chqAmt=Double.valueOf(jTextField2.getText().trim());

            qry="select cash_amt from dc_cash_in_hand where rec_date>'"+setDate+"'";
            String str1=object1.getSigetngleValue(qry, Main.year);
            if(str1!=null && str1.equals("")==false)
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Error!\nUpdation for selected date is not possible.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
                return false;
            }

            qry="delete from dc_chq_details where dp_code="+dpCode+" and receiving_date='"+setDate+"' and chq_no='"+selectedChqNo+"'";
            System.out.println(qry);
            boolean response=object1.saveInformation(qry, Main.year);
            if(response==true)
            {
                qry="select cash_amt from dc_cash_in_hand where rec_date='"+setDate+"'";
                String str=object1.getSigetngleValue(qry, Main.year);
                if(str!=null && str.equals("")==false)
                {
                    java.math.BigDecimal bd=new java.math.BigDecimal(str);
                    //bd=bd.add(new java.math.BigDecimal(jTextField2.getText().trim()));
                    bd=bd.subtract(new java.math.BigDecimal(selectedChqAmt));
                    qry="update dc_cash_in_hand set cash_amt="+bd+" where rec_date='"+setDate+"'";
                    System.out.println(qry);
                    response=object1.saveInformation(qry, Main.year);
                }
            }
            if(response==true)
            {
                setChequeDetails();
                javax.swing.JOptionPane.showMessageDialog(this, "Ok!\nCheque details updated successfully.", "Message",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jTextField1.setText("");
                jTextField2.setText("");
                jComboBox1.requestFocus();
            }
            else
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Error!\nSome problem found.", "Error Message",javax.swing.JOptionPane.ERROR_MESSAGE);
            }

        }
        catch(Exception ex)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error no 891..."+ex);
        }
        return true;
    }
*/
    private void setChequeDetails()
    {
        //set last entry date
        try
        {
             interfaceRailway object1=null;
             try
	     {
		object1=(interfaceRailway)java.rmi.Naming.lookup(getIPaddress.IP());
	     }
	     catch(Exception e)
             {
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

             String str=jLabel9.getText();
             String arr[]=str.split("-");
             String setDate=arr[2]+"-"+arr[1]+"-"+arr[0];

             String qry="select dp_code from department_detail where dp_name='"+jComboBox1.getSelectedItem()+"'";
             String dpCodeStr=object1.getSigetngleValue(qry, Main.year);
             int dpCode=Integer.parseInt(dpCodeStr);

             qry="select * from dc_chq_details where receiving_date='"+setDate+"' and dp_code="+dpCode;
             String data[][]=object1.getInformationDD(qry, 4, Main.year);
             dtm.setRowCount(0);
             for(int i=0;i<data.length;i++)
             {
                 String rowArr[]=new String[3];
                 rowArr[0]=""+(dtm.getRowCount()+1)+". ";
                 rowArr[1]=data[i][2];
                 rowArr[2]=""+(new java.math.BigDecimal(data[i][3])).setScale(2,5);

                 dtm.addRow(rowArr);
             }

             try
             {
             qry="select cash_amt from dc_cash_in_hand where rec_date<'"+setDate+"' order by rec_date desc";
             String str2[]=object1.getResultSetAs_1D_Array(qry, Main.year);
             jLabel1.setText(""+(new java.math.BigDecimal(str2[0])).setScale(2, 5));
             }
             catch(Exception ex)
             {
                 jLabel1.setText("0.00");
             }

             try
             {
             qry="select cash_amt from dc_cash_in_hand where rec_date='"+setDate+"'";
             String str1=object1.getSigetngleValue(qry, Main.year);
             jLabel3.setText(""+(new java.math.BigDecimal(str1)).setScale(2, 5));
             }
             catch(Exception ex)
             {
                 jLabel3.setText(jLabel1.getText());
             }


        }
        catch(Exception ex)
        {
            System.out.println("Error...627..."+ex);
            //javax.swing.JOptionPane.showMessageDialog(this, "Error 627..."+ex);
        }

    }
}