
package railwaycashoffice;
import java.rmi.*;
import java.util.Date;
import java.math.*;

public interface interfaceRailway extends Remote
{
       /* boolean checkSuperwiserPassword(String username,String password) throws RemoteException;
        boolean createSection(String divisioncode,String sectioncode,String sectionname) throws RemoteException;
        boolean createStation(String divisioncode,String sectioncode,String stationcode,String stationname,String lodgment,String bankname,String branchname,String branchcode) throws RemoteException;
        boolean createBankName(String naam) throws RemoteException;
        boolean createShroffsName(String naam) throws RemoteException;
        boolean createCashWitnessName(String naam) throws RemoteException;

        boolean checkExistance(String url) throws RemoteException;
        boolean deleteRecord(String url) throws RemoteException;
        String[][] returnSectionCode(String url) throws RemoteException;
        String[][] returnStationCode(String url) throws RemoteException;
        BigDecimal returnValue() throws RemoteException;//---USED IN DEPOSITE,
        Date returnDateFunc(String url,String dateFieldName) throws RemoteException;//---USED IN DEPOSITE,
        boolean executeSQLUpdateCommand(String url) throws RemoteException;//---USED IN DEPOSITE,
        String[] returnArray(String url,String fieldName) throws RemoteException;
        String[][] returnArray(String url,String fieldName1,String fieldName2) throws RemoteException;
        String[][] returnArray(String url,String fieldName1,String fieldName2,String fieldName3) throws RemoteException;
        String[][] returnArray(String url,int noOfFields) throws RemoteException;
        int countRecord(String url) throws RemoteException;
        String[] returnValueCashBagEntry(String url) throws RemoteException;    //return only bag no, no of pkts, shroffer's name, witness's name
        String[][] returnAllValueCashBagEntry(String url) throws RemoteException;    //return only bag no, no of pkts, shroffer's name, witness's name
        String[][] returnValueTransaction(String url) throws RemoteException;
        String[][] returnValueMiscEarning(String url) throws RemoteException;
        int countBagNo(String url) throws RemoteException;
        int countPktNo(String url) throws RemoteException;
        String[][] returnTcsafenoAndSealeddate(String url) throws RemoteException;
        String[][] returnValueCheque(String url) throws RemoteException;

        String[][] returnArrayDummyDB(String url,int noOfFields) throws RemoteException;
        String[][] returnArrayDummyDB(String url,String fieldName1,String fieldName2,String fieldName3) throws RemoteException;
        boolean executeSQLUpdateCommandDummyDB(String url) throws RemoteException;//---USED IN DEPOSITE,

        //include new methods
        int countRecordsInDateRange(String sql,int y1,int m1,int d1) throws RemoteException;
        int countRecordsInDateRange(String sql,int y1,int m1,int d1,int y2,int m2,int d2) throws RemoteException;
        String[][] returnArrayInDateRange(String url,int y1,int m1,int d1,int y2,int m2,int d2,int noOfFields) throws RemoteException;
        String[][] returnArrayInDateRange(String url,int y1,int m1,int d1,int noOfFields) throws RemoteException;
        boolean updateRecordsInDateRange(String sql,int y1,int m1,int d1,double doubleValue) throws RemoteException;
        boolean updateRecordsInDateRange(String sql,int y1,int m1,int d1) throws RemoteException;
        void updateRecordsInDateRangeInDummyDB(String sql,int y1,int m1,int d1,int y2,int m2,int d2) throws RemoteException;*/
       // boolean deleteSection(String url) throws RemoteException;
        
       // boolean selectedFinancialYear(String fin) throws RemoteException;
        public java.sql.Connection selectedFinancialYear(String fin) throws RemoteException;
        public boolean selectFinancialYear(String fin) throws RemoteException;
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
      //  int getCountValue(String qry) throws RemoteException;
        String [] getResultSetAs_1D_Array(String qry,String year)throws RemoteException;


}
