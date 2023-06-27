/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Police_customer_work.java
 *
 * Created on Dec 12, 2013, 10:25:21 AM
 */

package golden_shoap;
import java.math.RoundingMode;
import java.sql.*;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user1
 */
public class Cancle_Deliver_Polish_work extends javax.swing.JInternalFrame {
 javax.swing.table.DefaultTableModel dtm;
 javax.swing.JCheckBox ch[]=new  javax.swing.JCheckBox[9];
 int gPurjaNumber=0;
// static int sNo=0;
    /** Creates new form Police_customer_work */
    public Cancle_Deliver_Polish_work(int purjaNumber1) {
        initComponents();
            gPurjaNumber=purjaNumber1;
            dtm=new javax.swing.table.DefaultTableModel();
            javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
            CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
            CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
            CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
            javax.swing.table.TableColumn column;
             String heading1[]={"S.N","Rate Apply","Item Name","Polish Type","Quantity","Unit","Weight Bf/P","Unit","Weight Af/P","Quantity Af/P","Rate","Unit","Amount"};
            dtm=new javax.swing.table.DefaultTableModel(heading1,0);
            jTable1.setModel(dtm);
            column=jTable1.getColumn("S.N");
            column.setCellRenderer(CRCenter);
            column.setPreferredWidth(30);

            column=jTable1.getColumn("Rate Apply");
            column.setCellRenderer(CRCenter);
            column.setPreferredWidth(90);

            column=jTable1.getColumn("Item Name");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(155);

            column=jTable1.getColumn("Polish Type");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(80);

            column=jTable1.getColumn("Quantity");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(57);

            column=jTable1.getColumn("Unit");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(60);

            column=jTable1.getColumn("Weight Bf/P");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(75);

            column=jTable1.getColumn("Unit");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(25);

            column=jTable1.getColumn("Weight Af/P");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(80);

            column=jTable1.getColumn("Quantity Af/P");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(80);

            column=jTable1.getColumn("Rate");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(58);

            column=jTable1.getColumn("Unit");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(60);

            column=jTable1.getColumn("Amount");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(75);
            //for zerox of payable amount
            jLabel22.setVisible(false);
            //End
            jLabel11.setText(""+purjaNumber1);
            String qry="Select rec_date,ac_code from polish_details where purja_number="+purjaNumber1+"";
            //to set date
            String data[][]=Utility.getInformationDD(qry,2);
            String d[]=(data[0][0]).split(" ");
            String d1[]=d[0].split("-");
            jLabel10.setText((d1[2]+"-"+d1[1]+"-"+d1[0]));
            //End
            qry="select ac_name from ac_master where ac_code="+(Integer.parseInt(data[0][1]))+"";
            String name=Utility.getSingleValue(qry);
            jLabel4.setText(name);
            jTextField7.setText("0.00");
            //To hold paid amount
            jLabel8.setVisible(false);
            //load data on the table
            loadData(purjaNumber1);
            jTable1.setEnabled(false);


            //Refund amount panel visibility false
           /* jPanel1.setVisible(false);
             //jLabel 26 is used to hold the value of payable amount when user enter the weight after polish(used to manage paid amount)
            jLabel26.setText(jTextField6.getText());*/
            jLabel26.setVisible(false);
            for(int i=0;i<(jTable1.getRowCount());i++)
            {
                ch[i].setEnabled(false);
            }

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
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));
        setClosable(true);
        setIconifiable(true);
        setTitle("Cancle Polish Work");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel1.setText("Receiving Date");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 20, 100, 23);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel2.setText("Purja Number");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(840, 20, 90, 23);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setText("Select Customer's A/C");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 20, 140, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 990, 240);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel21.setText("Total Amount( in Rs)");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(760, 330, 140, 20);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.gif"))); // NOI18N
        jButton6.setMnemonic('c');
        jButton6.setText("Cloce");
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
        jButton6.setBounds(220, 410, 160, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 460, 980, 10);

        jLabel10.setBackground(new java.awt.Color(235, 217, 254));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("jLabel10");
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10);
        jLabel10.setBounds(550, 20, 90, 23);

        jLabel11.setBackground(new java.awt.Color(235, 217, 254));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("jLabel11");
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11);
        jLabel11.setBounds(930, 20, 70, 23);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/golden_shoap/cal.png"))); // NOI18N
        jLabel12.setText("jLabel12");
        jLabel12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
        });
        jLabel12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel12KeyPressed(evt);
            }
        });
        getContentPane().add(jLabel12);
        jLabel12.setBounds(640, 20, 30, 23);

        jTextField4.setBackground(new java.awt.Color(235, 217, 254));
        jTextField4.setFont(new java.awt.Font("Arial", 1, 12));
        jTextField4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jTextField4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jTextField4.setOpaque(true);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(900, 330, 100, 22);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 60, 1020, 10);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel16.setText("Discount ( in Rs)");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(760, 390, 110, 20);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel17.setText("Paid Amount (in Rs)");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(760, 470, 120, 20);

        jTextField6.setBackground(new java.awt.Color(235, 217, 254));
        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Arial", 1, 12));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField6MousePressed(evt);
            }
        });
        getContentPane().add(jTextField6);
        jTextField6.setBounds(900, 420, 100, 22);

        jLabel18.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel18.setText("Payable Amount");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(760, 420, 130, 20);

        jLabel20.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel20.setText("Rounding value  ");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(760, 360, 100, 20);

        jLabel9.setBackground(new java.awt.Color(235, 217, 254));
        jLabel9.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9);
        jLabel9.setBounds(900, 360, 100, 22);
        getContentPane().add(jLabel22);
        jLabel22.setBounds(780, 460, 40, 0);
        getContentPane().add(jLabel23);
        jLabel23.setBounds(780, 480, 0, 0);

        jLabel4.setBackground(new java.awt.Color(235, 217, 254));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 20, 200, 23);

        jLabel7.setBackground(new java.awt.Color(235, 217, 254));
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(610, 470, 100, 22);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel6.setText("Paid At Receiving ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(470, 470, 120, 30);

        jLabel8.setText("to hold paid amount");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(340, 470, 120, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jButton1.setText("Cancle Deliver Process");
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
        jButton1.setBounds(20, 410, 180, 30);

        jLabel26.setText("jLabel26");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(860, 440, 110, 14);

        jTextField5.setBackground(new java.awt.Color(235, 217, 254));
        jTextField5.setFont(new java.awt.Font("Arial", 0, 12));
        jTextField5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jTextField5.setOpaque(true);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(900, 390, 100, 20);

        jTextField7.setBackground(new java.awt.Color(235, 217, 254));
        jTextField7.setFont(new java.awt.Font("Arial", 0, 12));
        jTextField7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));
        jTextField7.setOpaque(true);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(900, 470, 100, 22);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeskTopTextureEdit11.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1020, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    
     public void check()
    {   int rowCount=jTable1.getRowCount();
        int row= jTable1.getSelectedRow();
           if(row>=0 && row<=rowCount)
           {          
                                    String cc=""+jTable1.getValueAt(row,8);
                                    boolean bn=Utility.isDouble(cc);
                                    if(bn==true)
                                    {   if(Double.valueOf(cc)==0)
                                            {
                                            jTable1.setValueAt("0.000",row,8);
                                            }
                                    }
                                    jTable1.editCellAt(row,8);
                       
           }
    }
   public void loadData(int purjaNumber)
    {
       dtm.setRowCount(0);
       int count=0;
       String qry="Select * from polish_details where purja_number="+purjaNumber+"";
                            String load[][]=Utility.getInformationDD(qry, 21);
                            System.out.println(qry+" length="+load.length);
                            double total=0;
                            String totamt="";
                            int itemno=0;
                            String arr[];
                            if(load.length>0)
                            {
                                //create array of checkBox and assign value
                                int s=0;
                                int x=1000;
                                int y=112;
                                int h=18;
                                int w=20;
                                //End

                                arr=new String[13];
                                    for(int i=0;i<load.length;i++)
                                    {
                                        //To make check box as a enabled
                                        ch[i]=new javax.swing.JCheckBox();
                                        ch[i].setBounds(x, y, w, h);
                                        ch[i].setVisible(true);
                                        int status=Integer.parseInt(load[i][14]);
                                        if(status==2)
                                        { ch[i].setSelected(true);
                                        }
                                        else
                                        {
                                            ch[i].setSelected(false);
                                        }
                                        jLabel5.add(ch[i]);
                                        y=y+20;
                                        //End

                                        arr[0]=""+(i+1);
                                        arr[1]=load[i][12];
                                        arr[2]=load[i][3];
                                        arr[3]=load[i][4];
                                        arr[4]=load[i][5];
                                        arr[5]=load[i][6];
                                        arr[6]=load[i][7];
                                        arr[7]=load[i][8];
                                        arr[8]=load[i][9];
                                        //to assign quantity after polish
                                        arr[9]=load[i][5];
                                        //to assign rate
                                        arr[10]=load[i][10];
                                        System.out.println("Value="+load[i][10]);
                                        arr[11]=load[i][11];
                                        System.out.println("Value="+load[i][11]);

                                        arr[12]=load[i][13];

                                        total=total+Double.valueOf(arr[12]);

                                      java.math.BigDecimal bd=new java.math.BigDecimal(arr[6]);
                                      arr[6]=(""+bd.setScale(3,5));
                                      bd=new java.math.BigDecimal(arr[8]);
                                      if(Double.valueOf(arr[8])>0)
                                      {
                                      arr[8]=(""+bd.setScale(3,5));
                                      }
                                      else
                                      {
                                          arr[8]="";
                                      }
                                      bd=new java.math.BigDecimal(arr[10]);
                                      arr[10]=(""+bd.setScale(2,5));
                                      bd=new java.math.BigDecimal(arr[12]);
                                      arr[12]=(""+bd.setScale(2,5));
                                      dtm.addRow(arr);
                                    }
                            }
                                                             int count1=dtm.getRowCount();
                                                             double oldAmount=0;
                                                             double newAmount=0;
                                                             double discount=0;
                                                             for(int i=0;i<count1;i++)
                                                             {
                                                                oldAmount=Double.valueOf(""+dtm.getValueAt(i,12));
                                                                newAmount= newAmount+oldAmount;
                                                             }
                                                              java.math.BigDecimal bd4=new java.math.BigDecimal(newAmount);
                                                              jTextField4.setText(""+bd4.setScale(2,5));
                                                              double payableAmount=Double.valueOf(""+bd4.setScale(0,java.math.BigDecimal.ROUND_HALF_UP));
                                                              if(jTextField5.getText().isEmpty()==false)
                                                              {
                                                                  if(Utility.isDouble(jTextField5.getText()))
                                                                  {
                                                                    discount=Double.valueOf(jTextField5.getText());
                                                                  }
                                                              }
                                                              payableAmount=(payableAmount-discount);
                                                              bd4=new java.math.BigDecimal(payableAmount);
                                                              //jTextField6.setText(""+bd4.setScale(2,5));

                                                              discount();
                                                              payableAmount();
                                                              //label22 visibility false
                                                              jLabel22.setText(""+bd4.setScale(2,5));
                                                              double rounding=((Double.valueOf(jTextField4.getText()))-(payableAmount));
                                                              bd4=new java.math.BigDecimal(rounding);
                                                              jLabel9.setText(""+bd4.setScale(2,5));
                                                              paidAmount();


 }
    public void payableAmount()
    {
                            String qry="Select payable_amount from polish_details where purja_number="+gPurjaNumber+"";
                            double payableAmount=Double.valueOf(Utility.getSingleValue(qry));
                            java.math.BigDecimal bd4=new java.math.BigDecimal(payableAmount);
                            jTextField6.setText(""+bd4.setScale(2,5));
    }
   public void edetingTotal()
    {
         int count1=dtm.getRowCount();
         double oldAmount=0;
         double newAmount=0;
         double discount=0;
         for(int i=0;i<count1;i++)
         {
            oldAmount=Double.valueOf(""+dtm.getValueAt(i,11));
            newAmount= newAmount+oldAmount;
         }
          java.math.BigDecimal bd4=new java.math.BigDecimal(newAmount);
          jTextField4.setText(""+bd4.setScale(2,5));
          double payableAmount=Double.valueOf(""+bd4.setScale(0,java.math.BigDecimal.ROUND_HALF_UP));
          //System.out.println("P="+payableAmount);
           if(jTextField5.getText().isEmpty()==false)
           {
                 if(Utility.isDouble(jTextField5.getText()))
                  {
                        discount=Double.valueOf(jTextField5.getText());
                   }
            }
          // System.out.println("D="+discount);
          bd4=new java.math.BigDecimal((payableAmount-discount));
          jTextField6.setText(""+bd4.setScale(2,5));
          //label22 visibility false
          jLabel22.setText(""+payableAmount);
          //end
          double rounding=(payableAmount-(Double.valueOf(jTextField4.getText())));
          bd4=new java.math.BigDecimal(rounding);
          jLabel9.setText(""+bd4.setScale(2,5));

          //to manage paid amount
          double oldPayableAmount=Double.valueOf(jLabel26.getText());

          if(oldPayableAmount!=(payableAmount-discount))
          {
                      String qry="Select distinct paid_at_receive from polish_details where purja_number="+gPurjaNumber+"";
                      double paidAtReceive=Double.valueOf(Utility.getSingleValue(qry));
                      bd4=new java.math.BigDecimal((payableAmount-discount)-paidAtReceive);
                      jTextField7.setText(""+bd4.setScale(2,5));
                      //to update value of label 26
                      jLabel26.setText(""+(payableAmount-discount));
         }
   }

     public void calenderDate()
    {   Calender c=new Calender();
        jLabel10.setText(c.getdate());
    }
     public void calculateTotal()
    {
       try
        {       int row=jTable1.getSelectedRow();
                String amount1="";
                String weight="";
                String paymentApply="";
                double rate=0;
                int totalRow=jTable1.getRowCount();
                //for weight
                        if((row==0))
                        {   if(totalRow==1)
                            {
                               
                            }
                             weight=""+jTable1.getValueAt(totalRow-1,8);
                             if(Utility.isDouble(weight))
                             {
                             rate=Double.valueOf(""+jTable1.getValueAt(totalRow-1,9));
                             paymentApply=""+jTable1.getValueAt(totalRow-1,1);
                             //jTable1.editCellAt(totalRow-1,8);
                             }
                             else
                             {    
                                 javax.swing.JOptionPane.showMessageDialog(this,"Error.....!!!!!!!!!!!!!! Enter valid weight." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                 jTable1.setValueAt("", totalRow-1, 8);
                                 //jTable1.editCellAt(totalRow-1,8);
                                 jTable1.setRowSelectionInterval(totalRow-1,totalRow-1);
                             }

                        }
                        else
                        {   weight=""+jTable1.getValueAt(row-1,8);
                             if(Utility.isDouble(weight))
                             {
                                 rate=Double.valueOf(""+jTable1.getValueAt(row-1,9));
                                 paymentApply=""+jTable1.getValueAt(row-1,1);
                                 //jTable1.editCellAt(totalRow-1,8);
                             }
                            else
                             {  
                                 javax.swing.JOptionPane.showMessageDialog(this,"Error.....!!!!!!!!!!!!!!!1 Enter valid weight." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                 jTable1.setValueAt("", row-1, 8);
                                 //jTable1.editCellAt(row-1,8);
                                 jTable1.setRowSelectionInterval(row-1,row-1);
                             }
                        }
                if(paymentApply.equals("After Polish"))
                {
                    double amount=(rate*(Double.valueOf(weight)));
                    java.math.BigDecimal bd=new java.math.BigDecimal(amount);
                    amount1=""+(bd.setScale(2,5));
                   //for amount
                     if((row==0))
                        {   jTable1.setValueAt(amount1, totalRow-1, 11);}
                     else
                        {jTable1.setValueAt(amount, row-1, 11);}
                }
       }
        catch(Exception ex)
       {
         System.out.println(ex)   ;
       }
    }
    public boolean validation()
    {
                int row=jTable1.getSelectedRow();
                String weight="";
                int totalRow=jTable1.getRowCount();
                //for weight
                        if((row==0))
                        {    weight=""+jTable1.getValueAt(totalRow-1,8);
                             if(Utility.isDouble(weight)==false)
                             {      
                                  //  javax.swing.JOptionPane.showMessageDialog(this,"Error..... Enter valid weight." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                   // weight=weight.substring(0,(weight.length()-1));
                                   // jTable1.setValueAt(weight, row-1,8);
                                    jTable1.editCellAt(row-1,8);
                                   // return false;
                             }
                        }
                        else
                        {   weight=""+jTable1.getValueAt(row-1,8);
                             if(Utility.isDouble(weight)==false)
                             {
                                 //System.out.println(",,,,,,,,,"+weight);
                                 //javax.swing.JOptionPane.showMessageDialog(this,"Error..... Enter valid weight." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                 //weight=weight.substring(0,(weight.length()-1));
                                  //jTable1.setValueAt(weight, row-1,8);
                                  jTable1.editCellAt(row,8);
                                // return false;
                             }
                        }
                        

       return true;

    }

   public void errorMsg()
    {
        javax.swing.JOptionPane.showMessageDialog(this,"Error..... Enter valid weight." ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
   public void discount()
   {                        String qry="Select discount from polish_details where purja_number="+gPurjaNumber+"";
                            double discount=Double.valueOf(Utility.getSingleValue(qry));
                            java.math.BigDecimal bd4=new java.math.BigDecimal(discount);
                            jTextField5.setText(""+bd4.setScale(2,5));
                            jLabel23.setText(""+discount);
    }
   public void paidAmount()
  {                         String qry="Select paid_at_receive from polish_details where purja_number="+gPurjaNumber+"";
                            String str=(Utility.getSingleValue(qry));
                            double paidAtReceive=0;
                            if(Utility.isDouble(str))
                            {
                                paidAtReceive=Double.valueOf(str);
                            }
                            java.math.BigDecimal bd4=new java.math.BigDecimal(paidAtReceive);
                            jLabel7.setText(""+bd4.setScale(2,5));
                            double amount=0;
                            qry="Select voucher_amount from receive_voucher where purja_number="+gPurjaNumber+" and voucher_type='Receive'";
                            String data=Utility.getSingleValue(qry);
                            if(data.isEmpty()|| data==null)
                            {
                                amount=0;
                            }
                            else
                            {   amount=Double.valueOf(data);
                                bd4=new java.math.BigDecimal(amount-paidAtReceive);
                                jTextField7.setText(""+bd4.setScale(2,5));
                                jLabel8.setText(""+(amount-paidAtReceive));
                            }
   }
   public boolean  ReceivePaidAmount()
   {   if(Utility.isDouble(jTextField7.getText())==true)
       {
       if((Double.valueOf(jTextField7.getText())>=0) || (Double.valueOf(jLabel7.getText())>=0))
        {
                      double totalPaidAmount=((Double.valueOf(""+jTextField7.getText())+(Double.valueOf(jLabel7.getText()))));
                      String byAccount=""+jLabel4.getText();
                      String qry="select ac_code from ac_master where ac_name='"+byAccount+"'";
                      int byAccountCode=Integer.parseInt(Utility.getSingleValue(qry));
                      int toAccountCode=9;
                      // update old paid amount and new paid amount in receive voucher table
                      if((Double.valueOf(jLabel7.getText()))>=0 && (Double.valueOf(jTextField7.getText()))>=0)
                      {
                       qry="Update receive_voucher set voucher_amount="+totalPaidAmount+" where purja_number="+gPurjaNumber+"";
                       System.out.println(qry);
                       boolean b=Utility.saveInformation(qry);
                       if(b==true)
                       {
                            accountPaidAmount();
                       }
                       //for Account updtion
                      }
                      if((Double.valueOf(jLabel7.getText()))==0 && (Double.valueOf(jTextField7.getText()))>0)
                      {       int voucherNumber=setVoucherNumber();
                              String date=""+jLabel10.getText();
                              qry="insert into receive_voucher values('Receive',"+voucherNumber+",'"+date+"',"+byAccountCode+","+toAccountCode+","+totalPaidAmount+",' ',"+gPurjaNumber+")";
                              boolean bn=Utility.saveInformation(qry);
                              if(bn==true)
                               {
                                    accountPaidAmount();
                               }
                      }

         }

       }
       else
       {
            return false;
       }
         return true;
   }
   public boolean accountPaidAmount()
  {
           if(jTextField7.getText().isEmpty()==false)
           {
                 if(Utility.isDouble(jTextField7.getText()))
                  {
                        //to find old paid amount so that subtact this amount from cr and dr and add new amount
                        double oldpaidAmount=Double.valueOf(jLabel8.getText());
                        //End
                        String byAccount=""+jLabel4.getText();
                        String qry="select ac_code from ac_master where ac_name='"+byAccount+"'";
                        int byAccountCode=Integer.parseInt(Utility.getSingleValue(qry));
                        int toAccountCode=9;
                        qry="select ac_cr from ac_smry where ac_code="+byAccountCode+"";
                        double acCr=Double.valueOf(Utility.getSingleValue(qry));
                        //to roll back paid amount
                        acCr=(acCr-oldpaidAmount);
                        //end
                        acCr=(acCr+(Double.valueOf(""+jTextField7.getText())));
                        qry="Update ac_smry set ac_cr="+acCr+" where ac_code="+byAccountCode+"";
                        Utility.saveInformation(qry);
                        //update cash account dr with new new paid amount
                        qry="select ac_Dr from ac_smry where ac_code="+toAccountCode+"";
                        double acDr=Double.valueOf(Utility.getSingleValue(qry));
                         //to roll back paid amount
                        acDr=(acDr-oldpaidAmount);
                        //End
                        acDr=(acDr+(Double.valueOf(""+jTextField7.getText())));
                        qry="Update ac_smry set ac_dr="+acDr+" where ac_code="+toAccountCode+"";
                        Utility.saveInformation(qry);
                    }
            }
           return true;
   }
    public int setVoucherNumber()
    {   int voucherNumber=0;
        try
        {          String qry="select max(voucher_number) from receive_voucher where voucher_type='Receive'";
                    String str=Utility.getSingleValue(qry);
                     if(str==null)
                     { voucherNumber=1;}
                    else
                     {voucherNumber=(Integer.parseInt(str)+1);}
        }
        catch(NullPointerException npe)
        { System.out.println(npe);
        }
        return voucherNumber;
   }
    public void takeInput()
    {
         String purjaNumber=javax.swing.JOptionPane.showInputDialog(this,"Enter purja number." ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
         int flag=0;
         int status=2;
         if(purjaNumber!=null)
         {
             if(Utility.isInteger(purjaNumber))
             {
                     String qry="select purja_number from polish_details where purja_number="+(Integer.parseInt(purjaNumber))+" and status="+status+"";
                     String data[][]=Utility.getInformationDD(qry,1);
                     for(int i=0;i<data.length;i++)
                     {
                         if((data[i][0]).equals(""+purjaNumber))
                         {
                             flag=1;
                             break;
                         }
                     }
                    if(flag==1)
                    {
                    Edit_Deliver_Polish_work ob=new  Edit_Deliver_Polish_work(Integer.parseInt(purjaNumber));
                    ob.setBounds(5,100,1020, 549);
                    Master_Screen.jDesktopPane1.add(ob);
                    ob.setVisible(true);
                    }
                    else
                    {
                          javax.swing.JOptionPane.showMessageDialog(this,"Error...Invalid purja number. " ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);

                    }
             }
             else
             {
                      javax.swing.JOptionPane.showMessageDialog(this,"Error...Enter purja number in number format. " ,"Message Box",javax.swing.JOptionPane.INFORMATION_MESSAGE);
             }
         }
    }
    public boolean manageAccountDiscount()
    {      if(jTextField5.getText().isEmpty()==false)
           {
                 if(Utility.isDouble(jTextField5.getText()))
                  {

                            int acCode=8;
                            String qry="select discount from polish_details where purja_number="+gPurjaNumber+"";
                            double oldDiscount=Double.valueOf(Utility.getSingleValue(qry));
                            qry="select ac_dr from ac_smry where ac_code="+acCode+"";
                            double acDr=Double.valueOf(Utility.getSingleValue(qry));
                            acDr=(acDr-oldDiscount);
                            acDr=acDr+(Double.valueOf(jTextField5.getText()));
                            qry="Update ac_smry set ac_dr="+acDr+" where ac_code="+acCode+"";
                            boolean b=Utility.saveInformation(qry);
                            if(b==false)
                            {
                                    return false;
                            }
                  }
           }
           return true;
    }

   public boolean Update()
   {
              String date=jLabel10.getText();
              String d[]=date.split("-");
              date=d[1]+"/"+d[0]+"/"+d[2];
              int purjaNumber=Integer.parseInt(jLabel11.getText());
              String accountName=""+jLabel4.getText();
              String qry="select ac_code from ac_master where ac_name='"+accountName+"'";
              int accountCode=Integer.parseInt(Utility.getSingleValue(qry));

              //manage Account CR and Dr
                            String acName=""+jLabel4.getText();
                            double newDiscount=0;
                            qry="select ac_dr from ac_smry where ac_code="+accountCode+"";
                            double acDr=Double.valueOf(Utility.getSingleValue(qry));
                            //formula for update (acDr+(newPayableAmount-oldPayableAmount))
                            qry="select payable_amount from polish_details where purja_number="+gPurjaNumber+"";
                            double oldPayableAmount=Double.valueOf(Utility.getSingleValue(qry));
                            double newPayableAmount=Double.valueOf(jTextField6.getText());
                            //System.out.println("npa=="+newPayableAmount);
                            acDr=((acDr-oldPayableAmount)+(newPayableAmount));
                            //System.out.println("acdr==="+acDr);
                            qry="Update ac_smry set ac_dr="+acDr+" where ac_code="+accountCode+"";
                            boolean b=Utility.saveInformation(qry);
                            if(b==false)
                            {
                                return false;
                            }
                            qry="select discount from polish_details where purja_number="+gPurjaNumber+"";
                            double oldDiscount=Double.valueOf(Utility.getSingleValue(qry));
                            //System.out.println("Od=="+oldDiscount);
                            if(jTextField5.getText().isEmpty()==false)
                            {
                                 if(Utility.isDouble(jTextField5.getText()))
                                 {
                                      newDiscount=Double.valueOf(jTextField5.getText());
                                 }
                            }
                            System.out.println("Nd=="+newDiscount);
                            qry="select ac_cr from ac_smry where ac_code="+10+"";
                            double acCr=Double.valueOf(Utility.getSingleValue(qry));
                            acCr=(acCr-(oldPayableAmount+oldDiscount))+((newPayableAmount+newDiscount));
                            System.out.println("acCr==="+acCr);

                            qry="Update ac_smry set ac_cr="+acCr+" where ac_code="+10+"";
                            b=Utility.saveInformation(qry);
                            if(b==false)
                            {
                                return false;
                            }
              //End
              int status=2;
              String itemName="";
              String polishType="";
              double quantity=0;
              String quantityUnit="";
              double weight=0;
              String weightUnit="";
              double rate=0;
              String rateUnit="";
              int row=dtm.getRowCount();
              double amount=0;
              double weightAfterPolish=0;
              String paymentApply="";
              boolean bn=false;

              qry="select paid_at_receive from polish_details where purja_number="+gPurjaNumber+"";
              double paidAtReceive=Double.valueOf(Utility.getSingleValue(qry));
              System.out.println(paidAtReceive);

              qry="select distinct discount_at_receive from polish_details where purja_number="+gPurjaNumber+"";
              double discountAtReceive=Double.valueOf(Utility.getSingleValue(qry));

                     //Delete old Existing record of same purja number
                     qry="delete * from polish_details where purja_number="+gPurjaNumber+"";
                     bn=Utility.saveInformation(qry);
                     System.out.println("!!!!!!!!!!!!");
                     if(bn==false)
                     {
                         return false;
                     }

              for(int i=0;i<row;i++)
              {
                      itemName=""+dtm.getValueAt(i,2);
                      polishType=""+dtm.getValueAt(i,3);
                      quantity=Double.valueOf(""+dtm.getValueAt(i,4));
                      quantityUnit=(""+dtm.getValueAt(i,5));
                      weight=Double.valueOf(""+dtm.getValueAt(i,6));
                      weightUnit=(""+dtm.getValueAt(i,7));
                      weightAfterPolish=Double.valueOf(""+dtm.getValueAt(i,8));
                      rate=Double.valueOf(""+dtm.getValueAt(i,9));
                      rateUnit=(""+dtm.getValueAt(i,10));
                     
                      paymentApply=(""+dtm.getValueAt(i,1));
                      amount=Double.valueOf(""+dtm.getValueAt(i,11));

                      //Insert new record with update
                      qry="insert into polish_details values(#"+date+"#,"+purjaNumber+","+accountCode+",'"+itemName+"','"+polishType+"',"+quantity+",'"+quantityUnit+"',"+weight+",'"+weightUnit+"',"+weightAfterPolish+","+rate+",'"+rateUnit+"','"+paymentApply+"',"+amount+","+status+","+(Double.valueOf(jTextField5.getText()))+","+(Double.valueOf(jTextField6.getText()))+","+paidAtReceive+","+discountAtReceive+")";
                      bn=Utility.saveInformation(qry);
                      if(bn==false)
                      {
                          return false;
                      }
               }
                      //Delete old record and add new record with after weight
        return true;
 }
   public void rollBackPaidAmount()
   {          
               int purjaNumber=Integer.parseInt(""+(jLabel11.getText()));                   // for amount validation
               double paidAmount=0;
               int byAccountCode=0;
               String qry="select distinct ac_code from polish_details where purja_number="+purjaNumber+"";
               String data[][]=Utility.getInformationDD(qry,1);
               byAccountCode=Integer.parseInt(data[0][0]);

               qry="select voucher_amount from receive_voucher where purja_number="+purjaNumber+" and voucher_type='Receive'";
               String str=(Utility.getSingleValue(qry));
               if(str.isEmpty()|| str==null)
               {
                    paidAmount=0;
               }
                else
               {
                    paidAmount=Double.valueOf(str);
               }
               int toAccountCode=9;
                                  //to manage ac_smry table
                                            //update party a/c
                                            qry="select ac_cr from ac_smry where ac_code="+byAccountCode+"";
                                            double acCr=Double.valueOf(Utility.getSingleValue(qry));
                                            acCr=(acCr-paidAmount);
                                            qry="Update ac_smry set ac_cr="+acCr+" where ac_code="+byAccountCode+"";
                                            Utility.saveInformation(qry);

                                            //udate CASH a/c
                                            qry="select ac_Dr from ac_smry where ac_code="+toAccountCode+"";
                                            double acDr=Double.valueOf(Utility.getSingleValue(qry));
                                            acDr=(acDr-paidAmount);
                                            qry="Update ac_smry set ac_dr="+acDr+" where ac_code="+toAccountCode+"";
                                            Utility.saveInformation(qry);
                                  //End
                                            //setVoucherNumber();
              


    }
    public void rollBackDiscount()
    {
                            int acCode=8;//code of discount a/c
                            int purjaNumber=Integer.parseInt(jLabel11.getText());
                            String qry="select discount from polish_details where purja_number="+purjaNumber+"";
                            double oldDiscount=Double.valueOf(Utility.getSingleValue(qry));
                            qry="select ac_dr from ac_smry where ac_code="+acCode+"";
                            double acDr=Double.valueOf(Utility.getSingleValue(qry));
                            acDr=(acDr-oldDiscount);
                            qry="Update ac_smry set ac_dr="+acDr+" where ac_code="+acCode+"";
                            Utility.saveInformation(qry);
     }
    public void rollback()
    {
         rollBackPaidAmount();
         rollBackDiscount();
         //To manage balance of polish and usetaccount
                           int purjaNumber=Integer.parseInt(jLabel11.getText());
                            String qry="select ac_code from polish_details where purja_number="+purjaNumber+"";
                            int acCode=Integer.parseInt(Utility.getSingleValue(qry));

                            qry="select payable_amount from polish_details where purja_number="+purjaNumber+"";
                            double payableAmount=Double.valueOf(Utility.getSingleValue(qry));

                            qry="select discount from polish_details where purja_number="+purjaNumber+"";
                            double discount=Double.valueOf(Utility.getSingleValue(qry));

                            qry="select ac_dr from ac_smry where ac_code="+acCode+"";
                            double acDr=Double.valueOf(Utility.getSingleValue(qry));
                            acDr=(acDr-(payableAmount));
                            qry="Update ac_smry set ac_dr="+acDr+" where ac_code="+acCode+"";
                            Utility.saveInformation(qry);

                            qry="select ac_cr from ac_smry where ac_code="+10+"";
                            double acCr=Double.valueOf(Utility.getSingleValue(qry));
                            System.out.println("Helllooooooooooooooooo");
                            acCr=(acCr-(payableAmount+discount));
                            qry="Update ac_smry set ac_cr="+acCr+" where ac_code="+10+"";
                            Utility.saveInformation(qry);

                            // Delete record from polish details
                            /*qry="delete * from polish_details where purja_number="+purjaNumber+"";
                            Utility.saveInformation(qry);
                            qry="delete * from receive_voucher where purja_number="+purjaNumber+"";
                            boolean bn=Utility.saveInformation(qry);*/

                            //to make deliver data record as a receiving record
                            qry="select distinct discount_at_receive from polish_details where purja_number="+purjaNumber+"";
                            double discountAtReceive=Double.valueOf(Utility.getSingleValue(qry));
                            
                            qry="select amount,payment_apply from polish_details where purja_number="+purjaNumber+"";
                            String data[][]=Utility.getInformationDD(qry,2);

                            double totalAmount=0;
                            int amount=0;
                            
                            for(int i=0;i<data.length;i++)
                            {
                                if(data[i][1].equals("Before Polish"))
                                {
                                    totalAmount=totalAmount+(Double.valueOf(data[i][0]));
                                    //qry="Update polish_details set amount="+(Double.valueOf((data[i][1])))+" where purja_number="+gPurjaNumber+"";
                                }
                                else
                                {
                                     qry="Update polish_details set amount="+amount+" where purja_number="+gPurjaNumber+" and payment_apply='After Polish'";
                                     Utility.saveInformation(qry);
                                }
                            }
                            double payable=(totalAmount-discountAtReceive);
                            int status=1;
                            int weightAfterPolish=0;
                            qry="Update polish_details set weight_after_polish="+weightAfterPolish+",status="+status+",discount="+discountAtReceive+",payable_amount="+payable+" where purja_number="+gPurjaNumber+"";
                            Utility.saveInformation(qry);
                            
                            qry="select paid_at_receive from polish_details where purja_number="+gPurjaNumber+"";
                            String load[][]=Utility.getInformationDD(qry,1);
                            double paymentAtReceive=Double.valueOf(load[0][0]);

                            qry="Update receive_voucher set voucher_amount="+paymentAtReceive+" where purja_number="+gPurjaNumber+"";
                            Utility.saveInformation(qry);

                            String cancle="Yes";
                            qry="Update polish_details set cancle='"+cancle+"' where purja_number="+gPurjaNumber+"";
                            Utility.saveInformation(qry);
                           
     }
   public boolean weightAfterPolish()
    {
       int row=jTable1.getRowCount();
       double weight=0;
       String weight1="";
       for(int i=0;i<row;i++)
       {
           weight1=(""+jTable1.getValueAt(i,8));
           if(Utility.isDouble(weight1))
           {       weight=Double.valueOf(""+jTable1.getValueAt(i,8));
                    if(weight==0 || weight1.isEmpty()==true)
                   {
                       return false;
                   }
               return true;
           }
            else
           {
               return false;
            }
     

       }
       System.out.println("Row"+row);
       return true;
   }
   public void callReturnAmountPanel()
    {
                    /* jPanel1.setVisible(true);
                     jTextField1.requestFocus();
                     double payableAmount=Double.valueOf(jTextField7.getText());
                     java.math.BigDecimal bd=new java.math.BigDecimal(payableAmount);
                     jLabel19.setText(""+bd.setScale(2,5));
                     jButton5.setVisible(false);
                     jButton6.setVisible(false);*/
   }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
       // check();
        //calculateTotal();
        //edetingTotal();
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        System.out.println(evt.getKeyCode());
        //System.out.println("..............="+jTable1.getSelectedRow());
       if(evt.getKeyCode()==116)
        {callReturnAmountPanel();
            //jTable1.setRowSelectionInterval(jTable1.getSelectedRow()-1, jTable1.getSelectedRow()-1);
           //validation();
        }
        if(evt.getKeyCode()==27)
        {
           /* jPanel1.setVisible(false);
            jButton5.setVisible(true);
            jButton6.setVisible(true);*/
        }
     /* int keyCode=evt.getKeyCode();
        if(keyCode>=65 && keyCode<=90 || keyCode>=97 && keyCode<=122)
        {
            errorMsg();
        }*/
    }//GEN-LAST:event_jTable1KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            this.dispose();
        }
       //Coading to visible and hide jPanel1(calculate return amount)
       if(evt.getKeyCode()==116)
        {callReturnAmountPanel();
        }
        if(evt.getKeyCode()==27)
        {
           /* jPanel1.setVisible(false);
            jButton5.setVisible(true);
            jButton6.setVisible(true);*/
        }
       //End

    }//GEN-LAST:event_jButton6KeyPressed

    private void jLabel12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel12KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel12KeyPressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        calenderDate();
}//GEN-LAST:event_jLabel12MouseClicked

    private void jTextField6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField6MousePressed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
      
      
    }//GEN-LAST:event_jTable1KeyReleased

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseEntered

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_formKeyReleased

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       { int check=javax.swing.JOptionPane.showConfirmDialog(this,"Are you sure to cancle this deliver process ?." ,"Message Box",javax.swing.JOptionPane.YES_NO_OPTION);
         if(check==0)
         {   rollback();
             this.dispose();
       
         }

       }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            rollback();
        }
    }//GEN-LAST:event_jButton1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jTextField4;
    private javax.swing.JLabel jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel jTextField7;
    // End of variables declaration//GEN-END:variables

   
 boolean firsttime1=false;
    int purjano;
    class printchallan2
    {

                PrintPanel2 canvas;
	        java.awt.print.PageFormat pageFormat;

        	public printchallan2(String str)
        	{
                    purjano=Integer.parseInt(str);
                    System.out.println("print constructor");

                                canvas=new PrintPanel2();
                                java.awt.print.PrinterJob printJob=java.awt.print.PrinterJob.getPrinterJob();
                                double width=8.27 * 72;
                                double height=(11.69 * 72);

                                java.awt.print.Paper paper=new java.awt.print.Paper();

                                paper.setSize(width,height);

                                java.awt.print.PageFormat page=new java.awt.print.PageFormat();
                                page.setOrientation(java.awt.print.PageFormat.PORTRAIT);
                                paper.setImageableArea(5,10,paper.getWidth(),paper.getHeight());
                                page.setOrientation(java.awt.print.PageFormat.PORTRAIT);
                                page.setPaper(paper);
                                pageFormat=printJob.defaultPage(page);
                                pageFormat.setPaper(paper);
                                pageFormat.setOrientation(java.awt.print.PageFormat.PORTRAIT);
                                printJob.setPrintable(canvas,pageFormat);

                                try
                                {
					//no of pages
                                        printJob.print();
                                }
                                catch(Exception exception)
                                {
                                        javax.swing.JOptionPane.showMessageDialog(null,"error2="+exception);
                                }
                                //jButton5.setEnabled(true);
        		    }
	}//print class


    class PrintPanel2 extends javax.swing.JPanel implements java.awt.print.Printable
	{

        int page=100;
		java.awt.font.TextLayout layout;
		java.awt.Font f,f1,f2,f3,f4,f5,f6;
		java.awt.Graphics2D g2;
		int row=0;
		java.awt.font.FontRenderContext context;


        public PrintPanel2()
        {
                //ChallanNo=JOptionPane.showInputDialog(null,"Enter Challan Number:");
        }
        public void paintComponent(java.awt.Graphics g)
        {
                super.paintComponent(g);
                System.out.println("BPPRINT");
                java.awt.Graphics2D g2=(java.awt.Graphics2D)g;
                drawPage(g2);

        }

        public int print(java.awt.Graphics g,java.awt.print.PageFormat pf,int page) throws java.awt.print.PrinterException
        {
                if(page>=1)
                return java.awt.print.Printable.NO_SUCH_PAGE;
                java.awt.Graphics2D g2=(java.awt.Graphics2D)g;
                g2.setPaint(java.awt.Color.black);
                g2.translate(pf.getImageableX(),pf.getImageableY());

                System.out.println("W1="+pf.getImageableWidth()+"H1="+pf.getImageableHeight());

                //if(printflag==5)
                //{
                	drawPage(g2);
                //}

                return java.awt.print.Printable.PAGE_EXISTS;
        }
        public void drawPage(java.awt.Graphics2D g2)
        {
            this.g2=g2;
	    System.out.println("Hellospecial"+firsttime1);
            //System.out.println("inside draw page..."+totalamt);
            context=g2.getFontRenderContext();
            f1=new java.awt.Font("Times New Roman",java.awt.Font.BOLD,10);
            f2=new java.awt.Font("Arial",java.awt.Font.PLAIN,8);
            f3=new java.awt.Font("Arial",java.awt.Font.PLAIN,30);
            f4=new java.awt.Font("Arial",java.awt.Font.BOLD,10);
            f5=new java.awt.Font("Verdana",java.awt.Font.PLAIN,10);
            f6=new java.awt.Font("Verdana",java.awt.Font.BOLD,10);
            java.awt.Font f7=new java.awt.Font("Arial",java.awt.Font.BOLD,13);
            java.awt.Font f8=new java.awt.Font("Times New Roman",java.awt.Font.BOLD,25);
            java.awt.Font f9=new java.awt.Font("Arial narrow",java.awt.Font.PLAIN,2);
            java.awt.FontMetrics fm;
            java.awt.geom.GeneralPath clipShape=new java.awt.geom.GeneralPath();
            String str=" fdfg dfg dfg";
            String str1="d fgf dgdfg df";
            g2.setFont(f1);
            layout=new java.awt.font.TextLayout(str,f1,context);
            java.awt.geom.AffineTransform transform=java.awt.geom.AffineTransform.getTranslateInstance(10,20);

            g2.setFont(f2);
            fm=g2.getFontMetrics();

			if(firsttime1==false)
			{
				firsttime1=true;
            		}
                        else
                        {   firsttime1=false;
                            int top=20;
                            int i=0;
                            int j=0;
                            int z=0;
                            double receiveAmount=0;
                            double discount=0;
                            double payableAmount=0;
                            String date="";
                            int pur=purjano;
                            String qry="Select rec_date from polish_details where purja_number="+pur+"";
                            String dd=Utility.getSingleValue(qry);
                            String d[]=dd.split(" ");
                            String d1[]=d[0].split("-");
                            date=d1[2]+"-"+d1[1]+"-"+d1[0];
                            g2.setFont(f6);
                            fm=g2.getFontMetrics();
                            String temp="Date : "+date;
                            g2.drawString(temp,15,top+10);
                            qry="Select ac_code from polish_details where purja_number="+pur+"";
                            int cid=Integer.parseInt(Utility.getSingleValue(qry));
                            qry="Select ac_name from ac_master where ac_code="+cid+"";
                            String accountName=""+(Utility.getSingleValue(qry));
                            temp="Customer Name : "+accountName;
                            g2.drawString(temp,200,top+10);
                            temp="Purja Number :"+purjano;
                            g2.drawString(temp,465,top+10);
                            top=top+25;
                            g2.drawLine(15, top, 575, top);
                            //for heading
                            top=top+15;
                            temp="S.No    Weight(B)   Item Name         Polish Type   Quantity   Weight(A)        Rate                  Amount";
                            g2.drawString(temp,15,top);
                            top=top+10;
                            g2.drawLine(15, top, 575, top);
                            //End
                            //for data printing
                            g2.setFont(f5);
                            fm=g2.getFontMetrics();
                            qry="Select * from polish_details where purja_number="+pur+"";
                            String load[][]=Utility.getInformationDD(qry,17);
                            double total=0;
                            double totamt=0;
                            String weight="";
                            String weightAP="";
                            String itemName="";
                            String polishType="";
                            String quantity="";
                            String unit="";
                            String rate="";
                            String rateUnit="";
                            String amount="";
                            String temp1="";
                            String temp2="";
                            String temp3="";
                            String temp4="";
                            String temp5="";
                            String temp6="";
                            String temp7="";
                            String temp8="";
                            String temp9="";
                            String temp10="";
                            String temp11="";
                            String temp12="";
                            String temp13="";
                            top=top+25;
                            if(load.length>0)
                            {
                                    for(i=0,j=(-10);i<load.length;i++,j=j+15)
                                    {
                                        weight=load[i][7];
                                        weightAP=load[i][9];
                                        itemName=load[i][3];
                                        polishType=load[i][4];
                                        quantity=load[i][5];
                                        unit=load[i][6];
                                        rate=load[i][10];
                                        rateUnit=load[i][11];
                                        amount=load[i][13];
                                        total=total+Double.valueOf(amount);
                                        temp4=(i+1)+".";
                                        //z=fm.stringWidth(temp4);
                                        java.math.BigDecimal bd=new java.math.BigDecimal(weight);
                                        temp5=""+bd.setScale(3,5);
                                        //weight after polish
                                        z=fm.stringWidth(temp13);
                                        bd=new java.math.BigDecimal(weightAP);
                                        temp13=""+bd.setScale(3,5);

                                        //End
                                        temp6=itemName;
                                        temp7=polishType;
                                        temp8=quantity;
                                        temp9=unit;
                                        bd=new java.math.BigDecimal(rate);
                                        temp10=""+bd.setScale(2,5);
                                        temp11=rateUnit;
                                        bd=new java.math.BigDecimal(amount);
                                        temp12=""+bd.setScale(2,5);
                                        z=fm.stringWidth(temp4);
                                        g2.drawString(temp4,35-z,top+j);
                                        //to display weight in bold if rate*weight
                                        if(rateUnit.equals("Kg"))
                                        {           g2.setFont(f6);
                                                    z=fm.stringWidth(temp5);
                                                    g2.drawString(temp5,100-z,top+j);
                                                    g2.setFont(f5);
                                        }
                                        else
                                        {
                                                    z=fm.stringWidth(temp5);
                                                    g2.drawString(temp5,100-z,top+j);
                                        }
                                        g2.drawString(temp6,120,top+j);
                                        g2.drawString(temp7,220,top+j);
                                        if(rateUnit.equals("Kg")==false)
                                        {
                                                    g2.setFont(f6);
                                                    z=fm.stringWidth(temp8);
                                                    g2.drawString((temp8+" "),300-z,top+j);
                                                    g2.setFont(f5);
                                        }
                                        else
                                        {
                                                    z=fm.stringWidth(temp8);
                                                    g2.drawString((temp8+" "),300-z,top+j);
                                        }
                                        //b=fm.stringWidth(temp9);
                                        g2.drawString(temp9,306,top+j);
                                        z=fm.stringWidth(temp13);
                                        g2.drawString(temp13,370,top+j);

                                        z=fm.stringWidth(temp10);
                                        g2.drawString(temp10+" / ",450-z,top+j);
                                        //b=fm.stringWidth(temp11);
                                        g2.drawString(temp11,460,top+j);
                                        int a=fm.stringWidth(temp12);
                                        g2.drawString(temp12,570-a,top+j);
                                        //Start Coading for total balance(Down ward)

                                        //g2.drawString("Hiii",100,840);

                                }
                            }
                            int down=312;
                            str="select discount from polish_details where purja_number="+purjano+"";
                            discount=Double.valueOf(Utility.getSingleValue(str));
                            str="select payable_amount from polish_details where purja_number="+purjano+"";
                            payableAmount=(Double.valueOf(Utility.getSingleValue(str))+discount);
                            //To find roundingvalue
                            java.math.BigDecimal bd4=new java.math.BigDecimal(total);
                            double aa=Double.valueOf(""+bd4.setScale(0,java.math.BigDecimal.ROUND_HALF_UP));
                            Double rounding=(aa-total);

                                if(total>0)
                                {
                                                if(discount==0 && rounding==0)
                                                {

                                                }
                                                else if(rounding==0)
                                                {
                                                                     //for discount
                                                                    temp="Discount :";
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,(497-z),down-20 );
                                                                    java.math.BigDecimal bd=new java.math.BigDecimal(discount);
                                                                    temp=""+bd.setScale(2,5);
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,570-z,down-20 );

                                                                    //for total
                                                                    temp="Total Amount : ";
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,(500-z),(down-35) );
                                                                    bd=new java.math.BigDecimal(total);
                                                                    temp=""+bd.setScale(2,5);
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,570-z,(down-35));


                                                }
                                                else if(discount==0)
                                                {
                                                                    temp="Rounding : ";
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,(500-z),down-20);
                                                                    java.math.BigDecimal bd=new java.math.BigDecimal(rounding);
                                                                    temp=""+bd.setScale(2,5);
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,570-z,down-20 );

                                                                    //for total
                                                                    temp="Total Amount : ";
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,(500-z),(down-35) );
                                                                    bd=new java.math.BigDecimal(total);
                                                                    temp=""+bd.setScale(2,5);
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,570-z,(down-35));
                                                                    //for Rounding
                                                 }
                                                 else
                                                {
                                                                    //for discount
                                                                    temp="Discount :";
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,(497-z),down-20 );
                                                                    java.math.BigDecimal bd=new java.math.BigDecimal(discount);
                                                                    temp=""+bd.setScale(2,5);
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,570-z,down-20 );
                                                                    //rounding
                                                                    temp="Rounding : ";
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,(500-z),(down-35) );
                                                                    bd=new java.math.BigDecimal(rounding);
                                                                    temp=""+bd.setScale(2,5);
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,570-z,(down-35) );

                                                                    //for total
                                                                    temp="Total Amount : ";
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,(500-z),(down-50) );
                                                                    bd=new java.math.BigDecimal(total);
                                                                    temp=""+bd.setScale(2,5);
                                                                    z=fm.stringWidth(temp);
                                                                    g2.drawString(temp,570-z,(down-50));

                                                 }
                                  }
                            g2.drawLine(400, 300, 575,300);

                            //for net amount
                            if(discount==0 && rounding==0)
                            {
                                    temp="Total Amount : ";
                                     z=fm.stringWidth(temp);
                                    g2.drawString(temp,(500-z),315 );

                            }
                            else
                            {
                                    temp="Net Amount : ";
                                    z=fm.stringWidth(temp);
                                    g2.drawString(temp,(500-z),315 );
                            }

                            //str="select payable_amount from polish_details where purja_number="+purjano+"";
                            //payableAmount=Double.valueOf(Utility.getSingleValue(str));
                                    g2.setFont(f6);
                                    java.math.BigDecimal bd=new java.math.BigDecimal(payableAmount-discount);
                                    temp=""+bd.setScale(2,5);
                                    z=fm.stringWidth(temp);
                                    g2.drawString(temp,565-z,315 );
                                    g2.setFont(f5);
                            //g2.drawLine(400, 320, 575,320);

                            //for received amount
                            temp="Received Amount : ";
                            z=fm.stringWidth(temp);
                            g2.drawString(temp,(500-z),335);

                            str="select voucher_amount from receive_voucher where purja_number="+purjano+" and voucher_type='Receive'";
                            String paidAmount=""+Utility.getSingleValue(str);
                            System.out.println("Helloooo");
                            if(paidAmount==null || paidAmount.isEmpty())
                            {       paidAmount="0";
                                    receiveAmount=0;
                                    bd=new java.math.BigDecimal(receiveAmount);
                                    temp=""+bd.setScale(2,5);
                                    z=fm.stringWidth(temp);
                                    g2.drawString(temp,570-z,335 );
                            }
                            else
                            {
                                    receiveAmount=Double.valueOf(paidAmount);
                                    bd=new java.math.BigDecimal(receiveAmount);
                                    temp=""+bd.setScale(2,5);
                                    z=fm.stringWidth(temp);
                                     g2.drawString(temp,570-z,335 );
                            }
                            //End
                            //Due Amount
                            temp="Due Amount : ";
                            z=fm.stringWidth(temp);
                            g2.drawString(temp,(500-z),355);

                            double dueAmount=Double.valueOf((payableAmount-discount)-(receiveAmount));
                                    bd=new java.math.BigDecimal(dueAmount);
                                    temp=""+bd.setScale(2,5);
                                    z=fm.stringWidth(temp);
                                    g2.setFont(f6);
                                    g2.drawString(temp,565-z,355 );
                                    g2.setFont(f5);

                            //End

                            //for old Amount
                            qry="select ac_cr,ac_dr from ac_smry where ac_code="+cid+"";
                            String data1[][]=Utility.getInformationDD(qry,2);
                            double cr=Double.valueOf(data1[0][0]);
                            double dr=Double.valueOf(data1[0][1]);
                            double netAmount=(payableAmount-discount);
                            //for paid amount
                            str="select voucher_amount from receive_voucher where purja_number="+purjano+" and voucher_type='Receive'";
                            System.out.println("Voucher Amount==");
                            String paidAmount1=""+Utility.getSingleValue(str);

                            double receive=0;
                            if(paidAmount1==null || paidAmount1.isEmpty())
                            {
                                    receive=0;
                            }
                            else
                            {
                                 receive=Double.valueOf(paidAmount1);
                            }
                            //End
                            double oldBalance=(dr-cr-netAmount+receive);

                                    bd=new java.math.BigDecimal(oldBalance);
                                    temp=""+bd.setScale(2,5);
                                    z=fm.stringWidth(temp);
                                    g2.drawString(temp,400-z,380 );
                           
                            //for Balance Account
                            netAmount=(aa-discount);
                            temp="Final Due Amt : ";
                            double receaveAmount=Double.valueOf(paidAmount);
                            z=fm.stringWidth(temp);
                            g2.drawString(temp,(500-z),380 );
                            System.out.println("Net Amount"+netAmount);
                            System.out.println("Receive Amount"+receiveAmount);
                            System.out.println("old Balance"+oldBalance);
                            //double balanceAmount=((netAmount-receiveAmount)+(oldBalance));
                            double balanceAmount=((oldBalance+netAmount)-receive);
                            bd=new java.math.BigDecimal(balanceAmount);
                            temp=""+bd.setScale(2,5);
                            z=fm.stringWidth(temp);
                            g2.setFont(f6);
                            g2.drawString(temp,565-z,380 );
                            g2.setFont(f5);
                            g2.drawLine(15, (385), 575, (385));

                           //ENd

                            
                            g2.drawLine(15, 365, 575,365);
                            //for total items
                            fm=g2.getFontMetrics();
                            temp="Total Items : "+(i);
                            g2.drawString(temp,20,380);
                            //Set Date
                            java.util.Date dt=new java.util.Date();
                            int date1=dt.getDate();
                            int month=dt.getMonth()+1;
                            int yr=dt.getYear()+1900;
                            String setDate=date1+"-"+month+"-"+yr;
                            //set Time
                            String amPm="A.M";
                            int hour=dt.getHours();
                            int min=dt.getMinutes();
                            if(hour>12)
                            {
                                amPm="P.M";
                                hour=hour-12;
                            }
                               String time="Till -  "+setDate+"  "+hour+":"+min+" "+amPm+"      Old Due Amt=";
                               System.out.println("Date="+setDate) ;
                               System.out.println("hour="+hour) ;
                               System.out.println("min="+min) ;
                               g2.drawString(time,125,380);

                      
System.out.println("Net Amount"+aa);

                        }
        }
    }
}
