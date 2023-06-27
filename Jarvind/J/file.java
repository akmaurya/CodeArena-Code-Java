import java.io.*;
//import java.io.File;
import java.util.*;
class file
{
    public static void main(String args[])
    {
        records r=new records();
        Scanner s=new Scanner(System.in);
        int choice;
        do
        {
        	System.out.println("1- Insert\n2- Fetch\n3- Delete\n4- Update\n5- Exit\n");
        	choice=s.nextInt();
        	switch(choice)
        	{
        		case 1:
        			r.insert(); 
        			break;
        		case 2:
        			r.fetch();    			
        			break;
                case 3:
                    r.delete();
                    break;
                case 4:
                	r.update();
                	break;
	        }
        }while(choice!=5);    
       
    }
}

class records
{
	String singleRecord, name,age,phone;
    public void insert()
    {
        
        try
        {
            RandomAccessFile raf=new RandomAccessFile("one.java","rw");
            raf.seek(raf.length());
            Scanner s=new Scanner(System.in);
            
            System.out.println("\n\nEnter The Name Of Student");
            name=s.nextLine();
            System.out.println("\nEnter The Age Of Student");
            age=s.nextLine();
            System.out.println("\nEnter The Phone No. Of Student");
            phone=s.nextLine();
            singleRecord=name+"-"+age+"-"+phone+"\n";
            byte bt[]=singleRecord.getBytes();
            raf.write(bt);
            raf.close();
            System.out.println("\nYou Have Successfully Inserted\n\n");
        }
        catch(Exception ex)
        {
            System.out.println("Error"+ex);
        }
            
    }
    
    
    public void fetch()
    {
        int n=0;

        try
        {
            RandomAccessFile raf=new RandomAccessFile("one.java","r");
            Scanner s=new Scanner(System.in);
            raf.seek(0);
            System.out.println("\n\n");
            while(raf.getFilePointer()<raf.length())
            {   
                singleRecord=raf.readLine();
                String bt[]=singleRecord.split("-");
                System.out.println("\t| Name: "+bt[0]+"\n  "+(++n)+"-->\t| Age: "+bt[1]+"\n\t| Phone No.: "+bt[2]+"\n\n");
            }
            raf.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error"+ex);
        }
    }


    /*public void delete(int acc)
    {
        
        try
        {
            RandomAccessFile raf=new RandomAccessFile("one.java","rw");
            String data;
            raf.seek(0);
            while(raf.getFilePointer()<raf.length())
            {   
                
                data=raf.readLine();
                String bt[]=data.split("-");
                int deleteLength=data.length();
              
                if(acc==(Integer.parseInt(bt[0])))
                {
                    data="";
                    for(int i=0;i<deleteLength;i++)
                    data="\b"+data;
                    raf.seek(raf.getFilePointer()-1);
                    byte spaces[]=data.getBytes();
                    raf.write(spaces);
                    
                    while(raf.getFilePointer()<raf.length())
                    {
                        int dataLength=0;
                        String d="";
                        data=raf.readLine()+"\n";
                        for(int i=1;i<dataLength;i++)
                        d="o"+d;
                        byte b[]=d.getBytes();
                        raf.write(b);
                        raf.seek(raf.getFilePointer()-(data.length()+deleteLength-1));
                        byte overWrite[]=data.getBytes();
                        dataLength=data.length();
                        
                        raf.write(overWrite);
                        deleteLength=data.length();
                    }
                    
                }
                else 
                System.out.println("Entered data not found");
                


            }
            raf.close();
        }
        catch(Exception ex)
        {
            System.out.println("Error"+ex);
        } 
    }*/


    public void delete()
    {
    	System.out.println("\n\nEnter Name to delete");
        Scanner s=new Scanner(System.in);
        name=s.nextLine();
        try
        {
            File f1=new File("one.java");
            RandomAccessFile raf=new RandomAccessFile("one.java","rw");
            File f=new File("temp.java");
            System.out.println(""+f.getAbsolutePath());
            RandomAccessFile raftemp=new RandomAccessFile("temp.java","rw");
            raf.seek(0);
            while(raf.getFilePointer()<raf.length())
            {   
                
                singleRecord=raf.readLine()+"\n";
                String singleRecordSplit[]=singleRecord.split("-");
              
                if(name.equalsIgnoreCase(singleRecordSplit[0]))
                {
                     raf.seek(raf.getFilePointer());
                     System.out.println("\n\nSuccessfully Delete selected record\n\n");
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
    
	
	public void update()
    {
    	System.out.println("\n\nEnter Name to update");
        Scanner s=new Scanner(System.in);
        name=s.nextLine();
        try
        {
            File f1=new File("one.java");
            RandomAccessFile raf=new RandomAccessFile("one.java","rw");
            File f=new File("temp.java");
            RandomAccessFile raftemp=new RandomAccessFile("temp.java","rw");
            raf.seek(0);
            while(raf.getFilePointer()<raf.length())
            {   
                singleRecord=raf.readLine()+"\n";
                String singleRecordSplit[]=singleRecord.split("-");
              
                if(name.equalsIgnoreCase(singleRecordSplit[0]))
                {
                    System.out.println("\n\nEnter the New Name of Student");
		            name=s.nextLine();
		            System.out.println("\nEnter the New Age of Student");
		            age=s.nextLine();
		            System.out.println("\nEnter the New Ph no. of Student");
		            phone=s.nextLine();
		            singleRecord=name+"-"+age+"-"+phone+"\n";
		            byte bt[]=singleRecord.getBytes();
		            raftemp.write(bt);
					System.out.println("\n\n`Successfully Update record\n\n");
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
}