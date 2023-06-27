/*
 * SurgeryOfEyeForm.java
 *
 * Created on April 28, 2011, 12:27 PM
 */

//package test;
import java.rmi.*;
import javax.swing.*;
/*
 * @author  deepPAL
 */
public class EditSurgeryForm extends javax.swing.JInternalFrame {
    
    /** Creates new form SurgeryOfEyeForm */
    public EditSurgeryForm(int pid) {
        initComponents();
        patientID=pid;
        jLabel2.setText(""+patientID);
        java.util.Date dt=new java.util.Date();
        String date=dt.getDate()+"/"+(dt.getMonth()+1)+"/"+(dt.getYear()+1900);
        jLabel4.setText(date);
        jLabel16.setText(date);
        jTextField1.setEnabled(false);
        jTextArea1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField1.setText(setInitialInfo("select name from patient_Profile where patientid="+patientID+""));
        jTextArea1.setText(setInitialInfo("select address from patient_Profile where patientid="+patientID+""));
        jTextField2.setText(setInitialInfo("select age from patient_Profile where patientid="+patientID+""));
        jTextField3.setText(setInitialInfo("select gender from patient_Profile where patientid="+patientID+""));
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
        
        
        
        
        
        
        
        	String query="select delivery from gianec_Surgery_Delivery order by delivery";
        	String arr[]=inf.getResultSetAs_1D_Array(query);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        			jComboBox1.addItem(arr[i]);
        	}
        	query="select D_C from gianec_Surgery_DilCur order by D_C";
        	arr=inf.getResultSetAs_1D_Array(query);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        			jComboBox2.addItem(arr[i]);
        	}
        	query="select surgeryInfo from gianec_Surgery_SurgeryInfo order by surgeryInfo";
        	arr=inf.getResultSetAs_1D_Array(query);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        			jComboBox3.addItem(arr[i]);
        	}
        	query="select others from gianec_Surgery_Others order by others";
        	arr=inf.getResultSetAs_1D_Array(query);
        	if(arr!=null)
        	{
        		for(int i=0;i<arr.length;i++)
        			jComboBox4.addItem(arr[i]);
        	}
        }
        catch(Exception e)
        {
        	System.out.println("Error in constructor of SurgeryForm class..."+e);
        }
        //......
        showInitialInfo();
        
        
    }
    private String setInitialInfo(String query)
    {
    	String str=null;
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
			str=inf.getSingleValue(query);
			if(str!=null)
			return str;
			else
			return "";
		}
		catch(Exception e)
		{
			System.out.println("Error at setInitialInfo method of SurgeryForm class..."+e);
			return  "";
		}
    }
    
    private void showInitialInfo()
    {
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
			String query="select * from gianec_Surgery_Detail where Patient_Id="+patientID+" order by date desc";
			String arr[][]=inf.getResultSetAs_2D_Array(query,15);
			if(arr!=null)
			{
				serialno=Integer.parseInt(arr[0][0]);
				
				//getting date---
				String tmp[]=arr[0][1].split("-");
    			String dt[]=tmp[2].split(" ");
    			String givendt=dt[0]+"/"+tmp[1]+"/"+tmp[0];
    			jLabel4.setText(givendt);
    			
    			//checking delivery and set---
    			if(!(arr[0][3]==null || arr[0][3].equals("")))
    			{
    				jCheckBox1.setSelected(true);
    				jComboBox1.setSelectedItem(arr[0][3]);
    				jTextField4.setText(""+(new java.math.BigDecimal(arr[0][4]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
    				jComboBox1.setEnabled(true);
    				jTextField4.setEnabled(true);
    			}
    			//checking d.c. and set---
    			if(!(arr[0][5]==null || arr[0][5].equals("")))
    			{
    				System.out.println("sasasa.....\n");
    				jCheckBox2.setSelected(true);
    				jComboBox2.setSelectedItem(arr[0][5]);
    				jTextField5.setText(""+(new java.math.BigDecimal(arr[0][6]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
    				jComboBox2.setEnabled(true);
    				jTextField5.setEnabled(true);
    			}
    			//checking surgery and set---
    			if(!(arr[0][7]==null || arr[0][7].equals("")))
    			{
    				jCheckBox3.setSelected(true);
    				jComboBox3.setSelectedItem(arr[0][7]);
    				jTextField6.setText(""+(new java.math.BigDecimal(arr[0][8]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
    				jComboBox3.setEnabled(true);
    				jTextField6.setEnabled(true);
    			}
    			//checking others and set---
    			if(!(arr[0][9]==null || arr[0][9].equals("")))
    			{
    				jCheckBox4.setSelected(true);
    				jComboBox4.setSelectedItem(arr[0][9]);
    				jTextField7.setText(""+(new java.math.BigDecimal(arr[0][10]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
    				jComboBox4.setEnabled(true);
    				jTextField7.setEnabled(true);
    			}
    			//getting total amt----
    			jLabel13.setText(""+(new java.math.BigDecimal(arr[0][11]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
    			//operation date---
    			tmp=arr[0][12].split("-");
    			dt=tmp[2].split(" ");
    			givendt=dt[0]+"/"+tmp[1]+"/"+tmp[0];
    			jLabel16.setText(givendt);
			}
		}
		catch(Exception e)
		{
			System.out.println("Error at showInitialInfo method of SurgeryForm class..."+e);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jCheckBox4 = new javax.swing.JCheckBox();
        jComboBox4 = new javax.swing.JComboBox();

        getContentPane().setLayout(null);

        setBackground(new java.awt.Color(60, 220, 220));
        setClosable(true);
        setTitle(" Edit Surgery Entry ");
        jLabel1.setText("Patient ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 70, 20);

        jLabel2.setBackground(new java.awt.Color(255, 0, 102));
        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setText("jLabel2");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0)));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 10, 110, 20);

        jLabel3.setText("Date");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(540, 10, 70, 20);

        jLabel4.setBackground(new java.awt.Color(204, 255, 255));
        jLabel4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel4");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(570, 10, 110, 20);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton1.setToolTipText("Set Date");
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
        jButton1.setBounds(680, 7, 30, 30);

        jPanel1.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true), "Patient Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12)));
        jLabel5.setText("Patient Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 20, 80, 20);

        jTextField1.setText("jTextField1");
        jPanel1.add(jTextField1);
        jTextField1.setBounds(90, 20, 340, 19);

        jLabel6.setText("Age");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(510, 20, 40, 20);

        jTextField2.setText("jTextField2");
        jPanel1.add(jTextField2);
        jTextField2.setBounds(540, 20, 60, 19);

        jLabel7.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel7.setText("Year");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(610, 20, 60, 20);

        jLabel8.setText("Address");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 50, 70, 20);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });

        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(90, 50, 340, 40);

        jLabel9.setText("Sex");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(510, 50, 30, 20);

        jTextField3.setText("jTextField3");
        jPanel1.add(jTextField3);
        jTextField3.setBounds(540, 50, 60, 19);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 40, 710, 100);

        jPanel4.setLayout(null);

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 51), 2, true));
        jButton3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton3.setForeground(new java.awt.Color(0, 0, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.gif")));
        jButton3.setMnemonic('e');
        jButton3.setText("Edit");
        jButton3.setToolTipText("Edit");
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

        jPanel4.add(jButton3);
        jButton3.setBounds(40, 10, 120, 30);

        jButton4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton4.setForeground(new java.awt.Color(0, 0, 153));
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

        jPanel4.add(jButton4);
        jButton4.setBounds(210, 10, 120, 30);

        jButton5.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton5.setForeground(new java.awt.Color(0, 0, 153));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/delete.gif")));
        jButton5.setMnemonic('a');
        jButton5.setText("Cancelled");
        jButton5.setToolTipText("Cancel Surgery");
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

        jPanel4.add(jButton5);
        jButton5.setBounds(375, 10, 130, 30);

        jButton6.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jButton6.setForeground(new java.awt.Color(0, 0, 153));
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

        jPanel4.add(jButton6);
        jButton6.setBounds(550, 10, 120, 30);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(10, 360, 710, 50);

        jPanel2.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true), "Surgery Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12)));
        jCheckBox1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 204));
        jCheckBox1.setText("Delivery");
        jCheckBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jPanel2.add(jCheckBox1);
        jCheckBox1.setBounds(20, 30, 100, 15);

        jCheckBox2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jCheckBox2.setForeground(new java.awt.Color(0, 0, 204));
        jCheckBox2.setText("D. & C.");
        jCheckBox2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jPanel2.add(jCheckBox2);
        jCheckBox2.setBounds(20, 60, 100, 15);

        jCheckBox3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jCheckBox3.setForeground(new java.awt.Color(0, 0, 204));
        jCheckBox3.setText("Surgery");
        jCheckBox3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jPanel2.add(jCheckBox3);
        jCheckBox3.setBounds(20, 90, 100, 15);

        jComboBox1.setEnabled(false);
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(150, 30, 220, 22);

        jComboBox2.setEnabled(false);
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(150, 60, 220, 22);

        jComboBox3.setEnabled(false);
        jPanel2.add(jComboBox3);
        jComboBox3.setBounds(150, 90, 220, 22);

        jLabel10.setText("Related Charges");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(420, 30, 110, 20);

        jLabel11.setText("Related Charges");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(420, 60, 110, 20);

        jLabel12.setText("Related Charges");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(420, 90, 110, 20);

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.setEnabled(false);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jPanel2.add(jTextField4);
        jTextField4.setBounds(550, 30, 130, 19);

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField5.setEnabled(false);
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        jPanel2.add(jTextField5);
        jTextField5.setBounds(550, 60, 130, 19);

        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.setEnabled(false);
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });

        jPanel2.add(jTextField6);
        jTextField6.setBounds(550, 90, 130, 19);

        jButton2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12));
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setMnemonic('T');
        jButton2.setText("Calculate Total Charges");
        jButton2.setToolTipText("Calaculate Total Amount");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, new java.awt.Color(255, 153, 153), java.awt.Color.darkGray, java.awt.Color.gray));
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

        jPanel2.add(jButton2);
        jButton2.setBounds(370, 154, 160, 30);

        jLabel13.setBackground(new java.awt.Color(204, 255, 204));
        jLabel13.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel13.setForeground(new java.awt.Color(204, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("0.00");
        jLabel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel13.setOpaque(true);
        jPanel2.add(jLabel13);
        jLabel13.setBounds(550, 160, 130, 20);

        jLabel14.setText("Other Charges");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(420, 120, 110, 20);

        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField7.setEnabled(false);
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });

        jPanel2.add(jTextField7);
        jTextField7.setBounds(550, 120, 130, 19);

        jLabel15.setText("Delivery / Surgery Date ");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(20, 160, 150, 20);

        jLabel16.setBackground(new java.awt.Color(204, 255, 255));
        jLabel16.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("jLabel16");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        jLabel16.setOpaque(true);
        jPanel2.add(jLabel16);
        jLabel16.setBounds(180, 160, 110, 20);

        jButton7.setBackground(new java.awt.Color(255, 0, 0));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.gif")));
        jButton7.setToolTipText("Set Date");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton7KeyPressed(evt);
            }
        });

        jPanel2.add(jButton7);
        jButton7.setBounds(290, 155, 30, 30);

        jCheckBox4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 12));
        jCheckBox4.setForeground(new java.awt.Color(0, 0, 204));
        jCheckBox4.setText("Other Charges");
        jCheckBox4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jCheckBox4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jPanel2.add(jCheckBox4);
        jCheckBox4.setBounds(20, 120, 130, 15);

        jComboBox4.setEnabled(false);
        jPanel2.add(jComboBox4);
        jComboBox4.setBounds(150, 120, 220, 22);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 150, 710, 200);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
