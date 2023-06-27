import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.Date;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.math.*;

class CreateLedger extends JFrame implements ActionListener,KeyListener,FocusListener
{
	JInternalFrame frame;
	JDesktopPane desk;
	Cursor cursor;
	Container c;	
	JButton save,reset,exit;
	JList gplist;
	Vector gpvec;
	JTextField nmtf,undertf,obtf,aliastf,mobtf,phonenotf,tintf,weftf,staxtf;
	JComboBox drcr;
	JTextField addresstf;
	
	public CreateLedger(JDesktopPane desk)
	{
  		this.desk=desk;
   		frame=new JInternalFrame("L e d g e r  C r e a t i o n",false,true,false,true);
   		c=frame.getContentPane();
    	c.setLayout(null);
   		desk.add(frame);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-750)/2;
		int y = (ds.height-300)/2;
   		frame.reshape(x,35,750,400);
		
		//CREATE A CURCOR
		cursor=new Cursor(Cursor.HAND_CURSOR);      
        //Date
        Date cur_date=new Date();

		JLabel lab1=new JLabel("Name");
		JLabel lab2=new JLabel("Alias");
       	JLabel lab3=new JLabel("Under");
		JLabel lab4=new JLabel("Opening Balance");
		JLabel lab5=new JLabel("Address");
		JLabel lab6=new JLabel("Phone Number");
		JLabel lab7=new JLabel("Mobile No.");
		JLabel lab8=new JLabel("TIN");
		JLabel lab9=new JLabel("W.E.F.");
		JLabel lab10=new JLabel("Sale Tax No.");
		nmtf=new JTextField();
		aliastf=new JTextField();
		undertf=new JTextField();
		obtf=new JTextField("0");
		addresstf=new JTextField("");
		//JScrollPane tajsp=new JScrollPane(addresstf);
		mobtf=new JTextField("");
		phonenotf=new JTextField("");
		tintf=new JTextField("");
		weftf=new JTextField("");
		staxtf=new JTextField("");
		drcr=new JComboBox();
		drcr.addItem("Dr");
		drcr.addItem("Cr");
		save=new JButton("Create");
		reset=new JButton("Reset");
		exit=new JButton("Close");
		gpvec = new Vector();
		gplist = new JList(gpvec);
		JScrollPane instListPane = new JScrollPane(gplist,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);				

		lab1.setBounds(10,10,100,25);
		lab3.setBounds(10,40,100,25);
		lab4.setBounds(10,70,100,25);
		lab5.setBounds(10,100,100,25);
		lab7.setBounds(10,130,100,25);
		/*lab7.setBounds(10,160,100,25);
		lab7.setBounds(10,190,100,25);
		lab8.setBounds(10,220,100,25);
		lab9.setBounds(10,250,100,25);
		lab10.setBounds(10,280,100,25);
		*/
		nmtf.setBounds(170,10,300,25);
		//aliastf.setBounds(170,40,300,25);
		undertf.setBounds(170,40,300,25);
		obtf.setBounds(170,70,200,25);
		drcr.setBounds(375,70,40,25);
		addresstf.setBounds(170,100,300,25);
		//phonenotf.setBounds(170,160,300,25);
		mobtf.setBounds(170,130,300,25);
		/*tintf.setBounds(170,220,300,25);
		weftf.setBounds(170,250,300,25);
		staxtf.setBounds(170,280,300,25);
		*/
		save.setBounds(55,300,100,25);
		reset.setBounds(185,300,100,25);
		exit.setBounds(315,300,100,25);
		instListPane.setBounds(480,10,240,320);
		//undertf.setEnabled(false);
		save.setMnemonic('e');
		reset.setMnemonic('r');
		exit.setMnemonic('c');

