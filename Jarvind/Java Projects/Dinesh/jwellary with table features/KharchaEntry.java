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

class KharchaEntry extends JFrame implements ActionListener,MouseListener,FocusListener,KeyListener
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
	//JComboBox drcb;
	Cursor cursor;
	Color col2;

	public KharchaEntry(JDesktopPane desk)
	{
		//About Container
    	this.desk=desk;
       	frame=new JInternalFrame("D a i l y   K h a r c h a",false,true,false,true);
       	c=frame.getContentPane();
	  	c.setLayout(null);
   		desk.add(frame);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-770)/2;
		int y = (ds.height-470)/2;
   		frame.reshape(x,y,770,470);
        
	   	//Font
	   	Font font1=new Font("Verdana",Font.BOLD,11);        
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
		JLabel lab1=new JLabel("Voucher Date");
		JLabel lab2=new JLabel("Voucher No.",JLabel.CENTER);
		JLabel lab3=new JLabel("Kharcha Amount");
		JLabel lab4=new JLabel("Narration");
		JLabel lab5=new JLabel("Enter Rate ");
		JLabel lab6=new JLabel("Converted Weight (in gm)",JLabel.RIGHT);
		JLabel lab7=new JLabel("gm");
		v_code=new JLabel("0",JLabel.CENTER);
		totalamtLb=new JLabel("0.00",JLabel.RIGHT);
		bhariCb=new JComboBox();
		rate=new JTextField();
		totalwtLb=new JLabel("",JLabel.RIGHT);
		lab1.setBounds(15,15,100,25);
		lab2.setBounds(280,15,100,25);
		lab3.setBounds(15,55,140,25);
		lab4.setBounds(280,55,100,25);
		lab5.setBounds(10,400,100,20);
		lab6.setBounds(300,400,190,20);
		lab7.setBounds(605,400,100,20);
		v_code.setBounds(380,15,100,25);
		rate.setBounds(80,400,120,20);
		bhariCb.setBounds(200,400,100,20);
		totalwtLb.setBounds(500,400,100,20);
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
		
		c.add(lab1);
		c.add(lab2);
		c.add(lab3);
		c.add(lab4);
		c.add(lab5);
		c.add(lab6);
		c.add(lab7);
		c.add(bhariCb);
		c.add(rate);
		c.add(totalwtLb);
		c.add(v_code);		
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
		c.add(dd);
		c.add(mm);
		c.add(yy);
		c.add(dramt);
		c.add(narration);
		c.add(totalamtLb);
		//addPane.setVisible(false);
		
		
		//About Buttons
		ImageIcon save_icon,reset_icon,close_icon;
		save_icon=new ImageIcon("save.gif");
		reset_icon=new ImageIcon("reset.gif");
		close_icon=new ImageIcon("close.gif");
		save_btn=new JButton("Save",save_icon);
		reset_btn=new JButton("Reset",reset_icon);
		close_btn=new JButton("Close",close_icon);
		saveMetal_btn=new JButton("Adjust",close_icon);
		save_btn.setBounds(640,50,100,25);
		reset_btn.setBounds(10,200,100,25);
		close_btn.setBounds(10,240,100,25);
		saveMetal_btn.setBounds(640,397,100,25);
		save_btn.setMnemonic('s');
		reset_btn.setMnemonic('r');
		close_btn.setMnemonic('c');
		saveMetal_btn.setMnemonic('a');
		
		c.add(save_btn);
		c.add(saveMetal_btn);
		//c.add(reset_btn);
		//c.add(close_btn);

		String heading1[]={"S.No.","Vch. No.","Amount","Narration"};
		dtm1=new DefaultTableModel(heading1,0);
		grid1=new JTable(dtm1);
		JScrollPane jsp1=new JScrollPane(grid1);
		jsp1.setBounds(15,100,730,250);
		c.add(jsp1);
		DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
   		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
   		CRLeft.setHorizontalAlignment(JLabel.LEFT);
      	CRRight.setHorizontalAlignment(JLabel.RIGHT);
   		CRCenter.setHorizontalAlignment(JLabel.CENTER);   		
   		TableColumn column;
   		column=grid1.getColumn("S.No.");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(50);
		column=grid1.getColumn("Vch. No.");
   		column.setCellRenderer(CRCenter);
   		column.setPreferredWidth(100);
   		column=grid1.getColumn("Amount");
   		column.setCellRenderer(CRRight);
   		column.setPreferredWidth(130);
   		column=grid1.getColumn("Narration");
   		column.setCellRenderer(CRLeft);
   		column.setPreferredWidth(450);



		//event
		save_btn.addActionListener(this);
		reset_btn.addActionListener(this);
		close_btn.addActionListener(this);
		bhariCb.addActionListener(this);
		saveMetal_btn.addActionListener(this);
		save_btn.addMouseListener(this);
		reset_btn.addMouseListener(this);
		close_btn.addMouseListener(this);
		save_btn.addFocusListener(this);
		reset_btn.addFocusListener(this);
		close_btn.addFocusListener(this);
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
		dramt.addFocusListener(this);
		/*try
		{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
			Statement st=con.createStatement();
			
			String temp="";
			ResultSet rs=st.executeQuery("select * from partyDetails where p_type<>'s' and p_type<>'p' order by partyName ");			
			while(rs.next())
			{
				temp=rs.getString("partyName");
				drcb.addItem(temp);
				if(rs.getString("p_type").equals("Direct Expenses")==false)
					crcb.addItem(temp);
			}
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error 32234..."+ex);
		}*/
		incr_voucher_no();
		
		getData();
		
		frame.show();		
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==save_btn)
		{
			saveData();
			getData();
			reset();
			dramt.requestFocus();
		}
		else if(event.getSource()==saveMetal_btn)
		{
			saveKharcha();
			rate.requestFocus();
		}		
		else if(event.getSource()==reset_btn)
		{
			reset();
			incr_voucher_no();
		}
		else if(event.getSource()==close_btn)
		{
			frame.dispose();
		}
		else if(event.getSource()==bhariCb)
		{
			try
			{
				//if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==45)
				//{
					double gWt=Double.valueOf(rate.getText());
					double fWt=Double.valueOf(totalamtLb.getText());
				
					if(bhariCb.getSelectedIndex()==0)
					{
						gWt=gWt/11.664;
					}
					else
					{
						gWt=gWt/10.000;
					}
					fWt=fWt/gWt;
					try
					{
						String t=""+(new BigDecimal(fWt)).setScale(3,5);						
						totalwtLb.setText(""+t);
					}
					catch(Exception x)
					{
						System.out.println(""+x);
					}
				/*}
				else
				{	
					String s=rate.getText();
					rate.setText(s.substring(0,s.length()-1));				
				}*/		
			}
			catch(Exception x)
			{
				totalwtLb.setText("0.000");
			}			
		}
	}
	public void mouseEntered(MouseEvent event)
	{
		if(event.getSource()==save_btn)
			save_btn.setForeground(Color.black);
		else if(event.getSource()==reset_btn)
			reset_btn.setForeground(Color.black);
		else if(event.getSource()==close_btn)
			close_btn.setForeground(Color.black);		
	}
	public void mouseClicked(MouseEvent event){}
	public void mouseExited(MouseEvent event)
	{
		if(event.getSource()==save_btn)
			save_btn.setForeground(col2);
		else if(event.getSource()==reset_btn)
			reset_btn.setForeground(col2);
		else if(event.getSource()==close_btn)
			close_btn.setForeground(col2);
	}
	public void mousePressed(MouseEvent event){}
	public void mouseReleased(MouseEvent event){}
	
	public void focusGained(FocusEvent event)
	{
		if(event.getSource()==dramt)	getData();
	}	
	public void focusLost(FocusEvent event)
	{
	}	
	public void keyPressed(KeyEvent event)
	{
		if(event.getSource()==dd && event.getKeyCode()==10)
			mm.requestFocus();
		else if(event.getSource()==mm && event.getKeyCode()==10)
			yy.requestFocus();
		else if(event.getSource()==yy && event.getKeyCode()==10)
			dramt.requestFocus();
		else if(event.getSource()==dramt && event.getKeyCode()==10)
			narration.requestFocus();			
		else if(event.getSource()==narration && event.getKeyCode()==10)
			save_btn.requestFocus();
		else if(event.getSource()==rate && event.getKeyCode()==10)
			bhariCb.requestFocus();
		else if(event.getSource()==bhariCb && event.getKeyCode()==10)
			saveMetal_btn.requestFocus();
		else if(event.getSource()==save_btn && event.getKeyCode()==10)
		{
			saveData();
			getData();
			reset();
			dramt.requestFocus();
		}	
		else if(event.getSource()==saveMetal_btn && event.getKeyCode()==10)
		{
			saveKharcha();
			rate.requestFocus();
		}		
		else if(event.getSource()==reset_btn && event.getKeyCode()==10)
			close_btn.requestFocus();
		else if(event.getSource()==close_btn && event.getKeyCode()==10)
			dd.requestFocus();

		else if(event.getSource()==save_btn && event.getKeyCode()==10)
		{
			saveData();
			
		}
		else if(event.getSource()==reset_btn && event.getKeyCode()==10)
		{
			reset();
			incr_voucher_no();
		}
		else if(event.getSource()==close_btn && event.getKeyCode()==10)
		{
			frame.dispose();
		}
		else if(event.getKeyCode()==event.VK_ESCAPE)
		{
			frame.dispose();
		}
			
	}
	public void keyReleased(KeyEvent e)
	{
		try
		{
				if((e.getKeyCode()>=48 && e.getKeyCode()<=57) || e.getKeyCode()==46 || e.getKeyCode()==8 || e.getKeyCode()==45)
				{
					double gWt=0;
					try					
					{
						gWt=Double.valueOf(rate.getText());
					}
					catch(Exception x)
					{
						String s=rate.getText();
						rate.setText(s.substring(0,s.length()-1));
						gWt=Double.valueOf(rate.getText());
					}
					double fWt=Double.valueOf(totalamtLb.getText());
				
					if(bhariCb.getSelectedIndex()==0)
					{
						gWt=gWt/11.664;
					}
					else
					{
						gWt=gWt/10.000;
					}
					
					fWt=fWt/gWt;
					try
					{
						String t=""+(new BigDecimal(fWt)).setScale(3,5);						
						totalwtLb.setText(""+t);
					}
					catch(Exception x)
					{
						System.out.println(""+x);
					}
				}
				/*else
				{	
					String s=rate.getText();
					rate.setText(s.substring(0,s.length()-1));				
				}*/		
		}
		catch(Exception x)
		{
			totalwtLb.setText("0.000");
		}				
	}
	public void keyTyped(KeyEvent event){}

	public void incr_voucher_no()
	{
			try
			{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select max(v_no) from kharcha_details ");
				if(rs.next())
				{
					v_code.setText(""+(rs.getInt(1)+1));
				}
				con.close();
			}
			catch(Exception ex)
			{
				System.out.println("Error 32234..."+ex);
			}
	}

	private void reset()
	{
		dramt.setText("");
		narration.setText("");
	}	
	public void saveData()
	{
		if(dramt.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Error!\nFirst you enter amount.");			
			dramt.requestFocus();
		}
		else if(narration.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Error!\nEnter narration.");			
			dramt.requestFocus();
		}
		else
		{
		
		try
		{
			Double.valueOf(dramt.getText());
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	    Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
			Statement st=con.createStatement();
			double tempvar=0;
			
			//String cno="":
			//st.executeUpdate("insert into client_master values('"+c_code.getText()+"','"+c_name.getText().trim()+"','"+address.getText().trim()+"','"+city_nm.getText().trim()+"','"+state_nm.getText().trim()+"','"+pin_code.getText().trim()+"','"+tele_no.getText().trim()+"','"+mobile_no.getText().trim()+"','"+email.getText().trim()+"','"+brk.getSelectedItem()+"')");
			String c_date=new String(mm.getText().trim()+"/"+dd.getText().trim()+"/"+yy.getText().trim());			
			int vno=Integer.parseInt(v_code.getText());
			double amt=Double.valueOf(dramt.getText());
			String nartext=""+narration.getText();
			
			st.executeUpdate("insert into kharcha_details values('"+c_date+"',"+vno+","+amt+",'"+nartext+"')");
			
			/*ResultSet rs=st.executeQuery("select * from partyDetails where partyName='"+drcb.getSelectedItem()+"'");
			if(rs.next())
			{
				tempvar=Double.valueOf(rs.getString("currentAmt")).doubleValue();
				String acType=rs.getString("p_type");
				if(acType.equals("Cash-in-hand") || acType.equals("Sundry Creditors") || acType.equals("Sundry Debtors") || acType.equals("Direct Expenses") || acType.equals("Bank Accounts"))
				{
					tempvar-=Double.valueOf(dramt.getText().trim()).doubleValue();
				}
				st.executeUpdate("update partyDetails set currentAmt='"+tempvar+"' where partyName='"+drcb.getSelectedItem()+"'");
			}
			rs=st.executeQuery("select * from partyDetails where partyName='"+crcb.getSelectedItem()+"'");
			if(rs.next())
			{
				tempvar=Double.valueOf(rs.getString("currentAmt")).doubleValue();
				String acType=rs.getString("p_type");
				if(acType.equals("Capital Account") || acType.equals("Sundry Debtors") || acType.equals("Sundry Creditors") || acType.equals("Cash-in-hand") || acType.equals("Bank Accounts"))
				{
					tempvar+=Double.valueOf(dramt.getText().trim()).doubleValue();
				}
				st.executeUpdate("update partyDetails set currentAmt='"+tempvar+"' where partyName='"+crcb.getSelectedItem()+"'");
			}*/
			con.close();
			reset();
			incr_voucher_no();
			//save_btn.setEnabled(false);
			JOptionPane.showMessageDialog(null,"Transaction completed successfully.");			
			
		}
		catch(Exception ex)
		{
			System.out.println("Error 32234..."+ex);
			JOptionPane.showMessageDialog(null,"Error!\nInvalid character found in amount.");			
			dramt.setText("");
			dramt.requestFocus();
		}

		}
		
	}	

	public void saveKharcha()
	{
		if(rate.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Error!\nFirst you rate.");			
			rate.requestFocus();
		}
		else
		{
		
		try
		{
			Double.valueOf(rate.getText());
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	    Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
			Statement st=con.createStatement();
			double tempvar=0;
			
			//String cno="":
			//st.executeUpdate("insert into client_master values('"+c_code.getText()+"','"+c_name.getText().trim()+"','"+address.getText().trim()+"','"+city_nm.getText().trim()+"','"+state_nm.getText().trim()+"','"+pin_code.getText().trim()+"','"+tele_no.getText().trim()+"','"+mobile_no.getText().trim()+"','"+email.getText().trim()+"','"+brk.getSelectedItem()+"')");
			String c_date=new String(mm.getText().trim()+"/"+dd.getText().trim()+"/"+yy.getText().trim());			
			String rt=rate.getText();
			String ratetype=""+bhariCb.getSelectedItem();
			String amount=""+totalamtLb.getText();
			String weight=""+totalwtLb.getText();
			
			ResultSet rs=st.executeQuery("select * from kharcha_adjustment where entry_date=#"+c_date+"#");
			if(rs.next()==false)
			{
				st.executeUpdate("insert into kharcha_adjustment values('"+c_date+"','"+rt+"','"+ratetype+"','"+amount+"','"+weight+"')");
				JOptionPane.showMessageDialog(null,"Adjustment completed successfully.");		
			}
			else
			{
				int res=JOptionPane.showConfirmDialog(null,"Metal updation already processed. Do you want to update again?","confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(res==JOptionPane.YES_OPTION)
				{
					st.executeUpdate("delete * from kharcha_adjustment where entry_date=#"+c_date+"#");
					st.executeUpdate("insert into kharcha_adjustment values('"+c_date+"','"+rt+"','"+ratetype+"','"+amount+"','"+weight+"')");
					JOptionPane.showMessageDialog(null,"Updation process completed successfully.");		
				}
			}
			con.close();
			reset();
				
			
		}
		catch(Exception ex)
		{
			System.out.println("Error 32234..."+ex);
			JOptionPane.showMessageDialog(null,"Error!\nInvalid character found in amount.");			
			rate.setText("");
			rate.requestFocus();
		}

		}
		
	}	

	public void getData()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	    Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
			Statement st=con.createStatement();
			int sno=1;
			double amt=0;
			while(grid1.getRowCount()>0)	dtm1.removeRow(0);
			String c_date=new String(mm.getText().trim()+"/"+dd.getText().trim()+"/"+yy.getText().trim());			
			ResultSet rs=st.executeQuery("select * from kharcha_details where v_date=#"+c_date+"# order by v_no");
			while(rs.next())
			{
				String arr[]=new String[4];
				arr[0]=""+ sno++;
				arr[1]=rs.getString("v_no");
				arr[2]=""+rs.getBigDecimal("v_amt").setScale(2,5);
				arr[3]=rs.getString("v_kment");
				dtm1.addRow(arr);
				amt+=Double.valueOf(arr[2]);
			}
			totalamtLb.setText(""+(new BigDecimal(amt) ).setScale(2,5) );
		}
		catch(Exception ex)
		{
			System.out.println("Error 32234..."+ex);
		}
	}	
	public void getData(String c_date)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	    Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
			Statement st=con.createStatement();
			int sno=1;
			double amt=0;
			while(grid1.getRowCount()>0)	dtm1.removeRow(0);
			//String c_date=new String(mm.getText().trim()+"/"+dd.getText().trim()+"/"+yy.getText().trim());			
			ResultSet rs=st.executeQuery("select * from kharcha_details where v_date=#"+c_date+"# order by v_no");
			while(rs.next())
			{
				String arr[]=new String[4];
				arr[0]=""+ sno++;
				arr[1]=rs.getString("v_no");
				arr[2]=""+rs.getBigDecimal("v_amt").setScale(2,5);
				arr[3]=rs.getString("v_kment");
				dtm1.addRow(arr);
				amt+=Double.valueOf(arr[2]);
			}
			totalamtLb.setText(""+(new BigDecimal(amt) ).setScale(2,5) );
			System.out.println(c_date);
			mm.setText(c_date.substring(0,c_date.indexOf('/')));
			dd.setText(c_date.substring(c_date.indexOf('/')+1,c_date.lastIndexOf('/')));
			yy.setText(c_date.substring(c_date.lastIndexOf('/')+1,c_date.length()));
		}
		catch(Exception ex)
		{
			System.out.println("Error 32234..."+ex);
		}
	}	
}