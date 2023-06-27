import javax.swing.*;
public class NetClientTest{
	public static void main(String args[]){
	NetClient s=new NetClient("127.0.0.1");
	s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	s.startRunning();
	}
}