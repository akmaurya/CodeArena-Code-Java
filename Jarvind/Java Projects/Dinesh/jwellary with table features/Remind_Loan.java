import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;
import java.math.*;
import javax.swing.table.*;

class Remind_Loan extends JFrame implements ActionListener,KeyListener
{
	JInternalFrame frame;
	JDesktopPane desk;
	Container c;
	JLabel v_code;
	DefaultTableModel dtm1;
	JTable grid1;
	//JTextField c_name,city_nm,state_nm,pin_code,mobile_no,tele_no,email;
	JLabel totalamtLb,totalwtLb;	
	JScrollPane addPane;
	
	JTextField c_code,dd,mm,yy,narration,rate;
	//JComboBox brk,narcb;
	JButton save_btn,reset_btn,close_btn,saveMetal_btn;
	JTextField dramt;//,cramt;
	JComboBox bhariCb;
	JComboBox partycb;
	Cursor cursor;
	Color col2;
	JLabel rateL;
	JTextField rateT;
	JButton calculateBtn;
	JLabel totalALb,totalWLb;
	//static int flag=0;
	public Remind_Loan(JDesktopPane desk)
	{
		//About Container
    	this.desk=desk;
       	frame=new JInternalFrame("R e m i n d e r    F o r    S h o w    T h e    D e b t o r ",false,true,false,true);
       	c=frame.getContentPane();
	  	c.setLayout(null);
   		desk.add(frame);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-770)/2;
		int y = (ds.height-470)/2;
   		frame.reshape(x-30,y-120,870,685);
        frame.setBackground(Color.pink);
	   	//Font
	   	Font font1=new Font("Verdana",Font.BOLD,13);        
    	Font font2=new Font("Arial",Font.PLAIN,11);
		Font font3=new Font("Verdana",Font.BOLD,10);
	   	Font font4=new Font("Verdana",Font.PLAIN,10);

		//COLOR
		Color bgcol=new Color(153,178,195);
		Color col1=new Color(113,145,167);
		col2=new Color(55,82,100);
		Color col3=new Color(212,237,254);
		//c.setBackground(bgcol);

		//CREATE A CURCOR
		//cursor=new Cursor(Cursor.HAND_CURSOR);
		
