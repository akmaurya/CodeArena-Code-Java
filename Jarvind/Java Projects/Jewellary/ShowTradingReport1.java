import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;

public class ShowTradingReport1 extends JFrame implements ActionListener,KeyListener//,MouseListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	JTable grid,grid2;//,table1,table1Detail;
	JButton showBtn,showBtn1,printBtn,closeBtn,resetBtn;
	DefaultTableModel dtm,dtm2;//,model1,model1Detail;
	JTextField dateTf,dateTf1;	
	JDesktopPane desk;
	JComboBox itemCb,itemCb1;
	JLabel pu_wtlb,sal_wtlb;
		
	public ShowTradingReport1(JDesktopPane desk)
	{
		this.desk=desk;
		frm=new JInternalFrame("REPORT : SHOW TRADING PARTY WISE IN A DATE RANGE",false,true,false,false);
		con=frm.getContentPane();
		con.setLayout(null);
		
		//JLabel lab1=new JLabel(" For Party");
		JLabel lab6=new JLabel("Enter Date :");
		JLabel lab10=new JLabel(" Purchased");
		JLabel lab11=new JLabel(" Sold");
		 pu_wtlb=new JLabel("");
		 sal_wtlb=new JLabel("");
		 pu_wtlb.setHorizontalAlignment(JLabel.RIGHT);
		 sal_wtlb.setHorizontalAlignment(JLabel.RIGHT);
		 
		
		dateTf=new JTextField();
		dateTf1=new JTextField();
		itemCb=new JComboBox();
		itemCb1=new JComboBox();
		

		String heading[]={"S.No.","Date","Item Name","Wt.(gm)"};
		dtm=new DefaultTableModel(heading,0);
		grid=new JTable(dtm);
		grid.setEnabled(false);
		grid.setSelectionBackground(new Color(255,157,157));
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
   		column.setPreferredWidth(70);
   		column=grid.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(350);
   		column=grid.getColumn("Item Name");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(230);
   		/*column=grid.getColumn("Bill No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(70);*/
   		column=grid.getColumn("Wt.(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);
   		/*column=grid.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(110);
   		column=grid.getColumn("pieces");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid.getColumn(" Fine Wt.(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(130);*/


		String heading2[]={"S.No.","Date","Item Name","Wt.(gm)"};
		dtm2=new DefaultTableModel(heading2,0);
		grid2=new JTable(dtm2);
		
		grid2.setEnabled(false);
		grid2.setSelectionBackground(new Color(255,157,157));
		JScrollPane jsp3=new JScrollPane(grid2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		column=grid2.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(70);
   		column=grid2.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(350);
   		column=grid2.getColumn("Item Name");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(230);
   		/*column=grid2.getColumn("Bill No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(70);*/
   		column=grid2.getColumn("Wt.(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);
   		/*column=grid2.getColumn("Tounch");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(110);
   		column=grid2.getColumn("pieces");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(90);
   		column=grid2.getColumn(" Fine Wt.(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(130);*/

		java.util.Date dt=new java.util.Date();		
		String tmp=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		dateTf.setText(tmp);
		dateTf1.setText(tmp);
		dateTf.setHorizontalAlignment(JTextField.CENTER);
		dateTf1.setHorizontalAlignment(JTextField.CENTER);
		
		showBtn=new JButton("Show");		
		showBtn1=new JButton("Show");		
		printBtn=new JButton("Print");
		resetBtn=new JButton("Reset");
		closeBtn=new JButton("Close");
				
								
		//lab1.setBounds(10,35,560,20);		
		itemCb.setBounds(10,60,220,20);		
		itemCb1.setBounds(10,290,220,20);		
		lab6.setBounds(10,10,100,20);
		lab10.setBounds(10,84,800,20);		
		lab11.setBounds(10,310,800,20);		
		dateTf.setBounds(95,10,130,20);		
		dateTf1.setBounds(240,10,130,20);		
		jsp2.setBounds(10,105,800,150);
		jsp3.setBounds(10,330,800,150);
		showBtn.setBounds(400,60,100,20);
		showBtn1.setBounds(400,290,100,20);
		printBtn.setBounds(280,530,100,25);
		resetBtn.setBounds(390,530,100,25);
		closeBtn.setBounds(500,530,100,25);
		
		//lab1.setOpaque(true);
		lab10.setOpaque(true);
		lab11.setOpaque(true);
		
		//lab1.setBackground(new Color(254,171,193));
		
		lab10.setBackground(new Color(249,230,194));
		
		lab11.setBackground(new Color(206,215,254));
		pu_wtlb.setBackground(new Color(252,251,213));
		sal_wtlb.setBackground(new Color(252,251,213));
		pu_wtlb.setBounds(550,260,200,20);
		pu_wtlb.setOpaque(true);
		sal_wtlb.setOpaque(true);		
		sal_wtlb.setBounds(550,490,200,20);
		showBtn.setMnemonic('s');
		printBtn.setMnemonic('p');
		closeBtn.setMnemonic('c');
		resetBtn.setMnemonic('r');
		
		addItem();
		addItem1();
		
		//con.add(lab1);
		con.add(itemCb);
		con.add(itemCb1);
		con.add(lab6);
		con.add(lab10);
		con.add(lab11);
		con.add(dateTf1);
		con.add(dateTf);
		con.add(jsp2);
		con.add(pu_wtlb);
		con.add(jsp3);
		con.add(sal_wtlb);
		con.add(showBtn);
		con.add(showBtn1);
		con.add(printBtn);
		con.add(resetBtn);
		con.add(closeBtn);
		
		itemCb.addActionListener(this);
		itemCb1.addActionListener(this);
		showBtn.addActionListener(this);
		showBtn.addKeyListener(this);
		showBtn1.addActionListener(this);
		showBtn1.addKeyListener(this);
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
   		frm.reshape(x,35,830,600);
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
		else if(e.getSource()==showBtn1)
		{
			showData1();			
		}
		else if(e.getSource()==resetBtn)
		{
			frm.dispose();
			new ShowTradingReport1(desk);
		}
		else if(e.getSource()==dateTf)
		{
			showBtn.requestFocus();
		}
		else if(e.getSource()==itemCb)
		{
			showData();
		}
		else if(e.getSource()==itemCb1)
		{
			showData1();
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
		else if(e.getSource()==showBtn1 && e.getKeyCode()==10)
		{
			showData1();
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
			//while(grid2.getRowCount()>0)	dtm2.removeRow(0);
			
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
	       	double total=0;
	       //	while(fromDtLong<=toDtLong)
	       	//{
	       		dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
				dt1=((new Date(toDtLong)).getMonth()+1)+"/"+(new Date(toDtLong)).getDate()+"/"+((new Date(toDtLong)).getYear()+1900);
				qry="select all distinct i_name from purchase  where  p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# and t_type='p' ";
				
				if(itemCb.getSelectedIndex()>0)
				{
					qry="select all distinct i_name from purchase  where p_Date>=#"+dt+"# and p_Date<=#"+dt1+"#  and p_name='"+itemCb.getSelectedItem()+"' and t_type='p'  ";
					
				}
				
				rs2=st2.executeQuery(qry);
		       	while(rs2.next())
		       	{
		       		System.out.print("a");
			       	String arr[]=new String[4];
			       	String arr1[]=new String[4];
			       	arr[2]=rs2.getString("i_name");
			       	rs1=st1.executeQuery("select * from purchase where  i_name='"+arr[2]+"' and  t_type='p' and p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# order by p_Date");		
			       	//rs1=st1.executeQuery("select * from sale where  i_name='"+arr[2]+"' and  t_type='s' and p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# order by p_Date");		
			       	if(itemCb.getSelectedIndex()>0)
			       	{
			       		rs1=st1.executeQuery("select * from purchase where  i_name='"+arr[2]+"'  and p_name='"+itemCb.getSelectedItem()+"' and  t_type='p' and p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# order by p_Date");		
			       	}
			       	while(rs1.next())
	       			{
			       		arr[0]=""+(grid.getRowCount()+1)+" ";
		    	   		
		    	   		Date dt4= rs1.getDate("p_date");
	        			String d= dt4.toString();
						String da[]= d.split("-");
						String temp = da[2]+ "-" + da[1] + "-" + da[0];

		    	   		arr[1]=temp;
		    	   				    	   		
		       			String j=rs1.getString("wt");
		       			arr[3]=""+(new BigDecimal(j)).setScale(3,5);
		       			dtm.addRow(arr);
		       		}
		       		//double l=Double.parseDouble(arr[2]);
		       		//total=total+l;
		       		
		       		
	       			
	       				//String q=rs1.getString(1);
	       				//arr[3]=""+(new BigDecimal(q)).setScale(3,5);
	       				//arr[2]=""+(new BigDecimal(temp)).setScale(3,5);
	       				rs3=st3.executeQuery("select sum(wt) from purchase where i_name='"+arr[2]+"' and t_type='p' and p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# ");		
	       				if(itemCb.getSelectedIndex()>0)
	       				{
	       					rs3=st3.executeQuery("select sum(wt) from purchase where i_name='"+arr[2]+"'  and p_name='"+itemCb.getSelectedItem()+"' and t_type='p' and p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# ");		
	       				}
	       				if(rs3.next())
	       				{
	       				 	String h=""+rs3.getDouble(1);  
	       				 	arr1[3]=""+(new BigDecimal(h)).setScale(3,5);
	       					arr1[0]="";
	       					arr1[1]="";
	       					arr1[2]="";
							double f=Double.valueOf(arr1[3]);
	       					total=total+f;
							//total=total+(new BigDecimal(h)).setScale(3,5);
							//dtm.setBackground(new Color(252,251,213));
							//grid.addRowSelectionInterval(4,4);							
	       				}
	       				
	       				
	       				//System.out.println("dhananjay.........."+q);
	       				//arr1.setBackground(new Color(252,251,213));
	       				//arr1.setBackground(Color.red);
	       				dtm.addRow(arr1);
	       				int i=grid.getRowCount()-1;
	       				grid.addRowSelectionInterval(i,i);
	       			}
	       			
													
						/*for(int i=0;i<grid.getRowCount();i++)
						{
							str=""+grid.getValueAt(i,1);
							try
							{
								str=str.substring(str.length()-2,str.length());
								if(str.equals(""))
								grid.addRowSelectionInterval(i,i);							
							}
							catch(Exception x){}

	       				}*/
	       			//arr[2]=""+total;
	       			
	       		//}
	       			System.out.println("dhananjay..........q1=err4"+total);
	       		String p=""+total;System.out.println("dhananjay..........q1=err3333");
	       		pu_wtlb.setText(""+(new BigDecimal(p)).setScale(3,5));
	       			System.out.println("dhananjay..........q1=err3");
	       		fromDtLong+=86400000;
	       	//}
	       	
	       	
	       	//CODE FOR GETTING TODAY'S  'OUT'
	       	db=0;
	       	count1=0;
	       	flag=0;
	       	gWt1=0;tnh1=0;fWt1=0;
			double total1=0;
			tmp=dateTf.getText();
	       	dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
	       	fromDtLong=Date.parse(dt);
			
	       	//while(fromDtLong<=toDtLong)
	       //	{
	       		//dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
	       	
				//qry="select all distinct i_name from sale where s_Date>=#"+dt+"# and s_Date<=#"+dt1+"#  and t_type='s' group by i_name,wt";
				//
				//if(itemCb.getSelectedIndex()>0)
				//{
				//	qry="select all distinct  i_name from sale where s_Date>=#"+dt+"# and s_Date<=#"+dt1+"#  and p_name='"+itemCb.getSelectedItem()+"' and t_type='s' group by i_name,wt";
					//
					//s_s_no,i_name,s_date
				//}/
	       		//rs2=st2.executeQuery(qry);
	       		//while(rs2.next())
	       		//{		System.out.println("dhananjay..........q1=err2");
			      // 	String arr[]=new String[3];
			       	//arr[0]=""+(grid2.getRowCount()+1)+" ";
			       	//arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		    	   	//arr[1]=rs2.getString(1);
	       			//arr[3]=rs2.getString("s_s_no");
	       		
		       		//rs1=st1.executeQuery("select * from sale where s_s_no="+Integer.parseInt(arr[3])+" and t_type='s'");		
	       			//	System.out.println("dhananjay..........q1=err1");
	       			//rs1=st1.executeQuery("select sum(wt) from sale where i_name='"+arr[1]+"'and t_type='s'");		
	       			//while(rs1.next())
	       			//{
	       			////	double q=rs1.getDouble(1);
	       				///arr[2]=""+(new BigDecimal(q)).setScale(3,5);
	       				//double r=Double.valueOf(arr[2]);
	       				//total1=total1+r;
	       			///	System.out.println("dhananjay..........q1="+q);
	       				//arr[5]=rs2.getString("tnh");
	       				//arr[6]=rs2.getString("pcs");
	       				//arr[7]=rs2.getString("f_wt");

	       			///}
	       			//dtm2.addRow(arr);
	       		//}
	       		//S/tring s1=""+total1;
	       		//sal_wtlb.setText(""+(new BigDecimal(s1)).setScale(3,5));
	       		//fromDtLong+=86400000;
	       	//}
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457...p"+x);
		}
	}
	
	/////////////////////////
	private void showData1()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	Statement st2=cn.createStatement();
	       	Statement st3=cn.createStatement();
	       	ResultSet rs1,rs2,rs3;
	       	      	
	       	String category=""+itemCb1.getSelectedItem();	       	
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
			
						
	       	//while(grid.getRowCount()>0)		dtm.removeRow(0);
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
	       	double total=0;
	       //	while(fromDtLong<=toDtLong)
	       	//{
	       		dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
				dt1=((new Date(toDtLong)).getMonth()+1)+"/"+(new Date(toDtLong)).getDate()+"/"+((new Date(toDtLong)).getYear()+1900);
				qry="select all distinct i_name from purchase  where  p_Date>=#"+dt+"# and p_Date<=#"+dt1+"# and t_type='p' ";
				
				/*if(itemCb.getSelectedIndex()>0)
				{
					qry="select all distinct  i_name from purchase  where p_Date>=#"+dt+"# and p_Date<=#"+dt1+"#  and p_name='"+itemCb.getSelectedItem()+"' and t_type='p' group by i_name,wt  ";
					
				}
				
				rs2=st2.executeQuery(qry);
		       	while(rs2.next())
		       	{
		       		System.out.print("a");
			       	String arr[]=new String[3];
			       	String arr1[]=new String[3];
			       	arr[0]=""+(grid.getRowCount()+1)+" ";
		    	   	
		       		arr[1]=rs2.getString("i_name");
		       		
		       		//double l=Double.parseDouble(arr[2]);
		       		//total=total+l;
		       		
		       		rs1=st1.executeQuery("select sum(wt) from purchase where i_name='"+arr[1]+"'and t_type='p'");		
	       			while(rs1.next())
	       			
	       			{
	       				double q=rs1.getDouble(1);
	       				arr[2]=""+(new BigDecimal(q)).setScale(3,5);
	       				//arr[2]=""+(new BigDecimal(temp)).setScale(3,5);
	       				//arr1[0]="";
	       				//arr1[1]="";
	       				double f=Double.parseDouble(arr[2]);
	       				total=total+f;
	       				System.out.println("dhananjay.........."+q);
	       				//dtm.addRow(arr1);
	       			}
	       			
	       			//arr[2]=""+total;
	       			dtm.addRow(arr);
	       		}*/
	       		//	System.out.println("dhananjay..........q1=err4"+total);
	       		//String p=""+total;System.out.println("dhananjay..........q1=err3333");
	       		//pu_wtlb.setText(""+(new BigDecimal(p)).setScale(3,5));
	       		///	System.out.println("dhananjay..........q1=err3");
	       		//fromDtLong+=86400000;
	       	//}
	       	
	       	
	       	//CODE FOR GETTING TODAY'S  'OUT'
	       	db=0;
	       	count1=0;
	       	flag=0;
	       	gWt1=0;tnh1=0;fWt1=0;
			double total1=0;
			tmp=dateTf.getText();
	       	dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
	       	fromDtLong=Date.parse(dt);
			
	       	//while(fromDtLong<=toDtLong)
	       //	{
	       		dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
	       	
				qry="select all distinct i_name  from sale where s_Date>=#"+dt+"# and s_Date<=#"+dt1+"#  and t_type='s'  ";
				//all distinct
				if(itemCb1.getSelectedIndex()>0)
				{
					qry="select all distinct i_name  from sale where s_Date>=#"+dt+"# and s_Date<=#"+dt1+"#  and p_name='"+itemCb1.getSelectedItem()+"' and t_type='s'  ";
					//
					//s_s_no,i_name,s_date
				}
	       		rs2=st2.executeQuery(qry);
	       		while(rs2.next())
		       	{
		       		//System.out.println("problem......................2");
		       		//System.out.print("a");
			       	String arr[]=new String[4];
			       	String arr1[]=new String[4];
			       	arr[2]=rs2.getString("i_name");
			       	//System.out.println("problem......................222222222222222222");
			       	rs1=st1.executeQuery("select * from sale where  i_name='"+arr[2]+"'and t_type='s' and s_date>=#"+dt+"# and s_date<=#"+dt1+"# order by s_date");		
			       	if(itemCb1.getSelectedIndex()>0)
			       	{
			       		rs1=st1.executeQuery("select * from sale where  i_name='"+arr[2]+"'  and p_name='"+itemCb1.getSelectedItem()+"' and t_type='s' and s_date>=#"+dt+"# and s_date<=#"+dt1+"# order by s_date");	
			       	}
			       	//System.out.println("problem......................11111111");
			       	while(rs1.next())
	       			{
			       		arr[0]=""+(grid2.getRowCount()+1)+" ";
		    	   		
		    	   		Date dt4= rs1.getDate("s_date");
	        			String d= dt4.toString();
						String da[]= d.split("-");
						String temp = da[2]+ "-" + da[1] + "-" + da[0];

		    	   		arr[1]=temp;
								       			
		       			String j=rs1.getString("wt");
		       			arr[3]=""+(new BigDecimal(j)).setScale(3,5);
		       			//arr[3]=rs1.getString("wt");
		       			dtm2.addRow(arr);
		       		}

	       				rs3=st3.executeQuery("select sum(wt) from sale where i_name='"+arr[2]+"' and t_type='s' and s_Date>=#"+dt+"# and s_Date<=#"+dt1+"# ");		
	       				if(itemCb1.getSelectedIndex()>0)
	       				{
	       					rs3=st3.executeQuery("select sum(wt) from sale where i_name='"+arr[2]+"'  and p_name='"+itemCb1.getSelectedItem()+"' and t_type='s' and s_Date>=#"+dt+"# and s_Date<=#"+dt1+"# ");		
	       				}
	       				if(rs3.next())
	       				{
	       				 	String h=""+rs3.getDouble(1);  
	       				 	arr1[3]=""+(new BigDecimal(h)).setScale(3,5);
	       					arr1[0]="";
	       					arr1[1]="";
	       					arr1[2]="";
							double f1=Double.valueOf(arr1[3]);
	       					total1=total1+f1;
	       				}
	       				dtm2.addRow(arr1);
	       				int i=grid2.getRowCount()-1;
	       				grid2.addRowSelectionInterval(i,i);
	       			}
	       			

	       				
	       				
	       				
	       				
	       				
	       				
	       				//dtm.addRow(arr1);
	       				
	       				/////////////String str="";	       				
	       				
	       			//arr[2]=""+total;
	       			
	       		//}
	       			System.out.println("dhananjay..........q1=err4"+total1);
	       		String qq=""+total1;System.out.println("dhananjay..........q1=err3333");
	       		sal_wtlb.setText(""+(new BigDecimal(qq)).setScale(3,5));
	       			System.out.println("dhananjay..........q1=err3");
	       		fromDtLong+=86400000;
	       	//}
	       	
	       	
	       	//CODE FOR GETTING TODAY'S  'OUT'
	       	db=0;
	       	count1=0;
	       	flag=0;
	       	gWt1=0;tnh1=0;fWt1=0;
			//double total1=0;
			tmp=dateTf.getText();
	       	dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
	       	fromDtLong=Date.parse(dt);
			
	       	//while(fromDtLong<=toDtLong)
	       //	{
	       		//dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
	       	
				//qry="select all distinct i_name from sale where s_Date>=#"+dt+"# and s_Date<=#"+dt1+"#  and t_type='s' group by i_name,wt";
				//
				//if(itemCb.getSelectedIndex()>0)
				//{
				//	qry="select all distinct  i_name from sale where s_Date>=#"+dt+"# and s_Date<=#"+dt1+"#  and p_name='"+itemCb.getSelectedItem()+"' and t_type='s' group by i_name,wt";
					//
					//s_s_no,i_name,s_date
				//}/
	       		//rs2=st2.executeQuery(qry);
	       		//while(rs2.next())
	       		//{		System.out.println("dhananjay..........q1=err2");
			      // 	String arr[]=new String[3];
			       	//arr[0]=""+(grid2.getRowCount()+1)+" ";
			       	//arr[1]=(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900);
		    	   	//arr[1]=rs2.getString(1);
	       			//arr[3]=rs2.getString("s_s_no");
	       		
		       		//rs1=st1.executeQuery("select * from sale where s_s_no="+Integer.parseInt(arr[3])+" and t_type='s'");		
	       			//	System.out.println("dhananjay..........q1=err1");
	       			//rs1=st1.executeQuery("select sum(wt) from sale where i_name='"+arr[1]+"'and t_type='s'");		
	       			//while(rs1.next())
	       			//{
	       			////	double q=rs1.getDouble(1);
	       				///arr[2]=""+(new BigDecimal(q)).setScale(3,5);
	       				//double r=Double.valueOf(arr[2]);
	       				//total1=total1+r;
	       			///	System.out.println("dhananjay..........q1="+q);
	       				//arr[5]=rs2.getString("tnh");
	       				//arr[6]=rs2.getString("pcs");
	       				//arr[7]=rs2.getString("f_wt");

	       			///}
	       			//dtm2.addRow(arr);
	       		//}
	       		//S/tring s1=""+total1;
	       		//sal_wtlb.setText(""+(new BigDecimal(s1)).setScale(3,5));
	       		//fromDtLong+=86400000;
	       	//}
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457...s"+x);
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
	       	rs1=st1.executeQuery("select * from partyDetails  where p_type='p' order by partyName ");
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
	//////////
	private void addItem1()
	{		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	ResultSet rs1;
	       	itemCb1.addItem("All Party");
	       	rs1=st1.executeQuery("select * from partyDetails  where p_type='s' order by partyName");
	       	while(rs1.next())
	       	{
	       		itemCb1.addItem(rs1.getString("partyName"));
	       	}
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457912..."+x);
		}
	}	       		
	

	
}	