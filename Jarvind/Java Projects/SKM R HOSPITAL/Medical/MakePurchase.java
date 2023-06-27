/*
 * MakePurchase.java
 *
 * Created on April 8, 2010, 9:15 AMcoNmVc
 */

//package medretail;
import java.rmi.*;
import javax.swing.*;
/**
 *
 * @author  Deep Pal
 */
public class MakePurchase extends javax.swing.JInternalFrame {
    
    /** Creates new form MakePurchase */
    public MakePurchase(javax.swing.JDesktopPane jDesktopPane1) {
        initComponents();
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
        try
        {
        ZedInterface inf=null;
ZedInterfaceForMedical inf1=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
        
        JLabel lbl1=new JLabel("Medicine Type");
        lbl1.setBounds(20, 425, 120, 15);
        getContentPane().add(lbl1);
        cb_typeOfDrug=new JComboBox();
        String arr[]=inf.getResultSetAs_1D_Array("select drugType from purchase_Whole_Drug_As order by drugType");
        if(arr!=null)
        {
        	for(int i=0;i<arr.length;i++)
        		cb_typeOfDrug.addItem(arr[i]);
        }
        cb_typeOfDrug.setBounds(20,440,120,20);
        getContentPane().add(cb_typeOfDrug);
        
        JLabel lbl2=new JLabel("Payment As");
        lbl2.setBounds(160, 425, 120, 15);
        getContentPane().add(lbl2);
        cb_typeOfPay=new JComboBox();
        arr=inf.getResultSetAs_1D_Array("select payAS from purchase_Pay_As order by payAS");
        if(arr!=null)
        {
        	for(int i=0;i<arr.length;i++)
        		cb_typeOfPay.addItem(arr[i]);
        }
        cb_typeOfPay.setBounds(160,440,120,20);
        getContentPane().add(cb_typeOfPay);
        	
        //utilityClass uc=new utilityClass();
        String coNm[]=inf1.getCmpNames();
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
        
        partyNm=inf1.getPurPartyNames();
        purPartyNmVc=new java.util.Vector();
        for(int i=1;i<partyNm.length;i++)
        {
            purPartyNmVc.addElement(partyNm[i]);
        }
        jList4.setListData(purPartyNmVc);
        jPanel4.setVisible(false);
        
        }
        catch(Exception e)
        {
        	System.out.println("Errr.."+e);
        }
        String heading[]={"S.No.","Company Name","Batch No.","Exp. Date","Particular","Packing","Qty.","Sp. Dis.","Trade (Rs.)","Disc. (%)","VAT (%)","Amount (Rs.)","M.R.P. (Rs.)"};
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

      		column=jTable2.getColumn("Batch No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(100);
                
      		column=jTable2.getColumn("Exp. Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);
                
                column=jTable2.getColumn("Particular");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(200);

      		column=jTable2.getColumn("Qty.");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(60);
                //ar","Packing","Qty.","Sp. Dis.","Trade (Rs.)","Disc. (%)","VAT (%)","Amount (Rs.)","M.R.P. (Rs.)"};
                
                column=jTable2.getColumn("Sp. Dis.");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);

                column=jTable2.getColumn("Trade (Rs.)");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);

                column=jTable2.getColumn("Disc. (%)");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);

