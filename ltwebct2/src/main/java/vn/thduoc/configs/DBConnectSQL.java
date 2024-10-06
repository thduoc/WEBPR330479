package vn.thduoc.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectSQL {
	
	private final static String serverName = "NOKIA3310";
	private final static String dbName = "ltwebct2";
	private final static String portNumber = "1433";
	private final static String userID = "sa";
	private final static String password = "kali";
	
	public static Connection getConnection() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);
	}

	 // Test chương trình. Kích phải chuột chọn run as->java application
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
