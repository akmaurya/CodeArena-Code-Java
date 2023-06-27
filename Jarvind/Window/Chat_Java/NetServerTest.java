import javax.swing.*;
public class NetServerTest{
	public static void main(String args[]){
	NetServer s=new NetServer();
	s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	s.startRunning();
	}
}