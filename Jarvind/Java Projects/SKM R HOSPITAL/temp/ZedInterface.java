import java.rmi.*;

public interface ZedInterface extends Remote
{
	public java.sql.Connection makeConnection() throws RemoteException;
	public boolean closeConnection(java.sql.Connection con)throws RemoteException;
	public int getMaxValue(String query)throws RemoteException;
	public int getCountValue(String query)throws RemoteException;
	public boolean executeUpdateQuery(String query)throws RemoteException;
	public String getSingleValue(String query)throws RemoteException;
	public String[] getResultSetAs_1D_Array(String query)throws RemoteException;
	public String[][] getResultSetAs_2D_Array(String query,int noOfColumn)throws RemoteException;
	/*
 	*this method is used in
 	*BackupScreen.java
 	*/
 	String getBackupOfDatabase() throws RemoteException;
}