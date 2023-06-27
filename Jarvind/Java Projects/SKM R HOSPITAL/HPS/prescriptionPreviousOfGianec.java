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

class prescriptionPreviousOfGianec extends JDialog implements ActionListener//,MouseListener
{
	JDesktopPane dpp;
	Container cn_New;
	JPanel pn1;
	int prescNo=0;
	JTextArea ta;
	JLabel lbl_dt;
	String head[]={"Sno.","Prescription Date"};
	DefaultTableModel dtm=new DefaultTableModel(head,0);
	JTable table=new JTable(dtm);
	ZedInterface inf;
	//--------upation start ----------
	String heading[]={"Medicine Name","Dosage","Duration","Days","Remarks"};
        DefaultTableModel dtm1=new javax.swing.table.DefaultTableModel(heading,0);
        JTable jTable1;
         
         
         //jTable1.setToolTipText("Select Any Row And Press->( DEL for DELETE ) ( Choose Update/Update Button ) To Update/Delete Item");
         
         DefaultTableCellRenderer CRLeft = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRRight = new DefaultTableCellRenderer();
       		DefaultTableCellRenderer CRCenter = new DefaultTableCellRenderer();
      		
       		//---end------=----------------------------
	
	JScrollPane jsp_DIALOG=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	JLabel lblname,lbl_Pname,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15,lbl16,lbl17,lbl18,L_PID;
	JTextField tf_vre,tf_vle,tf_sre,tf_sle,tf_lre,tf_lle,tf_conre,tf_conle,tf_corre,tf_corle,tf_are,tf_ale,tf_ire,tf_ile,tf_pre,tf_ple,tf_lenre,tf_lenle;
	JTextField tf_tre,tf_tle,tf_gre,tf_gle,tf_ore,tf_ole,tf_fre,tf_fle,tf_rre,tf_rle;
	JButton previous,set_CurrentPres,bt_Close;
	JButton bt_OK_DIALOG=new JButton("OK");
	int getID=0;
	String qry,setip;
	PrescriptionDialog P_DG;
	public prescriptionPreviousOfGianec(JDesktopPane dp,String GetName,int ID)
	{
		
		String Set_PName=GetName;
		System.out.println("Set_PName "+Set_PName);
		getID=ID;
		dpp=dp;
		System.out.println("getID "+getID);
		Font fn1=new Font("Microsoft Sans Serif",Font.BOLD,14);
		cn_New=getContentPane();
		cn_New.setLayout(null);
		setTitle("Previuos Prescription");
		
		
		Color fcl=new Color(0,0,128);
		Font fnt=new Font("Arial NArrow",Font.BOLD,9);
		pn1=new JPanel();
		pn1.setBounds(15,35,520,530);
		pn1.setLayout(null);
	//	p1.setBackground(cl);
		pn1.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Previous Prescription");
		pn1.setBorder(tb);
		pn1.setOpaque(false);
		
		pn1.setFont(fnt);
		
		Color clB=new Color(0,225,225);
		lblname=new JLabel("Name");
		lblname.setForeground(fcl);
		lblname.setOpaque(false);
		lblname.setBounds(20,10,40,20);
		
		lbl_Pname=new JLabel(Set_PName,JLabel.CENTER);
		lbl_Pname.setForeground(fcl);
		lbl_Pname.setOpaque(true);
		lbl_Pname.setBackground(clB);
		lbl_Pname.setBounds(85,10,140,20);
		
		cn_New.add(lblname);
		cn_New.add(lbl_Pname);
		
		
		lbl1=new JLabel("Vision");
		lbl1.setOpaque(true);
		lbl1.setBackground(new Color(174,200,230));
		lbl1.setFont(fn1);
		lbl1.setBounds(10,25,180,20);//5
		pn1.add(lbl1);
		
		lbl2=new JLabel("RE");
		lbl2.setHorizontalAlignment(JLabel.RIGHT);
		lbl2.setBounds(190,25,80,20);//5
		pn1.add(lbl2);
		
		tf_vre=new JTextField("");
		tf_vre.setBounds(270,25,80,20);//5
		pn1.add(tf_vre);
		
		lbl3=new JLabel("LE");
		lbl3.setHorizontalAlignment(JLabel.RIGHT);
		lbl3.setBounds(320,25,80,20);//5
		pn1.add(lbl3);
		
		tf_vle=new JTextField("");
		tf_vle.setBounds(400,25,80,20);//5
		pn1.add(tf_vle);
		
		
		lbl4=new JLabel("Slit Lamp Examination");
		lbl4.setOpaque(true);
		lbl4.setBackground(new Color(174,200,230));
		lbl4.setFont(fn1);
		lbl4.setBounds(10,55,180,20);//35
		pn1.add(lbl4);
		
		lbl5=new JLabel("RE");
		lbl5.setHorizontalAlignment(JLabel.RIGHT);
		lbl5.setBounds(190,75,80,20);//55
		pn1.add(lbl5);
		
		tf_sre=new JTextField("");
		tf_sre.setBounds(270,75,80,20);//55
		pn1.add(tf_sre);
		
		lbl6=new JLabel("LE");
		lbl6.setHorizontalAlignment(JLabel.RIGHT);
		lbl6.setBounds(320,75,80,20);//55
		pn1.add(lbl6);
		
		tf_sle=new JTextField("");
		tf_sle.setBounds(400,75,80,20);//55
		pn1.add(tf_sle);
		
		lbl7=new JLabel("Lid");
		lbl7.setOpaque(true);
		lbl7.setBackground(new Color(174,200,230));
		lbl7.setFont(fn1);
		lbl7.setBounds(10,110,180,20);//90
		pn1.add(lbl7);
		
		tf_lre=new JTextField("");
		tf_lre.setBounds(270,110,80,20);//90
		pn1.add(tf_lre);
		
		tf_lle=new JTextField("");
		tf_lle.setBounds(400,110,80,20);//90
		pn1.add(tf_lle);
		
		lbl8=new JLabel("Conjunctiva -");
		lbl8.setOpaque(true);
		lbl8.setBackground(new Color(174,200,230));
		lbl8.setFont(fn1);
		lbl8.setBounds(10,140,180,20);//120
		pn1.add(lbl8);
		
		tf_conre=new JTextField("");
		tf_conre.setBounds(270,140,80,20);//120
		pn1.add(tf_conre);
		
		tf_conle=new JTextField("");
		tf_conle.setBounds(400,140,80,20);//120
		pn1.add(tf_conle);
		
		lbl9=new JLabel("Cornia");
		lbl9.setOpaque(true);
		lbl9.setBackground(new Color(174,200,230));
		lbl9.setFont(fn1);
		lbl9.setBounds(10,170,180,20);//150
		pn1.add(lbl9);
		
		tf_corre=new JTextField("");
		tf_corre.setBounds(270,170,80,20);//150
		pn1.add(tf_corre);
		
		tf_corle=new JTextField("");
		tf_corle.setBounds(400,170,80,20);//150
		pn1.add(tf_corle);
		
		lbl10=new JLabel("A.C. -");
		lbl10.setOpaque(true);
		lbl10.setBackground(new Color(174,200,230));
		lbl10.setFont(fn1);
		lbl10.setBounds(10,200,180,20);//180
		pn1.add(lbl10);
		
		tf_are=new JTextField("");
		tf_are.setBounds(270,200,80,20);//180
		pn1.add(tf_are);
		
		tf_ale=new JTextField("");
		tf_ale.setBounds(400,200,80,20);//180
		pn1.add(tf_ale);
		
		lbl11=new JLabel("Iris -");
		lbl11.setOpaque(true);
		lbl11.setBackground(new Color(174,200,230));
		lbl11.setFont(fn1);
		lbl11.setBounds(10,230,180,20);//210
		pn1.add(lbl11);
		
		tf_ire=new JTextField("");
		tf_ire.setBounds(270,230,80,20);//210
		pn1.add(tf_ire);
		
		tf_ile=new JTextField("");
		tf_ile.setBounds(400,230,80,20);//210
		pn1.add(tf_ile);
		
		lbl12=new JLabel("Pupil -");
		lbl12.setOpaque(true);
		lbl12.setBackground(new Color(174,200,230));
		lbl12.setFont(fn1);
		lbl12.setBounds(10,260,180,20);//240
		pn1.add(lbl12);
		
		tf_pre=new JTextField("");
		tf_pre.setBounds(270,260,80,20);//240
		pn1.add(tf_pre);
		
		tf_ple=new JTextField("");
		tf_ple.setBounds(400,260,80,20);//240
		pn1.add(tf_ple);
		
		lbl13=new JLabel("Lens -");
		lbl13.setOpaque(true);
		lbl13.setBackground(new Color(174,200,230));
		lbl13.setFont(fn1);
		lbl13.setBounds(10,290,180,20);//270
		pn1.add(lbl13);
		
		tf_lenre=new JTextField("");
		tf_lenre.setBounds(270,290,80,20);//270
		pn1.add(tf_lenre);
		
		tf_lenle=new JTextField("");
		tf_lenle.setBounds(400,290,80,20);//270
		pn1.add(tf_lenle);
		
		lbl14=new JLabel("Tn A -");
		lbl14.setOpaque(true);
		lbl14.setBackground(new Color(174,200,230));
		lbl14.setFont(fn1);
		lbl14.setBounds(10,320,180,20);//300
		pn1.add(lbl14);
		
		tf_tre=new JTextField("");
		tf_tre.setBounds(270,320,80,20);//300
		pn1.add(tf_tre);
		
		tf_tle=new JTextField("");
		tf_tle.setBounds(400,320,80,20);//300
		pn1.add(tf_tle);
		
		lbl15=new JLabel("Gonio -");
		lbl15.setOpaque(true);
		lbl15.setBackground(new Color(174,200,230));
		lbl15.setFont(fn1);
		lbl15.setBounds(10,350,180,20);//330
		pn1.add(lbl15);
		
		tf_gre=new JTextField("");
		tf_gre.setBounds(270,350,80,20);//330
		pn1.add(tf_gre);
		
		tf_gle=new JTextField("");
		tf_gle.setBounds(400,350,80,20);//330
		pn1.add(tf_gle);
		
		lbl16=new JLabel("Ocular Mobility -");
		lbl16.setOpaque(true);
		lbl16.setBackground(new Color(174,200,230));
		lbl16.setFont(fn1);
		lbl16.setBounds(10,380,180,20);//360
		pn1.add(lbl16);
		
		tf_ore=new JTextField("");
		tf_ore.setBounds(270,380,80,20);//360
		pn1.add(tf_ore);
		
		tf_ole=new JTextField("");
		tf_ole.setBounds(400,380,80,20);//360
		pn1.add(tf_ole);
		
		lbl17=new JLabel("Fundus -");
		lbl17.setOpaque(true);
		lbl17.setBackground(new Color(174,200,230));
		lbl17.setFont(fn1);
		lbl17.setBounds(10,410,180,20);//390
		pn1.add(lbl17);
		
		tf_fre=new JTextField("");
		tf_fre.setBounds(270,410,80,20);//390
		pn1.add(tf_fre);
		
		tf_fle=new JTextField("");
		tf_fle.setBounds(400,410,80,20);//390
		pn1.add(tf_fle);
		
		lbl18=new JLabel("Refraction -");
		lbl18.setOpaque(true);
		lbl18.setBackground(new Color(174,200,230));
		lbl18.setFont(fn1);
		lbl18.setBounds(10,440,180,20);//420
		pn1.add(lbl18);
		
		tf_rre=new JTextField("");
		tf_rre.setBounds(270,440,80,20);//420
		pn1.add(tf_rre);
		
		tf_rle=new JTextField("");
		tf_rle.setBounds(400,440,80,20);//420
		pn1.add(tf_rle);
		
		previous=new JButton("View Previous");
		previous.setBounds(15,480,115,20);
		
		pn1.add(previous);
		cn_New.add(pn1);
		
		
	//	setip=getIPaddress.IP();
	//	System.out.println("setip "+setip);
		
		previous.addActionListener(this);
		bt_OK_DIALOG.addActionListener(this);
	//	set_CurrentPres.addActionListener(this);
//		table.addMouseListener(this);
	
		/*try
		{
			ZedInterface inf=(ZedInterface)Naming.lookup(setip);
			qry="Select * from previous_Prescription where Patient_ID="+getID+" ORDER by prescription_date Desc";
			System.out.println("qry "+qry);
			String loadPrescription[][]=inf.getResultSetAs_2D_Array(qry,29);
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
				
				System.out.println("sle1 "+loadPrescription[k][3]);
				tf_sre.setText(loadPrescription[k][3]);
				
				System.out.println("sle2 "+loadPrescription[k][4]);
				tf_sle.setText(loadPrescription[k][4]);
				
				System.out.println("lid1 "+loadPrescription[k][5]);
				tf_lre.setText(loadPrescription[k][5]);
				
				System.out.println("lid2 "+loadPrescription[k][6]);
				tf_lle.setText(loadPrescription[k][6]);
				
				System.out.println("conj1 "+loadPrescription[k][7]);
				tf_conre.setText(loadPrescription[k][7]);
				
				System.out.println("conj2 "+loadPrescription[k][8]);
				tf_conle.setText(loadPrescription[k][8]);
				
				System.out.println("cor 1"+loadPrescription[k][9]);
				tf_corre.setText(loadPrescription[k][9]);
				
				System.out.println("cor 2 "+loadPrescription[k][10]);
				tf_corle.setText(loadPrescription[k][10]);
				
				System.out.println("AC 1"+loadPrescription[k][11]);
				tf_are.setText(loadPrescription[k][11]);
				
				System.out.println("AC 2 "+loadPrescription[k][12]);
				tf_ale.setText(loadPrescription[k][12]);
				
				System.out.println("iris 1"+loadPrescription[k][13]);
				tf_ire.setText(loadPrescription[k][13]);
				
				System.out.println(loadPrescription[k][14]);
				tf_ile.setText(loadPrescription[k][14]);
				
				System.out.println("iris 2"+loadPrescription[k][15]);
				tf_pre.setText(loadPrescription[k][15]);
				
				System.out.println("pp 1 "+loadPrescription[k][16]);
				tf_ple.setText(loadPrescription[k][16]);
				
				System.out.println("pp 2"+loadPrescription[k][17]);
				tf_lenre.setText(loadPrescription[k][17]);
				
				System.out.println("lens 1"+loadPrescription[k][18]);
				tf_lenle.setText(loadPrescription[k][18]);
					
				System.out.println("lens 2"+loadPrescription[k][19]);
				tf_tre.setText(loadPrescription[k][19]);
				
				System.out.println("ten 1"+loadPrescription[k][20]);
				tf_tle.setText(loadPrescription[k][20]);
				
				System.out.println("ten 2"+loadPrescription[k][21]);
				tf_gre.setText(loadPrescription[k][21]);
				
				System.out.println("gonio 1"+loadPrescription[k][22]);
				tf_gle.setText(loadPrescription[k][22]);
				
				System.out.println("gonio 2"+loadPrescription[k][23]);
				tf_ore.setText(loadPrescription[k][23]);
				
				System.out.println("ocu 1"+loadPrescription[k][24]);
				tf_ole.setText(loadPrescription[k][24]);
				
				System.out.println("ocu 2"+loadPrescription[k][25]);
				tf_fre.setText(loadPrescription[k][25]);
				
				System.out.println("Fun1 "+loadPrescription[k][26]);
				tf_fle.setText(loadPrescription[k][26]);
				
				System.out.println("Fun 2"+loadPrescription[k][27]);
				tf_rre.setText(loadPrescription[k][27]);
				
				System.out.println("RF 1"+loadPrescription[k][28]);
				tf_rle.setText(loadPrescription[k][28]);
				
			}
		}
		catch(Exception ex)
		{
			System.out.println("ERROR.."+ex);
		}*/
		
		setip=getIPaddress.IP();
		
	pn1.removeAll();
	
	jTable1=new JTable(dtm1);
         JScrollPane jsp=new JScrollPane(jTable1);
	
	CRLeft.setHorizontalAlignment(JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(JLabel.CENTER);
      		TableColumn column;
			System.out.println("a1");
			column=jTable1.getColumn("Medicine Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(80);
       		//System.out.println("a2");
       		column=jTable1.getColumn("Dosage");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(80);
       		//System.out.println("a3");
       		column=jTable1.getColumn("Duration");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(80);
       		//System.out.println("a4");
       		column=jTable1.getColumn("Days");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(20);
       		//System.out.println("a5");
       		column=jTable1.getColumn("Remarks");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(100);
       		System.out.println("a6");
       		System.out.println("I m working with this file...........S_CHK");
       		
	jsp.setBounds(10,30,500,300);
	pn1.add(jsp);
	
	Color clBK=new Color(225,248,137);
	JLabel lb_dt=new JLabel("DATE");
		lb_dt.setForeground(fcl);
		lb_dt.setOpaque(false);
		lb_dt.setBounds(290,10,60,20);
		cn_New.add(lb_dt);
		
		lbl_dt=new JLabel("");
		lbl_dt.setForeground(fcl);
		lbl_dt.setOpaque(false);
		lbl_dt.setBackground(clBK);
		lbl_dt.setBounds(330,10,140,20);
		cn_New.add(lbl_dt);
	
	ta=new JTextArea();
	JScrollPane jjj=new JScrollPane(ta);
	jjj.setBounds(10,380,500,80);
	pn1.add(jjj);
	
	previous=new JButton("Select Presc.",new ImageIcon("icons\\logo.gif"));
		previous.setBounds(15,480,150,30);
		
		
		set_CurrentPres=new JButton("Set Current Presc.",new ImageIcon("icons\\edit.gif"));
		set_CurrentPres.setBounds(170,480,180,30);
		
		bt_Close=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		bt_Close.setMnemonic('c');
		bt_Close.setBounds(355,480,150,30);
		bt_Close.setToolTipText("Close");
		
		pn1.add(previous);
		pn1.add(set_CurrentPres);
		pn1.add(bt_Close);
		
		pn1.add(previous);
		
		
		try
		{
			dtm1.setRowCount(0);
		//	ZedInterface inf=(ZedInterface)Naming.lookup(setip);
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
							System.out.println("getID ......"+getID);
			String presc=inf.getSingleValue("select prescNo from patient_Presc_Gianec where patientID="+getID);
			if(presc!=null)
			{
				String qry="Select date from patient_Presc_Gianec where patientID="+getID+"";
				String getDt=inf.getSingleValue(qry);
				System.out.println("getDt......."+getDt);
				
				String dt1[]=getDt.split("-");
				System.out.println("year   "+dt1[0]);
				System.out.println("mon   "+dt1[1]);
				
				String dt2[]=dt1[2].split(" ");
				System.out.println("date  "+dt2[0]);
				
				String setDate=dt2[0]+"/"+dt1[1]+"/"+dt1[0];
				System.out.println("setDate  "+setDate);
				
				
				lbl_dt.setText(setDate);
				
				prescNo=Integer.parseInt(presc);
			System.out.println("prescNo  "+prescNo);
			qry="Select medicineNm,dosage,duration,days,remarks from patient_Presc_Gianec_Details where prescNo="+prescNo+"";
			System.out.println("qry "+qry);
			String loadPrescription[][]=inf.getResultSetAs_2D_Array(qry,5);
			if(loadPrescription==null)
			{
				JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				System.out.println("entering   inside........S_CHK ");
				for(int i=0;i<loadPrescription.length;i++)
				{
					System.out.println(i+"............."+loadPrescription[i]);
					dtm1.addRow(loadPrescription[i]);
				}
			}
			qry="select advice from patient_Presc_Gianec where patientID="+getID;
			System.out.println("qry......"+qry);
			String advice=inf.getSingleValue("select advice from patient_Presc_Gianec where patientID="+getID);
			
			System.out.println("advice......"+advice);
			ta.setText(advice);
			}
			else
			{
				javax.swing.JOptionPane.showMessageDialog(this,"No Record Found","Message",javax.swing.JOptionPane.ERROR_MESSAGE);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR.."+ex);
		}
		
		previous.addActionListener(this);
		bt_OK_DIALOG.addActionListener(this);
		set_CurrentPres.addActionListener(this);
		bt_Close.addActionListener(this);
//		table.addMouseListener(this);
	
		
	}
public void actionPerformed(ActionEvent ae)
{

	if(ae.getSource()==previous)
	{
		
		 P_DG=new PrescriptionDialog(getID);
		
		dtm.setRowCount(0);	
		try
		{
	//		ZedInterface inf=(ZedInterface)Naming.lookup(setip);
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
			qry="Select date from patient_Presc_Gianec where patientID="+getID+"";
			System.out.println("qry...................."+qry);
			String loadHistory[]=inf.getResultSetAs_1D_Array(qry);
			if(loadHistory==null)
			{
				JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
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
			System.out.println("ERROR.. "+ex);
		}
		
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
		
			int Selected_Row=table.getSelectedRow();
			System.out.println("Selected Row "+Selected_Row);
			
			if(Selected_Row!=-1)
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
				dtm1.setRowCount(0);
				///ZedInterface inf=(ZedInterface)Naming.lookup(setip);
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
				String q="select prescNo from patient_Presc_Gianec where patientID="+getID+" And date=#"+set_Date+"#";
				String presc=inf.getSingleValue(q);
				//String presc="";
				prescNo=Integer.parseInt(presc);
				qry="Select medicineNm,dosage,duration,days,remarks from patient_Presc_Gianec_Details where prescNo="+prescNo+"";
				System.out.println("qry "+qry);
				String loadPrescription[][]=inf.getResultSetAs_2D_Array(qry,5);
				if(loadPrescription==null)
				{
					JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					for(int i=0;i<loadPrescription.length;i++)
					{
						dtm1.addRow(loadPrescription[i]);
					}
				}
				String advice=inf.getSingleValue("select advice from patient_Presc_Gianec where patientID="+getID);
				ta.setText(advice);
				P_DG.dispose();
			}
			catch(Exception ex)
			{
				System.out.println("ERROR.."+ex);
			}
				//-------------------------------------
		  }
		  else
		  {
		  	P_DG.dispose();
		  //	JOptionPane.showMessageDialog(this,"Please Select The Row","Acknowledgement",JOptionPane.ERROR_MESSAGE);
		  }
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
			Color clB=new Color(0,225,225);
			int getID=pid;
			String setID=""+getID;
			Font fnt=new Font("Arial NArrow",Font.BOLD,9);
			Color fcl=new Color(0,0,128);
			cnDIALOG=getContentPane();
			cnDIALOG.setLayout(null);
			cnDIALOG.setFont(fnt);
			
			System.out.println("right");
	    	setTitle("Previous Prescription Record ");
	    	
			
			
	    	JLabel lb1=new JLabel("Patient ID");
	    	lb1.setForeground(fcl);
			lb1.setOpaque(false);
			lb1.setBounds(20,15,80,20);
			L_PID=new JLabel(setID,JLabel.CENTER);
			L_PID.setForeground(fcl);
			L_PID.setOpaque(true);
			L_PID.setBackground(clB);
			L_PID.setBounds(105,15,140,20);
					
			jsp_DIALOG.setBounds(20,60,250,100);
			
			bt_OK_DIALOG.setBounds(100,200,70,20);
			
		//	pm.add(del);
			
			cnDIALOG.add(lb1);
			cnDIALOG.add(L_PID);
			cnDIALOG.add(jsp_DIALOG);
			cnDIALOG.add(bt_OK_DIALOG);
		}
	}
	private void SetCurrentPresFun()
	{
		
		String getDate=lbl_dt.getText();
		System.out.println("getDate "+getDate);
		NewPatientPrescGianec.hold_Dt=getDate;
		System.out.println("hold_Dt "+NewPatientPrescGianec.hold_Dt);
		
		NewPatientPrescGianec frm=new NewPatientPrescGianec(dpp,getID,NewPatientPrescGianec.hold_Dt);
		this.dispose();
		System.out.println("process Completed........");
		
		
	/*	String getDate=setDtTime;
		System.out.println("getDatesssssssssss= "+getDate);
		PatientPrescription.hold_Dt=setDtTime;
		System.out.println("hold_Dt "+PatientPrescription.hold_Dt);
		
		PatientPrescription frm=new PatientPrescription(dpp,getID,PatientPrescription.hold_Dt);
		this.dispose();*/
	}
}