/*
 * ListOfPurchaseing.java
 *
 * Created on May 15, 2010, 10:18 PM
 */

//package medretail;
import java.rmi.*;
/**
 *
 * @author  Deep Pal
 */
public class ListOfPurchaseing extends javax.swing.JInternalFrame {
    
    /** Creates new form ListOfPurchaseing */
    public ListOfPurchaseing(javax.swing.JDesktopPane jDesktopPane1) {
        initComponents();

        this.jDesktopPane1=jDesktopPane1;
        java.awt.Cursor cursor;
        cursor = new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR);
        
        jButton1.setCursor(cursor);
        jButton2.setCursor(cursor);
        jButton3.setCursor(cursor);
        jButton4.setCursor(cursor);
        jTable1.setCursor(cursor);
        
        //get system date
        //java.util.Date dt=new java.util.Date();
        //jTextField1.setText(dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
        java.util.Date dt11=new java.util.Date();
        jTextField1.setText(dt11.getDate()+"/"+(dt11.getMonth()+1)+"/"+(dt11.getYear()+1900));
        selectedDate=(dt11.getMonth()+1)+"/"+dt11.getDate()+"/"+(dt11.getYear()+1900);
        vc=new java.util.Vector();
        
        String heading[]={"S.No.","Party Name","Address","Book No.","Serial No.","Total Items","Net Amt."};
        dtm1=new javax.swing.table.DefaultTableModel(heading,0);
        jTable1.setModel(dtm1);
                javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
      		javax.swing.table.TableColumn column;

      		column=jTable1.getColumn("S.No.");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(30);

      		column=jTable1.getColumn("Party Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(150);

      		column=jTable1.getColumn("Address");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(150);
                
      		column=jTable1.getColumn("Book No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);
                
                column=jTable1.getColumn("Serial No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);

                column=jTable1.getColumn("Total Items");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(60);

                column=jTable1.getColumn("Net Amt.");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(80);

        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        reshape(((dm.width-800)/2)-75,(dm.height-400)/2,800,350);
        jDesktopPane1.add(this);
        setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Edit Purchase Bill :: Wizard 1/2");
        jLabel1.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel1.setText("Select date ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 90, 20);

        jTextField1.setEditable(false);
        jTextField1.setForeground(new java.awt.Color(0, 51, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        getContentPane().add(jTextField1);
        jTextField1.setBounds(80, 20, 90, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton1.setMnemonic('d');
        jButton1.setToolTipText("Change reporting date");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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
        jButton1.setBounds(180, 20, 23, 20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.gif")));
        jButton2.setMnemonic('s');
        jButton2.setText("Show");
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
        jButton2.setBounds(240, 20, 160, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton3.setMnemonic('c');
        jButton3.setText("Close");
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
        jButton3.setBounds(640, 20, 130, 30);

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
        });

        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 60, 750, 250);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/arrow.gif")));
        jButton4.setMnemonic('n');
        jButton4.setText("Next >>");
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
        jButton4.setBounds(410, 20, 140, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
                    this.dispose();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
                    callNextScrean();
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            setDataInTable();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
                    Cal X=new Cal();
                    jTextField1.setText(X.getdate());
                    selectedDate=X.getmonth()+"/"+X.getday()+"/"+X.getyear();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
// TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
                    callNextScrean();
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        callNextScrean();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        setDataInTable();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void setDataInTable()
    {
        try {
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs,rs1;*/
            int flag=0;
            //utilityClass uc=new utilityClass();
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
            
            while(dtm1.getRowCount()>0)     dtm1.removeRow(0);
            
            vc.removeAllElements();
            String qry="select partyNm,partyAds,bookNo,srNo,totalitems,netAmt,pNo from purchaseSmry where entryDt=#"+selectedDate+"# order by pNo";
            String[][] rs=inf.getResultSetAs_2D_Array(qry,7);
            if(rs!=null)
            for(int i=0;i<rs.length;i++) {
                flag=1;
                String arr[]=new String[7];
                arr[0]=""+(dtm1.getRowCount()+1)+". ";
                arr[1]=rs[i][0];
                arr[2]=rs[i][1];
                arr[3]=rs[i][2];
                arr[4]=rs[i][3];
                arr[5]=rs[i][4];
                arr[6]=rs[i][5];
                
                dtm1.addRow(arr);
                vc.addElement(rs[i][6]);
            }
            //connection.close();
            if(flag==0) {
                javax.swing.JOptionPane.showMessageDialog(this,"Oh!\nNo purchase bill found.","Information",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                jButton1.requestFocus();
            }
        } catch(Exception ex) {
            System.out.println("Error..783..."+ex);
        }        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        Cal X=new Cal();
        jTextField1.setText(X.getdate());
        selectedDate=X.getmonth()+"/"+X.getday()+"/"+X.getyear();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void callNextScrean()
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
        //utilityClass uc=new utilityClass();
        if(uc.isBlank(jTextField1.getText().trim()))
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect billing date.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jButton1.requestFocus();
        }
        else if(jTable1.getSelectedRow()<0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect a bill.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTable1.requestFocus();
        }
        else
        {
            int pno=Integer.parseInt(""+vc.elementAt(jTable1.getSelectedRow()));
            EditMakePurchase emp=new EditMakePurchase(jDesktopPane1,pno);
        }
        }
        catch(Exception e)
        {
        	System.out.println("Error...callNextScreen..."+e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    javax.swing.table.DefaultTableModel dtm1;
    String selectedDate;    
    java.util.Vector vc;
    javax.swing.JDesktopPane jDesktopPane1;
}
