/*
 * StockReport.java
 *
 * Created on May 6, 2010, 8:28 PM
 */

//package medretail;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.sql.*;
import javax.print.PrintService;
import java.awt.print.*;
import javax.print.attribute.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.font.*;
import java.rmi.*;
/**
 *
 * @author  Deep Pal
 */
public class StockReportOfHPS extends javax.swing.JInternalFrame {
    
    /** Creates new form StockReport */
    public StockReportOfHPS(javax.swing.JDesktopPane jDesktopPane1) {
        initComponents();
        setTitle("HPS");
        dp=jDesktopPane1;
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
        jComboBox1.addItem("All");
        for(int i=1;i<coNm.length;i++)
        {
            jComboBox1.addItem(coNm[i]);
        }
        
        String heading[]={"S.No.","Company Name","Item Name","Quantity","Batch No.","Exp. Date","Party Name"};
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

      		column=jTable1.getColumn("Item Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(200);

      		column=jTable1.getColumn("Quantity");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);

      		column=jTable1.getColumn("Batch No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(100);
                
      		column=jTable1.getColumn("Exp. Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);
                
      		column=jTable1.getColumn("Party Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);
              tab1=jTable1;
        }
         catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		} 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setTitle("REPORT : Display Current Stocks");
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No.", "Company Name", "Item Name", "Quantity", "Batch No.", "Exp. Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 760, 360);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11));
        jLabel1.setText("Select company name to show current stock");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 270, 20);

        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(280, 10, 340, 22);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.gif")));
        jButton1.setMnemonic('s');
        jButton1.setText("Show Stock");
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
        jButton1.setBounds(630, 10, 150, 30);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/PRINT.GIF")));
        jButton2.setMnemonic('p');
        jButton2.setText("Print");
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
        jButton2.setBounds(390, 423, 190, 30);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton3.setMnemonic('c');
        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        getContentPane().add(jButton3);
        jButton3.setBounds(590, 423, 190, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            if(tab1.getRowCount()>0)
			{
				printchallan obj=new printchallan(dp);	
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No stock found to print?","PrintError",JOptionPane.ERROR_MESSAGE);
			}
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        if(tab1.getRowCount()>0)
			{
				printchallan obj=new printchallan(dp);	
			}
			else
			{
				JOptionPane.showMessageDialog(null,"No stock found to print?","PrintError",JOptionPane.ERROR_MESSAGE);
			}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
            showdata();
    }//GEN-LAST:event_jButton1KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
            jButton1.requestFocus();
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        showdata();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void showdata()
    {
        try
        {
            while(dtm1.getRowCount()>0)
                dtm1.removeRow(0);
            
            /*ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.Statement st1=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.Statement st2=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.Statement st3=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);*/
            String sqlQry="select cmpName,cmpCode from cmpMaster order by cmpName"; 
            if(jComboBox1.getSelectedIndex()>0)
            {
                sqlQry="select cmpName,cmpCode from cmpMaster where cmpName='"+jComboBox1.getSelectedItem()+"'";
            }
            //java.sql.ResultSet rs=st.executeQuery(sqlQry);
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
            String [][]rs=inf.getResultSetAs_2D_Array(sqlQry,2);
            String coName="",itmName="";
            if(rs!=null)
            for(int i=0;i<rs.length;i++)
            {
                coName=rs[i][0];
                sqlQry="select itemName,itemCode from itemMaster where cmpCode="+Integer.parseInt(rs[i][1])+" order by itemName";
                //java.sql.ResultSet rs1=st1.executeQuery(sqlQry);
                String [][]rs1=inf.getResultSetAs_2D_Array(sqlQry,2);
                if(rs1!=null)
                for(int j=0;j<rs1.length;j++)
                {
                    itmName=rs1[i][0];
                    sqlQry="select qty,itemType,batchNo,expDate from stockHolding_HPS where itemCode="+Integer.parseInt(rs1[j][1])+" and qty>0";
                    //java.sql.ResultSet rs2=st2.executeQuery(sqlQry);
                    String [][]rs2=inf.getResultSetAs_2D_Array(sqlQry,4);
                    if(rs2!=null)
                    for(int k=0;k<rs2.length;k++)
                    {
                        String arr[]=new String[7];
                        arr[0]=""+(dtm1.getRowCount()+1)+". ";
                        arr[1]=coName;
                        arr[2]=itmName;
                        arr[3]=rs2[k][0]+" "+rs2[k][1];
                        arr[4]=rs2[k][2];
                        arr[5]=rs2[k][3];
                        arr[5]=arr[5].substring(8,10)+"/"+arr[5].substring(5,7)+"/"+arr[5].substring(0,4);
                        arr[6]="";
                       // java.sql.ResultSet rs3=st3.executeQuery("select pNo from purchaseDtl where itemNm='"+arr[2]+"' and batchno='"+arr[4]+"'");
                        String pno=inf.getSingleValue("select pNo from purchaseDtl where itemNm='"+arr[2]+"' and batchno='"+arr[4]+"'"); 
                        if(pno!=null)
                        {
                            int purchaseno=Integer.parseInt(pno);
                            //rs3=st3.executeQuery("select partyNm from purchaseSmry where pNo="+purchaseno);
                            arr[6]=inf.getSingleValue("select partyNm from purchaseSmry where pNo="+purchaseno);
                            /*if(rs3.next())
                            {
                                arr[6]=rs3.getString(1);
                            }*/
                        }
                        dtm1.addRow(arr);
                    }
                }
            }
            //connection.close();
         }
        catch(Exception ex)
        {
            System.out.println("Error...45234..."+ex);
        }        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
     javax.swing.table.DefaultTableModel dtm1;
     JTable tab1;
     JDesktopPane dp;
     	int currentpg,totalpg, rem;
	boolean firsttime=false;
	boolean complete=false;
	int currentrec=0;
	boolean cmp1=false;
	boolean cmp2[]=new boolean[33];
	boolean cmp3=false;
	boolean cmp4=false;
	boolean cmp5=false;
	boolean cmp6=false;
	int startno=0,endno=0;
		
	class printchallan extends JFrame 
	{
        	JInternalFrame pchallanf;
	        Container contentPane;
        	GridBagLayout gbl;
	        GridBagConstraints gbc;
        	JButton printButton;
	        JButton pageSetupButton,exitButton;

			PrintPanel canvas;
	        PageFormat pageFormat;

        	public printchallan(JDesktopPane desk)
        	{
                pchallanf=new JInternalFrame("Printing of Invoice",false,true,true,true);
                contentPane=pchallanf.getContentPane();
				gbl=new GridBagLayout();
				gbc=new GridBagConstraints();
                contentPane.setLayout(new BorderLayout());

                addWindowListener(new WindowAdapter()
                {
                        public void windowClosing(WindowEvent e)
                        {
                                System.exit(0);
                        }
                }
                );

                canvas=new PrintPanel();
                contentPane.add(canvas,"Center");
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new GridLayout(2,1));

                //pageSetupButton.addActionListener(this);

                contentPane.add(buttonPanel,"East");

                                PrinterJob printJob=PrinterJob.getPrinterJob();
                                double width=8.27 * 72;
                                double height=(11.69 * 72);
                                Paper paper=new Paper();                                
                                paper.setSize(width,height);

                                PageFormat page=new PageFormat();
                                paper.setImageableArea(5,10,paper.getWidth(),paper.getHeight());
                                //page.setOrientation(PageFormat.LANDSCAPE);
                                page.setPaper(paper);
                                pageFormat=printJob.defaultPage(page);
                                pageFormat.setPaper(paper);
                                printJob.setPrintable(canvas,pageFormat);
								
                                try
                                {
                          				/*PrintRequestAttributeSet atrb=new HashPrintRequestAttributeSet();
                          				Attribute[] ar=atrb.toArray();
                          				//.out.println("length="+atrb.getName());
                          				PrintService[] pj = PrinterJob.lookupPrintServices();
                          				for(int i=0;i<pj.length;i++)
                          				{
                          					System.out.println(""+i+":-"+pj[i]);
                          				}
										
										PrinterJob job=PrinterJob.getPrinterJob();
										PrintPanel canvas=new PrintPanel();
										if(job.printDialog(atrb))
										{
										*/
										//no of pages
							 			/*Datab1aseFile dbfile=new Datab1aseFile();
										Connection con=dbfile.connectDatab1ase();
										Statement st=con.createStatement();
										Statement st1=con.createStatement();
										*/
										System.out.println("W="+paper.getWidth()+"H="+paper.getHeight());
										//printJob.print();
										
									//for(int d=1;d<=noOfCopies;d++)
	                           		//{
										//totalamt=new BigDecimal("0.00");
										
										
										
										
										
													int totalrec=tab1.getRowCount();
														if(tab1.getRowCount()<=33)
														{
															totalpg=tab1.getRowCount()/33;
															rem=tab1.getRowCount()%33;
														}
														if(tab1.getRowCount()>33)
														{
															totalpg=1+((tab1.getRowCount()-33)/38);
															rem=(tab1.getRowCount()-33)%38;
														}
														
									    				System.out.println("rem....more="+rem);
											
											
														System.out.println("dhananaja tiwari before="+totalpg);
														if(rem>0)
															totalpg++;
															currentpg=totalpg;	
										
														System.out.println("dhananaja tiwari after="+totalpg);
														firsttime=false;
														if(totalpg==1)
														{
																endno=totalrec;
                            		    						startno=1;
                            		    						
                            				
                            									firsttime=false;
                            									printJob.print();
                            									//currentpg--;	
                            									
														}
														else
														{
														
														for(int i=totalpg;i>=1;i--)	
                            		    				{
                            		    						if(totalpg==i)
                            		    						{
                            		    							startno=(totalrec-rem)+1;
                            		    							endno=totalrec;
                            		    						}
                            		    						else if(currentpg==1)
                            		    						{
                            		    							endno=startno-1;
                            		    							startno=1;
                            		    						}
                            		    						else
                            		    						{
                            		    							endno=startno-1;
                            		    							startno=(endno-38)+1;                            		    							
                            		    						}
                            				
                            									firsttime=false;
                            									printJob.print();
                            									currentpg--;	
                            									//startno=endno;
                            									//endno=startno+38;
                            							}
                            							}
														/*for(int i=1;i<=totalpg;i++)	
                            		    				{
                            									System.out.println("i="+i);
                            									if(i==1)
                            									{
                            										startno=(i-1)*33;
                            				    				    endno=startno+33;	
                            									
                            									}		
                            				                    if(i==2)
                            				                    {
                            				                    	startno=(i-1)*33;
                            				    				    endno=startno+38;	
                            				                    }
                            											
                            			    					if(endno>(grid.getRowCount()-1))
                            									endno=grid.getRowCount();
                            					
                            									currentpg++;	
                            				
                            									firsttime=false;
                            									printJob.print();
                            									startno=endno;
                            									endno=startno+38;
                            							}*/
										
										
										
											
										
										
										
										
									//}
	                            }
                                catch(Exception exception)
                                {
                                        JOptionPane.showMessageDialog(this,exception);
                                }
        		}
	}
	class PrintPanel extends JPanel implements Printable
	{
        //Connection connection;
        //Statement st,st1;
        //ResultSet rs,rs1;
        int page=100;
		TextLayout layout;
		Font f,f1,f2,f3,f4,f5,f6;
		Graphics2D g2;
		int row=0;		
		FontRenderContext context;
        
        
        public PrintPanel()
        {
                //ChallanNo=JOptionPane.showInputDialog(null,"Enter Challan Number:");
        }
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                Graphics2D g2=(Graphics2D)g;
                drawPage(g2);
        }

        public int print(Graphics g,PageFormat pf,int page) throws PrinterException
        {
                if(page>=1)
                        return Printable.NO_SUCH_PAGE;
                Graphics2D g2=(Graphics2D)g;
                g2.setPaint(Color.black);
                g2.translate(pf.getImageableX(),pf.getImageableY());
                //g2.draw(new Rectangle2D.Double(0,0,pf.getImageableWidth(),pf.getImageableHeight()));
                System.out.println("W1="+pf.getImageableWidth()+"H1="+pf.getImageableHeight());
                drawPage(g2);
                return Printable.PAGE_EXISTS;
        }
        public void drawPage(Graphics2D g2)
        {
			this.g2=g2;
			//System.out.println("inside draw page..."+totalamt);	
			
            context=g2.getFontRenderContext();
            f1=new Font("Times New Roman",Font.BOLD,10);
            //f1=new Font("Arial",Font.BOLD,120);
            f2=new Font("Arial",Font.PLAIN,9);
            f3=new Font("Arial",Font.PLAIN,10);
            f4=new Font("Arial",Font.BOLD,10);
            f5=new Font("Times New Roman",Font.PLAIN,11);
            f6=new Font("Times New Roman",Font.BOLD,11);
            Font f7=new Font("Times New Roman",Font.BOLD,12);
            Font f8=new Font("Times New Roman",Font.BOLD,25);
            FontMetrics fm;
            GeneralPath clipShape=new GeneralPath();

            String str=" fdfg dfg dfg";
            String str1="d fgf dgdfg df";                                        
            g2.setFont(f1);
            layout=new TextLayout(str,f1,context);
            AffineTransform transform=AffineTransform.getTranslateInstance(10,20);
			
			if(firsttime==false)
			{
				firsttime=true;
			}
			else
			{			
		        try
        		{
        			System.out.println("dhananjay.............1");
        			
        			
        			
		        	/*FinDatab1aseFile dbfile1=new FinDatab1aseFile();
					Connection con1=dbfile1.connectDatab1ase();
					Statement st=con1.createStatement();								
					con1.close();*/
					
					System.out.println("dhananjay.............2");
					
					/*Datab1aseFile confile=new Datab1aseFile();
					Connection connection=confile.connectDatab1ase();
					Statement stobj=connection.createStatement();
					stobj.close();
					connection.close();								
					System.out.println("dhananjay.............3");*/
					
					fm=g2.getFontMetrics();				
					String temp="";
		            int top=40;
		            
		            if(currentpg==1)
		            {
		            
						System.out.println("s......");

		            
		            
		            g2.setFont(f6);
		            java.util.Date dt=new java.util.Date();
		            fm=g2.getFontMetrics();				
		            temp="Stock on dated :" +dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		            layout=new TextLayout(temp,f6,context);
        		    g2.drawString(temp,(595-fm.stringWidth(temp))/2,top);
        		    
		            top+=20;
		            g2.setFont(f8);
		            fm=g2.getFontMetrics();
                            System.out.println(SetDBFileName.firmNameForDBSelection);
                            //String firm[]=SetDBFileName.firmNameForDBSelection.split("."); 
                            String firm=SetDBFileName.firmNameForDBSelection.substring(0,SetDBFileName.firmNameForDBSelection.indexOf("."));
		            temp=firm.toUpperCase();
		            layout=new TextLayout(temp,f8,context);
        		    g2.drawString(temp,(595-fm.stringWidth(temp))/2,top);
					
                                        top+=10;
					g2.setFont(f1);
                                        
		            temp="Company Name";
		            layout=new TextLayout(temp,f1,context);
        		    g2.drawString(temp,25,top);
        		    
        		    temp="Item Name";
		            layout=new TextLayout(temp,f1,context);
        		    g2.drawString(temp,135,top)	;

		            temp="Quantity";
		            layout=new TextLayout(temp,f1,context);
        		    g2.drawString(temp,275,top)	;
                            
                            temp="Batch No.";
		            layout=new TextLayout(temp,f1,context);
        		    g2.drawString(temp,375,top)	;

		            temp="Exp.Date";
		            layout=new TextLayout(temp,f1,context);
        		    g2.drawString(temp,500,top)	;

		            /*temp="Rate";
		            layout=new TextLayout(temp,f1,context);
        		    g2.drawString(temp,505,top);*/
                            }
					
					top+=7;
					g2.setFont(f6);
					//layout=new TextLayout("------------------------------------------------------------------------------------------------------------------------------------------------------------------",f6,context);
        			//g2.drawString("------------------------------------------------------------------------------------------------------------------------------------------------------------------",0,top);
					g2.drawLine(10,top,575,top);
					
					g2.setFont(f3);
		            for(int i=startno-1;i<endno;i++)
					{
						top+=12;
			            fm=g2.getFontMetrics();				
			            temp=""+tab1.getValueAt(i,1);
			            layout=new TextLayout(temp,f1,context);
        			    g2.drawString(temp,25,top);
	
			           
			            
			            temp=""+tab1.getValueAt(i,2);
			            temp=temp.toUpperCase();
			            layout=new TextLayout(temp,f1,context);
        			    g2.drawString(temp,100,top);

						temp=""+tab1.getValueAt(i,3);
						//temp=temp.toUpperCase();
			            layout=new TextLayout(temp,f1,context);
        			    g2.drawString(temp,250,top);
                                    
                                    temp=""+tab1.getValueAt(i,4);
			            temp=temp.toUpperCase();
			            layout=new TextLayout(temp,f1,context);
        			    g2.drawString(temp,370,top);
						
						fm=g2.getFontMetrics();				
			            temp=""+tab1.getValueAt(i,5);
			            layout=new TextLayout(temp,f1,context);
        			    g2.drawString(temp,490,top);

			            
			            
			            
			                     
			            
			            
			            
			           /*temp=""+tab11.getValueAt(i,4);			            
			            layout=new TextLayout(temp,f1,context);
        			    g2.drawString(temp,(550-fm.stringWidth(temp)),top);*/
        			    
        			  top+=5;
			            g2.drawLine(10,top,575,top);
					}

					top=720;
					g2.setFont(f6);
					//layout=new TextLayout("------------------------------------------------------------------------------------------------------------------------------------------------------------------",f6,context);
        			//g2.drawString("------------------------------------------------------------------------------------------------------------------------------------------------------------------",0,top);
					g2.drawLine(10,top,575,top);
					
					
					top+=10;
					g2.setFont(f6);
					if(totalpg>1 && currentpg!=totalpg)
					{
						temp="Continue...";	
			            layout=new TextLayout(temp,f1,context);
       				    g2.drawString(temp,480,top);        				    
					}
						temp="("+currentpg+"/"+totalpg+")";
						fm=g2.getFontMetrics();				
			            layout=new TextLayout(temp,f6,context);
       				    g2.drawString(temp,(575-fm.stringWidth(temp))/2,top);
       				   
					
         		}
         		catch(Exception x)
         		{
	        		System.out.println("Error2193821..."+x);
         		}
         
         	}
      	}
	}
}