import java.sql.*;
import java.io.*;
class MakeDBAndUseIt
{
	public static void main(String args[])
	{
		Connection con=null;
		Statement st=null;
		try
		{
			System.out.println("1.....");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("2.....");
			con=DriverManager.getConnection("jdbc:mysql://localhost/sqldb1?user=skm&password=rrr");
			System.out.println("3.....");
			st=con.createStatement();
			System.out.println("4.....");
			st.executeUpdate("insert into table1 values(1,'sunil')");
			System.out.println("Data inserted...");
			System.out.println("Accessing data------>");
			ResultSet rs=st.executeQuery("select * from table1");
			while(rs.next())
			{
				System.out.print(""+rs.getInt(1));
				System.out.println("\t"+rs.getString(2));
			}
		}
		catch(Exception e)
		{
			System.out.println("Error...."+e);
			File fl=new File("c:\\mysql\\data\\sqldb1");
			boolean b=fl.mkdirs();
			System.out.println(""+b);
			if(st!=null)
			{
				try
				{
					st.executeUpdate("create table table1(rollno int,stuname varchar(20))");
				}
				catch(Exception ex)
				{
					System.out.println("Error in error..."+ex);
				}
			}
		}
	}
}