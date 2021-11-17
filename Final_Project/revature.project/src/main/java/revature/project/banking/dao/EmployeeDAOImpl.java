package revature.project.banking.dao;

import static revature.project.colors.consoleColor.ANSI_RESET;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import revature.project.banking.models.Employees;
import revature.project.banking.utilities.ConnectionUtility;
import revature.project.logging.LogSimulator;
import revature.project.colors.consoleColor.*;
                
public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public boolean insertIntoEmployees(Employees emp) {
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "INSERT INTO banking.employees VALUES(Default,?,?,?,?)";
			ps = con.prepareStatement(query);
			
			ps.setString(1,emp.getEmp_name());
			ps.setString(2, emp.getEmp_phone());
			ps.setInt(4, emp.getLogin_id());
			ps.setString(3, emp.getEmp_title());

		   
			ps.executeUpdate();
			}catch (Exception e) {
		  System.err.println("insertIntoEmployees DAOerror");
		  e.printStackTrace();
		  return false;
		  }
		LogSimulator.getLogger().trace("insertIntoEmployees(" +emp.getEmp_name() + ")"+ANSI_RESET );

		return true;
	}

	@Override
	public Employees selectEmployeeById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employees emp = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.employees WHERE emp_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employees();
				emp.setEmp_id(rs.getInt(1));//retrive from first column of sql table
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_phone(rs.getString("emp_phone"));
				emp.setLogin_id(rs.getInt(4));
				emp.setEmp_title(rs.getString("emp_title"));

			}
			

		} catch (Exception e) {
		  System.err.println("selectEmployeeById DAOerror");
		  e.printStackTrace();
		  }
		LogSimulator.getLogger().trace("selectEmployeeById(" +id + ")" +ANSI_RESET);
		return emp;

	}
	
	@Override
	public Employees selectEmployeeByLoginId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employees emp = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.employees WHERE login_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				emp = new Employees();
				emp.setEmp_id(rs.getInt(1));//retrive from first column of sql table
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_phone(rs.getString("emp_phone"));
				emp.setLogin_id(rs.getInt(4));
				emp.setEmp_title(rs.getString("emp_title"));

			}
			

		} catch (Exception e) {
		  System.err.println("selectEmployeeByLoginId DAOerror");
		  e.printStackTrace();
		  }
		LogSimulator.getLogger().trace("selectEmployeeByLoginId "+ id+ANSI_RESET);

		return emp;

	}

	@Override
	public List<Employees> selectAllEmployees() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Employees> elist = null;
		
		try(Connection con = ConnectionUtility.getConnection_emp()) {
			String query = "SELECT * FROM banking.employees";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(query);
			
			elist = new ArrayList<Employees>();
			while (rs.next()) {
			Employees emp = new Employees();
				emp.setEmp_id(rs.getInt(1));//retrive from first column of sql table
				emp.setEmp_name(rs.getString(2));
				emp.setEmp_phone(rs.getString("emp_phone"));
				emp.setLogin_id(rs.getInt(4));
				emp.setEmp_title(rs.getString("emp_title"));

				
				elist.add(emp);
			}
		} catch (Exception e) {
			System.err.println("selectAllEmployees DAOerror");
			  e.printStackTrace();		}

		LogSimulator.getLogger().trace("selectAllEmployees "+ANSI_RESET);

		return elist;
	}

	@Override
	public boolean updateEmployee(Employees emp) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "UPDATE banking.employees SET "
					+ "emp_name=?, emp_phone=?, "
					+ "emp_login=?, login_title=? WHERE emp_id=?";
			ps = conn.prepareStatement(query);

			ps.setString(1, emp.getEmp_name());
			ps.setString(2, emp.getEmp_phone());
			ps.setInt(3, emp.getLogin_id());
			ps.setInt(5, emp.getEmp_id());
			ps.setString(4, emp.getEmp_title());


			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("updateEmployee DAOerror");

			return false;
		}
		LogSimulator.getLogger().trace(" updateEmployee "+emp.getEmp_name()+ANSI_RESET);

		return true;
	}

	@Override
	public boolean deleteEmployeeById(Integer id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			String query = "DELETE FROM banking.employees WHERE emp_id=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("deleteEmployee DAOerror");

			return false;
		}
		LogSimulator.getLogger().trace(" deleteEmployeeByID "+id+ANSI_RESET);

		return true;
	}

}
