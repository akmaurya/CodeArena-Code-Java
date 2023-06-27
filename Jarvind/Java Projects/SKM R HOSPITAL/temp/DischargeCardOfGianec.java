/*
 * DischargeCard.java
 *
 * Created on May 26, 2011, 5:06 PM
 */

//package skm;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.*;
import java.sql.*;
import java.rmi.*;
import java.rmi.registry.*;
import javax.print.PrintService;
import java.awt.print.*;
import javax.print.attribute.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
/**
 *
 * @author  Administrator
 */
public class DischargeCardOfGianec extends javax.swing.JInternalFrame {
    
    /** Creates new form DischargeCard */
    public DischargeCardOfGianec(int ID) {
    	//System.out.println("01......");
        initComponents();
        //System.out.println("1......");
        jButton1.setVisible(false);
        patientID=ID;
        jTextField1.setText(""+patientID);
        jButton4.setEnabled(false);
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField3.setEditable(false);
        jTextArea1.setEditable(false);
        dtm=new DefaultTableModel(new String[]{"S.No.","Medicine Name","Dosage","Duration","Days","Remarks"},0);
        jTable1.setModel(dtm);
        javax.swing.table.DefaultTableCellRenderer CRLeft = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRRight = new javax.swing.table.DefaultTableCellRenderer();
       		javax.swing.table.DefaultTableCellRenderer CRCenter = new javax.swing.table.DefaultTableCellRenderer();
      		CRLeft.setHorizontalAlignment(javax.swing.JLabel.LEFT);
	       	CRRight.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
       		CRCenter.setHorizontalAlignment(javax.swing.JLabel.CENTER);
      		javax.swing.table.TableColumn column;

      		column=jTable1.getColumn("S.No.");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(20);
                column=jTable1.getColumn("Medicine Name");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(135);
                column=jTable1.getColumn("Dosage");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(135);
                column=jTable1.getColumn("Duration");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(100);
                column=jTable1.getColumn("Days");
      		column.setCellRenderer(CRCenter);
       		column.setPreferredWidth(35);
                column=jTable1.getColumn("Remarks");
      		column.setCellRenderer(CRLeft);
       		column.setPreferredWidth(100);
                java.util.Date dt=new java.util.Date();
                String curDt=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
                jLabel4.setText(curDt);
                jLabel19.setText(curDt);
                jLabel39.setText(curDt);
                setDefaultValueFun();
                System.out.println("11......");
                CheckValidation();
             //   LoadInitialInfo();
                System.out.println("12......");
                
    }
    private void LoadInitialInfo()
  {
  	int pid=patientID;
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
  	
  	
  	
  	
  	
  	
  	
  		////Name,Address,Gender&Age
  		String qry="Select name,age,gender,address from patient_Profile where patientid="+pid+"";
  		System.out.println("qry "+qry);
  		String loadINFO[][]=inf.getResultSetAs_2D_Array(qry,4);
  		if(loadINFO!=null)
  		{
  			for(int i=0;i<loadINFO.length;i++)
  			{
  				int c=0;
  				jTextField2.setText(loadINFO[i][c]);
  				jTextField3.setText(loadINFO[i][++c]+" / "+loadINFO[i][++c]);
  				jTextArea1.setText(loadINFO[i][++c]);
  			}
  		}
  		//BP,Sugar
  		qry="select blood_pr,sugar from history_patient where patient_id="+patientID+" order by history_date desc";
  		loadINFO=inf.getResultSetAs_2D_Array(qry,2);
  		if(loadINFO!=null)
  		{
  			{
  				int i=0,c=0;
  				
  				jTextField4.setText(loadINFO[i][c]);
  				jTextField5.setText(loadINFO[i][++c]);
  				
  			}
  		}
  		//---surgery,surgery date
  		qry="select surgery,Operation_Date from gianec_Surgery_Detail where Patient_Id="+patientID+" order by date desc";
  		loadINFO=inf.getResultSetAs_2D_Array(qry,2);
  		if(loadINFO!=null)
  		{
  			jTextField7.setText(loadINFO[0][0]);
  			String tmp[]=loadINFO[0][1].split("-");
    			String dt[]=tmp[2].split(" ");
    			String givendt=dt[0]+"/"+tmp[1]+"/"+tmp[0];
    			jLabel19.setText(givendt);
  		}
  		//admit date----
  		qry="select bookingdt from admit_Patient_Info where id="+patientID+" order by bookingdt desc";
  		String temp=inf.getSingleValue(qry);
  		if(temp!=null)
  		{
  			String tmp[]=temp.split("-");
    			String dt[]=tmp[2].split(" ");
    			String givendt=dt[0]+"/"+tmp[1]+"/"+tmp[0];
    			jLabel39.setText(givendt);
  		}
  		//surgeon name-------
  		qry="select drcode from patient_Profile where patientid="+patientID+"";
  		temp=inf.getSingleValue(qry);
  		if(temp!=null)
  		{
  			qry="select drName from drDetail where drCode="+Integer.parseInt(temp)+"";
  			temp=inf.getSingleValue(qry);
  			if(temp!=null)
  			{
  				jTextField8.setText(temp);
  			}
  		}
  	}
  	catch(Exception e)
  	{
  		System.out.println("Error...SKM_R....."+e);
  	}
  }
  private void checkDischargeEntry()
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
  		String qry="Select status from gianec_Surgery_Detail where Patient_Id="+Integer.parseInt(jTextField1.getText())+"";
  		System.out.println("qry "+qry);
  		String getgianecStatus=inf.getSingleValue(qry);
  		System.out.println("getgianecStatus "+getgianecStatus);
  		
  		
  		String bedstatus="-1",rmNO="",getadmitstatus="",qry2="";
  		if(admitFlag==1)
  		{
  			qry2="Select bedNo,rate from admit_Patient_Info where id="+Integer.parseInt(jTextField1.getText())+" And status="+false+"";
  			System.out.println("qry2 "+qry2);
  			String loadbedno[][]=inf.getResultSetAs_2D_Array(qry2,2);
  			if(loadbedno!=null)
  			{
  				for(int j=0;j<loadbedno.length;j++)
  				{
  					int c=0;
  					System.out.println(loadbedno[j][c]);
  					System.out.println(loadbedno[j][++c]);
  				}
  			}
  		
  			qry2="Select roomNo from bedDetails where bedNo="+Integer.parseInt(loadbedno[0][0])+" And bedStatus="+false+"";
  			System.out.println("qry2 "+qry2);
  			rmNO=inf.getSingleValue(qry2);
  			System.out.println("rmNO "+rmNO);
  			
  			if(rmNO!=null)
  			{
  				qry2="Select bedStatus from bedDetails where bedNo="+Integer.parseInt(loadbedno[0][0])+" And roomNo="+Integer.parseInt(rmNO)+"";
  				System.out.println("qry2 "+qry2);
  				bedstatus=inf.getSingleValue(qry2);
  				System.out.println("bedstatus "+bedstatus);
  			}
  			
  			qry="Select status admit_Patient_Info where id="+Integer.parseInt(jTextField1.getText())+"";
			getadmitstatus=inf.getSingleValue(qry);
  			System.out.println("getadmitstatus "+getadmitstatus);
  		
  		}
  		
  		
  		
  		
  		String query="Select status from other_Payment_Detail where patient_id="+Integer.parseInt(jTextField1.getText())+" And status="+false+"";
  		System.out.println("query "+query);
  		String getPaystatus[]=inf.getResultSetAs_1D_Array(query);
  		//System.out.println("getPaystatus "+getPaystatus);
  		if(getPaystatus!=null)
  		{
  			for(int j=0;j<getPaystatus.length;j++)
  			{
  				System.out.println(j+" "+getPaystatus[j]);
  			}
  		}
  		else
  		{
  			System.out.println("not loaded");
  		}
  		
  	
  		/*	String qry1="Select status from gianec_Surgery_Detail where Patient_Id="+Integer.parseInt(jTextField1.getText())+"";
  			System.out.println("qry1 "+qry1);
  			String getgianecStatus=inf.getSingleValue(qry1);
  			System.out.println("getgianecStatus "+getgianecStatus);*/
  	
  		
  		
  		
  		qry2="Select status from saleSmry_ByHPS where patientID="+Integer.parseInt(jTextField1.getText())+"";
  		System.out.println("qry2 "+qry2);
  		String getMStatus=inf.getSingleValue(qry2);
  		System.out.println("getMStatus "+getMStatus);
  		
  		
  		
  		
  	/*	String getdt=jLabel29.getText();
  		String DT[]=getdt.split(" ");
  			
  		System.out.println("DT[0] "+DT[0]);
  			
  		String dt1[]=DT[0].split("/");
  			
  		String setDt=dt1[1]+"/"+dt1[0]+"/"+dt1[2];
  		System.out.println("setDt "+setDt);*/
  			
  	/*	System.out.println("Checked Status");
  		qry="Select MAX(srNo) from patient_DischargeSmry_Gianec";
  		System.out.println("qry "+qry);
  		int getmax=inf.getMaxValue(qry);
  		System.out.println("getmax "+getmax);*/
  		
  		
  	//	System.out.println("geteyeStatus "+geteyeStatus);
  		System.out.println("bedstatus "+bedstatus);
  	//	System.out.println("getPaystatus "+getPaystatus);
  		System.out.println("getMStatus "+getMStatus);
  		System.out.println("getgianecStatus "+getgianecStatus);
  		
  				
  		////////////////original code//////////////
  		
  		if(bedstatus.equals("-1"))
  		{
  			System.out.println("entering ");
  		}
  		
  		
  	/*	if(geteyeStatus!=null)
  		{
  			if(Integer.parseInt(bedstatus)==0)
  			{
  				qry="insert into patient_DischargeSmry values("+(++getmax)+","+Integer.parseInt(jTextField1.getText())+",#"+setDt+"#,'"+jComboBox3.getSelectedItem()+"','"+jComboBox4.getSelectedItem()+"','"+jComboBox7.getSelectedItem()+"','"+jComboBox8.getSelectedItem()+"','"+jTextField10.getText().trim()+"','"+jTextField11.getText().trim()+"','"+jComboBox9.getSelectedItem()+"','"+jComboBox10.getSelectedItem()+"')";
  				System.out.println("qry "+qry);
  				boolean successful=inf.executeUpdateQuery(qry);
  				System.out.println("successful "+successful);
  			
  			
  				if(dtm.getRowCount()!=0)
  				{
  					int getrw=dtm.getRowCount();
  					System.out.println("getrw "+getrw);
  					System.out.println("getmax "+getmax);
  					for(int j=0;j<getrw;j++)
  					{
  						int c=0;
  						qry="insert into patient_DischargeDtl values("+getmax+",'"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"')";
  						System.out.println("qry "+qry);
  						boolean successful1=inf.executeUpdateQuery(qry);

  						JOptionPane.showMessageDialog(this,"Patient Discharged Successfully","Message",JOptionPane.INFORMATION_MESSAGE);

  						jButton4.setEnabled(true);
  					}
  				}
  				
  			}
  			else if(bedstatus.equals("-1"))
  			{
  				System.out.println("entering");
  				qry="insert into patient_DischargeSmry values("+(++getmax)+","+Integer.parseInt(jTextField1.getText())+",#"+setDt+"#,'"+jComboBox3.getSelectedItem()+"','"+jComboBox4.getSelectedItem()+"','"+jComboBox7.getSelectedItem()+"','"+jComboBox8.getSelectedItem()+"','"+jTextField10.getText().trim()+"','"+jTextField11.getText().trim()+"','"+jComboBox9.getSelectedItem()+"','"+jComboBox10.getSelectedItem()+"')";
  				System.out.println("qry "+qry);
  				boolean successful=inf.executeUpdateQuery(qry);
  				System.out.println("successful "+successful);
  			
  			
  				if(dtm.getRowCount()!=0)
  				{
  					int getrw=dtm.getRowCount();
  					System.out.println("getrw "+getrw);
  					System.out.println("getmax "+getmax);
  					for(int j=0;j<getrw;j++)
  					{
  						int c=0;
  						qry="insert into patient_DischargeDtl values("+getmax+",'"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"')";
  						System.out.println("qry "+qry);
  						boolean successful1=inf.executeUpdateQuery(qry);
  						System.out.println("successful1 "+successful1);
  						JOptionPane.showMessageDialog(this,"Patient Discharged Successfully","Message",JOptionPane.INFORMATION_MESSAGE);

  						jButton4.setEnabled(true);
  					}
  				}
  					}
  			else
  			{
  				JOptionPane.showMessageDialog(this,"Payment Pending","Message",JOptionPane.INFORMATION_MESSAGE);
  			}
  			
  		}*/
  		if(getgianecStatus!=null)
  		{
  			if(Integer.parseInt(bedstatus)==0)
  			{
  				save();
  			/*	qry="insert into patient_DischargeSmry_Gianec("+(++getmax)+","+Integer.parseInt(jTextField1.getText())+",#"+setDt+"#,'"+jComboBox3.getSelectedItem()+"','"+jComboBox4.getSelectedItem()+"','"+jComboBox7.getSelectedItem()+"','"+jComboBox8.getSelectedItem()+"','"+jTextField10.getText().trim()+"','"+jTextField11.getText().trim()+"','"+jComboBox9.getSelectedItem()+"','"+jComboBox10.getSelectedItem()+"')";
  				System.out.println("qry "+qry);
  				boolean successful=inf.executeUpdateQuery(qry);
  			//	System.out.println("successful "+successful);
  			
  	  			
  				if(dtm.getRowCount()!=0)
  				{
  					int getrw=dtm.getRowCount();
  					System.out.println("getrw "+getrw);
  					System.out.println("getmax "+getmax);
  					for(int j=0;j<getrw;j++)
  					{
  						int c=0;
  						qry="insert into patient_DischargeDtl values("+getmax+",'"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"')";
  						System.out.println("qry "+qry);
  						boolean successful1=inf.executeUpdateQuery(qry);
  						System.out.println("successful1 "+successful1);
  						JOptionPane.showMessageDialog(this,"Patient Discharged Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
  						jButton4.setEnabled(true);
  					}
  				}*/
  				
  			}
  			else if(bedstatus.equals(""))
  			{
  				save();
  			/*	qry="insert into patient_DischargeSmry values("+(++getmax)+","+Integer.parseInt(jTextField1.getText())+",#"+setDt+"#,'"+jComboBox3.getSelectedItem()+"','"+jComboBox4.getSelectedItem()+"','"+jComboBox7.getSelectedItem()+"','"+jComboBox8.getSelectedItem()+"','"+jTextField10.getText().trim()+"','"+jTextField11.getText().trim()+"','"+jComboBox9.getSelectedItem()+"','"+jComboBox10.getSelectedItem()+"')";
  				System.out.println("qry "+qry);
  				boolean successful=inf.executeUpdateQuery(qry);
  				System.out.println("successful "+successful);
  			
  	
  				if(dtm.getRowCount()!=0)
  				{
  					int getrw=dtm.getRowCount();
  					System.out.println("getrw "+getrw);
  					System.out.println("getmax "+getmax);
  					for(int j=0;j<getrw;j++)
  					{
  						int c=0;
  						qry="insert into patient_DischargeDtl values("+getmax+",'"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"')";
  						System.out.println("qry "+qry);
  				         boolean successful1=inf.executeUpdateQuery(qry);
  						System.out.println("successful1 "+successful1);
  						JOptionPane.showMessageDialog(this,"Patient Discharged Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
  						jButton4.setEnabled(true);
  					}
  				}*/
  				
  			}
  			else
  			{
  				JOptionPane.showMessageDialog(this,"Payment Pending","Message",JOptionPane.INFORMATION_MESSAGE);
  			}
  		}
  		
  		
  		
  		
  		///////////////////////////////////////////
  	 	  		
  	}
  	catch(Exception ex)
  	{
  		System.out.println("ERROR...IN checkDischargeEntry Method"+ex);
  	}
  }
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jComboBox11 = new javax.swing.JComboBox();
        jComboBox12 = new javax.swing.JComboBox();
        jComboBox13 = new javax.swing.JComboBox();
        jComboBox14 = new javax.swing.JComboBox();
        jTextField12 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        getContentPane().setLayout(null);

        setBackground(new java.awt.Color(60, 220, 220));
        setClosable(true);
        setTitle("Discharge Card");
        jLabel1.setText("Patient ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 70, 14);

        jLabel2.setText("Patient Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 40, 80, 14);

        jTextField1.setBackground(new java.awt.Color(237, 208, 164));
        jTextField1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        //jTextField1.setText("jTextField1");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        getContentPane().add(jTextField1);
        jTextField1.setBounds(72, 9, 90, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Date");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(480, 10, 90, 14);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 153), 1, true));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(600, 10, 130, 16);

        //jTextField2.setText("jTextField2");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(90, 40, 150, 19);

        jLabel5.setText("Address");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(480, 40, 60, 14);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(570, 40, 160, 50);

        jLabel6.setText("Age / Sex");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 40, 80, 14);

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        //jTextField3.setText("jTextField3");
        getContentPane().add(jTextField3);
        jTextField3.setBounds(320, 40, 150, 19);

        jLabel7.setBackground(new java.awt.Color(204, 255, 204));
        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel7.setText(" Diagnosys :-");
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 100, 110, 20);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(140, 100, 240, 22);

        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });

        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(400, 100, 330, 22);

        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 51), 1, true), "Investigation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 12), new java.awt.Color(255, 0, 0)));
        jLabel10.setText("BP");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 30, 50, 14);

        //jTextField4.setText("jTextField4");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField4);
        jTextField4.setBounds(80, 30, 62, 19);

        jLabel14.setText("Sugar");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(170, 30, 60, 14);

        //jTextField5.setText("jTextField5");
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField5);
        jTextField5.setBounds(220, 30, 62, 19);

        //jTextField6.setText("jTextField6");
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField6);
        jTextField6.setBounds(390, 30, 60, 19);

        jLabel15.setText("Surgery");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(10, 100, 70, 20);

        //jTextField7.setText("jTextField7");
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField7);
        jTextField7.setBounds(80, 100, 320, 19);

        jLabel18.setText("Operation Date");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(420, 100, 140, 20);

        jLabel19.setBackground(new java.awt.Color(0, 153, 153));
        jLabel19.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel19.setForeground(new java.awt.Color(255, 255, 153));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("jLabel19");
        jLabel19.setOpaque(true);
        jPanel1.add(jLabel19);
        jLabel19.setBounds(570, 100, 110, 20);

        jLabel16.setText("HB %");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(330, 30, 50, 20);

        jLabel35.setText("ESR");
        jPanel1.add(jLabel35);
        jLabel35.setBounds(10, 60, 50, 20);

        //jTextField13.setText("jTextField13");
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField13KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField13);
        jTextField13.setBounds(80, 60, 60, 19);

        jLabel17.setText("DLC");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(470, 30, 50, 20);

        //jTextField14.setText("jTextField14");
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField14KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField14);
        jTextField14.setBounds(520, 30, 60, 20);

        jLabel37.setText("TLC");
        jPanel1.add(jLabel37);
        jLabel37.setBounds(600, 30, 50, 20);

        //jTextField16.setText("jTextField16");
        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField16KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField16);
        jTextField16.setBounds(640, 30, 60, 19);

        jLabel38.setText("Other Test");
        jPanel1.add(jLabel38);
        jLabel38.setBounds(170, 60, 70, 20);

        //jTextField17.setText("jTextField17");
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField17KeyPressed(evt);
            }
        });

        jPanel1.add(jTextField17);
        jTextField17.setBounds(250, 60, 150, 19);

        jLabel36.setText("Admit Date");
        jPanel1.add(jLabel36);
        jLabel36.setBounds(420, 60, 140, 20);

        jLabel39.setBackground(new java.awt.Color(0, 153, 153));
        jLabel39.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel39.setForeground(new java.awt.Color(255, 255, 153));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("jLabel39");
        jLabel39.setOpaque(true);
        jPanel1.add(jLabel39);
        jLabel39.setBounds(570, 60, 110, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 140, 720, 130);

        jPanel2.setLayout(null);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        jLabel20.setText("Surgeon Name");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(10, 10, 90, 14);

        //jTextField8.setText("jTextField8");
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
        });

        jPanel2.add(jTextField8);
        jTextField8.setBounds(100, 10, 320, 19);

        jLabel21.setText("Anefthetist");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(440, 10, 90, 14);

        //jTextField9.setText("jTextField9");
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
        });

        jPanel2.add(jTextField9);
        jTextField9.setBounds(530, 10, 180, 19);

        jLabel22.setText("Procedure");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(340, 40, 70, 20);

        jComboBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox7ActionPerformed(evt);
            }
        });
        jComboBox7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox7KeyPressed(evt);
            }
        });

        jPanel2.add(jComboBox7);
        jComboBox7.setBounds(410, 40, 130, 22);

        jComboBox8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox8KeyPressed(evt);
            }
        });

        jPanel2.add(jComboBox8);
        jComboBox8.setBounds(560, 40, 150, 22);

        jLabel23.setText("Assistant");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(10, 40, 90, 20);

        //jTextField10.setText("jTextField10");
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
        });

        jPanel2.add(jTextField10);
        jTextField10.setBounds(100, 40, 210, 19);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 270, 720, 70);

        jPanel3.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 51), 1, true), "Medication on discharge", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 0, 0)));
        jLabel30.setText("Medicine");
        jPanel3.add(jLabel30);
        jLabel30.setBounds(10, 15, 80, 14);

        jLabel31.setText("Dosage");
        jPanel3.add(jLabel31);
        jLabel31.setBounds(190, 15, 80, 14);

        jLabel32.setText("Duration");
        jPanel3.add(jLabel32);
        jLabel32.setBounds(370, 15, 80, 14);

        jLabel33.setText("Day(s)");
        jPanel3.add(jLabel33);
        //jLabel33.setBounds(490, 15, 50, 14);
        jLabel33.setBounds(443, 15, 50, 14);

        jLabel34.setText("Remarks");
        jPanel3.add(jLabel34);
        jLabel34.setBounds(560, 15, 80, 14);

        jComboBox11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox11KeyPressed(evt);
            }
        });

        jPanel3.add(jComboBox11);
        jComboBox11.setBounds(10, 30, 170, 22);

        jComboBox12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox12KeyPressed(evt);
            }
        });

        jPanel3.add(jComboBox12);
        jComboBox12.setBounds(190, 30, 170, 22);

        jComboBox13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox13KeyPressed(evt);
            }
        });

        jPanel3.add(jComboBox13);
        //jComboBox13.setBounds(370, 30, 110, 22);
		jComboBox13.setBounds(370, 30, 60, 22);
        

        jComboBox14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox14KeyPressed(evt);
            }
        });

        jPanel3.add(jComboBox14);
        //jComboBox14.setBounds(490, 30, 60, 22);
        jComboBox14.setBounds(443, 30,100, 22);

        //jTextField12.setText("jTextField12");
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
        });

        jPanel3.add(jTextField12);
        jTextField12.setBounds(560, 30, 90, 20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.jpg")));
        jButton2.setToolTipText("Add Medicine");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jPanel3.add(jButton2);
        jButton2.setBounds(660, 25, 50, 29);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 1, true));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(jTable1);

        jPanel4.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(10, 60, 700, 140);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 340, 720, 210);

        jPanel5.setLayout(null);

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 51), 1, true));
        jButton3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/update.gif")));
        jButton3.setMnemonic('d');
        jButton3.setText("Discharge");
        jButton3.setToolTipText("Discharge");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton3KeyPressed(evt);
            }
        });

        jPanel5.add(jButton3);
        jButton3.setBounds(40, 5, 120, 30);

        jButton4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/PRINT.GIF")));
        jButton4.setMnemonic('p');
        jButton4.setText("Print");
        jButton4.setToolTipText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton4KeyPressed(evt);
            }
        });

        jPanel5.add(jButton4);
        jButton4.setBounds(220, 5, 120, 30);

        jButton5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reset.gif")));
        jButton5.setMnemonic('r');
        jButton5.setText("Refresh");
        jButton5.setToolTipText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton5KeyPressed(evt);
            }
        });

        jPanel5.add(jButton5);
        jButton5.setBounds(380, 5, 120, 30);

        jButton6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/exit.gif")));
        jButton6.setMnemonic('c');
        jButton6.setText("Close");
        jButton6.setToolTipText("Close");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton6KeyPressed(evt);
            }
        });

        jPanel5.add(jButton6);
        jButton6.setBounds(560, 5, 120, 30);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(10, 550, 720, 40);

        jButton1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11));
        jButton1.setForeground(new java.awt.Color(0, 0, 204));
        jButton1.setMnemonic('S');
        jButton1.setText("Search");
        jButton1.setToolTipText("Search Patient To Discharge");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        getContentPane().add(jButton1);
        jButton1.setBounds(170, 10, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox7.requestFocus();
        }
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField10.requestFocus();
        }
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField9.requestFocus();
        }
    }//GEN-LAST:event_jTextField8KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField8.requestFocus();
        }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField7.requestFocus();
        }
    }//GEN-LAST:event_jTextField17KeyPressed

    private void jTextField13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField17.requestFocus();
        }
    }//GEN-LAST:event_jTextField13KeyPressed

    private void jTextField16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField13.requestFocus();
        }
    }//GEN-LAST:event_jTextField16KeyPressed

    private void jTextField14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField16.requestFocus();
        }
    }//GEN-LAST:event_jTextField14KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField14.requestFocus();
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField6.requestFocus();
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField5.requestFocus();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        //search
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton2.requestFocus();
        }
    }//GEN-LAST:event_jTextField12KeyPressed

    private void jComboBox14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox14KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField12.requestFocus();
        }
    }//GEN-LAST:event_jComboBox14KeyPressed

    private void jComboBox13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox13KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox14.requestFocus();
        }
    }//GEN-LAST:event_jComboBox13KeyPressed

    private void jComboBox12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox12KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox13.requestFocus();
        }
    }//GEN-LAST:event_jComboBox12KeyPressed

    private void jComboBox11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox11KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox12.requestFocus();
        }
    }//GEN-LAST:event_jComboBox11KeyPressed

    private void jComboBox8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox8KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox11.requestFocus();
        }
    }//GEN-LAST:event_jComboBox8KeyPressed

    private void jComboBox7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox7KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox8.requestFocus();
        }
    }//GEN-LAST:event_jComboBox7KeyPressed

    private void jComboBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox7ActionPerformed
