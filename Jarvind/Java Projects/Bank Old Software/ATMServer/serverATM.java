import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.sql.*;
import java.io.*;
import java.util.Date;
import java.math.*;
import atm.interfaceATM;
import java.lang.*;
public class serverATM extends UnicastRemoteObject implements interfaceATM
{
        Connection connection,connectionD;
        Statement st,st1,st2,st3,stD;
        ResultSet rs,rs1,rs3,rsD;
        static String finYear=null;
        public serverATM() throws RemoteException{}
        {
                System.out.println("The server is started----------...");
               try
                {
                        Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                        connection= DriverManager.getConnection("jdbc:mysql://localhost/atmdatabase?user=kgsgatm&password=rnr");
                	st = connection.createStatement();
                        st1=connection.createStatement();
                        st2=connection.createStatement();
                        st3=connection.createStatement();
                        stD=connection.createStatement();					
                }
                catch(Exception x)
                {
                        System.out.println("Error related to database connectivity..."+x);
                }
        }

	public boolean updateKGSGInUBI(String data)
        {
		try
		{
			int max_entry_no=1;
                        double balancedb=0;
			ResultSet rs=st.executeQuery("select max(entry_no) from kgsg_n_ubi");
			if(rs.next())
			{
				max_entry_no=rs.getInt(1)+1;	
			}
                        String qry="select balance_amt from kgsg_n_ubi order by entry_no desc";
                        System.out.println(qry);
                        rs=st.executeQuery(qry);
			if(rs.next())
			{
                            balancedb=rs.getDouble("balance_amt");
                            System.out.println("balancedb = "+balancedb);
                        }
                        else
                        {
                            balancedb=0;
                        }
                        System.out.println("balancedb = "+balancedb);
			String trandate="",tranid="",particulars="",debitamt="",creditamt="",balamt="";
			double dbamt=0,cramt=0,balanceamt=0;
			int status=0;
                        double totaldr=0,totalcr=0;
                        String indexString="";
                        String arr[]=data.split("\n");
                        System.out.println(arr.length);


                        //CODE TO CHECK MISSING RECORDS OR NOT IN SELECTED FILE
                        //-----------------------------------------------------
                        for(int r=0;r<arr.length;r++)
			{
				trandate="";tranid="";particulars="";debitamt="";creditamt="";balamt="";
                                dbamt=0;cramt=0;balanceamt=0;
				trandate=arr[r].substring(1,arr[r].indexOf(" ",1)).trim();//get tran date
                                //System.out.println("dateaaaaaaaaa....... ="+trandate);
                                trandate=trandate.substring(6,10)+"-"+trandate.substring(3,5)+"-"+trandate.substring(0,2);
				tranid=arr[r].substring(13,arr[r].indexOf(" ",14)).trim();		//get tran id
				particulars=arr[r].substring(44,72).trim();	//get particulars







                                System.out.println("date....... ="+trandate);
                                qry="select tran_date,tran_id,particular from kgsg_n_ubi where tran_date='"+trandate+"'and tran_id='"+tranid+"'and particular='"+particulars+"'";
                                //System.out.println("qry="+qry);
                                rs1=st1.executeQuery(qry);
                                if(rs1.next()==false)
                                {

                                    indexString=indexString+r+",";
                                    debitamt=arr[r].substring(72,93).trim();	//get debit amt
                                    creditamt=arr[r].substring(93,114).trim();	//get credit amt
                                    balamt=arr[r].substring(arr[r].indexOf(" ",117),arr[r].indexOf("Cr")).trim();	//get credit amt
                                    //trandate=trandate.substring(6,10)+"-"+trandate.substring(3,5)+"-"+trandate.substring(0,2);
                                    System.out.println("date ="+trandate);
                                    if(debitamt.length()>0)
                                    {
                                            String temparr[]=debitamt.split(",");
                                            debitamt="";
                                            for(int i=0;i<temparr.length;i++)
                                            {
                                                    debitamt=debitamt+temparr[i];
                                            }
                                            dbamt=Double.valueOf(debitamt);

                                            cramt=0;
                                    }
                                    else
                                    {
                                            dbamt=0;

                                            String temparr[]=creditamt.split(",");
                                            creditamt="";
                                            for(int i=0;i<temparr.length;i++)
                                            {
                                                    creditamt=creditamt+temparr[i];
                                            }
                                            cramt=Double.valueOf(creditamt);
                                    }

                                    totaldr=totaldr+dbamt;
                                    totalcr=totalcr+cramt;

                                    if(balamt.length()>0)
                                    {
                                            String temparr[]=balamt.split(",");
                                            balamt="";
                                            for(int i=0;i<temparr.length;i++)
                                            {
                                                    balamt=balamt+temparr[i];
                                            }
                                            balanceamt=Double.valueOf(balamt);
                                          //  System.out.println("balanceamt="+balanceamt);
                                    }

                                    if(r==0)
                                    {
                                        if(balancedb==0)
                                        {
                                           // System.out.println("balancedb="+balancedb);
                                            balancedb=balanceamt+dbamt-cramt;
                                            //System.out.println("balancedb at that time when it is 0 then ="+balancedb);
                                        }
                                    }
                                }
                                //System.out.println(" ="+balancedb);
                        }
                        
                        //javax.swing.JOptionPane.showMessageDialog(null, "leftside="+(balancedb+(totalcr-totaldr))+"\nRight side="+balanceamt);
                        //System.out.println("balancedb"+balancedb+"balancedb ="+balanceamt+"  debit ="+dbamt+"credit="+cramt);
                        System.out.println("Total DR="+totaldr+"          Total CR="+totalcr);

                        //IF RECORD NOT MISSED IN FILE THEN
                        //---------------------------------
                        System.out.println((balancedb+(totaldr-totalcr))+"    =   "+balanceamt+"      "+((balancedb+(totaldr-totalcr))-balanceamt));
                        if((balancedb+(totalcr-totaldr))==balanceamt)
                        {
                            trandate="";tranid="";particulars="";debitamt="";creditamt="";balamt="";
                            dbamt=0;cramt=0;balanceamt=0;
                            status=0;
                            String indexArr[]=indexString.split(",");
                            System.out.println(arr.length);
                            int r=0;
                            for(int idx=0;idx<indexArr.length;idx++)
                            {
                                r=Integer.parseInt(indexArr[idx]);
				trandate="";tranid="";particulars="";debitamt="";creditamt="";balamt="";
                                trandate=arr[r].substring(1,arr[r].indexOf(" ",1)).trim();//get tran date
                                //System.out.println("dateaaaaaaaaa....... ="+trandate);
                                trandate=trandate.substring(6,10)+"-"+trandate.substring(3,5)+"-"+trandate.substring(0,2);	//get tran date
				tranid=arr[r].substring(13,arr[r].indexOf(" ",14)).trim();		//get tran id
				particulars=arr[r].substring(44,72).trim();	//get particulars
				debitamt=arr[r].substring(72,93).trim();	//get debit amt
				creditamt=arr[r].substring(93,114).trim();	//get credit amt
				balamt=arr[r].substring(arr[r].indexOf(" ",117),arr[r].indexOf("Cr")).trim();	//get credit amt
				
				if(debitamt.length()>0)
                                {
                                     String temparr[]=debitamt.split(",");
                                     debitamt="";
                                     for(int i=0;i<temparr.length;i++)
                                     {
                                          debitamt=debitamt+temparr[i];
                                     }
                                     dbamt=Double.valueOf(debitamt);
                                     cramt=0;
                                }
                                else
                                {
                                     dbamt=0;
                                     String temparr[]=creditamt.split(",");
                                     creditamt="";
                                     for(int i=0;i<temparr.length;i++)
                                     {
                                          creditamt=creditamt+temparr[i];
                                     }
                                     cramt=Double.valueOf(creditamt);
                                }

                                if(balamt.length()>0)
                                {
                                      String temparr[]=balamt.split(",");
                                      balamt="";
                                      for(int i=0;i<temparr.length;i++)
                                      {
                                           balamt=balamt+temparr[i];
                                      }
                                           balanceamt=Double.valueOf(balamt);
                                }

                                if(tranid.toUpperCase().indexOf("AA")==0 && particulars.toUpperCase().indexOf("FY")>=0)
					status=10;
				else
					status=0;

                                int payment=-1;
                                String cmt=null;
                                System.out.println("insert into kgsg_n_ubi values("+max_entry_no+",'"+trandate+"','"+tranid+"','"+particulars+"',"+dbamt+","+cramt+","+balanceamt+","+status+","+payment+","+cmt+")");
				st.executeUpdate("insert into kgsg_n_ubi values("+max_entry_no+",'"+trandate+"','"+tranid+"','"+particulars+"',"+dbamt+","+cramt+","+balanceamt+","+status+","+payment+","+cmt+")");
				max_entry_no++;
                        }
                    }
                    else
                        {
                            return false;
                        }

			/*for(int r=0;r<arr.length;r++)
			{
				trandate="";tranid="";particulars="";debitamt="";creditamt="";balamt="";
                                trandate=arr[r].substring(1,arr[r].indexOf(" ",1)).trim();	//get tran date
				tranid=arr[r].substring(13,arr[r].indexOf(" ",14)).trim();		//get tran id
				trandate=trandate.substring(6,10)+"-"+trandate.substring(3,5)+"-"+trandate.substring(0,2);
				particulars=arr[r].substring(44,72).trim();	//get particulars
				debitamt=arr[r].substring(72,93).trim();	//get debit amt
				creditamt=arr[r].substring(93,114).trim();	//get credit amt
				balamt=arr[r].substring(arr[r].indexOf(" ",117),arr[r].indexOf("Cr")).trim();	//get credit amt
				trandate=trandate.substring(6,10)+"-"+trandate.substring(3,5)+"-"+trandate.substring(0,2);			
				if(debitamt.length()>0)
				{
					String temparr[]=debitamt.split(",");
					debitamt="";
					for(int i=0;i<temparr.length;i++)
					{
						debitamt=debitamt+temparr[i];
					}
					dbamt=Double.valueOf(debitamt);
	
					cramt=0;
				}
				else
				{
					dbamt=0;

					String temparr[]=creditamt.split(",");
					creditamt="";
					for(int i=0;i<temparr.length;i++)
					{
						creditamt=creditamt+temparr[i];
					}
					cramt=Double.valueOf(creditamt);
				}	

				if(balamt.length()>0)
				{
					String temparr[]=balamt.split(",");
					balamt="";
					for(int i=0;i<temparr.length;i++)
					{
						balamt=balamt+temparr[i];
					}
					balanceamt=Double.valueOf(balamt);
				}

				if(tranid.toUpperCase().indexOf("AA")==0 && particulars.toUpperCase().indexOf("FY")>=0)	
					status=10;
				else
					status=0;

                                System.out.println("insert into kgsg_n_ubi values("+max_entry_no+",'"+trandate+"','"+tranid+"','"+particulars+"',"+dbamt+","+cramt+","+balanceamt+","+status+")");
				st.executeUpdate("insert into kgsg_n_ubi values("+max_entry_no+",'"+trandate+"','"+tranid+"','"+particulars+"',"+dbamt+","+cramt+","+balanceamt+","+status+")");
				max_entry_no++;			
			}*/
		}
		catch(Exception ex)
		{
			System.out.println("error no. KGSG..."+ex);
			return false;
		}

		return true;
	}


