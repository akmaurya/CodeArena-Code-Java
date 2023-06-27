//package medretail;
public class LastBackup
{
	private void takeBackup()
    {
        try
        {
            java.util.Date dt=new java.util.Date();
            String toDayIs=(dt.getDate()+"-"+(dt.getMonth()+1)+"-"+(dt.getYear()+1900));
        
            java.io.File fl=new java.io.File(".");
            String path=fl.getCanonicalFile().getParent();
            String dirName=path.substring(0,path.indexOf(":"))+":\\medMan_Backup";
            String folderName=SetDBFileName.firmNameForDBSelection;
            folderName=folderName.substring(0,folderName.indexOf("."));
            java.io.File makedir=new java.io.File(dirName+"\\"+folderName+"\\"+toDayIs);
            makedir.mkdirs();
            
            String filename=dirName+"\\"+folderName+"\\"+toDayIs+"\\"+SetDBFileName.firmNameForDBSelection;
            
                                        
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