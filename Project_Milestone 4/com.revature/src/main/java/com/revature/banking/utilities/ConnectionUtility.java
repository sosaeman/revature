package com.revature.banking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class ConnectionUtility {

		public static Connection getConnection() throws SQLException {
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String user = "jim";
			String pass = "jpass";
			return DriverManager.getConnection(url,user,pass);
			
			
	};
	
	public static Connection getConnection(String User,String Pass) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = User;
		String pass = Pass;
		return DriverManager.getConnection(url,user,pass);
};

	public static Connection getConnection_Props() throws SQLException, IOException {
		FileInputStream stream = new FileInputStream("db_resources/db-props.properties"); 
		Properties props = new Properties();
		props.load(stream);
		String url = props.getProperty("CONN_URL");
		String user = props.getProperty("CONN_USER");
		String pass = props.getProperty("CONN_PASS");
		return DriverManager.getConnection(url, user, pass);
	}
}
