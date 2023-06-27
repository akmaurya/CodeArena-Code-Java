import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.Date;
import javax.swing.table.*;
import java.util.*;
import java.math.*;
import javax.print.PrintService;
import java.awt.print.*;
import javax.print.attribute.*;
import java.awt.geom.*;
import java.io.*;
import java.awt.font.*;

class PurchaseDosPrint extends JFrame
{
	JInternalFrame itemsFrame;
	JDesktopPane desk;
	Container itemsC;
   	JPanel itempan;
	JTable itemgrid;
	DefaultTableModel itemdtm;
	JScrollPane itemscr;
	JTextField vouno;
	int noOfCopies=1;	
	boolean printStockNo=false;		
	PrintService printerName;
	JLabel dtlab;
	int currentpg,totalpg,voucherno;
	boolean firsttime=false;
	boolean complete=false;
	int currentrec=0;
	boolean cmp1=false;
	boolean cmp2[]=new boolean[33];
	boolean cmp3=false;
	boolean cmp4=false;
	boolean cmp5=false;
	boolean cmp6=false;
	int startno=0,endno=0;
	BigDecimal totalamt=new BigDecimal("0.00");

	public PurchaseDosPrint(JDesktopPane desk)	//,int voucherno,int startno,int endno,int currentpg,int totalpg,boolean printStockNo,int noOfCopies)
	{
		printbill pbill=new printbill();
		
		/*itemsFrame=new JInternalFrame("L i s t  O f  P u r c h a s e d  I t e m s",false,false,false,false);
   		itemsC=itemsFrame.getContentPane();
        		
	   	itemsC.setLayout(null);		
	   	itemsC.setBackground(new Color(225,225,225));
        
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (ds.width-910)/2;
		int y = (ds.height-300)/2;
    	itemsFrame.reshape(600,35,410,675);
  		desk.add(itemsFrame);

		
		//CODING RELATED TO 'ITEMSFRAME'
		//START
		itempan=new JPanel();
		itempan.setLayout(new BorderLayout());
   		String[] itemhead = {"No(s).","Particular(s)","Qty.","P-Rate","Purchase Amt","Type"};
   		itemdtm = new DefaultTableModel(itemhead,0);
		itemgrid = new JTable();
		itemgrid.setModel(itemdtm);
		itemscr = new JScrollPane(itemgrid,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		itempan.add(itemscr,"Center");
		itempan.setBounds(0,395,400,130);
		itemsC.add(itempan);
				
		vouno=new JTextField(""+voucherno);
		dtlab=new JLabel();			
		checkVoucherExistance();

										if(this.printStockNo==true)
										{
											this.totalpg=itemgrid.getRowCount()/5;
											int rem=itemgrid.getRowCount()%5;
											if(rem>0)
												this.totalpg++;
										}
										else
										{
											this.totalpg=itemgrid.getRowCount()/11;
											int rem=itemgrid.getRowCount()%11;
											if(rem>0)
												this.totalpg++;
										}		
										this.currentpg=0;	
		                                //PrinterJob printJob=PrinterJob.getPrinterJob();
										//printJob.setPrintService(printerName);
					
										//firsttime=false;
										for(int i=1;i<=this.totalpg;i++)	
                            			{
                            				//System.out.println("i="+i);
                            				if(this.printStockNo==true)
                            				{
                            					this.startno=(i-1)*5;
                            					this.endno=this.startno+5;
                            				}
                            				else
                            				{
                            					this.startno=(i-1)*11;
                            					this.endno=this.startno+11;
                            				}	
                            				if(this.endno>(itemgrid.getRowCount()-1))
                            					this.endno=itemgrid.getRowCount();
                            				this.currentpg++;	
                            				
                            				//firsttime=false;
											//printbill pobj=new printbill();	
											System.out.println("calling dos based print class...");
											//PurchaseDosPrint printframe=new PurchaseDosPrint(desk,range1,startno,endno,currentpg,totalpg,printStockNo);
											printbill pbill=new printbill();
											System.out.println("Called print class.");
                            				//printJob.print();
                            			}	
		//printbill pbill=new printbill();
		//itemsFrame.show();		
		*/
	}


