import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.io.*;
import java.rmi.*;
class WholePaymentSmryPartyWise implements ActionListener,MouseListener
{
	JInternalFrame frm;
	JPanel p;	
	JLabel lbl,wholePMoney,wholeDMoney;
	JButton btn1,btn2;
	DefaultTableModel dtm;
	JTable tab1;
	JScrollPane jsp;
	JDesktopPane dp;
	JPopupMenu pop;
	JMenuItem it1;
	public WholePaymentSmryPartyWise(JDesktopPane dp1)
	{
		frm=new JInternalFrame("Balance Sheet : Party Wise",false,true,false,false);
		Container cn=frm.getContentPane();
		frm.setBackground(new Color(154,238,166));
		//cn.setLayout(null);
		this.dp=dp1;
		LineBorder lb=new LineBorder(Color.RED,2);
		TitledBorder tb=new TitledBorder(lb,"");
		p=new JPanel();
		p.setOpaque(true);
		p.setLayout(null);
		String head[]={"Party Name","Book No.","Sr.No.","Purchase Amt","Due Amt"};
		dtm=new DefaultTableModel(head,0);
		tab1=new JTable(dtm);
		jsp=new JScrollPane(tab1);
		jsp.setBounds(30,30,420,520);
		p.add(jsp);
		
			DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
      		TableColumn column;
      		
      		column=tab1.getColumn("Sr.No.");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(50);
		
			column=tab1.getColumn("Party Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(120);
       		
       		column=tab1.getColumn("Book No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(100);
       		
       		column=tab1.getColumn("Sr.No.");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(100);

      		column=tab1.getColumn("Purchase Amt");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);
  
      		column=tab1.getColumn("Due Amt");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(100);
		
		Font fn11=new Font("Arial",Font.BOLD|Font.ITALIC,25);
		lbl=new JLabel("No Record Available");
		lbl.setFont(fn11);
		lbl.setBounds(120,230,300,50);
		p.add(lbl);
		lbl.setVisible(false);
		
		
		wholePMoney=new JLabel("0.00");
		wholePMoney.setBackground(new Color(230,174,91));
		wholePMoney.setBounds(140,550,150,25);
		wholePMoney.setOpaque(true);
		wholePMoney.setHorizontalAlignment(JLabel.RIGHT);
		p.add(wholePMoney);
		//wholePMoney.setVisible(false);
		
		wholeDMoney=new JLabel("0.00");
		wholeDMoney.setBackground(new Color(254,177,239));
		wholeDMoney.setBounds(300,550,150,25);
		wholeDMoney.setOpaque(true);
		wholeDMoney.setHorizontalAlignment(JLabel.RIGHT);
		p.add(wholeDMoney);
		//wholeDMoney.setVisible(false);
		
		pop=new JPopupMenu();
		it1=new JMenuItem("Show Transactions");
		pop.add(it1);
//		tab1.setPopupMenu(pop);
		
		p.setBounds(25,15,420,560);
		p.setBorder(tb);
		cn.add(p);
		frm.reshape(120,50,485,620);
		dp1.add(frm);
		frm.setVisible(true);
		action();
		it1.addActionListener(this);
		tab1.addMouseListener(this);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==it1)
		{
			int r=tab1.getSelectedRow();
			TransactionDetails t=new TransactionDetails(""+tab1.getValueAt(r,1),""+tab1.getValueAt(r,2));
		}
	}
	public void mouseClicked(MouseEvent evt)
	{
		if(evt.getSource()==tab1)
		{
		
		if(evt.getModifiers()==4)
        {
            int r=tab1.getSelectedRow();
            if(r>=0)
            {
                it1.setEnabled(true);
              
            }
            else
            {
                it1.setEnabled(false);
                          
            }
            pop.show(tab1,evt.getX(),evt.getY());
        }
        }
	}
	public void mouseExited(MouseEvent me)
	{}
	public void mouseEntered(MouseEvent me)
	{}
	public void mouseReleased(MouseEvent me)
	{}
	public void mousePressed(MouseEvent me)
	{}
	private void action()
	{
		try
        {
        	java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
        	java.math.BigDecimal sum2=new java.math.BigDecimal("0.0");
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
        	String query="select partyNm,bookNo,srNo,purAmt,purDueAmt from purchasePaymentSmry";
        	String arr[][]=inf.getResultSetAs_2D_Array(query,5);
        	//System.out.println("1..");
        	if(arr!=null)
        	{
        	
        	for(int i=0;i<arr.length;i++)
        	{
            		//System.out.println("2..");
        			String data[]=new String[5];
        			data[0]=arr[i][0];
        			data[1]=arr[i][1];
        			data[2]=arr[i][2];
        			data[3]=arr[i][3];
        			data[4]=arr[i][4];
        			dtm.addRow(data);
        			if(!(data[3].equals("")||data[3].equals("null") || data[3]==null))
						sum1=sum1.add(new java.math.BigDecimal(data[3]));
					if(!(data[4].equals("")||data[4].equals("null") || data[4]==null))
						sum2=sum2.add(new java.math.BigDecimal(data[4]));
				//	System.out.println("3..");
        	}
        	//System.out.println("4..");
        	wholePMoney.setText(""+(sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        	//System.out.println("5..");
        	wholeDMoney.setText(""+(sum2.setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        //	System.out.println("6..");
        	}
        	else
        	{
        		jsp.setVisible(false);
        		wholePMoney.setVisible(false);
        		wholeDMoney.setVisible(false);
        		lbl.setVisible(true);
        	}
		}
        catch(Exception ex)
		{
     		System.out.println("Error ..skm.."+ex);
		}
	}
	
	//inner class
	class TransactionDetails
	{
		JLabel lbl1,wholePMoney1,wholeDMoney1;
		DefaultTableModel dtm1;
		JTable tab11;
		JScrollPane jsp1;
		public TransactionDetails(String bookno,String srNo)
		{
		
		JInternalFrame frm1=new JInternalFrame("Transactions : Party Wise",false,true,false,false);
		Container cn1=frm1.getContentPane();
		frm.setBackground(new Color(154,238,166));
		//cn.setLayout(null);
		LineBorder lb1=new LineBorder(Color.RED,2);
		TitledBorder tb1=new TitledBorder(lb1,"");
		JPanel p1=new JPanel();
		p1.setOpaque(true);
		p1.setLayout(null);
		String head[]={"Sr.No.","Paid Date","Paid Amt"};
		dtm1=new DefaultTableModel(head,0);
		tab11=new JTable(dtm1);
		jsp1=new JScrollPane(tab11);
		jsp1.setBounds(10,15,255,230);
		p1.add(jsp1);
		
			DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
      		TableColumn column;
      		
      		column=tab11.getColumn("Sr.No.");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(50);

      		column=tab11.getColumn("Paid Date");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(100);
  
      		column=tab11.getColumn("Paid Amt");
      		column.setCellRenderer(CRRight);
       		column.setPreferredWidth(120);
		
		Font fn11=new Font("Arial",Font.BOLD|Font.ITALIC,15);
		lbl1=new JLabel("No Transaction Available");
		lbl1.setFont(fn11);
		lbl1.setForeground(Color.RED);
		lbl1.setBounds(40,100,200,50);
		p1.add(lbl1);
		lbl1.setVisible(false);
		
		p1.setBounds(25,15,250,220);
		p1.setBorder(tb1);
		cn1.add(p1);
		frm1.reshape(120,50,285,290);
		dp.add(frm1);
		frm1.setVisible(true);
		
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
        	String query="select payDate,payAmt from purchasePaymentDetails where bookNo='"+bookno+"' and srNo='"+srNo+"'";
        	String arr[][]=inf.getResultSetAs_2D_Array(query,2);
        	if(arr!=null)
        	{
        	
        	for(int i=0;i<arr.length;i++)
        	{
        		
        		String dat[]=(arr[i][0]).split("-");
                String dd[]=dat[2].split(" ");
                String date=dd[0]+"/"+dat[1]+"/"+dat[0];
                String data[]=new String[3];
                data[0]=(dtm1.getRowCount()+1)+".";
                data[1]=date;
                data[2]=""+(new java.math.BigDecimal(arr[i][1]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP));
                dtm1.addRow(data);
        	}
        	}
        	else
        	{
        		p1.remove(jsp1);
        		p1.remove(tab11);
        		
        		//jsp1.setVisible(false);
        		//tab11.setVisible(false);
        		lbl1.setVisible(true);
        	}
        }
        catch(Exception ex)
		{
     		System.out.println("Error ...."+ex);
		}
		
		}
	}
	
}