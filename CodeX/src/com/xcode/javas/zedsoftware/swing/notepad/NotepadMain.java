package com.xcode.javas.zedsoftware.swing.notepad;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

class NotepadMain extends JFrame implements ActionListener
{
    JTextArea jta1;
    JScrollPane jsp;
    JPanel textAreaPane,filePane,editPane,findPane;
    JLabel fileLabel,filenameOpen,fileNameSave,editLabel,findLabel,findWhat,replaceWith,opening;
    JButton openBT,saveBT,cutBT,copyBT,pasteBT,selectAllBT,clearAllBT,findBT,findNextBT,replaceBT,replaceAllBT;
    JTextField fileOpenTF,fileSaveTF,findWhatTF,replaceWithTF;
    JProgressBar openProgress;
    //JColor
    Color cl=new Color(255,128,128);

    String toPaste;



    public static void main(String a[])
    {
        NotepadMain frame=new NotepadMain();
        frame.setSize(1200,700);
        frame.setVisible(true);
    };

    public NotepadMain()
    {
        Container cn=getContentPane();
        cn.setLayout(null);

        textAreaPane=new JPanel();
        textAreaPane.setBounds(10,10,600,400);
        textAreaPane.setLayout(null);
        textAreaPane.setBorder(new BevelBorder(BevelBorder.LOWERED));

        filePane=new JPanel();
        filePane.setBounds(630,10,450,125);
        filePane.setLayout(null);
        filePane.setBorder(new BevelBorder(BevelBorder.RAISED));
        filePane.setBackground(cl);

            editPane=new JPanel();
            editPane.setBounds(630,150,450,90);
            editPane.setLayout(null);
            editPane.setBorder(new BevelBorder(BevelBorder.RAISED));
            editPane.setBackground(cl);

                findPane=new JPanel();
                findPane.setBounds(630,255,450,220);
                findPane.setLayout(null);
                findPane.setBorder(new BevelBorder(BevelBorder.RAISED));
                findPane.setBackground(cl);


        jta1=new JTextArea();
        jsp=new JScrollPane(jta1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(2,2,598,398);
        textAreaPane.add(jsp);
        cn.add(textAreaPane);
        cn.add(filePane);
        cn.add(editPane);
        cn.add(findPane);


        fileLabel=new JLabel("File");
        fileLabel.setBounds(5,5,50,20);
        filePane.add(fileLabel);

            filenameOpen=new JLabel("File Name");
            filenameOpen.setBounds(10,30,70,20);
            filePane.add(filenameOpen);

                fileOpenTF=new JTextField();
                fileOpenTF.setBounds(100,30,240,30);
                filePane.add(fileOpenTF);

                    openBT=new JButton("Open");
                    openBT.setBounds(360,30,75,30);
                    filePane.add(openBT);

                        fileNameSave=new JLabel("File Name");
                        fileNameSave.setBounds(10,70,70,20);
                        filePane.add(fileNameSave);

                            fileSaveTF=new JTextField();
                            fileSaveTF.setBounds(100,70,240,30);
                            filePane.add(fileSaveTF);

                                saveBT=new JButton("Save");
                                saveBT.setBounds(360,70,75,30);
                                filePane.add(saveBT);

        editLabel=new JLabel("Edit");
        editLabel.setBounds(5,5,50,20);
        editPane.add(editLabel);

            cutBT=new JButton("Cut");
            cutBT.setBounds(10,30,75,30);
            editPane.add(cutBT);

                copyBT=new JButton("Copy");
                copyBT.setBounds(90,30,75,30);
                editPane.add(copyBT);

                    pasteBT=new JButton("Paste");
                    pasteBT.setBounds(170,30,75,30);
                    editPane.add(pasteBT);
        
                        selectAllBT=new JButton("Select All");
                        selectAllBT.setBounds(250,30,90,30);
                        editPane.add(selectAllBT);

                            clearAllBT=new JButton("Clear All");
                            clearAllBT.setBounds(345,30,90,30);
                            editPane.add(clearAllBT);

        findLabel=new JLabel("Find & Replace");
        findLabel.setBounds(5,5,150,20);
        findPane.add(findLabel);

            findWhat=new JLabel("Find What");
            findWhat.setBounds(10,30,125,20);
            findPane.add(findWhat);

                findWhatTF=new JTextField();
                findWhatTF.setBounds(105,30,330,30);
                findPane.add(findWhatTF);

                    findBT=new JButton("Find");
                    findBT.setBounds(105,70,100,30);
                    findPane.add(findBT);

                        findNextBT=new JButton("Find Next");
                        findNextBT.setBounds(230,70,125,30);
                        findPane.add(findNextBT);

            replaceWith=new JLabel("Replace With");
            replaceWith.setBounds(10,130, 125,20);
            findPane.add(replaceWith);

                replaceWithTF=new JTextField();
                replaceWithTF.setBounds(105,130,330,30);
                findPane.add(replaceWithTF);

                    replaceBT=new JButton("Replace");
                    replaceBT.setBounds(105,170,100,30);
                    findPane.add(replaceBT);

                        replaceAllBT=new JButton("Replace All");
                        replaceAllBT.setBounds(230,170,125,30);
                        findPane.add(replaceAllBT);

        opening=new JLabel("Opening");
        opening.setBounds(10,415, 100,20);
        opening.setVisible(false);
        cn.add(opening);

            openProgress=new JProgressBar();
            openProgress.setBounds(10,440,600,30);
            openProgress.setVisible(false);
            cn.add(openProgress);
        

        cutBT.addActionListener(this);
        copyBT.addActionListener(this);
        pasteBT.addActionListener(this);
        selectAllBT.addActionListener(this);
        clearAllBT.addActionListener(this);


    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==cutBT)
        {
            toPaste=jta1.getSelectedText();
            jta1.replaceRange("",jta1.getSelectionStart(),jta1.getSelectionEnd());
        }

        if(ae.getSource()==copyBT)
        {
            toPaste=jta1.getSelectedText();
        }

        if(ae.getSource()==pasteBT)
        {
            jta1.replaceRange(toPaste,jta1.getSelectionStart(),jta1.getSelectionEnd());
        }

        if(ae.getSource()==selectAllBT)
        {
            jta1.selectAll();
        }

        if(ae.getSource()==clearAllBT)
        {
            jta1.selectAll();
            jta1.replaceRange("",jta1.getSelectionStart(),jta1.getSelectionEnd());
        }
        jta1.requestFocus();
    }

    
};
/*public void mouseClicked(MouseEvent me)
    {
    }
    public void mousePressed(MouseEvent me)
    {
    }
    public void mouseReleased(MouseEvent me)
    {
    }
    public void mouseEntered(MouseEvent me)

    }

    /*public void mouseClicked(MouseEvent me)
    {
    }
    public void mousePressed(MouseEvent me)
    {
    }
    public void mouseReleased(MouseEvent me)
    {
    }
    public void mouseEntered(MouseEvent me)
    {
    }
    public void mouseExited(MouseEvent me)
    {
    }*/