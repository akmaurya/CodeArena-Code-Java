import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.sql.*;
import java.io.*;
import java.util.Date;
import java.math.*;
import railwaycashoffice.interfaceRailway;
public class serverRailway extends UnicastRemoteObject implements interfaceRailway
{
        Connection connection,connectionD;
        Statement st,st1,stD;
        ResultSet rs,rs1,rsD;
        static String finYear=null;
        public serverRailway() throws RemoteException
        {
                System.out.println("The server is started...");
                javax.swing.JOptionPane.showMessageDialog(null,"hello.....Coming here");
            /*    try
                {
                        /*
                        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        connection=DriverManager.getConnection("jdbc:odbc:newrailway2008","shubh","shubh");
                        st=connection.createStatement();
                        
                        connectionD=DriverManager.getConnection("jdbc:odbc:dummyrailway2008");
                        stD=connectionD.createStatement();
                        */

                        
						/*
                        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                        connection= DriverManager.getConnection("jdbc:mysql://localhost/railway0708?user=rnr&password=rnr");
                		st = connection.createStatement(); 	
						/////////////////off here
						File fl=new File(".");
						String path=fl.getCanonicalPath();
						System.out.println("database path="+path);
						
						
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
						String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ="+path+"//dummyrailway.MDB";
						connectionD = DriverManager.getConnection(myDB,"","");
						stD=connectionD.createStatement();						
                }
                catch(Exception x)
                {
                        System.out.println("Error related to database connectivity..."+x);
                }*/
        }
        public boolean selectedFinancialYear(String fin)
        {
        	try
        	{   
        		System.out.println("a");     	
	        	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                System.out.println("b");
                connection= DriverManager.getConnection("jdbc:mysql://localhost/railway"+fin+"?user=RailwaysCashOffice&password=RCO");
                System.out.println("jdbc:mysql://localhost/railway"+fin+"?user=RailwaysCashOffice&password=RCO");
           		st = connection.createStatement(); 
           		st1 = connection.createStatement();
           		finYear=fin; 
           		System.out.println("c");
                return true;	
           	}
            catch(Exception x)
            {
                System.out.println("Error related to database connectivity90..."+x);
            }	
            return false;
        }
        public String returnFinancialYears()
        {
        	String finyear="";
        	
        	try
        	{
        		
        		File fl=new File("C:\\mysql\\data");
        		String fname[]=fl.list();
        		for(int i=0;i<fname.length;i++)
        		{
        			System.out.println("C:\\mysql\\data\\"+fname[i]);
        			File fltemp=new File("C:\\mysql\\data\\"+fname[i]);
        			if(fltemp.isDirectory())
        			{
        				finyear=finyear+fname[i]+";";
        			}
        		}
        	}
        	catch(Exception x)
        	{
        		System.out.println("Error392..."+x);
        	}
        	System.out.println("finyear="+finyear);
        	return finyear;
        }
        public boolean checkFinancialDB(String path)
        {
        				System.out.println("path="+path);
        				File fl=new File(path);
        				if(fl.exists())
        				{
        					//if Database exist
        					return true;
        				}
        				else
        				{
        					//if Database NOT exist
        					//Create New Database folder
        					boolean bl=fl.mkdir();     
        					
          					fl=new File("C:\\mysql\\data\\railwayblankdatabase");
        					String fname[]=fl.list();
        		                              //Copy blank database
        		            for(int i=0;i<fname.length;i++)                  
                            {
                            	try
                                {
                                	    FileInputStream in = new FileInputStream("C:\\mysql\\data\\railwayblankdatabase\\"+fname[i]);
                                        FileOutputStream out = new FileOutputStream(path+"\\"+fname[i]);
                                        byte[] b=new byte[1000];
                                        int c=0;
                                        while((c=in.read(b))!=-1)
                                        {
                                                out.write(b);
                                        }
                                        in.close();
                                        out.close();
                                 }
                                 catch(Exception x)
                                 {
                                 	System.out.println("error 87654..."+x);
                                 }       
        					}   					
        					System.out.println("bl="+bl);
        					return false;
        				}
        }
        public boolean checkSuperwiserPassword(String username,String password)
        {
                try
                {
                	//System.out.println("\nquery="+url);
                        rs=st.executeQuery("select * from passwordinformation1 where username='"+username+"'");
                        if(rs.next())
                        {
                                if(password.compareTo(rs.getString("password"))==0)
                                {
                                        //if username & password is satisfied
                                        return(true);
                                }
                                else
                                {
                                        //in case of wrong password
                                        return(false);
                                }
                        }
                        else
                        {
                                //in case of wrong username or password
                                return(false);
                        }
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation1......"+x);
                }
                return true;
        }


