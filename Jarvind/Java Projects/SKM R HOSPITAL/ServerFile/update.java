import java.awt.*;
import java.awt.event.*;
import java.rmi.*;
import java.rmi.registry.*;
import javax.swing.*;
import javax.swing.event.*;

class update extends JFrame implements ActionListener
{
	
	Container cn;
	JButton updateBT;
	public static void main(String args[])
	{
		update frm=new update();
		frm.setSize(300,300);
		frm.setVisible(true);
	}
	
	
	public update()
	{
		cn=getContentPane();
		cn.setLayout(null);
		
		updateBT=new JButton("Update");
		updateBT.setBounds(20,50,100,30);
		cn.add(updateBT);
		
		updateBT.addActionListener(this);
		
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==updateBT)
		{
			updateRec();
		}
	}
private boolean updateRec()
{
//	ZedInterface inf=null;
		try
		{
	
		

/*try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}*/


java.sql.Connection connection=null;
	//	try
	//	{
//			System.out.println(""+query);
			connection=makeConnection();
            java.sql.Statement st=connection.createStatement();
          //  st.executeUpdate(query);
          //  closeConnection(connection);
          //  return true;
	//	}



		java.util.Date dt=new java.util.Date();
		
		int getD=dt.getDate();
		int getM=dt.getMonth()+1;
		int getY=dt.getYear()+1900;
		
		String setdate=getD+"/"+getM+"/"+getY;
		System.out.println("setdate..."+setdate);
		
			String qry="update history_Patient set status="+false+" where history_date<>#"+setdate+"#";
			System.out.println("qry..."+qry);
			st.executeUpdate(qry);
//			System.out.println(bn);
		//	if(bn)
		//	{
				javax.swing.JOptionPane.showMessageDialog(null,"File Upadted Successfully....");
		//	}
			
			
			return true;
		
		
		}
		catch(Exception e)
		{
			System.out.println("Error... in update class");
			javax.swing.JOptionPane.showMessageDialog(null,"File Not Upadted There are some errors found in consequences... ....");
			return false;
		}	
}


	public java.sql.Connection makeConnection()
	{
		java.sql.Connection DBCon=null;
		try
        {
        	String path = new java.io.File(".").getCanonicalPath();
        	System.out.println("path....."+path);
        //	path="D:\\SKM_R\\ServerFile";
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path+"\\mydatabase\\hospitalMNG.mdb";
        	DBCon = java.sql.DriverManager.getConnection(myDB,"zedabc123","zedabc123");
        	return DBCon;
        }
        catch(Exception ex)
        {
            System.out.println("Error at makeConnection method...."+ex);
           return DBCon;
        }
	}			
}