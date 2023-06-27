import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;

public class PartyCreationViaScreen extends JFrame implements ActionListener,MouseListener,KeyListener,FocusListener
{
	Container con;
	JDialog frm;
	JButton addBtn,deleteBtn,exitBtn,resetBtn,editBtn;
	JTextField partyTf,addressTf,contactTf,openTf,openWtTf,pieceTf;
	JLabel fineWtLb;
	DefaultTableModel dtm;
	JTable grid;
	JRadioButton rb1,rb2;
	JComboBox drCrCb1,drCrCb2;
		
	public PartyCreationViaScreen(JDesktopPane desk)
	{
		//frm=new JInternalFrame("Add New Party",false,true,false,false);
		frm=new JDialog(new Frame(),"Add New Party",true);
		con=frm.getContentPane();
		con.setLayout(null);
		
		JLabel lab1=new JLabel("Party Name");
		JLabel lab2=new JLabel("Address");
		JLabel lab3=new JLabel("Contact No.");
		JLabel lab4=new JLabel("Opening Amount (In Rs.)");
		JLabel lab5=new JLabel("Create Party For");
		JLabel lab6=new JLabel("Opening Weight (In gm)");
		JLabel lab7=new JLabel("No. Of Pieces");
		partyTf=new JTextField();
		addressTf=new JTextField();
		contactTf=new JTextField();
		openTf=new JTextField();
		openWtTf=new JTextField();
		pieceTf=new JTextField();
		rb1=new JRadioButton("Purchase",true);
		rb2=new JRadioButton("Sale");
		ButtonGroup bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		
		addBtn=new JButton("Add New");
		deleteBtn=new JButton("Delete");
		exitBtn=new JButton("Close");
		resetBtn=new JButton("Reset");
		editBtn=new JButton("Edit");
		String heading[]={"Party Name"};
		dtm=new DefaultTableModel(heading,0);
		grid=new JTable(dtm);
		JScrollPane jsp=new JScrollPane(grid);
		drCrCb1=new JComboBox();
		drCrCb2=new JComboBox();
		drCrCb1.addItem("Dr");
		drCrCb1.addItem("Cr");
		drCrCb2.addItem("Dr");
		drCrCb2.addItem("Cr");
		drCrCb1.setBounds(290,130,40,20);	
		drCrCb2.setBounds(290,160,40,20);				
		lab5.setBounds(10,10,150,20);
		lab1.setBounds(10,40,150,20);
		lab2.setBounds(10,70,150,20);
		lab3.setBounds(10,100,150,20);
		lab4.setBounds(10,130,150,20);
		lab6.setBounds(10,160,150,20);
		lab7.setBounds(10,190,150,20);
		rb1.setBounds(160,10,100,20);
		rb2.setBounds(260,10,70,20);
		partyTf.setBounds(160,40,170,20);
		addressTf.setBounds(160,70,170,20);
		contactTf.setBounds(160,100,170,20);
		openTf.setBounds(160,130,130,20);
		openWtTf.setBounds(160,160,130,20);
		pieceTf.setBounds(160,190,170,20);
		
		editBtn.setBounds(40,240,100,25);	
		addBtn.setBounds(144,240,100,25);	
		deleteBtn.setBounds(246,240,100,25);
		resetBtn.setBounds(348,240,100,25);
		exitBtn.setBounds(450,240,100,25);
		jsp.setBounds(350,10,200,210);
		
		partyTf.setHorizontalAlignment(JTextField.CENTER);
		addressTf.setHorizontalAlignment(JTextField.CENTER);
		contactTf.setHorizontalAlignment(JTextField.CENTER);
		openTf.setHorizontalAlignment(JTextField.RIGHT);
		openWtTf.setHorizontalAlignment(JTextField.RIGHT);
		
		addBtn.setMnemonic('a');
		deleteBtn.setMnemonic('d');
		resetBtn.setMnemonic('r');
		exitBtn.setMnemonic('c');
		editBtn.setMnemonic('e');
		
		con.add(drCrCb1);
		con.add(drCrCb2);
		con.add(lab1);
		con.add(lab2);
		con.add(lab3);
		con.add(lab4);
		//con.add(lab5);
		con.add(lab6);
		//con.add(lab7);
		con.add(partyTf);
		con.add(addressTf);
		con.add(contactTf);
		con.add(openTf);
		con.add(openWtTf);
		//con.add(pieceTf);
		con.add(addBtn);
		con.add(deleteBtn);
		con.add(exitBtn);
		con.add(resetBtn);
		con.add(editBtn);
		con.add(jsp);
		//con.add(rb1);
		//con.add(rb2);
		
		addBtn.addActionListener(this);
		editBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		resetBtn.addActionListener(this);		
		exitBtn.addActionListener(this);		
		rb1.addActionListener(this);		
		rb2.addActionListener(this);		
		
		grid.addMouseListener(this);
		
		addBtn.addKeyListener(this);
		deleteBtn.addKeyListener(this);
		resetBtn.addKeyListener(this);		
		editBtn.addKeyListener(this);		
		exitBtn.addKeyListener(this);		
		
		grid.addKeyListener(this);
		partyTf.addKeyListener(this);			
		addressTf.addKeyListener(this);				
		contactTf.addKeyListener(this);				
		openTf.addKeyListener(this);			
		openWtTf.addKeyListener(this);			
		pieceTf.addKeyListener(this);			
		
		partyTf.addFocusListener(this);		
		addressTf.addFocusListener(this);		
		contactTf.addFocusListener(this);		
		openTf.addFocusListener(this);		
		openWtTf.addFocusListener(this);		
		pieceTf.addFocusListener(this);		
		
		getPartyName();

   		partyTf.requestFocus();
		
		//desk.add(frm);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-570)/2;
		int y = (ds.height-400)/2;
   		frm.reshape(x,35,570,310);
   		frm.show();
   		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addBtn)
		{
			saveData();
		}
		else if(e.getSource()==deleteBtn)
		{
			deleteData();
		}
		else if(e.getSource()==resetBtn)
		{
			reset();
		}
		else if(e.getSource()==editBtn)
		{
			editData();
		}
		else if(e.getSource()==exitBtn)
		{
			frm.dispose();
		}
		else if(e.getSource()==rb1 || e.getSource()==rb2)
		{
			getPartyName();
		}
		
	}
	public void keyPressed(KeyEvent e)
	{
		if(e.getSource()==addBtn && e.getKeyCode()==10)
		{
			saveData();
		}
		else if(e.getSource()==deleteBtn && e.getKeyCode()==10)
		{
			deleteData();
		}
		else if(e.getSource()==resetBtn && e.getKeyCode()==10)
		{
			reset();
		}
		else if(e.getSource()==editBtn && e.getKeyCode()==10)
		{
			editData();
		}
		else if(e.getSource()==exitBtn && e.getKeyCode()==10)
		{
			frm.dispose();
		}
		else if(e.getSource()==partyTf && e.getKeyCode()==10)
		{
			addressTf.requestFocus();
		}
		else if(e.getSource()==addressTf && e.getKeyCode()==10)
		{
			contactTf.requestFocus();
		}
		else if(e.getSource()==contactTf && e.getKeyCode()==10)
		{
			openTf.requestFocus();
		}
		else if(e.getSource()==openTf && e.getKeyCode()==10)
		{
			if(openTf.getText().trim().length()==0)
			{
				openTf.setText("0");
			}
			
			openWtTf.requestFocus();
		}
		else if(e.getSource()==openWtTf && e.getKeyCode()==10)
		{
			if(openWtTf.getText().trim().length()==0)
			{
				openWtTf.setText("0");
			}
			
			addBtn.requestFocus();
		}
		/*else if(e.getSource()==grid)
		{
			partyTf.setText(""+grid.getValueAt(grid.getSelectedRow(),0));			
			try
			{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        	    	rs=st.executeQuery("select * from partyDetails where partyname='"+partyTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	
        		    	addressTf.setText(rs.getString("address"));
        		    	contactTf.setText(rs.getString("contactNo"));
        		    	double db=rs.getDouble("currentAmt");
        		    	double db1=rs.getDouble("currentWt");
        		    	if(db<0)
        		    		drCrCb1.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb1.setSelectedItem("Cr");
        		    	openTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(2,5));
        		    	
        		    	//db=rs.getDouble("currentWt");
        		    	if(db1<0)
        		    		drCrCb2.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb2.setSelectedItem("Cr");
        		    	openWtTf.setText(""+(new BigDecimal(""+Math.abs(db1))).setScale(3,5));
        		    	
        		    }
		           	cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01 777..."+x);
			}
			
		}*/
		/*else if(e.getSource()==pieceTf && e.getKeyCode()==10)
		{
			addBtn.requestFocus();
		}*/
		
	}
	public void keyReleased(KeyEvent e){
		
		if(e.getSource()==grid)
		{
			partyTf.setText(""+grid.getValueAt(grid.getSelectedRow(),0));			
			try
			{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        	    	rs=st.executeQuery("select * from partyDetails where partyname='"+partyTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	
        		    	addressTf.setText(rs.getString("address"));
        		    	contactTf.setText(rs.getString("contactNo"));
        		    	double db=rs.getDouble("currentAmt");
        		    	double db1=rs.getDouble("currentWt");
        		    	if(db<0)
        		    		drCrCb1.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb1.setSelectedItem("Cr");
        		    	openTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(2,5));
        		    	
        		    	//db=rs.getDouble("currentWt");
        		    	if(db1<0)
        		    		drCrCb2.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb2.setSelectedItem("Cr");
        		    	openWtTf.setText(""+(new BigDecimal(""+Math.abs(db1))).setScale(3,5));
        		    	
        		    }
		           	//cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01 777..."+x);
			}
			
		}
		
		
		}
	public void keyTyped(KeyEvent e){}
	
	public void focusGained(FocusEvent e)
	{
		if(e.getSource()==partyTf)
		{
			partyTf.selectAll();
		}
		else if(e.getSource()==addressTf)
		{
			addressTf.selectAll();
		}
		else if(e.getSource()==contactTf)
		{
			contactTf.selectAll();
		}
		else if(e.getSource()==openTf)
		{
			openTf.selectAll();
		}
		
	}
	public void focusLost(FocusEvent fe){}
	
	
	private void editData()
	{
		try
		{
			if(partyTf.getText().trim().length()>0)
			{
								Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    			        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
		  	          			Statement st=cn.createStatement();
        			    		ResultSet rs;
        			    		rs=st.executeQuery("select * from partyDetails where partyName='"+grid.getValueAt(grid.getSelectedRow(),0)+"'");
        			    		String d1="",d2="",d3="",d4="",d5="",d6="";
        			    		if(rs.next())
        			    		{
        			    			d1=rs.getString("partyName");
        			    			d2=rs.getString("address");
        			    			d3=rs.getString("contactNo");
        			    			d4=rs.getString("currentAmt");
        			    			d5=rs.getString("currentWt");
        			    			d6=rs.getString("openAmt");
        			    		}
		    	    		    /*if(rb1.isSelected()==true)
			            			{
			            				System.out.println("purchase edit");
			            				String amt=openTf.getText().trim();
			            				if(drCrCb1.getSelectedItem().toString().equals("Dr"))
			            					amt="-"+amt;
			            				String wt=openWtTf.getText().trim();
			            				if(drCrCb2.getSelectedItem().toString().equals("Dr"))
			            					wt="-"+wt;
			            				
			            				
			            				
			            					double f=Double.valueOf(d5);
		    	    		    			double h=Double.valueOf(amt);
		    	    		    			double l=h-f;
		    	    		    			double camt=Double.valueOf(d4);
		    	    		    			double rr=camt+l;
		    	    		    			String curr=""+rr;

			            				
			            				
			            				st.executeUpdate("update partyDetails set partyName='"+partyTf.getText().trim().toUpperCase()+"',address= '"+addressTf.getText().trim()+"',contactNo='"+contactTf.getText().trim()+"',currentAmt='"+curr+"',currentWt='"+wt+"',openAmt='"+amt+"'  where partyName='"+d1+"'and address= '"+d2+"'and contactNo='"+d3+"' and currentAmt='"+d4+"'and currentWt='"+d6+"'and openAmt='"+d5+"'");	
			            				JOptionPane.showMessageDialog(null,"Party has been Updated");
			            				reset();
			            				
			            			}
			            			else	
			            			{
			            				System.out.println("Sale edit");
			            				String amt=openTf.getText().trim();
			            				if(drCrCb1.getSelectedItem().toString().equals("Dr"))
			            					amt="-"+amt;
			            				String wt=openWtTf.getText().trim();
			            				if(drCrCb2.getSelectedItem().toString().equals("Dr"))
			            					wt="-"+wt;
			            				double f=Double.valueOf(d5);
		    	    		    		double h=Double.valueOf(amt);
		    	    		    	    double l=h-f;
		    	    		    	    double camt=Double.valueOf(d4);
		    	    		    	    double rr=camt+l;
		    	    		    	    String curr=""+rr;
                                        
                                        st.executeUpdate("update partyDetails set partyName='"+partyTf.getText().trim().toUpperCase()+"',address= '"+addressTf.getText().trim()+"',contactNo='"+contactTf.getText().trim()+"',currentAmt='"+curr+"',currentWt='"+wt+"',openAmt='"+amt+"'  where partyName='"+d1+"'and address= '"+d2+"'and contactNo='"+d3+"' and currentAmt='"+d4+"'and currentWt='"+d6+"'and openAmt='"+d5+"'");	
			            				JOptionPane.showMessageDialog(null,"Party has been Updated");
			            			    reset();	
			            				
			          				}*/
		    	    		       
		    	    		    
		    	    		    
		    	    		    
		    	    		    		
			            				
			            				String amt=openTf.getText().trim();
			            				if(drCrCb1.getSelectedItem().toString().equals("Dr"))
			            					amt="-"+amt;
			            				String wt=openWtTf.getText().trim();
			            				if(drCrCb2.getSelectedItem().toString().equals("Dr"))
			            					wt="-"+wt;
			            				double f=Double.valueOf(d5);
		    	    		    		double h=Double.valueOf(amt);
		    	    		    	    double l=h-f;
		    	    		    	    double camt=Double.valueOf(d4);
		    	    		    	    double rr=camt+l;
		    	    		    	    String curr=""+rr;

			            				st.executeUpdate("update partyDetails set partyName='"+partyTf.getText().trim().toUpperCase()+"',address= '"+addressTf.getText().trim()+"',contactNo='"+contactTf.getText().trim()+"',currentAmt='"+curr+"',currentWt='"+wt+"',openAmt='"+amt+"'  where partyName='"+d1+"'and address= '"+d2+"'and contactNo='"+d3+"' and currentAmt='"+d4+"'and currentWt='"+d5+"' and openAmt='"+d6+"'");	
			            				    	    		    
    	        					JOptionPane.showMessageDialog(null,"Party has been Updated");
			            			reset();
        		    			
            					//cn.close();            			
            }	
            else
            {
            	JOptionPane.showMessageDialog(null,"Enter party name, please.");
            	partyTf.requestFocus();
            }
            
        }	
		catch(Exception x)
		{
			System.out.println("er01..dt."+x);
		}
	
	}
	private void saveData()
	{
		try
		{
			if(partyTf.getText().trim().length()>0)
			{
								Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    			        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
		  	          			Statement st=cn.createStatement();
        			    		ResultSet rs;
        			    		int psno=0;
		    	    		    rs=st.executeQuery("select max(p_s_no) from purchase");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	psno=rs.getInt(1)+1;
		    	    		    }

		    	    		    rs=st.executeQuery("select * from partyDetails where partyName='"+partyTf.getText().trim()+"'");
        					    if(rs.next())
        					    {
        		    				JOptionPane.showMessageDialog(null,"Oh! Entered party name already exist in your database.");
			            			partyTf.setText("");
        		    				partyTf.requestFocus();
        				    	}
	        		    		else			
    	        				{
    	        					
			            			
    	        					System.out.print("a");
    	        					String amt=openTf.getText().trim();
			            			if(drCrCb1.getSelectedItem().toString().equals("Dr"))
			            				amt="-"+amt;
			            			String wt=openWtTf.getText().trim();
			            			if(drCrCb2.getSelectedItem().toString().equals("Cr"))//dhananjay
			            				wt="-"+wt;
									
									//String str1=""+drCrCb1.getSelectedItem();
									//String str2=""+drCrCb2.getSelectedItem();
									
									st.executeUpdate("insert into partyDetails values('"+partyTf.getText().trim().toUpperCase()+"','"+addressTf.getText().trim()+"','"+contactTf.getText().trim()+"','"+amt+"','"+wt+"','"+amt+"','s')");    
			            			
			            			
			            			
			            			System.out.print("b");
    	        					JOptionPane.showMessageDialog(null,"New party has been added successfully.");
    	        					System.out.print("c");
			            			//reset();
			            			Sale.partyCb.removeAllItems();
			            			System.out.print("d");
			            			rs=st.executeQuery("select * from partyDetails where p_type='s' order by partyName ");
        		    				while(rs.next())
        		    				{
        		    					System.out.print("1");
				        		    	Sale.partyCb.addItem(rs.getString("partyName"));        		    	
				        		    	System.out.println("2");
        						    }
        						    Sale.partyCb.setSelectedItem(partyTf.getText().trim().toUpperCase());
		           					frm.dispose();
        		    			}
            				    //cn.close();            			            					
            }	
            else
            {
            	JOptionPane.showMessageDialog(null,"Enter party name, please.");
            	partyTf.requestFocus();
            }
            
        }	
		catch(Exception x)
		{
			System.out.println("er010101..."+x);
		}
	}
	private void reset()
	{
		partyTf.setText("");
        addressTf.setText("");
        contactTf.setText("");
        openTf.setText("");        
        openWtTf.setText("");        
 		getPartyName();
	}
	/*private void deleteData()
	{
		int res=JOptionPane.showConfirmDialog(null,"Are you sure?","Confirm dialog box",JOptionPane.YES_NO_OPTION);
		if(res==JOptionPane.YES_OPTION)
		{
			try
			{
				//if(rb1.isSelected()==true)
				
			    if(partyTf.getText().trim().length()>0)
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    rs=st.executeQuery("select * from partyDetails where partyName='"+partyTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	if(Double.valueOf(rs.getString("currentBalance"))!=0)
        		    	{
        		    		JOptionPane.showMessageDialog(null,"Oh! This party name can not delete. This party have some balance amount.");
	            			partyTf.setText("");
            				partyTf.requestFocus();            			
        		    	}
        		    	else
        		    	{
        		    		st.executeUpdate("delete * from partyDetails where partyName='"+partyTf.getText().trim()+"'");
        		    		JOptionPane.showMessageDialog(null,"Party name has been deleted successfully.");
	            			partyTf.setText("");
	            			getPartyName();
            				partyTf.requestFocus();
            			}
            		}	
        		    else			
            		{
            			JOptionPane.showMessageDialog(null,"Oh! Invalid party name found.");
	            		partyTf.setText("");
            			partyTf.requestFocus();            			
            		}
            		cn.close();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null,"Enter party name, please.");
            		partyTf.requestFocus();
            	}
            }	
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
		}
	}
	*/
	private void deleteData()
	{
		int res=JOptionPane.showConfirmDialog(null,"Are you sure?","Confirm dialog box",JOptionPane.YES_NO_OPTION);
		if(res==JOptionPane.YES_OPTION)
		{
			try
			{
				//if(rb1.isSelected()==true)
				
			    if(partyTf.getText().trim().length()>0)
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    Statement st1=cn.createStatement();
        		    ResultSet rs;
        		    rs=st.executeQuery("select * from partyDetails where partyName='"+partyTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	if(Double.valueOf(rs.getString("currentAmt"))!=0 && Double.valueOf(rs.getString("currentWt"))!=0)
        		    	{
        		    		int res1=JOptionPane.showConfirmDialog(null,"Oh! This party have some balance amount.\nDo you want to delete anywhere?","Confirmation",JOptionPane.YES_NO_OPTION);
        		    		if(res1==JOptionPane.YES_OPTION)
        		    		{
        		    			st.executeUpdate("delete * from partyDetails where partyName='"+partyTf.getText().trim()+"'");
        		    			rs=st.executeQuery("select * from sale where p_Name='"+partyTf.getText().trim()+"'");
        		    			while(rs.next())
        		    			{
        		    				int t=rs.getInt("s_s_no");
        		    				
        		    				st1.executeUpdate("delete * from sale where s_s_no="+t);
        		    				st1.executeUpdate("delete * from sale_x where s_s_no="+t);
        		    			}
        		    			reset();
        		    		}
        		    		else
	            			{
	            				partyTf.setText("");
            					partyTf.requestFocus();            			
            				}
            			}	
        		    	else
        		    	{
        		    		st.executeUpdate("delete * from partyDetails where partyName='"+partyTf.getText().trim()+"'");
        		    		JOptionPane.showMessageDialog(null,"Party name has been deleted successfully.");
	            			partyTf.setText("");
       		    			reset();
	            			//getPartyName();
            				partyTf.requestFocus();
            			}
            		}	
        		    else			
            		{
            			JOptionPane.showMessageDialog(null,"Oh! Invalid party name found.");
	            		partyTf.setText("");
            			partyTf.requestFocus();            			
            		}
            		//cn.close();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null,"Enter party name, please.");
            		partyTf.requestFocus();
            	}
            }	
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
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
        		    while(grid.getRowCount()>0)	dtm.removeRow(0);
        		    /*if(rb1.isSelected()==true)
        		    {        		    
        		    	rs=st.executeQuery("select * from partyDetails where p_type='p' order by partyName");
        		    }
        		    else*/
        		    {
        		    	rs=st.executeQuery("select * from partyDetails where p_type='s' order by partyName");
        		    }	
        		    while(rs.next())
        		    {
        		    	String arr[]=new String[1];
        		    	arr[0]=rs.getString("partyName");
        		    	dtm.addRow(arr);
        		    }
		           	//cn.close();
           	   		partyTf.requestFocus();

            }	
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
		
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
			partyTf.setText(""+grid.getValueAt(grid.getSelectedRow(),0));			
			try
			{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        	    	rs=st.executeQuery("select * from partyDetails where partyname='"+partyTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	
        		    	addressTf.setText(rs.getString("address"));
        		    	contactTf.setText(rs.getString("contactNo"));
        		    	double db=rs.getDouble("openAmt");
        		    	/*
        		    	double db1=rs.getDouble("currentWt");
        		    	String str1=rs.getString("drcr1");
        		    	String str2=rs.getString("drcr2");
        		    	*/
        		    	if(db<0)
        		    	{
        		    		drCrCb1.setSelectedItem("Dr");//drCrCb1.setSelectedItem(str1);
        		    		//openTf.setText(""+(new BigDecimal(""+Math.abs(db)))).setScale(2,5));
        		    	}	
        		    	else	        		    	
        		    	{
        		    		drCrCb1.setSelectedItem("Cr");
        		    		//openTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(2,5));
        		    	}
        		    	openTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(2,5));
        		    	
        		    	db=rs.getDouble("currentWt");
        		    	if(db<0)
        		    	{
        		    		drCrCb2.setSelectedItem("Dr");//drCrCb2.setSelectedItem(str2);
        		    		//openWtTf.setText(""+(new BigDecimal(""+Math.abs(db.substring(1,db.length() )))).setScale(3,5));
        		    	}	
        		    	else	        		    	
        		    	{
        		    		drCrCb2.setSelectedItem("Cr");
        		    		//openWtTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(3,5));
        		    	}	
        		    	openWtTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(3,5));
        		    }
		           	//cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
	}
	public void mouseExited(MouseEvent e){}
	
}