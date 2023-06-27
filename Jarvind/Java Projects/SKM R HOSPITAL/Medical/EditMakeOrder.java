/*
 * MakePurchase.java
 *
 * Created on April 8, 2010, 9:15 AMcoNmVc
 */

//package medretail;
import java.rmi.*;
/**
 *
 * @author  Deep Pal
 */
public class EditMakeOrder extends javax.swing.JInternalFrame {
    
    /** Creates new form MakePurchase */
    public EditMakeOrder(javax.swing.JDesktopPane jDesktopPane1,int orderNo) {
        initComponents();
        
        jLabel9.setVisible(false);
        this.orderNo=orderNo;
        System.out.println("order no="+orderNo);
        jTextField2.setText(""+orderNo);
        
        java.awt.Cursor cursor;
        cursor = new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR);
        
        jButton1.setCursor(cursor);
        jButton2.setCursor(cursor);
        jButton3.setCursor(cursor);
        jButton4.setCursor(cursor);
        jButton6.setCursor(cursor);
        jButton7.setCursor(cursor);
        jList1.setCursor(cursor);
        jList2.setCursor(cursor);
        jTextField10.setCursor(cursor);
        jTextField11.setCursor(cursor);
        
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
        String coNm[]=uc.getCmpNames();
        coNmVc=new java.util.Vector();
        for(int i=1;i<coNm.length;i++)
        {
            coNmVc.addElement(coNm[i]);
        }
        jList1.setListData(coNmVc);
        jPanel2.setVisible(false);
        
        
        itemNmVc=new java.util.Vector();
        jList2.setListData(itemNmVc);
        jPanel3.setVisible(false);
        
        partyNm=uc.getPurPartyNames();
        purPartyNmVc=new java.util.Vector();
        for(int i=1;i<partyNm.length;i++)
        {
            purPartyNmVc.addElement(partyNm[i]);
        }
        jList4.setListData(purPartyNmVc);
        jPanel4.setVisible(false);
        
        
        String heading[]={"S.No.","Company Name","Particular","Quantity"};
        dtm2=new javax.swing.table.DefaultTableModel(heading,0);
        jTable2.setModel(dtm2);
                javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
      		javax.swing.table.TableColumn column;

      		column=jTable2.getColumn("S.No.");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(30);

