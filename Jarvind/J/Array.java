class arr
{
	public static void main(String args[])
	{
		int a[][]=new int[10][],i,j,n=1;
		
		for(i=0;i<10;i++)
		a[i]=new int[i+1];
		
		for(i=0;i<10;i++)
		{
			for(j=0;j<i;j++)
			a[i][j]=n++;
		}
		
		for(i=0;i<10;i++)
		{
			for(j=0;j<i;j++)
		 	System.out.print("\t"+a[i][j]);
		 	System.out.println("\n\n");
		}
		
		System.out.print("\n\n\n");
		for(i=0;i<10;i++)
		System.out.print("  "+a[i][i]);
	}
}