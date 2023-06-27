import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.rmi.*;
import java.rmi.registry.*;
class LoginDoctorForPatient implements ActionListener,KeyListener
{
      Color cl ;
      JInternalFrame frm;
      JTextField tf1;
      JPasswordField tf2;
      JButton btn1,btn2,btn3;
      JDesktopPane d;
      ZedInterface inf=null;
    public LoginDoctorForPatient(JDesktopPane ddd)
     {
          frm=new JInternalFrame("Login To See Patient",false,true,false,true);
          Container con=frm.getContentPane();
          cl = new Color(60,220,220);
          frm.setBackground(cl);
          ImageIcon i1=new ImageIcon("icons\\login.gif");
          btn1=new JButton("Login",i1);
		  d=ddd;
		  cl = new Color(175,227,207);
		  
          //btn1.setBackground(cl);
          btn1.setMnemonic('s');
          ImageIcon i2=new ImageIcon("icons\\reset.gif");
          btn2=new JButton("Clear",i2);
		  
		  cl = new Color(175,227,207);
		  
         // btn2.setBackground(cl);
          btn2.setMnemonic('c');
          ImageIcon i3=new ImageIcon("icons\\exit.gif");
          btn3=new JButton("Close",i3);
		  
		  cl = new Color(175,227,207);
          
          //btn3.setBackground(cl);
          btn3.setMnemonic('l');
          JLabel lb1=new JLabel("Enter Doctor Code");
          JLabel lb2=new JLabel("Enter Password");
          tf1=new JTextField();
		  
		  cl = new Color(175,227,207);
          
          //tf1.setBackground(cl);
          tf2=new JPasswordField();
          tf2.setEchoChar('*');
		  
		  cl = new Color(175,227,207);
          
          //tf2.setBackground(cl);
          con.setLayout(null);
          lb1.setBounds(10,20,150,25);
          tf1.setBounds(180,20,200,25);
          lb2.setBounds(10,60,150,25);
          tf2.setBounds(180,60,200,25);
          btn1.setBounds(10,125,120,30);
          btn2.setBounds(140,125,120,30);
          btn3.setBounds(270,125,120,30);
          con.add(btn1);
          con.add(btn2);
          con.add(btn3);
          con.add(lb1);
          con.add(lb2);
          con.add(tf1);
          con.add(tf2);
          tf1.setToolTipText("Please Enter Doctor Name");
          tf2.setToolTipText("Please Enter Password");
		  btn1.setToolTipText("Login");
	      btn2.setToolTipText("Clear");
		  btn3.setToolTipText("Close"); 
          frm.reshape(6,35,410,200);
          ddd.add(frm);
          frm.setVisible(true);
          btn3.addActionListener(this);  
          btn2.addActionListener(this);  
          btn1.addActionListener(this);  
          tf1.addKeyListener(this);
          tf2.addKeyListener(this); 
          btn1.addKeyListener(this);
          btn2.addKeyListener(this); 
          btn3.addKeyListener(this); 
     }
    public void actionPerformed(ActionEvent ae)
       {
         if(ae.getSource()==btn2)
          {
             try
                {
                    tf1.setText("");
                    tf2.setText("");
                    tf1.requestFocus();
                }
             catch(Exception x)
                {
                    System.out.println(""+x);
                }
          }
         else if(ae.getSource()==btn3)
          {
                  frm.dispose();
          }  
         else if(ae.getSource()==btn1)
          {
             if(login())
             	{
             		new ListOfPatientForSeeDoctor(d,Integer.parseInt(tf1.getText()));
             		frm.dispose();
             	//	frm.dispose();
             	}
          }
        }
     public void keyPressed(KeyEvent ke)
        {

           if(ke.getSource()==tf1 && ke.getKeyCode()==10)	
             {
               tf2.requestFocus();  
             }
           else if(ke.getSource()==tf2 && ke.getKeyCode()==10)	
             {
               btn1.requestFocus(); 
            
             }
           else if(ke.getSource()==btn1 && ke.getKeyCode()==10)	
             {
             	if(login())
             	{
             		new ListOfPatientForSeeDoctor(d,Integer.parseInt(tf1.getText()));
             		frm.dispose();
             	}
             }
           else if(ke.getSource()==btn2 && ke.getKeyCode()==10)	
             {
               tf1.setText("");
               tf2.setText("");
               tf1.requestFocus(); 
             }
           else if(ke.getSource()==btn3 && ke.getKeyCode()==10)	
             {
               frm.dispose(); 
             }
       }
     public void keyTyped(KeyEvent ke)	
       {
       }
     public void keyReleased(KeyEvent ke)
       {
       }
       
       public boolean login()
       {
       	try
       {
       			if(tf1.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter Doctor Code");  
                    tf1.requestFocus();
                    return false;
				}
				else if(tf2.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter Doctor Password");  
                    tf2.requestFocus();
                    return false;
				}
       	/*ZedInterface obj=null;
       	try
       {
       		obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
       }
		catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       }*/
       try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
									getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}	
       
       
       
       
       
       
       	String str[][]=inf.getResultSetAs_2D_Array("select drCode,drPws from drDetail order by drCode asc",2);
     	int fir=0;
     	boolean flag=true;
     	//System.out.println("len="+str.length);
     	if(str.length>0)
     	{
     	
       		for(int i=0;i<str.length;i++)
       		{
  			 	if(str[i][0].equals(tf1.getText()))
  			 	{
  			 		if(str[i][1].equals(tf2.getText()))
  			 		{
  			 			flag=false;
  			 			return true;
  			 		
  			 		}
  			 	}    		
      		 }
       }
       if(flag)
       {
       		JOptionPane.showMessageDialog(frm,"Doctor Code Or Password Is Wrong\nPlease Input Correct Doctor Code/Password","Error !!",JOptionPane.ERROR_MESSAGE);
       		tf1.requestFocus();
       		tf1.selectAll();
       		return false;
       }
       }
       catch(Exception ex)
       {
       	 System.out.println("Error.1..."+ex);
       	 return false;
       }
       return true;
    }           
}