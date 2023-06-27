/*
 *This class take value maximum of ten lakh
 **/

class ConversionOfNumberInWordFormat
{
	
	public static void main(String args[])
	{
		try
		{
			java.io.DataInputStream dis=new java.io.DataInputStream(System.in);
			for(int i=0;i<5;i++)
			{
			
			System.out.print("Enter a Number:");
			//double num=Double.valueOf(dis.readLine());
			//int num=Integer.parseInt((dis.readLine()));
			String str=dis.readLine();
			//System.out.println("\ns1  "+str);
			if(str!=null)
			{
				double d=Double.valueOf(str);
				str=""+d;
				String s1=str.substring(0,str.indexOf("."));
				//System.out.println("s1="+s1);
				String s2=str.substring(str.indexOf(".")+1,str.length());
				//System.out.println("s2="+s2);
				if(s2.length()==1)
				{
					s2+="0";
				}
				else if(s2.length()>2)      //because paisa is always of 2 digits...
				{
					s2=s2.substring(0,2);
					
				}
				String word=splitting(s1);
				word=word+"Rupees And ";
				//System.out.println("\ns4  "+s);
				word+=splitting(s2);
				word+="Paise Only";
				System.out.println(""+word);
			}
			}
		}
		catch(Exception e)
		{
			System.out.println("Error..skm R.."+e);
		}
	}
	public static String splitting(String num)	
	{
		String s=num;
		int v=Integer.parseInt(s);//if only 0 is entered more times i.e. 000
		s=""+v;
		//System.out.println("\n"+s+"\n");
		int len1=s.length();
		int len=s.length();
		String rVal="";
		for(int i=0;i<len1;i++,len--)
		{
			int val=Integer.parseInt(s.substring(i,i+1));
			if(val==0 && len1==1)	
			{
				rVal+=conversion(val);
			}
			else if(val>0)
			{
				if(i==0 && len==8)
				{
					rVal+=conversion(val)+"Crore ";
				}
				else if((i==1 && len==7)||(i==0 && len==7))
				{
					rVal+=multipleOfTenValue(val,s.substring(i+1,i+2),len);
					i++;
					len--;
				}
				else if((i==2 && len==6)||(i==1 && len==6)||(i==0 && len==6))
				{
					rVal+=conversion(val)+"Lakh ";
				}
				else if((i==3 && len==5)||(i==2 && len==5)||(i==1 && len==5)||(i==0 && len==5))
				{
					rVal+=multipleOfTenValue(val,s.substring(i+1,i+2),len);
					i++;
					len--;
				}
				else if((i==4 && len==4)||(i==3 && len==4)||(i==2 && len==4)||(i==1 && len==4)||(i==0 && len==4))
				{
					rVal+=conversion(val)+"Thousand ";
				}
				
				else if((i==5 && len==3)||(i==4 && len==3)||(i==3 && len==3)||(i==2 && len==3)||(i==1 && len==3)||(i==0 && len==3) )
				{
					rVal+=conversion(val)+"Hundred ";
				}
				else if((i==6 && len==2)||(i==5 && len==2)||(i==4 && len==2)||(i==3 && len==2)||(i==2 && len==2)||(i==1 && len==2)||(i==0 && len==2) )
				{
					rVal+=multipleOfTenValue(val,s.substring(i+1,i+2),len);
					i++;
					len--;
				}
				else if((i==7 && len==1)||(i==6 && len==1)||(i==5 && len==1)||(i==4 && len==1)||(i==3 && len==1)||(i==2 && len==1)||(i==1 && len==1)||(i==0 && len==1) )
				{
					rVal+=conversion(val);
				}
			}
		}
		//System.out.println(" "+rVal+"");
		return rVal;
	}
	public static String conversion(int n)
	{
		String r="";
		if(n==0)
		{
			r="Zero ";
		}
		else if(n==1)
		{
			r= "One ";
		}
		else if(n==2)
		{
			r= "Two ";
		}
		else if(n==3)
		{
			r= "Three ";
		}
		else if(n==4)
		{
			r= "Four ";
		}
		else if(n==5)
		{
			r= "Five ";
		}
		else if(n==6)
		{
			r= "Six ";
		}else if(n==7)
		{
			r= "Seven ";
		}
		else if(n==8)
		{
			r= "Eight ";
		}
		else if(n==9)
		{
			r= "Nine ";
		}
		else if(n==10)
		{
			r= "Ten ";
		}
		else if(n==11)
		{
			r= "Eleven ";
		}
		else if(n==12)
		{
			r= "Twelve ";
		}
		else if(n==13)
		{
			r= "Thirteen ";
		}
		else if(n==14)
		{
			r= "Fourteen ";
		}
		else if(n==15)
		{
			r= "Fifteen ";
		}
		else if(n==16)
		{
			r= "Sixteen ";
		}
		else if(n==17)
		{
			r= "Seventeen ";
		}
		else if(n==18)
		{
			r= "Eighteen ";
		}
		else if(n==19)
		{
			r= "nineteen ";
		}
		else if(n==20)
		{
			r= "Twenty ";
		}
		else if(n==30)
		{
			r= "Thirty ";
		}
		else if(n==40)
		{
			r= "Fourty ";
		}
		else if(n==50)
		{
			r= "Fifty ";
		}
		else if(n==60)
		{
			r= "Sixty ";
		}
		else if(n==70)
		{
			r= "Seventy ";
		}
		else if(n==80)
		{
			r= "Eighty ";
		}
		else if(n==90)
		{
			r= "Ninety ";
		}
		return r;
	}
	private static String multipleOfTenValue(int val,String secondValue,int len)
	{
		String rVal="";
		String var="";
		if(len==2)
		{}
		if(len==5)
		{
			var="Thousand ";
		}
		if(len==7)
		{
			var="Lakh ";
		}
		if(val>1)
		{
			rVal+=conversion(val*10);
			int val1=Integer.parseInt(secondValue);
			if(val1==0)
			{
				rVal+=var;
			}
			else
			{
				String temp=conversion(val1);
				rVal+=temp+var;
			}
		}
		else
		{
			int val1=Integer.parseInt(secondValue);
			String temp=""+val+""+val1;
			val=Integer.parseInt(temp);
			rVal+=conversion(val)+var;
		}
		return rVal;
	}
}