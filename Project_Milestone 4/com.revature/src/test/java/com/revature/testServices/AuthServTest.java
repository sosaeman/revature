package com.revature.testServices;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.banking.dao.EmployeeDAO;
import com.revature.banking.dao.UserDAO;
import com.revature.banking.dao.UserLoginDAO;
import com.revature.banking.models.CurrentUser;
import com.revature.banking.models.Employee;
import com.revature.banking.models.UserLogin;
import com.revature.banking.models.Users;
import com.revature.banking.utilities.Withdraw;
import com.revature.services.AuthenticateWithdraw;
import com.revature.services.EmpAuthentication;
public class AuthServTest {
	@InjectMocks
	private AuthenticateWithdraw withauth;
	@InjectMocks
	private EmpAuthentication empauth;
	
	
	@Mock
	private UserLoginDAO ldao;
	
	@Mock
	private UserDAO udao;

	@Mock
	private UserLogin login;

	@Mock
	private Users u;
	
	@Before
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		login = new UserLogin(1, "maggie_login", "maggie_pass",1);
		u = new Users(1, "Maggie", "123 main st, city USA 12345","555-111-1234", 500.0);
	}
	
	@Test
	public void authTest() {
		Mockito.when(ldao.selectUserNameAndPass("maggie_login", "maggie_pass")).thenReturn(login);
		Mockito.when(udao.selectUserById(login.getLogin_id())).thenReturn(u);
		Users u1 = empauth.authenticateEmployee("maggie_login", "maggie_pass");
		assertEquals(u1, u);
		System.out.println("authTest : Pass");
	}
	@Test
	public void withdraw() {
		Mockito.when(ldao.selectUserNameAndPass("maggie_login", "maggie_pass")).thenReturn(login);
		Mockito.when(udao.selectUserById(CurrentUser.getCuser_id())).thenReturn(u);
		Users u1 = withauth.testWithdraw();
		assertEquals(u1, u);
		System.out.println(u);
		System.out.println(u1);
		System.out.println("withdraw : Pass");
	}
}
