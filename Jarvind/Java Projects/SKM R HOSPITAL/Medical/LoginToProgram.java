/*LoginToProgram
 *Second Window
 *This Program is taking
 *a Dialog Box For
 *Login
 *If You Give Wrong ID and
 *Password and
 *Level Then
 *Program not executed
 *Created date Aug20,2010
 *Author Sunil Maurya
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.rmi.*;
class LoginToProgram  extends JFrame implements ActionListener,KeyListener
{
	Container cn;
	JDialog dg;
	JLabel notes;
	JTextField log;
	JPasswordField pws;
	JComboBox cbLog;
	JButton btn1,btn2;
	java.util.Date dt;
	int d,mm,yy,hh,m,s;
	task5 t=null;
	
	/*public static void main(String args[])
	{
		LoginToProgram frm=new LoginToProgram();
		
	}*/
	
	public LoginToProgram()
	{
		//DIALOG BOX FOR LOGIN
		
		dg=new JDialog(new JFrame(),"Login",true);
		dg.setAlwaysOnTop(true);
		cn=dg.getContentPane();
		cn.setBackground(new Color(154,238,166));
		cn.setLayout(null);
		
		JLabel lbl1=new JLabel("Enter loginID");
		JLabel lbl2=new JLabel("Enter Password");
		JLabel lbl3=new JLabel("Select Level");
		notes=new JLabel("You Are Welcome.........");
		notes.setForeground(Color.RED);
		notes.setFont(new Font("monotype corsiva",Font.ITALIC,18));
		notes.setBounds(20,5,350,15);
		cn.add(notes);
		lbl1.setBounds(20,25,100,25);
		cn.add(lbl1);
		lbl2.setBounds(20,75,100,25);
		cn.add(lbl2);
		lbl3.setBounds(20,125,100,25);
		cn.add(lbl3);
		log=new JTextField("");
		log.setBounds(140,25,200,25);
		cn.add(log);
		pws=new JPasswordField("");
		pws.setForeground(Color.RED);
		pws.setBounds(140,75,200,25);
		cn.add(pws);
		cbLog =new JComboBox();
		cbLog.addItem("Admin");
		cbLog.addItem("User");		
		cbLog.setBounds(140,125,200,25);
		cn.add(cbLog);
		String path=null;
		try
		{
			File fl=new File(".");
			path=fl.getCanonicalPath();
			
		}
		catch(Exception e)
		{
			System.out.println("Error.."+e);
		}
		ImageIcon i1=new ImageIcon(path+"\\icons\\login.gif");
		btn1=new JButton("LOGIN",i1);
		btn1.setMnemonic('L');
		btn1.setBounds(40,180,120,30);
		cn.add(btn1);
		ImageIcon i2=new ImageIcon(path+"\\icons\\exit.gif");
		btn2=new JButton("CLOSE",i2);
		btn2.setMnemonic('E');
		btn2.setBounds(220,180,120,30);
		cn.add(btn2);

		//Using Date and Time
		dt = new java.util.Date();
		d=dt.getDate();
		mm=dt.getMonth()+1;
		yy=dt.getYear()+1900;
		hh=dt.getHours();
		m=dt.getMinutes();
		s=dt.getSeconds();
		
		

		log.addKeyListener(this);
		pws.addKeyListener(this);
		cbLog.addKeyListener(this);
		btn1.addKeyListener(this);
		btn2.addKeyListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
				
		btn1.requestFocus();
		t = new task5();
        t.start();
		dg.setResizable(false);
		Dimension sd=Toolkit.getDefaultToolkit().getScreenSize();
       	dg.reshape((sd.width-360)/2,((sd.height-200)/2)-50,380,260);
		//dg.reshape(400,220,380,260);
		dg.show();
		
		
	}

	public void keyPressed(KeyEvent ke)
	{
		int code=ke.getKeyCode();

		if(ke.getSource()==log && code==KeyEvent.VK_ENTER )
		{
			pws.requestFocus();
		}
		
		if(ke.getSource()==pws && code==KeyEvent.VK_ENTER )
		{
			cbLog.requestFocus();
		}

		if(ke.getSource()==cbLog && code==KeyEvent.VK_ENTER )
		{
			btn1.requestFocus();
		}
		
		if(ke.getSource()==btn1 && code==KeyEvent.VK_ENTER )
		{
			ActionOfButton1();
		}
		if(ke.getSource()==btn1 && code==KeyEvent.VK_L )
		{
			ActionOfButton1();
		}
		if(ke.getSource()==btn2 && code==KeyEvent.VK_C)
		{
			System.exit(0);
		}
		if(ke.getSource()==btn2 && code==KeyEvent.VK_ENTER )
		{
			System.exit(0);
		}

	}
	public void keyTyped(KeyEvent ke)
	{}
	public void keyReleased(KeyEvent ke)
	{}

	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==btn1)
		{
			ActionOfButton1();
		}

		if(ae.getSource()==btn2)
		{
			System.exit(0);
		}
		
	}

	private void ActionOfButton1()
	{
		int flag=0;
		try
		{
			ZedInterface inf=null;
ZedInterfaceForMedical inf1=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
			String[][] rs=inf.getResultSetAs_2D_Array("select uId,uPws,uLevel from loginMasterOfMedical",3);
			//System.out.println("level="+cbLog.getSelectedIndex());	
			if(rs!=null)
			{
				for(int i=0;i<rs.length;i++)
				{
				
				String str1=rs[i][0];
				String str2=rs[i][1];
				String str3=rs[i][2];
				//System.out.println(str1+"   "+str2+"   "+str3);
				//System.out.println("input=  "+log.getText()+"   "+pws.getText()+"   "+""+cbLog.getSelectedIndex());
				if(str1.equals(log.getText()))
				{
					
					if(str2.equals(pws.getText()))
					{
						if(str3.equals(""+cbLog.getSelectedIndex()))
						{	
							flag=1;
							String dateTime=mm+"/"+d+"/"+yy+" "+hh+":"+m+":"+s;
						//System.out.println("Date="+dateTime);			//System.out.println("Date="+d);
							inf.executeUpdateQuery("insert into DateOfOpeningAppln values('"+str1+"','"+dateTime+"','MEDICAL')");
							
							dg.dispose();
							MainBase mbFrm=new MainBase(log.getText(),cbLog.getSelectedIndex());
        					mbFrm.setExtendedState(mbFrm.MAXIMIZED_BOTH);
        					mbFrm.setVisible(true);
							

							break;
						}
					}
				}
				}
			
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(dg,"You have wrong Id or Password or Level","LoginError",JOptionPane.ERROR_MESSAGE);
				log.requestFocus();
				log.selectAll();
			}
			//con.close();
		}
		catch(Exception s)
		{
			System.out.println("Error...skmR..."+s);
		}
	
	}
		//change button color		
	class task5 extends Thread
  {
       
       public void run()
      
       {
       		
       	int ind=0;
         for(int i=1;i>0;i++)
           {     
           int n=0;
       		Double tmp=Math.random()*10;
            n=tmp.intValue();
            
           Color colour[]={new Color(255, 175, 175),new Color(64, 64, 64),new Color(0, 0, 0),new Color(255, 0, 0),new Color(255, 175, 175),new Color(255, 255, 0),new Color(0, 255, 0),new Color(0, 0, 255),new Color(255, 200, 0),new Color(0, 255, 255)}; 
           String label[]={"You Are Welcome..............","Please Login......................","Created By - ZED SOFTWARE PVT. LTD.","For Details Please Contact At 0542-3196660"}  ;
                 try
                 {
                   Thread.sleep(2000);
                   btn1.setForeground(colour[n]);
                   if(ind==label.length)
                   		ind=0;
                   	notes.setForeground(colour[n]);
               		notes.setText(label[ind]);
               		
                    ind++;
                   
                 }
                catch(Exception Ex)
                 {
                     System.out.println("error found...."+Ex);
                 }
           }
       }
       
  }
}