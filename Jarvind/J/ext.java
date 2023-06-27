class ext
{
	public static void main(String args[])
	{
		int r=0;
	//  8601868485
		try
		{
			r=Integer.parseInt(args[0])/Integer.parseInt(args[1]);
			System.out.println("sum= "+(Integer.parseInt(args[0])/Integer.parseInt(args[1])));
		}
		catch(Exception ex)
		{
			System.out.println("Error from user");
		}
		System.out.println("Result is ="+r);
	}
}