/*
 *This class is treated as Server 
 *in RMI based application 
 *You can use it another places where needed
 *
 *Creation Date 31/03/2011 3:25:01 PM
 *
 *Created By SKM
 *at ZED Lab
 */
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class ZedServer extends UnicastRemoteObject implements ZedInterface,ZedInterfaceForMedical
{	
	//********************************************************************************************************
	public ZedServer() throws RemoteException{}
	{
		System.out.println("Server Status : START ");
	}
	//********************************************************************************************************
	/*
	 *This method provides DIRECT CONNECTIVITY WITH MS EXCESS DATABASE
	 *e.g. Database Name=hospitalMNG.mdb in mydatabase folder of current path
	 *is connected as database.
	 *This method return <Connection> type object
	 */
	public java.sql.Connection makeConnection()
	{
		java.sql.Connection DBCon=null;
		try
        {
        	String path = new java.io.File(".").getCanonicalPath();
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
	//********************************************************************************************************
	/*
	 *If you are connected with database 
	 *This method close related connection and return <boolean>true
	 *otherwise <boolean>false
	 */
	public boolean closeConnection(java.sql.Connection connection)
	{
		try
        {
			connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error at closeConnection method....."+ex);
        }
		return true;
	}
	//********************************************************************************************************
	/*
	 *This method is used to find (maxvalue) of database and 
	 *return it ,if no value found then return <int>0
	 *if error occured then return <-1>
	 *e.g. String query="select max(<int><field1>) from <table>";
	 *int value=getMaxValue(query);
	 */
public int getMaxValue(String query)
	{
		int maxValue=0;
		java.sql.Connection connection=null;
        try
        {
        	System.out.println(""+query);
            connection=makeConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                maxValue=rs.getInt(1);
            }
            else
            	maxValue=0;
            System.out.println("maxValue="+maxValue);
            closeConnection(connection);
            return maxValue;
        }
        catch(Exception ex)
        {
            System.out.println("Error at getMaxValue method......"+ex);
            closeConnection(connection);
            return -1;
        } 
	}
	//********************************************************************************************************
	/*
	 *This method is used to  <count> value of related <field> of <table> into database and 
	 *return it ,if no value found then return <int>0
	 *if error occured then return <-1>
	 *e.g. String query="select count(<field1>) from <table>";
	 *int value=getCountValue(query);
	 */
	public int getCountValue(String query)
	{
		int countValue=0;
		java.sql.Connection connection=null;
        try
        {
        	System.out.println(""+query);
            connection=makeConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=st.executeQuery(query);
            rs.last();
            countValue=rs.getRow();
            System.out.println("Count="+countValue);
            closeConnection(connection);
            return countValue;
        }
        catch(Exception ex)
        {
            System.out.println("Error at getCountValue method......"+ex);
            closeConnection(connection);
            return -1;
        } 
	}
	//********************************************************************************************************
	/*
	 *This method is used where 
	 *we call executeUpdate(String) of <Statement> class
	 *such as-
	 *String query="insert into table1 values(1,'skm')";
	 *or query="delete * from table1";
	 *or query="update table1 set field1=1,field2='skm'";
	 *then  following method is suitable
	 *call it as= Statement <object>.executeUpdateQuery(query);
	 */
	
	public boolean executeUpdateQuery(String query)
	{
		java.sql.Connection connection=null;
		try
		{
			System.out.println(""+query);
			connection=makeConnection();
            java.sql.Statement st=connection.createStatement();
            st.executeUpdate(query);
            closeConnection(connection);
            return true;
		}
		catch(Exception ex)
        {
            System.out.println("Error  at executeUpdateQuery method....."+ex);
            closeConnection(connection);
            return false;
        }
	}
	//********************************************************************************************************
	/*
	 *This method is used to  get value of related <field> of <table> into database and 
	 *return it ,if no value found then return null
	 *if error occured then return null
	 *e.g. String query="select <field1> from <table>";
	 *String value=getSingleValue(query);
	 */
	public String getSingleValue(String query)
	{
		String sendString=null;
		java.sql.Connection connection=null;
        try
        {
        	System.out.println(""+query);
            connection=makeConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs=st.executeQuery(query);
            if(rs.next())
            	sendString=rs.getString(1);
            closeConnection(connection);
            return sendString;
       }
       catch(Exception ex)
       {
           System.out.println("Error at getSingleValue method......"+ex);
           closeConnection(connection);
           return sendString;
       }
	}
	//********************************************************************************************************
	/*
	 *This method is used to  get value of related <field> of <table> into database and 
	 *return it as String[] ,if no value found then return null
	 *if error occured then return null
	 *e.g. String query="select <field1> from <table>";
	 *String value[]=getResultSetAs_1D_Array(query);
	 */
	public String[] getResultSetAs_1D_Array(String query)
	{
		String sendList[]=null;
		java.sql.Connection connection=null;
        try
        {
        	System.out.println(""+query);
        	connection=makeConnection();
            java.sql.Statement st=connection.createStatement();//java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY
            java.sql.ResultSet rs=st.executeQuery(query);
            int col=0;
            while(rs.next())
            	col++;
            /*rs.last();
            int col=rs.getRow();
            System.out.println("col="+col);
        	*/
        	sendList=new String[col];
            int index=0;
            //rs.beforeFirst();
            rs=st.executeQuery(query);
            while(rs.next())
            {
                sendList[index]=rs.getString(1);
                index++;
            }
            closeConnection(connection);
            return sendList;
        }
        catch(Exception ex)
        {
            System.out.println("Error at getResultSetAs_1D_Array method..At Server..."+ex);
            closeConnection(connection);
            return sendList;
        }
	}
	//********************************************************************************************************
	/*
	 *This method is used to  get value of related <field> of <table> into database and 
	 *return it as String[] ,if no value found then return null
	 *if error occured then return null
	 *e.g. String query="select <field1>,<field2> from <table>";
	 *String value[]=getResultSetAs_2D_Array(query,2);
	 */
	public String[][] getResultSetAs_2D_Array(String query,int noOfColumn)
	{
		String sendList[][]=null;
		java.sql.Connection connection=null;
        try
        {
        	System.out.println(""+query);
        	connection=makeConnection();
            java.sql.Statement st=connection.createStatement();//java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY
            java.sql.ResultSet rs=st.executeQuery(query);
            //rs.last();
            //int howManyRow=rs.getRow();
            int howManyRow=0;
            int row=0;
            //rs.beforeFirst();
            while(rs.next())
            {
            	howManyRow++;
            }
            sendList=new String[howManyRow][noOfColumn];
            rs=st.executeQuery(query);
            while(rs.next())
            {
            	for(int col=0;col<noOfColumn;col++)
                	sendList[row][col]=rs.getString((col+1));
                row++;
            }
            closeConnection(connection);
            return sendList;
        }
        catch(Exception ex)
        {
            System.out.println("Error at getResultSetAs_2D_Array method....."+ex);
            return sendList;
        }
	}
	/*
	 *This method is used to copy 
	 *hospitalMNG.mdb file
	 *and store it at 
	 *d:\Database_Backup\ZED location..
	 */
	
	public String getBackupOfDatabase()
    {
    	String msg=null;
    	try
    	{
    		java.util.Date dt=new java.util.Date();
    		String toDayIs=(dt.getDate()+"-"+(dt.getMonth()+1)+"-"+(dt.getYear()+1900)+"_"+dt.getHours()+"_"+dt.getMinutes()+"_"+dt.getSeconds());
        	//String timeIs=("_"+dt.getHours()+":"+dt.getMinutes()+":"+dt.getSeconds());
            java.io.File fl1=new java.io.File("");
            String path1=fl1.getAbsolutePath();
            //String dirName=path1+"\\internal_Backup";
            String dirName="D:\\Database_Backup";
            String folderName="ZED";//level+"\\"+name;
            java.io.File makedir=new java.io.File(dirName+"\\"+folderName+"\\"+toDayIs);
            makedir.mkdirs();
            String filename=dirName+"\\"+folderName+"\\"+toDayIs+"\\"+"hospitalMNG.mdb";
            System.out.println("FileCreationPath="+filename);
    		java.io.File fl=new java.io.File("");
            String currentpath = fl.getAbsolutePath();
            
            System.out.println("curPath="+currentpath+"\\mydatabase\\hospitalMNG.mdb");
            java.io.FileInputStream in = new java.io.FileInputStream(currentpath+"\\mydatabase\\hospitalMNG.mdb");
            java.io.FileOutputStream out = new java.io.FileOutputStream(filename);
            int c=0;
            int i=1;
            byte b[]=new byte[1000];
			while((c=in.read(b))!=-1)
			{
                   out.write(b);
            }
            in.close();
            out.close();
            msg="Backup process completed successfully.";
            System.out.println("6....");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in getBackupOfDatabase at meserver1 class.........."+e);
    		msg="Error found.";
    		return msg;
    	}
    	return msg;	 
    }
	
	
	//**********************************************  MEDICAL RELATED METHOD   ******************************************
	
	
	public String[] getCmpNames()
    {
        String nameList[]=null;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=st.executeQuery("select cmpName from cmpMaster order by cmpName");
            rs.last();
            int n=rs.getRow();
            nameList=new String[n+1];
            nameList[0]="-Select-";
            int r=1;
            rs.beforeFirst();
            while(rs.next())
            {
                nameList[r]=rs.getString("cmpName");
                r++;
            }
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...10..."+ex);
        }
        return nameList;
    }
    
    /*this method is used in following class
     *MakePurchase.java
     *EditMakePurchase.java
     */
    public String[] getPurPartyNames()
    {
        String nameList[]=null;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=st.executeQuery("select partyNm from purchasePartyMaster order by partyNm");
            rs.last();
            int n=rs.getRow();
            nameList=new String[n+1];
            nameList[0]="-Select-";
            int r=1;
            rs.beforeFirst();
            while(rs.next())
            {
                nameList[r]=rs.getString("partyNm").toUpperCase();
                r++;
            }
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error in getPurPartyNames method in utilityClass class..."+ex);
        }
        return nameList;
    }
    
    public String[] getItemNames(String cmpname)
    {
            String nameList[]=null;
            int cmpCode=0;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            String queryItem="select itemName from itemMaster order by itemName";
                      
            java.sql.ResultSet rs=st.executeQuery(queryItem);
            rs.last();
            int n=rs.getRow();
            nameList=new String[n+1];
            nameList[0]="-Select-";
            int r=1;
            rs.beforeFirst();
            while(rs.next())
            {
                nameList[r]=rs.getString("itemName");
                r++;
            }
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...11..."+ex);
        }
        return nameList;
    }
    public String getCompany(String str)
    {
        String company="";
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            String query="select cmpCode from itemMaster where itemName='"+str+"'";
            java.sql.ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                int cmpCode=rs.getInt(1);
                System.out.println("cmpnm="+company);
                company=getCmpName(cmpCode);
            }
            if(company==null || company.equals("null"))
            {
                company="";
            }    
        }
        catch(Exception e)
        {
            System.out.println("Error in get company method....."+e);
        }
        System.out.println("cmpnm="+company);
        return company;
    }
    public String[] getItemNamesOld(String cmpName)
    {
            String nameList[]=null;
            int cmpCode=0;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            String queryCmp="select cmpCode from cmpMaster where cmpName='"+cmpName+"'";
            String queryItem="select itemName from itemMaster order by itemName";
            if(cmpName.trim().equals("")==false)
            {                
                java.sql.ResultSet rs=st.executeQuery(queryCmp);
                if(rs.next())
                {
                    cmpCode=rs.getInt("cmpCode");
                    queryItem="select itemName from itemMaster where cmpCode="+cmpCode+" order by itemName";
                }
            }
            
            java.sql.ResultSet rs=st.executeQuery(queryItem);
            rs.last();
            int n=rs.getRow();
            nameList=new String[n+1];
            nameList[0]="-Select-";
            int r=1;
            rs.beforeFirst();
            while(rs.next())
            {
                nameList[r]=rs.getString("itemName");
                r++;
            }
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...11..."+ex);
        }
        return nameList;
    }
    public String[] getBatchNos(String cmpName,String itemName)
    {
            String nameList[]=null;
            int cmpCode=0,itemCode=0;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            String queryCmp="select cmpCode from cmpMaster where cmpName='"+cmpName+"'";
            String queryItem="select itemCode from itemMaster where itemName='"+itemName+"'";
            if(cmpName.equals("")==false)
            {
                java.sql.ResultSet rs=st.executeQuery(queryCmp);
                if(rs.next())
                {
                    cmpCode=rs.getInt("cmpCode");
                    queryItem="select itemCode from itemMaster where cmpCode="+cmpCode+" and itemName='"+itemName+"'";
                }
            }
            
            java.sql.ResultSet rs=st.executeQuery(queryItem);
            if(rs.next())
            {
                itemCode=rs.getInt("itemCode");
            }

            rs=st.executeQuery("select batchNo from stockHolding where itemCode="+itemCode+" and qty>0");
            if(rs.next())
            {
                rs.last();
                int n=rs.getRow();
            
                nameList=new String[n+1];
                nameList[0]="-Select-";
                int r=1;
                rs.beforeFirst();
                while(rs.next())
                {
                    nameList[r]=rs.getString("batchNo");
                    r++;
                }
            }
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...1198..."+ex);
        }
        return nameList;
    }
    
    public String getPacking(String itemName)
    {
        String packing="";
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            /*java.sql.ResultSet rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+cmpName+"'");
            int cmpCode=0;
            if(rs.next())
            {
                cmpCode=rs.getInt("cmpCode");
            }
            */
            java.sql.ResultSet rs=st.executeQuery("select pkging,pkgType from itemMaster where itemName='"+itemName+"'");
            if(rs.next())
            {
                packing=rs.getString("pkging")+" "+rs.getString("pkgType");
            }
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...12..."+ex);
        }
        return packing;
    }
    
    public String getQtyType(String itemName)
    {
        String qtyType="";
        String itemType="";
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            /*java.sql.ResultSet rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+cmpName+"'");
            int cmpCode=0;
            if(rs.next())
            {
                cmpCode=rs.getInt("cmpCode");
            }*/
            
            java.sql.ResultSet rs=st.executeQuery("select typeOfItem from itemMaster where itemName='"+itemName+"'");
            if(rs.next())
            {
                itemType=rs.getString("typeOfItem");
            }
            if(itemType.equals("Injection"))    qtyType="Injection";
            else if(itemType.equals("Drop"))    qtyType="Ph";
            else if(itemType.equals("Syrup"))    qtyType="Syrup";
            else if(itemType.equals("Tab"))    qtyType="St";
            else if(itemType.equals("Capsule"))    qtyType="St";
            else if(itemType.equals("Voil"))    qtyType="Voil";
            else if(itemType.equals("Pcs"))    qtyType="Pcs";
               
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...13..."+ex);
        }
        return qtyType;
    }
    public String getSmallestQtyType(String itemName)
    {
        String qtyType="";
        String itemType="";
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            /*java.sql.ResultSet rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+cmpName+"'");
            int cmpCode=0;
            if(rs.next())
            {
                cmpCode=rs.getInt("cmpCode");
            }
            */
            
            java.sql.ResultSet rs=st.executeQuery("select typeOfItem from itemMaster where itemName='"+itemName+"'");
            if(rs.next())
            {
                itemType=rs.getString("typeOfItem");
            }
            if(itemType.equals("Injection"))    qtyType="Injection";
            else if(itemType.equals("Drop"))    qtyType="Ph";
            else if(itemType.equals("Syrup"))    qtyType="Ph";
            else if(itemType.equals("Tab"))    qtyType="Tab";
            else if(itemType.equals("Capsule"))    qtyType="Capsule";
            else if(itemType.equals("Voil"))    qtyType="Voil";
            else if(itemType.equals("Pcs"))    qtyType="Pcs";
               
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...1345..."+ex);
        }
        return qtyType;
    }
    
    public String getVat(String itemName)
    {
        String vat="";
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=null;
            /*st.executeQuery("select cmpCode from cmpMaster where cmpName='"+cmpName+"'");
            int cmpCode=0;
            if(rs.next())
            {
                cmpCode=rs.getInt("cmpCode");
            }
            */
            rs=st.executeQuery("select vat from itemMaster where itemName='"+itemName+"'");
            if(rs.next())
            {
                vat=rs.getString("vat");
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...13..."+ex);
        }
        return vat;
    }
    
    public String getMrp(String itemName)
    {
        String mrp="";
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            /*java.sql.ResultSet rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+cmpName+"'");
            int cmpCode=0;
            if(rs.next())
            {
                cmpCode=rs.getInt("cmpCode");
            }
            */
                    
            java.sql.ResultSet rs=st.executeQuery("select mrp from itemMaster where itemName='"+itemName+"'");
            if(rs.next())
            {
                mrp=rs.getString("mrp");
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...13..."+ex);
        }
        return mrp;
    }
    public int getItemCode(String itemName)
    {
        int itemcode=0;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
                    
            java.sql.ResultSet rs=st.executeQuery("select itemCode from itemMaster where itemName='"+itemName+"'");
            if(rs.next())
            {
                itemcode=rs.getInt("itemCode");
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...13..."+ex);
        }
        return itemcode;
    }
    
    public int getNextPurchaseNo()
    {
        int pno=0;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            //java.sql.ResultSet rs=st.executeQuery("select pNo from purchaseSmry");
            java.sql.ResultSet rs=st.executeQuery("select max(pNo) from purchaseSmry");
            /*rs.last();
            pno=rs.getRow()+1;*/
            if(rs.next())
            {
               pno=rs.getInt(1);
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...13..."+ex);
        }
        pno+=1;
        return pno;
    }
    
    public int getSaleNo()
    {
        int sno=0;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=st.executeQuery("select max(sNo) from saleSmry");
            //rs.last();
            //sno=rs.getRow()+1;
            if(rs.next())
            {
                sno=rs.getInt(1);
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...13..."+ex);
        }
        sno+=1;
        return sno;
    }
    /*This method is used in following class
     *EditMakePurchase.java
     *EditMakingSale.java
     */
   /* public int getMaxValue(String query)
    {
        int sno=0;
        try
        {
            System.out.println("Query="+query);
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                sno=rs.getInt(1);
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error in takingMaxValue method into utilityClass class..."+ex);
        }
        sno+=1;
        return sno;
    }*/
    /*This method is used in following class
     *EditMakePurchase.java
     *EditMakingSale.java
     *DialogForChooseStatus.java
     */
    public void saveOrUpdateResultSet(String query)
    {
        try
        {
            System.out.println("Query="+query);
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.Statement st=connection.createStatement();
            st.executeUpdate(query);
        }
        catch(Exception e)
        {
            System.out.println("Error in saveOrUpdateResultSet method into utilityClass class..."+e);
        }
    }
    /*This method is used in following class
     *EditMakePurchase.java
     *EditMakingSale.java
     */
    public int countingValue(String query)
    {
        int count=0;
        try
        {
            System.out.println("Query="+query);
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs=st.executeQuery(query);
            while(rs.next())
            {
                    count++;
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in countingValue method into utilityClass class..."+e);
        }
        System.out.println("count="+count);
        return count;
    }
    
    /*This method is used in following class
     *MakePurchase.java
     *EditMakePurchase.java]
     */
    public String returnSingleData(String query)
    {
        String str="";
      try
      {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                str=rs.getString(1);
            }
            if(str==null || str.equalsIgnoreCase("null"))
            {
                str="";
            }
      }
      catch(Exception e)
      {
          System.out.println("Error in returnSingleData method of utilityClass class.... "+e);
      }
        return str;
    }
    
    /*This method is used in following class
     *EditMakePurchase.java
     *EditMakingSale.java
     *ShowIndividualSaleBill.java
     */
    public String[][]returnResultSet(String query,String label1,String label2)
    {
        String str[][]=null;
        try
        {
            //System.out.println("Query="+query);
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection = cd.getConnection();
            //System.out.println("1s............");
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            //System.out.println("1k............");
            java.sql.ResultSet rs=st.executeQuery(query);
            //System.out.println("1m............");
            if(label1.equalsIgnoreCase("EditMakePurchaseWindowSmry"))
            {
            	//System.out.println("01............");
                str=new String[1][12];
                //System.out.println("1............");
                
                while(rs.next())
                {
                    System.out.println("2............");
                    str[0][0]=rs.getString(1);
                    str[0][1]=rs.getString(2);
                    str[0][2]=rs.getString(3);
                    str[0][3]=rs.getString(4);
                    str[0][4]=rs.getString(5);
                    str[0][5]=rs.getString(6);
                    str[0][6]=rs.getString(7);
                    str[0][7]=rs.getString(8);
                    str[0][8]=rs.getString(9);
                    str[0][9]=rs.getString(10);
                    str[0][10]=rs.getString(11);
                    str[0][11]=rs.getString(12);
                }
            }
            if(label1.equalsIgnoreCase("ChangeStatusOfOrder"))   //return all party name
            {
                
                String qry="select *from purchasePartyMaster";
                int n=countingValue(qry);
                str=new String[1][n];
               // str[0][0]="-Select-";
                int r=0;
                while(rs.next())
                {
                    //System.out.println("2............");
                    str[0][r]=rs.getString("partyNm");
                    System.out.println("party="+str[0][r]);
                    r++;
                }
            }
            else if(label1.equalsIgnoreCase("EditMakePurchaseWindowDtl"))
            {
                int row=0;
                int i=0;
                try
                {
                    row=Integer.parseInt(label2);
                }
                catch(Exception e)
                {
                    System.out.println("Error in returnResultSet into utilityClass class at EditMakePurchaseWindowDtl..."+e);
                }
                str=new String[row][13];
                while(rs.next())
                {
                    str[i][0]=rs.getString(1);
                    str[i][1]=rs.getString(2);
                    str[i][2]=rs.getString(3);
                    str[i][3]=rs.getString(4);
                    str[i][4]=rs.getString(5);
                    str[i][5]=rs.getString(6);
                    str[i][6]=rs.getString(7);
                    str[i][7]=rs.getString(8);
                    str[i][8]=rs.getString(9);
                    str[i][9]=rs.getString(10);
                    str[i][10]=rs.getString(11);
                    str[i][11]=rs.getString(12);
                    str[i][12]=rs.getString(13);
                    i++;
                }
            }
            else if(label1.equalsIgnoreCase("EditMakingSellWindowDtl"))
            {
                int row=0;
                int i=0;
                try
                {
                    row=Integer.parseInt(label2);
                }
                catch(Exception e)
                {
                    System.out.println("Error in returnResultSet into utilityClass class at EditMakingSellWindowDtl..."+e);
                }
                str=new String[row][9];
                while(rs.next())
                {
                    str[i][0]=rs.getString(1);
                    str[i][1]=rs.getString(2);
                    str[i][2]=rs.getString(3);
                    str[i][3]=rs.getString(4);
                    str[i][4]=rs.getString(5);
                    str[i][5]=rs.getString(6);
                    str[i][6]=rs.getString(7);
                    str[i][7]=rs.getString(8);
                    str[i][8]=rs.getString(9);
                    i++;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Error in returnResultSet method into utilityClass class...skm.."+e);
        }
        return str;
    }
    public String getExpDate(String itemName)
    {
            String nameList=null;
            int cmpCode=0,itemCode=0;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            /*java.sql.ResultSet rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+cmpName+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt("cmpCode");
            }*/
            
            java.sql.ResultSet rs=st.executeQuery("select itemCode from itemMaster where itemName='"+itemName+"'");
            if(rs.next())
            {
                itemCode=rs.getInt("itemCode");
            }

            rs=st.executeQuery("select expDate from stockHolding where itemCode="+itemCode+"");
            if(rs.next())
            {
                    nameList=rs.getString("expDate");
                    nameList=nameList.substring(8,10)+"/"+nameList.substring(5,7)+"/"+nameList.substring(0,4);
                    System.out.println("date:"+nameList);
                    
            }
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...1198..."+ex);
        }
        return nameList;
    }
    public String getExpDate(String itemName,String batchNo)
    {
            String nameList=null;
            int cmpCode=0,itemCode=0;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            /*java.sql.ResultSet rs=st.executeQuery("select cmpCode from cmpMaster where cmpName='"+cmpName+"'");
            if(rs.next())
            {
                cmpCode=rs.getInt("cmpCode");
            }*/
            
            java.sql.ResultSet rs=st.executeQuery("select itemCode from itemMaster where itemName='"+itemName+"'");
            if(rs.next())
            {
                itemCode=rs.getInt("itemCode");
            }

            rs=st.executeQuery("select expDate from stockHolding where itemCode="+itemCode+" and batchNo='"+batchNo+"'");
            if(rs.next())
            {
                    nameList=rs.getString("expDate");
                    nameList=nameList.substring(8,10)+"/"+nameList.substring(5,7)+"/"+nameList.substring(0,4);
                    System.out.println("date:"+nameList);
                    
            }
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...11999..."+ex);
        }
        return nameList;
    }

    public String getItemName(int itemCode)
    {
            String itemName=null;
        try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=st.executeQuery("select itemName from itemMaster where itemCode="+itemCode+"");
            if(rs.next())
            {
                itemName=rs.getString("itemName");
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...1891..."+ex);
        }
        return itemName;
    }

    public String getCmpName(int itemCode)
    {
            String cmpName=null;
        try
        {
            int cmpcode=0;
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=st.executeQuery("select cmpCode from itemMaster where itemCode="+itemCode+"");
            if(rs.next())
            {
                cmpcode=rs.getInt("cmpCode");
            }
            rs=st.executeQuery("select cmpName from cmpMaster where cmpCode="+cmpcode+"");
            if(rs.next())
            {
                cmpName=rs.getString("cmpName");
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...1891..."+ex);
        }
        return cmpName;
    }
    public String getCmpName(String itemName)
    {
            String cmpName=null;
        try
        {
            int cmpcode=0;
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection connection=cd.getConnection();
            java.sql.Statement st=connection.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=st.executeQuery("select cmpCode from itemMaster where itemName='"+itemName+"'");
            if(rs.next())
            {
                cmpcode=rs.getInt("cmpCode");
            }
            rs=st.executeQuery("select cmpName from cmpMaster where cmpCode="+cmpcode+"");
            if(rs.next())
            {
                cmpName=rs.getString("cmpName");
            }
            
            connection.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error...1891..."+ex);
        }
        return cmpName;
    }
    public boolean isBlank(String text)
    {
        if(text==null || text.trim().equals(""))
        {
            return true;
        }
        return false;
    }
    public boolean isInteger(String text)
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
    public boolean isDouble(String text)
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
    public boolean makeNewFirm(String newFirmName)
    {
                                try
                                {
                                        int c=0;
                                        java.io.FileInputStream in = new java.io.FileInputStream("blankdatabase\\database.mdb");
                                        java.io.FileOutputStream out = new java.io.FileOutputStream("mydatabase\\"+newFirmName+".mdb");
                                        java.io.File fl=new java.io.File("blankdatabase\\database.mdb");
                                        long l=fl.length();
                                        System.out.println("l="+l);
                                        System.out.println("Start");
                                        int c1=1;
                                        while((c=in.read())!=-1)
                                        {
                                                out.write(c);
                                        }

                                        in.close();
                                        out.close();
                                        System.out.println("End");
                                }
                                catch(Exception e)
                                {
                                        javax.swing.JOptionPane.showMessageDialog(null,"Sorry! We can not create new Firm."+e,"Warning!",javax.swing.JOptionPane.WARNING_MESSAGE);
                                        return false;
                                }
                                return true;
    }
     public String getMotherboardSN() {
  String result = "";
    try {
        /*
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
         */
        
        //get serial no of hard disk
        String drive="C";
        java.io.File file = java.io.File.createTempFile("realhowto",".vbs");
      file.deleteOnExit();
      java.io.FileWriter fw = new java.io.FileWriter(file);

      String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                  +"Set colDrives = objFSO.Drives\n"
                  +"Set objDrive = colDrives.item(\"" + drive + "\")\n"
                  +"Wscript.Echo objDrive.SerialNumber";  // see note
      fw.write(vbs);
      fw.close();
      Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
      java.io.BufferedReader input =
        new java.io.BufferedReader
          (new java.io.InputStreamReader(p.getInputStream()));
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
	
	
	
	
	
	
	//**********************************************  END MEDICAL RELATED METHOD   ******************************************
	
	//************  AS INNER CLASS     **********************************  DATABASE CONNECTIVITY FOR MEDICAL RELATED METHOD   ******************************************
	
	public class ConnectDatabase 
	{	
	public java.sql.Connection getConnection ()//String strFileName, String strUserName, String strPassWord) throws Exception
	{
		java.sql.Connection databaseConnection=null;			
		try
		{
                        String path = new java.io.File(".").getCanonicalPath();
                        System.out.println("path="+path);
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        	String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path+"\\mydatabase\\hospitalMNG.mdb";
                        databaseConnection = java.sql.DriverManager.getConnection(myDB,"zedabc123","zedabc123");
                }
                catch (ClassNotFoundException ex) //Thrown if driver is not reconised
                {	       
                    System.out.println("\nError loading database access driver.\nPossible reason is that you do not have MS Access");	        
                }
                catch (java.sql.SQLException ex) //Thrown if database can not be found
                {	        
                    System.out.println("\nError connecting to database\n" +ex);	        
                }
                catch (java.io.IOException ex) //Thrown if database can not be found
                {	        
                    System.out.println("\n4. Error file not found\n" +ex);	        
                }
        
                return databaseConnection;
        
        }
	}
	
	
	//************  INNER CLASS CLOSE  **********************************  END DATABASE CONNECTIVITY FOR MEDICAL RELATED METHOD   ******************************************
	
	
	
	//**********************************************  Main Method   ******************************************
	public static void main(String args[])
	{
		try
		{
			Runtime.getRuntime().exec("runRMI.bat");
			ZedServer zs=new ZedServer();
			Naming.rebind("ExtendZedServer",zs);
		}
		catch(Exception ex)
		{
			System.out.println("Error no.1..."+ex);
		}
	}
	//********************************************************************************************************
}