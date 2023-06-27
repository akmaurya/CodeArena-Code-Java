import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
import java.util.Calendar;
import java.util.*;
import java.util.Date;
import javax.swing.tree.*;
import java.text.*;
import java.util.zip.*;

import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;

import javax.swing.table.*;
import java.util.Vector.*;
import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.math.*;
import com.sun.java.swing.plaf.motif.*;
import javax.swing.plaf.metal.*;
//import files related to language conversion
import javax.swing.text.*;
import com.sun.java.swing.plaf.motif.*;
import com.sun.java.swing.plaf.windows.*;


public class DeskTop extends JFrame implements ActionListener,WindowListener
{
	JDesktopPane desk;
	Container con;
  	JMenuBar menubar;
   	JMenu transaction,sale,master,reports,account,challan,challantoinvoice; 
	JMenuItem categoryMaster,itemMaster,partyMaster;
	JMenuItem saleSale,purPurchase,purExit,challanWS,challanRetail;
	JMenuItem repoShowClosing,repoPartyBal,repoCloseMetalCatWise,repoCloseMetalItemWise,repoTrading,repoTrading1,repoProfit,repoKharcha,reminder,reminder_R;
	JMenuItem acMakeLadger,acVoucherEntry,report_remloan,report_kundali;
	JMenuItem challan2invoiceWS,challan2invoiceRetail;
	Dimension sd;
	JToolBar toolbar;
	
	public DeskTop()
	{
   		setTitle("J w e l l a r y   V e r 1 . 3                                                       Z e d   S o f t w a r e   P v t.   L t d.");
   		setIconImage(getToolkit().getImage("LOGO.gif"));       		
		desk=new JDesktopPane();
 	    setContentPane(desk);
		con=getContentPane();
   		con.setLayout(null);
   		menuCreation();
   	}

