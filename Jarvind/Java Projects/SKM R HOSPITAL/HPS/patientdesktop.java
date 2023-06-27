import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class patientdesktop extends JFrame implements ActionListener
{
	JDesktopPane dp;
	JMenuBar  mb=new JMenuBar();
	JMenu Itemmenu=new JMenu("About Patient");
	JMenu Itemmenu1=new JMenu("About Fee");
	JMenu Itemmenu2=new JMenu("Login");
	JMenu Itemmenu3=new JMenu("ADMIT");
	
	
	
	JMenuItem addpatient=new JMenuItem("ADD NEW");
	JMenuItem editpatient=new JMenuItem("EDIT");
	JMenuItem existingPatient=new JMenuItem("EXISTING PATIENT");
	JMenuItem feedetail=new JMenuItem("Fee Detail");
	JMenuItem loginDoc=new JMenuItem("Doctor Login");
	JMenuItem Prescription=new JMenuItem("Prescription");
	JMenuItem roomallotement=new JMenuItem("Room Allotement");
	JMenuItem discharge=new JMenuItem("Discharge Slip");
	
	public static void main(String arg[])
	{
		patientdesktop patientdkt=new patientdesktop();
		patientdkt.setSize(1000,800);
		patientdkt.setVisible(true);
	}
	public patientdesktop()
	{
		dp=new JDesktopPane();
		setContentPane(dp);
		dp.setLayout(null);
		mb.setBounds(0,0,1000,30);
		dp.add(mb);
		
		mb.add(Itemmenu);
		mb.add(Itemmenu1);
		mb.add(Itemmenu2);
		mb.add(Itemmenu3);
		
		
		Itemmenu.add(addpatient);
		Itemmenu.add(editpatient);
		Itemmenu.add(existingPatient);
		Itemmenu1.add(feedetail);
		Itemmenu2.add(loginDoc);
		Itemmenu2.add(Prescription);
		Itemmenu3.add(roomallotement);
		Itemmenu3.add(discharge);
		
		addpatient.addActionListener(this);
		editpatient.addActionListener(this);
		existingPatient.addActionListener(this);
		feedetail.addActionListener(this);
		loginDoc.addActionListener(this);
		Prescription.addActionListener(this);
		roomallotement.addActionListener(this);
		discharge.addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==addpatient)		
		{
			addnewpatient addnew=new addnewpatient(dp);
		}
		if(ae.getSource()==editpatient)
		{
			editprevious edit=new editprevious(dp);
			
		}
		if(ae.getSource()==existingPatient)
		{
			patientExist Exist=new patientExist(dp);
		}
		if(ae.getSource()==feedetail)
		{
			int sendid=0;
					
			int FLAG=2;
			
			FeeDetails fee=new FeeDetails(dp,sendid,FLAG);
		}
		if(ae.getSource()==loginDoc)
		{
			LoginDoctorForPatient loginDCT=new LoginDoctorForPatient(dp);
		}
		if(ae.getSource()==Prescription)
		{
			String hold=null;
			
				PatientPrescription frm=new PatientPrescription(dp,15,hold);
		}
		if(ae.getSource()==roomallotement)
		{
			RoomAllotement rmallot=new RoomAllotement(dp);
		}
		if(ae.getSource()==discharge)
		{
			DischargeSlip DS=new DischargeSlip(dp);
		}
	} 
}


