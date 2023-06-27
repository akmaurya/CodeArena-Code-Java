import java.net.InetAddress;
class IP1
{
	public static void main(String a[]) throws Exception
	{
		
		String str=""+InetAddress.getLocalHost();
		String st[]=str.split("/");
		System.out.println("Computer Name--> "+st[0]);
		System.out.println("IP Address--> "+st[1]);
	}
}