      		column=jTable2.getColumn("Company Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(200);

      		
                
                column=jTable2.getColumn("Particular");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(200);

      		column=jTable2.getColumn("Quantity");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(60); 
       	}
       	catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}     
        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        reshape((dm.width-800)/2,(dm.height-600)/2,670,500);
        jDesktopPane1.add(this);
        setVisible(true);
        setExistingData();
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
            String qry="select orderDt,partyNm,partyAds,totalitems,status from orderSmry where oNo="+orderNo;
            String[][]rs=inf.getResultSetAs_2D_Array(qry,5);
            if(rs!=null)
            {
                //java.util.Date billDate=rs.getDate("orderDt");
                //jLabel30.setText(billDate.getDate()+"/"+(billDate.getMonth()+1)+"/"+(billDate.getYear()+1900));
                String dat[]=rs[0][0].split("-");
                String dd[]=dat[2].split(" ");
                String date=dd[0]+"/"+dat[1]+"/"+dat[0];
                jLabel30.setText(date);
                jTextField1.setText(rs[0][1]);
                jList4.setSelectedIndex(purPartyNmVc.indexOf(jTextField1.getText()));
                jTextArea1.setText(rs[0][2]);
                jLabel22.setText(rs[0][3]);
                int status=Integer.parseInt(rs[0][4]);
                if(status==1 || status==2)
                {
                    if(status==1)
                    {
                        jLabel9.setText("Delivered");
                        jLabel9.setVisible(true);
                    }
                    else if(status==2)
                    {
                        jLabel9.setText("Cancelled");
                        jLabel9.setVisible(true);
                    }
                    jButton1.setEnabled(false);
                    jButton2.setEnabled(false);
                    jButton6.setEnabled(false);
                    jButton3.setEnabled(false);
                }
                qry="select * from orderDtl where oNo="+orderNo;
                String[][]rs1=inf.getResultSetAs_2D_Array(qry,4);
            	if(rs1!=null)
                for(int i=0;i<rs1.length;i++)
                {
                    String data[]=new String[4];
                    data[0]=""+(jTable2.getRowCount()+1)+". ";
                    data[1]=rs1[i][1];
                    data[2]=rs1[i][2];
                    data[3]=rs1[i][3];
                    dtm2.addRow(data);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in setExistingData method in EditMakeOrder class..."+e);
        }
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jTextField2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jTextField5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem1.setText("Edit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem2.setText("Delete");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        jPopupMenu1.add(jMenuItem2);

        getContentPane().setLayout(null);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 102)));
        setClosable(true);
        setIconifiable(true);
        setTitle("Edit Make Order");
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
                formInternalFrameOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel1.setText("Enter Party Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 20, 94, 20);

        jTextField1.setToolTipText("Select party");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
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
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        getContentPane().add(jTextField1);
        jTextField1.setBounds(120, 20, 230, 20);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel2.setText("Address");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(370, 20, 100, 20);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel3.setText("Order No.");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 50, 52, 20);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jList4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jList4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jList4FocusLost(evt);
            }
        });
        jList4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList4MouseClicked(evt);
            }
        });

        jScrollPane5.setViewportView(jList4);

        jPanel4.add(jScrollPane5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(120, 40, 230, 70);

        jTextField2.setBackground(new java.awt.Color(51, 255, 255));
        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jTextField2.setForeground(new java.awt.Color(153, 0, 0));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField2);
        jTextField2.setBounds(90, 50, 90, 20);

        jLabel9.setBackground(new java.awt.Color(51, 255, 51));
        jLabel9.setFont(new java.awt.Font("Monotype Corsiva", 3, 36));
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PENDING");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 0, 153)));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(130, 150, 380, 80);

        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "About Particular"));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel5.setText("Company Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 20, 100, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel6.setText("Particular");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(290, 20, 100, 20);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
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

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.WEST);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(100, 40, 190, 50);

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField5);
        jTextField5.setBounds(100, 50, 120, 20);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
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

        jScrollPane4.setViewportView(jList2);

        jPanel3.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(350, 40, 220, 50);

        jButton2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton2.setForeground(new java.awt.Color(0, 0, 204));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.jpg")));
        jButton2.setMnemonic('a');
        jButton2.setText("Add Item");
        jButton2.setToolTipText("Click here to add record");
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
        jButton2.setBounds(320, 50, 140, 30);

        jTextField10.setForeground(new java.awt.Color(255, 0, 0));
        jTextField10.setEnabled(false);
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
        jTextField10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField10MouseClicked(evt);
            }
        });

        jPanel1.add(jTextField10);
        jTextField10.setBounds(100, 20, 190, 20);

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
        jTextField11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField11MouseClicked(evt);
            }
        });

        jPanel1.add(jTextField11);
        jTextField11.setBounds(350, 20, 220, 20);

        jButton6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton6.setForeground(new java.awt.Color(0, 0, 204));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.gif")));
        jButton6.setMnemonic('e');
        jButton6.setText("Modify Item ");
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

        jPanel1.add(jButton6);
        jButton6.setBounds(480, 50, 160, 29);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel7.setText("Quantity");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 50, 60, 20);

        jLabel8.setBackground(new java.awt.Color(255, 204, 204));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel8.setForeground(new java.awt.Color(51, 51, 0));
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(230, 50, 80, 20);

        jLabel4.setBackground(new java.awt.Color(255, 204, 204));
        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(570, 20, 70, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 80, 650, 90);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "S.No.", "Company Name", "Batch No.", "Exp. Date", "Particular", "Packing", "Qty.", "Sp. Dis.", "Trade (Rs.)", "Dis.(%)", "VAT(%)", "Amount(Rs.)", "M.R.P.(Rs.)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });

        jScrollPane3.setViewportView(jTable2);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 180, 650, 200);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel21.setText("Total No. Of Items");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(20, 400, 120, 20);

        jLabel22.setBackground(new java.awt.Color(204, 204, 204));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setOpaque(true);
        getContentPane().add(jLabel22);
        jLabel22.setBounds(130, 400, 50, 20);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("Enter Address");
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 20, 240, 60);

        jButton1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.gif")));
        jButton1.setMnemonic('u');
        jButton1.setText("Update");
        jButton1.setToolTipText("Update Bill");
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
        jButton1.setBounds(70, 430, 140, 30);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel29.setText("Order Date :");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(200, 50, 80, 20);

        jLabel30.setBackground(new java.awt.Color(204, 255, 204));
        jLabel30.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel30.setForeground(new java.awt.Color(255, 153, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setOpaque(true);
        getContentPane().add(jLabel30);
        jLabel30.setBounds(280, 50, 90, 20);

        jButton3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton3.setForeground(new java.awt.Color(0, 0, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.gif")));
        jButton3.setMnemonic('r');
        jButton3.setText("Order Cancelled");
        jButton3.setToolTipText("Order Canceled");
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
        jButton3.setBounds(270, 430, 190, 30);

        jButton4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton4.setForeground(new java.awt.Color(0, 0, 153));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton4.setMnemonic('c');
        jButton4.setText("Close");
        jButton4.setToolTipText("Close");
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
        jButton4.setBounds(530, 430, 100, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton7.setToolTipText("Change order date");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton7);
        jButton7.setBounds(380, 50, 20, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
// TODO add your handling code here:
        jPanel4.setVisible(true);
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jList4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList4FocusLost
// TODO add your handling code here:
        jPanel4.setVisible(false);
    }//GEN-LAST:event_jList4FocusLost

    private void jList4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList4FocusGained
// TODO add your handling code here:
        jPanel4.setVisible(true);
    }//GEN-LAST:event_jList4FocusGained

    private void jList4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList4MouseClicked
// TODO add your handling code here:
        System.out.println("1....");
        jTextField1.setText(""+purPartyNmVc.elementAt(jList4.getSelectedIndex()));
        jPanel4.setVisible(false);
                String query="select ads from purchasePartyMaster where partyNm='"+jTextField1.getText()+"'";
                try
        {
        	ZedInterface inf=null;
ZedInterfaceForMedical ut=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	ut=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		ut=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
        	String ads=ut.returnSingleData(query);
                jTextArea1.setText(ads);
		}
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
                //utilityClass ut=new utilityClass();
                
                jTextArea1.requestFocus();
    }//GEN-LAST:event_jList4MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
// TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_DOWN) {
            if(jPanel4.isVisible()==false)
                jPanel4.setVisible(true);
            jList4.setSelectedIndex(jList4.getSelectedIndex()+1);
            jList4.ensureIndexIsVisible(jList4.getSelectedIndex());
        } else if(evt.getKeyCode()==evt.VK_UP) {
            if(jPanel4.isVisible()==false)
                jPanel4.setVisible(true);
            jList4.setSelectedIndex(jList4.getSelectedIndex()-1);
            jList4.ensureIndexIsVisible(jList4.getSelectedIndex());
        }
        else
        {
            System.out.println("inside......");
            //jPanel2.setVisible(true);
            String crntText=jTextField1.getText().toUpperCase();
            int l=purPartyNmVc.size();
            jList4.clearSelection();
            for(int i=0;i<l;i++) {
                String partynm=""+purPartyNmVc.elementAt(i);
                int indx=partynm.indexOf(crntText);
                if(indx==0) {
                    jList4.setSelectedIndex(i);
                    jList4.ensureIndexIsVisible(i);
                    break;
                }
            }
        } 
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
// TODO add your handling code here:
       // jPanel4.setVisible(false);
    }//GEN-LAST:event_jTextField1FocusLost

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
// TODO add your handling code here:
       //jPanel4.setVisible(true);
    }//GEN-LAST:event_jTextField1FocusGained

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
// TODO add your handling code here:
        jTextField1.requestFocus();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
