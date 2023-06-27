package window;

/**
 * Created by jarvis on 1/7/17.
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.*;

/**
 * Created by jarvis on 26/6/17.
 */
public class NewClass extends JFrame{
    JComboBox directoryComboBox1, directoryComboBox2, directoryComboBox3;
    JComboBox fileComboBox1, fileComboBox2, fileComboBox3, fileComboBox4;
    JButton dotButton1, dotButton2, dotButton3, dotButton4;
    String srcHomePath = "/home/jarvis/Desktop/src";
    SRC src = new SRC();
    public static void main(String[] args) {
        NewClass frame = new NewClass();
        frame.setSize(1000,800);
        frame.setVisible(true);
    }

    public NewClass()
    {
        Container cn = getContentPane();
        cn.setLayout(null);
        directoryComboBox1 = new JComboBox();
        directoryComboBox1.setBounds(20,20,150,30);
//        directoryComboBox1.addItem("One");
//        directoryComboBox1.addItem("Two");

        SRC src = new SRC();
        java.util.List<String> list = src.getDirectoryList(srcHomePath);
        directoryComboBox1.addItem("Select One.");
        for(String dir : list) {
            directoryComboBox1.addItem(dir);
        }

        directoryComboBox2 = new JComboBox();
        directoryComboBox2.setBounds(20, 70, 150, 30);
        directoryComboBox2.setVisible(false);

        directoryComboBox3 = new JComboBox();
        directoryComboBox3.setBounds(20, 120, 150, 30);
        directoryComboBox3.setVisible(false);

        fileComboBox1 = new JComboBox();
        fileComboBox1.setBounds(190, 20, 150, 30);
        fileComboBox1.setVisible(false);

        fileComboBox2 = new JComboBox();
        fileComboBox2.setBounds(190, 70, 150, 30);
        fileComboBox2.setVisible(false);

        fileComboBox3 = new JComboBox();
        fileComboBox3.setBounds(190, 120, 150, 30);
        fileComboBox3.setVisible(false);

        fileComboBox4 = new JComboBox();
        fileComboBox4.setBounds(190, 170, 150, 30);
        fileComboBox4.setVisible(false);

        dotButton1 = new JButton(".");
        dotButton1.setBounds(20, 50, 50, 20);

        dotButton2 = new JButton(".");
        dotButton2.setBounds(20, 100, 50, 20);
        dotButton2.setVisible(false);


        cn.add(directoryComboBox1);
        cn.add(directoryComboBox2);

        cn.add(fileComboBox1);
        cn.add(fileComboBox2);

        cn.add(dotButton1);
        cn.add(dotButton2);

        directoryComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    java.util.List<String> directoryList = src.getDirectoryList(srcHomePath+"/"+directoryComboBox1.getSelectedItem());
                    directoryComboBox2.removeAllItems();
                    for(String dir : directoryList) {
                        directoryComboBox2.addItem(dir);
                    }
                    directoryComboBox2.setVisible(true);

                    if (!directoryList.isEmpty())
                    {
                        directoryComboBox2.addItem("Select One.");
                        for (String directory:directoryList) {
                            directoryComboBox2.addItem(directory);
                        }
                        directoryComboBox2.setVisible(true);
                        dotButton2.setVisible(true);
                    }
                    else
                    {
                        directoryComboBox2.setVisible(false);
                        dotButton2.setVisible(false);
                    }


                    java.util.List<String> fileList = src.getFileList(srcHomePath+"/"+directoryComboBox1.getSelectedItem());

                    if (!fileList.isEmpty())
                    {
                        fileComboBox1.addItem("Select One.");
                        for (String file:fileList) {
                            fileComboBox1.addItem(file);
                        }
                        fileComboBox1.setVisible(true);
                    }
                    else
                        fileComboBox1.setVisible(false);

                    directoryComboBox3.setVisible(false);

                    fileComboBox2.setVisible(false);
                    fileComboBox3.setVisible(false);
            }
        });
        directoryComboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Help");
            }
        });