// TODO add your handling code here:
        if(jCheckBox4.isSelected())
        {
            jComboBox4.setEnabled(true);
            jComboBox4.requestFocus();
            jTextField7.setEnabled(true);
        }
        else
        {
            jComboBox4.setEnabled(false);
            jTextField7.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jButton2.requestFocus();
        }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            jTextField7.requestFocus();
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

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
// TODO add your handling code here:
        if(jCheckBox3.isSelected())
        {
            jComboBox3.setEnabled(true);
            jComboBox3.requestFocus();
            jTextField6.setEnabled(true);
        }
        else
        {
            jComboBox3.setEnabled(false);
            jTextField6.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
// TODO add your handling code here:
        if(jCheckBox2.isSelected())
        {
            jComboBox2.setEnabled(true);
            jComboBox2.requestFocus();
            jTextField5.setEnabled(true);
        }
        else
        {
            jComboBox2.setEnabled(false);
            jTextField5.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
// TODO add your handling code here:
        if(jCheckBox1.isSelected())
        {
            jComboBox1.setEnabled(true);
            jComboBox1.requestFocus();
            jTextField4.setEnabled(true);
        }
        else
        {
            jComboBox1.setEnabled(false);
            jTextField4.setEnabled(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
        //calculate total amt button
        calculateTotalAmt();
    }//GEN-LAST:event_jButton2ActionPerformed
    private boolean calculateTotalAmt()
    {
        double tot=0.00;
        if(jTextField4.isEnabled())
        {
            try
            {
                tot+=Double.valueOf(jTextField4.getText());
            }
            catch(Exception e)
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Please Input Correct Delivery Charges","Error !!!",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField4.requestFocus();
                jTextField4.selectAll();
                return false;
            }
        }
        if(jTextField5.isEnabled())
        {
            try
            {
                tot+=Double.valueOf(jTextField5.getText());
            }
            catch(Exception e)
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Please Input Correct D. & C. Charges","Error !!!",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField5.requestFocus();
                jTextField5.selectAll();
                return false;
            }
        }
        if(jTextField6.isEnabled())
        {
            try
            {
                tot+=Double.valueOf(jTextField6.getText());
            }
            catch(Exception e)
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Please Input Correct Surgery Charges","Error !!!",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField6.requestFocus();
                jTextField6.selectAll();
                return false;
            }
        }
        if(jTextField7.isEnabled())
        {
            try
            {
                tot+=Double.valueOf(jTextField7.getText());
            }
            catch(Exception e)
            {
                javax.swing.JOptionPane.showMessageDialog(null,"Please Input Correct Other Charges","Error !!!",javax.swing.JOptionPane.ERROR_MESSAGE);
                jTextField7.requestFocus();
                jTextField7.selectAll();
                return false;
            }
        }
        java.math.BigDecimal sum1=new java.math.BigDecimal("0.0");
        sum1=sum1.add(new java.math.BigDecimal(""+tot));
        jLabel13.setText(""+(sum1.setScale(2,java.math.BigDecimal.ROUND_HALF_UP)));
        return true;
    }
    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            //calculate total amt button
            calculateTotalAmt();
            jButton3.requestFocus();
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void jButton7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton7KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            Cal calender=new Cal();
 		String date=calender.getdate();
 		System.out.println("date "+date);
 		jLabel16.setText(date);
        }
        
    }//GEN-LAST:event_jButton7KeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
