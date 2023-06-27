import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

public class ShowPartyBalance extends JFrame implements ActionListener,KeyListener//,MouseListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	DefaultTableModel dtm1;
	JTable grid1;
	JButton printBtn,closeBtn,resetBtn;
	JLabel wtLb,amtLb,l1,l2,l3,chose;
	JRadioButton r1,r2,r3;
	JPanel pan1;
	ButtonGroup bg;
	JDesktopPane desk;
	public ShowPartyBalance(JDesktopPane desk)
	{
		this.desk=desk;
		frm=new JInternalFrame("REPORT : SHOW PARTY'S CLOSING BALANCE",false,true,false,false);
		//frm=new JDialog(new Frame(),"Add New Party",true);
		con=frm.getContentPane();
		con.setLayout(null);
		
		wtLb=new JLabel("0.000",JLabel.RIGHT);
		amtLb=new JLabel("0.00",JLabel.RIGHT);
		printBtn=new JButton("Print");
		resetBtn=new JButton("Reset");
		closeBtn=new JButton("Close");
		
		
		r1=new JRadioButton("All",true);						
		
		r2=new JRadioButton("Sell",false);						
		r3=new JRadioButton("Purchase",false);					
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		
		chose=new JLabel("Choose  Category");
		chose.setBounds(20,15,100,20);
		pan1=new JPanel();
		pan1.setBounds(150,10,300,25);
		pan1.add(r1);
		pan1.add(r2);
		pan1.add(r3);
		
		String heading1[]={"Party Name","Weight(in gm)","Amount(in Rs.)"};
		dtm1=new DefaultTableModel(heading1,0);
		grid1=new JTable(dtm1);
		JScrollPane jsp1=new JScrollPane(grid1);
		
		printBtn.setMnemonic('p');
		closeBtn.setMnemonic('c');
		resetBtn.setMnemonic('r');
		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
   		CRLeft.setHorizontalAlignment(JLabel.LEFT);
      	CRRight.setHorizontalAlignment(JLabel.RIGHT);
   		CRCenter.setHorizontalAlignment(JLabel.CENTER);   		
   		TableColumn column;
   		column=grid1.getColumn("Party Name");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(370);
		column=grid1.getColumn("Weight(in gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(200);
   		column=grid1.getColumn("Amount(in Rs.)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(200);
   		
   		wtLb.setOpaque(true);
		amtLb.setOpaque(true);
		wtLb.setBackground(new Color(205,253,113));
		amtLb.setBackground(new Color(113,195,253));
		grid1.setEnabled(false);
		grid1.setSelectionBackground(new Color(255,157,157));
				
								
		jsp1.setBounds(10,60,770,470);		
		wtLb.setBounds(380,540,200,20);		
		amtLb.setBounds(582,540,198,20);		
		printBtn.setBounds(280,570,100,25);
		resetBtn.setBounds(390,570,100,25);
		closeBtn.setBounds(500,570,100,25);
		
		con.add(wtLb);
		con.add(amtLb);
		con.add(printBtn);
		con.add(resetBtn);
		con.add(closeBtn);
		con.add(jsp1);
		con.add(pan1);
		con.add(chose);
		
		closeBtn.addActionListener(this);
		closeBtn.addKeyListener(this);
		resetBtn.addActionListener(this);
		resetBtn.addKeyListener(this);
		//printBtn.setEnabled(false);
		printBtn.addActionListener(this);
		
		desk.add(frm);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-800)/2;
		int y = (ds.height-610)/2;
   		frm.reshape(x,35,800,650);
   		frm.show();
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		showData();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==closeBtn)
		{
			frm.dispose();
		}
		else if(e.getSource()==printBtn)
		{
			printchallan pb=new printchallan(desk);
		}
		else if(e.getSource()==resetBtn)
		{
			showData();
		}
		else if(e.getSource()==r1)
		{
			showData();
		}
		else if(e.getSource()==r2)
		{
			showData1();
		}
		else if(e.getSource()==r3)
		{
			showData2();
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getSource()==closeBtn && e.getKeyCode()==10)
		{
			frm.dispose();
		}
		else if(e.getSource()==resetBtn && e.getKeyCode()==10)
		{
			showData();
		}
	}
	public void keyReleased(KeyEvent ke)
	{
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	private void showData()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st=cn.createStatement();
	       	while(grid1.getRowCount()>0)		dtm1.removeRow(0);
	        
  		    
			BigDecimal amtDb=new BigDecimal("0.00");
			BigDecimal wtDb=new BigDecimal("0.00");
			
				double er=0;
				System.out.println("..............Dhananjay Tiwari..........BBBBBBBBBBB2.0000000000ererere>>>>>="+er);
			//System.out.println("select slx.field11,slx.jama,slx.s_s_no,sl.p_name from sale sl,sale_x slx where slx.s_s_no=sl.s_s_no and sl.s_date=#"+dt+"#");
            ResultSet rs1=st.executeQuery("select * from partyDetails order by partyName");				
			while(rs1.next())			
			{
				String arr[]=new String[3];
				arr[0]=rs1.getString("partyName");	//party name
				
				System.out.println("..............Dhananjay Tiwari..........1==="+arr[0]);
				double wtdb=Double.valueOf(""+rs1.getString("currentWt"));
				System.out.println("..............Dhananjay Tiwari..........2.1.1.1.=>>>>>>>>>="+er);
				 er=er+wtdb;
				System.out.println("..............Dhananjay Tiwari..........2=>>>>>>>>>="+er);
				//arr[1]=""+(new BigDecimal(wtdb)).setScale(3,5);		//weight
				if(rs1.getString("p_type").equals("s"))
				{
					if(wtdb>0)
					{					
						arr[1]=""+(new BigDecimal(Math.abs(wtdb))).setScale(3,5)+" Dr";					
					}	
					else
					{
						arr[1]=""+(new BigDecimal(Math.abs(wtdb))).setScale(3,5)+" Cr";	
					}	
				}
				else
				{
					if(wtdb>0)
					{					
						arr[1]=""+(new BigDecimal(Math.abs(wtdb))).setScale(3,5)+" Cr";					
						//wtdb=-wtdb;
					}	
					else
					{
						arr[1]=""+(new BigDecimal(Math.abs(wtdb))).setScale(3,5)+" Dr";	
						//wtdb=-wtdb;
					}
					wtdb=-wtdb;	
				}
				System.out.println("varanasi....................1="+wtdb);
				
				wtDb=wtDb.add(new BigDecimal(wtdb));
				//System.out.println("..............Dhananjay Tiwari..........3");
				
				double db=Double.valueOf(""+rs1.getString("currentAmt"));   //amount	
					
				//	System.out.println("..............Dhananjay Tiwari..........4");
				amtDb=amtDb.add(new BigDecimal(db));
				//System.out.println("..............Dhananjay Tiwari..........4.1");
				if(db>0)
				{					
					//System.out.println("..............Dhananjay Tiwari..........4.2.1");
					arr[2]=""+(new BigDecimal(Math.abs(db))).setScale(2,5)+" Cr";					
				}	
				else
				{
					//System.out.println("..............Dhananjay Tiwari..........4.2.2");
					arr[2]=""+(new BigDecimal(Math.abs(db))).setScale(2,5)+" Dr";	
				}	
				//if(wtdb!=0 && db!=0)
				{
					if(wtdb==0)		arr[1]="";
					if(db==0)		arr[2]="";					
					if(wtdb==0 && db==0)
					{
					}
					else
						dtm1.addRow(arr);
				}
			//	System.out.println("..............Dhananjay Tiwari..........4.3");					
			}
			//System.out.println("..............Dhananjay Tiwari..........5");
			//wtLb.setText(""+wtDb.setScale(3,5));
			System.out.println("..............Dhananjay Tiwari..........6=============="+wtDb);
			if(Double.valueOf(""+wtDb)>0)
			{
				wtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+wtDb.setScale(2,5))))).setScale(2,5)+" Dr");
			}
			else	
			{
				wtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+wtDb.setScale(2,5))))).setScale(2,5)+" Cr");
			}
			if(Double.valueOf(""+amtDb)>0)
			{
				amtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+amtDb.setScale(2,5))))).setScale(2,5)+" Cr");
			}
			else	
			{
				amtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+amtDb.setScale(2,5))))).setScale(2,5)+" Dr");
			}	
			
			//System.out.println("..............Dhananjay Tiwari..........7");
			String str="";
			//	System.out.println("Error...457done........................................1");
			for(int i=0;i<grid1.getRowCount();i++)
			{
				str=""+grid1.getValueAt(i,1);
				try
				{
					str=str.substring(str.length()-2,str.length());
				//	System.out.println("Error...457done........................................2");
					if(str.equals("Dr"))
						grid1.addRowSelectionInterval(i,i);							
				}
				catch(Exception x){}

				str=""+grid1.getValueAt(i,2);
				//System.out.println("Error...457done........................................3");
				try
				{
					str=str.substring(str.length()-2,str.length());
					if(str.equals("Dr"))
						grid1.addRowSelectionInterval(i,i);
						//System.out.println("Error...457done........................................4");							
				}
				catch(Exception x){}
			}
		}	
		catch(Exception x)
		{
			System.out.println("Error...457doneB..."+x);
		}
	}
	
	
	
	
	
	
	private void showData1()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st=cn.createStatement();
	       	while(grid1.getRowCount()>0)		dtm1.removeRow(0);
	        
  		    
			BigDecimal amtDb=new BigDecimal("0.00");
			BigDecimal wtDb=new BigDecimal("0.00");
			
				
			//System.out.println("select slx.field11,slx.jama,slx.s_s_no,sl.p_name from sale sl,sale_x slx where slx.s_s_no=sl.s_s_no and sl.s_date=#"+dt+"#");
            ResultSet rs1=st.executeQuery("select * from partyDetails where p_type='s' order by partyName ");				
			while(rs1.next())			
			{
				String arr[]=new String[3];
				arr[0]=rs1.getString("partyName");	//party name
				
				double wtdb=rs1.getDouble("currentWt");
				//arr[1]=""+(new BigDecimal(wtdb)).setScale(3,5);		//weight
				if(wtdb>0)
				{					
					arr[1]=""+(new BigDecimal(Math.abs(wtdb))).setScale(3,5)+" Dr";					
				}	
				else
				{
					arr[1]=""+(new BigDecimal(Math.abs(wtdb))).setScale(3,5)+" Cr";	
				}	
				wtDb=wtDb.add(new BigDecimal(wtdb));
				
				
				double db=rs1.getDouble("currentAmt");		//amount
				amtDb=amtDb.add(new BigDecimal(db));
				if(db>0)
				{					
					arr[2]=""+(new BigDecimal(Math.abs(db))).setScale(2,5)+" Cr";					
				}	
				else
				{
					arr[2]=""+(new BigDecimal(Math.abs(db))).setScale(2,5)+" Dr";	
				}	
				//if(wtdb!=0 && db!=0)
				{
					if(wtdb==0)		arr[1]="";
					if(db==0)		arr[2]="";					
					if(wtdb==0 && db==0)
					{
					}
					else
						dtm1.addRow(arr);
				}					
			}
			//wtLb.setText(""+wtDb.setScale(3,5));
			if(Double.valueOf(""+wtDb)>0)
			{
				wtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+wtDb.setScale(2,5))))).setScale(2,5)+" Dr");
			}
			else	
			{
				wtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+wtDb.setScale(2,5))))).setScale(2,5)+" Cr");
			}
				
			if(Double.valueOf(""+amtDb)>0)
			{
				amtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+amtDb.setScale(2,5))))).setScale(2,5)+" Cr");
			}
			else	
			{
				amtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+amtDb.setScale(2,5))))).setScale(2,5)+" Dr");
			}	
			
			String str="";
			for(int i=0;i<grid1.getRowCount();i++)
			{
				str=""+grid1.getValueAt(i,1);
				try
				{
					str=str.substring(str.length()-2,str.length());
					if(str.equals("Dr"))
						grid1.addRowSelectionInterval(i,i);							
				}
				catch(Exception x){}

				str=""+grid1.getValueAt(i,2);
				try
				{
					str=str.substring(str.length()-2,str.length());
					if(str.equals("Dr"))
						grid1.addRowSelectionInterval(i,i);							
				}
				catch(Exception x){}
			}
		}	
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
	}
	
	
	
	
	
	private void showData2()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st=cn.createStatement();
	       	while(grid1.getRowCount()>0)		dtm1.removeRow(0);
	        
  		    
			BigDecimal amtDb=new BigDecimal("0.00");
			BigDecimal wtDb=new BigDecimal("0.00");
			
				
			//System.out.println("select slx.field11,slx.jama,slx.s_s_no,sl.p_name from sale sl,sale_x slx where slx.s_s_no=sl.s_s_no and sl.s_date=#"+dt+"#");
            ResultSet rs1=st.executeQuery("select * from partyDetails  where p_type='p' order by partyName ");				
			while(rs1.next())			
			{
				String arr[]=new String[3];
				arr[0]=rs1.getString("partyName");	//party name
				
				double wtdb=rs1.getDouble("currentWt");
				//arr[1]=""+(new BigDecimal(wtdb)).setScale(3,5);		//weight
				if(wtdb>0)
				{					
					arr[1]=""+(new BigDecimal(Math.abs(wtdb))).setScale(3,5)+" Cr";					
				}	
				else
				{
					arr[1]=""+(new BigDecimal(Math.abs(wtdb))).setScale(3,5)+" Dr";	
				}	
				wtDb=wtDb.add(new BigDecimal(wtdb));
				
				
				double db=rs1.getDouble("currentAmt");		//amount
				amtDb=amtDb.add(new BigDecimal(db));
				if(db>0)
				{					
					arr[2]=""+(new BigDecimal(Math.abs(db))).setScale(2,5)+" Cr";					
				}	
				else
				{
					arr[2]=""+(new BigDecimal(Math.abs(db))).setScale(2,5)+" Dr";	
				}	
				//if(wtdb!=0 && db!=0)
				{
					if(wtdb==0)		arr[1]="";
					if(db==0)		arr[2]="";					
					if(wtdb==0 && db==0)
					{
					}
					else
						dtm1.addRow(arr);
				}					
			}
			//wtLb.setText(""+wtDb.setScale(3,5));
			
			if(Double.valueOf(""+wtDb)>0)
			{
				wtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+wtDb.setScale(2,5))))).setScale(2,5)+" Cr");
			}
			else	
			{
				wtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+wtDb.setScale(2,5))))).setScale(2,5)+" Dr");
			}
			if(Double.valueOf(""+amtDb)>0)
			{
				amtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+amtDb.setScale(2,5))))).setScale(2,5)+" Cr");
			}
			else	
			{
				amtLb.setText(""+(new BigDecimal(Math.abs(Double.valueOf(""+amtDb.setScale(2,5))))).setScale(2,5)+" Dr");
			}	
			
			String str="";
			for(int i=0;i<grid1.getRowCount();i++)
			{
				str=""+grid1.getValueAt(i,1);
				try
				{
					str=str.substring(str.length()-2,str.length());
					if(str.equals("Dr"))
						grid1.addRowSelectionInterval(i,i);							
				}
				catch(Exception x){}

				str=""+grid1.getValueAt(i,2);
				try
				{
					str=str.substring(str.length()-2,str.length());
					if(str.equals("Dr"))
						grid1.addRowSelectionInterval(i,i);							
				}
				catch(Exception x){}
			}
		}	
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
	}
	
	
	
	int currentpg,totalpg,noOfPages;
	boolean firsttime=false;
	boolean complete=false;
	int startIndex;
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
                                double width=4.40 * 72;
                                double height=(4.5 * 72);
                                
                                /*double width=8.27 * 72;
                                double height=(11.69 * 72);
                                */
                                Paper paper=new Paper();                                
                                paper.setSize(width,height);

                                PageFormat page=new PageFormat();
                                paper.setImageableArea(30,10,paper.getWidth(),paper.getHeight());
                                //page.setOrientation(PageFormat.LANDSCAPE);
                                page.setPaper(paper);
                                pageFormat=printJob.defaultPage(page);
                                pageFormat.setPaper(paper);
                                printJob.setPrintable(canvas,pageFormat);
								
                                try
                                {
                                	int noOfRows=grid1.getRowCount();
                                	noOfPages=noOfRows/22;
                                	if(noOfRows%22!=0)	noOfPages++;
                                	startIndex=1;
                                	currentpg=0;
                                	for(int i=1;i<=noOfPages;i++)
									{
											printJob.print();
											currentpg++;
									}
								}	
                                catch(Exception exception)
                                {
                                        JOptionPane.showMessageDialog(this,exception);
                                }
        		 }
	}

	class PrintPanel extends JPanel implements Printable
	{
        int page=100;
		TextLayout layout;
		//Font f,f1,f2,f3,f4,f5,f6;
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
			
            context=g2.getFontRenderContext();
            Font fb11,fp11,fb10,fp10,fb9,fp9,fb8,fp8,fp7;
            fb11=new Font("Times New Roman",Font.BOLD,11);
            fp11=new Font("Times New Roman",Font.PLAIN,11);
            fb10=new Font("Arial",Font.BOLD,10	);
            fp10=new Font("Arial",Font.PLAIN,10);
            fb9=new Font("Arial",Font.BOLD,9);
            fp9=new Font("Arial",Font.PLAIN,9);
            fb8=new Font("Arial",Font.BOLD,8);
            fp8=new Font("Arial",Font.PLAIN,8);
            fp7=new Font("Arial",Font.PLAIN,7);
            
            FontMetrics fm;
            GeneralPath clipShape=new GeneralPath();

            String str=" fdfg dfg dfg";
            String str1="d fgf dgdfg df";                                        
            layout=new TextLayout(str,fp11,context);
            AffineTransform transform=AffineTransform.getTranslateInstance(10,20);
			
			if(firsttime==false)
			{
				firsttime=true;
			}
			else
			{			
		        try
        		{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
		  	    	Statement st=cn.createStatement();
                   	ResultSet rs;
                            	 
					int top=10;
        			int left=10;
        			int flag=0;
        			g2.setFont(fp8);
		            fm=g2.getFontMetrics();				
		            String temp="";
		            
		            temp="Category : ";
		            g2.drawString(temp,10,top);
		            if(r1.isSelected())	temp="All";
		            else if(r2.isSelected())	temp="Sale";
		            else if(r3.isSelected())	temp="Purchase";
		            
		            g2.setFont(fb8);
		            g2.drawString(temp,fm.stringWidth("Category : ")+20,top);

					top+=5;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,300,top);
					top+=13;
		            g2.setFont(fp8);
		            temp=" Party Name                                                              Wt.                    Amt.";
		            g2.drawString(temp,10,top);
		            top+=7;
		            g2.setFont(fb11);
					g2.drawLine(left,top,300,top);
					
		            
		            
		            g2.setFont(fp8);		   
		            fm=g2.getFontMetrics();         
		            top+=10;
		            int lastIndex=0;
		            if((currentpg+1)==noOfPages)
		            	lastIndex=grid1.getRowCount();
		            else
		            	lastIndex=(currentpg*22)+22;
		            	
		            for(int i=22*currentpg;i<lastIndex;i++)
		            {
		            	temp=""+grid1.getValueAt(i,0);
		            	g2.drawString(temp,10,top);
		            	
		            	temp=""+grid1.getValueAt(i,2);
		            	g2.drawString(temp,(290-fm.stringWidth(temp)),top);
		            	
		            	temp=""+grid1.getValueAt(i,1);
		            	g2.drawString(temp,(220-fm.stringWidth(temp)),top);
		            	
		            	top+=12;
		            }
		            
        		    top-=5;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,300,top);
					
					top+=12;
					g2.setFont(fp8);
					fm=g2.getFontMetrics();
					temp=""+"("+(currentpg+1)+"/"+noOfPages+")";
	            	g2.drawString(temp,(290-fm.stringWidth(temp))/2,top);
                                	
		            if((currentpg+1)==noOfPages)
	    	    	{
	    	    		
	    	    	}	
         		}
         		catch(Exception x)
         		{
	        		System.out.println("BPError2193821..."+x);
         		}
         	}
      	}
	}
	
	
	
}	