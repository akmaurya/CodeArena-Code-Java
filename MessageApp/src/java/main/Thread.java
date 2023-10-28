package java.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class VendorThread implements Runnable {
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("csv/VENDOR.CSV"));
			String line;
			Connection connection = DatabaseUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO vendor_id (s_no, vendor_name, transaction_per_second) VALUES (?, ?, ?)");

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				int sNo = Integer.parseInt(data[0]);
				String vendorName = data[1];
				int transactionsPerSecond = Integer.parseInt(data[2]);

				preparedStatement.setInt(1, sNo);
				preparedStatement.setString(2, vendorName);
				preparedStatement.setInt(3, transactionsPerSecond);

				preparedStatement.executeUpdate();
			}

			preparedStatement.close();
			connection.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class MessageThread implements Runnable {
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("csv/MESSAGE_TO_SEND.CSV"));
			String line;
			Connection connection = DatabaseUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO message_to_send (s_no, name, message, vendor_name) VALUES (?, ?, ?, ?)");

			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				int sNo = Integer.parseInt(data[0]);
				String name = data[1];
				String message = data[2];
				String vendorName = data[3];

				preparedStatement.setInt(1, sNo);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3, message);
				preparedStatement.setString(4, vendorName);

				preparedStatement.executeUpdate();
			}

			preparedStatement.close();
			connection.close();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class VendorMessageProcessorThread implements Runnable {
	@Override
    public void run() {
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement vendorStatement = connection.prepareStatement("SELECT DISTINCT vendor_name FROM vendor_id");
            ResultSet vendorResultSet = vendorStatement.executeQuery();

            ExecutorService vendorExecutor = Executors.newCachedThreadPool();

            while (vendorResultSet.next()) {
                String vendorName = vendorResultSet.getString("vendor_name");
                Runnable vendorProcessor = new VendorProcessor(vendorName, connection);
                vendorExecutor.execute(vendorProcessor);
            }

            vendorExecutor.shutdown();

            while (!vendorExecutor.isTerminated()) {
                // Wait for all vendor threads to finish
            }

            vendorStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class VendorProcessor implements Runnable {
    private String vendorName;
    private Connection connection;

    public VendorProcessor(String vendorName, Connection connection) {
        this.vendorName = vendorName;
        this.connection = connection;
    }

    @Override
    public void run() {
        try {
            PreparedStatement messageStatement = connection.prepareStatement(
                    "SELECT * FROM message_to_send WHERE vendor_name = ?");
            messageStatement.setString(1, vendorName);
            ResultSet messageResultSet = messageStatement.executeQuery();

            while (messageResultSet.next()) {
                int sNo = messageResultSet.getInt("s_no");
                String name = messageResultSet.getString("name");
                String message = messageResultSet.getString("message");

                PreparedStatement insertStatement = connection.prepareStatement(
                        "INSERT INTO message_sent (s_no, name, message, vendor_name) VALUES (?, ?, ?, ?)");
                insertStatement.setInt(1, sNo);
                insertStatement.setString(2, name);
                insertStatement.setString(3, message);
                insertStatement.setString(4, vendorName);
                insertStatement.executeUpdate();

                insertStatement.close();
            }

            messageStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class DatabaseUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdb";
    private static final String DB_USER = "yourusername";
    private static final String DB_PASSWORD = "yourpassword";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}