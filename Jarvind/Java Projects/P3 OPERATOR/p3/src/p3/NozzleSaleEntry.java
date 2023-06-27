package p3;
import javax.swing.text.MaskFormatter;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NozzleSaleEntry.java
 *
 * Created on Jun 11, 2014, 4:05:51 PM
 */

/**
 *
 * @author welcome
 */
public class NozzleSaleEntry extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm,dtm1;
    /** Creates new form NozzleSaleEntry */
    public NozzleSaleEntry(String uid,String cnm,String fyear) {
        initComponents();

        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
        javax.swing.table.DefaultTableCellRenderer CRLeft=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight=new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter=new javax.swing.table.DefaultTableCellRenderer();

        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);


        String heading[]={"S.No.","Date","Shift","Supervisor Name","Tank Name","Nozzle No.","OP Reading","CL Reading","Testing","Quantity","OP OK Reading","CL OK Reading","Quantity 2","Amount 1","Amount 2","Final Amount"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
        jTable1.setModel(dtm);

        javax.swing.table.TableColumn column;
        
        column=jTable1.getColumn("S.No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(45);
        column=jTable1.getColumn("Date");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Shift");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(80);
        column=jTable1.getColumn("Supervisor Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(150);
        column=jTable1.getColumn("Tank Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(110);
        column=jTable1.getColumn("Nozzle No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("OP Reading");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("CL Reading");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Testing");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Quantity");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(110);
        column=jTable1.getColumn("OP OK Reading");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("CL OK Reading");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Quantity 2");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Amount 1");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Final Amount");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable1.getColumn("Amount 2");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);




        String heading1[]={"S.No.","Date","Shift","Supervisor Name","Tank Name","Nozzle No.","OP Reading","CL Reading","Testing","Quantity","OP OK Reading","CL OK Reading","Quantity 2","Amount 1","Amount 2","Final Amount"};
        dtm1=new javax.swing.table.DefaultTableModel(heading1,0);
        jTable2.setModel(dtm1);

        /*column=jTable2.getColumn("S.No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(45);
        column=jTable2.getColumn("Date");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("Shift");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(80);
        column=jTable2.getColumn("Supervisor Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(150);
        column=jTable2.getColumn("Tank Name");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(110);
        column=jTable2.getColumn("Nozzle No.");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("OP Reading");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("CL Reading");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("Testing");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("Quantity");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(110);
        column=jTable2.getColumn("OP OK Reading");
        column.setCellRenderer(CRLeft);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("CL OK Reading");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("Quantity 2");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("Amount 1");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("Final Amount");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);
        column=jTable2.getColumn("Amount 2");
        column.setCellRenderer(CRRight);
        column.setPreferredWidth(100);*/


        jScrollPane2.setVisible(false);

        java.util.Date dt=new java.util.Date();
        int date=dt.getDate();
        int month=dt.getMonth()+1;
        int year=dt.getYear()+1900;
        int hour=dt.getHours();
        int min=dt.getMinutes();
        int sec=dt.getSeconds();
        String setdate=date+"-"+month+"-"+year;
        String d=""+date,m=""+month;
        if(d.length()==1)
            d="0"+d;
        if(m.length()==1)
            m="0"+m;
        setdate=d+"-"+m+"-"+year;
        System.out.println(setdate);
        jFormattedTextField1.setText(setdate);

        jComboBox3.removeAllItems();
        jComboBox3.addItem("Select");

        


        loadIni();
        loadJTable();
    }

   /*private javax.swing.table.TableModel model=new javax.swing.table.DefaultTableModel(data,columnNames)
{
    public boolean isCellEditable(int row,int column)
    {
        return false;
    }
};*/
//private javax.swing.JTable jTable1=new javax.swing.JTable(model);
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        MaskFormatter mask1=null;
        try{
            mask1=new MaskFormatter("##-##-####");
            mask1.setPlaceholderCharacter('_');
        }
        catch(Exception ae)
        {
            System.out.println("error in setting jFormating textField");
        }
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int row,int column)
            {
                return false;
            }}
            ;
            jPanel6 = new javax.swing.JPanel();
            jButton2 = new javax.swing.JButton();
            jButton3 = new javax.swing.JButton();
            jButton5 = new javax.swing.JButton();
            jScrollPane2 = new javax.swing.JScrollPane();
            jTable2 = new javax.swing.JTable();
            jLabel13 = new javax.swing.JLabel();
            jPanel7 = new javax.swing.JPanel();
            jButton8 = new javax.swing.JButton();
            jButton9 = new javax.swing.JButton();
            jButton10 = new javax.swing.JButton();
            jButton6 = new javax.swing.JButton();
            jButton7 = new javax.swing.JButton();
            jButton11 = new javax.swing.JButton();
            jButton4 = new javax.swing.JButton();

            setClosable(true);
            setIconifiable(true);
            setTitle("Nozzle Wise Sale Detail");

            jPanel1.setBackground(new java.awt.Color(102, 102, 102));
            jPanel1.setLayout(null);

            jPanel2.setBackground(new java.awt.Color(219, 219, 186));
            jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 5, true), javax.swing.BorderFactory.createTitledBorder("")));
            jPanel2.setLayout(null);

            jPanel3.setBackground(new java.awt.Color(219, 219, 186));
            jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
            jPanel3.setLayout(null);

            jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
            jLabel4.setText("Tank Name");
            jPanel3.add(jLabel4);
            jLabel4.setBounds(10, 20, 80, 30);

            jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
            jLabel6.setText("Op Reading");
            jPanel3.add(jLabel6);
            jLabel6.setBounds(10, 70, 110, 30);

            jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
            jLabel8.setText("Testing ");
            jPanel3.add(jLabel8);
            jLabel8.setBounds(640, 70, 70, 30);

            jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12));
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
            jPanel3.add(jComboBox2);
            jComboBox2.setBounds(130, 20, 310, 30);

            jTextField3.setEditable(false);
            jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12));
            jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTextField3KeyPressed(evt);
                }
            });
            jPanel3.add(jTextField3);
            jTextField3.setBounds(130, 70, 180, 30);

            jTextField5.setFont(new java.awt.Font("Tahoma", 1, 12));
            jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            jTextField5.setText("0");
            jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTextField5KeyPressed(evt);
                }
            });
            jPanel3.add(jTextField5);
            jTextField5.setBounds(720, 70, 190, 30);

            jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
            jLabel7.setText("Cl Reading");
            jPanel3.add(jLabel7);
            jLabel7.setBounds(330, 70, 110, 30);

            jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
            jLabel5.setText("Nozzle No.");
            jPanel3.add(jLabel5);
            jLabel5.setBounds(450, 20, 70, 30);

            jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12));
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
            jPanel3.add(jComboBox3);
            jComboBox3.setBounds(520, 20, 100, 30);

            jTextField4.setFont(new java.awt.Font("Tahoma", 1, 12));
            jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            jTextField4.setText("0");
            jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTextField4KeyPressed(evt);
                }
            });
            jPanel3.add(jTextField4);
            jTextField4.setBounds(440, 70, 180, 30);

            jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12));
            jLabel9.setText("OK Op Reading");
            jPanel3.add(jLabel9);
            jLabel9.setBounds(10, 120, 120, 30);

            jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12));
            jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            jTextField1.setText("0");
            jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTextField1KeyPressed(evt);
                }
            });
            jPanel3.add(jTextField1);
            jTextField1.setBounds(130, 120, 180, 30);

            jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12));
            jLabel10.setText("OK Cl Reading");
            jPanel3.add(jLabel10);
            jLabel10.setBounds(330, 120, 100, 30);

            jTextField6.setFont(new java.awt.Font("Tahoma", 1, 12));
            jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            jTextField6.setText("0");
            jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTextField6KeyPressed(evt);
                }
            });
            jPanel3.add(jTextField6);
            jTextField6.setBounds(440, 120, 180, 30);

            jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12));
            jLabel11.setText("Rate/Liter");
            jPanel3.add(jLabel11);
            jLabel11.setBounds(640, 120, 80, 30);

            jTextField7.setEditable(false);
            jTextField7.setFont(new java.awt.Font("Tahoma", 1, 12));
            jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTextField7KeyPressed(evt);
                }
            });
            jPanel3.add(jTextField7);
            jTextField7.setBounds(720, 120, 170, 30);

            jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jCheckBox1ActionPerformed(evt);
                }
            });
            jPanel3.add(jCheckBox1);
            jCheckBox1.setBounds(890, 120, 20, 30);

            jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12));
            jLabel12.setText("Type");
            jPanel3.add(jLabel12);
            jLabel12.setBounds(640, 20, 60, 30);

            jTextField8.setEditable(false);
            jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12));
            jPanel3.add(jTextField8);
            jTextField8.setBounds(720, 20, 190, 30);

            jPanel2.add(jPanel3);
            jPanel3.setBounds(20, 90, 920, 170);

            jPanel4.setBackground(new java.awt.Color(219, 219, 186));
            jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
            jPanel4.setLayout(null);

            jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13));
            jLabel1.setText("Date");
            jPanel4.add(jLabel1);
            jLabel1.setBounds(10, 20, 60, 30);

            jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13));
            jLabel2.setText("Shift");
            jPanel4.add(jLabel2);
            jLabel2.setBounds(270, 20, 50, 30);

            jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 13));
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Day", "Night", "Not Applicable" }));
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
            jPanel4.add(jComboBox1);
            jComboBox1.setBounds(320, 20, 120, 30);

            jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13));
            jLabel3.setText("Supervisor Name");
            jPanel4.add(jLabel3);
            jLabel3.setBounds(510, 20, 120, 30);

            jTextField2.setFont(new java.awt.Font("Tahoma", 1, 13));
            jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTextField2KeyPressed(evt);
                }
            });
            jPanel4.add(jTextField2);
            jTextField2.setBounds(630, 20, 280, 30);

            jFormattedTextField1 = new javax.swing.JFormattedTextField(mask1);
            jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jFormattedTextField1KeyPressed(evt);
                }
            });
            jPanel4.add(jFormattedTextField1);
            jFormattedTextField1.setBounds(70, 20, 110, 30);

            jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
            jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/calendar.png"))); // NOI18N
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
            jPanel4.add(jButton1);
            jButton1.setBounds(180, 20, 30, 30);

            jPanel2.add(jPanel4);
            jPanel4.setBounds(20, 20, 920, 70);

            jPanel5.setBackground(new java.awt.Color(219, 219, 186));
            jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
            jPanel5.setLayout(new java.awt.BorderLayout());

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

            )

        );
        jTable1.setRowHeight(20);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(20, 310, 920, 270);

        jPanel6.setBackground(new java.awt.Color(219, 219, 186));
        jPanel6.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel6.setLayout(null);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 16));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/savefile.gif"))); // NOI18N
        jButton2.setMnemonic('s');
        jButton2.setText("Save");
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
        jPanel6.add(jButton2);
        jButton2.setBounds(10, 10, 150, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 16));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/dustbeen.gif"))); // NOI18N
        jButton3.setMnemonic('d');
        jButton3.setText("Delete");
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
        jPanel6.add(jButton3);
        jButton3.setBounds(160, 10, 150, 30);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 16));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/Close1.gif"))); // NOI18N
        jButton5.setMnemonic('x');
        jButton5.setText("Close (x)");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton5);
        jButton5.setBounds(310, 10, 150, 30);

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
        jScrollPane2.setViewportView(jTable2);

        jPanel6.add(jScrollPane2);
        jScrollPane2.setBounds(620, 10, 100, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("0.00");
        jPanel6.add(jLabel13);
        jLabel13.setBounds(730, 10, 180, 30);

        jPanel2.add(jPanel6);
        jPanel6.setBounds(20, 580, 920, 50);

        jPanel7.setBackground(new java.awt.Color(219, 219, 186));
        jPanel7.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel7.setLayout(null);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton8.setMnemonic('+');
        jButton8.setText("Add ( + )");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jButton8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton8KeyPressed(evt);
            }
        });
        jPanel7.add(jButton8);
        jButton8.setBounds(340, 10, 120, 30);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton9.setMnemonic('-');
        jButton9.setText("Remove ( - )");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton9KeyPressed(evt);
            }
        });
        jPanel7.add(jButton9);
        jButton9.setBounds(460, 10, 120, 30);

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton10.setMnemonic('s');
        jButton10.setText("Show");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jButton10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton10KeyPressed(evt);
            }
        });
        jPanel7.add(jButton10);
        jButton10.setBounds(690, 10, 110, 30);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton6.setMnemonic('<');
        jButton6.setText("<<");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton6);
        jButton6.setBounds(10, 10, 60, 30);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton7.setMnemonic('>');
        jButton7.setText(">>");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton7);
        jButton7.setBounds(70, 10, 60, 30);

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14));
        jButton11.setMnemonic('h');
        jButton11.setText("Hide");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton11);
        jButton11.setBounds(580, 10, 110, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 16));
        jButton4.setIcon(new javax.swing.ImageIcon("D:\\P3 OPERATOR\\p3\\src\\images\\icons\\refresh.gif")); // NOI18N
        jButton4.setMnemonic('c');
        jButton4.setText("Clear");
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
        jPanel7.add(jButton4);
        jButton4.setBounds(800, 10, 110, 30);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(20, 260, 920, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 960, 650);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        if(jComboBox2.getSelectedIndex()>0)
        {
            loadNozzle();
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            save();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox3.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField4.selectAll();
            jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jComboBox3KeyPressed

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
            jTextField5.selectAll();
            jTextField5.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField1.selectAll();
            jTextField1.requestFocus();
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:

        /*if(redundantTank()==true)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Tank Name alread exist.");
            jComboBox2.requestFocus();
        }

        else*/
        {
            if(evt.getKeyCode()==10)
            save();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        clearWindow();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
            clearWindow();
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(jTable1.getSelectedRowCount()<1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Record is not selected.");
        }

        else if(dtm.getRowCount() > 0)
        {
            int c=javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Delete record", javax.swing.JOptionPane.YES_NO_OPTION);
            if(c==javax.swing.JOptionPane.YES_OPTION)
            {
                deleteRecord();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(jTable1.getSelectedRowCount()<1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Record is not selected.");
        }

        else if(dtm.getRowCount() > 0)
        {
            int c=javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Delete record", javax.swing.JOptionPane.YES_NO_OPTION);
            if(c==javax.swing.JOptionPane.YES_OPTION)
            {
                deleteRecord();
            }
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jComboBox1.requestFocus();
        }
}//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Cal c=new Cal();
        jFormattedTextField1.setText(c.getdate());
}//GEN-LAST:event_jButton1ActionPerformed

    private void jFormattedTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jComboBox1.requestFocus();
            
        }
}//GEN-LAST:event_jFormattedTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jComboBox2.requestFocus();
        }
}//GEN-LAST:event_jTextField2KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jTextField2.requestFocus();
            loadJTable();
        }
}//GEN-LAST:event_jComboBox1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int i=jTable1.getSelectedRow();

        jFormattedTextField1.setText(jTable1.getValueAt(i, 1).toString());
        jComboBox1.setSelectedItem(jTable1.getValueAt(i, 2).toString());
        jTextField2.setText(jTable1.getValueAt(i, 3).toString());
        jComboBox2.setSelectedItem(jTable1.getValueAt(i, 4).toString());
        jComboBox3.setSelectedItem(jTable1.getValueAt(i, 5).toString());
        jTextField4.setText(jTable1.getValueAt(i, 7).toString());
        jTextField5.setText(jTable1.getValueAt(i, 8).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        if(jComboBox3.getSelectedIndex()>0)
        {
            getOpening();
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        addDetail();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton8KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            addDetail();
        }
    }//GEN-LAST:event_jButton8KeyPressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        remove();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton9KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9KeyPressed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        showRow();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton10KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton8.requestFocus();
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField6.selectAll();
            jTextField6.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton8.requestFocus();
        }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected()==true)
            jTextField7.setEditable(true);
        if(jCheckBox1.isSelected()==false)
            jTextField7.setEditable(false);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if(jComboBox1.getSelectedIndex()!=0){
        loadJTable();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        forword();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        backword();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        hideRow();
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

public void loadIni()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String qry="select TankName from tank_master order by TankName";
        String arr[]=object1.getResultSetAs_1D_Array(qry, Main.year);

        jComboBox2.removeAllItems();
        jComboBox2.addItem("Select");

        if(arr.length>0)
        {
            for(int i=0;i<arr.length;i++)
            {
                jComboBox2.addItem(arr[i]);
            }
        }
        
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadini Method "+e);
    }
}
public void loadNozzle()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String qry="select NoOfNozzle from tank_master where TankName='"+jComboBox2.getSelectedItem().toString()+"'";
        String arr=object1.getSigetngleValue(qry, Main.year);

        jComboBox3.removeAllItems();
        jComboBox3.addItem("Select");

        for(int i=0;i<Integer.parseInt(arr);i++)
        {
            jComboBox3.addItem(""+(i+1));
        }
        qry="select SaleRate from tank_master where TankName='"+jComboBox2.getSelectedItem().toString()+"'";
        arr=object1.getSigetngleValue(qry, Main.year);
        jTextField7.setText(arr);
    }
    catch(Exception e)
    {
        System.out.println("Error ! In getrecord Method "+e);
    }
}

