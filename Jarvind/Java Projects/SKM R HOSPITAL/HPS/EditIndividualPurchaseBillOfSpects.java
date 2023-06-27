/*
 * MakingPurchaseOfSpects.java
 *
 * Created on May 28, 2011, 1:34 PM
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
public class EditIndividualPurchaseBillOfSpects extends javax.swing.JInternalFrame {
    
    /** Creates new form MakingPurchaseOfSpects */
    public EditIndividualPurchaseBillOfSpects(javax.swing.JDesktopPane jDesktopPane1,int pNo,String callFrom) {
    	System.out.println("Edit purchase of Spects");
        initComponents();
         this.pNo=pNo;
         System.out.println("pno....."+pNo);
        this.callFrom=callFrom;
        System.out.println("callfrom...."+callFrom);
     //   jDesktopPane1.add(this);
      //  setVisible(true);
        dtm=new DefaultTableModel(new String[] {"S.No.","GroupNm","CategoryNm","Particular","Related Company","Size_Lens_No","Qty","Rate","Amount"},0);
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
                column=jTable1.getColumn("GroupNm");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(60);
                column=jTable1.getColumn("CategoryNm");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);
                column=jTable1.getColumn("Particular");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(130);
                column=jTable1.getColumn("Related Company");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(110);
                column=jTable1.getColumn("Size_Lens_No");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(50);
                column=jTable1.getColumn("Qty");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(50);
                column=jTable1.getColumn("Rate");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(70);
                column=jTable1.getColumn("Amount");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(80);
                java.util.Date dt=new java.util.Date();
                jLabel5.setText(dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
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
    		String query="select partyNm from purchasePartyMaster order by partyNm";
        	String arr[]=inf.getResultSetAs_1D_Array(query);
        	//System.out.println("1.."+arr.length);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        		{
        			jComboBox1.addItem(arr[i]);
        		}
        	}
    		query="select gpNm from spectsGroupMaster order by gpNm";
        	arr=inf.getResultSetAs_1D_Array(query);
        	//System.out.println("1.."+arr.length);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        		{
        			jComboBox2.addItem(arr[i]);
        		}
        	}
        	query="select cmpName from spectsCmpMaster order by cmpName";
        	arr=inf.getResultSetAs_1D_Array(query);
        	//System.out.println("1.."+arr.length);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        		{
        			jComboBox5.addItem(arr[i]);
        		}
        	}
        	query="select payAS from purchase_Pay_As order by payAS";
        	arr=inf.getResultSetAs_1D_Array(query);
        	//System.out.println("1.."+arr.length);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        		{
        			jComboBox6.addItem(arr[i]);
        		}
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error..1..."+e);
    	}    
                jComboBox1.requestFocus();
                
                
        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        reshape((dm.width-800)/2,(dm.height-600)/2,740,472);        
        jDesktopPane1.add(this);
        setVisible(true);
        setInitialInfo();        
                
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
      //  jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        
        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem1.setText("Edit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        jPopupMenu1.add(jMenuItem1);

      /*  jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem2.setText("Delete");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        jPopupMenu1.add(jMenuItem2);*/

        getContentPane().setLayout(null);

        setBackground(new java.awt.Color(60, 220, 220));
        setClosable(true);
        setTitle("Purchase Window");
        jLabel1.setText("Enter Party Name ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 110, 20);

        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(120, 20, 210, 22);

        jLabel2.setText("Book No.");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 60, 20);

        jLabel3.setText("Serial No.");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 60, 70, 20);

        jLabel4.setText("Entry Date");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(490, 0, 70, 14);

        jLabel5.setBackground(new java.awt.Color(255, 255, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel5");
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(570, 0, 110, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton1.setToolTipText("Set Date");
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
        jButton1.setBounds(690, 0, 30, 25);

        jLabel6.setText("Address");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(360, 30, 70, 14);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(410, 30, 310, 50);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField1);
        jTextField1.setBounds(70, 60, 80, 19);

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField2);
        jTextField2.setBounds(230, 60, 100, 19);

        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 51), 1, true), "About Particular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204)));
        jLabel7.setText("Select Group");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 20, 100, 14);

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

        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(110, 20, 90, 22);

        jLabel8.setText("Select Category");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(210, 20, 90, 20);

        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox3KeyPressed(evt);
            }
        });

        jPanel1.add(jComboBox3);
        jComboBox3.setBounds(310, 20, 150, 22);

        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jComboBox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox4KeyPressed(evt);
            }
        });

        jPanel1.add(jComboBox4);
        jComboBox4.setBounds(550, 20, 150, 22);

        jComboBox5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox5KeyPressed(evt);
            }
        });

        jPanel1.add(jComboBox5);
        jComboBox5.setBounds(120, 50, 100, 22);

        jLabel9.setText("Select Item");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(470, 20, 80, 20);

        jLabel10.setText("Related Company");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 50, 110, 20);

        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(230, 50, 60, 20);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField3);
        jTextField3.setBounds(290, 50, 60, 19);

        jLabel12.setText("Qty");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(360, 50, 30, 20);

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField4);
        jTextField4.setBounds(400, 50, 60, 19);

        jLabel13.setText("Rate");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(470, 50, 40, 20);

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField5);
        jTextField5.setBounds(520, 50, 70, 19);

        jButton2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.jpg")));
        jButton2.setMnemonic('a');
        //jButton2.setText("Add");
        jButton2.setToolTipText("Add Item");
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
        jButton2.setBounds(610, 50, 30, 20);
        
        jButton6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.gif")));
        jButton6.setToolTipText("Edit Item");
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

        jPanel1.add(jButton6);
        jButton6.setBounds(660, 50, 30, 20);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
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
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        
       
        

        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 80, 690, 160);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 100, 710, 250);

        jLabel14.setText("Total Amount");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(450, 350, 110, 20);

        jLabel15.setBackground(new java.awt.Color(255, 153, 153));
        jLabel15.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("0.00");
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(560, 350, 150, 20);

        jPanel3.setLayout(null);

        jButton3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton3.setForeground(new java.awt.Color(0, 0, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.gif")));
        jButton3.setMnemonic('E');
        jButton3.setText("Edit");
        jButton3.setToolTipText("Edit");
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

        jPanel3.add(jButton3);
        jButton3.setBounds(80, 5, 130, 30);

        jButton4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton4.setForeground(new java.awt.Color(0, 0, 153));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reset.gif")));
        jButton4.setMnemonic('r');
        jButton4.setText("Refresh");
        jButton4.setToolTipText("Refresh");
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

        jPanel3.add(jButton4);
        jButton4.setBounds(290, 5, 130, 30);

        jButton5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton5.setForeground(new java.awt.Color(0, 0, 153));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton5.setMnemonic('c');
        jButton5.setText("Close");
        jButton5.setToolTipText("Close");
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

        jPanel3.add(jButton5);
        jButton5.setBounds(500, 5, 130, 30);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 390, 710, 40);

        jLabel16.setText("Payment As");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 360, 100, 14);

        jComboBox6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox6KeyPressed(evt);
            }
        });

        getContentPane().add(jComboBox6);
        jComboBox6.setBounds(90, 355, 150, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox6KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton1.requestFocus();
        }
    }//GEN-LAST:event_jComboBox6KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            Cal X =new Cal();
        	jLabel5.setText(X.getdate());
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
	reset();
    }//GEN-LAST:event_jButton4ActionPerformed
   
    
    
	private void reset()
	{
		java.util.Date dt=new java.util.Date();
        jLabel5.setText(dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
		jButton3.setEnabled(true);
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jTextField4.setText("");
		jTextField5.setText("");
		jTextArea1.setText("");
		dtm.setRowCount(0);
		jLabel15.setText("0.00");
	}
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
	save();
    }//GEN-LAST:event_jButton3ActionPerformed
	private boolean save()
	{
		try
		{
			if(jComboBox1.getSelectedItem()!=null || jComboBox2.getSelectedItem()!=null || jComboBox3.getSelectedItem()!=null || jComboBox4.getSelectedItem()!=null || jComboBox5.getSelectedItem()!=null)
			{
				if(jTextField1.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Book No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField1.requestFocus();
					return false;
				}
				if(jTextField2.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Serial No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField2.requestFocus();
					return false;
				}
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
			/*	String query="select max(pNo) from purchaseSmryOfSpects";
				int pno=inf.getMaxValue(query);
				pno+=1;*/
	
	
				int remaining=0,flag=0;
				boolean successful=false;
				
				String qry="Select itmCode,qty from purchaseDtlOfSpects where pNo="+pNo+"";
				String loadarr[][]=inf.getResultSetAs_2D_Array(qry,2);
				if(loadarr!=null)
				{
					for(int i=0;i<loadarr.length;i++)
					{
						System.out.println(i+"  "+loadarr[i][0]);
						System.out.println(i+"  "+loadarr[i][1]);
						
						qry="Select qty from spectsStockHolding where itmCode="+Integer.parseInt(loadarr[i][0])+"";
						String totQty=inf.getSingleValue(qry);
				//		System.out.println("qty    "+totQty);
						if(totQty!=null)
						{
							if(Integer.parseInt(totQty)>(Integer.parseInt(loadarr[i][1])))
							{
								remaining=Integer.parseInt(totQty)-(Integer.parseInt(loadarr[i][1]));
						//		System.out.println("remaining    "+remaining);
							
								qry="Update spectsStockHolding set qty="+remaining+" where itmCode="+Integer.parseInt(loadarr[i][0])+"";
								inf.executeUpdateQuery(qry);
									flag=1;
							}
												
						}
										
					}
				}
				if(flag==1)
				{
				qry="delete * from purchaseDtlOfSpects where pNo="+pNo+"";
				successful=inf.executeUpdateQuery(qry);
			//	System.out.println("successful "+successful);
	
				}
				
			if(successful==true)
				{
					String dt1[]=jLabel5.getText().split("/");
            	String entrydate=dt1[1]+"/"+dt1[0]+"/"+dt1[2];
            	String prtynm=""+jComboBox1.getSelectedItem();
            	System.out.println("prtynm   "+prtynm);
				String query="Update purchaseSmryOfSpects set partyNm='"+(""+jComboBox1.getSelectedItem())+"',partyAds='"+jTextArea1.getText()+"',bookNo='"+jTextField1.getText()+"',srNo='"+jTextField2.getText()+"',totalAmt="+Double.valueOf(jLabel15.getText())+",wholeTypeOfPay=='"+(""+jComboBox6.getSelectedItem())+"' where pNo="+pNo+"";
			//	System.out.println("query   "+query);
				successful=inf.executeUpdateQuery(query);
				System.out.println("successful inside   "+successful);
				query="Update purchasePaymentSmry set partyNm='"+(""+jComboBox1.getSelectedItem())+"',bookNo='"+jTextField1.getText()+"',srNo='"+jTextField2.getText()+"',purAmt="+Double.valueOf(jLabel15.getText())+",purDueAmt="+Double.valueOf(jLabel15.getText())+" where pNo="+pNo+"";
		//		System.out.println("query  "+query);
				inf.executeUpdateQuery(query) ;
			//	int quantity=0;
				for(int r=0;r<dtm.getRowCount();r++)
				{
					int gpcode=0;
					String temp=inf.getSingleValue("select gpCode from spectsGroupMaster where gpNm='"+""+jTable1.getValueAt(r,1)+"'");
					if(temp!=null)
						gpcode=Integer.parseInt(temp);
					int catcode=0;
					temp=inf.getSingleValue("select catCode from spectsCatMaster where catNm='"+""+jTable1.getValueAt(r,2)+"'");
					if(temp!=null)
						catcode=Integer.parseInt(temp);
					int itmcode=0;
					temp=inf.getSingleValue("select itmCode from spectsItemMaster where itmNm='"+""+jTable1.getValueAt(r,3)+"' and catCode="+catcode+"");
					if(temp!=null)
						itmcode=Integer.parseInt(temp);
						System.out.println("ITEMCode..................."+itmcode);
					int cmpcode=0;
					temp=inf.getSingleValue("select cmpCode from spectsCmpMaster where cmpName='"+""+jTable1.getValueAt(r,4)+"'");
					if(temp!=null)
						cmpcode=Integer.parseInt(temp);
					String size_lens=""+jTable1.getValueAt(r,5);
					int qty=Integer.parseInt(""+jTable1.getValueAt(r,6));
					double rate=Double.valueOf(""+jTable1.getValueAt(r,7));
					double amt=Double.valueOf(""+jTable1.getValueAt(r,8));
					
					
					/////////////////code updated here by S_CHK///////////////////////
			/*	query="Select qty from purchaseDtlOfSpects where  groupCode="+gpcode+" and catCode="+catcode+" and itmCode="+itmcode+" and cmpCode="+cmpcode+"";
				String getqty=inf.getSingleValue(query);
				System.out.println("getqty....."+getqty);
				if(getqty!=null)
				{
					quantity=Integer.parseInt(getqty);
				System.out.println("quantity...."+quantity);
				quantity +=qty;
				System.out.println("Total Quantity...."+quantity);

				query="update purchaseDtlOfSpects set qty="+quantity+" where  groupCode="+gpcode+" and catCode="+catcode+" and itmCode="+itmcode+" and cmpCode="+cmpcode+"";
				inf.executeUpdateQuery(query);
				System.out.println("Successful");
					
				}
				else
				{
					
						query="insert into purchaseDtlOfSpects values("+pno+","+gpcode+","+catcode+","+itmcode+","+cmpcode+",'"+size_lens+"',"+quantity+","+rate+","+amt+")";
					inf.executeUpdateQuery(query);
					
				}*///block here 
				
				int quanty=0;
					qry="Select qty from spectsStockHolding where cmpCode="+cmpcode+" and itmCode="+itmcode+" and size_lense_No='"+size_lens+"'";
					System.out.println("qry................"+qry);
					String quantity1=inf.getSingleValue(qry);
					System.out.println("quantity1    "+quantity1);
					
					if(quantity1!=null)
					{
						quanty=Integer.parseInt(quantity1);
						quanty=quanty+qty;
						qry="update spectsStockHolding set qty="+quanty+" where cmpCode="+cmpcode+" and itmCode="+itmcode+" and size_lense_No='"+size_lens+"'";
						System.out.println("update qry.............."+qry);
						inf.executeUpdateQuery(qry);
						System.out.println("database updated here ");
						
					}
					else
					{
						quanty=qty;
						qry="insert into spectsStockHolding values("+cmpcode+","+itmcode+",'"+size_lens+"',"+quanty+")";;
						System.out.println("insert qry.........."+qry);
						inf.executeUpdateQuery(qry);
						System.out.println("one row inserted here");
					}
					query="insert into purchaseDtlOfSpects values("+pNo+","+gpcode+","+catcode+","+itmcode+","+cmpcode+",'"+size_lens+"',"+qty+","+rate+","+amt+")";
					inf.executeUpdateQuery(query);
					
					
					
				}
	
	
				
			
				
				
									
				
					///////////////////////////////////////////////////////
					
					
					
					
				///	query="insert into purchaseDtlOfSpects values("+pno+","+gpcode+","+catcode+","+itmcode+","+cmpcode+",'"+size_lens+"',"+qty+","+rate+","+amt+")";
			///		inf.executeUpdateQuery(query);///block here
				}
				jButton3.setEnabled(false);
				javax.swing.JOptionPane.showMessageDialog(this,"Saving process completed, successfully.","Information",javax.swing.JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Error!\nYou have loss of data.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
				jComboBox1.requestFocus();
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error..in save...."+e);
			return false;
		}
	}
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:


	
      	
      	//	setUpdatedDataInTable(r);
      
     /* String getQty=""+jTable1.getValueAt(r,6);
      System.out.println("getQty   "+getQty);
      
      String Itmname=""+jTable1.getValueAt(r,3);
      System.out.println("itmname  "+Itmname);
      
      try
      {
      	try
      	{
      		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
      	}
      	catch(Exception e)
      	{
      		System.out.println("Error at the time of connection with server"+getIPaddress.IP());
      		getIPaddress.changeIP();
      		try
      		{
      			inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
      		}
      		catch(Exception ex)
      		{
      			System.out.println("Error at the time of connection with ip-rmi//127.0.0.1/ExtendedZedServer"+ex);
      		}
      	}
      	
      	String qry="Select itmCode from spectsItemMaster where itmNm='"+Itmname+"'";
      	String Itcode=inf.getSingleValue(qry);
      	System.out.println("Itcode  "+Itcode);
      	
      	qry="Select qty from spectsStockHolding where itmCode="+Integer.parseInt(Itcode)+"";
      	String qty=inf.getSingleValue(qry);
      	System.out.println("qty  "+qty);
      	int remaining=0;
      	int quantity=Integer.parseInt(qty);
      	if(quantity>(Integer.parseInt(getQty)))
      	{
      		
      		remaining=quantity-(Integer.parseInt(getQty));
      		System.out.println("remaining  "+remaining);
      	}
      	
      	
      	
      	qry="Update spectsStockHolding set qty="+remaining+" where itmCode="+Integer.parseInt(Itcode)+"";
      	inf.executeUpdateQuery(qry);
      	
      	
      	qry="delete * from purchaseDtlOfSpects where itmCode="+Integer.parseInt(Itcode)+" and pNo="+pNo+"";
      	inf.executeUpdateQuery(qry);*/
      	
      
      	
      	
     /* }
      catch(Exception e)
      {
      	System.out.println("Error....12");
      }*/
      
//	}
//	else
//	{
		setDataInTable();
//	}
     
      
      
      
      
    }//GEN-LAST:event_jButton2ActionPerformed
    
   private boolean setDataInTable()
	{
		try
		{
			if(jComboBox1.getSelectedItem()!=null || jComboBox2.getSelectedItem()!=null || jComboBox3.getSelectedItem()!=null || jComboBox4.getSelectedItem()!=null || jComboBox5.getSelectedItem()!=null)
			{
				if(jTextField1.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Book No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField1.requestFocus();
					return false;
				}
				if(jTextField2.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Serial No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField2.requestFocus();
					return false;
				}
				if(jTextField3.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter "+jLabel11.getText(),"Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField3.requestFocus();
					return false;
				}
				if(jTextField4.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField4.requestFocus();
					return false;
				}
				if(jTextField5.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Rate","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField5.requestFocus();
					return false;
				}
				int qty=0;
				try
				{
					qty=Integer.parseInt(jTextField4.getText());
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty (Numbers Only)","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField4.requestFocus();
					jTextField4.selectAll();
					return false;
				}
				double rate=0;
				try
				{
					rate=Double.valueOf(jTextField5.getText());
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Correct Rate","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField5.requestFocus();
					jTextField5.selectAll();
					return false;
				}
				String data[]=new String[9];
				data[0]=""+(dtm.getRowCount()+1)+".";
				data[1]=""+jComboBox2.getSelectedItem();
				data[2]=""+jComboBox3.getSelectedItem();
				data[3]=""+jComboBox4.getSelectedItem();
				data[4]=""+jComboBox5.getSelectedItem();
				data[5]=jTextField3.getText();
				data[6]=jTextField4.getText();
				data[7]=jTextField5.getText();
				double amt=qty*rate;
				data[8]=""+(new java.math.BigDecimal(amt)).setScale(2,5);
				dtm.addRow(data);
				jLabel15.setText(""+(new java.math.BigDecimal(getTotalAmount())).setScale(2,5));
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jComboBox2.requestFocus();
				
				
			
				
				
				return true;
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Error!\nYou have loss of data.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
				jComboBox1.requestFocus();
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error...add.."+e);
			return false;
		}
	} 
    
    
   private boolean setUpdatedDataInTable(int rowNo)
	{
		int row;
		row=rowNo;
		System.out.println("row no is  "+row);
		try
		{
			if(jComboBox1.getSelectedItem()!=null || jComboBox2.getSelectedItem()!=null || jComboBox3.getSelectedItem()!=null || jComboBox4.getSelectedItem()!=null || jComboBox5.getSelectedItem()!=null)
			{
				if(jTextField1.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Book No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField1.requestFocus();
					return false;
				}
				if(jTextField2.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Serial No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField2.requestFocus();
					return false;
				}
				if(jTextField3.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter "+jLabel11.getText(),"Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField3.requestFocus();
					return false;
				}
				if(jTextField4.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField4.requestFocus();
					return false;
				}
				if(jTextField5.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Rate","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField5.requestFocus();
					return false;
				}
				
				
				int qty=0;
				try
				{
					qty=Integer.parseInt(jTextField4.getText());
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty (Numbers Only)","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField4.requestFocus();
					jTextField4.selectAll();
					return false;
				}
				double rate=0;
				try
				{
					rate=Double.valueOf(jTextField5.getText());
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Correct Rate","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField5.requestFocus();
					jTextField5.selectAll();
					return false;
				}
				
				
				ZedInterface inf=null;
				try
				{
					inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				}
				catch(Exception e)
				{
					System.out.println("Error at the time of connection with server"+getIPaddress.IP()+e);
					getIPaddress.changeIP();
					try
					{
						inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
					}
					catch(Exception ex)
					{
						System.out.println("Error at the time of connection with ip-rmi://127.0.0.1/ExtendedZedServer"+ex);
					}
				}
				
									
				String data[]=new String[9];
				
				
					dtm.removeRow(row);
				int rwcnt=dtm.getRowCount();
				System.out.println("rwcnt  "+rwcnt);
				
		
				data[0]=""+(dtm.getRowCount()+1)+".";
				data[1]=""+jComboBox2.getSelectedItem();
				data[2]=""+jComboBox3.getSelectedItem();
				data[3]=""+jComboBox4.getSelectedItem();
				data[4]=""+jComboBox5.getSelectedItem();
				data[5]=jTextField3.getText();
				data[6]=jTextField4.getText();
				data[7]=jTextField5.getText();
				double amt=qty*rate;
				data[8]=""+(new java.math.BigDecimal(amt)).setScale(2,5);
				dtm.addRow(data);
				jLabel15.setText(""+(new java.math.BigDecimal(getTotalAmount())).setScale(2,5));
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jComboBox2.requestFocus();
				
				
				int rw=1,col=0;
				
				for(int i=0;i<=rwcnt;i++)
				{
					jTable1.setValueAt(""+rw,i,col);
					rw++;
				}
				
				return true;
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Error!\nYou have loss of data.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
				jComboBox1.requestFocus();
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error...add.."+e);
			return false;
		}
	}
    
    
    
    
    
/*	private boolean setDataInTable()
	{
		try
		{
			if(jComboBox1.getSelectedItem()!=null || jComboBox2.getSelectedItem()!=null || jComboBox3.getSelectedItem()!=null || jComboBox4.getSelectedItem()!=null || jComboBox5.getSelectedItem()!=null)
			{
				if(jTextField1.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Book No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField1.requestFocus();
					return false;
				}
				if(jTextField2.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Serial No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField2.requestFocus();
					return false;
				}
				if(jTextField3.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter "+jLabel11.getText(),"Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField3.requestFocus();
					return false;
				}
				if(jTextField4.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField4.requestFocus();
					return false;
				}
				if(jTextField5.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Rate","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField5.requestFocus();
					return false;
				}
				int qty=0;
				try
				{
					qty=Integer.parseInt(jTextField4.getText());
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty (Numbers Only)","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField4.requestFocus();
					jTextField4.selectAll();
					return false;
				}
				double rate=0;
				try
				{
					rate=Double.valueOf(jTextField5.getText());
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Correct Rate","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField5.requestFocus();
					jTextField5.selectAll();
					return false;
				}
				String data[]=new String[9];
				data[0]=""+(dtm.getRowCount()+1)+".";
				data[1]=""+jComboBox2.getSelectedItem();
				data[2]=""+jComboBox3.getSelectedItem();
				data[3]=""+jComboBox4.getSelectedItem();
				data[4]=""+jComboBox5.getSelectedItem();
				data[5]=jTextField3.getText();
				data[6]=jTextField4.getText();
				data[7]=jTextField5.getText();
				double amt=qty*rate;
				data[8]=""+(new java.math.BigDecimal(amt)).setScale(2,5);
				dtm.addRow(data);
				jLabel15.setText(""+(new java.math.BigDecimal(getTotalAmount())).setScale(2,5));
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jComboBox2.requestFocus();
				return true;
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Error!\nYou have loss of data.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
				jComboBox1.requestFocus();
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error...add.."+e);
			return false;
		}
	}*/
	
	private boolean setInitialInfo()
    {
    //	jTable1.setEnabled(false);
    	String loadarr[]=null;
    	int sNo=0;
    	ZedInterface inf=null;
    	try
    	{
    		try
    		{
    			inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
    		}
    		catch(Exception e)
    		{
    			System.out.println("Error at the time of connection with server"+getIPaddress.IP()+e);
    			getIPaddress.changeIP();
    			try
    			{
    				inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
    			}
    			catch(Exception ex)
    			{
    				System.out.println("Error at the time of connection with ip-rmi//127.0.0.1/ExtendedZedServer"+e);
    			}
    		}
    		
    		String qry="Select partyNm,partyAds,bookNo,srNo,totalAmt,entryDt from purchaseSmryOfSpects where pNo="+pNo+"";
    		System.out.println("qry   "+qry);
    		String arr[][]=inf.getResultSetAs_2D_Array(qry,6);
    		if(arr!=null && arr.length>0)
    		{
    			
    			for(int i=0;i<arr.length;i++)	
    			{
    				
    				System.out.println(i+" "+arr[i][0]);
    				jComboBox1.setSelectedItem(arr[i][0]);
    				System.out.println(i+" "+arr[i][1]);
    				jTextArea1.setText(arr[i][1]);
    				System.out.println(i+" "+arr[i][2]);
    				jTextField1.setText(arr[i][2]);
    				System.out.println(i+" "+arr[i][3]);
    				jTextField2.setText(arr[i][3]);
    				System.out.println(i+" "+arr[i][4]);
    				jLabel15.setText(arr[i][4]);
    				System.out.println(i+" "+arr[i][5]);
    			//	jLabel5.setText(arr[i][5]);
    			//	String gtdt=arr[i][5];
    				String getdt[]=arr[i][5].split("-");
    				System.out.println("0 "+getdt[0]);
    				System.out.println("1"+getdt[1]);
    				System.out.println("1"+getdt[2]);
    				String getdt1[]=getdt[2].split(" ");
    				System.out.println("0"+getdt1[0]);
    				
    				String setdate=getdt1[0]+"/"+getdt[1]+"/"+getdt[0];
    				System.out.println("setdate  "+setdate);
    				
    				jLabel5.setText(setdate);
    			
    			}
    		}
    		
    		qry="Select groupCode,catCode,itmCode,cmpCode,size_lens_No,qty,rate,amt from purchaseDtlOfSpects where pNo="+pNo+"";
    		System.out.println("qry..."+qry);
    		arr=inf.getResultSetAs_2D_Array(qry,8);
    		if(arr!=null && arr.length>0)
    		{
    			loadarr=new String[9];
    			for(int i=0;i<arr.length;i++)
    			{
    				int c=0;
    				System.out.println(i+" "+arr[i][c++]);
    				System.out.println(i+" "+arr[i][c++]);
    				System.out.println(i+" "+arr[i][c++]);
    				System.out.println(i+" "+arr[i][c++]);
    				System.out.println(i+" "+arr[i][c++]);
    				System.out.println(i+" "+arr[i][c++]);
    				System.out.println(i+" "+arr[i][c++]);
    				System.out.println(i+" "+arr[i][c++]);
    				
    				qry="Select gpNm from spectsGroupMaster where gpCode="+Integer.parseInt(arr[i][0])+"";
    				System.out.println("qry  "+qry);
    				String gpname=inf.getSingleValue(qry);
    				System.out.println("gpname "+gpname);
    				
    				qry="Select catNm from spectsCatMaster where catCode="+Integer.parseInt(arr[i][1])+"";
    				System.out.println("qry .."+qry);
    				String catname=inf.getSingleValue(qry);
    				System.out.println("catname  "+catname);
    				
    				qry="Select itmNm from spectsItemMaster where itmCode="+Integer.parseInt(arr[i][2])+"";
    				System.out.println("qry  "+qry);
    				String itemname=inf.getSingleValue(qry);
    				System.out.println("itemname  "+itemname);
    				
    				qry="Select cmpName from spectsCmpMaster where cmpCode="+Integer.parseInt(arr[i][3])+"";
    				System.out.println("qry "+qry);
    				String cmpname=inf.getSingleValue(qry);
    				System.out.println("cmpname  "+cmpname);
    				
    				loadarr[0]=""+(++sNo);
    				loadarr[1]=gpname;
    				loadarr[2]=catname;
    				loadarr[3]=itemname;
    				loadarr[4]=cmpname;
    				loadarr[5]=arr[i][4];
    				loadarr[6]=arr[i][5];
    				loadarr[7]=arr[i][6];
    				loadarr[8]=arr[i][7];
    				dtm.addRow(loadarr);
    				
    				
    				
    			}
    		}
    		
    		
    		
    		
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error..In setDataInTable Method.."+e);
    	}
    	return true;
    }
	
	private double getTotalAmount()
    {
        double totalAmt=0;
        //get total amount
        for(int i=0;i<dtm.getRowCount();i++)
        {
            totalAmt+=Double.valueOf(""+jTable1.getValueAt(i,8));
        }
        return totalAmt;
    }
    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {                                    
// TODO add your handling code here:
        //edit
    //    updateDataInTable();
    	
		 int r=jTable1.getSelectedRow();
      System.out.println("r no..."+r);
      if(r>=0)
      {
    
    setUpdatedDataInTable(r);
   	}
    }                                   

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
        //edit
      //  updateDataInTable();
      	
		 int r=jTable1.getSelectedRow();
      System.out.println("r no..."+r);
      if(r>=0)
      {
      
      	setUpdatedDataInTable(r);
      }
      else
      {
      	javax.swing.JOptionPane.showMessageDialog(this,"Error.!\nPlease select the row to edit record","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
      }
    }
   /* private boolean updateDataInTable()
	{
		System.out.println("this function is running......");
		try
		{
			if(jComboBox1.getSelectedItem()!=null || jComboBox2.getSelectedItem()!=null || jComboBox3.getSelectedItem()!=null || jComboBox4.getSelectedItem()!=null || jComboBox5.getSelectedItem()!=null)
			{
				if(jTextField1.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Book No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField1.requestFocus();
					return false;
				}
				if(jTextField2.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Serial No.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField2.requestFocus();
					return false;
				}
				if(jTextField3.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter "+jLabel11.getText(),"Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField3.requestFocus();
					return false;
				}
				if(jTextField4.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField4.requestFocus();
					return false;
				}
				if(jTextField5.getText().trim().equals(""))
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Rate","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField5.requestFocus();
					return false;
				}
				int qty=0;
				try
				{
					qty=Integer.parseInt(jTextField4.getText());
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Qty (Numbers Only)","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField4.requestFocus();
					jTextField4.selectAll();
					return false;
				}
				double rate=0;
				try
				{
					rate=Double.valueOf(jTextField5.getText());
				}
				catch(Exception e)
				{
					javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Enter Correct Rate","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
					jTextField5.requestFocus();
					jTextField5.selectAll();
					return false;
				}
				String data[]=new String[9];
				data[0]=""+(dtm.getRowCount()+1)+".";
				data[1]=""+jComboBox2.getSelectedItem();
				data[2]=""+jComboBox3.getSelectedItem();
				data[3]=""+jComboBox4.getSelectedItem();
				data[4]=""+jComboBox5.getSelectedItem();
				data[5]=jTextField3.getText();
				data[6]=jTextField4.getText();
				data[7]=jTextField5.getText();
				double amt=qty*rate;
				data[8]=""+(new java.math.BigDecimal(amt)).setScale(2,5);
				//dtm.addRow(data);
				int r=jTable1.getSelectedRow();
        		dtm.removeRow(r);
        		dtm.insertRow(r,data);
        		for(r=0;r<dtm.getRowCount();r++)
            	{
                	jTable1.setValueAt(""+(r+1)+". ",r,0);
            	}
				jLabel15.setText(""+(new java.math.BigDecimal(getTotalAmount())).setScale(2,5));
				jTextField3.setText("");
				jTextField4.setText("");
				jTextField5.setText("");
				jComboBox2.requestFocus();
				return true;
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(this,"Error!\nYou have loss of data.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
				jComboBox1.requestFocus();
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error...add.."+e);
			return false;
		}
	}*/
    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
// TODO add your handling code here:
        setItemNm();
    }//GEN-LAST:event_jComboBox3ActionPerformed
	private void setItemNm()
    {
    	
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
    		if(jComboBox3.getSelectedItem()!=null)
    		{
    			//System.out.println("1..");
    			if(jComboBox4!=null)
    				jComboBox4.removeAllItems();
    			//System.out.println("2..");
    			String query="select catCode from spectsCatMaster where catNm='"+""+jComboBox3.getSelectedItem()+"'";
    			//System.out.println("3..");
    			String cd=inf.getSingleValue(query);
    			//System.out.println("4..");
    			if(cd!=null)
    			{
    				int code=Integer.parseInt(cd);
    				//System.out.println("5..");
    				query="select itmNm from spectsItemMaster where catCode="+code+" order by itmNm ";
        			String arr[]=inf.getResultSetAs_1D_Array(query);
        			//System.out.println("length.."+arr.length);
        			if(arr!=null)
        			{
        				for(int i=0;i<arr.length;i++)
        				{
        					//System.out.println("2..");
        					jComboBox4.addItem(arr[i]);
        				}
        			}
        		}
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error..3..."+e);
    	}
    }
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
// TODO add your handling code here:
		String gpNm=""+jComboBox2.getSelectedItem();
		if(gpNm!=null)
		{
			if(gpNm.equalsIgnoreCase("Frame"))
			{
				jLabel11.setText("Size");
			}
			else if(gpNm.equalsIgnoreCase("Glass"))
			{
				jLabel11.setText("Lens No.");
			}
		}
		setCategory();
    }//GEN-LAST:event_jComboBox2ActionPerformed
	private void setCategory()
    {
    	
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
    		if(jComboBox2.getSelectedItem()!=null)
    		{
    			//System.out.println("1..");
    			if(jComboBox3!=null)
    				jComboBox3.removeAllItems();
    			//System.out.println("2..");
    			String query="select gpCode from spectsGroupMaster where gpNm='"+""+jComboBox2.getSelectedItem()+"'";
    			//System.out.println("3..");
    			String cd=inf.getSingleValue(query);
    			//System.out.println("4..");
    			if(cd!=null)
    			{
    				int code=Integer.parseInt(cd);
    				//System.out.println("5..");
    				query="select catNm from spectsCatMaster where gpCode="+code+" order by catNm ";
        			String arr[]=inf.getResultSetAs_1D_Array(query);
        			//System.out.println("length.."+arr.length);
        			if(arr!=null)
        			{
        				for(int i=0;i<arr.length;i++)
        				{
        					//System.out.println("2..");
        					jComboBox3.addItem(arr[i]);
        				}
        			}
        		}
        	}
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error..2..."+e);
    	}
    }
    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            dispose();
        }
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            reset();
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            save();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
//            setDataInTable();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton2.requestFocus();
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField5.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jComboBox5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jComboBox5KeyPressed

    private void jComboBox4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox5.requestFocus();
        }
    }//GEN-LAST:event_jComboBox4KeyPressed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox4.requestFocus();
        }
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox3.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)    
        {
            if(jTextArea1.getText().trim().equals(""))
            {
                jTextArea1.setText("");//jTextArea1.getText().substring(0,jTextArea1.getText().length()-1));
                jTextField1.requestFocus();
            }
            else if((jTextArea1.getText().substring(jTextArea1.getText().length()-1,jTextArea1.getText().length())).equals("\n"))
            {
                jTextArea1.setText(jTextArea1.getText().substring(0,jTextArea1.getText().length()-1));
                jTextField1.requestFocus();
            }
        }
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
// TODO add your handling code here:
        if(evt.getModifiers()==4)
        {
            int r=jTable1.getSelectedRow();
            System.out.println("r no....."+r);
           /* if(r>=0)
            {
                jMenuItem1.setEnabled(true);
                jMenuItem2.setEnabled(true);
            }
            else
            {
                jMenuItem1.setEnabled(false);
                jMenuItem2.setEnabled(false);                
            }*/
            jPopupMenu1.show(jTable1,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_jTable1MouseClicked
	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt)
	{
		int r=jTable1.getSelectedRow();
		jComboBox2.setSelectedItem(jTable1.getValueAt(r,1).toString());
		jComboBox3.setSelectedItem(jTable1.getValueAt(r,2).toString());
		jComboBox4.setSelectedItem(jTable1.getValueAt(r,3).toString());
		jComboBox5.setSelectedItem(jTable1.getValueAt(r,4).toString());
		
		jTextField3.setText(jTable1.getValueAt(r,5).toString());
		jTextField4.setText(jTable1.getValueAt(r,6).toString());
		jTextField5.setText(jTable1.getValueAt(r,7).toString());
	}
	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
        int cnfrm=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure?","Confirmation",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
        if(cnfrm==javax.swing.JOptionPane.YES_OPTION)
        {
            dtm.removeRow(jTable1.getSelectedRow());
            for(int r=0;r<dtm.getRowCount();r++)
            {
                jTable1.setValueAt(""+(r+1)+". ",r,0);
            }
            jLabel15.setText(""+(new java.math.BigDecimal(getTotalAmount())).setScale(2,5));
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        Cal X =new Cal();
        jLabel5.setText(X.getdate());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
// TODO add your handling code here:
         if(evt.getKeyCode()==10)
         {
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
                	String query="select ads from purchasePartyMaster where partyNm='"+""+jComboBox1.getSelectedItem()+"'";
                	//utilityClass ut=new utilityClass();
                	String ads=uc.returnSingleData(query);
                	jTextArea1.setText(ads);
                	jTextArea1.requestFocus();
                }
                catch(Exception e)
                {
                	System.out.println("Errr..."+e);
                }
         }
        
    }//GEN-LAST:event_jComboBox1KeyPressed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPopupMenu jPopupMenu1;
        private javax.swing.JMenuItem jMenuItem1;
    //	private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
    
    int pNo;
    String callFrom;
    ZedInterface inf;
    DefaultTableModel dtm;
}
