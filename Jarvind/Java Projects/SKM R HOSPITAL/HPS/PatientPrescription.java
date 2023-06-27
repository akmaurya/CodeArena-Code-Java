import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.sql.*;
import java.rmi.*;
import java.util.*;
import java.util.Date;
import java.rmi.registry.*;
import java.util.Date.*;
import javax.swing.table.*;
import javax.swing.border.*;
 import java.awt.geom.*;
 import javax.print.PrintService;
 import java.awt.print.*;
 import javax.print.attribute.*;
 import java.awt.font.*;
public class PatientPrescription extends JInternalFrame implements ActionListener,KeyListener
{
	JDesktopPane dpp;
	Container cn;
	public static String hold_Dt=null;
	JInternalFrame frm;
	JButton btn_patienthistory,btn_patientprescpre,btn_save,btn_refresh,btn_close,btn_print,btn_logout;
	JLabel lbl_pname,lbl_page;
	JTextField tf_gre,tf_gle,tf_rre,tf_rle;// tf_diagnosis,tf_complaintsof,tf_historyof,tf_using,tf_vre,tf_vle,tf_sre,tf_sle,tf_lre,tf_lle,tf_conre,tf_conle,tf_corre,tf_corle,tf_are,tf_ale,tf_ire,tf_ile,tf_pre,tf_ple,tf_lenre,tf_lenle,tf_tre,tf_tle,;
	JTextArea ta_advice;
	String setip,qry,getDt;
	int patientID,chkFlag=0,add=0,Flag=0;
	JComboBox cb1_diagnosis,cb2_diagnosis,cb_historyof,cb_complaintsof,cb_using,tf_vre,tf_vle,tf_lre,tf_lle,tf_conre,tf_conle,tf_corre,tf_corle,tf_are,tf_ale,tf_ire,tf_ile,tf_pre,tf_ple,tf_lenre,tf_lenle,tf_tre,tf_tle,tf_ore,tf_ole,tf_fre,tf_fle,Up1,Down1,Right1,Left1,Up2,Down2,Right2,Left2;
	JCheckBox chkRE,chkLE;
	String LeftGonio,RightGonio,getsurgery_id,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
	Refraction r;
	ZedInterface inf=null;
	public PatientPrescription(JDesktopPane dp,int id,String holdDt)
	{
	//	prescriptionPrevious P_previous;
	
		frm=new JInternalFrame("Patient Prescription",false,true,false,true);
		cn=frm.getContentPane();
		cn.setLayout(null);
		Color c1=new Color(60,220,220);
 		cn.setBackground(c1);
 		patientID=id;
 		dpp=dp;
		System.out.println("pid "+patientID);
	
		getDt=holdDt;
		System.out.println("getDdt "+getDt);
	
		
		
		JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15,lbl16,lbl17,lbl18,lbl19,lbl20,lbl21,lbl22,lbl23,lbl24,lbl25;
		Font fn1=new Font("Microsoft Sans Serif",Font.BOLD,14);
		//---------panel 1--------------------------------------------------------
		JPanel p1=new JPanel();
		p1.setBorder(new javax.swing.border.LineBorder(Color.RED,1));
		p1.setLayout(null);
		p1.setBounds(5,5,940,30);
		cn.add(p1);
		
		lbl1=new JLabel("Patient Name");
		lbl1.setBounds(10,5,100,20);
		p1.add(lbl1);
		lbl_pname=new JLabel("Patient Name");
		lbl_pname.setOpaque(true);
		lbl_pname.setBackground(Color.GREEN);
		lbl_pname.setBounds(130,5,350,20);
		p1.add(lbl_pname);
		
		btn_patienthistory=new JButton("Previous History",new ImageIcon("icons\\back.gif"));
		btn_patienthistory.setBounds(480,5,170,20);
		p1.add(btn_patienthistory);
		
		lbl2=new JLabel("Age/Sex");
		lbl2.setHorizontalAlignment(JLabel.RIGHT);
		lbl2.setBounds(650,5,100,20);
		p1.add(lbl2);
		lbl_page=new JLabel("16 Y /M");
		lbl_page.setHorizontalAlignment(JLabel.RIGHT);
		lbl_page.setOpaque(true);
		lbl_page.setBackground(Color.GREEN);
		lbl_page.setBounds(750,5,180,20);
		p1.add(lbl_page);
		
		//--------------------end panel 1------------------------------------------
		
		
		//---------panel 2--------------------------------------------------------
		JPanel p2=new JPanel();
		p2.setBorder(new javax.swing.border.LineBorder(Color.RED,1));
		p2.setLayout(null);
		p2.setBounds(5,35,940,105);
		cn.add(p2);
		
		lbl3=new JLabel("Diagnosis");
		lbl3.setBounds(10,5,100,20);
		p2.add(lbl3);
		cb1_diagnosis=new JComboBox();
		cb1_diagnosis.setBounds(130,5,200,20);
		
		cb2_diagnosis=new JComboBox();
		cb2_diagnosis.setBounds(350,5,200,20);
		
		p2.add(cb1_diagnosis);
		p2.add(cb2_diagnosis);
		cb1_diagnosis.setEditable(true);
		cb2_diagnosis.setEditable(true);
		
	/*	chkRE=new JCheckBox("RE");
		chkRE.setBounds(650,5,50,20);
		p2.add(chkRE);
		
		chkLE=new JCheckBox("LE");
		chkLE.setBounds(750,5,50,20);
		p2.add(chkLE);*/
		
	//	tf_diagnosis=new JTextField("");
		//tf_diagnosis.setOpaque(true);
		//tf_diagnosis.setBackground(Color.GREEN);
	//	tf_diagnosis.setBounds(130,5,800,20);
		//p2.add(tf_diagnosis);
		
		lbl4=new JLabel("Complaints of");
		lbl4.setBounds(10,40,100,20);
		p2.add(lbl4);
		cb_complaintsof=new JComboBox();
		cb_complaintsof.setBounds(130,40,420,20);
		p2.add(cb_complaintsof);
		cb_complaintsof.setEditable(true);
		//tf_complaintsof=new JTextField("");
		//tf_complaintsof.setBounds(130,40,800,20);
		//p2.add(tf_complaintsof);
		
		lbl5=new JLabel("History of");
		lbl5.setBounds(10,75,100,20);
		p2.add(lbl5);
		cb_historyof=new JComboBox();
		cb_historyof.setBounds(130,75,200,20);
		p2.add(cb_historyof);
		cb_historyof.setEditable(true);
	//	tf_historyof=new JTextField("");
	//	tf_historyof.setBounds(130,75,300,20);
		
		
		lbl6=new JLabel("Using");
		lbl6.setBounds(350,75,50,20);
		p2.add(lbl6);
		cb_using=new JComboBox();
		cb_using.setBounds(400,75,150,20);
		p2.add(cb_using);
		cb_using.setEditable(true);
		//tf_using=new JTextField("");
		//tf_using.setBounds(530,75,180,20);
		
		
		btn_patientprescpre=new JButton("Previous Prescription",new ImageIcon("icons\\back.gif"));
		btn_patientprescpre.setBounds(720,75,210,20);
		p2.add(btn_patientprescpre);
		
		//--------------------end panel 2------------------------------------------
		//---------panel 3--------------------------------------------------------
		JPanel p3=new JPanel();
		p3.setBorder(new javax.swing.border.LineBorder(Color.RED,1));
		p3.setLayout(null);
		p3.setBounds(5,140,510,450);
		cn.add(p3);
		
		lbl7=new JLabel("Vision");
		lbl7.setOpaque(true);
		lbl7.setBackground(new Color(174,200,230));
		lbl7.setFont(fn1);
		lbl7.setBounds(10,25,180,20);
		p3.add(lbl7);
		
		lbl8=new JLabel("RE");
		lbl8.setHorizontalAlignment(JLabel.CENTER);
		lbl8.setBounds(270,5,80,20);
		p3.add(lbl8);
		
		tf_vre=new JComboBox();
		tf_vre.setBounds(270,25,80,20);
	//	tf_vre=new JTextField("");
	//	tf_vre.setBounds(270,25,80,20);
		p3.add(tf_vre);
		tf_vre.setEditable(true);
		
		lbl9=new JLabel("LE");
		lbl9.setHorizontalAlignment(JLabel.CENTER);
		lbl9.setBounds(400,5,80,20);
		p3.add(lbl9);
		
		tf_vle=new JComboBox();
		tf_vle.setBounds(400,25,80,20);	
	//	tf_vle=new JTextField("");
	//	tf_vle.setBounds(400,25,80,20);
		p3.add(tf_vle);
		tf_vle.setEditable(true);
		
		
		lbl10=new JLabel("Slit Lamp Examination");
		lbl10.setOpaque(true);
		lbl10.setBackground(new Color(174,200,230));
		lbl10.setFont(fn1);
		lbl10.setBounds(10,55,180,20);
		p3.add(lbl10);
		
	//	lbl11=new JLabel("RE");
	//	lbl11.setHorizontalAlignment(JLabel.RIGHT);
	//	lbl11.setBounds(190,55,80,20);
	//	p3.add(lbl11);
		
	//	tf_sre=new JComboBox();
	//	tf_sre.setBounds(270,55,80,20);
	//	tf_sre=new JTextField("");
	//	tf_sre.setBounds(270,55,80,20);
	//	p3.add(tf_sre);
		
	//	lbl12=new JLabel("LE");
	//	lbl12.setHorizontalAlignment(JLabel.RIGHT);
	//	lbl12.setBounds(320,55,80,20);
	//	p3.add(lbl12);
		
	//	tf_sle=new JTextField("");
	//	tf_sle.setBounds(400,55,80,20);
	//	p3.add(tf_sle);
		
		lbl13=new JLabel("Lid");
		lbl13.setOpaque(true);
		lbl13.setBackground(new Color(174,200,230));
		lbl13.setFont(fn1);
		lbl13.setBounds(10,90,180,20);
		p3.add(lbl13);
		
		tf_lre=new JComboBox();
		tf_lre.setBounds(270,90,80,20);
	//	tf_lre=new JTextField("");
	//	tf_lre.setBounds(270,90,80,20);
		p3.add(tf_lre);
		tf_lre.setEditable(true);
		
		tf_lle=new JComboBox();
		tf_lle.setBounds(400,90,80,20);
	//	tf_lle=new JTextField("");
	//	tf_lle.setBounds(400,90,80,20);
		p3.add(tf_lle);
		tf_lle.setEditable(true);
		
		lbl14=new JLabel("Conjunctiva -");
		lbl14.setOpaque(true);
		lbl14.setBackground(new Color(174,200,230));
		lbl14.setFont(fn1);
		lbl14.setBounds(10,120,180,20);
		p3.add(lbl14);
		
		tf_conre=new JComboBox();
		tf_conre.setBounds(270,120,80,20);
	//	tf_conre=new JTextField("");
	//	tf_conre.setBounds(270,120,80,20);
		p3.add(tf_conre);
		tf_conre.setEditable(true);
		
		tf_conle=new JComboBox();
		tf_conle.setBounds(400,120,80,20);
	//	tf_conle=new JTextField("");
	//	tf_conle.setBounds(400,120,80,20);
		p3.add(tf_conle);
		tf_conle.setEditable(true);
		
		lbl15=new JLabel("Cornia");
		lbl15.setOpaque(true);
		lbl15.setBackground(new Color(174,200,230));
		lbl15.setFont(fn1);
		lbl15.setBounds(10,150,180,20);
		p3.add(lbl15);
		
		tf_corre=new JComboBox();
		tf_corre.setBounds(270,150,80,20);
	//	tf_corre=new JTextField("");
	//	tf_corre.setBounds(270,150,80,20);
		p3.add(tf_corre);
		tf_corre.setEditable(true);
		
		tf_corle=new JComboBox();
		tf_corle.setBounds(400,150,80,20);
	//	tf_corle=new JTextField("");
	//	tf_corle.setBounds(400,150,80,20);
		p3.add(tf_corle);
		tf_corle.setEditable(true);
		
		lbl16=new JLabel("A.C. -");
		lbl16.setOpaque(true);
		lbl16.setBackground(new Color(174,200,230));
		lbl16.setFont(fn1);
		lbl16.setBounds(10,180,180,20);
		p3.add(lbl16);
		
		tf_are=new JComboBox();
		tf_are.setBounds(270,180,80,20);
	//	tf_are=new JTextField("");
	//	tf_are.setBounds(270,180,80,20);
		p3.add(tf_are);
		tf_are.setEditable(true);
		
		tf_ale=new JComboBox();
		tf_ale.setBounds(400,180,80,20);
	//	tf_ale=new JTextField("");
	//	tf_ale.setBounds(400,180,80,20);
		p3.add(tf_ale);
		tf_ale.setEditable(true);
		
		lbl17=new JLabel("Iris -");
		lbl17.setOpaque(true);
		lbl17.setBackground(new Color(174,200,230));
		lbl17.setFont(fn1);
		lbl17.setBounds(10,210,180,20);
		p3.add(lbl17);
		
		tf_ire=new JComboBox();
		tf_ire.setBounds(270,210,80,20);
	//	tf_ire=new JTextField("");
	//	tf_ire.setBounds(270,210,80,20);
		p3.add(tf_ire);
		tf_ire.setEditable(true);
		
		tf_ile=new JComboBox();
		tf_ile.setBounds(400,210,80,20);
	//	tf_ile=new JTextField("");
	//	tf_ile.setBounds(400,210,80,20);
		p3.add(tf_ile);
		tf_ile.setEditable(true);
		
		lbl18=new JLabel("Pupil -");
		lbl18.setOpaque(true);
		lbl18.setBackground(new Color(174,200,230));
		lbl18.setFont(fn1);
		lbl18.setBounds(10,240,180,20);
		p3.add(lbl18);
		
		tf_pre=new JComboBox();
		tf_pre.setBounds(270,240,80,20);
	//	tf_pre=new JTextField("");
	//	tf_pre.setBounds(270,240,80,20);
		p3.add(tf_pre);
		tf_pre.setEditable(true);
		
		tf_ple=new JComboBox();
		tf_ple.setBounds(400,240,80,20);
	//	tf_ple=new JTextField("");
	//	tf_ple.setBounds(400,240,80,20);
		p3.add(tf_ple);
		tf_ple.setEditable(true);
		
		lbl19=new JLabel("Lens -");
		lbl19.setOpaque(true);
		lbl19.setBackground(new Color(174,200,230));
		lbl19.setFont(fn1);
		lbl19.setBounds(10,270,180,20);
		p3.add(lbl19);
		
		tf_lenre=new JComboBox();
		tf_lenre.setBounds(270,270,80,20);
	//	tf_lenre=new JTextField("");
	//	tf_lenre.setBounds(270,270,80,20);
		p3.add(tf_lenre);
		tf_lenre.setEditable(true);
		
		tf_lenle=new JComboBox();
		tf_lenle.setBounds(400,270,80,20);
	//	tf_lenle=new JTextField("");
	//	tf_lenle.setBounds(400,270,80,20);
		p3.add(tf_lenle);
		tf_lenle.setEditable(true);
		
		lbl20=new JLabel("Tn A -");
		lbl20.setOpaque(true);
		lbl20.setBackground(new Color(174,200,230));
		lbl20.setFont(fn1);
		lbl20.setBounds(10,300,180,20);
		p3.add(lbl20);
		
		tf_tre=new JComboBox();
		tf_tre.setBounds(270,300,80,20);
	//	tf_tre=new JTextField("");
	//	tf_tre.setBounds(270,300,80,20);
		p3.add(tf_tre);
		tf_tre.setEditable(true);
		
		tf_tle=new JComboBox();
		tf_tle.setBounds(400,300,80,20);
	//	tf_tle=new JTextField("");
	//	tf_tle.setBounds(400,300,80,20);
		p3.add(tf_tle);
		tf_tle.setEditable(true);
		
		for(int i=1;i<=50;i++)
		{
				tf_tre.addItem(""+i);
				tf_tle.addItem(""+i);
		}
		
		lbl21=new JLabel("Gonio -");
		lbl21.setOpaque(true);
		lbl21.setBackground(new Color(174,200,230));
		lbl21.setFont(fn1);
		lbl21.setBounds(10,350,180,20);
	//	lbl21.setBounds(10,330,180,20);
		p3.add(lbl21);
		
		Up1=new JComboBox();
		Font fn=new Font("Arial Narrow",Font.BOLD,10);
		Up1.setFont(fn);
		Up1.setBounds(300,325,30,15);
		p3.add(Up1);
		Up1.setEditable(true);
		
		
		Down1=new JComboBox();
		Down1.setBounds(300,370,30,15);
		Down1.setFont(fn);
		p3.add(Down1);
		Down1.setEditable(true);
		
		
		Left1=new JComboBox();
		Left1.setBounds(270,345,30,15);
		Left1.setFont(fn);
		p3.add(Left1);
		Left1.setEditable(true);
	
		
		Right1=new JComboBox();
		Right1.setBounds(330,345,30,15);
		Right1.setFont(fn);
		p3.add(Right1);
		Right1.setEditable(true);
		
		
		JLabel lb_gre=new JLabel(new ImageIcon("icons\\CLOSE.gif"));
		lb_gre.setBounds(305,345,20,20);
	//	lb_gre.setBounds(300,330,20,20);
		p3.add(lb_gre);
		
	
		tf_gre=new JTextField("");
		tf_gre.setBounds(270,330,80,20);
	//	p3.add(tf_gre);
		
		///////////////////////2nd side///////////////////////////
		Up2=new JComboBox();
		Up2.setBounds(425,325,30,15);
		Up2.setFont(fn);
		p3.add(Up2);
		Up2.setEditable(true);
		
		Down2=new JComboBox();
		Down2.setBounds(425,370,30,15);
		Down2.setFont(fn);
		p3.add(Down2);
		Down2.setEditable(true);
		
		
		
		Right2=new JComboBox();
		Right2.setBounds(455,345,30,15);
		Right2.setFont(fn);
		p3.add(Right2);
		Right2.setEditable(true);
	
		
		Left2=new JComboBox();
		Left2.setBounds(395,345,30,15);
		Left2.setFont(fn);
		p3.add(Left2);
		Left2.setEditable(true);
		
		Up1.addItem("Select");
		Down1.addItem("Select");
		Left1.addItem("Select");
		Right1.addItem("Select");
		Up2.addItem("Select");
		Down2.addItem("Select");
		Right2.addItem("Select");
		Left2.addItem("Select");
		for(int i=0;i<=4;i++)
		{
			Up1.addItem(""+i);
			Down1.addItem(""+i);
			Left1.addItem(""+i);
			Up2.addItem(""+i);
			Down2.addItem(""+i);
			Right2.addItem(""+i);
			Left2.addItem(""+i);
			Right1.addItem(""+i);
		}
		
		
		JLabel lb_gle=new JLabel(new ImageIcon("icons\\CLOSE.gif"));
		lb_gle.setBounds(430,345,20,20);
	//	lb_gle.setBounds(430,330,20,20);
		p3.add(lb_gle);
		
		///////////////////////////End of 2nd side/////////////////
		tf_gle=new JTextField("");
		tf_gle.setBounds(400,330,80,20);
	//	p3.add(tf_gle);
		
		lbl22=new JLabel("Ocular Mobility -");
		lbl22.setOpaque(true);
		lbl22.setBackground(new Color(174,200,230));
		lbl22.setFont(fn1);
		lbl22.setBounds(10,390,180,20);
	//	lbl22.setBounds(10,360,180,20);
		p3.add(lbl22);
		
		tf_ore=new JComboBox();
		tf_ore.setBounds(270,390,80,20);
	//	tf_ore.setBounds(270,360,80,20);
	//	tf_ore=new JTextField("");
	//	tf_ore.setBounds(270,360,80,20);
		p3.add(tf_ore);
		tf_ore.setEditable(true);
		
		tf_ole=new JComboBox();
		tf_ole.setBounds(400,390,80,20);
	//	tf_ole.setBounds(400,360,80,20);
	//	tf_ole=new JTextField("");
	//	tf_ole.setBounds(400,360,80,20);
		p3.add(tf_ole);
		tf_ole.setEditable(true);
		
		
		lbl23=new JLabel("Fundus -");
		lbl23.setOpaque(true);
		lbl23.setBackground(new Color(174,200,230));
		lbl23.setFont(fn1);
		lbl23.setBounds(10,420,180,20);
	//	lbl23.setBounds(10,390,180,20);
		p3.add(lbl23);
		
		tf_fre=new JComboBox();
		tf_fre.setBounds(270,420,210,20);
	//	tf_fre.setBounds(270,390,80,20);
	//	tf_fre=new JTextField("");
	//	tf_fre.setBounds(270,390,80,20);
		p3.add(tf_fre);
		tf_fre.setEditable(true);
		
		tf_fle=new JComboBox();
		tf_fle.setBounds(400,420,80,20);
	//	tf_fle.setBounds(400,390,80,20);
	//	tf_fle=new JTextField("");
	//	tf_fle.setBounds(400,390,80,20);
	//	p3.add(tf_fle);
		
		lbl24=new JLabel("Refraction -");
		lbl24.setOpaque(true);
		lbl24.setBackground(new Color(174,200,230));
		lbl24.setFont(fn1);
		lbl24.setBounds(10,420,180,20);
	//	p3.add(lbl24);
		
		tf_rre=new JTextField("");
		tf_rre.setBounds(270,420,80,20);
	//	p3.add(tf_rre);
		
		tf_rle=new JTextField("");
		tf_rle.setBounds(400,420,80,20);
	//	p3.add(tf_rle);
		//-------------end panel 3---------------------------------------------------
		
		//-------------JPanel 4-----------------------------------------------
		JPanel p4=new JPanel();
		LineBorder lb=new LineBorder(Color.RED,1);
		TitledBorder tb1=new TitledBorder(lb," A d v i c e  ");
		p4.setBorder(tb1);
		//p4.setBorder(new javax.swing.border.LineBorder(Color.RED,1));
		//p4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Advice", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(255, 0, 0)));
		p4.setLayout(new BorderLayout());
		p4.setBounds(515,140,430,275);//width was=450
		cn.add(p4);
		ta_advice=new JTextArea();
		ta_advice.setFont(fn1);
		JScrollPane jsp=new JScrollPane(ta_advice,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//jsp.setBounds(0,0,400,430);
		p4.add(jsp);
		
		//-------------panel 4 end------------------------------
		
		//================ADDING REFRACTION PANEL ========================
		
		r=new Refraction();
		r.setBounds(515,415,430,175);
		cn.add(r);
	
		
		//===============ENDING REFRACTION PANEL  ========================
		
		//-----------------JPanel 5 ---------------------------------------------------------
		JPanel p5=new JPanel();
		p5.setBorder(new LineBorder(Color.RED,2));
		p5.setLayout(null);
		p5.setBounds(5,590,940,50);
		cn.add(p5);
		
		btn_save=new JButton("Save",new ImageIcon("icons\\save.gif"));
		btn_save.setMnemonic('s');
		btn_save.setBounds(60,10,150,30);
		btn_save.setToolTipText("Save");
		p5.add(btn_save);
		
		btn_print=new JButton("Print",new ImageIcon("icons\\print.gif"));
		btn_print.setMnemonic('P');
		btn_print.setBounds(230,10,150,30);
		btn_print.setToolTipText("Print");
		p5.add(btn_print);
		
		btn_logout=new JButton("Log Out",new ImageIcon("icons\\forward.gif"));
		btn_logout.setMnemonic('L');
		btn_logout.setBounds(400,10,150,30);
		btn_logout.setToolTipText("Log out Patient");
		p5.add(btn_logout);
		
		
		btn_refresh=new JButton("Refresh",new ImageIcon("icons\\reset.gif"));
		btn_refresh.setMnemonic('r');
		btn_refresh.setBounds(570,10,150,30);
		btn_refresh.setToolTipText("Refresh");
		p5.add(btn_refresh);
		
		
		
		
		
		btn_close=new JButton("Close",new ImageIcon("icons\\close.gif"));
		btn_close.setMnemonic('c');
		btn_close.setBounds(740,10,150,30);
		btn_close.setToolTipText("Close");
		p5.add(btn_close);
		
		
		
		//------------------end panel 5 ------------------------------
		
		frm.reshape(30,50,960,680);
		System.out.println("skmmm");
	 	dp.add(frm);
	 	frm.setVisible(true);
	 	
	 	
	// 	setip=getIPaddress.IP();
	//	System.out.println("setip "+setip);
	 	
	 	
	 	cb1_diagnosis.addActionListener(this);
	 	btn_patienthistory.addActionListener(this);
	 
	 	btn_save.addActionListener(this);
	 	btn_print.addActionListener(this);
	 	btn_patientprescpre.addActionListener(this);
	 	
	 	btn_close.addActionListener(this);
	 	btn_refresh.addActionListener(this);
	 	btn_logout.addActionListener(this);
	 
	 	
	 	tf_vre.addKeyListener(this);
		tf_vle.addKeyListener(this);
		tf_lre.addKeyListener(this);
		tf_lle.addKeyListener(this);
		tf_conre.addKeyListener(this);
		tf_conle.addKeyListener(this);
		tf_corre.addKeyListener(this);
		tf_corle.addKeyListener(this);
		tf_are.addKeyListener(this);
		tf_ale.addKeyListener(this);
		tf_ire.addKeyListener(this);
		tf_ile.addKeyListener(this);
		tf_pre.addKeyListener(this);
		tf_ple.addKeyListener(this);
		tf_lenre.addKeyListener(this);
		tf_lenle.addKeyListener(this);
		tf_tre.addKeyListener(this);
		tf_tle.addKeyListener(this);
		Up1.addKeyListener(this);
		Right1.addKeyListener(this);
		Down1.addKeyListener(this);
		Left1.addKeyListener(this);
		Up2.addKeyListener(this);
		Right2.addKeyListener(this);
		Down2.addKeyListener(this);
		Left2.addKeyListener(this);
		tf_ore.addKeyListener(this);
		tf_ole.addKeyListener(this);
		tf_fre.addKeyListener(this);
		tf_rre.addKeyListener(this);
		tf_rle.addKeyListener(this);
		btn_print.addKeyListener(this);
		
	 	tf_vre.requestFocus();
	 	
	 	
		
		
		SetDefaultValuesFun();
		getInitialInfo();
		if(getDt!=null)
		{
			GetTheCurrentPresFun();
		}
	   	
	}

public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==cb1_diagnosis)
	{
		cb2_diagnosis.removeAllItems();
		String getcb1=""+cb1_diagnosis.getSelectedItem();
		System.out.println("getcb1  "+getcb1);
		if(!getcb1.equals("SELECT"))
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
				qry="Select dg_surgery_id from eye_diagnosys_surgery_common where dg_surgery='"+getcb1+"'";
				System.out.println("qry "+qry);
				getsurgery_id=inf.getSingleValue(qry);
				System.out.println("getsurgery_id "+getsurgery_id);
				
				qry="Select dg_option from eye_diagnosys_option where dg_surgery_id="+Integer.parseInt(getsurgery_id)+"";
				System.out.println("qry "+qry);
				String loadcb2[]=inf.getResultSetAs_1D_Array(qry);
				cb2_diagnosis.addItem("SELECT");
				for(int i=0;i<loadcb2.length;i++)
				{
					cb2_diagnosis.addItem(loadcb2[i]);
				}
			}
			catch(Exception ex)
			{
				System.out.println("ERROR.."+ex);
			}
			
		}
	}
	else if(ae.getSource()==btn_patienthistory)
	{
		GetPatientHistoryFun();
	}
