package giftcorner;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * purchase_master.java
 * Created on Feb 7, 2014, 2:54:48 PM
 */
/**
 * @author user3
 */
import java.awt.Color;
import java.math.BigDecimal;
import javax.swing.table.JTableHeader;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane.*;
import javax.swing.table.DefaultTableModel;
public class purchase_master extends javax.swing.JInternalFrame {
    /** Creates new form purchase_master */
    public purchase_master() {
        initComponents();
        Color cl=new Color(187,201,255);
        head=jTable1.getTableHeader();
        head.setBackground(cl);
        //jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        head.setForeground(Color.blue);//"purchase_amt","deal","rate_afert_deal","discount","amt"
        String heading[]={"Item Cat","Item name","Qty","Pur.Rt.","Deal","Rt.After Deal","Net Amt.","Dis. %","Dis.Rs","Total","Barcode","Batch No.","Mfd.","Exp."};
        dtm=new DefaultTableModel(heading,0);
        javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        jTable1.setModel(dtm);
        javax.swing.table.TableColumn column;
        column=jTable1.getColumn("Item Cat");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Item name");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(110);
        column=jTable1.getColumn("Barcode");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Batch No.");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Mfd.");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(110);
        column=jTable1.getColumn("Exp.");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(110);
        column=jTable1.getColumn("Qty");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(60);
        column=jTable1.getColumn("Pur.Rt.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(60);
        column=jTable1.getColumn("Deal");
        column.setCellRenderer(CRCenter);
        column.setPreferredWidth(50);
        column=jTable1.getColumn("Rt.After Deal");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(90);
        column=jTable1.getColumn("Net Amt.");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(70);
        column=jTable1.getColumn("Dis. %");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(60);
        column=jTable1.getColumn("Dis.Rs");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(70);
        column=jTable1.getColumn("Total");
        column.setCellRenderer(CRRight);
        //jTable1.setModel(dtm);
        String type[]={"cash","creadit"};
        for(int i=0;i<type.length;i++)
        {
            jComboBox1.addItem(type[i].toUpperCase());
            }
        String monthly[]={"MONTH","JAN","FAB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
        for(int i=0;i<monthly.length;i++)
        {
            jComboBox4.addItem(monthly[i]);
            jComboBox6.addItem(monthly[i]);
            }
            jComboBox5.addItem("YEAR");
            jComboBox7.addItem("YEAR");
       for(int i=2007;i<=2100;i++)
        {
            jComboBox5.addItem(""+i);
            jComboBox7.addItem(""+i);
            }
          jComboBox10.addItem("SELECT");
        Connection con;
        Statement st,st1;
        ResultSet res,res1;
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=DriverManager.getConnection("jdbc:mysql://localhost/GiftCorner?user=GiftCorner&password=corner");
            st=con.createStatement();
            res= st.executeQuery("Select cat_nm from cat_master");
            while(res.next()==true)
            {
             jComboBox3.addItem(res.getString(1));
              }
             res.close();
             st.close();
             st1=con.createStatement();
             res1=st1.executeQuery("select ac_nm from ac_details where drcr='cr'");
            while(res1.next()==true)
            {
             jComboBox2.addItem(res1.getString(1).toUpperCase());
              }
             st1.close();
             res1.close();
             con.close();
          }catch(Exception ex) { System.out.println("error.."+ex); }
        SimpleDateFormat date=new SimpleDateFormat("dd-MM-yyyy");
        jXDatePicker1.setFormats(date);
        //jXDatePicker1.getDate();
        jXDatePicker1.setDate(new java.util.Date());
     }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jComboBox9 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel12 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Purchase ");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(207, 121, 34));
        jPanel1.setLayout(null);