public boolean save()
{
    try
    {
        if(dtm.getRowCount()<1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please add the records then save.");
            jButton8.requestFocus();
            return false;
        }


        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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
        String d[]=jTable1.getValueAt(0, 1).toString().split("-");
        String dd=d[2]+"-"+d[1]+"-"+d[0];
        String qry1="select sno from nozzle_sale_entry where Date='"+dd+"' and Shift='"+jTable1.getValueAt(0, 2).toString()+"'";
        String chkdata[]=object1.getResultSetAs_1D_Array(qry1, Main.year);
        if(chkdata.length>0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Records are already inserted on this date shift.");
            dtm.setRowCount(0);
            clearWindow();
            return false;

        }
        int sno=0;
        boolean bn=false;
        String q="select max(sno) from nozzle_sale_entry";
        String sn=object1.getSigetngleValue(q, Main.year);
        if(sn==null || sn.isEmpty())
        {
            sn="0";
        }
        sno=Integer.parseInt(sn)+1;
        for(int i=0;i<dtm.getRowCount();i++)
        {
            
            sno=sno;
            System.out.println("sno="+sno);
            String dt[]=jTable1.getValueAt(i, 1).toString().split("-");
            String date=dt[2]+"-"+dt[1]+"-"+dt[0];
            String shift=jTable1.getValueAt(i, 2).toString();
            String sup=jTable1.getValueAt(i, 3).toString();
            String tnk=jTable1.getValueAt(i, 4).toString();
            String nozzle=jTable1.getValueAt(i, 5).toString();
            String clreading=jTable1.getValueAt(i, 7).toString();
            String testing=jTable1.getValueAt(i, 8).toString();
            String okop=jTable1.getValueAt(i, 10).toString();
            String okcl=jTable1.getValueAt(i, 11).toString();
            String qry="insert into nozzle_sale_entry values ("+sno+",'"+date+"','"+shift+"','"+sup+"','"+tnk+"',"+Integer.parseInt(nozzle)+","+Double.valueOf(clreading)+","+Double.valueOf(testing)+","+Double.valueOf(okop)+","+Double.valueOf(okcl)+")";
            System.out.println("qry="+qry);
            bn=object1.saveInformation(qry, Main.year);
        }

        if(bn==true)
        {
            dtm.setRowCount(0);
            //loadJTable();
            javax.swing.JOptionPane.showMessageDialog(this, "Saving process completed.");
            if(jComboBox1.getSelectedIndex()==0)
                jComboBox1.setSelectedIndex(1);
            else if(jComboBox1.getSelectedIndex() == 1)
                jComboBox1.setSelectedIndex(0);
            clearWindow();
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In getrecord Method "+e);
    }
    return true;
}

public void loadJTable()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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
        dtm.setRowCount(0);
        String dt[]=jFormattedTextField1.getText().split("-");
        String date=dt[2]+"-"+dt[1]+"-"+dt[0];
        String qry="select * from nozzle_sale_entry where Date='"+date+"'and Shift='"+jComboBox1.getSelectedItem().toString()+"'";
        System.out.println(qry);
        String load[][]=object1.getInformationDD(qry, 10, Main.year);
        if(load.length>0)
        {
            String arr[]=new String[17];
            for(int i=0;i<arr.length;i++)
            {
                arr[0]=""+(i+1);
                       arr[1]=load[i][1];
                       dt=arr[1].split("-");
                       arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                       arr[2]=load[i][2];
                       arr[3]=load[i][3];
                       arr[4]=load[i][4];
                       arr[5]=load[i][5];
                       //arr[6]=load[i][6];
                       System.out.println("i m ok..........."+1);
                       String shift="";
                       if(jComboBox1.getSelectedIndex()==1)
                       {
                           shift="Night";
                       }
                       else if(jComboBox1.getSelectedIndex() == 2)
                       {
                           shift="Day";
                       }
                       if(jComboBox1.getSelectedIndex()==1)
                        {
                            qry="Select Closing from nozzle_sale_entry where Tank_Name='"+arr[4]+"' and Nozzle_No="+Integer.parseInt(arr[5])+" and Date<'"+date+"' order by sno desc";
                        }
                        if(jComboBox1.getSelectedIndex()==2)
                        {
                            String day="Day",night="Night";
                            qry="Select Closing from nozzle_sale_entry where Tank_Name='"+arr[4]+"' and Nozzle_No="+Integer.parseInt(arr[5])+" and (Date='"+date+"' and Shift='"+day+"') or Date<'"+date+"' order by sno desc";

                        }
                       //qry="select Closing from nozzle_sale_entry where Date<'"+arr[1]+"' and Shift<>'"+jComboBox1.getSelectedItem().toString()+"'and Tank_Name='"+jComboBox2.getSelectedItem().toString()+"'and Nozzle_No='"+Integer.parseInt(jComboBox3.getSelectedItem().toString())+"' order by sno desc";
                       System.out.println(qry);
                       arr[6]=object1.getSigetngleValue(qry, Main.year);
                       System.out.println(arr[6]);
                       if(arr[6]==null || arr[6].isEmpty())
                       {
                           qry="select Opening from nozzle_master where TankName='"+arr[4]+"'and Nozzle_No='"+arr[5]+"'";
                           System.out.println(qry);
                           arr[6]=object1.getSigetngleValue(qry, Main.year);
                       }
                       arr[7]=load[i][6];
                       arr[8]=load[i][7];
                       System.out.println("arr[7]="+arr[7]+"   arr[8]="+arr[8]+"  arr[6]="+arr[6]);
                       arr[9]=""+(Double.valueOf(arr[7])-Double.valueOf(arr[6])-Double.valueOf(arr[8]));
                       System.out.println("i m ok..........."+2);
                       arr[10]=load[i][8];
                       arr[11]=load[i][9];
                       System.out.println("i m ok..........."+3);
                       double xx=getx(i,arr[4],arr[5]);
                       double temp=(Double.valueOf(arr[9])-((Double.valueOf(arr[11])-Double.valueOf(arr[10]))));
                       System.out.println("temp="+temp+" xx="+xx);
                       arr[12]=""+(temp*xx/100);
                       System.out.println("i m ok..........."+4);
                       int x=getxType(arr[4],arr[5]);
                       qry="Select SaleRate from tank_master where TankName='"+arr[4]+"'";
                       String amt=object1.getSigetngleValue(qry, Main.year);
                        if(x==1)
                        {
                             double tem=(temp * Double.valueOf(amt));
                             arr[13]=""+new java.math.BigDecimal(tem).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                             double temp1=(Double.valueOf(arr[12]) * Double.valueOf(amt));
                             arr[14]=""+new java.math.BigDecimal(temp1).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                        }
                       else if(x == 2 || x == 3)
                        {
                              double tem=(temp * Double.valueOf(amt));
                              arr[13]=""+new java.math.BigDecimal(tem).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                              arr[14]="0";
                        }
                       arr[15]=""+new java.math.BigDecimal(Double.valueOf(arr[13])+Double.valueOf(arr[14])).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                       dtm.addRow(arr);
                       System.out.println("calculatng job amount.........");
                        calculateJobAmt();
                }
            
        }
 
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method "+e);
    }
}