// TODO add your handling code here:
        //utilityClass ut=new utilityClass();
        try
        {
        	ZedInterface inf=null;
ZedInterfaceForMedical ut=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	ut=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		ut=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
        	String query="select max(oNo) from orderSmry";
        	int orderNo=ut.getMaxValue(query);
		}
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        
        /*jTextField2.setText(""+orderNo);
        java.util.Date dt=new java.util.Date();
        jLabel30.setText(""+dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));*/
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
// TODO add your handling code here:
        Cal calender=new Cal();
        jLabel30.setText(calender.getdate());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField11MouseClicked
// TODO add your handling code here:
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jTextField11MouseClicked

    private void jTextField10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField10MouseClicked
// TODO add your handling code here:
       // jPanel2.setVisible(true);
    }//GEN-LAST:event_jTextField10MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
        int r=jTable2.getSelectedRow();
        jTextField10.setText(jTable2.getValueAt(r,1).toString());   //company name
        jTextField11.setText(jTable2.getValueAt(r,2).toString());   //item name
        jTextField5.setText(jTable2.getValueAt(r,3).toString());    //qty
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
// TODO add your handling code here:
       if(updateDataInTable()==0)
        {
            clearEntryScrean();
            jTextField11.requestFocus();
        }
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
        if(updateDataInTable()==0)
        {
            clearEntryScrean();
            jTextField11.requestFocus();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private int updateDataInTable()
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
            if(uc.isBlank(jTextField11.getText())==true)   //jComboBox2.getSelectedIndex()==0)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect particular name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField11.requestFocus();
                flag=1;
            }
            else if(uc.isBlank(jTextField5.getText())==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField5.requestFocus();
                flag=1;
            }
            else if(uc.isInteger(jTextField5.getText())==false)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField5.requestFocus();
                jTextField5.selectAll();
                flag=1;
            }
            if(flag==0)
            {
                String data[]=new String[4];
                data[0]=""+(jTable2.getRowCount()+1)+". ";
                data[1]=""+jTextField10.getText();//jComboBox1.getSelectedItem();
                data[2]=jTextField11.getText().toUpperCase();
                data[3]=jTextField5.getText();
                int r=jTable2.getSelectedRow();
                dtm2.removeRow(r);
                dtm2.insertRow(r,data);
                for(r=0;r<dtm2.getRowCount();r++)
                {
                    jTable2.setValueAt(""+(r+1)+". ",r,0);
                }
                setSummery();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in updateDataInTable in MakeOrder class...."+e);
        }
        return flag;
    }
    
    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)    
        {
            if(jTextArea1.getText().trim().equals(""))
            {
                jTextArea1.setText("");//jTextArea1.getText().substring(0,jTextArea1.getText().length()-1));
                jTextField11.requestFocus();
            }
            else if((jTextArea1.getText().substring(jTextArea1.getText().length()-1,jTextArea1.getText().length())).equals("\n"))
            {
                jTextArea1.setText(jTextArea1.getText().substring(0,jTextArea1.getText().length()-1));
                jTextField11.requestFocus();
            }
        }

    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
