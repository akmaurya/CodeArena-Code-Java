import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;

public class ShowKharchaAdjustment extends JFrame implements ActionListener,KeyListener//,MouseListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	DefaultTableModel dtm1;
	JTable grid1;
	JTextField dateTf,dateTf1;	
	JButton showBtn,printBtn,closeBtn;
	JLabel totalInAmt,totalOutAmt;
	JDesktopPane desk;
	public ShowKharchaAdjustment(JDesktopPane desk)
	{
		this.desk=desk;
		frm=new JInternalFrame("REPORT : SHOW KHARCHA ADJUSTMENT IN DATE RANGE",false,true,false,false);
		//frm=new JDialog(new Frame(),"Add New Party",true);
		con=frm.getContentPane();
		con.setLayout(null);
		
		JLabel lab1=new JLabel("Enter Date :");
		JLabel lab3=new JLabel("Rs.");
		totalInAmt=new JLabel("0.00",JLabel.RIGHT);
		totalOutAmt=new JLabel("0.00",JLabel.RIGHT);		
		dateTf=new JTextField();
		dateTf1=new JTextField();
		showBtn=new JButton("Show");
		printBtn=new JButton("Print");
		closeBtn=new JButton("Close");
		
		
		String heading1[]={"S.No.","Date","Rate","Amount (in Rs.)","Metal (in Gm)"};
		dtm1=new DefaultTableModel(heading1,0);
		grid1=new JTable(dtm1);
		JScrollPane jsp1=new JScrollPane(grid1);
		
		java.util.Date dt=new java.util.Date();		
		String tmp=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		dateTf.setText(tmp);
		dateTf.setHorizontalAlignment(JTextField.CENTER);
		dateTf1.setText(tmp);
		dateTf1.setHorizontalAlignment(JTextField.CENTER);
		showBtn.setMnemonic('s');
		printBtn.setMnemonic('p');
		closeBtn.setMnemonic('c');
		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
   		CRLeft.setHorizontalAlignment(JLabel.LEFT);
      	CRRight.setHorizontalAlignment(JLabel.RIGHT);
   		CRCenter.setHorizontalAlignment(JLabel.CENTER);   		
   		TableColumn column;
   		column=grid1.getColumn("S.No.");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(70);
		column=grid1.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(200);
		column=grid1.getColumn("Rate");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(200);
		column=grid1.getColumn("Amount (in Rs.)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(200);
   		column=grid1.getColumn("Metal (in Gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(200);
   		
		
		
		
		lab1.setBounds(10,10,100,20);
		dateTf.setBounds(95,10,100,20);
		dateTf1.setBounds(205,10,100,20);
		showBtn.setBounds(360,10,100,20);
		printBtn.setBounds(470,10,100,20);
		closeBtn.setBounds(580,10,100,20);
		lab3.setBounds(610,50,20,20);
		jsp1.setBounds(10,70,770,450);		
		totalInAmt.setBounds(390,525,200,20);
		totalOutAmt.setBounds(570,525,200,20);		
		
		con.add(lab1);
		con.add(dateTf);
		con.add(dateTf1);
		con.add(showBtn);
		con.add(printBtn);
		con.add(closeBtn);
		con.add(lab3);
		con.add(jsp1);
		con.add(totalInAmt);
		con.add(totalOutAmt);
		
		showBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		showBtn.addKeyListener(this);
		closeBtn.addKeyListener(this);
		dateTf.addKeyListener(this);
		dateTf1.addKeyListener(this);
		grid1.addKeyListener(this);
		
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
			dateTf1.requestFocus();
		}
		else if(e.getSource()==dateTf1 && e.getKeyCode()==10)
		{
			showBtn.requestFocus();
		}
		else if(e.getSource()==showBtn && e.getKeyCode()==10)
		{
			showData();
		}
		else if(e.getSource()==closeBtn && e.getKeyCode()==10)
		{
			frm.dispose();
		}
		else if(e.getSource()==grid1 && e.getKeyCode()==10)
		{
			e.consume();
			KharchaEntry kentry=new KharchaEntry(desk);
			String tmp=""+grid1.getValueAt(grid1.getSelectedRow(),1);
			String dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;
   		    kentry.getData(dt);
		}
		else if(e.getKeyCode()==e.VK_ESCAPE)
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
	       	Statement st2=cn.createStatement();
   		    String tmp=dateTf.getText();
	        String tmp1=dateTf1.getText();
	        while(grid1.getRowCount()>0)		dtm1.removeRow(0);
	        //while(grid2.getRowCount()>0)		dtm2.removeRow(0);

  		    String dt=tmp.substring(0,tmp.indexOf('/'));
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=tmp.substring(0,tmp.indexOf('/'))+"/"+dt;
   		    tmp=tmp.substring(tmp.indexOf('/')+1,tmp.length());
   		    dt=dt+"/"+tmp;

  		    String dt1=tmp1.substring(0,tmp1.indexOf('/'));
   		    tmp1=tmp1.substring(tmp1.indexOf('/')+1,tmp1.length());
   		    dt1=tmp1.substring(0,tmp1.indexOf('/'))+"/"+dt1;
   		    tmp1=tmp1.substring(tmp1.indexOf('/')+1,tmp1.length());
   		    dt1=dt1+"/"+tmp1;
			
			
			long fromDtLong=Date.parse(dt);
			long toDtLong=Date.parse(dt1);
			System.out.println(""+(toDtLong-fromDtLong));
			System.out.println(""+(new Date(fromDtLong)).getDate());
			System.out.println(""+(new Date(fromDtLong)).getMonth());
			System.out.println(""+(new Date(fromDtLong)).getYear());
			
			BigDecimal amt=new BigDecimal("0.00");
			BigDecimal wt=new BigDecimal("0.00");
			while(fromDtLong<=toDtLong)		
			{		
				String arr[]=new String[5];
				arr[0]=""+(grid1.getRowCount()+1);	
				arr[1]=""+((new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getMonth()+1)+"/"+((new Date(fromDtLong)).getYear()+1900));	
				arr[2]="";
				arr[3]="0.00";
				arr[4]="0.000";
				dt=((new Date(fromDtLong)).getMonth()+1)+"/"+(new Date(fromDtLong)).getDate()+"/"+((new Date(fromDtLong)).getYear()+1900);
            	ResultSet rs1=st1.executeQuery("select * from kharcha_adjustment where entry_date=#"+dt+"#");				
				if(rs1.next())			
				{
					arr[2]=rs1.getString("rate")+rs1.getString("rate_type");		
					arr[3]=rs1.getString("amount");	
					arr[4]=rs1.getString("weight");	
					amt=amt.add(new BigDecimal(arr[3]));
					wt=wt.add(new BigDecimal(arr[4]));
				}
			
				dtm1.addRow(arr);				
				fromDtLong+=86400000;
			}	
			totalInAmt.setText(""+amt.setScale(2,5));
			totalOutAmt.setText(""+wt.setScale(3,5));
		}
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
	}
	
	
}	