        	public void menuCreation()
        	{
                //--------------------
                //'menubar' creation
                //--------------------
                Dimension sd=Toolkit.getDefaultToolkit().getScreenSize();
                menubar=new JMenuBar();
                menubar.setBounds(0,0,sd.width+2,25);
                menubar.setBorder(new BevelBorder(BevelBorder.RAISED));                
                con.add(menubar);
                
                JLabel bgImage=new JLabel(new ImageIcon("background2.jpg"));
                bgImage.setBounds(0,25,sd.width,sd.height);
                con.add(bgImage);

				master=new JMenu("MASTER          ");
				transaction=new JMenu("TRANSACTION          ");
				sale=new JMenu("SALE          ");
				reports=new JMenu("REPORT          ");
				account=new JMenu("ACCOUNT          ");
				challan=new JMenu("Make Challan");
				challantoinvoice=new JMenu("Convert # Challan To Invoice");
				transaction.setMnemonic('t');
                sale.setMnemonic('S');
                master.setMnemonic('M');
                reports.setMnemonic('r');
                account.setMnemonic('a');
                challan.setMnemonic('c');
                challantoinvoice.setMnemonic('i');
                menubar.add(transaction);
                //menubar.add(sale);
                menubar.add(master);
                menubar.add(reports);
                //menubar.add(account);
                //master.setFont(new Font("Arial",Font.BOLD,13));
                //acMakeLadger,acVouvherEntry
				categoryMaster= new JMenuItem("New Category");
				itemMaster= new JMenuItem("New Item");
				partyMaster= new JMenuItem("Create Party");
				purPurchase= new JMenuItem("Purchase Items");
				purExit= new JMenuItem("Exit");
				challanWS= new JMenuItem("Wholesale");
				challanRetail= new JMenuItem("Retail");
				challan2invoiceWS= new JMenuItem("Wholesale");
				challan2invoiceWS= new JMenuItem("Wholesale");
				challan2invoiceRetail= new JMenuItem("Retail");
				repoShowClosing= new JMenuItem("Show Rokar");
				repoPartyBal= new JMenuItem("Party's Current Balance");
				repoCloseMetalCatWise=new JMenuItem("Show Closing Of Metal:Category Wise");
				repoCloseMetalItemWise=new JMenuItem("Show Closing Of Metal:Item Wise");
				repoTrading=new JMenuItem("Show Trading Report");
				repoTrading1=new JMenuItem("Show Trading Report Client Wise");
				repoProfit=new JMenuItem("Show Profit & loss Report");
				acMakeLadger=new JMenuItem("Create Ledger");
				acVoucherEntry=new JMenuItem("Kharcha");
				reminder_R=new JMenuItem("Reminder Person");
				reminder=new JMenuItem("Reminder");
				repoKharcha=new JMenuItem("Show Kharcha Adjustment");
				report_remloan=new JMenuItem("Show Debtor");
				report_kundali=new JMenuItem("Lekha Jokha");
				
				categoryMaster.setMnemonic('c');
                itemMaster.setMnemonic('i');
                partyMaster.setMnemonic('p');
                purPurchase.setMnemonic('p');
                purExit.setMnemonic('x');
               	challanWS.setMnemonic('w');
                challanRetail.setMnemonic('r');
               	challan2invoiceWS.setMnemonic('w');
                challan2invoiceRetail.setMnemonic('r');
                repoShowClosing.setMnemonic('r');
                repoProfit.setMnemonic('r');
                repoPartyBal.setMnemonic('p');
                repoCloseMetalCatWise.setMnemonic('c');
                report_remloan.setMnemonic('c');
                repoCloseMetalItemWise.setMnemonic('i');
                acMakeLadger.setMnemonic('c');
                acVoucherEntry.setMnemonic('k');
                reminder.setMnemonic('r');
                repoKharcha.setMnemonic('k');
                report_kundali.setMnemonic('l');
                
                //master.add(categoryMaster);
                master.add(itemMaster);
                master.add(partyMaster);
                master.add(reminder); 
                transaction.add(challan);
                	challan.add(challanWS);
                	challan.add(challanRetail);
                transaction.add(challantoinvoice);
                	challantoinvoice.add(challan2invoiceWS);
                	challantoinvoice.add(challan2invoiceRetail);
                transaction.addSeparator();
                transaction.add(purPurchase);
                
                
                transaction.addSeparator();
                transaction.add(acVoucherEntry);                
                               
                transaction.addSeparator();
                transaction.add(purExit);                
                reports.add(repoShowClosing);
                reports.addSeparator();
                reports.add(repoPartyBal);
                reports.addSeparator();
                reports.add(repoCloseMetalCatWise);
                reports.add(repoCloseMetalItemWise);
                reports.add(repoTrading);
                reports.add(repoTrading1);
                reports.add(repoProfit);
                reports.add(repoKharcha);
                reports.add(reminder_R);
                reports.add(report_remloan);
                reports.add(report_kundali);
                
                //account.add(acMakeLadger);
                //account.add(acVoucherEntry);
                categoryMaster.addActionListener(this);
				itemMaster.addActionListener(this);
				partyMaster.addActionListener(this);
				purPurchase.addActionListener(this);
				purExit.addActionListener(this);
				challanWS.addActionListener(this);
				challanRetail.addActionListener(this);
				challan2invoiceWS.addActionListener(this);
				challan2invoiceRetail.addActionListener(this);
				repoShowClosing.addActionListener(this);
				repoPartyBal.addActionListener(this);
				repoCloseMetalCatWise.addActionListener(this);
				report_remloan.addActionListener(this);
				repoProfit.addActionListener(this);
				repoCloseMetalItemWise.addActionListener(this);
				acMakeLadger.addActionListener(this);
				acVoucherEntry.addActionListener(this);
				reminder.addActionListener(this);
				reminder_R.addActionListener(this);
				repoTrading.addActionListener(this);
				repoTrading1.addActionListener(this);
				repoKharcha.addActionListener(this);
				report_kundali.addActionListener(this);
				addWindowListener(this);
				menubar.requestFocus();
				 
				
				Remind_Auto on=new Remind_Auto(desk,1); 		
       	}

