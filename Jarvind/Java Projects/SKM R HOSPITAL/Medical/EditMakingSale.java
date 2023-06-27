/*
 * MakingSale.java
 *
 * Created on May 1, 2010, 9:34 AM
 */

//package medretail;
import java.rmi.*;
/**
 *
 * @author  Deep Pal
 */
public class EditMakingSale extends javax.swing.JInternalFrame {
    
    /** Creates new form MakingSale */
    public EditMakingSale(javax.swing.JDesktopPane jDesktopPane1,int sNo) {
        initComponents();
        this.sNo=sNo;
        java.awt.Cursor cursor;
        cursor = new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR);
        
        jButton1.setCursor(cursor);
        jButton2.setCursor(cursor);
        jButton3.setCursor(cursor);
        //jButton4.setCursor(cursor);
        jButton5.setCursor(cursor);
        jButton7.setCursor(cursor);
        jList1.setCursor(cursor);
        jList2.setCursor(cursor);
        jTextField4.setCursor(cursor);
        jTextField5.setCursor(cursor);
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
        String coNm[]=uc.getCmpNames();
        coNmVc=new java.util.Vector();
        for(int i=1;i<coNm.length;i++)
        {
            coNmVc.addElement(coNm[i]);
        }
        jList1.setListData(coNmVc);
        jPanel1.setVisible(false);
        
        
        itemNmVc=new java.util.Vector();
        jList2.setListData(itemNmVc);
        jPanel2.setVisible(false);
        
        batchNoVc=new java.util.Vector();
        jList3.setListData(batchNoVc);
        jPanel3.setVisible(false);
        
        
        String heading[]={"S.No.","Company Name","Batch No.","Exp. Date","Particular","Qty.","","Rate (Rs.)","Amount (Rs.)"};
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

      		column=jTable1.getColumn("Company Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(200);

      		column=jTable1.getColumn("Batch No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(100);
                
      		column=jTable1.getColumn("Exp. Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);
                
                column=jTable1.getColumn("Particular");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(200);

      		column=jTable1.getColumn("Qty.");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(60);
                
                column=jTable1.getColumn("Rate (Rs.)");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);

                column=jTable1.getColumn("Amount (Rs.)");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);

      		
        
        java.util.Date dt=new java.util.Date();
        String entrydate=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);
        jLabel35.setText(entrydate);
        
