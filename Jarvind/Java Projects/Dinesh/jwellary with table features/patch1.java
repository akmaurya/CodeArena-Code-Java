import javax.swing.*;
import java.sql.*;
import java.math.*;

class patch1 extends JFrame
{
	public static void main(String args[])
	{
		/*
		patch1 pt=new patch1();
		pt.setSize(200,300);
		pt.setVisible(true);
		pt.updatedata();
		*/
	}
	
	/*public void updatedata(String pnm)
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
			rs=st.executeQuery("select all distinct p_s_no from purchase where p_name='"+pnm+"'");
			while(rs.next())
			{
				totalrecords++;
			}
			System.out.println("totalrecords="+totalrecords);
			int psno[]=new int[totalrecords];
			rs=st.executeQuery("select all distinct p_s_no from purchase where p_name='"+pnm+"' order by p_s_no");
			while(rs.next())
			{
				psno[i]=rs.getInt("p_s_no");
				i++;
			}
		
			double f2,f3=0,f5,f8;				
			BigDecimal w3=new BigDecimal("0");
			BigDecimal w5=new BigDecimal("0");
			for(i=0;i<psno.length;i++)
			{
				rs=st.executeQuery("select * from purchase_x where p_s_no="+psno[i]);
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
						System.out.println("update purchase_x set field3="+w3+",field5="+w5+" where p_s_no="+psno[i]);
						st1.executeUpdate("update purchase_x set field3="+w3+",field5="+w5+" where p_s_no="+psno[i]);
						f3=f5;
					}					
					System.out.println("i="+i+"psno="+psno[i]+";f3="+w3);
				}
			}
			//st1.executeUpdate("update purchase_x set field3="+w3+",field5="+w5+" where p_s_no="+psno[i]);
			if(psno.length>1)
			{
				st1.executeUpdate("update partyDetails set currentWt='"+w5+"' where 	partyName='"+pnm+"' and p_type='p'");
			}

						
			System.out.println("Process Completed.");
			cn.close();
						
		}
		catch(Exception ex)
		{
			System.out.println("Error...89..."+ex);
		}
	}*/
	
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
			rs=st.executeQuery("select all distinct p_s_no from purchase where p_name='"+pnm+"'");
			while(rs.next())
			{
				totalrecords++;
			}
			System.out.println("totalrecords="+totalrecords);
			int psno[]=new int[totalrecords];
			rs=st.executeQuery("select all distinct p_s_no from purchase where p_name='"+pnm+"' order by p_s_no");
			while(rs.next())
			{
				psno[i]=rs.getInt("p_s_no");
				i++;
			}
		
			boolean b3Response;
			double f2,f3=0,f5,f8;
			double f4=0,f6=0,jama=0;				
			BigDecimal w3=new BigDecimal("0");
			BigDecimal w5=new BigDecimal("0");
			//BigDecimal updatef4=new BigDecimal("0");
			for(i=0;i<psno.length;i++)
			{
				jama=0;
				rs=st.executeQuery("select * from purchase_x where p_s_no="+psno[i]);
				if(rs.next())
				{
					if(i==0)
					{
						f3=rs.getDouble("field5");	
						jama=rs.getDouble("jama");								
						f6=rs.getDouble("field6");//+jama;	
						f4=f6;								
					}
					else
					{	
						jama=rs.getDouble("jama");
						f6=f4+jama;
									
						f2=rs.getDouble("field2");
						f8=rs.getDouble("field8");
						f5=(f3+f2)-f8;
						b3Response=rs.getBoolean("btn3");
						if(rs.getBoolean("btn1")==true || b3Response==true)
						{
							f5=f5-rs.getDouble("field10");
						}
						if(b3Response==true)
						{
							f6=f6-rs.getDouble("field11");
						}
						w3=new BigDecimal(f3);
						w5=new BigDecimal(f5);
						w3=w3.setScale(3,5);
						w5=w5.setScale(3,5);
						//System.out.println("jama="+jama);
						//System.out.println("update purchase_x set field3="+w3+",field5="+w5+",field4="+f4+",field6="+f6+" where p_s_no="+psno[i]);
						st1.executeUpdate("update purchase_x set field3="+w3+",field5="+w5+",field4="+f4+",field6="+f6+" where p_s_no="+psno[i]);
						f3=f5;
						f4=f6;
						
					}		
					//updatef4=new BigDecimal(f4);			
					//System.out.println("i="+i+"psno="+psno[i]+";f3="+w3);
				}
			}
			if(psno.length>1)
			{
				//st1.executeUpdate("update purchase_x set field3="+w3+",field5="+w5+" where p_s_no="+psno[i]);
				st1.executeUpdate("update partyDetails set currentWt='"+w5+"',currentAmt='"+f6+"' where partyName='"+pnm+"' and p_type='p'");
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