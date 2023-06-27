/*
 * MainBase.java
 *
 * Created on April 4, 2010, 2:03 PM
 */

//package medretail;
import java.rmi.*;
import javax.swing.*;
/**
 *
 * @author  Deep Pal
 */
public class MainBase extends javax.swing.JFrame {
    
    /** Creates new form MainBase */
    public MainBase(String id,int level) {
    	
        System.out.println("skm123");
        this.id=id;
        this.level=level;
        initComponents();
        System.out.println("skm123...");
        
        jMenuItem14.setVisible(false);
        setTitle("medMAN Ver 1.1  ::  "+SetDBFileName.firmNameForDBSelection.substring(0,SetDBFileName.firmNameForDBSelection.lastIndexOf(".")).toUpperCase());
        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        jDesktopPane1.setLayout(null);
        jPanel1.setBounds(0,dm.height-120,dm.width,30);
        jToolBar1.setBounds(0,0,dm.width,30);
        
        mnuItm_reportPayParty=new JMenuItem("Report : Paid Details",new ImageIcon("icons\\hotfin.gif"));
    	mnuItm_reportPayParty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
     //   mnuItm_reportPayParty.setMnemonic('i');
     //   mnuItm_reportPayParty.setText("Report : Paid Details",new ImageIcon("icons\\veryhotfin.gif"));
        mnuItm_reportPayParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItm_reportPayPartyActionPerformed(evt);
            }
        });
        mnuItm_reportPayPartyTrans=new JMenuItem("Report : Transaction Details",new ImageIcon("icons\\hotfin.gif"));
    	mnuItm_reportPayPartyTrans.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
    //    mnuItm_reportPayPartyTrans.setMnemonic('T');
    //    mnuItm_reportPayPartyTrans.setText("Report : Transaction Details",new ImageIcon("icons\\veryhotfin.gif"));
        mnuItm_reportPayPartyTrans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItm_reportPayPartyTransActionPerformed(evt);
            }
        });
        
        jMenu6.addSeparator();
        jMenu6.add(mnuItm_reportPayParty);
        jMenu6.addSeparator();
        jMenu6.add(mnuItm_reportPayPartyTrans);
        
        mnuItm_payToParty=new JMenuItem();
    	mnuItm_payToParty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
     //   mnuItm_payToParty.setMnemonic('u');
        mnuItm_payToParty.setText("Pay Amount To Party");
        mnuItm_payToParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItm_payToPartyActionPerformed(evt);
            }
        });
        jMenu4.addSeparator();
        jMenu4.add(mnuItm_payToParty);
        
        mnuItm_sellToHPSorPatient=new JMenuItem();
    	mnuItm_sellToHPSorPatient.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
      //  mnuItm_sellToHPSorPatient.setMnemonic('t');
        mnuItm_sellToHPSorPatient.setText("Sell : Hospital_Patient");
        mnuItm_sellToHPSorPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItm_sellToHPSorPatientActionPerformed(evt);
            }
        });
        jMenu5.addSeparator();
        jMenu5.add(mnuItm_sellToHPSorPatient);
        jMenu5.addSeparator();
        
        
        jMenu6.addSeparator();

        jMenuItem29.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
     //   jMenuItem29.setMnemonic('G');
     //   c.setText("Report : Generic Index",new ImageIcon("icons\\veryhotfin.gif"));
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem29);
        
        
        String str=getMatter();
        System.out.println("str="+str);
        
        //---providing menu item------------
        
        providationOfMenu();
        scroll th=new scroll(str);
        th.start();
        
    }
    private void providationOfMenu()
    {
    	try
        {
        	if(level==0)//for admin
        	{}
        	else
        	{
        		System.out.println("MENU PROVIDATION.................");
        		jButton1.setEnabled(false);
        		jButton2.setEnabled(false);
        		jButton3.setEnabled(false);
        		jButton4.setEnabled(false);
        		jButton5.setEnabled(false);
        		jButton6.setEnabled(false);
        		jMenuItem1.setEnabled(false);
        		jMenuItem2.setEnabled(false);
        		jMenuItem3.setEnabled(false);
        		jMenuItem4.setEnabled(false);
        		jMenuItem5.setEnabled(false);
        		jMenuItem6.setEnabled(false);
        		jMenuItem7.setEnabled(false);
        		jMenuItem8.setEnabled(false);
        		jMenuItem9.setEnabled(false);
        		mnuItm_purchaseParty.setEnabled(false);
        		jMenuItem10.setEnabled(false);
        		jMenuItem11.setEnabled(false);
        		jMenuItem12.setEnabled(false);
        		jMenuItem13.setEnabled(false);
        		jMenuItem14.setEnabled(false);
        		jMenuItem15.setEnabled(false);
        		jMenuItem16.setEnabled(false);
        		jMenuItem17.setEnabled(false);
        		jMenuItem18.setEnabled(false);
        		jMenuItem19.setEnabled(false);
        		jMenuItem20.setEnabled(false);
        		//jMenuItem21.setEnabled(false);//shut down
        		jMenuItem22.setEnabled(false);
        		jMenuItem23.setEnabled(false);
        		jMenuItem24.setEnabled(false);
        		jMenuItem25.setEnabled(false);
        		jMenuItem26.setEnabled(false);
        		jMenuItem27.setEnabled(false);
        		jMenuItem28.setEnabled(false);
        		jMenuItem29.setEnabled(false);
        		
        		
        		jMenuItem31.setEnabled(false);
        		jMenuItem32.setEnabled(false);
        		jMenuItem33.setEnabled(false);
        		jMenuItem34.setEnabled(false);
        		jMenuItem35.setEnabled(false);
        		jMenuItem36.setEnabled(false);
        		jMenuItem37.setEnabled(false);
        		jMenuItem38.setEnabled(false);
        		
        		jMenuItem39.setEnabled(false);
        		jMenuItem40.setEnabled(false);
        		jMenuItem41.setEnabled(false);
        		jMenuItem42.setEnabled(false);
        		jMenuItem43.setEnabled(false);
        		jMenuItem44.setEnabled(false);
        		
        		
        		mnuItm_payToParty.setEnabled(false);
        		mnuItm_reportPayParty.setEnabled(false);
        		mnuItm_reportPayPartyTrans.setEnabled(false);
        		mnuItm_sellToHPSorPatient.setEnabled(false);
        		mnuItm_sellByHPS.setEnabled(false);
        		ZedInterface inf=null;
ZedInterfaceForMedical uc=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		uc=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
        		System.out.println("id="+id+"     level="+level);
        		String value=inf.getSingleValue("select providedMenuItem from loginMasterOfMedical where uId='"+id+"'");
        		System.out.println("value="+value);
        		String selectedMnuItm[]=null;
        		if(value!=null)
        			selectedMnuItm=value.split(",");
        		System.out.println("len="+selectedMnuItm.length);
        		if(selectedMnuItm!=null)
        		{
        			String str=jMenuItem1.getText();
        			System.out.println("1.."+str);
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem1.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem2.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem2.setEnabled(true);
        					jButton1.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem3.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem3.setEnabled(true);
        					jButton2.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem4.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem4.setEnabled(true);
        					break;
        				}
        			}
        			str=mnuItm_purchaseParty.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mnuItm_purchaseParty.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem5.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem5.setEnabled(true);
        					jButton3.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem6.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem6.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem7.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem7.setEnabled(true);
        					jButton4.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem8.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem8.setEnabled(true);
        					jButton5.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem9.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem9.setEnabled(true);
        					jButton6.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem10.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem10.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem11.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem11.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem12.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem12.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem13.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem13.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem14.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem14.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem15.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem15.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem16.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem16.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem17.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem17.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem18.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem18.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem19.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem19.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem20.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem20.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem21.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem21.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem22.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem22.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem23.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem23.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem24.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem24.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem25.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem25.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem26.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem26.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem27.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem27.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem28.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem28.setEnabled(true);
        					break;
        				}
        			}
        			str=jMenuItem29.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem29.setEnabled(true);
        					break;
        				}
        			}
        			str=mnuItm_payToParty.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mnuItm_payToParty.setEnabled(true);
        					break;
        				}
        			}
        			str=mnuItm_reportPayParty.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mnuItm_reportPayParty.setEnabled(true);
        					break;
        				}
        			}
        			str=mnuItm_reportPayPartyTrans.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mnuItm_reportPayPartyTrans.setEnabled(true);
        					break;
        				}
        			}
        			str=mnuItm_sellToHPSorPatient.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mnuItm_sellToHPSorPatient.setEnabled(true);
        					break;
        				}
        			}
        			str=mnuItm_sellByHPS.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mnuItm_sellByHPS.setEnabled(true);
        					break;
        				}
        			}
        			
        			
        			str=jMenuItem31.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem31.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem32.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem32.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem33.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem33.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem34.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem34.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem35.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem35.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem36.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem36.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem37.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem37.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem38.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem38.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem39.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem39.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem40.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem40.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem41.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem41.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem42.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem42.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem43.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem43.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=jMenuItem44.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					jMenuItem44.setEnabled(true);
        					break;
        				}
        			}
        			
        			
        		}
        	}
        }
        catch(Exception e)
        {
        	System.out.println("Error...SKM_R...."+e);
        }
    }
    
    
    
    private String getMatter()
    {
        String str="";
        try
        {
            //ConnectDatabase cd=new ConnectDatabase();
            //java.sql.Connection connection=cd.getConnection();
            //java.sql.Statement st=connection.createStatement();
            System.out.println("ok1");
            ZedInterface inf=null;
ZedInterfaceForMedical inf1=null;
try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
            //utilityClass uc=new utilityClass();
            //System.out.println(" "+(java.util.Date.parse("7/17/2010")-java.util.Date.parse("4/1/2010")));
            System.out.println("ok3");
            java.util.Date dt=new java.util.Date();
            //System.out.println("date="+(dt.getMonth()+1)+"/"+(dt.getDate())+"/"+(dt.getYear()+1900));
            long time=java.sql.Date.parse((dt.getMonth()+1)+"/"+(dt.getDate())+"/"+(dt.getYear()+1900));
            //System.out.println("time="+time);
            //long moreDays=9244800000;//86400000*10;
            //time=moreDays+time;
            //System.out.println("time="+time);
            java.util.Date lastdt=new java.util.Date(time+(java.util.Date.parse("5/1/2010")-java.util.Date.parse("4/1/2010")));
            String expdate=(lastdt.getMonth()+1)+"/"+(lastdt.getDate())+"/"+(lastdt.getYear()+1900);
            System.out.println("Expiry Date="+expdate);
            //System.out.println("select * from stockHolding where expDate<=#"+expdate+"#");
           // java.sql.ResultSet rs=st.executeQuery("select itemCode,batchNo from stockHolding where expDate<=#"+expdate+"#");
            String arr[][]=inf.getResultSetAs_2D_Array("select itemCode,batchNo from stockHolding where expDate<=#"+expdate+"#",2);
            if(arr!=null)
            {
            	for(int i=0;i<arr.length;i++)
            	{
            		int itemcode=Integer.parseInt(arr[i][0]);
                	String inm=inf1.getItemName(itemcode);
                	String bno=arr[i][1];
                	str=str+inm+" # "+bno+"     ";
            	}
            }
            /*while(rs.next())
            {
                int itemcode=rs.getInt("itemCode");
                String inm=uc.getItemName(itemcode);
                String bno=rs.getString("batchNo");
                str=str+inm+" # "+bno+"     ";
            }*/
            str="                      "+str;
            
        }
        catch(Exception ex)
        {
            System.out.println("Error...123..."+ex);
        }   
        return str;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jMenuItem21 = new javax.swing.JMenuItem("ShutDown",new ImageIcon("icons\\logout1.gif"));
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem("Report : Generic Index",new ImageIcon("icons\\hotfin.gif"));
  
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem("Current Available Stock",new ImageIcon("icons\\property.gif"));
        jMenuItem8 = new javax.swing.JMenuItem("Out Of Stock",new ImageIcon("icons\\reminder.gif"));
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem9 = new javax.swing.JMenuItem("Expiry : Coming Soon",new ImageIcon("icons\\expiry.gif"));;
        jSeparator3 = new javax.swing.JSeparator();
        jMenuItem12 = new javax.swing.JMenuItem("Sale - Date Wise",new ImageIcon("icons\\prev-off.gif"));
        jMenuItem13 = new javax.swing.JMenuItem("Purchase - Date Wise",new ImageIcon("icons\\prev-off.gif"));
        jMenuItem23 = new javax.swing.JMenuItem("Order - Date Wise",new ImageIcon("icons\\hotfinal.gif"));
        jSeparator6 = new javax.swing.JSeparator();
        jMenuItem17 = new javax.swing.JMenuItem("Purchase Info - Batchwise",new ImageIcon("icons\\sticky.gif"));;
        jSeparator7 = new javax.swing.JSeparator();
        jMenuItem18 = new javax.swing.JMenuItem("Show Profit",new ImageIcon("icons\\scales.gif"));
        jSeparator9 = new javax.swing.JSeparator();
        jMenuItem20 = new javax.swing.JMenuItem("Show Report : Editing of Bill",new ImageIcon("icons\\edit1.gif"));
        jMenu7 = new javax.swing.JMenu();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jMenuItem15 = new javax.swing.JMenuItem("Change Password",new ImageIcon("icons\\key.gif"));
        jSeparator8 = new javax.swing.JSeparator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem31=new javax.swing.JMenuItem("Company Master : Spectacle",'m');
        jMenuItem32=new javax.swing.JMenuItem("Opening Stock : Spectacle",'S');
        jMenuItem33=new javax.swing.JMenuItem("Make Purchase : Spectacle",'P');
        jMenuItem34=new javax.swing.JMenuItem("Edit Purchase Of Spectacle:DateWise",'E');
        jSeparator11 = new javax.swing.JSeparator();
        jMenuItem35=new javax.swing.JMenuItem("Direct Sale Of Spectacles",'d');
        jMenuItem36=new javax.swing.JMenuItem("Patient : Spects Entry");
        jMenuItem37=new javax.swing.JMenuItem("Patient : Edit Spects Entry");
        jMenuItem38=new javax.swing.JMenuItem("Patient : Provide Spects");
        jMenu10 = new javax.swing.JMenu();
        jSeparator12 = new javax.swing.JSeparator();
        jMenuItem39=new javax.swing.JMenuItem("Spects Detail",'e');
        jMenuItem40=new javax.swing.JMenuItem("Pending Spects Detail",'i');
        jMenuItem41=new javax.swing.JMenuItem("Spectacle Stock Report",'r');
        jMenuItem42=new javax.swing.JMenuItem("Spectacle Purchase Report:DateWise",'p');
        jMenuItem43=new javax.swing.JMenuItem("Edit : Direct Sale Of Spectacles",'i');
        jMenuItem44=new javax.swing.JMenuItem("Customer : Provide Spects",'c');
        
		System.out.println("1........");
        jMenu1.setText("Menu");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menu");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("MEDman VER-1.1111");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
		System.out.println("2........");
        jDesktopPane1.setBackground(new java.awt.Color(215, 215, 172));
        jPanel1.setLayout(new java.awt.BorderLayout());
		System.out.println("20........");
        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jLabel1.setText("jLabel1");
        System.out.println("02........");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
		System.out.println("21........");
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.setBounds(0, 170, 780, 20);
        jDesktopPane1.add(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		System.out.println("22........");
        jToolBar1.setBackground(new java.awt.Color(236, 235, 242));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.gif")));
        jButton1.setToolTipText("Add Item");
        System.out.println("23........");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		System.out.println("3........");
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.gif")));
        jButton2.setToolTipText("Make Purchase");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/createstaff.gif")));
        jButton3.setToolTipText("Make Sell");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/surgery.gif")));
        jButton4.setToolTipText("Current Available Stock");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
		System.out.println("4........");
        jToolBar1.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/info.gif")));
        jButton5.setToolTipText("Out Of Stock");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/samples.gif")));
        jButton6.setToolTipText("Expiry Coming Soon");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jToolBar1.add(jButton6);

        jToolBar1.setBounds(0, 0, 680, -1);
        jDesktopPane1.add(jToolBar1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jMenuBar3.setBackground(new java.awt.Color(204, 204, 255));
        jMenu3.setMnemonic('m');
        jMenu3.setText("Master     ");
        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setMnemonic('c');
        jMenuItem1.setText("Company Master");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
		System.out.println("5........");
        jMenu3.add(jMenuItem1);
        jMenuItem25.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem25.setMnemonic('r');
        jMenuItem25.setText("Company Master : Spectacle");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu3.addSeparator();
	//jMenu3.add(jMenuItem25);
	//	jMenu3.addSeparator();
        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setMnemonic('i');
        jMenuItem2.setText("Item Master");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });

        jMenu3.add(jMenuItem2);
		jMenu3.addSeparator();
        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setMnemonic('o');
        jMenuItem11.setText("Opening Stock");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });

        jMenu3.add(jMenuItem11);

        jMenu3.add(jSeparator2);
        
        
        jMenuItem26.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem26.setMnemonic('k');
        jMenuItem26.setText("Opening Stock : Spectacle");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        