//	else if((Up1.getSelectedItem().equals("Select"))||(Down1.getSelectedItem().equals("Select"))||(Right1.getSelectedItem().equals("Select"))||(Left1.getSelectedItem().equals("Select")))
//	{
//		JOptionPane.showMessageDialog(this,"Please Select The Values From Left Side(Gonio) Only ClockWise Manner","Message",JOptionPane.ERROR_MESSAGE);						
//	}
//	else if((Up2.getSelectedItem().equals("Select"))||(Down2.getSelectedItem().equals("Select"))||(Right2.getSelectedItem().equals("Select"))||(Left2.getSelectedItem().equals("Select")))
//	{
//		JOptionPane.showMessageDialog(this,"Please Select The Values From Right Side(Gonio) Only ClockWise Manner","Message",JOptionPane.ERROR_MESSAGE);						
//	}

	else if(ae.getSource()==btn_patientprescpre)
	{
		GetPatientPresFun();
		
	}
	else if(ae.getSource()==btn_save)
	{
		SavePatientPresFun();
		
	}
	else if(ae.getSource()==btn_print)
	{
		printDischargeCard Printing=new printDischargeCard(dpp);
	}
	else if(ae.getSource()==btn_close)
	{
		frm.dispose();
	}
	else if(ae.getSource()==btn_refresh)
	{
			String st="";
			ta_advice.setText(st);
			cb1_diagnosis.setSelectedItem("SELECT");
		//	cb2_diagnosis.setText(st);
			cb_complaintsof.setSelectedItem("SELECT");
			cb_historyof.setSelectedItem("SELECT");
			cb_using.setSelectedItem("SELECT");
		
			tf_vre.setSelectedItem("SELECT");
			tf_vle.setSelectedItem("SELECT");
			tf_lre.setSelectedItem("SELECT");
			tf_lle.setSelectedItem("SELECT");
			tf_conre.setSelectedItem("SELECT");
			tf_conle.setSelectedItem("SELECT");
			tf_corre.setSelectedItem("SELECT");
			tf_corle.setSelectedItem("SELECT");
			tf_are.setSelectedItem("SELECT");
			tf_ale.setSelectedItem("SELECT");
			tf_ire.setSelectedItem("SELECT");
			tf_ile.setSelectedItem("SELECT");
			tf_pre.setSelectedItem("SELECT");
			tf_ple.setSelectedItem("SELECT");
			tf_lenre.setSelectedItem("SELECT");
			tf_lenle.setSelectedItem("SELECT");
			tf_tre.setSelectedItem(0);
			tf_tle.setSelectedItem(0);
			Up1.setSelectedItem(0);
			Right1.setSelectedItem(0);
			Down1.setSelectedItem(0);
			Left1.setSelectedItem(0);
			Up2.setSelectedItem(0);
			Right2.setSelectedItem(0);
			Down2.setSelectedItem(0);
			Left2.setSelectedItem(0);
			tf_ore.setSelectedItem("SELECT");
			tf_ole.setSelectedItem("SELECT");
			tf_fre.setSelectedItem("SELECT");
			r.jComboBox1.setSelectedItem("SELECT");
			r.jComboBox2.setSelectedItem("SELECT");
			r.jComboBox3.setSelectedItem(0);
			r.jComboBox4.setSelectedItem("SELECT");
			r.jComboBox5.setSelectedItem("SELECT");
			r.jComboBox6.setSelectedItem("SELECT");
			r.jComboBox7.setSelectedItem(0);
			r.jComboBox8.setSelectedItem("SELECT");
			r.jComboBox9.setSelectedItem("SELECT");
			r.jComboBox10.setSelectedItem("SELECT");
			r.jComboBox11.setSelectedItem("SELECT");
			r.jComboBox12.setSelectedItem("SELECT");
				

	}
	else if(ae.getSource()==btn_logout)
	{
		
		if(btn_save.isEnabled()==false)
		{
		
			try
			{
					ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
					
					
					qry="Update history_Patient set status="+false+" where patient_id="+patientID+"";
					System.out.println("qry "+qry);
					boolean successful1=inf.executeUpdateQuery(qry);
					System.out.println("successful 1"+successful1);
		
			   	 /*	String	qry="Update patient_Profile set status="+false+" where patientid="+patientID+"";
					System.out.println("qry "+qry);
					boolean successful1=inf.executeUpdateQuery(qry);
					System.out.println("successful 1"+successful1);*/
				
				
		
			/*	qry="Select history_date from history_Patient where status="+true+" ORDER by history_date Desc";
       			String getdate[]=inf.getResultSetAs_1D_Array(qry);
       	
       			int lenofdate=getdate.length;
       			System.out.println("lenof "+lenofdate);
       			if(getdate!=null)
       			{
       					
       				int lenof=getdate.length;
       				System.out.println("lenof "+lenof);
       			
       				String get_Date=getdate[0];
					System.out.println("getdate "+get_Date);
				
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
					
					String matchdate=split_wholeDate[1]+"/"+split_Date[0]+"/"+split_wholeDate[0];
					System.out.println("matchdate "+matchdate);
					
					String MDATE=M+"/"+D+"/"+Y;
					System.out.println("MDATE "+MDATE);
					java.util.Date date=new java.util.Date();
       				String curDate=(date.getMonth()+1)+"/"+""+date.getDate()+"/"+(date.getYear()+1900);
       				System.out.println("curDate "+curDate);
       					
       				if(curDate.equals(MDATE))
       				{
						qry="Update history_Patient set status="+false+" where patient_id="+patientID+"";
						System.out.println("qry "+qry);
						successful1=inf.executeUpdateQuery(qry);
						System.out.println("successful 1"+successful1);
					}
				}*/
				
				frm.dispose();
				}
				catch(Exception ex)
				{
					System.out.println("ERROR.."+ex);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"First Save The Record","Message",JOptionPane.ERROR_MESSAGE);						
			}
	}
}
		
	private void getInitialInfo()
	{
		try
		{
		
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
       		String pName=inf.getSingleValue("select name from patient_Profile where patientid="+patientID);
       		lbl_pname.setText(pName);
       		String pAge=inf.getSingleValue("select age from patient_Profile where patientid="+patientID);
       		String pGen=inf.getSingleValue("select gender from patient_Profile where patientid="+patientID);
       		lbl_page.setText(pAge+" / "+pGen);
       		
       		String convtID=""+patientID;
       		String qry="Select patientID from patient_Prescription";
       		System.out.println("qry "+qry);
       		String loadIDInfo[]=inf.getResultSetAs_1D_Array(qry);
       		if(loadIDInfo!=null)
       		{
       			int lenof1=loadIDInfo.length;
       			System.out.println("lenof1 "+lenof1);
       			for(int j=0;j<lenof1;j++)
       			{
       				if(convtID.equals(loadIDInfo[j]))
       				{
       					chkFlag=1;
       				}
       				
       			}
       		}
       	
       		String diagnosisCode="";
       		if(chkFlag==1)
       		{
       		
       			qry="Select diagnosis_sgy_code,diagnosis_option,Complaints_of,History_of,Using from patient_Prescription where patientID="+patientID+"";
       			System.out.println("qry "+qry);
       			String loadPreInfo[][]=inf.getResultSetAs_2D_Array(qry,5);
       			if(loadPreInfo!=null)
       			{
       				int lenof=loadPreInfo.length;
       				System.out.println("lenof loadPreInfo "+lenof);
       			
       				System.out.println("0 "+loadPreInfo[0][0]);
       				diagnosisCode=loadPreInfo[0][0];
       				String diagnosisopt=loadPreInfo[0][1];
       			//	cb2_diagnosis.setSelectedItem(loadPreInfo[0][1]);
       			//cb1_diagnosis.setText(loadPreInfo[0][0]);
       				System.out.println("1 "+loadPreInfo[0][2]);
       			   cb_complaintsof.setSelectedItem(loadPreInfo[0][2]);
       			   cb_historyof.setSelectedItem(loadPreInfo[0][3]);
       			   cb_using.setSelectedItem(loadPreInfo[0][4]);
       			
       			}
       			qry="Select dg_surgery from eye_diagnosys_surgery_common where dg_surgery_id="+Integer.parseInt(loadPreInfo[0][0])+"";
       			System.out.println("qry "+qry);
       			String getcodename=inf.getSingleValue(qry);
       			System.out.println("getcodename"+getcodename);
       			cb1_diagnosis.setSelectedItem(getcodename);
       			cb2_diagnosis.setSelectedItem(loadPreInfo[0][1]);
       		}
       	}
       	catch(Exception ex)
       	{
       	 	System.out.println("Error.1..."+ex);
       	}
	}
	
	public void keyPressed(KeyEvent ke)
	{
		
		if(ke.getSource()==tf_vre && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_vle.requestFocus();
		}
		else if(ke.getSource()==tf_vle && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_lre.requestFocus();
		}
		else if(ke.getSource()==tf_lre && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_lle.requestFocus();
		}
		else if(ke.getSource()==tf_lle && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_conre.requestFocus();
		}
		else if(ke.getSource()==tf_conre && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_conle.requestFocus();
		}
		else if(ke.getSource()==tf_conle && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_corre.requestFocus();
		}
		else if(ke.getSource()==tf_corre && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_corle.requestFocus();
		}
		else if(ke.getSource()==tf_corle && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_are.requestFocus();
		}
		else if(ke.getSource()==tf_are && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_ale.requestFocus();
		}
		else if(ke.getSource()==tf_ale && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_ire.requestFocus();
		}
		else if(ke.getSource()==tf_ire && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_ile.requestFocus();
		}
		else if(ke.getSource()==tf_ile && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_pre.requestFocus();
		}
		else if(ke.getSource()==tf_pre && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_ple.requestFocus();
		}
		else if(ke.getSource()==tf_ple && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_lenre.requestFocus();
		}
		else if(ke.getSource()==tf_lenre && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_lenle.requestFocus();
		}
		else if(ke.getSource()==tf_lenle && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_tre.requestFocus();
		}
		else if(ke.getSource()==tf_tre && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_tle.requestFocus();
		}
		else if(ke.getSource()==tf_tle && ke.getKeyCode()==ke.VK_ENTER)
		{
			Up1.requestFocus();
		}
		else if(ke.getSource()==Up1 && ke.getKeyCode()==ke.VK_ENTER)
		{
			Right1.requestFocus();
		}
		else if(ke.getSource()==Right1 && ke.getKeyCode()==ke.VK_ENTER)
		{
			Down1.requestFocus();
		}
		else if(ke.getSource()==Down1 && ke.getKeyCode()==ke.VK_ENTER)
		{
			Left1.requestFocus();
		}
		else if(ke.getSource()==Left1 && ke.getKeyCode()==ke.VK_ENTER)
		{
			Up2.requestFocus();
		}
		else if(ke.getSource()==Up2 && ke.getKeyCode()==ke.VK_ENTER)
		{
			Right2.requestFocus();
		}
		else if(ke.getSource()==Right2 && ke.getKeyCode()==ke.VK_ENTER)
		{
			Down2.requestFocus();
		}
		else if(ke.getSource()==Down2 && ke.getKeyCode()==ke.VK_ENTER)
		{
			Left2.requestFocus();
		}
		else if(ke.getSource()==Left2 && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_ore.requestFocus();
		}
		else if(ke.getSource()==tf_ore && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_ole.requestFocus();
		}
		else if(ke.getSource()==tf_ole && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_fre.requestFocus();
		}
		else if(ke.getSource()==tf_fre && ke.getKeyCode()==ke.VK_ENTER)
		{
			tf_fle.requestFocus();
		}
		else if(ke.getSource()==ta_advice && ke.getKeyCode()==ke.VK_ENTER)
		{
			btn_save.requestFocus();
		}//
		else if(ke.getSource()==btn_print && ke.getKeyCode()==ke.VK_ENTER)
		{
			printDischargeCard Printing=new printDischargeCard(dpp);
		}

	}
	public void keyReleased(KeyEvent ke)
	{}
	public void keyTyped(KeyEvent ke)
	{}
	private void GetTheCurrentPresFun()
	{
				System.out.println("date received");
				String split_wholeDate[]=getDt.split("/");
				System.out.println("0 "+split_wholeDate[0]);
				int D=Integer.parseInt(split_wholeDate[0]);
		
				System.out.println("1 "+split_wholeDate[1]);
				int M=Integer.parseInt(split_wholeDate[1]);
		
				System.out.println("2 "+split_wholeDate[2]);
		
					
				String split_Date[]=split_wholeDate[2].split(" ");
				System.out.println("0 "+split_Date[0]);
				int Y=Integer.parseInt(split_Date[0]);
		
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
				
			//	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
			ZedInterface inf=null;

try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
			
			
			
				qry="Select * from previous_Prescription where Patient_ID="+patientID+" And prescription_date=#"+set_Date+"#";
				System.out.println("qryssss=== "+qry);
				String loadPrescription[][]=inf.getResultSetAs_2D_Array(qry,36);
				if(loadPrescription==null)
				{
					JOptionPane.showMessageDialog(this,"Record Not Available","Acknowledgement",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					System.out.println("data fetched000");
					int lenof=loadPrescription.length;
					
					System.out.println("lenof "+lenof);
					int k=0;
					System.out.println(loadPrescription[k][0]);
				
					System.out.println("v1 "+loadPrescription[k][1]);
					tf_vre.setSelectedItem(loadPrescription[k][1]);
							
					System.out.println("v2 "+loadPrescription[k][2]);
					tf_vle.setSelectedItem(loadPrescription[k][2]);
				
					System.out.println("lid1 "+loadPrescription[k][3]);
					tf_lre.setSelectedItem(loadPrescription[k][3]);
				
					System.out.println("lid2 "+loadPrescription[k][4]);
					tf_lle.setSelectedItem(loadPrescription[k][4]);
				
					System.out.println("conj1 "+loadPrescription[k][5]);
					tf_conre.setSelectedItem(loadPrescription[k][5]);
				
					System.out.println("conj2 "+loadPrescription[k][6]);
					tf_conle.setSelectedItem(loadPrescription[k][6]);
				
					System.out.println("cor 1"+loadPrescription[k][7]);
					tf_corre.setSelectedItem(loadPrescription[k][7]);
				
					System.out.println("cor 2 "+loadPrescription[k][8]);
					tf_corle.setSelectedItem(loadPrescription[k][8]);
				
					System.out.println("AC 1"+loadPrescription[k][9]);
					tf_are.setSelectedItem(loadPrescription[k][9]);
				
					System.out.println("AC 2 "+loadPrescription[k][10]);
					tf_ale.setSelectedItem(loadPrescription[k][10]);
				
					System.out.println("iris 1"+loadPrescription[k][11]);
					tf_ire.setSelectedItem(loadPrescription[k][11]);
				
					System.out.println("iris 1"+loadPrescription[k][12]);
					tf_ile.setSelectedItem(loadPrescription[k][12]);
				
					System.out.println("pp 1"+loadPrescription[k][13]);
					tf_pre.setSelectedItem(loadPrescription[k][13]);
				
					System.out.println("pp 2 "+loadPrescription[k][14]);
					tf_ple.setSelectedItem(loadPrescription[k][14]);
				
					System.out.println("lens 1"+loadPrescription[k][15]);
					tf_lenre.setSelectedItem(loadPrescription[k][15]);
				
					System.out.println("lens 2"+loadPrescription[k][16]);
					tf_lenle.setSelectedItem(loadPrescription[k][16]);
					
					System.out.println("ten 1: "+loadPrescription[k][17]);
					tf_tre.setSelectedItem((""+loadPrescription[k][17]));
				
					System.out.println("ten 2: "+loadPrescription[k][18]);
					tf_tle.setSelectedItem((""+loadPrescription[k][18]));
				
					System.out.println("left gonio"+loadPrescription[k][19]);
					String LeftGonio1=loadPrescription[k][19];
				
					System.out.println("right gonio"+loadPrescription[k][20]);
					String RightGonio1=loadPrescription[k][20];
				
					System.out.println("ocu 1"+loadPrescription[k][21]);
					tf_ore.setSelectedItem(loadPrescription[k][21]);
				
					System.out.println("ocu 2"+loadPrescription[k][22]);
					tf_ole.setSelectedItem(loadPrescription[k][22]);
					
					System.out.println("fundus 1 "+loadPrescription[k][23]);
					tf_fre.setSelectedItem(loadPrescription[k][23]);
				
					System.out.println("r "+loadPrescription[k][24]);
					r.jComboBox1.setSelectedItem(loadPrescription[k][24]);
				
					System.out.println("r 2"+loadPrescription[k][25]);
					r.jComboBox2.setSelectedItem(loadPrescription[k][25]);
				
					System.out.println("r 3"+loadPrescription[k][26]);
					r.jComboBox3.setSelectedItem(loadPrescription[k][26]);
				
					System.out.println("r 4"+loadPrescription[k][27]);
					r.jComboBox4.setSelectedItem(loadPrescription[k][27]);
				
					System.out.println("r 5"+loadPrescription[k][28]);
					r.jComboBox5.setSelectedItem(loadPrescription[k][28]);
				
					System.out.println("r 6"+loadPrescription[k][29]);
					r.jComboBox6.setSelectedItem(loadPrescription[k][29]);
				
					System.out.println("r 7"+loadPrescription[k][30]);
					r.jComboBox7.setSelectedItem(loadPrescription[k][30]);
				
					System.out.println("r 8"+loadPrescription[k][31]);
					r.jComboBox8.setSelectedItem(loadPrescription[k][31]);
			
					System.out.println("r 9"+loadPrescription[k][32]);
					r.jComboBox9.setSelectedItem(loadPrescription[k][32]);
				
					System.out.println("r 10"+loadPrescription[k][33]);
					r.jComboBox10.setSelectedItem(loadPrescription[k][33]);
					
					System.out.println("r 11"+loadPrescription[k][34]);
					r.jComboBox11.setSelectedItem(loadPrescription[k][34]);
				
					System.out.println("r 12"+loadPrescription[k][35]);
					r.jComboBox12.setSelectedItem(loadPrescription[k][35]);
					
					
					String SetLeft[]=LeftGonio1.split(",");
				
					Up1.setSelectedItem(SetLeft[0]);
					Right1.setSelectedItem(SetLeft[1]);
					Down1.setSelectedItem(SetLeft[2]);
					Left1.setSelectedItem(SetLeft[3]);
					
					String SetRight[]=RightGonio1.split(",");
					
					Up2.setSelectedItem(SetRight[0]);
					Right2.setSelectedItem(SetRight[1]);
					Down2.setSelectedItem(SetRight[2]);
					Left2.setSelectedItem(SetRight[3]);
					
				/*	System.out.println("Prescription date"+loadPrescription[k][30]);
					String Prescription_Date=loadPrescription[k][30];
					
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
					System.out.println("Sec "+split_Time1[2]);*/
					
				//	String setDate=split_Date[0]+"/"+split_wholeDate1[1]+"/"+split_wholeDate1[0]+" "+split_Time1[0]+":"+split_Time1[1]+":"+split_Time1[2];//
				
						
				//	lbl_dt.setText(setDate);
					
							 
							
				}
			}
			catch(Exception ex)
			{
				System.out.println("ERROR..IN SetTheCurrentPresFun Method"+ex);
			}
	}
	private void SavePatientPresFun()
	{
		LeftGonio=""+Up1.getSelectedItem();
		LeftGonio=LeftGonio+","+""+Right1.getSelectedItem();
		LeftGonio=LeftGonio+","+""+Down1.getSelectedItem();
		LeftGonio=LeftGonio+","+""+Left1.getSelectedItem();
		System.out.println("LeftGonio "+LeftGonio);
		
		RightGonio=""+Up2.getSelectedItem();
		RightGonio=RightGonio+","+""+Right2.getSelectedItem();
		RightGonio=RightGonio+","+""+Down2.getSelectedItem();
		RightGonio=RightGonio+","+""+Left2.getSelectedItem();
		System.out.println("RightGonio "+RightGonio);
		
		String Pname=lbl_pname.getText();
		System.out.println("Pname "+Pname);
		String age=lbl_page.getText();
		System.out.println("age "+age);
		String ageArr[]=age.split("/");
		System.out.println("ageArr 0 "+ageArr[0]);
		System.out.println("ageArr 1 "+ageArr[1]);
	//	String diagnosis=tf_diagnosis.getText();
	//	System.out.println("diagnosis "+diagnosis);
	//	String complaints=tf_comlaintsof.getText();
	//	System.out.println("complaints "+complaints);
	
		int age1=Integer.parseInt(ageArr[0].trim());
		System.out.println("age1 "+age1);
		
		Date dt=new Date();
		int day=dt.getDate();
		int mon=dt.getMonth()+1;
		int year=1900+dt.getYear();
		int hr=dt.getHours();
		int min=dt.getMinutes();
		int sec=dt.getSeconds();
		String currentdate=mon+"/"+day+"/"+year;
		String currenttime=hr+":"+min+":"+sec;
		System.out.println("currentdate "+currentdate);
		
		
		s1=""+r.jComboBox1.getSelectedItem();
		System.out.println("s11 "+s11);
		s2=""+r.jComboBox2.getSelectedItem();
		System.out.println("s2 "+s2);
		s3=""+r.jComboBox3.getSelectedItem();
		System.out.println("s3 "+s3);
		s4=""+r.jComboBox4.getSelectedItem();
		System.out.println("s4 "+s4);
		s5=""+r.jComboBox5.getSelectedItem();
		System.out.println("s5 "+s5);
		 s6=""+r.jComboBox6.getSelectedItem();
		System.out.println("s6 "+s6);
		 s7=""+r.jComboBox7.getSelectedItem();
		System.out.println("s7 "+s7);
        s8=""+r.jComboBox8.getSelectedItem();
		System.out.println("s8 "+s8);
		 s9=""+r.jComboBox9.getSelectedItem();
		System.out.println("s9 "+s9);
		 s10=""+r.jComboBox10.getSelectedItem();
		System.out.println("s10 "+s10);
		 s11=""+r.jComboBox11.getSelectedItem();
		System.out.println("s11 "+s11);
		 s12=""+r.jComboBox12.getSelectedItem();
		System.out.println("s12 "+s12);
		
		
				String qry1="",qry2="";
				System.out.println("Flag "+Flag);
				
				System.out.println("chkFlag "+chkFlag);
			
				if(chkFlag==1)
				{
					qry2="Update patient_Prescription set diagnosis_sgy_code="+getsurgery_id+",diagnosis_option='"+cb2_diagnosis.getSelectedItem()+"',Complaints_of='"+cb_complaintsof.getSelectedItem()+"',History_of='"+cb_historyof.getSelectedItem()+"',Using='"+cb_using.getSelectedItem()+"' where patientID="+patientID+"";	
					System.out.println("qry2 "+qry2);
				}
				else
				{
					qry1="insert into patient_Prescription values("+patientID+",'"+lbl_pname.getText()+"','"+ageArr[0]+"','"+ageArr[1]+"',"+getsurgery_id+",'"+cb2_diagnosis.getSelectedItem()+"','"+cb_complaintsof.getSelectedItem()+"','"+cb_historyof.getSelectedItem()+"','"+cb_using.getSelectedItem()+"')";
					System.out.println("qry "+qry);
		
				}
				
				String qry3="insert into previous_Prescription values("+patientID+",'"+tf_vre.getSelectedItem()+"','"+tf_vle.getSelectedItem()+"','"+tf_lre.getSelectedItem()+"','"+tf_lle.getSelectedItem()+"','"+tf_conre.getSelectedItem()+"','"+tf_conle.getSelectedItem()+"','"+tf_corre.getSelectedItem()+"','"+tf_corle.getSelectedItem()+"','"+tf_are.getSelectedItem()+"','"+tf_ale.getSelectedItem()+"','"+tf_ire.getSelectedItem()+"','"+tf_ile.getSelectedItem()+"','"+tf_pre.getSelectedItem()+"','"+tf_ple.getSelectedItem()+"','"+tf_lenre.getSelectedItem()+"','"+tf_lenle.getSelectedItem()+"','"+tf_tre.getSelectedItem()+"','"+tf_tle.getSelectedItem()+"','"+LeftGonio+"','"+RightGonio +"','"+tf_ore.getSelectedItem()+"','"+tf_ole.getSelectedItem()+"','"+tf_fre.getSelectedItem()+"','"+r.jComboBox1.getSelectedItem()+"','"+r.jComboBox2.getSelectedItem()+"','"+r.jComboBox3.getSelectedItem()+"','"+r.jComboBox4.getSelectedItem()+"','"+r.jComboBox5.getSelectedItem()+"','"+r.jComboBox6.getSelectedItem()+"','"+r.jComboBox7.getSelectedItem()+"','"+r.jComboBox8.getSelectedItem()+"','"+r.jComboBox9.getSelectedItem()+"','"+r.jComboBox10.getSelectedItem()+"','"+r.jComboBox11.getSelectedItem()+"','"+r.jComboBox12.getSelectedItem()+"','"+ta_advice.getText()+"',#"+currentdate+"#,#"+currenttime+"#)";
				System.out.println("qry1 "+qry1);
		
		
			int variable=JOptionPane.showConfirmDialog(this,"Do You Want To Save This Record","Confirm Dialog Box",JOptionPane.YES_NO_OPTION,2);			
			if(variable==JOptionPane.YES_OPTION)
			{
					add=1;
			}
			if(add==1)
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
			
				if(chkFlag==1)
				{
					boolean successful2=inf.executeUpdateQuery(qry2);
					System.out.println("successful2 "+successful2);
				}
				else
				{
					boolean successful1=inf.executeUpdateQuery(qry1);
					System.out.println("successful1 "+successful1);
				}
				
			
				boolean successful3=inf.executeUpdateQuery(qry3);
				System.out.println("successful3 "+successful3);
			
				String st="";
			
			/*	lbl_pname.setText(st);
				lbl_page.setText(st);
				cb1_diagnosis.setSelectedItem("SELECT");
				cb_complaintsof.setSelectedItem("SELECT");
				cb_historyof.setSelectedItem("SELECT");
				cb_using.setSelectedItem("SELECT");
				ta_advice.setText(st);
				cb1_diagnosis.setSelectedItem("SELECT");
				tf_vre.setSelectedItem("SELECT");
				tf_vle.setSelectedItem("SELECT");
				tf_lre.setSelectedItem("SELECT");
				tf_lle.setSelectedItem("SELECT");
				tf_conre.setSelectedItem("SELECT");
				tf_conle.setSelectedItem("SELECT");
				tf_corre.setSelectedItem("SELECT");
				tf_corle.setSelectedItem("SELECT");
				tf_are.setSelectedItem("SELECT");
				tf_ale.setSelectedItem("SELECT");
				tf_ire.setSelectedItem("SELECT");
				tf_ile.setSelectedItem("SELECT");
				tf_pre.setSelectedItem("SELECT");
				tf_ple.setSelectedItem("SELECT");
				tf_lenre.setSelectedItem("SELECT");
				tf_lenle.setSelectedItem("SELECT");
				tf_tre.setSelectedItem(0);
				tf_tle.setSelectedItem(0);
				Up1.setSelectedItem(0);
				Right1.setSelectedItem(0);
				Down1.setSelectedItem(0);
				Left1.setSelectedItem(0);
				Up2.setSelectedItem(0);
				Right2.setSelectedItem(0);
				Down2.setSelectedItem(0);
				Left2.setSelectedItem(0);
				tf_ore.setSelectedItem("SELECT");
				tf_ole.setSelectedItem("SELECT");
				tf_fre.setSelectedItem("SELECT");
			    r.jComboBox1.setSelectedItem("SELECT");
				r.jComboBox2.setSelectedItem("SELECT");
				r.jComboBox3.setSelectedItem(0);
				r.jComboBox4.setSelectedItem("SELECT");
				r.jComboBox5.setSelectedItem("SELECT");
				r.jComboBox6.setSelectedItem("SELECT");
				r.jComboBox7.setSelectedItem(0);
				r.jComboBox8.setSelectedItem("SELECT");
				r.jComboBox9.setSelectedItem("SELECT");
				r.jComboBox10.setSelectedItem("SELECT");
				r.jComboBox11.setSelectedItem("SELECT");
				r.jComboBox12.setSelectedItem("SELECT");*/
				
				
				btn_save.setEnabled(false);
			
			}
			catch(Exception ex)
			{
				System.out.println("ERROR..IN SavePatientPresFun Method"+ex);
			}
		}
	}
	private void GetPatientHistoryFun()
	{
		String P_name=lbl_pname.getText();
		System.out.println("go");
		fetchHistory historyDG=new fetchHistory(P_name,patientID);
		historyDG.setBounds(100,50,700,370);
		historyDG.setVisible(true);
	}
	private void GetPatientPresFun()
	{
		String P_name=lbl_pname.getText();
		System.out.println("go");
		prescriptionPrevious P_previous=new prescriptionPrevious(dpp,P_name,patientID);
		P_previous.setBounds(30,40,985,550);
		P_previous.setVisible(true);
		frm.setVisible(false);
	}
	private void SetDefaultValuesFun()
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
			qry="Select dg_surgery from eye_diagnosys_surgery_common";
			System.out.println("qry "+qry);
			String loadDG1[]=inf.getResultSetAs_1D_Array(qry);
			cb1_diagnosis.addItem("SELECT");
			for(int i=0;i<loadDG1.length;i++)
			{
				System.out.println(i+" "+loadDG1[i]);
				cb1_diagnosis.addItem(loadDG1[i]);
			}
			
			
			qry="Select complain from eye_presc_complaintsOf";
			System.out.println("qry "+qry);
			String loadComplain[]=inf.getResultSetAs_1D_Array(qry);
			cb_complaintsof.addItem("SELECT");
			for(int i=0;i<loadComplain.length;i++)
			{
				cb_complaintsof.addItem(loadComplain[i]);
			}
			
			
			qry="Select history from eye_presc_historyOf";
			System.out.println("qry "+qry);
			String loadhistory[]=inf.getResultSetAs_1D_Array(qry);
			cb_historyof.addItem("SELECT");
			for(int i=0;i<loadhistory.length;i++)
			{
				cb_historyof.addItem(loadhistory[i]);
			}
			
			qry="Select using from eye_presc_using";
			System.out.println("qry "+qry);
			String loadusing[]=inf.getResultSetAs_1D_Array(qry);
			cb_using.addItem("SELECT");
			for(int i=0;i<loadusing.length;i++)
			{
				cb_using.addItem(loadusing[i]);
			}
			
			qry="Select vision_for_both_eye from eye_vision";
			System.out.println("qry "+qry);
			String loadVision[]=inf.getResultSetAs_1D_Array(qry);
			tf_vre.addItem("SELECT");
			tf_vle.addItem("SELECT");
			for(int i=0;i<loadVision.length;i++)
			{
				tf_vre.addItem(loadVision[i]);
				tf_vle.addItem(loadVision[i]);
			}
			
			qry="Select lid_for_both_eye from eye_SLE_lid";
			System.out.println("qry "+qry);
			String loadLid[]=inf.getResultSetAs_1D_Array(qry);
			tf_lre.addItem("SELECT");
			tf_lle.addItem("SELECT");
			for(int i=0;i<loadLid.length;i++)
			{
				tf_lre.addItem(loadLid[i]);
				tf_lle.addItem(loadLid[i]);
			}
			
			qry="Select conjuctiva_for_both_eye from eye_SLE_conjunctiva";
			System.out.println("qry "+qry);
			String loadConjunctiva[]=inf.getResultSetAs_1D_Array(qry);
			tf_conre.addItem("SELECT");
			tf_conle.addItem("SELECT");
			for(int i=0;i<loadConjunctiva.length;i++)
			{
				tf_conre.addItem(loadConjunctiva[i]);
				tf_conle.addItem(loadConjunctiva[i]);
			}
			
			qry="Select cornia_for_both_eye from eye_SLE_cornia";
			System.out.println("qry "+qry);
			String loadCornia[]=inf.getResultSetAs_1D_Array(qry);
			tf_corre.addItem("SELECT");
			tf_corle.addItem("SELECT");
			for(int i=0;i<loadCornia.length;i++)
			{
				tf_corre.addItem(loadCornia[i]);
				tf_corle.addItem(loadCornia[i]);
			}
			
			qry="Select AC_for_both_eye from eye_SLE_AC";
			System.out.println("qry "+qry);
			String loadAC[]=inf.getResultSetAs_1D_Array(qry);
			tf_are.addItem("SELECT");
			tf_ale.addItem("SELECT");
			for(int i=0;i<loadAC.length;i++)
			{
				tf_are.addItem(loadAC[i]);
				tf_ale.addItem(loadAC[i]);
			}
			
			qry="Select iris_for_both_eye from eye_SLE_iris";
			System.out.println("qry "+qry);
			String loadIris[]=inf.getResultSetAs_1D_Array(qry);
			tf_ire.addItem("SELECT");
			tf_ile.addItem("SELECT");
			for(int i=0;i<loadIris.length;i++)
			{
				tf_ire.addItem(loadIris[i]);
				tf_ile.addItem(loadIris[i]);
			}
			
			qry="Select pupil_for_both_eye from eye_SLE_pupil";
			System.out.println("qry "+qry);
			String loadPupil[]=inf.getResultSetAs_1D_Array(qry);
			tf_pre.addItem("SELECT");
			tf_ple.addItem("SELECT");
			
			for(int i=0;i<loadPupil.length;i++)
			{
				tf_pre.addItem(loadPupil[i]);
				tf_ple.addItem(loadPupil[i]);
			}
			qry="Select lens_for_both_eye from eye_SLE_lens";
			System.out.println("qry "+qry);
			String loadLens[]=inf.getResultSetAs_1D_Array(qry);
			tf_lenre.addItem("SELECT");
			tf_lenle.addItem("SELECT");
			for(int i=0;i<loadLens.length;i++)
			{
				tf_lenre.addItem(loadLens[i]);
				tf_lenle.addItem(loadLens[i]);
			}
			
			
			
			qry="Select ocularMobility_for_both_eye from eye_SLE_ocuMobility";
			System.out.println("qry "+qry);
			String loadOcular[]=inf.getResultSetAs_1D_Array(qry);
			tf_ore.addItem("SELECT");
			tf_ole.addItem("SELECT");
			for(int i=0;i<loadOcular.length;i++)
			{
				tf_ore.addItem(loadOcular[i]);
				tf_ole.addItem(loadOcular[i]);
			}
			
			qry="Select fundus from eye_SLE_fundus";
			System.out.println("qry "+qry);
			String loadFundus[]=inf.getResultSetAs_1D_Array(qry);
			tf_fre.addItem("SELECT");
		//	tf_fle.addItem("SELECT");
			for(int i=0;i<loadFundus.length;i++)
			{
				tf_fre.addItem(loadFundus[i]);
			//	tf_fle.addItem(loadFundus[i]);
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("ERROR.."+ex);
		}
		
	}
	class printDischargeCard extends JFrame 
   {
        	JInternalFrame pchallanf;
	        Container contentPane;
        	GridBagLayout gbl;
	        GridBagConstraints gbc;
        	JButton printButton;
	        JButton pageSetupButton,exitButton;

			PrintPanel canvas;
	        PageFormat pageFormat;

        	public printDischargeCard(JDesktopPane desk)
        	{
                pchallanf=new JInternalFrame("Printing of Invoice",false,true,true,true);
                contentPane=pchallanf.getContentPane();
				gbl=new GridBagLayout();
				gbc=new GridBagConstraints();
                contentPane.setLayout(new BorderLayout());

                addWindowListener(new WindowAdapter()
                {
                        public void windowClosing(WindowEvent e)
                        {
                                System.exit(0);
                        }
                }
                );

                canvas=new PrintPanel();
                contentPane.add(canvas,"Center");
                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new GridLayout(2,1));

                //pageSetupButton.addActionListener(this);

                contentPane.add(buttonPanel,"East");

                                PrinterJob printJob=PrinterJob.getPrinterJob();
                                double width=8.27 * 72;
                                double height=(11.69 * 72);
                                Paper paper=new Paper();                                
                                paper.setSize(width,height);

                                PageFormat page=new PageFormat();
                                paper.setImageableArea(5,10,paper.getWidth(),paper.getHeight());
                                //page.setOrientation(PageFormat.LANDSCAPE);
                                page.setPaper(paper);
                                pageFormat=printJob.defaultPage(page);
                                pageFormat.setPaper(paper);
                                printJob.setPrintable(canvas,pageFormat);
								
                                try
                                {
										System.out.println("W="+paper.getWidth()+"H="+paper.getHeight());
										currentpg=1;
										printJob.print();
	                            }
                                catch(Exception exception)
                                {
                                        JOptionPane.showMessageDialog(this,exception);
                                }
        		}
	}
		int currentpg,totalpg, rem;
	boolean firsttime=false;
	boolean complete=false;
	int currentrec=0,startno=0,endno=0;
	//print ---------
	class PrintPanel extends JPanel implements Printable
	{
	
        //Connection connection;
        //Statement st,st1;
        //ResultSet rs,rs1;
        int page=100;
		TextLayout layout;
		Font f,f1,f2,f3,f4,f5,f6;
		Graphics2D g2;
		int row=0;		
		FontRenderContext context;
        
        
        public PrintPanel()
        {
                //ChallanNo=JOptionPane.showInputDialog(null,"Enter Challan Number:");
        }
        public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                Graphics2D g2=(Graphics2D)g;
                drawPage(g2);
        }
        public int print(Graphics g,PageFormat pf,int page) throws PrinterException
        {
                if(page>=1)
                        return Printable.NO_SUCH_PAGE;
                Graphics2D g2=(Graphics2D)g;
                g2.setPaint(Color.black);
                g2.translate(pf.getImageableX(),pf.getImageableY());
                //g2.draw(new Rectangle2D.Double(0,0,pf.getImageableWidth(),pf.getImageableHeight()));
                System.out.println("W1="+pf.getImageableWidth()+"H1="+pf.getImageableHeight());
                drawPage(g2);
                return Printable.PAGE_EXISTS;
        }
        
    
        public void drawPage(Graphics2D g2)
        {
			this.g2=g2;
			//System.out.println("inside draw page..."+totalamt);	
			
            context=g2.getFontRenderContext();
            f1=new Font("Times New Roman",Font.BOLD,10);
            //f1=new Font("Arial",Font.BOLD,120);
            f2=new Font("Arial",Font.PLAIN,7);
            f3=new Font("Arial",Font.PLAIN,10);
            f4=new Font("Arial",Font.BOLD,10);
            f5=new Font("Times New Roman",Font.PLAIN,11);
            f6=new Font("Times New Roman",Font.BOLD,11);
            Font f7=new Font("Times New Roman",Font.BOLD,12);
            Font f8=new Font("Times New Roman",Font.PLAIN,6);
            FontMetrics fm;
            GeneralPath clipShape=new GeneralPath();

            String str=" fdfg dfg dfg";
            String str1="d fgf dgdfg df";                                        
            g2.setFont(f1);
            layout=new TextLayout(str,f1,context);
            AffineTransform transform=AffineTransform.getTranslateInstance(10,20);
			
			if(firsttime==false)
			{
				firsttime=true;
			}
			else
			{			
		        try
        		{
        			System.out.println("dhananjay.............1");
        			
        			
		        	
					
					System.out.println("dhananjay.............2");
					
					
					
					fm=g2.getFontMetrics();				
					String temp="";
		            int top=205;
		            
		            if(currentpg==1)
		            {
		            
						System.out.println("s......");

		            
		            
		            g2.setFont(f7);
		            fm=g2.getFontMetrics();				
		            temp=lbl_pname.getText();
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,195,top);
        		    
		            //top+=20;
		            g2.setFont(f7);
		            fm=g2.getFontMetrics();
                    
                    String t[]=lbl_page.getText().split("/");
                    if(t[1].equals("Male"))
                    {
                    	temp=t[0]+"/ M";
                    }
                    else
                    {
                    	temp=t[0]+"/ F";
                    }
                    //temp=lbl_page.getText();
		            //temp=firm.toUpperCase();
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,420,top);
        		    
        		    java.util.Date dt=new java.util.Date();
        		    temp=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
		            layout=new TextLayout(temp,f7,context);
        		    g2.drawString(temp,(540-fm.stringWidth(temp)),top);
					
					//second line
                    top+=20;
					
                    
                    try
                    {
                    //	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
                    ZedInterface inf=null;

try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
                    
                    
                    
                    
                    	String rs[][]=inf.getResultSetAs_2D_Array("select address,city,pincode from patient_Profile where patientid="+patientID+"",3);
                    	if(rs!=null)
                    	{
                    		g2.setFont(f7);
		            		fm=g2.getFontMetrics();
		            		//vill				
		            		temp=rs[0][0];
		            		layout=new TextLayout(temp,f7,context);
        		    		g2.drawString(temp,210,top);
        		    		//post
        		    		temp=rs[0][1];
		            		layout=new TextLayout(temp,f7,context);
        		    		g2.drawString(temp,370,top);
        		    		//distt
        		    		temp=rs[0][2];
		            		layout=new TextLayout(temp,f7,context);
        		    		g2.drawString(temp,(540-fm.stringWidth(temp)),top);
                    	}
                    }   
                    catch(Exception e)                 
                    {
                    	System.out.println("Error...SKM_R..."+e);
                    }
                    
		          	//diagnosys
		          	top+=39;
		          	
		          	g2.setFont(f7);
		           	fm=g2.getFontMetrics();
		            //1	
		            if(!(""+cb1_diagnosis.getSelectedItem()).equalsIgnoreCase("SELECT"))
		            {
		            	temp=""+cb1_diagnosis.getSelectedItem();
		            	layout=new TextLayout(temp,f7,context);
        		    	g2.drawString(temp,220,top);
        		    }
        		    //2
        		    if(!(""+cb2_diagnosis.getSelectedItem()).equalsIgnoreCase("SELECT"))
        		    {
        		    	temp=""+cb2_diagnosis.getSelectedItem();
		            	layout=new TextLayout(temp,f7,context);
        		    	g2.drawString(temp,(540-fm.stringWidth(temp)),top);
        		    }
        		    //complaints of
        		    top+=15;
		          	
		          	g2.setFont(f7);
		           	fm=g2.getFontMetrics();	
		           	if(!(""+cb_complaintsof.getSelectedItem()).equalsIgnoreCase("SELECT") && cb_complaintsof.getSelectedItem() !=null)
		           	{
		          		temp=""+cb_complaintsof.getSelectedItem();
		            	layout=new TextLayout(temp,f7,context);
        		    	g2.drawString(temp,250,top);
        		    }
        		    //History of & Using
        		    top+=15;
		          	
		          	g2.setFont(f7);
		           	fm=g2.getFontMetrics();	
		           	if(!(""+cb_historyof.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+cb_historyof.getSelectedItem();
		            	layout=new TextLayout(temp,f7,context);
        		    	g2.drawString(temp,210,top);
        		    }
					if(!(""+cb_using.getSelectedItem()).equalsIgnoreCase("SELECT"))
					{		
		            	temp=""+cb_using.getSelectedItem();
		            	layout=new TextLayout(temp,f7,context);
        		    	g2.drawString(temp,(540-fm.stringWidth(temp)),top);
        		    }
//------------------------setting all RE and LE --------------------------------------
        		    int re=270;
        		    int le=330;
        		    
        		    //vision
        		    top+=25;
        		    g2.setFont(f2);
        		    fm=g2.getFontMetrics();	
		           	if(!(""+tf_vre.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_vre.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_vle.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_vle.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//lid
		           	top+=70;
		           	//storing top value for advice
		           	int top_advice=top+15;
		           	
		           	if(!(""+tf_lre.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_lre.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_lle.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_lle.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//Conjuctiva
		           	top+=25;
		           	
		           	if(!(""+tf_conre.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_conre.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_conle.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_conle.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//cornea
		           	top+=25;
		           	
		           	if(!(""+tf_corre.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_corre.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_corle.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_corle.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//AC
		           	top+=25;
		           	
		           	if(!(""+tf_are.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_are.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_ale.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_ale.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//Iris
		           	top+=20;
		           	
		           	if(!(""+tf_ire.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_ire.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_ile.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_ile.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//Pupil
		           	top+=25;
		           	
		           	if(!(""+tf_pre.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_pre.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_ple.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_ple.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//Lens
		           	top+=25;
		           	
		           	if(!(""+tf_lenre.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_lenre.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_lenle.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_lenle.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//Tn A
		           	top+=25;
		           	
		           	if(!(""+tf_tre.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_tre.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_tle.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_tle.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//Gonio
		           	top+=15;
		           	g2.setFont(f8);
        		    fm=g2.getFontMetrics();
		           	///====RE------
		           	if(!(""+Up1.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+Up1.getSelectedItem();
		            	layout=new TextLayout(temp,f8,context);
        		    	g2.drawString(temp,re,top);
		           	}
		           	if(!(""+Left1.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+Left1.getSelectedItem();
		            	layout=new TextLayout(temp,f8,context);
        		    	g2.drawString(temp,re-15,top+5);
		           	}
		           	if(!(""+Right1.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+Right1.getSelectedItem();
		            	layout=new TextLayout(temp,f8,context);
        		    	g2.drawString(temp,re+15,top+5);
		           	}
		           	if(!(""+Down1.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+Down1.getSelectedItem();
		            	layout=new TextLayout(temp,f8,context);
        		    	g2.drawString(temp,re,top+15);
		           	}
		           	//===LE-----------		
		            if(!(""+Up2.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+Up2.getSelectedItem();
		            	layout=new TextLayout(temp,f8,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	if(!(""+Left2.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+Left2.getSelectedItem();
		            	layout=new TextLayout(temp,f8,context);
        		    	g2.drawString(temp,le-10,top+5);
		           	}
		           	if(!(""+Right2.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+Right2.getSelectedItem();
		            	layout=new TextLayout(temp,f8,context);
        		    	g2.drawString(temp,le+10,top+5);
		           	}
		           	if(!(""+Down2.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+Down2.getSelectedItem();
		            	layout=new TextLayout(temp,f8,context);
        		    	g2.drawString(temp,le,top+15);
		           	}
		           	
		           	//Ocular Mobility
		           	top+=30;
		           	g2.setFont(f2);
        		    fm=g2.getFontMetrics();
		           	if(!(""+tf_ore.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_ore.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}		
		            if(!(""+tf_ole.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_ole.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	
		           	//fundus
		           	top+=25;
		           	
		           	if(!(""+tf_fre.getSelectedItem()).equalsIgnoreCase("SELECT"))
		           	{
		           		temp=""+tf_fre.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}
		           	
		           	//refrection
		           	top+=25;
		           	g2.setFont(f8);
        		    fm=g2.getFontMetrics();
        		    //setting pre defined word of refraction
		           	temp="SPH";
		            layout=new TextLayout(temp,f8,context);
        		    g2.drawString(temp,re-30,top);
        		    temp="CYL";
		            layout=new TextLayout(temp,f8,context);
        		    g2.drawString(temp,re-30,top+8);
        		    temp="Axis";
		            layout=new TextLayout(temp,f8,context);
        		    g2.drawString(temp,re-30,top+16);
        		    temp="Va";
		            layout=new TextLayout(temp,f8,context);
        		    g2.drawString(temp,re-30,top+24);
		           	temp="N";
		            layout=new TextLayout(temp,f8,context);
        		    g2.drawString(temp,re-50,top+32);
		           	//RE refraction
		           	if(!(""+r.jComboBox1.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox1.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox1.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top);
		           	}
		           	if(!(""+r.jComboBox2.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox2.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox2.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top+8);
		           	}
		           	if(!(""+r.jComboBox3.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox3.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox3.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top+16);
		           	}
		           	if(!(""+r.jComboBox4.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox4.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox4.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top+24);
		           	}
		           	if(!(""+r.jComboBox9.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox9.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox9.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re-20,top+32);
		           	}
		           	if(!(""+r.jComboBox10.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox10.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox10.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,re,top+32);
		           	}
		           	//LE refraction
		           	if(!(""+r.jComboBox5.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox5.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox5.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top);
		           	}
		           	if(!(""+r.jComboBox6.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox6.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox6.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top+8);
		           	}
		           	if(!(""+r.jComboBox7.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox7.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox7.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top+16);
		           	}
		           	if(!(""+r.jComboBox8.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox8.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox8.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le,top+24);
		           	}
		           	if(!(""+r.jComboBox11.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox11.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox11.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le-10,top+32);
		           	}
		           	if(!(""+r.jComboBox12.getSelectedItem()).equalsIgnoreCase("SELECT") && (r.jComboBox12.getSelectedItem()!=null))
		           	{
		           		temp=""+r.jComboBox12.getSelectedItem();
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,le+10,top+32);
		           	}
		           	
		           	
		           	//SAC BP SUGAR
                    top+=50;
					g2.setFont(f4);
        		    fm=g2.getFontMetrics();
                    
                    try
                    {
                    //	ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
                    
                    ZedInterface inf=null;

try
{
	inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
}
catch(Exception e)
{
	System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
	getIPaddress.changeIP();
	try
	{
		inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	
	}
	catch(Exception ex)
	{
		System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
	}
}
                    
                    
                    
                    	String rs[][]=inf.getResultSetAs_2D_Array("select Sac,blood_pr,sugar from history_Patient where patient_id="+patientID+" order by history_date desc",3);
                    	if(rs!=null)
                    	{
                    		g2.setFont(f4);
		            		fm=g2.getFontMetrics();
		            		//Sac				
		            		temp=rs[0][0];
		            		layout=new TextLayout(temp,f4,context);
        		    		g2.drawString(temp,220,top);
        		    		//BP
        		    		top+=25;
        		    		
        		    		temp=rs[0][1];
		            		layout=new TextLayout(temp,f4,context);
        		    		g2.drawString(temp,220,top);
        		    		//Sugar
        		    		top+=25;
        		    		
        		    		temp=rs[0][2];
		            		layout=new TextLayout(temp,f4,context);
        		    		g2.drawString(temp,250,top);
                    	}
                    }   
                    catch(Exception e)                 
                    {
                    	System.out.println("Error...SKM_R..."+e);
                    }
		           	
		           	//advice
		           	int adviceX=le+70;
		           	int adviceY=top_advice;
					g2.setFont(f4);
        		    fm=g2.getFontMetrics();
		           	
		           	temp=""+ta_advice.getText();
		           	String t1[]=temp.split("\n");
		           	if(t1!=null)
		           	{
		           		System.out.println(""+t1.length);
		           		for(int i=0;i<t1.length;i++)
		           		{
		           			temp=""+t1[i];
		           			layout=new TextLayout(temp,f4,context);
        		    		g2.drawString(temp,adviceX,adviceY);
        		    		adviceY+=20;	
		           		}
		           	}
		            
		           	
					//--end---------------------------------------
					}
         		}
         		catch(Exception x)
         		{
	        		System.out.println("Error2193821..."+x);
         		}
         
         	}
      	}
	}

}