public void clearWindow()
{
    jTextField2.selectAll();
    jTextField3.setText("");
    jTextField4.setText("0");
    jTextField5.setText("0");
    jTextField1.setText("0");
    jTextField6.setText("0");
    jTextField7.setText("");
    jTextField7.setEnabled(false);
    jCheckBox1.setSelected(false);
    
    //jComboBox1.setSelectedIndex(0);
    jComboBox2.setSelectedIndex(0);
    jComboBox3.setSelectedIndex(0);

    
}

public boolean redundantTank()
{
    boolean check=false;
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String qry="select Tank_Name from nozzle_sale_entry";
        String arr[]=object1.getResultSetAs_1D_Array(qry, Main.year);

        if(arr.length>0)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i].equals(jComboBox2.getSelectedItem().toString())==true)
                    check=true;
            }
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method "+e);
    }

    return check;
}

public void deleteRecord()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        String qry="delete from nozzle_sale_entry where Tank_Name='"+jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString()+"'";
        boolean bn=object1.saveInformation(qry, Main.year);

        if(bn==true)
        {
            dtm.setRowCount(0);
            loadJTable();
            clearWindow();
        }
    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method "+e);
    }
}
public void getOpening()
{
    try
    {
        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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
        String dt[]=jFormattedTextField1.getText().split("-");
        String date=dt[2]+"-"+dt[1]+"-"+dt[0];
        String qry=null;
        if(jComboBox1.getSelectedIndex()==1)
        {
            qry="Select Closing from nozzle_sale_entry where Tank_Name='"+jComboBox2.getSelectedItem().toString()+"' and Nozzle_No="+Integer.parseInt(jComboBox3.getSelectedItem().toString())+" and Date<'"+date+"' order by sno desc";
        }
        if(jComboBox1.getSelectedIndex()==2)
        {
            String day="Day",night="Night";
            qry="Select Closing from nozzle_sale_entry where Tank_Name='"+jComboBox2.getSelectedItem().toString()+"' and Nozzle_No="+Integer.parseInt(jComboBox3.getSelectedItem().toString())+" and ((Date='"+date+"' and Shift='"+day+"') or Date<'"+date+"') order by sno desc";

        }
            //qry="Select Closing from nozzle_sale_entry where Tank_Name='"+jComboBox2.getSelectedItem().toString()+"' and Nozzle_No="+Integer.parseInt(jComboBox3.getSelectedItem().toString())+" and Date<='"+date+"'and Shift<>'"+jComboBox1.getSelectedItem().toString()+"' order by sno desc";
            System.out.println(qry);
            String clread=object1.getSigetngleValue(qry, Main.year);
            System.out.println("clreading ="+clread);
            if(clread==null || clread.isEmpty())
            {
            qry="Select Opening from nozzle_master where TankName='"+jComboBox2.getSelectedItem().toString()+"' and Nozzle_No="+Integer.parseInt(jComboBox3.getSelectedItem().toString())+"";
            System.out.println(qry);
            String getItem=object1.getSigetngleValue(qry, Main.year);
            System.out.println("getItem="+getItem);
            jTextField3.setText(getItem);
            }
            else
            {
                jTextField3.setText(clread);
            }
        qry="Select LeverageType from nozzle_master where TankName='"+jComboBox2.getSelectedItem().toString()+"' and Nozzle_No="+Integer.parseInt(jComboBox3.getSelectedItem().toString())+"";
        System.out.println(qry);
        String getItem=object1.getSigetngleValue(qry, Main.year);
        System.out.println("getItem="+getItem);
        int x=Integer.parseInt(getItem);
        String ltype="";
        if(x==1)
        {
            ltype="Cash";
        }
        else if(x == 2)
        {
            ltype="Reverse InFlow";
        }
        else if(x == 3)
        {
            ltype="I have ok meter";
        }
        jTextField8.setText(ltype);
    }
    catch(Exception ae)
    {
        System.out.println("error in getOpening method"+ae);
    }
}
public double getxx()
    {
        double xx=0;
        try
        {
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
            //jComboBox1.removeAllItems();

            String qry="Select PerLogic from nozzle_master where TankName='"+jComboBox2.getSelectedItem().toString()+"' and Nozzle_No="+Integer.parseInt(jComboBox3.getSelectedItem().toString())+"";
            System.out.println(qry);
            String getItemper=object1.getSigetngleValue(qry, Main.year);
            System.out.println(getItemper);
            qry="Select LeverageType from nozzle_master where TankName='"+jComboBox2.getSelectedItem().toString()+"' and Nozzle_No="+Integer.parseInt(jComboBox3.getSelectedItem().toString())+"";
            System.out.println(qry);
            String getItemtyp=object1.getSigetngleValue(qry, Main.year);
            System.out.println(getItemtyp);

            xx=Double.valueOf(getItemper);
            if(Integer.parseInt(getItemtyp)==3)
                xx=0;
        }
        catch(Exception ae)
        {
            System.out.println("Error in getxx method."+ae);
        }
        return xx;
    }
