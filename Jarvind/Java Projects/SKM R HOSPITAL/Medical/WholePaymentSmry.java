import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.*;
import java.io.*;
import java.rmi.*;
class WholePaymentSmry
{
	JInternalFrame frm;
	JPanel p;	
	JLabel lbl,wholePMoney,wholeDMoney;
	JButton btn1,btn2;
	DefaultTableModel dtm;
	JTable tab1;
	JScrollPane jsp;
	JDesktopPane dp;
	public WholePaymentSmry(JDesktopPane dp1)
	{
		frm=new JInternalFrame("Balance Sheet",false,true,false,false);
		Container cn=frm.getContentPane();
		frm.setBackground(new Color(154,238,166));
		//cn.setLayout(null);
		this.dp=dp1;
		LineBorder lb=new LineBorder(Color.RED,2);
		TitledBorder tb=new TitledBorder(lb,"");
		p=new JPanel();
		p.setOpaque(true);
		p.setLayout(null);
		String head[]={"Sr.No.","Party Name","Purchase Amt","Due Amt"};
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
       		column.setPreferredWidth(200);

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
		
		
		p.setBounds(25,15,420,560);
		p.setBorder(tb);
		cn.add(p);
		frm.reshape(120,50,485,620);
		dp1.add(frm);
		frm.setVisible(true);
		action();

	}
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
        	String query="select distinct(partyNm) from purchasePaymentSmry";
        	String arr[]=inf.getResultSetAs_1D_Array(query);
        	System.out.println("1.."+arr.length);
        	if(arr!=null)
        	{
        	
        	for(int i=0;i<arr.length;i++)
        	{
        		//System.out.println("123..l00p");
//        		if(arr[i]!=null)
        		if(arr[i].equals(""))
            	{}
            	else
            	{
            		//System.out.println("2..");
        			String data[]=new String[4];
        			data[0]=(dtm.getRowCount()+1)+".";
        			data[1]=arr[i];
        			query="select sum(purAmt) from purchasePaymentSmry where partyNm='"+arr[i]+"'";
        			data[2]=inf.getSingleValue(query);
        			query="select sum(purDueAmt) from purchasePaymentSmry where partyNm='"+arr[i]+"'";
        			data[3]=inf.getSingleValue(query);
        			dtm.addRow(data);
        			if(!(data[2].equals("")||data[2].equals("null") || data[2]==null))
						sum1=sum1.add(new java.math.BigDecimal(data[2]));
					if(!(data[3].equals("")||data[3].equals("null") || data[3]==null))
						sum2=sum2.add(new java.math.BigDecimal(data[3]));
					//System.out.println("3..n");
					//if(i==3)break;
        		}
        		//System.out.println("3..l00p");
        	}
        	//System.out.println("4.."+sum1);
        	wholePMoney.setText(""+(sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        	//System.out.println("5..");
        	wholeDMoney.setText(""+(sum2.setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        	//System.out.println("6..");
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
	
}