        public boolean createSection(String divisioncode,String sectioncode,String sectionname)
        {
                try
                {
                        rs=st.executeQuery("select * from sectionhead where sectioncode='"+sectioncode+"' and divisioncode='"+divisioncode+"'");
                        if(rs.next())
                        {
                        		
                                //in case this name already exist
                                return(false);
                        }
                        else
                        {
                                //new data insert 
                                st.executeUpdate("insert into sectionhead values('"+divisioncode+"','"+sectioncode+"','"+sectionname+"')");
                                String tablename=sectioncode+"stationlist";
                                st.executeUpdate("CREATE TABLE "+tablename+" (sno int(11) default NULL,stationcode varchar(20) default NULL,stationname varchar(50) default NULL)");

								/*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=d:/rmirailway/dummyrailway.MDB";
								Connection c1= DriverManager.getConnection(myDB,"","");
								Statement s1=c1.createStatement();						
								System.out.println("1");
								s1.executeUpdate("CREATE TABLE "+tablename+" (sno integer,stationcode text,stationname text)");
								System.out.println("2");

								myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=d:/rmirailway/Railway_transaction_blank.MDB";
								c1= DriverManager.getConnection(myDB,"","");
								s1=c1.createStatement();						
								s1.executeUpdate("CREATE TABLE "+tablename+" (sno integer,stationcode text,stationname text)");
								*/

                                return(true);
                        }                     
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of section creation......"+x);
                }
                return true;
        }


        public boolean createStation(String divisioncode,String sectioncode,String stationcode,String stationname,String lodgment,String bankname,String branchname,String branchcode)
        {
                try
                {
                        rs=st.executeQuery("select * from stationmaster where stationcode='"+stationcode+"' and divisioncode='"+divisioncode+"'");
                        if(rs.next())
                        {
                                //in case this name already exist
                                return(false);
                        }
                        else
                        {
                                //new data insert 
                                st.executeUpdate("insert into stationmaster values('"+divisioncode+"','"+sectioncode+"','"+stationcode+"','"+stationname+"','"+lodgment+"','"+bankname+"','"+branchname+"','"+branchcode+"')");
                                return(true);
                        }                     
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of section creation......"+x);
                }
                return true;
        }


        public boolean createBankName(String naam)
        {
                try
                {
                        rs=st.executeQuery("select * from bankMaster where name='"+naam+"' ");
                        if(rs.next())
                        {
                                //in case of given name already exist
                                return(false);
                        }
                        else
                        {
                                //successfuly created
                                st.executeUpdate("insert into bankMaster values('"+naam+"')");
                                return(true);
                        }
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation2......"+x);
                }
                return true;
        }
        public boolean createShroffsName(String naam)
        {
                try
                {
                        rs=st.executeQuery("select * from shrofferMaster where shrofferName='"+naam+"' ");
                        if(rs.next())
                        {
                                //in case of given name already exist
                                return(false);
                        }
                        else
                        {
                                //successfuly created
                                st.executeUpdate("insert into shrofferMaster values('"+naam+"')");
                                return(true);
                        }
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation3......"+x);
                }
                return true;
        }


        public boolean createCashWitnessName(String naam)
        {
                try
                {
                        rs=st.executeQuery("select * from witnessMaster where cashWitnessName='"+naam+"' ");
                        if(rs.next())
                        {
                                //in case of given name already exist
                                return(false);
                        }
                        else
                        {
                                //successfuly created
                                st.executeUpdate("insert into witnessMaster values('"+naam+"')");
                                return(true);
                        }
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation4......"+x);
                }
                return true;
        }


        public boolean checkExistance(String url)
        {
                try
                {
                	System.out.println("\nquery="+url);
                        rs=st.executeQuery(url);
                        if(rs.next())
                        {
                                //if found
                                return(true);
                        }
                        else
                        {
                                //if not found
                                return(false);
                        }
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation4......"+x);
                }
                return true;
        }

