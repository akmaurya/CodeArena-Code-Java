/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DaywiseReport.java
 *
 * Created on Mar 21, 2013, 12:45:06 PM
 */

package virtualcheckmanagementsystem;
import java.math.BigInteger;
import java.util.Map;
import java.util.Calendar;
/**
 *
 * @author user2
 */
public class DaywiseReport extends javax.swing.JInternalFrame {
String set;
String setDate;
String time;
    /** Creates new form DaywiseReport */
    public DaywiseReport() {
        initComponents();
        jComboBox1.requestFocus();
        java.util.Date dt=new java.util.Date();
        int date=dt.getDate();
        int month=dt.getMonth()+1;
        int year=dt.getYear()+1900;
        setDate=date+"-"+month+"-"+year;
        jLabel4.setText(setDate);
        System.out.println("jLabel4= "+setDate);
        jLabel6.setText(setDate);
        int hour=dt.getHours();
        int min=dt.getMinutes();
        int sec=dt.getSeconds();
        String tfor="AM";
        if(hour>12)
        {
            hour=hour-12;
            tfor="PM";
        }
        time=hour+":"+min+" "+tfor;

          jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
dtm=new javax.swing.table.DefaultTableModel();
        javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
        javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
        CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
        CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        javax.swing.table.TableColumn column;
        String heading1[]={"Sr.No","Date","Account Name","Amount","Bank Name","Cheque No"};
        dtm=new javax.swing.table.DefaultTableModel(heading1,0);
        jTable1.setModel(dtm);
            column=jTable1.getColumn("Sr.No");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(50);
            column=jTable1.getColumn("Date");
            column.setCellRenderer(CRCenter);
            column.setPreferredWidth(80);
            column=jTable1.getColumn("Account Name");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(220);
            column=jTable1.getColumn("Amount");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(100);
            column=jTable1.getColumn("Bank Name");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(190);
            column=jTable1.getColumn("Cheque No");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(78);
            loadInitialInfo();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Day wise Cheque Detail Window");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Verdana 11", 1, 12));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("From");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 8, 40, 20);

        jLabel4.setBackground(new java.awt.Color(227, 194, 186));
        jLabel4.setFont(new java.awt.Font("Verdana 11", 1, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel4");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 10, 160, 20);

        jButton3.setIcon(new javax.swing.ImageIcon("E:\\Mohitkumar\\VirtualCheckManagementSystem\\src\\images\\icons\\calendar.png")); // NOI18N
        jButton3.setFocusable(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(230, 10, 30, 23);

        jLabel5.setFont(new java.awt.Font("Verdana 11", 1, 12));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("To");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(280, 8, 40, 20);

        jLabel6.setBackground(new java.awt.Color(227, 194, 186));
        jLabel6.setFont(new java.awt.Font("Verdana 11", 1, 12));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("jLabel6");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(340, 10, 140, 20);

        jButton4.setIcon(new javax.swing.ImageIcon("E:\\Mohitkumar\\VirtualCheckManagementSystem\\src\\images\\icons\\calendar.png")); // NOI18N
        jButton4.setFocusable(false);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(480, 10, 30, 23);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel7.setText("Select Bank Name");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 40, 120, 25);

        jComboBox1.setFont(new java.awt.Font("Verdana 11", 1, 12));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(180, 40, 360, 25);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12));
        jLabel8.setText("Select Account Name");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 75, 150, 25);

        jComboBox2.setFont(new java.awt.Font("Verdana", 1, 12));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(180, 75, 360, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 720, 110);

        jButton1.setFont(new java.awt.Font("Verdana 11", 1, 12));
        jButton1.setMnemonic('S');
        jButton1.setText("Show");
        jButton1.setToolTipText("Show Information");
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
        jButton1.setBounds(10, 130, 340, 30);

        jButton2.setFont(new java.awt.Font("Verdana 11", 1, 12));
        jButton2.setMnemonic('C');
        jButton2.setText("Close");
        jButton2.setToolTipText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(390, 130, 330, 30);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(null);

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
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 720, 430);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 160, 750, 450);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("0.00");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(480, 610, 140, 30);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14));
        jLabel2.setText("Final Ballence");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 610, 110, 30);

        jButton5.setFont(new java.awt.Font("Verdana", 1, 14));
        jButton5.setText("Print");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(10, 615, 300, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
        Cal cl=new Cal();
        jLabel4.setText(cl.getdate());
        String dt[]=cl.getdate().split("-");
        System.out.println("date...............="+dt[0]+dt[1]+dt[2]);
        set=dt[1]+"/"+dt[0]+"/"+dt[2];
        System.out.println(set);
        System.out.println(setDate);
}//GEN-LAST:event_jButton3MousePressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
        Cal cl=new Cal();

        jLabel6.setText(cl.getdate());
}//GEN-LAST:event_jButton4MousePressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            jButton1.requestFocus();
        }
}//GEN-LAST:event_jComboBox1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        class task1 extends Thread {
            public void run() {

                try {
                    uploadDetail();
                    Thread.sleep(100);
                } catch(InterruptedException ex) {
                    System.out.println("error..."+ex);
                }

            }

        }


        task1 t1=new task1();
        t1.start();



    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==10) {
            class task1 extends Thread {
                public void run() {

                    try {
                        uploadDetail();
                        Thread.sleep(100);
                    } catch(InterruptedException ex) {
                        System.out.println("error..."+ex);
                    }

                }

            }


            task1 t1=new task1();
            t1.start();




        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        printchallan2 print=new printchallan2();
}//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
javax.swing.table.DefaultTableModel dtm;
boolean t;
private void loadInitialInfo()
{
    String qry="";
    try
    {
        qry="Select distinct(Bank_name) From cheque_detail ";
        String load[][]=Utility.getInformationDD(qry,1);
        System.out.println(load.length);
        if(load.length>0)
        {
           jComboBox1.removeAllItems();
           jComboBox1.addItem("All");
           for(int i=0;i<load.length;i++)
            {
                jComboBox1.addItem(load[i][0]);
            }
        }
        qry="Select distinct(Acount_name) From cheque_detail ";
        String load1[][]=Utility.getInformationDD(qry,1);
        System.out.println(load1.length);
        if(load1.length>0)
        {
           jComboBox2.removeAllItems();
           jComboBox2.addItem("All");
           for(int i=0;i<load1.length;i++)
            {
                jComboBox2.addItem(load1[i][0]);
            }
        }

    }
    catch(Exception e)
    {
        System.out.println("Error ! In loadInitialInfo Method."+e);
    }
}
private void uploadDetail()
{
    String qry="";
    dtm.setRowCount(0);
    String arr[]=null;
    java.math.BigDecimal bd=null;
    //String arr1[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    try
    {
        double bal=0;
        String D[]=jLabel4.getText().split("-");
        //String setDat=D[0]+"-"+D[1]+"-"+D[2];
       // String dt[]=c.getdate().split("-");
        //set=D[1]+"/"+D[0]+"/"+D[2];

        String D1[]=jLabel6.getText().split("-");
        String setD1=D1[2]+"-"+D1[1]+"-"+D1[0];
        System.out.println("setD1 = "+setD1);
        String setD=D[2]+"-"+D[1]+"-"+D[0];
        System.out.println("setD= "+setD);

        java.util.Date dt1=new java.util.Date();
        int date=Integer.parseInt(D[0]);
        int month=Integer.parseInt(D[1]);
        int year=Integer.parseInt(D[2]);
        String getDtt=month+"/"+date+"/"+year;
        int date1=Integer.parseInt(D1[0]);
        int month1=Integer.parseInt(D1[1]);
        int year1=Integer.parseInt(D1[2]);
        String getDtt1=month1+"/"+date1+"/"+year1;
        long getParse=dt1.parse(getDtt)-86400000;
        java.util.Date dt2=new java.util.Date();
        long getParse1=dt2.parse(getDtt1);
        long diff=getParse1-getParse;
        int days=(int)(diff/86400000);
        arr=new String[5];





        //arr[0]=""+(dtm.getRowCount()+1);
        //arr[1]=set;
        if(jComboBox2.getSelectedItem().toString().equals("All")&&(!jComboBox1.getSelectedItem().toString().equals("All")))
         qry="Select * from cheque_detail where Bank_name='"+jComboBox1.getSelectedItem().toString()+"' and Cheque_date>=#"+setD+"# and Cheque_date<=#"+setD1+"#";
        else if((!jComboBox2.getSelectedItem().toString().equals("All"))&&(!jComboBox1.getSelectedItem().toString().equals("All")))
            qry="Select * from cheque_detail where Bank_name='"+jComboBox1.getSelectedItem().toString()+"'and Acount_name='"+jComboBox2.getSelectedItem().toString()+"' and Cheque_date>=#"+setD+"# and Cheque_date<=#"+setD1+"#";
        else if((jComboBox2.getSelectedItem().toString().equals("All"))&&(jComboBox1.getSelectedItem().toString().equals("All")))
            qry="Select * from cheque_detail where Cheque_date>=#"+setD+"# and Cheque_date<=#"+setD1+"#";
        else if((!jComboBox2.getSelectedItem().toString().equals("All"))&&(jComboBox1.getSelectedItem().toString().equals("All")))
            qry="Select * from cheque_detail where Acount_name='"+jComboBox2.getSelectedItem().toString()+"' and Cheque_date>=#"+setD+"# and Cheque_date<=#"+setD1+"#";

        System.out.println(qry);
         String load[][]=Utility.getInformationDD(qry,5);
         System.out.println("load.length= "+load.length);
         double total=0;
         if(load.length>0)
         {
            arr=new String[6];
            for(int i=0;i<load.length;i++)
            {
                arr[0]=""+(dtm.getRowCount()+1);
                String d[]=load[i][1].split("-");
                
                arr[1]=d[2].substring(0, 2)+"-"+d[1]+"-"+d[0];
                System.out.println(load[i][1]+"printing date on table= "+arr[1]);
                arr[2]=load[i][2];
                bd=new java.math.BigDecimal(load[i][3]);
                total=total+Double.valueOf(load[i][3]);
                arr[3]=(""+bd.setScale(2,5));
                arr[4]=load[i][0];
                arr[5]=load[i][4];
                dtm.addRow(arr);
            }
        }
         bd=new java.math.BigDecimal(total);
        jLabel1.setText(""+bd.setScale(2,5));
         

    }
    catch(Exception e)
    {
        System.out.println("Error ! In uploadDetail Method."+e);
    }

}
   private int getMonth(String getM)
  {
      int month=0;
        if(getM.equals("Jan"))
            month=Calendar.JANUARY;
        if(getM.equals("Feb"))
            month=Calendar.FEBRUARY;
        if(getM.equals("Mar"))
            month=Calendar.MARCH;
        if(getM.equals("Apr"))
            month=Calendar.APRIL;
        if(getM.equals("May"))
            month=Calendar.MAY;
        if(getM.equals("Jun"))
            month=Calendar.JUNE;
        if(getM.equals("Jul"))
            month=Calendar.JULY;
        if(getM.equals("Aug"))
            month=Calendar.AUGUST;
        if(getM.equals("Sep"))
            month=Calendar.SEPTEMBER;
        if(getM.equals("Oct"))
            month=Calendar.OCTOBER;
        if(getM.equals("Nov"))
            month=Calendar.NOVEMBER;
        if(getM.equals("Dec"))
            month=Calendar.DECEMBER;

        System.out.println("month......"+month);
        return month;
  }