	public boolean updateUBIBillOfKGSGCards(String data)
        {
		System.out.println("ok");
		System.out.println(data);
		try
		{

			int max_entry_no=1;
                        int flag=0;
                        double balancedb=0;
                        double balancefile=0;
                        double bal=0;
                        double debit=0;
                        double credit=0;
			ResultSet rs=st.executeQuery("select max(entry_no) from ubi_bill_of_kgsg_cards");
			if(rs.next())
			{
				max_entry_no=rs.getInt(1)+1;	
			}

                        String trandate="",tranid="",particulars="",debitamt="",creditamt="",balamt="";
			double dbamt=0,cramt=0,balanceamt=0;
			int status=0,paymentno=-1;
                        double totaldr=0,totalcr=0;
                        String indexString="";
                        String arr[]=data.split("\n");
                        //CODE TO CHECK MISSING RECORDS OR NOT IN SELECTED FILE
                        //-----------------------------------------------------
                        rs=st.executeQuery("select balanceamt from ubi_bill_of_kgsg_cards order by entry_no desc");
			if(rs.next())
			{
                            balancedb=rs.getDouble(1);

                        }
                        else
                        {
                            balancedb=0;
                        }
                        //System.out.println("balancedb= "+balancedb);
                        //System.out.println("arr.length= "+arr.length);
                        for(int r=0;r<arr.length;r++)
			{
                            //System.out.println("start............");
				trandate="";tranid="";particulars="";debitamt="";creditamt="";balamt="";
                                dbamt=0;cramt=0;balanceamt=0;

                                //System.out.println("arr[r]="+arr[r]+"arr length="+arr[r].length());
				trandate=arr[r].substring(1,arr[r].indexOf(" ",2)).trim();	//get tran date
                                //trandate=arr[r].substring(1,12).trim();	//get tran date
				//System.out.print("dt="+trandate);
				tranid=arr[r].substring(11,arr[r].indexOf(" ",19)).trim();	//get tran id
				//System.out.print("\tid="+tranid);
				//particulars=arr[r].substring(35,60).trim();
                                particulars=arr[r].substring(26,66).trim();//get particulars
				//System.out.println("\tpart="+particulars);
                                trandate=trandate.substring(6,10)+"-"+trandate.substring(3,5)+"-"+trandate.substring(0,2);
                                String qry="select tran_date,tran_id,particular from ubi_bill_of_kgsg_cards where tran_date='"+trandate+"'and tran_id='"+tranid+"'and particular='"+particulars+"'";
                                //System.out.println("qry="+qry);

                                rs1=st1.executeQuery(qry);
                                if(rs1.next()==false)
                                {
                                   /* System.out.println("tranid="+tranid+" is available");
                                }
                                else
                                {*/
                                    indexString=indexString+r+",";
                                    debitamt=arr[r].substring(arr[r].indexOf(" ",61),82).trim();	//get debit amt
                                    creditamt=arr[r].substring(arr[r].indexOf(" ",82),105).trim();			//get credit amt
                                    System.out.println("debitamt="+debitamt+" creditamt="+creditamt);
                                    balamt=arr[r].substring(arr[r].indexOf(" ",120),141).trim();	//get balance amt
                                    //System.out.println("balamt="+balamt);
                                    if(debitamt.length()>0)
                                    {
                                            String temparr[]=debitamt.split(",");
                                            debitamt="";
                                            for(int i=0;i<temparr.length;i++)
                                            {
                                                    debitamt=debitamt+temparr[i];
                                            }
                                            dbamt=Double.valueOf(debitamt);
                                            cramt=0;
                                    }
                                    else
                                    {
                                            dbamt=0;

                                            String temparr[]=creditamt.split(",");
                                            creditamt="";
                                            for(int i=0;i<temparr.length;i++)
                                            {
                                                    creditamt=creditamt+temparr[i];
                                            }
                                            cramt=Double.valueOf(creditamt);
                                    }

                                    totaldr=totaldr+dbamt;
                                    totalcr=totalcr+cramt;

                                    //System.out.println("total dr= "+totaldr+"      total cr="+totalcr);
                                    if(balamt.length()>0)
                                    {
                                            String temparr[]=balamt.split(",");
                                            balamt="";
                                            for(int i=0;i<temparr.length;i++)
                                            {
                                                    balamt=balamt+temparr[i];
                                            }
                                            balanceamt=Double.valueOf(balamt);
                                    }

                                    if(r==0)
                                    {
                                        if(balancedb==0)
                                        {
                                            balancedb=balanceamt-dbamt+cramt;
                                            System.out.println("balancedb=0  then"+balancedb);
                                        }
                                    }
                                }
                        }
                        System.out.println("balancedb="+balancedb+" totaldr="+totaldr+" totalcr="+totalcr+" (totaldr-totalcr)"+(totaldr-totalcr)+" balanceamt"+balanceamt);
                        System.out.println("leftside="+(balancedb+(totaldr-totalcr))+"\nRight side="+balanceamt);
                        //javax.swing.JOptionPane.showMessageDialog(null, "leftside="+(balancedb+(totaldr-totalcr))+"\nRight side="+balanceamt);
                        
                        //IF RECORD NOT MISSED IN FILE THEN
                        //---------------------------------
                        if((balancedb+(totaldr-totalcr))==balanceamt)
                        {
                            trandate="";tranid="";particulars="";debitamt="";creditamt="";balamt="";
                            dbamt=0;cramt=0;balanceamt=0;
                            status=0;paymentno=-1;
                            String indexArr[]=indexString.split(",");
                            //System.out.println(arr.length);
                            int r=0;
                            for(int idx=0;idx<indexArr.length;idx++)
                            {
                                r=Integer.parseInt(indexArr[idx]);
				trandate="";tranid="";particulars="";debitamt="";creditamt="";balamt="";

				trandate=arr[r].substring(1,arr[r].indexOf(" ",2)).trim();	//get tran date
                                //trandate=arr[r].substring(1,12).trim();	//get tran date
				//System.out.print("dt="+trandate);
				tranid=arr[r].substring(11,arr[r].indexOf(" ",19)).trim();	//get tran id
				//System.out.print("\tid="+tranid);
				//particulars=arr[r].substring(35,60).trim();
                                particulars=arr[r].substring(26,66).trim();//get particulars		//get particulars
				//System.out.println("part="+particulars);
                                trandate=trandate.substring(6,10)+"-"+trandate.substring(3,5)+"-"+trandate.substring(0,2);
                                debitamt=arr[r].substring(arr[r].indexOf(" ",61),82).trim();	//get debit amt
                                creditamt=arr[r].substring(arr[r].indexOf(" ",82),105).trim();		//get credit amt
                                balamt=arr[r].substring(arr[r].indexOf(" ",120),141).trim();	//get balance amt

                                if(debitamt.length()>0)
                                {
                                     String temparr[]=debitamt.split(",");
                                     debitamt="";
                                     for(int i=0;i<temparr.length;i++)
                                     {
                                          debitamt=debitamt+temparr[i];
                                     }
                                     dbamt=Double.valueOf(debitamt);
                                     cramt=0;
                                }
                                else
                                {
                                     dbamt=0;
                                     String temparr[]=creditamt.split(",");
                                     creditamt="";
                                     for(int i=0;i<temparr.length;i++)
                                     {
                                          creditamt=creditamt+temparr[i];
                                     }
                                     cramt=Double.valueOf(creditamt);
                                }

                                if(balamt.length()>0)
                                {
                                      String temparr[]=balamt.split(",");
                                      balamt="";
                                      for(int i=0;i<temparr.length;i++)
                                      {
                                           balamt=balamt+temparr[i];
                                      }
                                           balanceamt=Double.valueOf(balamt);
                                }

                                if(particulars.indexOf("bal")>=0 || particulars.indexOf("Tra")>=0 || particulars.indexOf("to")>=0 || particulars.indexOf(":")>=0)
                                status=10;
                                else
                                    status=0;

                                    
                                st.executeUpdate("insert into ubi_bill_of_kgsg_cards values("+max_entry_no+",'"+trandate+"','"+tranid+"','"+particulars+"',"+dbamt+","+cramt+","+balanceamt+","+status+","+paymentno+")");
                                max_entry_no++;
                                //}
                        }
                    }
                    else
                        {
                            return false;
                        }
		}
		catch(Exception ex)
		{
			System.out.println("error no. in ubi..."+ex);
			return false;
		}

		return true;
	}

        
	public String getSingleValue(String qry)
	{
		String data="";
		try
		{
			ResultSet rs=st.executeQuery(qry);
			if(rs.next())
			{
				data=rs.getString(1);
			}
		}
		catch(Exception ex)
		{
			System.out.println("error no. 2..."+ex);

		}
		return data;
	}

