import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;

public class ShowClosing extends JFrame implements ActionListener,KeyListener//,MouseListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	DefaultTableModel dtm1,dtm2;
	JTable grid1,grid2;
	JTextField dateTf;	
	JButton showBtn,printBtn,closeBtn;
	JLabel openingAmtLb,totalInAmt,totalOutAmt,closingAmt;
	public ShowClosing(JDesktopPane desk)
	{
		frm=new JInternalFrame("REPORT : SHOW ROKAR",false,true,false,false);
		//frm=new JDialog(new Frame(),"Add New Party",true);
		con=frm.getContentPane();
		con.setLayout(null);
		
		JLabel lab1=new JLabel("Enter Date :");
		JLabel lab2=new JLabel("Opening :");
		JLabel lab3=new JLabel("Rs.");
		JLabel lab4=new JLabel("IN->");		
		JLabel lab5=new JLabel("OUT->");
		JLabel lab6=new JLabel("Total In Amount :",JLabel.RIGHT);
		JLabel lab7=new JLabel("Total Out Amount :",JLabel.RIGHT);
		JLabel lab8=new JLabel("Closing Amount :",JLabel.RIGHT);
		openingAmtLb=new JLabel("0.00");
		totalInAmt=new JLabel("0.00",JLabel.RIGHT);
		totalOutAmt=new JLabel("0.00",JLabel.RIGHT);		
		closingAmt=new JLabel("0.00",JLabel.RIGHT);		
		dateTf=new JTextField();
		showBtn=new JButton("Show");
		printBtn=new JButton("Print");
		closeBtn=new JButton("Close");
		
		
		String heading1[]={"Party Name","Through","Bill No.","Amount","For"};
		dtm1=new DefaultTableModel(heading1,0);
		grid1=new JTable(dtm1);
		JScrollPane jsp1=new JScrollPane(grid1);
		
		String heading2[]={"Party Name","Through","Bill No.","Amount","For"};
		dtm2=new DefaultTableModel(heading2,0);
		grid2=new JTable(dtm2);
		JScrollPane jsp2=new JScrollPane(grid2);
		
		java.util.Date dt=new java.util.Date();		
		String tmp=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		dateTf.setText(tmp);
		dateTf.setHorizontalAlignment(JTextField.CENTER);
		showBtn.setMnemonic('s');
		printBtn.setMnemonic('p');
		closeBtn.setMnemonic('c');
		openingAmtLb.setForeground(Color.red);
		closingAmt.setForeground(Color.red);
		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
   		CRLeft.setHorizontalAlignment(JLabel.LEFT);
      	CRRight.setHorizontalAlignment(JLabel.RIGHT);
   		CRCenter.setHorizontalAlignment(JLabel.CENTER);   		
   		TableColumn column;
   		column=grid1.getColumn("Party Name");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(180);
		column=grid1.getColumn("Through");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(100);
   		column=grid1.getColumn("Bill No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(70);
   		column=grid1.getColumn("Amount");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);
   		column=grid1.getColumn("For");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(270);
		
   		column=grid2.getColumn("Party Name");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(180);
		column=grid2.getColumn("Through");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(100);
   		column=grid2.getColumn("Bill No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(70);
   		column=grid2.getColumn("Amount");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(150);
   		column=grid2.getColumn("For");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(270);
		
		
		
		lab1.setBounds(10,10,100,20);
		dateTf.setBounds(95,10,130,20);
		showBtn.setBounds(250,10,100,20);
		printBtn.setBounds(360,10,100,20);
		closeBtn.setBounds(470,10,100,20);
		lab2.setBounds(540,50,100,20);
		lab3.setBounds(610,50,20,20);openingAmtLb.setBounds(640,50,200,20);
		lab4.setBounds(10,50,100,20);
		lab5.setBounds(10,300,100,20);
		jsp1.setBounds(10,70,770,200);		
		jsp2.setBounds(10,320,770,200);		
		lab6.setBounds(210,275,150,20);		
		lab7.setBounds(210,525,150,20);		
		lab8.setBounds(210,545,150,20);		
		totalInAmt.setBounds(360,275,150,20);
		totalOutAmt.setBounds(360,525,150,20);	
		closingAmt.setBounds(360,545,150,20);	
		
		con.add(lab1);
		con.add(dateTf);
		con.add(showBtn);
		con.add(printBtn);
		con.add(closeBtn);
		con.add(lab2);
		con.add(lab3);con.add(openingAmtLb);
		con.add(lab4);
		con.add(lab5);
		con.add(jsp1);
		con.add(jsp2);
		con.add(lab6);
		con.add(lab7);
		con.add(lab8);
		con.add(totalInAmt);
		con.add(totalOutAmt);
		con.add(closingAmt);
		
		showBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		showBtn.addKeyListener(this);
		closeBtn.addKeyListener(this);
		dateTf.addKeyListener(this);
		
		desk.add(frm);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-800)/2;
		int y = (ds.height-600)/2;
   		frm.reshape(x,35,800,600);
   		frm.show();
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==showBtn)
		{
			getOpeningAmt();
			showData();
		}
		else if(e.getSource()==closeBtn)
		{
			frm.dispose();
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getSource()==dateTf && e.getKeyCode()==10)
		{
			showBtn.requestFocus();
		}
		else if(e.getSource()==showBtn && e.getKeyCode()==10)
		{
			getOpeningAmt();
			showData();
		}
		else if(e.getSource()==closeBtn && e.getKeyCode()==10)
		{
			frm.dispose();
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
	       	Statement st1=cn.createStatement();
   		    String tmp=dateTf.getText();
	        while(grid1.getRowCount()>0)		dtm1.removeRow(0);
	        while(grid2.getRowCount()>0)		dtm2.removeRow(0);

  		    String dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
			
			BigDecimal inDb=new BigDecimal("0.00");
			BigDecimal outDb=new BigDecimal("0.00");
				
			//System.out.println("select slx.field11,slx.jama,slx.s_s_no,sl.p_name from sale sl,sale_x slx where slx.s_s_no=sl.s_s_no and sl.s_date=#"+dt+"#");
            ResultSet rs1=st1.executeQuery("select p_name,s_s_no from sale where s_date=#"+dt+"# group by s_s_no,p_name");				
			while(rs1.next())			
			{
				String arr[]=new String[5];
				arr[0]=rs1.getString(1);	//party name
				arr[2]=rs1.getString(2);		//s_s_no
				
				ResultSet rs=st.executeQuery("select field11,jama,s_s_no,btn1,btn2 from sale_x where s_s_no="+Integer.parseInt(arr[2]));
				if(rs.next())
				{
					arr[1]="Sale";									 
					arr[3]=""+rs.getBigDecimal(1).setScale(2);
					if(Double.valueOf(arr[3])!=0 && rs.getBoolean(4)==true)	//for payment
					{	
						
					
						if(Double.valueOf(arr[3])>0)	//if payment liya gaya
						{
							inDb=inDb.add(new BigDecimal(arr[3]));
							arr[4]="  Cash received against bill";
							dtm1.addRow(arr);
						}	
						else							//if payment diya gaya
						{
							arr[3]=""+Math.abs(Double.valueOf(arr[3]));
							arr[3]=""+(new BigDecimal(arr[3])).setScale(2);
							outDb=outDb.add(new BigDecimal(arr[3]));
							arr[4]="  Balance cash paid";	
							dtm2.addRow(arr);
						}	
					}	
					arr[3]=""+rs.getBigDecimal(2).setScale(2);			
					if(Double.valueOf(arr[3])!=0  && rs.getBoolean(5)==true)		//for JAMA
					{					
						
						if(Double.valueOf(arr[3])>0)	//customer ne rs. jama kiya
						{
							inDb=inDb.add(new BigDecimal(arr[3]));
							arr[4]="  Jama";
							dtm1.addRow(arr);
						}					
						else							//customer ne jama rs. liya
						{
							arr[3]=""+Math.abs(Double.valueOf(arr[3]));
							arr[3]=""+(new BigDecimal(arr[3])).setScale(2);
							outDb=outDb.add(new BigDecimal(arr[3]));
							arr[4]="  Return jama amount";
							dtm2.addRow(arr);
						}	
					}
				}	
			}
			
			
			
			//System.out.println("select slx.field11,slx.jama,slx.s_s_no,sl.p_name from sale sl,sale_x slx where slx.s_s_no=sl.s_s_no and sl.s_date=#"+dt+"#");
            rs1=st1.executeQuery("select p_name,p_s_no from purchase where p_date=#"+dt+"# group by p_s_no,p_name");				
			while(rs1.next())			
			{
				String arr[]=new String[5];
				arr[0]=rs1.getString(1);	//party name
				arr[2]=rs1.getString(2);		//s_s_no
				
				ResultSet rs=st.executeQuery("select field11,jama,p_s_no,btn1,btn2 from purchase_x where p_s_no="+Integer.parseInt(arr[2]));
				if(rs.next())
				{
					arr[1]="Purchase";									 
					arr[3]=""+rs.getBigDecimal(1).setScale(2);
					if(Double.valueOf(arr[3])!=0 && rs.getBoolean(4)==true)	//for payment
					{	
						
					
						if(Double.valueOf(arr[3])<0)	//if payment liya gaya
						{
							inDb=inDb.add(new BigDecimal(arr[3]));
							arr[4]="  Cash received against bill";
							dtm1.addRow(arr);
						}	
						else							//if payment diya gaya
						{
							arr[3]=""+Math.abs(Double.valueOf(arr[3]));
							arr[3]=""+(new BigDecimal(arr[3])).setScale(2);
							outDb=outDb.add(new BigDecimal(arr[3]));
							arr[4]="  Balance cash paid";	
							dtm2.addRow(arr);
						}	
					}	
					arr[3]=""+rs.getBigDecimal(2).setScale(2);			
					if(Double.valueOf(arr[3])!=0  && rs.getBoolean(5)==true)		//for JAMA
					{					
						
						if(Double.valueOf(arr[3])<0)	//customer ne rs. jama kiya
						{
							inDb=inDb.add(new BigDecimal(arr[3]));
							arr[4]="  Jama";
							dtm1.addRow(arr);
						}					
						else							//customer ne jama rs. liya
						{
							arr[3]=""+Math.abs(Double.valueOf(arr[3]));
							arr[3]=""+(new BigDecimal(arr[3])).setScale(2);
							outDb=outDb.add(new BigDecimal(arr[3]));
							arr[4]="  Return jama amount";
							dtm2.addRow(arr);
						}	
					}
				}	
			}
			
			totalInAmt.setText(""+inDb);
			totalOutAmt.setText(""+outDb);
			closingAmt.setText(""+((new BigDecimal(openingAmtLb.getText())).add(inDb)).subtract(outDb).setScale(2));
			
		}
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
	}
	
	
	private void getOpeningAmt()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st=cn.createStatement();
	       	Statement st1=cn.createStatement();
   		    String tmp=dateTf.getText();
	        //while(grid1.getRowCount()>0)		dtm1.removeRow(0);
	        //while(grid2.getRowCount()>0)		dtm2.removeRow(0);

  		    String dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
			
			BigDecimal inDb=new BigDecimal("0.00");
			BigDecimal outDb=new BigDecimal("0.00");
				
			//System.out.println("select slx.field11,slx.jama,slx.s_s_no,sl.p_name from sale sl,sale_x slx where slx.s_s_no=sl.s_s_no and sl.s_date=#"+dt+"#");
            ResultSet rs1=st1.executeQuery("select p_name,s_s_no from sale where s_date<#"+dt+"# group by s_s_no,p_name");				
			while(rs1.next())			
			{
				String arr[]=new String[5];
				arr[0]=rs1.getString(1);	//party name
				arr[2]=rs1.getString(2);		//s_s_no
				
				ResultSet rs=st.executeQuery("select field11,jama,s_s_no,btn1,btn2 from sale_x where s_s_no="+Integer.parseInt(arr[2]));
				if(rs.next())
				{
					arr[1]="Sale";									 
					arr[3]=""+rs.getBigDecimal(1).setScale(2);
					if(Double.valueOf(arr[3])!=0 && rs.getBoolean(4)==true)	//for payment
					{	
						
					
						if(Double.valueOf(arr[3])>0)	//if payment liya gaya
						{
							inDb=inDb.add(new BigDecimal(arr[3]));
							//arr[4]="  Cash received against bill";
							//dtm1.addRow(arr);
						}	
						else							//if payment diya gaya
						{
							arr[3]=""+Math.abs(Double.valueOf(arr[3]));
							outDb=outDb.add(new BigDecimal(arr[3]));
							//arr[4]="  Balance cash paid";	
							//dtm2.addRow(arr);
						}	
					}	
					arr[3]=""+rs.getBigDecimal(2).setScale(2);			
					if(Double.valueOf(arr[3])!=0  && rs.getBoolean(5)==true)		//for JAMA
					{					
						
						if(Double.valueOf(arr[3])>0)	//customer ne rs. jama kiya
						{
							inDb=inDb.add(new BigDecimal(arr[3]));
							//arr[4]="  Jama";
							//dtm1.addRow(arr);
						}					
						else							//customer ne jama rs. liya
						{
							arr[3]=""+Math.abs(Double.valueOf(arr[3]));
							outDb=outDb.add(new BigDecimal(arr[3]));
							//arr[4]="  Return jama amount";
							//dtm2.addRow(arr);
						}	
					}
				}	
			}
			//totalInAmt.setText(""+inDb);
			//totalOutAmt.setText(""+outDb);
			openingAmtLb.setText(""+(inDb.subtract(outDb).setScale(2)));
			
		}
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
	}
}	