// TODO add your handling code here:
        //Delivery/surgery date button
        Cal calender=new Cal();
 		String date=calender.getdate();
 		System.out.println("date "+date);
 		jLabel16.setText(date);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            Cal calender=new Cal();
 		String date=calender.getdate();
 		System.out.println("date "+date);
 		jLabel4.setText(date);
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
        //curdate
        Cal calender=new Cal();
 		String date=calender.getdate();
 		System.out.println("date "+date);
 		jLabel4.setText(date);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
// TODO add your handling code here:
		cancelEntry();
    }//GEN-LAST:event_jButton5ActionPerformed
	private void cancelEntry()
	{
		try
		{
			int res=JOptionPane.showConfirmDialog(null,"Are You Sure ");
			if(res==JOptionPane.YES_OPTION)
			{
				int res1=JOptionPane.showConfirmDialog(null,"Are You Sure To Cancel Surgery Entry ?");
				if(res1==JOptionPane.YES_OPTION)
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
				
				
					String query="delete * from gianec_Surgery_Detail where S_no="+serialno+"";
					inf.executeUpdateQuery(query);
					JOptionPane.showMessageDialog(this,"Entry Cancelled Successfully.");
					dispose();
				}
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error in cancelEntry method of EditProvideSpectsEntry class...."+e);
		}
	}
    private void jButton5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            cancelEntry();
        }
    }//GEN-LAST:event_jButton5KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
