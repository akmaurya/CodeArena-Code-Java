package com.xcode.javas.durgasoft.digging.src_viewer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class Main
{
    static int count=0;
    static int totalFolderCount=1;
    static int totalFileCount=1;
    public static void main(String[] args) throws Exception
    {
        FileReader reader=new FileReader("srcFileName.properties");

        Properties p=new Properties();
        p.load(reader);

        System.out.println(p.getProperty("srcFileName"));
        Main main=new Main();
        main.fileListView(p.getProperty("srcFileName"));
        System.out.println("Total Folders : "+totalFolderCount);
        System.out.println("Total Files : "+totalFileCount);

    }
    public static void fileListView(String dirName){
        count++;
        int folderCount=1;
        int fileCount=1;

        File folder = new File(dirName);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            for(int j=0;j<=count;j++)
                System.out.print(" ");
            if (listOfFiles[i].isFile()) {
                System.out.println("|-"+fileCount+++"- " + listOfFiles[i].getName());
                totalFileCount++;
            } else if (listOfFiles[i].isDirectory()) {

                System.out.println("|+" +folderCount+++"- " + listOfFiles[i].getName());
                totalFolderCount++;
                fileListView(listOfFiles[i].getAbsolutePath());
                count--;
            }
        }

    }
}
