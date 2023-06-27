import java.util.*;
class Banking
{
	public static void main(String a[])
	{
		Transaction t=new Transaction();
		
		do
		{
			t.menu();
			switch(t.ch)
			{
				case 1:
						t.balance();
						break;
				case 2:
						t.withdraw();
						break;
				case 3:
						t.deposit();
						break;
			/*	case 4:
						t.createAccount();
						break;
			*/	
				default :
						if(t.ch!=5)
						{
							System.out.println("You have entered wrong choice Try again");
							t.menu();
						}
					
						
			}
		}while(t.ch!=5);
		
	}
}



class Initialise
{
	protected String name="arv",acn="1";
	protected int bal=5000,ch;
	Scanner s=new Scanner(System.in);
	public void menu()
	{
		System.out.println("1-Balance Enquiy\n2-Withdraw\n3-Deposit\n4-Create Account\n5-Exit\n\n\nPlease select your choice");
		ch=s.nextInt();
	}
	
}



class Transaction extends Initialise
{
	public void deposit()
	{
		
		System.out.println("Enter your account number");
		Scanner s=new Scanner(System.in);
		try
		{
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
		catch(Exception ex)
		{
			System.out.println("You have entered wrong values");
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
/*	public void createAccount()
	{
		int i=0;
		Initialise c=new Initialise();
		c CA[]=new c[10];
		Scanner s=new Scanner(System.in);
			System.out.println("Enter the name of Account Holder");
			CA[i].name=s.nextLine();
			System.out.println("Enter the account no. of Account Holder");
			CA[i].acn=s.nextLine();
			System.out.println("Enter the opening balance of Account Holder");
			CA[i].bal=s.nextInt();
	}*/

}