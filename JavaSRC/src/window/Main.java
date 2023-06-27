package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by jarvis on 26/6/17.
 */
public class Main extends JFrame implements ActionListener{
    JComboBox directoryComboBox1, directoryComboBox2, directoryComboBox3, directoryComboBox4, directoryComboBox5, directoryComboBox6;
    JComboBox fileComboBox1, fileComboBox2, fileComboBox3, fileComboBox4;
    String srcHomePath = "/home/jarvis/Desktop/src";
    SRC src = new SRC();
    Combo ob = new Combo();
    public static void main(String[] args) {
//        System.out.println("Hllo World!");
        Main frame = new Main();
        frame.setSize(1000,800);
        frame.setVisible(true);

    }

    public Main()
    {
        Container cn = getContentPane();
        cn.setLayout(null);

        directoryComboBox1 = new JComboBox();
        directoryComboBox1.setBounds(20,20,150,30);

        java.util.List<String> directoryList = src.getDirectoryList(srcHomePath);

        directoryComboBox1.addItem("Select One.");
        for (String directory : directoryList)
        {
            directoryComboBox1.addItem(directory);
        }
        directoryComboBox2 = new JComboBox();
        directoryComboBox2.setBounds(20, 70, 150, 30);
        directoryComboBox2.addItem("Select One");
        directoryComboBox2.addItem("Select Two");

        directoryComboBox2.setVisible(true);

        directoryComboBox3 = new JComboBox();
        directoryComboBox3.setBounds(20, 120, 150, 30);
        directoryComboBox3.addItem("Select One.");


        directoryComboBox3.setVisible(false);

        directoryComboBox4 = new JComboBox();
        directoryComboBox4.setBounds(20, 170, 150, 30);
        directoryComboBox4.addItem("Select One.");
        directoryComboBox4.setVisible(false);

        directoryComboBox5 = new JComboBox();
        directoryComboBox5.setBounds(20, 220, 150, 30);
        directoryComboBox5.setVisible(false);

        directoryComboBox6 = new JComboBox();
        directoryComboBox6.setBounds(20, 270, 150, 30);
        directoryComboBox6.setVisible(false);

        fileComboBox1 = new JComboBox();
        fileComboBox1.setBounds(190, 20, 150, 30);
        fileComboBox1.addItem("Select One.");
        fileComboBox1.setVisible(false);

        fileComboBox2 = new JComboBox();
        fileComboBox2.setBounds(190, 70, 150, 30);
        fileComboBox2.addItem("Select One.");
        fileComboBox2.setVisible(false);

        fileComboBox3 = new JComboBox();
        fileComboBox3.setBounds(190, 120, 150, 30);
        fileComboBox3.addItem("Select One.");
        fileComboBox3.setVisible(false);

        fileComboBox4 = new JComboBox();
        fileComboBox4.setBounds(190, 170, 150, 30);
        fileComboBox4.addItem("Select One.");
        fileComboBox4.setVisible(false);

        cn.add(directoryComboBox1);
        cn.add(directoryComboBox2);
        cn.add(directoryComboBox3);
        cn.add(directoryComboBox4);
        cn.add(directoryComboBox5);
        cn.add(directoryComboBox6);

        cn.add(fileComboBox1);
        cn.add(fileComboBox2);
        cn.add(fileComboBox3);
        cn.add(fileComboBox4);



        directoryComboBox1.addActionListener(this);
        directoryComboBox2.addActionListener(this);
        directoryComboBox3.addActionListener(this);
        directoryComboBox4.addActionListener(this);
        directoryComboBox5.addActionListener(this);
        directoryComboBox6.addActionListener(this);

        fileComboBox1.addActionListener(this);
        fileComboBox2.addActionListener(this);
        fileComboBox3.addActionListener(this);
        fileComboBox4.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == directoryComboBox1)
        {
            System.out.println("Main path: "+srcHomePath+"/"+directoryComboBox1.getSelectedItem());
            System.out.println("Before removeAll");
            System.out.println("After removeAll");
            //fileComboBox1.removeAllItems();

            System.out.println("After removeAll files");
//            directoryComboBox2.removeAll();
//            fileComboBox1.removeAll();
            System.out.println("My-2-"+srcHomePath+"/"+directoryComboBox1.getSelectedItem());
            java.util.List<String> directoryList = src.getDirectoryList(srcHomePath+"/"+directoryComboBox1.getSelectedItem());
            System.out.println("Main directroy list size = "+directoryList.size());
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
            System.out.println("Main file list size = "+fileList.size());
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

            fileComboBox2.setVisible(false);
            fileComboBox3.setVisible(false);
            fileComboBox4.setVisible(false);


            directoryComboBox3.setVisible(false);
            directoryComboBox4.setVisible(false);
            directoryComboBox5.setVisible(false);
            directoryComboBox6.setVisible(false);
        }

        if (ae.getSource() == directoryComboBox2)
        {
            directoryComboBox3.removeAllItems();
            fileComboBox2.removeAllItems();
//            directoryComboBox3.removeAll();
//            fileComboBox2.removeAll();

            java.util.List<String> directoryList = src.getDirectoryList(srcHomePath+"/"+directoryComboBox1.getSelectedItem()+"/"+directoryComboBox2.getSelectedItem());

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

            directoryComboBox4.setVisible(false);
            directoryComboBox5.setVisible(false);
            directoryComboBox6.setVisible(false);

            fileComboBox3.setVisible(false);
            fileComboBox4.setVisible(false);
        }

        if (ae.getSource() == directoryComboBox3)
        {
//            ob.emptyCombo(directoryComboBox4);
//            ob.emptyCombo(fileComboBox3);
            directoryComboBox4.removeAllItems();
            fileComboBox3.removeAllItems();

            java.util.List<String> directoryList = src.getDirectoryList(srcHomePath+"/"+directoryComboBox1.getSelectedItem()+"/"+directoryComboBox2.getSelectedItem()+"/"+directoryComboBox3.getSelectedItem());

            if (!directoryList.isEmpty())
            {
                directoryComboBox4.addItem("Select One.");
                for (String directory:directoryList) {
                    directoryComboBox4.addItem(directory);
                }
                directoryComboBox4.setVisible(true);
            }
            else
                directoryComboBox4.setVisible(false);

            java.util.List<String> fileList = src.getFileList(srcHomePath+"/"+directoryComboBox1.getSelectedItem()+"/"+directoryComboBox2.getSelectedItem()+"/"+directoryComboBox3.getSelectedItem());

            if (!fileList.isEmpty())
            {
                fileComboBox3.addItem("Select One.");
                for (String file:fileList) {
                    fileComboBox3.addItem(file);
                }
                fileComboBox3.setVisible(true);
            }
            else
                fileComboBox3.setVisible(false);

            directoryComboBox5.setVisible(false);
            directoryComboBox6.setVisible(false);

            fileComboBox4.setVisible(false);
        }
    }
}
