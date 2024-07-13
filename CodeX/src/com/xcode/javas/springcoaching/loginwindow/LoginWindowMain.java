package com.xcode.javas.springcoaching.loginwindow;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindowMain extends JFrame implements ActionListener
{
    JTextArea jta1;
    JScrollPane jsp;
    JPanel filePane;
    JButton openBT,saveBT;
    Color cl=new Color(255,128,128);

    String toPaste;



    public static void main(String a[])
    {
        LoginWindowMain frame=new LoginWindowMain();
        frame.setSize(1200,700);
        frame.setVisible(true);
    };

    public LoginWindowMain()
    {
        Container cn=getContentPane();
        cn.setLayout(null);


        filePane=new JPanel();
        filePane.setBounds(630,10,450,125);
        filePane.setLayout(null);
        filePane.setBorder(new BevelBorder(BevelBorder.RAISED));
        filePane.setBackground(cl);

        cn.add(filePane);

        openBT=new JButton("Open");
        openBT.setBounds(360,30,75,30);
        filePane.add(openBT);

        saveBT=new JButton("Save");
        saveBT.setBounds(360,70,75,30);
        filePane.add(saveBT);
    }

    public void actionPerformed(ActionEvent ae)
    {
    }



}