// TODO add your handling code here:
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton4KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
        {
            
        }
    }//GEN-LAST:event_jButton4KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
	save();
    }//GEN-LAST:event_jButton3ActionPerformed
	private boolean save()
	{
		try
		{
			int Sno=0;
    		java.util.Date dt=new java.util.Date();
    		if(calculateTotalAmt())
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
    	
    	
    	
    			String getDt=jLabel4.getText();
    			String setDate[]=getDt.split("/");
    			String currentdt=setDate[1]+"/"+setDate[0]+"/"+setDate[2];
    			System.out.println(currentdt);
    			String getDt1=jLabel16.getText();
    			String setDate1[]=getDt1.split("/");
    			String OperationDt=setDate1[1]+"/"+setDate1[0]+"/"+setDate1[2];
    			System.out.println(OperationDt);
    			String OperationTime=dt.getHours()+":"+dt.getMinutes()+":"+dt.getSeconds();
    			/*String qry="Select MAX(S_no) from gianec_Surgery_Detail";
    			Sno=inf.getMaxValue(qry);
    			Sno+=1;*/
    			Sno=serialno;
    			
    			String deli="";
    			String dc="";
    			String sur="";
    			String other="";
    			double deli_charge=0;
    			double dc_charge=0;
    			double sur_charge=0;
    			double other_charge=0;
    			//System.out.println("1..");
    			if(jComboBox1.isEnabled())
    			{
    				deli=""+jComboBox1.getSelectedItem();
    				deli_charge=Double.valueOf(jTextField4.getText());
    			}
    			if(jComboBox2.isEnabled())
    			{
    				dc=""+jComboBox2.getSelectedItem();
    				dc_charge=Double.valueOf(jTextField5.getText());
    			}
    			if(jComboBox3.isEnabled())
    			{
    				sur=""+jComboBox3.getSelectedItem();
    				sur_charge=Double.valueOf(jTextField6.getText());
    			}
    			if(jComboBox4.isEnabled())
    			{
    				other=""+jComboBox4.getSelectedItem();
    				other_charge=Double.valueOf(jTextField7.getText());
    			}
    			double total=Double.valueOf(jLabel13.getText());
    			int res=JOptionPane.showConfirmDialog(null,"Are You Sure ?");
				if(res==JOptionPane.YES_OPTION)
				{
    				//deleting pre info---
    				inf.executeUpdateQuery("delete * from gianec_Surgery_Detail where S_no="+serialno+"");
    				//inserting new value---
    				inf.executeUpdateQuery("insert into gianec_Surgery_Detail values("+Sno+",#"+currentdt+"#,"+patientID+",'"+deli+"',"+deli_charge+",'"+dc+"',"+dc_charge+",'"+sur+"',"+sur_charge+",'"+other+"',"+other_charge+","+total+",#"+OperationDt+"#,#"+OperationTime+"#,"+false+")");
    				javax.swing.JOptionPane.showMessageDialog(null,"Entry Updated Successfully....");
    				jButton3.setEnabled(false);
    			}
    		}
			
			
		}
		catch(Exception e)
		{
			System.out.println("Error in save method of SurgeryForm...111......."+e);
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

    private void jButton6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton6KeyPressed
// TODO add your handling code here:
        if(evt.getKeyCode()==10)
            this.dispose();
    }//GEN-LAST:event_jButton6KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
// TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
    int patientID;
    int serialno;
    ZedInterface inf=null;
    
}
