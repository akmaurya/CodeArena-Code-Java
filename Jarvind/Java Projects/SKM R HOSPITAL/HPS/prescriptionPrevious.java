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

class prescriptionPrevious extends JDialog implements ActionListener//,MouseListener
{
	JDesktopPane dpp;
	Container cn_New;
	JPanel pn1,pn2;


	DefaultTableModel dtm;
	JTable table;
	
	JScrollPane jsp_DIALOG;
	
	JLabel lblname,lbl_Pname,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15,lbl16,lbl17,lbl18,L_PID,lbl_dt;
	JTextField tf_vre,tf_vle,tf_lre,tf_lle,tf_conre,tf_conle,tf_corre,tf_corle,tf_are,tf_ale,tf_ire,tf_ile,tf_pre,tf_ple,tf_lenre,tf_lenle,tf_tre,tf_tle,tf_gre,tf_gle,tf_ore,tf_ole,tf_fre,tf_fle;
//	JTextField tf_tre,tf_tle,tf_gre,tf_gle,tf_ore,tf_ole,tf_fre,tf_fle,tf_rre,tf_rle;
//	JComboBox tf_vre,tf_vle,tf_lre,tf_lle,tf_conre,tf_conle,tf_corre,tf_corle,tf_are,tf_ale,tf_ire,tf_ile,tf_pre,tf_ple,tf_lenre,tf_lenle,tf_tre,tf_tle,tf_ore,tf_ole,tf_fre,tf_fle,Up1,Down1,Right1,Left1,Up2,Down2,Right2,Left2;
	JButton previous,set_CurrentPres,bt_Close;
	JButton bt_OK_DIALOG=new JButton("OK",new ImageIcon("icons\\info.gif"));
	int getID=0;
	String qry,setDtTime;
	PrescriptionDialog P_DG;
	Refraction r;
	ZedInterface inf;
	public prescriptionPrevious(JDesktopPane dp,String GetName,int ID)
	{
		dpp=dp;
				
		String Set_PName=GetName;
		System.out.println("Set_PName "+Set_PName);
		getID=ID;
		System.out.println("getID "+getID);
		Font fn1=new Font("Microsoft Sans Serif",Font.BOLD,14);
		cn_New=getContentPane();
		cn_New.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn_New.setBackground(c1);
		setTitle("Previuos Prescription");
		
		
		
		
		String head[]={"Sno.","Prescription Date"};
		dtm=new DefaultTableModel(head,0);
		table=new JTable(dtm);
	
		jsp_DIALOG=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		Color fcl=new Color(0,0,128);
		Font fnt=new Font("Arial Narrow",Font.BOLD,9);
		pn1=new JPanel();
		pn1.setBounds(15,35,508,450);
		pn1.setLayout(null);
	//	p1.setBackground(cl);
		pn1.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Previous Prescription");
		pn1.setBorder(tb);
		pn1.setOpaque(true);
		
		pn1.setFont(fnt);
		
		
		r=new Refraction();
		r.setBounds(530,35,430,175);
		cn_New.add(r);
		
		
		
		
		
	//	Color clB=new Color(0,225,225);
		Color clBK=new Color(225,248,137);
		lblname=new JLabel("Name");
		lblname.setForeground(fcl);
		lblname.setOpaque(false);
		lblname.setBounds(20,10,40,20);
		
		lbl_Pname=new JLabel(Set_PName,JLabel.CENTER);
		lbl_Pname.setForeground(fcl);
		lbl_Pname.setOpaque(true);
		lbl_Pname.setBackground(clBK);
		lbl_Pname.setBounds(85,10,140,20);
		
		cn_New.add(lblname);
		cn_New.add(lbl_Pname);
		
		JLabel lb_dt=new JLabel("DATE");
		lb_dt.setForeground(fcl);
		lb_dt.setOpaque(false);
		lb_dt.setBounds(290,10,60,20);
		cn_New.add(lb_dt);
		
		lbl_dt=new JLabel("",JLabel.CENTER);
		lbl_dt.setForeground(fcl);
		lbl_dt.setOpaque(true);
		lbl_dt.setBackground(clBK);
		lbl_dt.setBounds(330,10,140,20);
		cn_New.add(lbl_dt);
		
		lbl1=new JLabel("Vision");
		lbl1.setOpaque(true);
		lbl1.setBackground(new Color(174,200,230));
		lbl1.setFont(fn1);
		lbl1.setBounds(10,40,180,20);//5
		pn1.add(lbl1);
		
		lbl2=new JLabel("RE");
		lbl2.setHorizontalAlignment(JLabel.CENTER);
		lbl2.setBounds(270,15,80,20);//5
		pn1.add(lbl2);
		
	//	tf_vre=new JComboBox();
	//	tf_vre.setBounds(270,25,80,20);
		tf_vre=new JTextField("");
		tf_vre.setBounds(270,40,80,20);//5
		pn1.add(tf_vre);
		
		lbl3=new JLabel("LE");
		lbl3.setHorizontalAlignment(JLabel.CENTER);
		lbl3.setBounds(400,15,80,20);//5
		pn1.add(lbl3);
		
	
		tf_vle=new JTextField("");
		tf_vle.setBounds(400,40,80,20);//5
		pn1.add(tf_vle);
		
		
		lbl4=new JLabel("Slit Lamp Examination");
		lbl4.setOpaque(true);
		lbl4.setBackground(new Color(174,200,230));
		lbl4.setFont(fn1);
		lbl4.setBounds(10,70,180,20);//35
		pn1.add(lbl4);
		
		lbl5=new JLabel("RE");
		lbl5.setHorizontalAlignment(JLabel.RIGHT);
		lbl5.setBounds(190,75,80,20);//55
	//	pn1.add(lbl5);
		
	//	tf_sre=new JTextField("");
	//	tf_sre.setBounds(270,75,80,20);//55
		//pn1.add(tf_sre);
		
		lbl6=new JLabel("LE");
		lbl6.setHorizontalAlignment(JLabel.RIGHT);
		lbl6.setBounds(320,75,80,20);//55
	//	pn1.add(lbl6);
		
	//	tf_sle=new JTextField("");
	//	tf_sle.setBounds(400,75,80,20);//55
		//pn1.add(tf_sle);
		
		lbl7=new JLabel("Lid");
		lbl7.setOpaque(true);
		lbl7.setBackground(new Color(174,200,230));
		lbl7.setFont(fn1);
		lbl7.setBounds(10,100,180,20);//90
		pn1.add(lbl7);
		
		//tf_lre=new JComboBox();
		tf_lre=new JTextField("");
		tf_lre.setBounds(270,100,80,20);//90
		pn1.add(tf_lre);
		
		//tf_lle=new JComboBox();
		tf_lle=new JTextField("");
		tf_lle.setBounds(400,100,80,20);//90
		pn1.add(tf_lle);
		
		lbl8=new JLabel("Conjunctiva -");
		lbl8.setOpaque(true);
		lbl8.setBackground(new Color(174,200,230));
		lbl8.setFont(fn1);
		lbl8.setBounds(10,130,180,20);//120
		pn1.add(lbl8);
		
	//	tf_conre=new JComboBox();
		tf_conre=new JTextField("");
		tf_conre.setBounds(270,130,80,20);//120
		pn1.add(tf_conre);
		
	//	tf_conle=new JComboBox();
		tf_conle=new JTextField("");
		tf_conle.setBounds(400,130,80,20);//120
		pn1.add(tf_conle);
		
		lbl9=new JLabel("Cornia");
		lbl9.setOpaque(true);
		lbl9.setBackground(new Color(174,200,230));
		lbl9.setFont(fn1);
		lbl9.setBounds(10,160,180,20);//150
		pn1.add(lbl9);
		
		//tf_corre=new JComboBox();
		tf_corre=new JTextField("");
		tf_corre.setBounds(270,160,80,20);//150
		pn1.add(tf_corre);
		
		//tf_corle=new JComboBox();
		tf_corle=new JTextField("");
		tf_corle.setBounds(400,160,80,20);//150
		pn1.add(tf_corle);
		
		lbl10=new JLabel("A.C. -");
		lbl10.setOpaque(true);
		lbl10.setBackground(new Color(174,200,230));
		lbl10.setFont(fn1);
		lbl10.setBounds(10,190,180,20);//180
		pn1.add(lbl10);
		
	//	tf_are=new JComboBox();
		tf_are=new JTextField("");
		tf_are.setBounds(270,190,80,20);//180
		pn1.add(tf_are);
		
	//	tf_ale=new JComboBox();
	    tf_ale=new JTextField("");
		tf_ale.setBounds(400,190,80,20);//180
		pn1.add(tf_ale);
		
		lbl11=new JLabel("Iris -");
		lbl11.setOpaque(true);
		lbl11.setBackground(new Color(174,200,230));
		lbl11.setFont(fn1);
		lbl11.setBounds(10,220,180,20);//210
		pn1.add(lbl11);
		
	//	tf_ire=new JComboBox();
		tf_ire=new JTextField("");
		tf_ire.setBounds(270,220,80,20);//210
		pn1.add(tf_ire);
		
	//	tf_ile=new JComboBox();
		tf_ile=new JTextField("");
		tf_ile.setBounds(400,220,80,20);//210
		pn1.add(tf_ile);
		
		lbl12=new JLabel("Pupil -");
		lbl12.setOpaque(true);
		lbl12.setBackground(new Color(174,200,230));
		lbl12.setFont(fn1);
		lbl12.setBounds(10,250,180,20);//240
		pn1.add(lbl12);
		
	//	tf_pre=new JComboBox();
		tf_pre=new JTextField("");
		tf_pre.setBounds(270,250,80,20);//240
		pn1.add(tf_pre);
		
	//	tf_ple=new JComboBox();
		tf_ple=new JTextField("");
		tf_ple.setBounds(400,250,80,20);//240
		pn1.add(tf_ple);
		
		lbl13=new JLabel("Lens -");
		lbl13.setOpaque(true);
		lbl13.setBackground(new Color(174,200,230));
		lbl13.setFont(fn1);
		lbl13.setBounds(10,280,180,20);//270
		pn1.add(lbl13);
		
	//	tf_lenre=new JComboBox();
		tf_lenre=new JTextField("");
		tf_lenre.setBounds(270,280,80,20);//270
		pn1.add(tf_lenre);
		
	//	tf_lenle=new JComboBox();
		tf_lenle=new JTextField("");
		tf_lenle.setBounds(400,280,80,20);//270
		pn1.add(tf_lenle);
		
		lbl14=new JLabel("Tn A -");
		lbl14.setOpaque(true);
		lbl14.setBackground(new Color(174,200,230));
		lbl14.setFont(fn1);
		lbl14.setBounds(10,310,180,20);//300
		pn1.add(lbl14);
		
	//	tf_tre=new JComboBox();;
		tf_tre=new JTextField("");
		tf_tre.setBounds(270,310,80,20);//300
		pn1.add(tf_tre);
		
	//	tf_tle=new JComboBox();
		tf_tle=new JTextField("");
		tf_tle.setBounds(400,310,80,20);//300
		pn1.add(tf_tle);
		
		lbl15=new JLabel("Gonio -");
		lbl15.setOpaque(true);
		lbl15.setBackground(new Color(174,200,230));
		lbl15.setFont(fn1);
		lbl15.setBounds(10,340,180,20);//330 
		pn1.add(lbl15);
		
		tf_gre=new JTextField("");
		tf_gre.setBounds(270,340,80,20);//330
		pn1.add(tf_gre);
		
		tf_gle=new JTextField("");
		tf_gle.setBounds(400,340,80,20);//330
		pn1.add(tf_gle);
		
		lbl16=new JLabel("Ocular Mobility -");
		lbl16.setOpaque(true);
		lbl16.setBackground(new Color(174,200,230));
		lbl16.setFont(fn1);
		lbl16.setBounds(10,370,180,20);//360
		pn1.add(lbl16);
		
	//	tf_ore=new JComboBox();
		tf_ore=new JTextField("");
		tf_ore.setBounds(270,370,80,20);//360
		pn1.add(tf_ore);
		
	//	tf_ole=new JComboBox();
		tf_ole=new JTextField("");
		tf_ole.setBounds(400,370,80,20);//360
		pn1.add(tf_ole);
		
		lbl17=new JLabel("Fundus -");
		lbl17.setOpaque(true);
		lbl17.setBackground(new Color(174,200,230));
		lbl17.setFont(fn1);
		lbl17.setBounds(10,400,180,20);//390
		pn1.add(lbl17);
		
	//	tf_fre=new JComboBox();
		tf_fre=new JTextField("");
		tf_fre.setBounds(270,400,210,20);//390
		pn1.add(tf_fre);
		
	//	tf_fle=new JTextField("");
	//	tf_fle.setBounds(400,410,80,20);//390
	//	pn1.add(tf_fle);
		
		lbl18=new JLabel("Refraction -");
		lbl18.setOpaque(true);
		lbl18.setBackground(new Color(174,200,230));
		lbl18.setFont(fn1);
		lbl18.setBounds(10,430,180,20);//420
	//	pn1.add(lbl18);
		
	//	tf_rre=new JTextField("");
	//	tf_rre.setBounds(270,440,80,20);//420
	//	pn1.add(tf_rre);
		
	//	tf_rle=new JTextField("");
	//	tf_rle.setBounds(400,440,80,20);//420
	//	pn1.add(tf_rle);
		
		previous=new JButton("Select Presc.",new ImageIcon("icons\\logo.gif"));
		previous.setBounds(530,330,430,30);//530,35,430,175
		
		
		set_CurrentPres=new JButton("Set Current Presc.",new ImageIcon("icons\\edit.gif"));
		set_CurrentPres.setBounds(530,370,430,30);//530,35,430,175
		
		bt_Close=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		bt_Close.setMnemonic('c');
		bt_Close.setBounds(530,410,430,30);///530,35,430,175
		bt_Close.setToolTipText("Close");
		
	//	pn1.add(previous);
	//	pn1.add(set_CurrentPres);
	//	pn1.add(bt_Close);
		cn_New.add(previous);
		cn_New.add(set_CurrentPres);
		cn_New.add(bt_Close);
		cn_New.add(pn1);
	//	cn_New.add(pn2);
		
	//	setip=getIPaddress.IP();
	//	System.out.println("setip "+setip);
		
		previous.addActionListener(this);
		bt_OK_DIALOG.addActionListener(this);
		set_CurrentPres.addActionListener(this);
		bt_Close.addActionListener(this);
	//	table.addMouseListener(this);
	
		SetTheLastPresFun();
	
	
		
	}
public void actionPerformed(ActionEvent ae)
{

	if(ae.getSource()==previous)
	{
		
		 P_DG=new PrescriptionDialog(getID);
		
		dtm.setRowCount(0);	
		SetPreviousPresFun();
		
	}
	else if(ae.getSource()==set_CurrentPres)
	{
		SetCurrentPresFun();
		
	}
	else if(ae.getSource()==bt_Close)
	{
		this.dispose();
	}
	else if(ae.getSource()==bt_OK_DIALOG)
	{
		int RWCOUNT=dtm.getRowCount();
		System.out.println("RWCOUNT "+RWCOUNT);
		if(RWCOUNT!=0)
		{
			FetchParticularPresFun();
				  
		}
		else if(RWCOUNT==0)
		{
			 P_DG.dispose();
		}
	}
	
}



