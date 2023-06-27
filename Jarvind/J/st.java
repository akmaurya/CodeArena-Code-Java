class st
{
	public static void main(String a[])
	{
		String s="15/01/2014 This is An Given String for checking this which is given below";
		String ss="is";
		int i=0,c=1,l=s.length(),n=0;
/*1*/
 		System.out.println("Given String in Reverse Order-->");
		System.out.print("                                  ");
		for(i=l;i>0;i--)
		System.out.print(s.charAt(i-1));
		System.out.println("\n\n\n");
			

/*2*/
 		System.out.println("\n\nGiven String in Vertical Order-->");
		for(i=0;i<l;i++)	
		System.out.println("                                     "+s.charAt(i));
		System.out.println("\n\n\n");


/*3*/
		
		s=s.trim();
		for(i=0;i<l;i++)
		{
			if(s.charAt(i)==' '&& s.charAt(i+1)!=' ')
			c=c+1;
		}
		System.out.println("\n\nGiven string contains "+c+" Word");
		System.out.println("\n\n\n");


/*4*/
		
		s=s.trim();
		c=0;
		for(i=0;i<l;i++)
		{
			if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u')
			c=c+1;
		}
		System.out.println("\n\nIn given String there are total "+c+" Vowels");
		System.out.println("\n\n\n");



/*5*/

		s=s.trim();
		c=0;
		for(i=0;i<l;i++)
		{
			if(s.indexOf(ss,i)>=0)
			{
				c=c+1;
				i=s.indexOf(ss,i);
			}
			
		}
		System.out.println("\n\nIn given String \""+ss+"\" is repeate "+c+" Times");
		System.out.println("\n\n\n");


/*6*/	
				
		System.out.print("\n\nDate is  "+s.charAt(0)+s.charAt(1)+" ");
		if(s.charAt(3)=='0'&&s.charAt(4)=='1')
		System.out.print("Jan ");
		if(s.charAt(3)=='0'&&s.charAt(4)=='2')
		System.out.print("Feb ");
		if(s.charAt(3)=='0'&&s.charAt(4)=='3')
		System.out.print("Mar ");
		if(s.charAt(3)=='0'&&s.charAt(4)=='4')
		System.out.print("Apr ");
		if(s.charAt(3)=='0'&&s.charAt(4)=='5')
		System.out.print("May ");
		if(s.charAt(3)=='0'&&s.charAt(4)=='6')
		System.out.print("Jun ");
		if(s.charAt(3)=='0'&&s.charAt(4)=='7')
		System.out.print("Jul ");
		if(s.charAt(3)=='0'&&s.charAt(4)=='8')
		System.out.print("Aug ");
		if(s.charAt(3)=='0'&&s.charAt(4)=='9')
		System.out.print("Sep ");
		if(s.charAt(3)=='1'&&s.charAt(4)=='0')
		System.out.print("Oct ");
		if(s.charAt(3)=='1'&&s.charAt(4)=='1')
		System.out.print("Nov ");
		if(s.charAt(3)=='1'&&s.charAt(4)=='2')
		System.out.print("Dec ");
		System.out.print(""+s.charAt(6)+s.charAt(7)+s.charAt(8)+s.charAt(9));
		
	}
}