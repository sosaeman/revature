package com.banking3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banking3.models.Account;
import com.banking3.utilities.ConnectionUtility;

public class AccountDAOImpl implements AccountDAO {
	
	@Override
	public List<Account> selectAllAccount() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Account> ulist = null;
		
		try(Connection con = ConnectionUtility.getConnection()) {
			String query = "SELECT * FROM BA.account";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(query);
			
			ulist = new ArrayList<Account>();
			while (rs.next()) {
			Account u = new Account();
				u.setAcc_id(rs.getInt(1));//retrive from first column of sql table
				u.setAcc_type(rs.getString(2));
				u.setAcc_balance(rs.getDouble(3));
				
				ulist.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return ulist;
	}

}
