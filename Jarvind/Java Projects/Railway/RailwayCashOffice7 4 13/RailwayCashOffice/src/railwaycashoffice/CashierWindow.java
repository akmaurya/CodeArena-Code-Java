/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CashierWindow.java
 *
 * Created on Apr 12, 2012, 1:15:21 PM
 */

package railwaycashoffice;

/**
 *
 * @author pratiksha
 */
public class CashierWindow extends javax.swing.JInternalFrame {

    /** Creates new form CashierWindow */
    public CashierWindow() {
        initComponents();
        jTable1.setEnabled(false);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");

        /*
        String getT=Main.MR.getTitle();
        String f1[]=getT.split(":");
        String f2[]=f1[1].split("-");
        String year=f2[0]+f2[1];
        year=year.trim();
        */
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();


        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        javax.swing.table.TableColumn column;

        String head[]={"Sr. No.","Cashier No.","Cashier Name","Address","Contact No.","Current Amount"};
        dtm=new javax.swing.table.DefaultTableModel(head,0);
        jTable1.setModel(dtm);
         column=jTable1.getColumn("Sr. No.");
         column.setCellRenderer(CRRight);
         column.setPreferredWidth(60);
         column=jTable1.getColumn("Cashier No.");
         column.setCellRenderer(CRCenter);
         column.setPreferredWidth(80);
         column=jTable1.getColumn("Cashier Name");
         column.setCellRenderer(CRLeft);
         column.setPreferredWidth(220);
         column=jTable1.getColumn("Address");
         column.setCellRenderer(CRLeft);
         column.setPreferredWidth(240);
         column=jTable1.getColumn("Contact No.");
         column.setCellRenderer(CRCenter);
         column.setPreferredWidth(120);
         column=jTable1.getColumn("Current Amount");
         column.setCellRenderer(CRRight);
         column.setPreferredWidth(120);

         setCashierDetails();

        jTextField1.requestFocus();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(131, 139, 184));
        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setTitle("Manage Cashier ");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Cashier Number");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 30, 150, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Cashier Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 150, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("+91");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 180, 30, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Sort list by cashier ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(530, 240, 110, 20);

        jTextField1.setToolTipText("Please Input cashier number");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(160, 30, 90, 28);

        jTextField2.setToolTipText("Please input cashier name");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(160, 80, 400, 28);

        jTextField3.setToolTipText("Please input address");
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(160, 130, 400, 28);

        jTextField4.setToolTipText("Please input contact no.");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(160, 180, 240, 28);