        public boolean ubi_account_statement(String data)
        {
		try
		{

			int max_entry_no=1;
			ResultSet rs=st.executeQuery("select max(entry_no) from ubi_account_statement");
			if(rs.next())
			{
				max_entry_no=rs.getInt(1)+1;
			}

			String trandate="",tranid="",particulars="",withdrawal="",Deposit="",balamt="",chk;
			double dbamt=0,cramt=0,balanceamt=0;
			int status=0;
                        int paymentno=1;
                        ResultSet rs1=st.executeQuery("select max(ubi_payment_no) from ubi_account_statement");
                                if(rs1.next())
                                {
                                        paymentno=rs1.getInt(1)+1;
                                }
			String arr[]=data.split("\n");
			for(int r=0;r<arr.length;r++)
			{
                            trandate=arr[r].substring(0, 10);

                            //System.out.println("date="+arr[r].substring(0, 10));
                            //System.out.println("date="+arr[r].substring(11, 49));
                            String str1=arr[r].substring(0, arr[r].indexOf("     "));
                            particulars=str1.trim();
                            //System.out.println("length="+str1.length()+"  arr.length-1 ="+(arr[r].length()-1));
                            String str2=arr[r].substring(arr[r].indexOf("     ")+1, arr[r].length()-2).trim();
                            System.out.println(str2+"length 2="+str2.length());
                            //System.out.println("length="+str.length);
                            if(str2.split("                  ").length==2)
                            {
                                String str[]=str2.split("                  ");
                                withdrawal=str[0].trim();
                                balamt=str[1].trim();
                                System.out.println("withdrawal = "+str[0].trim()+"                  length="+str.length+"   "+str[1].trim());
                            }
                            else if(str2.split("    ").length==2)
                            {
                                String str[]=str2.split("    ");
                                Deposit=str[0].trim();
                                balamt=str[1].trim();
                                System.out.println("Deposit = "+str[0].trim()+"    length="+str.length+"   "+str[1].trim());
                            }
				trandate=trandate.substring(6,10)+"-"+trandate.substring(3,5)+"-"+trandate.substring(0,2);
				if(withdrawal.length()>0)
				{
					String temparr[]=withdrawal.split(",");
					withdrawal="";
					for(int i=0;i<temparr.length;i++)
					{
						withdrawal=withdrawal+temparr[i];
					}
					dbamt=Double.valueOf(withdrawal);

					cramt=0;
				}
				else if(Deposit.length()>0)
				{
					dbamt=0;

					String temparr[]=Deposit.split(",");
					Deposit="";
					for(int i=0;i<temparr.length;i++)
					{
						Deposit=Deposit+temparr[i];
					}
					cramt=Double.valueOf(Deposit);
				}

				if(balamt.length()>0)
				{
					String temparr[]=balamt.split(",");
					balamt="";
					for(int i=0;i<temparr.length;i++)
					{
						balamt=balamt+temparr[i];
					}
					balanceamt=Double.valueOf(balamt);
				}

				if(tranid.toUpperCase().indexOf("AA")==0 && particulars.toUpperCase().indexOf("FY")>=0)
					status=10;
				else
					status=0;

                                String qry="select date,Deposit,withdrawal,balance from ubi_account_statement where date='"+trandate+"'and withdrawal='"+dbamt+"'and Deposit='"+cramt+"' and balance='"+balanceamt+"'";
                                System.out.println("qry="+qry);

                                rs1=st1.executeQuery(qry);
                                if(rs1.next()==false)
                                {
                                    System.out.println("insert into ubi_account_statement values("+max_entry_no+",'"+trandate+"','"+particulars+"',"+dbamt+","+cramt+","+balanceamt+","+status+","+paymentno+")");
                                    int slno=1;
                                    rs=st2.executeQuery("select max(sl_no) from ubi_account_statement");
                                    if(rs.next())
                                    {
                                         slno=rs.getInt(1)+1;
                                    }
                                    String KGSGto="";
                                    String date="2000-01-01";
                                    String txnId=null;
                                    st.executeUpdate("insert into ubi_account_statement values("+max_entry_no+",'"+trandate+"','"+particulars+"',"+dbamt+","+cramt+","+balanceamt+","+status+","+paymentno+","+slno+",'"+KGSGto+"','"+date+"','"+txnId+"')");
                                    max_entry_no++;paymentno++;
                                }
                                trandate="";tranid="";particulars="";withdrawal="";Deposit="";balamt="";
                                dbamt=0;cramt=0;balanceamt=0;
			}
		}
		catch(Exception ex)
		{
			System.out.println("error no. 2..."+ex);
			return false;
		}

		return true;
	}



        
        public int breakAmtUBI(int paymentno,double amt)
        {

            int flag=0,entryno=0;
            double regbal=amt,bal=0,dr=0,cr=0;
            String data="";
            try
		{
                        String qry="select entry_no,tran_debit_amt,tran_credit_amt from ubi_bill_of_kgsg_cards where ubi_payment_no="+(-1)+" and recon_status<>"+10+" order by entry_no asc";
                        System.out.println(qry);
			ResultSet rs=st.executeQuery(qry);
			while(rs.next())
			{
                            int eno=rs.getInt("entry_no");
                            if(flag==0)
                            {
                                entryno=eno;
                                flag=2;
                            }
                            dr=dr+rs.getDouble("tran_debit_amt");
                            cr=cr+rs.getDouble("tran_credit_amt");
                            bal=dr-cr;
                            System.out.println("register ballance="+regbal+"        ballance"+bal);
                            if(bal<=regbal)
                            {
                                System.out.println("ballance"+bal);
                            }
                            if(bal==regbal)
                            {
                                System.out.println("entry_no>"+entryno+"   entry_no<"+eno);
                                qry="update ubi_bill_of_kgsg_cards set recon_status=1, ubi_payment_no="+paymentno+" where entry_no>="+entryno+" and entry_no<="+eno+" and recon_status="+0+" and ubi_payment_no="+(-1)+" ";
                                System.out.println(qry);
                                st.executeUpdate(qry);
                                flag=1;
                                break;
                            }

			}
		}
		catch(Exception ex)
		{
			System.out.println("error in breakamt method..."+ex);
		}
            System.out.println(flag);
            return flag;
        }
