boolean firsttime1=false;
    class printchallan2
    {

                PrintPanel2 canvas;
	        java.awt.print.PageFormat pageFormat;

        	public printchallan2()
        	{
                    sr=0;
                    count=0;

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
                                    for(int r=0;r<=count;r++)
                                    {
                                        printJob.print();
                                    }

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
            //sr=0;

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

            g2.setFont(f3);
            fm=g2.getFontMetrics();

			if(firsttime1==false)
			{
				firsttime1=true;
            		}
            else
{

                            int row=10;
                            firsttime1=false;

                            int top=20;
                            String temp="";
                            String temp1="";
                            String temp2="";
                            String temp3="";
                            String temp4="";
                            String temp5="";
                            String temp6="";
                            String temp7="";
                            String temp8="";

                            g2.setFont(f6);
                            fm=g2.getFontMetrics();
                            temp="Running Date / Time : "+set+" "+time;
                            temp1="Bank Name  : "+jComboBox1.getSelectedItem();
                            //temp2=jLabel6.getText()+"                               "+jComboBox2.getSelectedItem();
                            //temp3=jLabel1.getText()+"                          "+jTextField1.getText()+"       "+jLabel2.getText()+"    "+jTextField2.getText();
                            //temp4=jLabel8.getText()+"                       "+jComboBox3.getSelectedItem();
                            //temp5=jLabel7.getText()+"                   "+jLabel9.getText()+"    "+jLabel10.getText()+"    "+jTextField3.getText();
                            temp2="S.No        Date           Account Name                                                                                       Amount   " ;
                            g2.drawString(temp,20,top+10);
                            g2.drawLine(15, top+55, 585, top+55);
                            g2.drawLine(15, top+57, 585, top+57);
                            int y=fm.stringWidth(temp1);
                            g2.drawString(temp1,580-y,top+10);
                            g2.drawString(temp2,19,top+50);
                            int j=1,i;
                            System.out.println("hello ther is error");


                       for(i=sr;i<jTable1.getRowCount();i++,j=j+15)
                       {

                                    temp3=jTable1.getValueAt(i, 0).toString();
                                    temp4=jTable1.getValueAt(i, 1).toString();
                                    temp5=jTable1.getValueAt(i, 2).toString();
                                    temp6=jTable1.getValueAt(i, 3).toString();
                                g2.setFont(f5);
                                fm=g2.getFontMetrics();
                                int w=fm.stringWidth(temp8);
                                int a=fm.stringWidth(temp6);
                                int b=fm.stringWidth(temp5);
                                //System.out.println(b+"  hello.............."+a);
                                int z=fm.stringWidth(temp3);
                            g2.drawString(temp3,40-z,top+70+j);
                            g2.drawString(temp4,50,top+70+j);
                            if(temp5.length()>24)
                            {
                                   temp5=temp5.substring(0, 23)+"-";
                            }
                            g2.drawString(temp5,130,top+70+j);
                            g2.drawString(temp6,510,top+70+j);
                            
                            if(i==jTable1.getRowCount()-14)
                            {
                                //i++;
                                break;
                            }

                          }
                            sr=sr+46;
                            count=jTable1.getRowCount()/46;
                            temp5="page-"+count+"/"+(count+1);
                            g2.drawString(temp5,270,800);
                            System.out.println("count==================="+count);
                            g2.drawLine(47, top+40, 47, top+70+j);

            }
        }
    }

int sr=0;
//int i=0;
int count=0;
}