        jLabel1.setText("Purchase Date ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 90, 20);

        jLabel2.setText("Type ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(260, 20, 30, 20);

        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(300, 20, 120, 20);

        jLabel3.setText("From Party ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(440, 20, 70, 20);

        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(510, 20, 160, 20);

        jLabel4.setText("Bill No.");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(702, 20, 40, 20);

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(750, 20, 110, 20);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 940, 10);

        jLabel5.setText("Item Category ");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 60, 100, 20);

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
        jComboBox3.setBounds(10, 80, 130, 20);

        jLabel6.setText("Item Name ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 110, 90, 20);

        jLabel7.setText("Barcode ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 160, 60, 20);

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(10, 180, 130, 20);

        jLabel8.setText("Quantity ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 210, 60, 20);

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField5.setText("1");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField5FocusGained(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField5);
        jTextField5.setBounds(10, 230, 70, 20);

        jLabel9.setText("Deal ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 300, 40, 20);

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.setText("0");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField6FocusGained(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField6);
        jTextField6.setBounds(40, 300, 50, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("+");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(80, 300, 30, 20);

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField7.setText("0");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField7FocusGained(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField7);
        jTextField7.setBounds(100, 300, 40, 20);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rupya.png"))); // NOI18N
        jLabel11.setText("Rate ");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 260, 50, 20);

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField8.setText("00.00");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField8FocusGained(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField8);
        jTextField8.setBounds(60, 260, 80, 20);

        jLabel13.setText("Batch No.");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(10, 380, 60, 20);

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField9);
        jTextField9.setBounds(70, 380, 70, 20);

        jLabel14.setText("Manufacturing Date");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(10, 410, 120, 30);

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
        jComboBox4.setBounds(10, 440, 70, 20);

        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });
        jComboBox5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox5KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox5);
        jComboBox5.setBounds(80, 440, 60, 20);

        jLabel15.setText("Expiry Date ");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(10, 470, 90, 20);

        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        jComboBox6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox6KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox6);
        jComboBox6.setBounds(10, 490, 70, 20);

