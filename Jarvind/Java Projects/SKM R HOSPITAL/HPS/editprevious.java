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

class editprevious extends JFrame implements ActionListener,KeyListener,MouseListener
{
	JInternalFrame editpatientfrm;
	Container cn1,cnnext;
	Vector vc,vc1;
	JDialog dg,dgnext;
	

	DefaultTableModel dtm;
	JTable table;
	JScrollPane jsp_DIALOG;
	
	JPopupMenu pm=new JPopupMenu();;
	JMenuItem del=new JMenuItem("DELETE");
		
	JLabel lb,lbt,lbtime,lbdate,PatientL,pid,nameL,ageL,sexL,dobL,addressL,phoneL,gurdianL,referredbyL,cityL,pincodeL,stateL;
	JLabel heightL,weightL,bloodgroupL,sugarL,bloodpressureL,allergyL,currentmediL,commentL,L_PID;
	JComboBox cb1,cballergy,cbcurrentmedi,cbdrcatnm,cbdrnm,cbSac;
	JButton bt1,refresh,previous,btallergy,btcurrentmedi,EDIT,CLOSE,bt_SaveRef,bt_CloseRef,bt_SaveAllergy,bt_CloseAllergy,btn_refresh,bt_addDt;
	ButtonGroup genGp=new ButtonGroup();
	
