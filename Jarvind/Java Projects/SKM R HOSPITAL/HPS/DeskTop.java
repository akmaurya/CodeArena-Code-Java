import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.rmi.*;
import java.util.*;

class DeskTop extends JFrame implements ActionListener
{
	
	static Dimension dm;
	JDesktopPane dp;
	JLabel wallpaperLb;
	
	JLabel lbl_DateAndTime;
	
	JMenuBar  mb;
	JButton btn_newReg,btn_drLogin,btn_admit,btn_surgery,btn_spectsEntry,btn_receipt,btn_discharge,btn_newStaff,btn_pendingSurgery,btn_pendingSpects;
	
	JMenu master,doctor,opd,ipd,surgery,Staff,Report,Utility,payment,certificate,help,spectacles;
	JMenuItem mas_it1,mas_it2,mas_it3,mas_it4,mas_it5,mas_it6,mas_it7,mas_it8,mas_it9,mas_it10,mas_it11,mas_it12,mas_it13,doc_it1,opd_it1,opd_it2,opd_it3,opd_it4,opd_it5,opd_it6,opd_it7,opd_it8,opd_it9,opd_it10,opd_it11,opd_it12,sur_it2,sur_it1;
	JMenuItem staff_it1,staff_it2,staff_it3,report_it1,report_it2,report_it3,report_it4,report_it5,report_it6,report_it7,report_it8,report_it9,report_it10,report_it11,report_it12,report_it13,report_it14,report_it15,report_it16,report_it17,report_it18,report_it19,utility_it1,utility_it2,utility_it3,utility_it4,utility_it5,utility_it6,utility_it7,utility_it8,staff_it4,staff_it5;
	JMenuItem pay_it1,pay_it2,certi_it1,certi_it2,help_it1,spects_it1,spects_it2,spects_it3,spects_it4,spects_it5,spects_it6,spects_it7;
	JMenuItem spectacles_it1;
	JMenuItem staffleave;

	JMenu report_spects,report_staff;
	
	String id;
        
