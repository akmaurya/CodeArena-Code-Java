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



public class ShowRokar extends JFrame implements ActionListener,KeyListener//,MouseListener,FocusListener
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
	JLabel saleGrossWtLb,saleTounchLb,saleFineWtLb,lab13,lab14;
	JLabel saleGrossWtLb2,saleTounchLb2,saleFineWtLb2;
	JRadioButton briefRb,detailRb;	
	JScrollPane jsp1Detail,jsp1;
	JDesktopPane desk;
	JComboBox catCb;
		
	public ShowRokar(JDesktopPane desk)
	{
		this.desk=desk;
		frm=new JInternalFrame("REPORT : SHOW CLOSING OF METAL CATEGORY WISE",false,true,false,false);
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
		JLabel lab100=new JLabel("Closing");
		JLabel lab11=new JLabel(" Out");
		JLabel lab12=new JLabel("Profit (in %)");
		
		 lab13=new JLabel("0.000",JLabel.RIGHT);
		 lab14=new JLabel("0.000",JLabel.RIGHT);
		grossLb=new JLabel("0.000",JLabel.RIGHT);
		tounchLb=new JLabel("0",JLabel.RIGHT);
		fineLb=new JLabel("0.000",JLabel.RIGHT);
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
		catCb=new JComboBox();
		
		String title1[]={"S.No.","ItemName","Gross Wt.","Tounch","Fine Wt."};
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
   		column=table1.getColumn("ItemName");
   		column.setCellRenderer(CRCenter);
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
   		jsp1.setVisible(true);

		//To show oppeing in details
		String title1Detail[]={"S.No.","Item Name","Gross Wt.","Tounch","Fine Wt."};
		model1Detail=new DefaultTableModel(title1Detail,0);
		table1Detail=new JTable(model1Detail);
		jsp1Detail=new JScrollPane(table1Detail,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		column=table1Detail.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		
   		column=table1Detail.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		column=table1Detail.getColumn("Item Name");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(470);
   		column=table1Detail.getColumn("Gross Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=table1Detail.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=table1Detail.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);

   		/*column=table1Detail.getColumn("Category");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(270);
   		
   		column=table1Detail.getColumn("Item Name");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(200);
   		column=table1Detail.getColumn("Gross Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=table1Detail.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=table1Detail.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);*/
		//jsp1Detail.setVisible(false);
		
		String heading[]={"S.No.","itemName","Gross Wt.","Tounch","Fine Wt."};
		dtm=new DefaultTableModel(heading,0);
		grid=new JTable(dtm);
		JScrollPane jsp2=new JScrollPane(grid,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   		
   		column=grid.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		column=grid.getColumn("itemName");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(470);
   		column=grid.getColumn("Gross Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid.getColumn("Fine Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);


		String heading2[]={"S.No.","itemName","Gross Wt.","Tounch","Fine Wt."};
		dtm2=new DefaultTableModel(heading2,0);
		grid2=new JTable(dtm2);
		JScrollPane jsp3=new JScrollPane(grid2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		column=grid2.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(60);
   		
		column=grid2.getColumn("itemName");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(470);
   		
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
		catCb.setBounds(580,35,220,20);		
		lab3.setBounds(10,57+100,140,20);		
		lab4.setBounds(275,57+100,140,20);		
		lab5.setBounds(535,57+100,140,20);		
		lab6.setBounds(10,10,100,20);
		lab2.setBounds(10,475,800,20);		
		lab7.setBounds(10,495,140,20);		
		lab8.setBounds(10,520,140,20);		
		lab9.setBounds(535,495,140,20);		
		lab10.setBounds(10,144,800,20);		
		lab100.setBounds(10,370,800,15);		
		lab11.setBounds(10,260,800,20);		
		lab12.setBounds(535,520,140,20);		
		dateTf.setBounds(95,10,130,20);		
		dateTf1.setBounds(240,10,130,20);		
		grossLb.setBounds(530,57+70,88,20);
		tounchLb.setBounds(620,57+70,88,20);
		fineLb.setBounds(710,57+70,88,20);	
		grossLb1.setBounds(150,495,125,20);
		fineLb1.setBounds(675,495,135,20);	
		profitInWt.setBounds(150,590,125,20);
		profitInPc.setBounds(675,590,135,20);
		jsp1.setBounds(10,80-23,800,70);
		jsp1Detail.setBounds(10,385,800,70);
		jsp2.setBounds(10,165,800,70);
		jsp3.setBounds(10,280,800,70);
		lab13.setBounds(530,455,88,20);
		lab14.setBounds(710,455,88,20);
		saleGrossWtLb.setBounds(530,240,88,20);
		saleTounchLb.setBounds(620,240,88,20);
		saleFineWtLb.setBounds(710,240,88,20);
		saleGrossWtLb2.setBounds(530,350,88,20);
		saleTounchLb2.setBounds(620,350,88,20);
		saleFineWtLb2.setBounds(710,350,88,20);
		showBtn.setBounds(400,10,100,20);
		printBtn.setBounds(280,560,100,25);
		resetBtn.setBounds(390,560,100,25);
		closeBtn.setBounds(500,560,100,25);
		
		lab1.setOpaque(true);
		lab3.setOpaque(true);
		lab4.setOpaque(true);
		lab5.setOpaque(true);
		lab10.setOpaque(true);
		lab100.setOpaque(true);
		lab11.setOpaque(true);
		lab12.setOpaque(true);
		lab13.setOpaque(true);
		lab14.setOpaque(true);
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
		grossLb.setBackground(new Color(254,171,193));
		tounchLb.setBackground(new Color(254,171,193));
		fineLb.setBackground(new Color(254,171,193));
		
		grossLb1.setBackground(new Color(252,251,213));
		fineLb1.setBackground(new Color(252,251,213));
		
		profitInWt.setBackground(new Color(252,251,213));
		profitInPc.setBackground(new Color(252,251,213));
		
		lab10.setBackground(new Color(249,230,194));
		lab13.setBackground(new Color(249,230,194));
		lab14.setBackground(new Color(249,230,194));
		lab100.setBackground(new Color(249,230,194));
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
		
		addCategory();
		
		con.add(lab1);
		//con.add(briefRb);
		//con.add(detailRb);
		con.add(catCb);
		//con.add(lab4);
		//con.add(lab5);
		con.add(lab6);
		//con.add(lab2);
		//con.add(lab7);
		//con.add(lab8);
		//con.add(lab9);
		con.add(lab10);
		con.add(lab100);
		con.add(lab11);
		con.add(lab13);
		con.add(lab14);
		//con.add(lab12);
		con.add(dateTf1);
		con.add(dateTf);
		con.add(grossLb);
		//con.add(tounchLb);
		con.add(fineLb);
		//con.add(grossLb1);
		//con.add(profitInWt);
		//con.add(profitInPc);
		//con.add(fineLb1);
		con.add(jsp1);
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
		catCb.addActionListener(this);
		showBtn.addActionListener(this);
		showBtn.addKeyListener(this);
		closeBtn.addActionListener(this);
		closeBtn.addKeyListener(this);
		resetBtn.addActionListener(this);
		resetBtn.addKeyListener(this);
		dateTf1.addKeyListener(this);
		dateTf.addKeyListener(this);
		printBtn.addKeyListener(this);
		printBtn.addActionListener(this);
		//printBtn.setEnabled(false);
		grid.addKeyListener(this);
		grid2.addKeyListener(this);
		
		desk.add(frm);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-830)/2;
		int y = (ds.height-630)/2;
   		frm.reshape(x,20,830,630);
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
		else if(e.getSource()==printBtn)
		{
			
		
			printchallan pb=new printchallan(desk);
		
			
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
		else if(e.getSource()==catCb)
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
			//showOpeningDataInDetails();
		}
		
		else if(e.getSource()==printBtn && e.getKeyCode()==10)
		{
			printchallan pb=new printchallan(desk);	
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
	       	Statement st4=cn.createStatement();
	       	Statement st6=cn.createStatement();
	       	Statement st7=cn.createStatement();
	       	ResultSet rs1,rs2,rs3,rs4,rs8;
	       	
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
	       	
	       	String category=""+catCb.getSelectedItem();	       	
	     	System.out.println("daya shankar.....................seth"+category);
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
			while(table1Detail.getRowCount()>0)	model1Detail.removeRow(0);
			
			double zemp1=0,zemp2=0,jemp1=0,jemp2=0,pemp1=0,pemp2=0,pemp111=0,pemp222=0;
			double chemp1=0,chemp2=0;
			double grossWt=0,fineWt=0,tnh=0;
			double openwt=0,openfine=0;
			double chemp11=0,chemp22=0,chemp111=0,chemp222=0,jemp11=0,jemp22=0;
			double totalweightin=0,intotalweight=0,insumweight=0;
			double totalfweightin=0,intotalfweight=0,insumfweight=0;
			double totalweightout=0,outtotalweight=0,outsumweight=0;
			double totalfweightout=0,outtotalfweight=0,outsumfweight=0;
			
			
			long fromDtLong=Date.parse(dt);
			long toDtLong=Date.parse(dt1);

			dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
			dt1=((new Date(toDtLong)).getMonth()+1)+"/"+(new Date(toDtLong)).getDate()+"/"+((new Date(toDtLong)).getYear()+1900);

			//code for opening 
			String qry="select  itemName from itemList where   categoryName='"+category+"' group by itemName  ";
			//all distinct
			rs3=st3.executeQuery(qry);
			
			while(rs3.next())
			{
				System.out.println("dhananjay  tiwari");
				String arrr[]=new String[5];
				arrr[0]=""+(table1.getRowCount()+1);
				String r=rs3.getString("itemName");
				
			   
				
				
				//about gross weight
				//Purchase part
				double purchasedWt=0,totalFineWt=0,temp=0;
				
				
				double demp=returnData("select sum(weight) from itemTransactionDetails where tranDate<#"+dt+"# and itemName='"+r+"'");				
				double demp3=returnData("select sum(wt) from purchase where p_Date<#"+dt+"#  and t_type='p' and i_name='"+r+"'");				
				double demp55=returnData("select sum(wt) from sale where s_Date<#"+dt+"#  and t_type='a' and i_name='"+r+"'");				
				
				double demp2=returnData("select sum(fineWt) from itemTransactionDetails where tranDate<#"+dt+"# and itemName='"+r+"'");				
				double demp4=returnData("select sum(f_wt) from purchase where p_Date<#"+dt+"# and t_type='p' and i_name='"+r+"'");				
				double demp66=returnData("select sum(f_wt) from sale where s_Date<#"+dt+"# and t_type='a' and i_name='"+r+"'");				
				
				
				double demp33=returnData("select sum(wt) from purchase where p_Date<#"+dt+"#  and t_type='a' and i_name='"+r+"'");				
				double demp5=returnData("select sum(wt) from sale where s_Date<#"+dt+"# and t_type='s' and i_name='"+r+"'");				
				
				double demp44=returnData("select sum(f_wt) from purchase where p_Date<#"+dt+"# and t_type='a' and i_name='"+r+"'");				
				double demp6=returnData("select sum(f_wt) from sale where s_Date<#"+dt+"#  and t_type='s' and i_name='"+r+"'");				
				
				openwt=demp+demp3+demp55-demp33-demp5;
				openfine=(demp2+demp4+demp66)-(demp44+demp6);
				
				arrr[1]=r;
				arrr[2]="0.000";
				arrr[3]="0.00";
				arrr[4]="0.000";
				
				
				try
				{
					
					arrr[2]=""+(new BigDecimal(openwt)).setScale(3,5);	
					arrr[4]=""+(new BigDecimal(openfine)).setScale(3,5);
					arrr[3]=""+(new BigDecimal((openfine*100)/openwt)).setScale(2,5);
					
				
				}
				catch(Exception e){ }
				
								
				
					grossWt+=openwt;	
					System.out.println("dhan wari");
				
					fineWt+=openfine;	
				
				
				
				model1.addRow(arrr);
				
							
				
			}
			
			
			grossLb.setText(""+(new BigDecimal(grossWt)).setScale(3,5));
			
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
	       	//-------------------------------
	       	//CODE FOR GETTING TODAY'S   'IN'
			//-------------------------------
	       	double db=0;
	       	count1=0;
	       	flag=0;
	       	gWt1=0;tnh1=0;fWt1=0;
	       	
				String qry1="select  itemName from itemList where   categoryName='"+category+"' order by itemName  ";
				
				ResultSet rs6=st7.executeQuery(qry1);
				while(rs6.next())
				{
				
				 		
				 		String rr=rs6.getString("itemName");
				 		
				 		
				 		
				 		String arr[]=new String[5];
		       			
		       			arr[0]=""+(grid.getRowCount()+1)+" ";
		       			arr[1]=rr;
						arr[2]="0.000";
						arr[3]="0.00";
						arr[4]="0.000";
				 					
		    	   		chemp1=returnData("select sum(wt) from sale where t_type='a' and s_Date>=#"+dt+"#  and s_Date<=#"+dt1+"# and i_name='"+arr[1]+"'");
		    	   			
	       				chemp2=returnData("select sum(f_wt) from sale where t_type='a' and s_Date>=#"+dt+"# and s_Date<=#"+dt1+"# and i_name='"+arr[1]+"'");
	       												
		       									
						pemp1=returnData("select sum(wt) from purchase where t_type='p' and p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# and i_name='"+arr[1]+"'");
													
	       				pemp2=returnData("select sum(f_wt) from purchase where t_type='p' and p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# and i_name='"+arr[1]+"'");
	       							
		       										
						pemp111=returnData("select sum(weight) from itemTransactionDetails where tranDate>=#"+dt+"# and tranDate<=#"+dt1+"#  and itemName='"+arr[1]+"'");				
						
						pemp222=returnData("select sum(fineWt) from itemTransactionDetails where tranDate>=#"+dt+"# and tranDate<=#"+dt1+"#  and itemName='"+arr[1]+"'");				
									
	       				
	       				double grossweight=chemp1+pemp1+pemp111;
	       				double fineweight=chemp2+pemp2+pemp222;
	       				
	       					
		       			arr[2]=""+(new BigDecimal(grossweight)).setScale(3,5);
		       						
		       			arr[4]=""+(new BigDecimal(fineweight)).setScale(3,5);
	       				try
	       				{
	       					arr[3]=""+(new BigDecimal(((fineweight*100)/grossweight))).setScale(2,5);				
	       				}
	       				catch(Exception e)
	       				{
	       					
	       				}
	       				
	       				
	       				outtotalweight+=grossweight;
	       				outtotalfweight+=fineweight;
	       				
	       				dtm.addRow(arr);	
	       				//System.out.println("zed2---");
						
	       			
	       		}//end of while  for in 		
	       		System.out.println("zed22---");
	       	
	       	//-------------------------------
	       	//CODE FOR GETTING TODAY'S  'OUT'
	       	//-------------------------------
	       	db=0;
	       	count1=0;
	       	flag=0;
	       	gWt1=0;tnh1=0;fWt1=0;
			
			
	       					double t1=0,t2=0,t3=0,t4=0;
	       							
	       					
	       					String qry2="select  itemName from itemList where  categoryName='"+category+"' order by itemName ";		
	       					ResultSet rs5=st3.executeQuery(qry2);
	       					
	       					while(rs5.next())
							{
	       										
	       							String arr[]=new String[5];
	       							
	       							
	       							String rrr=rs5.getString("itemName");

	       							arr[0]=""+(grid2.getRowCount()+1)+" ";
	       							arr[1]=rrr;
									arr[2]="0.000";
									arr[3]="0.00";
									arr[4]="0.000";
	       							
	       							
	       							//dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
	       											
		       						jemp1=returnData("select sum(wt) from sale where t_type='s' and s_Date>=#"+dt+"# and s_Date<=#"+dt1+"# and i_name='"+arr[1]+"'");
		       										
	       							jemp2=returnData("select sum(f_wt) from sale where t_type='s' and s_Date>=#"+dt+"# and s_Date<=#"+dt1+"# and i_name='"+arr[1]+"'");
	       							
		    	   				     zemp1=returnData("select sum(wt) from purchase where t_type='a' and p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# and i_name='"+arr[1]+"'");
		    	   				       						
	       							 zemp2=returnData("select sum(f_wt) from purchase where t_type='a' and p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# and i_name='"+arr[1]+"'");
	       													
	       							double grossweightout=jemp1+zemp1;
	       							double fineweightout=jemp2+zemp2;			
									
									intotalweight+=grossweightout;
			       					intotalfweight+=fineweightout;
	       							
	       							
	       							arr[2]=""+(new BigDecimal(grossweightout)).setScale(3,5);
		       						
		       						arr[4]=""+(new BigDecimal(fineweightout)).setScale(3,5);		       		
									try
									{
										arr[3]=""+(new BigDecimal(((fineweightout*100)/grossweightout))).setScale(2,5);		
									}
	       							catch(Exception e)
	       							{
	       								
	       							}
	       															
	       		
	       							dtm2.addRow(arr);	
	       		
	       			
	       							
	       		}				
	       		
	       		
	       	totalweightin=intotalweight; 
	       	totalfweightin=intotalfweight; 
	       	
	       	
	       	
	       	try
	       	{
	       	
	       		saleGrossWtLb2.setText(""+(new BigDecimal(totalweightin)).setScale(3,5));
	       		saleFineWtLb2.setText(""+(new BigDecimal(totalfweightin)).setScale(3,5));
	       		double a=(totalfweightin*100)/totalweightin;
	       		
	       		saleTounchLb2.setText(""+(new BigDecimal(a)).setScale(2,5));
	       	}
	       	catch(Exception e){}
	       	
	       	totalweightout=outtotalweight; 
	       	
	       	
	       	totalfweightout=outtotalfweight; 
	       
	       	
	       	try
	       	{
	       		 
	       		saleFineWtLb.setText(""+(new BigDecimal(outtotalfweight)).setScale(3,5));	
	       		
	       		saleGrossWtLb.setText(""+(new BigDecimal(outtotalweight)).setScale(3,5));
	       		
	       		double intounch=(totalfweightout*100)/totalweightout;
	       		
	       		saleTounchLb.setText(""+(new BigDecimal(intounch)).setScale(2,5));
	       		
	       		
	       	}
	       	catch(Exception e){System.out.println("dhananjay.........grruytytty."+e);}
	       	
	       	
	       	//-------------------------------------
			//CLOSEING
			//-------------------------------------
			double grossWt1=0,fineWt1=0;
			double openwt1=0,openfine1=0;
			//code for closing 
			System.out.println("closing problem....before...grosswttotal....="+grossWt1);
			System.out.println("closing problem....before....finetotal=...="+fineWt1);
			String qry23="select   itemName from itemList where   categoryName='"+category+"' group by itemName  ";
			//all distinct
			rs4=st4.executeQuery(qry23);
			System.out.println("khoj......................................................................3");
			while(rs4.next())
			{
				System.out.println("dhananjay  tiwari");
				String arrr[]=new String[5];
				arrr[0]=""+(table1Detail.getRowCount()+1);
				String r=rs4.getString("itemName");
				
			   System.out.println("item Name---------------closing--------------------->="+r);
				
				
				//about gross weight
				//Purchase part
				//double purchasedWt=0,totalFineWt=0,temp=0;
				
				
				double demp=returnData("select sum(weight) from itemTransactionDetails where   tranDate<=#"+dt1+"# and itemName='"+r+"'");				
				System.out.println("demp-----------------------------="+demp);
				double demp3=returnData("select sum(wt) from purchase where  p_Date<=#"+dt1+"#  and t_type='p' and i_name='"+r+"'");				
				System.out.println("demp3----------------------------="+demp3);
				double demp55=returnData("select sum(wt) from sale where  s_Date<=#"+dt1+"#  and t_type='a' and i_name='"+r+"'");				
				System.out.println("demp55---------------------------="+demp55);
				double demp2=returnData("select sum(fineWt) from itemTransactionDetails where  tranDate<=#"+dt1+"# and itemName='"+r+"'");				
				System.out.println("demp2----------------------------="+demp2);
				double demp4=returnData("select sum(f_wt) from purchase where  p_Date<=#"+dt1+"# and t_type='p' and i_name='"+r+"'");				
				System.out.println("demp4-----------------------------="+demp4);
				double demp66=returnData("select sum(f_wt) from sale where  s_Date<=#"+dt1+"# and t_type='a' and i_name='"+r+"'");				
				System.out.println("demp66-----------------------------="+demp66);
				
				double demp33=returnData("select sum(wt) from purchase where  p_Date<=#"+dt1+"#  and t_type='a' and i_name='"+r+"'");				
				System.out.println("demp33------------------------------="+demp33);
				double demp5=returnData("select sum(wt) from sale where  s_Date<=#"+dt1+"# and t_type='s' and i_name='"+r+"'");				
				System.out.println("demp5--------------------------------="+demp5);
				double demp44=returnData("select sum(f_wt) from purchase where  p_Date<=#"+dt1+"# and t_type='a' and i_name='"+r+"'");				
				System.out.println("demp44--------------------------------="+demp44);
				double demp6=returnData("select sum(f_wt) from sale where   s_Date<=#"+dt1+"#  and t_type='s' and i_name='"+r+"'");				
				System.out.println("demp6----------------------------------="+demp6);
				openwt1=demp+demp3+demp55-demp33-demp5;
				System.out.println("openWt1-------"+openwt1);
				openfine1=(demp2+demp4+demp66)-(demp44+demp6);
				System.out.println("openfine1-------"+openfine1);
				arrr[1]=r;
				
				
				double opWt,opTnch,actOpWt;
				double inWt,inTnch,actInWt;
				double actClWt=0;
				try
				{
					arrr[2]=""+(new BigDecimal(openwt1)).setScale(3,5);	
					int crntRow=table1Detail.getRowCount();
					opWt=Double.valueOf(""+table1.getValueAt(crntRow,2));
					actOpWt=Double.valueOf(""+table1.getValueAt(crntRow,4));
					System.out.println("op. wt.="+opWt);
					System.out.println("op. fine wt="+actOpWt);
					
					inWt=Double.valueOf(""+grid.getValueAt(crntRow,2));
					actInWt=Double.valueOf(""+grid.getValueAt(crntRow,4));
					System.out.println("in wt.="+inWt);
					System.out.println("in fine wt="+actInWt);
					
					double totalWt=opWt+inWt;
					double totalFineWt=actOpWt+actInWt;
					double clTnch=(totalFineWt*100)/totalWt;
					actClWt=openwt1*clTnch/100;
					arrr[3]=""+(new BigDecimal(clTnch)).setScale(2,5);
					arrr[4]=""+(new BigDecimal(actClWt)).setScale(3,5);
					
					//arrr[4]=""+(new BigDecimal(openfine1)).setScale(3,5);
					//arrr[3]=""+(new BigDecimal((openfine1*100)/openwt1)).setScale(2,5);
				}
				catch(Exception e){ }
				
								
				
					grossWt1+=openwt1;	
					System.out.println("dhan wari");
				
					fineWt1+=actClWt;	
				
				
				
				model1Detail.addRow(arrr);
				
							
				
			}
			
			System.out.println("closing problem.......grosswttotal=....1"+grossWt1);
			System.out.println("closing problem........finetotal=...2"+fineWt1);
			lab13.setText(""+(new BigDecimal(grossWt1)).setScale(3,5));
			
	       	lab14.setText(""+(new BigDecimal(fineWt1)).setScale(3,5));
	       	
			//end of closing
				       	
	       	//end of pasting codes
	       	//--------------------
	       	
	  		System.out.println("dhananjay..........22222222222222222222222222");       	
	       	grossLb1.setText(""+(new BigDecimal(Double.valueOf(grossLb.getText())+Double.valueOf(saleGrossWtLb.getText())-Double.valueOf(saleGrossWtLb2.getText()))).setScale(3,5));
	       	System.out.println("dhananjay..........11111111111111111");
	       	fineLb1.setText(""+(new BigDecimal(Double.valueOf(fineLb.getText())+Double.valueOf(saleFineWtLb.getText())-Double.valueOf(saleFineWtLb2.getText()))).setScale(3,5));
	       	System.out.println("dhananjay..........````````````````````````````");
	       	if(!saleGrossWtLb2.getText().equals("0.000"))	       	
	       		calculateProfit();
	       			System.out.println("dhananjay.........weqeqweqeqeqeqeqeqeqe.````````````````````````````");
	    cn.close();	
	    }	
		
		catch(Exception x)
		{
			System.out.println("Error1......"+x);
		}
		System.out.println("dhananjay..........gggggggggggggggggggggggggggg");
	}
	
	private double returnData(String query)
	{		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	ResultSet rs1;
	       	//System.out.println(query);
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
			System.out.println("Error2...457912 dhan2..."+x);
		}
		return 0;
	}	       		
	
	
	private void addCategory()
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
	       		catCb.addItem(rs1.getString("categoryName"));
	       	}
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error5...457912.dhan1.."+x);
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
			System.out.println("Error8...4590..."+x);
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
		
	}
	//printing
	int currentpg,totalpg;
	boolean firsttime=false;
	boolean complete=false;
	
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
                                //double width=4.27 * 72;
                                double width=8.27 * 72;
                                double height=(11.69 * 72);
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
										printJob.print();
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
            /*
            fb11=new Font("Times New Roman",Font.BOLD,11);
            fp11=new Font("Times New Roman",Font.PLAIN,11);
            fb10=new Font("Arial",Font.BOLD,10);
            fp10=new Font("Arial",Font.PLAIN,10);
            fb9=new Font("Arial",Font.BOLD,9);
            fp9=new Font("Arial",Font.PLAIN,9);
            fb8=new Font("Arial",Font.BOLD,8);
            fp8=new Font("Arial",Font.PLAIN,8);
            fp7=new Font("Arial",Font.PLAIN,7);
            */
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
                            	 
			        		    //String firmname=""+partyCb.getSelectedItem();;
        					    String billno="";
								String date=""+dateTf.getText();
								String date1=""+dateTf1.getText();
		    	    		    
		    	    		    //dateTf,dateTf1
		    	    		    /*rs=st.executeQuery("select max(s_s_no) from Sale");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	billno=""+(rs.getInt(1));
		    	    		    }*/
		    	    		    //billno=billNoLb.getText();
					int top=20;
        			int left=50;
        			int flag=0;
        			g2.setFont(fb11);
		            fm=g2.getFontMetrics();				
		           
		           	
					top+=10;
					String temp="SHOW CLOSING OF METAL CATEGORYWISE";
		            g2.drawString(temp,200,top);
					
					
					top+=10;
					
        		    g2.setFont(fb11);
					g2.drawLine(left,top,570,top);
        		    
		           
		           
		           
					
					
					/*top+=10;
					g2.setFont(fb10);
		            fm=g2.getFontMetrics();				
		            //temp=firmname;
		            g2.drawString(temp,(300-fm.stringWidth(temp))/2,top);*/
					
		        	top+=15;
					g2.setFont(fb9);
		            fm=g2.getFontMetrics();				
		            temp="Date : "+date;
		            //layout=new TextLayout(temp,fp10,context);
        		    g2.drawString(temp,230,top);
        		    
        		    //top+=10;
					g2.setFont(fb9);
		            fm=g2.getFontMetrics();				
		            temp=" to  "+date1;
		            //layout=new TextLayout(temp,fp10,context);
        		    g2.drawString(temp,300,top);
        		    
        		    
        		    
					if(table1.getRowCount()>0)
					{
					
								
								
								
								
								top+=10;
        		    			g2.setFont(fb11);
								g2.drawLine(left,top,570,top);
								
								top+=10;
        		    			g2.setFont(fb10);
								temp="Opening:-";
								g2.drawString(temp,50,top);
        		    
        		    
        		    			
								top+=30;
								g2.setFont(fb10);
		            			temp=" S.NO.             ITEM                    		                                           GROSSWEIGHT    			         TOUNCH      			         FINEWT";
								layout=new TextLayout(temp,fb9,context);
								g2.drawString(temp,50,top);
        		    
        		    			//System.out.println("no of row-----------------------------grid2-------"+grid2.getRowCount());
        		    			//System.out.println("no of row------------------------------grid------"+grid.getRowCount());
        		   
        		    			for(int i=0;i<table1.getRowCount();i++)
        		    			{
        		    	
        		    					//System.out.println("rsmt");
        		    					top+=13;
										g2.setFont(fp8);
										fm=g2.getFontMetrics();						            
		            					temp=""+table1.getValueAt(i,0);
		               					g2.drawString(temp,60,top);
						
		    	    					g2.setFont(fp9);
		    	    					fm=g2.getFontMetrics();
						
		    	    					temp=""+table1.getValueAt(i,1);
		    	    					g2.drawString(temp,115,top);
		    	    	
		    	    	
		    	    					temp=""+table1.getValueAt(i,2);
		    	    					g2.drawString(temp,(365-fm.stringWidth(temp)),top);
		    	    	
		    	    	
		    	    					temp=""+table1.getValueAt(i,3);
		    	    					g2.drawString(temp,(465-fm.stringWidth(temp)),top);
        		    		
        		    
	        		    				temp=""+table1.getValueAt(i,4);
		    	    					g2.drawString(temp,(545-fm.stringWidth(temp)),top);
						
        		    
        		   				 }
        		    			top+=10;
        		    			g2.setFont(fb11);
								g2.drawLine(left,top,570,top);
					
								top+=10;
								g2.setFont(fb10);
								temp=""+grossLb.getText();
								
								g2.drawString(temp,(365-fm.stringWidth(temp)),top);
					
					
								g2.setFont(fb10);
								temp=""+fineLb.getText();
								g2.drawString(temp,(545-fm.stringWidth(temp)),top);
					
								top+=5;
        		    			g2.setFont(fb11);
								g2.drawLine(left,top,570,top);
					

        		    }
        		    
					
					
					/*top+=10;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,500,top);*/
        		    
        		    /////////////////////////////////code for in table
        		    System.out.println("saleGrossWtLb="+saleGrossWtLb.getText());
					System.out.println("saleGrossWtLb2="+saleGrossWtLb2.getText());
					System.out.println("grossLb1="+grossLb1.getText());
        		    if(grid.getRowCount()>0)
        		    {
        		    
        		    			top+=15;
        		    			g2.setFont(fb10);
								temp="In:-";
				             	g2.drawString(temp,50,top);
        		    			top+=30;
								g2.setFont(fb10);
		            			temp=" S.NO.             ITEM                    		                                           GROSSWEIGHT    			         TOUNCH      			         FINEWT";
								layout=new TextLayout(temp,fb9,context);
								g2.drawString(temp,50,top);
        		    
        		    			for(int i=0;i<grid.getRowCount();i++)
        		    			{
        		    	
        		    						System.out.println("rsmt");
        		    						top+=13;
											g2.setFont(fp8);
											fm=g2.getFontMetrics();						            
		            						temp=""+grid.getValueAt(i,0);
		            	
		            						g2.drawString(temp,60,top);
						
		    	    						g2.setFont(fp9);
		    	    						fm=g2.getFontMetrics();
						
		    	    						temp=""+grid.getValueAt(i,1);
		    	    						g2.drawString(temp,115,top);
		    	    	
		    	    	
		    	    						temp=""+grid.getValueAt(i,2);
		    	    						g2.drawString(temp,(365-fm.stringWidth(temp)),top);
		    	    	
		    	    	
		    	    						temp=""+grid.getValueAt(i,3);
		    	    						g2.drawString(temp,(465-fm.stringWidth(temp)),top);
        		    		
        		    
	        		    					temp=""+grid.getValueAt(i,4);
		    	    						g2.drawString(temp,(545-fm.stringWidth(temp)),top);
						
        		    
        		    			}
        		    			
        		    			top+=10;
        		    			g2.setFont(fb11);
								g2.drawLine(left,top,570,top);
					
								top+=10;
								g2.setFont(fb10);
								temp=""+saleGrossWtLb.getText();
								g2.drawString(temp,(365-fm.stringWidth(temp)),top);
					
					
								//saleTounchLb
								
								g2.setFont(fb10);
								temp=""+saleTounchLb.getText();
								g2.drawString(temp,(465-fm.stringWidth(temp)),top);
								//
								g2.setFont(fb10);
								temp=""+saleFineWtLb.getText();
								g2.drawString(temp,(545-fm.stringWidth(temp)),top);
					
								top+=5;
        		    			g2.setFont(fb11);
								g2.drawLine(left,top,570,top);
					
        		    			
        		    			
        		    }			
					
					
					
					/*top+=10;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,500,top);*/
        		    
        		   
        		    //////////////////code for out table
        		    if(grid2.getRowCount()>0)
        		    {
        		    
        		    		
        		    		top+=15;
        		    		g2.setFont(fb10);
							temp="Out:-";
							g2.drawString(temp,50,top);
        		    		
        		    		top+=30;
							g2.setFont(fb10);
		            		temp=" S.NO.             ITEM                    		                                           GROSSWEIGHT    			         TOUNCH      			         FINEWT";
							layout=new TextLayout(temp,fb9,context);
							g2.drawString(temp,50,top);
        		    
        		    		for(int i=0;i<grid2.getRowCount();i++)
        		    		{
        		    	
        		    				System.out.println("rsmt");
        		    				top+=13;
									g2.setFont(fp8);
									fm=g2.getFontMetrics();						            
		            				temp=""+grid2.getValueAt(i,0);
		            	
		            				g2.drawString(temp,60,top);
						
		    	    				g2.setFont(fp9);
		    	    				fm=g2.getFontMetrics();
						
		    	    				temp=""+grid2.getValueAt(i,1);
		    	    				g2.drawString(temp,115,top);
		    	    	
		    	    	
		    	    				temp=""+grid2.getValueAt(i,2);
		    	    				g2.drawString(temp,(365-fm.stringWidth(temp)),top);
		    	    	
		    	    	
		    	    				temp=""+grid2.getValueAt(i,3);
		    	    				g2.drawString(temp,(465-fm.stringWidth(temp)),top);
        		    		
        		    
	        		    			temp=""+grid2.getValueAt(i,4);
		    	    				g2.drawString(temp,(545-fm.stringWidth(temp)),top);
						
        		    
        		    		}
        		    			top+=10;
        		    			g2.setFont(fb11);
								g2.drawLine(left,top,570,top);
					
								top+=10;
								g2.setFont(fb10);
								temp=""+saleGrossWtLb2.getText();
								g2.drawString(temp,(365-fm.stringWidth(temp)),top);
					
					
								//saleTounchLb
								g2.setFont(fb10);
								temp=""+saleTounchLb2.getText();
								g2.drawString(temp,(465-fm.stringWidth(temp)),top);
								//
								
								g2.setFont(fb10);
								temp=""+saleFineWtLb2.getText();
								g2.drawString(temp,(545-fm.stringWidth(temp)),top);
					
								top+=5;
        		    			g2.setFont(fb11);
								g2.drawLine(left,top,570,top);
					}
					top+=10;
					g2.setFont(fb10);
					temp="Closing:-";
					g2.drawString(temp,50,top);			
					
        		    top+=15;
					g2.setFont(fb10);
					temp="GrossWeight in(Gm)";
					g2.drawString(temp,50,top);			
						
        		    
					g2.setFont(fb10);
					temp=""+grossLb1.getText();
					g2.drawString(temp,170,top);			
        		    
        		    
        		    
					g2.setFont(fb10);
					temp="FineWeight in (Gm)";
					g2.drawString(temp,400,top);
        		     
        		     
        		    
					g2.setFont(fb10);
					temp=""+fineLb1.getText();
					g2.drawString(temp,510,top);
        		            		    
        		    
        		    
        		    
        		    
        		    /*top+=5;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,300,top);*/
        		    
        		   // BigDecimal wttotal=new BigDecimal("0.000");
					//BigDecimal fwttotal=new BigDecimal("0.000");
								
					/*rs=st.executeQuery("select * from Sale_temp where s_s_no="+Integer.parseInt(billno)+" and t_type='s'");
		    	    while(rs.next())
		    	    {
		    	    	top+=13;
						g2.setFont(fp8);
						fm=g2.getFontMetrics();						            
		            	temp=rs.getString("i_name").trim();
		            	System.out.println("Item Name - length:"+fm.stringWidth(temp));
		            	g2.drawString(temp,10,top);
										
		    	    	g2.setFont(fp9);
		    	    	fm=g2.getFontMetrics();
						temp=""+rs.getBigDecimal("wt").setScale(3,5);
		    	    	wttotal=wttotal.add(new BigDecimal(temp));
		    	    	g2.drawString(temp,(180-fm.stringWidth(temp)),top);
		    	    	
		    	    	temp=""+rs.getBigDecimal("tnh").setScale(2,5);
		    	    	g2.drawString(temp,(235-fm.stringWidth(temp)),top);
		    	    	
		    	    	temp=""+rs.getBigDecimal("f_wt").setScale(3,5);
		    	    	fwttotal=fwttotal.add(new BigDecimal(temp));
		    	    	g2.drawString(temp,(290-fm.stringWidth(temp)),top);
		    	    		    	
		    	   	}*/
		    	    		    
        		    //top+=7;
        		    //g2.setFont(fp9);
        		    //g2.drawString("-------------------------------------------------------------------------------------------------",left,top);
					//g2.drawLine(left,top,300,top);
        		    
						/*top+=13;
						g2.setFont(fb9);
						fm=g2.getFontMetrics();						            
		            	temp="New Total";
		            	g2.drawString(temp,10,top);
										
		    	    	g2.setFont(fb10);
		    	    	fm=g2.getFontMetrics();*/
		    	    	//temp=""+wttotal.setScale(3,5);
		    	    	//g2.drawString(temp,(180-fm.stringWidth(temp)),top);
		    	    	
		    	    	
		    	    	//temp=""+fwttotal.setScale(3,5);
		    	    	//g2.drawString(temp,(290-fm.stringWidth(temp)),top);
		    	    		    	
		    	   	//top+=7;
        		    //g2.setFont(fp9);
					//g2.drawString("-------------------------------------------------------------------------------------------------",left,top);
					//g2.drawLine(left,top,300,top);

					/*System.out.println("select slx.field3,sl.s_date from Sale_x_temp slx,Sale_temp sl where slx.s_s_no="+Integer.parseInt(billno)+" and sl.s_s_no=slx.s_s_no");
   	    		    rs=st.executeQuery("select slx.field3 from Sale_x_temp slx where slx.s_s_no="+Integer.parseInt(billno)+"");
   	    		    if(rs.next())
   	    		    {
   	    		    	System.out.println("1");
						top+=13;
						g2.setFont(fb9);
						fm=g2.getFontMetrics();						            
		            	temp="Old Balance";
		            	g2.drawString(temp,10,top);
						System.out.println("2");				
		    	    	/*g2.setFont(fp9);
		    	    	fm=g2.getFontMetrics();
						temp=""+rs.getDate(2);
						temp=temp.substring(8,10)+"/"+temp.substring(5,7)+"/"+temp.substring(0,4);
		    	    	g2.drawString(temp,100,top);
						System.out.println("3");		    	    			    	    	
		    	    	g2.setFont(fb10);
		    	    	fm=g2.getFontMetrics();
						temp=""+rs.getBigDecimal(1).setScale(3,5);
		    	    	fwttotal=fwttotal.add(new BigDecimal(temp));
		    	    	g2.drawString(temp,(290-fm.stringWidth(temp)),top);														
		    	    	System.out.println("4");
		    	    	
		    	    	rs=st.executeQuery("select * from sale where s_s_no<"+Integer.parseInt(billno)+" and p_name='"+partyCb.getSelectedItem()+"' order by s_date desc");
		    	    	if(rs.next())
		    	    	{
		    	    		g2.setFont(fp9);
		    		    	fm=g2.getFontMetrics();
							temp=""+rs.getDate("s_date");
							System.out.println("5:"+temp);
							temp=temp.substring(8,10)+"/"+temp.substring(5,7)+"/"+temp.substring(0,4);
			    	    	g2.drawString(temp,100,top);
		    	    	}
   	    		    }*/

        		    //top+=7;
        		    //g2.setFont(fp9);
					//g2.drawString("-------------------------------------------------------------------------------------------------",left,top);

						//top+=13;
						//g2.setFont(fb9);
						//fm=g2.getFontMetrics();						            
		            	//temp="Net Total";
		            	//g2.drawString(temp,10,top);
												    	    	
		    	    	//g2.setFont(fb10);
		    	    	//fm=g2.getFontMetrics();
						//temp=""+fwttotal.setScale(3,5);
		    	    	//g2.drawString(temp,(290-fm.stringWidth(temp)),top);
        		    	
					//top+=7;//7
        		    //g2.setFont(fb11);
					//g2.drawLine(left,top,300,top++);
					//g2.drawLine(left,top,300,top);
										
						//top+=13;
						//g2.setFont(fb9);
						//fm=g2.getFontMetrics();						            
		            	//temp="Jama Details";
		            	//g2.drawString(temp,10,top);
					

        		    //BigDecimal wttotal1=new BigDecimal("0.000");
					//BigDecimal fwttotal1=new BigDecimal("0.000");

					//g2.setFont(fp9);
					//rs=st.executeQuery("select * from Sale_temp where s_s_no="+Integer.parseInt(billno)+" and t_type='a'");
		    	    /*while(rs.next())
		    	    {
		    	    	top+=13;
						g2.setFont(fp8);
						//g2.setFont(fp10);
						fm=g2.getFontMetrics();						            
		            	temp=rs.getString("i_name").trim();
		            	g2.drawString(temp,10,top);
										
		    	    	g2.setFont(fp9);
		    	    	fm=g2.getFontMetrics();
						temp=""+rs.getBigDecimal("wt").setScale(3,5);
		    	    	wttotal1=wttotal1.add(new BigDecimal(temp));
		    	    	g2.drawString(temp,(180-fm.stringWidth(temp)),top);
		    	    	
		    	    	temp=""+rs.getBigDecimal("tnh").setScale(2,5);
		    	    	g2.drawString(temp,(235-fm.stringWidth(temp)),top);
		    	    	
		    	    	temp=""+rs.getBigDecimal("f_wt").setScale(3,5);
		    	    	fwttotal1=fwttotal1.add(new BigDecimal(temp));		    	    		    	
		    	    	g2.drawString(temp,(290-fm.stringWidth(temp)),top);		    	    		    	
		    	   	}*/
					
					/*top+=7;
        		    g2.setFont(fp9);
					g2.drawString("-------------------------------------------------------------------------------------------------",left,top);
					//g2.drawLine(left,top,300,top);
        		    
						top+=13;
						g2.setFont(fb9);
						fm=g2.getFontMetrics();						            
		            	temp="Jama Total";
		            	g2.drawString(temp,10,top);
										
		    	    	temp=""+wttotal1.setScale(3,5);
		    	    	g2.drawString(temp,(180-fm.stringWidth(temp)),top);
		    	    	
		    	    	
		    	    	temp=""+fwttotal1.setScale(3,5);
		    	    	g2.drawString(temp,(290-fm.stringWidth(temp)),top);
		    	    		    	
		    	   	top+=7;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,300,top++);
		    	    g2.drawLine(left,top,300,top);
		    	    		    
					top+=13;
					g2.setFont(fb9);
					fm=g2.getFontMetrics();
		            temp="Bill Uptodate";
		            g2.drawString(temp,10,top);
												    	    	
		    	    temp=""+fwttotal.subtract(fwttotal1).setScale(3,5);
		    	    fwttotal=fwttotal.subtract(fwttotal1);
		    	    g2.drawString(temp,(290-fm.stringWidth(temp)),top);
        		    			        	
        			top+=7;
        		    g2.setFont(fp9);
					g2.drawString("-------------------------------------------------------------------------------------------------",left,top);*/

					
		    	    
		    	    /*top+=13;
					g2.setFont(fb9);
					fm=g2.getFontMetrics();						            
		            temp="Bhawkata   ";
		            g2.drawString(temp,10,top);*/
							    
		    	    
					/*rs=st.executeQuery("select slx.field9,slx.field10,slx.field11,slx.rate_type from Sale_x_temp slx where slx.s_s_no="+Integer.parseInt(billno)+"");
		    	    if(rs.next())
		    	    {
		    	    	//top+=13;
		    	    	int i=fm.stringWidth(temp);
		    	    	g2.setFont(fp8);
		    	    	fm=g2.getFontMetrics();
		    	      	temp=""+rs.getBigDecimal(1).setScale(2,5)+" per "+rs.getString(4)+"   "+"Rs. "+rs.getBigDecimal(3).setScale(2,5);
		    	       	g2.drawString(temp,30+i,top);
		    	    		    	
		    	    	/*temp="Rs. "+rs.getBigDecimal(3).setScale(2,5);
		    	    	g2.drawString(temp,(190-fm.stringWidth(temp)),top);
		    	    	
		    	    	g2.setFont(fb10);
		    	    	fm=g2.getFontMetrics();
		    	    	temp=""+rs.getBigDecimal(2).setScale(3,5);
		    	    	fwttotal=fwttotal.subtract(new BigDecimal(temp));
		    	    	g2.drawString(temp,(290-fm.stringWidth(temp)),top);		    	    				
		    	    }*/
		    	    		    
		    	    /*top+=7;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,300,top);
		    	    
		    	    top+=13;
					g2.setFont(fb9);
					fm=g2.getFontMetrics();
		            temp="Final Total Balance";
		            g2.drawString(temp,10,top);*/
					
					//g2.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC,11));							    	    	
		    	   // temp=""+(fwttotal).setScale(3,5);
		    	    //g2.drawString(temp,(290-fm.stringWidth(temp)),top);
        		    		    
					/*top+=7;
        		    g2.setFont(fb11);
					g2.drawLine(left,top,300,top);
		    	    

		    	    top+=13;
					g2.setFont(fb9);
					fm=g2.getFontMetrics();
				    temp="Pending Cash Details";
		            g2.drawString(temp,10,top);
		    	    		    
   	    		    top+=13;
					g2.setFont(fb8);
					fm=g2.getFontMetrics();
				    temp="      Bhawkata      Old Jama       New Jama         Pending ";
		            g2.drawString(temp,10,top);
					
   	    		    g2.setFont(fp8);
   	    		    fm=g2.getFontMetrics();*/
					/*rs=st.executeQuery("select field4,field6,jama,field11 from Sale_x_temp where s_s_no="+Integer.parseInt(billno)+"");
   	    		    if(rs.next())
					{
						top+=13;
			    	    temp=""+rs.getBigDecimal(4).setScale(2,5);
			    	    g2.drawString(temp,(70-fm.stringWidth(temp)),top);

			    	    temp=""+rs.getBigDecimal(1).setScale(2,5);
			    	    g2.drawString(temp,(135-fm.stringWidth(temp)),top);

			    	    temp=""+rs.getBigDecimal(3).setScale(2,5);
			    	    g2.drawString(temp,(210-fm.stringWidth(temp)),top);

			    	    g2.setFont(new Font("Times New Roman",Font.BOLD|Font.ITALIC,11));							    	    	
		    	    	temp=""+rs.getBigDecimal(2).setScale(2,5);
			    	    g2.drawString(temp,(290-fm.stringWidth(temp)),top);
										
					}*/
								
		    	    //top+=7;
        		    //g2.setFont(fb11);
					//g2.drawLine(left,top,300,top);
		    	    
		    	    /*rs=st.executeQuery("select * from company_details");
					if(rs.next())
						flag=1;
					//-------------
					top+=10;
					g2.setFont(fb8);
		            temp="TIN :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+5,top);
        		    
        		    if(flag==1)
					{
						g2.setFont(fp8);
			            temp=rs.getString("tin");
			            layout=new TextLayout(temp,fp8,context);
        			    g2.drawString(temp,left+30,top);
					}
					
					g2.setFont(fb8);
		            temp="W.E.F. :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+165,top);
        		    
        		    if(flag==1)
					{
					g2.setFont(fp8);
		            temp=rs.getString("wef");
		            layout=new TextLayout(temp,fp8,context);
        		    g2.drawString(temp,left+200,top);
					}

					g2.setFont(fb8);
		            temp="C.S.T. No. :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+325,top);
        		    
        		    if(flag==1)
					{
					g2.setFont(fp8);
		            temp=rs.getString("cstno");
		            layout=new TextLayout(temp,fp8,context);
        		    g2.drawString(temp,left+375,top);
					}
					
					
					//---------
					top+=5;
        		    g2.setFont(fp9);
					g2.drawLine(left,top,left+480,top);
					
					top+=10;
					g2.setFont(fb8);
		            temp="Phone No. :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+5,top);

        		    if(flag==1)
					{
						g2.setFont(fp8);
			            temp=rs.getString("phno");
			            System.out.println("a");
			            try
			            {if(temp.trim().length()>0)
			            {
			            	layout=new TextLayout(temp,fp8,context);
        			    	g2.drawString(temp,left+55,top);
        			    }
        			    System.out.println("b");
        			    }
        			    catch(Exception x){}
        			}   
					
					g2.setFont(fb8);
		            temp="Mobile No. :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+325,top);

        		    if(flag==1)
					{
						g2.setFont(fp8);
			            temp=rs.getString("mobno");
			            layout=new TextLayout(temp,fp8,context);
        			    g2.drawString(temp,left+375,top);
					}

					//-----------------
					top+=5;
        		    g2.setFont(fp9);
					g2.drawLine(left,top,left+480,top);
					
					String partynm="";					
					rs1=st1.executeQuery("select * from sale_details where bill_no="+Integer.parseInt(printToBillNo));
					if(rs1.next())
					{
						top+=10;
						g2.setFont(fb8);
			            temp="Book No. :";
		    	        layout=new TextLayout(temp,fb8,context);
        			    g2.drawString(temp,left+5,top);
					
					if(flag==1)
					{
						g2.setFont(fp8);
			            temp=rs1.getString("book_no");
			            layout=new TextLayout(temp,fp8,context);
        			    g2.drawString(temp,left+50,top);
					}
					
					g2.setFont(fb8);
		            temp="Serial No. :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+165,top);
					
					if(flag==1)
					{
						g2.setFont(fp8);
			            temp=rs1.getString("book_serial_no");
			            layout=new TextLayout(temp,fp8,context);
        			    g2.drawString(temp,left+215,top);
					}

        		    g2.setFont(fp9);
					g2.drawLine(left+160,top-10,left+160,top+5);
					g2.setFont(fb8);
		            temp="Sale Date :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+325,top);

						g2.setFont(fp8);
			            temp=rs1.getString("date");
			            temp=temp.substring(8,10)+"-"+temp.substring(5,7)+"-"+temp.substring(0,4);
			            layout=new TextLayout(temp,fp8,context);
        			    g2.drawString(temp,left+375,top);
        			    
        			    partynm=rs1.getString("party_nm");
					}

					top+=5;
        		    g2.setFont(fp9);
					g2.drawLine(left,top,left+480,top);
					
					flag=0;
					
					//ABOUT BUYER
					rs=st.executeQuery("select * from sale_tin_details where billno='"+printToBillNo+"'");
					if(rs.next())
						flag=1;
					
					top+=10;
        		    g2.setFont(fb8);
		            temp="Buyer:";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+5,top);
					
					System.out.println("top="+top);
					//top+=10;
        		    if(flag==1)
					{
						g2.setFont(fb9);
						if(!partynm.equals("Cash"))
						{
							layout=new TextLayout(partynm.toUpperCase(),fb10,context);
	        				g2.drawString(partynm.toUpperCase(),left+35,top);	        			    
						}
						else
						{
							layout=new TextLayout("CASH",fb10,context);
	        				g2.drawString("CASH",left+35,top);	        			    						
						}
			            temp=""+rs.getString("address");
			            //layout=new TextLayout(temp,fb9,context);
        			    //g2.drawString(temp,left+10,top);
        			    if(temp.length()>0 && !temp.equals("null"))
			            {
			            	do
			            	{
			            		top+=10;
			            		if(temp.indexOf("\n")<=0)
			            		{
			            			layout=new TextLayout(temp,fb9,context);
	        			    		g2.drawString(temp,left+35,top);
	        			    		temp="";
			            		}
			            		else
			            		{			            		
			            			String subtemp=temp.substring(0,temp.indexOf("\n"));	
				            		layout=new TextLayout(subtemp,fb9,context);
	        			    		g2.drawString(subtemp,left+35,top);
	        			    		temp=temp.substring(temp.indexOf("\n")+1,temp.length());	
	        			    	}
	        			    	
			            	}
			            	while(temp.length()>0);
        			    }
					}

					//buyer's tin no
					top=115;
					g2.setFont(fb8);
		            temp="TIN :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+325,top);

        		    if(flag==1)
					{
						g2.setFont(fp8);
			            temp=rs.getString("tin");
			            if(temp.length()>0)
			            {
			            	layout=new TextLayout(temp,fp8,context);
        			    	g2.drawString(temp,left+350,top);
        			    }
					}
					top+=5;
        		    g2.setFont(fp9);
					g2.drawLine(left+320,top,left+480,top);
					
					top+=10;
					g2.setFont(fb8);
		            temp="W.E.F. :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+325,top);

        		    if(flag==1)
					{
						g2.setFont(fp8);
			            temp=rs.getString("wef");
			            if(temp.length()>0)
			            {
			            	layout=new TextLayout(temp,fp8,context);
        			   	 	g2.drawString(temp,left+360,top);
        			    }
        			 }   
					
					top+=5;
        		    g2.setFont(fp9);
					g2.drawLine(left+320,top,left+480,top);
					
					top+=10;
					g2.setFont(fb8);
		            temp="Phone No. :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+325,top);

        		    if(flag==1)
					{
						g2.setFont(fp8);
			            temp=rs.getString("phno");
			            if(temp.length()>0)
			            {
			            	layout=new TextLayout(temp,fp8,context);
        			    	g2.drawString(temp,left+375,top);
        			    }
					}
					top+=5;
        		    g2.setFont(fp9);
					g2.drawLine(left+320,top,left+480,top);
					
					top+=10;
					g2.setFont(fb8);
		            temp="Mobile No. :";
		            layout=new TextLayout(temp,fb8,context);
        		    g2.drawString(temp,left+325,top);

        		    if(flag==1)
					{
						g2.setFont(fp8);
			            temp=rs.getString("mobno");
			            if(temp.length()>0)
			            {
			            	layout=new TextLayout(temp,fp8,context);
        			    	g2.drawString(temp,left+375,top);
        			    }
					}
					flag=0;
					//---------------
					top+=20;
					g2.setFont(fp9);
					g2.drawLine(left,top,left+480,top);//horizontal line
					g2.drawLine(left+205,top,left+205,top+500);//vertical line
					g2.drawLine(left+242,top,left+242,top+500);//vertical line
					g2.drawLine(left+292,top,left+292,top+500);//vertical line
					g2.drawLine(left+317,top,left+317,top+500);//vertical line
					g2.drawLine(left+357,top,left+357,top+500);//vertical line
					g2.drawLine(left+382,top,left+382,top+500);//vertical line
					g2.drawLine(left+422,top,left+422,top+500);//vertical line
					g2.drawLine(left,top+480,left+480,top+480);//horizontal line
					g2.drawLine(left,top+500,left+480,top+500);//horizontal line
					g2.drawLine(left+242,top+500,left+242,top+600);//vertical line
					
					//heading
					g2.setFont(fb8);
					    temp="Description of Goods                                     Qty.            	Rate        Dis(%)  Dis(Rs.)  VAT(%)  VAT(Rs.)   Amount(Rs.)";
			            layout=new TextLayout(temp,fb8,context);
        			    g2.drawString(temp,left+50,top-5);
					
					int totalQty=0;
					BigDecimal disAmt=new BigDecimal("0");
					BigDecimal vatAmt=new BigDecimal("0");
					BigDecimal paybleAmt=new BigDecimal("0");
					//code to print sale data
					rs=st.executeQuery("select * from sale_details where bill_no="+Integer.parseInt(printToBillNo)+"");											
					while(rs.next())
					{
						top+=15;
						g2.setFont(fp8);
			            fm=g2.getFontMetrics();				
						//quantity
			            temp=rs.getString("qty");
			            totalQty=totalQty+Integer.parseInt(temp);
			            temp=temp+" Unit";			            
						layout=new TextLayout(temp,fp8,context);
						g2.drawString(temp,(left+240)-fm.stringWidth(temp),top);
			            
			            //rate
			            temp=""+rs.getBigDecimal("rate").setScale(2,5);
						layout=new TextLayout(temp,fp8,context);
						g2.drawString(temp,(left+290)-fm.stringWidth(temp),top);
			            
						//discount in %
			            temp=""+rs.getBigDecimal("dis_pc").setScale(0,5);
			            if(!temp.trim().equals("0") && !temp.trim().equals("0.0") && !temp.trim().equals("0.00"))
						{
							layout=new TextLayout(temp,fp8,context);
							g2.drawString(temp,(left+315)-fm.stringWidth(temp),top);
			            }
			            
			            //discount in rs.
			            temp=""+rs.getBigDecimal("dis_rs").setScale(2,5);
						if(!temp.trim().equals("0") && !temp.trim().equals("0.0") && !temp.trim().equals("0.00"))
						{
							layout=new TextLayout(temp,fp8,context);
							g2.drawString(temp,(left+355)-fm.stringWidth(temp),top);
							disAmt=disAmt.add(new BigDecimal(temp));
			            }
			            
						//VAT in %
			            temp=""+rs.getBigDecimal("vat_pc").setScale(2,5);
			            if(!temp.trim().equals("0") && !temp.trim().equals("0.0") && !temp.trim().equals("0.00"))
						{
							layout=new TextLayout(temp,fp8,context);
							g2.drawString(temp,(left+380)-fm.stringWidth(temp),top);
			            }
			            
			            //VAT in rs.
			            temp=""+rs.getBigDecimal("vat_rs").setScale(2,5);
						layout=new TextLayout(temp,fp8,context);
						g2.drawString(temp,(left+420)-fm.stringWidth(temp),top);
						vatAmt=vatAmt.add(new BigDecimal(temp));
			            
			            //Total amount in rs.
			            temp=""+rs.getBigDecimal("net_amt").setScale(2,5);
						layout=new TextLayout(temp,fp8,context);
						g2.drawString(temp,(left+475)-fm.stringWidth(temp),top);
						
			            paybleAmt=paybleAmt.add(new BigDecimal(temp));
						
						//item name
			            int ino=rs.getInt("i_no");
			            rs1=st1.executeQuery("select * from item_master where i_no="+ino);
			            if(rs1.next())
			            {
							g2.setFont(fb9);
				            fm=g2.getFontMetrics();				
			            	temp=rs1.getString("i_nm");
			            	String comno=rs1.getString("c_no");
			            	ResultSet rs2=st2.executeQuery("select * from company_master where c_no="+comno);
			            	if(rs2.next())
			            	{
			            		temp=rs2.getString("c_nm")+" "+temp;
			            	}
			            	int lpos=left+5;
			            	String subtemp="";
			            	while(temp.length()>0)
			            	{
			            		subtemp=temp.substring(0,1);
			            		lpos=lpos+fm.stringWidth(subtemp);
			            		if(lpos>(left+200))
			            		{
			            			lpos=left+5;
			            			top+=15;
			            		}
			            		else
			            			lpos=lpos-fm.stringWidth(subtemp);			            		
			            			
			            		layout=new TextLayout(subtemp,fb9,context);
	        			    	g2.drawString(subtemp,lpos,top);
	        			    	temp=temp.substring(1,temp.length());	
	        			    	lpos=lpos+fm.stringWidth(subtemp);			            		
	        			    }	
			            	
			            	temp=rs.getString("serial_no");
			            	if(temp.length()>0)
			            	{
			            		top+=15;
			            		g2.setFont(fp8);			            		
			            		layout=new TextLayout("B.No.-",fp8,context);
       			    			g2.drawString("B.No.-",left+15,top);
			            		g2.setFont(fb8);
			            	
		            			layout=new TextLayout(temp,fb8,context);
       			    			g2.drawString(temp,left+40,top);
       			    		}
						}
					}	
					
					top=675;
					g2.setFont(fb9);
					temp="Total";
					layout=new TextLayout(temp,fb9,context);
					g2.drawString(temp,(left+200)-fm.stringWidth(temp),top);
					
					temp=""+totalQty+" Unit";
					layout=new TextLayout(temp,fb9,context);
					g2.drawString(temp,(left+240)-fm.stringWidth(temp),top);
					
					temp=""+disAmt.setScale(2,5);
					layout=new TextLayout(temp,fb9,context);
					g2.drawString(temp,(left+355)-fm.stringWidth(temp),top);

					temp=""+vatAmt.setScale(2,5);
					layout=new TextLayout(temp,fb9,context);
					g2.drawString(temp,(left+420)-fm.stringWidth(temp),top);

					g2.setFont(fb10);
					temp=""+paybleAmt.setScale(2,5);
					layout=new TextLayout(temp,fb10,context);
					g2.drawString(temp,(left+475)-fm.stringWidth(temp),top);
					
					g2.setFont(fp9);
					//g2.drawLine(left+240,top+15,left+240,top+250);
					top+=75;
					
					temp="Signature of Autherised Signatory";
					layout=new TextLayout(temp,fp9,context);
					g2.drawString(temp,left+5,top);
					
					temp="Signature of Issuing Tax Invoice";
					layout=new TextLayout(temp,fp9,context);
					g2.drawString(temp,left+250,top);
					
					top+=10;
					temp="Name :";
					layout=new TextLayout(temp,fp9,context);
					g2.drawString(temp,left+5,top);
																
					temp="Name :";
					layout=new TextLayout(temp,fp9,context);
					g2.drawString(temp,left+250,top);
																
					top+=10;
					temp="Designation :";
					layout=new TextLayout(temp,fp9,context);
					g2.drawString(temp,left+5,top);
																
					temp="Designation :";
					layout=new TextLayout(temp,fp9,context);
					g2.drawString(temp,left+250,top);
					*/											
         		}
         		catch(Exception x)
         		{
	        		System.out.println("BPError2193821..."+x);
         		}
         	}
      	}
	}

}	