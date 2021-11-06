package com.banking3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.banking3.models.Customer;
import com.banking3.utilities.ConnectionUtility;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean insertIntoCustomers(Customer cus) {
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection()) {
			String query = "INSERT INTO BA.customer VALUES(Default,?,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setString(1,cus.getCus_name());
			ps.setString(2, cus.getCus_email());
			ps.setDouble(3, cus.getCus_acc());
			ps.setInt(4, cus.getCus_login());
		   
			ps.executeUpdate();
			}catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  return false;
		  }
		return true;
	}

	@Override
	public Customer selectCustomerById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Customer cus = null;
		
		try(Connection con = ConnectionUtility.getConnection()) {
			System.out.println("DAOconnection");
			String query = "SELECT * FROM BA.customer WHERE cus_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				cus = new Customer();
				cus.setCus_id(rs.getInt(1));//retrive from first column of sql table
				cus.setCus_name(rs.getString(2));
				cus.setCus_email(rs.getString("cus_email"));
				cus.setCus_acc(rs.getInt("cus_acc"));
				cus.setCus_login(rs.getInt(5));
			}
			
		
		} catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  }
		
		return cus;

	}

	@Override
	public List<Customer> selectAllCustomers() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Customer> elist = null;
		
		try(Connection con = ConnectionUtility.getConnection()) {
			String query = "SELECT * FROM BA.customer";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(query);
			
			elist = new ArrayList<Customer>();
			while (rs.next()) {
			Customer cus = new Customer();
				cus.setCus_id(rs.getInt(1));//retrive from first column of sql table
				cus.setCus_name(rs.getString(2));
				cus.setCus_email(rs.getString("cus_email"));
				cus.setCus_acc(rs.getInt("cus_acc"));
				cus.setCus_login(rs.getInt(5));
				
				elist.add(cus);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return elist;
	}

	@Override
	public boolean updateCustomer(Customer cus) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "UPDATE BA.customer SET "
					+ "cus_name=?, cus_email=?, "
					+ "cus_acc=?, cus_login=? WHERE cus_id=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, cus.getCus_name());
			ps.setString(2, cus.getCus_email());
			ps.setDouble(3, cus.getCus_acc());
			ps.setInt(4, cus.getCus_login());
			ps.setInt(5, cus.getCus_id());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteCustomerById(Integer id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "DELETE FROM BA.customer WHERE cus_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