        public boolean deleteRecord(String url)
        {
                try
                {
                        st.executeUpdate(url);
                        return(true);
                }
                catch(Exception x)
                {
                        System.out.println("Error ......"+x+"..."+url);
                }
                return false;
        }


        public boolean deleteSection(String url)
        {
                try
                {
                        st.executeUpdate(url);
                        
		                        /*Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								String myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=d:/rmirailway/dummyrailway.MDB";
								Connection c1= DriverManager.getConnection(myDB,"","");
								Statement s1=c1.createStatement();						
								System.out.println("1");
								s1.executeUpdate(url);
								System.out.println("2");

								myDB = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=d:/rmirailway/Railway_transaction_blank.MDB";
								c1= DriverManager.getConnection(myDB,"","");
								s1=c1.createStatement();						
								s1.executeUpdate(url);
								*/

                        return(true);
                }
                catch(Exception x)
                {
                        System.out.println("Error ......"+x+"..."+url);
                }
                return false;
        }


        public String[][] returnSectionCode(String url)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                	System.out.println("\nquery="+url);
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][2];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                array1[i][0]=rs.getString("sectioncode");
                                array1[i][1]=rs.getString("sectionname");
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation5......"+x);
                }
                return array;
        }


        public String[][] returnStationCode(String url)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][2];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                array1[i][0]=rs.getString("stationcode");
                                array1[i][1]=rs.getString("stationname");
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation6......"+x);
                }
                return array;
        }


        public BigDecimal returnValue()
        {
        	
                BigDecimal amt=new BigDecimal(0.00);
                try
                {
                        rs=st.executeQuery("select amount from miscEntry");
                        while(rs.next())
                        {
                                amt=amt.add(new BigDecimal(rs.getString("amount")));
                        }
                        System.out.println("misc value="+amt);
                        rs=st.executeQuery("select depositeAmt from depositeEntry ");
                        while(rs.next())
                        {
                                amt=amt.subtract(new BigDecimal(rs.getString("depositeAmt")));
                        }
                        System.out.println("deposite value11="+amt);
                        //amt=new BigDecimal("0");
                        rs1=st1.executeQuery("select cashValue from earningmaster");
                        System.out.println("skm....1");
                        while(rs1.next())
                        {
                        	//System.out.println("skm....2");
                        	String cashV=rs1.getString("cashValue");
                        	//System.out.println("cash value="+cashV);
                                amt=amt.add(new BigDecimal(cashV));
                        }
                        System.out.println("cash value="+amt);
                        return amt;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation7......"+x);
                }
                return amt;
        }


        public String[][] returnArray(String url,String fieldName1,String fieldName2)
        {
                int i=0;
                System.out.println("\nquery="+url);
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][2];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                array1[i][0]=rs.getString(fieldName1);
                                array1[i][1]=rs.getString(fieldName2);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation7......"+x);
                }
                return array;
        }


        public String[][] returnArray(String url,String fieldName1,String fieldName2,String fieldName3)
        {
                int i=0;
                
                System.out.println("\nquery="+url);
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][3];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                array1[i][0]=rs.getString(fieldName1);
                                array1[i][1]=rs.getString(fieldName2);
                                array1[i][2]=rs.getString(fieldName3);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation8......"+x);
                }
                return array;
        }


        public Date returnDateFunc(String url,String dateFieldName)
        {
                Date date=new Date("01/01/01");
                try     
                {
                		System.out.println("url="+url);
                        System.out.println("dateFieldName="+dateFieldName);
                        rs=st.executeQuery(url);
                        rs.next();
                        date=rs.getDate(dateFieldName);
                        String temp=""+date;
                        temp=temp.substring(5,7)+"/"+temp.substring(8,10)+"/"+temp.substring(0,4);
                        date=new Date(temp);
                        System.out.println(date);
                        return date;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation9......"+x);
                }
                return date;
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
    		String toDayIs=(dt.getDate()+"-"+(dt.getMonth()+1)+"-"+(dt.getYear()+1900));//+"_"+dt.getHours()+"_"+dt.getMinutes()+"_"+dt.getSeconds());
            java.io.File fl1=new java.io.File("");
            String path1=fl1.getAbsolutePath();
            String p=fl1.getCanonicalPath();
            String dirName=p+"Database_Backup";
            String folderName="ZED";
            String filename=dirName+"\\"+folderName+"\\"+toDayIs+"\\railway"+finYear;//+"\\"+"hospitalMNG.mdb";
            System.out.println("FileCreationPath="+filename);
            java.io.File makedir=new java.io.File(filename);
            makedir.mkdirs();
    		java.io.File fl=new java.io.File("");
            String currentpath = fl.getAbsolutePath();
            String dataPath="c:\\mysql\\data\\"+"railway"+finYear;
            System.out.println("datapath="+dataPath);
            File fl11=new File(dataPath);
	   		File file111[]=fl11.listFiles();
	   		System.out.println("How Many file="+file111.length);
	   		for(int i1=0;i1<file111.length;i1++)
	   		{
                String dbNm=file111[i1].getName();
	   			java.io.FileInputStream in = new java.io.FileInputStream(dataPath+"\\"+dbNm);
            	java.io.FileOutputStream out = new java.io.FileOutputStream(filename+"\\"+dbNm);
            	int c=0;
            	int i=1;
            	byte b[]=new byte[1000];
				while((c=in.read(b))!=-1)
				{
                   out.write(b);
            	}
            	in.close();
            	out.close();
            }
            msg="Backup process completed successfully.";
            System.out.println(""+msg);
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in getBackupOfDatabase at meserver1 class.........."+e);
    		msg="Error found.";
    		return msg;
    	}
    	return msg;	 
    }

        public boolean executeSQLUpdateCommand(String url)
        {
                try
                {
                		System.out.println(url);
                        st.executeUpdate(url);
                        return true;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of execution of SQL Command789......"+x);
                }
                return false;
        }
        

        public String[] returnArray(String url,String fieldName)
        {
                int i=0;
                String[] array={"a","b","c","d"};
                try
                {
                	System.out.println("\nquery="+url);
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[]=new String[i];
                        i=0;
                        System.out.println("\nquery="+url);
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                array1[i]=rs.getString(fieldName);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation10......"+x);
                }
                return array;
        }


        public String[][] returnArray(String url,int noOfFields)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][noOfFields];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                for(int n=0;n<noOfFields;n++)
                                        array1[i][n]=rs.getString(n+1);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation11......"+x);
                }
                return array;
        }



        public int countRecord(String url)
        {
                int i=0;
                try
                {
                	System.out.println("\nquery="+url);
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        return i;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation12......"+x);
                }
                return i;
        }


        public String[] returnValueCashBagEntry(String url)
        {
                int i=0;
                String[] array1={"a","b"};
                try
                {
                        rs=st.executeQuery(url);
                        if(rs.next())
                        {
                                        String[] array=new String[4];
                                        String temp="";
                                        String temp1=rs.getString("bagNo1");
                                        String temp2=rs.getString("bagNo2");
                                        String temp3=rs.getString("bagNo3");
                                        String temp4=rs.getString("bagNo4");
                                        String temp5=rs.getString("bagNo5");
                                        if(!temp1.equals("null"))
                                                temp=temp1;    
                                        if(!temp2.equals("null"))
                                                temp=temp+","+temp2;    
                                        if(!temp3.equals("null"))
                                                temp=temp+","+temp3;    
                                        if(!temp4.equals("null"))
                                                temp=temp+","+temp4;    
                                        if(!temp5.equals("null"))
                                                temp=temp+","+temp5;    

                                        String temp6=rs.getString("bagNo6");
                                        if(temp6.equals("null"))
                                                temp6="0";    

                                        array[0]=temp;
                                        array[1]=temp6;
                                        array[2]=rs.getString("shrofferName");
                                        array[3]=rs.getString("witnessName");
                                        return(array);
                        }
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation13......"+x);
                }
                return array1;
        }


        public String[][] returnAllValueCashBagEntry(String url)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                	System.out.println("\nquery="+url);
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][13];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                for(int n=0;n<13;n++)
                                        array1[i][n]=rs.getString(n+1);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation14......"+x);
                }
                return array;
        }




        public String[][] returnValueTransaction(String url)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][38];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                for(int n=0;n<38;n++)
                                        array1[i][n]=rs.getString(n+1);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation15......"+x);
                }
                return array;
        }



        public String[][] returnValueMiscEarning(String url)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][16];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                for(int n=0;n<16;n++)
                                        array1[i][n]=rs.getString(n+1);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation16......"+x);
                }
                return array;
        }



        public int countBagNo(String url)
        {
                int i=0;
                try
                {
                	System.out.println("\nquery="+url);
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                String temp=rs.getString("bagNo1");
                                if(!temp.equals("null"))
                                        i++;
                                temp=rs.getString("bagNo2");
                                if(!temp.equals("null"))
                                        i++;
                                temp=rs.getString("bagNo3");
                                if(!temp.equals("null"))
                                        i++;
                                temp=rs.getString("bagNo4");
                                if(!temp.equals("null"))
                                        i++;
                                temp=rs.getString("bagNo5");
                                if(!temp.equals("null"))
                                        i++;
                        }
                        return i;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation17......"+x);
                }
                return i;
        }


        public int countPktNo(String url)
        {
                int i=0;
                String temp="";
                try
                {
                	System.out.println("\nquery="+url);
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                temp=rs.getString("bagNo6");
                                if(!temp.equals("null"))
                                        i+=Integer.parseInt(temp);
                        }
                        return i;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation18......"+x);
                }
                return i;
        }


        public String[][] returnTcsafenoAndSealeddate(String url)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][2];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                array1[i][0]=rs.getString("tcsafeNo");
                                array1[i][1]=rs.getString("sealedDate");
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation19......"+x);
                }
                return array;
        }


        public String[][] returnValueCheque(String url)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                	System.out.println("\nquery="+url);
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][12];
                        i=0;
                        rs=st.executeQuery(url);
                        while(rs.next())
                        {
                                for(int n=0;n<12;n++)
                                        array1[i][n]=rs.getString(n+1);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation20......"+x);
                }
                return array;
        }


        public String[][] returnArrayDummyDB(String url,int noOfFields)
        {
                try
                {
                        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        //connectionD=DriverManager.getConnection("jdbc:odbc:dummyrailway");
                        //stD=connectionD.createStatement();
                }
                catch(Exception x)
                {
                        System.out.println("Error related to database connectivity..."+x);
                }
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        rsD=stD.executeQuery(url);
                        while(rsD.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][noOfFields];
                        i=0;
                        rsD=stD.executeQuery(url);
                        while(rsD.next())
                        {
                                for(int n=0;n<noOfFields;n++)
                                        array1[i][n]=rsD.getString(n+1);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation21......"+x);
                }
                return array;
        }

        public String[][] returnArrayDummyDB(String url,String fieldName1,String fieldName2,String fieldName3)
        {
                try
                {
                        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        //connectionD=DriverManager.getConnection("jdbc:odbc:dummyrailway");
                        //stD=connectionD.createStatement();
                }
                catch(Exception x)
                {
                        System.out.println("Error related to database connectivity..."+x);
                }
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                	System.out.println("\nquery="+url);
                        rsD=stD.executeQuery(url);
                        while(rsD.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][3];
                        i=0;
                        rsD=stD.executeQuery(url);
                        while(rsD.next())
                        {
                                array1[i][0]=rsD.getString(fieldName1);
                                array1[i][1]=rsD.getString(fieldName2);
                                array1[i][2]=rsD.getString(fieldName3);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation22......"+x);
                }
                return array;
        }

        public boolean executeSQLUpdateCommandDummyDB(String url)
        {
                try
                {
                        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        //connectionD=DriverManager.getConnection("jdbc:odbc:dummyrailway");
                        //stD=connectionD.createStatement();
                }
                catch(Exception x)
                {
                        System.out.println("Error related to database connectivity..."+x);
                }
                try
                {
                		System.out.println("url:"+url);
                        stD.executeUpdate(url);
                        return true;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of execution of SQL Command389......"+x+" ; "+url);
                }
                return false;
        }
        


        public static void main(String args[])
        {
                try
                {
                        serverRailway server1=new serverRailway();
                        Naming.rebind("railwayMethod",server1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of rmi registry..."+x);
                }
        }

        public int countRecordsInDateRange(String sql,int y1,int m1,int d1,int y2,int m2,int d2)
        {
                int i=0;
                try
                {
                	System.out.println("\nquery="+sql);
                        PreparedStatement ps=connection.prepareStatement(sql);
                        java.sql.Date mydate1=new java.sql.Date(y1,m1,d1);
                        java.sql.Date mydate2=new java.sql.Date(y2,m2,d2);
                        ps.setDate(1,mydate1);
                        ps.setDate(2,mydate2);
                        rs=ps.executeQuery();
                        while(rs.next())
                        {
                                i++;
                        }
                        return i;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation23......"+x);
                }
                return i;
        }

        public int countRecordsInDateRange(String sql,int y1,int m1,int d1)
        {
                int i=0;
                try
                {
                	System.out.println("\nquery="+sql);
                        PreparedStatement ps=connection.prepareStatement(sql);
                        java.sql.Date mydate1=new java.sql.Date(y1,m1,d1);
                        ps.setDate(1,mydate1);
                        rs=ps.executeQuery();
                        while(rs.next())
                        {
                                i++;
                        }
                        return i;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation24......"+x);
                }
                return i;
        }


        public String[][] returnArrayInDateRange(String url,int y1,int m1,int d1,int y2,int m2,int d2,int noOfFields)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        PreparedStatement ps=connection.prepareStatement(url);
                        java.sql.Date mydate1=new java.sql.Date(y1,m1,d1);
                        java.sql.Date mydate2=new java.sql.Date(y2,m2,d2);
                        ps.setDate(1,mydate1);
                        ps.setDate(2,mydate2);
                        rs=ps.executeQuery();
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][noOfFields];
                        i=0;
                        rs=ps.executeQuery();
                        while(rs.next())
                        {
                                for(int n=0;n<noOfFields;n++)
                                        array1[i][n]=rs.getString(n+1);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation25......"+x);
                }
                return array;
        }

        public String[][] returnArrayInDateRange(String url,int y1,int m1,int d1,int noOfFields)
        {
                int i=0;
                String[][] array={{"a","b"},{"c","d"}};
                try
                {
                        PreparedStatement ps=connection.prepareStatement(url);
                        java.sql.Date mydate1=new java.sql.Date(y1,m1,d1);
                        ps.setDate(1,mydate1);
                        rs=ps.executeQuery();
                        while(rs.next())
                        {
                                i++;
                        }
                        String array1[][]=new String[i][noOfFields];
                        i=0;
                        rs=ps.executeQuery();
                        while(rs.next())
                        {
                                for(int n=0;n<noOfFields;n++)
                                        array1[i][n]=rs.getString(n+1);
                                i++;
                        }
                        return(array1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of bank name creation26......"+x);
                }
                return array;
        }
        public boolean updateRecordsInDateRange(String sql,int y1,int m1,int d1,double doubleValue)
        {
                try
                {
                        PreparedStatement ps=connection.prepareStatement(sql);
                        java.sql.Date mydate1=new java.sql.Date(y1,m1,d1);
                        ps.setDate(1,mydate1);
                        ps.setDouble(2,doubleValue);

                        ps.executeUpdate();
                        return true;
                }
                catch(Exception x)
                {
                        System.out.println("Error in updateRecordsInDateRange......"+x);
                }

                return false;
        }
        public boolean updateRecordsInDateRange(String sql,int y1,int m1,int d1)
        {
                try
                {
                        PreparedStatement ps=connection.prepareStatement(sql);
                        java.sql.Date mydate1=new java.sql.Date(y1,m1,d1);
                        ps.setDate(1,mydate1);
						System.out.println("receive qry:"+sql);
                        ps.executeUpdate();
                        return true;
                }
                catch(Exception x)
                {
                        System.out.println("Error in updateRecordsInDateRange111>>......"+x);
                }

                return false;
        }
        public void updateRecordsInDateRangeInDummyDB(String sql,int y1,int m1,int d1,int y2,int m2,int d2)
        {
                try
                {
                        PreparedStatement ps=connectionD.prepareStatement(sql);
                        java.sql.Date mydate1=new java.sql.Date(y1,m1,d1);
                        java.sql.Date mydate2=new java.sql.Date(y2,m2,d2);
                        ps.setDate(1,mydate1);
                        ps.setDate(2,mydate2);
                        ps.executeUpdate();

                        //stD.executeUpdate(url);
                        //return true;
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of execution of SQL Command......"+x);
                }
                //return false;
        }

		public String returnSingleValue(String url)
        {
        	 System.out.println("called : "+url);
        		String value=null;
                try
                {
                        rs=st.executeQuery(url);
                        if(rs.next())
                        {
                        	value=rs.getString(1);
                        	if(value==null)
                        		value="0";
                        }
        	 System.out.println("value : "+value);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of execution of SQL Command in returnSingleValue()......"+x);
                }
                return value;
		}
}