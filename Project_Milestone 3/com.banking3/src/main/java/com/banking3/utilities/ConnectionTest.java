package com.banking3.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		try(Connection conn =ConnectionUtility.getConnection();) {
			System.out.println("Connection Successfull");
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}

	}
}
