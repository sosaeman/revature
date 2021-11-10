package com.revature.banking.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
//		try(Connection conn =ConnectionUtility.getConnection();) {
//			System.out.println("Connection Successfull");
//		} catch (SQLException e) {
//			System.out.println("Error");
//			e.printStackTrace();
//		}
//--------------------------------------------------------------
		try(Connection conn =ConnectionUtility.getConnection_Props();) {
			System.out.println("Props Connection Successfull");
		} catch (SQLException e) {
			System.out.println("Props Error");
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//-------------------------------------------------------------------
		
	}
}