        jLabel33.setText(""+uc.getSaleNo());
        setExistingData();
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        reshape((dm.width-800)/2,(dm.height-600)/2,790,500);
        jDesktopPane1.add(this);
        setVisible(true);
    }
    private void setExistingData()
    {
        try
        {
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs;*/
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
            
            String qry="select sNo,entrydt,totalitems,dispc,taxpc,totalAmt,disAmt,taxAmt,payAmt,netAmt from saleSmry where sNo="+sNo;
            String [][]rs=inf.getResultSetAs_2D_Array(qry,10);
            if(rs!=null)
            //if(rs.next())
            {
                jLabel33.setText(rs[0][0]);
                String dat[]=rs[0][1].split("-");
                String dd[]=dat[2].split(" ");
                String date=dd[0]+"/"+dat[1]+"/"+dat[0];
                //java.util.Date billDate=rs.getDate("entrydt");
                //jLabel35.setText(billDate.getDate()+"/"+(billDate.getMonth()+1)+"/"+(billDate.getYear()+1900));
                jLabel35.setText(date);
                jLabel37.setText(rs[0][2]);
                jTextField6.setText(rs[0][3]);
                jTextField13.setText(rs[0][4]);
                jLabel10.setText(rs[0][5]);
                jLabel27.setText(rs[0][6]);
                jLabel29.setText(rs[0][7]);
                jLabel31.setText(rs[0][8]);
                jLabel39.setText(rs[0][9]);
                
                qry="select * from saleDtl where sNo="+sNo;
                //rs=st.executeQuery(qry);
                String rr[][]=inf.getResultSetAs_2D_Array(qry,9);
                if(rr!=null)
                for(int i1=0;i1<rr.length;i1++)
                {
                    String arr[]=new String[9];
                    arr[0]=(dtm1.getRowCount()+1)+". ";
                    for(int i=1;i<=8;i++)
                    {
                        arr[i]=rr[i1][i];
                    }
                    arr[3]=arr[3].substring(8,10)+"/"+arr[3].substring(5,7)+"/"+arr[3].substring(0,4);
                    dtm1.addRow(arr);
                }
            }
           // connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...291..."+ex);
        }
        initialRowCount=jTable1.getRowCount();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jMenuItem1.setMnemonic('u');
        jMenuItem1.setText("Update");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setMnemonic('d');
        jMenuItem2.setText("Delete");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        jPopupMenu1.add(jMenuItem2);

        getContentPane().setLayout(null);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Edit Sale Bill :: Wizard 2/2");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jList3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList3MouseClicked(evt);
            }
        });

        jScrollPane4.setViewportView(jList3);

        jPanel3.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(400, 120, 100, 180);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jList1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jList1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jList1FocusLost(evt);
            }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(jList1);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(100, 80, 250, 220);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jList2MouseEntered(evt);
            }
        });

        jScrollPane3.setViewportView(jList2);

        jPanel2.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(480, 80, 290, 170);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel1.setText("Company Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 60, 86, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel2.setText("Select Item Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 60, 96, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel3.setText("Quantity");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 100, 45, 20);

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField1);
        jTextField1.setBounds(60, 100, 50, 19);

        jLabel4.setBackground(new java.awt.Color(254, 254, 241));
        jLabel4.setFont(new java.awt.Font("Arial", 2, 11));
        jLabel4.setForeground(new java.awt.Color(255, 51, 0));
        jLabel4.setText("Tab");
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 100, 60, 20);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel5.setText("Rate (Rs.)");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 100, 52, 20);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField2);
        jTextField2.setBounds(240, 100, 70, 19);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel6.setText("Batch No.");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(360, 100, 50, 20);

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField3FocusGained(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        getContentPane().add(jTextField3);
        jTextField3.setBounds(410, 100, 80, 19);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.jpg")));
        jButton1.setToolTipText("Click here to add record");
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
        jButton1.setBounds(680, 90, 30, 30);

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
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 750, 170);

        jTextField4.setEnabled(false);
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });

        getContentPane().add(jTextField4);
        jTextField4.setBounds(100, 60, 250, 19);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });

        getContentPane().add(jTextField5);
        jTextField5.setBounds(480, 60, 290, 19);

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 10));
        getContentPane().add(jLabel7);
        jLabel7.setBounds(314, 100, 40, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel8.setText("Exp. Date");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(520, 100, 60, 20);

        jLabel9.setBackground(new java.awt.Color(234, 234, 251));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("12/12/2009");
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(580, 100, 70, 20);

        jLabel10.setBackground(new java.awt.Color(255, 255, 204));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("0.00");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(660, 320, 110, 20);

        jLabel11.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel11.setText("Total Amount (In Rs.)");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(490, 320, 150, 20);

        jLabel12.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Discount(In %)");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(160, 320, 110, 20);

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField6);
        jTextField6.setBounds(250, 320, 40, 19);

        jInternalFrame1.getContentPane().setLayout(null);

        jInternalFrame1.setOpaque(true);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jList4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList4MouseClicked(evt);
            }
        });

        jScrollPane5.setViewportView(jList4);

        jPanel4.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jInternalFrame1.getContentPane().add(jPanel4);
        jPanel4.setBounds(400, 70, 100, 180);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jList5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jList5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jList5FocusLost(evt);
            }
        });
        jList5.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList5ValueChanged(evt);
            }
        });
        jList5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList5MouseClicked(evt);
            }
        });

        jScrollPane6.setViewportView(jList5);

        jPanel5.add(jScrollPane6, java.awt.BorderLayout.CENTER);

        jInternalFrame1.getContentPane().add(jPanel5);
        jPanel5.setBounds(100, 30, 240, 220);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jList6.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList6ValueChanged(evt);
            }
        });
        jList6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jList6MouseEntered(evt);
            }
        });

        jScrollPane7.setViewportView(jList6);

        jPanel6.add(jScrollPane7, java.awt.BorderLayout.CENTER);

        jInternalFrame1.getContentPane().add(jPanel6);
        jPanel6.setBounds(500, 30, 240, 220);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel13.setText("Company Name");
        jInternalFrame1.getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 10, 86, 20);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel14.setText("Select Item Name");
        jInternalFrame1.getContentPane().add(jLabel14);
        jLabel14.setBounds(400, 10, 96, 20);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel15.setText("Quantity");
        jInternalFrame1.getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 50, 45, 20);

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jTextField7);
        jTextField7.setBounds(60, 50, 50, 19);

        jLabel16.setBackground(new java.awt.Color(254, 254, 241));
        jLabel16.setFont(new java.awt.Font("Arial", 2, 11));
        jLabel16.setForeground(new java.awt.Color(255, 51, 0));
        jLabel16.setText("Tab");
        jLabel16.setOpaque(true);
        jInternalFrame1.getContentPane().add(jLabel16);
        jLabel16.setBounds(110, 50, 60, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel17.setText("Rate (Rs.)");
        jInternalFrame1.getContentPane().add(jLabel17);
        jLabel17.setBounds(180, 50, 52, 20);

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jInternalFrame1.getContentPane().add(jTextField8);
        jTextField8.setBounds(240, 50, 70, 19);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel18.setText("Batch No.");
        jInternalFrame1.getContentPane().add(jLabel18);
        jLabel18.setBounds(350, 50, 60, 20);

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField9FocusGained(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jTextField9);
        jTextField9.setBounds(410, 50, 80, 19);

        jButton2.setText("Add In List");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jButton2);
        jButton2.setBounds(670, 50, 100, 23);

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
        jScrollPane8.setViewportView(jTable2);

        jInternalFrame1.getContentPane().add(jScrollPane8);
        jScrollPane8.setBounds(20, 90, 750, 170);

        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField10FocusLost(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jTextField10);
        jTextField10.setBounds(100, 10, 240, 19);

        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField11FocusLost(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField11KeyReleased(evt);
            }
        });

        jInternalFrame1.getContentPane().add(jTextField11);
        jTextField11.setBounds(500, 10, 240, 19);

        jInternalFrame1.getContentPane().add(jLabel19);
        jLabel19.setBounds(320, 50, 34, 20);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel20.setText("Exp. Date");
        jInternalFrame1.getContentPane().add(jLabel20);
        jLabel20.setBounds(520, 50, 60, 20);

        jLabel21.setBackground(new java.awt.Color(234, 234, 251));
        jLabel21.setFont(new java.awt.Font("Arial", 0, 10));
        jLabel21.setForeground(new java.awt.Color(255, 51, 51));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("12/12/2009");
        jLabel21.setOpaque(true);
        jInternalFrame1.getContentPane().add(jLabel21);
        jLabel21.setBounds(580, 50, 80, 20);

        jLabel22.setBackground(new java.awt.Color(255, 255, 204));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("0.00");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel22.setOpaque(true);
        jInternalFrame1.getContentPane().add(jLabel22);
        jLabel22.setBounds(660, 270, 110, 20);

        jLabel23.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel23.setText("Total Amount (In Rs.)");
        jInternalFrame1.getContentPane().add(jLabel23);
        jLabel23.setBounds(520, 270, 120, 20);

        jLabel24.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel24.setText("Discount(In %)");
        jInternalFrame1.getContentPane().add(jLabel24);
        jLabel24.setBounds(20, 300, 110, 20);

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jInternalFrame1.getContentPane().add(jTextField12);
        jTextField12.setBounds(110, 300, 40, 19);

        getContentPane().add(jInternalFrame1);
        jInternalFrame1.setBounds(160, 50, 22, 39);

        jLabel25.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel25.setForeground(new java.awt.Color(0, 0, 204));
        jLabel25.setText("Any Tax (In %)");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(340, 320, 90, 20);

        jTextField13.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField13KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField13);
        jTextField13.setBounds(430, 320, 40, 19);

        jLabel26.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel26.setText("Discount Amount (In Rs.)");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(490, 350, 150, 20);

        jLabel27.setBackground(new java.awt.Color(255, 255, 204));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("0.00");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel27.setOpaque(true);
        getContentPane().add(jLabel27);
        jLabel27.setBounds(660, 350, 110, 20);

        jLabel28.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel28.setText("Tax Amount (In Rs.)");
        getContentPane().add(jLabel28);
        jLabel28.setBounds(490, 380, 150, 20);

        jLabel29.setBackground(new java.awt.Color(255, 255, 204));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("0.00");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel29.setOpaque(true);
        getContentPane().add(jLabel29);
        jLabel29.setBounds(660, 380, 110, 20);

        jLabel30.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel30.setText("Payble Amount (In Rs.)");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(490, 410, 150, 20);

        jLabel31.setBackground(new java.awt.Color(255, 255, 204));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("0.00");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel31.setOpaque(true);
        getContentPane().add(jLabel31);
        jLabel31.setBounds(660, 410, 110, 20);

        jLabel32.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel32.setText("Bill No.");
        getContentPane().add(jLabel32);
        jLabel32.setBounds(10, 10, 40, 20);

        jLabel33.setBackground(new java.awt.Color(255, 255, 204));
        jLabel33.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel33.setForeground(new java.awt.Color(0, 102, 102));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel33.setOpaque(true);
        getContentPane().add(jLabel33);
        jLabel33.setBounds(50, 10, 110, 20);

        jLabel34.setFont(new java.awt.Font("Arial", 0, 11));
        jLabel34.setText("Date");
        getContentPane().add(jLabel34);
        jLabel34.setBounds(560, 10, 40, 20);

        jLabel35.setBackground(new java.awt.Color(255, 255, 204));
        jLabel35.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel35.setForeground(new java.awt.Color(0, 102, 102));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel35.setOpaque(true);
        getContentPane().add(jLabel35);
        jLabel35.setBounds(600, 10, 120, 20);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.gif")));
        jButton3.setMnemonic('u');
        jButton3.setText("Update Sale");
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
        jButton3.setBounds(20, 390, 160, 70);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton5.setMnemonic('c');
        jButton5.setText("Close");
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
        jButton5.setBounds(190, 390, 230, 70);

        jLabel36.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel36.setText("Total Items");
        getContentPane().add(jLabel36);
        jLabel36.setBounds(20, 320, 70, 20);

        jLabel37.setBackground(new java.awt.Color(204, 255, 204));
        jLabel37.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("0");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel37.setOpaque(true);
        getContentPane().add(jLabel37);
        jLabel37.setBounds(90, 320, 50, 20);

        jLabel38.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 10));
        jLabel38.setText("Net Amount (In Rs.)");
        getContentPane().add(jLabel38);
        jLabel38.setBounds(490, 440, 150, 20);

        jLabel39.setBackground(new java.awt.Color(255, 255, 204));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel39.setText("0.00");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel39.setOpaque(true);
        getContentPane().add(jLabel39);
        jLabel39.setBounds(660, 440, 110, 20);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.gif")));
        jButton6.setToolTipText("Click here to update record");
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
        jButton6.setBounds(730, 90, 30, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton7.setToolTipText("Click here to change date");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton7);
        jButton7.setBounds(730, 10, 20, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
// TODO add your handling code here:
        jTextField5.requestFocus();
    }//GEN-LAST:event_formInternalFrameActivated

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
// TODO add your handling code here:
        Cal calender=new Cal();
        jLabel35.setText(calender.getdate());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
