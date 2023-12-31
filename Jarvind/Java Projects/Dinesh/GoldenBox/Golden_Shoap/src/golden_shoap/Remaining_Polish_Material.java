/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Remaining_Polish_Material.java
 *
 * Created on Jan 13, 2014, 1:09:19 PM
 */

package golden_shoap;

/**
 *
 * @author user1
 */
public class Remaining_Polish_Material extends javax.swing.JInternalFrame {
javax.swing.table.DefaultTableModel dtm;
    /** Creates new form Remaining_Polish_Material */
    public Remaining_Polish_Material() {
        initComponents();

        dtm=new javax.swing.table.DefaultTableModel();

            javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
            javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
            CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
            CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
            CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
            javax.swing.table.TableColumn column;
            String heading1[]={"S.No","Material Name","Quantity","Unit"};
            dtm=new javax.swing.table.DefaultTableModel(heading1,0);
            jTable1.setModel(dtm);
            column=jTable1.getColumn("S.No");
            column.setCellRenderer(CRCenter);
            column.setPreferredWidth(50);

            column=jTable1.getColumn("Material Name");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(212);

            column=jTable1.getColumn("Quantity");
            column.setCellRenderer(CRRight);
            column.setPreferredWidth(96);

            column=jTable1.getColumn("Unit");
            column.setCellRenderer(CRLeft);
            column.setPreferredWidth(96);

            loadTable();

            jTable1.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Remaining Polish Material");
        getContentPane().setLayout(null);

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(255, 204, 255));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 600, 400);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit.gif"))); // NOI18N
        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton2KeyReleased(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 430, 150, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 422, 610, 0);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/PRINT.GIF"))); // NOI18N
        jButton3.setText("Print");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 430, 150, 30);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/DeskTopTextureEdit.png"))); // NOI18N
        getContentPane().add(jLabel23);
        jLabel23.setBounds(0, 0, 630, 490);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyReleased
        // TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            this.dispose();
        }
    }//GEN-LAST:event_jButton2KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        printchallan2 pt=new printchallan2();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void loadTable()
    {
                       String qry="Select * from polish_material order by material_name";

                                            String load[][]=Utility.getInformationDD(qry,4);
                                            if(load.length>0)
                                            {
                                                   String arr[]=new String[4];
                                                    for(int i=0;i<load.length;i++)
                                                    {
                                                        arr[0]=""+(i+1);
                                                        arr[1]=load[i][0];
                                                        arr[2]=load[i][2];
                                                        arr[3]=load[i][1];
                                                        java.math.BigDecimal bd=new java.math.BigDecimal(arr[2]);
                                                        int scale=Utility.manageUnitDecimal("polish_material_unit","material_unit","scale",arr[3]);
                                                        arr[2]=(""+bd.setScale(scale,5));
                                                        dtm.addRow(arr);
                                                }
                                             }

     }


    //Printing coding
     boolean firsttime1=false;
    int purjano;
    class printchallan2
    {

                PrintPanel2 canvas;
	        java.awt.print.PageFormat pageFormat;

        	public printchallan2()
        	{
                    //purjano=Integer.parseInt(str);
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
                            int top=30;
                            int z=0;
                            java.util.Date dt=new java.util.Date();
                            int date=dt.getDate();
                            int month=dt.getMonth()+1;
                            int yr=dt.getYear()+1900;
                            String setDate=date+"-"+month+"-"+yr;
                            g2.setFont(f6);
                            String aa="A.M";
                            int h=dt.getHours();
                            if(h>=12)
                            {   h=(h%12);
                                if(h==0)
                                {
                                    h=1;
                                }
                                aa="P.M";
                            }
                            int m=dt.getMinutes();
                            String temp="Time -"+h+" : "+m+" "+aa+"";
                            g2.drawString(temp,300,top);

                            
                            temp="Date : "+setDate;
                            g2.drawString(temp,15,top);
                            top=top+25;
                            g2.drawLine(15, top, 575, top);
                            //for heading
                            top=top+20;
                            temp="  S.No                           Material Name                                              Quantity                        Unit";
                            g2.drawString(temp,15,top);
                            top=top+10;

                            g2.drawLine(15, top, 575, top);

                            g2.setFont(f5);
                            top=top+30;
                            String qry="Select * from polish_material";
                            String data[][]=Utility.getInformationDD(qry,3);
                            for(int i=0;i<data.length;i++)
                            {
                                temp=""+(i+1);
                                g2.drawString(temp,30,top);
                                temp=""+data[i][0];
                                g2.drawString(temp,140,top);
                                temp=""+data[i][2];
                                g2.drawString(temp,380,top);
                                temp=""+data[i][1]+"";
                                g2.drawString(temp,510,top);
                                top=top+35;
                                /*fm=g2.getFontMetrics();
                                z=fm.stringWidth(temp);
                                g2.drawString(temp,350-z,top);
                               */
                                
                            }
                   }
        }
    }
}
