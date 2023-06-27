package src.com.gps;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggingSample {
	private static Logger logger = LogManager.getLogger(LoggingSample.class.getName());

	public static void main(String[] args){
	   try{
		   System.out.println("Working1");
	      FileInputStream fstream = 
	                         new FileInputStream("./LoggingExample/src/log4j.properties"
//	                        		 "D:\\AmitKumar\\Personal\\PPT\\GPSWorkSpace\\CoreJava\\LoggingExample\\log4j.properties"
	                        		 );
	      System.out.println("Working2");
	      DataInputStream in = 
	                         new DataInputStream(fstream);
	      BufferedReader br = 
	                  new BufferedReader(new InputStreamReader(in));
	      String strLine;
	      while ((strLine = br.readLine()) != null){
	     System.out.println (strLine);
	      }
	      in.close();
	      System.out.println("Working");
	   }catch (FileNotFoundException fe){
	     logger.error("File Not Found",fe);
	        logger.warn("This is a warning message");
	        logger.trace("This message will not be logged since log level is set as DEBUG");
	   }catch (IOException e){
		   System.out.println("Working 3");
	     logger.error("IOEXception occured:", e);
	  }
	 }
	
}
