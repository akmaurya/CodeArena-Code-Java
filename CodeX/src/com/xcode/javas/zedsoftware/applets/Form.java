package com.xcode.javas.zedsoftware.applets;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.io.File;

public class Form extends JApplet implements ActionListener
{
	JTextField tf_name1,tf_name2,tf_name3,tf_age,tf_sex,tf_mob,tf_email,tf_pass,tf_search;
	JPasswordField pf_pass;
	JLabel lb_message;
	JButton bt_submit,bt_reset,bt_close,bt_update,bt_search,bt_delete;
	
	String singleRecord;
	
	
	public void init()
	{
		Container cn=getContentPane();
		cn.setLayout(null);
		Color cl_blue=new Color(128,128,255);
		Color cl_red=new Color(255,0,0);
		Color cl_lightred=new Color(255,128,128);
		
		ImageIcon im_photo=new ImageIcon("M.jpg");
		
		JLabel lb_image=new JLabel(im_photo);
		JLabel lb_name1=new JLabel("First Name");
		JLabel lb_name2=new JLabel("Middle Name");
		JLabel lb_name3=new JLabel("Last Name");
		JLabel lb_age=new JLabel("Age");
		JLabel lb_sex=new JLabel("Sex");
		JLabel lb_mob=new JLabel("Mobile No.");
		JLabel lb_email=new JLabel("Emai ID");
		JLabel lb_pass=new JLabel("Password");
		JLabel lb_search=new JLabel("Enter Mobile No.");
		lb_message=new JLabel("");
		
		tf_name1=new JTextField();
		tf_name2=new JTextField();
		tf_name3=new JTextField();
		tf_age=new JTextField();
		tf_sex=new JTextField();
		tf_mob=new JTextField();
		tf_email=new JTextField();
		tf_search=new JTextField();
		pf_pass=new JPasswordField();
		
		bt_submit=new JButton("Submit");
		bt_reset=new JButton("Reset");
		bt_close=new JButton("Close");
		bt_update=new JButton("Update");
		bt_delete=new JButton("Delete");
		bt_search=new JButton("Search");
		
	
		
		
		lb_image.setBounds(340,20,100,130);
		lb_name1.setBounds(10,30,100,30);
		lb_name2.setBounds(10,70,100,30);
		lb_name3.setBounds(10,110,100,30);
		lb_age.setBounds(10,150,50,30);
		lb_sex.setBounds(200,150,60,30);
		lb_mob.setBounds(10,190,100,30);
		lb_email.setBounds(10,230,100,30);
		lb_pass.setBounds(10,270,100,30);
		lb_message.setBounds(10,360,320,30);
		lb_search.setBounds(340,230,100,30);
		
		tf_name1.setBounds(120,30,200,30);
		tf_name2.setBounds(120,70,200,30);
		tf_name3.setBounds(120,110,200,30);
		tf_age.setBounds(120,150,50,30);
		tf_sex.setBounds(240,150,80,30);
		tf_mob.setBounds(120,190,200,30);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       		tf_email.setBounds(120,230,200,30);
		tf_search.setBounds(340,150,100,30);
		pf_pass.setBounds(120,270,200,30);
			
		
		bt_submit.setBounds(10,310,100,30);
		bt_reset.setBounds(120,310,90,30);
		bt_close.setBounds(220,310,100,30);
		bt_search.setBounds(340,190,100,30);
		bt_update.setBounds(340,230,100,30);
		bt_delete.setBounds(340,270,100,30);
		
		
		cn.add(lb_image);
		cn.add(lb_name1);
		cn.add(lb_name2);
		cn.add(lb_name3);
		cn.add(lb_age);
		cn.add(lb_sex);
		cn.add(lb_message);
		cn.add(tf_name1);
		cn.add(tf_name2);
		cn.add(tf_name3);
		cn.add(tf_age);
		cn.add(tf_sex);
		cn.add(tf_mob);
		cn.add(tf_email);
		cn.add(tf_search);
		cn.add(pf_pass);
		cn.add(lb_pass);
		cn.add(lb_mob);
		cn.add(lb_email);

		cn.add(bt_submit);
		cn.add(bt_reset);
		cn.add(bt_close);
		cn.add(bt_update);
		cn.add(bt_delete);
		cn.add(bt_search);
		
		
		bt_submit.addActionListener(this);
		bt_reset.addActionListener(this);
		bt_close.addActionListener(this);
		bt_update.addActionListener(this);
		bt_delete.addActionListener(this);
		bt_search.addActionListener(this);
	}
    public void insert()
    {
        
        try
        {
            RandomAccessFile raf=new RandomAccessFile("Database.txt","rw");
            raf.seek(raf.length());
            
            singleRecord=tf_name1+"@@@"+tf_name2+"@@@"+tf_name3+"@@@"+tf_age+"@@@"+tf_sex+"@@@"+tf_mob+"@@@"+tf_email+"@@@"+pf_pass+"\n";
            byte bt[]=singleRecord.getBytes();
            raf.write(bt);
            raf.close();
            lb_message.setText("You Have Successfully Submited");
            tf_name1.setText("");
			tf_name2.setText("");
			tf_name3.setText("");
			tf_age.setText("");
			tf_sex.setText("");
			tf_mob.setText("");
			tf_email.setText("");
			pf_pass.setText("");
        }
        catch(Exception ex)
        {
            System.out.println("Error"+ex);
        }
            
    }
    
    
    public void delete()
    {
        try
        {
            File f1=new File("Database.txt.java");
            RandomAccessFile raf=new RandomAccessFile("Database.txt","rw");
            File f=new File("temp.txt");
            RandomAccessFile raftemp=new RandomAccessFile("temp.txt","rw");
            raf.seek(0);
            while(raf.getFilePointer()<raf.length())
            {   
                
                singleRecord=raf.readLine()+"\n";
                String singleRecordSplit[]=singleRecord.split("@@@");
              	String str=tf_search.getText();
                if(str.equalsIgnoreCase(singleRecordSplit[5]))
                {
                     raf.seek(raf.getFilePointer());
                     lb_message.setText("Successfully Delete Selected Record");
                }
                else
                {
                    byte bt[]=singleRecord.getBytes();
                    raftemp.write(bt);
                }
            }
            raf.close();
            raftemp.close();
            f1.delete();
         	f.renameTo(f1);
        }
        catch(Exception ex)
        {
            System.out.println("Error"+ex);
        } 
    }
    
	
	public void update()
    {
        try
        {
            File f1=new File("Database.txt");
            RandomAccessFile raf=new RandomAccessFile("Database.txt","rw");
            File f=new File("temp.txt");
            RandomAccessFile raftemp=new RandomAccessFile("temp.txt","rw");
            raf.seek(0);
            while(raf.getFilePointer()<raf.length())
            {   
                singleRecord=raf.readLine()+"\n";
                String singleRecordSplit[]=singleRecord.split("@@@");
              	String str=tf_search.getText();
                if(str.equalsIgnoreCase(singleRecordSplit[5]))
                {
                	tf_name1.setText(singleRecordSplit[0]);
                	tf_name2.setText(singleRecordSplit[1]);
                	tf_name3.setText(singleRecordSplit[2]);
                	tf_age.setText(singleRecordSplit[3]);
                	tf_sex.setText(singleRecordSplit[4]);
                	tf_mob.setText(singleRecordSplit[5]);
                	tf_email.setText(singleRecordSplit[6]);
		            singleRecord=tf_name1+"@@@"+tf_name2+"@@@"+tf_name3+"@@@"+tf_age+"@@@"+tf_sex+"@@@"+tf_mob+"@@@"+tf_email+"@@@"+tf_pass+"\n";
		            byte bt[]=singleRecord.getBytes();
		            raftemp.write(bt);
					lb_message.setText("Successfully Update Record");
                }
                else
                {
                    byte bt[]=singleRecord.getBytes();
                    raftemp.write(bt);       
                }
            }
            raf.close();
            raftemp.close();
            f1.delete();
            boolean res=f.renameTo(f1);
        }
        catch(Exception ex)
        {
            System.out.println("Error"+ex);
        } 
    }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bt_submit)
		{
			insert();
		}
	}
	

}