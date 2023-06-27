import java.io.*;
import java.util.*;
import java.io.File.*;
class BankingNew
{
    public static void main(String args[])
    {
        Account acc=new Account();
        Scanner s=new Scanner(System.in);
        int choice=0;
        do
        {
        	System.out.println("\n\n1- Create New Account\n2- Check Balance\n3- Withdraw\n4- Deposit\n5- Delete Account\n6- Exit\n");
        	try
        	{
        		choice=s.nextInt();
        	}
        	catch(Exception ex)
        	{
        		System.out.println("You Have Entered An Invalid Character\n"+ex);
        	}
        	
        	switch(choice)
        	{
        		case 1:
        			acc.createAccount(); 
        			break;
        /*		case 2:
        			acc.checkBalance();
        			break;
                case 3:
                	acc.withdraw();
                	break;
                case 4:
                	acc.deposit();
                	break;
                case 5:
                	acc.deleteAccount();
                    break;*/
	        }
        }while(choice!=6);    
       
    }
}

class Account
{
	String singleRecord,singleRecordSplit,name, age, phone, passward1, passward2;
	int balance, accountNo=0;
    public void createAccount()
    {
        
        try
        {       	
            RandomAccessFile raf=new RandomAccessFile("Record.bank","rw");
            raf.seek(raf.length());
            Scanner s=new Scanner(System.in);
            
            System.out.println("\nEnter The Name Of Account Holder");
            name=s.nextLine();
            System.out.println("\nEnter the Age Of Account Holder");
           	age=s.nextLine();
            System.out.println("\nEnter the Ph no. Of Account Holder");
            phone=s.nextLine();
            System.out.println("\nEnter Core Balance Of Account Holder");
            try
            {
            	balance=s.nextInt();
            }
            catch(Exception ex)
            {
            	System.out.println("\nError In Balance  "+ex);
            }
            
            do
            {
            	System.out.println("\nEnter the Passward");
            	Scanner s2=new Scanner(System.in);
	            passward1=s2.nextLine();
	            System.out.println("\nEnter Again To Conferm The Passward");
	            passward2=s2.nextLine();
	            if(passward1.equals(passward2))
	            {
	            	if(raf.length()==0)
	            	{
	            		raf.seek(0);
	            		singleRecord=(++accountNo)+"@@@"+passward1+"@@@"+name+"@@@"+age+"@@@"+phone+"@@@"+balance+"\n";
		            	byte bt[]=singleRecord.getBytes();
		            	raf.write(bt);
	            	}
	               	else
	               	{
	               		raf.seek(raf.length()-4);
			            singleRecord=raf.readLine();
			            String singleRecordSplit[]=singleRecord.split("@@@");
			           	accountNo=Integer.parseInt(singleRecordSplit[0])+1;
			           	System.out.println("\n------"+singleRecordSplit[0]+"------------\n");
		            	singleRecord=(accountNo)+"@@@"+passward1+"@@@"+name+"@@@"+age+"@@@"+phone+"@@@"+balance+"\n";
			            byte bt[]=singleRecord.getBytes();
			            raf.write(bt);
	               	}
	            	
		            raf.close();
		            System.out.println("\nAccount Created Successfully\n\nPlease Remember Your Passward And Account No.\n\nAccount No.- "+accountNo+"\n\n");
		            break;
	            }
	            else
	            {
	            	System.out.println("\nPassword Is Not Match With First One\nTry Again\n\n");
	            }
            }while(passward1!=passward2);
        }
        catch(Exception ex)
        {
            System.out.println("Error"+ex);
        }
            
    }
    
  /*  
    public void fetch()
    {
        int n=0;

        try
        {
            RandomAccessFile raf=new RandomAccessFile("one.java","r");
            String data, s1,s2,s3;
            Scanner s=new Scanner(System.in);
            raf.seek(0);
            while(raf.getFilePointer()<raf.length())
            {   
                n=n+1;
                data=raf.readLine();
                String bt[]=data.split("-");
                System.out.println(n+" - Name: "+bt[0]+"\n"+n+" - Age: "+bt[1]+"\n"+n+" - Phone No.: "+bt[2]+"\n\n");
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
                    
                    /*while(raf.getFilePointer()<raf.length())
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

/*

    public void deleteNew(String name)
    {
        try
        {
            //File f1=new File("one.java");
            RandomAccessFile raf=new RandomAccessFile("one.java","rw");
            //File f=new File("temp.java");
            RandomAccessFile raftemp=new RandomAccessFile("temp.java","rw");
            String data;
            raf.seek(0);
            while(raf.getFilePointer()<raf.length())
            {   
                
                data=raf.readLine();
                String bt[]=data.split("-");
                int deleteLength=data.length();
              
                if(name.equalIgnoreCase(bt[0]))
                {
                     raf.seek(raf.getFilePointer()+1);
                }
                else
                {
                    bt[]=data.getBytes();
                    raftemp.write(bt);       
                }
            }
            raf.close();
            raftemp.close();
            File f2=new File("one.java");
            boolean b=raftemp.renameTo(f2);
        }
        catch(Exception ex)
        {
            System.out.println("Error"+ex);
        } 
    }
    */

}