package com.revature.banking.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.banking.models.Employee;
import com.revature.banking.models.UserLogin;
import com.revature.banking.models.Users;
import com.revature.banking.utilities.ConnectionUtility;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean insertIntoUsers(Users U) {
PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props() ) {
			String query = "INSERT INTO example.Users VALUES(Default,?,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setString(1, U.getUser_name());
			ps.setString(2, U.getUser_address());
			ps.setString(3, U.getUser_phone());
			ps.setDouble(4, U.getUser_balance());
		   
			ps.executeUpdate();
			}catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  return false;
		  }
		return true;
	}

	@Override
	public Users selectUserById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users u = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			System.out.println("selectUserById DAOconnection");
			String query = "SELECT * FROM example.users WHERE user_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new Users();
				u.setUser_id(rs.getInt(1));//retrive from first column of sql table
				u.setUser_name(rs.getString(2));
				u.setUser_address(rs.getString(3));
				u.setUser_phone(rs.getString(4));
				u.setUser_balance(rs.getDouble(5));

			}   
			
		
		} catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  }
		
		return u;

	}

	@Override
	public List<Users> selectAllUsers() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Users> ulist = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			String query = "SELECT * FROM example.users";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(query);
			
			ulist = new ArrayList<Users>();
			while (rs.next()) {
			Users u = new Users();
				u.setUser_id(rs.getInt(1));//retrive from first column of sql table
				u.setUser_name(rs.getString(2));
				u.setUser_phone(rs.getString(4));
				u.setUser_address(rs.getString(3));
				u.setUser_balance(rs.getDouble(5));
				
				ulist.add(u);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return ulist;
	}

	@Override
	public boolean updateUser(Users U) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtility.getConnection_Props()) {
			String query = "UPDATE example.users SET "
					+ "user_name=?,  user_address=?, "
					+ "user_phone=?, user_balance=? WHERE user_id=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, U.getUser_name());
			ps.setString(2, U.getUser_address());
			ps.setString(3, U.getUser_phone());
			ps.setDouble(4, U.getUser_balance());
			ps.setInt(5, U.getUser_id());


			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean deleteUserById(Integer id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "DELETE FROM example.Users WHERE user_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	@Override
	public Users selectUserByNameAndPhone(String name,String phone) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users u = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			System.out.println("DAOconnection");
			String query = "SELECT * FROM example.users WHERE user_name=? AND user_phone=?";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, phone);

			rs = ps.executeQuery();
			while (rs.next()) {
				u = new Users(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4),
				rs.getDouble(5));
				
			};
			
		
		} catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  }
		
		return u;

	}

}
