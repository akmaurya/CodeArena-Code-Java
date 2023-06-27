/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package atm;

/**
 *ubi_account_statement
 * @author DEEP PAL
 */
public interface interfaceATM  extends java.rmi.Remote{

public boolean updateKGSGInUBI(String data) throws java.rmi.RemoteException;
public boolean updateUBIBillOfKGSGCards(String data) throws java.rmi.RemoteException;
public String getSingleValue(String qry) throws java.rmi.RemoteException;
public boolean ubi_account_statement(String data) throws java.rmi.RemoteException;
public String[][] getInformationDD(String query,int c) throws java.rmi.RemoteException;
public String[] getResultSetAs_1D_Array(String query) throws java.rmi.RemoteException;
public boolean saveInformation(String query) throws java.rmi.RemoteException;

}
