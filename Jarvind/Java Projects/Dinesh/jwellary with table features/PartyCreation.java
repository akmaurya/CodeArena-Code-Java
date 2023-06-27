import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;

public class PartyCreation extends JFrame implements ActionListener,MouseListener,KeyListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	JButton addBtn,deleteBtn,exitBtn,resetBtn,editBtn;
	JTextField partyTf,addressTf,contactTf,openTf,openWtTf,silverTf;
	JLabel fineWtLb;
	DefaultTableModel dtm;
	JTable grid;
	JRadioButton rb1,rb2;
	JComboBox drCrCb1,drCrCb2,drCrCb3;
			
	public PartyCreation(JDesktopPane desk)
	{
		frm=new JInternalFrame("Add New Party",false,true,false,false);
		con=frm.getContentPane();
		con.setLayout(null);
		
		JLabel lab1=new JLabel("Party Name");
		JLabel lab2=new JLabel("Address");
		JLabel lab3=new JLabel("Contact No.");
		JLabel lab4=new JLabel("Opening Amount (In Rs.)");
		JLabel lab5=new JLabel("Create Party For");
		JLabel lab6=new JLabel("Opening Gold Weight (In gm)");
		JLabel lab7=new JLabel("Opening Silver Weight (In gm)");
		partyTf=new JTextField();
		addressTf=new JTextField();
		contactTf=new JTextField();
		openTf=new JTextField();
		openWtTf=new JTextField();
		silverTf=new JTextField();
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
		drCrCb3=new JComboBox();
		drCrCb1.addItem("Dr");
		drCrCb1.addItem("Cr");
		drCrCb2.addItem("Dr");
		drCrCb2.addItem("Cr");
		drCrCb3.addItem("Dr");
		drCrCb3.addItem("Cr");
		drCrCb1.setBounds(290,130,40,20);	
		drCrCb2.setBounds(290,160,40,20);	
		drCrCb3.setBounds(290,190,40,20);	
		lab5.setBounds(10,10,150,20);
		lab1.setBounds(10,40,150,20);
		lab2.setBounds(10,70,150,20);
		lab3.setBounds(10,100,150,20);
		lab4.setBounds(10,130,150,20);
		lab6.setBounds(10,160,190,20);
		lab7.setBounds(10,190,190,20);
		rb1.setBounds(160,10,100,20);
		rb2.setBounds(260,10,70,20);
		partyTf.setBounds(160,40,170,20);
		addressTf.setBounds(160,70,170,20);
		contactTf.setBounds(160,100,170,20);
		openTf.setBounds(160,130,130,20);
		openWtTf.setBounds(200,160,90,20);
		silverTf.setBounds(200,190,90,20);
		
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
		silverTf.setHorizontalAlignment(JTextField.RIGHT);
		
		addBtn.setMnemonic('a');
		deleteBtn.setMnemonic('d');
		resetBtn.setMnemonic('r');
		editBtn.setMnemonic('e');
		exitBtn.setMnemonic('c');
		
		con.add(drCrCb1);
		con.add(drCrCb2);
		con.add(drCrCb3);
		con.add(lab1);
		con.add(lab2);
		con.add(lab3);
		con.add(lab4);
		con.add(lab5);
		con.add(lab6);
		con.add(lab7);
		con.add(partyTf);
		con.add(addressTf);
		con.add(contactTf);
		con.add(openTf);
		con.add(openWtTf);
		con.add(silverTf);
		con.add(addBtn);
		con.add(deleteBtn);
		con.add(exitBtn);
		con.add(resetBtn);
		con.add(editBtn);
		con.add(jsp);
		con.add(rb1);
		con.add(rb2);
		
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		resetBtn.addActionListener(this);		
		editBtn.addActionListener(this);		
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
		silverTf.addKeyListener(this);			
		
		partyTf.addFocusListener(this);		
		addressTf.addFocusListener(this);		
		contactTf.addFocusListener(this);		
		openTf.addFocusListener(this);		
		openWtTf.addFocusListener(this);		
		silverTf.addFocusListener(this);		
		
		getPartyName();
		
		desk.add(frm);
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
			
			silverTf.requestFocus();
		}
		else if(e.getSource()==silverTf && e.getKeyCode()==10)
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
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        	    	rs=st.executeQuery("select * from partyDetails where partyname='"+partyTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	
        		    	addressTf.setText(rs.getString("address"));
        		    	contactTf.setText(rs.getString("contactNo"));
        		    	double db=rs.getDouble("currentAmt");
        		    	if(db<0)
        		    		drCrCb1.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb1.setSelectedItem("Cr");
        		    	openTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(2,5));
        		    	
        		    	db=rs.getDouble("currentWt");
        		    	if(db<0)
        		    		drCrCb2.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb2.setSelectedItem("Cr");
        		    	openWtTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(3,5));
        		    	
        		    }
		           	cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
			
		}*/
		/*else if(e.getSource()==silverTf && e.getKeyCode()==10)
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
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        	    	rs=st.executeQuery("select * from partyDetails where partyname='"+partyTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	
        		    	addressTf.setText(rs.getString("address"));
        		    	contactTf.setText(rs.getString("contactNo"));
        		    	double db=rs.getDouble("openAmt");
        		    	if(db<0)
        		    		drCrCb1.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb1.setSelectedItem("Cr");
        		    	openTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(2,5));
        		    	
        		    	//db=rs.getDouble("currentWt");
        		    	db=rs.getDouble("openWt");
        		    	if(db<0)
        		    		drCrCb2.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb2.setSelectedItem("Cr");
        		    	openWtTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(3,5));
        		    	
        		    	//db=rs.getDouble("currentSilverWt");
        		    	db=rs.getDouble("openSilverWt");
        		    	if(db<0)
        		    		drCrCb3.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb3.setSelectedItem("Cr");
        		    	silverTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(3,5));
        		    	
        		    }
		           	//cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01..."+x);
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
								//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    			        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
		  	          			//Statement st=DeskTop.cn1.createStatement();
		  	          			Statement st=cn.createStatement();
        			    		String curamt="0",curgoldwt="0",cursilverwt="0",oldopeningamt="0",oldopeninggoldwt="0",oldopeningsilverwt="0";
        			    		ResultSet rs;
        			    		rs=st.executeQuery("select * from partyDetails where partyName='"+grid.getValueAt(grid.getSelectedRow(),0)+"'");
        			    		String d1="",d2="",d3="",d4="",d5="",d6="",d7="";
        			    		if(rs.next())
        			    		{
        			    			d1=rs.getString("partyName");
        			    			d2=rs.getString("address");
        			    			d3=rs.getString("contactNo");
        			    			
        			    			curamt=rs.getString("currentAmt");
        			    			if(curamt==null || curamt.equals(""))
        			    				curamt="0";
        			    			curgoldwt=rs.getString("currentWt");
        			    			if(curgoldwt==null || curgoldwt.equals(""))
        			    				curgoldwt="0";
        			    			cursilverwt=rs.getString("currentSilverWt");
        			    			if(cursilverwt==null || cursilverwt.equals(""))
        			    				cursilverwt="0";
        			    			oldopeningamt=rs.getString("openAmt");
        			    			if(oldopeningamt==null || oldopeningamt.equals(""))
        			    				oldopeningamt="0";
        			    			oldopeninggoldwt=rs.getString("openWt");
        			    			if(oldopeninggoldwt==null || oldopeninggoldwt.equals(""))
        			    				oldopeninggoldwt="0";
        			    			oldopeningsilverwt=rs.getString("openSilverWt");
        			    			if(oldopeningsilverwt==null || oldopeningsilverwt.equals(""))
        			    				oldopeningsilverwt="0";
        			    			
        			    		}
		    	    		    
		    	    		    	
		    	    		    	
		    	    		    			    	    		    	
		    	    		    	
		    	    		    	if(rb1.isSelected()==true)
			            			{
			            				System.out.println("purchase edit");
			            				String amt=openTf.getText().trim();
			            				if(amt.equals(""))
			            					amt="0";
			            				if(drCrCb1.getSelectedItem().toString().equals("Dr"))
			            					amt="-"+amt;
			            				String wt=openWtTf.getText().trim();
			            				if(wt.equals(""))
			            					wt="0";
			            				if(drCrCb2.getSelectedItem().toString().equals("Dr"))
			            					wt="-"+wt;
			            				String silverwt=silverTf.getText().trim();
			            				if(silverwt.equals(""))
			            					silverwt="0";
			            				if(drCrCb3.getSelectedItem().toString().equals("Dr"))
			            					silverwt="-"+silverwt;
			            				
			            				
			            				//opening amount.
			            				////////////////////
			            					//double f=Double.valueOf(d5);
		    	    		    			double newopeningamt=Double.valueOf(amt);
		    	    		    			//double l=h-f;
		    	    		    			double openingamt=(Double.valueOf(curamt)-Double.valueOf(oldopeningamt))+newopeningamt;
		    	    		    		
		    	    		    		//opening gold's wt
		    	    		    		///////////////////////
		    	    		    			double newopeningamt1=Double.valueOf(wt);
			            					double newgoldwt=(Double.valueOf(curgoldwt)-Double.valueOf(oldopeninggoldwt))+newopeningamt1;
		    	    		    		
			            				//opening silver's wt.
			            				////////////////////
			            					//double f1=Double.valueOf(d7);
			            					double newopeningamt2=Double.valueOf(silverwt);
			            					double newsilverwt=(Double.valueOf(cursilverwt)-Double.valueOf(oldopeningsilverwt))+newopeningamt2;
		    	    		    			//double h1=Double.valueOf(amt);
		    	    		    			
			            				st.executeUpdate("update partyDetails set partyName='"+partyTf.getText().trim().toUpperCase()+"',address= '"+addressTf.getText().trim()+"',contactNo='"+contactTf.getText().trim()+"',currentAmt="+openingamt+",currentWt="+newgoldwt+",currentSilverWt="+newsilverwt+",openAmt="+Double.valueOf(amt)+",openWt="+Double.valueOf(wt)+",openSilverWt="+Double.valueOf(silverwt)+"  where partyName='"+d1+"' and address= '"+d2+"' and contactNo='"+d3+"' and p_type='p'");//and currentAmt='"+d4+"'and currentWt='"+d6+"'and openAmt='"+d5+"'");	
			            				JOptionPane.showMessageDialog(null,"Party has been Updated");
			            				reset();
			            			}
			            			else	
			            			{
			            				/*System.out.println("Sale edit");
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
			            			    reset();*/
			            			    
			            			    String amt=openTf.getText().trim();
			            				if(amt.equals(""))
			            					amt="0";
			            				if(drCrCb1.getSelectedItem().toString().equals("Dr"))
			            					amt="-"+amt;
			            				String wt=openWtTf.getText().trim();
			            				if(wt.equals(""))
			            					wt="0";
			            				if(drCrCb2.getSelectedItem().toString().equals("Dr"))
			            					wt="-"+wt;
			            				String silverwt=silverTf.getText().trim();
			            				if(silverwt.equals(""))
			            					silverwt="0";
			            				if(drCrCb3.getSelectedItem().toString().equals("Dr"))
			            					silverwt="-"+silverwt;
			            				
			            				
			            				//opening amount.
			            				////////////////////
			            					//double f=Double.valueOf(d5);
		    	    		    			double newopeningamt=Double.valueOf(amt);
		    	    		    			//double l=h-f;
		    	    		    			double openingamt=(Double.valueOf(curamt)-Double.valueOf(oldopeningamt))+newopeningamt;
		    	    		    		
		    	    		    		//opening gold's wt
		    	    		    		///////////////////////
		    	    		    			double newopeningamt1=Double.valueOf(wt);
			            					double newgoldwt=(Double.valueOf(curgoldwt)-Double.valueOf(oldopeninggoldwt))+newopeningamt1;
		    	    		    		
			            				//opening silver's wt.
			            				////////////////////
			            					//double f1=Double.valueOf(d7);
			            					double newopeningamt2=Double.valueOf(silverwt);
			            					double newsilverwt=(Double.valueOf(cursilverwt)-Double.valueOf(oldopeningsilverwt))+newopeningamt2;
		    	    		    			//double h1=Double.valueOf(amt);
		    	    		    			
			            				st.executeUpdate("update partyDetails set partyName='"+partyTf.getText().trim().toUpperCase()+"',address= '"+addressTf.getText().trim()+"',contactNo='"+contactTf.getText().trim()+"',currentAmt="+openingamt+",currentWt="+newgoldwt+",currentSilverWt="+newsilverwt+",openAmt="+Double.valueOf(openTf.getText())+",openWt="+Double.valueOf(openWtTf.getText())+",openSilverWt="+Double.valueOf(silverTf.getText())+"  where partyName='"+d1+"' and address= '"+d2+"' and contactNo='"+d3+"' and p_type='s'");//and currentAmt='"+d4+"'and currentWt='"+d6+"'and openAmt='"+d5+"'");	
			            				JOptionPane.showMessageDialog(null,"Party has been Updated");
			            				reset();	
			            				
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
			System.out.println("er01..dt."+x);
			JOptionPane.showMessageDialog(this,"Please Input Correct Data To Update.\n"+x,"Error !!!",JOptionPane.ERROR_MESSAGE);
		}
	
	}	
	private void saveData()
	{
		try
		{
			if(partyTf.getText().trim().length()>0)
			{
								//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    			        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
		  	          			//Statement st=DeskTop.cn1.createStatement();
		  	          			Statement st=cn.createStatement();
        			    		
        			    		ResultSet rs;
        			    		/*int psno=0;
		    	    		    rs=st.executeQuery("select max(p_s_no) from purchase");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	psno=rs.getInt(1)+1;
		    	    		    }*/

		    	    		    rs=st.executeQuery("select * from partyDetails where partyName='"+partyTf.getText().trim()+"'");
        					    if(rs.next())
        					    {
        		    				JOptionPane.showMessageDialog(null,"Oh! Entered party name already exist in your database.");
			            			partyTf.setText("");
        		    				partyTf.requestFocus();
        				    	}
	        		    		else			
    	        				{
    	        					/*System.out.print("a");
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
		           					frm.dispose();*/
    	        					if(rb1.isSelected()==true)
			            			{
			            				String amt=openTf.getText().trim();
			            				if(drCrCb1.getSelectedItem().toString().equals("Dr"))
			            					amt="-"+amt;
			            				String wt=openWtTf.getText().trim();
			            				if(drCrCb2.getSelectedItem().toString().equals("Dr"))
			            					wt="-"+wt;
			            				String silverwt=silverTf.getText().trim();
			            				if(drCrCb3.getSelectedItem().toString().equals("Dr"))
			            					silverwt="-"+silverwt;
			            				System.out.println("insert into partyDetails values('"+partyTf.getText().trim().toUpperCase()+"','"+addressTf.getText().trim()+"','"+contactTf.getText().trim()+"','"+amt+"','"+wt+"','"+silverwt+"','"+amt+"','"+wt+"','"+silverwt+"','p')");	
			            				st.executeUpdate("insert into partyDetails values('"+partyTf.getText().trim().toUpperCase()+"','"+addressTf.getText().trim()+"','"+contactTf.getText().trim()+"','"+amt+"','"+wt+"','"+silverwt+"','"+amt+"','"+wt+"','"+silverwt+"','p')");
			            			}
			            			else	
			            			{
			            				String amt=openTf.getText().trim();
			            				if(drCrCb1.getSelectedItem().toString().equals("Dr"))
			            					amt="-"+amt;
			            				String wt=openWtTf.getText().trim();
			            				if(drCrCb2.getSelectedItem().toString().equals("Dr"))
			            					wt="-"+wt;
			            				String silverwt=silverTf.getText().trim();
			            				if(drCrCb3.getSelectedItem().toString().equals("Dr"))
			            					silverwt="-"+silverwt;
			            				st.executeUpdate("insert into partyDetails values('"+partyTf.getText().trim().toUpperCase()+"','"+addressTf.getText().trim()+"','"+contactTf.getText().trim()+"','"+amt+"','"+wt+"','"+silverwt+"','"+amt+"','"+wt+"','"+silverwt+"','s')");
			          				}  			
			            			//java.util.Date dt=new java.util.Date();	
			            			//String dtstr=""+(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);
			            			
			            			//st.executeUpdate("insert into purchase values("+psno+",'"+partyTf.getText().trim().toUpperCase()+"','"+dtstr+"','','',"+(Double.valueOf(openWtTf.getText()))+",100,"+Integer.parseInt(silverTf.getText())+","+(Double.valueOf(openWtTf.getText()))+",'p')");	
			    	    		    //st.executeUpdate("insert into purchase_x values("+psno+",0,0,0,0,"+Double.valueOf(openWtTf.getText().trim())+","+Double.valueOf(openTf.getText().trim())+",0,0,0,0,0,false,false,false,'')");
    	        					JOptionPane.showMessageDialog(null,"New party has been added successfully.");
			            			reset();
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
	
	
	private void reset()
	{
		partyTf.setText("");
        addressTf.setText("");
        contactTf.setText("");
        openTf.setText("");        
        openWtTf.setText("");        
        silverTf.setText("");        
 		getPartyName();
	}
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
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    Statement st1=cn.createStatement();
					//Statement st=DeskTop.cn1.createStatement();
        		    //Statement st1=DeskTop.cn1.createStatement();

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
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    
        		    ResultSet rs;
        		    while(grid.getRowCount()>0)	dtm.removeRow(0);
        		    if(rb1.isSelected()==true)
        		    {        		    
        		    	rs=st.executeQuery("select * from partyDetails where p_type='p' order by partyName");
        		    }
        		    else
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
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        	    	rs=st.executeQuery("select * from partyDetails where partyname='"+partyTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	
        		    	addressTf.setText(rs.getString("address"));
        		    	contactTf.setText(rs.getString("contactNo"));
        		    	double db=rs.getDouble("openAmt");
        		    	if(db<0)
        		    		drCrCb1.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb1.setSelectedItem("Cr");
        		    	openTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(2,5));
        		    	
        		    	//db=rs.getDouble("currentWt");
        		    	db=rs.getDouble("openWt");
        		    	if(db<0)
        		    		drCrCb2.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb2.setSelectedItem("Cr");
        		    	openWtTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(3,5));
        		    	
        		    	//db=rs.getDouble("currentSilverWt");
        		    	db=rs.getDouble("openSilverWt");
        		    	if(db<0)
        		    		drCrCb3.setSelectedItem("Dr");
        		    	else	        		    	
        		    		drCrCb3.setSelectedItem("Cr");
        		    	silverTf.setText(""+(new BigDecimal(""+Math.abs(db))).setScale(3,5));
        		    	
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