import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;

public class ShowProfit extends JFrame implements ActionListener,KeyListener//,MouseListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	//DefaultTableModel dtm1,dtm2;
	JTable grid,grid2,table1,table1Detail;
	JButton showBtn,printBtn,closeBtn,resetBtn;
	JLabel grossLb,tounchLb,fineLb,balAmtLab,balAmt;
	JLabel grossLb1,profitInWt,profitInPc,fineLb1;
	DefaultTableModel dtm,dtm2,model1,model1Detail;
	//JTable grid;
	JTextField dateTf,dateTf1;	
	JLabel saleGrossWtLb,saleTounchLb,saleFineWtLb,lab9,lab8,lab3,lab7,lab2,lab12;
	JLabel saleGrossWtLb2,saleTounchLb2,saleFineWtLb2;
	JRadioButton briefRb,detailRb;	
	JScrollPane jsp1Detail,jsp1;
	JDesktopPane desk;
	//JComboBox catCb;
	double avgPurchaseRate=0,avgSaleRate=0;		
	
	public ShowProfit(JDesktopPane desk)
	{
		this.desk=desk;
		frm=new JInternalFrame("REPORT : S H O W  P R O F I T  A N D  L O S S  D A T E  W I S E",false,true,false,false);
		con=frm.getContentPane();
		con.setLayout(null);
		
		JLabel lab1=new JLabel(" sale");
		lab2=new JLabel("00.000",JLabel.RIGHT);
		lab3=new JLabel("");
		JLabel lab4=new JLabel("Tounch");
		JLabel lab5=new JLabel("Fine weight (in Gm)");
		JLabel lab6=new JLabel("Enter Date :");
		lab7=new JLabel("");
		lab8=new JLabel("Profit    or    Loss    Amount");
		lab9=new JLabel("00.000",JLabel.RIGHT);
		JLabel lab10=new JLabel(" Purchase");
		JLabel lab11=new JLabel(" Profit                  or                  Loss ");
		lab12=new JLabel("00.000",JLabel.RIGHT);
		
		grossLb=new JLabel("00.000",JLabel.RIGHT);
		tounchLb=new JLabel("0",JLabel.RIGHT);
		fineLb=new JLabel("00.000",JLabel.RIGHT);
		dateTf=new JTextField();
		dateTf1=new JTextField();
		grossLb1=new JLabel("Average Purchase Rate");
		profitInWt=new JLabel("0");
		profitInPc=new JLabel("0 %");
		fineLb1=new JLabel("00.000",JLabel.RIGHT);
		saleGrossWtLb=new JLabel("00.000",JLabel.RIGHT);
		saleTounchLb=new JLabel("Average Sale Rate");
		saleFineWtLb=new JLabel("00.000",JLabel.RIGHT);
		saleGrossWtLb2=new JLabel("00.000",JLabel.RIGHT);
		saleTounchLb2=new JLabel("00.00",JLabel.RIGHT);
		saleFineWtLb2=new JLabel("00.000",JLabel.RIGHT);
		briefRb=new JRadioButton("Category wise",true);
		detailRb=new JRadioButton("Detail");
		ButtonGroup gp=new ButtonGroup();
		gp.add(briefRb);
		gp.add(detailRb);
		//catCb=new JComboBox();
		balAmtLab=new JLabel("Cash in hand (in Rs.)",JLabel.RIGHT);
		balAmt=new JLabel("0.00",JLabel.RIGHT);
		
		String title1[]={"Bill no","Date","Weight","Rate","Amount"};
		model1=new DefaultTableModel(title1,0);
		table1=new JTable(model1);
		jsp1=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
   		CRLeft.setHorizontalAlignment(JLabel.LEFT);
      	CRRight.setHorizontalAlignment(JLabel.RIGHT);
   		CRCenter.setHorizontalAlignment(JLabel.CENTER);   		
   		TableColumn column;
   		
   		
   		
   		column=table1.getColumn("Bill no");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);
   		
   		column=table1.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(150);
   		
   		column=table1.getColumn("Weight");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);

   		column=table1.getColumn("Rate");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);

   		column=table1.getColumn("Amount");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(200);

   		
   		
   		
   		
   		/*column=table1.getColumn("Bill no");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		column=table1.getColumn("Date");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(470);
   		column=table1.getColumn("Rate");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=table1.getColumn("Amount");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);*/
   		/*column=table1.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);*/

		//To show oppeing in details
		String title1Detail[]={"Bill no","Date","Rate","Amount"};
		model1Detail=new DefaultTableModel(title1Detail,0);
		table1Detail=new JTable(model1Detail);
		jsp1Detail=new JScrollPane(table1Detail,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);




		
		String heading[]={"Bill no","Date","Weight","Rate","Amount"};
		dtm=new DefaultTableModel(heading,0);
		grid=new JTable(dtm);
		JScrollPane jsp2=new JScrollPane(grid,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   		column=grid.getColumn("Bill no");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);
   		
   		column=grid.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(150);
   		
   		column=grid.getColumn("Weight");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);

   		column=grid.getColumn("Rate");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);

   		column=grid.getColumn("Amount");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(200);
   		/*column=grid.getColumn("Via");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(140);
   		column=grid.getColumn("Gross Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);*/


		//String heading2[]={"S.No.","Date","Party Name","Bill No.","Via","Gross Wt.","Tounch","Fine Wt."};
		//dtm2=new DefaultTableModel(heading2,0);
		//grid2=new JTable(dtm2);
		//JScrollPane jsp3=new JScrollPane(grid2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		/*column=grid2.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		column=grid2.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(150);
   		column=grid2.getColumn("Bill No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(100);*/
   		//
   		/*column=grid2.getColumn("Party Name");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(200);

   		//
   		column=grid2.getColumn("Via");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(140);
   		column=grid2.getColumn("Gross Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid2.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid2.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);*/

		java.util.Date dt=new java.util.Date();		
		String tmp=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		dateTf.setText(tmp);
		dateTf1.setText(tmp);
		dateTf.setHorizontalAlignment(JTextField.CENTER);
		dateTf1.setHorizontalAlignment(JTextField.CENTER);
		
		showBtn=new JButton("Show");		
		printBtn=new JButton("Print");
		resetBtn=new JButton("Reset");
		closeBtn=new JButton("Close");

		JLabel lnpan=new JLabel(" R A T E   T O   B A L A N C E   P R O F I T   O R   L O S S");
		lnpan.setBounds(10,425,800,20);
		lnpan.setOpaque(true);
		lnpan.setBackground(new Color(192,192,192));
		con.add(lnpan);
								
		lab1.setBounds(10,35,860,20);		
		//detailRb.setBounds(650+70,35,80,20);		
		//briefRb.setBounds(500+70,35,150,20);		
		//catCb.setBounds(580,35,220,20);		
		lab3.setBounds(10,455,300,20);		
		lab4.setBounds(275,57+100,140,20);		
		lab5.setBounds(535,57+100,140,20);		
		lab6.setBounds(10,10,100,20);
		lab2.setBounds(312,495,200,20);		
		lab7.setBounds(10,495,300,20);		
		lab8.setBounds(10,395,300,20);		
		lab9.setBounds(312,395,200,20);		
		lab10.setBounds(10,209,800,20);		
		lab11.setBounds(10,330,800,20);		
		lab12.setBounds(312,455,200,20);		
		dateTf.setBounds(95,10,130,20);		
		dateTf1.setBounds(240,10,130,20);		
		grossLb.setBounds(300,57+100,150,20);
		tounchLb.setBounds(620,57+100,88,20);
		fineLb.setBounds(600,57+100,190,20);	
		balAmtLab.setBounds(512,395,200,20);		
		balAmt.setBounds(712,395,100,20);		
		
		
		profitInWt.setBounds(150,520,125,20);
		profitInPc.setBounds(675,520,135,20);
		jsp1.setBounds(10,80-23,800,100);
		jsp1Detail.setBounds(10,80-23,800,100);
		jsp2.setBounds(10,230,800,100);
		//jsp3.setBounds(10,350,800,100);
		grossLb1.setBounds(20,350,160,20);
		fineLb1.setBounds(200,350,135,20);	
		saleGrossWtLb.setBounds(300,330,150,20);
		saleFineWtLb.setBounds(600,330,190,20);
		saleTounchLb.setBounds(20,177,160,20);
		saleGrossWtLb2.setBounds(200,177,135,20);
		//saleTounchLb2.setBounds(620,450,88,20);
		//saleFineWtLb2.setBounds(710,450,88,20);
		showBtn.setBounds(400,10,100,20);
		printBtn.setBounds(280,560,100,25);
		resetBtn.setBounds(390,560,100,25);
		closeBtn.setBounds(500,560,100,25);
		
		lab1.setOpaque(true);
		lab3.setOpaque(true);
		lab4.setOpaque(true);
		lab5.setOpaque(true);
		lab10.setOpaque(true);
		lab11.setOpaque(true);
		lab12.setOpaque(true);
		grossLb.setOpaque(true);
		tounchLb.setOpaque(true);
		fineLb.setOpaque(true);
		grossLb1.setOpaque(true);
		profitInWt.setOpaque(true);
		profitInPc.setOpaque(true);
		fineLb1.setOpaque(true);
		lab2.setOpaque(true);
		lab7.setOpaque(true);
		lab8.setOpaque(true);
		lab9.setOpaque(true);
		balAmtLab.setOpaque(true);
		balAmt.setOpaque(true);
		saleGrossWtLb.setOpaque(true);
		saleTounchLb.setOpaque(true);
		saleFineWtLb.setOpaque(true);
		saleGrossWtLb2.setOpaque(true);
		saleTounchLb2.setOpaque(true);
		saleFineWtLb2.setOpaque(true);
		lab3.setBackground(new Color(190,251,252));
		lab4.setBackground(new Color(190,251,252));
		lab5.setBackground(new Color(190,251,252));
		lab2.setBackground(new Color(254,171,193));
		lab7.setBackground(new Color(190,251,252));
		lab8.setBackground(new Color(190,251,252));
		lab9.setBackground(new Color(254,171,193));
		lab12.setBackground(new Color(254,171,193));
		balAmtLab.setBackground(new Color(190,251,252));
		balAmt.setBackground(new Color(254,171,193));
		
		lab1.setBackground(new Color(254,171,193));
		grossLb.setBackground(new Color(254,171,193));
		tounchLb.setBackground(new Color(254,171,193));
		fineLb.setBackground(new Color(254,171,193));
		
		grossLb1.setBackground(new Color(252,251,213));
		fineLb1.setBackground(new Color(252,251,213));
		
		profitInWt.setBackground(new Color(252,251,213));
		profitInPc.setBackground(new Color(252,251,213));
		
		lab10.setBackground(new Color(249,230,194));
		saleGrossWtLb.setBackground(new Color(249,230,194));
		saleTounchLb.setBackground(new Color(252,251,213));
		saleFineWtLb.setBackground(new Color(249,230,194));
		
		lab11.setBackground(new Color(206,215,254));
		saleGrossWtLb2.setBackground(new Color(252,251,213));
		saleTounchLb2.setBackground(new Color(206,215,254));
		saleFineWtLb2.setBackground(new Color(206,215,254));
		showBtn.setMnemonic('s');
		printBtn.setMnemonic('p');
		closeBtn.setMnemonic('c');
		resetBtn.setMnemonic('r');
		
		//addCategory();
		
		con.add(lab1);
		con.add(lab3);
		//con.add(briefRb);
		//con.add(detailRb);
		//con.add(catCb);
		//con.add(lab4);
		//con.add(lab5);
		con.add(lab6);
		con.add(lab7);
		con.add(lab2);
		con.add(lab8);
		con.add(lab9);
		con.add(lab10);
		//con.add(lab11);
		con.add(lab12);
		con.add(dateTf1);
		con.add(dateTf);
		con.add(grossLb);
		//con.add(tounchLb);
		con.add(fineLb);
		con.add(grossLb1);
		//con.add(profitInWt);
		//con.add(profitInPc);
		con.add(fineLb1);
		con.add(jsp1);
		con.add(jsp1Detail);
		con.add(jsp2);
		//con.add(jsp3);
		con.add(saleGrossWtLb);
		con.add(saleTounchLb);
		con.add(saleFineWtLb);
		con.add(saleGrossWtLb2);
		con.add(saleTounchLb2);
		con.add(saleFineWtLb2);
		con.add(showBtn);
		con.add(printBtn);
		con.add(resetBtn);
		con.add(closeBtn);
		con.add(balAmtLab);
		con.add(balAmt);
		
		//briefRb.addActionListener(this);
		//detailRb.addActionListener(this);
		//catCb.addActionListener(this);
		showBtn.addActionListener(this);
		showBtn.addKeyListener(this);
		closeBtn.addActionListener(this);
		closeBtn.addKeyListener(this);
		resetBtn.addActionListener(this);
		resetBtn.addKeyListener(this);
		dateTf1.addKeyListener(this);
		dateTf.addKeyListener(this);
		printBtn.setEnabled(false);
		grid.addKeyListener(this);
		//grid2.addKeyListener(this);
		
		desk.add(frm);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-830)/2;
		int y = (ds.height-630)/2;
   		frm.reshape(x,35,830,630);
   		frm.show();		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==closeBtn)
		{
			frm.dispose();
		}
		else if(e.getSource()==showBtn)
		{
			showData();
			//showOpeningDataInDetails();
		}
		else if(e.getSource()==resetBtn)
		{
			frm.dispose();
			new ShowRokar(desk);
		}
		else if(e.getSource()==dateTf)
		{
			showBtn.requestFocus();
		}
		/*else if(e.getSource()==briefRb)
		{
			jsp1.setVisible(true);
			jsp1Detail.setVisible(false);
		}
		else if(e.getSource()==detailRb)
		{
			jsp1Detail.setVisible(true);
			jsp1.setVisible(false);
		}*/
		/*else if(e.getSource()==catCb)
		{
			showData();
		}*/
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getSource()==closeBtn && e.getKeyCode()==10)
		{
			frm.dispose();
		}
		else if(e.getSource()==showBtn && e.getKeyCode()==10)
		{
			showData();
			//showOpeningDataInDetails();
		}
		else if(e.getSource()==resetBtn && e.getKeyCode()==10)
		{
			frm.dispose();
			new ShowProfit(desk);
		}
		else if(e.getSource()==dateTf && e.getKeyCode()==10)
		{
			dateTf1.requestFocus();
		}
		else if(e.getSource()==dateTf1 && e.getKeyCode()==10)
		{
			showBtn.requestFocus();
		}
		else if(e.getSource()==grid && e.getKeyCode()==10)
		{
			e.consume();
			if((""+grid.getValueAt(grid.getSelectedRow(),3)).equals("Purchase"))
			{
				Purchase pc=new Purchase(desk,Integer.parseInt(""+grid.getValueAt(grid.getSelectedRow(),2)));
			}
			else if((""+grid.getValueAt(grid.getSelectedRow(),3)).equals("Sale"))
			{
				Sale pc=new Sale(desk,Integer.parseInt(""+grid.getValueAt(grid.getSelectedRow(),2)));
			}
		}
		else if(e.getSource()==grid2 && e.getKeyCode()==10)
		{
			e.consume();
			if((""+grid2.getValueAt(grid2.getSelectedRow(),3)).equals("Purchase"))
			{
				Purchase pc=new Purchase(desk,Integer.parseInt(""+grid2.getValueAt(grid2.getSelectedRow(),2)));
			}
			else if((""+grid2.getValueAt(grid2.getSelectedRow(),3)).equals("Sale"))
			{
				Sale pc=new Sale(desk,Integer.parseInt(""+grid2.getValueAt(grid2.getSelectedRow(),2)));
			}
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
	       	Statement st1=cn.createStatement();
	       	Statement st2=cn.createStatement();
	       	ResultSet rs1,rs2;
	       	
	       	while(model1.getRowCount()>0)	model1.removeRow(0);
	       	while(dtm.getRowCount()>0)	dtm.removeRow(0);
	       	
			
			String tmp=dateTf.getText();
	       	String dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
				
		  	String tmp1=dateTf1.getText();
	       	String dt1=tmp1.substring(0,tmp1.indexOf('/'));
   		    tmp1=tmp1.substring(tmp1.indexOf('/')+1,tmp1.length());
   		    dt1=tmp1.substring(0,tmp1.indexOf('/'))+"/"+dt1;
   		    tmp1=tmp1.substring(tmp1.indexOf('/')+1,tmp1.length());
   		    dt1=dt1+"/"+tmp1;
			double totalSaleWt=0,totalSaleAmt=0,totalPurchaseWt=0,totalPurchaseAmt=0;
			//Sale
			rs1=st1.executeQuery("select s_date,s_s_no from sale where s_date>=#"+dt+"# and s_date<=#"+dt1+"# and t_type='s' group by s_date,s_s_no order by s_date");
			while(rs1.next())
			{
				String arr[]=new String[5];
				arr[0]=rs1.getString("s_s_no");
				arr[1]=rs1.getString("s_date");
				arr[1]=arr[1].substring(8,10)+"-"+arr[1].substring(5,7)+"-"+arr[1].substring(0,4);
				rs2=st2.executeQuery("select * from sale_x where s_s_no="+Integer.parseInt(arr[0])+" and btn1=1");
				if(rs2.next())
				{
					arr[2]=""+(new BigDecimal(rs2.getString("field10"))).setScale(3,5);
					arr[3]=rs2.getString("field9");
					arr[4]=rs2.getString("field11");
					String ratetype=rs2.getString("rate_type");
					if(ratetype.equals("Bhari"))
					{
						arr[3]=""+(new BigDecimal(""+((Double.valueOf(arr[3]))/(Double.valueOf("11.664"))))).setScale(2,5);						
					}
					else
					{
						arr[3]=""+(new BigDecimal(arr[3])).setScale(2,5);
					}
					arr[4]=""+(new BigDecimal(arr[4])).setScale(2,5);
					model1.addRow(arr);
					
					totalSaleWt+=Double.valueOf(arr[2]);
					totalSaleAmt+=Double.valueOf(arr[4]);
															
				}
			}
			grossLb.setText(""+(new BigDecimal(totalSaleWt)).setScale(3,5));
			fineLb.setText(""+(new BigDecimal(totalSaleAmt)).setScale(2,5));
			try
			{
				avgSaleRate=totalSaleAmt/totalSaleWt;
				saleGrossWtLb2.setText(""+(new BigDecimal(avgSaleRate)).setScale(2,5));
				System.out.println("avgSaleRate="+avgSaleRate);
			}
			catch(Exception x)
			{
				saleGrossWtLb2.setText(""+(new BigDecimal("0.00")).setScale(2,5));
				avgSaleRate=0;
				System.out.println("avgSaleRate="+avgSaleRate);
			}
			
			//Purchase
			rs1=st1.executeQuery("select p_date,p_s_no from purchase where p_date>=#"+dt+"# and p_date<=#"+dt1+"# and t_type='p'  group by p_date,p_s_no order by p_date");
			while(rs1.next())
			{
				String arr[]=new String[5];
				arr[0]=rs1.getString("p_s_no");
				arr[1]=rs1.getString("p_date");
				arr[1]=arr[1].substring(8,10)+"-"+arr[1].substring(5,7)+"-"+arr[1].substring(0,4);
				rs2=st2.executeQuery("select * from purchase_x where p_s_no="+Integer.parseInt(arr[0])+" and btn1=1");
				if(rs2.next())
				{
					arr[2]=""+(new BigDecimal(rs2.getString("field10"))).setScale(3,5);
					arr[3]=rs2.getString("field9");
					arr[4]=rs2.getString("field11");
					String ratetype=rs2.getString("rate_type");
					if(ratetype.equals("Bhari"))
					{
						arr[3]=""+(new BigDecimal(""+((Double.valueOf(arr[3]))/(Double.valueOf("11.664"))))).setScale(2,5);						
					}
					else
					{
						arr[3]=""+(new BigDecimal(arr[3])).setScale(2,5);
					}
					arr[4]=""+(new BigDecimal(arr[4])).setScale(2,5);
					dtm.addRow(arr);
					
					totalPurchaseWt+=Double.valueOf(arr[2]);
					totalPurchaseAmt+=Double.valueOf(arr[4]);
				}
			}
			//kharcha
			rs1=st1.executeQuery("select * from kharcha_adjustment where entry_date>=#"+dt+"# and entry_date<=#"+dt1+"#  order by entry_date");
			while(rs1.next())
			{
				String arr[]=new String[5];
				arr[0]="Kharcha";
				arr[1]=rs1.getString("entry_date");
				arr[1]=arr[1].substring(8,10)+"-"+arr[1].substring(5,7)+"-"+arr[1].substring(0,4);
				arr[2]=""+(new BigDecimal(rs1.getString("weight"))).setScale(3,5);
				
				arr[3]=rs1.getString("rate");
				arr[4]=rs1.getString("amount");
					String ratetype=rs1.getString("rate_type");
					if(ratetype.equals("Bhari"))
					{
						arr[3]=""+(new BigDecimal(""+((Double.valueOf(arr[3]))/(Double.valueOf("11.664"))))).setScale(2,5);						
					}
					else
					{
						arr[3]=""+(new BigDecimal(arr[3])).setScale(2,5);
					}
					arr[4]=""+(new BigDecimal(arr[4])).setScale(2,5);
					dtm.addRow(arr);
					
					totalPurchaseWt+=Double.valueOf(arr[2]);
					totalPurchaseAmt+=Double.valueOf(arr[4]);
				
			}
			
			saleGrossWtLb.setText(""+(new BigDecimal(totalPurchaseWt)).setScale(3,5));
			saleFineWtLb.setText(""+(new BigDecimal(totalPurchaseAmt)).setScale(2,5));
			/*try
			{
				avgPurchaseRate=totalPurchaseAmt/totalPurchaseWt;
				fineLb1.setText(""+(new BigDecimal(avgPurchaseRate)).setScale(2,5));
			}
			catch(Exception x)
			{
				saleGrossWtLb2.setText(""+(new BigDecimal("0.00")).setScale(2,5));
			}*/
			try
			{
				avgPurchaseRate=totalPurchaseAmt/totalPurchaseWt;
				fineLb1.setText(""+(new BigDecimal(avgPurchaseRate)).setScale(2,5));
				System.out.println("avgSaleRate="+avgPurchaseRate);
			}
			catch(Exception x)
			{
				fineLb1.setText(""+(new BigDecimal("0.00")).setScale(2,5));
				avgPurchaseRate=0;
				System.out.println("avgPurchaseRate="+avgPurchaseRate);
			}
			
			try
			{
				double apr=Double.valueOf(fineLb1.getText());//purchase rate
				double asr=Double.valueOf(saleGrossWtLb2.getText());//sale rate
				double purWt=Double.valueOf(saleGrossWtLb.getText());//total purchased wt
				double saleWt=Double.valueOf(grossLb.getText());//total sold wt				
				//double requiredRate=((apr*Math.abs(purWt-saleWt))+((saleWt*apr)-(saleWt*asr)))/Math.abs(purWt-saleWt);
				double requiredRate=Math.abs(totalSaleAmt-totalPurchaseAmt)/Math.abs(purWt-saleWt);
				lab2.setText(""+(new BigDecimal(requiredRate)).setScale(2,5));
				
				balAmt.setText(""+(new BigDecimal(totalSaleAmt-totalPurchaseAmt)).setScale(2,5));
			}
			catch(Exception ex)
			{
				System.out.println("Error no. 4567..."+ex);
			}
			if(avgPurchaseRate>avgSaleRate)
			{							
				if(totalPurchaseWt>totalSaleWt)
				{
					lab9.setText(""+(new BigDecimal(Math.abs(avgPurchaseRate-avgSaleRate)*Math.abs(totalSaleWt))).setScale(2,5) );				
					lab8.setText("LOSS amount on sale of "+(new BigDecimal(totalSaleWt)).setScale(3,5)+" gm (in Rs.)");
					lab3.setText("Required weight to SALE (in gm)");
					lab7.setText("Required rate for SALE (in Rs.)");
					lab12.setText(""+(new BigDecimal(totalPurchaseWt-totalSaleWt)).setScale(3,5));
				}
				if(totalPurchaseWt<totalSaleWt)
				{
					lab9.setText(""+(new BigDecimal(Math.abs(avgPurchaseRate-avgSaleRate)*Math.abs(totalPurchaseWt))).setScale(2,5) );				
					lab8.setText("LOSS amount on sale of "+(new BigDecimal(totalPurchaseWt)).setScale(3,5)+" gm (in Rs.)");				
					lab3.setText("Required weight to PURCHASE ((in gm)");
					lab7.setText("Required rate for PURCHASE (in Rs.)");
					lab12.setText(""+(new BigDecimal(totalSaleWt-totalPurchaseWt)).setScale(3,5));
				}
			}
			else
			{								
				if(totalPurchaseWt>totalSaleWt)
				{				
					lab9.setText( ""+(new BigDecimal(Math.abs(avgPurchaseRate-avgSaleRate)*Math.abs(totalSaleWt))).setScale(2,5) );
					lab8.setText("PROFIT amount on sale of "+(new BigDecimal(totalSaleWt)).setScale(3,5)+" gm (in Rs.)");
					lab3.setText("Required weight to SALE (in gm)");
					lab7.setText("Required rate for SALE (in Rs.)");
					lab12.setText(""+(new BigDecimal(totalPurchaseWt-totalSaleWt)).setScale(3,5));									
				}
				if(totalPurchaseWt<totalSaleWt)
				{
					lab9.setText( ""+(new BigDecimal(Math.abs(avgPurchaseRate-avgSaleRate)*Math.abs(totalPurchaseWt))).setScale(2,5) );
					lab8.setText("PROFIT amount on sale of "+(new BigDecimal(totalPurchaseWt)).setScale(3,5)+" gm (in Rs.)");				
					lab3.setText("Required weight to PURCHASE (in gm)");
					lab7.setText("Required rate for PURCHASE (in Rs)");
					lab12.setText(""+(new BigDecimal(totalSaleWt-totalPurchaseWt)).setScale(3,5));
				}
			}
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
	}
	/*private void showData()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	Statement st2=cn.createStatement();
	       	Statement st3=cn.createStatement();
	       	ResultSet rs1,rs2,rs3;
	       	
	       	grossLb.setText("0.00");
	       	tounchLb.setText("0");
	       	fineLb.setText("0.000");
	       	saleGrossWtLb.setText("0.000");
		    saleTounchLb.setText("0");
	    	saleFineWtLb.setText("0.000");
	       	saleGrossWtLb2.setText("0.000");
		    saleTounchLb2.setText("0");
	    	saleFineWtLb2.setText("0.000");
	       	grossLb1.setText("0.00");
	       	profitInWt.setText("0");
	       	profitInPc.setText("0");
	       	fineLb1.setText("0.000");
	       	
	       	//String category=""+catCb.getSelectedItem();	       	
	     	String tmp=dateTf.getText();
	       	String dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
		
		
		  	String tmp1=dateTf1.getText();
	       	String dt1=tmp1.substring(0,tmp1.indexOf('/'));
   		    tmp1=tmp1.substring(tmp1.indexOf('/')+1,tmp1.length());
   		    dt1=tmp1.substring(0,tmp1.indexOf('/'))+"/"+dt1;
   		    tmp1=tmp1.substring(tmp1.indexOf('/')+1,tmp1.length());
   		    dt1=dt1+"/"+tmp1;
			
						
	       	while(grid.getRowCount()>0)		dtm.removeRow(0);
			while(grid2.getRowCount()>0)	dtm2.removeRow(0);
			while(table1.getRowCount()>0)	model1.removeRow(0);
			
			double grossWt=0,fineWt=0,tnh=0;
			String qry="select categoryName from categoryList order by categoryName";
			/*if(catCb.getSelectedIndex()>0)
			{
				qry="select categoryName from categoryList where categoryName='"+category+"'";
			}
			rs3=st3.executeQuery(qry);
			while(rs3.next())
			{
				String arr[]=new String[4];
				arr[0]=""+(table1.getRowCount()+1);
				arr[1]=rs3.getString(1);
				
				//about gross weight
				//Purchase part
				double purchasedWt=0,totalFineWt=0;
				double temp=returnData("select sum(weight) from itemTransactionDetails where tranDate<#"+dt+"# and categoryName='"+arr[1]+"'");				
				temp+=returnData("select sum(wt) from purchase where t_type='p' and p_Date<#"+dt+"# and c_name='"+arr[1]+"'");
				temp+=returnData("select sum(wt) from sale where t_type='a' and s_Date<#"+dt+"# and c_name='"+arr[1]+"'");
				purchasedWt=temp;
				//Sale part
				temp-=returnData("select sum(wt),sum(tnh),sum(f_wt),count(p_s_no) from purchase where t_type='a' and p_Date<#"+dt+"# and c_name='"+arr[1]+"'");
				temp-=returnData("select sum(wt),sum(tnh),sum(f_wt),count(s_s_no) from sale where t_type='s' and s_Date<#"+dt+"# and c_name='"+arr[1]+"'");
				arr[2]=""+(new BigDecimal(temp)).setScale(3,5);
				grossWt+=temp;
				
				
				temp=returnData("select sum(fineWt) from itemTransactionDetails where tranDate<#"+dt+"# and categoryName='"+arr[1]+"'");
				temp+=returnData("select sum(f_wt) from purchase where t_type='p' and p_Date<#"+dt+"# and c_name='"+arr[1]+"'");
				temp+=returnData("select sum(f_wt) from sale where t_type='a' and s_Date<#"+dt+"# and c_name='"+arr[1]+"'");				
				totalFineWt=temp;
				//Sale part
				temp-=returnData("select sum(f_wt) from purchase where t_type='a' and p_Date<#"+dt+"# and c_name='"+arr[1]+"'");
				temp-=returnData("select sum(f_wt) from sale where t_type='s' and s_Date<#"+dt+"# and c_name='"+arr[1]+"'");
				arr[4]=""+(new BigDecimal(temp)).setScale(3,5);
				fineWt+=temp;
				
				
				System.out.println("deno2:"+arr[2]);				
				//temp=(Double.valueOf(arr[4])*100)/Double.valueOf(arr[2]);
				temp=(Double.valueOf(totalFineWt)*100)/Double.valueOf(purchasedWt);
				arr[3]=""+(new BigDecimal(temp)).setScale(2,5);
								
				model1.addRow(arr);
			}
			System.out.println("grossWt:"+grossWt);
			System.out.println("fineWt:"+fineWt);
			tnh=(fineWt*100)/grossWt;
			System.out.println("tnh:"+tnh);
			grossLb.setText(""+(new BigDecimal(grossWt)).setScale(3,5));
	       	tounchLb.setText(""+(new BigDecimal(tnh)).setScale(2,5));
	       	fineLb.setText(""+(new BigDecimal(fineWt)).setScale(3,5));
	       	
			//CODE FOR GETTING OPENING WEIGHT
	       	/*
	       	 *Purchase part
	       	 
	       	double gWt=0,fWt=0;
	       	int count=0,flag=0;	       	
	       	/*
	       	 *Sale part
	       	 
	       	double gWt1=0,tnh1=0,fWt1=0;
	       	int count1=0,flag1=0;	       	
	       	//CODE FOR GETTING TODAY'S   'IN'
			long fromDtLong=Date.parse(dt);
			long toDtLong=Date.parse(dt1);

	       	double db=0;
	       	count1=0;
	       	flag=0;
	       	gWt1=0;tnh1=0;fWt1=0;
	       	while(fromDtLong<=toDtLong)
	       	{
	       		dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
				qry="select * from sale where t_type='a' and s_Date=#"+dt+"#";
				/*if(catCb.getSelectedIndex()>0)
				{
					qry="select * from sale where t_type='a' and s_Date=#"+dt+"# and c_name='"+category+"'";
				}
	       		rs2=st2.executeQuery(qry);
		       	while(rs2.next())
		       	{
		       		System.out.print("a");
			       	String arr[]=new String[8];
			       	arr[0]=""+(grid.getRowCount()+1)+" ";
		    	   	arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		       		arr[2]=rs2.getString("p_name");
		       		arr[3]=rs2.getString("s_s_no");
		       		arr[4]="Sale";
	       		
		       		db=rs2.getDouble("wt");
	    	   		gWt1=gWt1+db;
	       			arr[5]=""+(new BigDecimal(db)).setScale(3,5);
	       		
	       			db=rs2.getDouble("tnh");
		       		tnh1=tnh1+db;
		       		arr[6]=""+(new BigDecimal(db)).setScale(2,5);
	    	   		
	       			db=rs2.getDouble("f_wt");
	       			fWt1=fWt1+db;
		       		arr[7]=""+(new BigDecimal(db)).setScale(3,5);
	       		
		       		count1++;
	    	   		flag1=1;	       		
	       			dtm.addRow(arr);
	       		}
	       		
				qry="select * from purchase where t_type='p' and p_Date=#"+dt+"#";
				/*if(catCb.getSelectedIndex()>0)
				{
					qry="select * from purchase where t_type='p' and p_Date=#"+dt+"# and c_name='"+category+"'";
				}
	       		rs2=st2.executeQuery(qry);
	       		while(rs2.next())
	       		{
		       		System.out.print("b");
			       	String arr[]=new String[8];
			       	arr[0]=""+(grid.getRowCount()+1)+" ";
		    	   	arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		       		arr[2]=rs2.getString("p_name");
		       		arr[3]=rs2.getString("p_s_no");
		       		arr[4]="Purchase";
	       		
		       		db=rs2.getDouble("wt");
	    	   		gWt1=gWt1+db;
	       			arr[5]=""+(new BigDecimal(db)).setScale(3,5);
	       		
	       			db=rs2.getDouble("tnh");
		       		tnh1=tnh1+db;
		       		arr[6]=""+(new BigDecimal(db)).setScale(2,5);
	       		
	    	   		db=rs2.getDouble("f_wt");
	       			fWt1=fWt1+db;
	       			arr[7]=""+(new BigDecimal(db)).setScale(3,5);
	       		
		       		count1++;
		       		flag1=1;	       		
	    	   		dtm.addRow(arr);
	       		}
	       		
	       		fromDtLong+=86400000;
	       	}
	       	if(flag1==1)
	       	{
	       		System.out.println("tnh1="+tnh1);
	       		System.out.println("count1="+count1);
	       		
	       		//tnh1=tnh1/count1;
		       	saleGrossWtLb.setText(""+(new BigDecimal(gWt1)).setScale(3,5));
		       	//saleTounchLb.setText(""+(new BigDecimal(tnh1)).setScale(2,5));
	    	   	saleFineWtLb.setText(""+(new BigDecimal(fWt1)).setScale(3,5));
				
				System.out.println("deno4:"+gWt1);
				tnh1=(fWt1*100)/gWt1;
				saleTounchLb.setText(""+(new BigDecimal(tnh1)).setScale(2,5));
	       	}
	       	
	       	
	       	//CODE FOR GETTING TODAY'S  'OUT'
	       	db=0;
	       	count1=0;
	       	flag=0;
	       	gWt1=0;tnh1=0;fWt1=0;
			
			tmp=dateTf.getText();
	       	dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
	       	fromDtLong=Date.parse(dt);
			
	       	while(fromDtLong<=toDtLong)
	       	{
	       		dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
	       	
				qry="select * from sale where t_type='s' and s_Date=#"+dt+"#";
				/*if(catCb.getSelectedIndex()>0)
				{
					qry="select * from sale where t_type='s' and s_Date=#"+dt+"# and c_name='"+category+"'";
				}
	       		rs2=st2.executeQuery(qry);
	       		while(rs2.next())
	       		{
			       	String arr[]=new String[8];
			       	arr[0]=""+(grid2.getRowCount()+1)+" ";
			       	arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		    	   	
		    	   	arr[2]=rs2.getString("p_name");
		    	   	arr[3]=rs2.getString("s_s_no");
	       			arr[4]="Sale";
	       		
		       		db=rs2.getDouble("wt");
		       		gWt1=gWt1+db;
	    	   		arr[5]=""+(new BigDecimal(db)).setScale(3,5);
	       		
	       			db=rs2.getDouble("tnh");
	       			tnh1=tnh1+db;
		       		arr[6]=""+(new BigDecimal(db)).setScale(2,5);
	       		
		       		db=rs2.getDouble("f_wt");
	    	   		fWt1=fWt1+db;
	       			arr[7]=""+(new BigDecimal(db)).setScale(3,5);
	       		
	       			count1++;
		       		flag1=1;	       		
		       		dtm2.addRow(arr);
	       		}
	       		
				qry="select * from purchase where t_type='a' and p_Date=#"+dt+"#";
				/*if(catCb.getSelectedIndex()>0)
				{
					qry="select * from purchase where t_type='a' and p_Date=#"+dt+"# and c_name='"+category+"'";
				}
	       		rs2=st2.executeQuery(qry);
	       		while(rs2.next())
	       		{
		       		System.out.print("c");
			       	String arr[]=new String[8];
			       	arr[0]=""+(grid2.getRowCount()+1)+" ";
		    	   	arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		       		arr[2]=rs2.getString("p_name");
		       		arr[3]=rs2.getString("p_s_no");
		       		arr[4]="Purchase";
	       		
		       		db=rs2.getDouble("wt");
	    	   		gWt1=gWt1+db;
	       			arr[5]=""+(new BigDecimal(db)).setScale(3,5);
	       		
	       			db=rs2.getDouble("tnh");
		       		tnh1=tnh1+db;
		       		arr[6]=""+(new BigDecimal(db)).setScale(2,5);
	       		
	    	   		db=rs2.getDouble("f_wt");
	       			fWt1=fWt1+db;
	       			arr[7]=""+(new BigDecimal(db)).setScale(3,5);
	       		
		       		count1++;
		       		flag1=1;	       		
	    	   		dtm2.addRow(arr);
	       		}
	       		
	       		fromDtLong+=86400000;
	       	}
	       	if(flag1==1)
	       	{
	       		
	       		//tnh1=tnh1/count1;
		       	saleGrossWtLb2.setText(""+(new BigDecimal(gWt1)).setScale(3,5));
		       	//saleTounchLb2.setText(""+(new BigDecimal(tnh1)).setScale(2,5));
	    	   	saleFineWtLb2.setText(""+(new BigDecimal(fWt1)).setScale(3,5));
	    	   	
	    	   	System.out.println("deno5:"+gWt1);
	    	   	if(gWt1!=0)
	    	   	tnh1=(fWt1*100)/gWt1;
	    	   	
				saleTounchLb2.setText(""+(new BigDecimal(tnh1)).setScale(2,5));
	       	}
       	
	       	grossLb1.setText(""+(new BigDecimal(Double.valueOf(grossLb.getText())+Double.valueOf(saleGrossWtLb.getText())-Double.valueOf(saleGrossWtLb2.getText()))).setScale(3,5));
	       	fineLb1.setText(""+(new BigDecimal(Double.valueOf(fineLb.getText())+Double.valueOf(saleFineWtLb.getText())-Double.valueOf(saleFineWtLb2.getText()))).setScale(3,5));
	       	if(!saleGrossWtLb2.getText().equals("0.000"))	       	
	       		calculateProfit();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
	}*/
	
	/*private double returnData(String query)
	{		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	ResultSet rs1;
	       	rs1=st1.executeQuery(query);
	       	if(rs1.next())
	       	{
	       		double db=rs1.getDouble(1);
	       		cn.close();
	       		return db;
	       	}
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457912..."+x);
		}
		return 0;
	}*/	       		
	
	
	/*private void addCategory()
	{		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	ResultSet rs1;
	       	//catCb.addItem("All Category");
	       	rs1=st1.executeQuery("select * from categoryList order by categoryName");
	       	while(rs1.next())
	       	{
	       		//catCb.addItem(rs1.getString("categoryName"));
	       	}
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457912..."+x);
		}
	}*/	       		
	
	/*private void showOpeningDataInDetails()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	Statement st2=cn.createStatement();
	       	Statement st3=cn.createStatement();
	       	ResultSet rs1,rs2,rs3;
	       	
	       	String tmp=dateTf.getText();
	       	String dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
			
	       	while(table1Detail.getRowCount()>0)	model1Detail.removeRow(0);
			
			double grossWt=0,fineWt=0,tnh=0;
			rs3=st3.executeQuery("select categoryName from categoryList order by categoryName");
			while(rs3.next())
			{
				String arr[]=new String[6];
				arr[0]=""+(table1Detail.getRowCount()+1);
				arr[1]=rs3.getString(1);
				
				rs1=st1.executeQuery("select itemName from itemTransactionDetails where categoryName='"+arr[1]+"' order by itemName");
				while(rs1.next())
				{
					arr[2]=rs1.getString(1);
				
					//about gross weight				
					//Purchase part
					double purchasedWt=0,totalFineWt=0;				
					double temp=returnData("select sum(weight) from itemTransactionDetails where tranDate<#"+dt+"# and categoryName='"+arr[1]+"' and itemName='"+arr[2]+"'");				
					temp+=returnData("select sum(wt) from purchase where t_type='p' and p_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					temp+=returnData("select sum(wt) from sale where t_type='a' and s_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					purchasedWt=temp;
					//Sale part
					temp-=returnData("select sum(wt) from purchase where t_type='a' and p_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					temp-=returnData("select sum(wt) from sale where t_type='s' and s_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					arr[3]=""+(new BigDecimal(temp)).setScale(3,5);
					//grossWt+=temp;
				
					temp=returnData("select sum(tounch) from itemTransactionDetails where tranDate<#"+dt+"# and categoryName='"+arr[1]+"' and itemName='"+arr[2]+"'");
					temp+=returnData("select sum(tnh) from purchase where t_type='p' and p_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					temp+=returnData("select sum(tnh) from sale where t_type='a' and s_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					//Sale part
					//temp-=returnData("select sum(tnh) from purchase where t_type='a' and p_Date<#"+dt+"# and c_name='"+arr[1]+"'");
					//temp-=returnData("select sum(tnh) from sale where t_type='s' and s_Date<#"+dt+"# and c_name='"+arr[1]+"'");
					//arr[4]=""+(new BigDecimal(temp)).setScale(3,5);
					//tnh+=temp;
				
					temp=returnData("select sum(fineWt) from itemTransactionDetails where tranDate<#"+dt+"# and categoryName='"+arr[1]+"' and itemName='"+arr[2]+"'");
					temp+=returnData("select sum(f_wt) from purchase where t_type='p' and p_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					temp+=returnData("select sum(f_wt) from sale where t_type='a' and s_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					totalFineWt=temp;
					//Sale part
					temp-=returnData("select sum(f_wt) from purchase where t_type='a' and p_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					temp-=returnData("select sum(f_wt) from sale where t_type='s' and s_Date<#"+dt+"# and c_name='"+arr[1]+"' and i_Name='"+arr[2]+"'");
					arr[5]=""+(new BigDecimal(temp)).setScale(3,5);
					//fineWt+=temp;
					System.out.println("deno1:"+arr[3]);
					if(Double.valueOf(arr[3])!=0)
					temp=(Double.valueOf(totalFineWt)*100)/Double.valueOf(purchasedWt);
					//temp=(Double.valueOf(arr[5])*100)/Double.valueOf(arr[3]);
					arr[4]=""+(new BigDecimal(temp)).setScale(2,5);
							
					model1Detail.addRow(arr);
				}	
			}
		}	
		catch(Exception x)
		{
			System.out.println("Error...4590..."+x);
		}
	}	
	private void calculateProfit()
	{
		double tnh=Double.valueOf(tounchLb.getText());
		double gwt=Double.valueOf(grossLb1.getText());
		double fwt=Double.valueOf(fineLb1.getText());
		
		double canFineWt=Double.valueOf(""+(new BigDecimal((gwt*tnh)/100)).setScale(3,5));
		double profitWt=fwt-canFineWt;
		profitInWt.setText(""+(new BigDecimal(profitWt)).setScale(3,5));
		
		//in percentage
		double profitPc=(100*profitWt)/fwt;
		profitInPc.setText(""+(new BigDecimal(profitPc)).setScale(2,5));
		
	}*/
}	