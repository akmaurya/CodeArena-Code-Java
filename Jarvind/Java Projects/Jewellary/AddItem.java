import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.math.*;
import javax.swing.table.*;

public class AddItem extends JFrame implements ActionListener,MouseListener,KeyListener,FocusListener
{
	Container con;
	JInternalFrame frm;
	JButton addBtn,editBtn,deleteBtn,exitBtn,resetBtn;
	JComboBox categoryCb;
	JTextField itemTf,openTf,tounchTf,pieceTf,dateTf;
	JLabel fineWtLb;
	DefaultTableModel dtm;
	JTable grid;
		
	public AddItem(JDesktopPane desk)
	{
		frm=new JInternalFrame("Add New Item",false,true,false,false);
		con=frm.getContentPane();
		con.setLayout(null);
		
		JLabel lab1=new JLabel("Select Category");
		JLabel lab2=new JLabel("New Item Name");
		JLabel lab3=new JLabel("Gross Weight (In gm)");
		JLabel lab4=new JLabel("Tounch");
		JLabel lab5=new JLabel("Fine Weight (In gm)");
		JLabel lab6=new JLabel("No. Of Piece(s)");
		JLabel lab7=new JLabel("Date");
		categoryCb=new JComboBox();
		itemTf=new JTextField();
		openTf=new JTextField();
		tounchTf=new JTextField();
		fineWtLb=new JLabel("",JLabel.RIGHT);
		pieceTf=new JTextField();
		dateTf=new JTextField();
		editBtn=new JButton("Update");
		addBtn=new JButton("Add New");
		deleteBtn=new JButton("Delete");
		exitBtn=new JButton("Close");
		resetBtn=new JButton("Reset");
		String heading[]={"Category Name"};
		dtm=new DefaultTableModel(heading,0);
		grid=new JTable(dtm);
		JScrollPane jsp=new JScrollPane(grid);
			
		lab7.setBounds(10,10,150,20);
		lab1.setBounds(10,40,150,20);
		lab2.setBounds(10,70,150,20);
		lab3.setBounds(10,100,150,20);
		lab4.setBounds(10,130,150,20);
		lab5.setBounds(10,160,150,20);
		lab6.setBounds(10,190,150,20);
		dateTf.setBounds(140,10,190,20);
		categoryCb.setBounds(140,40,190,20);
		itemTf.setBounds(140,70,190,20);
		openTf.setBounds(140,100,100,20);
		tounchTf.setBounds(140,130,100,20);
		fineWtLb.setBounds(140,160,100,20);
		pieceTf.setBounds(140,190,100,20);

		addBtn.setBounds(42,240,100,25);
		editBtn.setBounds(144,240,100,25);	
		deleteBtn.setBounds(246,240,100,25);
		resetBtn.setBounds(348,240,100,25);
		exitBtn.setBounds(450,240,100,25);
		jsp.setBounds(350,10,200,210);
		
		categoryCb.setMaximumRowCount(5);
		openTf.setHorizontalAlignment(JTextField.RIGHT);
		tounchTf.setHorizontalAlignment(JTextField.RIGHT);
		itemTf.setHorizontalAlignment(JTextField.CENTER);
		pieceTf.setHorizontalAlignment(JTextField.RIGHT);
		dateTf.setHorizontalAlignment(JTextField.CENTER);
		editBtn.setMnemonic('u');
		addBtn.setMnemonic('a');
		deleteBtn.setMnemonic('d');
		resetBtn.setMnemonic('r');
		exitBtn.setMnemonic('c');
		java.util.Date dt=new java.util.Date();
		String tmp=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		dateTf.setText(tmp);
		
		con.add(lab1);
		con.add(lab2);
		con.add(lab3);
		con.add(lab4);
		con.add(lab5);
		//con.add(lab6);
		con.add(lab7);
		con.add(dateTf);
		con.add(categoryCb);
		con.add(itemTf);
		con.add(openTf);
		con.add(tounchTf);
		con.add(fineWtLb);
		//con.add(pieceTf);
		con.add(addBtn);
		con.add(editBtn);
		con.add(deleteBtn);
		con.add(exitBtn);
		con.add(resetBtn);
		con.add(jsp);
		
		editBtn.addActionListener(this);
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		resetBtn.addActionListener(this);		
		exitBtn.addActionListener(this);		
		categoryCb.addActionListener(this);
		
		grid.addMouseListener(this);
		
		addBtn.addKeyListener(this);
		deleteBtn.addKeyListener(this);
		resetBtn.addKeyListener(this);		
		exitBtn.addKeyListener(this);		
		dateTf.addKeyListener(this);		
		categoryCb.addKeyListener(this);		
		itemTf.addKeyListener(this);		
		openTf.addKeyListener(this);		
		tounchTf.addKeyListener(this);		
		pieceTf.addKeyListener(this);		
		
		dateTf.addFocusListener(this);		
		itemTf.addFocusListener(this);		
		openTf.addFocusListener(this);		
		tounchTf.addFocusListener(this);		
		pieceTf.addFocusListener(this);		
		
		getCategoryName();
		
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
		else if(e.getSource()==editBtn)
		{
			editData();
		}
		else if(e.getSource()==deleteBtn)
		{
			deleteData();
		}
		else if(e.getSource()==resetBtn)
		{
			reset();
		}
		else if(e.getSource()==exitBtn)
		{
			frm.dispose();
		}
		else if(e.getSource()==categoryCb)
		{
			getItemName();
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
		else if(e.getSource()==exitBtn && e.getKeyCode()==10)
		{
			frm.dispose();
		}
		else if(e.getSource()==dateTf && e.getKeyCode()==10)
		{
			categoryCb.requestFocus();
		}
		else if(e.getSource()==categoryCb && e.getKeyCode()==10)
		{
			itemTf.requestFocus();
		}
		else if(e.getSource()==itemTf && e.getKeyCode()==10)
		{
			openTf.requestFocus();
		}
		else if(e.getSource()==openTf && e.getKeyCode()==10)
		{
			if(openTf.getText().trim().length()==0)
			{
				openTf.setText("0");
			}
			
			tounchTf.requestFocus();
		}
		else if(e.getSource()==tounchTf && e.getKeyCode()==10)
		{
			if(tounchTf.getText().trim().length()==0)
			{
				tounchTf.setText("0");
			}
			BigDecimal gWt=new BigDecimal(openTf.getText());
			BigDecimal tWt=new BigDecimal(tounchTf.getText());
			BigDecimal fWt=new BigDecimal("0");
			fWt=(gWt.multiply(tWt)).divide(new BigDecimal("100"));
			fineWtLb.setText(""+fWt.setScale(3,5));
			addBtn.requestFocus();
		}
		else if(e.getSource()==pieceTf && e.getKeyCode()==10)
		{
			if(pieceTf.getText().trim().length()==0)
			{
				pieceTf.setText("0");
			}
			addBtn.requestFocus();
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	
	public void focusGained(FocusEvent e)
	{
		if(e.getSource()==openTf)
		{
			openTf.selectAll();
		}
		else if(e.getSource()==tounchTf)
		{
			tounchTf.selectAll();
		}
		else if(e.getSource()==itemTf)
		{
			itemTf.selectAll();
		}
		else if(e.getSource()==dateTf)
		{
			dateTf.selectAll();
		}
		
	}
	public void focusLost(FocusEvent fe){}
	private void saveData()
	{
		try
		{
			if(dateTf.getText().trim().length()>0)
			{
				if(itemTf.getText().trim().length()>0)
				{
					if(openTf.getText().trim().length()>0)
					{
						if(tounchTf.getText().trim().length()>0)
						{
							//if(pieceTf.getText().trim().length()>0)
							{
								//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    			        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
		  	          			Statement st=cn.createStatement();
        			    		ResultSet rs;
		    	    		    rs=st.executeQuery("select * from itemList where itemName='"+itemTf.getText().trim()+"'");
        					    if(rs.next())
        					    {
        		    				JOptionPane.showMessageDialog(null,"Oh! This item name already exist in your database.");
			            			itemTf.setText("");
        		    				itemTf.requestFocus();
        				    	}
	        		    		else			
    	        				{
    	        					int itemcode=0;
    	        					rs=st.executeQuery("select max(itemcode) from itemlist");
    	        					if(rs.next())
    	        					{
    	        						itemcode=rs.getInt(1)+1;
    	        					}	
    	        					else
    	        					{
    	        						itemcode=1;
    	        					}
			            			st.executeUpdate("insert into itemList values('"+categoryCb.getSelectedItem()+"','"+itemTf.getText().trim().toUpperCase()+"',"+itemcode+",'"+openTf.getText().trim()+"','0')");
        			    			//'o' stands opening of item
    	        					st.executeUpdate("insert into itemTransactionDetails values('"+dateTf.getText()+"','"+categoryCb.getSelectedItem()+"','"+itemTf.getText().trim().toUpperCase()+"',"+Double.valueOf(openTf.getText().trim())+","+Double.valueOf(tounchTf.getText().trim())+","+Double.valueOf(fineWtLb.getText().trim())+",0,'o')");
    	        					JOptionPane.showMessageDialog(null,"New item has been added successfully.");
			            			reset();
        		    			}
            					cn.close();
            				}
	            			/*else
    	        			{
        	    				JOptionPane.showMessageDialog(null,"Enter no. of pieces.");
            					pieceTf.requestFocus();
            				}*/
            			}
	            		else
    	        		{
        	    			JOptionPane.showMessageDialog(null,"Enter tounch.");
            				tounchTf.requestFocus();
            			}
            		}
	            	else
    	        	{
        	    		JOptionPane.showMessageDialog(null,"Enter opening weight in gram.");
            			openTf.requestFocus();
            		}
            	}	
	            else
    	        {
        	    	JOptionPane.showMessageDialog(null,"Enter item name, please.");
            		itemTf.requestFocus();
            	}
            }	
            else
            {
            	JOptionPane.showMessageDialog(null,"Enter date, please.");
            	dateTf.requestFocus();
            }
            
        }	
		catch(Exception x)
		{
			System.out.println("er01dhan..."+x);
		}
	}
	
	
	private void editData()
	{
		int res=JOptionPane.showConfirmDialog(null,"Are you sure?","Confirm dialog box",JOptionPane.YES_NO_OPTION);
		if(res==JOptionPane.YES_OPTION)
		{
		try
		{
			if(dateTf.getText().trim().length()>0)
			{
				if(itemTf.getText().trim().length()>0)
				{
					if(openTf.getText().trim().length()>0)
					{
						if(tounchTf.getText().trim().length()>0)
						{
							if(pieceTf.getText().trim().length()>0)
							{
								//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    			        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
		  	          			Statement st=cn.createStatement();
		  	          			Statement st1=cn.createStatement();
        			    		
        			    		ResultSet rs,rs1;
		    	    		    String str1="",str2="",str3="",str4="",str5="";
		    	    		    String str6="",str7="",str8="",str9="",str10="",str11="",str12="",str13="";
		    	    		    rs=st.executeQuery("select * from itemList where itemName='"+grid.getValueAt(grid.getSelectedRow(),0)+"' ");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	str1=rs.getString("categoryName");
		    	    		    	str2=rs.getString("itemName");
		    	    		    	str3=rs.getString("weight");
		    	    		    	str4=rs.getString("piece");
		    	    		    	
		    	    		    }
		    	    		    System.out.println("checking......1");
		    	    		    double str33=Double.valueOf(openTf.getText());
		    	    		    System.out.println("checking......str33--2="+str33);
		    	    		    double hj=Double.valueOf(str3);
		    	    		    System.out.println("checking......hj=-3="+hj);
		    	    		    double sdf=str33-hj;
		    	    		    System.out.println("checking......sdf--4="+sdf);
		    	    		    
		    	    		    double openingwt=0;
		    	    		    rs=st.executeQuery("select weight from itemTransactionDetails where itemname='"+str2+"'");
		    	    		    if(rs.next())
		    	    		    {
		    	    		    	openingwt=rs.getDouble(1);
		    	    		    }
		    	    		    double itemweight=hj+(str33-openingwt);
		    	    		    
		    	    		    double p=Double.valueOf(str4);
		    	    		    double p1=Double.valueOf(pieceTf.getText());
		    	    		    double p2=p1-p;
		    	    		    
		    	    		    System.out.println("update itemList set categoryName='"+categoryCb.getSelectedItem()+"',itemName='"+itemTf.getText().trim().toUpperCase()+"',weight="+itemweight+", piece="+pieceTf.getText()+" where categoryName='"+str1+"' and itemName='"+str2+"'");
		    	    		    st.executeUpdate("update itemList set categoryName='"+categoryCb.getSelectedItem()+"',itemName='"+itemTf.getText().trim().toUpperCase()+"',weight="+itemweight+", piece="+pieceTf.getText()+" where categoryName='"+str1+"' and itemName='"+str2+"'");// and weight="+sdf+" and piece="+p2+" ");
		    	    		    System.out.println("dhananjay tiwari..............1");
		    	    		    
		    	    		    rs1=st1.executeQuery("select * from itemTransactionDetails where itemName='"+grid.getValueAt(grid.getSelectedRow(),0)+"' ");
		    	    		    if(rs1.next())
		    	    		    {
		    	    		    	str5=rs1.getString("categoryName");
		    	    		    	str6=rs1.getString("itemName");
		    	    		    	str7=rs1.getString("weight");
		    	    		    	str8=rs1.getString("tounch");
		    	    		    	str9=rs1.getString("fineWt");
		    	    		    	str10=rs1.getString("piece");
		    	    		    	
		    	    		    }
		    	    		    
		    	    		    st1.executeUpdate("update   itemTransactionDetails  set categoryName='"+categoryCb.getSelectedItem()+"',itemName='"+itemTf.getText().trim().toUpperCase()+"',weight="+openTf.getText().trim()+",tounch="+tounchTf.getText()+",fineWt="+fineWtLb.getText()+",piece="+pieceTf.getText()+" where categoryName='"+str5+"' and itemName='"+str6+"' and weight="+str7+" and tounch="+str8+" and fineWt="+str9+" and piece="+str10+" ");
		    	    		    reset();
		    	    		    JOptionPane.showMessageDialog(null,"Updated successfully.");
		    	    		    
		    	    		    
		    	    		    
	 
		    	    		    /*rs=st.executeQuery("select * from itemList where itemName='"+itemTf.getText().trim()+"'");
        					    if(rs.next())
        					    {
        		    				JOptionPane.showMessageDialog(null,"Oh! This item name already exist in your database.");
			            			itemTf.setText("");
        		    				itemTf.requestFocus();
        				    	}
	        		    		else			
    	        				{
			            			
			            			st.executeUpdate("delete * from itemList where categoryName='"+categoryCb.getSelectedItem()+"' and itemName='"+itemTf.getText().trim()+"'");
        		    				st.executeUpdate("delete * from itemTransactionDetails where categoryName='"+categoryCb.getSelectedItem()+"' and itemName='"+itemTf.getText().trim()+"'");
			            			//st.executeUpdate("delete * from itemList where itemName='"+itemTf.getText().trim()+"' ");
			            			st.executeUpdate("insert into itemList values('"+categoryCb.getSelectedItem()+"','"+itemTf.getText().trim().toUpperCase()+"','"+openTf.getText().trim()+"','"+pieceTf.getText().trim()+"')");
        			    			//'o' stands opening of item
    	        					//st.executeUpdate("delete * from itemTransactionDetails where itemName='"+itemTf.getText().trim()+"' ");
    	        					st.executeUpdate("insert into itemTransactionDetails values('"+dateTf.getText()+"','"+categoryCb.getSelectedItem()+"','"+itemTf.getText().trim().toUpperCase()+"',"+Double.valueOf(openTf.getText().trim())+","+Double.valueOf(tounchTf.getText().trim())+","+Double.valueOf(fineWtLb.getText().trim())+","+Double.valueOf(pieceTf.getText().trim())+",'o')");
    	        					
    	        					
    	        					
    	        					
			            			
        		    			}*/
            					cn.close();
            				}
	            			else
    	        			{
        	    				JOptionPane.showMessageDialog(null,"Enter no. of pieces.");
            					pieceTf.requestFocus();
            				}
            			}
	            		else
    	        		{
        	    			JOptionPane.showMessageDialog(null,"Enter tounch.");
            				tounchTf.requestFocus();
            			}
            		}
	            	else
    	        	{
        	    		JOptionPane.showMessageDialog(null,"Enter opening weight in gram.");
            			openTf.requestFocus();
            		}
            	}	
	            else
    	        {
        	    	JOptionPane.showMessageDialog(null,"Enter item name, please.");
            		itemTf.requestFocus();
            	}
            }	
            else
            {
            	JOptionPane.showMessageDialog(null,"Enter date, please.");
            	dateTf.requestFocus();
            }
            
        }	
		catch(Exception x)
		{
			System.out.println("er01dhan..."+x);
		}
		}
	}
	private void reset()
	{
		itemTf.setText("");
        openTf.setText("");
        tounchTf.setText("");
        fineWtLb.setText("");
        pieceTf.setText("");
        itemTf.requestFocus();
 		getItemName();
	}
	private void deleteData()
	{
		int res=JOptionPane.showConfirmDialog(null,"Are you sure?","Confirm dialog box",JOptionPane.YES_NO_OPTION);
		if(res==JOptionPane.YES_OPTION)
		{
			try
			{
				if(itemTf.getText().trim().length()>0)
				{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    rs=st.executeQuery("select * from itemList where categoryName='"+categoryCb.getSelectedItem()+"' and itemName='"+itemTf.getText().trim()+"'");
        		    if(rs.next())
        		    {
        		    	st.executeUpdate("delete * from itemList where categoryName='"+categoryCb.getSelectedItem()+"' and itemName='"+itemTf.getText().trim()+"'");
        		    	st.executeUpdate("delete * from itemTransactionDetails where categoryName='"+categoryCb.getSelectedItem()+"' and itemName='"+itemTf.getText().trim()+"'");
        		    	JOptionPane.showMessageDialog(null,"Item name has been deleted successfully.");
	            		itemTf.setText("");
	            		getItemName();
            			itemTf.requestFocus();
        		    }
        		    else			
            		{
            			//st.executeUpdate("insert into categoryList values('"+categoryLb.getText().trim().toUpperCase()+"')");
    	        		JOptionPane.showMessageDialog(null,"Oh! Invalid item name found.");
	            		itemTf.setText("");
            			itemTf.requestFocus();            			
            		}
            		cn.close();
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null,"Enter item name, please.");
            		itemTf.requestFocus();
            	}
            }	
			catch(Exception x)
			{
				System.out.println("er012..."+x);
			}
		}
	}
	private void getCategoryName()
	{
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    while(grid.getRowCount()>0)	dtm.removeRow(0);
        		    rs=st.executeQuery("select * from categoryList order by categoryName");
        		    while(rs.next())
        		    {
        		    	
        		    	categoryCb.addItem(rs.getString("categoryName"));
        		    	
        		    }
		           	cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
		
	}
	private void getItemName()
	{
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    while(grid.getRowCount()>0)	dtm.removeRow(0);
        		    rs=st.executeQuery("select * from itemList where categoryName='"+categoryCb.getSelectedItem()+"' order by itemName");
        		    while(rs.next())
        		    {
        		    	String arr[]=new String[1];
        		    	arr[0]=rs.getString("itemName");
        		    	dtm.addRow(arr);
        		    }
		           	cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er013..."+x);
			}
		
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseClicked(MouseEvent e)
	{
			itemTf.setText(""+grid.getValueAt(grid.getSelectedRow(),0));
			try
			{
					//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	        	Connection cn=Utility.makeConnection();//DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
	            	Statement st=cn.createStatement();
        		    ResultSet rs;
        		    rs=st.executeQuery("select * from itemTransactionDetails where categoryName='"+categoryCb.getSelectedItem()+"' and  itemName='"+itemTf.getText()+"'");
        		    if(rs.next())
        		    {
        		    	openTf.setText(rs.getString("Weight"));
        		    	tounchTf.setText(rs.getString("tounch"));
						fineWtLb.setText(rs.getString("fineWt"));
						pieceTf.setText(rs.getString("piece"));
        		    	
        		    }
		           	cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er014tiwari..."+x);
			}
	}
	public void mouseExited(MouseEvent e){}
	
}