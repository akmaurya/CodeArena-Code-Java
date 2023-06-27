/*
 * PatientDescGianec.java
 *
 * Created on April 19, 2011, 1:24 AM
 */

/**
 *
 * @author  DeepaL
 */
 import java.rmi.*;
 import javax.swing.*;
 import javax.swing.table.*;
 import java.util.*;
 import java.awt.*;
 import javax.swing.event.*;
 import java.awt.geom.*;
 import javax.print.PrintService;
 import java.awt.print.*;
 import javax.print.attribute.*;
 import java.awt.font.*;
 import java.awt.event.*;
 import javax.swing.event.*;
 import java.io.*;
 
 
public class NewPatientPrescGianec extends javax.swing.JInternalFrame {
    
    /** Creates new form PatientDescGianec */
    public NewPatientPrescGianec(javax.swing.JDesktopPane dp,int pid,String holdDt) {
    	
    	
    	frm=new JInternalFrame("New Patient Prescription Gianec",false,true,false,true);
		cn=frm.getContentPane();
	//	cn=frm.getContentPane();
	//	setLayout(null);
		cn.setLayout(null);
    	
    	setTitle("Patient Prescription");
    	setClosable(true);
    	initComponents();
        dpp=dp;
        getDt=holdDt;
        System.out.println("getDt       ........By S_CHK     "+getDt);
        //System.out.println("sa1");
        String[] ele=null,dosage=null;
        patientID=pid;
        try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
									getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}
		try
		{
			
       ele=inf.getResultSetAs_1D_Array("select itemName from itemMaster order by itemName asc");
       dosage=inf.getResultSetAs_1D_Array("select dosage from dosage");
		
		}
	catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       }
        
        //System.out.println("sa2");
        itemNmVc=new java.util.Vector();
        for(int i=0;i<ele.length;i++)
        {
        	itemNmVc.addElement(ele[i]);
        }
        jList1.setListData(itemNmVc);
        jPanel3.setVisible(false);
        jComboBox1.removeAllItems();
        for(int i=0;i<dosage.length;i++)
       {
       		jComboBox1.addItem(dosage[i]);
       }
       jComboBox2.removeAllItems();
        for(int i=1;i<=100;i++)
       {
       		jComboBox2.addItem(""+i);
       }
       
        jTextField1.setText("");
       // System.out.println("aaaa");
        String heading[]={"Medicine Name","Dosage","Duration","Days","Remarks"};
        dtm=new javax.swing.table.DefaultTableModel(heading,0);
         jTable1.setModel(dtm);
         //jTable1.setToolTipText("Select Any Row And Press->( DEL for DELETE ) ( Choose Update/Update Button ) To Update/Delete Item");
         
         DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
      		TableColumn column;
			System.out.println("a1");
			column=jTable1.getColumn("Medicine Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(80);
       		//System.out.println("a2");
       		column=jTable1.getColumn("Dosage");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(80);
       		//System.out.println("a3");
       		column=jTable1.getColumn("Duration");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);
       		//System.out.println("a4");
       		column=jTable1.getColumn("Days");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(20);
       		//System.out.println("a5");
       		column=jTable1.getColumn("Remarks");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(100);
       		System.out.println("a6");
       		
       		
       		jButton1.setIcon(new ImageIcon("icons\\Garrow.gif"));
       		jButton2.setIcon(new ImageIcon("icons\\save.gif"));
       		jButton3.setIcon(new ImageIcon("icons\\back.gif"));
       		jButton4.setIcon(new ImageIcon("icons\\back.gif"));
       		jButton5.setIcon(new ImageIcon("icons\\print.gif"));
       		jButton6.setIcon(new ImageIcon("icons\\forward.gif"));
       		jButton7.setIcon(new ImageIcon("icons\\reset.gif"));
       		jButton8.setIcon(new ImageIcon("icons\\close.gif"));
       		
       		
       		
		frm.reshape(50,50,812,519);
		System.out.println("S_CHK");
	 	dp.add(frm);
	 	frm.setVisible(true);
	 	
       		
       		
       	getInitialInfo();
       	
       	
       	if(getDt!=null)
		{
		setCurrentPresc();
	    	}
 }
    
    private void getInitialInfo()
	{
		try
		{
		
		try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
									getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
       		String pName=inf.getSingleValue("select name from patient_Profile where patientid="+patientID);
       		jLabel2.setText(pName);
       		String pAge=inf.getSingleValue("select age from patient_Profile where patientid="+patientID);
       		String pGen=inf.getSingleValue("select gender from patient_Profile where patientid="+patientID);
       		jLabel4.setText(pAge+" / "+pGen);
       		String pAds=inf.getSingleValue("select address from patient_Profile where patientid="+patientID);
       		jLabel6.setText(pAds);
       		
       		java.util.Date dt=new java.util.Date();
       		String curDt=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
       		jLabel8.setText(curDt);
       		System.out.println("here is the problm     ");
       	}
       	catch(Exception ex)
       	{
       	 	System.out.println("Error.1..."+ex);
       	}
	}
	
	class printGianicPresc extends JFrame 
   {
        	JInternalFrame pchallanf;
	        Container contentPane;
        	GridBagLayout gbl;
	        GridBagConstraints gbc;
        	JButton printButton;
	        JButton pageSetupButton,exitButton;

			PrintPanel canvas;
	        PageFormat pageFormat;

        	public printGianicPresc(JDesktopPane desk)
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
										System.out.println("W="+paper.getWidth()+"H="+paper.getHeight());
										currentpg=1;
										printJob.print();
	                            }
                                catch(Exception exception)
                                {
                                        JOptionPane.showMessageDialog(this,exception);
                                }
        		}
	}
	
	
	
	
	
	int currentpg,totalpg, rem;
	boolean firsttime=false;
	boolean complete=false;
	int currentrec=0,startno=0,endno=0;
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
            f1=new Font("Times New Roman",Font.BOLD,12);
            //f1=new Font("Arial",Font.BOLD,120);
            f2=new Font("Arial",Font.PLAIN,9);
            f3=new Font("Arial",Font.PLAIN,10);
            f4=new Font("Arial",Font.BOLD,10);
            f5=new Font("Times New Roman",Font.PLAIN,15);
            f6=new Font("Times New Roman",Font.BOLD,11);
            Font f7=new Font("Times New Roman",Font.BOLD,15);
            Font f8=new Font("Times New Roman",Font.BOLD,25);
            Font f9=new Font("Times New Roman",Font.BOLD,18);
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
					Statement stinf=connection.createStatement();
					stinf.close();
					connection.close();								
					System.out.println("dhananjay.............3");*/
					
					fm=g2.getFontMetrics();				
					String temp="";
		            int top=170;
		            
		            if(currentpg==1)
		            {
		            
						System.out.println("s......");

		            
		            
		            g2.setFont(f1);
		            
		            fm=g2.getFontMetrics();				
		            
                   	temp=jLabel2.getText();//.toUpperCase();
		            layout=new TextLayout(temp,f1,context);
        		    g2.drawString(temp,100,top);
					
                    				
					//g2.setFont(f9);
					//fm=g2.getFontMetrics();
				//	firm=jLabel4.getText();
					temp=jLabel4.getText();
					layout=new TextLayout(temp,f1,context);
					g2.drawString(temp,470,top);
					
					top+=20;
					//g2.setFont(f9);
					//fm=g2.getFontMetrics();
				//	firm=jLabel6.getText();
					temp=jLabel6.getText();
					System.out.println("add="+temp);
					layout=new TextLayout(temp,f1,context);
					g2.drawString(temp,100,top);
					
					//g2.setFont(f9);
					//fm=g2.getFontMetrics();
				//	firm=jLabel8.getText();
					temp=jLabel8.getText();
					layout=new TextLayout(temp,f1,context);
					g2.drawString(temp,390,top);
					
					g2.setFont(f3);
					fm=g2.getFontMetrics();
					top+=50;
					
					
					//////////////update here///////////////for printing/////////////
					 g2.drawRect(50,top,248,top+105);
					//String ln=
					
				/*	if(dtm.getRowCount()!=0)
					{
						int rwcnt=dtm.getRowCount();
						System.out.println("rwcnt "+rwcnt);
						
						int temp1=100;
						for(int j=0;j<rwcnt;j++,top+=20)
						{
							int c=0;
							temp=""+jTable1.getValueAt(j,c);
							if(!temp.equals(""))
							{
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1-30,top);
							}
							else
							{
								temp=" ";
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1-30,top);
							}
							
												    
						    temp1+=90;
						    temp=""+jTable1.getValueAt(j,++c);
							if(!temp.equals(""))
							{
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1,top);
							}
							else
							{
								temp=" ";
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1,top);
							}
							
							
							temp1+=150;
							temp=""+jTable1.getValueAt(j,++c);
							if(!temp.equals(""))
							{
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1,top);
							
							}
							else
							{
								temp=" ";
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1,top);
							
							}
							
							temp1+=60;
							temp=""+jTable1.getValueAt(j,++c);
							if(!temp.equals(""))
							{
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1,top);
							
							}
							else
							{
								temp=" ";
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1,top);
							
							}
							
							temp1+=60;
							temp=""+jTable1.getValueAt(j,++c);
							if(!temp.equals(""))
							{
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1,top);
							
							}
							else
							{
								temp=" ";
								layout=new TextLayout(temp,f3,context);
							g2.drawString(temp,temp1,top);
							
							}
							
							temp1=100;
												
						}
					}*/
					
					
					
				/*	top+=400;
					g2.setFont(f1);
					fm=g2.getFontMetrics();
					temp="BP";
					layout=new TextLayout(temp,f1,context);
					g2.drawString(temp,100,top);
					
					top+=20;
					//g2.setFont(f7);
					//fm=g2.getFontMetrics();
					temp="Sugar";
					layout=new TextLayout(temp,f1,context);
					g2.drawString(temp,100,top);*/
					
				///	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
									getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}					
					String qry="Select blood_pr,sugar from history_Patient where patient_id="+patientID+" Order By history_date desc";
                    System.out.println("qry "+qry);
                    String loadHistory[][]=inf.getResultSetAs_2D_Array(qry,2);
                    if(loadHistory!=null)
                    {
                    	top-=20;
                    	g2.setFont(f3);
                    	fm=g2.getFontMetrics();
                    	temp=" "+loadHistory[0][0];
                    	layout=new TextLayout(temp,f3,context);
                    	g2.drawString(temp,200,top);
                    	
                    	top+=20;
                    	//g2.setFont(f5);
                    	//fm=g2.getFontMetrics();
                    	temp=" "+loadHistory[0][1];
                    	layout=new TextLayout(temp,f3,context);
                    	g2.drawString(temp,200,top);
                    	//System.out.println();
                    	
                    //	System.out.println(loadHistory[0][1]);
                    }
					
					}
         		}
         		catch(Exception x)
         		{
	        		System.out.println("Error2193821..."+x);
         		}
         
         	}
      	}
	}
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

      //  getContentPane().setLayout(null);

        jPanel1.setLayout(null);
     //   cn.add(jPanel1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 51), 2, true), "Patient Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 11), new java.awt.Color(0, 0, 204)));
        jLabel1.setText("Patient Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 90, 14);

        jLabel2.setBackground(new java.awt.Color(255, 255, 102));
        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel2.setText("Sunil ma");
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 20, 210, 15);

        jLabel3.setText("Age / Sex");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(490, 20, 70, 14);

        jLabel4.setBackground(new java.awt.Color(255, 255, 102));
        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel4.setText("Sunil ma");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(560, 20, 210, 15);

        jLabel5.setText("Address");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 50, 70, 14);

        jLabel6.setBackground(new java.awt.Color(255, 255, 102));
        jLabel6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel6.setText("Sunil ma");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6);
        jLabel6.setBounds(100, 50, 370, 15);

        jLabel7.setText("Date");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(490, 50, 70, 14);

        jLabel8.setBackground(new java.awt.Color(255, 255, 102));
        jLabel8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Sunil ma");
        jLabel8.setOpaque(true);
        jPanel1.add(jLabel8);
        jLabel8.setBounds(560, 50, 210, 15);

        //jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton3.setForeground(new java.awt.Color(0, 0, 153));
        jButton3.setText("Previous Hist.");
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
        jButton3.setBounds(320, 20, 160, 23);

        //getContentPane().add(jPanel1);
        cn.add(jPanel1);
        jPanel1.setBounds(10, 10, 780, 80);

        jPanel2.setLayout(null);
        

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 51), 2, true), "Medicine Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 11), new java.awt.Color(0, 0, 204)));
        jLabel9.setText("Enter Medicine Name");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 20, 120, 14);

        jLabel10.setText("Dosage");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(180, 20, 80, 14);

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

        jPanel2.add(jTextField5);
        jTextField5.setBounds(10, 40, 140, 19);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
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

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(10, 60, 140, 180);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel());
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

        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(170, 40, 100, 22);

        jLabel11.setText("Duration");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(300, 20, 80, 14);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel());
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

        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(290, 40, 100, 22);

        jLabel12.setText("Day(s)");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(420, 20, 80, 14);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day(s)","Week(s)","Month(s)","Year(s)" }));
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

        jPanel2.add(jComboBox3);
        jComboBox3.setBounds(410, 40, 100, 22);

        jLabel13.setText("Remarks");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(530, 20, 80, 14);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jPanel2.add(jTextField1);
        jTextField1.setBounds(522, 40, 140, 19);

       // jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton1.setForeground(new java.awt.Color(0, 0, 153));
        jButton1.setText("Add");
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

        jPanel2.add(jButton1);
        jButton1.setBounds(670, 40, 100, 30);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new  Object [][] {
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
        jScrollPane1.setBounds(10, 90, 760, 150);

        //jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton4.setForeground(new java.awt.Color(0, 0, 153));
        jButton4.setText("Old Presc.");
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

        jPanel2.add(jButton4);
        jButton4.setBounds(630, 10, 140, 23);

     //   getContentPane().add(jPanel2);
     cn.add(jPanel2);
        jPanel2.setBounds(10, 90, 780, 250);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 51), 2, true), "Advice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 11), new java.awt.Color(0, 0, 204)));
        jPanel4.add(jScrollPane3, java.awt.BorderLayout.NORTH);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });

        jScrollPane4.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane4, java.awt.BorderLayout.CENTER);

       // getContentPane().add(jPanel4);
       cn.add(jPanel4);
        jPanel4.setBounds(10, 340, 780, 70);

        jPanel5.setLayout(null);

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));
       // jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton2.setForeground(new java.awt.Color(0, 0, 153));
        jButton2.setText("Save");
        jButton2.setMnemonic('s');
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

        jPanel5.add(jButton2);
        jButton2.setBounds(30, 10, 130, 30);

        //jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton5.setForeground(new java.awt.Color(0, 0, 153));
        jButton5.setText("Print");
        jButton5.setMnemonic('P');
        jButton5.setToolTipText("Print");
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

        jPanel5.add(jButton5);
        jButton5.setBounds(170, 10, 130, 30);

        //jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton6.setForeground(new java.awt.Color(0, 0, 153));
        jButton6.setText("Log Out");
        jButton6.setMnemonic('L');
        jButton6.setToolTipText("Log out Patient");
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

        jPanel5.add(jButton6);
        jButton6.setBounds(320, 10, 130, 30);

        //jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton7.setForeground(new java.awt.Color(0, 0, 153));
        jButton7.setText("Refresh");
        jButton7.setToolTipText("Refresh");
        jButton7.setMnemonic('r');
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton7KeyPressed(evt);
            }
        });

        jPanel5.add(jButton7);
        jButton7.setBounds(470, 10, 130, 30);

        //jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton8.setMnemonic('c');
        jButton8.setForeground(new java.awt.Color(0, 0, 153));
        jButton8.setText("Close");
        jButton8.setToolTipText("Close");
        
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

        jPanel5.add(jButton8);
        jButton8.setBounds(620, 10, 130, 30);

       // getContentPane().add(jPanel5);
       cn.add(jPanel5);
        jPanel5.setBounds(10, 420, 780, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
	{
		jButton2.requestFocus();
	}
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jButton8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton8KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
		this.dispose();
    }//GEN-LAST:event_jButton8KeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