// TODO add your handling code here:
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
// TODO add your handling code here:
        //jPanel1.setVisible(true);
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            takePreviousDataAndSaveIntoDB();
            if(saveRecords()==0)
            {
                /*clearFullComponents();
                utilityClass uc=new utilityClass();
                jLabel33.setText(""+uc.getSaleNo());*/
            }
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            this.dispose();
        }
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
        int flag=0;
        try
        {
        	
        
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

        if(uc.isBlank(jTextField5.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter item name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField1.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField2.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter rate of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField3.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter batch number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
            flag=1;
        }
        else if(uc.isInteger(jTextField1.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isDouble(jTextField2.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in rate.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else        //checking stock of item
        {
            try
            {
             int cmpCode=0,itemCode=0,stockQty=0,qty1;  
             int qty=Integer.parseInt(jTextField1.getText());
             qty1=Integer.parseInt(jTextField1.getText());
             int tableQty=takingStockFromJTableForUpdate();
             qty+=tableQty;
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;
            java.sql.Statement st=connection.createStatement();*/
            
            /*rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt(1);
            }
            rs=st.executeQuery("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(rs.next())
            {
                itemCode=rs.getInt(1);
            }
            rs=st.executeQuery("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(rs.next())
            {
                stockQty=rs.getInt(1);
            }*/
            //ZedInterface inf1=(ZedInterface)Naming.lookup(getIPaddress.IP());
            String cmpC=inf.getSingleValue("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(cmpC!=null)
            	cmpCode=Integer.parseInt(cmpC);
            /*rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt(1);
            }*/
            String itemC=inf.getSingleValue("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(itemC!=null)
            	itemCode=Integer.parseInt(itemC);
            /*rs=st.executeQuery("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(rs.next())
            {
                itemCode=rs.getInt(1);
            }*/
            String stockQ=inf.getSingleValue("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(stockQ!=null)
            	stockQty=Integer.parseInt(stockQ);
            int indexOfSelectedRow=jTable1.getSelectedRow();
            if(jTextField4.getText().equalsIgnoreCase(""+jTable1.getValueAt(indexOfSelectedRow,1)))
            {
                if(jTextField5.getText().equalsIgnoreCase(""+jTable1.getValueAt(indexOfSelectedRow,4)))
                {
                    if(jTextField3.getText().equalsIgnoreCase(""+jTable1.getValueAt(indexOfSelectedRow,2)))
                    {
                        int selectedRowQty=Integer.parseInt(""+jTable1.getValueAt(indexOfSelectedRow,5));
                        
                        int stockOfSell=stockOfSell(""+jTable1.getValueAt(indexOfSelectedRow,1),""+jTable1.getValueAt(indexOfSelectedRow,2),""+jTable1.getValueAt(indexOfSelectedRow,4));
                        stockQty+=stockOfSell;
                        if(qty1<=selectedRowQty)
                        {
                            qty=-1;
                        }
                    }
                }
            }
            
            if(stockQty<qty)
            {
                int tempQty=(stockQty-tableQty);
                System.out.println("tempQty="+tempQty);
                javax.swing.JOptionPane.showMessageDialog(null,"You have "+tempQty+" "+jLabel4.getText()+" only.","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField1.setText(""+tempQty);
                //jTextField1.setText(""+stockQty);
                flag=1;
            }    
            }
            catch(Exception e)
            {
                System.out.println("Error..."+e);
            }
        }
        if(flag==0)
            updateRecordInTable();
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        }
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
        int flag=0;
        try
        {
        	
        
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

        if(uc.isBlank(jTextField5.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter item name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField1.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField2.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter rate of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField3.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter batch number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
            flag=1;
        }
        else if(uc.isInteger(jTextField1.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isDouble(jTextField2.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in rate.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else        //checking stock of item
        {
            try
            {
             int cmpCode=0,itemCode=0,stockQty=0,qty1;  
             int qty=Integer.parseInt(jTextField1.getText());
             qty1=Integer.parseInt(jTextField1.getText());
             int tableQty=takingStockFromJTableForUpdate();
             qty+=tableQty;
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;
            java.sql.Statement st=connection.createStatement();*/
            
            /*rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt(1);
            }
            rs=st.executeQuery("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(rs.next())
            {
                itemCode=rs.getInt(1);
            }
            rs=st.executeQuery("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(rs.next())
            {
                stockQty=rs.getInt(1);
            }*/
            //ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
            String cmpC=inf.getSingleValue("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(cmpC!=null)
            	cmpCode=Integer.parseInt(cmpC);
            /*rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt(1);
            }*/
            String itemC=inf.getSingleValue("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(itemC!=null)
            	itemCode=Integer.parseInt(itemC);
            /*rs=st.executeQuery("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(rs.next())
            {
                itemCode=rs.getInt(1);
            }*/
            String stockQ=inf.getSingleValue("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(stockQ!=null)
            	stockQty=Integer.parseInt(stockQ);
            int indexOfSelectedRow=jTable1.getSelectedRow();
            if(jTextField4.getText().equalsIgnoreCase(""+jTable1.getValueAt(indexOfSelectedRow,1)))
            {
                if(jTextField5.getText().equalsIgnoreCase(""+jTable1.getValueAt(indexOfSelectedRow,4)))
                {
                    if(jTextField3.getText().equalsIgnoreCase(""+jTable1.getValueAt(indexOfSelectedRow,2)))
                    {
                        int selectedRowQty=Integer.parseInt(""+jTable1.getValueAt(indexOfSelectedRow,5));
                        
                        int stockOfSell=stockOfSell(""+jTable1.getValueAt(indexOfSelectedRow,1),""+jTable1.getValueAt(indexOfSelectedRow,2),""+jTable1.getValueAt(indexOfSelectedRow,4));
                        stockQty+=stockOfSell;
                        if(qty1<=selectedRowQty)
                        {
                            qty=-1;
                        }
                    }
                }
            }
            
            if(stockQty<qty)
            {
                int tempQty=(stockQty-tableQty);
                System.out.println("tempQty="+tempQty);
                javax.swing.JOptionPane.showMessageDialog(null,"You have "+tempQty+" "+jLabel4.getText()+" only.","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField1.setText(""+tempQty);
                //jTextField1.setText(""+stockQty);
                flag=1;
            }    
            }
            catch(Exception e)
            {
                System.out.println("Error..."+e);
            }
        }
        if(flag==0)
            updateRecordInTable();
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        
    }//GEN-LAST:event_jButton6ActionPerformed
    private int stockOfSell(String company,String batch,String itemName)
    {
        int qty=0;
        try
        {
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;
            java.sql.Statement st=connection.createStatement();*/
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
            //rs=st.executeQuery("select qty from saleDtl where coNm='"+company+"' and batchNo='"+batch+"' and itemNm='"+itemName+"'");
            String qt[]=inf.getResultSetAs_1D_Array("select qty from saleDtl where coNm='"+company+"' and batchNo='"+batch+"' and itemNm='"+itemName+"'");
            if(qt!=null)
            for(int i=0;i<qt.length;i++)
            {
                int q=0;
                q=Integer.parseInt(qt[i]);
                qty+=q;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in taking data from sellDtel "+e);
        }
        System.out.println("StockFromSellDTel="+qty);
        return qty;
    }
    private int takingStockFromJTableForUpdate()
    {
        int stockQty=0;
        int ind=jTable1.getSelectedRow();
        try
            {
            System.out.println("1....");
            for(int i=0;i<jTable1.getRowCount();i++)
            {
                if(ind==i)
                {
                    continue;
                }
            System.out.println("Company="+jTable1.getValueAt(i,1));
            System.out.println("Item="+jTable1.getValueAt(i,4));
            //System.out.println("Company="+jTable1.getValueAt(i,));
            if(jTextField4.getText().equalsIgnoreCase(""+jTable1.getValueAt(i,1)))
            {
                if(jTextField5.getText().equalsIgnoreCase(""+jTable1.getValueAt(i,4)))
                {
                    if(jTextField3.getText().equalsIgnoreCase(""+jTable1.getValueAt(i,2)))
                    {
                        System.out.println("2....");
                        int qty=Integer.parseInt(""+jTable1.getValueAt(i,5));
                        stockQty+=qty;
                        System.out.println("3....");
                    }
                }
            }
            
            }
            }
            catch(Exception e)
            {
                System.out.println("Error..."+e);
            }
        System.out.println("TableQty="+stockQty);
    return stockQty;
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
        int r=jTable1.getSelectedRow();
        jTextField4.setText(jTable1.getValueAt(r,1).toString());    //company name
        jTextField5.setText(jTable1.getValueAt(r,4).toString());    //item name
        jTextField1.setText(jTable1.getValueAt(r,5).toString());    //qty
        jTextField2.setText(jTable1.getValueAt(r,7).toString());    //rate
        jTextField3.setText(jTable1.getValueAt(r,2).toString());    //batch no.
        jLabel9.setText(jTable1.getValueAt(r,3).toString());    //expiry date
        jLabel4.setText(jTable1.getValueAt(r,6).toString());    //qty type
        
        //utilityClass uc=new utilityClass();
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
        String type=uc.getQtyType(jTextField5.getText().trim());
        jLabel7.setText("/ "+type);
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
        int cnfrm=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure?","Confirmation",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
        if(cnfrm==javax.swing.JOptionPane.YES_OPTION)
        {
            dtm1.removeRow(jTable1.getSelectedRow());
            for(int r=0;r<dtm1.getRowCount();r++)
            {
                jTable1.setValueAt(""+(r+1)+". ",r,0);
            }
            calculateAndSetAmts();
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
// TODO add your handling code here:
        if(evt.getModifiers()==4)
        {
            int r=jTable1.getSelectedRow();
            if(r>=0)
            {
                jMenuItem1.setEnabled(true);
                jMenuItem2.setEnabled(true);
            }
            else
            {
                jMenuItem1.setEnabled(false);
                jMenuItem2.setEnabled(false);                
            }
            jPopupMenu1.show(jTable1,evt.getX(),evt.getY());
        }

    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
// TODO add your handling code here:
 
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        /*if(evt.getKeyCode()==10)
        {
                   int flag=0;
        utilityClass uc=new utilityClass();
        /*if(uc.isBlank(jTextField4.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter company name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField4.requestFocus();
            flag=1;
        }
        else 
        if(uc.isBlank(jTextField5.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter item name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField1.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField2.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter rate of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField3.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter batch number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
            flag=1;
        }
        else if(uc.isInteger(jTextField1.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isDouble(jTextField2.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in rate.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else        //checking stock of item
        {
            try
            {
             int cmpCode=0,itemCode=0,stockQty=0;
             int qty=Integer.parseInt(jTextField1.getText());
             int tableQty=takingStockFromJTable();
             qty+=tableQty;
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;
            java.sql.Statement st=connection.createStatement();
            rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt(1);
            }
            rs=st.executeQuery("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(rs.next())
            {
                itemCode=rs.getInt(1);
            }
            rs=st.executeQuery("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(rs.next())
            {
                stockQty=rs.getInt(1);
            }
            int stockOfSell=stockOfSell(jTextField4.getText(),jTextField3.getText(),jTextField5.getText());
            stockQty+=stockOfSell;
            //int qty=Integer.parseInt(jTextField1.getText());
            if(stockQty<qty)
            {
                int tempQty=(stockQty-tableQty);
                System.out.println("tempQty="+tempQty);
                javax.swing.JOptionPane.showMessageDialog(null,"You have "+tempQty+" "+jLabel4.getText()+" only.","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
                //jTextField1.setText(""+stockQty);
                jTextField1.setText(""+tempQty);
                flag=1;
            }    
            }
            catch(Exception e)
            {
                System.out.println("Error..."+e);
            }
        }
        if(flag==0)
            setRecordInTable();
            jTextField5.requestFocus();
        }*/
        if(evt.getKeyCode()==10)
        {
                   int flag=0;
        //utilityClass uc=new utilityClass();
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
        if(uc.isBlank(jTextField5.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter item name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField1.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField2.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter rate of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField3.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter batch number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
            flag=1;
        }
        else if(uc.isInteger(jTextField1.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isDouble(jTextField2.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in rate.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else        //checking stock of item
        {
            try
            {
             int cmpCode=0,itemCode=0,stockQty=0; 
             int qty=Integer.parseInt(jTextField1.getText());
             int tableQty=takingStockFromJTable();
             qty+=tableQty;
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;
            java.sql.Statement st=connection.createStatement();*/
            
            String cmpc=inf.getSingleValue("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(cmpc!=null)
            	cmpCode=Integer.parseInt(cmpc);
            /*rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt(1);
            }*/
            cmpc=inf.getSingleValue("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(cmpc!=null)
            	itemCode=Integer.parseInt(cmpc);
            /*rs=st.executeQuery("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(rs.next())
            {
                itemCode=rs.getInt(1);
            }*/
            cmpc=inf.getSingleValue("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(cmpc!=null)
            	stockQty=Integer.parseInt(cmpc);
            /*rs=st.executeQuery("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(rs.next())
            {
                stockQty=rs.getInt(1);
            }*/
            
            if(stockQty<qty)
            {
                int tempQty=(stockQty-tableQty);
                System.out.println("tempQty="+tempQty);
                javax.swing.JOptionPane.showMessageDialog(null,"You have "+tempQty+" "+jLabel4.getText()+" only.","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
                //jTextField1.setText(""+stockQty);
                jTextField1.setText(""+tempQty);
                flag=1;
            }    
            }
            catch(Exception e)
            {
                System.out.println("Error..."+e);
            }
        }
        if(flag==0)
            setRecordInTable();
            jTextField5.requestFocus();
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
		}
    }//GEN-LAST:event_jButton1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jTextField3.requestFocus();
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {    
            jTextField2.selectAll();
            jTextField2.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        takePreviousDataAndSaveIntoDB();
        if(saveRecords()==0)
        {
            /*clearFullComponents();
            utilityClass uc=new utilityClass();
            jLabel33.setText(""+uc.getSaleNo());*/
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    private int saveRecords()
    {
        int flag=0;
        try {
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
            if(uc.isBlank(jTextField6.getText())==false)
            {
                if(uc.isDouble(jTextField6.getText())==false)
                {
                    javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in discount.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                    jTextField6.requestFocus();
                    jTextField6.selectAll();    
                    flag=1;    
                }                    
            }
            if(flag==0 && uc.isBlank(jTextField13.getText())==false)
            {
                if(uc.isDouble(jTextField13.getText())==false)
                {
                    javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in tax.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                    jTextField13.requestFocus();
                    jTextField13.selectAll();    
                    flag=1;
                }                    
            }
            if(flag==0)
            {
                /*ConnectDatabase cd=new ConnectDatabase();
                java.sql.Connection connection = cd.getConnection();
                java.sql.Statement st1=connection.createStatement();
                java.sql.Statement st2=connection.createStatement();
                java.sql.ResultSet rs,rs1,rs2;*/
                //ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
                int sno=Integer.parseInt(jLabel33.getText());
    
                //delete old informations
                //-----------------------
               // rs1=st1.executeQuery("select * from saleDtl where sNo="+sNo);
               String [][]rs1=inf.getResultSetAs_2D_Array("select itemNm,batchNo,qty from saleDtl where sNo="+sNo,3);
               if(rs1!=null)
                for(int i=0;i<rs1.length;i++)
                {
                    String itemname=rs1[i][0];
                    String batchno=rs1[i][1];
                    int quantity=Integer.parseInt(rs1[i][2]);
                    int itemcode=uc.getItemCode(itemname);
                    
                    /*String typeofitem="";
                    rs2=st2.executeQuery("select * from itemMaster where itemCode="+itemcode);
                    if(rs2.next())
                    {
                        typeofitem=rs2.getString("typeOfItem");
                        if(typeofitem.equalsIgnoreCase("Tab") || typeofitem.equalsIgnoreCase("Capsule"))
                        {
                            quantity=quantity * rs2.getInt("pkging");
                        }
                    }*/
                
                    
                    //rs2=st2.executeQuery("select qty from stockHolding where itemCode="+itemcode+" and batchNo='"+batchno+"'");
                    String rs2=inf.getSingleValue("select qty from stockHolding where itemCode="+itemcode+" and batchNo='"+batchno+"'");
                    if(rs2!=null)
                    {
                        quantity=Integer.parseInt(rs2)+quantity;
                        //st2.executeUpdate("update stockHolding set qty="+quantity+" where itemCode="+itemcode+" and batchNo='"+batchno+"'");
                        inf.executeUpdateQuery("update stockHolding set qty="+quantity+" where itemCode="+itemcode+" and batchNo='"+batchno+"'");
                    }                 
                }
                //st1.executeUpdate("delete * from saleDtl where sNo="+sNo);
                //st1.executeUpdate("delete * from saleSmry where sNo="+sNo);
                inf.executeUpdateQuery("delete * from saleDtl where sNo="+sNo);
                inf.executeUpdateQuery("delete * from saleSmry where sNo="+sNo);
                
            //insert new records
            //------------------   
            //java.util.Date dt=new java.util.Date();
            String dt=jLabel35.getText();
            String entrydate=dt.substring(dt.indexOf("/")+1,dt.lastIndexOf("/"))+"/"+dt.substring(0,dt.indexOf("/"))+"/"+dt.substring(dt.lastIndexOf("/")+1,dt.length());
            //String entrydate=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);
            double dispc=0;
            if(uc.isBlank(jTextField6.getText())==false)
                dispc=Double.valueOf(jTextField6.getText());
            double taxpc=0;
            if(uc.isBlank(jTextField13.getText())==false)
                taxpc=Double.valueOf(jTextField13.getText());
            int totalitems=Integer.parseInt(jLabel37.getText());
            double totalamt=Double.valueOf(jLabel10.getText());
            double disamt=Double.valueOf(jLabel27.getText());
            double taxamt=Double.valueOf(jLabel29.getText());
            double payamt=Double.valueOf(jLabel31.getText());
            double netamt=Double.valueOf(jLabel39.getText());
            
            
            //java.sql.Statement st=connection.createStatement();
            //st.executeUpdate("insert into saleSmry values("+sno+",'"+entrydate+"',"+dispc+","+taxpc+","+totalitems+","+totalamt+","+disamt+","+taxamt+","+payamt+","+netamt+")");
            inf.executeUpdateQuery("insert into saleSmry values("+sno+",'"+entrydate+"',"+dispc+","+taxpc+","+totalitems+","+totalamt+","+disamt+","+taxamt+","+payamt+","+netamt+")");
            
            for(int r=0;r<dtm1.getRowCount();r++)
            {
                String coname=""+jTable1.getValueAt(r,1);
                String btno=""+jTable1.getValueAt(r,2);
                String expdate=""+jTable1.getValueAt(r,3);
                expdate=expdate.substring(expdate.indexOf('/')+1,expdate.lastIndexOf('/'))+"/"+expdate.substring(0,expdate.indexOf('/'))+"/"+expdate.substring(expdate.lastIndexOf('/')+1,expdate.length());
                String itemnm=""+jTable1.getValueAt(r,4);
                int qty=Integer.parseInt(""+jTable1.getValueAt(r,5));
                String pkgtype=""+jTable1.getValueAt(r,6);
                double mrp=Double.valueOf(""+jTable1.getValueAt(r,7));
                double amt=Double.valueOf(""+jTable1.getValueAt(r,8));
                //st.executeUpdate("insert into saleDtl values("+sno+",'"+coname+"','"+btno+"','"+expdate+"','"+itemnm+"',"+qty+",'"+pkgtype+"',"+mrp+","+amt+")");
                inf.executeUpdateQuery("insert into saleDtl values("+sno+",'"+coname+"','"+btno+"','"+expdate+"','"+itemnm+"',"+qty+",'"+pkgtype+"',"+mrp+","+amt+")");    
                int itemcode=0;
                String typeofitem="";
                /*rs=st.executeQuery("select * from itemMaster where itemName='"+itemnm+"'");
                if(rs.next())
                {
                    itemcode=rs.getInt("itemCode");
                    /*typeofitem=rs.getString("typeOfItem");
                    
                    //if(typeofitem.equalsIgnoreCase("Tab") || typeofitem.equalsIgnoreCase("Capsule"))
                    //{
                       // qty=qty * rs.getInt("pkging");
                    //}
                }*/
                String itemc=inf.getSingleValue("select itemCode from itemMaster where itemName='"+itemnm+"'");
                if(itemc!=null)
                	itemcode=Integer.parseInt(itemc);
                /*rs=st.executeQuery("select * from stockHolding where itemCode="+itemcode+" and batchno='"+btno+"'");
                if(rs.next())
                {
                    qty=rs.getInt("qty")-qty;
                }
                st.executeUpdate("update stockHolding set qty="+qty+" where itemCode="+itemcode+" and batchno='"+btno+"'");
                 */
                itemc=inf.getSingleValue("select qty from stockHolding where itemCode="+itemcode+" and batchno='"+btno+"'");
                if(itemc!=null)
                	qty=Integer.parseInt(itemc)-qty;
            
            //----------adjustment of hospital stock-----
            String query="select sNo from saleTo_HPS_Patient where sNo="+sno+" and hpsOrPatientID=0";
            String treatedAs=inf.getSingleValue(query);
            if(treatedAs!=null)
            {
            	qty=Integer.parseInt(""+jTable1.getValueAt(r,5));
            	itemc=inf.getSingleValue("select qty from stockHolding_HPS where itemCode="+itemcode+" and batchno='"+btno+"'");
                if(itemc!=null)
                	qty=Integer.parseInt(itemc)-qty;
                /*rs=st.executeQuery("select * from stockHolding where itemCode="+itemcode+" and batchno='"+btno+"'");
                if(rs.next())
                {
                    qty=rs.getInt("qty")-qty;
                }*/
                if(qty==0)
                    //st.executeUpdate("delete * from stockHolding where itemCode="+itemcode+" and batchno='"+btno+"'");
                    inf.executeUpdateQuery("delete * from stockHolding_HPS where itemCode="+itemcode+" and batchno='"+btno+"'");
                else
                    //st.executeUpdate("update stockHolding set qty="+qty+" where itemCode="+itemcode+" and batchno='"+btno+"'");
                 	inf.executeUpdateQuery("update stockHolding_HPS set qty="+qty+" where itemCode="+itemcode+" and batchno='"+btno+"'");
            }
            }
            javax.swing.JOptionPane.showMessageDialog(this,"Updation process completed, successfully.","Information",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            //this.dispose();
            jButton3.setEnabled(false);
            }
        } catch(Exception ex) {
            System.out.println("Error..783..."+ex);
        }
        return flag;
    }
    private void jTextField13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            int flag=0;
            //utilityClass uc=new utilityClass();
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
            if(uc.isBlank(jTextField13.getText())==true)
            {
                flag=1;
            }
            else if(uc.isDouble(jTextField13.getText())==false)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in tax.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField13.requestFocus();
                flag=1;
            }
            if(flag==0)
            {
                calculateAndSetAmts();
            }
            }
            catch(Exception ex)
			{
     			System.out.println("Error ...."+ex);
			}
        }
    }//GEN-LAST:event_jTextField13KeyPressed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusLost

    private void jTextField10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusGained
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField10FocusGained

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusGained
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField9FocusGained

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField7FocusGained

    private void jList6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList6MouseEntered
// TODO add your handling code here:
    }//GEN-LAST:event_jList6MouseEntered

    private void jList6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList6MouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_jList6MouseClicked

    private void jList6ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList6ValueChanged
// TODO add your handling code here:
    }//GEN-LAST:event_jList6ValueChanged

    private void jList5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList5MouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_jList5MouseClicked

    private void jList5ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList5ValueChanged
// TODO add your handling code here:
    }//GEN-LAST:event_jList5ValueChanged

    private void jList5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList5FocusLost
// TODO add your handling code here:
    }//GEN-LAST:event_jList5FocusLost

    private void jList5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList5FocusGained
// TODO add your handling code here:
    }//GEN-LAST:event_jList5FocusGained

    private void jList4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList4MouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_jList4MouseClicked

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10) {
        {
            int flag=0;
            //utilityClass uc=new utilityClass();
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
            if(uc.isBlank(jTextField6.getText())==true)
            {
                flag=1;
            }
            else if(uc.isDouble(jTextField6.getText())==false)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in discount.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField6.requestFocus();
                flag=1;
            }
            if(flag==0)
            {
                calculateAndSetAmts();
            }
            }
            catch(Exception ex)
			{
     			System.out.println("Error ...."+ex);
			}
        }
            
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
// TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_DOWN) 
        {
            if(jPanel2.isVisible()==false)
                jPanel2.setVisible(true);
            jList2.setSelectedIndex(jList2.getSelectedIndex()+1);
            jList2.ensureIndexIsVisible(jList2.getSelectedIndex());
        }
        else if(evt.getKeyCode()==evt.VK_UP) 
        {
            if(jPanel2.isVisible()==false)
                jPanel2.setVisible(true);
            jList2.setSelectedIndex(jList2.getSelectedIndex()-1);
            jList2.ensureIndexIsVisible(jList2.getSelectedIndex());
        }
        else
//        if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) 
        {
        //jPanel2.setVisible(true);
        String crntText=jTextField5.getText().toUpperCase();
        int l=itemNmVc.size();
        jList2.clearSelection();
        for(int i=0;i<l;i++) {
            String itemnm=""+itemNmVc.elementAt(i);
            int indx=itemnm.indexOf(crntText);
            if(indx==0) {
                jList2.setSelectedIndex(i);
                jList2.ensureIndexIsVisible(i);
                break;
            }
        }
        }
  /*      else if(evt.getKeyCode()!=evt.VK_ENTER && evt.getKeyCode()!=evt.VK_ESCAPE && evt.getKeyCode()!=evt.VK_DOWN && evt.getKeyCode()!=evt.VK_UP) 
        {
            jList2.clearSelection();
        }
    */    
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
    // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER) {
        	try{
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
            if(jList2.getSelectedIndex()>=0){
            jTextField5.setText(""+itemNmVc.elementAt(jList2.getSelectedIndex()));
            //utilityClass obj=new utilityClass();
        jTextField4.setText(uc.getCmpName(jTextField5.getText()));
            }
            //utilityClass uc=new utilityClass();
            String unittype=uc.getSmallestQtyType(jTextField5.getText().trim());//,jTextField5.getText().trim());
            if(unittype.equalsIgnoreCase("tab"))
                jLabel4.setText("Tab");
            else if(unittype.equalsIgnoreCase("capsule"))
                jLabel4.setText("Capsule");
            else
                jLabel4.setText(unittype);
            }
            catch(Exception ex)
			{
     			System.out.println("Error ...."+ex);
			}
            jPanel2.setVisible(false);
            jTextField1.requestFocus();
        }
        /*else if(evt.getKeyCode()==evt.VK_DOWN) 
        {
            if(jPanel2.isVisible()==false)
                jPanel2.setVisible(true);
            jList2.setSelectedIndex(jList2.getSelectedIndex()+1);
            jList2.ensureIndexIsVisible(jList2.getSelectedIndex());
        }
        else if(evt.getKeyCode()==evt.VK_UP) 
        {
            if(jPanel2.isVisible()==false)
                jPanel2.setVisible(true);
            jList2.setSelectedIndex(jList2.getSelectedIndex()-1);
            jList2.ensureIndexIsVisible(jList2.getSelectedIndex());
        }*/
        if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) 
        {
            jPanel2.setVisible(true);
        }
        if(evt.getKeyCode()==evt.VK_ESCAPE)
        {
            jPanel2.setVisible(false);
        }
        if(evt.getKeyCode()==evt.VK_F1)
        {
            jPanel2.setVisible(true);
        }

    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
// TODO add your handling code here:
        //jPanel2.setVisible(false);
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
// TODO add your handling code here:
        //utilityClass uc=new utilityClass();
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
        String itemNm[]=uc.getItemNames(jTextField4.getText());//""+coNmVc.elementAt(jList1.getSelectedIndex()));
        itemNmVc.removeAllElements();
        for(int i=1;i<itemNm.length;i++) {
            itemNmVc.addElement(itemNm[i]);
        }
        jList2.setListData(itemNmVc);
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        //jPanel2.setVisible(true);
    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
// TODO add your handling code here
        //jPanel1.setVisible(true);
       /* if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) 
        {
        utilityClass uc=new utilityClass();
        if(uc.isBlank(jTextField4.getText())==false)
        {
            String crntText=jTextField4.getText().toUpperCase();
            int l=coNmVc.size();
            jList1.clearSelection();
            for(int i=0;i<l;i++) 
            {
                String conm=""+coNmVc.elementAt(i);
                int indx=conm.indexOf(crntText);
                if(indx>=0) 
                {
                    jList1.setSelectedIndex(i);
                    jList1.ensureIndexIsVisible(i);
                    break;
                }
            }
        }
        }
        else if(evt.getKeyCode()!=evt.VK_ENTER && evt.getKeyCode()!=evt.VK_ESCAPE && evt.getKeyCode()!=evt.VK_DOWN && evt.getKeyCode()!=evt.VK_UP) 
        {
            jList1.clearSelection();
        }*/
        
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
// TODO add your handling code here:
        
      /*  if(evt.getKeyCode()==evt.VK_ENTER) {
            utilityClass uc=new utilityClass();
            if(jList1.getSelectedIndex()>=0){
                jTextField4.setText(""+coNmVc.elementAt(jList1.getSelectedIndex()));
            }
            jPanel1.setVisible(false);
            jTextField5.requestFocus();
        }
        else if(evt.getKeyCode()==evt.VK_DOWN) 
        {
            if(jPanel1.isVisible()==false)
                jPanel1.setVisible(true);
            jList1.setSelectedIndex(jList1.getSelectedIndex()+1);
            jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
        }
        else if(evt.getKeyCode()==evt.VK_UP) 
        {
            if(jPanel1.isVisible()==false)
                jPanel1.setVisible(true);
            jList1.setSelectedIndex(jList1.getSelectedIndex()-1);
            jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
        }
        if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) 
        {
            jPanel1.setVisible(true);
        }
        if(evt.getKeyCode()==evt.VK_ESCAPE)
        {
            jPanel1.setVisible(false);
        }
        if(evt.getKeyCode()==evt.VK_F1)
        {
            jPanel1.setVisible(true);
        }*/
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
// TODO add your handling code here:
        //jPanel1.setVisible(false);
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusGained
// TODO add your handling code here:
        ///jPanel1.setVisible(true);
    }//GEN-LAST:event_jTextField4FocusGained

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        /*int flag=0;
        utilityClass uc=new utilityClass();
        
        if(uc.isBlank(jTextField5.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter item name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField1.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField2.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter rate of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField3.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter batch number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
            flag=1;
        }
        else if(uc.isInteger(jTextField1.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isDouble(jTextField2.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in rate.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else        //checking stock of item
        {
            try
            {
             int cmpCode=0,itemCode=0,stockQty=0;
             int qty=Integer.parseInt(jTextField1.getText());
             int tableQty=takingStockFromJTable();
             qty+=tableQty;
             System.out.println("\nTableQty="+tableQty);
             System.out.println("\nqty="+qty);
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;
            java.sql.Statement st=connection.createStatement();
            rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt(1);
            }
            rs=st.executeQuery("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(rs.next())
            {
                itemCode=rs.getInt(1);
            }
            rs=st.executeQuery("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(rs.next())
            {
                stockQty=rs.getInt(1);
            }
            int stockOfSell=stockOfSell(jTextField4.getText(),jTextField3.getText(),jTextField5.getText());
            stockQty+=stockOfSell;
            System.out.println("\nstockQty="+stockQty);
            if(stockQty<qty)
            {
                int tempQty=(stockQty-tableQty);
                System.out.println("\ntempQty="+tempQty);
                javax.swing.JOptionPane.showMessageDialog(null,"You have "+tempQty+" "+jLabel4.getText()+" only.","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
                //jTextField1.setText(""+stockQty);
                jTextField1.setText(""+tempQty);
                flag=1;
            }    
            }
            catch(Exception e)
            {
                System.out.println("Error..."+e);
            }
        }
        if(flag==0)
            setRecordInTable();*/
            int flag=0;
        //utilityClass uc=new utilityClass();
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
        /*if(uc.isBlank(jTextField4.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter company name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField4.requestFocus();
            flag=1;
        }
        else */
        if(uc.isBlank(jTextField5.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter item name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField1.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField2.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter rate of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(jTextField3.getText())==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter batch number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField3.requestFocus();
            flag=1;
        }
        else if(uc.isInteger(jTextField1.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField1.requestFocus();
            flag=1;
        }
        else if(uc.isDouble(jTextField2.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in rate.\nOnly numbers are allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
            flag=1;
        }
        else        //checking stock of item
        {
            try
            {
             int cmpCode=0,itemCode=0,stockQty=0; 
             int qty=Integer.parseInt(jTextField1.getText());
             int tableQty=takingStockFromJTable();
             qty+=tableQty;
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;
            java.sql.Statement st=connection.createStatement();*/
           // ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
            String cmpc=inf.getSingleValue("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(cmpc!=null)
            	cmpCode=Integer.parseInt(cmpc);
            /*rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+jTextField4.getText()+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt(1);
            }*/
            cmpc=inf.getSingleValue("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(cmpc!=null)
            	itemCode=Integer.parseInt(cmpc);
            /*rs=st.executeQuery("select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+jTextField5.getText()+"'");
            if(rs.next())
            {
                itemCode=rs.getInt(1);
            }*/
            cmpc=inf.getSingleValue("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(cmpc!=null)
            	stockQty=Integer.parseInt(cmpc);
            /*rs=st.executeQuery("select qty from stockHolding where itemCode="+itemCode+" and batchNo='"+jTextField3.getText()+"'");
            if(rs.next())
            {
                stockQty=rs.getInt(1);
            }*/
            
            if(stockQty<qty)
            {
                int tempQty=(stockQty-tableQty);
                System.out.println("tempQty="+tempQty);
                javax.swing.JOptionPane.showMessageDialog(null,"You have "+tempQty+" "+jLabel4.getText()+" only.","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
                //jTextField1.setText(""+stockQty);
                jTextField1.setText(""+tempQty);
                flag=1;
            }    
            }
            catch(Exception e)
            {
                System.out.println("Error..."+e);
            }
        }
        if(flag==0)
            setRecordInTable();
            //jTextField5.requestFocus();
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
    }//GEN-LAST:event_jButton1ActionPerformed
private int takingStockFromJTable()
    {
        int stockQty=0; 
        try
            {
            System.out.println("1....");
            for(int i=0;i<jTable1.getRowCount();i++)
            {
            System.out.println("Company="+jTable1.getValueAt(i,1));
            System.out.println("Item="+jTable1.getValueAt(i,4));
            //System.out.println("Company="+jTable1.getValueAt(i,));
            if(jTextField4.getText().equalsIgnoreCase(""+jTable1.getValueAt(i,1)))
            {
                if(jTextField5.getText().equalsIgnoreCase(""+jTable1.getValueAt(i,4)))
                {
                    if(jTextField3.getText().equalsIgnoreCase(""+jTable1.getValueAt(i,2)))
                    {
                        System.out.println("2....");
                        int qty=Integer.parseInt(""+jTable1.getValueAt(i,5));
                        stockQty+=qty;
                        System.out.println("3....");
                    }
                }
            }
            
            }
            }
            catch(Exception e)
            {
                System.out.println("Error..."+e);
            }
        System.out.println("TableQty="+stockQty);
    return stockQty;
    }
    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
// TODO add your handling code here:
        jPanel3.setVisible(true);
        String crntText=jTextField3.getText().toUpperCase();
        int l=batchNoVc.size();
        jList3.clearSelection();
        for(int i=0;i<l;i++) {
            String bnonm=""+batchNoVc.elementAt(i);
            int indx=bnonm.indexOf(crntText);
            if(indx>=0) {
                jList3.setSelectedIndex(i);
                jList3.ensureIndexIsVisible(i);
                break;
            }
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER) {
            jTextField3.setText(""+batchNoVc.elementAt(jList3.getSelectedIndex()));
            jPanel3.setVisible(false);
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
            jLabel9.setText(uc.getExpDate(jTextField5.getText()));
            jButton1.requestFocus();
            }
            catch(Exception ex)
			{
     			System.out.println("Error ...."+ex);
			}
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusGained
// TODO add your handling code here:
        System.out.println("focus");
        try {
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
            String btnoNm[]=uc.getBatchNos(jTextField4.getText().trim(),jTextField5.getText().trim());
            batchNoVc.removeAllElements();
            for(int i=1;i<btnoNm.length;i++) {
                batchNoVc.addElement(btnoNm[i]);
            }
            jList3.setListData(batchNoVc);
            
            jPanel3.setVisible(true);
        } catch(Exception ex) {
            System.out.println("Error...34..."+ex);
        }
    }//GEN-LAST:event_jTextField3FocusGained

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
// TODO add your handling code here:
        try {
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
            String mrp=uc.getMrp(jTextField5.getText().trim());
            jTextField2.setText(""+(new java.math.BigDecimal(mrp)).setScale(2,5));
            
            String type=uc.getQtyType(jTextField5.getText().trim());//,jTextField5.getText().trim());
            jLabel7.setText("/ "+type);
        } catch(Exception ex) {
            System.out.println("error...567..."+ex);
        }
    }//GEN-LAST:event_jTextField1FocusGained

    private void jList2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseEntered
// TODO add your handling code here:
        System.out.println("entered.....");
    }//GEN-LAST:event_jList2MouseEntered

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
// TODO add your handling code here:
        System.out.println("clicked.....");
        jTextField5.setText(""+itemNmVc.elementAt(jList2.getSelectedIndex()));
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
        //utilityClass obj=new utilityClass();
        jTextField4.setText(uc.getCmpName(jTextField5.getText()));
        jPanel2.setVisible(false);
        //utilityClass uc=new utilityClass();
        
        String unittype=uc.getSmallestQtyType(jTextField5.getText().trim());//,jTextField5.getText().trim());
        if(unittype.equalsIgnoreCase("tab"))
            jLabel4.setText("Tab");
        else if(unittype.equalsIgnoreCase("capsule"))
            jLabel4.setText("Capsule");
        else
            jLabel4.setText(unittype);
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        jTextField1.requestFocus();
    }//GEN-LAST:event_jList2MouseClicked

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
// TODO add your handling code here:
/*        jTextField5.setText(""+itemNmVc.elementAt(jList2.getSelectedIndex()));
        utilityClass obj=new utilityClass();
        jTextField4.setText(obj.getCmpName(jTextField5.getText()));
 */
    }//GEN-LAST:event_jList2ValueChanged

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
// TODO add your handling code here:
        jTextField4.setText(""+coNmVc.elementAt(jList1.getSelectedIndex()));
        jPanel1.setVisible(false);
        jTextField5.requestFocus();
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
// TODO add your handling code here:
        // jTextField4.setText(""+coNmVc.elementAt(jList1.getSelectedIndex()));
    }//GEN-LAST:event_jList1ValueChanged

    private void jList1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList1FocusLost
// TODO add your handling code here:
        jPanel1.setVisible(false);
    }//GEN-LAST:event_jList1FocusLost

    private void jList1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList1FocusGained
// TODO add your handling code here:
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jList1FocusGained

    private void jList3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList3MouseClicked
// TODO add your handling code here:
        jTextField3.setText(""+batchNoVc.elementAt(jList3.getSelectedIndex()));
        jPanel3.setVisible(false);
        
        //utilityClass uc=new utilityClass();]
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
        jLabel9.setText(uc.getExpDate(jTextField5.getText()));
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        jButton1.requestFocus();
        
        jButton1.requestFocus();
    }//GEN-LAST:event_jList3MouseClicked
    private void calculateAndSetAmts()
    {
        System.out.println("ok");
            jLabel10.setText("0.00");
            jLabel27.setText("0.00");
            jLabel29.setText("0.00");
            jLabel31.setText("0.00");
            double amt=0;
            jLabel37.setText(""+dtm1.getRowCount());
            for(int i=0;i<dtm1.getRowCount();i++)
            {
                amt=amt+Double.valueOf(""+jTable1.getValueAt(i,8));
            }
            jLabel10.setText(""+(new java.math.BigDecimal(amt)).setScale(2,5));
            
            //calculate discount
            double disamt=0;
            if(jTextField6.getText().trim().equals("")==false)
            {
                try
                {
                    disamt=(amt*Double.valueOf(jTextField6.getText().trim()))/100;
                    jLabel27.setText(""+(new java.math.BigDecimal(disamt)).setScale(2,5));
                    amt=amt-disamt;
                }
                catch(Exception ex)
                {
                    disamt=0;
                    javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in DISCOUNT.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                    jTextField6.selectAll();
                    jTextField6.requestFocus();
                }
            }
           
            //calculate TAX
            double taxamt=0;
            if(jTextField13.getText().trim().equals("")==false)
            {
                try
                {
                    taxamt=(amt*Double.valueOf(jTextField13.getText().trim()))/100;
                    jLabel29.setText(""+(new java.math.BigDecimal(taxamt)).setScale(2,5));
                    amt=amt+taxamt;
                }
                catch(Exception ex)
                {
                    taxamt=0;
                    javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in TAX.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                    jTextField13.selectAll();
                    jTextField13.requestFocus();
                }
            }
            jLabel31.setText(""+(new java.math.BigDecimal(amt)).setScale(2,5));
            
            
            //R/O AMOUNT
        int intAmt=Double.valueOf(jLabel31.getText()).intValue();
        double roAmt=(Double.valueOf(jLabel31.getText())-intAmt);
        if(roAmt>=0.5)
            roAmt=1-roAmt;
        else
            roAmt=-roAmt;
        //jLabel27.setText(""+(new java.math.BigDecimal(roAmt)).setScale(2,5));
        //NET AMOUNT
        //netamt=payamt+roAmt;
        jLabel39.setText(""+(new java.math.BigDecimal(Double.valueOf(jLabel31.getText())+roAmt)).setScale(2,5));
        
    }
    private void setRecordInTable()
    {
        try
        {
            String arr[]=new String[9];
            arr[0]=""+(jTable1.getRowCount()+1)+". ";
            arr[1]=jTextField4.getText().trim();
            arr[2]=jTextField3.getText().trim();
            arr[3]=jLabel9.getText().trim();
            arr[4]=jTextField5.getText().trim();
            arr[5]=jTextField1.getText().trim();
            arr[6]=jLabel4.getText().trim();
            arr[7]=jTextField2.getText().trim();
            if(jLabel7.getText().equalsIgnoreCase("/ St")==false)
            {
                arr[8]=""+(Double.valueOf(jTextField1.getText())*Double.valueOf(jTextField2.getText()));
                arr[8]=""+(new java.math.BigDecimal(arr[8])).setScale(2,5) ;
            }
            else
            {
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
                String pkg=uc.getPacking(jTextField5.getText().trim());//jTextField4.getText().trim(),jTextField5.getText().trim());
                pkg=pkg.substring(0,pkg.indexOf(" "));
                int pkgInt=Integer.parseInt(pkg);
                double rate=Double.valueOf(jTextField2.getText())/pkgInt;
                
                arr[8]=""+(Double.valueOf(jTextField1.getText())*rate);
                arr[8]=""+(new java.math.BigDecimal(arr[8])).setScale(2,5) ;
            }
            dtm1.addRow(arr);
            calculateAndSetAmts();
            clearComponents();
        }
        catch(Exception ex)
        {
            System.out.println("Error...345..."+ex);
        }
    }
    private void updateRecordInTable()
    {
        try
        {
            //int r=jTable1.getSelectedRow();
            String arr[]=new String[9];
            arr[0]=""+(jTable1.getRowCount()+1);
            arr[1]=jTextField4.getText().trim();
            arr[2]=jTextField3.getText().trim();
            arr[3]=jLabel9.getText().trim();
            arr[4]=jTextField5.getText().trim();
            arr[5]=jTextField1.getText().trim();
            arr[6]=jLabel4.getText().trim();
            arr[7]=jTextField2.getText().trim();
            if(jLabel7.getText().equalsIgnoreCase("/ St")==false)
            {
                arr[8]=""+(Double.valueOf(jTextField1.getText())*Double.valueOf(jTextField2.getText()));
                arr[8]=""+(new java.math.BigDecimal(arr[8])).setScale(2,5) ;
            }
            else
            {
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
                String pkg=uc.getPacking(jTextField5.getText().trim());//jTextField4.getText().trim(),jTextField5.getText().trim());
                pkg=pkg.substring(0,pkg.indexOf(" "));
                int pkgInt=Integer.parseInt(pkg);
                double rate=Double.valueOf(jTextField2.getText())/pkgInt;
                
                arr[8]=""+(Double.valueOf(jTextField1.getText())*rate);
                arr[8]=""+(new java.math.BigDecimal(arr[8])).setScale(2,5) ;
            }
            
            int r=jTable1.getSelectedRow();
            dtm1.removeRow(r);
            dtm1.insertRow(r,arr);
            
        
        for(r=0;r<dtm1.getRowCount();r++)
            {
                jTable1.setValueAt(""+(r+1)+". ",r,0);
            }
        
            calculateAndSetAmts();
            clearComponents();
        }
        catch(Exception ex)
        {
            System.out.println("Error...345..."+ex);
        }
    }
    private void clearComponents()
    {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField4.requestFocus();
    }
    private void clearFullComponents()
    {
        while(dtm1.getRowCount()>0)     dtm1.removeRow(0);
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField13.setText("");
        jLabel37.setText("0");
        jLabel10.setText("0.00");
        jLabel27.setText("0.00");
        jLabel29.setText("0.00");
        jLabel31.setText("0.00");
        jLabel39.setText("0.00");
        jTextField4.requestFocus();
    }
    
    /*
     *this method is used to take
     *information before editing 
     *and save data into database
     */
    private void takePreviousDataAndSaveIntoDB()
    {
        try
        {
            String str[][]=null;
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;*/
            //utilityClass ut=new utilityClass();
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
            String query="select max(editNo) from logFileForUpdate";
            //taking max edit no
            int editNo=uc.getMaxValue(query);
            editNo+=1;
            //save data 1
            java.util.Date dt=new java.util.Date();
            String dateAndTime=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900)+" "+dt.getHours()+":"+dt.getMinutes()+":"+dt.getSeconds();
            
            query="insert into logFileForUpdate values('"+dateAndTime+"','EditSellBill',"+editNo+")";
            uc.saveOrUpdateResultSet(query);
            //getting data from db
            query="select * from saleSmry where sNo="+sNo+"";
            str=uc.returnResultSet(query,"EditMakePurchaseWindowSmry","");
            //save data 2
            query="insert into saleSmryEdit values('"+str[0][0]+"','"+str[0][1]+"','"+str[0][2]+"','"+str[0][3]+"','"+str[0][4]+"','"+str[0][5]+"','"+str[0][6]+"','"+str[0][7]+"','"+str[0][8]+"','"+str[0][9]+"',"+editNo+")";
            uc.saveOrUpdateResultSet(query);
            //counting value of purDtl with existing 
            query="select * from saleDtl where sNo="+sNo+"";
            int count=uc.countingValue(query);
            //taking data from DB
            query="select * from saleDtl where sNo="+sNo+"";
            str=uc.returnResultSet(query,"EditMakingSellWindowDtl",""+count);
            //System.out.println("len="+str.length);
            //save data 3
            for(int i=0;i<str.length;i++)
            {
                query="insert into saleDtlEdit values("+editNo+",'"+str[i][1]+"','"+str[i][2]+"','"+str[i][3]+"','"+str[i][4]+"','"+str[i][5]+"','"+str[i][6]+"','"+str[i][7]+"','"+str[i][8]+"')";
                uc.saveOrUpdateResultSet(query);
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error in takePrevoiusDataAndSaveIntoDB method into EditMakingSale class..."+e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JList jList5;
    private javax.swing.JList jList6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
    java.util.Vector coNmVc;
    java.util.Vector itemNmVc;
    java.util.Vector batchNoVc;
    javax.swing.table.DefaultTableModel dtm1;
    int sNo;
    int initialRowCount;
    
    
}