	JRadioButton rb1,rb2;
	JTextField pidT,nameT,ageT,dobT,phoneT,gurdianT,cityT,pincodeT,stateT;
	JTextField heightT,weightT,bloodgroupT,sugarT,bloodpressureT;
//	JTextArea commentJ;
	JList allergyLT,currentmediLT;
	JPanel p1,p2;
	JTextArea commentJ=new JTextArea();
	JTextArea addressT=new JTextArea();
	JScrollPane jsp=new JScrollPane(commentJ);
	JScrollPane jspallergy=new JScrollPane(allergyLT);
	JScrollPane jspcurrentmedi=new JScrollPane(currentmediLT);
	Date dt;
//	JButton SAVED,CANCELED,SAVEA,CANCELA;
	JButton bt_OK_DIALOG=new JButton("OK",new ImageIcon("icons\\info.gif"));
	JTextField tft1,tftA;
	String st="";
	int load,dcode,code;
	int date1,mon,yer,hr,min,sec,cbcount=0,cbcount1=0,add=0;
	String setip,qry,history_Date,str="",str1="";
	SetDialog set_DG;
	ZedInterface inf=null;
	public editprevious(JDesktopPane dp1)
	{
		
		vc=new Vector();
		vc1=new Vector();
		allergyLT=new JList(vc);
		jspallergy=new JScrollPane(allergyLT,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		currentmediLT=new JList(vc1);
		jspcurrentmedi=new JScrollPane(currentmediLT,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		load=1;
	//	mydialog mydg=new mydialog();
		Font fntdialog=new Font("Arial NArrow",Font.BOLD,12);
		Color c1=new Color(60,220,220);
		Color clBK=new Color(225,248,137);
		
		String head[]={"Sno.","Height","Weight","Blood_grp","Sugar","Blood_pre","Sac","Allergy","CuurentMedi","Remarks","History Date"};
		dtm=new DefaultTableModel(head,0);
		table=new JTable(dtm);
	
		jsp_DIALOG=new JScrollPane(table);
		
		
				
		dg=new JDialog (new JFrame(),true);
	    cn1=dg.getContentPane();
	    cn1.setLayout(null);
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
		
		editpatientfrm=new JInternalFrame("EDIT PATIENT WINDOW",true,true,false,true);
		Container cn=editpatientfrm.getContentPane();
		cn.setLayout(null);
	//	Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
		editpatientfrm.setBounds(100,50,700,600);
		setTitle("EDIT PATIENT WINDOW");

		lb=new JLabel("DATE");
		lb.setOpaque(false);
		lb.setBounds(400,2,50,20);
		dt=new Date();
		date1=dt.getDate();
		mon=dt.getMonth();
		yer=dt.getYear();
		String mon1=""+mon;
		String condt=""+date1;
		String year1=""+(yer+1900);
		lbdate=new JLabel("",JLabel.CENTER);
		lbdate.setOpaque(true);
		lbdate.setBackground(clBK);
		lbdate.setBounds(456,2,120,20);
		
		bt_addDt=new JButton(new ImageIcon("icons\\calendar.gif"));
		bt_addDt.setBounds(580,2,20,20);
		bt_addDt.setEnabled(false);
		cn.add(bt_addDt);
		
	
		
		
		
	//	Color cl=new Color(0,119,119);
		Color fcl=new Color(0,0,128);
		Font fnt=new Font("Arial NArrow",Font.BOLD,9);
		p1=new JPanel();
		p1.setBounds(10,25,670,215);
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
		PatientL.setBounds(15,20,60,20);
		pidT=new JTextField();
		pidT.setBounds(75,20,140,20);
		
		nameL=new JLabel("Name");
		nameL.setForeground(fcl);
		nameL.setOpaque(false);
		nameL.setBounds(15,50,40,20);
		nameT=new JTextField();
		nameT.setBounds(75,50,140,20);
		
		ageL=new JLabel("Age");
		ageL.setForeground(fcl);
		ageL.setOpaque(false);
		ageL.setBounds(15,80,30,20);
		ageT=new JTextField();
		ageT.setBounds(75,80,50,20);
		
		sexL=new JLabel("Sex");
		sexL.setForeground(fcl);
		sexL.setOpaque(false);
		sexL.setBounds(15,110,30,20);
		rb1=new JRadioButton("Male");
		rb1.setOpaque(false);
		rb1.setBounds(75,110,60,20);
		rb2=new JRadioButton("Female");
		rb2.setOpaque(false);
		rb2.setBounds(130,110,80,20);
		genGp.add(rb1);
		genGp.add(rb2);
		
		dobL=new JLabel("DOB");
		dobL.setForeground(fcl);
		dobL.setOpaque(false);
		dobL.setBounds(15,140,30,20);
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
		JScrollPane jsp1=new JScrollPane(addressT);
		jsp1.setBounds(310,50,130,30);
		
		phoneL=new JLabel("Phone No.");
		phoneL.setForeground(fcl);
		phoneL.setOpaque(false);
		phoneL.setBounds(240,90,60,15);
		phoneT=new JTextField();
		phoneT.setBounds(310,90,130,20);
		
		gurdianL=new JLabel("Gurdian");
		gurdianL.setForeground(fcl);
		gurdianL.setOpaque(false);
		gurdianL.setBounds(240,120,60,15);
		gurdianT=new JTextField();
		gurdianT.setBounds(310,120,130,20);
		
		referredbyL=new JLabel("Refered By");
		referredbyL.setForeground(fcl);
		referredbyL.setOpaque(false);
		referredbyL.setBounds(240,150,70,15);
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
		cityL.setBounds(460,50,40,20);
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
		p1.add(pidT);
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
		hunit.setBounds(171,30,18,15);
		
		weightL=new JLabel("Weight");
		weightL.setForeground(fcl);
		weightL.setOpaque(false);
		weightL.setBounds(15,65,60,20);
		JLabel wunit=new JLabel("Kg");
		weightT=new JTextField();
		weightT.setBounds(110,65,60,20);
		wunit.setBounds(171,65,15,15);
		
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
		
		
	//	Font fntSac=new Font("Times New Roman",Font.BOLD,8);
		JLabel lbSac=new JLabel("Sac");
		lbSac.setForeground(fcl);
		lbSac.setOpaque(false);
		lbSac.setBounds(15,205,40,20);
		cbSac=new JComboBox();
	//	cbSac.setFont(fntSac);
		cbSac.setBounds(50,205,160,20);
		
		previous=new JButton("View Previous",new ImageIcon("icons\\back.gif"));
		previous.setBounds(15,240,180,20);//15,230,180,25);
		
		allergyL=new JLabel("Allergy",JLabel.LEFT);
		allergyL.setForeground(fcl);
		allergyL.setOpaque(false);
		allergyL.setBounds(220,25,40,15);
		cballergy=new JComboBox();
		cballergy.setBounds(220,42,140,20);
		btallergy=new JButton(new ImageIcon("icons\\new.gif"));
		btallergy.setBounds(362,42,20,20);
		jspallergy.setBounds(220,70,160,60);
		
		
		currentmediL=new JLabel("Current Medicine",JLabel.LEFT);
		currentmediL.setForeground(fcl);
		currentmediL.setOpaque(false);
		currentmediL.setBounds(410,25,100,15);
		cbcurrentmedi=new JComboBox();
		cbcurrentmedi.setBounds(410,42,200,20);
		btcurrentmedi=new JButton(new ImageIcon("icons\\new.gif"));
		btcurrentmedi.setBounds(613,42,20,20);
		
		jspcurrentmedi.setBounds(410,70,225,60);
		
		commentL=new JLabel("Patient History Remarks",JLabel.LEFT);
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
		p2.add(previous);
		
	
		EDIT=new JButton("Edit",new ImageIcon("icons\\edit.gif"));
		EDIT.setMnemonic('e');
		EDIT.setBounds(100,530,150,30);
		EDIT.setToolTipText("Edit");
	
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
		cn.add(EDIT);
		cn.add(btn_refresh);
		cn.add(CLOSE);
		
		dp1.add(editpatientfrm);
		editpatientfrm.setVisible(true);
		
		EDIT.addActionListener(this);
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
		//pidT.addKeyListener(this);
		cbdrcatnm.addActionListener(this);
		cbdrnm.addActionListener(this);
		allergyLT.addKeyListener(this);
		currentmediLT.addKeyListener(this);
		previous.addActionListener(this);
		bt_OK_DIALOG.addActionListener(this);
		table.addMouseListener(this);
		del.addActionListener(this);
		btn_refresh.addActionListener(this);
		bt_addDt.addActionListener(this);
		
		
		
		pidT.addKeyListener(this);
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
		
		pidT.requestFocus();
		
		
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
	else if(ae.getSource()==EDIT)
	{
		
		if(pidT.getText().equals(st))
		{
			JOptionPane.showMessageDialog(this,"Please Enter ID And Press Enter","Acknowledgement",JOptionPane.ERROR_MESSAGE);	
		}
		else
		{
				
		//	System.out.println("set_Date "+set_Date);
		
			String drcatname=""+cbdrcatnm.getSelectedItem();
			String drname=""+cbdrnm.getSelectedItem();
		
			/*	String st1=nameT.getText();
				String st4=addressT.getText();
				String st5=phoneT.getText();*/
				
				if((nameT.getText().equals(st))||(ageT.getText().equals(st)))
				{
					JOptionPane.showMessageDialog(this,"Must Add Name And Age ","Message",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
						if(drcatname.equals("SELECT")||(drname.equals("SELECT")))
						{
							JOptionPane.showMessageDialog(this,"Must Add Dr.Category And Dr.Name","Message",JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							
							
							EditPatientInfo();
				
				}
			}
		}
		
	}
	
	else if(ae.getSource()==btn_refresh)
	{
		refreshAll();
	}
	else if(ae.getSource()==CLOSE)
	{
		editpatientfrm.dispose();
	}
	else if(ae.getSource()==cbdrcatnm)
	{
		cbdrnm.removeAllItems();
		cbdrnm.addItem("SELECT");
		String drcat=""+cbdrcatnm.getSelectedItem();
		if(!drcat.equals("SELECT"))
		{
		//	int getdr=Integer.parseInt(drcat);
		//	System.out.println("getdr "+getdr);
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
		String drname=""+cbdrnm.getSelectedItem();
		System.out.println("drname "+drname);
		if(!drname.equals("SELECT") || drname!=null)
		{
		
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
	else if(ae.getSource()==previous)
	{
		if(pidT.getText().equals(st))
		{
			JOptionPane.showMessageDialog(this,"Please Enter ID And Press Enter","Acknowledgement",JOptionPane.ERROR_MESSAGE);	
		}
		else
		{
			ViewPreviousRecordFun();
		}
	}
	else if(ae.getSource()==bt_OK_DIALOG)
	{
		if(dtm.getRowCount()>0)
		{
			SetParticularHistoryFun();
		}
		else
		{
			set_DG.dispose();
		}
	}
	else if(ae.getSource()==bt1)
	{
		System.out.println("go");
		dg.setVisible(true);
		
			
	}
	else if(ae.getSource()==cballergy)
	{
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
	else if(ae.getSource()==del)////////////////to delete record from list/////////////////////
	{
		DeletePatientRecordFun();
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
			EDIT.requestFocus();
		}
		else if(ke.getSource()==allergyLT && ke.getKeyCode()==ke.VK_DELETE)
		{
			System.out.println("ok");
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
			System.out.println("ok");
			boolean bn=currentmediLT.isSelectionEmpty();
			if(bn==false)
			{
				int index=currentmediLT.getSelectedIndex();
				vc1.removeElementAt(index);
				currentmediLT.setListData(vc1);
			}
		
		}
		else if(ke.getSource()==pidT && ke.getKeyCode()==ke.VK_ENTER)
		{
			System.out.println("oksssssssssssssssssssssssssssssssssssssssss");
			
			if(pidT.getText().equals(st))
			{
				System.out.println("ok11sssssssssssssssssssssssssssssssssssssssss11");
				JOptionPane.showMessageDialog(this,"Please Enter ID And Press Enter","Acknowledgement",JOptionPane.ERROR_MESSAGE);	
			}
			else
			{
				System.out.println("ok222sssssssssssssssssssssssssssssssssssssssss2222");
				int chkCORRECTID=0;
				nameT.setText(st);
				ageT.setText(st);
				dobT.setText(st);
				addressT.setText(st);
				phoneT.setText(st);
				gurdianT.setText(st);
				cb1.setSelectedItem(0);
				cityT.setText(st);
				pincodeT.setText(st);
				stateT.setText(st);
		//	rb1.setSelected(false);
		//	rb2.setSelected(false);
				if((rb1.isSelected())||(rb2.isSelected()))
				{
					rb1.setSelected(false);
					rb2.setSelected(false);
				}
		
				heightT.setText(st);
				weightT.setText(st);
				bloodgroupT.setText(st);
				sugarT.setText(st);
				bloodpressureT.setText(st);
				
			
				vc.removeAllElements();
				allergyLT.setListData(vc);
				vc1.removeAllElements();
				currentmediLT.setListData(vc1);
				String getid="";
				int sendID=0,checkedID=0;
				try
				{
					getid=pidT.getText()	;
					sendID=Integer.parseInt(getid);
					///ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
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
					
					
					
					
					
					
				
					qry="Select patientid from patient_Profile where patientid="+sendID+"";
					String loadID=inf.getSingleValue(qry);
					if(loadID!=null)
					{
						if(getid.equals(loadID))
						{
								chkCORRECTID=1;
								checkedID=Integer.parseInt(getid);
						}
						
														
					}			
					else
					{
						JOptionPane.showMessageDialog(this,"Wrong ID","Message",JOptionPane.ERROR_MESSAGE);						
					}
					if(chkCORRECTID==1)
					{
						
						FetchPatientDetailFun(checkedID,chkCORRECTID);
					//	chkCORRECTID=0;
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Please Input CorrectID (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);
				}
		
		}
  	}
  	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}
	
	public void mousePressed(MouseEvent me)
	{
		System.out.println("go");
		if(me.getSource()==table)
		{
			if(me.getModifiers()==4)
			{
				pm.show(table,me.getX(),me.getY());
			}
		}
		
	}
	public void mouseClicked(MouseEvent me)
	{}
	public void mouseReleased(MouseEvent me)
	{}
	public void mouseEntered(MouseEvent me)
	{
	}
	public void mouseExited(MouseEvent me)
	{}
	
	class SetDialog extends JDialog
	{
		Container cnDIALOG;
		
		
	//	JDialog DG;
		
		public SetDialog(String pid)
		{
			Color c1=new Color(60,220,220);
			Color clBK=new Color(225,248,137);
			String getID=pid;
			Font fnt=new Font("Arial NArrow",Font.BOLD,9);
			Color fcl=new Color(0,0,128);
			cnDIALOG=getContentPane();
			cnDIALOG.setLayout(null);
			cnDIALOG.setBackground(c1);
			cnDIALOG.setFont(fnt);
			
		//	System.out.println("right");
	    	setTitle("Previous Records");
	    	
			
			
	    	JLabel lb1=new JLabel("Patient ID");
	    	lb1.setForeground(fcl);
			lb1.setOpaque(false);
			lb1.setBounds(20,15,80,20);
			L_PID=new JLabel("",JLabel.CENTER);
			L_PID.setForeground(fcl);
			L_PID.setOpaque(true);
			L_PID.setBackground(clBK);
			L_PID.setBounds(105,15,140,20);
			L_PID.setText(getID);
			
			jsp_DIALOG.setBounds(20,60,700,250);
			
			
			bt_OK_DIALOG.setBounds(300,330,150,30);//290,330,150,30
			
			pm.add(del);
			
			cnDIALOG.add(lb1);
			cnDIALOG.add(L_PID);
			cnDIALOG.add(jsp_DIALOG);
			cnDIALOG.add(bt_OK_DIALOG);
		}
	}
	
	private void refreshAll()
	{
		pidT.setText("");
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
			pidT.requestFocus();
	}
	private void EditPatientInfo()
	{
		int edit=0;
		
		
	    	String pid=pidT.getText();
			int ID=Integer.parseInt(pid);
			System.out.println("ID "+ID);
		
			String get_Date=history_Date;
			System.out.println("getdate "+get_Date);
			if(get_Date!=null)
			{
				String split_wholeDate[]=get_Date.split("-");
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
			System.out.println("setdate "+set_Date);
		
	        int getvc=vc.size();
			System.out.println("getvc "+getvc);
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
						System.out.println("str "+str);
					}
					else
					{
						String str2=""+vc.elementAt(i);
						str=str+","+str2;
						System.out.println("str inside"+str);
					}
				}
			}
			int getvc1=vc1.size();
			System.out.println("getvc1 "+getvc1);
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
						System.out.println("str1 "+str1);
					}
					else
					{
						String str2=""+vc1.elementAt(j);
						str1=str1+","+str2;
						System.out.println("str1 inside"+str1);
					}
				}
			}
				
			
			String rbSelected="";
			if(rb1.isSelected()==true)
				rbSelected=rb1.getText();
			else if(rb2.isSelected()==true)
				rbSelected=rb2.getText();
						System.out.println("rbSelected "+rbSelected);
		
			String pidt=pidT.getText();
			int sendID=Integer.parseInt(pidt);
		
		
				
			Date dt=new Date();
			int day=dt.getDate();
			int mon=1+dt.getMonth();
			int year=1900+dt.getYear();
			int hr=dt.getHours();
			int min=dt.getMinutes();
			int sec=dt.getSeconds();
			//	String currentdate=mon+"/"+day+"/"+year+" "+hr+":"+min+":"+sec;
			//	System.out.println("currentdate "+currentdate);
				
		
				
				
				
			int variable=JOptionPane.showConfirmDialog(this,"Do You Want To Edit This Record","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
			if(variable==JOptionPane.YES_OPTION)
			{
						edit=1;
			}
			if(edit==1)
			{
				
					try
					{
					///		ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
					
					
					
					
					
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
						
				
				//	System.out.println("qry12 "+qry12);
				
							qry="Update patient_Profile set name='"+nameT.getText()+"',drCatCode="+code+",drCode="+dcode+",age='"+ageT.getText()+"',gender='"+rbSelected+"',dob='"+dobT.getText()+"',address='"+addressT.getText()+"',phone_no='"+phoneT.getText()+"',gurdian='"+gurdianT.getText()+"',refered_by='"+(""+cb1.getSelectedItem())+"',city='"+cityT.getText()+"',pincode='"+pincodeT.getText()+"',state='"+stateT.getText()+"' where patientid="+ID+"";
					//	System.out.println("qry "+qry);
						boolean successful1=inf.executeUpdateQuery(qry);
					//	System.out.println("successful 1"+successful1);
				
					
				//	System.out.println("qry13 "+qry13);
				//	qry="Update history_Patient set height='"+stp1+"',weight='"+stp2+"',blood_grp='"+stp3+"',sugar='"+stp4+"',blood_pr='"+stp5+"',allergy='"+stp6+"',current_medi='"+stp7+"',patient_remark='"+stp8+"'where patient_id="+ID+" And history_date=#"+set_Date+"#";
					
					
							qry="Update history_Patient set height='"+heightT.getText()+"',weight='"+weightT.getText()+"',blood_grp='"+bloodgroupT.getText()+"',sugar='"+sugarT.getText()+"',blood_pr='"+bloodpressureT.getText()+"',Sac='"+(""+cbSac.getSelectedItem())+"',allergy='"+str+"',current_medi='"+str1+"',patient_remark='"+commentJ.getText()+"'where patient_id="+ID+" And history_date=#"+set_Date+"#";
					//	System.out.println("qry "+qry);
						boolean successful2=inf.executeUpdateQuery(qry);
					//	System.out.println("successful 2"+successful2);
					
				
							pidT.setText(st);
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
							if((rb1.isSelected())||(rb2.isSelected()))
							{
								rb1.setSelected(false);
								rb2.setSelected(false);
							}
							lbdate.setText(st);
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
							pidT.requestFocus();
					
										
					}
					catch(Exception ex)
					{
						System.out.println("ERROR..IN EditPatientInfo Method"+ex);
					}
			  }
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Data Can't Be Updated","Message",JOptionPane.INFORMATION_MESSAGE);
			}
		
			
	}
	int iq=1;
	private void FetchPatientDetailFun(int checkedID,int chkCORRECTID)/////////ON ENTER KEY//////////////////
	{
		int chkCORRECTID1=0;
		int sendID=checkedID;
		int chkCORRECTID3=chkCORRECTID;
	
					
					try
					{
						System.out.println("SKM_R............................."+iq++);
			///			ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			
			
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
			
			
			
						qry="Select * from patient_Profile where patientid="+sendID+"";
						String loadprofile[][]=inf.getResultSetAs_2D_Array(qry,14);
						if(loadprofile==null)
						{
							JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
				
						}
						else
						{
							int dr_cat=0;
							System.out.println(loadprofile[0][1]);
							nameT.setText(loadprofile[0][1]);
				
							System.out.println(loadprofile[0][2]);
							String drcat=loadprofile[0][2];
							System.out.println("Drcode ...."+drcat);
							if(!drcat.equals(st))
							{
								dr_cat=Integer.parseInt(drcat);
								System.out.println("dr_cat "+dr_cat);
								qry="Select drCatName from drCategory where drCatCode="+dr_cat+"";
								System.out.println("qry "+qry);
								String drCatNM=inf.getSingleValue(qry);
								cbdrcatnm.setSelectedItem(drCatNM);
							}
				
				
							System.out.println(loadprofile[0][3]);
							String drcd=loadprofile[0][3];
				
							if(!drcd.equals(st))
							{
								int dr_cd=Integer.parseInt(drcd);
								qry="Select drName from drDetail where drCatCode="+dr_cat+" AND drCode="+dr_cd+"";
								System.out.println("qry "+qry);
								String drNM=inf.getSingleValue(qry);
								cbdrnm.setSelectedItem(drNM);
							}	
				
				
				
							System.out.println(loadprofile[0][4]);
							ageT.setText(loadprofile[0][4]);
					
							System.out.println(loadprofile[0][5]);
							String gender=loadprofile[0][5];
				
							if(gender.equals("Male"))
							rb1.setSelected(true);
							else if(gender.equals("Female"))
							rb2.setSelected(true);
							else if(gender.equals(st))
							{
				
								rb1.setSelected(false);
								rb2.setSelected(false);
							}
				
							System.out.println(loadprofile[0][6]);
							dobT.setText(loadprofile[0][6]);
				
							System.out.println(loadprofile[0][7]);
							addressT.setText(loadprofile[0][7]);
				
							System.out.println(loadprofile[0][8]);
							phoneT.setText(loadprofile[0][8]);
				
							System.out.println(loadprofile[0][9]);
							gurdianT.setText(loadprofile[0][9]);
				
							System.out.println(loadprofile[0][10]);
							cb1.setSelectedItem(loadprofile[0][10]);
				
							System.out.println(loadprofile[0][11]);
							cityT.setText(loadprofile[0][11]);
				
							System.out.println(loadprofile[0][12]);
							pincodeT.setText(loadprofile[0][12]);
				
							System.out.println(loadprofile[0][13]);
							stateT.setText(loadprofile[0][13]);
						
					
						}
						if(chkCORRECTID3==1)
						{
						
								qry="Select patient_id from history_Patient where patient_id="+sendID+"";
								String loadID2=inf.getSingleValue(qry);
								System.out.println("loadID2 "+loadID2);
								if(loadID2!=null)
								{
									if((loadprofile[0][0]).equals(loadID2))
									chkCORRECTID1=1;
														
								}			
								else if(loadID2==null)
								{
									JOptionPane.showMessageDialog(this,"History Not Available","Message",JOptionPane.ERROR_MESSAGE);						
								}
								if(chkCORRECTID1==1)
								{
									qry="Select * from history_Patient where patient_id="+sendID+" ORDER by history_date Desc";
									System.out.println("qry "+qry);
									String loadHistory[][]=inf.getResultSetAs_2D_Array(qry,13);
									if(loadHistory==null)
									{
										JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
				
									}
									else
									{
								
											System.out.println(loadHistory[0][0]);
											System.out.println(loadHistory[0][1]);
											heightT.setText(loadHistory[0][1]);
					
											System.out.println(loadHistory[0][2]);
											weightT.setText(loadHistory[0][2]);
					
											System.out.println(loadHistory[0][3]);
											bloodgroupT.setText(loadHistory[0][3]);
					
											System.out.println(loadHistory[0][4]);
											sugarT.setText(loadHistory[0][4]);
					
											System.out.println(loadHistory[0][5]);
											bloodpressureT.setText(loadHistory[0][5]);
							
											System.out.println(loadHistory[0][6]);
											cbSac.addItem(loadHistory[0][6]);
					
											System.out.println(loadHistory[0][7]);
											String allergy=loadHistory[0][7];
					
											System.out.println(loadHistory[0][8]);
											String currentmedi=loadHistory[0][8];
					
											System.out.println(loadHistory[0][9]);
											commentJ.setText(loadHistory[0][9]);
					
											System.out.println(loadHistory[0][10]);
											history_Date=loadHistory[0][10];
											System.out.println("history_Date "+history_Date);
					
											String split_wholeDate[]=history_Date.split("-");
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
						
									nameT.requestFocus();
							}
			
			}
			catch(Exception ex)
			{
				System.out.println("ERROR...IN FetchPatientDetailFun"+ex);
			}
			
	}
	private void DeletePatientRecordFun()
	{
		System.out.println("I M here now");
		/////////////check here////////////
		System.out.println("row count   "+dtm.getRowCount());
		
		
		
		
		
		int Selected_Row=table.getSelectedRow();
		System.out.println("Selected Row "+Selected_Row);
		String Selected_Date=""+table.getValueAt(Selected_Row,10);
		System.out.println("Selected date "+Selected_Date);
		
		String getID=L_PID.getText();
		int ID=Integer.parseInt(getID);
		System.out.println("ID "+ID);
		
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
	
	
	
			qry="delete * from history_Patient where patient_id="+ID+" And history_date=#"+set_Date+"#";
			System.out.println("qry "+qry);
			boolean successful=inf.executeUpdateQuery(qry);
			if(successful==false)
			{
			
				JOptionPane.showMessageDialog(this,"Record Not Deleted","Acknowledgement",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Record Deleted","Acknowledgement",JOptionPane.ERROR_MESSAGE);
			}
			
			System.out.println("Problem is here 11111 S_CHK");
			System.out.println("row count "+dtm.getRowCount());
			if(dtm.getRowCount()==1)
			{
				dtm.removeRow(0);
				dtm.setRowCount(0);
			}
			else
			{
				System.out.println("getRow Count   "+dtm.getRowCount());
			if(dtm.getRowCount()!=0)
			{
				System.out.println("Problem is here 2222 S_CHK");
				dtm.removeRow(1);
				System.out.println("Now row count is   "+dtm.getRowCount());
				int rwcnt=dtm.getRowCount();
				System.out.println("rwcnt "+rwcnt);
				int C=0,nt=1;
				if(rwcnt!=0)
				{
					for(int R=0;R<rwcnt;R++)
					{
						System.out.println("Its moving");
						String RW=""+(nt++);
						System.out.println("row no "+RW);
						table.setValueAt(RW,R,C);
			
					}

				}
			}
			}
		
			
		
			
		/*	else
			{
			set_DG.dispose();	
			}*/
				
		}
		catch(Exception ex)
		{
			System.out.println("ERROR.."+ex);
		}
	}
	private void SetParticularHistoryFun()
	{
		System.out.println("S_CHK 11111111111");
		int RWCOUNT=dtm.getRowCount();
		System.out.println("RWCOUNT "+RWCOUNT);
		if(RWCOUNT!=0)
		{
		
			int Selected_Row=table.getSelectedRow();
			System.out.println("Selected Row "+Selected_Row);
			
			if(Selected_Row!=-1)
			{
		
				String Selected_Date=""+table.getValueAt(Selected_Row,10);
				System.out.println("Selected date "+Selected_Date);
		
				String getID=L_PID.getText();
				int ID=Integer.parseInt(getID);
				System.out.println("ID "+ID);
		
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
				///		ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				
				
				
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
						qry="Select * from history_Patient where patient_id="+ID+" And history_date=#"+set_Date+"#";
						System.out.println("qry "+qry);
						String loadHistory[][]=inf.getResultSetAs_2D_Array(qry,11);
						if(loadHistory==null)
						{
								JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.PLAIN_MESSAGE);
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
							cbSac.addItem(loadHistory[0][6]);
							System.out.println("7"+loadHistory[0][7]);
							String allergy=loadHistory[0][7];
							System.out.println("8"+loadHistory[0][8]);
							String currentmedi=loadHistory[0][8];
							System.out.println("9"+loadHistory[0][9]);
							commentJ.setText(loadHistory[0][9]);
							System.out.println("10"+loadHistory[0][10]);
						//	String Get_Date=loadHistory[0][10];
							history_Date=loadHistory[0][10];
				
							String splt_Date[]=history_Date.split("-");
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
						//	String Adjust_Date=D+"/"+M+"/"+Y+" "+split_Time[0]+":"+split_Time[1]+":"+split_Time[2];
							String Adjust_Date=D+"/"+M+"/"+Y;
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
					System.out.println("ERROR.."+ex);
				}
		   }
		   else
		  {
		  	set_DG.dispose();
		  	//JOptionPane.showMessageDialog(this,"Please Select The Row","Acknowledgement",JOptionPane.ERROR_MESSAGE);
		  }
		}
	}
	private void AddNewReferenceFun()	
	{
			String name=tft1.getText();
		//	System.out.println("name"+name);
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
			//	patientInterface inf=(patientInterface)Naming.lookup("rmi://127.0.0.1/testing");
		////		ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
		
		
		
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
				System.out.println("ERROR..IN  UpdateAllergyListFun"+ex);
			}
	}
	private void ViewPreviousRecordFun()
	{
		String pid=pidT.getText();
		
			int ID=Integer.parseInt(pid);
		//	System.out.println("ID "+ID);
		
			set_DG=new SetDialog(pid);
			dtm.setRowCount(0);
		
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
				qry="Select * from history_Patient where patient_id="+ID+"";
				String loadHistory[][]=inf.getResultSetAs_2D_Array(qry,11);
				if(loadHistory==null)
				{
					JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					int len=loadHistory.length;
				//	System.out.println("len "+len);
					String load[][]=new String[len][11];
			
					int lenof=load.length;
				//	System.out.println("lenof "+lenof);
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
					
					//	System.out.println(loadHistory[start][10]);
						load[start1][10]=loadHistory[start][10];				
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
				
					set_DG.setBounds(230,180,750,420);
					set_DG.setVisible(true);
				}
			
			}
			catch(Exception ex)
			{
					System.out.println("ERROR.. IN ViewPreviousRecordFun"+ex);
			}
	}
	private void GetInitialInfo()
	{
		try
		{
				
		//	patientInterface inf=(patientInterface)Naming.lookup("rmi://127.0.0.1/testing");
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
			
			qry="Select drCatName from drCategory";
			String loaddrcat[]=inf.getResultSetAs_1D_Array(qry);
			cbdrcatnm.addItem("SELECT");
			for(int i=0;i<loaddrcat.length;i++)
			{
					cbdrcatnm.addItem(loaddrcat[i]);
			}
			
			qry=("Select * from referedBy_Dr");
		//	String loadnm[]=inf.loadReference(load);
			String loadnm[]=inf.getResultSetAs_1D_Array(qry);
			cb1.addItem("SELECT");
			for(int i=0;i<loadnm.length;i++)
			{
					cb1.addItem(loadnm[i]);
			}
			
		//	patientInterface inf1=(patientInterface)Naming.lookup("rmi://127.0.0.1/testing");
			qry=("Select * from allergyList");
		//	String loadlt[]=inf1.loadallergyList(load);
			String loadlt[]=inf.getResultSetAs_1D_Array(qry);
			cballergy.addItem("SELECT");
			for(int i=0;i<loadlt.length;i++)
			{
					cballergy.addItem(loadlt[i]);
			}
			
			qry="Select * from Sac";
			String loadSac[]=inf.getResultSetAs_1D_Array(qry);
			cbSac.addItem("SELECT");
			for(int i=0;i<loadSac.length;i++)
			{
				cbSac.addItem(loadSac[i]);
			}
			
			qry=("Select * from drug_Master");
		//	String loadlt[]=inf1.loadallergyList(load);
			String loadlt1[]=inf.getResultSetAs_1D_Array(qry);
			cbcurrentmedi.addItem("SELECT");
			for(int i=0;i<loadlt1.length;i++)
			{
					cbcurrentmedi.addItem(loadlt1[i]);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR..IN GetInitialInfo Method"+ex);
		}
	}
}