        class task1 extends Thread
        {
            int Paymentno=0;double amt=0;
            int flag=0;
            public task1(int payment,double amt1)
            {
                Paymentno=payment;
                amt=amt1;
            }

            public void run()
            {

                int entryno=0;
                int temp=0,item=0;
                double regbal=amt,bal=0,dr=0,cr=0;
                String data="";
                try
		{

                    //java.sql.Connection conn=null;
                    //java.sql.Statement st=conn.createStatement();
                    System.out.println("breaking process start...................\n");

                    String qry="select particular,tran_debit_amt,tran_credit_amt from ubi_bill_of_kgsg_cards where ubi_payment_no="+Paymentno+" and recon_status<>"+10+" and recon_status="+1+" order by entry_no desc";
                    //System.out.println(qry);
                    rsD=stD.executeQuery(qry);
                    String upart[]=null;String uparticular=null;double udr=0;double ucr=0;int entry=0;item=0;
                    while(rsD.next())
                    {
                      upart=rsD.getString("particular").split("/");
                      uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
                      udr=rsD.getDouble("tran_debit_amt");
                      ucr=rsD.getDouble("tran_credit_amt");
                      //int entry=rsD.getInt("entry_no");
                      qry="select entry_no from kgsg_n_ubi where tran_credit_amt="+udr+" and tran_debit_amt="+ucr+" and (particular like '"+uparticular+"%' ) and recon_status="+0+"";
                    //System.out.println(qry);
                    rs3=st3.executeQuery(qry);
                    if(rs3.next())
                    {
                        System.out.println("last record found.............................");
                        break;
                    }
                    else
                    {


                    if(temp==3)
                    {
                        javax.swing.JOptionPane.showMessageDialog(null,"!Sory there is mismatched of KGSG records.\nMay be sufficient records are not found in KGSG ");
                        item=1;
                        break;
                    }
                    temp++;
                        }

                    }


                    /*if(item!=1)
                    {
                        upart=null;uparticular=null;udr=0;ucr=0;entry=0;
                        qry="select particular,tran_debit_amt,tran_credit_amt,entry_no from ubi_bill_of_kgsg_cards where ubi_payment_no="+Paymentno+" and (recon_status<>"+10+" and recon_status="+1+") order by entry_no asc";
                        //System.out.println(qry);
                        rs1=st1.executeQuery(qry);
                        while(rs1.next())
                        {
                            upart=rs1.getString("particular").split("/");
                            uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
                            udr=rs1.getDouble("tran_debit_amt");
                            ucr=rs1.getDouble("tran_credit_amt");
                            entry=rs1.getInt("entry_no");
                            // System.out.println(uparticular);
                            qry="select entry_no from kgsg_n_ubi where recon_status="+0+" and (tran_credit_amt="+udr+" and tran_debit_amt="+ucr+" and (particular like '"+uparticular+"%' )) ";
                            //System.out.println(qry);
                            int en=0;
                            rs=st.executeQuery(qry);
                            if(rs.next())
                            {
                               en=rs.getInt(1);
                               //qry="update kgsg_n_ubi,ubi_bill_of_kgsg_cards set (kgsg_n_ubi.recon_status=2, kgsg_n_ubi.ubi_payment_no="+Paymentno+" ), ubi_bill_of_kgsg_cards.recon_status="+2+" where kgsg_n_ubi.entry_no="+en+" and ubi_bill_of_kgsg_cards.entry_no="+entry+"";//recon_status="+0+" and
                               qry="update kgsg_n_ubi set recon_status="+2+",ubi_payment_no="+Paymentno+" where entry_no="+en+"";//recon_status="+0+" and
                               //System.out.println(qry);
                               st2.executeUpdate(qry);
                               qry="update ubi_bill_of_kgsg_cards set recon_status="+2+" where entry_no="+entry+"";//recon_status="+1+"
                               //System.out.println(qry);
                               st2.executeUpdate(qry);
                               flag=1;
                               System.out.println(" in if when update performe...............");
                            }
                            else
                            {
                               qry="update ubi_bill_of_kgsg_cards set recon_status=3 where recon_status="+1+" and entry_no="+entry+"";
                               st2.executeUpdate(qry);
                                flag=1;
                                System.out.println(".............. in else when update performe...............");
                            }
                            upart=null;uparticular=null;udr=0;ucr=0;entry=0;
                        }
                    }*/
                    //start new logic
                    try
                    {
                        //Class.forName("com.mysql.jdbc.Driver").newInstance();
                        //Connection connection1= DriverManager.getConnection("jdbc:mysql://localhost/atmdatabase?user=kgsgatm&password=rnr");

                    if(item!=1)
                    {
                        
                        Statement stt1=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        Statement stt2=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ResultSet rset,rset1;
                        upart=null;uparticular=null;udr=0;ucr=0;entry=0;
                        qry="select * from ubi_bill_of_kgsg_cards where ubi_payment_no="+Paymentno+" and (recon_status<>"+10+" and recon_status="+1+") order by entry_no asc";
                        System.out.println("msg1:"+qry+"\n");
                        rset1=stt1.executeQuery(qry);
                        
                        while(rset1.next())
                        {
                            
                            upart=rset1.getString("particular").split("/");
                            uparticular=upart[0]+"/"+upart[1].substring(3, upart[1].length())+"/";
                            udr=rset1.getDouble("tran_debit_amt");
                            ucr=rset1.getDouble("tran_credit_amt");
                            entry=rset1.getInt("entry_no");
                            // System.out.println(uparticular);
                            qry="select * from kgsg_n_ubi where recon_status="+0+" and (tran_credit_amt="+udr+" and tran_debit_amt="+ucr+" and (particular like '"+uparticular+"%' )) ";
                            System.out.println("msg2:"+qry+"\n");
                            //int en=0;
                            rset=stt2.executeQuery(qry);
                            System.out.println("msg4: rs start"+"\n");
                            if(rset.next())
                            {
                                System.out.println("msg4: in the rs"+"\n");
                               //en=rs.getInt(1);
                               //qry="update kgsg_n_ubi,ubi_bill_of_kgsg_cards set (kgsg_n_ubi.recon_status=2, kgsg_n_ubi.ubi_payment_no="+Paymentno+" ), ubi_bill_of_kgsg_cards.recon_status="+2+" where kgsg_n_ubi.entry_no="+en+" and ubi_bill_of_kgsg_cards.entry_no="+entry+"";//recon_status="+0+" and
                               //qry="update kgsg_n_ubi set recon_status="+2+",ubi_payment_no="+Paymentno+" where entry_no="+en+"";//recon_status="+0+" and
                               //System.out.println(qry);
                               //st2.executeUpdate(qry);
                               System.out.println(" rset.updateInt start...............\n");
                               rset.updateInt("recon_status", 2);
                               System.out.println(" rset.updateInt end...............");
                               rset.updateInt("ubi_payment_no", Paymentno);
                               System.out.println(" rset.updateInt End end...............");
                               rset.updateRow();
                               //qry="update ubi_bill_of_kgsg_cards set recon_status="+2+" where entry_no="+entry+"";//recon_status="+1+"
                               rset1.updateInt("recon_status", 2);
                               rset1.updateRow();
                               //System.out.println(qry);
                               //st2.executeUpdate(qry);
                               flag=1;
                               System.out.println(" in if when update performe...............");
                            }
                            else
                            {
                               //qry="update ubi_bill_of_kgsg_cards set recon_status=3 where recon_status="+1+" and entry_no="+entry+"";
                               //st2.executeUpdate(qry);
                                rset1.updateInt("recon_status", 3);
                                rset1.updateRow();
                                flag=1;
                                System.out.println(".............. in else when update performe...............");
                            }
                            upart=null;uparticular=null;udr=0;ucr=0;entry=0;
                        }
                    }
                    }
                    catch(Exception ex123)
                    {
                        System.out.println("Error at time of reconsile...."+ex123);
                    }
                    //end of new logic
            
                }
                catch(Exception ex)
                {
                     System.out.println("error..."+ex);
                }

            }
        }

        
        public int breakAmtKGSG(int paymentno,double amt)
        {
            task1 t1=new task1(paymentno,amt);
            t1.start();
            while(true)
            {
                if(t1.isAlive()==false)
                {
                    break;
                }
            }
            int flag1=t1.flag;
            System.out.println("flag........................= "+flag1);
            return flag1;
        }


