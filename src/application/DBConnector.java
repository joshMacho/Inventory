package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private static Connection conn = null;
	static String databaseName = "itemList";
	
	public static Connection dbconnect() {
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://MACHO\\SQLEXPRESS;"
					+ "databaseName="+databaseName+";username=sa;password=macho;"
					+ "encrypt=true;trustServerCertificate=true");
			System.out.println("Connection successfull");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
