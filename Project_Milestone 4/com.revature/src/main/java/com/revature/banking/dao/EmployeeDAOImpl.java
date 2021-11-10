package com.revature.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.banking.models.Employee;
import com.revature.banking.utilities.ConnectionUtility;
import com.revature.logging.LogSimulator;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean insertIntoEmployees(Employee emp) {
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			String query = "INSERT INTO example.employees VALUES(Default,?,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setString(1,emp.getEmp_name());
			ps.setString(2, emp.getEmp_title());
			ps.setDouble(3, emp.getEmp_salary());
			ps.setInt(4, emp.getLogin_id());
		   
			ps.executeUpdate();
			}catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  return false;
		  }
		return true;
	}

	@Override
	public Employee selectEmployeeById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			System.out.println("DAOconnection");
			String query = "SELECT * FROM example.employees WHERE emp_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmp_id(rs.getInt(1));//retrive from first column of sql table
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_title(rs.getString("emp_title"));
				emp.setEmp_salary(rs.getDouble("emp_salary"));
				emp.setLogin_id(rs.getInt(5));
			}
			
		
		} catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  }
		LogSimulator.getLogger().trace("selectEmployeeById(" +id + ")" );
		return emp;

	}
	
	@Override
	public Employee selectEmployeeByLoginId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee emp = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			System.out.println("DAOconnection");
			String query = "SELECT * FROM example.employees WHERE login_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employee();
				emp.setEmp_id(rs.getInt(1));//retrive from first column of sql table
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_title(rs.getString("emp_title"));
				emp.setEmp_salary(rs.getDouble("emp_salary"));
				emp.setLogin_id(rs.getInt(5));
			}
			
		
		} catch (Exception e) {
		  System.out.println("DAOerror");
		  e.printStackTrace();
		  }
		LogSimulator.getLogger().trace("selected all uemployyee");

		return emp;

	}

	@Override
	public List<Employee> selectAllEmployees() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> elist = null;
		
		try(Connection con = ConnectionUtility.getConnection_Props()) {
			String query = "SELECT * FROM example.employees";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(query);
			
			elist = new ArrayList<Employee>();
			while (rs.next()) {
			Employee emp = new Employee();
				emp.setEmp_id(rs.getInt(1));//retrive from first column of sql table
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_title(rs.getString("emp_title"));
				emp.setEmp_salary(rs.getDouble("emp_salary"));
				emp.setLogin_id(rs.getInt(5));
				
				elist.add(emp);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return elist;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "UPDATE example.employees SET "
					+ "emp_name=?, emp_title=?, "
					+ "emp_salary=?, login_id=? WHERE emp_id=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, emp.getEmp_name());
			ps.setString(2, emp.getEmp_title());
			ps.setDouble(3, emp.getEmp_salary());
			ps.setInt(4, emp.getLogin_id());
			ps.setInt(5, emp.getEmp_id());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean deleteEmployeeById(Integer id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "DELETE FROM example.examployees WHERE emp_id=?";
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