        public void actionPerformed(ActionEvent event)
        {
        	if(event.getSource()==categoryMaster)	
        	{
        		AddCategory obj=new AddCategory(desk);
        	}
        	else if(event.getSource()==itemMaster)	
        	{
        		AddItem obj=new AddItem(desk);
        	}
        	else if(event.getSource()==partyMaster)	
        	{
        		PartyCreation obj=new PartyCreation(desk);
        	}
        	else if(event.getSource()==purPurchase)	
        	{
        		WholesalePurchase obj=new WholesalePurchase(desk,0);
        	}
        	else if(event.getSource()==purExit)	
        	{
        		System.exit(0);
        	}
        	else if(event.getSource()==challanWS)	
        	{
        		ChallanWholeSale obj=new ChallanWholeSale(desk,0);
        	}
        	else if(event.getSource()==challan2invoiceWS)	
        	{
        		ChallanToInvoiceWholeSale obj=new ChallanToInvoiceWholeSale(desk,0);
        	}
        	else if(event.getSource()==challanRetail)	
        	{
        		ChallanRetailSale obj=new ChallanRetailSale(desk,0);
        	}
        	
        	else if(event.getSource()==challan2invoiceRetail)	
        	{
        				System.out.println("calling...");
ChallanToInvoiceRetailSale obj=new ChallanToInvoiceRetailSale(desk,0);
        	}
        	else if(event.getSource()==repoShowClosing)
        	{
        		ShowRokarInDateRange ob=new ShowRokarInDateRange(desk);
        	}
        	else if(event.getSource()==repoPartyBal)
        	{
        		ShowPartyBalance ob=new ShowPartyBalance(desk);
        	}
        	else if(event.getSource()==repoCloseMetalCatWise)
        	{
        		ShowRokar ob=new ShowRokar(desk);
        	}
        	else if(event.getSource()==repoCloseMetalItemWise)
        	{
        		ShowCloseMetalItemWise ob=new ShowCloseMetalItemWise(desk);
        	}
        	else if(event.getSource()==report_remloan)
        	{
        		System.out.println("i am in debtor report");
        		Remind_Loan ob=new Remind_Loan(desk);
        		System.out.println("i am in debtor report.............");
        	}
        	
        	else if(event.getSource()==repoProfit)
        	{
        		ShowProfit ob=new ShowProfit(desk);
        	}
        	else if(event.getSource()==acMakeLadger)
        	{
        		CreateLedger ob=new CreateLedger(desk);
        	}
        	else if(event.getSource()==acVoucherEntry)
        	{
        		KharchaEntry ob=new KharchaEntry(desk);
        	}
        	else if(event.getSource()==reminder)
        	{
        		Reminder ob=new Reminder(desk);
        	}
        	else if(event.getSource()==reminder_R)
        	{
        		Remind_Auto ob=new Remind_Auto(desk,2);
        	}
 			else if(event.getSource()==repoTrading)
 			{
        		ShowTradingReport ob=new ShowTradingReport(desk);
        	}
        	else if(event.getSource()==repoTrading1)
 			{
        		ShowTradingReport1 ob=new ShowTradingReport1(desk);
        	}
        	else if(event.getSource()==repoKharcha)
 			{
        		ShowKharchaAdjustment ob=new ShowKharchaAdjustment(desk);
        	}
        	else if(event.getSource()==report_kundali)
 			{
        		PartyLekhaJokha ob=new PartyLekhaJokha(desk);
        	}
 			       	
   		}
   		
   		public void windowDeactivated(WindowEvent we)
	{}
	public void windowActivated(WindowEvent we)
	{
		//System.out.println("First");
	}
	public void windowDeiconified(WindowEvent we)
	{}
	public void windowIconified(WindowEvent we)
	{}
	public void windowClosed(WindowEvent we)
	{}
	public void windowClosing(WindowEvent we)
	{}
	public void windowOpened(WindowEvent we)
	{
		//checkOriginalityOfSoftware ();
		//checkDate ();
	}
   		
   		public static void main(String args[])
   		{
   			DeskTop dt=new DeskTop();
   			Dimension sd=Toolkit.getDefaultToolkit().getScreenSize();
   			dt.setSize(sd.width,sd.height);
   			dt.show();
   		}
   		