		lab1.setFont(new Font("Arial",Font.PLAIN,13));
		lab2.setFont(new Font("Arial",Font.PLAIN,13));
		lab3.setFont(new Font("Arial",Font.PLAIN,13));
		lab4.setFont(new Font("Arial",Font.PLAIN,13));
		lab5.setFont(new Font("Arial",Font.PLAIN,13));
		lab6.setFont(new Font("Arial",Font.PLAIN,13));
		lab7.setFont(new Font("Arial",Font.PLAIN,13));
		lab8.setFont(new Font("Arial",Font.PLAIN,13));
		lab9.setFont(new Font("Arial",Font.PLAIN,13));
		lab10.setFont(new Font("Arial",Font.PLAIN,13));
		obtf.setHorizontalAlignment(JTextField.RIGHT);		
		try
		{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from groupList order by gpNm");
			while(rs.next())
			{
				gpvec.addElement(""+rs.getString("gpNm"));	
			}
			st.close();
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error111..."+ex);
		}
		c.add(lab1);	
		//c.add(lab2);	
		c.add(lab3);	
		c.add(lab4);	
		c.add(lab5);	
		//c.add(lab6);	
		c.add(lab7);	
		/*c.add(lab8);	
		c.add(lab9);	
		c.add(lab10);*/	
		c.add(nmtf);	
		//c.add(aliastf);	
		c.add(undertf);	
		c.add(obtf);	
		c.add(addresstf);	
		c.add(mobtf);	
		/*c.add(phonenotf);	
		c.add(tintf);	
		c.add(weftf);	
		c.add(staxtf);	*/
		c.add(drcr);	
		c.add(save);		
		c.add(reset);		
		c.add(exit);		
		c.add(instListPane);		
		
		save.addActionListener(this);	
		reset.addActionListener(this);	
		exit.addActionListener(this);
		nmtf.addKeyListener(this);	
		aliastf.addKeyListener(this);	
		obtf.addKeyListener(this);
		undertf.addKeyListener(this);
		drcr.addKeyListener(this);
		addresstf.addKeyListener(this);	
		mobtf.addKeyListener(this);	
		phonenotf.addKeyListener(this);	
		tintf.addKeyListener(this);	
		weftf.addKeyListener(this);	
		staxtf.addKeyListener(this);	
		save.addKeyListener(this);
		reset.addKeyListener(this);
		exit.addKeyListener(this);
		gplist.addKeyListener(this);

		nmtf.addFocusListener(this);	
		aliastf.addFocusListener(this);	
		obtf.addFocusListener(this);
		undertf.addFocusListener(this);
		drcr.addFocusListener(this);
		addresstf.addFocusListener(this);	
		mobtf.addFocusListener(this);	
		phonenotf.addFocusListener(this);	
		tintf.addFocusListener(this);	
		weftf.addFocusListener(this);	
		staxtf.addFocusListener(this);	

