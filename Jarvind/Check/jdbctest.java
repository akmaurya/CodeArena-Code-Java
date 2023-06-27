import java.sql.*;


class jdbctest
{
	public static void main(String arg[])
	{
		try
		{
			System.out.println("Till this ok-1");
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Till this ok-2");
			Connection conn=DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)}; DBQ=I:/Jarvind/Advaned/Calender/build/classes/calender/EventDatabase.accdb");
			System.out.println("Till this ok-3");
			Statement st=conn.createStatement();
			System.out.println("Till this ok-4");
			st.executeUpdate("insert into Event values(34,45,23,'ads','adsf')");
			System.out.println("Till this ok-5");
			conn.close();
		}
		catch(Exception ex)
		{
			System.out.println("Error1---\n"+ex);
		}
		
	}
}