import java.rmi.*;
//import java.net.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class mathserver extends UnicastRemoteObject implements mathmenu
{
	public mathserver() throws RemoteException {}
	{
		System.out.print("Server Start");
	}
	
	public int addition(int a,int b)
	{
		System.out.println("Addition");
		return(a+b);
	}
	public double getaverage(double a, double b) 
	{
		System.out.println("Average");
		return(a+b)/2;
	}
	public static void main(String a[])
	{
		try
		{
			mathserver ms=new mathserver();
			Naming.rebind("rmi://127.0.0.1:5000/mathdemo",ms);
		}
		catch(Exception ex)
		{
			System.out.println(""+ex);
		}
	}
}