// TODO add your handling code here:
	this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton7KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
		refresh();
    }//GEN-LAST:event_jButton7KeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
// TODO add your handling code here:
	refresh();
    }//GEN-LAST:event_jButton7ActionPerformed
	private void refresh()
	{
		jButton2.setEnabled(true);
		dtm.setRowCount(0);
		jTextField1.setText("");
		jTextField5.setText("");
		jTextArea1.setText("");
		jTextField5.requestFocus();
	}
    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
		logOut();
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
	logOut();
System.out.println("log out");
    }//GEN-LAST:event_jButton6ActionPerformed
	private void logOut()
	{
		try
		{
		try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
									getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
       	//	String query="update patient_Profile set status="+false+" where patientid="+patientID+"";
       	//	inf.executeUpdateQuery(query);
       		String qry="Update history_Patient set status="+false+" where patient_id="+patientID+"";
			inf.executeUpdateQuery(qry);
			
			
       		JOptionPane.showMessageDialog(null,jLabel2.getText()+" Go To Home Successfully...");
       		jButton6.setEnabled(false);
       	}
       	catch(Exception e)
		{
			System.out.println("Error into logOut method...."+e);
		}
	}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
	System.out.println("print");
	
	printGianicPresc printing=new printGianicPresc(dpp);
	
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
		save();
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
		save();
    }//GEN-LAST:event_jButton2ActionPerformed

	private boolean save()
	{
		try
		{
		try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
									getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
       		int presc=inf.getMaxValue("select max(prescNo) from patient_Presc_Gianec");
       		presc+=1;
       		System.out.println("presc......."+presc);
       		Date dt=new Date();
			int day=dt.getDate();
			int mon=dt.getMonth()+1;
			int year=(1900+dt.getYear());
			int hr=dt.getHours();
			int min=dt.getMinutes();
			int sec=dt.getSeconds();
			String currentdate=mon+"/"+day+"/"+year+" "+hr+":"+min+":"+sec;
			String currenttime=hr+":"+min+":"+sec;
		//	System.out.println("currenttime....."+currenttime);
		//	System.out.println("currentdate "+currentdate);
			String qry="insert into patient_Presc_Gianec values("+presc+","+patientID+",'"+jTextArea1.getText()+"',#"+currentdate+"#,#"+currenttime+"#)";
		//	System.out.println("qry...........by  S_CHK"+qry);
       		inf.executeUpdateQuery("insert into patient_Presc_Gianec values("+presc+","+patientID+",'"+jTextArea1.getText()+"',#"+currentdate+"#,#"+currenttime+"#)");
       		int i=0;
       		System.out.println("dtmcount......."+dtm.getRowCount());
       		while(i<dtm.getRowCount())
       		{
       			inf.executeUpdateQuery("insert into patient_Presc_Gianec_Details values("+presc+",'"+(""+jTable1.getValueAt(i,0))+"','"+(""+jTable1.getValueAt(i,1))+"',"+Integer.parseInt(""+jTable1.getValueAt(i,2))+",'"+(""+jTable1.getValueAt(i,3))+"','"+(""+jTable1.getValueAt(i,4))+"')");
       			i++;
       		}
       		JOptionPane.showMessageDialog(null,"Patient Prescription Saved Successfully..");
       		jButton2.setEnabled(false);
		}
		catch(Exception e)
		{
			System.out.println("Error into save method...."+e);
			return false;
		}
		return true;
	}

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
	{
		prescriptionPreviousOfGianec P_previous=new prescriptionPreviousOfGianec(dpp,jLabel2.getText(),patientID);
		P_previous.setBounds(100,40,560,620);
		P_previous.setVisible(true);
	}
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
		System.out.println("date     "+jLabel2.getText());
		prescriptionPreviousOfGianec P_previous=new prescriptionPreviousOfGianec(dpp,jLabel2.getText(),patientID);
		P_previous.setBounds(100,40,560,620);
		P_previous.setVisible(true);
	//	this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
	{
		fetchHistory historyDG=new fetchHistory(jLabel2.getText(),patientID);
		historyDG.setBounds(100,50,700,370);
		historyDG.setVisible(true);
	}
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
		fetchHistory historyDG=new fetchHistory(jLabel2.getText(),patientID);
		historyDG.setBounds(100,50,700,370);
		historyDG.setVisible(true);
	//System.out.println("Preious history");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
		addItem();
		jTextField5.requestFocus();
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
		addItem();
		jTextField5.requestFocus();
    }//GEN-LAST:event_jButton1ActionPerformed

	private boolean addItem()
	{
		if(jTextField5.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null,"Please Enter Medicine Name","Error !!",JOptionPane.ERROR_MESSAGE);
            jTextField5.requestFocus();
            return false;
		}
		String arr[]=new String[5];
		arr[0]=jTextField5.getText();
		arr[1]=""+jComboBox1.getSelectedItem();
		arr[2]=""+jComboBox2.getSelectedItem();
		arr[3]=""+jComboBox3.getSelectedItem();
		arr[4]=jTextField1.getText();
		dtm.addRow(arr);
		jTextField1.setText("");
		jTextField5.setText("");
		return true;
	}
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
	{
		jButton1.requestFocus();
	}
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
	{
		jTextField1.requestFocus();
	}
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
	{
		jComboBox3.requestFocus();
	}
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
// TODO add your handling code here:
	if(evt.getKeyCode()==10)
	{
		jComboBox2.requestFocus();
	}
        
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
// TODO add your handling code here:
       jTextField5.setText(""+itemNmVc.elementAt(jList1.getSelectedIndex()));
        jPanel3.setVisible(false);
        //jTextField5.requestFocus();
        jComboBox1.requestFocus();
    }//GEN-LAST:event_jList1MouseClicked

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
// TODO add your handling code here:
       //  jTextField5.setText(""+itemNmVc.elementAt(jList1.getSelectedIndex()));
    }//GEN-LAST:event_jList1ValueChanged

    private void jList1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList1FocusLost
