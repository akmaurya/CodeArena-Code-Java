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

class Reminder extends JFrame implements ActionListener,KeyListener //,FocusListener
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

	public Reminder(JDesktopPane desk)
	{
		//About Container
    	this.desk=desk;
       	frame=new JInternalFrame("Master For Setting No Of Day",false,true,false,true);
       	c=frame.getContentPane();
	  	c.setLayout(null);
   		desk.add(frame);
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-770)/2;
		int y = (ds.height-470)/2;
   		frame.reshape(x,y,470,220);
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
		JLabel lab2=new JLabel("Day",JLabel.CENTER);
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
		lab2.setBounds(15,55,100,25);
		lab3.setBounds(15,55,140,25);
		lab4.setBounds(280,55,100,25);
		lab5.setBounds(10,400,100,20);
		lab6.setBounds(300,400,190,20);
		lab7.setBounds(605,400,100,20);
		v_code.setBounds(380,15,100,25);
		rate.setBounds(125,55,200,20);
		bhariCb.setBounds(125,15,250,20);
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
		//bhariCb.addItem("Bhari");
		//bhariCb.addItem("Gram");
		rate.setHorizontalAlignment(JTextField.CENTER);
		
		c.add(lab1);
		c.add(lab2);
		c.add(rate);
		//c.add(lab3);
		//c.add(lab4);
		//c.add(lab5);
		//c.add(lab6);
		//c.add(lab7);
		c.add(bhariCb);
		
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
		save_icon=new ImageIcon("images/save.gif");
		reset_icon=new ImageIcon("images/reset.gif");
		close_icon=new ImageIcon("images/close.gif");
		save_btn=new JButton("Set",save_icon);
		reset_btn=new JButton("Reset",reset_icon);
		close_btn=new JButton("Close",close_icon);
		saveMetal_btn=new JButton("Adjust",close_icon);
		save_btn.setBounds(60,140,100,25);
		reset_btn.setBounds(180,140,100,25);
		close_btn.setBounds(300,140,100,25);
		saveMetal_btn.setBounds(640,397,100,25);
		save_btn.setMnemonic('s');
		reset_btn.setMnemonic('r');
		close_btn.setMnemonic('c');
		saveMetal_btn.setMnemonic('a');
		
		c.add(save_btn);
		//c.add(saveMetal_btn);
		c.add(reset_btn);
		c.add(close_btn);

		String heading1[]={"S.No.","Vch. No.","Amount","Narration"};
		dtm1=new DefaultTableModel(heading1,0);
		grid1=new JTable(dtm1);
		JScrollPane jsp1=new JScrollPane(grid1);
		jsp1.setBounds(15,100,730,250);
		//c.add(jsp1);
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
		//bhariCb.addFocusListener(this);		
		dd.addKeyListener(this);
		mm.addKeyListener(this);
		yy.addKeyListener(this);
		dramt.addKeyListener(this);
		rate.addKeyListener(this);
		//dramt.addFocusListener(this);
		
		getPartyName();
		
		frame.show();		
	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==save_btn)
		{
			saveData();
			
		}
		
		else if(event.getSource()==close_btn)
		{
			frame.dispose();
		}
		else if(event.getSource()==reset_btn)
		{
			rate.setText("");
		}
	}
	
	public void keyPressed(KeyEvent event)
	{
		if(event.getSource()==bhariCb && event.getKeyCode()==10)
		{
			rate.requestFocus();
		}
		else if(event.getSource()==rate && event.getKeyCode()==10)
		{
			save_btn.requestFocus();
		}
		else if(event.getSource()==save_btn && event.getKeyCode()==10)
		{
			saveData();
			reset_btn.requestFocus();
		}
		else if(event.getSource()==reset_btn && event.getKeyCode()==10)
		{
			rate.setText("");
			close_btn.requestFocus();
		}
		else if(event.getSource()==close_btn && event.getKeyCode()==10)
		{
			frame.dispose();		
			
		}				
		
	}
	public void keyReleased(KeyEvent event)
	{
		
	}
	public void keyTyped(KeyEvent event){}

	
	public void saveData()
	{
		if(rate.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null,"Error!\nFirst you enter Day.");			
			dramt.requestFocus();
		}
		
		else
		{
		
		try
		{
			
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	    Connection con=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
			Statement st=con.createStatement();
			Statement st1=con.createStatement();
			String name=""+bhariCb.getSelectedItem();
			String r=rate.getText();
			ResultSet rs=st1.executeQuery("select * from reminder where p_name='"+bhariCb.getSelectedItem()+"'");
			if(rs.next())
			{
				
				JOptionPane.showMessageDialog(null,"This party has already set.");			
				rate.setText("");
				bhariCb.setSelectedIndex(0);
				bhariCb.requestFocus();
				
			}
			else
			{
				st.executeUpdate("insert into reminder values('"+name+"',"+r+")");	
				JOptionPane.showMessageDialog(null,"Set successfully.");			
			}
			
			
			
			con.close();
			
			
			
		}
		catch(Exception ex)
		{
			System.out.println("Error 32234..."+ex);
			
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
        		    //while(grid.getRowCount()>0)	dtm.removeRow(0);
        		    bhariCb.addItem("-Select Party-");
        		    rs=st.executeQuery("select p_name from sale  group by p_name ");
        		    while(rs.next())
        		    {
        		    	
        		    	bhariCb.addItem(rs.getString("p_name"));
        		    	
        		    }
		           	cn.close();
            }	
			catch(Exception x)
			{
				System.out.println("er01..."+x);
			}
		
	}	

	
}