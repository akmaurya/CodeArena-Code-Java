/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * View_Polish_Transaction.java
 *
 * Created on Dec 31, 2013, 2:36:13 PM
 */

package golden_shoap;
import java.awt.Color;
import javax.swing.*;


/**
 *
 * @author user1
 */
public class Demo extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm;
    /** Creates new form View_Polish_Transaction */
    public Demo() {
        initComponents();
            java.util.Date dt=new java.util.Date();
            int date=dt.getDate();
            int month=dt.getMonth()+1;
            int yr=dt.getYear()+1900;
            String setDate=date+"-"+month+"-"+yr;
            jLabel3.setText(setDate);
            jLabel5.setText(setDate);
            
            dtm=new javax.swing.table.DefaultTableModel();
            javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
            CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
            CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
            CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
            javax.swing.table.TableColumn column;
            String heading1[]={"S.No","Date","Account Name","Against","In Cash","Out Cash","Check Box"};
            dtm=new javax.swing.table.DefaultTableModel(heading1,0);
            jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
            jTable1.setModel(dtm);
            column=jTable1.getColumn("S.No");
            column.setCellRenderer(CRCenter);
            column.setPreferredWidth(70);

            column=jTable1.getColumn("Date");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(122);

            column=jTable1.getColumn("Account Name");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(260);

            column=jTable1.getColumn("Against");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(100);

            column=jTable1.getColumn("In Cash");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(148);

            column=jTable1.getColumn("Out Cash");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(148);
            column=jTable1.getColumn("Check Box");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(148);
           //to add combo Box
            /*String list[]=getCategoryName();
            setComboBoxInCell(jTable1,3,list);
            JCheckBox checkBox = new javax.swing.JCheckBox();
            jTable1.getColumn(6).setCellEditor(new DefaultCellEditor(checkBox));
            */
           // jTable1.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());

           setCheckBoxInCell(jTable1,0);


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        //javax.swing.JCheckBox ch1=new javax.swing.JCheckBox();
        JCheckBox checkBox = new javax.swing.JCheckBox();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Polish Transaction Report");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(204, 0, 204));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(235, 217, 254));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 15, 120, 25);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel2.setText("Date ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 15, 40, 25);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/golden_shoap/cal.png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(180, 15, 30, 25);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("To");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(230, 15, 20, 25);

        jLabel5.setBackground(new java.awt.Color(235, 217, 254));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 12));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(270, 15, 120, 25);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/golden_shoap/cal.png"))); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(390, 15, 30, 25);

        jButton3.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.gif"))); // NOI18N
        jButton3.setMnemonic('d');
        jButton3.setText("Done");
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
        jButton3.setBounds(450, 15, 360, 30);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(15, 10, 820, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 0, 850, 100);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumn("State").setCellEditor(new DefaultCellEditor(checkBox));

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 850, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        Calender c=new Calender();
        jLabel3.setText(c.getdate());
}//GEN-LAST:event_jButton1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
        Calender c=new Calender();
        jLabel5.setText(c.getdate());
}//GEN-LAST:event_jButton2MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        boolean b=getData();
        if(b==false)
        {
           javax.swing.JOptionPane.showMessageDialog(this,"Sory!!!!!!!!!!!! No any record found");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            getData();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
      /*  int row=jTable1.getSelectedRow();
        String str=""+jTable1.getValueAt(row,1);
        if(Utility.isInteger(str)==true)
        {
                        int purjaNumber=Integer.parseInt(str);
                        System.out.println(" purjaNumber============="+ purjaNumber);

        //To call purja Details window
                        Purja_Detail ob=new  Purja_Detail(purjaNumber);
                        ob.setBounds(5,100,1020, 523);
                        Master_Screen.jDesktopPane1.add(ob);
                        ob.setVisible(true);
        }*/
}//GEN-LAST:event_jTable1MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

 public boolean getData()
    {   dtm.setRowCount(0);
        int a=0;
        int toAccount=9;
        String qry=null;
        String date1=null,date2=null;
        String d[]=jLabel3.getText().split("-");
        date1=d[1]+"/"+d[0]+"/"+d[2];
        d=jLabel5.getText().split("-");
        date2=d[1]+"/"+d[0]+"/"+d[2];
        qry="Select * from receive_voucher where voucher_date>=#"+date1+"# and voucher_date<=#"+date2+"# and (voucher_type='Payment' or voucher_type='Receive') order by voucher_date desc";
        System.out.println(qry);
        String load[][]=Utility.getInformationDD(qry,8);
        double paymentTotal=0;
        double receiveTotal=0;
        String arr[];
        if(load.length>0)
        {
            arr=new String[6];
            for(int i=0;i<load.length;i++)
            {   
                arr[0]=""+(i+1);

                String da[]=load[i][2].split(" ");
                String da1[]=da[0].split("-");
                arr[1]=da1[2]+"-"+da1[1]+"-"+da1[0];

                int acc=Integer.parseInt(load[i][3]);
                String q="select ac_name from ac_master where ac_code="+acc+"";
                arr[2]=Utility.getSingleValue(q);

                if(load[i][0].equals("Payment"))
                {
                    //to manage payment related transaction
                    if((Integer.parseInt(load[i][7]))>0)
                    {
                        arr[3]="S.No - "+load[i][7];

                    }
                    else
                    {
                       arr[3]="P/V -"+load[i][1];
                    }
                    //to manage (out payment)
                    java.math.BigDecimal bd=new java.math.BigDecimal(load[i][5]);
                    arr[5]=(""+bd.setScale(2,5));
                    arr[4]="";
                    paymentTotal=paymentTotal+(Double.valueOf(arr[5]));

                }

                if(load[i][0].equals("Receive"))
                {
                    if((Integer.parseInt(load[i][7]))>0)
                    {
                        arr[3]="P.No - "+load[i][7];
                    }
                    else
                    {
                        arr[3]="R/V -"+load[i][1];
                    }
                    //to manage (in payment)
                    java.math.BigDecimal bd=new java.math.BigDecimal(load[i][5]);
                    arr[4]=(""+bd.setScale(2,5));
                    arr[5]="";
                    receiveTotal=receiveTotal+(Double.valueOf(arr[4]));


                }
                  dtm.addRow(arr);
            
            }
            java.math.BigDecimal bd=new java.math.BigDecimal(receiveTotal);
           
          
         }
     return true;
    }
 /*javax.swing.jTable1.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer()
 {
  // the method gives the component  like whome the cell must be rendered
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean isFocused, int row, int col)
                    {
                                boolean marked = (Boolean) value;
                                JCheckBox rendererComponent = new JCheckBox();
                                if (marked)
                                {
                                    rendererComponent.setSelected(true);
                                }
                                return rendererComponent;
                    }
            }
    );*/
 private void setCheckBoxInCell(JTable table,int columnNo)
    {
            javax.swing.table.TableColumnModel cm1 = table.getColumnModel();
            cm1.getColumn(columnNo).setCellEditor(new DefaultCellEditor(new JCheckBox()));
            //if()
    }
 /*private void setComboBoxInCell(JTable table,int columnNo,String list[])
	{//Combo Box
		javax.swing.table.TableColumnModel cm = table.getColumnModel();
		cm.getColumn(columnNo).setCellEditor(new DefaultCellEditor(new JComboBox(new DefaultComboBoxModel(list))));
    }
*/
        //CheckBox


