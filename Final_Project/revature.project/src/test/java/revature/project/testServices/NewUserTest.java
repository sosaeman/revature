package revature.project.testServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import revature.project.banking.dao.CustomerDAO;
import revature.project.banking.dao.LoginDAO;
import revature.project.banking.models.Login;
import revature.project.banking.models.Customer;
import revature.project.services.NotANewUser;

public class NewUserTest {

	@InjectMocks
	private NotANewUser nanu;
	
	@Mock
	private LoginDAO ldao;
	
	@Mock
	private CustomerDAO cdao;

	@Mock
	private Login login;

	@Mock
	private Customer real,fake;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		real = new Customer(6,	"jim",	"jpass",	0.0,	8,	"open");
		 fake= new Customer(100,	"fff",	"fff",	0.0,	999,	"open");

	}

	@Test
	public void isUser() {
		
		String c1 = nanu.test(real.getLogin_id());
		assertEquals(c1, "macth");
		System.out.println("isUser Test : Pass");
	}
	
	@Test
	public void NotUser() {
		
		String c1 = nanu.test(fake.getLogin_id());
		assertNotEquals(c1, " macth");
		System.out.println("NotUser Test : Pass");
	}
}
	
