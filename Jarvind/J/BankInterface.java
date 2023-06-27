import java.util.*;
class Banking
{
	public static void main(String a[])
	{
		Transaction t=new Transaction();
		t.name="Arvind";
		t.acn="1";
		t.bal=5000;
		
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
				
				default :
						if(t.ch!=4)
						{
							System.out.println("You have entered wrong choice Try again");
							t.menu();
						}
						
			}
		}while(t.ch!=4);
		
	}
}



class Initialise
{
	protected String name,acn;
	protected int bal,ch;
	Scanner s=new Scanner(System.in);
	public void menu()
	{
		System.out.println("1-Balance Enquiy\n2-Withdraw\n3-deposit\n4-Exit\n\n\nPlease select your choice");
		ch=s.nextInt();
	}
	
}



class Transaction extends Initialise implements TransactionFunctions
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