                column=jTable2.getColumn("VAT (%)");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);

                column=jTable2.getColumn("Amount (Rs.)");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);
        
                column=jTable2.getColumn("M.R.P. (Rs.)");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);
        
        /*try
        {
            utilityClass obj=new utilityClass();
            String compNameList[]=obj.getCmpNames();            
            jComboBox1.removeAllItems();
            for(int i=0;i<compNameList.length;i++)
            {
                jComboBox1.addItem(compNameList[i]);
            }
        }
        catch(Exception ex)
        {
            System.out.println("error..."+ex);
        }*/
        
        //get system date
        java.util.Date dt=new java.util.Date();
        expDateLb.setText(dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
        jLabel30.setText(dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900));
         
        /*try 
        { 
            mask = new javax.swing.text.MaskFormatter("##/##/##"); 
            mask.setPlaceholderCharacter('_');
            expDateLb=new javax.swing.JLabel();
            //mask.setPlaceholderCharacter('_'); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }*/ 
        //dt_tax_inv = new JFormattedTextField(mask); 
        
        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        reshape((dm.width-800)/2,(dm.height-600)/2,800,500);
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
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        //jLabel18 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JTextField();//updated
        jLabel19 = new javax.swing.JLabel();
        //jLabel20 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        expDateLb = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
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
        setTitle("Make New Purchase");
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
        jLabel3.setText("Book Number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 50, 75, 20);

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

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField2);
        jTextField2.setBounds(90, 50, 80, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel4.setText("Serial No.");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 50, 80, 20);

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField3);
        jTextField3.setBounds(240, 50, 110, 20);

        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "About Particular"));
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
        jPanel3.setBounds(350, 40, 220, 70);

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

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(100, 40, 190, 70);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel5.setText("Company Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 20, 100, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel6.setText("Particular");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(290, 20, 100, 20);

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setOpaque(true);
        jPanel1.add(jLabel7);
        jLabel7.setBounds(620, 20, 150, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel8.setText("Packing");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(570, 20, 60, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel9.setText("Batch No.");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 50, 70, 20);

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField4);
        jTextField4.setBounds(70, 50, 110, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel10.setText("Exp. Date");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(200, 50, 60, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel11.setText("Qty");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(400, 50, 40, 20);

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField5);
        jTextField5.setBounds(430, 50, 70, 20);

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setOpaque(true);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(510, 50, 100, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel13.setText("Sp. Dis.");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(620, 50, 50, 20);

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField6);
        jTextField6.setBounds(670, 50, 50, 20);

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField7);
        jTextField7.setBounds(730, 50, 40, 20);

        jLabel14.setText("+");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(720, 50, 10, 20);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel15.setText("Trade Rate (Rs.)");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(10, 80, 90, 20);

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField8);
        jTextField8.setBounds(110, 80, 80, 20);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel16.setText("Discount (%)");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(200, 80, 80, 20);

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField9);
        jTextField9.setBounds(280, 80, 40, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel17.setText("VAT (%)");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(340, 80, 60, 20);

        jLabel18.setBackground(new java.awt.Color(204, 204, 204));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setOpaque(true);
        jPanel1.add(jLabel18);
        jLabel18.setBounds(390, 80, 90, 20);

        jLabel19.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel19.setText("M. R. P. (Rs.)");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(500, 80, 80, 20);

        jLabel20.setBackground(new java.awt.Color(204, 204, 204));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setOpaque(true);
        jPanel1.add(jLabel20);
        jLabel20.setBounds(580, 80, 90, 20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.jpg")));
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
        jButton2.setBounds(680, 70, 40, 30);

        expDateLb.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        expDateLb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                expDateLbKeyPressed(evt);
            }
        });

        jPanel1.add(expDateLb);
        expDateLb.setBounds(260, 50, 90, 20);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton5.setMnemonic('d');
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel1.add(jButton5);
        jButton5.setBounds(350, 50, 30, 20);

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

        jPanel1.add(jButton6);
        jButton6.setBounds(730, 70, 40, 29);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 80, 780, 110);

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
        jScrollPane3.setBounds(10, 200, 780, 180);

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
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 20, 360, 50);

        jLabel23.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel23.setText("Total Amount (Rs.)");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(210, 400, 120, 20);

        jLabel24.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel24.setText("R/O");
        getContentPane().add(jLabel24);
        jLabel24.setBounds(460, 400, 40, 20);

        jLabel25.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel25.setText("Grand Total (Rs.)");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(560, 400, 120, 20);

        jLabel26.setBackground(new java.awt.Color(204, 204, 204));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setOpaque(true);
        getContentPane().add(jLabel26);
        jLabel26.setBounds(320, 400, 110, 20);

        jLabel27.setBackground(new java.awt.Color(204, 204, 204));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setOpaque(true);
        getContentPane().add(jLabel27);
        jLabel27.setBounds(490, 400, 50, 20);

        jLabel28.setBackground(new java.awt.Color(204, 204, 204));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setOpaque(true);
        getContentPane().add(jLabel28);
        jLabel28.setBounds(660, 400, 130, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.gif")));
        jButton1.setMnemonic('s');
        jButton1.setText("Save");
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
        jButton1.setBounds(340, 440, 140, 30);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 10));
        jLabel29.setText("Entry Date :");
        getContentPane().add(jLabel29);
        jLabel29.setBounds(620, 0, 70, 20);

        jLabel30.setFont(new java.awt.Font("Arial", 1, 10));
        jLabel30.setForeground(new java.awt.Color(255, 153, 51));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel30);
        jLabel30.setBounds(680, 0, 80, 20);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reset.gif")));
        jButton3.setMnemonic('r');
        jButton3.setText("Reset Screen");
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
        jButton3.setBounds(490, 440, 190, 30);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton4.setMnemonic('c');
        jButton4.setText("Close");
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
        jButton4.setBounds(690, 440, 100, 30);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton7.setToolTipText("Change current date");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton7);
        jButton7.setBounds(770, 0, 20, 20);

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
ZedInterfaceForMedical inf1=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
                //utilityClass ut=new utilityClass();
                String ads=inf1.returnSingleData(query);
                jTextArea1.setText(ads);
                jTextArea1.requestFocus();
                }
                catch(Exception e)
                {
                	System.out.println("Errr..cc...."+e);
                }
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
        jTextField11.setText(jTable2.getValueAt(r,4).toString());   //item name
        jTextField4.setText(jTable2.getValueAt(r,2).toString());    //batch no.
        expDateLb.setText(jTable2.getValueAt(r,3).toString());      //expiry date
        jTextField5.setText(jTable2.getValueAt(r,6).toString());    //qty
        String spDis=jTable2.getValueAt(r,7).toString();
        if(spDis.equals("")==false)
        {
            
            jTextField6.setText(spDis.substring(0,spDis.indexOf("+")).trim());    //sp. dis.
            jTextField7.setText(spDis.substring(spDis.indexOf("+")+1,spDis.length()).trim());    //sp. dis.
            
        }
        else
        {
            jTextField6.setText("");    //sp. dis.
            jTextField7.setText("");    //sp. dis.            
        }      
        jTextField8.setText(jTable2.getValueAt(r,8).toString());    //trade
        String dis=jTable2.getValueAt(r,9).toString();
        if(dis.equals("")==false)
        {
            jTextField9.setText(dis);    //discount
        }
        else
        {
            jTextField9.setText("");    //discount
        }
        jLabel18.setText(jTable2.getValueAt(r,10).toString());      //VAT
        jLabel20.setText(jTable2.getValueAt(r,12).toString());      //MRP
        jLabel7.setText(jTable2.getValueAt(r,5).toString());        //Packing
        
        //utilityClass obj=new utilityClass(); 
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
        	String packingType=uc.getQtyType(jTextField11.getText().trim());   //unit
        	jLabel12.setText(packingType);
        }
        catch(Exception e)       
        {
        	System.out.println("Errr.."+e);
        }
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
// TODO add your handling code here:
        if(updateDataInTable()==0)
        {
            clearEntryScrean();
            jTextField10.requestFocus();
        }
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
        if(updateDataInTable()==0)
        {
            clearEntryScrean();
            jTextField10.requestFocus();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)    jTextField11.requestFocus();
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)    jTextField3.requestFocus();
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)    
        {
            if(jTextArea1.getText().trim().equals(""))
            {
                jTextArea1.setText("");//jTextArea1.getText().substring(0,jTextArea1.getText().length()-1));
                jTextField2.requestFocus();
            }
            else if((jTextArea1.getText().substring(jTextArea1.getText().length()-1,jTextArea1.getText().length())).equals("\n"))
            {
                jTextArea1.setText(jTextArea1.getText().substring(0,jTextArea1.getText().length()-1));
                jTextField2.requestFocus();
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
                try
                {
                	ZedInterface inf=null;
ZedInterfaceForMedical inf1=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
                	String query="select ads from purchasePartyMaster where partyNm='"+jTextField1.getText()+"'";
                	//utilityClass ut=new utilityClass();
                	String ads=inf1.returnSingleData(query);
                	jTextArea1.setText(ads);
                	jTextArea1.requestFocus();
                }
                catch(Exception e)
                {
                	System.out.println("Errr..."+e);
                }
                
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
            clearFullScrean();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            saveData();
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
        {
            jTextField6.requestFocus();
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton2.requestFocus();
        }
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
// TODO add your handling code here:
         if(evt.getKeyCode()==10)
        {
            jTextField9.requestFocus();
        }
    }//GEN-LAST:event_jTextField8KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
// TODO add your handling code here:
         if(evt.getKeyCode()==10)
        {
            jTextField8.requestFocus();
        }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField7.requestFocus();
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void expDateLbKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_expDateLbKeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField5.requestFocus();
        }
    }//GEN-LAST:event_expDateLbKeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            expDateLb.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

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
try
{

	ZedInterface inf=null;
ZedInterfaceForMedical inf1=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
	
        if(evt.getKeyCode()==evt.VK_ENTER) {
            if(jList2.getSelectedIndex()>=0){
                jTextField11.setText(""+itemNmVc.elementAt(jList2.getSelectedIndex()));
                //utilityClass obj=new utilityClass();
                jTextField10.setText(inf1.getCmpName(jTextField11.getText()));
            }
            
            //utilityClass obj=new utilityClass();
        String packing=inf1.getPacking(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel7.setText(packing);
        
        String packingType=inf1.getQtyType(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel12.setText(packingType);
        
        String vat=inf1.getVat(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel18.setText(vat);
        
        String mrp=inf1.getMrp(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
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
            jTextField4.requestFocus();
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
 catch(Exception e)
{
	System.out.println("Errr..."+e);
}
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusLost
// TODO add your handling code here:
        //jPanel2.setVisible(false);
        //utilityClass obj=new utilityClass();
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
        	jTextField10.setText(uc.getCmpName(jTextField11.getText()));
        }
        catch(Exception e)
		{               		

			System.out.println("Errr..."+e);
		}
        
    }//GEN-LAST:event_jTextField11FocusLost

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
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
        String itemNm[]=uc.getItemNames(jTextField10.getText());//""+coNmVc.elementAt(jList1.getSelectedIndex()));
        itemNmVc.removeAllElements();
        
        for(int i=1;i<itemNm.length;i++) {
            itemNmVc.addElement(itemNm[i]);
        }
        jList2.setListData(itemNmVc);
        }
        catch(Exception e)
		{               		
			System.out.println("Errr..."+e);
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
        //utilityClass obj=new utilityClass();
        jTextField10.setText(obj.getCmpName(jTextField11.getText()));
        String packing=obj.getPacking(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel7.setText(packing);
        
        String packingType=obj.getQtyType(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel12.setText(packingType);
        
        String vat=obj.getVat(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel18.setText(vat);
        
        String mrp=obj.getMrp(jTextField11.getText().trim());//,jComboBox2.getSelectedItem().toString());
        jLabel20.setText(mrp);
        }
        catch(Exception e)
		{               		
			System.out.println("Errr..."+e);
		}
        jTextField4.requestFocus();
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
            if(jTextField10.getText().trim().equals("")) {
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
        } else if(evt.getKeyCode()!=evt.VK_ENTER && evt.getKeyCode()!=evt.VK_ESCAPE && evt.getKeyCode()!=evt.VK_DOWN && evt.getKeyCode()!=evt.VK_UP) {
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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        Cal X=new Cal();
        expDateLb.setText(X.getdate());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        clearFullScrean();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        if(setDataInTable()==0)
        {
            clearEntryScrean();
            jTextField10.requestFocus();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private int setDataInTable()
    {
        double amt=0;
        int flag=0;
        String data[]=new String[13];
        data[0]=""+(jTable2.getRowCount()+1)+". ";
        data[1]=""+jTextField10.getText();//jComboBox1.getSelectedItem();
        data[2]=jTextField4.getText().toUpperCase();
        data[3]=expDateLb.getText();
        data[4]=""+jTextField11.getText();//jComboBox2.getSelectedItem();
        data[5]=""+jLabel7.getText();
        //qty
        data[6]=""+jTextField5.getText();
        //special descount
        data[7]="";
        //trade
        data[8]=""+jTextField8.getText();
        
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
        /*if(jComboBox1.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect company name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jComboBox1.requestFocus();
            flag=1;
        }
        else*/
        if(uc.isBlank(jTextField11.getText())==true)   //jComboBox2.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect particular name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField11.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(data[2])==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter batch number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField4.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(data[3])==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter expiry date of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            expDateLb.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(data[6])==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(data[8])==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter trade rate of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField8.requestFocus();
            flag=1;
        }
        else if(uc.isInteger(data[6])==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            jTextField5.selectAll();
            flag=1;
        }
        else if((jTextField6.getText().trim().equals("")==false && jTextField7.getText().trim().equals("")==false) && uc.isInteger(jTextField6.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in special discount.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField6.requestFocus();
            jTextField6.selectAll();
            flag=1;
        }
        else if((jTextField6.getText().trim().equals("")==false && jTextField7.getText().trim().equals("")==false) && uc.isInteger(jTextField7.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in special discount.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField7.requestFocus();
            jTextField7.selectAll();
            flag=1;
        }
        
        else if(uc.isDouble(data[8])==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in trade rate.\nOnly number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField8.requestFocus();
            jTextField8.selectAll();
            flag=1;
        }
        else if(jTextField9.getText().trim().equals("")==false && uc.isDouble(jTextField9.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in discount.\nOnly number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField9.requestFocus();
            jTextField9.selectAll();
            flag=1;
        }
        //update------
        else if(jLabel18.getText().trim().equals("")==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Input Vat% ?","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jLabel18.requestFocus();
            jLabel18.selectAll();
            flag=1;
        }
        else if((jLabel18.getText().trim().equals("")==false && jLabel18.getText().trim().equals("")==false) && uc.isDouble(jLabel18.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in vat.\nOnly  number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jLabel18.requestFocus();
            jLabel18.selectAll();
            flag=1;
        }
        else if(jLabel20.getText().trim().equals("")==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Input MRP ?","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jLabel20.requestFocus();
            jLabel20.selectAll();
            flag=1;
        }
        else if((jLabel20.getText().trim().equals("")==false && jLabel20.getText().trim().equals("")==false) && uc.isDouble(jLabel20.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in mrp.\nOnly number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jLabel20.requestFocus();
            jLabel20.selectAll();
            flag=1;
        }
        //-----------------------
        if(flag==0)
        {
         
        if(jTextField6.getText().trim().equals("")==false && jTextField7.getText().trim().equals("")==false)
            data[7]=""+jTextField6.getText()+"+"+jTextField7.getText();
        
        //trade
        data[8]=""+(new java.math.BigDecimal(jTextField8.getText())).setScale(2,5);
        
        //discount
        data[9]="";
        if(jTextField9.getText().trim().equals("")==false)
            data[9]=""+(new java.math.BigDecimal(jTextField9.getText())).setScale(2,5);
        //vat
        data[10]=""+(new java.math.BigDecimal(jLabel18.getText())).setScale(2,5);
        //amount
        double spD1=0,spD2=0,trdRate=0,qty=0,disRate=0,vatRate=0;
        trdRate=Double.valueOf(jTextField8.getText().trim());
        qty=Double.valueOf(jTextField5.getText().trim());
        //if special discount
        if(jTextField6.getText().trim().equals("")==false && jTextField7.getText().trim().equals("")==false)
        {
            spD1=Double.valueOf(jTextField6.getText().trim());
            spD2=Double.valueOf(jTextField7.getText().trim());
            trdRate=(trdRate*spD1)/(spD1+spD2);
        }    
        amt=qty*trdRate;
        //if discount
        if(jTextField9.getText().trim().equals("")==false)  
        {
            disRate=Double.valueOf(jTextField9.getText().trim());
            amt=amt-((amt*disRate)/100);
        }
        //if VAT
        if(jLabel18.getText().trim().equals("")==false)  
        {
            vatRate=Double.valueOf(jLabel18.getText().trim());
            amt=amt+((amt*vatRate)/100);
        }
        data[11]=""+(new java.math.BigDecimal(amt)).setScale(2,5);
        //mrp
        data[12]=""+(new java.math.BigDecimal(jLabel20.getText())).setScale(2,5);
        dtm2.addRow(data);
        
        
        
        setSummery();
        
        }
        }
        catch(Exception e)
		{               		
			System.out.println("Errr..."+e);
		}   
        return flag;
    }
    private void setSummery()
    {
        //TOTAL NO. OF ITEM PURCHASED
        jLabel22.setText(""+dtm2.getRowCount());

        //TOTAL AMOUNT
        jLabel26.setText(""+(new java.math.BigDecimal(getTotalAmount())).setScale(2,5));
        
        //R/O AMOUNT
        int intAmt=Double.valueOf(jLabel26.getText()).intValue();
        double roAmt=(Double.valueOf(jLabel26.getText())-intAmt);
        if(roAmt>=0.5)
            roAmt=1-roAmt;
        else
            roAmt=-roAmt;
        jLabel27.setText(""+(new java.math.BigDecimal(roAmt)).setScale(2,5));
        //NET AMOUNT
        jLabel28.setText(""+(new java.math.BigDecimal(Double.valueOf(jLabel26.getText())+roAmt)).setScale(2,5));
    }
    private void clearEntryScrean()
    {
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField4.setText("");
        //expDateLb.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        
    }
    private void clearFullScrean()
    {
        
        while(dtm2.getRowCount()>0)     dtm2.removeRow(0);
        jTextArea1.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField4.setText("");
        //expDateLb.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jLabel22.setText("");
        jLabel26.setText("");
        jLabel27.setText("");
        jLabel28.setText("");
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
        partyNm=uc.getPurPartyNames();
        purPartyNmVc.removeAllElements();
        for(int i=1;i<partyNm.length;i++)
        {
            purPartyNmVc.addElement(partyNm[i]);
        }
        jList4.setListData(purPartyNmVc);
        jButton1.setEnabled(true);
        }
        catch(Exception e)
		{               		
			System.out.println("Errr..."+e);
		}
        jTextField1.requestFocus();
        
        
    }
    private double getTotalAmount()
    {
        double totalAmt=0;
        //get total amount
        for(int i=0;i<dtm2.getRowCount();i++)
        {
            totalAmt+=Double.valueOf(""+jTable2.getValueAt(i,11));
        }
        return totalAmt;
    }
    private int updateDataInTable()
    {
        double amt=0;
        int flag=0;
        String data[]=new String[13];
        data[0]=""+(jTable2.getRowCount()+1)+". ";
        data[1]=""+jTextField10.getText();//jComboBox1.getSelectedItem();
        data[2]=jTextField4.getText().toUpperCase();
        data[3]=expDateLb.getText();
        data[4]=""+jTextField11.getText();//jComboBox2.getSelectedItem();
        data[5]=""+jLabel7.getText();
        //qty
        data[6]=""+jTextField5.getText();
        //special descount
        data[7]="";
        //trade
        data[8]=""+jTextField8.getText();
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
        /*if(jComboBox1.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect company name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jComboBox1.requestFocus();
            flag=1;
        }
        else*/
        if(uc.isBlank(jTextField11.getText())==true)   //jComboBox2.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nSelect particular name.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField11.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(data[2])==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter batch number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField4.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(data[3])==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter expiry date of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            expDateLb.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(data[6])==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter quantity.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            flag=1;
        }
        else if(uc.isBlank(data[8])==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter trade rate of particular.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField8.requestFocus();
            flag=1;
        }
        else if(uc.isInteger(data[6])==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in quantity.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            jTextField5.selectAll();
            flag=1;
        }
        else if((jTextField6.getText().trim().equals("")==false && jTextField7.getText().trim().equals("")==false) && uc.isInteger(jTextField6.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in special discount.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField6.requestFocus();
            jTextField6.selectAll();
            flag=1;
        }
        else if((jTextField6.getText().trim().equals("")==false && jTextField7.getText().trim().equals("")==false) && uc.isInteger(jTextField7.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in special discount.\nOnly whole number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField7.requestFocus();
            jTextField7.selectAll();
            flag=1;
        }
        else if(uc.isDouble(data[8])==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in trade rate.\nOnly number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField8.requestFocus();
            jTextField8.selectAll();
            flag=1;
        }
        else if(jTextField9.getText().trim().equals("")==false && uc.isDouble(jTextField9.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in discount.\nOnly number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jTextField9.requestFocus();
            jTextField9.selectAll();
            flag=1;
        }
        //update------
        else if(jLabel18.getText().trim().equals("")==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Input Vat% ?","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jLabel18.requestFocus();
            jLabel18.selectAll();
            flag=1;
        }
        else if((jLabel18.getText().trim().equals("")==false && jLabel18.getText().trim().equals("")==false) && uc.isDouble(jLabel18.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in vat.\nOnly  number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jLabel18.requestFocus();
            jLabel18.selectAll();
            flag=1;
        }
        else if(jLabel20.getText().trim().equals("")==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nPlease Input MRP ?","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jLabel20.requestFocus();
            jLabel20.selectAll();
            flag=1;
        }
        else if((jLabel20.getText().trim().equals("")==false && jLabel20.getText().trim().equals("")==false) && uc.isDouble(jLabel20.getText().trim())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this,"Error!\nInvalid character found in mrp.\nOnly number is allowed.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
            jLabel20.requestFocus();
            jLabel20.selectAll();
            flag=1;
        }
        //--------------------
        if(flag==0)
        {
         
        if(jTextField6.getText().trim().equals("")==false && jTextField7.getText().trim().equals("")==false)
            data[7]=""+jTextField6.getText()+"+"+jTextField7.getText();
        
        //trade
        data[8]=""+(new java.math.BigDecimal(jTextField8.getText())).setScale(2,5);
        
        //discount
        data[9]="";
        if(jTextField9.getText().trim().equals("")==false)
            data[9]=""+(new java.math.BigDecimal(jTextField9.getText())).setScale(2,5);
        //vat
        data[10]=""+(new java.math.BigDecimal(jLabel18.getText())).setScale(2,5);
        //amount
        double spD1=0,spD2=0,trdRate=0,qty=0,disRate=0,vatRate=0;
        trdRate=Double.valueOf(jTextField8.getText().trim());
        qty=Double.valueOf(jTextField5.getText().trim());
        //if special discount
        if(jTextField6.getText().trim().equals("")==false && jTextField7.getText().trim().equals("")==false)
        {
            spD1=Double.valueOf(jTextField6.getText().trim());
            spD2=Double.valueOf(jTextField7.getText().trim());
            trdRate=(trdRate*spD1)/(spD1+spD2);
        }    
        amt=qty*trdRate;
        //if discount
        if(jTextField9.getText().trim().equals("")==false)  
        {
            disRate=Double.valueOf(jTextField9.getText().trim());
            amt=amt-((amt*disRate)/100);
        }
        //if VAT
        if(jLabel18.getText().trim().equals("")==false)  
        {
            vatRate=Double.valueOf(jLabel18.getText().trim());
            amt=amt+((amt*vatRate)/100);
        }
        data[11]=""+(new java.math.BigDecimal(amt)).setScale(2,5);
        //mrp
        data[12]=""+(new java.math.BigDecimal(jLabel20.getText())).setScale(2,5);
        
        int r=jTable2.getSelectedRow();
        dtm2.removeRow(r);
        dtm2.insertRow(r,data);
        //dtm2.addRow(data);
        
        for(r=0;r<dtm2.getRowCount();r++)
            {
                jTable2.setValueAt(""+(r+1)+". ",r,0);
            }
        setSummery();
        
        }
        }
        catch(Exception e)
		{               		
			System.out.println("Errr..."+e);
		}   
        return flag;
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        saveData();
        
    }//GEN-LAST:event_jButton1ActionPerformed
    private void saveData()
    {
        try
        {
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.ResultSet rs;
            utilityClass ut=new utilityClass();*/
            ZedInterface inf=null;
ZedInterfaceForMedical inf1=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
            
            int pno=inf1.getNextPurchaseNo();
            java.util.Date dt=new java.util.Date();
            //String entrydate=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);
            String dt1[]=jLabel30.getText().split("/");
            String entrydate=dt1[1]+"/"+dt1[0]+"/"+dt1[2];
            //String entrydate=jLabel30.getText();
            String partynm=jTextField1.getText();
            String partyads=jTextArea1.getText();
            String bookno=jTextField2.getText();
            String srno=jTextField3.getText();
            int flag=0;
            //utilityClass uc=new utilityClass();
            if(inf1.isBlank(jTextField1.getText())==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter name of party.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField1.requestFocus();
                flag=1;
            }
            else if(inf1.isBlank(jTextField2.getText())==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter book number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField2.requestFocus();
                flag=1;
            }    
            else if(inf1.isBlank(jTextField3.getText())==true)
            {
                javax.swing.JOptionPane.showMessageDialog(this,"Error!\nEnter serial number.","Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField3.requestFocus();
                flag=1;
            }    
            
            if(flag==0)
            {
                
            System.out.println("A...");
            int totalitems=Integer.parseInt(jLabel22.getText());
            double totalamt=Double.valueOf(jLabel26.getText());
            double roamt=Double.valueOf(jLabel27.getText());
            double netamt=Double.valueOf(jLabel28.getText());
            //java.sql.Statement st=connection.createStatement();
            //updated here----------------------------
            savePartyWithCheckExistingParty();
            //----------------------------------------
            //System.out.println("B..."+"insert into purchaseSmry values("+pno+",'"+entrydate+"','"+partynm+"','"+partyads+"','"+bookno+"','"+srno+"',"+totalitems+","+totalamt+","+roamt+","+netamt+")");
            inf.executeUpdateQuery("insert into purchaseSmry values("+pno+",'"+entrydate+"','"+partynm+"','"+partyads+"','"+bookno+"','"+srno+"',"+totalitems+","+totalamt+","+roamt+","+netamt+",'"+""+cb_typeOfDrug.getSelectedItem()+"','"+""+cb_typeOfPay.getSelectedItem()+"')");
            //st.executeUpdate("insert into purchaseSmry values("+pno+",'"+entrydate+"','"+partynm+"','"+partyads+"','"+bookno+"','"+srno+"',"+totalitems+","+totalamt+","+roamt+","+netamt+")");
            inf.executeUpdateQuery("insert into purchasePaymentSmry values("+pno+",'"+partynm+"','"+bookno+"','"+srno+"',"+netamt+","+netamt+")");
            
            System.out.println("C...");
            for(int r=0;r<dtm2.getRowCount();r++)
            {
                String coname=""+jTable2.getValueAt(r,1);
                String btno=(""+jTable2.getValueAt(r,2)).toUpperCase();
                String expdate=""+jTable2.getValueAt(r,3);        
                expdate=expdate.substring(expdate.indexOf('/')+1,expdate.lastIndexOf('/'))+"/"+expdate.substring(0,expdate.indexOf('/'))+"/"+expdate.substring(expdate.lastIndexOf('/')+1,expdate.length());
                String itemnm=""+jTable2.getValueAt(r,4);
                String packing=""+jTable2.getValueAt(r,5);
                int qty=Integer.parseInt(""+jTable2.getValueAt(r,6));
                String spdis="";
                if(jTable2.getValueAt(r,7).toString().equals("")==false)
                    spdis=jTable2.getValueAt(r,7).toString();
                double trd=Double.valueOf(""+jTable2.getValueAt(r,8));
                double dis=0;
                if(jTable2.getValueAt(r,9).toString().equals("")==false)
                    dis=Double.valueOf(""+jTable2.getValueAt(r,9));
                double vat=Double.valueOf(""+jTable2.getValueAt(r,10));
                double amt=Double.valueOf(""+jTable2.getValueAt(r,11));
                double mrp=Double.valueOf(""+jTable2.getValueAt(r,12));
                //st.executeUpdate("insert into purchaseDtl values("+pno+",'"+coname+"','"+btno+"','"+expdate+"','"+itemnm+"','"+packing+"',"+qty+",'"+spdis+"',"+trd+","+dis+","+vat+","+amt+","+mrp+")");
                inf.executeUpdateQuery("insert into purchaseDtl values("+pno+",'"+coname+"','"+btno+"','"+expdate+"','"+itemnm+"','"+packing+"',"+qty+",'"+spdis+"',"+trd+","+dis+","+vat+","+amt+","+mrp+")");
                int itemcode=0;
                String typeofitem="";
                String s1[][]=inf.getResultSetAs_2D_Array("select itemCode,typeOfItem,pkging from itemMaster where itemName='"+itemnm+"'",3);
                //rs=st.executeQuery("select * from itemMaster where itemName='"+itemnm+"'");
                if(s1!=null)
                {
                    itemcode=Integer.parseInt(s1[0][0]);
                    typeofitem=s1[0][1];
                    if(typeofitem.equalsIgnoreCase("Tab") || typeofitem.equalsIgnoreCase("Capsule"))
                    {
                    	
                        qty=qty * Integer.parseInt(s1[0][2]);
                    }
                }
                //rs=st.executeQuery("select qty from stockHolding where itemCode="+itemcode+" and batchNo='"+btno+"'");
                String eqty=inf.getSingleValue("select qty from stockHolding where itemCode="+itemcode+" and batchNo='"+btno+"'");
                if(eqty!=null)
                {
                    int existingQty=Integer.parseInt(eqty);
                    qty=qty+existingQty;
                    inf.executeUpdateQuery("update stockHolding set qty="+qty+" where itemCode="+itemcode+" and batchNo='"+btno+"'");
                    //st.executeUpdate("update stockHolding set qty="+qty+" where itemCode="+itemcode+" and batchNo='"+btno+"'");
                }
                else
                {
                    //typeofitem
                    inf.executeUpdateQuery("insert into stockHolding values("+itemcode+","+qty+",'"+inf1.getSmallestQtyType(itemnm)+"','"+btno+"','"+expdate+"')");
                    //st.executeUpdate("insert into stockHolding values("+itemcode+","+qty+",'"+ut.getSmallestQtyType(itemnm)+"','"+btno+"','"+expdate+"')");
                }
                
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
		inf=(ZedInterface)Naming.lookup("rmi://127.0.0.1/ExtendZedServer");
		uc=(ZedInterfaceForMedical)Naming.lookup("rmi://127.0.0.1/ExtendZedServer");
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
    private javax.swing.JTextField expDateLb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JTextField jLabel18;//update
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jLabel20;//update
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
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
    javax.swing.text.MaskFormatter mask;
    javax.swing.table.DefaultTableModel dtm2;
    java.util.Vector coNmVc;
    java.util.Vector itemNmVc;
    java.util.Vector purPartyNmVc;
    String partyNm[];
    JComboBox cb_typeOfDrug,cb_typeOfPay;
}
