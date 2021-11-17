
package revature.project.banking.dao;

import java.util.List;

import revature.project.banking.models.Employees;

/*
 * The DAO interface defines the methods which perform basic operations
 * on our database, based on a particular table and model class
 */
public interface EmployeeDAO {
	public boolean insertIntoEmployees(Employees emp);
	public Employees selectEmployeeById(Integer id);
	public List<Employees> selectAllEmployees();
	public boolean updateEmployee(Employees emp);
	public boolean deleteEmployeeById(Integer id);
	public Employees selectEmployeeByLoginId(Integer id);
}