// TODO add your handling code here:
        //if(evt.getKeyCode()==10)    jTextArea1.requestFocus();
        if(evt.getKeyCode()==evt.VK_ENTER) {
            if(jList4.getSelectedIndex()>=0){
                jTextField1.setText(""+purPartyNmVc.elementAt(jList4.getSelectedIndex()));
                jPanel4.setVisible(false);
                String query="select ads from purchasePartyMaster where partyNm='"+jTextField1.getText()+"'";
                try
        {
        	ZedInterface inf=null;
ZedInterfaceForMedical ut=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	ut=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		ut=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
        	String ads=ut.returnSingleData(query);
                jTextArea1.setText(ads);
		}
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
                //utilityClass ut=new utilityClass();
                
                jTextArea1.requestFocus();
            }
            else
            {
                if(jTextField1.equals(""))
                {
                    javax.swing.JOptionPane.showMessageDialog(this,"Please enter party name","Error!",javax.swing.JOptionPane.ERROR_MESSAGE);
                    jTextField1.requestFocus();
                }
                else
                {
                    jPanel4.setVisible(false);
                    jTextArea1.requestFocus();
                }
            }
            }
           
            if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) {
            jPanel4.setVisible(true);
            }
            if(evt.getKeyCode()==evt.VK_ESCAPE) {
            jPanel4.setVisible(false);
            }
            if(evt.getKeyCode()==evt.VK_F1) {
            jPanel4.setVisible(true);
            }
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            this.dispose();
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            orderCancelation();
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton6.setEnabled(false);
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            updateData();
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            if(setDataInTable()==0)
            {
                clearEntryScrean();
                jTextField11.requestFocus();
            }
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        jButton2.requestFocus();
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyReleased
// TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_DOWN) {
            if(jPanel3.isVisible()==false)
                jPanel3.setVisible(true);
            jList2.setSelectedIndex(jList2.getSelectedIndex()+1);
            jList2.ensureIndexIsVisible(jList2.getSelectedIndex());
        } else if(evt.getKeyCode()==evt.VK_UP) {
            if(jPanel3.isVisible()==false)
                jPanel3.setVisible(true);
            jList2.setSelectedIndex(jList2.getSelectedIndex()-1);
            jList2.ensureIndexIsVisible(jList2.getSelectedIndex());
        }
        else
        /*if(evt.getKeyCode()!=evt.VK_ENTER && evt.getKeyCode()!=evt.VK_ESCAPE && evt.getKeyCode()!=evt.VK_DOWN && evt.getKeyCode()!=evt.VK_UP) {
            System.out.println("inside...if...");
            jList2.clearSelection();
        }
        else*/
        //if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) 
        {
            System.out.println("inside......");
            //jPanel2.setVisible(true);
            String crntText=jTextField11.getText().toUpperCase();
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
        
    }//GEN-LAST:event_jTextField11KeyReleased

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER) {
        	try
        	{
        	ZedInterface inf=null;
ZedInterfaceForMedical obj=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	obj=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		obj=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
            if(jList2.getSelectedIndex()>=0){
                jTextField11.setText(""+itemNmVc.elementAt(jList2.getSelectedIndex()));
                //utilityClass obj=new utilityClass();
                jTextField10.setText(obj.getCmpName(jTextField11.getText()));
                
            }
            
            //utilityClass obj=new utilityClass();
        String packing=obj.getPacking(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel4.setText(packing);
        
        String packingType=obj.getQtyType(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel8.setText(packingType);
        
       /* String vat=obj.getVat(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel18.setText(vat);
        
        String mrp=obj.getMrp(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel20.setText(mrp);
        
            /*utilityClass uc=new utilityClass();
            String unittype=uc.getSmallestQtyType(jTextField11.getText().trim());//,jTextField5.getText().trim());
            if(unittype.equalsIgnoreCase("tab"))
                jLabel11.setText("Tab");
            else if(unittype.equalsIgnoreCase("capsule"))
                jLabel4.setText("Capsule");
            else
                jLabel4.setText(unittype);
            */
            jPanel3.setVisible(false);
            jTextField5.requestFocus();
        }
        catch(Exception ex)
				{
    				 System.out.println("Error ...."+ex);
				} 
        /*else if(evt.getKeyCode()==evt.VK_DOWN) {
            if(jPanel3.isVisible()==false)
                jPanel3.setVisible(true);
            jList2.setSelectedIndex(jList2.getSelectedIndex()+1);
            jList2.ensureIndexIsVisible(jList2.getSelectedIndex());
        } else if(evt.getKeyCode()==evt.VK_UP) {
            if(jPanel3.isVisible()==false)
                jPanel3.setVisible(true);
            jList2.setSelectedIndex(jList2.getSelectedIndex()-1);
            jList2.ensureIndexIsVisible(jList2.getSelectedIndex());
        }*/
        if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) {
            jPanel3.setVisible(true);
        }
        if(evt.getKeyCode()==evt.VK_ESCAPE) {
            jPanel3.setVisible(false);
        }
        if(evt.getKeyCode()==evt.VK_F1) {
            jPanel3.setVisible(true);
        }
        
        }
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
// TODO add your handling code here:
        //jPanel2.setVisible(false);
        try
        {
        	ZedInterface inf=null;
ZedInterfaceForMedical obj=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	obj=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		obj=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}	
        	jTextField10.setText(obj.getCmpName(jTextField11.getText()));
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
// TODO add your handling code here:
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
        	String itemNm[]=uc.getItemNames(jTextField10.getText());//""+coNmVc.elementAt(jList1.getSelectedIndex()));
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
    }//GEN-LAST:event_jTextField11FocusGained

    private void jList2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseEntered
