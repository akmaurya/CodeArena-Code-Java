import java.rmi.*;
public interface DesktopInterface extends Remote
{
	public int send(int a,int b)throws RemoteException;
}