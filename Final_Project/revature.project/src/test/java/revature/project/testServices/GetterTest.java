package revature.project.testServices;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import revature.project.banking.models.Customer;
import revature.project.banking.models.Employees;
import revature.project.banking.models.Login;

public class GetterTest {
	
private Employees e;
private Customer c;
private Login l;

	@Before
	public void setGo() {
		e = new Employees(2,	"boss",	"333-000-3456",	7 ,	"boss");
		c =  new Customer(9	,"jule",	"444-123-3212",	0.0,	11,	"pending");
		l = new Login(10,	"free",	"fpass",	"customer");
	}
	
	
	@Test
	public void EmpGet() {
	
		int id = e.getEmp_id();
		assertTrue(id == 2);
	};
	
	@Test
	public void CusGet() {
		
		int id = c.getCus_id();
		assertTrue(id == 9);
	};
	
	@Test
	public void LoginGet() {
		
		String id = l.getLogin_name();
		assertTrue(id == "free");
	};

}