	class PrescriptionDialog extends JDialog
	{
		Container cnDIALOG;
		
		
	//	JDialog DG;
		
		public PrescriptionDialog(int pid)
		{
		//	Color clB=new Color(0,225,225);
			int getID=pid;
			String setID=""+getID;
			Font fnt=new Font("Arial NArrow",Font.BOLD,9);
			Color fcl=new Color(0,0,128);
			cnDIALOG=getContentPane();
			cnDIALOG.setLayout(null);
			Color c1=new Color(60,220,220);
 			cnDIALOG.setBackground(c1);
			cnDIALOG.setFont(fnt);
			
			System.out.println("right");
	    	setTitle("Previous Prescription Record ");
	    	
			Color clBK=new Color(225,248,137);
			
	    	JLabel lb1=new JLabel("Patient ID");
	    	lb1.setForeground(fcl);
			lb1.setOpaque(false);
			lb1.setBounds(20,15,80,20);
			L_PID=new JLabel(setID,JLabel.CENTER);
			L_PID.setForeground(fcl);
			L_PID.setOpaque(true);
			L_PID.setBackground(clBK);
			L_PID.setBounds(105,15,140,20);
					
			jsp_DIALOG.setBounds(20,60,250,100);
			
			bt_OK_DIALOG.setBounds(70,200,150,30);
			
		//	pm.add(del);
			
			cnDIALOG.add(lb1);
			cnDIALOG.add(L_PID);
			cnDIALOG.add(jsp_DIALOG);
			cnDIALOG.add(bt_OK_DIALOG);
		}
	}
	private void SetPreviousPresFun()
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
		
