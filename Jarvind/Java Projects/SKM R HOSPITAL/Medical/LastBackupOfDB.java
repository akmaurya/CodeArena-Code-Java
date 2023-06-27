/*
 * LastBackupOfDB.java
 *
 * Created on December 6, 2010, 4:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

//package medretail;

/**
 *
 * @author skm
 */
public class LastBackupOfDB {
    
    /** Creates a new instance of LastBackupOfDB */
    public LastBackupOfDB() {
    }
    
   public static void takeBackup()
    {
        try
        {
            java.util.Date dt=new java.util.Date();
            String toDayIs=(dt.getDate()+"-"+(dt.getMonth()+1)+"-"+(dt.getYear()+1900));
        
            java.io.File fl=new java.io.File("");
            //String path=fl.getCanonicalFile().getParent();
            String path=fl.getAbsolutePath();
            //System.out.println("p="+path);
            //String dirName=path.substring(0,path.indexOf(":"))+":\\internal_Backup";
            String dirName=path+"\\internal_Backup";
            //System.out.println("dirnm="+dirName);
            String folderName=SetDBFileName.firmNameForDBSelection;
            //System.out.println("FOLDER1="+folderName);
            folderName=folderName.substring(0,folderName.indexOf("."));
            //System.out.println("FOLDER2="+folderName);
            java.io.File makedir=new java.io.File(dirName+"\\"+folderName+"\\"+toDayIs);
            makedir.mkdirs();
            
            String filename=dirName+"\\"+folderName+"\\"+toDayIs+"\\"+SetDBFileName.firmNameForDBSelection;
            //System.out.println("filename="+filename);
                                        
                                        String currentpath = new java.io.File(".").getCanonicalPath();
                                        java.io.FileInputStream in = new java.io.FileInputStream(currentpath+"\\mydatabase\\"+SetDBFileName.firmNameForDBSelection);
                                        java.io.FileOutputStream out = new java.io.FileOutputStream(filename);
                                        int c=0;
                                        int i=1;
                                        byte b[]=new byte[1000];
					while((c=in.read(b))!=-1)
					{
                                            out.write(b);
					      
                                            if(i==100)
                                            {
                                                i=1;
                                            }
                    }
                                        
                                        in.close();
                                        out.close();                    
                                       // javax.swing.JOptionPane.showMessageDialog(null,"Backup completed successfully.","Message",javax.swing.JOptionPane.INFORMATION_MESSAGE);
                                          
                   
        }
        catch(Exception ex)
        {
            System.out.println("error no. 9291..."+ex);
        }
    }
    
}
