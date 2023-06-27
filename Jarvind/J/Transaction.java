package b;
import java.util.*;
import Initialise.Initialise;


public class Transaction extends Initialise
{
	public void deposit()
	{
		
		System.out.println("Enter your account number");
		Scanner s=new Scanner(System.in);
		if(acn.equals(s.nextLine()))
		{
			System.out.println("Enter amount to be deposit");
			bal=bal+s.nextInt();
			System.out.println("Successfully deposited");
		}
		else
		{
			System.out.println("Sorry Invalid account no.\nTry again");
			deposit();
		}
	}
	
	public void withdraw()
	{
		System.out.println("Enter your account number");
		Scanner s=new Scanner(System.in);
		if(acn.equals(s.nextLine()))
		{
			System.out.println("Enter amount to be withdraw");
			int withdraw=s.nextInt();
			if(bal>=withdraw)
			{
				bal=bal-withdraw;
				System.out.println("Successfully withdraw");
			}
			else
			{
				System.out.println("You have entered more than available balance please try again");
				withdraw();
			}
		}
		else
		{
			System.out.println("Sorry Invalid account no.\nTry again");
			withdraw();
		}
	}
	
	public void balance()
	{
		try{
		Runtime.getRuntime().exec("cmd /c cls");
		}
		catch(Exception a)
		{
			System.out.println("error="+a);
		}
		
		System.out.println("Enter your account number");
		Scanner s=new Scanner(System.in);
		if(acn.equals(s.nextLine()))
		System.out.println("Your current balance is \""+bal+"\" Rupees");
		else
		{
			System.out.println("Sorry Invalid account no.\nTry again");
			balance();
		}
	}

}