// TODO add your handling code here:
        //jPanel3.setVisible(false);
    }//GEN-LAST:event_jList1FocusLost

    private void jList1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jList1FocusGained
// TODO add your handling code here:
        //jPanel3.setVisible(true);
    }//GEN-LAST:event_jList1FocusGained

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
// TODO add your handling code here:
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
// TODO add your handling code here:
        /*if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) {
            jPanel3.setVisible(true);
            String crntText=jTextField5.getText().toUpperCase();
            int l=itemNmVc.size();
            jList1.clearSelection();
            for(int i=0;i<l;i++) {
                String itemnm=""+itemNmVc.elementAt(i);
                int indx=itemnm.indexOf(crntText);
                if(indx>=0) {
                    jList1.setSelectedIndex(i);
                    jList1.ensureIndexIsVisible(i);
                    break;
                }
            }
        } else if(evt.getKeyCode()!=evt.VK_ENTER && evt.getKeyCode()!=evt.VK_ESCAPE && evt.getKeyCode()!=evt.VK_DOWN && evt.getKeyCode()!=evt.VK_UP) {
            jList1.clearSelection();
        }*/
        
        if(evt.getKeyCode()==evt.VK_DOWN) 
        {
            if(jPanel3.isVisible()==false)
                jPanel3.setVisible(true);
            jList1.setSelectedIndex(jList1.getSelectedIndex()+1);
            jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
        }
        else if(evt.getKeyCode()==evt.VK_UP) 
        {
            if(jPanel3.isVisible()==false)
                jPanel3.setVisible(true);
            jList1.setSelectedIndex(jList1.getSelectedIndex()-1);
            jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
        }
