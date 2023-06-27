import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.sql.*;
import java.util.Date;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;
import javax.swing.table.*;

class fetchHistory extends JDialog implements ActionListener//,KeyListener
{
//	JDesktopPane Feedp;


	DefaultTableModel dtm;
	JTable table;
	
	JScrollPane jsp_DIALOG;
	
	JPopupMenu pm=new JPopupMenu();;
	JMenuItem del=new JMenuItem("DELETE");
	
	Container cn1,cnnext,cn;
	
	SetDialog set_DG;
	Vector vc,vc1;
	JDialog dg,dgnext;
	JLabel lb,lbt,lbtime,lbdate,PatientL,pid,nameL;
	JLabel heightL,weightL,bloodgroupL,sugarL,bloodpressureL,allergyL,currentmediL,commentL,pnameL,L_PID;
	JComboBox cb1,cballergy,cbcurrentmedi,cbdrcatnm,cbdrnm,cbSac;
	JButton bt1,refresh,previous,btallergy,btcurrentmedi,SAVE,CANCEL;
	ButtonGroup genGp=new ButtonGroup();
	
	JRadioButton rb1,rb2;
	JTextField nameT,ageT,dobT,phoneT,gurdianT,cityT,pincodeT,stateT;
	JTextField heightT,weightT,bloodgroupT,sugarT,bloodpressureT;
//	JTextArea commentJ;
	JList allergyLT,currentmediLT;
	JPanel p1;
	JTextArea addressT; 
	JTextArea commentJ=new JTextArea();
	JScrollPane jsp=new JScrollPane(commentJ);
	JScrollPane jspallergy;
	JScrollPane jspcurrentmedi;
	Date dt;
	JButton bt_OK_DIALOG=new JButton("OK",new ImageIcon("icons\\info.gif"));
	JTextField tft1,tftA;
	String st="";
	int load,dcode,code,FLAG=0,getID=0;
	int date1,mon,yer,hr,min,sec,cbcount=0,cbcount1=0;
	String setip,drcat,qry,str="",str1="";
	ZedInterface inf=null;
	
	
	public fetchHistory(String GetName,int ID)
	{
		Font fntdialog=new Font("Arial NArrow",Font.BOLD,12);
		Color fcl=new Color(0,0,128);
		Font fnt=new Font("Arial NArrow",Font.BOLD,9);

		String Set_PName=GetName;
		System.out.println("Set_PName "+Set_PName);
		getID=ID;
		System.out.println("getID "+getID);
		vc=new Vector();
		vc1=new Vector();
		allergyLT=new JList(vc);
		jspallergy=new JScrollPane(allergyLT,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		currentmediLT=new JList(vc1);
		jspcurrentmedi=new JScrollPane(currentmediLT,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		load=1;
	
		
		String head[]={"Sno.","Height","Weight","Blood_grp","Sugar","Blood_pre","Sac","Allergy","CuurentMedi","Remarks","History Date"};
		dtm=new DefaultTableModel(head,0);
		table=new JTable(dtm);
	
		jsp_DIALOG=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
	
		cn=getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		setTitle("PATIENT HISTORY WINDOW");

		lb=new JLabel("DATE");
		lb.setOpaque(false);
		lb.setBounds(470,10,50,20);
		
		
		dt=new Date();
		date1=dt.getDate();
		mon=1+dt.getMonth();
		yer=1900+dt.getYear();
		int h=dt.getHours();
		int min=dt.getMinutes();
		int sec=dt.getSeconds();
		
		String currentDate=date1+"/"+mon+"/"+yer+" "+h+":"+min+":"+sec;
		System.out.println("currentDate "+currentDate);
	/*	String mon1=""+mon;
		String condt=""+date1;
		String year1=""+(yer+1900);*/
		//lbdate=new JLabel(condt+"/"+mon1+"/"+year1,JLabel.LEFT);
		lbdate=new JLabel(currentDate);
		lbdate.setOpaque(false);
		lbdate.setBounds(535,10,120,20);
		

		
		Color clB=new Color(225,248,137);
		nameL=new JLabel("Name");
		nameL.setForeground(fcl);
		nameL.setOpaque(false);
		nameL.setBounds(15,10,40,20);
		pnameL=new JLabel(Set_PName,JLabel.CENTER);
		pnameL.setForeground(fcl);
		pnameL.setOpaque(true);
		pnameL.setBackground(clB);
		pnameL.setBounds(80,10,140,20);
	//	Pname.setText(Set_PName);
		//nameT.setText(Set_PName);
		
		
		
		
	//	Color cl1=new Color(0,128,64);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		Color fcl1=new Color(0,0,128);
		p1=new JPanel();
		p1.setBounds(10,35,670,275);
		p1.setLayout(null);
		TitledBorder tb1=new TitledBorder(eb,"History");
		p1.setBorder(tb1);
		p1.setOpaque(false);
	//	p2.setBackground(cl1);
		p1.setForeground(fcl1);
		
		heightL=new JLabel("Height",JLabel.LEFT);
		heightL.setForeground(fcl);
		heightL.setOpaque(false);
		heightL.setBounds(15,30,40,15);
		JLabel hunit=new JLabel("cm",JLabel.LEFT);
		heightT=new JTextField();
		heightT.setBounds(110,30,60,20);
		hunit.setBounds(171,30,18,15);
		
		weightL=new JLabel("Weight",JLabel.LEFT);
		weightL.setForeground(fcl);
		weightL.setOpaque(false);
		weightL.setBounds(15,60,60,15);
		JLabel wunit=new JLabel("Kg",JLabel.LEFT);
		weightT=new JTextField();
		weightT.setBounds(110,60,60,20);
		wunit.setBounds(171,60,15,15);
		
		bloodgroupL=new JLabel("Blood Group",JLabel.LEFT);
		bloodgroupL.setForeground(fcl);
		bloodgroupL.setOpaque(false);
		bloodgroupL.setBounds(15,90,70,15);
		bloodgroupT=new JTextField();
		bloodgroupT.setBounds(110,90,40,20);
		
		
		sugarL=new JLabel("Sugar",JLabel.LEFT);
		sugarL.setForeground(fcl);
		sugarL.setOpaque(false);
		sugarL.setBounds(15,120,70,15);
		sugarT=new JTextField();
		sugarT.setBounds(110,120,40,20);
		
		
		bloodpressureL=new JLabel("Blood Pressure",JLabel.LEFT);
		bloodpressureL.setForeground(fcl);
		bloodpressureL.setOpaque(false);
		bloodpressureL.setBounds(15,150,90,25);
		bloodpressureT=new JTextField();
		bloodpressureT.setBounds(110,150,40,20);
		
		
		JLabel lbSac=new JLabel("Sac");
		lbSac.setForeground(fcl);
		lbSac.setOpaque(false);
		lbSac.setBounds(15,180,40,20);
		cbSac=new JComboBox();
	//	cbSac.setFont(fntSac);
		cbSac.setBounds(50,180,160,20);
		
		previous=new JButton("View Previous",new ImageIcon("icons\\back.gif"));
		previous.setBounds(15,230,180,25);
		
		allergyL=new JLabel("Allergy",JLabel.LEFT);
		allergyL.setForeground(fcl);
		allergyL.setOpaque(false);
		allergyL.setBounds(220,25,40,15);
		cballergy=new JComboBox();
		cballergy.setBounds(220,42,140,20);
		cballergy.setEnabled(false);
		btallergy=new JButton("Add");
		btallergy.setBounds(362,42,20,20);
		btallergy.setEnabled(false);
		jspallergy.setBounds(220,70,160,60);
		
		
		currentmediL=new JLabel("Current Medicine",JLabel.LEFT);
		currentmediL.setForeground(fcl);
		currentmediL.setOpaque(false);
		currentmediL.setBounds(410,25,100,15);
		cbcurrentmedi=new JComboBox();
		cbcurrentmedi.setBounds(410,42,200,20);
		cbcurrentmedi.setEnabled(false);
		btcurrentmedi=new JButton("Add");
		btcurrentmedi.setEnabled(false);
		btcurrentmedi.setBounds(613,42,20,20);
		
		jspcurrentmedi.setBounds(410,70,225,60);
		
		commentL=new JLabel("Patient History Remarks",JLabel.LEFT);
		commentL.setForeground(fcl);
		commentL.setOpaque(false);
		commentL.setBounds(220,150,150,15);
	
		jsp.setBounds(220,170,415,80);
		
	//	p1.add(lb);
		p1.add(heightL);
		p1.add(heightT);
		p1.add(hunit);
		p1.add(weightL);
		p1.add(weightT);
		p1.add(wunit);
		p1.add(bloodgroupL);
		p1.add(bloodgroupT);
		p1.add(sugarL);
		p1.add(sugarT);
		p1.add(bloodpressureL);
		p1.add(bloodpressureT);
		p1.add(lbSac);
		p1.add(cbSac);
		p1.add(allergyL);
		p1.add(cballergy);
		p1.add(btallergy);
		p1.add(jspallergy);
		p1.add(currentmediL);
		p1.add(cbcurrentmedi);
		p1.add(btcurrentmedi);
		p1.add(jspcurrentmedi);
		p1.add(commentL);
		p1.add(jsp);
		p1.add(previous);
		
	
	
		cn.add(p1);
		cn.add(nameL);
		cn.add(pnameL);
		cn.add(lb);
		cn.add(lbdate);
		
	//	String pid=pnameL.getText();
	//	System.out.println("pid "+pid);
		
	//	SAVE=new JButton("SAVE");
	//	SAVE.setBounds(275,330,75,20);
	//	CANCEL=new JButton("CANCEL");
	//	CANCEL.setBounds(358,330,80,20);
	//	cn.add(lb);
	//	cn.add(lbt);
	//	cn.add(lbtime);
		
	//	cn.add(p1);
		
	//	cn.add(SAVE);
	//	cn.add(CANCEL);
		
//		dp1.add(patientfrm);
//		patientfrm.setVisible(true);
		
	/*	SAVE.addActionListener(this);
		CANCEL.addActionListener(this);
		bt1.addActionListener(this);
		btallergy.addActionListener(this);
		btcurrentmedi.addActionListener(this);
		SAVED.addActionListener(this);
		SAVEA.addActionListener(this);
		cballergy.addActionListener(this);
		cbcurrentmedi.addActionListener(this);
		allergyLT.addKeyListener(this);
		currentmediLT.addKeyListener(this);*/
		previous.addActionListener(this);
		bt_OK_DIALOG.addActionListener(this);
		
		
		try
		{
		///	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		
		
try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}			
		
		
			qry="Select * from Sac";
			String loadSac[]=inf.getResultSetAs_1D_Array(qry);
			cbSac.addItem("SELECT");
			for(int i=0;i<loadSac.length;i++)
			{
				cbSac.addItem(loadSac[i]);
			}
		}
		catch(Exception ex)
		{
			System.out.println("ERROR!..");
		}
			
		GetInitialInfo();
	
	}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==previous)
	{
		FetchPreviousHistoryFun();
	
	}
	else if(ae.getSource()==bt_OK_DIALOG)
	{
		
		int RWCOUNT=dtm.getRowCount();
		System.out.println("RWCOUNT "+RWCOUNT);
		if(RWCOUNT!=0)
		{
		
			SetParticularHistoryFun();

	    }
	    else if(RWCOUNT==0)
	    {
			 set_DG.dispose();
	    }
	}
}
	
	class SetDialog extends JDialog
	{
		Container cnDIALOG;
		
		
	//	JDialog DG;
		
		public SetDialog(String pid)
		{
			Color clB=new Color(225,248,137);
			String getID=pid;
			System.out.println("dialogID "+getID);
			Font fnt=new Font("Arial NArrow",Font.BOLD,9);
			Color fcl=new Color(0,0,128);
			cnDIALOG=getContentPane();
			cnDIALOG.setLayout(null);
			Color c1=new Color(60,220,220);
 			cnDIALOG.setBackground(c1);
			cnDIALOG.setFont(fnt);
			
			System.out.println("right");
	    	setTitle("Previous Records");
	    	
			
			
	    	JLabel lb1=new JLabel("Patient ID");
	    	lb1.setForeground(fcl);
			lb1.setOpaque(false);
			lb1.setBounds(20,15,80,20);
			L_PID=new JLabel("",JLabel.CENTER);
			L_PID.setForeground(fcl);
			L_PID.setOpaque(true);
			L_PID.setBackground(clB);
			L_PID.setBounds(105,15,140,20);
			L_PID.setText(getID);
			
			jsp_DIALOG.setBounds(20,60,700,250);
			
			
			bt_OK_DIALOG.setBounds(290,330,150,30);
			
			pm.add(del);
			
			cnDIALOG.add(lb1);
			cnDIALOG.add(L_PID);
			cnDIALOG.add(jsp_DIALOG);
			cnDIALOG.add(bt_OK_DIALOG);
		}
	}
	private void GetInitialInfo()
	{
			try
		{
		//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		
try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}			
				
			qry=("Select * from allergyList");
			String loadlt[]=inf.getResultSetAs_1D_Array(qry);
			cballergy.addItem("SELECT");
			for(int i=0;i<loadlt.length;i++)
			{
					cballergy.addItem(loadlt[i]);
			}
			
			qry=("Select * from drug_Master");
			String loadlt1[]=inf.getResultSetAs_1D_Array(qry);
			cbcurrentmedi.addItem("SELECT");
			for(int i=0;i<loadlt1.length;i++)
			{
					cbcurrentmedi.addItem(loadlt1[i]);
			}
			
			qry="Select * from history_Patient where patient_id="+getID+" ORDER by history_date Desc";
			System.out.println("qry "+qry);
			String loadHistory[][]=inf.getResultSetAs_2D_Array(qry,13);
			if(loadHistory==null)
			{
					JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
				
			}
			else
			{
					System.out.println(loadHistory[0][0]);
					
					if((loadHistory[0][1])!=null)
					{
						System.out.println(loadHistory[0][1]);
						heightT.setText(loadHistory[0][1]);
					}
					else
						heightT.setText(" ");
					if((loadHistory[0][2])!=null)
					{
						System.out.println(loadHistory[0][2]);
						weightT.setText(loadHistory[0][2]);	
					}
					else
						weightT.setText(" ");
					if((loadHistory[0][3])!=null)
					{
						System.out.println(loadHistory[0][3]);
						bloodgroupT.setText(loadHistory[0][3]);	
					}
					else
						bloodgroupT.setText(" ");
					if((loadHistory[0][4])!=null)
					{
						System.out.println(loadHistory[0][4]);
						sugarT.setText(loadHistory[0][4]);
					}
					else
						sugarT.setText(" ");
					
					
					if((loadHistory[0][5])!=null)
					{
						System.out.println(loadHistory[0][5]);
						bloodpressureT.setText(loadHistory[0][5]);
					}
					else
						bloodpressureT.setText(" ");
					
					
					if((loadHistory[0][6])!=null)
					{
						cbSac.setSelectedItem(loadHistory[0][6]);
					}
					
						
					System.out.println(loadHistory[0][7]);
					String allergy=loadHistory[0][7];
					
					System.out.println(loadHistory[0][8]);
					String currentmedi=loadHistory[0][8];
					
					
					if((loadHistory[0][9])!=null)
					{
						System.out.println(loadHistory[0][9]);
					commentJ.setText(loadHistory[0][9]);
					}
					else
						commentJ.setText(" ");
					
					
					
					System.out.println(loadHistory[0][10]);
					String history_Date=loadHistory[0][10];
					
					
					
					
					String split_wholeDate[]=history_Date.split("-");
					System.out.println("0-----"+split_wholeDate[0]);
					System.out.println("1-----"+split_wholeDate[1]);
					System.out.println("2-----"+split_wholeDate[2]);
					
					String split_Date[]=split_wholeDate[2].split(" ");
					System.out.println("0--yr--"+split_Date[0]);
					System.out.println("1------"+split_Date[1]);
					
					String split_Time[]=split_Date[1].split(":");
					System.out.println("h "+split_Time[0]);
					System.out.println("Min "+split_Time[1]);
					System.out.println("Sec "+split_Time[2]);
					
					String setDate=split_Date[0]+"/"+split_wholeDate[1]+"/"+split_wholeDate[0]+" "+split_Time[0]+":"+split_Time[1]+":"+split_Time[2];
					System.out.println("setDate "+setDate);
					lbdate.setText(setDate);
					
					if(!allergy.equals(st))
					{
					
						String allergylt[]=allergy.split(",");
						int len=allergylt.length;
						
						for(int k=0;k<len;k++)
						{
						//	allergyLT.requestFocus();
							String addto=allergylt[k];
							System.out.println(k+" "+addto);
							vc.addElement(allergylt[k]);
							allergyLT.setListData(vc);
						}
					}
					
					if(!currentmedi.equals(st))
					{
						String cmedi[]=currentmedi.split(",");
						int len1=cmedi.length;
					
						for(int j=0;j<len1;j++)
						{
						//	currentmediLT.requestFocus();
							String add=cmedi[j];
							System.out.println("add "+add);
							vc1.addElement(cmedi[j]);
							currentmediLT.setListData(vc1);
						}
					}
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..IN GetInitialInfo Method"+ex);
		}
	}
	private void FetchPreviousHistoryFun()
	{
			String pid=pnameL.getText();
		System.out.println("pid "+pid);
	//	int ID=Integer.parseInt(pid);
	//	System.out.println("ID "+ID);
		
		set_DG=new SetDialog(pid);
		dtm.setRowCount(0);
		
		try
		{
	//		ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}		
			qry="Select * from history_Patient where patient_id="+getID+"";
			String loadHistory[][]=inf.getResultSetAs_2D_Array(qry,13);
			if(loadHistory==null)
			{
				JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int len=loadHistory.length;
				System.out.println("len "+len);
				String load[][]=new String[len][11];
				int lenof=load.length;
				System.out.println("lenof "+lenof);
				int R=0,n=1;
				
				for(int start=0,start1=0;start<len;start++)
				{
					
					
				//	System.out.println(loadHistory[start][0]);
					load[start1][0]=""+n;				
				//	System.out.println(load[start][0]);
				//	System.out.println(loadHistory[start][1]);
					load[start1][1]=loadHistory[start][1];	
				//	System.out.println(load[start][1]);
									
				//	System.out.println(loadHistory[start][2]);
					load[start1][2]=loadHistory[start][2];
				//	System.out.println(load[start][2]);
										
				//	System.out.println(loadHistory[start][3]);
					load[start1][3]=loadHistory[start][3];
				//	System.out.println(load[start][3]);
										
				//	System.out.println(loadHistory[start][4]);
					load[start1][4]=loadHistory[start][4];
			    //	System.out.println(load[start][4]);
										
				//	System.out.println(loadHistory[start][5]);
					load[start1][5]=loadHistory[start][5];					
				//	System.out.println(load[start][5]);
					
				//	System.out.println(loadHistory[start][6]);
					load[start1][6]=loadHistory[start][6];
				//	System.out.println(load[start][6]);
										
				//	System.out.println(loadHistory[start][7]);
					load[start1][7]=loadHistory[start][7];
				//	System.out.println(load[start][7]);
										
				//	System.out.println(loadHistory[start][8]);
					load[start1][8]=loadHistory[start][8];					
				//	System.out.println(load[start][8]);
					
				//	System.out.println(loadHistory[start][9]);
					load[start1][9]=loadHistory[start][9];
				//	System.out.println(load[start][9]);	
				
					load[start1][10]=loadHistory[start][10];
				//	System.out.println(loadHistory[start][10]);
				//	load[start1][10]=loadHistory[start][10];				
				//	System.out.println(load[start1][10]);	
					n++;
					start1++;
					
				}
				lenof=load.length;
			//	System.out.println("after loading lenof "+lenof);
				for(int LD=0;LD<len;LD++)
				{
					dtm.addRow(load[LD]);
				}
				
				set_DG.setBounds(230,180,750,410);
				set_DG.setVisible(true);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..IN FetchPreviousHistoryFun Method "+ex);
		}
		
	}
	private void SetParticularHistoryFun()
	{
			int Selected_Row=table.getSelectedRow();
			System.out.println("Selected Row "+Selected_Row);
		//	int Selected_Row=table.getSelectedRow();
		//	System.out.println("Selected Row "+Selected_Row);
			
			if(Selected_Row!=-1)
			{
		
		
				String Selected_Date=""+table.getValueAt(Selected_Row,10);
				System.out.println("Selected date "+Selected_Date);
		
			//	String getID=L_PID.getText();
			//	int ID=Integer.parseInt(getID);
			//	System.out.println("ID "+ID);
		
				String split_wholeDate[]=Selected_Date.split("-");
				System.out.println("0 "+split_wholeDate[0]);
				int Y=Integer.parseInt(split_wholeDate[0]);
		
				System.out.println("1 "+split_wholeDate[1]);
				int M=Integer.parseInt(split_wholeDate[1]);
		
				System.out.println("2 "+split_wholeDate[2]);
		
					
				String split_Date[]=split_wholeDate[2].split(" ");
				System.out.println("0 "+split_Date[0]);
				int D=Integer.parseInt(split_Date[0]);
		
				System.out.println("1 "+split_Date[1]);
		
				String split_Time[]=split_Date[1].split(":");
				System.out.println("0 "+split_Time[0]);
				int H=Integer.parseInt(split_Time[0]);
		
				System.out.println("1 "+split_Time[1]);
				int MIN=Integer.parseInt(split_Time[1]);
		
				System.out.println("2 "+split_Time[2]);
				int S=Integer.parseInt(split_Time[2]);
		
				String set_Date=Y+"/"+M+"/"+D+" "+H+":"+MIN+":"+S;
				System.out.println("set_Date "+set_Date);
		
				try
				{
			//		ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			
			
			
try
							{
								inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
							}
							catch(Exception e)
							{
									System.out.println("Error at the time of connection with server "+getIPaddress.IP()+"..."+e);
							getIPaddress.changeIP();
									try
									{
										inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
											
										
									}
									catch(Exception ex)
									{
										System.out.println("Error at the time of connection with server ip-rmi//127.0.0.1/ExtendZedServer  ..."+ex);
									}
							}				
					qry="Select * from history_Patient where patient_id="+getID+" And history_date=#"+set_Date+"#";
					System.out.println("qry "+qry);
					String loadHistory[][]=inf.getResultSetAs_2D_Array(qry,13);
					if(loadHistory==null)
					{
						JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						vc.removeAllElements();
						allergyLT.setListData(vc);
						vc1.removeAllElements();
						currentmediLT.setListData(vc1);
						int lenof=loadHistory.length;
						System.out.println("lenofSelected "+lenof);
				
						System.out.println("1"+loadHistory[0][1]);
						heightT.setText(loadHistory[0][1]);
						
						System.out.println("2"+loadHistory[0][2]);
						weightT.setText(loadHistory[0][2]);
						
						System.out.println("3"+loadHistory[0][3]);
						bloodgroupT.setText(loadHistory[0][3]);
						
						System.out.println("4"+loadHistory[0][4]);
						sugarT.setText(loadHistory[0][4]);
						
						System.out.println("5"+loadHistory[0][5]);
						bloodpressureT.setText(loadHistory[0][5]);
						
						System.out.println("6"+loadHistory[0][6]);
						cbSac.setSelectedItem(loadHistory[0][6]);
						
						System.out.println("7"+loadHistory[0][7]);
						String allergy=loadHistory[0][7];
						
						System.out.println("8"+loadHistory[0][8]);
						String currentmedi=loadHistory[0][8];
						
						System.out.println("9"+loadHistory[0][9]);
						commentJ.setText(loadHistory[0][9]);
						
						System.out.println("10-------"+loadHistory[0][10]);
						String Get_Date=loadHistory[0][10];
				
				
						String splt_Date[]=Get_Date.split("-");
						System.out.println("0 "+splt_Date[0]);
						Y=Integer.parseInt(splt_Date[0]);
		
						System.out.println("1 "+splt_Date[1]);
						M=Integer.parseInt(splt_Date[1]);
		
						System.out.println("2 "+splt_Date[2]);
		
					
						String split_Date1[]=splt_Date[2].split(" ");
						System.out.println("0 "+split_Date1[0]);
						D=Integer.parseInt(split_Date1[0]);
				
						String split_Time1[]=split_Date1[1].split(":");
						System.out.println("h "+split_Time1[0]);
						System.out.println("min "+split_Time1[1]);
						System.out.println("Sec "+split_Time1[2]);
						String Adjust_Date=D+"/"+M+"/"+Y+" "+split_Time[0]+":"+split_Time[1]+":"+split_Time[2];
						System.out.println("Adjust_Date "+Adjust_Date);
						//System.out.println("1"+loadHistory[0][10]);
						lbdate.setText(Adjust_Date);
				
						if(!allergy.equals(st))
						{
					
							String allergylt[]=allergy.split(",");
							int len=allergylt.length;
						
							for(int k=0;k<len;k++)
							{
							//	allergyLT.requestFocus();
								String addto=allergylt[k];
								System.out.println(k+" "+addto);
								vc.addElement(allergylt[k]);
								allergyLT.setListData(vc);
							}
						}
					
					
						if(!currentmedi.equals(st))
						{
							String cmedi[]=currentmedi.split(",");
							int len1=cmedi.length;
						
						
							for(int j=0;j<len1;j++)
							{
							//	currentmediLT.requestFocus();
								String add=cmedi[j];
								System.out.println("add "+add);
								vc1.addElement(cmedi[j]);
								currentmediLT.setListData(vc1);
							}
						}
				
						set_DG.dispose();
					}
			
			
				}
			
			catch(Exception ex)
			{
				System.out.println("ERROR..IN SetParticularHistoryFun Method"+ex);
			}
		}
		else
		{
		  set_DG.dispose();
		  	//JOptionPane.showMessageDialog(this,"Please Select The Row","Acknowledgement",JOptionPane.ERROR_MESSAGE);
	    }
	}
}