			qry="Select prescription_date from previous_Prescription where Patient_ID="+getID+"";
			String loadHistory[]=inf.getResultSetAs_1D_Array(qry);
			if(loadHistory==null)
			{
				JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.PLAIN_MESSAGE);
			}
			else
			{
				int len=loadHistory.length;
				System.out.println("len "+len);
				String load[][]=new String[len][2];
				int lenof=load.length;
				System.out.println("lenof "+lenof);
				int R=0,n=1;
				
				for(int start=0,start1=0;start<len;start++)
				{
					
					
				//	System.out.println(loadHistory[start][0]);
					
					load[start1][0]=""+n;				
					load[start1][1]=loadHistory[start];	
				
					n++;
					start1++;
					
				}
				lenof=load.length;
			//	System.out.println("after loading lenof "+lenof);
				for(int LD=0;LD<len;LD++)
				{
					dtm.addRow(load[LD]);
				}
				
				P_DG.setBounds(230,280,300,300);
				P_DG.setVisible(true);
		
			}
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..In SetPreviousPresFun Method "+ex);
		}
	}
	private void FetchParticularPresFun()
	{
		int Selected_Row=table.getSelectedRow();
			System.out.println("Selected Row "+Selected_Row);
			if(Selected_Row==-1)
			{
				P_DG.dispose();
			}
			else if(Selected_Row!=-1)
			{
			
				String Selected_Date=""+table.getValueAt(Selected_Row,1);
				System.out.println("Selected date "+Selected_Date);
		
		
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
				qry="Select * from previous_Prescription where Patient_ID="+getID+" And prescription_date=#"+set_Date+"#";
				System.out.println("qry "+qry);
				String loadPrescription[][]=inf.getResultSetAs_2D_Array(qry,38);
				if(loadPrescription==null)
				{
					JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					int lenof=loadPrescription.length;
					System.out.println("lenof "+lenof);
					int k=0;
					System.out.println(loadPrescription[k][0]);
				
					System.out.println("v1 "+loadPrescription[k][1]);
					tf_vre.setText(loadPrescription[k][1]);
				
					System.out.println("v2 "+loadPrescription[k][2]);
					tf_vle.setText(loadPrescription[k][2]);
				
					System.out.println("lid1 "+loadPrescription[k][3]);
					tf_lre.setText(loadPrescription[k][3]);
				
					System.out.println("lid2 "+loadPrescription[k][4]);
					tf_lle.setText(loadPrescription[k][4]);
				
					System.out.println("conj1 "+loadPrescription[k][5]);
					tf_conre.setText(loadPrescription[k][5]);
				
					System.out.println("conj2 "+loadPrescription[k][6]);
					tf_conle.setText(loadPrescription[k][6]);
				
					System.out.println("cor 1"+loadPrescription[k][7]);
					tf_corre.setText(loadPrescription[k][7]);
				
					System.out.println("cor 2 "+loadPrescription[k][8]);
					tf_corle.setText(loadPrescription[k][8]);
				
					System.out.println("AC 1"+loadPrescription[k][9]);
					tf_are.setText(loadPrescription[k][9]);
				
					System.out.println("AC 2 "+loadPrescription[k][10]);
					tf_ale.setText(loadPrescription[k][10]);
				
					System.out.println("iris 1"+loadPrescription[k][11]);
					tf_ire.setText(loadPrescription[k][11]);
				
					System.out.println(loadPrescription[k][12]);
					tf_ile.setText(loadPrescription[k][12]);
				
					System.out.println("iris 2"+loadPrescription[k][13]);
					tf_pre.setText(loadPrescription[k][13]);
				
					System.out.println("pp 1 "+loadPrescription[k][14]);
					tf_ple.setText(loadPrescription[k][14]);
				
					System.out.println("pp 2"+loadPrescription[k][15]);
					tf_lenre.setText(loadPrescription[k][15]);
				
					System.out.println("lens 1"+loadPrescription[k][16]);
					tf_lenle.setText(loadPrescription[k][16]);
					
					System.out.println("lens 2"+loadPrescription[k][17]);
					tf_tre.setText(loadPrescription[k][17]);
				
					System.out.println("ten 1"+loadPrescription[k][18]);
					tf_tle.setText(loadPrescription[k][18]);
				
					System.out.println("ten 2"+loadPrescription[k][19]);
					tf_gre.setText(loadPrescription[k][19]);
				
					System.out.println("gonio 1"+loadPrescription[k][20]);
					tf_gle.setText(loadPrescription[k][20]);
				
					System.out.println("gonio 2"+loadPrescription[k][21]);
					tf_ore.setText(loadPrescription[k][21]);
				
					System.out.println("ocu 1"+loadPrescription[k][22]);
					tf_ole.setText(loadPrescription[k][22]);
					
					System.out.println("ocu 2"+loadPrescription[k][23]);
					tf_fre.setText(loadPrescription[k][23]);
					
					
					System.out.println("ocu 2"+loadPrescription[k][24]);
					r.jComboBox1.setSelectedItem(loadPrescription[k][24]);
				
					System.out.println("ocu 2"+loadPrescription[k][25]);
					r.jComboBox2.setSelectedItem(loadPrescription[k][25]);
				
					System.out.println("ocu 2"+loadPrescription[k][26]);
					r.jComboBox3.setSelectedItem(loadPrescription[k][26]);
				
					System.out.println("ocu 2"+loadPrescription[k][27]);
					r.jComboBox4.setSelectedItem(loadPrescription[k][27]);
				
					System.out.println("ocu 2"+loadPrescription[k][28]);
					r.jComboBox5.setSelectedItem(loadPrescription[k][28]);
				
					System.out.println("ocu 2"+loadPrescription[k][29]);
					r.jComboBox6.setSelectedItem(loadPrescription[k][29]);
				
					System.out.println("ocu 2"+loadPrescription[k][30]);
					r.jComboBox7.setSelectedItem(loadPrescription[k][30]);
				
					System.out.println("ocu 2"+loadPrescription[k][31]);
					r.jComboBox8.setSelectedItem(loadPrescription[k][31]);
				
					System.out.println("ocu 2"+loadPrescription[k][32]);
					r.jComboBox9.setSelectedItem(loadPrescription[k][32]);
				
					System.out.println("ocu 2"+loadPrescription[k][33]);
					r.jComboBox10.setSelectedItem(loadPrescription[k][33]);
				
					System.out.println("ocu 2"+loadPrescription[k][34]);
					r.jComboBox11.setSelectedItem(loadPrescription[k][34]);
				
					System.out.println("ocu 2"+loadPrescription[k][35]);
					r.jComboBox12.setSelectedItem(loadPrescription[k][35]);
				
									
					System.out.println("Prescription date"+loadPrescription[k][37]);
					String Prescription_Date=loadPrescription[k][37];
					
					String split_wholeDate1[]=Prescription_Date.split("-");
					System.out.println("0"+split_wholeDate1[0]);
					System.out.println("1"+split_wholeDate1[1]);
					System.out.println("2"+split_wholeDate1[2]);
					
					String split_Date1[]=split_wholeDate1[2].split(" ");
					System.out.println("0"+split_Date1[0]);
					System.out.println("1"+split_Date1[1]);
					
					String split_Time1[]=split_Date1[1].split(":");
					System.out.println("h "+split_Time1[0]);
					System.out.println("Min "+split_Time1[1]);
					System.out.println("Sec "+split_Time1[2]);
					
					String setDate=split_Date[0]+"/"+split_wholeDate1[1]+"/"+split_wholeDate1[0];
				
					setDtTime=split_Date[0]+"/"+split_wholeDate1[1]+"/"+split_wholeDate1[0]+" "+split_Time1[0]+":"+split_Time1[1]+":"+split_Time1[2];
					System.out.println("setDtTime "+setDtTime);
					lbl_dt.setText(setDate);
					
			
				 P_DG.dispose();
							
				}
			}
			catch(Exception ex)
			{
				System.out.println("ERROR..IN FetchParticularPresFun Method"+ex);
			}
		  }
	}
	private void SetCurrentPresFun()
	{
		String getDate=setDtTime;
		System.out.println("getDatesssssssssss= "+getDate);
		PatientPrescription.hold_Dt=setDtTime;
		System.out.println("hold_Dt "+PatientPrescription.hold_Dt);
		
		PatientPrescription frm=new PatientPrescription(dpp,getID,PatientPrescription.hold_Dt);
		this.dispose();
	}
	private void SetTheLastPresFun()
	{
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
			qry="Select * from previous_Prescription where Patient_ID="+getID+" ORDER by prescription_date Desc";
			System.out.println("qry "+qry);
			String loadPrescription[][]=inf.getResultSetAs_2D_Array(qry,38);
			if(loadPrescription==null)
			{
				JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				int lenof=loadPrescription.length;
				System.out.println("lenof "+lenof);
				int k=0;
				System.out.println(loadPrescription[k][0]);
				
				System.out.println("v1 "+loadPrescription[k][1]);
				tf_vre.setText(loadPrescription[k][1]);
				
				System.out.println("v2 "+loadPrescription[k][2]);
				tf_vle.setText(loadPrescription[k][2]);
				
				System.out.println("lid1 "+loadPrescription[k][3]);
				tf_lre.setText(loadPrescription[k][3]);
				
				System.out.println("lid2 "+loadPrescription[k][4]);
				tf_lle.setText(loadPrescription[k][4]);
				
				System.out.println("conj1 "+loadPrescription[k][5]);
				tf_conre.setText(loadPrescription[k][5]);
				
				System.out.println("conj2 "+loadPrescription[k][6]);
				tf_conle.setText(loadPrescription[k][6]);
				
				System.out.println("cor 1"+loadPrescription[k][7]);
				tf_corre.setText(loadPrescription[k][7]);
				
				System.out.println("cor 2 "+loadPrescription[k][8]);
				tf_corle.setText(loadPrescription[k][8]);
				
				System.out.println("AC 1"+loadPrescription[k][9]);
				tf_are.setText(loadPrescription[k][9]);
				
				System.out.println("AC 2 "+loadPrescription[k][10]);
				tf_ale.setText(loadPrescription[k][10]);
				
				System.out.println("iris 1"+loadPrescription[k][11]);
				tf_ire.setText(loadPrescription[k][11]);
				
				System.out.println(loadPrescription[k][12]);
				tf_ile.setText(loadPrescription[k][12]);
				
				System.out.println("iris 2"+loadPrescription[k][13]);
				tf_pre.setText(loadPrescription[k][13]);
				
				System.out.println("pp 1 "+loadPrescription[k][14]);
				tf_ple.setText(loadPrescription[k][14]);
				
				System.out.println("pp 2"+loadPrescription[k][15]);
				tf_lenre.setText(loadPrescription[k][15]);
				
				System.out.println("lens 1"+loadPrescription[k][16]);
				tf_lenle.setText(loadPrescription[k][16]);
					
				System.out.println("lens 2"+loadPrescription[k][17]);
				tf_tre.setText(loadPrescription[k][17]);
				
				System.out.println("ten 1"+loadPrescription[k][18]);
				tf_tle.setText(loadPrescription[k][18]);
				
				System.out.println("ten 2"+loadPrescription[k][19]);
				tf_gre.setText(loadPrescription[k][19]);
				
				System.out.println("gonio 1"+loadPrescription[k][20]);
				tf_gle.setText(loadPrescription[k][20]);
				
				System.out.println("gonio 2"+loadPrescription[k][21]);
				tf_ore.setText(loadPrescription[k][21]);
				
				System.out.println("ocu 1"+loadPrescription[k][22]);
				tf_ole.setText(loadPrescription[k][22]);
				
				System.out.println("ocu 2"+loadPrescription[k][23]);
				tf_fre.setText(loadPrescription[k][23]);
				
				System.out.println("ocu 2"+loadPrescription[k][24]);
				r.jComboBox1.setSelectedItem(loadPrescription[k][24]);
				
				System.out.println("ocu 2"+loadPrescription[k][25]);
				r.jComboBox2.setSelectedItem(loadPrescription[k][25]);
				
				System.out.println("ocu 2"+loadPrescription[k][26]);
				r.jComboBox3.setSelectedItem(loadPrescription[k][26]);
				
				System.out.println("ocu 2"+loadPrescription[k][27]);
				r.jComboBox4.setSelectedItem(loadPrescription[k][27]);
				
				System.out.println("ocu 2"+loadPrescription[k][28]);
				r.jComboBox5.setSelectedItem(loadPrescription[k][28]);
				
				System.out.println("ocu 2"+loadPrescription[k][29]);
				r.jComboBox6.setSelectedItem(loadPrescription[k][29]);
				
				System.out.println("ocu 2"+loadPrescription[k][30]);
				r.jComboBox7.setSelectedItem(loadPrescription[k][30]);
				
				System.out.println("ocu 2"+loadPrescription[k][31]);
				r.jComboBox8.setSelectedItem(loadPrescription[k][31]);
				
				System.out.println("ocu 2"+loadPrescription[k][32]);
				r.jComboBox9.setSelectedItem(loadPrescription[k][32]);
				
				System.out.println("ocu 2"+loadPrescription[k][33]);
				r.jComboBox10.setSelectedItem(loadPrescription[k][33]);
				
				System.out.println("ocu 2"+loadPrescription[k][34]);
				r.jComboBox11.setSelectedItem(loadPrescription[k][34]);
				
				System.out.println("ocu 2"+loadPrescription[k][35]);
				r.jComboBox12.setSelectedItem(loadPrescription[k][35]);
		
				
				System.out.println("Prescription date"+loadPrescription[k][37]);
				String Prescription_Date=loadPrescription[k][37];
					
					String split_wholeDate[]=Prescription_Date.split("-");
					System.out.println("0"+split_wholeDate[0]);
					System.out.println("1"+split_wholeDate[1]);
					System.out.println("2"+split_wholeDate[2]);
					
					String split_Date[]=split_wholeDate[2].split(" ");
					System.out.println("0"+split_Date[0]);
					System.out.println("1"+split_Date[1]);
					
					String split_Time[]=split_Date[1].split(":");
					System.out.println("h "+split_Time[0]);
					System.out.println("Min "+split_Time[1]);
					System.out.println("Sec "+split_Time[2]);
					
					String setDate=split_Date[0]+"/"+split_wholeDate[1]+"/"+split_wholeDate[0];
					System.out.println("setDate "+setDate);
				
					String setTime=split_Time[0]+":"+split_Time[1]+":"+split_Time[2];
				
					lbl_dt.setText(setDate);
				
			}
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..IN SetTheLastPresFun Method"+ex);
		}
	}
}