//      if(evt.getKeyCode()>=evt.VK_A && evt.getKeyCode()<=evt.VK_Z) 
        else
        {
        //jPanel2.setVisible(true);
        String crntText=jTextField5.getText().toUpperCase();
        int l=itemNmVc.size();
        jList1.clearSelection();
        for(int i=0;i<l;i++) {
            String itemnm=""+itemNmVc.elementAt(i);
            int indx=itemnm.indexOf(crntText);
            if(indx==0) {
                jList1.setSelectedIndex(i);
                jList1.ensureIndexIsVisible(i);
                break;
            }
        }
        }
        
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==evt.VK_ENTER) {
            if(jList1.getSelectedIndex()>=0){
                jTextField5.setText(""+itemNmVc.elementAt(jList1.getSelectedIndex()));
            }
            /*utilityClass uc=new utilityClass();
            //String unittype=uc.getSmallestQtyType(jTextField5.getText().trim());//,jTextField5.getText().trim());
            //if(unittype.equalsIgnoreCase("tab"))
             //   jLabel4.setText("Tab");
            //else if(unittype.equalsIgnoreCase("capsule"))
                jLabel4.setText("Capsule");
            else
                jLabel4.setText(unittype);*/
            
            jPanel3.setVisible(false);
            jComboBox1.requestFocus();
        } 
        /*else if(evt.getKeyCode()==evt.VK_DOWN) {
            if(jPanel3.isVisible()==false)
                jPanel3.setVisible(true);
            jList1.setSelectedIndex(jList1.getSelectedIndex()+1);
            jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
        } else if(evt.getKeyCode()==evt.VK_UP) {
            if(jPanel3.isVisible()==false)
                jPanel3.setVisible(true);
            jList1.setSelectedIndex(jList1.getSelectedIndex()-1);
            jList1.ensureIndexIsVisible(jList1.getSelectedIndex());
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
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
// TODO add your handling code here:
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusGained
// TODO add your handling code here:
       /*utilityClass uc=new utilityClass();
        //String itemNm[]=uc.getItemNames(jTextField4.getText());//""+coNmVc.elementAt(jList1.getSelectedIndex()));
        /itemNmVc.removeAllElements();
        for(int i=1;i<itemNm.length;i++) {
            itemNmVc.addElement(itemNm[i]);
        }
        jList2.setListData(itemNmVc);*/
        
        //jPanel3.setVisible(true);
    }//GEN-LAST:event_jTextField5FocusGained
    
    private void setCurrentPresc()
    {
    		System.out.println("Coming back to..........this file S_CHK");
			
			System.out.println("date received");
				String split_wholeDate[]=getDt.split("/");
				System.out.println("date "+split_wholeDate[0]);
				int D=Integer.parseInt(split_wholeDate[0]);
		
				System.out.println("Month "+split_wholeDate[1]);
				int M=Integer.parseInt(split_wholeDate[1]);
		
			//	System.out.println("2 "+split_wholeDate[2]);
		
					
			/*	String split_Date[]=split_wholeDate[2].split(" ");
				System.out.println("year "+split_Date[0]);
				int Y=Integer.parseInt(split_Date[0]);
		
				System.out.println("Time "+split_Date[1]);*/
				
				
				
				
				String split_Date[]=split_wholeDate[2].split(" ");
				System.out.println("year  "+split_Date[0]);
				int Y=Integer.parseInt(split_Date[0]);
		
		/*		System.out.println("1 "+split_Date[1]);
			
				String split_Time[]=split_Date[1].split(":");
				System.out.println("0 "+split_Time[0]);
				int H=Integer.parseInt(split_Time[0]);
		
				System.out.println("1 "+split_Time[1]);
				int MIN=Integer.parseInt(split_Time[1]);
		
				System.out.println("2 "+split_Time[2]);
				int S=Integer.parseInt(split_Time[2]);*/
		
			//	String set_Date=Y+"/"+M+"/"+D+" "+H+":"+MIN+":"+S;
			    String set_Date=Y+"/"+M+"/"+D;
				System.out.println("set_Date "+set_Date);
				
				
				
				
				
				
				
				
			
			/*	String split_Time[]=split_Date[1].split(":");
				System.out.println("0 "+split_Time[0]);
				int H=Integer.parseInt(split_Time[0]);
		
				System.out.println("1 "+split_Time[1]);
				int MIN=Integer.parseInt(split_Time[1]);
		
				System.out.println("2 "+split_Time[2]);
				int S=Integer.parseInt(split_Time[2]);
		
				String set_Date=Y+"/"+M+"/"+D+" "+H+":"+MIN+":"+S;
				System.out.println("set_Date "+set_Date);*/
				
		try
		{
	//		dtm.setRowCount(0);
			System.out.println("getrowcount........"+dtm.getRowCount());
		//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
							try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
									getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}
							
/////////////////////check here//////////////////////there is some problem/////////////////
				jLabel2.setText("Patient");
			String q="select prescNo from patient_Presc_Gianec where patientID="+patientID+""; //And date=#"+set_Date+"#";
			System.out.println("q    "+q);
			String presc=inf.getSingleValue(q);
			//String presc="";
			int prescNo=Integer.parseInt(presc);
			System.out.println("prescNo......"+prescNo);
			String qry="Select medicineNm,dosage,duration,days,remarks from patient_Presc_Gianec_Details where prescNo="+prescNo+"";
			System.out.println("qry "+qry);
			String loadPrescription[][]=inf.getResultSetAs_2D_Array(qry,5);
			if(loadPrescription==null)
			{
				JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				for(int i=0;i<loadPrescription.length;i++)
				{
					System.out.println("entering.....");
			
					System.out.println(i+"     "+loadPrescription[i][0]);
					System.out.println(i+"     "+loadPrescription[i][1]);
					System.out.println(i+"     "+loadPrescription[i][2]);
					System.out.println(i+"     "+loadPrescription[i][3]);
					System.out.println(i+"     "+loadPrescription[i][4]);
					System.out.println("row count ......"+dtm.getRowCount());
					dtm.addRow(loadPrescription[i]);
				}
				System.out.println("dtmrow count............"+dtm.getRowCount());
				
				/*	for(int LD=0;LD<len;LD++)
					{
						dtm.addRow(load[LD]);
					}*/
			}
			String advice=inf.getSingleValue("select advice from patient_Presc_Gianec where patientID="+patientID);
			System.out.println("advice......."+advice);
			jTextArea1.setText(advice);
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR.."+ex);
		}
		
		
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
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
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField5;
    java.util.Vector itemNmVc;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel dtm;
    int patientID;
    JDesktopPane dpp;
    String getDt;
    ZedInterface inf=null;
    public static String hold_Dt=null;
    JInternalFrame frm;
    Container cn;
}
