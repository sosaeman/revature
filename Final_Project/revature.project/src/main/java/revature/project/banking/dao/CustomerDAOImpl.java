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

import revature.project.banking.models.Customer;
import revature.project.banking.utilities.ConnectionUtility;
import revature.project.logging.LogSimulator;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean insertIntoCustomer(Customer c) {
		PreparedStatement ps = null;

		try(Connection con = ConnectionUtility.getConnection_emp() ) {
			String query = "INSERT INTO banking.Customer VALUES(Default,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setString(1, c.getCus_name());
			ps.setString(2, c.getCus_phone());
			ps.setDouble(3, c.getCus_balance());
			ps.setInt(4, c.getLogin_id());
			ps.setString(5, c.getCus_status());

		                        
			ps.executeUpdate();
			}catch (Exception e) {
		  System.err.println("insertIntoCustomer DAOerror");
		  e.printStackTrace();
		  return false;
		  }
		LogSimulator.getLogger().trace("insertIntoCustomer(" +c.getCus_name() + ")"+ANSI_RESET );

		return true;
	}

	@Override
	public Customer selectCustomerById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.customer WHERE cus_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Customer();
				c.setCus_id(rs.getInt(1));//retrive from first column of sql table
				c.setCus_name(rs.getString(2));
				c.setCus_phone(rs.getString(3));
				c.setCus_balance(rs.getDouble(4));
				c.setLogin_id(rs.getInt(5));
				c.setCus_status(rs.getString(6));             
			}   
			
		} catch (Exception e) {
		  System.err.println("selectCustomerById DAOerror");
		  e.printStackTrace();
		  }
		LogSimulator.getLogger().trace("selectCustomerById(" + id + ")"+ANSI_RESET );

		return c;

	}

	@Override
	public List<Customer> selectAllCustomer() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Customer> clist = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.Customer";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(query);
			
			clist = new ArrayList<Customer>();
			while (rs.next()) {
			Customer c = new Customer();
			c.setCus_id(rs.getInt(1));//retrive from first column of sql table
			c.setCus_name(rs.getString(2));
			c.setCus_phone(rs.getString(3));
			c.setCus_balance(rs.getDouble(4));
			c.setLogin_id(rs.getInt(5));
			c.setCus_status(rs.getString(6));
				
				clist.add(c);
			}
		
		} catch (Exception e) {
			System.err.println("selectAllCustomer DAOerror");
			  e.printStackTrace();		
			  }
		LogSimulator.getLogger().trace("selectAllCustomer()" +ANSI_RESET);

		return clist;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtility.getConnection_emp()) {
			String query = "UPDATE banking.Customer SET "
					+ "cus_name=?,  cus_phone=?, "
					+ "cus_balance=?, cus_status=? WHERE login_id=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, c.getCus_name());
			ps.setString(2, c.getCus_phone());
			ps.setDouble(3, c.getCus_balance());
			ps.setInt(5, c.getLogin_id());
			ps.setString(4, c.getCus_status());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("updateCustomer DAOerror");
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		LogSimulator.getLogger().trace("updateCustomer(" +c.getCus_name() + ")" +ANSI_RESET);

		return true;
	}

	@Override
	public boolean deleteCustomerById(Integer id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection_emp()) {
			String query = "DELETE FROM banking.Customer WHERE cus_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("deleteCustomerById DAO error");
			e.printStackTrace();
			return false;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LogSimulator.getLogger().trace("deleteCustomerById(" + id + ")"+ANSI_RESET );

		return true;
	}

	
	@Override
	public Customer selectCustomerByNameAndPhone(String name,String phone) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.Customer WHERE cus_name=? AND cus_phone=?";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, phone);

			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Customer(
				rs.getInt(1),
				rs.getString(2),
				rs.getString(3),
				rs.getDouble(4),
				rs.getInt(5),
				rs.getString(6));
			};
		
		} catch (Exception e) {
		  System.err.println("selectCustomerByNameAndPhone DAOerror");
		  e.printStackTrace();
		  }
		LogSimulator.getLogger().trace("selectCustomerByNameAndPhone(" +name + phone + ")"+ANSI_RESET );

		return c;

	}

	@Override
	public List<Customer> selectAllCustomerWithPendingStatus() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Customer> clist = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.Customer WHERE cus_status='pending'";
			ps = con.prepareStatement(query);
			
			rs = ps.executeQuery();
			
			clist = new ArrayList<Customer>();
			while (rs.next()) {
			Customer c = new Customer();
			c.setCus_id(rs.getInt(1));//retrive from first column of sql table
			c.setCus_name(rs.getString(2));
			c.setCus_phone(rs.getString(3));
			c.setCus_balance(rs.getDouble(4));
			c.setLogin_id(rs.getInt(5));
			c.setCus_status(rs.getString(6));
			
				clist.add(c);
			}
		
		} catch (Exception e) {
			System.err.println("selectAllCustomerWithPendingStatus DAOerror");
			  e.printStackTrace();		
			  }
		LogSimulator.getLogger().trace("selectAllCustomerWithPendingStatus" +ANSI_RESET);
		return clist;
	}

	@Override
	public Customer selectCustomerLoginId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer c = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.customer WHERE login_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				c = new Customer();
				c.setCus_id(rs.getInt(1));//retrive from first column of sql table
				c.setCus_name(rs.getString(2));
				c.setCus_phone(rs.getString(3));
				c.setCus_balance(rs.getDouble(4));
				c.setLogin_id(rs.getInt(5));
				c.setCus_status(rs.getString(6));             
			}   
			
		} catch (Exception e) {
		  System.err.println("selectCustomerByLoginId DAOerror");
		  e.printStackTrace();
		  }
		LogSimulator.getLogger().trace("selectCustomerByLoginId(" + id + ")" +ANSI_RESET);

		return c;
	}

}
