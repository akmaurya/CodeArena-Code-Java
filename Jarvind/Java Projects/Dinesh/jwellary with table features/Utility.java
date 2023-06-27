import java.awt.*;
import java.sql.*;
import java.io.*;

public class Utility {

	//public static String userId;
        
    public static String path="e:\\AgencyManagement\\AMS";
	
    public static Connection makeConnection ()
	{
                
				Connection databaseConnection=null;			
				try
				{
                        
                        path = new java.io.File(".").getCanonicalPath();
 			 			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
 			 			System.out.println(""+path+"\\mydatabase\\database.mdb");
                        String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path+"\\mydatabase\\database.mdb";
                        databaseConnection = DriverManager.getConnection(myDB,"zed","zed");
                }
                catch (ClassNotFoundException ex) //Thrown if driver is not reconised
                {	       
                    System.out.println("\nError loading database access driver.\nPossible reason is that you do not have MS Access");	        
                }
                catch (SQLException ex) //Thrown if database can not be found
                {	        
                    System.out.println("\nError connecting to database\n" +ex);	        
                }
                catch (FileNotFoundException ex) //Thrown if database can not be found
                {	        
                    System.out.println("\n3. Error file not found of path setting:-"+path+"\n" +ex);	        
                }
                catch (IOException ex) //Thrown if database can not be found
                {	        
                    System.out.println("\n4. Error file not found\n" +ex);	        
                }
        
        
                return databaseConnection;        
    }
    
	public static String getSingleData(String qry)
	{
        String data="";
        try
        {
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery(qry);
            if(rs.next())
            {
                data=rs.getString(1);
            }
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...233..."+ex);
        }
        return data;
	
	}
}	