   		//updated from here---------------------------------------
   	public static String getHardDiskSRNo()
    {
  String result = "";
    try {
      
        String drive="C";
        File file = File.createTempFile("realhowto",".vbs");
      file.deleteOnExit();
      FileWriter fw = new java.io.FileWriter(file);

      String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                  +"Set colDrives = objFSO.Drives\n"
                  +"Set objDrive = colDrives.item(\"" + drive + "\")\n"
                  +"Wscript.Echo objDrive.SerialNumber";  // see note
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
  private void checkDate()
    {
        try
        {
        	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
		  	Statement st=cn.createStatement();
            java.sql.ResultSet rs11=null;
            java.util.Date dtt=null;
             //check date of open table valid upto 1 month(30 Days)----------------------------------------
            java.util.Date dt=new java.util.Date();
            try
            {
            
            rs11=st.executeQuery("select min(DOfOpen) from openingDate where status=0");
            if(rs11.next())
            {
                
                dtt=rs11.getDate(1);
                System.out.println("dBaseDate="+dtt);
            }
            if(dtt==null) //checking for status
            {
            	javax.swing.JOptionPane.showMessageDialog(this,"Software Validity Expired.\nFor use Contact us:-\nZED Software Pvt. Ltd.\nContact No.0542-23196660","Unathourized Access Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            System.out.println("curDate="+dt);
            long dt1=java.sql.Date.parse((dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900));
            long dLong=java.sql.Date.parse((dtt.getMonth()+1)+"/"+(dtt.getDate())+"/"+(dtt.getYear()+1900));
            long oneDayLongValue=86400000;//since the long value of 24 hours(one day) is 86400000
            long exp30=oneDayLongValue*30;
            if(dt.compareTo(dtt)<0)
            {
                System.out.println("Current date is smaller than DB date.........");
                //st.executeUpdate("update openingDate set status=1");
                javax.swing.JOptionPane.showMessageDialog(this,"Software Validity Expired.\nFor use Contact us:-\nZED Software Pvt. Ltd.\nContact No.0542-23196660","Unathourized Access Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            System.out.println("dt1="+dt1);
            System.out.println("dLong="+dLong);
            System.out.println("exp30="+exp30);
            if(dt1>(dLong+exp30))
            {
                System.out.println("Current date is Greater than DB date.........");
                st.executeUpdate("update openingDate set status=1");
                javax.swing.JOptionPane.showMessageDialog(this,"Software Validity Expired.\nFor use Contact us:-\nZED Software Pvt. Ltd.\nContact No.0542-23196660","Unathourized Access Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            
            }
            catch(Exception e)
            {
                System.out.println("Creation of first table");
                st.executeUpdate("create table openingDate (DOfOpen Date,status int);");
                String dt1=(dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900);
                st.executeUpdate("insert into openingDate values('"+dt1+"',0)");
            }  
            //------------------------------------------------------------------------
            cn.close();
              
            
        }
        catch(Exception e)
        {
            System.out.println("Error in taking data from desktop class "+e);
        }
    }
    private void checkOriginalityOfSoftware()
    {
         try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	    	Connection cn=DriverManager.getConnection("jdbc:odbc:jweldsn","zed","zed"); 
		  	Statement st=cn.createStatement();
            String cpuId = getHardDiskSRNo();
            System.out.println("Motherboard no="+cpuId);
            boolean flag=false;
            try
            {
                java.sql.ResultSet rs=st.executeQuery("select * from serialNumber");
                if(rs.next())
                {
                    String getCpuNo=rs.getString("srNo");
                    if(getCpuNo.equals(cpuId)==false)
                    {
                        javax.swing.JOptionPane.showMessageDialog(this,"Sorry!\nYou must have original copy of SOFTWARE.\nTo purchase, call - 0542 3196660","Bad Work",javax.swing.JOptionPane.ERROR_MESSAGE);                        
                        cn.close();
                        System.exit(1);
                    }
                }
                else
                {
                    st.executeUpdate("insert into serialnumber values('"+cpuId+"')");                
                }
                flag=true;
            }
            catch(Exception ex)
            {
                System.out.println("error....table not found.");
                flag=false;
            }
            if(flag==false)
            {
                st.executeUpdate("create table serialNumber (srno text)");
                st.executeUpdate("insert into serialnumber values('"+cpuId+"')");
                
            }
            cn.close();
        }
        catch(Exception ex)
        {
            System.out.println("error...222..."+ex);
        }
    
    }
}