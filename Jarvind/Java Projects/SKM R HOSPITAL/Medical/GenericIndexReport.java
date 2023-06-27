/*
 * GenericIndexReport.java
 *
 * Created on June 3, 2011, 11:00 AM
 */

//package skm;
import javax.swing.*;
import javax.swing.table.*;
import java.rmi.*;
import java.awt.*;
/**
 *
 * @author  Administrator
 */
public class GenericIndexReport extends javax.swing.JInternalFrame {
    
    /** Creates new form GenericIndexReport */
    public GenericIndexReport() {
        initComponents();
        java.util.Date dt=new java.util.Date();
        String entrydate=(dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
        jLabel3.setText(entrydate);
        jLabel5.setText(entrydate);
        dtm=new DefaultTableModel(new String[] {"S.No.","Company","Particular","Batch No.","Trade","Deal","MRP","Net Profit","Agency"},0);
        jTable1.setModel(dtm);
        javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
      		javax.swing.table.TableColumn column;

      		column=jTable1.getColumn("S.No.");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(35);
                column=jTable1.getColumn("Company");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);
                column=jTable1.getColumn("Particular");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);
       			column=jTable1.getColumn("Batch No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(100);
                column=jTable1.getColumn("Trade");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(80);
                column=jTable1.getColumn("MRP");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(50);
                column=jTable1.getColumn("Deal");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(90);
                column=jTable1.getColumn("Net Profit");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);
       			column=jTable1.getColumn("Agency");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);
       		
       		jComboBox1.removeAllItems();
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
       			String str[]=inf.getResultSetAs_1D_Array("select distinct(genericNm) from itemMaster order by genericNm");
       			if(str!=null)
       			{
       				for(int i=0;i<str.length;i++)
       					jComboBox1.addItem(str[i]);
       			}
       		}
       		catch(Exception e)
       		{
       			System.out.println("Error in constructor of GenericIndexReport class...."+e);
       		}
    }
    private void execution0()
    {
    String qry="select itemName from itemMaster where genericNm='"+""+jComboBox1.getSelectedItem()+"'";
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
       		String str[]=inf.getResultSetAs_1D_Array(qry);
       		if(str!=null)
       		{
       			
       			for(int i=0;i<str.length;i++)
       			{
       				data=new String[9];
       				//sr
       				data[0]=(dtm.getRowCount()+1)+".";
       				//cmp name
       				String cmpcode=inf.getSingleValue("select cmpCode from itemMaster where itemName='"+str[i]+"'");
       				data[1]=inf.getSingleValue("select cmpName from cmpMaster where cmpCode="+Integer.parseInt(cmpcode)+"");
       				//item nm
       				data[2]=str[i];
       				// taking list of value of related item
       				String temp[][]=inf.getResultSetAs_2D_Array("select pNo,batchNo,trdRate,spDis,mrp from purchaseDtl where itemNm='"+data[2]+"'",5);
       				if(temp!=null)
       				{
       					for(int j=0;j<temp.length;j++)
       					{
       						//batch no
       						data[3]=temp[j][1];
       						//trade
       						data[4]=""+(new java.math.BigDecimal(temp[j][2]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
       						//deal
       						data[5]=temp[j][3];
       						//mrp
       						data[6]=""+(new java.math.BigDecimal(temp[j][4]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
       						//profit related code----------
       						wholeSellAmt=0;
       						wholePurAmt=0;
       						//showProfit();
       						execution1();
       						System.out.println(".......................W S A="+wholeSellAmt);
       						System.out.println(".......................W P A="+wholePurAmt);
       						
       						double profit=wholeSellAmt-wholePurAmt;
       						//profit
       						data[7]=""+(new java.math.BigDecimal(profit).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
       						//agency
       						String q="select partyNm from purchaseSmry where pNo="+Integer.parseInt(temp[j][0])+"";
       						data[8]=inf.getSingleValue(q);
       						dtm.addRow(data);
       						
       						wholePurAmt=0;
       						wholeSellAmt=0;
       						
       					}
       				}
       			}
       		}
       	}
       	catch(Exception e)
       	{
       		System.out.println("Error in constructor of GenericIndexReport class...."+e);
       	}
    }
    private void execution1()
    {
    	try
    	{
    		System.out.println("in 1");
    		String temp[]=jLabel3.getText().split("/");
    		String selectedDate1=temp[1]+"/"+temp[0]+"/"+temp[2];
    		temp=jLabel5.getText().split("/");
    		String selectedDate2=temp[1]+"/"+temp[0]+"/"+temp[2];
    		String query="select sNo from saleSmry";
        	System.out.println("1.........");
			if(jCheckBox1.isSelected())
			{
				System.out.println("2.........");
				query+=" where entryDt>=#"+selectedDate1+"# and entryDt<=#"+selectedDate2+"# order by entryDt,sNo";
                System.out.println("Query="+query);
				execution2(query);
			}
       		if(!jCheckBox1.isSelected())
			{
				System.out.println("3.........");
				query+=" where entryDt<=#"+selectedDate2+"# order by entryDt,sNo desc";
                System.out.println("Query="+query);
				execution2(query);
        	}
        	query="select pkging,qty,amount from purchaseDtl where coNm='"+data[1]+"' and batchNo='"+data[3]+"' and itemNm='"+data[2]+"'";
            execution4(query);
            wholePurAmt=qtyAtSellTime*costOfOneItem;
            wholeSellAmt=amtAtSellTime;
            //re initilize-------------
            qtyAtSellTime=0;
            amtAtSellTime=0;
            costOfOneItem=0;
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in execution1 ...."+e);
    	}
    }
    private void execution2(String query1)
    {
    	try
    	{
    		System.out.println("in 2");
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
            String []rs=inf.getResultSetAs_1D_Array(query1);
            if(rs!=null)
            for(int i=0;i<rs.length;i++)
            {
            	int sno=Integer.parseInt(rs[i]);
            	String query="select qty,amount from saleDtl where coNm='"+data[1]+"' and itemNm='"+data[2]+"' and batchNo='"+data[3]+"' and sNo="+sno+"";
            	execution3(query);	
            }
            
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in execution2 ...."+e);
    	}
    }
    private void execution4(String query1)
    {
        try 
        {
        	System.out.println("in 4");
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
            String[][] rs=inf.getResultSetAs_2D_Array(query1,3);
            if(rs!=null)
            for(int i=0;i<rs.length;i++)
            {
                String pkging=rs[i][0];
                String a[]=pkging.split(" ");
                int pkQty=0;
                try
                {
                    pkQty=Integer.parseInt(a[0]);
                }
                catch(Exception e)
                {
                    System.out.println("Error...in execution4 method..."+e);
                }
                int qty=Integer.parseInt(rs[i][1]);
                if(qty==0)  qty=1;
                if(pkQty==0)  pkQty=1;
                int totalQty=pkQty*qty;
                double amt=Double.valueOf(rs[i][2]);
                costOfOneItem=(amt/totalQty);
                //wholePurAmt+=(qtyAtSellTime*costOfOneItem);
            }
            /*else
            {
                flagForSellRateEqualsPurRate=true;
            }*/
            //connection.close();
        }
        catch(Exception e)
        {
            System.out.println("Error in execution4 2...."+e);
        }
    }
    private void execution3(String query1)
    {
    	try
    	{
    		System.out.println("in 3");
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
            String [][]rs1=inf.getResultSetAs_2D_Array(query1,2);
            if(rs1!=null && rs1.length!=0)
            {
            	System.out.println("...........1.."+rs1.length);
            	qtyAtSellTime+=Integer.parseInt(rs1[0][0]);
            	System.out.println("...........2");
            	amtAtSellTime+=Double.valueOf(rs1[0][1]);
            	System.out.println("...........3");
            }
       	}
    	catch(Exception e)
    	{
    		System.out.println("Error in excution3.11....."+e);
    	}
    }

    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        getContentPane().setLayout(null);

        setBackground(new java.awt.Color(60, 220, 220));
        setClosable(true);
        setTitle("Generic Index");
        jPanel1.setLayout(null);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 0), 1, true));
        jLabel1.setText("Select Generic name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 50, 150, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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

        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(140, 50, 240, 22);

        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pendingSur.gif")));
        jButton1.setMnemonic('s');
        jButton1.setText("Show");
        jButton1.setToolTipText("SHow Related Info");
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
        jButton1.setBounds(390, 10, 110, 60);

        jButton2.setForeground(new java.awt.Color(0, 0, 153));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
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

        jPanel1.add(jButton2);
        jButton2.setBounds(520, 10, 110, 60);

        jLabel2.setText("Select Date Range");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 120, 20);

        jLabel3.setBackground(new java.awt.Color(255, 255, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("99/99/9999");
        jLabel3.setEnabled(false);
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(130, 10, 80, 20);

        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(117, 15, 13, 13);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton3.setEnabled(false);
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
        jButton3.setBounds(210, 7, 30, 29);

        jLabel4.setText("To");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(250, 15, 20, 14);

        jLabel5.setBackground(new java.awt.Color(255, 255, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("99/99/9999");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(270, 10, 80, 20);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
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
        jButton4.setBounds(350, 7, 30, 29);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 640, 80);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 0, 0), 1, true));
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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 100, 640, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
        	Cal X =new Cal();
        jLabel5.setText(X.getdate());
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        Cal X =new Cal();
        jLabel5.setText(X.getdate());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
        	Cal X =new Cal();
        jLabel3.setText(X.getdate());
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        Cal X =new Cal();
        jLabel3.setText(X.getdate());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
// TODO add your handling code here:
        if(jCheckBox1.isSelected())
        {
            jLabel3.setEnabled(true);
            jButton3.setEnabled(true);
        }
        else
        {
            jLabel3.setEnabled(false);
            jButton3.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton1.requestFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            dispose();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            dtm.setRowCount(0);
        	execution0();
        	if(dtm.getRowCount()==0)
        		javax.swing.JOptionPane.showMessageDialog(null,"No Record Found ?");
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
		dtm.setRowCount(0);
        execution0();
        if(dtm.getRowCount()==0)
        	javax.swing.JOptionPane.showMessageDialog(null,"No Record Found ?");
        	
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
     DefaultTableModel dtm;
     double wholeSellAmt=0;
    double wholePurAmt=0;
    int qtyAtSellTime=0;
    double amtAtSellTime=0;
    boolean flagForSellRateEqualsPurRate=false;
    String data[]=null;
    double costOfOneItem=0;
}
