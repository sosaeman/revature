package revature.project.banking.dao;

import static revature.project.colors.consoleColor.ANSI_RESET;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import revature.project.banking.models.Login;
import revature.project.banking.utilities.ConnectionUtility;
import revature.project.logging.LogSimulator;

public class LoginDAOImpl implements LoginDAO {


	@Override
	public boolean insertIntoLogin(Login l) {
PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "INSERT INTO banking.login VALUES(Default,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setString(1,l.getLogin_name());
			ps.setString(2, l.getLogin_pass());
			ps.setString(3, l.getRole());
		

			ps.executeUpdate();
			}catch (Exception e) {
		  System.err.println("insertIntoLogin DAOerror");
		  e.printStackTrace();
		  return false;
		  }
		LogSimulator.getLogger().trace("insertIntoLogin(" +l.getLogin_name() + ")"+ANSI_RESET );

		return true;
	}

	@Override
	public Login selectLoginNameAndPass(String name, String pass) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Login ul = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.login WHERE login_name=? AND login_pass=?";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, pass);

			rs = ps.executeQuery();
			while (rs.next()) {
				ul = new Login(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getString(4));
				
			};
			

		} catch (Exception e) {
		  System.err.println("selectLoginNameAndPass DAOerror");
		  e.printStackTrace();
		  }
		LogSimulator.getLogger().trace("selectLoginNameAndPass(" + name + pass + ")"+ANSI_RESET );

		return ul;

	}

	@Override
	public List<Login> selectAllLogin() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Login> llist = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.login";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(query);
			
			llist = new ArrayList<Login>();
			while (rs.next()) {
			Login ul = new Login();
				ul.setLogin_id(rs.getInt(1));//retrive from first column of sql table
				ul.setLogin_name(rs.getString(2));
				ul.setLogin_pass(rs.getString(3));
				ul.setRole(rs.getString(4));
				
				llist.add(ul);
			}

		} catch (Exception e) {
			System.err.println("selectAllLogin DAOerror");
			  e.printStackTrace();		}
		LogSimulator.getLogger().trace("selectAllLogin " +ANSI_RESET);

		return llist;
	}

	@Override
	public boolean updateLogin(Login l) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "UPDATE banking.login SET "
					+ "login_name=?,"
					+ "login_pass=?, role=? WHERE login_id=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, l.getLogin_name());
			ps.setString(2, l.getLogin_pass());
			ps.setString(3, l.getRole());
			ps.setInt(4, l.getLogin_id());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("UpdateLogin DAO error");
			e.printStackTrace();
			return false;
		}
		LogSimulator.getLogger().trace("UpdateLogin(" +l.getLogin_name() + ")"+ANSI_RESET );

		return true;
	}

	@Override
	public boolean deleteLoginById(Integer id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection_emp()) {
			String query = "DELETE FROM banking.login WHERE login_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("deleteLoginById DAO error");
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LogSimulator.getLogger().trace("deleteLoginById(" +id+ ")"+ANSI_RESET );

		return true;
	}

	@Override
	public Login selectLoginById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Login ul = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.login WHERE login_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				ul = new Login();
				ul.setLogin_id(rs.getInt(1));//retrive from first column of sql table
				ul.setLogin_name(rs.getString(2));
				ul.setLogin_pass(rs.getString(3));
				ul.setRole(rs.getString(4));

			}   
			
		
		} catch (Exception e) {
		  System.err.println("selectLoginById DAOerror");
		  e.printStackTrace();
		  }
		LogSimulator.getLogger().trace("selectLoginById(" + id + ")" +ANSI_RESET);

		return ul;

	}

	}


