/*
 * Choose_Tax_Sale_Invoice1.java
 *
 * Created on June 1, 2011, 4:02 PM
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
public class Choose_Tax_Sale_Invoice1 extends javax.swing.JInternalFrame {
    
    /** Creates new form Choose_Tax_Sale_Invoice1 */
    public Choose_Tax_Sale_Invoice1() {
        initComponents();
        dtm1=new DefaultTableModel(new String[] {"S.No.","Date","Patient ID","Against","Amount"},0);
        jTable1.setModel(dtm1);
        dtm2=new DefaultTableModel(new String[] {"S.No.","Date","Patient ID","Against","Amount"},0);
        jTable2.setModel(dtm2);
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
                column=jTable1.getColumn("Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(90);
                column=jTable1.getColumn("Patient ID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(70);
                column=jTable1.getColumn("Against");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(170);
                column=jTable1.getColumn("Amount");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(60);
                
                column=jTable2.getColumn("S.No.");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(35);
                column=jTable2.getColumn("Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(90);
                column=jTable2.getColumn("Patient ID");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(70);
                column=jTable2.getColumn("Against");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(170);
                column=jTable2.getColumn("Amount");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(60);
       		java.util.Date dt=new java.util.Date();
        String entrydate=(dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
        jLabel1.setText(entrydate);
       		setInitInfo();
    }
    private void setInitInfo()
    {
    	try
    	{
    		dtm1.setRowCount(0);
    		dtm2.setRowCount(0);
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
    		String query="";
    		query="select receiptDt,patientID,throughPaymentCome,amount from patient_All_Invoice where status=0";
    		if(jRadioButton2.isSelected())
    		{
    			String temp[]=jLabel1.getText().split("/");
    			String dt=temp[1]+"/"+temp[0]+"/"+temp[2];
    			query+=" and receiptDt=#"+dt+"#";
    		}
			String[][] rs=inf.getResultSetAs_2D_Array(query,4);
			if(rs!=null)
			{
				for(int i=0;i<rs.length;i++)
				{
					int id=Integer.parseInt(rs[i][1]);
					String checkIfAdmit=inf.getSingleValue("select patientID from patient_admit_Invoice_Temp where patientID="+id+" and status=0");
					if(checkIfAdmit!=null)
					{
						continue;
					}
					else
					{
						String data[]=new String[5];
						String dat[]=(rs[i][0]).split("-");
                		String dd[]=dat[2].split(" ");
                		String date=dd[0]+"/"+dat[1]+"/"+dat[0];
                		data[0]=""+(dtm1.getRowCount()+1)+".";
                		data[1]=date;
                		data[2]=rs[i][1];
                		data[3]=rs[i][2];
                		data[4]=""+(new java.math.BigDecimal(rs[i][3]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
                		dtm1.addRow(data);
					}
					
				}
			}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in setInitInfo of Choose_Tax_Sale_Invoice1 class....."+e);
    	}
    }
    private void setIndex1()
    {
    	for(int i=0;i<dtm1.getRowCount();i++)
    	{
    		dtm1.setValueAt(""+(i+1),i,0);
    	}
    }
    private void setIndex2()
    {
    	for(int i=0;i<dtm2.getRowCount();i++)
    	{
    		dtm2.setValueAt(""+(i+1),i,0);
    	}
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setBackground(new java.awt.Color(60, 220, 220));
        setClosable(true);
        setTitle("Declaring Invoice 1 : All Without Admit Patient");
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("All");
        jRadioButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton1.setOpaque(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jRadioButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton1KeyPressed(evt);
            }
        });

        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(20, 20, 80, 15);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Date Wise");
        jRadioButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jRadioButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jRadioButton2.setOpaque(false);
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jRadioButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jRadioButton2KeyPressed(evt);
            }
        });

        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(150, 20, 110, 15);

        jLabel1.setBackground(new java.awt.Color(153, 244, 51));
        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("99/99/9999");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 14, 130, 20);

        jButton1.setBackground(new java.awt.Color(204, 51, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton1.setToolTipText("Set Date");
        jButton1.setEnabled(false);
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
        jButton1.setBounds(380, 10, 30, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/system1.gif")));
        jButton2.setMnemonic('s');
        jButton2.setText("Show");
        jButton2.setToolTipText("Show Related Record");
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
        jButton2.setBounds(430, 10, 130, 30);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Existing List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153)));
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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 60, 290, 280);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tax Invoice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 153)));
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
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable2KeyReleased(evt);
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(410, 60, 290, 280);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton3.setMnemonic('c');
        jButton3.setText("Close");
        jButton3.setToolTipText("Close");
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
        jButton3.setBounds(580, 10, 110, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/forward.gif")));
        jButton4.setToolTipText("Send To Tax Invoice");
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
        jButton4.setBounds(320, 110, 47, 30);

        jButton5.setText("");
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/backward.gif")));
        jButton5.setToolTipText("Remove From Tax Invoice");
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
        jButton5.setBounds(320, 170, 45, 30);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.gif")));
        jButton6.setMnemonic('u');
        jButton6.setText("Update Only Tax Invoice");
        jButton6.setToolTipText("Update Only Tax Invoice");
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

        getContentPane().add(jButton6);
        jButton6.setBounds(10, 350, 340, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/createco.gif")));
        jButton7.setMnemonic('i');
        jButton7.setText("Update Tax Invoice & Remaining With Sale Invoice");
        jButton7.setToolTipText("Update Tax Invoice & Remaining With Sale Invoice");
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

        getContentPane().add(jButton7);
        jButton7.setBounds(360, 350, 340, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton1KeyPressed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButton1KeyPressed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
// TODO add your handling code here:
         if(jRadioButton2.isSelected())
        {
            jButton1.setEnabled(true);
        }
        else
        {
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
// TODO add your handling code here:
        if(jRadioButton2.isSelected())
        {
            jButton1.setEnabled(true);
        }
        else
        {
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jRadioButton2KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2KeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyReleased
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTable2KeyReleased

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTable2KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
// TODO add your handling code here:
        saveTaxInvoiceAndSaleInvoice();
    }//GEN-LAST:event_jButton7ActionPerformed
	private boolean saveTaxInvoiceAndSaleInvoice()
	{
		try
		{
			if(dtm1.getRowCount()<=0 && dtm2.getRowCount()<=0)
			{
				JOptionPane.showMessageDialog(null,"No List Found To Save","Error!!!",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else
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
				//update as sale invoice ----(table1)
				for(int i=0;i<dtm1.getRowCount();i++)
				{
					String query="update patient_All_Invoice set status=1 where patientID="+Integer.parseInt(""+jTable1.getValueAt(i,2))+" and status=0";
					inf.executeUpdateQuery(query);
				}
				//update as tax invoice ----(table2)
				for(int i=0;i<dtm2.getRowCount();i++)
				{
					String query="update patient_All_Invoice set status=2 where patientID="+Integer.parseInt(""+jTable2.getValueAt(i,2))+" and status=0";
					inf.executeUpdateQuery(query);
				}
			}
			JOptionPane.showMessageDialog(null,"Process successful.","Thanks !!!",JOptionPane.INFORMATION_MESSAGE);
			setInitInfo ();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error..SKM_R...."+e);
			return false;
		}
		
	}
    private void jButton7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton7KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            saveTaxInvoiceAndSaleInvoice();
        }
    }//GEN-LAST:event_jButton7KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
        saveOnlyTaxInvoice();
    }//GEN-LAST:event_jButton6ActionPerformed
	private boolean saveOnlyTaxInvoice()
	{
		try
		{
			if(dtm2.getRowCount()<=0)
			{
				JOptionPane.showMessageDialog(null,"No List Found To Save","Error!!!",JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else
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
				for(int i=0;i<dtm2.getRowCount();i++)
				{
					String query="update patient_All_Invoice set status=2 where patientID="+Integer.parseInt(""+jTable2.getValueAt(i,2))+" and status=0";
					inf.executeUpdateQuery(query);
				}
			}
			JOptionPane.showMessageDialog(null,"Process successful.","Thanks !!!",JOptionPane.INFORMATION_MESSAGE);
			setInitInfo ();
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Error..SKM_R...."+e);
			return false;
		}
		
	}
    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            saveOnlyTaxInvoice();
        }
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            sendDataToExisting();
        }
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        sendDataToExisting();
    }//GEN-LAST:event_jButton5ActionPerformed
	private void sendDataToExisting()
	{
		int r=jTable2.getSelectedRow();
		if(r>-1)
		{
		
		String data[]=new String[5];
		for(int j=0;j<5;j++)
		{
			data[j]=""+jTable2.getValueAt(r,j);
		}
		dtm1.addRow(data);
		dtm2.removeRow(r);
		setIndex1 ();
		setIndex2 ();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Please Select List To Send","Error!!!",JOptionPane.ERROR_MESSAGE);
		}
	}
    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            sendDataToTax();
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        sendDataToTax();
    }//GEN-LAST:event_jButton4ActionPerformed
	private void sendDataToTax()
	{
		int r=jTable1.getSelectedRow();
		if(r>-1)
		{
		String data[]=new String[5];
		for(int j=0;j<5;j++)
		{
			data[j]=""+jTable1.getValueAt(r,j);
		}
		dtm2.addRow(data);
		dtm1.removeRow(r);
		setIndex1 ();
		setIndex2 ();
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Please Select List To Send","Error!!!",JOptionPane.ERROR_MESSAGE);
		}
		/*int rowcount=jTable1.getSelectedRowCount();
		int rvalue[]=jTable1.getSelectedRows();
		for(int i=0;i<rowcount;i++)
		{
			String data[]=new String[5];
			for(int j=0;j<5;j++)
			{
				data[j]=""+jTable1.getValueAt(rvalue[i],j);
			}
			dtm2.addRow(data);
			
		}
		for(int i=0;i<rowcount;i++)
		{
			dtm1.removeRow(rvalue[i]);
			rvalue[i]-=1;
		}*/
	}
    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10){
            dispose();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10){
            setInitInfo();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
		setInitInfo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10){
            Cal calender=new Cal();
        jLabel1.setText(calender.getdate());
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        Cal calender=new Cal();
        jLabel1.setText(calender.getdate());
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel dtm1,dtm2;
}