    public String[][] getInformationDD(String query,int c)
    {
        String arr[][]=null;
        try
        {
            //java.sql.Connection conn=selectedFinancialYear(finYear);
            //java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery(query);
            System.out.println(query);
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
                    arr[row][col]=rs.getString(col+1);
                }
                row++;
            }
            return arr;
        }
        catch(Exception ex)
        {
            System.out.println("Error...233..."+ex);
        }
        return arr;
    }

    public String[] getResultSetAs_1D_Array(String query)
	{
		String sendList[]=null;

        try
        {
        	System.out.println(""+query);
            rs=st.executeQuery(query);
            System.out.println(""+query);
            int col=0;
            while(rs.next())
            	col++;
        	sendList=new String[col];
            int index=0;
            rs=st.executeQuery(query);
            while(rs.next())
            {
                sendList[index]=rs.getString(1);
                index++;
            }
          //connection.close();
            return sendList;
        }
        catch(Exception ex)
        {
            System.out.println("Error at getResultSetAs_1D_Array method..At Server..."+ex);
            return sendList;
        }
	}



    public boolean saveInformation(String query)
    {

        try
        {
            System.out.println(""+query);
            st.executeUpdate(query);
            return true;
        }
        catch(Exception ex)
        {
            System.out.println("Error...233.skm R.."+ex);
        }
        return false;
    }
        

	public static void main(String args[])
        {
                try
                {
                        serverATM server1=new serverATM();
                        Naming.rebind("atmMethods",server1);
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of rmi registry..."+x);
                }
        }
        public java.sql.Connection selectedFinancialYear(String fin)
        {
        	java.sql.Connection DBCon=null;
        //	boolean bn=false;
        	
        	try
        	{ 
        
        	
        		System.out.println("a");     	
	        	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                System.out.println("b");
                // connection= DriverManager.getConnection("jdbc:mysql://localhost/railway"+fin+"?user=RailwaysCashOffice&password=RCO");
                DBCon=java.sql.DriverManager.getConnection("jdbc:mysql://localhost/railway"+fin+"?user=cashier&password=rnr");
           //     System.out.println("jdbc:mysql://localhost/railway"+fin+"?user=cashier&password=rnr");
           	//	st = DBCon.createStatement(); 
           	//	st1 = DBCon.createStatement();
           		finYear=fin; 
           		System.out.println("c");
         
         
           	
           	    return DBCon;
         
         
                	
           	}
            catch(Exception x)
            {
                System.out.println("Error related to database connectivity90..."+x);
            
         
            }
           
           return DBCon;
         
          
        }
        public boolean selectFinancialYear(String fin)
        {
        	
        java.sql.Connection DBCon=null;
        	
        	try
        	{ 
        
        	
        		System.out.println("a");     	
	        	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
                System.out.println("b");
                // connection= DriverManager.getConnection("jdbc:mysql://localhost/railway"+fin+"?user=RailwaysCashOffice&password=RCO");
                DBCon=java.sql.DriverManager.getConnection("jdbc:mysql://localhost/railway"+fin+"?user=cashier&password=rnr");
             //   System.out.println("jdbc:mysql://localhost/railway"+fin+"?user=cashier&password=rnr");
           	//	st = DBCon.createStatement(); 
           	//	st1 = DBCon.createStatement();
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


     /*   public boolean createSection(String divisioncode,String sectioncode,String sectionname)
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
								//////////////////////close here*

                                return(true);
                        }                     
                }
                catch(Exception x)
                {
                        System.out.println("Error at the time of section creation......"+x);
                }
                return true;
        }*/

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
    public boolean isLong(String text)
    {
        try
        {
            long n=Long.parseLong(text); 
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    public boolean isExist(String query,String fyr)
    {
    	
        try
        {
        	finYear=fyr; 
            java.sql.Connection conn=selectedFinancialYear(finYear);
            java.sql.Statement st=conn.createStatement();
            System.out.println(""+query);
            java.sql.ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                connection.close();
                return true;
        
            }
            else
            {
                connection.close();
        
                return false;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error...233..."+ex);
        }
        return false;
    }
    public String getSigetngleValue(String qry,String fyr)
    {
        String data="";
        try
        {
        	finYear=fyr;
            java.sql.Connection conn=selectedFinancialYear(finYear);
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery(qry);
              System.out.println(""+qry);
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
    
     public boolean saveInformation(String query,String fyr)
    {
    	
        try
        {
        	finYear=fyr;
            java.sql.Connection conn=selectedFinancialYear(finYear);
            java.sql.Statement st=conn.createStatement();
            System.out.println(""+query);
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
    
    public String[][] getInformationDD(String query,int c,String fyr)
    {
        String arr[][]=null;
        try
        {
        	finYear=fyr;
            java.sql.Connection conn=selectedFinancialYear(finYear);
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery(query);
            System.out.println(query);
            
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
    
    public int getMaxValue(String query,String fyr)
	{
		int maxValue=0;
	//	java.sql.Connection connection=null;
        try
        {
        /*	System.out.println(""+query);
            connection=makeConnection();
            java.sql.Statement st=connection.createStatement();
            java.sql.ResultSet rs=st.executeQuery(query);*/
            finYear=fyr;
            java.sql.Connection conn=selectedFinancialYear(finYear);
            java.sql.Statement st=conn.createStatement();
            java.sql.ResultSet rs;
            rs=st.executeQuery(query);
            System.out.println(""+query);
            
            
            if(rs.next())
            {
                maxValue=rs.getInt(1);
            }
            else
            	maxValue=0;
            System.out.println("maxValue="+maxValue);
           // closeConnection(connection);
          conn.close();
            return maxValue;
        }
        catch(Exception ex)
        {
            System.out.println("Error at getMaxValue method......"+ex);
            //closeConnection(connection);
        //    conn.close();
            return -1;
        } 
	}
/*	public int getCountValue(String query)
	{
		int countValue=0;
		java.sql.Connection conn=null;
                 
        try
        {
        	System.out.println(""+query);
       //    connection=makeConnection();
           
         //   java.sql.ResultSet rs=st.executeQuery(query);
             finYear=fyr;
            conn=selectedFinancialYear(finYear);
            java.sql.Statement st=conn.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY);
            java.sql.ResultSet rs=st.executeQuery(query);
          //  java.sql.Statement st=conn.createStatement();
         //   java.sql.ResultSet rs;
         //   rs=st.executeQuery(query);
            
            rs.last();
            countValue=rs.getRow();
            System.out.println("Count="+countValue);
       //     closeConnection(connection);
        conn.close();
            return countValue;
        }
        catch(Exception ex)
        {
            System.out.println("Error at getCountValue method......"+ex);
           // closeConnection(connection);
          //  conn.close();
            return -1;
        } 
	}*/
	
	
	
	
	public String[] getResultSetAs_1D_Array(String query,String fyr)
	{
		String sendList[]=null;
		java.sql.Connection connection=null;
        try
        {
        	System.out.println(""+query);
        	 finYear=fyr;
        	connection=selectedFinancialYear(finYear);
            java.sql.Statement st=connection.createStatement();//java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,java.sql.ResultSet.CONCUR_READ_ONLY
            java.sql.ResultSet rs=st.executeQuery(query);
            
            /*java.sql.Connection conn=selectedFinancialYear(finYear);
            java.sql.Statement st=conn.createStatement();*/
           // java.sql.ResultSet rs;
            rs=st.executeQuery(query);
            System.out.println(""+query);
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
          //  closeConnection(connection);
          connection.close();
            return sendList;
        }
        catch(Exception ex)
        {
            System.out.println("Error at getResultSetAs_1D_Array method..At Server..."+ex);
           // closeConnection(connection);
        //    conn.close();
            return sendList;
        }
	}
    
    
    
    
        /*public boolean createStation(String divisioncode,String sectioncode,String stationcode,String stationname,String lodgment,String bankname,String branchname,String branchcode)
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
								////////////close here

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

/*        public boolean executeSQLUpdateCommand(String url)
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
        }*/
        


        

       /* public int countRecordsInDateRange(String sql,int y1,int m1,int d1,int y2,int m2,int d2)
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
		}*/		


}