// TODO add your handling code here:
        
    }//GEN-LAST:event_jList2MouseEntered

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked
// TODO add your handling code here:
        jTextField11.setText(""+itemNmVc.elementAt(jList2.getSelectedIndex()));
        jPanel3.setVisible(false);
        //utilityClass obj=new utilityClass();
        try
        {
        	ZedInterface inf=null;
ZedInterfaceForMedical obj=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	obj=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		obj=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
        	jTextField10.setText(obj.getCmpName(jTextField11.getText()));
        String packing=obj.getPacking(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel4.setText(packing);
        
        String packingType=obj.getQtyType(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel8.setText(packingType);
		}
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        
        
       /* String vat=obj.getVat(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel18.setText(vat);
        
        String mrp=obj.getMrp(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel20.setText(mrp);*/
        
        jTextField5.requestFocus();
    }//GEN-LAST:event_jList2MouseClicked

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
// TODO add your handling code here:
     /*   jTextField11.setText(""+itemNmVc.elementAt(jList2.getSelectedIndex()));
        try
        {
            utilityClass obj=new utilityClass();
            jTextField10.setText(obj.getCmpName(jTextField11.getText()));
        }
        catch(Exception e)
        {
            System.out.println("Error in valueChanged Event...."+e);
        }*/
    }//GEN-LAST:event_jList2ValueChanged

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
// TODO add your handling code here:
        jTextField10.setText(""+coNmVc.elementAt(jList1.getSelectedIndex()));
        jPanel2.setVisible(false);
        jTextField11.requestFocus();
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
// TODO add your handling code here:
        // jTextField4.setText(""+coNmVc.elementAt(jList1.getSelectedIndex()));
    }//GEN-LAST:event_jList1ValueChanged

    private void jList1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList1FocusLost
