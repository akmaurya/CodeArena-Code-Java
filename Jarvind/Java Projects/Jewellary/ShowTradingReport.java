import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;

public class ShowTradingReport extends JFrame implements ActionListener,KeyListener//,MouseListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	JTable grid,grid2;//,table1,table1Detail;
	JButton showBtn,printBtn,closeBtn,resetBtn;
	DefaultTableModel dtm,dtm2;//,model1,model1Detail;
	JTextField dateTf,dateTf1;	
	JDesktopPane desk;
	JComboBox itemCb;
		
	public ShowTradingReport(JDesktopPane desk)
	{
		this.desk=desk;
		frm=new JInternalFrame("REPORT : SHOW TRADING PARTY WISE IN A DATE RANGE",false,true,false,false);
		con=frm.getContentPane();
		con.setLayout(null);
		
		JLabel lab1=new JLabel(" For Party");
		JLabel lab6=new JLabel("Enter Date :");
		JLabel lab10=new JLabel(" Purchased");
		JLabel lab11=new JLabel(" Sold");
		
		dateTf=new JTextField();
		dateTf1=new JTextField();
		itemCb=new JComboBox();
		

		String heading[]={"S.No.","Date","Party Name","Bill No.","Pur. Fine Wt.(gm)","Adj. Wt.(gm)","Closing Wt.","Closing Amt."};
		dtm=new DefaultTableModel(heading,0);
		grid=new JTable(dtm);
		JScrollPane jsp2=new JScrollPane(grid,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
   		CRLeft.setHorizontalAlignment(JLabel.LEFT);
      	CRRight.setHorizontalAlignment(JLabel.RIGHT);
   		CRCenter.setHorizontalAlignment(JLabel.CENTER);   		
   		TableColumn column;
   		column=grid.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(40);
   		column=grid.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(80);
   		column=grid.getColumn("Party Name");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(180);
   		column=grid.getColumn("Bill No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(70);
   		column=grid.getColumn("Pur. Fine Wt.(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(120);
   		column=grid.getColumn("Adj. Wt.(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(110);
   		column=grid.getColumn("Closing Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid.getColumn("Closing Amt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(130);


		String heading2[]={"S.No.","Date","Party Name","Bill No.","Sale Fine Wt.(gm)","Adj. Wt.(gm)","Closing Wt.","Closing Amt."};
		dtm2=new DefaultTableModel(heading2,0);
		grid2=new JTable(dtm2);
		JScrollPane jsp3=new JScrollPane(grid2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		column=grid2.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(40);
   		column=grid2.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(80);
   		column=grid2.getColumn("Party Name");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(180);
   		column=grid2.getColumn("Bill No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(70);
   		column=grid2.getColumn("Sale Fine Wt.(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(120);
   		column=grid2.getColumn("Adj. Wt.(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(110);
   		column=grid2.getColumn("Closing Wt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid2.getColumn("Closing Amt.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(130);

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
		itemCb.setBounds(580,35,220,20);		
		lab6.setBounds(10,10,100,20);
		lab10.setBounds(10,84,800,20);		
		lab11.setBounds(10,280,800,20);		
		dateTf.setBounds(95,10,130,20);		
		dateTf1.setBounds(240,10,130,20);		
		jsp2.setBounds(10,105,800,150);
		jsp3.setBounds(10,300,800,150);
		showBtn.setBounds(400,10,100,20);
		printBtn.setBounds(280,460,100,25);
		resetBtn.setBounds(390,460,100,25);
		closeBtn.setBounds(500,460,100,25);
		
		lab1.setOpaque(true);
		lab10.setOpaque(true);
		lab11.setOpaque(true);
		
		lab1.setBackground(new Color(254,171,193));
		
		lab10.setBackground(new Color(249,230,194));
		
		lab11.setBackground(new Color(206,215,254));
		showBtn.setMnemonic('s');
		printBtn.setMnemonic('p');
		closeBtn.setMnemonic('c');
		resetBtn.setMnemonic('r');
		
		addItem();
		
		con.add(lab1);
		con.add(itemCb);
		con.add(lab6);
		con.add(lab10);
		con.add(lab11);
		con.add(dateTf1);
		con.add(dateTf);
		con.add(jsp2);
		con.add(jsp3);
		con.add(showBtn);
		con.add(printBtn);
		con.add(resetBtn);
		con.add(closeBtn);
		
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
		int y = (ds.height-530)/2;
   		frm.reshape(x,35,830,530);
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
		}
		else if(e.getSource()==resetBtn)
		{
			frm.dispose();
			new ShowTradingReport(desk);
		}
		else if(e.getSource()==dateTf)
		{
			showBtn.requestFocus();
		}
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
		}
		else if(e.getSource()==resetBtn && e.getKeyCode()==10)
		{
			frm.dispose();
			new ShowTradingReport(desk);
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
			Purchase pc=new Purchase(desk,Integer.parseInt(""+grid.getValueAt(grid.getSelectedRow(),3)));
		}
		else if(e.getSource()==grid2 && e.getKeyCode()==10)
		{
			e.consume();
			Sale pc=new Sale(desk,Integer.parseInt(""+grid2.getValueAt(grid2.getSelectedRow(),3)));
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
			
			double grossWt=0,fineWt=0,tnh=0;
			
			
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
	       	String qry="";
	       	while(fromDtLong<=toDtLong)
	       	{
	       		dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
				qry="select all distinct p_s_no,p_name,p_date from purchase where p_Date=#"+dt+"#";
				if(itemCb.getSelectedIndex()>0)
				{
					qry="select all distinct p_s_no,p_name,p_date from purchase where p_Date=#"+dt+"# and p_name='"+itemCb.getSelectedItem()+"'";
				}
				rs2=st2.executeQuery(qry);
		       	while(rs2.next())
		       	{
		       		System.out.print("a");
			       	String arr[]=new String[8];
			       	arr[0]=""+(grid.getRowCount()+1)+" ";
		    	   	arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		       		arr[2]=rs2.getString("p_name");
		       		arr[3]=rs2.getString("p_s_no");
		       		
		       		rs1=st1.executeQuery("select * from purchase_x where p_s_no="+Integer.parseInt(arr[3])+"");		
	       			while(rs1.next())
	       			{
	       				arr[4]=rs1.getString("field2");
	       				arr[5]=rs1.getString("field8");
	       				arr[6]=rs1.getString("field5");
	       				arr[7]=rs1.getString("field6");
	       			}
	       			dtm.addRow(arr);
	       		}
	       		fromDtLong+=86400000;
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
	       	
				qry="select all distinct s_s_no,p_name,s_date from sale where s_Date=#"+dt+"#";
				if(itemCb.getSelectedIndex()>0)
				{
					qry="select all distinct s_s_no,p_name,s_date from sale where s_Date=#"+dt+"# and p_name='"+itemCb.getSelectedItem()+"'";
				}
	       		rs2=st2.executeQuery(qry);
	       		while(rs2.next())
	       		{
			       	String arr[]=new String[8];
			       	arr[0]=""+(grid2.getRowCount()+1)+" ";
			       	arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		    	   	arr[2]=rs2.getString("p_name");
	       			arr[3]=rs2.getString("s_s_no");
	       		
		       		rs1=st1.executeQuery("select * from sale_x where s_s_no="+Integer.parseInt(arr[3])+"");		
	       			while(rs1.next())
	       			{
	       				arr[4]=rs1.getString("field2");
	       				arr[5]=rs1.getString("field8");
	       				arr[6]=rs1.getString("field5");
	       				arr[7]=rs1.getString("field6");
	       			}
	       			dtm2.addRow(arr);
	       		}
	       		
	       		
	       		fromDtLong+=86400000;
	       	}
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
	}
	
	private void addItem()
	{		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	ResultSet rs1;
	       	itemCb.addItem("All Party");
	       	rs1=st1.executeQuery("select * from partyDetails order by partyName");
	       	while(rs1.next())
	       	{
	       		itemCb.addItem(rs1.getString("partyName"));
	       	}
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457912..."+x);
		}
	}	       		
	
	
}	