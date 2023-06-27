package window;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarvis on 26/6/17.
 */
public class SRC {
    public static void main(String[] args) {
        /*SRC src = new SRC();
        List<String> fileList = src.getFileList("/home/jarvis/Desktop/src");
        List<String> directoryList = src.getDirectoryList("/home/jarvis/Desktop/src");
        System.out.println("File List:-");
        int count = 0;
        for (String file :fileList)
        {
            System.out.println(++count+ " - " + file);
        }
        System.out.println("Directory List:-");
        count = 0;
        for (String directory :directoryList)
        {
            System.out.println(++count+ " - " + directory);
        }
*/
    }

    public List<String> getFileList(String directoryPath)
    {
        System.out.println(directoryPath);
        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();
        List<String> fileList = new ArrayList<String>();
//        fileList.clear();
        System.out.println(directoryPath);
        System.out.println("File Length = "+listOfFiles.length);

        for (int i = 0; i < listOfFiles.length; i++)
        {

            if (listOfFiles[i].isFile())
            {
//                System.out.println(listOfFiles[i].getName());
                fileList.add(listOfFiles[i].getName());
            }
        }
        return fileList;
    }

    public List<String> getDirectoryList(String directoryPath)
    {
        File folder = new File(directoryPath);
        File[] listOfFiles = folder.listFiles();
        List<String> directoryList = new ArrayList<String>();
        System.out.println(directoryPath);
        System.out.println("Directroy Length = "+listOfFiles.length);
        
        for (int i = 0; i < listOfFiles.length; i++)
        {
            if (listOfFiles[i].isDirectory())
            {
//                System.out.println(listOfFiles[i].getName());
                directoryList.add(listOfFiles[i].getName());
            }
        }
        return directoryList;
    }

/*    public List<String> findFoldersInDirectory(String directoryPath)
    {
        File directory = new File(directoryPath);

        FileFilter directoryFileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };

        File[] directoryListAsFile = directory.listFiles(directoryFileFilter);
        List<String> foldersInDirectory = new ArrayList<String>(directoryListAsFile.length);
        for (File directoryAsFile : directoryListAsFile) {
            foldersInDirectory.add(directoryAsFile.getName());
        }

        return foldersInDirectory;
    }*/
}