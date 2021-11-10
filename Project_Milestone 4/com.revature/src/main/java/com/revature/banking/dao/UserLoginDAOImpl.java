package com.revature.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.banking.models.Employee;
import com.revature.banking.models.UserLogin;
import com.revature.banking.models.Users;
import com.revature.banking.utilities.ConnectionUtility;

public class UserLoginDAOImpl implements UserLoginDAO {


	@Override
	public boolean insertIntoUserLogins(UserLogin ul) {
PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			String query = "INSERT INTO example.user_login VALUES(Default,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setString(1,ul.getLogin_name());
			ps.setString(2, ul.getLogin_pass());
			ps.setInt(3, ul.getUser_id());
		
		   
			ps.executeUpdate();
			}catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  return false;
		  }
		return true;
	}

	@Override
	public UserLogin selectUserNameAndPass(String name, String pass) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserLogin ul = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			System.out.println("selectUserNameAndPass DAOconnection");
			String query = "SELECT * FROM example.user_login WHERE login_name=? AND login_pass=?";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, pass);

			rs = ps.executeQuery();
			while (rs.next()) {
				ul = new UserLogin(
						rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getInt(4));
				
			};
			
		
		} catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  }
		
		return ul;

	}

	@Override
	public List<UserLogin> selectAllUserLogins() {
		Statement stmt = null;
		ResultSet rs = null;
		List<UserLogin> ullist = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			String query = "SELECT * FROM example.user_login";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(query);
			
			ullist = new ArrayList<UserLogin>();
			while (rs.next()) {
			UserLogin ul = new UserLogin();
				ul.setLogin_id(rs.getInt(1));//retrive from first column of sql table
				ul.setLogin_name(rs.getString(2));
				ul.setLogin_pass(rs.getString(3));
				ul.setUser_id(rs.getInt(4));
				
				ullist.add(ul);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return ullist;
	}

	@Override
	public boolean updateUserLogin(UserLogin ul) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "UPDATE example.user_login SET "
					+ "login_name=?,"
					+ "login_pass=?, User_id=? WHERE login_id=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, ul.getLogin_name());
			ps.setString(2, ul.getLogin_pass());
			ps.setDouble(3, ul.getUser_id());
			ps.setInt(4, ul.getLogin_id());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteUserLoginById(Integer id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "DELETE FROM example.user_login WHERE login_id=?";
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
	public UserLogin selectUserById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserLogin ul = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			System.out.println("DAOconnection");
			String query = "SELECT * FROM example.users_login WHERE user_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ul = new UserLogin();
				ul.setLogin_id(rs.getInt(1));//retrive from first column of sql table
				ul.setLogin_name(rs.getString(2));
				ul.setLogin_pass(rs.getString(3));
				ul.setUser_id(rs.getInt(4));

			}   
			
		
		} catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  }
		
		return ul;

	}

	}


