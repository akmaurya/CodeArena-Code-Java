package p3;

import java.rmi.*;
import java.util.Date;
import java.math.*;

public interface interfaceRailway extends Remote
{
        public java.sql.Connection selectedFinancialYear(String fin) throws RemoteException;
        public boolean selectFinancialYear(String cnm,String fin) throws RemoteException;
        String returnFinancialYears() throws RemoteException;
        boolean checkFinancialDB(String path) throws RemoteException;
        String getBackupOfDatabase() throws RemoteException;
        boolean checkSuperwiserPassword(String username,String password) throws RemoteException;
       // String returnSingleValue(String url) throws RemoteException;
        boolean isInteger(String str) throws RemoteException;
        boolean isLong(String str) throws RemoteException;
        boolean isBlank(String str) throws RemoteException;
        boolean isDouble(String str) throws RemoteException;
        boolean isExist(String str,String year) throws RemoteException;
        String getSigetngleValue(String qry,String year)throws RemoteException;
        boolean saveInformation(String qry,String year) throws RemoteException;
        String [][]getInformationDD(String qry,int col,String year) throws RemoteException;
        int getMaxValue(String qry,String year)throws RemoteException;
        String [] getResultSetAs_1D_Array(String qry,String year)throws RemoteException;
}