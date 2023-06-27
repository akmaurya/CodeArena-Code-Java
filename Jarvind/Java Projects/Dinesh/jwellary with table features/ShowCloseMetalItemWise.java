import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;

public class ShowCloseMetalItemWise extends JFrame implements ActionListener,KeyListener//,MouseListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	//DefaultTableModel dtm1,dtm2;
	JTable grid,grid2,table1,table1Detail;
	JButton showBtn,printBtn,closeBtn,resetBtn;
	JLabel grossLb,tounchLb,fineLb;
	JLabel grossLb1,profitInWt,profitInPc,fineLb1;
	DefaultTableModel dtm,dtm2,model1,model1Detail;
	//JTable grid;
	JTextField dateTf,dateTf1;	
	JLabel saleGrossWtLb,saleTounchLb,saleFineWtLb;
	JLabel saleGrossWtLb2,saleTounchLb2,saleFineWtLb2;
	JRadioButton briefRb,detailRb;	
	JScrollPane jsp1Detail,jsp1;
	JDesktopPane desk;
	JComboBox itemCb;
		
	public ShowCloseMetalItemWise(JDesktopPane desk)
	{
		this.desk=desk;
		frm=new JInternalFrame("REPORT : SHOW CLOSING OF METAL ITEM WISE",false,true,false,false);
		con=frm.getContentPane();
		con.setLayout(null);
		
		JLabel lab1=new JLabel(" Opening");
		JLabel lab2=new JLabel(" Closing");
		JLabel lab3=new JLabel("Gross weight (in Gm)");
		JLabel lab4=new JLabel("Tounch");
		JLabel lab5=new JLabel("Fine weight (in Gm)");
		JLabel lab6=new JLabel("Enter Date :");
		JLabel lab7=new JLabel("Gross weight (in Gm)");
		JLabel lab8=new JLabel("Profit (in Gm)");
		JLabel lab9=new JLabel("Fine weight (in Gm)");
		JLabel lab10=new JLabel(" In");
		JLabel lab11=new JLabel(" Out");
		JLabel lab12=new JLabel("Profit (in %)");
		JLabel lab13=new JLabel("Gross Wt. (in Gm)");
		JLabel lab14=new JLabel("Tounch");
		JLabel lab15=new JLabel("Fine Wt. (in Gm)");
		
		grossLb=new JLabel("0.000",JLabel.CENTER);
		tounchLb=new JLabel("0",JLabel.CENTER);
		fineLb=new JLabel("0.000",JLabel.CENTER);
		dateTf=new JTextField();
		dateTf1=new JTextField();
		grossLb1=new JLabel("0.000");
		profitInWt=new JLabel("0");
		profitInPc=new JLabel("0 %");
		fineLb1=new JLabel("0.000");
		saleGrossWtLb=new JLabel("0.000",JLabel.RIGHT);
		saleTounchLb=new JLabel("0.00",JLabel.RIGHT);
		saleFineWtLb=new JLabel("0.000",JLabel.RIGHT);
		saleGrossWtLb2=new JLabel("0.000",JLabel.RIGHT);
		saleTounchLb2=new JLabel("0.00",JLabel.RIGHT);
		saleFineWtLb2=new JLabel("0.000",JLabel.RIGHT);
		briefRb=new JRadioButton("Category wise",true);
		detailRb=new JRadioButton("Detail");
		ButtonGroup gp=new ButtonGroup();
		gp.add(briefRb);
		gp.add(detailRb);
		itemCb=new JComboBox();
		
		String title1[]={"S.No.","Category","Gross Wt.","Tounch","Fine Wt."};
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
   		column=table1.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		column=table1.getColumn("Category");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(470);
   		column=table1.getColumn("Gross Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=table1.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=table1.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);

		//To show oppeing in details
		String title1Detail[]={"S.No.","Category","Item Name","Gross Wt.","Tounch","Fine Wt."};
		model1Detail=new DefaultTableModel(title1Detail,0);
		table1Detail=new JTable(model1Detail);
		jsp1Detail=new JScrollPane(table1Detail,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		column=table1Detail.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		column=table1Detail.getColumn("Category");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(270);
   		column=table1Detail.getColumn("Item Name");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(200);
   		column=table1Detail.getColumn("Gross Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=table1Detail.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=table1Detail.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
		jsp1Detail.setVisible(false);
		
		String heading[]={"S.No.","Date","Party Name","Bill No.","Via","Gross Wt.","Tounch","Fine Wt."};
		dtm=new DefaultTableModel(heading,0);
		grid=new JTable(dtm);
		JScrollPane jsp2=new JScrollPane(grid,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   		column=grid.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		column=grid.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(100);
   		
   		column=grid.getColumn("Party Name");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(200);

   		column=grid.getColumn("Bill No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(100);
   		column=grid.getColumn("Via");
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
   		column.setPreferredWidth(90);


		String heading2[]={"S.No.","Date","Party Name","Bill No.","Via","Gross Wt.","Tounch","Fine Wt."};
		dtm2=new DefaultTableModel(heading2,0);
		grid2=new JTable(dtm2);
		JScrollPane jsp3=new JScrollPane(grid2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		column=grid2.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		column=grid2.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(100);
   		column=grid2.getColumn("Party Name");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(200);

   		column=grid2.getColumn("Bill No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(100);
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
   		column.setPreferredWidth(90);

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
				
								
		lab1.setBounds(10,35,560,20);		
		//detailRb.setBounds(650+70,35,80,20);		
		//briefRb.setBounds(500+70,35,150,20);		
		lab13.setBounds(10,60,130,20);		
		grossLb.setBounds(140,60,150,20);
		lab14.setBounds(290,60,90,20);		
		tounchLb.setBounds(380,60,150,20);
		lab15.setBounds(530,60,120,20);		
		fineLb.setBounds(650,60,150,20);	
		itemCb.setBounds(580,35,220,20);		
		lab3.setBounds(10,57+100,140,20);		
		lab4.setBounds(275,57+100,140,20);		
		lab5.setBounds(535,57+100,140,20);		
		lab6.setBounds(10,10,100,20);
		lab2.setBounds(10,475,800,20);		
		lab7.setBounds(10,495,140,20);		
		lab8.setBounds(10,520,140,20);		
		lab9.setBounds(535,495,140,20);		
		lab10.setBounds(10,84,800,20);		
		lab11.setBounds(10,280,800,20);		
		lab12.setBounds(535,520,140,20);		
		dateTf.setBounds(95,10,130,20);		
		dateTf1.setBounds(240,10,130,20);		
		grossLb1.setBounds(150,495,125,20);
		fineLb1.setBounds(675,495,135,20);	
		profitInWt.setBounds(150,520,125,20);
		profitInPc.setBounds(675,520,135,20);
		jsp1.setBounds(10,80-23,800,100);
		jsp1Detail.setBounds(10,80-23,800,100);
		jsp2.setBounds(10,105,800,150);
		jsp3.setBounds(10,300,800,150);
		saleGrossWtLb.setBounds(530,255,88,20);
		saleTounchLb.setBounds(620,255,88,20);
		saleFineWtLb.setBounds(710,255,88,20);
		saleGrossWtLb2.setBounds(530,450,88,20);
		saleTounchLb2.setBounds(620,450,88,20);
		saleFineWtLb2.setBounds(710,450,88,20);
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
		lab13.setOpaque(true);
		lab14.setOpaque(true);
		lab15.setOpaque(true);
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
		lab9.setBackground(new Color(190,251,252));
		lab12.setBackground(new Color(190,251,252));
		
		lab1.setBackground(new Color(254,171,193));
		lab13.setBackground(new Color(190,251,252));
		lab14.setBackground(new Color(190,251,252));
		lab15.setBackground(new Color(190,251,252));
		grossLb.setBackground(new Color(252,251,213));
		tounchLb.setBackground(new Color(252,251,213));
		fineLb.setBackground(new Color(252,251,213));
		
		grossLb1.setBackground(new Color(252,251,213));
		fineLb1.setBackground(new Color(252,251,213));
		
		profitInWt.setBackground(new Color(252,251,213));
		profitInPc.setBackground(new Color(252,251,213));
		
		lab10.setBackground(new Color(249,230,194));
		saleGrossWtLb.setBackground(new Color(249,230,194));
		saleTounchLb.setBackground(new Color(249,230,194));
		saleFineWtLb.setBackground(new Color(249,230,194));
		
		lab11.setBackground(new Color(206,215,254));
		saleGrossWtLb2.setBackground(new Color(206,215,254));
		saleTounchLb2.setBackground(new Color(206,215,254));
		saleFineWtLb2.setBackground(new Color(206,215,254));
		showBtn.setMnemonic('s');
		printBtn.setMnemonic('p');
		closeBtn.setMnemonic('c');
		resetBtn.setMnemonic('r');
		
		addItem();
		
		con.add(lab1);
		//con.add(briefRb);
		//con.add(detailRb);
		con.add(itemCb);
		//con.add(lab4);
		//con.add(lab5);
		con.add(lab6);
		con.add(lab2);
		con.add(lab7);
		con.add(lab8);
		con.add(lab9);
		con.add(lab10);
		con.add(lab11);
		con.add(lab12);
		con.add(lab13);
		con.add(lab14);
		con.add(lab15);
		con.add(dateTf1);
		con.add(dateTf);
		con.add(grossLb);
		con.add(tounchLb);
		con.add(fineLb);
		con.add(grossLb1);
		con.add(profitInWt);
		con.add(profitInPc);
		con.add(fineLb1);
		//con.add(jsp1);
		con.add(jsp1Detail);
		con.add(jsp2);
		con.add(jsp3);
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
		
		//briefRb.addActionListener(this);
		//detailRb.addActionListener(this);
		itemCb.addActionListener(this);
		showBtn.addActionListener(this);
		showBtn.addKeyListener(this);
		closeBtn.addActionListener(this);
		closeBtn.addKeyListener(this);
		resetBtn.addActionListener(this);
		resetBtn.addKeyListener(this);
		dateTf1.addKeyListener(this);
		dateTf.addKeyListener(this);
		grid.addKeyListener(this);
		grid2.addKeyListener(this);
		printBtn.setEnabled(false);
		
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
			showOpeningDataInDetails();
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
		else if(e.getSource()==itemCb)
		{
			showData();
		}
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
			showOpeningDataInDetails();
		}
		else if(e.getSource()==resetBtn && e.getKeyCode()==10)
		{
			frm.dispose();
			new ShowRokar(desk);
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
	       	
	       	String category=""+itemCb.getSelectedItem();	       	
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
			
			String qry="select itemName from itemList where itemName='"+category+"'";				
			rs3=st3.executeQuery(qry);
			while(rs3.next())
			{
				String arr[]=new String[5];
				arr[0]=""+(table1.getRowCount()+1);
				arr[1]=rs3.getString(1);
				
				//about gross weight
				//Purchase part
				double purchasedWt=0,totalFineWt=0;
				System.out.println("trounce..................1");
				
				double temp=returnData("select sum(weight) from itemTransactionDetails where tranDate<#"+dt+"# and itemName='"+arr[1]+"'");				
				temp+=returnData("select sum(wt) from purchase where t_type='p' and p_Date<#"+dt+"# and i_name='"+arr[1]+"'");
				temp+=returnData("select sum(wt) from sale where t_type='a' and s_Date<#"+dt+"# and i_name='"+arr[1]+"'");
				purchasedWt=temp;
				System.out.println("trounce..................2");
				//Sale part
				temp-=returnData("select sum(wt),sum(tnh),sum(f_wt),count(p_s_no) from purchase where t_type='a' and p_Date<#"+dt+"# and i_name='"+arr[1]+"'");
				temp-=returnData("select sum(wt),sum(tnh),sum(f_wt),count(s_s_no) from sale where t_type='s' and s_Date<#"+dt+"# and i_name='"+arr[1]+"'");
				arr[2]=""+(new BigDecimal(temp)).setScale(3,5);
				grossWt+=temp;
				
				System.out.println("trounce..................3");
				temp=returnData("select sum(fineWt) from itemTransactionDetails where tranDate<#"+dt+"# and itemName='"+arr[1]+"'");
				temp+=returnData("select sum(f_wt) from purchase where t_type='p' and p_Date<#"+dt+"# and i_name='"+arr[1]+"'");
				temp+=returnData("select sum(f_wt) from sale where t_type='a' and s_Date<#"+dt+"# and i_name='"+arr[1]+"'");				
				totalFineWt=temp;
				//Sale part
				temp-=returnData("select sum(f_wt) from purchase where t_type='a' and p_Date<#"+dt+"# and i_name='"+arr[1]+"'");
				temp-=returnData("select sum(f_wt) from sale where t_type='s' and s_Date<#"+dt+"# and i_name='"+arr[1]+"'");
				arr[4]=""+(new BigDecimal(temp)).setScale(3,5);
				fineWt+=temp;
				
				System.out.println("trounce..................4");
				System.out.println("deno2:"+arr[2]);				
				//temp=(Double.valueOf(arr[4])*100)/Double.valueOf(arr[2]);
				try
				{
				
				temp=(Double.valueOf(totalFineWt)*100)/Double.valueOf(purchasedWt);
				arr[3]=""+(new BigDecimal(temp)).setScale(2,5);
				model1.addRow(arr);
				
				tounchLb.setText(""+(new BigDecimal(temp)).setScale(2,5));
	       	
				}
				catch(Exception e)
				{
				}
				System.out.println("trounce..................5");						
				
			}
			System.out.println("deno3:"+grossWt);
			//tnh=(fineWt*100)/grossWt;
			grossLb.setText(""+(new BigDecimal(grossWt)).setScale(3,5));
	       	//tounchLb.setText(""+(new BigDecimal(tnh)).setScale(2,5));
	       	fineLb.setText(""+(new BigDecimal(fineWt)).setScale(3,5));
	       	
			//CODE FOR GETTING OPENING WEIGHT
	       	/*
	       	 *Purchase part
	       	 */
	       	double gWt=0,fWt=0;
	       	int count=0,flag=0;	       	
	       	/*
	       	 *Sale part
	       	 */
	       	double gWt1=0,tnh1=0,fWt1=0;
	       	int count1=0,flag1=0;	       	
	       	//CODE FOR GETTING TODAY'S   'IN'
			long fromDtLong=Date.parse(dt);
			long toDtLong=Date.parse(dt1);

	       	double db=0;
	       	count1=0;
	       	flag=0;
	       	gWt1=0;tnh1=0;fWt1=0;
	       	System.out.println("trounce..................6");
	       	while(fromDtLong<=toDtLong)
	       	{
	       		dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
				qry="select * from sale where t_type='a' and s_Date=#"+dt+"# and i_name='"+category+"'";
				rs2=st2.executeQuery(qry);
		       	while(rs2.next())
		       	{
		       		System.out.println("trounce..................6.1");
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
	       		
	       			System.out.println("trounce..................6.2");
	       			db=rs2.getDouble("tnh");
		       		tnh1=tnh1+db;
		       		arr[6]=""+(new BigDecimal(db)).setScale(2,5);
	    	   		
	       			System.out.println("trounce..................6.3");
	       			db=rs2.getDouble("f_wt");
	       			fWt1=fWt1+db;
		       		arr[7]=""+(new BigDecimal(db)).setScale(3,5);
	       		
		       		count1++;
	    	   		flag1=1;	       		
	       			dtm.addRow(arr);
	       			System.out.println("trounce..................7");
	       		}
	       		
				qry="select * from purchase where t_type='p' and p_Date=#"+dt+"# and i_name='"+category+"'";
	       		rs2=st2.executeQuery(qry);
	       		System.out.println("trounce..................8");
	       		while(rs2.next())
	       		{
		       		System.out.println("trounce..................8.1");
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
	       		
	       			System.out.println("trounce...................8.2");
	       			db=rs2.getDouble("tnh");
		       		tnh1=tnh1+db;
		       		arr[6]=""+(new BigDecimal(db)).setScale(2,5);
	       		
	    	   		System.out.println("trounce..................8.3");
	    	   		db=rs2.getDouble("f_wt");
	       			fWt1=fWt1+db;
	       			arr[7]=""+(new BigDecimal(db)).setScale(3,5);
	       		
		       		count1++;
		       		flag1=1;	       		
	    	   		dtm.addRow(arr);
	    	   		System.out.println("trounce..................9");
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
			System.out.println("trounce..................10");
	       	while(fromDtLong<=toDtLong)
	       	{
	       		dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
	       	
				qry="select * from sale where t_type='s' and s_Date=#"+dt+"# and i_name='"+category+"'";
	       		rs2=st2.executeQuery(qry);
	       		while(rs2.next())
	       		{
			       	String arr[]=new String[8];
			       	arr[0]=""+(grid2.getRowCount()+1)+" ";
			       	arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		    	   	
	       			System.out.println("trounce..................10.1");
	       			arr[2]=rs2.getString("p_name");
	       			arr[3]=rs2.getString("s_s_no");
	       			arr[4]="Sale";
	       		
		       		db=rs2.getDouble("wt");
		       		gWt1=gWt1+db;
	    	   		arr[5]=""+(new BigDecimal(db)).setScale(3,5);
	       		
	       			System.out.println("trounce..................10.2");
	       			db=rs2.getDouble("tnh");
	       			tnh1=tnh1+db;
		       		arr[6]=""+(new BigDecimal(db)).setScale(2,5);
	       		
		       		System.out.println("trounce..................10.3");
		       		db=rs2.getDouble("f_wt");
	    	   		fWt1=fWt1+db;
	       			arr[7]=""+(new BigDecimal(db)).setScale(3,5);
	       		
	       			count1++;
		       		flag1=1;	       		
		       		dtm2.addRow(arr);
	       		}
	       		
				qry="select * from purchase where t_type='a' and p_Date=#"+dt+"# and i_name='"+category+"'";
	       		rs2=st2.executeQuery(qry);
	       		while(rs2.next())
	       		{
		       		System.out.print("c");
			       	String arr[]=new String[8];
			       	arr[0]=""+(grid2.getRowCount()+1)+" ";
		    	   	arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		       		
		       		arr[2]=rs2.getString("p_name");
		       		System.out.println(".............................."+arr[2]);
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
	    	   	System.out.println("trounce..................10.4");
	    	   	tnh1=(fWt1*100)/gWt1;
	    	   	System.out.println("trounce..................10.5");
	    	   	
				try
				{
					saleTounchLb2.setText(""+(new BigDecimal(tnh1)).setScale(2,5));	
				}
				catch(Exception e){
				}
				
	       	}
       	
	       	try
	       	{
	       	
	       	grossLb1.setText(""+(new BigDecimal(Double.valueOf(grossLb.getText())+Double.valueOf(saleGrossWtLb.getText())-Double.valueOf(saleGrossWtLb2.getText()))).setScale(3,5));
	       	//fineLb1.setText(""+(new BigDecimal(Double.valueOf(fineLb.getText())+Double.valueOf(saleFineWtLb.getText())-Double.valueOf(saleFineWtLb2.getText()))).setScale(3,5));
	       	fineLb1.setText(""+(new BigDecimal(Double.valueOf(tounchLb.getText())*Double.valueOf(grossLb1.getText())/100)).setScale(3,5));
	       	if(!saleGrossWtLb2.getText().equals("0.000"))	       	
	       		calculateProfit();
	    	}
	    	catch(Exception e)
	    	{
	    		
	    	}
	    System.out.println("trounce..................11");
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
	}
	
	private double returnData(String query)
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
			System.out.println("Error...45791222..."+x);
		}
		return 0;
	}	       		
	
	
	private void addItem()
	{		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	ResultSet rs1;
	       	//itemCb.addItem("All Category");
	       	rs1=st1.executeQuery("select * from itemList order by itemName");
	       	while(rs1.next())
	       	{
	       		itemCb.addItem(rs1.getString("itemName"));
	       	}
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457912..."+x);
		}
	}	       		
	
	private void showOpeningDataInDetails()
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
		
		double balanceFineWt=(((Double.valueOf(fineLb.getText())+Double.valueOf(saleFineWtLb.getText())-Double.valueOf(saleFineWtLb2.getText()))));
		double calculatedFineWt=fwt;
		double profitWt=calculatedFineWt-balanceFineWt;
		//double canFineWt=Double.valueOf(""+(new BigDecimal((gwt*tnh)/100)).setScale(3,5));
		//double profitWt=fwt-canFineWt;
		profitInWt.setText(""+(new BigDecimal(profitWt)).setScale(3,5));
		//in percentage
		double profitPc=(100*profitWt)/fwt;
		profitInPc.setText(""+(new BigDecimal(profitPc)).setScale(2,5));		
	}
}	