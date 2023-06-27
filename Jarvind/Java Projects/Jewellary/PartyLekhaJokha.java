 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;
import java.io.*;

public class PartyLekhaJokha extends JFrame implements ActionListener,KeyListener//,MouseListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	//JTable grid,grid2;//,table1,table1Detail;
	JButton showBtn,printBtn,closeBtn,resetBtn;
	JTextField dateTf,dateTf1;	
	JDesktopPane desk;
	JComboBox itemCb;
		
	public PartyLekhaJokha(JDesktopPane desk)
	{
		this.desk=desk;
		frm=new JInternalFrame("REPORT : Lekha Jokha",false,true,false,false);
		con=frm.getContentPane();
		con.setLayout(null);
		
		JLabel lab1=new JLabel("For Party ");
		JLabel lab2=new JLabel("Enter Date ");
		
		dateTf=new JTextField();
		dateTf1=new JTextField();
		itemCb=new JComboBox();
		

		
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
				
								
		lab1.setBounds(10,45,560,25);		
		itemCb.setBounds(95,45,275,25);		
		
		lab2.setBounds(10,10,100,20);
		dateTf.setBounds(95,10,130,20);		
		dateTf1.setBounds(240,10,130,20);		
		
		showBtn.setBounds(80,100,100,25);
		closeBtn.setBounds(220,100,100,25);
		
		//printBtn.setBounds(280,590,100,25);
		//resetBtn.setBounds(390,590,100,25);
		
		
		showBtn.setMnemonic('s');
		printBtn.setMnemonic('p');
		closeBtn.setMnemonic('c');
		resetBtn.setMnemonic('r');
		
		addItem();
		
		con.add(lab1);
		con.add(itemCb);
		con.add(lab2);
		con.add(dateTf1);
		con.add(dateTf);
		con.add(showBtn);
		//con.add(printBtn);
		//con.add(resetBtn);
		con.add(closeBtn);
		
		showBtn.addActionListener(this);
		showBtn.addKeyListener(this);
		closeBtn.addActionListener(this);
		closeBtn.addKeyListener(this);
		resetBtn.addActionListener(this);
		resetBtn.addKeyListener(this);
		dateTf1.addKeyListener(this);
		dateTf.addKeyListener(this);
		itemCb.addKeyListener(this);
		printBtn.setEnabled(false);
		
		desk.add(frm);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-400)/2;
		int y = (ds.height-180)/2;
   		frm.reshape(x,35,400,180);
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
			new PartyLekhaJokha(desk);
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
			itemCb.requestFocus();
		}
		else if(e.getSource()==itemCb && e.getKeyCode()==10)
		{
			showBtn.requestFocus();
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
	       	      	
	       	String partyName=""+itemCb.getSelectedItem();	       	
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
			
			
			double grossWt=0,fineWt=0,tnh=0;
			
			
			//CODE FOR GETTING OPENING WEIGHT
	       	/*
	       	 *Purchase part
	       	 */
	       	double gWt=0,fWt=0;
	       	int count=0;	       	
	       	/*
	       	 *Sale part
	       	 */
	       	double gWt1=0,tnh1=0,fWt1=0;
	       	int count1=0,flag1=0;	       	
	       	//CODE FOR GETTING TODAY'S   'IN'
			long fromDtLong=Date.parse(dt);
			long toDtLong=Date.parse(dt1);

            FileOutputStream fos=new FileOutputStream("lekhajokha"+".txt");
            PrintWriter pw=new PrintWriter(fos);
	
    		pw.println("******************************************************************************************************");
			String tempString=addInCenter(partyName.toUpperCase(),100);
			pw.println(tempString);
			String dateRange="( "+dateTf.getText()+" - "+dateTf1.getText()+" )";
			tempString=addInCenter(dateRange,100);
			pw.println(tempString);
    		pw.println("******************************************************************************************************");
				pw.println();
                pw.println();
                pw.println();


	       	double db=0;
	       	count1=0;
	       	gWt1=0;tnh1=0;fWt1=0;
	       	String qry="";
	       	String str="";
	       	int flag=1,counter=1,saleBillNo=0;
	       	qry="select all distinct s_s_no,s_date from sale where s_date>=#"+dt+"# and s_date<=#"+dt1+"# and p_name='"+partyName+"' order by s_date";
	 		rs1=st1.executeQuery(qry);      	
	       	while(rs1.next())
	       	{
	       		str=rs1.getString("s_date");
	       		str=str.substring(8,10)+"-"+str.substring(5,7)+"-"+str.substring(0,4);
                pw.print("Date     : ");
                pw.println(str);

	       		str=rs1.getString("s_s_no");
	       		saleBillNo=Integer.parseInt(str);
                pw.print("Bill No. : ");
                str=addAfterSpace(str,9);
	            pw.print(str);
	       		
	       		//print opening balance
	       		//---------------------
				rs3=st3.executeQuery("select * from sale_x where s_s_no="+saleBillNo);
				if(rs3.next())
				{
					str="Opening Balance --->  Wt(in gm) ";
					//str=addBeforeSpace(str,30);
	                pw.print(str);					
				
		       		str=""+(rs3.getBigDecimal("field3").setScale(3,5));
					str=addAfterSpace(str,10);
	                pw.print(str);					
				
					str="Amt.(in Rs.) ";
					str=addBeforeSpace(str,20);
	                pw.print(str);					

					//str=""+(rs3.getBigDecimal("field4").setScale(2,5));
					double opamt=rs3.getDouble("field4");
					if(opamt>0)
							str=""+(new BigDecimal(""+Math.abs(opamt)).setScale(2,5))+" Cr";
					else if(opamt<0)
							str=""+(new BigDecimal(""+Math.abs(opamt)).setScale(2,5))+" Dr";
					else
							str=""+(new BigDecimal(""+Math.abs(opamt)).setScale(2,5));
					pw.println(str);					
				}

	       		
	       		flag=1;
	       		counter=1;
	       		
		       	qry="select * from sale where s_s_no="+saleBillNo+" and t_type='s'";
		       	rs2=st2.executeQuery(qry);
		       	while(rs2.next())
	       		{
	       			if(flag==1)
					{
		                pw.println("----------------------------------------------------------------------------------------------------");
		                pw.println("---- SOLD ITEMS ----");//----------------------------------------------------------------------------------------------");
		                pw.println("----------------------------------------------------------------------------------------------------");
		                pw.print("S. No.  ");
		                pw.print("Category Name       ");
		                pw.print("Item Name         ");
		                pw.print("Weight (In gm.)   ");
		                pw.print("Tounch (In %)   ");
		                pw.print("Pieces     ");
		                pw.println("Fine Wt.       ");
		                pw.println("----------------------------------------------------------------------------------------------------");

						flag=0;
					}
					
					str=counter++ +".";
					str=addBeforeSpace(str,5);
	                pw.print(str+"    ");
		       		
		       		str=rs2.getString("c_name");
					str=addAfterSpace(str,20);
	                pw.print(str);

		       		str=rs2.getString("i_name");
	                str=addAfterSpace(str,20);
	                pw.print(str);

		       		str=""+(rs2.getBigDecimal("wt").setScale(3,5));
					str=addBeforeSpace(str,10);
	                pw.print(str);

		       		str=""+(rs2.getBigDecimal("tnh").setScale(2,5));
					str=addBeforeSpace(str,15);
	                pw.print(str);

		       		str=""+(rs2.getBigDecimal("pcs").setScale(0,5));
					str=addBeforeSpace(str,10);
	                pw.print(str);

		       		str=""+(rs2.getBigDecimal("f_wt").setScale(3,5));
					str=addBeforeSpace(str,14);
	                pw.println(str);

	       		}

				if(flag==0)			//it means, item is sold
				{
				pw.println("----------------------------------------------------------------------------------------------------");
		        //get total about sold items
				//--------------------------
				rs3=st3.executeQuery("select * from sale_x where s_s_no="+saleBillNo);
				if(rs3.next())
				{
		       		str=""+(rs3.getBigDecimal("field1").setScale(3,5));
					str=addBeforeSpace(str,59);
	                pw.print(str);					
				
					str=""+(rs3.getBigDecimal("field2").setScale(3,5));
					str=addBeforeSpace(str,39);
	                pw.println(str);					
				}
				pw.println("----------------------------------------------------------------------------------------------------");
				}
		        pw.println();        





				//FOR ADJUSTMENT
				//--------------

	       		flag=1;
	       		counter=1;
	       		
		       	qry="select * from sale where s_s_no="+saleBillNo+" and t_type='a'";
		       	rs2=st2.executeQuery(qry);
		       	while(rs2.next())
	       		{
	       			if(flag==1)
					{
		                pw.println("----------------------------------------------------------------------------------------------------");
		                pw.println("---- ADJUST ITEMS ----");//--------------------------------------------------------------------------------------------");
		                pw.println("----------------------------------------------------------------------------------------------------");
		                pw.print("S. No.  ");
		                pw.print("Category Name       ");
		                pw.print("Item Name         ");
		                pw.print("Weight (In gm.)   ");
		                pw.print("Tounch (In %)   ");
		                pw.print("Pieces     ");
		                pw.println("Fine Wt.       ");
		                pw.println("----------------------------------------------------------------------------------------------------");

						flag=0;
					}
					
					str=counter++ +".";
					str=addBeforeSpace(str,5);
	                pw.print(str+"    ");
		       		
		       		str=rs2.getString("c_name");
	                str=addAfterSpace(str,20);
	                pw.print(str);

		       		str=rs2.getString("i_name");
	                str=addAfterSpace(str,20);
	                pw.print(str);

		       		str=""+(rs2.getBigDecimal("wt").setScale(3,5));
					str=addBeforeSpace(str,10);
	                pw.print(str);

		       		str=""+(rs2.getBigDecimal("tnh").setScale(2,5));
					str=addBeforeSpace(str,15);
	                pw.print(str);

		       		str=""+(rs2.getBigDecimal("pcs").setScale(0,5));
					str=addBeforeSpace(str,10);
	                pw.print(str);

		       		str=""+(rs2.getBigDecimal("f_wt").setScale(3,5));
					str=addBeforeSpace(str,14);
	                pw.println(str);
				}

				if(flag==0)
				{
				pw.println("----------------------------------------------------------------------------------------------------");
		        //get total about ADJUST items
				//-----------------------------
				rs3=st3.executeQuery("select * from sale_x where s_s_no="+saleBillNo);
				if(rs3.next())
				{
		       		str=""+(rs3.getBigDecimal("field7").setScale(3,5));
					str=addBeforeSpace(str,59);
	                pw.print(str);					
				
					str=""+(rs3.getBigDecimal("field8").setScale(3,5));
					str=addBeforeSpace(str,39);
	                pw.println(str);					
				}
				pw.println("----------------------------------------------------------------------------------------------------");
				}
		        pw.println();        

                //pw.println("----------------------------------------------------------------------------------------------------");
                

				//adjustment
				//----------
				rs3=st3.executeQuery("select * from sale_x where s_s_no="+saleBillNo);
				if(rs3.next())
				{
					
		       		str=""+(rs3.getBigDecimal("field9").setScale(2,5));
		       		if(str.equals("0.00")==false && str.equals("0.0")==false && str.equals("0")==false )
		       		{
		       			pw.print("ADJUSTMENT :  Rate ->Rs. ");
		        		str=str+"/"+rs3.getString("rate_type");
				        pw.print(str);					
				
						pw.print("    Weight -> ");
		        		str=""+(rs3.getBigDecimal("field10").setScale(3,5))+" gm";
						pw.print(str);

						pw.print("    Amount ->Rs. ");
						boolean adj=rs3.getBoolean("btn1");
						boolean pnd=rs3.getBoolean("btn2");
						str=""+(rs3.getBigDecimal("field11").setScale(2,5));
						if(adj==true)
							str=str+"   [ADJUST]";
						else if(pnd==true)
							str=str+"   [PENDING]";
						pw.println(str);
		       		
		       			boolean dpt=rs3.getBoolean("btn3");
						if(dpt==true)
						{
							double dposit=rs3.getDouble("jama");
							if(dposit>0)
							{
								str="DEPOSITE AMOUNT : Rs."+(new BigDecimal(""+Math.abs(dposit)).setScale(2,5))+" Cr";
							}
							else
							{
								str="DEPOSITE AMOUNT : Rs."+(new BigDecimal(""+Math.abs(dposit)).setScale(2,5))+" Dr";
							}
							
							pw.println();
		       				pw.println(str);
		       				
						}
					}
				}
	       		//print closing balance
	       		//---------------------
				rs3=st3.executeQuery("select * from sale_x where s_s_no="+saleBillNo);
				if(rs3.next())
				{
					pw.println();					
				
					str="Closing Balance --->  Wt(in gm) ";
					//str=addBeforeSpace(str,30);
	                pw.print(str);					
				
		       		str=""+(rs3.getBigDecimal("field5").setScale(3,5));
					str=addAfterSpace(str,10);
	                pw.print(str);					
				
					str="Amt.(in Rs.) ";
					str=addBeforeSpace(str,20);
	                pw.print(str);					

					double clamt=rs3.getDouble("field6");
					if(clamt>0)
							str=""+(new BigDecimal(""+Math.abs(clamt)).setScale(2,5))+" Cr";
					else if(clamt<0)
							str=""+(new BigDecimal(""+Math.abs(clamt)).setScale(2,5))+" Dr";
					else
							str=""+(new BigDecimal(""+Math.abs(clamt)).setScale(2,5));
					pw.println(str);					
				}

				pw.println();
                pw.println();
                pw.println();
				pw.println("******************************************************************************************************");
				pw.println();
                pw.println();
                pw.println();

	       	}	



            pw.close();
            fos.close();
	       	cn.close();
	    }	
		catch(Exception x)
		{
			System.out.println("Error...457..."+x);
		}
		try
		{
			new ProcessBuilder("notepad","lekhajokha.txt").start(); 
		}
		catch(Exception ex)
		{
			System.out.println("Error..0292..."+ex);
		}
	}
	
	private String addBeforeSpace(String str,int size)
	{
		int l=str.length();
		for(int i=1;i<=(size-l);i++)
		{
			str=" "+str;
		}
		
		return str;
	}
	
	private String addAfterSpace(String str,int size)
	{
		int l=str.length();
		for(int i=1;i<=(size-l);i++)
		{
			str=str+" ";
		}
		
		return str;
	}

	private String addInCenter(String str,int size)
	{
		int l=size-str.length();
		l=l/2;
		for(int i=1;i<=l;i++)
		{
			str=" "+str;
		}
		
		return str;
	}
	
	private void addItem()
	{		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	   	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	       	Statement st1=cn.createStatement();
	       	ResultSet rs1;
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