public int getxxType()
    {
        int x=0;
        try
        {
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
            //jComboBox1.removeAllItems();

            String qry="Select LeverageType from nozzle_master where TankName='"+jComboBox2.getSelectedItem().toString()+"' and Nozzle_No="+Integer.parseInt(jComboBox3.getSelectedItem().toString())+"";
            System.out.println(qry);
            String getItemtyp=object1.getSigetngleValue(qry, Main.year);
            System.out.println(getItemtyp);

            x=Integer.parseInt(getItemtyp);

        }
        catch(Exception ae)
        {
            System.out.println("Error in getxx method."+ae);
        }
        return x;
    }
public boolean addDetail()
{
    try
    {
        if(jFormattedTextField1.getText().isEmpty())
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please enter the date.");
            jFormattedTextField1.requestFocus();
                   return false;
        }
        else if(jComboBox1.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please select the shift of job.");
            jComboBox1.requestFocus();
            return false;
        }
        else if(jTextField2.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please enter supervisor name.");
            jTextField2.requestFocus();
            return false;
        }

        else if(jComboBox2.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please select tank name.");
            jComboBox2.requestFocus();
            return false;
        }

        else if(jComboBox3.getSelectedIndex()==0)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please select nozzle no.");
            jComboBox3.requestFocus();
            return false;
        }

        else if(jTextField3.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please enter opening reading.");
            jTextField3.requestFocus();
            return false;
        }

        else if(jTextField4.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please enter closing reading.");
            jTextField4.requestFocus();
            return false;
        }

        else if(jTextField5.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please enter testing.");
            jTextField5.requestFocus();
            return false;
        }
        else if(jTextField1.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please enter op ok reading.");
            jTextField1.requestFocus();
            return false;
        }
        else if(jTextField6.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! Please enter cl ok reading.");
            jTextField6.requestFocus();
            return false;
        }
        else if(jTextField7.getText().trim().equals(""))
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Error! There is somthing wrong please enter the amount.");
            jTextField7.requestFocus();
            return false;
        }
        if(dtm.getRowCount()>0)
        {
            for(int i=0;i<dtm.getRowCount();i++)
            {
                if(jFormattedTextField1.getText().equals(jTable1.getValueAt(i, 1).toString()) && jComboBox1.getSelectedItem().toString().equals(jTable1.getValueAt(i, 2).toString()) && jComboBox2.getSelectedItem().toString().equals(jTable1.getValueAt(i, 4).toString()) && jComboBox3.getSelectedItem().toString().equals(jTable1.getValueAt(i, 5).toString()))
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error! Data already inserted.");
                    return false;
                }
            }
        }

        interfaceRailway object1=null;
        System.out.println("in loadInitial");
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

        if(object1.isDouble(jTextField3.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter opening reading in number format.");
            jTextField3.requestFocus();
            return false;
        }
        if(object1.isDouble(jTextField4.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter closing reading in number format.");
            jTextField4.requestFocus();
            return false;
        }
        if(object1.isDouble(jTextField5.getText())==false)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please enter testing in number format.");
            jTextField5.requestFocus();
            return false;
        }
          String arr[]=new String[16];
          arr[0]=""+(dtm.getRowCount()+1);
          arr[1]=jFormattedTextField1.getText();
          arr[2]=jComboBox1.getSelectedItem().toString();
          arr[3]=jTextField2.getText().trim().toUpperCase();
          arr[4]=jComboBox2.getSelectedItem().toString();
          arr[5]=jComboBox3.getSelectedItem().toString();
          arr[6]=jTextField3.getText().trim();
          arr[7]=jTextField4.getText().trim();
          arr[8]=jTextField5.getText().trim();
          Double op=Double.valueOf(jTextField3.getText().trim());
          Double cl=Double.valueOf(jTextField4.getText().trim());
          Double tx=Double.valueOf(jTextField5.getText().trim());
          arr[10]=jTextField1.getText().trim();
          arr[11]=jTextField6.getText().trim();
          arr[9]=""+new java.math.BigDecimal(cl-op-tx).setScale(3,java.math.BigDecimal.ROUND_HALF_UP);
          double xx=getxx();
          int x=getxxType();
          arr[12]=""+new java.math.BigDecimal((Double.valueOf(arr[9])-(Double.valueOf(arr[11])-Double.valueOf(arr[10])))*xx/100).setScale(3,java.math.BigDecimal.ROUND_HALF_UP);
          if(x==1)
          {
              double temp=((Double.valueOf(arr[9])-(Double.valueOf(arr[11])-Double.valueOf(arr[10]))) * Double.valueOf(jTextField7.getText().trim()));
              arr[13]=""+new java.math.BigDecimal(temp).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
              double temp1=(Double.valueOf(arr[10]) * Double.valueOf(jTextField7.getText().trim()));
              arr[14]=""+new java.math.BigDecimal(temp1).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
          }
          if(x==2 || x==3)
          {
              double temp=((Double.valueOf(arr[9])-(Double.valueOf(arr[11])-Double.valueOf(arr[10]))) * Double.valueOf(jTextField7.getText().trim()));
              arr[13]=""+new java.math.BigDecimal(temp).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
              arr[14]="0";
          }
              arr[15]=""+new java.math.BigDecimal(Double.valueOf(arr[13])+Double.valueOf(arr[14])).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
          dtm.addRow(arr);

          calculateJobAmt();
          jComboBox2.requestFocus();
          clearWindow();
          return true;
     }
     catch(Exception ae)
     {
          System.out.println("Error in addop method"+ae);
     }
    return true;
}
public void calculateJobAmt()
    {
        try
        {
            double total=0;
            if(dtm.getRowCount()>0)
            {
                for(int i=0;i<dtm.getRowCount();i++)
                {
                    total=total+Double.valueOf(jTable1.getValueAt(i, 15).toString());
                }
            }
            jLabel13.setText(""+new java.math.BigDecimal(total).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
        }
        catch(Exception ae)
        {
            System.out.println("Error in calculate method "+ae);
        }
    }
public void forword()
    {
        try
        {
            clearWindow();
            jButton6.setEnabled(true);
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

            int ltype=0;

            String dt[]=jFormattedTextField1.getText().split("-");
            String d1=dt[2]+"-"+dt[1]+"-"+dt[0];
            String sn="";
            System.out.println("dtm.getRowCount()>0");
            if(dtm.getRowCount()>0)
            {
                dt=jTable1.getValueAt(0, 1).toString().split("-");
                System.out.println("dt="+dt);
                String shift=jTable1.getValueAt(0, 2).toString();
                System.out.println("shift="+shift);
                String date=dt[2]+"-"+dt[1]+"-"+dt[0];
                System.out.println("date="+date);

               String qry="select (sno+1) from nozzle_sale_entry where Date='"+date+"'and Shift='"+shift+"' order by sno asc";
               System.out.println(qry);
               sn=object1.getSigetngleValue(qry, Main.year);
               System.out.println("sno="+sn);
            }
            else if(dtm.getRowCount() < 1)
            {
               String qry="select max(sno) from nozzle_sale_entry ";
               System.out.println(qry);
               sn=object1.getSigetngleValue(qry, Main.year);
               System.out.println("sno="+sn);
               jButton7.setEnabled(false);
               jButton6.setEnabled(true);
            }
            dtm.setRowCount(0);
           if(sn!=null && object1.isInteger(sn))
           {
               String qry="select * from nozzle_sale_entry where sno="+Integer.parseInt(sn)+"";
               //String qry="select * from nozzle_sale_entry where Date='"+date+"'and Shift='"+jComboBox1.getSelectedItem().toString()+"'";
                String load[][]=object1.getInformationDD(qry, 10, Main.year);
                if(load.length>0)
                {
                    String arr[]=new String[17];
                    for(int i=0;i<arr.length;i++)
                    {
                        arr[0]=""+(i+1);
                               arr[1]=load[i][1];
                               dt=arr[1].split("-");
                               arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                               arr[2]=load[i][2];
                               arr[3]=load[i][3];
                               arr[4]=load[i][4];
                               arr[5]=load[i][5];
                               //arr[6]=load[i][6];
                               String date=load[i][1];
                               System.out.println("i m ok..........."+1);
                               if(arr[2].equalsIgnoreCase("Day"))
                                {
                                    qry="Select Closing from nozzle_sale_entry where Tank_Name='"+arr[4]+"' and Nozzle_No="+Integer.parseInt(arr[5])+" and Date<'"+date+"' order by sno desc";
                                }
                                if(arr[2].equalsIgnoreCase("Night"))
                                {
                                    String day="Day",night="Night";
                                    qry="Select Closing from nozzle_sale_entry where Tank_Name='"+arr[4]+"' and Nozzle_No="+Integer.parseInt(arr[5])+" and (Date='"+date+"' and Shift='"+day+"') or Date<'"+date+"' order by sno desc";

                                }
                               System.out.println(qry);
                               //qry="select Closing from nozzle_sale_entry where Date<'"+date+"' and Shift<>'"+jComboBox1.getSelectedItem().toString()+"' order by sno desc";
                               String temp11=object1.getSigetngleValue(qry, Main.year);
                               if(temp11==null || temp11.isEmpty())
                               {
                                   qry="select Opening from nozzle_master where TankName='"+arr[4]+"'and Nozzle_No='"+arr[5]+"'";
                                   temp11=object1.getSigetngleValue(qry, Main.year);
                               }
                               System.out.println(qry);
                               arr[6]=temp11;
                               arr[7]=load[i][6];
                               arr[8]=load[i][7];
                               System.out.println("arr[7]="+arr[7]+"   arr[8]="+arr[8]+"  arr[6]="+arr[6]);
                               arr[9]=""+(Double.valueOf(arr[7])-Double.valueOf(arr[6])-Double.valueOf(arr[8]));
                               System.out.println("i m ok..........."+2);
                               arr[10]=load[i][8];
                               arr[11]=load[i][9];
                               System.out.println("i m ok..........."+3);
                               double xx=getx(i,arr[4],arr[5]);
                               double temp=(Double.valueOf(arr[9])-((Double.valueOf(arr[11])-Double.valueOf(arr[10]))));
                               System.out.println("temp="+temp+" xx="+xx);
                               arr[12]=""+(temp*xx/100);
                               System.out.println("i m ok..........."+4);
                               int x=getxType(arr[4],arr[5]);
                               qry="Select SaleRate from tank_master where TankName='"+arr[4]+"'";
                               String amt=object1.getSigetngleValue(qry, Main.year);
                                if(x==1)
                                {
                                     double tem=(temp * Double.valueOf(amt));
                                     arr[13]=""+new java.math.BigDecimal(tem).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                                     double temp1=(Double.valueOf(arr[12]) * Double.valueOf(amt));
                                     arr[14]=""+new java.math.BigDecimal(temp1).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                                }
                               else if(x == 2 || x == 3)
                                {
                                      double tem=(temp * Double.valueOf(amt));
                                      arr[13]=""+new java.math.BigDecimal(tem).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                                      arr[14]="0";
                                }
                               arr[15]=""+new java.math.BigDecimal(Double.valueOf(arr[13])+Double.valueOf(arr[14])).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                               
                               dtm.addRow(arr);
                    }
                   System.out.println(load[0][0]);
                   dt=load[0][0].split("-");
                   jFormattedTextField1.setText(dt[2]+"-"+dt[1]+"-"+dt[0]);


               }
            }
                   String qry="select sno from op_reading_entry where Date>'"+d1+"' order by sno desc";
                   System.out.println(qry);
                   sn=object1.getSigetngleValue(qry, Main.year);
                   System.out.println("sno="+sn);
                   if(sn.isEmpty())
                   {
                       jButton7.setEnabled(false);
                       jButton6.setEnabled(true);
                   }
                   //clr();
                   calculateJobAmt();
            
        }
        catch(Exception ex)
        {
            System.out.println("Error in forward method......"+ex);
        }
    }
public double getx(int i,String tname,String nozzle)
    {
        double xx=0;
        try
        {
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
            //jComboBox1.removeAllItems();
            System.out.println(i);
            String qry="Select PerLogic from nozzle_master where TankName='"+tname+"'and Nozzle_No="+Integer.parseInt(nozzle)+"";
            System.out.println(qry);
            String getItemper=object1.getSigetngleValue(qry, Main.year);
            System.out.println(getItemper);
            qry="Select LeverageType from nozzle_master where TankName='"+tname+"'and Nozzle_No="+Integer.parseInt(nozzle)+"";
            System.out.println(qry);
            String getItemtyp=object1.getSigetngleValue(qry, Main.year);
            System.out.println(getItemtyp);

            xx=Double.valueOf(getItemper);
            if(xx==3)
                xx=0;
        }
        catch(Exception ae)
        {
            System.out.println("Error in getx method."+ae);
        }
        return xx;
    }
public int getxType(String tnm,String nozzle)
    {
        int x=0;
        try
        {
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
            //jComboBox1.removeAllItems();

            String qry="Select LeverageType from nozzle_master where TankName='"+tnm+"'and Nozzle_No="+Integer.parseInt(nozzle)+"";
            System.out.println(qry);
            String getItemtyp=object1.getSigetngleValue(qry, Main.year);
            System.out.println(getItemtyp);

            x=Integer.parseInt(getItemtyp);

        }
        catch(Exception ae)
        {
            System.out.println("Error in getxx method."+ae);
        }
        return x;
    }
public void backword()
    {
        try
        {
            clearWindow();
            jButton7.setEnabled(true);
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

            int ltype=0;

            String dt[]=jFormattedTextField1.getText().split("-");
            String d1=dt[2]+"-"+dt[1]+"-"+dt[0];

            String sn="";
           if(dtm.getRowCount()>0)
            {
                dt=jTable1.getValueAt(0, 1).toString().split("-");
                String shift=jTable1.getValueAt(0, 2).toString();
                String date=dt[2]+"-"+dt[1]+"-"+dt[0];

               String qry="select (sno-1) from nozzle_sale_entry where Date='"+date+"'and Shift='"+shift+"' order by sno asc";
               System.out.println(qry);
               sn=object1.getSigetngleValue(qry, Main.year);
               System.out.println("sno="+sn);
            }
            if(dtm.getRowCount()<1)
            {
               String qry="select max(sno) from nozzle_sale_entry ";
               System.out.println(qry);
               sn=object1.getSigetngleValue(qry, Main.year);
               System.out.println("sno="+sn);
               jButton6.setEnabled(true);
               //jButton7.setEnabled(false);
            }
            dtm.setRowCount(0);
           if(sn!=null && object1.isInteger(sn))
           {
               String qry="select * from nozzle_sale_entry where sno="+Integer.parseInt(sn)+"";
               //String qry="select * from nozzle_sale_entry where Date='"+date+"'and Shift='"+jComboBox1.getSelectedItem().toString()+"'";
                String load[][]=object1.getInformationDD(qry, 10, Main.year);
                if(load.length>0)
                {
                    String arr[]=new String[17];
                    for(int i=0;i<arr.length;i++)
                    {
                        arr[0]=""+(i+1);
                               arr[1]=load[i][1];
                               dt=arr[1].split("-");
                               arr[1]=dt[2]+"-"+dt[1]+"-"+dt[0];
                               arr[2]=load[i][2];
                               arr[3]=load[i][3];
                               arr[4]=load[i][4];
                               arr[5]=load[i][5];
                               //arr[6]=load[i][6];
                               String date=load[i][1];
                               System.out.println("i m ok..........."+1);
                               if(arr[2].equalsIgnoreCase("Day"))
                                {
                                    qry="Select Closing from nozzle_sale_entry where Tank_Name='"+arr[4]+"' and Nozzle_No="+Integer.parseInt(arr[5])+" and Date<'"+date+"' order by sno desc";
                                }
                                if(arr[2].equalsIgnoreCase("Night"))
                                {
                                    String day="Day",night="Night";
                                    qry="Select Closing from nozzle_sale_entry where Tank_Name='"+arr[4]+"' and Nozzle_No="+Integer.parseInt(arr[5])+" and (Date='"+date+"' and Shift='"+day+"') or Date<'"+date+"' order by sno desc";

                                }
                               System.out.println(qry);
                               //qry="select Closing from nozzle_sale_entry where Date<'"+date+"' and Shift<>'"+jComboBox1.getSelectedItem().toString()+"' order by sno desc";
                               String temp11=object1.getSigetngleValue(qry, Main.year);
                               if(temp11==null || temp11.isEmpty())
                               {
                                   qry="select Opening from nozzle_master where TankName='"+arr[4]+"'and Nozzle_No='"+arr[5]+"'";
                                   temp11=object1.getSigetngleValue(qry, Main.year);
                               }
                               System.out.println(qry);
                               arr[6]=temp11;
                               arr[7]=load[i][6];
                               arr[8]=load[i][7];
                               System.out.println("arr[7]="+arr[7]+"   arr[8]="+arr[8]+"  arr[6]="+arr[6]);
                               arr[9]=""+(Double.valueOf(arr[7])-Double.valueOf(arr[6])-Double.valueOf(arr[8]));
                               System.out.println("i m ok..........."+2);
                               arr[10]=load[i][8];
                               arr[11]=load[i][9];
                               System.out.println("i m ok..........."+3);
                               double xx=getx(i,arr[4],arr[5]);
                               double temp=(Double.valueOf(arr[9])-((Double.valueOf(arr[11])-Double.valueOf(arr[10]))));
                               System.out.println("temp="+temp+" xx="+xx);
                               arr[12]=""+(temp*xx/100);
                               System.out.println("i m ok..........."+4);
                               int x=getxType(arr[4],arr[5]);
                               qry="Select SaleRate from tank_master where TankName='"+arr[4]+"'";
                               String amt=object1.getSigetngleValue(qry, Main.year);
                                if(x==1)
                                {
                                     double tem=(temp * Double.valueOf(amt));
                                     arr[13]=""+new java.math.BigDecimal(tem).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                                     double temp1=(Double.valueOf(arr[12]) * Double.valueOf(amt));
                                     arr[14]=""+new java.math.BigDecimal(temp1).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                                }
                               else if(x == 2 || x == 3)
                                {
                                      double tem=(temp * Double.valueOf(amt));
                                      arr[13]=""+new java.math.BigDecimal(tem).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);
                                      arr[14]="0";
                                }
                               arr[15]=""+new java.math.BigDecimal(Double.valueOf(arr[13])+Double.valueOf(arr[14])).setScale(2,java.math.BigDecimal.ROUND_HALF_UP);

                               dtm.addRow(arr);
                    }
                   System.out.println(load[0][0]);
                   dt=load[0][0].split("-");
                   jFormattedTextField1.setText(dt[2]+"-"+dt[1]+"-"+dt[0]);


               }
            }
                   String qry="select sno from op_reading_entry where Date<'"+d1+"' order by sno desc";
                   System.out.println(qry);
                   sn=object1.getSigetngleValue(qry, Main.year);
                   System.out.println("sno="+sn);
                   if(sn.isEmpty())
                   {
                       jButton6.setEnabled(false);
                       jButton7.setEnabled(true);
                   }
                   calculateJobAmt();
        }
        catch(Exception ex)
        {
            System.out.println("Error in backword method......"+ex);
        }
    }
