package p3;

import java.io.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.rmi.*;

public class getIPaddress
{
	public static String IP()
	{
		String store=new String("rmi://127.0.0.1/railwayMethods");
		try
		{
			File fl=new File("ipaddress.txt");
			if(fl.exists())
			{
				String path=fl.getCanonicalPath();
				RandomAccessFile raf=new RandomAccessFile(path,"r");
				System.out.println(""+path);
				raf.seek(0);
				while(raf.getFilePointer()<raf.length())
				{
					store=raf.readLine();
				}
				raf.close();
				System.out.println("rmi address... "+store);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error at getIPaddress class....."+ex);
		}
		return store;
	}
	
	public static void changeIP()
	{
		try
		{
			String store="";
		
			File fl=new File("ipaddressalways.txt");
			String path=fl.getCanonicalPath();
			RandomAccessFile raf=new RandomAccessFile(path,"r");
		
			/*First delete ioaddress.txt 
			* file
			*/
			File newfl=new File("ipaddress.txt");
			newfl.delete();
			/*Again create new
			 *ipaddress.txt 
			 *file and write matter 
			 *from ipaddressalways.txt
			 */
			RandomAccessFile newraf=new RandomAccessFile(newfl,"rw");
			newraf.seek(0);
			while(raf.getFilePointer()<raf.length())
			{
				store=raf.readLine();
				byte bt[]=store.getBytes();
				newraf.write(bt);
			}
			raf.close();
			newraf.close();
			
			/*Try to connect with
			 *server
			 */				
			interfaceRailway inf=null;
			inf=(interfaceRailway)Naming.lookup(getIPaddress.IP());
		}
		catch(Exception e)
		{
			try
			{
				/* Execution pointer
			 * is here, it means
			 * we fiald to connect
			 * with server. So set IP address of local host 
			 *in ipaddress.txt file
			 */ 
			File newfl=new File("ipaddress.txt");
			newfl.delete();
			RandomAccessFile newraf=new RandomAccessFile(newfl,"rw");
			newraf.seek(0);
			//String store="rmi://127.0.0.1/ExtendZedServer";
			String store="rmi://127.0.0.1/railwayMethods";
			byte bt[]=store.getBytes();
			newraf.write(bt);
			newraf.close();
			
			System.out.println("Error with connection with server "+getIPaddress.IP()+" ...");
			/*try
			{
				inf=(ZedInterface)Naming.lookup(getIPaddress.IP());
				inf1=(ZedInterfaceForMedical)Naming.lookup(getIPaddress.IP());
			}*/
			}
			catch(Exception ex)
			{
				System.out.println("Error with connection with server  rmi://127.0.0.1/ExtendZedServer...");
			}
		}
	}
}