/*jTable1.getColumnModel().getColumn(0).setCellRenderer(new TableCellRenderer()
{
  // the method gives the component  like whome the cell must be rendered
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean isFocused, int row, int col) {
      boolean marked = (Boolean) value;
      JCheckBox rendererComponent = new JCheckBox();
      if (marked) {
         rendererComponent.setSelected(true);
      }
      return rendererComponent;
   }
});*/
  /*
		TableColumnModel cm = grid.getColumnModel();
		cm.getColumn(0).setCellEditor(new DefaultCellEditor(
    new JComboBox(new DefaultComboBoxModel(new String[] {
      "Yes",
      "No",
      "Maybe"
    }))));
		cm.getColumn(1).setCellEditor(new DefaultCellEditor(
    new JComboBox(new DefaultComboBoxModel(new String[] {
      "Yes",
      "No",
      "Maybe"
    }))));
    	//String blankrow[]=new String[12];
		dtm.addRow(blankrow);
		*/
	
 /*	private String[] getCategoryName()
	{
			
        		 String arraylist[]={"A","B","C"};

                      
			return arraylist;

	}*/

/*class ImageRenderer extends javax.swing.table.DefaultTableCellRenderer
{

    @Override
    public java.awt.Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected,boolean hasFocus, int row, int column)
    {
        System.out.println("Value="+value);
       // boolean marked = (Boolean)value;
      JCheckBox rendererComponent = new JCheckBox();
      if (value.equals(true)) {
         rendererComponent.setSelected(true);
      }
      else
      {
          rendererComponent.setSelected(false);
      }
      
     return rendererComponent;
   }*/




}