    int level;
    ZedInterface inf;
	/*public static void main(String arg[])
	{
		dm=Toolkit.getDefaultToolkit().getScreenSize();
		DeskTop patientdkt=new DeskTop();
		
		patientdkt.setSize(dm.width,dm.height);
		patientdkt.setVisible(true);
	}*/
	public DeskTop(String id,int level)
	{
		setTitle("H O S P I T A L   M A N A G E M E N T   S Y S T E M   V e r 1 . 1");
		this.id=id;
        this.level=level;
        dm=Toolkit.getDefaultToolkit().getScreenSize();
		dp=new JDesktopPane();
		setContentPane(dp);
		//dp.setLayout(null);
		setIconImage(getToolkit().getImage("icons\\zicon.gif"));
		mb=new JMenuBar();
		mb.setBounds(0,0,dm.width,30);
		dp.add(mb);
		
		////////updated here by S_CHK///////
//		update.updateRec();
		
		
		
		
		//----ADDING TOOLBAR -------
		JToolBar toolbar=new JToolBar();
		toolbar.setLayout(null);
		toolbar.setBounds(0,35,dm.width,30);
		dp.add(toolbar);
		
		Cursor cr=new Cursor(Cursor.HAND_CURSOR);
		
		btn_newReg=new JButton(new ImageIcon("icons\\new.gif"));
		btn_newReg.setBounds(5,0,25,25);
		toolbar.add(btn_newReg);
		btn_newReg.setToolTipText("New Registration");
		btn_newReg.addActionListener(this);
		toolbar.addSeparator();
		btn_newReg.setCursor(cr);
		
		btn_drLogin=new JButton(new ImageIcon("icons\\login.gif"));
		btn_drLogin.setBounds(32,0,25,25);
		toolbar.add(btn_drLogin);
		btn_drLogin.setToolTipText("Login Doctor");
		btn_drLogin.addActionListener(this);
		toolbar.addSeparator();
		btn_drLogin.setCursor(cr);
		
		btn_admit=new JButton(new ImageIcon("icons\\admit.gif"));
		btn_admit.setBounds(59,0,25,25);
		toolbar.add(btn_admit);
		btn_admit.setToolTipText("Admit Patient");
		btn_admit.addActionListener(this);
		toolbar.addSeparator();
		btn_admit.setCursor(cr);
		
		btn_surgery=new JButton(new ImageIcon("icons\\surgery.gif"));
		btn_surgery.setBounds(86,0,25,25);
		toolbar.add(btn_surgery);
		btn_surgery.setToolTipText("Surgery Entry");
		btn_surgery.addActionListener(this);
		toolbar.addSeparator();
		btn_surgery.setCursor(cr);
		
		btn_spectsEntry=new JButton(new ImageIcon("icons\\edit.gif"));
		btn_spectsEntry.setBounds(113,0,25,25);
		toolbar.add(btn_spectsEntry);
		btn_spectsEntry.setToolTipText("Spectacles Entry");
		btn_spectsEntry.addActionListener(this);
		toolbar.addSeparator();
		btn_spectsEntry.setCursor(cr);
		
		btn_receipt=new JButton(new ImageIcon("icons\\receipt.gif"));
		btn_receipt.setBounds(140,0,25,25);
		toolbar.add(btn_receipt);
		btn_receipt.setToolTipText("Make Receipt");
		btn_receipt.addActionListener(this);
		toolbar.addSeparator();
		btn_receipt.setCursor(cr);
		
		btn_discharge=new JButton(new ImageIcon("icons\\update.gif"));
		btn_discharge.setBounds(167,0,25,25);
		toolbar.add(btn_discharge);
		btn_discharge.setToolTipText("Make Discharge Card");
		btn_discharge.addActionListener(this);
		toolbar.addSeparator();
		btn_discharge.setCursor(cr);
		
		btn_newStaff=new JButton(new ImageIcon("icons\\createstaff.gif"));
		btn_newStaff.setBounds(194,0,25,25);
		toolbar.add(btn_newStaff);
		btn_newStaff.setToolTipText("Staff Registration");
		btn_newStaff.addActionListener(this);
		toolbar.addSeparator();
		btn_newStaff.setCursor(cr);
		
		btn_pendingSurgery=new JButton(new ImageIcon("icons\\pendingSur.gif"));
		btn_pendingSurgery.setBounds(221,0,25,25);
		toolbar.add(btn_pendingSurgery);
		btn_pendingSurgery.setToolTipText("Pending Surgery");
		btn_pendingSurgery.addActionListener(this);
		toolbar.addSeparator();
		btn_pendingSurgery.setCursor(cr);
		
		btn_pendingSpects=new JButton(new ImageIcon("icons\\pendingSpects.gif"));
		btn_pendingSpects.setBounds(248,0,25,25);
		toolbar.add(btn_pendingSpects);
		btn_pendingSpects.setToolTipText("Pending Spectacles");
		btn_pendingSpects.addActionListener(this);
		toolbar.addSeparator();
		btn_pendingSpects.setCursor(cr);
		
		JLabel lbl1_GIF=new JLabel(new ImageIcon("icons\\progressbar1.gif"));
		lbl1_GIF.setBounds(300,0,110,25);
		toolbar.add(lbl1_GIF);
		lbl1_GIF.setCursor(cr);
		
		///...........date and time...........
		Date date1=new Date();
      	GregorianCalendar calendar = new GregorianCalendar();
      	String hour=""+calendar.get(Calendar.HOUR_OF_DAY);
      	if(hour.length()==1)
      	{
      			hour="0"+hour;
      	}
	    String minute=""+calendar.get(Calendar.MINUTE);
	    if(minute.length()==1)
	    {
	      	minute="0"+minute;
	    }
		String second=""+calendar.get(Calendar.SECOND);
		if(second.length()==1)
		{
		      second="0"+second;
		}
      	String time="";
      					
      	String date=""+(date1.getDate()+1);
      	if(date.length()==1)
      	{
      			date="0"+date;
      	}
      	String mon=""+(date1.getMonth()+1);
      	if(mon.length()==1)
      	{
      		mon="0"+mon;
      	}
      	String year=""+(date1.getYear()+1900);			
	    time=date+"-"+mon+"-"+year+"  "+hour+":"+minute+":"+second;
		
		lbl_DateAndTime=new JLabel(""+time);
		lbl_DateAndTime.setForeground(Color.RED);
		lbl_DateAndTime.setBounds((dm.width-time.length()-120),0,690,25);
		toolbar.add(lbl_DateAndTime);
		
		Timer t=new Timer();
		t.start();
		
		
		//----END TOOLBAR CODE------
		
		
		//.....ADDING WALLPAPER........
		
		wallpaperLb=new JLabel(new ImageIcon("wallpapers\\"+selectImage()));
		System.out.println("s2...");
		wallpaperLb.setBounds(0,60,dm.width+2,dm.height-25-130);
		dp.add(wallpaperLb);
		//.....END CODE OF WALLPAPER......
		
		//-----------master menu---------
		master=new JMenu("Master  ");
		master.setMnemonic('M');
		mb.add(master);
		
		mas_it1=new JMenuItem("Add Doctor Category",new ImageIcon("icons\\surgeon.gif"));
	mas_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
     //   mas_it1.setMnemonic('a');
		mas_it2=new JMenuItem("Add Doctor",new ImageIcon("icons\\appointment.gif"));
		mas_it2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it3=new JMenuItem("Add Ward",new ImageIcon("icons\\sticky.gif"));
		mas_it3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it4=new JMenuItem("Add Room",new ImageIcon("icons\\addRoom.gif"));
		mas_it4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it5=new JMenuItem("Add Bed",new ImageIcon("icons\\bed.gif"));
		mas_it5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it6=new JMenuItem("Edit Doctor Category",new ImageIcon("icons\\edit1.gif"));
		mas_it6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it7=new JMenuItem("Edit Ward",new ImageIcon("icons\\edit2.gif"));
		mas_it7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it8=new JMenuItem("Edit Room",new ImageIcon("icons\\edit2.gif"));
		mas_it8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it9=new JMenuItem("Edit Bed",new ImageIcon("icons\\edit2.gif"));
		mas_it9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it10=new JMenuItem("Delete Room",new ImageIcon("icons\\room_del.gif"));
		mas_it10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it11=new JMenuItem("Delete Bed",new ImageIcon("icons\\delBed.gif"));
		mas_it11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it12=new JMenuItem("Exit",new ImageIcon("icons\\logoff.gif"));
		mas_it12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		mas_it13=new JMenuItem("Status Of Bed",new ImageIcon("icons\\hotfinal.gif"));
		mas_it13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));

                staffleave=new JMenuItem("staff leave report",new ImageIcon("icons\\edit2.gif"));
		staffleave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		
		master.add(mas_it1);
		master.addSeparator();
		//master.add(mas_it2);
		master.add(mas_it3);
		master.addSeparator();
		master.add(mas_it4);
		master.addSeparator();
		master.add(mas_it5);
	//	master.addSeparator();
		master.add(mas_it13);
		master.addSeparator();
		master.add(mas_it6);
	//	master.addSeparator();
		master.add(mas_it7);
	//	master.addSeparator();
		master.add(mas_it8);
	//	master.addSeparator();
		master.add(mas_it9);
		master.addSeparator();
		master.add(mas_it10);
	//	master.addSeparator();
		master.add(mas_it11);
		master.addSeparator();
		master.add(mas_it12);
		
		
		//---------end master menu------------------------
		
		//------------Doctor Menu------------------------
		
		doctor=new JMenu("Doctor  ");
		doctor.setMnemonic('D');
		mb.add(doctor);
		doc_it1=new JMenuItem("Doctor Login",new ImageIcon("icons\\doc1.gif"));
		doc_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		doctor.add(doc_it1);
		
		//-------------end doctor menu----------------------
		
		//-------------OPD menu-----------------------------
		
		opd=new JMenu("OPD    ");
		opd.setMnemonic('O');
		mb.add(opd);
		
		opd_it1=new JMenuItem("New Patient Registration",new ImageIcon("icons\\hand.gif"));
		opd_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		opd_it2=new JMenuItem("Edit Patient Registration",new ImageIcon("icons\\edit_pt.gif"));
		opd_it2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		opd_it3=new JMenuItem("Existing Patient - OPD",new ImageIcon("icons\\openid.gif"));
		opd_it3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		opd_it4=new JMenuItem("Input Patient Fee",new ImageIcon("icons\\feePay1.gif"));
		opd_it4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		opd_it11=new JMenuItem("Edit Patient Fee Details",new ImageIcon("icons\\edit1.gif"));
		opd_it11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		opd_it12=new JMenuItem("Edit YAG Master",new ImageIcon("icons\\edit_YAG.gif"));
		opd_it12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));;
		
	//	opd_it5=new JMenuItem("Admit Patient",'a');
	//	opd_it6=new JMenuItem("Patient Receiving",'p');
	//	opd_it7=new JMenuItem("Sell : To Patient",'s');
	//	opd_it8=new JMenuItem("Discharge : To Patient",'c');
	//	opd_it9=new JMenuItem("Patient : Spects Entry",'i');
	//	opd_it10=new JMenuItem("Patient : Provide Spects",'v');
	//	opd_it11=new JMenuItem("Medical Certificate");
		
		opd.add(opd_it1);
		opd.addSeparator();
		opd.add(opd_it2);
		opd.addSeparator();
		opd.add(opd_it3);
		opd.addSeparator();
	//	opd.add(opd_it7);
	//	opd.addSeparator();
		opd.add(opd_it4);
		opd.addSeparator();
		opd.add(opd_it11);
	//	opd.add(opd_it5);
	//	opd.addSeparator();
		opd.add(opd_it12);
	//	opd.addSeparator();
	//	opd.add(opd_it8);
	//	opd.addSeparator();
	//	opd.add(opd_it9);
	//	opd.addSeparator();
	//	opd.add(opd_it10);
	//	opd.addSeparator();
	//	opd.add(opd_it11);
		
		//opd.add(opd_it7);
		
		//-------------end OPD menu-------------------------
		
		///-------------IPD menu---------------------------
		
		ipd=new JMenu("IPD   ");
		ipd.setMnemonic('I');
		mb.add(ipd);
		
		opd_it5=new JMenuItem("Admit Patient",new ImageIcon("icons\\Admit_pt.gif"));
		opd_it5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		opd_it7=new JMenuItem("Sell : To Patient",new ImageIcon("icons\\sale.gif"));
		opd_it7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		opd_it6=new JMenuItem("Payment Receiving",new ImageIcon("icons\\receiving.gif"));
		opd_it6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		opd_it8=new JMenuItem("Discharge : To Patient",new ImageIcon("icons\\discharge.gif"));
		opd_it8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		
	
		ipd.add(opd_it7);
		ipd.addSeparator();
		ipd.add(opd_it5);
		ipd.addSeparator();
		ipd.add(opd_it6);
		ipd.addSeparator();
		ipd.add(opd_it8);
		ipd.addSeparator();
		
		
		
		///------------end IPD menu------------------------
		
		//-------------Surgery Menu-------------------------
		surgery=new JMenu("Surgery   ");
		surgery.setMnemonic('S');
		mb.add(surgery);
		
		sur_it1=new JMenuItem("Edit Surgery Entry",new ImageIcon("icons\\editSurgery.gif"));
		sur_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		sur_it2=new JMenuItem("Surgery Entry",new ImageIcon("icons\\Surgery1.gif"));
		sur_it2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		
		surgery.add(sur_it2);
		surgery.addSeparator();
		surgery.add(sur_it1);
		
		//--------------end Surgery Menu--------------------
		
		//-------------Payment Menu-------------------------
		payment=new JMenu("Payment   ");
		payment.setMnemonic('P');
		mb.add(payment);
		pay_it1=new JMenuItem("Receive Payment",new ImageIcon("icons\\ptRece.gif"));
		pay_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));	
		pay_it2=new JMenuItem("Other Payment Entry",new ImageIcon("icons\\other.gif"));
		pay_it2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		payment.add(pay_it1);
		payment.addSeparator();
		payment.add(pay_it2);
		pay_it1.addActionListener(this);
		pay_it2.addActionListener(this);
		//--------------end Payment Menu--------------------
		
		///-------------Spectacles--------------------------
		spectacles=new JMenu("Spectacles  ");
		spectacles.setMnemonic('T');
		mb.add(spectacles);
		
		//////////code update here////////////////////////////////////////
		
		spects_it1=new JMenuItem("Company Master : Spectacle",new ImageIcon("icons\\company.gif"));
	spects_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		spects_it2=new JMenuItem("Opening Stock : Spectacle",new ImageIcon("icons\\stock1.gif"));
		spects_it2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		spects_it3=new JMenuItem("Make Purchase : Spectacle",new ImageIcon("icons\\spectacles.gif"));
		spects_it3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		spects_it4=new JMenuItem("Edit Purchase Of Spectacle:DateWise",new ImageIcon("icons\\edit_old.gif"));
		spects_it4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		//////////////////////////////////////////////////////////////////
		opd_it9=new JMenuItem("Patient : Spects Entry",new ImageIcon("icons\\patient.gif"));
		opd_it9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		spectacles_it1=new JMenuItem("Patient : Edit Spects Entry",new ImageIcon("icons\\edit1.gif"));
		spectacles_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		opd_it10=new JMenuItem("Patient : Provide Spects",new ImageIcon("icons\\spectacles.gif"));
		opd_it10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		spects_it5=new JMenuItem("Direct Sale Of Spectacles",new ImageIcon("icons\\customers.gif"));
		spects_it5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		spects_it6=new JMenuItem("Edit : Direct Sale Of Spectacles",new ImageIcon("icons\\sticky2.gif"));
		spects_it6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		spects_it7=new JMenuItem("Customer : Provide Spects",new ImageIcon("icons\\spectacles.gif"));
		spects_it7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		spectacles.add(spects_it1);
		spectacles.add(spects_it2);
		spectacles.addSeparator();
		spectacles.add(spects_it3);
		spectacles.add(spects_it4);
		spectacles.addSeparator();
		spectacles.add(opd_it9);
	//	spectacles.addSeparator();
		spectacles.add(spectacles_it1);
	//	spectacles.addSeparator();
		spectacles.add(opd_it10);
		spectacles.addSeparator();
		spectacles.add(spects_it5);
		spectacles.add(spects_it6);
		spectacles.add(spects_it7);
		
		spectacles_it1.addActionListener(this);
		spects_it1.addActionListener(this);
		spects_it2.addActionListener(this);
		spects_it3.addActionListener(this);
		spects_it4.addActionListener(this);
		spects_it5.addActionListener(this);
		spects_it6.addActionListener(this);
		spects_it7.addActionListener(this);
		///-------------end Spectacles Menu-----------------
		
		//--------------Staff Menu--------------------------
		Staff=new JMenu("Staff     ");
		Staff.setMnemonic('f');
		mb.add(Staff);
		staff_it1=new JMenuItem("Staff Registration",new ImageIcon("icons\\appointment.gif"));
		staff_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		staff_it2=new JMenuItem("Edit Staff Info",new ImageIcon("icons\\edit1.gif"));
		staff_it2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		staff_it3=new JMenuItem("Staff Attendance",new ImageIcon("icons\\staff1.gif"));
		staff_it3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		staff_it4=new JMenuItem("Staff Leave",new ImageIcon("icons\\leave.gif"));
		staff_it4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		staff_it5=new JMenuItem("Staff Salary",new ImageIcon("icons\\salary.gif"));
		staff_it5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		Staff.add(staff_it1);
		Staff.addSeparator();
		Staff.add(staff_it2);
		Staff.addSeparator();
		Staff.add(staff_it3);
	//	Staff.addSeparator();
		Staff.add(staff_it4);
		Staff.addSeparator();
		Staff.add(staff_it5);
		staff_it1.addActionListener(this);
		staff_it2.addActionListener(this);
		staff_it3.addActionListener(this);
		staff_it4.addActionListener(this);
		staff_it5.addActionListener(this);
		
		//--------------------------------------------------
		///////////////////certificate//////////////////////
		certificate=new JMenu("Certificate    ");
		certificate.setMnemonic('c');
		mb.add(certificate);
		
		certi_it1=new JMenuItem("Medical/Fitness Certificate",new ImageIcon("icons\\list_users.gif"));
		certi_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		certificate.add(certi_it1);
		certi_it1.addActionListener(this);
		certi_it2=new JMenuItem("Birth Certificate",new ImageIcon("icons\\birth.gif"));
		certi_it2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		certificate.add(certi_it2);
		certi_it2.addActionListener(this);
		
		///////////////////end of certificate//////////////
		//------------------Report Menu---------------------
		Report=new JMenu("Patient Report   ");
		Report.setMnemonic('R');
		mb.add(Report);
		report_it1=new JMenuItem("Search Patient",new ImageIcon("icons\\search.gif"));
		report_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it4=new JMenuItem("Patient Details",new ImageIcon("icons\\hist.gif"));
		report_it4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it5=new JMenuItem("Cash Details",new ImageIcon("icons\\payment.gif"));
		report_it5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it6=new JMenuItem("Eye Surgery Details",new ImageIcon("icons\\hide.gif"));
		report_it6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it7=new JMenuItem("Admit Patient Details",new ImageIcon("icons\\admit1.gif"));
		report_it7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it8=new JMenuItem("Discharge Patient Details",new ImageIcon("icons\\dischr.gif"));
		report_it8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it9=new JMenuItem("Pending Eye Surgery Details",new ImageIcon("icons\\indicator.gif"));
		report_it9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		report_it12=new JMenuItem("Medical/Fitness Certificate Details",new ImageIcon("icons\\report.gif"));
		report_it12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it13=new JMenuItem("Birth Certificate Details",new ImageIcon("icons\\report.gif"));
		report_it13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it14=new JMenuItem("Hospital Medicine Stock",new ImageIcon("icons\\drug.gif"));
		report_it14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it15=new JMenuItem("Gynec Surgery Details",new ImageIcon("icons\\women.gif"));
		report_it15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it16=new JMenuItem("Pending Gynec Surgery Details",new ImageIcon("icons\\spinner.gif"));
		report_it16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it17=new JMenuItem("Invoice Details",new ImageIcon("icons\\invoice.gif"));
		report_it17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		
		
		Report.addSeparator();
		Report.add(report_it1);
		Report.addSeparator();
		Report.add(report_it4);
	//	Report.addSeparator();
		Report.add(report_it7);
		Report.addSeparator();
		Report.add(report_it8);
		Report.addSeparator();
		Report.addSeparator();
		
		
		Report.add(report_it6);
		//Report.addSeparator();
		Report.add(report_it9);
		Report.addSeparator();
		Report.add(report_it15);
	//	Report.addSeparator();
		Report.add(report_it16);
		Report.addSeparator();
		Report.addSeparator();	
		
		
		Report.add(report_it13);
	//	Report.addSeparator();	
		Report.add(report_it12);
		Report.addSeparator();	
		Report.addSeparator();
		
		
		Report.add(report_it14);
		Report.addSeparator();	
		Report.add(report_it17);
	//	Report.addSeparator();	
		Report.add(report_it5);
		
			
		//////////sunil ji coded////
	/*	Report.add(report_it5);
		Report.addSeparator();	
		Report.add(report_it14);
		Report.addSeparator();	
		Report.add(report_it12);
		Report.addSeparator();	
		Report.add(report_it13);
		Report.addSeparator();	
		Report.add(report_it17);*/
		
		report_it1.addActionListener(this);
		
		report_it4.addActionListener(this);
		report_it5.addActionListener(this);
		report_it6.addActionListener(this);
		report_it7.addActionListener(this);
		report_it8.addActionListener(this);
		report_it9.addActionListener(this);
		
		report_it12.addActionListener(this);
		report_it13.addActionListener(this);
		report_it14.addActionListener(this);
		report_it15.addActionListener(this);
		report_it16.addActionListener(this);
		report_it17.addActionListener(this);
		//-------------------end patient report-------------------------------
		
		//-----------------------Spects Report -------------
		report_spects=new JMenu("Spects Report  ");
		report_spects.setMnemonic('e');
		mb.add(report_spects);
		
		
	//	report_it10=new JMenuItem("Spects Details",'e');
	report_it10=new JMenuItem("Spects Details",new ImageIcon("icons\\report.gif"));
		report_it10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it11=new JMenuItem("Pending Spects Details",new ImageIcon("icons\\pendings.gif"));
		report_it11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it18=new JMenuItem("Spectacle Stock Report",new ImageIcon("icons\\warehouse.gif"));
		report_it18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it19=new JMenuItem("Spectacle Purchase Report:DateWise",new ImageIcon("icons\\edit_old.gif"));
		report_it19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		report_spects.add(report_it10);
	//	report_spects.addSeparator();	
		report_spects.add(report_it11);
		report_spects.addSeparator();	
		report_spects.add(report_it18);
		report_spects.addSeparator();
		report_spects.add(report_it19);
		
		report_it10.addActionListener(this);
		report_it11.addActionListener(this);
		report_it18.addActionListener(this);
		report_it19.addActionListener(this);
		
		//---------------end spects report------------------
		
		//-----------------------Staff Report -------------
		report_staff=new JMenu("Staff Report  ");
		report_staff.setMnemonic('a');
		mb.add(report_staff);
		
		report_it2=new JMenuItem("Staff Details",new ImageIcon("icons\\report.gif"));
		report_it2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		report_it3=new JMenuItem("Staff Edit Log",new ImageIcon("icons\\star.gif"));
		report_it3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		report_staff.add(report_it2);
		report_staff.addSeparator();
		report_staff.add(report_it3);
                report_staff.addSeparator();
		report_staff.add(staffleave);

                staffleave.addActionListener(this);
		report_it2.addActionListener(this);
		report_it3.addActionListener(this);
		
		//---------------end spects report------------------
		
		//------------------Utility Menu--------------------
		Utility=new JMenu("Utility  ");
		Utility.setMnemonic('U');
		mb.add(Utility);
		utility_it1=new JMenuItem("Create New User",new ImageIcon("icons\\spin.gif"));
		utility_it1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		utility_it2=new JMenuItem("Change Password",new ImageIcon("icons\\CreateNew.gif"));
		utility_it2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		utility_it3=new JMenuItem("Sale 2 Tax : Non Admit Patient",new ImageIcon("icons\\invoice.gif"));
		utility_it3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		utility_it4=new JMenuItem("Sale 2 Tax : Admit Patient",new ImageIcon("icons\\rules.gif"));
		utility_it4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		utility_it5=new JMenuItem("Get Backup",new ImageIcon("icons\\backup.gif"));
		utility_it5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		utility_it6=new JMenuItem("Change Password of Doctor",new ImageIcon("icons\\change_passwd.gif"));
		utility_it6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		utility_it7=new JMenuItem("Payment: To Return",new ImageIcon("icons\\return.gif"));
		utility_it7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		utility_it8=new JMenuItem("Payment: To Return Report",new ImageIcon("icons\\report.gif"));
		utility_it8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		
		
		Utility.add(utility_it1);
	//	Utility.addSeparator();
		Utility.add(utility_it2);
		Utility.addSeparator();
		Utility.add(utility_it6);
		Utility.addSeparator();
		Utility.add(utility_it3);
	//	Utility.addSeparator();
		Utility.add(utility_it4);
		Utility.addSeparator();
		Utility.add(utility_it7);
		Utility.add(utility_it8);
		Utility.addSeparator();
		Utility.add(utility_it5);
		
		
		utility_it1.addActionListener(this);
		utility_it2.addActionListener(this);
		utility_it3.addActionListener(this);
		utility_it4.addActionListener(this);
		utility_it5.addActionListener(this);
		utility_it6.addActionListener(this);
		utility_it7.addActionListener(this);
		utility_it8.addActionListener(this);
		//--------------------------------------------------
		
		//--------HELP MENU----------------
		help=new JMenu("    Help");
		help.setMnemonic('h');
		mb.add(help);
		
		help_it1=new JMenuItem("About Us",new ImageIcon("icons\\About.gif"));
		help.add(help_it1);
		help_it1.addActionListener(this);
		//help.addSeparator();
		
		//....CLOSE HELP MENU..........................................
		
		
		mas_it1.addActionListener(this);
		mas_it2.addActionListener(this);
		mas_it3.addActionListener(this);
		mas_it4.addActionListener(this);
		mas_it5.addActionListener(this);
		mas_it6.addActionListener(this);
		mas_it7.addActionListener(this);
		mas_it8.addActionListener(this);
		mas_it9.addActionListener(this);
		mas_it10.addActionListener(this);
		mas_it11.addActionListener(this);
		mas_it12.addActionListener(this);
		mas_it13.addActionListener(this);
		doc_it1.addActionListener(this);
		opd_it1.addActionListener(this);
		opd_it2.addActionListener(this);
		opd_it3.addActionListener(this);
		opd_it4.addActionListener(this);
		opd_it5.addActionListener(this);
		opd_it6.addActionListener(this);
		opd_it7.addActionListener(this);
		opd_it8.addActionListener(this);
		opd_it9.addActionListener(this);
		opd_it10.addActionListener(this);
		opd_it11.addActionListener(this);
		opd_it12.addActionListener(this);
		sur_it1.addActionListener(this);
		sur_it2.addActionListener(this);
		providationOfMenu();
	}
	
	private String selectImage()
		{
			String imageName="";
			String path=null;
			try
			{
			
			File fl1=new File(".");
			path=fl1.getCanonicalPath();
			}
	   		catch(Exception e)
			{
				System.out.println("Error_SKM.."+e);
			}	
	   		File fl=new File(path+"\\wallpapers");	
	   		File file[]=fl.listFiles();
	   		int l=file.length;
	   		while(true)
	   		{
	   			int i=(int)(Math.random()*100);
	   			if(i<l)
	   			{
	   				System.out.println(file[i].getName());	
	   				return file[i].getName();
	   				
	   			}
	   		}
	   		   		
		}
	
	private void providationOfMenu()
    {
    	try
        {
        	if(level==0)//for admin
        	{}
        	else
        	{
        		mas_it1.setEnabled(false);
        		mas_it2.setEnabled(false);
        		mas_it3.setEnabled(false);
        		mas_it4.setEnabled(false);
        		mas_it5.setEnabled(false);
        		mas_it6.setEnabled(false);
        		mas_it7.setEnabled(false);
        		mas_it8.setEnabled(false);
        		mas_it9.setEnabled(false);
        		mas_it10.setEnabled(false);
        		mas_it11.setEnabled(false);
        		mas_it13.setEnabled(false);
        		
        		doc_it1.setEnabled(false);
        		
        		opd_it1.setEnabled(false);
        		opd_it2.setEnabled(false);
        		opd_it3.setEnabled(false);
        		opd_it4.setEnabled(false);
        		opd_it5.setEnabled(false);
        		opd_it6.setEnabled(false);
        		opd_it7.setEnabled(false);
        		opd_it9.setEnabled(false);
        		opd_it10.setEnabled(false);
        		opd_it12.setEnabled(false);
        	//	opd_it11.setEnabled(false);
        		opd_it8.setEnabled(false);
        		opd_it11.setEnabled(false);
        		sur_it1.setEnabled(false);
        		sur_it2.setEnabled(false);
        		
        		pay_it1.setEnabled(false);
        		pay_it2.setEnabled(false);
        		
        		staff_it1.setEnabled(false);
        		staff_it2.setEnabled(false);
        		staff_it3.setEnabled(false);
        		staff_it4.setEnabled(false);
        		staff_it5.setEnabled(false);
        		
        		certi_it1.setEnabled(false);
        		certi_it2.setEnabled(false);
        		
        		report_it1.setEnabled(false);
        		report_it2.setEnabled(false);
        		report_it3.setEnabled(false);
        		report_it4.setEnabled(false);
        		report_it5.setEnabled(false);
        		report_it6.setEnabled(false);
        		report_it7.setEnabled(false);
        		report_it8.setEnabled(false);
        		report_it9.setEnabled(false);
        		report_it10.setEnabled(false);
        		report_it11.setEnabled(false);
        		report_it12.setEnabled(false);
        		report_it13.setEnabled(false);
        		report_it14.setEnabled(false);
        		report_it15.setEnabled(false);
        		report_it16.setEnabled(false);
        		report_it17.setEnabled(false);
        	//	report_it18.setEnabled(false);
        	//	report_it19.setEnabled(false);
        		
        		utility_it1.setEnabled(false);
        		utility_it2.setEnabled(false);
        		utility_it3.setEnabled(false);
        		utility_it4.setEnabled(false);
        		utility_it5.setEnabled(false);
        		utility_it6.setEnabled(false);
        		utility_it7.setEnabled(false);
        		utility_it8.setEnabled(false);
        		
        		btn_newReg.setEnabled(false);
        		btn_drLogin.setEnabled(false);
        		btn_admit.setEnabled(false);
        		btn_surgery.setEnabled(false);
        		btn_spectsEntry.setEnabled(false);
        		btn_receipt.setEnabled(false);
        		btn_discharge.setEnabled(false);
        		btn_newStaff.setEnabled(false);
        		btn_pendingSurgery.setEnabled(false);
        		btn_pendingSpects.setEnabled(false);
        		
        		spectacles_it1.setEnabled(false);
        		spects_it6.setEnabled(false);
        		spects_it7.setEnabled(false);

                        staffleave.setEnabled(false);
        	//	report_spects
        		
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
        	
        	
        	
        	
        	
        	
        	
        		System.out.println("id="+id+"     level="+level);
        		String value=inf.getSingleValue("select providedMenuItem from loginMasterOfHPS where uId='"+id+"'");
        		System.out.println("value="+value);
        		String selectedMnuItm[]=null;
        		if(value!=null)
        			selectedMnuItm=value.split(",");
        		System.out.println("len="+selectedMnuItm.length);
        		if(selectedMnuItm!=null)
        		{
        			String str=mas_it1.getText();
        			System.out.println("1.."+str);
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it1.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it2.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it2.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it3.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it3.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it4.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it4.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it5.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it5.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it6.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it6.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it7.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it7.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it8.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it8.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it9.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it9.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it10.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it10.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it11.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it11.setEnabled(true);
        					break;
        				}
        			}
        			str=mas_it13.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					mas_it13.setEnabled(true);
        					break;
        				}
        			}
        			str=doc_it1.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					doc_it1.setEnabled(true);
        					btn_drLogin.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it1.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it1.setEnabled(true);
        					btn_newReg.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it2.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it2.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it3.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it3.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it4.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it4.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it5.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it5.setEnabled(true);
        					btn_admit.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it6.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it6.setEnabled(true);
        					btn_receipt.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it7.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it7.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it8.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it8.setEnabled(true);
        					btn_discharge.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it9.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it9.setEnabled(true);
        					btn_spectsEntry.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it10.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it10.setEnabled(true);
        					break;
        				}
        			}
        			str=opd_it11.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it11.setEnabled(true);
        					break;
        				}
        			}
         			str=opd_it12.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					opd_it12.setEnabled(true);
        					break;
        				}
        			}
        			str=sur_it2.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					sur_it2.setEnabled(true);
        					btn_surgery.setEnabled(true);
        					break;
        				}
        			}
        			str=sur_it1.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					sur_it1.setEnabled(true);
        				//	btn_surgery.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=pay_it1.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					pay_it1.setEnabled(true);
        					break;
        				}
        			}
        			str=pay_it2.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					pay_it2.setEnabled(true);
        					break;
        				}
        			}
        			str=staff_it1.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					staff_it1.setEnabled(true);
        					btn_newStaff.setEnabled(true);
        					break;
        				}
        			}
        			str=staff_it2.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					staff_it2.setEnabled(true);
        					break;
        				}
        			}
        			str=staff_it3.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					staff_it3.setEnabled(true);
        					break;
        				}
        			}
        			str=staff_it4.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					staff_it4.setEnabled(true);
        					break;
        				}
        			}
        			str=staff_it5.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					staff_it5.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it1.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it1.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it2.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it2.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it3.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it3.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it4.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it4.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it5.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it5.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it6.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it6.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it7.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it7.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it8.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it8.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it9.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it9.setEnabled(true);
        					btn_pendingSurgery.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it10.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it10.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it11.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it11.setEnabled(true);
        					btn_pendingSpects.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it12.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it12.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it13.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it13.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it14.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it14.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it15.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it15.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it16.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it16.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it17.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it17.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it18.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it18.setEnabled(true);
        					break;
        				}
        			}
        			str=report_it19.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					report_it19.setEnabled(true);
        					break;
        				}
        			}
        			str=certi_it1.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					certi_it1.setEnabled(true);
        					break;
        				}
        			}
        			str=certi_it2.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					certi_it2.setEnabled(true);
        					break;
        				}
        			}
        			str=utility_it1.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					utility_it1.setEnabled(true);
        					break;
        				}
        			}
        			str=utility_it2.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					utility_it2.setEnabled(true);
        					break;
        				}
        			}	
        			str=utility_it3.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					utility_it3.setEnabled(true);
        					break;
        				}
        			}	
        			str=utility_it4.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					utility_it4.setEnabled(true);
        					break;
        				}
        			}
        			str=utility_it5.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					utility_it5.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=spectacles_it1.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					spectacles_it1.setEnabled(true);
        					break;
        				}
        			}
        			str=spects_it1.getText()	;
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					spects_it1.setEnabled(true);
        					break;
        				}
        			}
        			str=spects_it2.getText()	;
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					spects_it2.setEnabled(true);
        					break;
        				}
        			}
        			str=spects_it3.getText()	;
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					spects_it3.setEnabled(true);
        					break;
        				}
        			}
        			str=spects_it4.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					spects_it4.setEnabled(true);
        					break;
        				}
        			}
        			str=spects_it5.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					spects_it5.setEnabled(true);
        					break;
        				}
        			}
        			str=spects_it6.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					spects_it6.setEnabled(true);
        					break;
        				}
        			}
        			str=spects_it7.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					spects_it7.setEnabled(true);
        					break;
        				}
        			}
        			str=utility_it6.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					utility_it6.setEnabled(true);
        					break;
        				}
        			}
        			
        			str=utility_it7.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					utility_it7.setEnabled(true);
        					break;
        				}
        			}
        			str=utility_it8.getText();
        			for(int i=0;i<selectedMnuItm.length;i++)
        			{
        				if(selectedMnuItm[i].equalsIgnoreCase(str))
        				{
        					utility_it8.setEnabled(true);
        					break;
        				}
        			}
        			
        		}
        	}
        }
        catch(Exception e)
        {
        	System.out.println("Error...SKM R....."+e);
        }
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==mas_it1)		
		{
			AddDoctorCategory addnew=new AddDoctorCategory(dp);
		}
		else if(ae.getSource()==mas_it2)		
		{
			//AddDoctorCategory addnew=new AddDoctorCategory(dp);
		}
		else if(ae.getSource()==mas_it3)		
		{
			AddWard addnew1=new AddWard(dp);
		}
		else if(ae.getSource()==mas_it4)		
		{
			AddRoom addnew2=new AddRoom(dp);
		}
		else if(ae.getSource()==mas_it5)		
		{
			AddBed addnew3=new AddBed(dp);
		}
		else if(ae.getSource()==mas_it6)		
		{
			EditDoctorCategory addnew333=new EditDoctorCategory(dp);
		}
		else if(ae.getSource()==mas_it7)		
		{
			EditWard addnew=new EditWard(dp);
		}
		else if(ae.getSource()==mas_it8)		
		{
			EditRoom addnew=new EditRoom(dp);
		}
		else if(ae.getSource()==mas_it9)		
		{
			EditBed addnew=new EditBed(dp);
		}
		else if(ae.getSource()==mas_it10)		
		{
			DeleteRoom dr=new DeleteRoom(dp);
		}
		else if(ae.getSource()==mas_it11)		
		{
			DeleteBed dr=new DeleteBed(dp);
		}
		else if(ae.getSource()==mas_it12)
		{
			System.exit(0);
		}
		else if(ae.getSource()==mas_it13)
		{
			new StatusOfBed(dp);
		}
		else if(ae.getSource()==doc_it1 || ae.getSource()==btn_drLogin)		
		{
			LoginDoctorForPatient drL=new LoginDoctorForPatient(dp);
		}
		else if(ae.getSource()==opd_it1 || ae.getSource()==btn_newReg)		
		{
			String Hold_dt=null;
			addnewpatient addnew=new addnewpatient(dp,Hold_dt);
		}
		else if(ae.getSource()==opd_it2)		
		{
			editprevious edit=new editprevious(dp);
		}
		else if(ae.getSource()==opd_it3)		
		{
			patientExist Exist=new patientExist(dp);
		}
		else if(ae.getSource()==opd_it4)		
		{
			int sendid=0;
					
			int FLAG=3;
			
			String Hold_dt1=null;
			
			FeeDetails fee=new FeeDetails(dp,sendid,FLAG,Hold_dt1);
		}
		else if(ae.getSource()==opd_it5 || ae.getSource()==btn_admit)		
		{
			RoomAllotement rmallot=new RoomAllotement(dp);
		}
		else if(ae.getSource()==opd_it6 || ae.getSource()==btn_receipt)		
		{
			DischargeSlip DS=new DischargeSlip(dp);
		}
		else if(ae.getSource()==opd_it7)		
		{
			MakingSaleByHPS DS=new MakingSaleByHPS(dp);
		}
		else if(ae.getSource()==opd_it8 || ae.getSource()==btn_discharge)
		{
			
			String obj=JOptionPane.showInputDialog(this,"Enter ID","Discharge Card",JOptionPane.INFORMATION_MESSAGE);
			if(obj!=null)
			{
				//System.out.println("obj "+obj);
				try
				{
					int ID=Integer.parseInt(obj);
				//	ZedInterface obj1=null;
       			//	obj1=(ZedInterface)Naming.lookup(getIPaddress.IP());
       			
       			
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
       			
       			
       			
       			
       			
       			
       				int drCategoryCode=-1;
       				String dcode=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+ID);
       				drCategoryCode=Integer.parseInt(dcode);
       				if(drCategoryCode==1)
       				{
       					DischargeCard DC=new DischargeCard(ID);
						DC.setBounds(50,50,752,684);
						dp.add(DC);
						DC.setVisible(true);
       					/*SurgeryOfEyeForm SE=new SurgeryOfEyeForm(ID);
						SE.setBounds(30,50,929,653);
						dp.add(SE);
						SE.setVisible(true);*/
       				}
       				else
       				{
       					DischargeCardOfGianec frm=new DischargeCardOfGianec(ID);
        				frm.setBounds(20,40,752,632);
        				dp.add(frm);
        				frm.setVisible(true);
       					/*SurgeryForm SE=new SurgeryForm(ID);
       					SE.setBounds(30,50,741,449);
						dp.add(SE);
						SE.setVisible(true);*/
       				}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Please Input Correct ID");
				}
			}
		
			
			
			
			
			/*DischargeCard DC=new DischargeCard();
			DC.setBounds(50,50,752,684);
			dp.add(DC);
			DC.setVisible(true);*/
		}
		else if(ae.getSource()==opd_it9 || ae.getSource()==btn_spectsEntry)
		{
			ProvideSpectsToPatient frm=new ProvideSpectsToPatient(dp);
		}
		else if(ae.getSource()==spectacles_it1 || ae.getSource()==btn_spectsEntry)
		{
			EditProvideSpectsToPatient frm=new EditProvideSpectsToPatient(dp);
		}
		else if(ae.getSource()==opd_it10)
		{
			GivenSpectsToPatientWithPay frm=new GivenSpectsToPatientWithPay();
			frm.setBounds(50,100,340,196);
			dp.add(frm);
			frm.show();
		}
		else if(ae.getSource()==certi_it1)
		{
			Medical_Fitness_Certificate MC=new Medical_Fitness_Certificate();
			MC.setBounds(50,50,412,463);
			dp.add(MC);
			MC.setVisible(true);
		}
	
		
		else if(ae.getSource()==report_it1)
		{
			SearchPatient SP=new SearchPatient(dp);
		}
		else if(ae.getSource()==report_it2)
		{
			new StaffDetails(dp);
		}
                else if(ae.getSource()==staffleave)
                {
                    StaffLeaveReport ob=new StaffLeaveReport();
                    ob.setBounds(30, 10, 840, 592);
                    dp.add(ob);
                    ob.setVisible(true);
                }
		else if(ae.getSource()==report_it4)
		{
			new PatientDetails(dp);
		}
		else if(ae.getSource()==report_it3)
		{
			new StaffDetailsById(dp);
		}
		else if(ae.getSource()==report_it5)
		{
			new CashDetails(dp);
		}
		else if(ae.getSource()==report_it6)
		{
			new SurgeryDetails(dp);
		}
		else if(ae.getSource()==report_it7)
		{
			new AdmitPatientDetails(dp);
		}
		else if(ae.getSource()==report_it8)
		{
			new DischargePatientDetails(dp);
		}
		else if(ae.getSource()==report_it9 || ae.getSource()==btn_pendingSurgery)
		{
			new PendingSurgeryDetails(dp);
		}
		else if(ae.getSource()==report_it10)
		{
			//new SpectDetails(dp);
			new newSpectaclesDetail(dp);
			
		}
		else if(ae.getSource()==report_it11 || ae.getSource()==btn_pendingSpects)
		{
		//	new PendingSpects(dp);
			new newPendingSpects(dp);
			
		}
		else if(ae.getSource()==report_it14)
		{
			new StockReportOfHPS(dp);
		}
		else if(ae.getSource()==report_it15)
		{
			////gynec Surgery
			new GynecSurgeryDetail(dp);
		}
		else if(ae.getSource()==report_it16)
		{
			///pending gynec Surgery
			new PendingGynecSurgeryDetail(dp);
		}
		else if(ae.getSource()==report_it17)
		{
			/////invoice detail
			new InvoiceDetail(dp);
		}
		else if(ae.getSource()==pay_it1)
			{
				//System.out.println("1");
				ReceivePayment SE=new ReceivePayment();
				SE.setBounds(30,50,370,256);
				dp.add(SE);
				SE.setVisible(true);
				//System.out.println("2");
			}
			else if(ae.getSource()==pay_it2)
			{
				//ystem.out.println("1");
				OtherPayOfPatient SE1=new OtherPayOfPatient();
				SE1.setBounds(30,50,436,218);
				dp.add(SE1);
				SE1.setVisible(true);
				//System.out.println("2");
			}
		else if(ae.getSource()==sur_it2 || ae.getSource()==btn_surgery)
		{
			String obj=JOptionPane.showInputDialog(this,"Enter ID","Registration For Eye Surgery",JOptionPane.INFORMATION_MESSAGE);
			if(obj!=null)
			{
				//System.out.println("obj "+obj);
				try
				{
					int ID=Integer.parseInt(obj);
				//	ZedInterface obj1=null;
       			//	obj1=(ZedInterface)Naming.lookup(getIPaddress.IP());
       			
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
       			
       			
       			
       			
       			
       			
       				int drCategoryCode=-1;
       				String dcode=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+ID);
       				drCategoryCode=Integer.parseInt(dcode);
       				if(drCategoryCode==1)
       				{
       					SurgeryOfEyeForm SE=new SurgeryOfEyeForm(ID);
						SE.setBounds(30,50,929,653);
						dp.add(SE);
						SE.setVisible(true);
       				}
       				else
       				{
       					SurgeryForm SE=new SurgeryForm(ID);
       					SE.setBounds(30,50,741,449);
						dp.add(SE);
						SE.setVisible(true);
       				}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Please Input Correct ID");
				}
			}
		
		}
		else if(ae.getSource()==staff_it3)
		{
			int InCorrectid=0;
			String obj=JOptionPane.showInputDialog(this,"Enter ID","Staff Login",JOptionPane.INFORMATION_MESSAGE);
			if(obj!=null)
			{
				try
				{
					int ID=Integer.parseInt(obj);
					//ZedInterface obj1=null;
					//obj1=(ZedInterface)Naming.lookup(getIPaddress.IP());
					
					
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
					
					
					
					
					
					
       				String qry="Select s_Code from staff_Details";
       				String loadID[]=inf.getResultSetAs_1D_Array(qry);
       				if(loadID!=null)
       				{
       					for(int k=0;k<loadID.length;k++)
       					{
       						if(ID==(Integer.parseInt(loadID[k])))
       						{
       						//	
       							staffLogin staffEntry=new staffLogin(dp,ID);
       							System.out.println("Correct ID");
       							InCorrectid=0;
       							break;
       						}
       						else
       						{
       							InCorrectid=1;
       							
       						}
       					
       					}
       					if(InCorrectid==1)
       					{
       						System.out.println("Incorrect ID");
       						
       						
       					JOptionPane.showMessageDialog(null,"Incorrect ID");		
       					}
       				}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Please Input Correct ID");	
				}
				
			
			
			}
			
		
		}
		else if(ae.getSource()==staff_it4)
		{
			String obj=JOptionPane.showInputDialog(this,"Enter ID","Staff Leave",JOptionPane.INFORMATION_MESSAGE);
			if(obj!=null)
			{
				try
				{
					int ID=Integer.parseInt(obj);
				staffLeave staffLve=new staffLeave(dp,ID);	
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Please Input Correct ID");	
				}
				
				
			}
		}
		else if(ae.getSource()==staff_it5)
		{
			staffSalary Staff=new staffSalary(dp);
		}
		else if(ae.getSource()==staff_it1 || ae.getSource()==btn_newStaff)
		{
			StaffRegistration f=new StaffRegistration(dp);
		}
		else if(ae.getSource()==staff_it2)
		{
			StaffEdit aaa=new StaffEdit(dp);
		}
		else if(ae.getSource()==utility_it1)
		{
			CreateNewUserForHPS u=new CreateNewUserForHPS();
			u.setBounds(20,80,852,464);
			dp.add(u);
			u.show();
		}
		else if(ae.getSource()==utility_it2)
		{
			ChangePasswordOfHPS cp=new ChangePasswordOfHPS(dp);
		}
		else if(ae.getSource()==utility_it6)
		{
			ChangePasswordOfDoctors cp=new ChangePasswordOfDoctors(dp);
		}
		else if(ae.getSource()==utility_it3)
		{
			Choose_Tax_Sale_Invoice1 INVOICE1=new Choose_Tax_Sale_Invoice1();
			INVOICE1.setBounds(50,100,720,430);
			dp.add(INVOICE1);
			INVOICE1.show();
		}
		else if(ae.getSource()==utility_it4)
		{
			Choose_Tax_Sale_Invoice2 INVOICE2=new Choose_Tax_Sale_Invoice2();
			INVOICE2.setBounds(50,100,720,430);
			dp.add(INVOICE2);
			INVOICE2.show();
		}
		else if(ae.getSource()==utility_it5)
		{
			BackupScreenOfHPS bk=new BackupScreenOfHPS(dp);
		}
		else if(ae.getSource()==utility_it7)
		{
			new paymentToReturnScreen(dp);
		}
		else if(ae.getSource()==utility_it8)
		{
			new paymentToReturnReport(dp);
		}
		else if(ae.getSource()==certi_it2)
		{
			BirthCertificate frm=new BirthCertificate(dp);
			frm.setBounds(100,100,412,492);
			dp.add(frm);
			frm.show();
		}
		else if(ae.getSource()==report_it12)
		{
			Medical_Fitness_Certificate_Report f=new Medical_Fitness_Certificate_Report(dp);
		}
		else if(ae.getSource()==report_it13)
		{
			BirthCertificateReport f1=new BirthCertificateReport(dp);
		}
		else if(ae.getSource()==help_it1)
		{
			new AboutUsHPS(dp);
		}
		else if(ae.getSource()==opd_it11)		
		{
			String obj=JOptionPane.showInputDialog(this,"Enter ID","Edit Patient Fee Detail",JOptionPane.INFORMATION_MESSAGE);
			if(obj!=null)
			{
				try
				{
					int ID=Integer.parseInt(obj);
					//	int sendid=0;
					//	int FLAG=3;
						EditFeeDetail fee=new EditFeeDetail(dp,ID);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"Please Input Correct ID");	
				}
				
				
			}
		
		}
		else if(ae.getSource()==spects_it1)
		{
			new CmpMasterOfSpects(dp);
		}
		else if(ae.getSource()==spects_it2)
		{
			System.out.println("Entered..............123");
		//	new OpeningStockOfSpects(dp);
		OpeningStockOfSpects frm=new OpeningStockOfSpects();
        frm.setBounds(50,100,385,285);
        dp.add(frm);
        frm.show();
		}
		else if(ae.getSource()==spects_it3)
		{
			System.out.println("entered...................1234");
		//	new MakingPurchaseOfSpects(dp);
		MakingPurchaseOfSpects frm=new MakingPurchaseOfSpects();
			frm.setBounds(50,100,740,472);
        	dp.add(frm);
        	frm.show();
		}
		else if(ae.getSource()==report_it18)
		{
			new spectsStockReport(dp);
		}
		else if(ae.getSource()==report_it19)
		{
			new PurchaseDateWiseReportOfSpects(dp);
		}
		else if(ae.getSource()==spects_it4)
		{
		System.out.println("entering");
			new EditPurchaseOfSpects(dp);
		}
		else if(ae.getSource()==opd_it12)
		{
				System.out.println("Correct");
		editYAGMaster Edit_YAG=new editYAGMaster();
		Edit_YAG.setBounds(300,300,500,200);
		dp.add(Edit_YAG);
		Edit_YAG.show();
		}
		else if(ae.getSource()==spects_it5)
		{
			new ProvideSpectsToCustomer(dp);
		}
		else if(ae.getSource()==spects_it6)
		{
			new EditProvideSpectsToCustomer(dp);
		}
		else if(ae.getSource()==spects_it7)
		{
			GivenSpectsToCustomerWithPay frm=new GivenSpectsToCustomerWithPay();
			frm.setBounds(50,100,340,196);
			dp.add(frm);
			frm.show();
			
			
		}
		else if(ae.getSource()==sur_it1)
		{
			String obj=JOptionPane.showInputDialog(this,"Please Enter Patient ID","Edit Surgery",JOptionPane.INFORMATION_MESSAGE);
			if(obj!=null)
			{
				//System.out.println("obj "+obj);
				try
				{
					int ID=Integer.parseInt(obj);
					//ZedInterface obj1=null;
       				//obj1=(ZedInterface)Naming.lookup(getIPaddress.IP());
       				
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
       				
       				
       				
       				
       				
       				
       				int drCategoryCode=-1;
       				String dcode=inf.getSingleValue("select drCatCode from patient_Profile where patientid="+ID);
       				drCategoryCode=Integer.parseInt(dcode);
       				if(drCategoryCode==1)
       				{
       					String qry="Select Patient_Id from eye_Surgery_Detail where Patient_Id="+ID+" and status="+false+" order by date desc";
       					String getResult=inf.getSingleValue(qry);
       					if(getResult!=null)
       					{
       						EditSurgeryOfEyeForm SE=new EditSurgeryOfEyeForm(ID);
							SE.setBounds(30,50,929,653);
							dp.add(SE);
							SE.setVisible(true);
       					}
       					else
       					{
       						JOptionPane.showMessageDialog(this,"Surgery Detail Is Not Available","Message",JOptionPane.INFORMATION_MESSAGE);
       					}
       					
       				}
       				//////////////for gynec///////
       				else
       				{
       					String qry="Select Patient_Id from gianec_Surgery_Detail where Patient_Id="+ID+" and status="+false+" order by date desc";
       					String getResult=inf.getSingleValue(qry);
       					if(getResult!=null)
       					{
       						EditSurgeryForm SE=new EditSurgeryForm(ID);
       						SE.setBounds(30,50,741,449);
							dp.add(SE);
							SE.setVisible(true);
						}
						else
       					{
       						JOptionPane.showMessageDialog(this,"Surgery Detail Is Not Available","Message",JOptionPane.INFORMATION_MESSAGE);
       					}
       				}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"Please Input Correct ID");
				}
			}
		}
		
	}
	
	class Timer extends Thread implements Runnable
	 {
	 	public Timer()
	 	{
	 		System.out.println("I am in thread....SKM_R........");
	 		new Thread(this).start();
	 	}

	 	public void run() 
	 	{
		
      			try 
      			{
      				while(true)
      				{	
      					Thread.sleep(1000);
      			
      					Date date1=new Date();
      			
	      				GregorianCalendar calendar = new GregorianCalendar();
      					
      					String hour=""+calendar.get(Calendar.HOUR_OF_DAY);
      					if(hour.length()==1)
      					{
      						hour="0"+hour;
      					}
	      				String minute=""+calendar.get(Calendar.MINUTE);
	      				if(minute.length()==1)
	      				{
	      					minute="0"+minute;
	      				}
		      			String second=""+calendar.get(Calendar.SECOND);
		      			if(second.length()==1)
		      			{
		      				second="0"+second;
		      			}
      					String time="";
      					
      					String date=""+(date1.getDate()+1);
      					if(date.length()==1)
      					{
      						date="0"+date;
      					}
      					String mon=""+(date1.getMonth()+1);
      					if(mon.length()==1)
      					{
      						mon="0"+mon;
      					}
      					String year=""+(date1.getYear()+1900);
      				
	      				time=date+"-"+mon+"-"+year+"  "+hour+":"+minute+":"+second;
      					lbl_DateAndTime.setText(""+time);
      				
				}
      			}
      			catch(InterruptedException ex)
      			{
      				System.out.print(ex); 
      			}
	      	 }
    	  }

}