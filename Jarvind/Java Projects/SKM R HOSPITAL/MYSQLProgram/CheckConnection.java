/*
 *this program work on existing database
 */
import java.sql.*;
class CheckConnection
{
	public static void main(String args[])
	{
		try
		{
			System.out.println("1.....");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("2.....");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/sqldb?user=skm&password=rrr");
			System.out.println("3.....");
			Statement st=con.createStatement();
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
		}
	}
}