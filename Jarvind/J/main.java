import b.Transaction;
class main
{
	public static void main(String ar[])
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