public void remove()
{
    if(dtm.getRowCount()>0)
    {
        dtm.removeRow(jTable1.getSelectedRow());
    }
}
public void hideRow()
{
    if(dtm.getRowCount()>0)
    {
        String arr[]=new String[16];
        arr[0]=dtm1.getRowCount()+"";
        arr[1]=jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
        arr[2]=jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
        arr[3]=jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
        arr[4]=jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
        arr[5]=jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
        arr[6]=jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();
        arr[7]=jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString();
        arr[8]=jTable1.getValueAt(jTable1.getSelectedRow(), 8).toString();
        arr[9]=jTable1.getValueAt(jTable1.getSelectedRow(), 9).toString();
        arr[10]=jTable1.getValueAt(jTable1.getSelectedRow(), 10).toString();
        arr[11]=jTable1.getValueAt(jTable1.getSelectedRow(), 11).toString();
        arr[12]=jTable1.getValueAt(jTable1.getSelectedRow(), 12).toString();
        arr[13]=jTable1.getValueAt(jTable1.getSelectedRow(), 13).toString();
        arr[14]=jTable1.getValueAt(jTable1.getSelectedRow(), 14).toString();
        arr[15]=jTable1.getValueAt(jTable1.getSelectedRow(), 15).toString();
        dtm1.addRow(arr);
        dtm.removeRow(jTable1.getSelectedRow());
        calculateJobAmt();
        System.out.println("dtm1.getRowcount="+dtm1.getRowCount());
    }
}
public void showRow()
{
    if(dtm1.getRowCount()>0)
    {
        System.out.println("i m in show row");
        String arr[]=new String[16];
        arr[0]=dtm.getRowCount()+"";
        arr[1]=jTable2.getValueAt(jTable2.getRowCount()-1, 1).toString();
        arr[2]=jTable2.getValueAt(jTable2.getRowCount()-1, 2).toString();
        arr[3]=jTable2.getValueAt(jTable2.getRowCount()-1, 3).toString();
        arr[4]=jTable2.getValueAt(jTable2.getRowCount()-1, 4).toString();
        arr[5]=jTable2.getValueAt(jTable2.getRowCount()-1, 5).toString();
        arr[6]=jTable2.getValueAt(jTable2.getRowCount()-1, 6).toString();
        arr[7]=jTable2.getValueAt(jTable2.getRowCount()-1, 7).toString();
        arr[8]=jTable2.getValueAt(jTable2.getRowCount()-1, 8).toString();
        arr[9]=jTable2.getValueAt(jTable2.getRowCount()-1, 9).toString();
        arr[10]=jTable2.getValueAt(jTable2.getRowCount()-1, 10).toString();
        arr[11]=jTable2.getValueAt(jTable2.getRowCount()-1, 11).toString();
        arr[12]=jTable2.getValueAt(jTable2.getRowCount()-1, 12).toString();
        arr[13]=jTable2.getValueAt(jTable2.getRowCount()-1, 13).toString();
        arr[14]=jTable2.getValueAt(jTable2.getRowCount()-1, 14).toString();
        arr[15]=jTable2.getValueAt(jTable2.getRowCount()-1, 15).toString();
        dtm.addRow(arr);
        dtm1.removeRow(jTable2.getRowCount()-1);
        calculateJobAmt();
    }

}
}
