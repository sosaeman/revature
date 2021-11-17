package revature.project.testServices;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import revature.project.banking.dao.EmployeeDAO;
import revature.project.banking.dao.CustomerDAO;
import revature.project.banking.dao.LoginDAO;
import revature.project.banking.models.CurrentUser;
import revature.project.banking.models.Employees;
import revature.project.banking.models.Login;
import revature.project.banking.models.Customer;
import revature.project.banking.utilities.Withdraw;
import revature.project.services.AuthenticateWithdraw;
import revature.project.services.LoginAuthentication;
public class AuthServTest {
	@InjectMocks
	private AuthenticateWithdraw withauth;
	@InjectMocks
	private LoginAuthentication logauth;
	
	
	@Mock
	private LoginDAO ldao;
	
	@Mock
	private CustomerDAO cdao;

	@Mock
	private Login login;

	@Mock
	private Customer c;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		login = new Login(2,	"sosa",	"spass",	"customer");
		c = new Customer(2,	"sosa",	"098-777-5555",	900.0,	2,	"open");
	}
	@Test
	public void authTest() {
		Mockito.when(ldao.selectLoginNameAndPass("sosa", "spass")).thenReturn(login);
		Mockito.when(cdao.selectCustomerById(login.getLogin_id())).thenReturn(c);
		Object c1 = logauth.authenticateLogin("sosa", "spass");
		assertEquals(c1, c);
		System.out.println("authTest : Pass");
	}
	
	@Test
	public void withdraw() {
		Mockito.when(ldao.selectLoginNameAndPass("jim", "jpass")).thenReturn(login);
		Mockito.when(cdao.selectCustomerById(login.getLogin_id())).thenReturn(c);
		Customer c1 = withauth.testWithdraw(login.getLogin_id());
		assertEquals(c1, c);
		System.out.println(c);
		System.out.println(c1);
		System.out.println("withdraw : Pass");
	}
	
	
}