// TODO add your handling code here:


	jComboBox8.removeAllItems();
        	String getoption=""+jComboBox7.getSelectedItem();
        	System.out.println("getoption "+getoption);
        	if(!getoption.equals("SELECT"))
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
        		
        			String qry="Select dg_surgery_id from eye_diagnosys_surgery_common where dg_surgery='"+getoption+"'";
        			System.out.println("qry "+qry);
        			String getoptionid=inf.getSingleValue(qry);
        			System.out.println("getoptionid "+getoptionid);
        			
        			qry="Select surgery_option from eye_surgery_option where dg_surgery_id="+Integer.parseInt(getoptionid)+"";
        			System.out.println("qry "+qry);
        			String loadOPT[]=inf.getResultSetAs_1D_Array(qry);
        			jComboBox8.addItem("SELECT");
        			if(loadOPT!=null)
        			{
        				for(int j=0;j<loadOPT.length;j++)
        				{
        					jComboBox8.addItem(loadOPT[j]);
        				}
        			}
        			
        		}
        		catch(Exception ex)
        		{
        			System.out.println("ERROR.."+ex);
        		}
        	}

        
    }//GEN-LAST:event_jComboBox7ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            //----use search method here
            int getID=Integer.parseInt(jTextField1.getText());
            
           // loadInitialInfo(getID);
           CheckValidation();
            jComboBox1.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
