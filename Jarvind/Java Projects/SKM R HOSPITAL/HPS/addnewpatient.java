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

class addnewpatient extends JFrame implements ActionListener,KeyListener
{
	JInternalFrame patientfrm;
	JDesktopPane Feedp;
	public static String hold_Dt=null;
	Container cn1,cnnext;
	Vector vc,vc1;
	JDialog dg,dgnext;
	JLabel lb,lbt,lbtime,lbdate,PatientL,pid,nameL,ageL,sexL,dobL,addressL,phoneL,gurdianL,referredbyL,cityL,pincodeL,stateL;
	JLabel heightL,weightL,bloodgroupL,sugarL,bloodpressureL,allergyL,currentmediL,commentL;
	JComboBox cb1,cballergy,cbcurrentmedi,cbdrcatnm,cbdrnm,cbSac;
	JButton bt1,refresh,previous,btallergy,btcurrentmedi,SAVE,CLOSE,bt_SaveRef,bt_CloseRef,bt_SaveAllergy,bt_CloseAllergy,bt_addDt,btn_refresh;
	ButtonGroup genGp=new ButtonGroup();
	
	JRadioButton rb1,rb2;
	JTextField nameT,ageT,dobT,phoneT,gurdianT,cityT,pincodeT,stateT;
	JTextField heightT,weightT,bloodgroupT,sugarT,bloodpressureT;
//	JTextArea commentJ;
	JList allergyLT,currentmediLT;
	JPanel p1,p2;
	JTextArea addressT;
	JTextArea commentJ=new JTextArea();
	JScrollPane jsp=new JScrollPane(commentJ);
	JScrollPane jspallergy;
	JScrollPane jspcurrentmedi;
	Date dt;
	JTextField tft1,tftA;
	String st="";
	int load,dcode,code,FLAG=0,add=0;;
	int date1,mon,yer,hr,min,sec,cbcount=0,cbcount1=0;
	String setip,drcat,qry,str="",str1="",getdt;
	ZedInterface inf;
	public addnewpatient(JDesktopPane dp1,String holdDt)
	{
		Feedp=dp1;
		getdt=hold_Dt;
		System.out.println("hold dt"+getdt);
		vc=new Vector();
		vc1=new Vector();
		allergyLT=new JList(vc);
		jspallergy=new JScrollPane(allergyLT,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		currentmediLT=new JList(vc1);
		jspcurrentmedi=new JScrollPane(currentmediLT,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		load=1;
	//	mydialog mydg=new mydialog();
		Color c1=new Color(60,220,220);
		Font fntdialog=new Font("Arial Narrow",Font.BOLD,12);
		
		
		dg=new JDialog (new JFrame(),true);
	    cn1=dg.getContentPane();
	    
	    cn1.setLayout(null);
	  //  Color c1=new Color(60,220,220);
 		cn1.setBackground(c1);
	    dg.setBounds(300,300,250,200);
	    dg.setTitle("ADD NEW REFERENCE");
	    JLabel name=new JLabel("NAME",JLabel.LEFT);
	    name.setOpaque(false);
	    name.setBounds(15,15,50,20);
	    name.setFont(fntdialog);
	    tft1=new JTextField();
    	tft1.setBounds(15,45,200,25);
    	tft1.setFont(fntdialog);
    //	SAVED=new JButton("SAVE");
    	bt_SaveRef=new JButton("Save",new ImageIcon("\\icons\\save.gif"));
    	bt_SaveRef.setMnemonic('s');
    	bt_SaveRef.setBounds(30,95,70,20);
    	bt_SaveRef.setToolTipText("Save");
    	
    //	CANCELED=new JButton("CANCEL");
    	bt_CloseRef=new JButton("Close",new ImageIcon("\\icons\\CLOSE.gif"));
    	bt_CloseRef.setMnemonic('c');
    	bt_CloseRef.setBounds(120,95,90,20);
    	bt_CloseRef.setToolTipText("Close");
    //	JComboBox cbdialog=new JComboBox();
    //	SAVED.setBounds(30,95,70,20);
    
    	
    	
    //	CANCELED.setBounds(120,95,90,20);
    //	cbdialog.setBounds(67,15,155,20);
    	cn1.add(name);
    	cn1.add(tft1);
    	cn1.add(bt_SaveRef);
    	cn1.add(bt_CloseRef);
    //	cn1.add(cbdialog);
    	
		
		dgnext=new JDialog (new JFrame(),true);
	    cnnext=dgnext.getContentPane();
	    cnnext.setLayout(null);
	    //Color c1=new Color(60,220,220);
 		cnnext.setBackground(c1);
	    dgnext.setBounds(300,300,250,200);
	    dgnext.setTitle("ALLERGY LIST");
	    JLabel nameA=new JLabel("NAME",JLabel.LEFT);
	    nameA.setOpaque(false);
	    nameA.setBounds(15,15,50,20);
	    nameA.setFont(fntdialog);
	    tftA=new JTextField();
    	tftA.setBounds(15,45,200,25);
    	tftA.setFont(fntdialog);
    //	SAVEA=new JButton("SAVE");
    	bt_SaveAllergy=new JButton("Save",new ImageIcon("\\icons\\save.gif"));
    	bt_SaveAllergy.setMnemonic('s');
    	bt_SaveAllergy.setBounds(30,95,70,20);
    	bt_SaveAllergy.setToolTipText("Save");
    	
    //	CANCELA=new JButton("CANCEL");
    	
    	bt_CloseAllergy=new JButton("Close",new ImageIcon("\\icons\\CLOSE.gif"));
    	bt_CloseAllergy.setMnemonic('c');
    	bt_CloseAllergy.setBounds(120,95,90,20);
    	bt_CloseAllergy.setToolTipText("Close");
    //	JComboBox cbdialog=new JComboBox();
    //	SAVEA.setBounds(30,95,70,20);
    	
    	
    //	CANCELA.setBounds(120,95,90,20);
    	
    	
    //	cbdialog.setBounds(67,15,155,20);
    	cnnext.add(nameA);
    	cnnext.add(tftA);
    	cnnext.add(bt_SaveAllergy);
    	cnnext.add(bt_CloseAllergy);
		
		patientfrm=new JInternalFrame("ADD PATIENT WINDOW",true,true,false,true);
		Container cn=patientfrm.getContentPane();
		cn.setLayout(null);
		
 		cn.setBackground(c1);
		patientfrm.setBounds(100,50,700,600);
		setTitle("ADD PATIENT WINDOW");

		Color clBK=new Color(225,248,137);

		lb=new JLabel("DATE");
		lb.setOpaque(false);
		lb.setBounds(400,2,50,20);
		dt=new Date();
		date1=dt.getDate();
		mon=1+dt.getMonth();
		yer=1900+dt.getYear();
	/*	int h=dt.getHours();
		int min=dt.getMinutes();
		int sec=dt.getSeconds();*/
		
		String currentDate=date1+"/"+mon+"/"+yer;
		System.out.println("currentDate "+currentDate);
	/*	String mon1=""+mon;
		String condt=""+date1;
		String year1=""+(yer+1900);*/
		//lbdate=new JLabel(condt+"/"+mon1+"/"+year1,JLabel.LEFT);
		if(getdt!=null)
		{
			lbdate=new JLabel(getdt,JLabel.CENTER);
		}
		else
		{
			lbdate=new JLabel(currentDate,JLabel.CENTER);	
		}
		
		lbdate.setOpaque(true);
		lbdate.setBackground(clBK);
		lbdate.setBounds(456,2,120,20);
		
		bt_addDt=new JButton(new ImageIcon("icons\\calendar.gif"));
		bt_addDt.setBounds(580,2,20,20);
		cn.add(bt_addDt);
	/*	lbt=new JLabel("TIME",JLabel.LEFT);
		lbt.setOpaque(false);
		lbt.setBounds(500,20,60,20);*/
		
	/*	hr=dt.getHours();
		min=dt.getMinutes();
		sec=dt.getSeconds();
		String hr1=""+hr;
		String min1=""+min;
		String sec1=""+sec;
		lbtime=new JLabel(hr1+":"+min1+":"+sec1,JLabel.LEFT);
		lbtime.setOpaque(false);
		lbtime.setBounds(570,20,60,20);*/
		
		
	//	hr=dt.getHour();
		
		
		
	//	Color cl=new Color(0,119,119);
		Color fcl=new Color(0,0,128);
		Font fnt=new Font("Arial NArrow",Font.BOLD,9);
		p1=new JPanel();
		p1.setBounds(10,20,670,215);
		p1.setLayout(null);
	//	p1.setBackground(cl);
		p1.setForeground(fcl);
		BevelBorder eb=new BevelBorder(BevelBorder.RAISED);
		TitledBorder tb=new TitledBorder(eb,"Personal Profile");
		p1.setBorder(tb);
		p1.setOpaque(false);
		
		p1.setFont(fnt);
		
		PatientL=new JLabel("Patient ID");
		PatientL.setForeground(fcl);
		PatientL.setOpaque(false);
		PatientL.setBounds(15,20,60,15);
		pid=new JLabel("");
		pid.setOpaque(true);
		pid.setBackground(clBK);
		pid.setBounds(75,20,140,20);
		
		nameL=new JLabel("Name");
		nameL.setForeground(fcl);
		nameL.setOpaque(false);
		nameL.setBounds(15,50,40,15);
		nameT=new JTextField();
		nameT.setBounds(75,50,140,20);
		
		ageL=new JLabel("Age");
		ageL.setForeground(fcl);
		ageL.setOpaque(false);
		ageL.setBounds(15,80,30,15);
		ageT=new JTextField();
		ageT.setBounds(75,80,50,20);
		
		sexL=new JLabel("Sex");
		sexL.setForeground(fcl);
		sexL.setOpaque(false);
		sexL.setBounds(15,110,30,15);
		rb1=new JRadioButton("Male",true);
		rb1.setOpaque(false);
		rb1.setBounds(75,110,60,15);
		rb2=new JRadioButton("Female");
		rb2.setOpaque(false);
		rb2.setBounds(130,110,80,15);
		genGp.add(rb1);
		genGp.add(rb2);
		
		dobL=new JLabel("DOB");
		dobL.setForeground(fcl);
		dobL.setOpaque(false);
		dobL.setBounds(15,140,30,15);
		dobT=new JTextField();
		dobT.setBounds(75,140,50,20);
		
		JLabel drcatnm=new JLabel("Dr.Category");
		drcatnm.setForeground(fcl);
		drcatnm.setOpaque(false);
		drcatnm.setBounds(225,20,70,20);
		cbdrcatnm=new JComboBox();
		cbdrcatnm.setBounds(310,20,130,20);
		
		addressL=new JLabel("Village/Colony");
		addressL.setForeground(fcl);
		addressL.setOpaque(false);
		addressL.setBounds(225,50,80,20);
		addressT=new JTextArea();
		JScrollPane jsp1=new JScrollPane(addressT,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp1.setBounds(310,50,130,30);
		
		phoneL=new JLabel("Phone No.");
		phoneL.setForeground(fcl);
		phoneL.setOpaque(false);
		phoneL.setBounds(240,90,60,20);
		phoneT=new JTextField();
		phoneT.setBounds(310,90,130,20);
		
		gurdianL=new JLabel("Gurdian");
		gurdianL.setForeground(fcl);
		gurdianL.setOpaque(false);
		gurdianL.setBounds(240,120,60,20);
		gurdianT=new JTextField();
		gurdianT.setBounds(310,120,130,20);
		
		referredbyL=new JLabel("Refered By");
		referredbyL.setForeground(fcl);
		referredbyL.setOpaque(false);
		referredbyL.setBounds(240,150,70,20);
		cb1=new JComboBox();
		cb1.setBounds(240,168,180,20);
		bt1=new JButton(new ImageIcon("icons\\new.gif"));
		bt1.setBounds(423,168,20,20);
		
		JLabel drnm=new JLabel("Dr.Name");
		drnm.setForeground(fcl);
		drnm.setOpaque(false);
		drnm.setBounds(460,20,60,20);
		cbdrnm=new JComboBox();
		cbdrnm.setBounds(520,20,130,20);
		
		cityL=new JLabel("Post");
		cityL.setForeground(fcl);
		cityL.setOpaque(false);
		cityL.setBounds(460,50,60,20);
		cityT=new JTextField();
		cityT.setBounds(520,50,130,20);
		
		pincodeL=new JLabel("District");
		pincodeL.setForeground(fcl);
		pincodeL.setOpaque(false);
		pincodeL.setBounds(460,80,70,20);
		pincodeT=new JTextField();
		pincodeT.setBounds(520,80,130,20);
		
		stateL=new JLabel("State");
		stateL.setForeground(fcl);
		stateL.setOpaque(false);
		stateL.setBounds(460,110,70,20);
		stateT=new JTextField();
		stateT.setBounds(520,110,130,20);
		
	//	refresh=new JButton("REFRESH");
	//	refresh.setBounds(530,150,100,20);
		

		p1.add(PatientL);
		p1.add(pid);
		p1.add(nameL);
		p1.add(nameT);
		p1.add(ageL);
		p1.add(ageT);
		p1.add(sexL);
		p1.add(rb1);
		p1.add(rb2);
		p1.add(dobL);
		p1.add(dobT);
		p1.add(drcatnm);
		p1.add(cbdrcatnm);
		p1.add(addressL);
		p1.add(jsp1);
		p1.add(phoneL);
		p1.add(phoneT);
		p1.add(gurdianL);
		p1.add(gurdianT);
		p1.add(referredbyL);
		p1.add(cb1);
		p1.add(bt1);
		p1.add(drnm);
		p1.add(cbdrnm);
		p1.add(cityL);
		p1.add(cityT);
		p1.add(pincodeL);
		p1.add(pincodeT);
		p1.add(stateL);
		p1.add(stateT);
	//	p1.add(refresh);
		
	//	setip=getIPaddress.IP();
	//	System.out.println("setip "+setip);
		
	//	Color cl1=new Color(0,128,64);
		Color fcl1=new Color(0,0,128);
		p2=new JPanel();
		p2.setBounds(10,250,670,275);
		p2.setLayout(null);
		TitledBorder tb1=new TitledBorder(eb,"History");
		p2.setBorder(tb1);
		p2.setOpaque(false);
	//	p2.setBackground(cl1);
		p2.setForeground(fcl1);
		
		heightL=new JLabel("Height");
		heightL.setForeground(fcl);
		heightL.setOpaque(false);
		heightL.setBounds(15,30,40,20);
		JLabel hunit=new JLabel("cm");
		heightT=new JTextField();
		heightT.setBounds(110,30,60,20);
		hunit.setBounds(171,30,18,20);
		
		weightL=new JLabel("Weight");
		weightL.setForeground(fcl);
		weightL.setOpaque(false);
		weightL.setBounds(15,65,60,20);
		JLabel wunit=new JLabel("Kg");
		weightT=new JTextField();
		weightT.setBounds(110,65,60,20);
		wunit.setBounds(171,65,15,20);
		
		bloodgroupL=new JLabel("Blood Group");
		bloodgroupL.setForeground(fcl);
		bloodgroupL.setOpaque(false);
		bloodgroupL.setBounds(15,100,70,20);
		bloodgroupT=new JTextField();
		bloodgroupT.setBounds(110,100,40,20);
		
		
		sugarL=new JLabel("Sugar");
		sugarL.setForeground(fcl);
		sugarL.setOpaque(false);
		sugarL.setBounds(15,135,70,20);
		sugarT=new JTextField();
		sugarT.setBounds(110,135,40,20);
		
		
		bloodpressureL=new JLabel("Blood Pressure");
		bloodpressureL.setForeground(fcl);
		bloodpressureL.setOpaque(false);
		bloodpressureL.setBounds(15,170,90,20);
		bloodpressureT=new JTextField();
		bloodpressureT.setBounds(110,170,40,20);
		
	//	Font fntSac=new Font("Arial Narrow",Font.BOLD,10);
		JLabel lbSac=new JLabel("Sac");
		lbSac.setForeground(fcl);
		lbSac.setOpaque(false);
		lbSac.setBounds(15,205,40,20);
		cbSac=new JComboBox();
	//	cbSac.setFont(fntSac);
		cbSac.setBounds(50,205,160,20);
	//	previous=new JButton("View Previous");
	//	previous.setBounds(15,230,115,20);
		
		allergyL=new JLabel("Allergy");
		allergyL.setForeground(fcl);
		allergyL.setOpaque(false);
		allergyL.setBounds(220,25,40,15);
		cballergy=new JComboBox();
		cballergy.setBounds(220,42,138,20);
		btallergy=new JButton(new ImageIcon("icons\\new.gif"));
		btallergy.setBounds(362,42,20,20);
		jspallergy.setBounds(220,70,160,60);
		
		
		currentmediL=new JLabel("Current Medicine");
		currentmediL.setForeground(fcl);
		currentmediL.setOpaque(false);
		currentmediL.setBounds(410,25,100,15);
		cbcurrentmedi=new JComboBox();
		cbcurrentmedi.setBounds(410,42,200,20);
		btcurrentmedi=new JButton(new ImageIcon("icons\\new.gif"));
		btcurrentmedi.setBounds(613,42,20,20);
		
		jspcurrentmedi.setBounds(410,70,225,60);
		
		commentL=new JLabel("Patient History Remarks");
		commentL.setForeground(fcl);
		commentL.setOpaque(false);
		commentL.setBounds(220,150,150,15);
	
		jsp.setBounds(220,170,415,80);
		
		
		p2.add(heightL);
		p2.add(heightT);
		p2.add(hunit);
		p2.add(weightL);
		p2.add(weightT);
		p2.add(wunit);
		p2.add(bloodgroupL);
		p2.add(bloodgroupT);
		p2.add(sugarL);
		p2.add(sugarT);
		p2.add(bloodpressureL);
		p2.add(bloodpressureT);
		p2.add(lbSac);
		p2.add(cbSac);
		p2.add(allergyL);
		p2.add(cballergy);
		p2.add(btallergy);
		p2.add(jspallergy);
		p2.add(currentmediL);
		p2.add(cbcurrentmedi);
		p2.add(btcurrentmedi);
		p2.add(jspcurrentmedi);
		p2.add(commentL);
		p2.add(jsp);
	//	p2.add(previous);
		
	
	
		SAVE=new JButton("Save",new ImageIcon("icons\\save.gif"));
		SAVE.setMnemonic('s');
		SAVE.setBounds(100,530,150,30);
		SAVE.setToolTipText("Save");
	
	
		btn_refresh=new JButton("Refresh",new ImageIcon("icons\\reset.gif"));
		btn_refresh.setMnemonic('r');
		btn_refresh.setBounds(265,530,150,30);
		btn_refresh.setToolTipText("Refresh");
		
		CLOSE=new JButton("Close",new ImageIcon("icons\\CLOSE.gif"));
		CLOSE.setMnemonic('c');
		CLOSE.setBounds(430,530,150,30);
		CLOSE.setToolTipText("Close");
		
		
		cn.add(lb);
	//	cn.add(lbt);
	//	cn.add(lbtime);
		cn.add(lbdate);
		cn.add(p1);
		cn.add(p2);
		cn.add(SAVE);
		cn.add(CLOSE);
		cn.add(btn_refresh);
		
		dp1.add(patientfrm);
		patientfrm.setVisible(true);
		
		SAVE.addActionListener(this);
		CLOSE.addActionListener(this);
		bt1.addActionListener(this);
		btallergy.addActionListener(this);
		btcurrentmedi.addActionListener(this);
		bt_SaveRef.addActionListener(this);
		bt_CloseRef.addActionListener(this);
		bt_SaveAllergy.addActionListener(this);
		bt_CloseAllergy.addActionListener(this);
		cballergy.addActionListener(this);
		cbcurrentmedi.addActionListener(this);
		cbdrcatnm.addActionListener(this);
		cbdrnm.addActionListener(this);
		allergyLT.addKeyListener(this);
		currentmediLT.addKeyListener(this);
		bt_addDt.addActionListener(this);
		btn_refresh.addActionListener(this);
		
		nameT.addKeyListener(this);
		ageT.addKeyListener(this);
		dobT.addKeyListener(this);
		cbdrcatnm.addKeyListener(this);
		cbdrnm.addKeyListener(this);
		addressT.addKeyListener(this);
		phoneT.addKeyListener(this);
		gurdianT.addKeyListener(this);
		cb1.addKeyListener(this);
		cityT.addKeyListener(this);
		pincodeT.addKeyListener(this);
		stateT.addKeyListener(this);
		rb1.addKeyListener(this);
		rb2.addKeyListener(this);
		
		heightT.addKeyListener(this);
		weightT.addKeyListener(this);
		bloodgroupT.addKeyListener(this);
		sugarT.addKeyListener(this);
		bloodpressureT.addKeyListener(this);
		cbSac.addKeyListener(this);
		allergyLT.addKeyListener(this);
		cballergy.addKeyListener(this);
		cbcurrentmedi.addKeyListener(this);
		commentJ.addKeyListener(this);
		
		
		nameT.requestFocus();
		GetInitialInfo();
	}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==bt_addDt)
	{
		Cal calender=new Cal();
 		String date=calender.getdate();
 		System.out.println("date "+date);
 		lbdate.setText(date);
	}
	else if(ae.getSource()==SAVE)
	{
			if((nameT.getText().equals(st))||(ageT.getText().equals(st)))
			{
				JOptionPane.showMessageDialog(this,"Must Add Name And Age ","Message",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
					String drcatname=""+cbdrcatnm.getSelectedItem();
					String drname=""+cbdrnm.getSelectedItem();
					if(drcatname.equals("SELECT")||(drname.equals("SELECT")))
					{
							JOptionPane.showMessageDialog(this,"Must Add Dr.Category And Dr.Name","Message",JOptionPane.ERROR_MESSAGE);
					}
					else
					{
							
						SavePatientInfo();
			
					}
			}
		
	}
	else if(ae.getSource()==btn_refresh)
	{
		refreshAll();
			
	}
	else if(ae.getSource()==CLOSE)
	{

		patientfrm.dispose();

	}
	else if(ae.getSource()==bt1)
	{
		System.out.println("go");
		dg.setVisible(true);
		
			
	}
	else if(ae.getSource()==cballergy)
	{
		System.out.println("go ");
		String stcb=""+cballergy.getSelectedItem();
		//	TXT.setText(stcb);
		if(!stcb.equals("SELECT"))
		{
		
			int variable=JOptionPane.showConfirmDialog(this,"Do You Want To add?","Message",JOptionPane.YES_NO_OPTION);
			if(variable==JOptionPane.YES_OPTION)
			{
				vc.addElement(stcb);
				allergyLT.setListData(vc);
		//	flag=1;
				allergyLT.setSelectedIndex(cbcount);
				allergyLT.ensureIndexIsVisible(cbcount);
				cbcount++;	
			}
		}	
	}
	else if(ae.getSource()==cbcurrentmedi)
	{
		System.out.println("go ");
		String stcb=""+cbcurrentmedi.getSelectedItem();
		if(!stcb.equals("SELECT"))
		{
		
		//	TXT.setText(stcb);
			int variable=JOptionPane.showConfirmDialog(this,"Do You Want To add?","Message",JOptionPane.YES_NO_OPTION);
			if(variable==JOptionPane.YES_OPTION)
			{
				vc1.addElement(stcb);
				currentmediLT.setListData(vc1);
		//	flag=1;
				currentmediLT.setSelectedIndex(cbcount1);
				currentmediLT.ensureIndexIsVisible(cbcount1);	
				cbcount1++;
			}
		}	
	}
	else if(ae.getSource()==cbdrcatnm)
	{
		cbdrnm.removeAllItems();
		drcat=""+cbdrcatnm.getSelectedItem();
		System.out.println("drcat "+drcat);
		if(!(drcat.equals("SELECT")))
		{
		//	int getdr=Integer.parseInt(drcat);
		//	System.out.println("getdr "+getdr);
			try
			{
			//	ZedInterface patientsd=(ZedInterface)Naming.lookup(getIPaddress.IP());
			
			
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
				String qry1="Select drCatCode from drCategory where drCatName='"+drcat+"'";
				String catcode=inf. getSingleValue(qry1);
				
				code=Integer.parseInt(catcode);
			   System.out.println("code "+code);
				
				qry="Select drName from drDetail where drCatCode="+code+"";
				
				String loaddrnm[]=inf.getResultSetAs_1D_Array(qry);
				cbdrnm.addItem("SELECT");
				for(int i=0;i<loaddrnm.length;i++)
				{
					cbdrnm.addItem(loaddrnm[i]);
				}
			
			}
			catch(Exception ex)
			{
				System.out.println("ERROR "+ex);
			}
							
		}
	}
	else if(ae.getSource()==cbdrnm)
	{
	
		if(!(drcat.equals("SELECT")))
		{
				String drname=""+cbdrnm.getSelectedItem();
				System.out.println("drname here is problem "+drname);
				if(!drname.equals("SELECT") || drname!=null)
				{
				
					try
					{
					//	ZedInterface patientsd=(ZedInterface)Naming.lookup(getIPaddress.IP());
					
//ZedInterface inf=null;
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
					
					
					
					
						String qry1="Select drCode from drDetail where drName='"+drname+"'";
						String drcode=inf. getSingleValue(qry1);
				
						dcode=Integer.parseInt(drcode);
						System.out.println("dcode "+dcode);
							
					}
					catch(Exception ex)
					{
						System.out.println("ERROR "+ex);
					}
			   	}
		}
		
	}
	else if(ae.getSource()==bt_SaveRef)
	{
		if(tft1.getText().equals(st))
		{
			JOptionPane.showMessageDialog(this,"Blank Box Can't Be Saved","Message",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			
			AddNewReferenceFun();
			
	
	    }
	}
	else if(ae.getSource()==bt_CloseRef)
	{
		tft1.setText(st);
		dg.dispose();
	}
	else if(ae.getSource()==btallergy)
	{
		dgnext.setVisible(true);
	}
	else if(ae.getSource()==bt_SaveAllergy)
	{
		if(tftA.getText().equals(st))
		{
			JOptionPane.showMessageDialog(this,"Blank Box Can't Be Saved","Message",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			UpdateAllergyListFun();
			
			
		}
	}
	else if(ae.getSource()==bt_CloseAllergy)
	{
		tftA.setText(st);
		dgnext.dispose();
	}
	else if(ae.getSource()==btcurrentmedi)
	{
		System.out.println("go");
		drugMaster DM=new drugMaster();
		DM.setBounds(300,300,300,300);
		DM.setVisible(true);
	}
	
	
}
public void keyPressed(KeyEvent ke)
	{
		if(ke.getSource()==nameT && ke.getKeyCode()==ke.VK_ENTER)
		{
			ageT.requestFocus();
		}
		else if(ke.getSource()==ageT && ke.getKeyCode()==ke.VK_ENTER)
		{
			rb1.requestFocus();
		}
		else if(ke.getSource()==rb1 && ke.getKeyCode()==ke.VK_ENTER)
		{
			rb2.requestFocus();
		}
		else if(ke.getSource()==rb2 && ke.getKeyCode()==ke.VK_ENTER)
		{
			dobT.requestFocus();
		}
		else if(ke.getSource()==dobT && ke.getKeyCode()==ke.VK_ENTER)
		{
			cbdrcatnm.requestFocus();
		}
		else if(ke.getSource()==cbdrcatnm && ke.getKeyCode()==ke.VK_ENTER)
		{
			addressT.requestFocus();
		}
		else if(ke.getSource()==addressT && ke.getKeyCode()==ke.VK_ENTER)
		{
			phoneT.requestFocus();
		}
		else if(ke.getSource()==phoneT && ke.getKeyCode()==ke.VK_ENTER)
		{
			gurdianT.requestFocus();
		}
		else if(ke.getSource()==gurdianT && ke.getKeyCode()==ke.VK_ENTER)
		{
			cb1.requestFocus();
		}
		else if(ke.getSource()==cb1 && ke.getKeyCode()==ke.VK_ENTER)
		{
			cbdrnm.requestFocus();
		}
		else if(ke.getSource()==cbdrnm && ke.getKeyCode()==ke.VK_ENTER)
		{
			cityT.requestFocus();
		}
		else if(ke.getSource()==cityT && ke.getKeyCode()==ke.VK_ENTER)
		{
			pincodeT.requestFocus();
		}
		else if(ke.getSource()==pincodeT && ke.getKeyCode()==ke.VK_ENTER)
		{
			stateT.requestFocus();
		}
		else if(ke.getSource()==stateT && ke.getKeyCode()==ke.VK_ENTER)
		{
			heightT.requestFocus();
		}
		else if(ke.getSource()==heightT && ke.getKeyCode()==ke.VK_ENTER)
		{
			weightT.requestFocus();
		}
		else if(ke.getSource()==weightT && ke.getKeyCode()==ke.VK_ENTER)
		{
			bloodgroupT.requestFocus();
		}
		else if(ke.getSource()==bloodgroupT && ke.getKeyCode()==ke.VK_ENTER)
		{
			sugarT.requestFocus();
		}
		else if(ke.getSource()==sugarT && ke.getKeyCode()==ke.VK_ENTER)
		{
			bloodpressureT.requestFocus();
		}
		else if(ke.getSource()==bloodpressureT && ke.getKeyCode()==ke.VK_ENTER)
		{
			cbSac.requestFocus();
		}
		else if(ke.getSource()==cbSac && ke.getKeyCode()==ke.VK_ENTER)
		{
			cballergy.requestFocus();
		}
		else if(ke.getSource()==cballergy && ke.getKeyCode()==ke.VK_ENTER)
		{
			cbcurrentmedi.requestFocus();
		}
		else if(ke.getSource()==cbcurrentmedi && ke.getKeyCode()==ke.VK_ENTER)
		{
			commentJ.requestFocus();///////update this line
		}
		else if(ke.getSource()==commentJ && ke.getKeyCode()==ke.VK_ENTER)
		{
			SAVE.requestFocus();
		}
	
		else if(ke.getSource()==allergyLT && ke.getKeyCode()==ke.VK_DELETE)
		{
		//	System.out.println("ok");
			boolean bn=allergyLT.isSelectionEmpty();
			if(bn==false)
			{
				int index=allergyLT.getSelectedIndex();
				vc.removeElementAt(index);
				allergyLT.setListData(vc);
			}
		
		}
		else if(ke.getSource()==currentmediLT && ke.getKeyCode()==ke.VK_DELETE)
		{
		//	System.out.println("ok");
			boolean bn=currentmediLT.isSelectionEmpty();
			if(bn==false)
			{
				int index=currentmediLT.getSelectedIndex();
				vc1.removeElementAt(index);
				currentmediLT.setListData(vc1);
			}
		
		}
	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}
	private void refreshAll()
	{
			nameT.setText(st);
			cbdrcatnm.setSelectedItem("SELECT");
			//	cbdrnm.setSelectedItem("SELECT");
			ageT.setText(st);
			dobT.setText(st);
			addressT.setText(st);
			phoneT.setText(st);
			gurdianT.setText(st);
			cb1.setSelectedItem("SELECT");
			cityT.setText(st);
			pincodeT.setText(st);
			stateT.setText(st);
			rb1.setSelected(true);
						
			heightT.setText(st);
			weightT.setText(st);
			bloodgroupT.setText(st);
			sugarT.setText(st);
			bloodpressureT.setText(st);
			vc.removeAllElements();
			allergyLT.setListData(vc);
			vc1.removeAllElements();
			currentmediLT.setListData(vc1);
			commentJ.setText(st);
			cbSac.setSelectedItem("SELECT");
			nameT.requestFocus();
	}
	private void SavePatientInfo()
	{
			int getvc=vc.size();
			//	System.out.println("getvc "+getvc);
				if(getvc==0)
				{
					str=st;
				}
				else
				{
				
					for(int i=0;i<getvc;i++)
					{
						if(str.equals(st))
						{
							str=""+vc.elementAt(i);
						//	System.out.println("str "+str);
						}
						else
						{
							String str2=""+vc.elementAt(i);
							str=str+","+str2;
						//	System.out.println("str inside"+str);
						}
					}
				}
				int getvc1=vc1.size();
			//	System.out.println("getvc1 "+getvc1);
				if(getvc1==0)
				{
					str1=st;
				}
				else
				{
					for(int j=0;j<getvc1;j++)
					{
						if(str1.equals(st))
						{
							str1=""+vc1.elementAt(j);
					//		System.out.println("str1 "+str1);
						}
						else
						{
							String str2=""+vc1.elementAt(j);
							str1=str1+","+str2;
					//		System.out.println("str1 inside"+str1);
						}
					}
				}
				
			
				String rbSelected;
				if(rb1.isSelected()==true)
					rbSelected=rb1.getText();
				else
					rbSelected=rb2.getText();
	
			//	System.out.println("rbSelected "+rbSelected);
		
				String pidt=pid.getText();
				int sendID=Integer.parseInt(pidt);
		
				
			
				
				Date dt=new Date();
				int day=dt.getDate();
				int mon=dt.getMonth()+1;
				int year=1900+dt.getYear();
				int hr=dt.getHours();
				int min=dt.getMinutes();
				int sec=dt.getSeconds();
				String currentdate=mon+"/"+day+"/"+year;
				String currenttime=hr+":"+min+":"+sec;
			//	System.out.println("currentdate "+currentdate);
			
				String getdt=lbdate.getText();
				String splitdate[]=getdt.split("/");
				currentdate=splitdate[1]+"/"+splitdate[0]+"/"+splitdate[2];
			//	System.out.println("currentdate "+currentdate);
				
				try
				{
				//	ZedInterface patientsd=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
ZedInterface inf=null;
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
				
				
					
					qry="Select MAX(patientid) from patient_Profile";
					int getid=inf.getMaxValue(qry);
			//		System.out.println("getid "+getid);
					String setpid=""+(++getid);
				
					if(pidt.equals(setpid))
					{
				
							
						int variable=JOptionPane.showConfirmDialog(this,"Do you want to change date ?"+lbdate.getText(),"Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);
						if(variable==JOptionPane.NO_OPTION)	
						{
							
							
						variable=JOptionPane.showConfirmDialog(this,"Do You Want To Save This Record","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
						if(variable==JOptionPane.YES_OPTION)
						{
							add=1;
						}
						if(add==1)
						{
				
				
							try
							{
							
								String	qry="insert into patient_Profile values("+sendID+",'"+nameT.getText()+"',"+code+","+dcode+",'"+ageT.getText()+"','"+rbSelected+"','"+dobT.getText()+"','"+addressT.getText()+"','"+phoneT.getText()+"','"+gurdianT.getText()+"','"+(""+cb1.getSelectedItem())+"','"+cityT.getText()+"','"+pincodeT.getText()+"','"+stateT.getText()+"')";
							//	System.out.println("qry "+qry);
								boolean successful1=inf.executeUpdateQuery(qry);
								System.out.println("successful 1"+successful1);
					
					
										
								qry="insert into history_Patient values("+sendID+",'"+heightT.getText()+"','"+weightT.getText()+"','"+bloodgroupT.getText()+"','"+sugarT.getText()+"','"+bloodpressureT.getText()+"','"+(""+cbSac.getSelectedItem())+"','"+str+"','"+str1+"','"+commentJ.getText()+"',#"+currentdate+"#,#"+currenttime+"#,"+true+")";
							//	System.out.println("qry "+qry);
								boolean successful2=inf.executeUpdateQuery(qry);
								System.out.println("successful 2"+successful2);
					
								qry="insert into patient_Date values("+sendID+",#"+currentdate+"#,#"+currenttime+"#)";
								boolean successful3=inf.executeUpdateQuery(qry);
								System.out.println("successful 3"+successful3);
					
					
								if((successful1==true) && (successful2==true) && (successful3==true))
								{
										FLAG=1;
										FeeDetails fee=new FeeDetails(Feedp,sendID,FLAG,getdt);
										patientfrm.dispose();
										nameT.setText(st);
										cbdrcatnm.setSelectedItem("SELECT");
									//	cbdrnm.setSelectedItem("SELECT");
										ageT.setText(st);
										dobT.setText(st);
										addressT.setText(st);
										phoneT.setText(st);
										gurdianT.setText(st);
										cb1.setSelectedItem("SELECT");
										cityT.setText(st);
										pincodeT.setText(st);
										stateT.setText(st);
										rb1.setSelected(true);
										/*if((rb1.isSelected())||(rb2.isSelected()))
										{
											rb1.setSelected(false);
											rb2.setSelected(false);
										}*/
					
										heightT.setText(st);
										weightT.setText(st);
										bloodgroupT.setText(st);
										sugarT.setText(st);
										bloodpressureT.setText(st);
										vc.removeAllElements();
										allergyLT.setListData(vc);
										vc1.removeAllElements();
										currentmediLT.setListData(vc1);
						
										qry="Select MAX(patientid) from patient_Profile";
										getid=inf.getMaxValue(qry);
									//	System.out.println("getid "+getid);
										setpid=""+(++getid);
										pid.setText(setpid);
								}
								else
								{
									JOptionPane.showMessageDialog(this,"Either Patient Profile Or History Not Saved Successfully","Message",JOptionPane.ERROR_MESSAGE);
									patientfrm.dispose();
								}
							
							}
							catch(Exception ex)
							{
								System.out.println("ERROR..IN SavePatientInfo Method"+ex);
							}	
						
			  	  	 	}
							
					}
				}
			   	else
			   	{
			   		JOptionPane.showMessageDialog(this,"ERROR..IN ID Generation Process","Message",JOptionPane.ERROR_MESSAGE);
			   	}
			}			
			catch(Exception ex)
			{
					System.out.println("ERROR..IN ID Generation Process"+ex);
			}	
				
		}
	private void AddNewReferenceFun()	
	{
			String name=tft1.getText();
			System.out.println("name"+name);
			try
			{
		
		
				//ZedInterface patientsd=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
ZedInterface inf=null;
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
				
				
				
				
				
				
				int variable=JOptionPane.showConfirmDialog(this,"Do You Want To Save This Reference","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
				if(variable==JOptionPane.YES_OPTION)
				{
					add=1;
				}
				if(add==1)
				{
					String qury1=("insert into referedBy_Dr values('"+name+"')");
					boolean successful=inf.executeUpdateQuery(qury1);
					if(successful==false)
					{
				
						JOptionPane.showMessageDialog(this,"This Reference Already Exists In The List","Acknowledgement",JOptionPane.PLAIN_MESSAGE);
					}
						
				//	System.out.println("successful ="+successful);
					tft1.setText(st);
				}
			}
			catch(Exception ex)
			{
				System.out.println("Error.."+ex);
			}
	}
	private void UpdateAllergyListFun()
	{
			String name=tftA.getText();
		//	System.out.println("name"+name);
			try
			{
			//	patientInterface patientsd=(patientInterface)Naming.lookup("rmi://127.0.0.1/testing");
			//	ZedInterface patientsd=(ZedInterface)Naming.lookup(getIPaddress.IP());
			
			
ZedInterface inf=null;
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
			
			
			
			
			
				int variable=JOptionPane.showConfirmDialog(this,"Do You Want To Save In The List","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
				if(variable==JOptionPane.YES_OPTION)
				{
					add=1;
				}
				if(add==1)
				{
					String qury1=("insert into allergyList values('"+name+"')");
					boolean successful=inf.executeUpdateQuery(qury1);
					if(successful==false)
					{
				
						JOptionPane.showMessageDialog(this,"Already Exists In The List","Acknowledgement",JOptionPane.PLAIN_MESSAGE);
					}
					
				//	System.out.println("successful ="+successful);
					tftA.setText(st);
				}
			}
			catch(Exception ex)
			{
				System.out.println("ERROR.."+ex);
			}
	}
	private void GetInitialInfo()
	{
		try
		{
			//ZedInterface patientsd=(ZedInterface)Naming.lookup(getIPaddress.IP());
			
			
			
ZedInterface inf=null;
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
			
				
			qry="Select drCatName from drCategory";
			String loaddrcat[]=inf.getResultSetAs_1D_Array(qry);
			cbdrcatnm.addItem("SELECT");
			for(int i=0;i<loaddrcat.length;i++)
			{
					cbdrcatnm.addItem(loaddrcat[i]);
			}
			
			qry=("Select * from referedBy_Dr");
			String loadnm[]=inf.getResultSetAs_1D_Array(qry);
			cb1.addItem("SELECT");
			for(int i=0;i<loadnm.length;i++)
			{
					cb1.addItem(loadnm[i]);
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
			
			qry="Select * from Sac";
			String loadSac[]=inf.getResultSetAs_1D_Array(qry);
			cbSac.addItem("SELECT");
			for(int i=0;i<loadSac.length;i++)
			{
				cbSac.addItem(loadSac[i]);
			}
			
			qry="Select MAX(patientid) from patient_Profile";
			int getid=inf.getMaxValue(qry);
		//	System.out.println("getid "+getid);
			String setpid=""+(++getid);
			pid.setText(setpid);
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..IN GetInitialInfo Method"+ex);
		}
	}
	
}