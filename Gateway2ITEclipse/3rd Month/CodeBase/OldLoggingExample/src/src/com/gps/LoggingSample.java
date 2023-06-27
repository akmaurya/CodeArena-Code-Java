package src.com.gps;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

public class LoggingSample {
	private static Logger logger = Logger.getLogger(LoggingSample.class.getName());

	public static void main(String[] args) {
		try {
			logger.info("Main method get called...");
			FileInputStream fstream = new FileInputStream("./media/MCA/6Month/SVN/Java_Getway2IT/Study/trunk/3rd Month/CodeBase/OldLoggingExample/src/log4j.properties"
//					"D:\\AmitKumar\\Personal\\PPT\\GPSWorkSpace\\CoreJava\\LoggingExample\\log4j.properties"
					);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				System.out.println(strLine);
			}
			in.close();
		} catch (FileNotFoundException fe) {
			logger.error("File Not Found", fe);
			logger.warn("This is a warning message");
			logger.trace("This message will not be logged since log level is set as DEBUG");
		} catch (IOException e) {
			System.out.println("working 2.5");
			
			logger.error("IOEXception occured:", e);
		} finally {
			logger.info("Exit from Main method...");
		}
		System.out.println("Working");
	}
}
