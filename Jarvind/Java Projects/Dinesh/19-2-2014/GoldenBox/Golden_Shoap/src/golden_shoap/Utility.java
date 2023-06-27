/*
 * Utility.java
 *
 * Created on August 7, 2010, 8:31 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package golden_shoap;

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.*;



public class Utility {
    
    /** Creates a new instance of Utility */
    public static String userId;
    public Utility() {
    }
        
        public static String path="D:\\GoldenBox\\Golden_Shoap\\Database";
	
        public static Connection makeConnection ()
	{
      		Connection databaseConnection=null;			
		try
		{
                
                        path = new java.io.File(".").getCanonicalPath();
  			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path+"\\Database\\MyDatabase.mdb";
                        databaseConnection = DriverManager.getConnection(myDB);
                        //System.out.println("databaseConnection..........................."+databaseConnection);
                        
                        /*    
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        String myDB = "jdbc:odbc:agency";
                        databaseConnection = DriverManager.getConnection(myDB,"zedabc123","zedabc123");
                        */
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
        
        public static Connection makeConnectionForAnotherCenter(String path1,String centercode)
	{
                
		Connection databaseConnection1=null;			
		try
		{
                        
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        String myDB1 = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path1+"\\"+centercode+".mdb";
                        System.out.println(myDB1);
                        databaseConnection1 = java.sql.DriverManager.getConnection(myDB1,"zedabc123","zedabc123");
                      //  System.out.println("databaseConnection1.................."+databaseConnection1);
                        
                }
                catch (ClassNotFoundException ex) //Thrown if driver is not reconised
                {	       
                    System.out.println("\nError loading database access driver.\nPossible reason is that you do not have MS Access");	        
                }
                catch (SQLException ex) //Thrown if database can not be found
                {	        
                    System.out.println("\nError connecting to database\n" +ex);	        
                }
                
        
        
                return databaseConnection1;
        
        }
        
    public static String[] getResultSetAs_1D_Array(String query)
	{
		String sendList[]=null;
		java.sql.Connection connection=null;
        try
        {
            System.out.println(""+query);
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery(query);
            int col=0;
            while(rs.next())
            	col++;
        	sendList=new String[col];
            int index=0;
            //rs.beforeFirst();
            rs=st.executeQuery(query);
            while(rs.next())
            {
                sendList[index]=rs.getString(1);
                index++;
            }
           conn.close();
           return sendList;
        }
        catch(Exception ex)
        {
            System.out.println("Error at getResultSetAs_1D_Array method..At Server..."+ex);
            return sendList;
        }
	}
        
    public static boolean isBlank(String text)
    {
        if(text==null || text.trim().equals(""))
        {
            return true;
        }
        return false;
    }
    public static boolean isInteger(String text)
    {
        try
        {
            int n=Integer.parseInt(text); 
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    public static boolean isDouble(String text)
    {
        try
        {
            double n=Double.valueOf(text); 
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    public static boolean isExist(String query)
    {
        try
        {
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                conn.close();
                return true;
            }
            else
            {
                conn.close();
                return false;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error...233..."+ex);
        }
        return false;
    }
    
    public static String getSuperGroupName(String gpName)
    {
        try
        {
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs=st.executeQuery("select superGpNm from groupList where gpNm='"+gpName+"'");
            if(rs.next())
            {
                String sgpnm=rs.getString("superGpNm");
                conn.close();
                return sgpnm;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error...2343..."+ex);
        }
        return null;
    }
    public static String getSingleValue(String qry)
    {
        System.out.println(qry);
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
            System.out.println("Error...2345..."+ex);
        }
        return data;
    }
    public static int getItemCode(String itemName)
    {
        int code=0;
        try
        {
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery("select * from ITEMMASTER where itemName='"+itemName+"'");
            if(rs.next())
            {
                code=rs.getInt("itemCode");
            }
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...233..."+ex);
        }
        return code;
    }
    public static String getCategoryName(int catCode)
    {
        String name="";
        try
        {
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery("select * from ITEMCATEGORYMASTER where catCode="+catCode);
            if(rs.next())
            {
                name=rs.getString("itemcatname");
            }
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...233..."+ex);
        }
        return name;
    }
    public static String getItemName(int itemcode)
    {
        String name="";
        try
        {
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery("select * from ITEMMASTER where itemcode="+itemcode);
            if(rs.next())
            {
                name=rs.getString("itemName");
            }
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...233..."+ex);
        }
        return name;
    }
    public static String getItemUnit(String itemname)
    {
        String unit="";
        try
        {
            //System.out.println("a");
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery("select * from ITEMMASTER where itemName='"+itemname+"'");
            //System.out.println("select * from ITEMMASTER where itemName='"+itemname+"'");
            if(rs.next())
            {
                unit=rs.getString("itemUnit");
            }
            //System.out.println("ok");
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...254..."+ex);
        }
        return unit;
    }
    public static String getMotherboardSN() {
  String result = "";
    try {
      File file = File.createTempFile("realhowto",".vbs");
      file.deleteOnExit();
      FileWriter fw = new java.io.FileWriter(file);

      String vbs =
         "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
        + "Set colItems = objWMIService.ExecQuery _ \n"
        + "   (\"Select * from Win32_BaseBoard\") \n"
        + "For Each objItem in colItems \n"
        + "    Wscript.Echo objItem.SerialNumber \n"
        + "    exit for  ' do the first cpu only! \n"
        + "Next \n";

      fw.write(vbs);
      fw.close();
      Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
      BufferedReader input =
        new BufferedReader
          (new InputStreamReader(p.getInputStream()));
      String line;
      while ((line = input.readLine()) != null) {
         result += line;
      }
      input.close();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    return result.trim();
  }

    public static boolean saveInformation(String query)
    {
        try
        {
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            st.executeUpdate(query);
            conn.close();
            return true;
        }
        catch(Exception ex)
        {
            System.out.println("Error...233.skm R.."+ex);
        }
        return false;
    }
    
    public static int getNextCode(String query)
    {
        try
        {
            int code=1;
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery(query);
            if(rs.next())
            {
                code=rs.getInt(1)+1;
            }
            conn.close();
            return code;
        }
        catch(Exception ex)
        {
            System.out.println("Error...233..."+ex);
        }
        return 0;
    }
    
    public static String[][] getInformationDD(String query,int c)
    {
        String arr[][]=null;
        try
        {
            java.sql.Connection conn=Utility.makeConnection();
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery(query);
            //System.out.println(query);
            
            int r=0;
            while(rs.next())    r++;
            rs=st.executeQuery(query);
            int row=0;
            arr=new String[r][c];
            //System.out.println(r+";"+c);
            while(rs.next())
            {
                for(int col=0;col<c;col++)
                {
               //System.out.println(">>"+row+";"+col);
                    arr[row][col]=rs.getString(col+1);
                }
                row++;
            }
            conn.close();
            return arr;
        }
        catch(Exception ex)
        {
            System.out.println("Error...233..."+ex);
        }
        return arr;
    }
    public static int manageUnitDecimal(String tableName,String unitColumnName,String scaleColumnName,String unitName)
    {
        String qry="Select "+scaleColumnName+" from "+tableName+" where "+unitColumnName+"='"+unitName+"'";
        int scale=(Integer.parseInt(Utility.getSingleValue(qry)));
        return scale;
    }
}
// Demo