// TODO add your handling code here:
        jPanel2.setVisible(false);
    }//GEN-LAST:event_jList1FocusLost

    private void jList1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList1FocusGained
// TODO add your handling code here:
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jList1FocusGained

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
// TODO add your handling code here
        //jPanel1.setVisible(true);
       if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) {
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
        	if(uc.isBlank(jTextField10.getText())==false) {
                String crntText=jTextField10.getText().toUpperCase();
                int l=coNmVc.size();
                jList1.clearSelection();
                for(int i=0;i<l;i++) {
                    String conm=""+coNmVc.elementAt(i);
                    int indx=conm.indexOf(crntText);
                    if(indx==0) {
                        jList1.setSelectedIndex(i);
                        jList1.ensureIndexIsVisible(i);
                        break;
                    }
                }
            }
        
        }
	
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
          }
          else if(evt.getKeyCode()!=evt.VK_ENTER && evt.getKeyCode()!=evt.VK_ESCAPE && evt.getKeyCode()!=evt.VK_DOWN && evt.getKeyCode()!=evt.VK_UP) {
            jList1.clearSelection();
            }  
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
// TODO add your handling code here:
        
        /*if(evt.getKeyCode()==evt.VK_ENTER) {
            utilityClass uc=new utilityClass();
            if(jList1.getSelectedIndex()>=0){
                jTextField10.setText(""+coNmVc.elementAt(jList1.getSelectedIndex()));
            }
            jPanel2.setVisible(false);
            jTextField11.requestFocus();
        } else if(evt.getKeyCode()==evt.VK_DOWN) {
            if(jPanel2.isVisible()==false)
                jPanel2.setVisible(true);
            jList1.setSelectedIndex(jList1.getSelectedIndex()+1);
            jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
        } else if(evt.getKeyCode()==evt.VK_UP) {
            if(jPanel2.isVisible()==false)
                jPanel2.setVisible(true);
            jList1.setSelectedIndex(jList1.getSelectedIndex()-1);
            jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
        }
        if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) {
            jPanel2.setVisible(true);
        }
        if(evt.getKeyCode()==evt.VK_ESCAPE) {
            jPanel2.setVisible(false);
        }
        if(evt.getKeyCode()==evt.VK_F1) {
            jPanel2.setVisible(true);
        }*/
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusLost
// TODO add your handling code here:
        //jPanel1.setVisible(false);
    }//GEN-LAST:event_jTextField10FocusLost

    private void jTextField10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusGained
