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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 *
 * @author welcome
 */
public class ShowReceivedCashByCashier extends javax.swing.JInternalFrame {

    /** Creates new form ChequeReceiveByDC */
    public ShowReceivedCashByCashier() {
        initComponents();
        java.util.Date dt=new java.util.Date();
        int date=dt.getDate();
        int month=dt.getMonth()+1;
        int yr=dt.getYear()+1900;
        String setDate=date+"-"+month+"-"+yr;
        jLabel9.setText(setDate);
        jLabel10.setText(setDate);

        
//        addDepartmentNameInList();

        String heading[]={"Sr. No.","Date","Opening Amt.","Cash Bill Amt.","Received Cash","Due Amt.","Cheque Bill Amt.","Received Cheque Amt.","Total Bill Amt."};
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
        column=jTable1.getColumn("Date");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Cash Bill Amt.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Received Cash");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Due Amt.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Opening Amt.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Cheque Bill Amt.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(115);
        column=jTable1.getColumn("Received Cheque Amt.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(140);
        column=jTable1.getColumn("Total Bill Amt.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);

        jTable1.setRowHeight(25);
        addCashier();
        //setChequeDetails();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("REPORT :: CASH RECEIVED DETAILS - CASHIER WISE");
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("To");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(320, 20, 50, 20);

        jLabel9.setBackground(new java.awt.Color(255, 255, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("jLabel9");
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(370, 20, 120, 25);

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
        jButton1.setBounds(490, 20, 30, 25);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railwaycashoffice/images/Close1.gif"))); // NOI18N
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
        jButton2.setBounds(790, 60, 130, 30);

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
        jScrollPane1.setBounds(10, 100, 910, 410);

        jLabel10.setBackground(new java.awt.Color(255, 255, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("jLabel10");
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(170, 20, 120, 25);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railwaycashoffice/images/calendar.png"))); // NOI18N
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
        jButton3.setBounds(290, 20, 30, 25);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Last Due Amount (In Rs.)");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 520, 170, 20);

        jLabel3.setBackground(new java.awt.Color(153, 255, 153));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("0.00");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(420, 520, 100, 20);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railwaycashoffice/images/show.gif"))); // NOI18N
        jButton4.setText("Show");
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
        jButton4.setBounds(330, 60, 310, 30);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railwaycashoffice/images/PRINT.GIF"))); // NOI18N
        jButton5.setMnemonic('p');
        jButton5.setText("Print");
        jButton5.setToolTipText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jButton5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jButton5FocusLost(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(650, 60, 130, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Select Date Range");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 20, 170, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(170, 60, 150, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jLabel8.setText("Select Cashier Code");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 60, 170, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Cal date1=new Cal();
        jLabel9.setText(date1.getdate());
        //jComboBox1.requestFocus();
        //setChequeDetails();
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            Cal date1=new Cal();
            jLabel9.setText(date1.getdate());
            //setChequeDetails();
        }
}//GEN-LAST:event_jButton1KeyPressed

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        Cal date1=new Cal();
        jLabel10.setText(date1.getdate());
        //jComboBox1.requestFocus();
        //setChequeDetails();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        setChequeDetails();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5FocusGained

    private void jButton5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jButton5FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5FocusLost

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            setChequeDetails();
        }
    }//GEN-LAST:event_jButton4KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    javax.swing.table.DefaultTableModel dtm;
    String selectedChqAmt="";
    String selectedChqNo="";


    private void addCashier()
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
             String qry="Select cashier_number from cashier_detail order by cashier_number";
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

             String str=jLabel10.getText();
             String arr22[]=str.split("-");
             String setDateFrom=arr22[2]+"-"+arr22[1]+"-"+arr22[0];
             //java.util.Date dtFrom=new java.util.Date(Integer.parseInt(arr22[2])-1900, Integer.parseInt(arr22[1])-1, Integer.parseInt(arr22[0]));
             long dtFromLong=java.util.Date.parse(arr22[1]+"/"+arr22[0]+"/"+arr22[2]);

             str=jLabel9.getText();
             String arr[]=str.split("-");
             String setDate=arr[2]+"-"+arr[1]+"-"+arr[0];
             long dtToLong=java.util.Date.parse(arr[1]+"/"+arr[0]+"/"+arr[2]);

             String dpCodeStr="";
             String qry="";
             //int dpCode=-1;
             /*if(jComboBox1.getSelectedIndex()!=0)
             {
                qry="select dp_code from department_detail where dp_name='"+jComboBox1.getSelectedItem()+"'";
                dpCodeStr=object1.getSigetngleValue(qry, Main.year);
                dpCode = Integer.parseInt(dpCodeStr);
             }
              *
              */

             dtm.setRowCount(0);
             
             /*java.math.BigDecimal billAmtBd=new java.math.BigDecimal("0.00");
             java.math.BigDecimal openingAmtBd=new java.math.BigDecimal("0.00");
             java.math.BigDecimal recAmtBd=new java.math.BigDecimal("0.00");
             java.math.BigDecimal balAmtBd=new java.math.BigDecimal("0.00");
              *
              */
         
             //GET CASHIER CODE
             //----------------
             int cashiercode=0;
             int cashierno=Integer.parseInt(""+jComboBox1.getSelectedItem());
             qry="select cashier_code from cashier_detail where cashier_number="+cashierno+"";
             String value1=object1.getSigetngleValue(qry, Main.year);
             if(value1!=null)
             {
                 cashiercode=Integer.parseInt(value1);
             }

             qry="select sum(amount) from build_distribution where cashier_code="+cashiercode+" and edate<'"+setDateFrom+"'";
             value1=object1.getSigetngleValue(qry, Main.year);
             if(value1==null)
             {
                 value1="0.00";
             }

             qry="select sum(received_amount) from received_cash_detail where cashier_code="+cashiercode+" and edate<'"+setDateFrom+"'";
             String value2=object1.getSigetngleValue(qry, Main.year);
             if(value2==null)
             {
                 value2="0.00";
             }

             qry="select dueamount from opening_dueamount where cashier_code="+cashiercode+"";
             String value3=object1.getSigetngleValue(qry, Main.year);
             if(value3==null)
             {
                 value3="0.00";
             }

             String opening=""+(((new java.math.BigDecimal(value1)).add(new java.math.BigDecimal(value3)))).subtract((new java.math.BigDecimal(value2)));

          String cashbillamt="",receivedcash="",dueamt="",chequebillamt="",recchequebillamt="",mixbillamt="";
          boolean flag=false;
          while(dtFromLong<=dtToLong)
          {
              java.util.Date dtFrom=new java.util.Date(dtFromLong);
              setDate=(dtFrom.getYear()+1900)+"-"+(dtFrom.getMonth()+1)+"-"+dtFrom.getDate();

             //GET SUM OF DISTRIBUTED CASH BILL
             //--------------------------------
             qry="select sum(amount) from build_distribution where cashier_code="+cashiercode+" and edate='"+setDate+"'";
             cashbillamt=object1.getSigetngleValue(qry, Main.year);
             if(cashbillamt==null)
             {
                 cashbillamt="0.00";
             }

             //GET SUM OF RECEIVED CASH BY CASHIER
             //--------------------------------
             qry="select sum(received_amount) from received_cash_detail where cashier_code="+cashiercode+" and edate='"+setDate+"'";
             receivedcash=object1.getSigetngleValue(qry, Main.year);
             if(receivedcash==null)
             {
                 receivedcash="0.00";
             }

             //CALCULATE DUE AMOUNT
             //---------------------
             dueamt=""+((new java.math.BigDecimal(opening)).add(new java.math.BigDecimal(cashbillamt))).subtract(new java.math.BigDecimal(receivedcash));

             //GET SUM OF CHEQUE AMOUNT
             //--------------------------------
             qry="select sum(chq_amt) from build_distribution where cashier_code="+cashiercode+" and edate='"+setDate+"'";
             chequebillamt=object1.getSigetngleValue(qry, Main.year);
             if(chequebillamt==null)
             {
                 chequebillamt="0.00";
             }


             //GET SUM OF RECEIVED CHEQUE AMOUNT
             //---------------------------------
             qry="select sum(chq_amt) from cheque_detail_entry where cashier_code="+cashiercode+" and edate='"+setDate+"'";
             recchequebillamt=object1.getSigetngleValue(qry, Main.year);
             if(recchequebillamt==null)
             {
                 recchequebillamt="0.00";
             }

             //GET SUM OF total BILL AMOUNT
             //--------------------------------
             qry="select sum(mix_amount) from build_distribution where cashier_code="+cashiercode+" and edate='"+setDate+"'";
             mixbillamt=object1.getSigetngleValue(qry, Main.year);
             if(mixbillamt==null)
             {
                 mixbillamt="0.00";
             }


             String rowArr[]=new String[9];
             rowArr[0]=""+(dtm.getRowCount()+1)+". ";
             rowArr[1]=dtFrom.getDate()+"-"+(dtFrom.getMonth()+1)+"-"+(dtFrom.getYear()+1900);//date
             rowArr[2]=""+(new java.math.BigDecimal(opening)).setScale(2, 5);//opening amt
             rowArr[3]=""+(new java.math.BigDecimal(cashbillamt)).setScale(2, 5);//cash bill amt
             rowArr[4]=""+(new java.math.BigDecimal(receivedcash)).setScale(2, 5);//received cash amt
             rowArr[5]=""+(new java.math.BigDecimal(dueamt)).setScale(2, 5);//due amt
             rowArr[6]=""+(new java.math.BigDecimal(chequebillamt)).setScale(2, 5);//cheque  amt
             rowArr[7]=""+(new java.math.BigDecimal(recchequebillamt)).setScale(2, 5);//received cheque amt
             rowArr[8]=""+(new java.math.BigDecimal(mixbillamt)).setScale(2, 5);//total bill amt
             dtm.addRow(rowArr);
             opening=rowArr[5];


             dtFromLong=dtFromLong+86400000;
         }
             //jLabel1.setText(""+recAmtBd.setScale(2, 5));
             //jLabel2.setText(""+disAmtBd.setScale(2, 5));
         jLabel3.setText(""+(new java.math.BigDecimal(opening)).setScale(2, 5));
             


        }
        catch(Exception ex)
        {
            System.out.println("Error...627..."+ex);
            //javax.swing.JOptionPane.showMessageDialog(this, "Error 627..."+ex);
        }

    }
}