        jButton1.setMnemonic('s');
        jButton1.setText("Save");
        jButton1.setToolTipText("Save Information");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed1(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(610, 150, 160, 30);

        jButton2.setMnemonic('c');
        jButton2.setText("Close");
        jButton2.setToolTipText("Close");
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
        jButton2.setBounds(610, 190, 160, 30);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(580, 30, 10, 190);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Contact No.");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 180, 150, 30);

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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 260, 740, 190);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/railwaycashoffice/images/lady_cashier.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(610, 30, 160, 110);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Existing Cashier Details");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 240, 150, 20);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setForeground(new java.awt.Color(0, 102, 102));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Name");
        jRadioButton1.setOpaque(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(640, 240, 60, 23);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setForeground(new java.awt.Color(0, 102, 102));
        jRadioButton2.setText("Number");
        jRadioButton2.setOpaque(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(700, 240, 80, 23);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("Address");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 130, 150, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Save();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
        Save();
        }

    }//GEN-LAST:event_jButton1KeyPressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        setCashierDetails();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        setCashierDetails();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton1KeyPressed1(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed1
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            Save();
    }//GEN-LAST:event_jButton1KeyPressed1

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
           dispose();
    }//GEN-LAST:event_jButton2KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
    javax.swing.table.DefaultTableModel dtm;
    //String year;

    private void setCashierDetails()
    {
        try
        {
        dtm.setRowCount(0);
        //interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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

        String qry="";
        if(jRadioButton1.isSelected()==true)
            qry="select cashier_code,cashier_number,cashier_name,address,phone_no from cashier_detail order by cashier_name";
        else
            qry="select cashier_code,cashier_number,cashier_name,address,phone_no from cashier_detail order by cashier_number";
        String data[][]=object1.getInformationDD(qry, 5,Main.year);
        String arr[]=new String[6];
        for(int r=0;r<data.length;r++)
        {
            qry="select current_amount from cashier_openingamount where cashier_code="+Integer.parseInt(data[r][0])+"";
            double curAmt=Double.valueOf(object1.getSigetngleValue(qry,Main.year));
            arr[0]=""+(dtm.getRowCount()+1)+". ";
            arr[1]=data[r][1];
            arr[2]=data[r][2];
            arr[3]=data[r][3];
            arr[4]=data[r][4];
            System.out.println("arr...."+arr[4]);
            arr[5]=(""+(new java.math.BigDecimal(curAmt).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
            dtm.addRow(arr);

            /*data[r][0]=""+(dtm.getRowCount()+1)+". ";
            dtm.addRow(data[r]);*/
        }
        }
        catch(Exception ex)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Can not show details. Error is -\n"+ex);
        }
    }

    private boolean Save()
{
    try
    {
        //interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
        if(jTextField1.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Please input cashier's no.");
            jTextField1.requestFocus();
            return false;
        }
        if(object1.isInteger(jTextField1.getText().trim())==false)
        {
             javax.swing.JOptionPane.showMessageDialog(null,"Error! Cashier's no. must be a number type.");
             jTextField1.requestFocus();
             jTextField1.selectAll();
             return false;
        }
        
        if(jTextField2.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Please input cashier's name.");
            jTextField2.requestFocus();
            return false;
        }
        if(!(jTextField4.getText().equals("")))
        {
            try
            {
                long con=Long.parseLong(jTextField4.getText().trim());
            }
            catch(Exception e)
            //if(object1.isInteger(jTextField4.getText().trim())==false)
            {
                 javax.swing.JOptionPane.showMessageDialog(null,"Error! Contact no. must be a number type."+e);
                 jTextField4.requestFocus();
                 jTextField4.selectAll();
                   return false;
            }
        }
        
        //CHECK EXISTANCE OF CASHIER CODE
        //-------------------------------
        
        String qry="Select cashier_number from cashier_detail where cashier_number="+Integer.parseInt(jTextField1.getText().trim());
        String getCashierNo=object1.getSigetngleValue(qry, Main.year);
        if(getCashierNo.length()>0)
          {
              javax.swing.JOptionPane.showMessageDialog(null,"Error! This cashier no. already exists.");
              jTextField1.requestFocus();
              jTextField1.selectAll();
              return false;
          }


        //NOW SAVE INFOEMATION
        //--------------------
        qry="Select max(cashier_Code) from cashier_detail";
        String getMax=object1.getSigetngleValue(qry,Main.year);
        if(getMax==null || getMax.length()==0)
        {
            getMax=""+1;
        }
        else
        {
            int ind=Integer.parseInt(getMax)+1;
            getMax=""+ind;
        }
        
         
        
                qry="insert into cashier_detail values("+Integer.parseInt(getMax)+","+Integer.parseInt(jTextField1.getText().trim())+",'"+jTextField2.getText().trim().toUpperCase()+"','"+jTextField3.getText().trim().toUpperCase()+"','"+jTextField4.getText().trim()+"')";
                boolean bn=object1.saveInformation(qry,Main.year);

                qry="insert into cashier_openingamount values("+Integer.parseInt(getMax)+","+0.0+","+0.0+",0)";
                bn=object1.saveInformation(qry,Main.year);

                qry="insert into opening_dueamount values("+Integer.parseInt(getMax)+","+0.0+")";
                bn=object1.saveInformation(qry,Main.year);
                qry="insert into cashier_creditbalance values("+Integer.parseInt(getMax)+","+0.0+")";
                bn=object1.saveInformation(qry,Main.year);

                if(bn)
                {
                    javax.swing.JOptionPane.showMessageDialog(null,"Process Completed ");
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jTextField3.setText("");
                    jTextField4.setText("");
                    setCashierDetails();
                    jTextField1.requestFocus();
                }          
    }
    catch(Exception e)
    {
        System.out.println("Error ! In Save Method"+e);
    }

    return true;
}
}