//	jMenu3.add(jMenuItem26);
	//	jMenu3.addSeparator();
		
		
		
		jMenuItem28.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem28.setMnemonic('r');
        jMenuItem28.setText("Opening Stock : Spectacle");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        //jMenu3.addSeparator();
		//jMenu3.add(jMenuItem28);//-------------use me
        
        mnuItm_purchaseParty=new JMenuItem();
    	mnuItm_purchaseParty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mnuItm_purchaseParty.setMnemonic('m');
        mnuItm_purchaseParty.setText("Party Master");
        mnuItm_purchaseParty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItm_purchasePartyActionPerformed(evt);
            }
        });
        //jMenu3.addSeparator();
        jMenu3.add(mnuItm_purchaseParty);
        jMenu3.addSeparator();

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setForeground(new java.awt.Color(255, 198, 26));
        jMenuItem14.setText("Change Firm");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });

        jMenu3.add(jMenuItem14);

        jMenu3.add(jSeparator4);

        jMenu3.add(jSeparator10);

        jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem21.setForeground(new java.awt.Color(0, 0, 204));
       // jMenuItem21.setMnemonic('s');
       // jMenuItem21.setText("ShutDown");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });

        jMenu3.add(jMenuItem21);

        jMenuBar3.add(jMenu3);

        jMenu4.setMnemonic('p');
        jMenu4.setText("Purchase     ");
        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setMnemonic('m');
        jMenuItem3.setText("Make Purchase");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem3);
        
        jMenuItem27.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem27.setMnemonic('a');
        jMenuItem27.setText("Make Purchase : Spectacle");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
      //  jMenu4.addSeparator();
	//	jMenu4.add(jMenuItem27);
		jMenu4.addSeparator();
        
        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("Edit Purchase");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });

        jMenu4.add(jMenuItem4);

        jMenuBar3.add(jMenu4);

        jMenu5.setMnemonic('s');
        jMenu5.setText("Sale     ");
        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Make Sale");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });

        jMenu5.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Edit Sale");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });

        jMenu5.add(jMenuItem6);

        jMenuBar3.add(jMenu5);

        jMenu8.setMnemonic('o');
        jMenu8.setText("Order     ");
        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setMnemonic('m');
        jMenuItem10.setText("Make Order");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });

        jMenu8.add(jMenuItem10);

        jMenuItem22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem22.setMnemonic('e');
        jMenuItem22.setText("Edit Order");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });

        jMenu8.add(jMenuItem22);

        jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem24.setMnemonic('u');
        jMenuItem24.setLabel("Change Status");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });

        jMenu8.add(jMenuItem24);

        jMenuBar3.add(jMenu8);
        
        //////////updated here by S_CHK///////////////
        jMenu9.setMnemonic('T');
        jMenu9.setText("Spectacles   ");
        jMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });
		
		jMenuItem31.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem31.setMnemonic('c');
      //  jMenuItem31.setText("Company Master : Spectacle",'m');
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem31);
     
     jMenuItem32.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem32.setMnemonic('o');
     //   jMenuItem32.setText("Opening Stock : Spectacle",'S');
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem32);
		
		jMenu9.addSeparator();
		
		jMenuItem33.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem33.setMnemonic('m');
       // jMenuItem33.setText("Make Purchase : Spectacle",'P');
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem33);
		
		
		jMenuItem34.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem34.setMnemonic('e');
     //   jMenuItem34.setText("Edit Purchase Of Spectacle:DateWise",'E');
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem34);
		jMenu9.addSeparator();
	
		
		
		//jMenuItem36.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
		jMenuItem36.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem36.setMnemonic('s');
      //  jMenuItem36.setText("Patient : Spects Entry");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem36);
		
		
		//jMenuItem37.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
		jMenuItem37.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem37.setMnemonic('a');
      //  jMenuItem37.setText("Patient : Edit Spects Entry");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem37);
		
		
		
		//jMenuItem38.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
		jMenuItem38.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem38.setMnemonic('v');
      //  jMenuItem38.setText("Patient : Provide Spects");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem38);
        
               
        jMenuBar3.add(jMenu9);
        
        jMenu9.addSeparator();
        	
		jMenuItem35.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem35.setMnemonic('r');
     //   jMenuItem35.setText("Direct Sale Of Spectacles",'d');
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem35);
		
		
		jMenuItem43.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
      //  jMenuItem43.setMnemonic('r');
     //   jMenuItem35.setText("Direct Sale Of Spectacles",'d');
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem43);
		
		
		jMenuItem44.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
      //  jMenuItem44.setMnemonic('r');
     //   jMenuItem35.setText("Direct Sale Of Spectacles",'d');
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
		
		jMenu9.add(jMenuItem44);
		
		
		
        
        
         jMenu10.setMnemonic('e');
        jMenu10.setText("Spects  Report  ");
        jMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu9ActionPerformed(evt);
            }
        });
		
		//jMenuItem39.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
		jMenuItem39.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem39.setMnemonic('c');
      //  jMenuItem31.setText("Company Master : Spectacle",'m');
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
		
		jMenu10.add(jMenuItem39);
     
     	//jMenuItem40.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
     	jMenuItem40.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem40.setMnemonic('o');
     //   jMenuItem32.setText("Opening Stock : Spectacle",'S');
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
		
		jMenu10.add(jMenuItem40);
        
        
	//	jMenuItem41.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
	jMenuItem41.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem41.setMnemonic('o');
     //   jMenuItem32.setText("Opening Stock : Spectacle",'S');
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
		
		jMenu10.add(jMenuItem41);
		
		
		
		//jMenuItem42.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
		jMenuItem42.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem42.setMnemonic('e');
     //   jMenuItem32.setText("Opening Stock : Spectacle",'S');
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
		
		jMenu10.add(jMenuItem42);        
        
        
        jMenuBar3.add(jMenu10);
        
        
        
		/////////////////////////////////////////////
        jMenu6.setMnemonic('r');
        jMenu6.setText("Reports     ");
        jMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu6ActionPerformed(evt);
            }
        });

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
       // jMenuItem7.setMnemonic('s');
      //  jMenuItem7.setText("Current Available Stock");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
      //  jMenuItem8.setMnemonic('o');
      //  jMenuItem8.setText("Out Of Stock");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem8);

        jMenu6.add(jSeparator1);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        //jMenuItem9.setMnemonic('e');
       // jMenuItem9.setText("Expiry : Coming Soon");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem9);

        jMenu6.add(jSeparator3);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        //jMenuItem12.setMnemonic('a');
      //  jMenuItem12.setText("Sale - Date Wise");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem12);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        //jMenuItem13.setMnemonic('u');
       // jMenuItem13.setText("Purchase - Date Wise");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem13);

        jMenuItem23.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
      //  jMenuItem23.setMnemonic('d');
      //  jMenuItem23.setText("Order - Date Wise");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem23);

        jMenu6.add(jSeparator6);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
       // jMenuItem17.setMnemonic('b');
       // jMenuItem17.setText("Purchase Info - Batchwise");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem17);

        jMenu6.add(jSeparator7);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem18.setMnemonic('f');
      //  jMenuItem18.setText("Show Profit");
      //  jMenuItem18.setToolTipText("Show Profit");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem18);

        jMenu6.add(jSeparator9);

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK));
      //  jMenuItem20.setMnemonic('h');
     //   jMenuItem20.setText("Show Report : Editing of Bill");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });

        jMenu6.add(jMenuItem20);

        jMenuBar3.add(jMenu6);

        jMenu7.setMnemonic('u');
        jMenu7.setText("Utility     ");
        mnuItm_sellByHPS=new JMenuItem("Create New User",new ImageIcon("icons\\user.gif"));
    	mnuItm_sellByHPS.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        //mnuItm_sellByHPS.setMnemonic('N');
        //mnuItm_sellByHPS.setText("Create New User");
        mnuItm_sellByHPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuItm_sellByHPSActionPerformed(evt);
            }
        });
        jMenu7.add(mnuItm_sellByHPS);
        jMenu7.add(jSeparator5);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
       // jMenuItem15.setMnemonic('p');
       // jMenuItem15.setText("Change Password");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });

        jMenu7.add(jMenuItem15);

        jMenu7.add(jSeparator8);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem19.setMnemonic('l');
        jMenuItem19.setText("Company Profile");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });

        jMenu7.add(jMenuItem19);
        
        jMenu7.addSeparator();
        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setMnemonic('b');
        jMenuItem16.setText("Get Backup");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });

        jMenu7.add(jMenuItem16);

        jMenuBar3.add(jMenu7);

        setJMenuBar(jMenuBar3);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
