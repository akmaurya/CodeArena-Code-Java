/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReceivedChallanEntry.java
 *
 * Created on Apr 26, 2012, 3:07:22 PM
 */

package railwaycashoffice;

import java.math.BigInteger;

/**
 *
 * @author pratiksha
 */
public class ReceivedChallanEntry extends javax.swing.JInternalFrame {

    /** Creates new form ReceivedChallanEntry */
    public ReceivedChallanEntry() {
        initComponents();

        java.util.Date dt=new java.util.Date();
        int date=dt.getDate();
        int month=dt.getMonth()+1;
        int yr=dt.getYear()+1900;
        String setDate=date+"-"+month+"-"+yr;
        jLabel2.setText(setDate);

        jTextField1.setText("");
        loadInitialInfo();

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
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(82, 152, 176));
        setClosable(true);
        setIconifiable(true);
        setTitle("Received Cash Entry");
        getContentPane().setLayout(null);

        jLabel1.setBackground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Date");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 90, 25);

        jLabel2.setBackground(new java.awt.Color(153, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("0");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 20, 200, 25);

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
        jButton1.setBounds(310, 20, 30, 25);

        jComboBox1.setToolTipText("Please input cashier number");
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
        jComboBox1.setBounds(130, 70, 220, 25);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("jTextField1");
        jTextField1.setToolTipText("Please input amount");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(480, 95, 270, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Cashier Number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 70, 110, 25);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Amount");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(360, 70, 120, 20);

        jButton2.setText("Save");
        jButton2.setToolTipText("Save Information");
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
        jButton2.setBounds(20, 150, 220, 30);

        jButton4.setMnemonic('C');
        jButton4.setText("Close");
        jButton4.setToolTipText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(530, 150, 220, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Select Department");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(350, 20, 130, 25);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setToolTipText("Please select department");
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(480, 20, 270, 25);

        jButton5.setMnemonic('n');
        jButton5.setText("Cancel");
        jButton5.setToolTipText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(270, 150, 230, 30);

        jLabel6.setBackground(new java.awt.Color(244, 183, 133));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("0");
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(480, 70, 270, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                  Cal date1=new Cal();
           jLabel2.setText(date1.getdate());
           jComboBox2.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedItem().equals("Select"))
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Please select the cashier from the list");
            jComboBox1.requestFocus();
        }
        else
        {
            Save();
        }
      

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
   if(evt.getKeyCode()==10)
   {
        if(jComboBox1.getSelectedItem().equals("Select"))
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Please select the cashier from the list");
            jComboBox1.requestFocus();
        }
        else
        {
            Save();
        }

   }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField1.requestFocus();
            jTextField1.selectAll();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(!jComboBox1.getSelectedItem().equals("Select"))
        {
            uploadDetail();
        }
         else
        {
            jTextField1.setText("0.0");
            jLabel6.setText("0.0");
            
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here
            if(!jComboBox1.getSelectedItem().equals("Select"))
            {
                cancelReceivedCashEntry();
            }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox1.requestFocus();
        }

    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
private void loadInitialInfo()
{
    try
    {
    
      //  interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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

        String qry="Select cashier_number from cashier_detail order by cashier_code";
        String load[]=object1.getResultSetAs_1D_Array(qry,Main.year);
        if(load!=null)
        {
            jComboBox1.addItem("Select");
            for(int i=0;i<load.length;i++)
            {
                jComboBox1.addItem(load[i]);
            }
        }

        qry="select dp_name from department_detail order by dp_code";
        load=object1.getResultSetAs_1D_Array(qry,Main.year);
        if(load!=null)
        {
            jComboBox2.removeAllItems();
            for(int i=0;i<load.length;i++)
            {
                jComboBox2.addItem(load[i]);
            }
        }


    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method"+e);
    }

}
private boolean Save()
{
    try
    {
      //  interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
            javax.swing.JOptionPane.showMessageDialog(null,"Please Input Amount");
            jTextField1.requestFocus();
            return false;

        }
        if(object1.isDouble(jTextField1.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Error ! Please input number type(Amount) value.");
            jTextField1.requestFocus();
            return false;
        }

        String qry="Select cashier_code from cashier_detail where cashier_number="+Integer.parseInt(""+jComboBox1.getSelectedItem())+"";
        String getCashierCode=object1.getSigetngleValue(qry,Main.year);
       

        qry="Select dp_code from department_detail where dp_name='"+(""+jComboBox2.getSelectedItem())+"'";
        String getDpCode=object1.getSigetngleValue(qry,Main.year);



        String d1[]=jLabel2.getText().split("-");
        String setDate=d1[2]+"-"+d1[1]+"-"+d1[0];
      

        //qry="Select sum(received_amount) from received_cash_detail where cashier_code="+Integer.parseInt(getCashierCode)+" and dp_code="+Integer.parseInt(getDpCode)+" and  edate='"+setDate+"'";
        qry="Select sum(received_amount) from received_cash_detail where cashier_code="+Integer.parseInt(getCashierCode)+" and  edate='"+setDate+"'";
        String getAmt[]=object1.getResultSetAs_1D_Array(qry,Main.year);
      
        if(getAmt[0]!=null)
        {
            //qry="insert into received_cash_detail values('"+setDate+"',"+Integer.parseInt(getCode)+","+Double.valueOf(jTextField1.getText().trim())+","+Integer.parseInt(getDpCode)+")";
            /*qry="delete from received_cash_detail where cashier_code="+Integer.parseInt(getCashierCode)+" and dp_code="+Integer.parseInt(getDpCode)+" and  edate='"+setDate+"' ";
            boolean bn=object1.saveInformation(qry,Main.year);
            if(bn)
            {
                //qry="update received_cash_detail set received_amount="+tot+" where cashier_code="+Integer.parseInt(getCashierCode)+" and dp_code="+Integer.parseInt(getDpCode)+" and  edate='"+setDate+"'";
                qry="select current_amount from cashier_openingamount where cashier_code="+Integer.parseInt(getCashierCode)+"";
                double curAmt=Double.valueOf(object1.getSigetngleValue(qry,Main.year));
                double amt=curAmt+Double.valueOf(jTextField1.getText().trim());
                qry="update cashier_openingamount set current_amount="+amt+",status=1 where cashier_code="+Integer.parseInt(getCashierCode)+"";
                object1.saveInformation(qry, Main.year);
                qry="insert into received_cash_detail values('"+setDate+"',"+Integer.parseInt(getCashierCode)+","+Double.valueOf(jTextField1.getText().trim())+","+Integer.parseInt(getDpCode)+")";
                bn=object1.saveInformation(qry,Main.year);
                if(bn)
                {
                    javax.swing.JOptionPane.showMessageDialog(null,"Process Completed");
                    jTextField1.setText("");
                    jComboBox1.setSelectedIndex(0);
                    jComboBox2.requestFocus();
                }
            }*/
            javax.swing.JOptionPane.showMessageDialog(null,"Please use edit option to update.");

        }
        else if(getAmt[0]==null)
        {
            qry="select current_amount from cashier_openingamount where cashier_code="+Integer.parseInt(getCashierCode)+"";
            double curAmt=Double.valueOf(object1.getSigetngleValue(qry,Main.year));
            double amt=curAmt+Double.valueOf(jTextField1.getText().trim());
            qry="update cashier_openingamount set current_amount="+amt+",status=1 where cashier_code="+Integer.parseInt(getCashierCode)+"";
            object1.saveInformation(qry, Main.year);
            qry="insert into received_cash_detail values('"+setDate+"',"+Integer.parseInt(getCashierCode)+","+Double.valueOf(jTextField1.getText().trim())+","+Integer.parseInt(getDpCode)+")";
            boolean bn=object1.saveInformation(qry,Main.year);
            if(bn)
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Process Completed");
                jTextField1.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.requestFocus();
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
    try
    {
        double totalDueAmount=0.0;
       // interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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

        String qry="Select dp_code from department_detail where dp_name='"+(""+jComboBox2.getSelectedItem())+"'";
        String getDpCode=object1.getSigetngleValue(qry,Main.year);
        qry="Select cashier_code from cashier_detail where cashier_number="+Integer.parseInt(""+jComboBox1.getSelectedItem());
        String getCashierCode=object1.getSigetngleValue(qry, Main.year);
        if(getCashierCode!=null || getCashierCode.length()>0)
        {
            String d1[]=jLabel2.getText().split("-");
            String setDate=d1[2]+"-"+d1[1]+"-"+d1[0];

            //totalDueAmount=dueAmount(getCashierCode,getDpCode);
            totalDueAmount=dueAmount(getCashierCode);
            jLabel6.setText(""+new java.math.BigDecimal(totalDueAmount).setScale(2,5));


            //qry="Select sum(received_amount) from received_cash_detail where cashier_code="+Integer.parseInt(getCashierCode)+" and dp_code="+Integer.parseInt(getDpCode)+" and  edate='"+setDate+"'";
            qry="Select sum(received_amount) from received_cash_detail where cashier_code="+Integer.parseInt(getCashierCode)+" and  edate='"+setDate+"'";
            String getAmt[]=object1.getResultSetAs_1D_Array(qry,Main.year);
            
            if(getAmt[0]!=null)
                 jTextField1.setText(""+new java.math.BigDecimal(Double.valueOf(getAmt[0])).setScale(2,5));
            else if(getAmt[0]==null)
                 jTextField1.setText("0.0");
            jTextField1.selectAll();
        }

    }
    catch(Exception e)
    {
        System.out.println("Error ! In uploadDetail Method."+e);
    }

}
private boolean cancelReceivedCashEntry()
{
    try
    {

     //   interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
            javax.swing.JOptionPane.showMessageDialog(null,"Please Input Amount");
            jTextField1.requestFocus();
            return false;

        }
        if(object1.isDouble(jTextField1.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(null,"Error ! Please input number type(Amount) value.");
            jTextField1.requestFocus();
            return false;
        }
 
        String d1[]=jLabel2.getText().split("-");
        String setDate=d1[2]+"-"+d1[1]+"-"+d1[0];
        String qry="Select dp_code from department_detail where dp_name='"+(""+jComboBox2.getSelectedItem())+"'";
        String getDpCode=object1.getSigetngleValue(qry,Main.year);
        qry="Select cashier_code from cashier_detail where cashier_number="+Integer.parseInt(""+jComboBox1.getSelectedItem());
        String getCashierCode=object1.getSigetngleValue(qry, Main.year);
        if(getCashierCode!=null || getCashierCode.length()>0)
        {

            int response=javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure about this deletion? \nClick YES if you accept, otherwise click on NO.","Confirmation",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
            if(response==javax.swing.JOptionPane.YES_OPTION)
            {
                qry="select received_amount from received_cash_detail where cashier_code="+Integer.parseInt(getCashierCode)+" and edate='"+setDate+"'";
                String amt=object1.getSigetngleValue(qry,Main.year);
                if(amt.trim().equals("")==false)
                {
                    qry="select current_amount from cashier_openingamount where cashier_code="+Integer.parseInt(getCashierCode)+"";
                    double curAmt=Double.valueOf(object1.getSigetngleValue(qry,Main.year));
                    double amt1=curAmt-Double.valueOf(amt);
                    qry="update cashier_openingamount set current_amount="+amt1+",status=1 where cashier_code="+Integer.parseInt(getCashierCode)+"";
                    object1.saveInformation(qry, Main.year);

                    //qry="delete from received_cash_detail where cashier_code="+Integer.parseInt(getCashierCode)+" and dp_code="+Integer.parseInt(getDpCode)+" and  edate='"+setDate+"'";
                    qry="delete from received_cash_detail where cashier_code="+Integer.parseInt(getCashierCode)+" and edate='"+setDate+"'";
                    boolean bn=object1.saveInformation(qry,Main.year);
                    if(bn)
                    {
                        javax.swing.JOptionPane.showMessageDialog(this,"Record deleted successfully.");
                        jTextField1.setText("");
                        jComboBox1.setSelectedIndex(0);
                        jComboBox2.setSelectedIndex(0);

                        java.util.Date dt=new java.util.Date();
                        int date=dt.getDate();
                        int month=dt.getMonth()+1;
                        int yr=dt.getYear()+1900;
                        setDate=date+"-"+month+"-"+yr;
                        jLabel2.setText(setDate);
                        jComboBox2.requestFocus();
                    }
                }
                else
                {
                    javax.swing.JOptionPane.showMessageDialog(this,"No data found to cancel.");
                    jTextField1.requestFocus();
                }
                  
            }

        }


    }
    catch(Exception e)
    {
        System.out.println("Error ! in cancelReceivedCashEntry Method."+e);
    }
return true;

}
//private double dueAmount(String cashiercode,String dpcode)
private double dueAmount(String cashiercode)
{
    double amount=0.0,receivedamount=0.0,dueAmount=0.0,totalDueAmt=0.0,totdue=0.0,returningAmt=0.0,lastYearDueAmt=0.0;
    String load=cashiercode;
    //String dpCode=dpcode;
    try
    {
        String d1[]=jLabel2.getText().split("-");
        String setDate=d1[2]+"-"+d1[1]+"-"+d1[0];
        String deadDate=2000+"-"+1+"-"+1;
    ///    interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
        String  qry="Select dueamount from opening_dueamount where cashier_code="+Integer.parseInt(load)+"";
        String dueAmt=object1.getSigetngleValue(qry,Main.year);
        //System.out.println("dueAmt.........");
        if(dueAmt.length()>0)// || dueAmt.length>0)
                  dueAmount=Double.valueOf(dueAmt);
        else if(dueAmt.length()==0)
                  dueAmount=0.0;
        String getStr[]=jLabel2.getText().split("-");
        String setDate1=getStr[2]+"-"+getStr[1]+"-"+getStr[0];
       // qry="Select sum(amount) from build_distribution where cashier_code="+Integer.parseInt(load)+" and dp_code="+Integer.parseInt(dpCode)+" and (amounttype='"+"Cash"+"' and edate<='"+setDate1+"')";
        //qry="Select sum(amount) from build_distribution where cashier_code="+Integer.parseInt(load)+" and edate<='"+setDate1+"' and (amounttype='"+"Cash"+"' or amounttype='"+"Cash n Cheque"+"')";
        qry="Select sum(amount) from build_distribution where cashier_code="+Integer.parseInt(load)+" and edate<='"+setDate1+"'";
        System.out.println("qry............shweta........"+qry);
        String amt[]=object1.getResultSetAs_1D_Array(qry,Main.year);
        System.out.println("amt........"+amt.length+"    "+amt);
        if(amt[0]!=null )
        {
                  amount=Double.valueOf(amt[0]);
                  System.out.println("amount............."+amount);
        }
        else if(amt[0]==null)
                  amount=0.0;

       
                  //////sum of received amount///////////////
        qry="Select sum(received_amount) from received_cash_detail where cashier_code="+Integer.parseInt(load)+"";
        String receivedAmt[]=object1.getResultSetAs_1D_Array(qry,Main.year);
        if(receivedAmt[0]!=null)// || receivedAmt.length>0)
                  receivedamount=Double.valueOf(receivedAmt[0]);
        else if(receivedAmt[0]==null)
                  receivedamount=0.0;
        totdue=dueAmount+amount;
        System.out.println("totdue........"+totdue);
        if(totdue>=receivedamount)
            totalDueAmt=totdue-receivedamount;
        else
            totalDueAmt=totdue;
            System.out.println("totalDueAmt................"+totalDueAmt);

        /////////////returning dues of closed challan/////////////////
        qry="Select edate from challan_detail where edate<'"+setDate+"' and cashier_code="+Integer.parseInt(load)+" and closing_status="+"1"+" order by edate asc";
        String loadDate[]=object1.getResultSetAs_1D_Array(qry,Main.year);
        if(loadDate!=null && loadDate.length>0)
        {
            for(int i=0;i<loadDate.length;i++)
            {
                String D1[]=loadDate[i].split("-");
                String matchDate=D1[2]+"-"+D1[1]+"-"+D1[0];
                //qry="Select sum(amount) from build_distribution where edate='"+matchDate+"' and paymentdate='"+deadDate+"' and cashier_code="+Integer.parseInt(load)+" and (amounttype='"+"Cash"+"' or amounttype='"+"Cash n Cheque"+"')";
                qry="Select sum(amount) from build_distribution where edate='"+matchDate+"' and paymentdate='"+deadDate+"' and cashier_code="+Integer.parseInt(load)+"";
                String getReturningAmount=object1.getSigetngleValue(qry,Main.year);
                if(getReturningAmount!=null && getReturningAmount.length()>0)
                {
                    returningAmt=returningAmt+Double.valueOf(getReturningAmount);
                }
            
            }
        }
        if(totalDueAmt>=returningAmt)
            totalDueAmt=totalDueAmt-returningAmt;
        /////////////////////////////////////////////////////////////
    }
    catch(Exception e)
    {
        System.out.println("Error ! In due Amount Method."+e);
    }
    return totalDueAmt;
}
/*private double backDateCalculation(String cashierCode)
{
    double amount=0.0;
    String d1[]=jLabel2.getText().split("-");
    String setDate=d1[2]+"-"+d1[1]+"-"+d1[0];
    try
    {
       // interfaceRailway object1=(interfaceRailway)java.rmi.Naming.lookup("rmi://127.0.0.1/railwayMethods");
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
        String qry="Select sum(amount) from carryforward_build_distribution where cashier_code="+Integer.parseInt(cashierCode)+" and amounttype='"+"Cash"+"'and edate<'"+setDate+"'";
        String getAmt=object1.getSigetngleValue(qry,Main.year);
        if(getAmt!=null && getAmt.equals("")==false)
        {
            amount=Double.valueOf(getAmt);
        }

    }
    catch(Exception e)
    {
        System.out.println("Error ! In backDateCalculation Method."+e);
    }

    return amount;
}*/


}