// TODO add your handling code here:
        ///jPanel1.setVisible(true);
    }//GEN-LAST:event_jTextField10FocusGained

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
        int cnfrm=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure?","Confirmation",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
        if(cnfrm==javax.swing.JOptionPane.YES_OPTION)
        {
            dtm2.removeRow(jTable2.getSelectedRow());
            for(int r=0;r<dtm2.getRowCount();r++)
            {
                jTable2.setValueAt(""+(r+1)+". ",r,0);
            }
            setSummery();
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
// TODO add your handling code here:
        if(evt.getModifiers()==4)
        {
            int r=jTable2.getSelectedRow();
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
            jPopupMenu1.show(jTable2,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        //clearFullScrean();
        orderCancelation();
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton6.setEnabled(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void orderCancelation()
    {
        int cnfrm=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure to cancel order ?","Warning !",javax.swing.JOptionPane.WARNING_MESSAGE);
        if(cnfrm==javax.swing.JOptionPane.YES_OPTION)
        {
            String query="update orderSmry set status=2 where oNo="+orderNo;
            //utilityClass ut=new utilityClass();
            try
        {
        	ZedInterface inf=null;
ZedInterfaceForMedical ut=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	ut=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		ut=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
        	ut.saveOrUpdateResultSet(query);
		}
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
            
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        if(setDataInTable()==0)
        {
            clearEntryScrean();
            jTextField11.requestFocus();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
   
    private int setDataInTable()
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
            if(uc.isBlank(jTextField11.getText())==true)   //jComboBox2.getSelectedIndex()==0)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect particular name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField11.requestFocus();
                flag=1;
            }
            else if(uc.isBlank(jTextField5.getText())==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField5.requestFocus();
                flag=1;
            }
            else if(uc.isInteger(jTextField5.getText())==false)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField5.requestFocus();
                jTextField5.selectAll();
                flag=1;
            }
            if(flag==0)
            {
                String data[]=new String[4];
                data[0]=""+(jTable2.getRowCount()+1)+". ";
                data[1]=""+jTextField10.getText();//jComboBox1.getSelectedItem();
                data[2]=jTextField11.getText().toUpperCase();
                data[3]=jTextField5.getText();
                dtm2.addRow(data);
                setSummery();
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Error in setDataInTable method in MakeOrder class...."+e);
        }
        return flag;
    }
    private void setSummery()//total items
    {
        //TOTAL NO. OF ITEM PURCHASED
        jLabel22.setText(""+dtm2.getRowCount());

        
    }
    private void clearEntryScrean()
    {
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField5.setText("");
    }
    private void clearFullScrean()
    {
        
        while(dtm2.getRowCount()>0)     dtm2.removeRow(0);
        jTextArea1.setText("");
        jTextField1.setText("");
        
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
        	partyNm=uc.getPurPartyNames();
        	purPartyNmVc.removeAllElements();
        	for(int i=1;i<partyNm.length;i++)
        	{
            	purPartyNmVc.addElement(partyNm[i]);
        	}
        	jList4.setListData(purPartyNmVc);
        
        	String query="select max(oNo) from orderSmry";
        	int orderNo=uc.getMaxValue(query);
        	orderNo+=1;
		}
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
        
      //  jTextField2.setText(""+orderNo);
        java.util.Date dt=new java.util.Date();
        jLabel30.setText(""+dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
        jButton1.setEnabled(true);
        jTextField1.requestFocus();
        
        
    }
    
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
       updateData();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    private void updateData()
    {
        try
        {
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;
            utilityClass uc=new utilityClass();*/
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
            String query;
            //String query="select max(oNo) from orderSmry";
            //int orderNo=uc.getMaxValue(query);
            String dt1[]=jLabel30.getText().split("/");
            String entrydate=dt1[1]+"/"+dt1[0]+"/"+dt1[2];
            String partynm=jTextField1.getText();
            String partyads=jTextArea1.getText();
            int flag=0;
            if(uc.isBlank(jTextField1.getText())==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter name of party.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField1.requestFocus();
                flag=1;
            }                      
            if(flag==0)
            {
                
            System.out.println("A...");
            int totalitems=Integer.parseInt(jLabel22.getText());
            //java.sql.Statement st=connection.createStatement();
            //updated here----------------------------
            inf.executeUpdateQuery("delete *from orderSmry where oNo="+orderNo+"");
            inf.executeUpdateQuery("delete *from orderDtl where oNo="+orderNo+"");
            savePartyWithCheckExistingParty();
            //----------------------------------------
            query="insert into orderSmry values("+orderNo+",'"+entrydate+"','"+partynm+"','"+partyads+"',"+totalitems+",0)";
            uc.saveOrUpdateResultSet(query);
            System.out.println("C...");
            for(int r=0;r<dtm2.getRowCount();r++)
            {
                String coname=""+jTable2.getValueAt(r,1);
                String itemnm=""+jTable2.getValueAt(r,2);
                //String packing=""+jTable2.getValueAt(r,5);
                int qty=Integer.parseInt(""+jTable2.getValueAt(r,3));
                query="insert into orderDtl values("+orderNo+",'"+coname+"','"+itemnm+"',"+qty+")";
                uc.saveOrUpdateResultSet(query);
            }
            //connection.close();
            javax.swing.JOptionPane.showMessageDialog(this,"Saveing process completed, successfully.","Information",javax.swing.JOptionPane.INFORMATION_MESSAGE);
            jButton1.setEnabled(false);
            //clearFullScrean();
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error..783..."+ex);
        }
    }
    
    private void savePartyWithCheckExistingParty()
    {
        boolean flag=true;
        try
        {
            for(int i=0;i<partyNm.length;i++)
            {
                if(jTextField1.getText().equalsIgnoreCase(partyNm[i]))
                {
                    flag=false;
                }
            }
            if(flag)
            {
                /*ConnectDatabase cd=new ConnectDatabase();
                java.sql.Connection connection = cd.getConnection();
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
                String query="select max(partyCode) from purchasePartyMaster";
                //utilityClass ut=new utilityClass();
                int partyCode=inf.getMaxValue(query);
                partyCode+=1;
                query="insert into purchasePartyMaster values("+partyCode+",'"+jTextField1.getText()+"','"+jTextArea1.getText()+"','','','')";
                inf.executeUpdateQuery(query);
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in savePartyWithCheckExistingParty in MakePurchase class .."+e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables
    javax.swing.text.MaskFormatter mask;
    javax.swing.table.DefaultTableModel dtm2;
    java.util.Vector coNmVc;
    java.util.Vector itemNmVc;
    java.util.Vector purPartyNmVc;
    String partyNm[];
    int orderNo;
}
