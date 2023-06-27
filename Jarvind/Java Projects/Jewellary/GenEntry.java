import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.*;

class GenEntry extends JFrame implements ActionListener,MouseListener,FocusListener,KeyListener
{
	JInternalFrame frame;
	JDesktopPane desk;
	Container c;
	JLabel v_code;
	//JTextField c_name,city_nm,state_nm,pin_code,mobile_no,tele_no,email;
	JTextArea narration;
	JScrollPane addPane;
	
	JTextField c_code,dd,mm,yy;
	JComboBox brk,narcb;
	JButton save_btn,reset_btn,close_btn;
	JTextField dramt,cramt;
	JComboBox drcb,crcb;
	Cursor cursor;
	Color col2;

	public GenEntry(JDesktopPane desk)
	{
		//About Container
        		this.desk=desk;
        		frame=new JInternalFrame("J o u r n e l  E n t r y",false,true,false,true);
        		c=frame.getContentPane();
	    	c.setLayout(null);
        		desk.add(frame);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-680)/2;
		int y = (ds.height-400)/2;
        		frame.reshape(x,y,680,340);
        
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
		c.add(pan1);
		c.add(pan2);
		
		//About Labels
		JLabel lab1=new JLabel("Voucher Date");
		JLabel lab2=new JLabel("Voucher No.",JLabel.CENTER);
		JLabel lab3=new JLabel("Account No./Name",JLabel.CENTER);
		JLabel lab4=new JLabel("Amount",JLabel.CENTER);
		JLabel lab5=new JLabel("Amount",JLabel.CENTER);
		JLabel lab6=new JLabel("Dr,");
		JLabel lab7=new JLabel("To,");
		JLabel lab8=new JLabel("Cr");
		JLabel lab9=new JLabel("Narration");
		JLabel lab19=new JLabel("ENTER :");
		JLabel lab110=new JLabel("Pg Up :");
		JLabel lab111=new JLabel("Pg Dn :");
		JLabel lab112=new JLabel("For action");
		JLabel lab113=new JLabel("Move previous");
		JLabel lab114=new JLabel("Move forward");
		JLabel lab15=new JLabel(new ImageIcon("help_small.gif"));
		v_code=new JLabel("0",JLabel.CENTER);
		lab1.setBounds(15,15,100,25);
		lab2.setBounds(280,15,100,25);
		lab3.setBounds(100,80,140,25);
		lab4.setBounds(310,80,100,25);
		lab5.setBounds(410,80,100,25);
		lab6.setBounds(15,105,100,25);
		lab7.setBounds(15,140,100,25);
		lab8.setBounds(280,140,100,25);
		lab9.setBounds(15,185,100,25);
		lab19.setBounds(10,20,100,20);
		lab110.setBounds(10,50,100,20);
		lab111.setBounds(10,80,100,20);
		lab112.setBounds(20,35,110,20);
		lab113.setBounds(20,65,100,20);
		lab114.setBounds(20,95,100,20);
		lab15.setBounds(10,20,100,120);
		v_code.setBounds(280,40,100,25);
		lab1.setFont(font1);
		lab2.setFont(font1);
		lab3.setFont(font1);
		lab4.setFont(font1);
		lab5.setFont(font1);
		lab6.setFont(font3);
		lab7.setFont(font3);
		lab8.setFont(font3);
		lab9.setFont(font1);
		lab19.setFont(font3);
		lab110.setFont(font3);
		lab111.setFont(font3);
		lab112.setFont(font4);
		lab113.setFont(font4);
		lab114.setFont(font4);
		v_code.setFont(new Font("Verdana",Font.BOLD,12));		
		v_code.setOpaque(true);
		v_code.setForeground(Color.red);
		v_code.setBackground(col3);
		pan1.add(lab1);
		pan1.add(lab2);
		pan1.add(lab3);
		pan1.add(lab4);
		pan1.add(lab5);
		pan1.add(lab6);
		pan1.add(lab7);
		pan1.add(lab8);
		pan1.add(lab9);
		pan1.add(v_code);
		/*pan2.add(lab19);
		pan2.add(lab110);
		pan2.add(lab111);
		pan2.add(lab112);
		pan2.add(lab113);
		pan2.add(lab114);
		pan2.add(lab15);
		*/
		//About TextFilds and TextArea
		java.util.Date cur_date=new java.util.Date();
		dd=new JTextField(""+cur_date.getDate());
		mm=new JTextField(""+(cur_date.getMonth()+1));
		yy=new JTextField(""+(cur_date.getYear()+1900));
		dramt=new JTextField();
		cramt=new JTextField();		
		narration=new JTextArea();
		addPane=new JScrollPane(narration,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		dd.setBounds(15,40,25,20);
		mm.setBounds(45,40,25,20);
		yy.setBounds(75,40,40,20);
		dramt.setBounds(310,105,100,20);
		cramt.setBounds(410,140,100,20);
		addPane.setBounds(15,235,495,40);
		dd.setHorizontalAlignment(JTextField.CENTER);
		mm.setHorizontalAlignment(JTextField.CENTER);
		yy.setHorizontalAlignment(JTextField.CENTER);
		dramt.setHorizontalAlignment(JTextField.RIGHT);
		cramt.setHorizontalAlignment(JTextField.RIGHT);		
		/*dd.setBackground(col3);
		mm.setBackground(col3);
		yy.setBackground(col3);
		dramt.setBackground(col3);
		cramt.setBackground(col3);
		*/
		cramt.setEnabled(false);
		narration.setBackground(col3);
		pan1.add(dd);
		pan1.add(mm);
		pan1.add(yy);
		pan1.add(dramt);
		pan1.add(cramt);
		pan1.add(addPane);
		addPane.setVisible(false);
		
		//Combo Box
		drcb=new JComboBox();
		crcb=new JComboBox();
		narcb=new JComboBox();
		narcb.addItem("Being Cash Paid");
		narcb.addItem("Being Cash Received");
		narcb.addItem("Other");
		drcb.setBounds(35,105,240,20);
		crcb.setBounds(35,140,240,20);
		narcb.setBounds(15,210,495,20);
		/*drcb.setBackground(col1);
		crcb.setBackground(col1);
		narcb.setBackground(col1);
		*/
		drcb.setFont(font3);
		crcb.setFont(font3);
		pan1.add(drcb);
		pan1.add(crcb);
		pan1.add(narcb);
		
		//About Buttons
		ImageIcon save_icon,reset_icon,close_icon;
		save_icon=new ImageIcon("save.gif");
		reset_icon=new ImageIcon("reset.gif");
		close_icon=new ImageIcon("close.gif");
		save_btn=new JButton("Save",save_icon);
		reset_btn=new JButton("Reset",reset_icon);
		close_btn=new JButton("Close",close_icon);
		save_btn.setBounds(10,160,100,25);
		reset_btn.setBounds(10,200,100,25);
		close_btn.setBounds(10,240,100,25);
		save_btn.setMnemonic('s');
		reset_btn.setMnemonic('r');
		close_btn.setMnemonic('c');
		/*save_btn.setForeground(Color.gray);
		reset_btn.setForeground(Color.gray);
		close_btn.setForeground(Color.gray);
		save_btn.setBackground(col1);
		reset_btn.setBackground(col1);
		close_btn.setBackground(col1);
		save_btn.setForeground(col2);
		reset_btn.setForeground(col2);
		close_btn.setForeground(col2);
		save_btn.setCursor(cursor);
		close_btn.setCursor(cursor);
		reset_btn.setCursor(cursor);
		*/
		pan2.add(save_btn);
		pan2.add(reset_btn);
		pan2.add(close_btn);

		//event
		save_btn.addActionListener(this);
		reset_btn.addActionListener(this);
		close_btn.addActionListener(this);
		narcb.addActionListener(this);
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
		
		dd.addKeyListener(this);
		mm.addKeyListener(this);
		yy.addKeyListener(this);
		drcb.addKeyListener(this);
		crcb.addKeyListener(this);
		dramt.addKeyListener(this);
		cramt.addKeyListener(this);
		narcb.addKeyListener(this);

		try
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
		}
		incr_voucher_no();
		frame.show();		
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==save_btn)
		{
			try
			{
				double temp1=Double.valueOf(dramt.getText().trim()).doubleValue();
				System.out.println(temp1);
				try
				{
					double temp2=Double.valueOf(cramt.getText().trim()).doubleValue();
					if(temp1==temp2)
					{
						saveData();
						reset();
						incr_voucher_no();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Oh! Debit amount and Credit amount must be same.","Error",JOptionPane.ERROR_MESSAGE);							
						cramt.requestFocus();
					}
				}
				catch(Exception x)
				{
					JOptionPane.showMessageDialog(null,"Oh! Invalid character found in entered Credit Amount.","Error",JOptionPane.ERROR_MESSAGE);							
					cramt.requestFocus();
				}
			}
			catch(Exception x)
			{
				JOptionPane.showMessageDialog(null,"Oh! Invalid character found in entered Debit Amount.","Error",JOptionPane.ERROR_MESSAGE);							
				dramt.requestFocus();
			}
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
		else if(event.getSource()==narcb)
		{
			if(narcb.getSelectedIndex()==2)			
				addPane.setVisible(true);			
			else
				addPane.setVisible(false);			
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
		/*if(event.getSource()==save_btn)
			save_btn.setForeground(Color.black);
		else if(event.getSource()==reset_btn)
			reset_btn.setForeground(Color.black);
		else if(event.getSource()==close_btn)
			close_btn.setForeground(Color.black);		
		*/	
	}	
	public void focusLost(FocusEvent event)
	{
		/*if(event.getSource()==save_btn)
			save_btn.setForeground(col2);
		else if(event.getSource()==reset_btn)
			reset_btn.setForeground(col2);
		else if(event.getSource()==close_btn)
			close_btn.setForeground(col2);
		*/	
	}	
	public void keyPressed(KeyEvent event)
	{
		if(event.getSource()==dd && event.getKeyCode()==10)
			mm.requestFocus();
		else if(event.getSource()==mm && event.getKeyCode()==10)
			yy.requestFocus();
		else if(event.getSource()==yy && event.getKeyCode()==10)
			drcb.requestFocus();
		else if(event.getSource()==drcb && event.getKeyCode()==10)
			{dramt.requestFocus();	dramt.selectAll();}
		else if(event.getSource()==dramt && event.getKeyCode()==10)
			crcb.requestFocus();
		else if(event.getSource()==crcb && event.getKeyCode()==10)
			narcb.requestFocus();
		else if(event.getSource()==narcb && event.getKeyCode()==10)
		{
			if(narcb.getSelectedIndex()==2)
				narration.requestFocus();
			else
				save_btn.requestFocus();
		}		
		else if(event.getSource()==save_btn && event.getKeyCode()==10)
			reset_btn.requestFocus();
		else if(event.getSource()==reset_btn && event.getKeyCode()==10)
			close_btn.requestFocus();
		else if(event.getSource()==close_btn && event.getKeyCode()==10)
			dd.requestFocus();

		else if(event.getSource()==reset_btn && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
			save_btn.requestFocus();
		else if(event.getSource()==save_btn && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
		{
			if(narcb.getSelectedIndex()==2)
				narration.requestFocus();
			else
				narcb.requestFocus();
			//narcb.requestFocus();
		}
		else if(event.getSource()==narcb && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
		{
			event.consume();
			cramt.requestFocus();
		}
		else if(event.getSource()==cramt && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
			crcb.requestFocus();
		else if(event.getSource()==crcb && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
		{
			event.consume();
			dramt.requestFocus();
		}
		else if(event.getSource()==dramt && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
			drcb.requestFocus();
		else if(event.getSource()==drcb && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
		{
			event.consume();
			yy.requestFocus();
		}
		else if(event.getSource()==yy && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
			mm.requestFocus();
		else if(event.getSource()==mm && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
			dd.requestFocus();
		else if(event.getSource()==dd && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
			close_btn.requestFocus();
		else if(event.getSource()==close_btn && event.getKeyCode()==KeyEvent.VK_PAGE_UP)
			reset_btn.requestFocus();

		if(event.getSource()==dd && event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
			mm.requestFocus();
		else if(event.getSource()==mm  && event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
			yy.requestFocus();
		else if(event.getSource()==yy &&  event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
			drcb.requestFocus();
		else if(event.getSource()==drcb &&  event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
		{
			event.consume();
			dramt.requestFocus();
		}
		else if(event.getSource()==dramt &&  event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
			crcb.requestFocus();
		else if(event.getSource()==crcb &&  event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
		{
			event.consume();
			cramt.requestFocus();
		}
		else if(event.getSource()==cramt &&  event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
			narcb.requestFocus();
		else if(event.getSource()==narcb &&  event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
		{
			event.consume();
			if(narcb.getSelectedIndex()==2)
				narration.requestFocus();
			else
				save_btn.requestFocus();
			//save_btn.requestFocus();
		}
		else if(event.getSource()==save_btn &&  event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
			reset_btn.requestFocus();
		else if(event.getSource()==reset_btn &&  event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
			close_btn.requestFocus();
		else if(event.getSource()==close_btn &&  event.getKeyCode()==KeyEvent.VK_PAGE_DOWN)
			dd.requestFocus();

		else if(event.getSource()==save_btn && event.getKeyCode()==10)
		{
			try
			{
				double temp1=Double.valueOf(dramt.getText().trim()).doubleValue();
				try
				{
					double temp2=Double.valueOf(cramt.getText().trim()).doubleValue();
					if(temp1==temp2)
					{
						saveData();
						reset();
						incr_voucher_no();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Oh! Debit amount and Credit amount must be same.","Error",JOptionPane.ERROR_MESSAGE);							
						cramt.requestFocus();
					}
				}
				catch(Exception x)
				{
					JOptionPane.showMessageDialog(null,"Oh! Invalid character found in entered Credit Amount.","Error",JOptionPane.ERROR_MESSAGE);							
					cramt.requestFocus();
				}
			}
			catch(Exception x)
			{
				JOptionPane.showMessageDialog(null,"Oh! Invalid character found in entered Debit Amount.","Error",JOptionPane.ERROR_MESSAGE);							
				dramt.requestFocus();
			}
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
	}
	public void keyReleased(KeyEvent event)
	{
		if(event.getSource()==dramt)
		{
			cramt.setText(dramt.getText());
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
				ResultSet rs=st.executeQuery("select max(voucher_no) from ac_transaction ");
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
		save_btn.setEnabled(true);
		drcb.setSelectedIndex(0);	
		crcb.setSelectedIndex(0);	
		dramt.setText("0.00");
		cramt.setText("0.00");
		narcb.setSelectedIndex(0);
		narration.setText("");
		drcb.requestFocus();
	}	
	public void saveData()
	{
		try
		{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
			Statement st=con.createStatement();
			double tempvar=0;
			//String cno="":
			//st.executeUpdate("insert into client_master values('"+c_code.getText()+"','"+c_name.getText().trim()+"','"+address.getText().trim()+"','"+city_nm.getText().trim()+"','"+state_nm.getText().trim()+"','"+pin_code.getText().trim()+"','"+tele_no.getText().trim()+"','"+mobile_no.getText().trim()+"','"+email.getText().trim()+"','"+brk.getSelectedItem()+"')");
			String c_date=new String(mm.getText().trim()+"/"+dd.getText().trim()+"/"+yy.getText().trim());			
			String nartext=""+narcb.getSelectedItem();
			if(narcb.getSelectedIndex()==2)
			{
				nartext=narration.getText();
			}
			st.executeUpdate("insert into ac_transaction values('"+v_code.getText()+"','"+drcb.getSelectedItem()+"','"+crcb.getSelectedItem()+"','"+c_date+"','"+dramt.getText().trim()+"','"+nartext+"')");
			
			ResultSet rs=st.executeQuery("select * from partyDetails where partyName='"+drcb.getSelectedItem()+"'");
			if(rs.next())
			{
				tempvar=Double.valueOf(rs.getString("currentAmt")).doubleValue();
				String acType=rs.getString("p_type");
				if(acType.equals("Cash-in-hand") || acType.equals("Sundry Creditors") || acType.equals("Sundry Debtors") || acType.equals("Direct Expenses") || acType.equals("Bank Accounts"))
				{
					tempvar-=Double.valueOf(dramt.getText().trim()).doubleValue();
				}
				/*else if(acType.equals("Sundry Debtors") )
				{
					tempvar-=Double.valueOf(dramt.getText().trim()).doubleValue();
				}*/
				/*if(acType.equals("Sundry Creditors") || acType.equals("Sundry Debtors"))				
					tempvar-=Double.valueOf(dramt.getText().trim()).doubleValue();
				else
					tempvar+=Double.valueOf(dramt.getText().trim()).doubleValue();
				*/
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
				/*else if(acType.equals("Sundry Debtors") )
				{
					tempvar+=Double.valueOf(dramt.getText().trim()).doubleValue();
				}*/
				/*if(acType.equals("Sundry Creditors") || acType.equals("Sundry Debtors"))				
					tempvar+=Double.valueOf(dramt.getText().trim()).doubleValue();			
				else	
					tempvar-=Double.valueOf(dramt.getText().trim()).doubleValue();			
				*/
				st.executeUpdate("update partyDetails set currentAmt='"+tempvar+"' where partyName='"+crcb.getSelectedItem()+"'");
			}
			/*
			String vno=""+(Integer.parseInt(v_code.getText())+1);
			st.executeUpdate("update voucher_no_master set v_no='"+vno+"'");
			*/
			//st.executeUpdate("insert into ac_balance values('"+c_code+"','0','0')");
			con.close();
			save_btn.setEnabled(false);
			JOptionPane.showMessageDialog(null,"Transaction completed successfully.");			
		}
		catch(Exception ex)
		{
			System.out.println("Error 32234..."+ex);
		}
	}
}