//        dotButton1.addActionListener(this);
    }

   /* @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == dotButton1)
        {
            java.util.List<String> directoryList = src.getDirectoryList(srcHomePath+"/"+directoryComboBox1.getSelectedItem());
            directoryComboBox2.removeAllItems();
            for(String dir : directoryList) {
                directoryComboBox2.addItem(dir);
            }
            directoryComboBox2.setVisible(true);

            if (!directoryList.isEmpty())
            {
                directoryComboBox2.addItem("Select One.");
                for (String directory:directoryList) {
                    directoryComboBox2.addItem(directory);
                }
                directoryComboBox2.setVisible(true);
                dotButton2.setVisible(true);
            }
            else
            {
                directoryComboBox2.setVisible(false);
                dotButton2.setVisible(false);
            }


            java.util.List<String> fileList = src.getFileList(srcHomePath+"/"+directoryComboBox1.getSelectedItem());

            if (!fileList.isEmpty())
            {
                fileComboBox1.addItem("Select One.");
                for (String file:fileList) {
                    fileComboBox1.addItem(file);
                }
                fileComboBox1.setVisible(true);
            }
            else
                fileComboBox1.setVisible(false);

            directoryComboBox3.setVisible(false);

            fileComboBox2.setVisible(false);
            fileComboBox3.setVisible(false);



        }

        else if (ae.getSource() == dotButton2)
        {
            System.out.println("Help");
        }*/

        /*if (ae.getSource() == directoryComboBox2)
        {
            java.util.List<String> directoryList = src.getDirectoryList(srcHomePath+"/"+directoryComboBox1.getSelectedItem()+"/"+directoryComboBox2.getSelectedItem());
            directoryComboBox3.removeAllItems();
            for(String dir : directoryList) {
                directoryComboBox2.addItem(dir);
            }
            directoryComboBox2.setVisible(true);

            if (!directoryList.isEmpty())
            {
                directoryComboBox3.addItem("Select One.");
                for (String directory:directoryList) {
                    directoryComboBox3.addItem(directory);
                }
                directoryComboBox3.setVisible(true);
            }
            else
                directoryComboBox3.setVisible(false);

            java.util.List<String> fileList = src.getFileList(srcHomePath+"/"+directoryComboBox1.getSelectedItem()+"/"+directoryComboBox2.getSelectedItem());

            if (!fileList.isEmpty())
            {
                fileComboBox2.addItem("Select One.");
                for (String file:fileList) {
                    fileComboBox2.addItem(file);
                }
                fileComboBox2.setVisible(true);
            }
            else
                fileComboBox2.setVisible(false);

            fileComboBox3.setVisible(false);
        }
    }*/

    /*@Override
    public void itemStateChanged(ItemEvent ae) {
        if (ae.getStateChange() == ItemEvent.SELECTED)
        {
            java.util.List<String> directoryList = src.getDirectoryList(srcHomePath+"/"+directoryComboBox1.getSelectedItem());
            directoryComboBox2.removeAllItems();
            *//*for(String dir : list) {
                directoryComboBox2.addItem(dir);
            }
            directoryComboBox2.setVisible(true);*//*

            if (!directoryList.isEmpty())
            {
                directoryComboBox2.addItem("Select One.");
                for (String directory:directoryList) {
                    directoryComboBox2.addItem(directory);
                }
                directoryComboBox2.setVisible(true);
            }
            else
                directoryComboBox2.setVisible(false);

            java.util.List<String> fileList = src.getFileList(srcHomePath+"/"+directoryComboBox1.getSelectedItem());

            if (!fileList.isEmpty())
            {
                fileComboBox1.addItem("Select One.");
                for (String file:fileList) {
                    fileComboBox1.addItem(file);
                }
                fileComboBox1.setVisible(true);
            }
            else
                fileComboBox1.setVisible(false);

            directoryComboBox3.setVisible(false);

            fileComboBox2.setVisible(false);
            fileComboBox3.setVisible(false);


        }

        if (ae.getSource() == directoryComboBox2)
        {
            System.out.println("Help");
        }
    }*/
}