	/*private void checkVoucherExistance()
	{
		try
		{
			System.out.println("inside checkVoucherExistance()");
			//DatabaseFile dbfile=new DatabaseFile();
			//Connection con=dbfile.connectDatabase();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Connection con=DriverManager.getConnection("jdbc:odbc:odsn","system","zed");
			Statement st=Purchase.conWithOra.createStatement();
			Statement st1=Purchase.conWithOra.createStatement();
			ResultSet rs1;
			String start="",end="";
			ResultSet rs=st.executeQuery("select sum(qty),particular,prate,ptype from purchaseDetails where purchase_no="+Integer.parseInt(vouno.getText())+" group by particular,prate,ptype");
			while(rs.next())
			{
				//System.out.println("1...");
				//voucherExist=true;
				String arr[]=new String[6];
				arr[0]=new String("");
				arr[1]=new String(rs.getString("particular"));
				//System.out.println("1...");
						
				arr[2]=new String(""+rs.getInt(1));
				//System.out.println("2..."+arr[2]+";");
						
				arr[3]=new String(rs.getString("prate").trim());
				//System.out.println("3..."+arr[3]+";");
				arr[4]=new String(""+( (new BigDecimal(arr[2]) ).multiply(new BigDecimal(arr[3]) ) ).setScale(2,5));
				//System.out.println("31..."+arr[4]);
				arr[5]=new String(rs.getString("ptype").trim());
				//System.out.println("32..."+arr[5]);
				rs1=st1.executeQuery("select min(stock_no),max(stock_no) from purchaseDetails where purchase_no="+Integer.parseInt(vouno.getText())+" and particular='"+arr[1]+"' and prate='"+arr[3]+"' and ptype='"+arr[5]+"'");
				//System.out.println("33...");
						
				if(rs1.next())
				{
					start=rs1.getString(1).trim();
					end=rs1.getString(2).trim();
					if(start.equals(end))
						arr[0]=start;
					else
						arr[0]=start+"-"+end;	
				}
				//System.out.println("4...");
				//Search its
				 //suitable position
				 //to add.
				 //
				int stno; 
				int r=itemgrid.getRowCount();
				for(r=0;r<itemgrid.getRowCount();r++)
				{
				 	String temp=""+itemgrid.getValueAt(r,0);				 	
				 	if(temp.indexOf('-')>0)
				 		stno=Integer.parseInt(temp.substring(0,temp.indexOf('-')));
				 	else
				 		stno=Integer.parseInt(temp);	
				 	if(stno>Integer.parseInt(start))
				 		break;	
				}
				itemdtm.insertRow(r,arr);
				//System.out.println("5...");
						
			}			
			//System.out.println("exit from checkVoucherExistance()");
			//conWithOra.close();			

		}
		catch(Exception x)
		{
			System.out.println("error 3456..." +x);
		}
	}
	*/

	
		
	
		//dos based printing
        class printbill extends JFrame 
        {
                public printbill()
                {
                        try
                        {
                                String space="";
                                String temp="";
                                int rep=0;
                                System.out.println("Start printing");
                                FileOutputStream fos=new FileOutputStream("files\\purchase"+voucherno+".in");//LPT1");	//
                                PrintWriter pw=new PrintWriter(fos);
                                System.out.println("Start1 ");

                                int countLine=1;
                             
			        		    String firmname="ROUGH ESTIMATE";
        					    String firmadd="";
								String firmadd1="";
								/*Fetch selected 
								 *company name
								 */        					    
								FinDatabaseFile dbfile1=new FinDatabaseFile();
								Connection con1=dbfile1.connectDatabase();
								Statement st=con1.createStatement();								
								ResultSet rs=st.executeQuery("select * from companyInfo where selected='yes'");								
								if(rs.next())
								{
									firmname=rs.getString("name");
									firmadd=rs.getString("address1");
									firmadd1=rs.getString("address2");
        					    }
        					    con1.close();
        					    
        					    int l=firmname.length();
        					    space="";
        					    for(int i=1;i<=(42-l)/2;i++)	{space=space+" ";}        					    
                                pw.println(space+firmname);
                                
        					    l=firmadd.length();
        					    space="";
        					    for(int i=1;i<=(42-l)/2;i++)	{space=space+" ";}        					    
                                pw.println(space+firmadd);


                                //pw.println("");
                             	try
                             	{
                             		l=firmadd1.trim().length();
                             	
        					    	space="";
        					    	for(int i=1;i<=(42-l)/2;i++)	{space=space+" ";}        					    
                                	pw.println(space+firmadd1);
									pw.println("");
                             	}
                             	catch(Exception x)
                             	{
                             		System.out.println("Error...no problem..."+x);
                             		pw.println("");
                             		pw.println("");
                             	}
                             	
                                temp="Purchase Voucher";
        					    l=temp.length();
        					    space="";
        					    for(int i=1;i<=(42-l)/2;i++)	{space=space+" ";}        					    
								pw.println(space+temp);

                                System.out.println("Start2 ");
                                pw.println("");
								
								temp=" Purja No. "+vouno.getText();
								pw.print(temp);
								

					 			//DatabaseFile dbfile=new DatabaseFile();
								//Connection con=dbfile.connectDatabase();
								//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								//Connection con=DriverManager.getConnection("jdbc:odbc:odsn","system","zed");
								st=Purchase.conWithOra.createStatement();
								boolean rsnext=false;
                                System.out.println("Start3 ");
								rs=st.executeQuery("select * from pur_karigar_details where purchase_no="+Integer.parseInt(vouno.getText()));
								if(rs.next())
								{		
									rsnext=true;			
									String tempdt=rs.getString("purdate").trim();
									tempdt=tempdt.substring(8,10)+"-"+tempdt.substring(5,7)+"-"+tempdt.substring(0,4);
									l=temp.length()+5+tempdt.length();
	        					    space="";
    	    					    for(int i=1;i<=(42-l);i++)	{space=space+" ";}        					    
									pw.println(space+"Date "+tempdt);
        			    		}	
                                System.out.println("Start4 ");

        					    space="";
   	    					    for(int i=1;i<=42;i++)	{space=space+"-";}        					    
                                pw.println(space);
								
								if(rsnext)
								{
									temp=rs.getString("party_type").trim();
									if(temp.equals("KARIGAR"))
									{
										temp=rs.getString("karigar_nm").trim();
									}
									temp=" To, "+temp;
									pw.println(temp);
									
									temp=rs.getString("other_info").trim();
									if(!temp.equals("na"))
			            			{
										temp="     "+temp;
										pw.println(temp);
									}
									else
									{
										pw.println();
									}
								}

        					    space="";
   	    					    for(int i=1;i<=42;i++)	{space=space+"-";}        					    
                                pw.println(space);

								temp="Sr  Description    Qty    Rate    Amount";
                                pw.println(temp);
                                
                                pw.println(space);
                                
								
                                
                                countLine=0;
                                String type="";
                                int totalpcs=0;

									if(currentpg>1)
									{
										countLine++;
										temp="Continue...";	
										pw.print(temp);
										l=temp.length();
										//totalamt=totalamt.add(Purchase.lasttotalamt);

										temp=""+(Purchase.lasttotalamt).setScale(2,5);	//continue amount
										l=l+temp.length();
		        					    space="";
    		    					    for(int i=1;i<=(42-l);i++)	{space=space+" ";}        					    
            		                    pw.println(space+temp);	//4 char										
									}							
								System.out.println("start No:"+startno);
								System.out.println("end No:"+endno);
								for(int rn=startno;rn<endno;rn++)
								{														
									temp=""+ (rn+1) +" ";
									l=temp.length();
	        					    space="";
    	    					    for(int i=1;i<=(4-l);i++)	{space=space+" ";}        					    
            	                    pw.print(space+temp);	//4 char
        				    
									temp=" "+itemgrid.getValueAt(rn,1);	//item name
            	                    pw.print(temp.trim());	//15 char
            	                    l=4+temp.length();
        				    
       			 				    Statement st1=Purchase.conWithOra.createStatement();
        						    ResultSet rs1=st1.executeQuery("select * from itemlist where itemnm='"+temp.trim()+"'");
        							if(rs1.next())
        				    		{
		        				    	type=rs1.getString("itemType").trim();
        						    }
							
									temp=""+itemgrid.getValueAt(rn,2);	//quantity
									totalpcs+=Integer.parseInt(temp);
									temp=temp+" "+type;
									l=l+temp.length();	
	        					    space="";
    	    					    for(int i=1;i<=(24-l);i++)	{space=space+" ";}        					    
									pw.print(space+temp);		//9 char
																
									temp=""+itemgrid.getValueAt(rn,3);	//rate
									l=temp.length();
	        					    space="";
    	    					    for(int i=1;i<=(8-l);i++)	{space=space+" ";}        					    
									pw.print(space+temp);		//9 char
									
									temp=""+itemgrid.getValueAt(rn,4);	//amount
									temp=""+(new BigDecimal(temp.trim())).setScale(2,5);
		        				    //g2.drawString(""+(new BigDecimal(temp)).setScale(2,5),290-fm.stringWidth(temp),row);
									l=temp.length();
	        					    space="";
    	    					    for(int i=1;i<=(11-l);i++)	{space=space+" ";}        					    
        				    		pw.println(space+temp);		//11 char
        				    		
		        				    totalamt=totalamt.add(new BigDecimal(temp));

									if(printStockNo==true)
									{
										temp="     "+itemgrid.getValueAt(rn,0);	//stock no.       				    									
										pw.println(temp);
										countLine++;
									}
									countLine++;
								}

								String temp1="0";								
								if(currentpg==totalpg)
								{
									rs=st.executeQuery("select * from pur_discount where purchase_no="+Integer.parseInt(vouno.getText()));
									if(rs.next())
									{			
										if(endno>1)		
										{
		        						    space="";
    			    					    for(int i=1;i<=(18);i++)	{space=space+" ";}        					    
    			    					    temp=space;
			        					    space="";
	    		    					    for(int i=1;i<=(24);i++)	{space=space+"-";}        					    
											pw.println(temp+space);
											countLine++;
										
											temp=""+totalamt.setScale(2,5);							
											l=temp.length();
	    	    						    space="";
    	    							    for(int i=1;i<=(42-l);i++)	{space=space+" ";}										
    	    							    pw.println(space+temp);
    	    							    countLine++;
										}
										String percent=rs.getString("dis_per").trim();
										if(!percent.equals("0") && !percent.equals("0.00"))
										{
											temp="Less      "+percent+"%";	//discount percentage
										l=temp.length();
    	    					    	space="";
   	    							    for(int i=1;i<=(23-l);i++)	{space=space+" ";}										
   										pw.print(space+temp);   									
   										l=l+space.length();
   												           				            				    
										temp1=""+rs.getString("dis_amt").trim();	//discount in Rs.
										temp1=""+(new BigDecimal(temp1)).setScale(2,5);
										l=l+temp1.length();
    		    					    space="";
   		    						    for(int i=1;i<=(41-l);i++)	{space=space+" ";}
	   									pw.println(space+"-"+temp1);																			
   										countLine++;
   										}
									}
									else
										temp1="0";
								}

								while(countLine<=13)
								{
									pw.println();
									countLine++;
								}

        					    space="";
   	    					    for(int i=1;i<=42;i++)	{space=space+"-";}        					    
                                pw.println(space);
					
								/*temp="          Total      "+totalpcs+" "+"Pcs.";
								pw.print(temp);
								l=temp.length();*/
								temp="       Total";//      "+totalpcs+" "+"Pcs.";
								pw.print(temp);
								l=temp.length();

								System.out.println("l="+l);
								temp=""+totalpcs+" "+"Pcs";
								l=l+temp.length();
        					    space="";
   	    					    for(int i=1;i<=(23-l);i++)	{space=space+" ";}        					    
								pw.print(space+temp);
								l=l+space.length();
				System.out.println("l="+l+";"+totalamt);
				
								Purchase.lasttotalamt=totalamt;
								temp=""+totalamt.subtract(new BigDecimal(temp1)).setScale(2,5);
System.out.println("l="+l);								
								l=l+temp.length();
        					    space="";
   	    					    for(int i=1;i<=(42-l);i++)	{space=space+" ";}        					    
								pw.println(space+temp);
System.out.println("l="+l);								
        					    space="";
   	    					    for(int i=1;i<=42;i++)	{space=space+"-";}        					    
                                pw.println(space);
System.out.println("l="+l);
                               /*Code to display 
                                 *narration.
                                 */
                                 temp="";
                                 pw.println(temp);
						
					    		temp=" ("+currentpg+"/"+totalpg+")";
								pw.print(temp);
								l=temp.length();

        					    space="";
        					    temp="For, "+firmname;
        					    l=l+temp.length();
   	    					    for(int i=1;i<=(42-l);i++)	{space=space+" ";}        					    								
								pw.println(space+temp);

								pw.println("");
								pw.println("");
								pw.println("");
								pw.println("");
								//pw.println("");

                                 System.out.println("Start5 ");
		
                                System.out.println("Start6 ");
                                pw.close();
                                System.out.println("Start7 ");
                                
                                fos.close();
                                //con.close();
                                System.out.println("End printing");
                        }
                        catch(Exception x)
                        {
                                System.out.println("Error 929393...."+x);
                        }
                        
                }
        }
        //end of printing
	
	
}