// TODO add your handling code here:
        
        		jComboBox2.removeAllItems();
		String getcb1=""+jComboBox1.getSelectedItem();
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
			
				
				String qry="Select dg_surgery_id from eye_diagnosys_surgery_common where dg_surgery='"+getcb1+"'";
				System.out.println("qry "+qry);
				String getsurgery_id=inf.getSingleValue(qry);
				System.out.println("getsurgery_id "+getsurgery_id);
				
				qry="Select dg_option from eye_diagnosys_option where dg_surgery_id="+Integer.parseInt(getsurgery_id)+"";
				System.out.println("qry "+qry);
				String loadcb2[]=inf.getResultSetAs_1D_Array(qry);
				jComboBox2.addItem("SELECT");
				for(int i=0;i<loadcb2.length;i++)
				{
					jComboBox2.addItem(loadcb2[i]);
				}
				
				
				
				
				
			}
			catch(Exception ex)
			{
				System.out.println("ERROR.."+ex);
			}
			
		
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
        	addMedi();
            jComboBox11.requestFocus();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
		addMedi();
        //add medicine
    }//GEN-LAST:event_jButton2ActionPerformed
	private void addMedi()
  {
  	int indx=0;
  	int getcnt=dtm.getRowCount();
  	System.out.println("getcnt "+getcnt);
  	if(getcnt==0)
  		indx=1;
  	else
    	indx=(++getcnt);
  
  	int C=0;
  	String loadmedi[][]=new String[1][6];
  		for(int R=0;R<loadmedi.length;R++)
  		{
  			loadmedi[R][C]=""+indx;
  			loadmedi[R][++C]=""+jComboBox11.getSelectedItem();
  			loadmedi[R][++C]=""+jComboBox12.getSelectedItem();
  			loadmedi[R][++C]=""+jComboBox13.getSelectedItem();
  			loadmedi[R][++C]=""+jComboBox14.getSelectedItem();
  			loadmedi[R][++C]=jTextField12.getText();
  			dtm.addRow(loadmedi[R]);
  		}
  }
    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            dispose();
        }
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            
        }
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
        //refresh
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            printDischargeCard Printing=new printDischargeCard(dpp);
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        printDischargeCard Printing=new printDischargeCard(dpp);
        
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private boolean save()
    {
    	
    	try
    	{
		///	ZedInterface obj=(ZedInterface)Naming.lookup(getIPaddress.IP());
		
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
		
		
			//srni--------
			int srNo=0;
    		String temp=inf.getSingleValue("select max(srNo) from patient_DischargeSmry_Gianec");
    		if(temp!=null)
    			srNo=Integer.parseInt(temp);
    		srNo+=1;
    		//----discharge date----
    		String t[]=(jLabel4.getText()).split("/");
    		String disDt=t[1]+"/"+t[0]+"/"+t[2];
    		//diagnosys---------------
    		String dg1="",dg2="";
    		if(jComboBox1.getSelectedItem()!=null && (!(""+jComboBox1.getSelectedItem()).equalsIgnoreCase("select")))
    		{
    			dg1=""+jComboBox1.getSelectedItem();
    		}
    		if(jComboBox2.getSelectedItem()!=null && (!(""+jComboBox2.getSelectedItem()).equalsIgnoreCase("select")))
    		{
    			dg2=""+jComboBox2.getSelectedItem();
    		}
    		//--procedure-------------
    		String proc1="",proc2="";
    		if(jComboBox7.getSelectedItem()!=null && (!(""+jComboBox7.getSelectedItem()).equalsIgnoreCase("select")))
    		{
    			proc1=""+jComboBox7.getSelectedItem();
    		}
    		if(jComboBox8.getSelectedItem()!=null && (!(""+jComboBox8.getSelectedItem()).equalsIgnoreCase("select")))
    		{
    			proc2=""+jComboBox8.getSelectedItem();
    		}
    		//----admit date----
    		t=jLabel39.getText().split("/");
    		String admitDt=t[1]+"/"+t[0]+"/"+t[2];
    		//---operation date-----
    		t=jLabel19.getText().split("/");
    		String opDt=t[1]+"/"+t[0]+"/"+t[2];
    		//INSERTING DATA -----
    		String qry="insert into patient_DischargeSmry_Gianec values("+srNo+","+patientID+",#"+disDt+"#,'"+dg1+"','"+dg2+"','"+jTextField4.getText()+"','"+jTextField5.getText()+"','"+jTextField6.getText()+"','"+jTextField14.getText()+"','"+jTextField16.getText()+"','"+jTextField13.getText()+"','"+jTextField17.getText()+"',#"+admitDt+"#,'"+jTextField7.getText()+"',#"+opDt+"#,'"+jTextField8.getText()+"','"+jTextField9.getText()+"','"+jTextField10.getText()+"','"+proc1+"','"+proc2+"')";
    		inf.executeUpdateQuery(qry);
    		if(dtm.getRowCount()!=0)
  				{
  					int getrw=dtm.getRowCount();
  					//System.out.println("getrw "+getrw);
  					//System.out.println("getmax "+getmax);
  					for(int j=0;j<getrw;j++)
  					{
  						int c=0;
  						qry="insert into patient_DischargeDtl_Gianec values("+srNo+",'"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"','"+(""+jTable1.getValueAt(j,++c))+"')";
  						System.out.println("qry "+qry);
  						boolean successful1=inf.executeUpdateQuery(qry);
  					}
  				}
    		JOptionPane.showMessageDialog(this,"Patient Discharged Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
			jButton3.setEnabled(false);
  			jButton4.setEnabled(true);
  			jButton4.requestFocus();
    	}
    	catch(Exception e)
    	{
    		System.out.println("Error in save method of DischargeCardOfGianec class...."+e);
    	}
    	return true;
    }

    private void jButton3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton3KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            save();
        }
    }//GEN-LAST:event_jButton3KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
        save();
        
    }//GEN-LAST:event_jButton3ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox13;
    private javax.swing.JComboBox jComboBox14;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
    DefaultTableModel dtm;
    int patientID,admitFlag;
    JDesktopPane dpp;
    ZedInterface inf=null;
    
    private void setDefaultValueFun()
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
    	
    	
    	
			String qry="Select dg_surgery from eye_diagnosys_surgery_common";
			System.out.println("qry "+qry);
			String loadDG1[]=inf.getResultSetAs_1D_Array(qry);
			jComboBox1.addItem("SELECT");
			jComboBox7.addItem("SELECT");
			for(int i=0;i<loadDG1.length;i++)
			{
				System.out.println(i+" "+loadDG1[i]);
				jComboBox1.addItem(loadDG1[i]);
				jComboBox7.addItem(loadDG1[i]);
			}
			String loadItem[]=inf.getResultSetAs_1D_Array("select itemName from itemMaster order by itemName asc");
       		String dosage[]=inf.getResultSetAs_1D_Array("select dosage from dosage");
       		for(int j=0;j<loadItem.length;j++)
       		{
       			jComboBox11.addItem(loadItem[j]);
       		}
       	
       		for(int j=0;j<dosage.length;j++)
       		{
       			jComboBox12.addItem(dosage[j]);
       		}
       		for(int j=1;j<=100;j++)
       		{
       			jComboBox13.addItem(""+j);
       		}
       
       		String arr[]={"Day(s)","Week(s)","Month(s)","Year(s)"};
       		for(int j=0;j<arr.length;j++)
       		{
       			jComboBox14.addItem(arr[j]);
       		}
    	}
    	catch(Exception ex)
    	{
    		System.out.println("ERROR..! At setDefaultValueFun"+ex);
    	}
    }
    private void loadInitialInfo(int getID)
    {
    	int pid=getID;
  		try
  		{
	  		//ZedInterface inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
	  		
	  		
	  		
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
	  		
  			String qry="Select name,age,gender,address from patient_Profile where patientid="+pid+"";
  			System.out.println("qry "+qry);
  			String loadINFO[][]=inf.getResultSetAs_2D_Array(qry,4);
  			if(loadINFO!=null)
  			{
	  			for(int i=0;i<loadINFO.length;i++)
  				{
	  				int c=0;
  				//	System.out.println(i+" "+c+" "+loadINFO[i][c]);
	  				jTextField2.setText(loadINFO[i][c]);
  				//	System.out.println(i+" "+c+" "+loadINFO[i][++c]);
  				//	System.out.println(i+" "+c+" "+loadINFO[i][++c]);
	  				jTextField3.setText(loadINFO[i][++c]+" / "+loadINFO[i][++c]);
  					jTextArea1.setText(loadINFO[i][++c]);
  				//	System.out.println(i+" "+c+" "+loadINFO[i][++c]);
  				//	System.out.println(i+" "+c+" "+loadINFO[i][++c]);
	  				
  				}
  			}
  			
  			qry="select sugar,blood_pr from history_Patient where patient_id="+pid+" order by history_date desc ";
  			System.out.println("qry "+qry);
  			String loadHistory[][]=inf.getResultSetAs_2D_Array(qry,2);
			if(loadHistory!=null)
  			{
  				//for(int j=0;j<loadHistory.length;j++)
  				{
  					int c=0;
  					//System.out.println(loadHistory[j][c]);
  					jTextField5.setText(loadHistory[0][c]);
  					jTextField4.setText(loadHistory[0][++c]);
  				//	jTextField6.setText(loadHistory[j][++c]);
  				  				  				
  				}
  			}
  			
  			
  			
  			
  			
  		qry="Select patientID from patient_Presc_Gianec where patientID="+pid+"";
  		System.out.println("qry "+qry);
  		String loadid=inf.getSingleValue(qry);
  		if(loadid!=null)
  		{
  			qry="Select date from patient_Presc_Gianec where patientID="+pid+"";
  			System.out.println("qry .."+qry);
  			String loadDt=inf.getSingleValue(qry);
  			
  			String getdt[]=loadDt.split(" ");
  			String getdt1[]=getdt[0].split("-");
  			System.out.println("0  "+getdt1[0]);
  			System.out.println("1  "+getdt1[1]);
  			System.out.println("2  "+getdt1[2]);
  			jLabel39.setText(getdt1[2]+"/"+getdt1[1]+"/"+getdt1[0]);
  		}
  			
  			
  		
  		}
  		catch(Exception ex)
  		{
  			System.out.println("ERROR..! At loadInitialValueFun"+ex);
  		}
    }
    private void CheckValidation()
  {
  	 String st="";
            int ID=0,CORRECTID=0,INCORRECTID=0;
            if(jTextField1.getText().trim().equals(st))
            {
            	jTextField1.requestFocus();
            	JOptionPane.showMessageDialog(null,"Plaese Input ID","ERROR...!",JOptionPane.ERROR_MESSAGE);
            	
            }
            else
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
            	
            		ID=Integer.parseInt(jTextField1.getText());
            		System.out.println("ID "+ID);
            		
            		String qry="Select id from admit_Patient_Info where id="+ID+" And status="+false+"";
            		System.out.println("qry "+qry );
            		String loadID=inf.getSingleValue(qry);
				//	System.out.println("loadID "+loadID);
					if(loadID!=null)
					{
						if(ID==(Integer.parseInt(loadID)))
						{
							CORRECTID=1;
					//		checkedID=Integer.parseInt(loadID);	
							admitFlag=1;
							
							
						}
						
					}
					else if(loadID==null)
					{
					
						qry="Select Patient_Id from gianec_Surgery_Detail where Patient_Id="+ID+" And status="+true+"";
						System.out.println("qry "+qry);
						String loadID3=inf.getSingleValue(qry);
						if(loadID3!=null)
						{
							CORRECTID=2;
						//	checkedID=Integer.parseInt(loadID3);	
							System.out.println("3333...");
						}
						else
						{
								JOptionPane.showMessageDialog(this," Wrong ID Or Payment Not Completed ","Message",JOptionPane.ERROR_MESSAGE);		
						}
						
											
					}
					else
					{
						JOptionPane.showMessageDialog(this," Wrong ID Or Patient Discharged ","Message",JOptionPane.ERROR_MESSAGE);		
					}
					
            	}
            	catch(Exception ex)
            	{
            		jTextField1.requestFocus();
            		JOptionPane.showMessageDialog(null,"Please Input CorrectID (Number Only)","Error !!",JOptionPane.ERROR_MESSAGE);
            		
            	}
            	if(CORRECTID==1 || CORRECTID==2)
            	{
            	
            		jComboBox1.requestFocus();
            		LoadInitialInfo();
            	}
            
            	
         }
  }
  
  //PRINTING STARTS FROM HERE------------------------------------------------
  
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
            f1=new Font("Times New Roman",Font.BOLD,12);
            //f1=new Font("Arial",Font.BOLD,120);
            f2=new Font("Arial",Font.PLAIN,10);
            f3=new Font("Arial",Font.PLAIN,10);
            f4=new Font("Arial",Font.BOLD,10);
            f5=new Font("Times New Roman",Font.PLAIN,11);
            f6=new Font("Times New Roman",Font.BOLD,11);
            Font f7=new Font("Times New Roman",Font.BOLD,15);
            Font f8=new Font("Times New Roman",Font.BOLD,25);
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
        			
        			
        			
		        	/*FinDatab1aseFile dbfile1=new FinDatab1aseFile();
					Connection con1=dbfile1.connectDatab1ase();
					Statement st=con1.createStatement();								
					con1.close();*/
					
					System.out.println("dhananjay.............2");
					
					/*Datab1aseFile confile=new Datab1aseFile();
					Connection connection=confile.connectDatab1ase();
					Statement stobj=connection.createStatement();
					stobj.close();
					connection.close();								
					System.out.println("dhananjay.............3");*/
					
					fm=g2.getFontMetrics();				
					String temp="";
		            int top=170;
		            
		            if(currentpg==1)
		            {
		            
						System.out.println("s......");

		            
		            g2.setFont(f1);
                                        
		            temp=" "+jTextField2.getText();
		            if(!temp.equals(""))
		            {
		            	layout=new TextLayout(temp,f1,context);
        		    	g2.drawString(temp,100,top);
		            }
		            
		            
        		    
        		    temp=" "+jTextField3.getText();
        		    if(!temp.equals(""))
        		    {
        		    	layout=new TextLayout(temp,f1,context);
        		    g2.drawString(temp,390,top)	;
        		    }
        		    
		            
        		    
        		    top+=20;

		            temp=" "+jTextArea1.getText();
		            if(!temp.equals(""))
		            {
		            	layout=new TextLayout(temp,f1,context);
        		    g2.drawString(temp,100,top)	;
		            }
		            
		            
		            g2.setFont(f2);
		            fm=g2.getFontMetrics();
		            
                    ////pre diag        
                    top+=30;
                    temp=""+jComboBox1.getSelectedItem();
                    if((!temp.equals("SELECT"))||(jComboBox1.getSelectedItem()!=null))
        		    { 
		            layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,150,top)	;
        		    }
        		    else
        		    {
        		    	temp=" ";
        		    	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,150,top)	;
        		    }

		            temp=""+jComboBox2.getSelectedItem();
		            if((!temp.equals("SELECT"))||(jComboBox2.getSelectedItem()!=null))
        		    {
		            	layout=new TextLayout(temp,f2,context);
        		   		 g2.drawString(temp,350,top)	;
					}
					else
					{
						temp=" ";
						layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,350,top)	;
					}
					////HB
		            top+=20;
		            temp=jTextField6.getText();
		            //if((!temp.equals("SELECT"))||(jComboBox3.getSelectedItem()!=null))
        		    {
		            	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,100,top+45);
        		    }
        		    
        		    //tlc
        		    temp=jTextField16.getText();
        		    //if((!temp.equals("SELECT"))||(jComboBox4.getSelectedItem()!=null))
        		    {
		            layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,250,top+45);
        		    }
        		    
        		    
        		    ////dlc
        		    top+=45;
        		    temp=jTextField14.getText();
        		    //if((!temp.equals("SELECT"))||(jComboBox5.getSelectedItem()!=null))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    	g2.drawString(temp,340,top);
        		    }
        		    //esr
        		    temp=jTextField13.getText();
        		    //if((!temp.equals("SELECT"))||(jComboBox6.getSelectedItem()!=null))
        		    {
        		    layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,400,top);
        		    }
        		    
        		    
        		    top+=20;
        		    temp=" "+jTextField13.getText();
        		    layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,340,top);
        		    
        		    temp=" "+jTextField14.getText();
        		    layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,400,top);
        		    
        		    
        		    //bp
        		    top+=20;
        		    temp=" "+jTextField4.getText();
        		    if(!temp.equals(""))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,60,top);	
        		    }
        		    
        		    
        		    //sugar
        		    temp=" "+jTextField5.getText();
        		    if(!temp.equals(""))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,120,top);
        		    }
        		    
        		    
        		    //other test
        		    temp=" "+jTextField17.getText();
        		    if(!temp.equals(""))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,210,top);
        		    }
        		    
        		   //surgery 
        		    
        		    top+=20;
        		    temp=" "+jTextField7.getText();
        		    if(!temp.equals(""))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,90,top);	
        		    }
        		    
        		    
        		    
        		    temp=jLabel19.getText();
        		    if(!temp.equals(""))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,300,top);
        		    }
        		    else
        		    {
        		    	temp=" ";
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,300,top);
        		    }
        		    
        		    
        		    //surgon nm
        		    top+=20;
        		    temp=" "+jTextField8.getText();
        		    if(!temp.equals(""))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,130,top);
        		    }
        		    
        		    //anefthetist
        		    temp=" "+jTextField9.getText();
        		    if(!temp.equals(""))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,350,top);
        		    }
        		    
        		    //assistant
        		    top+=22;
        		    temp=" "+jTextField10.getText();
        		    if(!temp.equals(""))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,130,top);
        		    }
        		    
        		    
        		    //producure
        		    top+=22;
        		    temp=""+jComboBox7.getSelectedItem();
        		    if((!temp.equals("SELECT"))||(jComboBox7.getSelectedItem()!=null))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,130,top);
        		    }
        		    else
        		    {
        		    	temp=" ";
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,130,top);
        		    }
        		    
        		    
        		    temp=""+jComboBox8.getSelectedItem();
        		    if((!temp.equals("SELECT"))||(jComboBox8.getSelectedItem()!=null))
        		    {
        		    	layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,320,top);
        		   	}
        		   	else
        		   	{
        		   		temp=" ";
        		   		layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,320,top);
        		   	}
        		    
        		    //date of admission
        		    top+=23;
        		    temp=""+jLabel39.getText();
        		    //if((!temp.equals("SELECT"))||(jComboBox9.getSelectedItem()!=null))
        		    {
        		    layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,130,top);
        		    }
        		    
        		    
        		    //discharge dt
        		    top+=23;
        		    temp=jLabel4.getText();
        		    layout=new TextLayout(temp,f2,context);
        		    g2.drawString(temp,200,top);
        		    
        		    top+=40;
        		    int temp1=80;
        		    if(dtm.getRowCount()!=0)
        		    {
        		    	int getrw=dtm.getRowCount();
        		    	System.out.println("getrw "+getrw);
        		    	for(int j=0;j<getrw;j++,top+=25)
        		    	{
        		    		int c=1;
        		    		temp1=80;
        		    		temp=""+jTable1.getValueAt(j,c);
        		    		if(!temp.equals(""))
        		    		{
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1-20,top);
        		    		
        		    		}
        		    		else
        		    		{
        		    			temp=" ";
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1-20,top);
        		    		
        		    		}
        		    		//2
        		    		temp1+=80;
        		    		temp=""+jTable1.getValueAt(j,++c);
        		    		if(!temp.equals(""))
        		    		{
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1,top);
        		    		}
        		    		else
        		    		{
        		    			temp=" ";
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1,top);
        		    		}
        		    		
        		    		//3
        		    		temp1+=80;
        		    		temp=""+jTable1.getValueAt(j,++c);
        		    		if(!temp.equals(""))
        		    		{
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1+100,top);
        		    		
        		    		}
        		    		else
        		    		{
        		    			temp=" ";
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1+100,top);
        		    		
        		    		}
        		    		
        		    		//4
        		    		temp1+=120;
        		    		temp=""+jTable1.getValueAt(j,++c);
        		    		if(!temp.equals(""))
        		    		{
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1,top);
        		    		
        		    		}
        		    		else
        		    		{
        		    			temp=" ";
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1,top);
        		    		
        		    		}
        		    		
        		    		//5
        		    		temp1+=80;
        		    		temp=""+jTable1.getValueAt(j,++c);
        		    		if(!temp.equals(""))
        		    		{
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1-10,top);
        		    		
        		    		}
        		    		else
        		    		{
        		    			temp=" ";
        		    			layout=new TextLayout(temp,f2,context);
        		    		g2.drawString(temp,temp1-10,top);
        		    		
        		    		}
        		    	}
        		    }
        		    
        		    
        		    
                            }
					
					top+=7;
					g2.setFont(f6);
					//layout=new TextLayout("------------------------------------------------------------------------------------------------------------------------------------------------------------------",f6,context);
        			//g2.drawString("------------------------------------------------------------------------------------------------------------------------------------------------------------------",0,top);
				//	g2.drawLine(10,top,575,top);
					
					g2.setFont(f3);
		         

					top=720;
					g2.setFont(f6);
					//layout=new TextLayout("------------------------------------------------------------------------------------------------------------------------------------------------------------------",f6,context);
        			//g2.drawString("------------------------------------------------------------------------------------------------------------------------------------------------------------------",0,top);
				//	g2.drawLine(10,top,575,top);
					
					
					
					
         		}
         		catch(Exception x)
         		{
	        		System.out.println("Error2193821..."+x);
         		}
         
         	}
      	}
	}

  
}