		//About Panel
		JPanel pan1=new JPanel();
		JPanel pan2=new JPanel();
		pan1.setLayout(null);
		pan2.setLayout(null);
		pan1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),""));
		pan2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED),""));
		pan1.setBounds(10,10,525,290);
		pan2.setBounds(540,10,120,290);
		//pan1.setBackground(bgcol);
		//pan2.setBackground(bgcol);
		//c.add(pan1);
		//c.add(pan2);
		
		//About Labels
		JLabel lab1=new JLabel("Party Name");
		JLabel lab2=new JLabel("Voucher No.",JLabel.CENTER);
		JLabel lab3=new JLabel("Day");
		JLabel lab4=new JLabel("Narration");
		JLabel lab5=new JLabel("Enter Rate ");
		JLabel lab6=new JLabel("Converted Weight (in gm)",JLabel.RIGHT);
		JLabel lab7=new JLabel("gm");
		 rateL=new JLabel("Enter Rate  ( per gm )");
		rateT=new JTextField();
		calculateBtn=new JButton("Calculate");
		v_code=new JLabel("0",JLabel.CENTER);
		totalamtLb=new JLabel("0.00",JLabel.RIGHT);
		bhariCb=new JComboBox();
		rate=new JTextField();
		totalwtLb=new JLabel("",JLabel.RIGHT);
		
		partycb=new JComboBox();
		
		rateL.setBounds(25,15,150,20);
		rateT.setBounds(160,15,200,20);
		calculateBtn.setBounds(420,15,100,25);
		
		lab1.setBounds(15,15,100,25);
		partycb.setBounds(125,15,300,20);
		lab2.setBounds(280,15,100,25);
		lab3.setBounds(15,55,100,20);
		lab4.setBounds(280,55,100,25);
		lab5.setBounds(10,400,100,20);
		lab6.setBounds(300,400,190,20);
		lab7.setBounds(605,400,100,20);
		v_code.setBounds(380,15,100,25);
		rate.setBounds(125,55,120,20);
		bhariCb.setBounds(200,400,100,20);
		totalwtLb.setBounds(500,400,100,20);
		
		totalALb=new JLabel("0.00",JLabel.RIGHT);
		totalALb.setBounds(630,555,115,20);
		totalWLb=new JLabel("0.00",JLabel.RIGHT);
		totalWLb.setBounds(750,555,90,20);
		totalALb.setFont(font1);
		totalWLb.setFont(font1);
		totalWLb.setBackground(Color.cyan);
		totalALb.setBackground(Color.green);
		totalWLb.setOpaque(true);
		totalALb.setOpaque(true);
		lab1.setFont(font1);
		lab2.setFont(font1);
		lab3.setFont(font1);
		lab4.setFont(font1);
		totalwtLb.setFont(font1);
		v_code.setFont(new Font("Verdana",Font.BOLD,12));		
		v_code.setOpaque(true);
		v_code.setForeground(Color.red);
		v_code.setBackground(col3);
		totalwtLb.setOpaque(true);
		totalwtLb.setBackground(col3);
		totalwtLb.setForeground(Color.red);
		bhariCb.addItem("Bhari");
		bhariCb.addItem("Gram");
		rate.setHorizontalAlignment(JTextField.CENTER);
		
		c.add(rateL);
		c.add(rateT);
		c.add(calculateBtn);
		
		c.add(totalALb);
		c.add(totalWLb);
		//c.add(lab1);
		//c.add(partycb);
		//c.add(lab3);
		//c.add(rate);
		
		/*c.add(lab2);
		
		c.add(lab4);
		c.add(lab5);
		c.add(lab6);
		c.add(lab7);*/
		//c.add(bhariCb);
		
		//c.add(totalwtLb);
		//c.add(v_code);		
		//About TextFilds and TextArea
		
		java.util.Date cur_date=new java.util.Date();
		dd=new JTextField(""+cur_date.getDate());
		mm=new JTextField(""+(cur_date.getMonth()+1));
		yy=new JTextField(""+(cur_date.getYear()+1900));
		dramt=new JTextField();
		narration=new JTextField();
		//addPane=new JScrollPane(narration,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		dd.setBounds(115,15,25,20);
		mm.setBounds(145,15,25,20);
		yy.setBounds(175,15,40,20);
		dramt.setBounds(140,55,100,20);
		narration.setBounds(355,55,280,20);
		totalamtLb.setBounds(195,355,150,20);
		dd.setHorizontalAlignment(JTextField.CENTER);
		mm.setHorizontalAlignment(JTextField.CENTER);
		yy.setHorizontalAlignment(JTextField.CENTER);
		dramt.setHorizontalAlignment(JTextField.RIGHT);
		totalamtLb.setForeground(Color.red);
		//narration.setBackground(col3);
		//c.add(dd);
		//c.add(mm);
		//c.add(yy);
		//c.add(dramt);
		//c.add(narration);
		//c.add(totalamtLb);
		//addPane.setVisible(false);
		
		
		//About Buttons
		ImageIcon save_icon,reset_icon,close_icon;
		save_icon=new ImageIcon("save.gif");
		reset_icon=new ImageIcon("reset.gif");
		close_icon=new ImageIcon("close.gif");
		save_btn=new JButton("Set",save_icon);
		reset_btn=new JButton("Reset",reset_icon);
		close_btn=new JButton("Close",close_icon);
		saveMetal_btn=new JButton("Adjust",close_icon);
		save_btn.setBounds(210,120,100,25);
		reset_btn.setBounds(10,200,100,25);
		close_btn.setBounds(390,610,100,25);
		saveMetal_btn.setBounds(640,397,100,25);
		save_btn.setMnemonic('s');
		reset_btn.setMnemonic('r');
		close_btn.setMnemonic('c');
		saveMetal_btn.setMnemonic('a');
		
		//c.add(save_btn);
	//	c.add(saveMetal_btn);
		//c.add(reset_btn);
		c.add(close_btn);

		System.out.println("dhananjay tiwari");
		String heading1[]={"S.No.","Vch. No.","Party Name","Address","Mobile","Date","Weight(gm)","Amount(Rs)","Total Amount(Rs)","Total Weight(gm)"};
		//System.out.println("dhananjay tiwari............1");
		dtm1=new DefaultTableModel(heading1,0);
		grid1=new JTable(dtm1);
		JScrollPane jsp1=new JScrollPane(grid1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp1.setBounds(15,50,830,500);
		c.add(jsp1);
		//System.out.println("dhananjay tiwari..............2");
		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
   		CRLeft.setHorizontalAlignment(JLabel.LEFT);
      	CRRight.setHorizontalAlignment(JLabel.RIGHT);
   		CRCenter.setHorizontalAlignment(JLabel.CENTER);   		
   		TableColumn column;
   		//System.out.println("dhananjay tiwari.................3");
   		column=grid1.getColumn("S.No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(30);
		column=grid1.getColumn("Vch. No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(40);
   		//System.out.println("dhananjay tiwari............4");
   		column=grid1.getColumn("Party Name");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(110);
   		
   		column=grid1.getColumn("Address");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(70);
   		
   		column=grid1.getColumn("Mobile");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(50);
   		
   		
   		
   		column=grid1.getColumn("Date");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(70);
   		//System.out.println("dhananjay tiwari..................5");
   		column=grid1.getColumn("Weight(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(80);
   		//System.out.println("dhananjay tiwari..................6");
   		column=grid1.getColumn("Amount(Rs)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(80);
		
		column=grid1.getColumn("Total Amount(Rs)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);
		column=grid1.getColumn("Total Weight(gm)");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(100);
		//
		//System.out.println("dhananjay tiwari..................7");


		//event
		save_btn.addActionListener(this);
		calculateBtn.addActionListener(this);
		reset_btn.addActionListener(this);
		close_btn.addActionListener(this);
		bhariCb.addActionListener(this);
		saveMetal_btn.addActionListener(this);
		//save_btn.addMouseListener(this);
		//reset_btn.addMouseListener(this);
		//close_btn.addMouseListener(this);
		//save_btn.addFocusListener(this);
		//reset_btn.addFocusListener(this);
		//close_btn.addFocusListener(this);
		save_btn.addKeyListener(this);
		reset_btn.addKeyListener(this);
		close_btn.addKeyListener(this);
		narration.addKeyListener(this);
		saveMetal_btn.addKeyListener(this);
		rate.addKeyListener(this);
		bhariCb.addKeyListener(this);
		
		dd.addKeyListener(this);
		mm.addKeyListener(this);
		yy.addKeyListener(this);
		dramt.addKeyListener(this);
		rate.addKeyListener(this);
		rateT.addKeyListener(this);
		calculateBtn.addKeyListener(this);
		//dramt.addFocusListener(this);
		
		//incr_voucher_no();
		
	//	getData();
		grid1.setSelectionBackground(new Color(255,157,157));
							
		getPartyName();
		getReminder();
		frame.show();		
		
	}
	
	
	private void calculateTotal()
	{
		double amt1=0;
		double totalAmount=0,totalWeight=0;
		String totalAmounts="";
		String totalWeights="";
		for(int i=0;i<grid1.getRowCount();i++)
		{
			String wt=""+grid1.getValueAt(i,6);
			String wt1=wt.substring(0,(wt.length()-2));
			String wt2=wt.substring((wt.length()-2),wt.length());
			double jw=Double.valueOf(wt1); 
			double jw1=Double.valueOf(wt1); 
			
			
			String yt=""+grid1.getValueAt(i,7);
			String yt1=yt.substring(0,(yt.length()-2));
			String yt2=yt.substring((yt.length()-2),yt.length());
			
			double jr=Double.valueOf(yt1);
			
			double rt=Double.valueOf(rateT.getText());
			if(wt2.equals("Dr"))
			{
				jw=-jw;
			}
			
			double amt=((jw*rt)-jr);
			String amount=""+(new BigDecimal(""+amt)).setScale(2,5); 
			String amT=amount.substring(0,1);
			if(amT.equals("-"))
			{
				String a=amount.substring(1,amount.length());
				amount=a+" Dr";
				grid1.setValueAt(amount,i,8);		
			}
			else
			{
				amount=amount+" Cr";	
				grid1.addRowSelectionInterval(i,i);
				grid1.setValueAt(amount,i,8);		
			}
			double ytt=Double.valueOf(yt1);
			double totweight=ytt/rt;
			if(yt2.equals("Dr") && wt2.equals("Dr"))
			{
				 amt1=jw1+totweight;	
			}
			else if(yt2.equals("Dr") && wt2.equals("Cr") || yt2.equals("Cr") && wt2.equals("Dr"))
			{
				amt1=jw1-totweight;	
			}
			
			
			String df=""+amt1;
			String jk=df.substring(0,1);
			if(jk.equals("-"))
			{
				String ty=""+df.substring(1,df.length());
				amt1=Double.valueOf(ty);
			}
			String tt=""+(new BigDecimal(""+amt1)).setScale(2,5); 
			String as=""+yt;
			String qw=yt1.substring(0,1);
			
			if(qw.equals("-"))
			{
				tt+=" Cr";
				grid1.addRowSelectionInterval(i,i);
				grid1.setValueAt(tt,i,9);		
			}
			else if(as.equals("0.0"))
			{
				
			}
			else
			{
				tt+=" Dr";
				
				grid1.setValueAt(tt,i,9);		
			}
			//String abc=""+amt;
			String ac=amount.substring(amount.length()-2,amount.length());
			String xz=tt.substring(tt.length()-2,tt.length());
			//String xyz=""+amt1;
			//String xz=xyz.substring(0,1);
			if(ac.equals("Dr"))
			{
				totalAmount+=amt ;
			}
			else
			{
				totalAmount-=amt;
			}
			
			if(xz.equals("Dr"))
			{
				totalWeight+=amt1;
				System.out.println("dhananjay tiwari11111111111==="+totalWeight);	
			}
			else if(xz.equals("Cr"))
			{
				totalWeight-=amt1;
				System.out.println("dhananjay tiwari22222222222222222222==="+totalWeight);	
			}
			else
			{
				
			}
			
			
			
		}
		
		if(totalAmount>0)
			{
				
				totalAmounts=""+(new BigDecimal(Double.valueOf(totalAmount))).setScale(2,5)+" Cr";
			}
			else
			{
				String kl=""+totalAmount;
				String kp=kl.substring(1,kl.length());
				totalAmounts=""+(new BigDecimal(Double.valueOf(kp))).setScale(2,5)+" Dr";
			}
			
			
			if(totalWeight>0)
			{
				String op=""+(new BigDecimal(Double.valueOf(totalWeight))).setScale(2,5);
				totalWeights=op+" Dr";
			}
			else
			{
				String kl1=""+totalWeight;
				String kp1=kl1.substring(1,kl1.length());
				totalWeights=""+(new BigDecimal(Double.valueOf(kp1))).setScale(2,5)+" Cr";
			}
		
		/*String qwe=totalAmounts.substring(totalAmounts.length()-2,totalAmounts.length());
		String hjk="";
		if(qwe.equals("Dr"))
		{
			hjk=totalAmounts.substring(1,totalAmounts.length()-2);	
		}
		else
		{
			hjk=totalAmounts.substring(0,totalAmounts.length()-2);	
		}
		
		String qwe1=totalWeights.substring(totalWeights.length()-2,totalWeights.length());
		String hjk1="";
		if(qwe1.equals("Dr"))
		{
			hjk1=totalWeights.substring(0,totalWeights.length()-2);	
		}
		else
		{
			hjk1=totalWeights.substring(1,totalWeights.length()-2);	
		}*/
		
		totalALb.setText(totalAmounts);
		totalWLb.setText(totalWeights);
		
	}	
	private void getReminder()
	{
			try
			{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
	            	Statement st1=cn.createStatement();
	            	Statement st2=cn.createStatement();
	            	Statement st3=cn.createStatement();
        		    Statement st4=cn.createStatement();
        		    ResultSet rs,rs1,rs2,rs3,rs4;
        		   // while(grid.getRowCount()>0)	dtm.removeRow(0);
        		    int count=0;
        		    rs=st.executeQuery("select * from reminder order by p_name ");
        		    while(rs.next())
        		    {
        		    	String name=rs.getString("p_name");
        		    	int d=rs.getInt("day");
        		    	
        		    	System.out.println("dhananjay.................1");
        		    	//System.out.println("select max(s_s_no) from sale where p_name='"+name+"' ");
        		    	System.out.println("dhananjay.................2");
        		    	
        		    	System.out.println("dhananjay.................3");
        		    	int bill=0;
        		    	String dat="";
        		    	
        		    	/*java.util.Date tazadate=new java.util.Date();
        		    	String day=""+tazadate.getDate();
        		    	String month=""+(tazadate.getMonth()+1);
        		    	String year=""+(tazadate.getYear()+1900);*/
        		    	
        		    	java.util.Date tazadate=new java.util.Date();
        		    	String day1=""+tazadate.getDate();
        		    	int day=Integer.parseInt(day1);
        		    	String month1=""+(tazadate.getMonth()+1);
        		    	int month=Integer.parseInt(month1);
        		    	String year1=""+(tazadate.getYear()+1900);
        		    	int year=Integer.parseInt(year1);
        		    	
        		    	
        		    	
        		    	
        		    	String tazadate1=day+"/"+month+"/"+year;
        		    	System.out.println("dhananjay.................4");
        		    	rs4=st4.executeQuery("select * from partyDetails where partyName='"+name+"' ");
        		    	String astr="",cstr="";
        		    	if(rs4.next())
        		    	{
        		    		astr=rs4.getString("address");
        		    		cstr=rs4.getString("contactNo");
        		    		
        		    	}
        		    	rs1=st1.executeQuery("select max(s_s_no) from sale where p_name='"+name+"' ");
        		    	if(rs1.next())
        		    	{
        		    				bill=rs1.getInt(1);
        		    		
        		    				System.out.println("dhananjay.................5bill="+bill);
        		    				rs2=st2.executeQuery("select s_date from sale where s_s_no="+bill+" ");
        		    				System.out.println("dhananjay.................6");
        		    				String dd="";
        		    				if(rs2.next())
        		    				{
        		    		 				dd=""+rs2.getDate(1);
        		    	    
        		    				}
        		    				System.out.println("dhananjay.................7");
        		    				String	 dd1[]=dd.split("-");
        		    				System.out.println("dhananjay.................8");
        		    				dat=dd1[2]+"/"+dd1[1]+"/"+dd1[0];
        		    				System.out.println("dhananjay.................9");
        		    	    		String dat1=dd1[2]+"/"+dd1[1]+"/"+dd1[0];
        		    	    		System.out.println("dhananjay.................10");
        		    	 			System.out.printf("date="+dat);
        		    	 			System.out.println("dhananjay.................11");
        		    	 			System.out.printf("remind date="+dat1);
        		    	 			System.out.println("dhananjay.................12");
        		    	 			
        		    	 			int dday=Integer.parseInt(dd1[2]);
        		    	 			int dmonth=Integer.parseInt(dd1[1]);
        		    	 			int dyear=Integer.parseInt(dd1[0]);
        		    	 			long chkInDate=java.util.Date.parse(dmonth+"/"+dday+"/"+dyear);
        		    	 			long chkRDate=java.util.Date.parse(month+"/"+day+"/"+year);
        		    				System.out.println("dhananjay.................17");
        		    				
        		    				long tDate=chkRDate-chkInDate;
        		    				double ttd=tDate/86400000;
        		    				Double dt=Math.ceil(ttd);
						 			
						           int nodd=dt.intValue();
						           if(nodd>d)
        		    				{
        		    							
        		    							System.out.println("Please remind your customer");
        		    							rs3=st3.executeQuery("select * from sale_x where s_s_no="+bill+" ");
        		    							if(rs3.next())
        		    							{
        		    								String cbal=rs3.getString("field5");
        		    								String cval=rs3.getString("field6");
        		    								String err[]=new String[10];
        		    								
													
													String sb=cbal.substring(0,1);
												    String sb1=cval.substring(0,1);
													System.out.println("6666666666sb="+sb);
													System.out.println("77777777777s="+sb1);
													if(sb.equals("-") ||cbal.equals("0.0"))
													{
														if( sb1.equals("-"))
															{
														
														
																	err[0]=""+(++count);
        		    												err[1]=""+bill;
        		    												err[2]=name;
												    				err[5]=dat;
												    				if(cbal.equals("0.0"))
												    				{
												    					err[6]=cbal;
												    				}
												    				else
												    				{
												    					String cb=cbal.substring(1,cbal.length());
												    					err[6]=cb+" Cr";
												    				}
												    				
												    				
												    				if(cval.equals("0.0"))
												    				{
												    					err[7]=cval;
												    				}
												    				else
												    				{
												    					String cc=cval.substring(1,cval.length());
												    					err[7]=cc+" Dr";
												    				}
												    				
												    				
																	
																	err[3]=astr;
																	err[4]=cstr;
																	err[8]="";
																	dtm1.addRow(err);	
															}	
													}
													else
													{
													
															
														
																	err[0]=""+(++count);
        		    												err[1]=""+bill;
        		    												err[2]=name;
												    				err[5]=dat;
												    				
												    				err[6]=cbal+" Dr";
												    				
												    				
												    				
												    				if(sb1.equals("-"))
												    				{
												    					String fg=cval.substring(1,cval.length());
												    					err[7]=fg+" Dr";
												    				}
												    				else if(cval.equals("0.0"))
												    				{
												    					err[7]=cval;
												    				}
												    				else
												    				{
												    					err[7]=cval+" Cr";
												    				}
												    				
																	err[3]=astr;
																	err[4]=cstr;
																	err[8]="";
																	err[9]="";
																	dtm1.addRow(err);	
															
													
													}
													
													
													
													
												
												
												}				
        		    				}
        		    				else
        		    				{
        		    					
        		    					System.out.println("Please Don't remind your customer");
        		    				}
        		    	}
        		    	
        		    	
        		    	
        		    }
        		   
        		    
		           	cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01.getReminder.."+x);
			}
		
	}
	private void set()
	{
			try
			{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    st.executeUpdate("insert into reminder values('"+partycb.getSelectedItem()+"',"+rate.getText()+")");
        		   
        		   
        		    
		           	cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01..remind."+x);
			}
		
	}
	private void getPartyName()
	{
			try
			{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			   		Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		   // while(grid.getRowCount()>0)	dtm.removeRow(0);
        		    partycb.addItem("-Select Party-");
        		    rs=st.executeQuery("select * from partyDetails where p_type='s' order by partyName ");
        		    while(rs.next())
        		    {
        		    	
        		    	partycb.addItem(rs.getString("partyName"));
        		    	
        		    }
		           	cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
		
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==save_btn)
		{
			set();
		}
		
		else if(event.getSource()==close_btn)
		{
			frame.dispose();
		}
		else if(event.getSource()==calculateBtn)
		{
			calculateTotal();	
		}
		
		
	}
	
	public void keyPressed(KeyEvent event)
	{
		if(event.getSource()==rateT && event.getKeyCode()==10)
			calculateBtn.requestFocus();
		else if(event.getSource()==calculateBtn && event.getKeyCode()==10)
			calculateTotal();	
		
			
	}
	public void keyReleased(KeyEvent e)
	{
					
	}
	public void keyTyped(KeyEvent event){}

	

	
}