        jComboBox7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox7KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox7);
        jComboBox7.setBounds(80, 490, 60, 20);

        jLabel16.setText("Discount");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(10, 530, 50, 20);

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField10.setText("00");
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField10FocusGained(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
        });
        jPanel1.add(jTextField10);
        jTextField10.setBounds(70, 530, 50, 20);

        jLabel17.setText("%");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(130, 530, 20, 20);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(150, 50, 10, 540);

        jPanel2.setBackground(new java.awt.Color(58, 150, 197));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 255), new java.awt.Color(204, 204, 255), null, null));
        jPanel2.setLayout(null);

        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
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
        jTable1.setRowHeight(20);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 750, 200);

        jLabel18.setText("Total Amount ");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel18);
        jLabel18.setBounds(490, 220, 80, 20);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("00.00");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(600, 220, 100, 20);

        jLabel20.setText("Discount Amount");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(490, 250, 100, 20);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel21.setText("00.00");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(600, 250, 100, 20);

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "%" }));
        jPanel2.add(jComboBox8);
        jComboBox8.setBounds(710, 250, 50, 20);

        jLabel22.setText("Vat Amount");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(490, 280, 70, 20);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("00.00");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(600, 280, 100, 20);

        jLabel24.setText("Net Amount");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(490, 310, 70, 20);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("00.00");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(600, 310, 100, 20);

        jLabel26.setText("R/O ");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(490, 340, 50, 20);

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("00.00");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(600, 340, 100, 20);

        jLabel28.setText("Discount ");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(270, 250, 60, 20);

        jTextField11.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField11.setText("0");
        jTextField11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField11FocusGained(evt);
            }
        });
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField11);
        jTextField11.setBounds(340, 250, 70, 20);

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "%" }));
        jPanel2.add(jComboBox9);
        jComboBox9.setBounds(420, 250, 50, 20);

        jLabel29.setText("Vat");
        jPanel2.add(jLabel29);
        jLabel29.setBounds(270, 280, 40, 20);

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField12.setText("0");
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jTextField12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField12FocusGained(evt);
            }
        });
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField12);
        jTextField12.setBounds(340, 280, 70, 20);

        jLabel30.setText("%");
        jPanel2.add(jLabel30);
        jLabel30.setBounds(420, 280, 20, 20);

        jLabel32.setBackground(new java.awt.Color(204, 204, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel32.setForeground(new java.awt.Color(0, 0, 153));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("00.00");
        jLabel32.setOpaque(true);
        jPanel2.add(jLabel32);
        jLabel32.setBounds(610, 380, 90, 20);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/rupya.png"))); // NOI18N
        jLabel31.setText("Payble Amount");
        jLabel31.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel2.add(jLabel31);
        jLabel31.setBounds(490, 380, 110, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(160, 80, 770, 410);

        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blue button.png"))); // NOI18N
        jButton1.setText("Add ");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blue button2.png"))); // NOI18N
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blue button1.png"))); // NOI18N
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
        jButton1.setBounds(190, 500, 110, 50);

        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/green button.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/green button2.png"))); // NOI18N
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/green button1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(360, 500, 110, 50);

        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blue button.png"))); // NOI18N
        jButton3.setText("Refresh");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blue button2.png"))); // NOI18N
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blue button1.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(540, 500, 110, 50);

        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blue button.png"))); // NOI18N
        jButton4.setText("Cancel");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blue button2.png"))); // NOI18N
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/blue button1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(730, 500, 110, 50);

        jXDatePicker1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jXDatePicker1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jXDatePicker1KeyPressed(evt);
            }
        });
        jPanel1.add(jXDatePicker1);
        jXDatePicker1.setBounds(100, 20, 130, 22);

        jLabel12.setText("Unit");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(90, 230, 40, 20);

        jComboBox10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox10ActionPerformed(evt);
            }
        });
        jComboBox10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox10KeyPressed(evt);
            }
        });
        jPanel1.add(jComboBox10);
        jComboBox10.setBounds(10, 130, 130, 20);

        jLabel34.setText("Rate After Deal ");
        jPanel1.add(jLabel34);
        jLabel34.setBounds(10, 330, 90, 20);

        jTextField1.setEditable(false);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(10, 350, 130, 20);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Background-Html53.png"))); // NOI18N
        jLabel33.setText("jLabel33");
        jPanel1.add(jLabel33);
        jLabel33.setBounds(0, 0, 940, 610);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 940, 610);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row=dtm.getRowCount();
        int no=0,n = 0,itcd;
        String itnm="";
        String cat="";
        String batch="";
        double qty;
        if(jTextField2.getText().equals("")==false)
           {
                if(n==row)
                {                   
                    javax.swing.JOptionPane.showMessageDialog(null,"Error :.."+"\n"+"Please add 'data' in table ...","Error..",JOptionPane.ERROR_MESSAGE);
                    jTextField2.requestFocus();
                    }
                else{
                  int date=jXDatePicker1.getDate().getDate();
                  int month=01+jXDatePicker1.getDate().getMonth();
                  int year=1900+jXDatePicker1.getDate().getYear();
                  String date1=""+year+"-"+month+"-"+date;
                  int col=dtm.getColumnCount();
                 String data[]=new String[14];
                 Connection con;
                 Statement st,st1,st2,st3,st4,st5;
                 ResultSet res,res1,res2;
                try {
                 Class.forName("com.mysql.jdbc.Driver").newInstance();
                 con=DriverManager.getConnection("jdbc:mysql://localhost/GiftCorner?user=GiftCorner&password=corner");
                st2=con.createStatement();
                 res=st2.executeQuery("select bil_no from pur_detail");
                 while(res.next()==true)
                 {
                     no=res.getInt("bil_no");
                     no=no+1;
                    }
                 st=con.createStatement();
                String detail="insert into pur_detail values("+no+",'"+date1+"','"+jComboBox1.getSelectedItem()+"','"+jComboBox2.getSelectedItem()+"',"+Integer.valueOf(""+jTextField2.getText())+","+Double.valueOf(""+jLabel19.getText())+","+Double.valueOf(""+jLabel21.getText())+","+Double.valueOf(""+jLabel23.getText())+","+Double.valueOf(""+jLabel25.getText())+","+Double.valueOf(""+jLabel27.getText())+","+Double.valueOf(""+jLabel32.getText())+")";
                st.executeUpdate(detail);
                st1=con.createStatement();
                st3=con.createStatement();
                for(int i=0;i<row;i++)
                 {
                   for(int j=0;j<col;j++)
                    {
                       data[j]=""+jTable1.getValueAt(i,j);//data[i]=                       
                      }
                    st1.executeUpdate("insert into pur_summary values("+no+",'"+data[0]+"','"+data[1]+"',"+Double.valueOf(data[2])+","+Double.valueOf(data[3])+",'"+data[4]+"',"+Double.valueOf(data[5])+","+Double.valueOf(data[6])+","+Double.valueOf(data[7])+","+Double.valueOf(data[8])+","+Double.valueOf(data[9])+",'"+data[10]+"','"+data[11]+"','"+data[12]+"','"+data[13]+"')");
                        }
                        st3=con.createStatement();
                        st4=con.createStatement();
                        st5=con.createStatement();
              for(int i=0;i<row;i++)
                {
                    cat=""+jTable1.getValueAt(i,0);
                    //System.out.println(cat);
                    }
            for(int i=0;i<row;i++)
              {
                itnm=""+jTable1.getValueAt(i,1);
                qty=Double.valueOf(""+jTable1.getValueAt(i,2));
                batch=""+jTable1.getValueAt(i,11);
                 res1=st3.executeQuery("select item_cd from item_mstr where item_nm='"+itnm+"'");
                    st5=con.createStatement();
                    if(res1.next()==true)
                    {
                        itcd=res1.getInt(1);
                        //st5.executeUpdate("update item_stock set item_qty="+qty+" where4 item_cd="+res1.getInt(1)+"");
                        //System.out.println("update item_stock set item_qty="+qty+" where item_cd="+res1.getInt(1)+"");
                        //System.out.println(batch);
                       res2=st4.executeQuery("select item_qty from item_stock where item_cd="+res1.getInt(1)+" and batch_no='"+batch+"'");
                       if(res2.next()==true)
                       {
                           qty=qty+res2.getDouble(1);
                           st5.executeUpdate("update item_stock set item_qty="+qty+" where item_cd="+res1.getInt(1)+" and batch_no='"+batch+"'");
                           //System.out.println("Quantity  "+qty);
                            }

                     else{
                           //System.out.println("else insert the value");
                           st5.executeUpdate("insert into item_stock values("+itcd+","+qty+",'"+batch+"')");
                            }
                  }
               // System.out.println(itnm);
                }
                javax.swing.JOptionPane.showMessageDialog(null,"Congrase! "+"\n"+"data has been seved.","Massage",JOptionPane.PLAIN_MESSAGE);
                reload();
                con.close();
                jTextField2.requestFocus();
          }catch(Exception ex) { System.out.println("error to store data of Table .."+ex); }
                }
               }
     else{
            javax.swing.JOptionPane.showMessageDialog(null,"Error :.."+"\n"+"Please enter 'Bill No.'","Error..",JOptionPane.ERROR_MESSAGE);
            jTextField2.requestFocus();
        }
        //}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       //String r=jTextField1.getText();
        n=0;
        cd=0;
       if(jTextField1.getText().equals("")!=true)
       {
        String add[]=new String[14];
        double rate,net_amt,disc,discount,total,amount=0;
        rate=Double.valueOf(jTextField1.getText());
        double qty=Double.valueOf(jTextField5.getText());
        add[0]=""+jComboBox3.getSelectedItem();//item category
        add[1]=""+jComboBox10.getSelectedItem();//item name
        add[2]=""+qty;//add[10]=jTextField4.getText();
        add[3]=""+Double.valueOf(jTextField8.getText());
                //add[11]=jTextField9.getText();
        add[4]=jTextField6.getText()+"+"+jTextField7.getText();
                //""+jComboBox4.getSelectedItem()+"-"+jComboBox5.getSelectedItem();
        add[5]=""+rate;
                //""+jComboBox6.getSelectedItem()+"-"+jComboBox7.getSelectedItem();
        net_amt=qty*rate;
        bg3=new BigDecimal(net_amt);
        add[6]=""+bg3.setScale(2,5);
               //add[5]=jTextField7.getText();
        disc=Double.valueOf(jTextField10.getText());
        bg2=new BigDecimal(disc);
        add[7]=""+bg2.setScale(2,5);
               //add[7]=""+rate;
        discount=(net_amt*disc)/100;
        bg4=new BigDecimal(discount);
        add[8]=""+bg4.setScale(2,5);
        //add[8]=jTextField6.getText()+"+"+jTextField7.getText();
        total=net_amt-discount;
        //dis=Double.valueOf(jTextField10.getText());
        bg5=new BigDecimal(total);
        add[9]=""+bg5.setScale(2,5);
        add[10]=jTextField4.getText();
        add[11]=jTextField9.getText();
        add[12]=""+jComboBox4.getSelectedItem()+"-"+jComboBox5.getSelectedItem();
        add[13]=""+jComboBox6.getSelectedItem()+"-"+jComboBox7.getSelectedItem();
      //String s="select cat_cd from cat_master where cat_nm='"+jComboBox3.getSelectedItem()+"'";
        dtm.addRow(add);
        int row=dtm.getRowCount();        
        for(int i=0;i<row;i++)
        {
            String total1=jTable1.getValueAt(i,9).toString();
            amount=amount+Double.valueOf(total1);
            dc=new BigDecimal(amount);
            jLabel19.setText(""+dc.setScale(2,5));
            jLabel32.setText(""+dc.setScale(2,5));
            }
                jComboBox3.setSelectedIndex(0);
                jComboBox10.setSelectedIndex(0);
                jTextField4.setText("");
                jTextField5.setText("1");
                jTextField8.setText("00.00");
                jTextField6.setText("0");
                jTextField7.setText("0");
                jTextField1.setText("");
                jTextField9.setText("");
                jComboBox4.setSelectedIndex(0);
                jComboBox5.setSelectedIndex(0);
                jComboBox6.setSelectedIndex(0);
                jComboBox7.setSelectedIndex(0);
                jTextField10.setText("00");
                jComboBox3.requestFocus();
        }
 else{
           javax.swing.JOptionPane.showMessageDialog(null,"Error :.."+"\n"+"Please enter 'item rate and quantity' ","Error.",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jComboBox10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox10ActionPerformed
        // TODO add your handling code here:
        String item=""+jComboBox10.getSelectedItem();
        n=0;
        Connection con;
        Statement st,st1;
        ResultSet res,res1;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=DriverManager.getConnection("jdbc:mysql://localhost/GiftCorner?user=GiftCorner&password=corner");
            st=con.createStatement();
            res= st.executeQuery("Select unit from item_mstr where item_nm='"+item+"'");
            if(res.next()==true)
            {
             jLabel12.setText(res.getString("unit").toLowerCase());
              }
                res.close();
                st.close();
                st1=con.createStatement();
                res1=st1.executeQuery("select item_cd from item_mstr where item_nm='"+item+"'");
                if(res1.next()==true)
                {
                    n=res1.getInt("item_cd");
                    }
                //System.out.println("."+n);
              }catch(Exception ex){System.out.println("error in find unit "+ex);}
        //res.close();
        //st.close();
        //System.out.println(item);
    }//GEN-LAST:event_jComboBox10ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        String item=""+jComboBox3.getSelectedItem();
        String item_cd="";
        Connection con;
        Statement st,st1 = null;
        ResultSet res,res1;
        cd=0;
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con=DriverManager.getConnection("jdbc:mysql://localhost/GiftCorner?user=GiftCorner&password=corner");
            if("ALL".equals(item)==true)
            {
              st=con.createStatement();
              res=st.executeQuery("select item_nm from item_mstr");
              jComboBox10.removeAllItems();
              while(res.next()==true)
                {
                  jComboBox10.addItem(res.getString(1));
                     }
             //st.close();
             //res.close();
             //con.close();
             }
                else{
                   st1=con.createStatement();
                   res1=st1.executeQuery("select cat_cd from cat_master where cat_nm='"+item+"'");
                   if(res1.next()==true)
                        {
                            cd=res1.getInt("cat_cd");
                            //System.out.println(".."+cd);
                            }                    
                            st1.close();
                            res1.close();
                    st=con.createStatement();
                    res=st.executeQuery("select item_nm from item_mstr where cat_cd="+cd+"");
                    jComboBox10.removeAllItems();
                    //jComboBox10.addItem("SELECT");
                    while(res.next()==true)
                     {
                        jComboBox10.addItem(res.getString(1));
                    }
                    st.close();
                    res.close();
                    con.close();
                }
        }catch(Exception ex) {System.out.println("error in item cat  "+ex); }
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
        // TODO add your handling code here:
        jTextField5.selectAll();
    }//GEN-LAST:event_jTextField5FocusGained

    private void jTextField6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusGained
        // TODO add your handling code here:
        jTextField6.selectAll();
    }//GEN-LAST:event_jTextField6FocusGained

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
        jTextField7.selectAll();
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusGained
        // TODO add your handling code here:
        jTextField8.selectAll();
    }//GEN-LAST:event_jTextField8FocusGained

    private void jTextField10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField10FocusGained
        // TODO add your handling code here:
        jTextField10.selectAll();
    }//GEN-LAST:event_jTextField10FocusGained

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
          jComboBox10.requestFocus();
          }
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void jComboBox10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox10KeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==evt.VK_ENTER)
            {
             jTextField4.requestFocus();
             jTextField4.selectAll();
              }
    }//GEN-LAST:event_jComboBox10KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             jTextField5.requestFocus();
             //jTextField4.selectAll();
              }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             jTextField8.requestFocus();
             jTextField8.selectAll();
              }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             jTextField7.requestFocus();
             jTextField7.selectAll();
              }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             double rate=dis(jTextField8.getText(),jTextField6.getText(),jTextField7.getText(),jTextField5.getText());
             //double qty=Double.valueOf(jTextField5.getText());
             jTextField1.setText(""+rate);
             jTextField9.requestFocus();
             jTextField9.selectAll();
               }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             double rate=dis(jTextField8.getText(),jTextField6.getText(),jTextField7.getText(),jTextField5.getText());
             jTextField1.setText(""+rate);
             jTextField6.requestFocus();
             jTextField6.selectAll();
              }
    }//GEN-LAST:event_jTextField8KeyPressed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             jComboBox4.requestFocus();
             //jTextField9.selectAll();
              }
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jComboBox4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             jComboBox5.requestFocus();
              }
    }//GEN-LAST:event_jComboBox4KeyPressed

    private void jComboBox6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             jComboBox7.requestFocus();
              }
    }//GEN-LAST:event_jComboBox6KeyPressed

    private void jComboBox5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox5KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             jComboBox6.requestFocus();
              }
    }//GEN-LAST:event_jComboBox5KeyPressed

    private void jComboBox7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox7KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
            {
             jTextField10.requestFocus();
              }
    }//GEN-LAST:event_jComboBox7KeyPressed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusGained
        // TODO add your handling code here:
        jTextField7.selectAll();
    }//GEN-LAST:event_jTextField7FocusGained

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            double amount,vat,amount1,total;
            amount=netamt;//Double.valueOf(jLabel25.getText());
            System.out.println(netamt);
            vat=Double.valueOf(jTextField12.getText());
            amount1=(amount*vat)/100;
            bg8=new BigDecimal(amount1);
            jLabel23.setText(""+bg8.setScale(2,5));
            total=amount+amount1;
            bd=new BigDecimal(total);
            jLabel25.setText(""+bd.setScale(2,5));
            String d1=""+bd.setScale(0, bd.ROUND_HALF_UP);
            double d=Double.valueOf(d1);
            double t=d-total;
            bg1=new BigDecimal(t);
            jLabel27.setText(""+bg1.setScale(2,5));
            jLabel32.setText(d1);
            }
    }//GEN-LAST:event_jTextField12KeyPressed

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            double amount,dis,amount1,total;
            amount=Double.valueOf(jLabel19.getText());
            dis=Double.valueOf(jTextField11.getText());
            amount1=(amount*dis)/100;
            bg7=new BigDecimal(amount1);
            jLabel21.setText(""+bg7.setScale(2,5));
            total=amount-amount1;
            netamt=total;
            bd=new BigDecimal(total);
            jLabel25.setText(""+bd.setScale(2,5));
            String d1=""+bd.setScale(0, bd.ROUND_HALF_UP);
            double d=Double.valueOf(d1);
            double t=d-total;
            bg1=new BigDecimal(t);
            jLabel27.setText(""+bg1.setScale(2,5));
            jLabel32.setText(d1);
            jTextField12.requestFocus();
            }
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField11FocusGained
        // TODO add your handling code here:
     jTextField11.selectAll();
    }//GEN-LAST:event_jTextField11FocusGained

    private void jTextField12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField12FocusGained
        // TODO add your handling code here:
        jTextField12.selectAll();
    }//GEN-LAST:event_jTextField12FocusGained

    private void jXDatePicker1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jXDatePicker1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            //System.out.println("Line is OK");
            jComboBox1.requestFocus();
            //System.out.println("Line 2 is OK");
            }
    }//GEN-LAST:event_jXDatePicker1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            jComboBox2.requestFocus();
            }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==evt.VK_ENTER)
        {
            jTextField2.requestFocus();
            }
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            jComboBox3.requestFocus();
            }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            jButton1.requestFocus();
            }
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==evt.VK_ENTER)
        {
            String r=jTextField1.getText();
       if(r.equals("")!=true)
       {
            String add[]=new String[14];
            double rate,net_amt,disc,discount,total,amount=0;
            rate=Double.valueOf(jTextField1.getText());
            double qty=Double.valueOf(jTextField5.getText());
            add[0]=""+jComboBox3.getSelectedItem();//item category
            add[1]=""+jComboBox10.getSelectedItem();//item name
            add[2]=""+qty;//add[10]=jTextField4.getText();
            add[3]=""+Double.valueOf(jTextField8.getText()); //add[11]=jTextField9.getText();
            add[4]=jTextField6.getText()+"+"+jTextField7.getText();
        //""+jComboBox4.getSelectedItem()+"-"+jComboBox5.getSelectedItem();
            add[5]=""+rate;
        //""+jComboBox6.getSelectedItem()+"-"+jComboBox7.getSelectedItem();
            net_amt=qty*rate;
            bg3=new BigDecimal(net_amt);
            add[6]=""+bg3.setScale(2,5);
        //add[5]=jTextField7.getText();
            disc=Double.valueOf(jTextField10.getText());
            bg2=new BigDecimal(disc);
            add[7]=""+bg2.setScale(2,5);
        //add[7]=""+rate;
            discount=(net_amt*disc)/100;
            bg4=new BigDecimal(discount);
            add[8]=""+bg4.setScale(2,5);
        //add[8]=jTextField6.getText()+"+"+jTextField7.getText();
            total=net_amt-discount;
        //dis=Double.valueOf(jTextField10.getText());
            bg5=new BigDecimal(total);
            add[9]=""+bg5.setScale(2,5);
            add[10]=jTextField4.getText();
            add[11]=jTextField9.getText();
            add[12]=""+jComboBox4.getSelectedItem()+"-"+jComboBox5.getSelectedItem();
            add[13]=""+jComboBox6.getSelectedItem()+"-"+jComboBox7.getSelectedItem();
            dtm.addRow(add);
            int row=dtm.getRowCount();
         for(int i=0;i<row;i++)
            {
                String total1=jTable1.getValueAt(i,9).toString();
                amount=amount+Double.valueOf(total1);
                dc=new BigDecimal(amount);
                jLabel19.setText(""+dc.setScale(2,5));
                jLabel32.setText(""+dc.setScale(2,5));
              }
                jComboBox3.setSelectedIndex(0);
                jComboBox10.setSelectedIndex(0);
                jTextField4.setText("");
                jTextField5.setText("1");
                jTextField8.setText("00.00");
                jTextField6.setText("0");
                jTextField7.setText("0");
                jTextField1.setText("");
                jTextField9.setText("");
                jComboBox4.setSelectedIndex(0);
                jComboBox5.setSelectedIndex(0);
                jComboBox6.setSelectedIndex(0);
                jComboBox7.setSelectedIndex(0);
                jTextField10.setText("00");
                jComboBox3.requestFocus();
        }
 else{
           javax.swing.JOptionPane.showMessageDialog(null,"Error :.."+"\n"+"Please enter 'item rate and quantity' ","Error..",JOptionPane.ERROR_MESSAGE);
            }
                }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
 private JTableHeader head;
 private DefaultTableModel dtm;
 private double netamt;
 int n,cd;
     java.math.BigDecimal dc,bd,bg1,bg2,bg3,bg4,bg5,bg6,bg7,bg8;
 public double dis(String rate,String deal,String deal1,String qty)
 {
       double rate1,deal12,deal13,rt_dis,qty1,amt,to;

       rate1=Double.valueOf(rate);
       deal12=Double.valueOf(deal);
       deal13=Double.valueOf(deal1);
       qty1=Double.valueOf(qty);
       if((deal12==0)&&(deal13==0))
       {
            amt=rate1;
            return(amt);
            }
    else{
             rt_dis=(deal12*rate1)/(deal12+deal13);
             bg6=new BigDecimal(rt_dis);
             to=Double.valueOf(""+bg6.setScale(2,5));
             return(to);
            }

    }
 public void reload(){
     dtm.setRowCount(0);
                jTextField2.setText("");
                jComboBox1.setSelectedIndex(0);
                jComboBox2.setSelectedIndex(0);
                jComboBox3.setSelectedIndex(0);
                jComboBox10.setSelectedIndex(0);
                jTextField4.setText("");
                jTextField5.setText("1");
                jTextField8.setText("00.00");
                jTextField6.setText("0");
                jTextField7.setText("0");
                jTextField1.setText("");
                jTextField9.setText("");
                jComboBox4.setSelectedIndex(0);
                jComboBox5.setSelectedIndex(0);
                jComboBox6.setSelectedIndex(0);
                jComboBox7.setSelectedIndex(0);
                jTextField10.setText("00");
                jTextField11.setText("00.00");
                jTextField12.setText("00.00");
                jLabel19.setText("00.00");
                jLabel21.setText("00.00");
                jLabel23.setText("00.00");
                jLabel25.setText("00.00");
                jLabel27.setText("00.00");
                jLabel32.setText("00.00");
                jXDatePicker1.requestFocus();
         }
}

