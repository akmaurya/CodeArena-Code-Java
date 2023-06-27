import java.rmi.*;

public interface ZedInterfaceForMedical extends Remote
{
	static int status=-1;
	public String[] getCmpNames()throws RemoteException;
	public String[] getPurPartyNames()throws RemoteException;
	public String[] getItemNames(String cmpname)throws RemoteException;
	public String getCompany(String str)throws RemoteException;
	public String[] getItemNamesOld(String cmpName)throws RemoteException;
	public String[] getBatchNos(String cmpName,String itemName)throws RemoteException;
	public String getPacking(String itemName)throws RemoteException;
	public String getQtyType(String itemName)throws RemoteException;
	public String getSmallestQtyType(String itemName)throws RemoteException;
	public String getVat(String itemName)throws RemoteException;
	public String getMrp(String itemName)throws RemoteException;
	public int getItemCode(String itemName)throws RemoteException;
	public int getNextPurchaseNo()throws RemoteException;
	public int getSaleNo()throws RemoteException;
	public int getMaxValue(String query)throws RemoteException;
	public void saveOrUpdateResultSet(String query)throws RemoteException;
	public int countingValue(String query)throws RemoteException;
	public String returnSingleData(String query)throws RemoteException;
	public String[][]returnResultSet(String query,String label1,String label2)throws RemoteException;
	public String getExpDate(String itemName)throws RemoteException;
	public String getExpDate(String itemName,String batchNo)throws RemoteException;
	public String getItemName(int itemCode)throws RemoteException;
	public String getCmpName(int itemCode)throws RemoteException;
	public String getCmpName(String itemName)throws RemoteException;
	public boolean isBlank(String text)throws RemoteException;
	public boolean isInteger(String text)throws RemoteException;
	public boolean isDouble(String text)throws RemoteException;
	public boolean makeNewFirm(String newFirmName)throws RemoteException;
	public String getMotherboardSN()throws RemoteException;
}