// TODO add your handling code here:
        ChangeStatusOfOrder frm=new ChangeStatusOfOrder(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem24ActionPerformed
	private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
        CmpMasterOfSpects cmpMaster=new CmpMasterOfSpects(jDesktopPane1);
    }
    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
        OpeningStockOfSpects frm=new OpeningStockOfSpects();
        frm.setBounds(50,100,385,285);
        jDesktopPane1.add(frm);
        frm.show();
    }
    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
        MakingPurchaseOfSpects frm=new MakingPurchaseOfSpects();
        frm.setBounds(50,100,740,472);
        jDesktopPane1.add(frm);
        frm.show();
    }
    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
        //CmpMasterOfSpects cmpMaster=new CmpMasterOfSpects(jDesktopPane1);
    }
    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    	GenericIndexReport frm=new GenericIndexReport();
        frm.setBounds(50,100,670,424);
        jDesktopPane1.add(frm);
        frm.show();
    }
    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
// TODO add your handling code here:
        OrderDateWiseReport frm=new OrderDateWiseReport(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
// TODO add your handling code here:
        ListOfOrdering frm=new ListOfOrdering(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
// TODO add your handling code here:
        //taking internal backup of database
        //LastBackupOfDB.takeBackup();
       /* BackupWindowOnExit frm=new BackupWindowOnExit();
        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frm.setBounds((dm.width-785)/2,(dm.height-550)/2,530,120);
        jDesktopPane1.add(frm);
        frm.setVisible(true);*/
        System.exit(0);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
// TODO add your handling code here:
        LoginForShowEditingOfBill dg=new LoginForShowEditingOfBill(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem20ActionPerformed


	private void mnuItm_payToPartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
// TODO add your handling code here:
        PaymentMoneyToPurParty p=new PaymentMoneyToPurParty();
        p.setBounds(200,120,419,280);
        jDesktopPane1.add(p);
        p.show();
    }//G
    
    private void mnuItm_reportPayPartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
// TODO add your handling code here:
        /*PaymentMoneyToPurParty p=new PaymentMoneyToPurParty();
        p.setBounds(200,120,419,280);
        jDesktopPane1.add(p);
        p.show();*/
        WholePaymentSmry w=new WholePaymentSmry(jDesktopPane1);
        
    }//G
	private void mnuItm_reportPayPartyTransActionPerformed(java.awt.event.ActionEvent evt) {
		WholePaymentSmryPartyWise s=new WholePaymentSmryPartyWise(jDesktopPane1);
		}
    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
// TODO add your handling code here:
        FirmProfile fp=new FirmProfile(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
// TODO add your handling code here:
        System.out.println("\nskm1111");
        ShowProfit sf=new ShowProfit(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
// TODO add your handling code here:
       // checkOriginalityOfSoftware();
        //checkDate();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
// TODO add your handling code here:
        ShowPurchaseInfoBatchWise expItem=new ShowPurchaseInfoBatchWise(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed

  private void jMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu6ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jMenu6ActionPerformed


    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
// TODO add your handling code here:
         //System.out.println("skm");
        //taking internal backup of database
    //LastBackupOfDB.takeBackup();
        /*BackupWindowOnExit frm=new BackupWindowOnExit();
        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frm.setBounds((dm.width-785)/2,(dm.height-550)/2,530,120);
        jDesktopPane1.add(frm);
        frm.setVisible(true);*/
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
        ComingExpItems expItem=new ComingExpItems(jDesktopPane1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        OutStockReport outStock=new OutStockReport(jDesktopPane1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        StockReport makeSale=new StockReport(jDesktopPane1);
        //StockReportOfHPS makeSale=new StockReportOfHPS(jDesktopPane1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        MakingSale makeSale=new MakingSale(jDesktopPane1);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        MakePurchase makePurchase=new MakePurchase(jDesktopPane1);
    }//GEN-LAST:event_jButton2ActionPerformed
	
	private void mnuItm_purchasePartyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        AddPurchaseParty frm=new AddPurchaseParty();
        frm.setBounds(50,100,700,295);
        jDesktopPane1.add(frm);
        frm.show();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        ItemMaster itemMaster=new ItemMaster(jDesktopPane1);
        //itemMaster.setBounds(50,100,461,470);
        //jDesktopPane1.add(itemMaster);
        //itemMaster.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
// TODO add your handling code here:
        BackupScreen cp=new BackupScreen(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
// TODO add your handling code here:
        ChangePassword cp=new ChangePassword(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
// TODO add your handling code here:
        /*BackupWindowOnExit frm=new BackupWindowOnExit();
        java.awt.Dimension dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        frm.setBounds((dm.width-785)/2,(dm.height-550)/2,530,120);
        jDesktopPane1.add(frm);
        frm.setVisible(true);
        this.dispose();
        SelectFirmList fl=new SelectFirmList(new java.awt.Frame(),true );
        
        //dm=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        fl.setBounds((dm.width-730)/2,(dm.height-340)/2,730,340);
        fl.setVisible(true);*/
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
// TODO add your handling code here:
        PurchaseDateWiseReport pdwr=new PurchaseDateWiseReport(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
// TODO add your handling code here:
        SaleDateWiseReport ois=new SaleDateWiseReport(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
// TODO add your handling code here:
        OpeningItemStock ois=new OpeningItemStock(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
// TODO add your handling code here:
        start=true;
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
// TODO add your handling code here:
        start=false;
    }//GEN-LAST:event_jLabel1MouseEntered

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
// TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
// TODO add your handling code here:
        java.awt.Dimension dm=this.getSize();
        jDesktopPane1.setLayout(null);
        jPanel1.setBounds(0,dm.height-120,dm.width,30);
        
        
    }//GEN-LAST:event_formWindowActivated

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
// TODO add your handling code here:
       MakeOrder frm=new MakeOrder(jDesktopPane1);
                
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
// TODO add your handling code here:
                ComingExpItems expItem=new ComingExpItems(jDesktopPane1);

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
// TODO add your handling code here:
        OutStockReport outStock=new OutStockReport(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
// TODO add your handling code here:
        StockReport makeSale=new StockReport(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
// TODO add your handling code here:
        ListOfSaleing lop=new ListOfSaleing(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
// TODO add your handling code here:
        MakingSale makeSale=new MakingSale(jDesktopPane1);
		
    }//GEN-LAST:event_jMenuItem5ActionPerformed
	private void mnuItm_sellToHPSorPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
		MakingSaleToPatient makeSale=new MakingSaleToPatient(jDesktopPane1);
	}
	private void mnuItm_sellByHPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
		//MakingSaleByHPS mm=new MakingSaleByHPS(jDesktopPane1);
		CreateNewUser u=new CreateNewUser();
		u.setBounds(20,80,852,464);
		jDesktopPane1.add(u);
		u.show();
	}
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
// TODO add your handling code here:
        ListOfPurchaseing lop=new ListOfPurchaseing(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
// TODO add your handling code here:
        MakePurchase makePurchase=new MakePurchase(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
// TODO add your handling code here:
        ItemMaster itemMaster=new ItemMaster(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
        CmpMaster cmpMaster=new CmpMaster(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    
      private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
        CmpMasterOfSpects cmp=new CmpMasterOfSpects(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
      private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
        OpeningStockOfSpects frm=new OpeningStockOfSpects();
        frm.setBounds(50,100,385,285);
        jDesktopPane1.add(frm);
        frm.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
      private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
       	MakingPurchaseOfSpects frm=new MakingPurchaseOfSpects();
			frm.setBounds(50,100,740,472);
        	jDesktopPane1.add(frm);
        	frm.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
      private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
     	new EditPurchaseOfSpects(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
      private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
       	new ProvideSpectsToCustomer(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
      private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
       		new EditProvideSpectsToCustomer(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    
      private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
       GivenSpectsToCustomerWithPay frm=new GivenSpectsToCustomerWithPay();
			frm.setBounds(50,100,340,196);
			jDesktopPane1.add(frm);
			frm.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
       private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
       ProvideSpectsToPatient frm=new ProvideSpectsToPatient(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
       private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
       	EditProvideSpectsToPatient frm=new EditProvideSpectsToPatient(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
       private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
       		GivenSpectsToPatientWithPay frm=new GivenSpectsToPatientWithPay();
			frm.setBounds(50,100,340,196);
			jDesktopPane1.add(frm);
			frm.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    
      private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
       new newSpectaclesDetail(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    
      private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
      	new newPendingSpects(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
      private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
      new spectsStockReport(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    
      private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
// TODO add your handling code here:
      new PurchaseDateWiseReportOfSpects(jDesktopPane1);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    /*private void checkDate()
    {
        try
        {
            //ConnectDatabase cd=new ConnectDatabase();
            //java.sql.Connection connection = cd.getConnection();
            //java.sql.ResultSet rs,rs1;
            //java.sql.Statement st=connection.createStatement();
            //java.sql.ResultSet rs11=null;
            ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
            java.util.Date dtt=null;
             //check date of open table valid upto 1 month(30 Days)----------------------------------------
            java.util.Date dt=new java.util.Date();
            try
            {
            String date=inf.getSingleValue("select min(DOfOpen) from openingDate");
            System.out.println("date="+date);
            /*rs11=st.executeQuery("select min(DOfOpen) from openingDate");
            if(rs11.next())
            {
                
                dtt=rs11.getDate(1);
                System.out.println("dBaseDate="+dtt);
            }
            System.out.println("curDate="+dt);
            long dt1=java.sql.Date.parse((dt.getMonth()+1)+"/"+dt.getDate()+"/"+(dt.getYear()+1900));
            long dLong=java.sql.Date.parse((dtt.getMonth()+1)+"/"+(dtt.getDate())+"/"+(dtt.getYear()+1900));
            long oneDayLongValue=86400000;//since the long value of 24 hours(one day) is 86400000
            long exp30=oneDayLongValue*30;
            if(dt.compareTo(dtt)<0)
            {
                System.out.println("E1111.........");
                javax.swing.JOptionPane.showMessageDialog(this,"Software Validity Expired.\nFor use Contact us:-\nZED Software Pvt. Ltd.\nContact No.0542-23196660","Unathourized Access Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            System.out.println("dt1="+dt1);
            System.out.println("dLong="+dLong);
            System.out.println("exp30="+exp30);
            if(dt1>(dLong+exp30))
            {
                System.out.println("E2222.........");
                javax.swing.JOptionPane.showMessageDialog(this,"Software Validity Expired.\nFor use Contact us:-\nZED Software Pvt. Ltd.\nContact No.0542-23196660","Unathourized Access Error",javax.swing.JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
            
            }
            catch(Exception e)
            {
                System.out.println("Creation of first table");
                inf.executeUpdateQuery("create table openingDate (DOfOpen Date);");
                inf.executeUpdateQuery("insert into openingDate values('"+dt1+"')");
                //st.executeUpdate("create table openingDate (DOfOpen Date);");
                //String dt1=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
                //st.executeUpdate("insert into openingDate values('"+dt1+"')");
            }  
            //------------------------------------------------------------------------
            
              
            
        }
        catch(Exception e)
        {
            System.out.println("Error in taking data from sellDtel "+e);
        }
    }*/
    
/*    private void checkOriginalityOfSoftware()
    {
         try
        {
            ConnectDatabase cd=new ConnectDatabase();
            java.sql.Connection con = cd.getConnection();
            java.sql.Statement st=con.createStatement();
            String cpuId = utilityClass.getMotherboardSN();//actually getting serial no. of Hard Disk not of Mother Board
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
                        con.close();
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
            con.close();
        }
        catch(Exception ex)
        {
            System.out.println("error...222..."+ex);
        }
    
    }*/
    
    
    
    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainBase().setVisible(true);
            }
        });
    }*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnuItm_payToParty;
    private javax.swing.JMenuItem mnuItm_reportPayParty;
    private javax.swing.JMenuItem mnuItm_reportPayPartyTrans;
    private javax.swing.JMenuItem mnuItm_sellToHPSorPatient;
    private javax.swing.JMenuItem mnuItm_sellByHPS;
    private javax.swing.JMenuItem mnuItm_purchaseParty;
    // End of variables declaration//GEN-END:variables
     String id;
        
    int times=8,level;
    boolean start=true;
    class scroll extends Thread
    {
        String str="";
        public scroll(String str)
        {
            this.str=str;
        }
        public void run()
        {
            while(str.length()>0)
            {
                if(start==true)
                {
                    try
                {
                    if(times==8)
                    {
                        jLabel1.setText(str);
                        str=str.substring(1);
                        jLabel1.setText(str);
                        Thread.sleep(100);
                    }
                    if(str.length()==0)
                    {
                        times=1;
                        str=getMatter();
                        jLabel1.setText(str);
                        jLabel1.setVisible(false);
                    }
                    if(times<8)
                    {
                        if(jLabel1.isVisible()==false)
                            jLabel1.setVisible(true);
                        else
                            jLabel1.setVisible(false);
                        times++;
                        Thread.sleep(100);
                    }
                }
                catch(Exception ex)
                {
                    System.out.println("error...289..."+ex);
                }
                }
            }
        }
    }
}
