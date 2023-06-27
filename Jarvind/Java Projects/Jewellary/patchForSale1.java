import javax.swing.*;
import java.sql.*;
import java.math.*;

class patchForSale1 extends JFrame
{
	public static void main(String args[])
	{
		
		patchForSale1 pt=new patchForSale1();
		pt.setSize(200,300);
		pt.setVisible(true);
		//pt.updatedata("XYZ");
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
           	Statement st=cn.createStatement();
           	ResultSet rs=st.executeQuery("select all distinct p_name from sale");
			int c=0,i=0;
			while(rs.next())
			{
				c++;
			}
		//		System.out.println("total no. of party="+c);
			String partyList[]=new String[c];
			rs=st.executeQuery("select all distinct p_name from sale");
			while(rs.next())
			{
				partyList[i]=rs.getString(1);
				i++;
			}
			
			for(i=0;i<partyList.length;i++)
			{
				System.out.println("calling party="+partyList[i]);
				pt.updatedata(partyList[i]);
			}
			JOptionPane.showMessageDialog(null,"Scanning completed.");
			System.exit(0);
					
   		}
		catch(Exception ex)
		{
			System.out.println("Error...91..."+ex);
		}
		
	}
	
	public void updatedata(String pnm)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
           	Statement st=cn.createStatement();
   		    Statement st1=cn.createStatement();
   		    ResultSet rs;
   		    int totalrecords=0,i=0;
			//String pnm="BOSS";
			rs=st.executeQuery("select all distinct s_s_no from sale where p_name='"+pnm+"'");
			while(rs.next())
			{
				totalrecords++;
			}
			System.out.println("totalrecords="+totalrecords);
			int psno[]=new int[totalrecords];
			rs=st.executeQuery("select all distinct s_s_no from sale where p_name='"+pnm+"' order by s_s_no");
			while(rs.next())
			{
				psno[i]=rs.getInt("s_s_no");
				i++;
			}
		
			double f2,f3=0,f5,f8;				
			BigDecimal w3=new BigDecimal("0");
			BigDecimal w5=new BigDecimal("0");
			for(i=0;i<psno.length;i++)
			{
				rs=st.executeQuery("select * from sale_x where s_s_no="+psno[i]);
				if(rs.next())
				{
					if(i==0)
					{
						f3=rs.getDouble("field5");									
					}
					else
					{					
						f2=rs.getDouble("field2");
						f8=rs.getDouble("field8");
						f5=(f3+f2)-f8;
						if(rs.getBoolean("btn1")==true || rs.getBoolean("btn3"))
						{
							f5=f5-rs.getDouble("field10");
						}
						w3=new BigDecimal(f3);
						w5=new BigDecimal(f5);
						w3=w3.setScale(3,5);
						w5=w5.setScale(3,5);
						//System.out.println("update sale_x set field3="+w3+",field5="+w5+" where s_s_no="+psno[i]);
						st1.executeUpdate("update sale_x set field3="+w3+",field5="+w5+" where s_s_no="+psno[i]);
						f3=f5;
					}					
					//System.out.println("i="+i+"psno="+psno[i]+";f3="+w3);
				}
			}
			if(psno.length>1)
			{
				st1.executeUpdate("update partyDetails set currentWt='"+w5+"' where 	partyName='"+pnm+"' and p_type='s'");
			}
			
			System.out.println("Process Completed.");
			cn.close();
						
		}
		catch(Exception ex)
		{
			System.out.println("Error...89..."+ex);
		}
	}
}