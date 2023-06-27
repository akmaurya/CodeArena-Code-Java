import java.util.*;
class Age
{
	public static void main(String args[])
	{
		int age=0;
		 System.out.println("Enter your Age");
		 Scanner s=new Scanner(System.in);
		 try
		 {
		 	age=s.nextInt();
		 	if(age<0)
		 	{
		 		AgeException a=new AgeException();
		 		throw a;
		 	}
		 }
		 catch(Exception ex)
		 {
		 	System.out.println(""+ex.getMessage());
		 }
		 if(age>18)
		 System.out.println("You are elligible");
		 else 
		 System.out.println("You are not elligible");
		 
		 
	}
}