		frame.show();		
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==save)
		{
				if(nmtf.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Error found!"+"\n"+"Enter a/c name.","Error",JOptionPane.ERROR_MESSAGE);
					nmtf.requestFocus();
				}
				else if(undertf.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Error found!"+"\n"+"Enter a/c group.","Error",JOptionPane.ERROR_MESSAGE);
					undertf.requestFocus();
				}
				else if(obtf.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Error found!"+"\n"+"Enter opening balance.","Error",JOptionPane.ERROR_MESSAGE);
					obtf.requestFocus();
				}
				else if(nmtf.getText().length()>35)
				{
					JOptionPane.showMessageDialog(null,"Error found!"+"\n"+"A/c name can be maximum 35 characters long.","Error",JOptionPane.ERROR_MESSAGE);
					nmtf.requestFocus();
				}
				else
				{	
					save();
					frame.dispose();
					CreateLedger obj=new CreateLedger(desk);
				}
		}
		else if(event.getSource()==reset)		
		{
				frame.dispose();
				CreateLedger obj=new CreateLedger(desk);
		}
		else if(event.getSource()==exit)		
		{
				frame.dispose();
		}
	}
	
	public void keyPressed(KeyEvent event)
	{
		if(event.getKeyCode()==KeyEvent.VK_UP)
		{
			if(event.getSource()==undertf)
			{
				if((gplist.getSelectedIndex())>0)
				{
					gplist.setSelectedIndex(gplist.getSelectedIndex()-1);
					gplist.ensureIndexIsVisible(gplist.getSelectedIndex()-1);
					undertf.setText(""+gpvec.elementAt(gplist.getSelectedIndex()));
				}	
			}
		}
		else if(event.getKeyCode()==KeyEvent.VK_DOWN)
		{
			if(event.getSource()==undertf)
			{
				if((gplist.getSelectedIndex()+1)<gpvec.size())
				{
					gplist.setSelectedIndex(gplist.getSelectedIndex()+1);
					gplist.ensureIndexIsVisible(gplist.getSelectedIndex()+1);
					undertf.setText(""+gpvec.elementAt(gplist.getSelectedIndex()));
				}	
			}
		}
		else if(event.getKeyCode()==10)
		{
			if(event.getSource()==nmtf)		
			{
				undertf.requestFocus();
			}	
			else if(event.getSource()==undertf)		
			{
				undertf.setText(""+gpvec.elementAt(gplist.getSelectedIndex()));
				obtf.requestFocus();
			}	
			else if(event.getSource()==obtf)		drcr.requestFocus();
			else if(event.getSource()==drcr)		addresstf.requestFocus();
			else if(event.getSource()==addresstf)		mobtf.requestFocus();
			else if(event.getSource()==mobtf)		save.requestFocus();
			else if(event.getSource()==save)		
			{
				if(nmtf.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Error found!"+"\n"+"Enter a/c name.","Error",JOptionPane.ERROR_MESSAGE);
					nmtf.requestFocus();
				}
				else if(undertf.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Error found!"+"\n"+"Enter a/c group.","Error",JOptionPane.ERROR_MESSAGE);
					undertf.requestFocus();
				}
				else if(obtf.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null,"Error found!"+"\n"+"Enter opening balance.","Error",JOptionPane.ERROR_MESSAGE);
					obtf.requestFocus();
				}
				else if(nmtf.getText().length()>35)
				{
					JOptionPane.showMessageDialog(null,"Error found!"+"\n"+"A/c name can be maximum 35 characters long.","Error",JOptionPane.ERROR_MESSAGE);
					nmtf.requestFocus();
				}
				else
				{	
					save();
					frame.dispose();
					CreateLedger obj=new CreateLedger(desk);
				}
				
			}
			else if(event.getSource()==reset)		
			{													
				frame.dispose();
				CreateLedger obj=new CreateLedger(desk);
			}
			else if(event.getSource()==exit)		
			{
				frame.dispose();
			}
		}
		else if(event.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			frame.dispose();
		}

	}
	public void keyReleased(KeyEvent event)
	{
		if(event.getSource()==undertf)
		{
				try
				{
					int j=-1;
					String str1=undertf.getText().toUpperCase();
					for( j=0; j< gpvec.size(); j++)
					{
						String str = (gpvec.elementAt(j).toString());
						if(str.toUpperCase().indexOf(str1)==0)
						{
							gplist.setSelectedIndex(j);
							j= (gpvec.size());
			            	gplist.ensureIndexIsVisible(gplist.getSelectedIndex());
						}
					}
					if(j==gpvec.size())
					{
						undertf.setText(str1.substring(0,str1.length()-1));
					}
					undertf.requestFocus();
				}
				catch(Exception ex)
				{
					System.out.println("Error..55533..."+ex);
				}
		}
	}
	public void keyTyped(KeyEvent event)
	{
	}
	public void save()
	{
			try
			{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from partyDetails where partyName='"+nmtf.getText().trim()+"'");				
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null,"Oh!"+"\n"+"This account name already exist.");
					nmtf.requestFocus();
					nmtf.selectAll();
				}
				else
				{
					String ob=obtf.getText().trim();
					if(ob.length()==0)	ob="0";
					String partynm=nmtf.getText().trim().toUpperCase();
					String address=addresstf.getText().trim();
					String mobno=mobtf.getText().trim();
					String under=undertf.getText().trim();
					
					if((""+drcr.getSelectedItem()).equals("Dr"))				
					{
						ob="-"+ob;
						st.executeUpdate("insert into partyDetails values('"+partynm+"','"+address+"','"+mobno+"','"+ob+"','0','"+under+"')");
					}
					else
					{
						st.executeUpdate("insert into partyDetails values('"+partynm+"','"+address+"','"+mobno+"','"+ob+"','0','"+under+"')");
					}

					JOptionPane.showMessageDialog(null,"Process Completed.");
					reset.requestFocus();
				}	
				con.close();
			}
			catch(Exception ex)
			{
				System.out.println("Error111..."+ex);
			}					
	}
	public void focusLost(FocusEvent fe)
	{
	}
	public void focusGained(FocusEvent fe)
	{
		if(fe.getSource()==nmtf)	nmtf.selectAll();
		else if(fe.getSource()==undertf)	undertf.selectAll();
		else if(fe.getSource()==aliastf)	aliastf.selectAll();
		else if(fe.getSource()==obtf)	obtf.selectAll();
		else if(fe.getSource()==addresstf)	addresstf.selectAll();
		else if(fe.getSource()==mobtf)	mobtf.selectAll();
		else if(fe.getSource()==phonenotf)	phonenotf.selectAll();
		else if(fe.getSource()==tintf)	tintf.selectAll();
		else if(fe.getSource()==weftf)	weftf.selectAll();
		else if(fe.getSource()==staxtf)	staxtf.selectAll();
	}
}