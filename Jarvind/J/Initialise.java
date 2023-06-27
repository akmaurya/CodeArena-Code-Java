package Initialise;
import java.util.*;
public class Initialise
{
	public String name,acn;
	public int bal,ch;
	Scanner s=new Scanner(System.in);
	public void menu()
	{
		System.out.println("1-Balance Enquiy\n2-Withdraw\n3-Deposit\n4-Exit\n\n\nPlease select your choice");
		try
		{
			ch=s.nextInt();
		}
		catch(Exception ex)
		{
			System.out.println("Invalid Entry");
		}
	}
	
}