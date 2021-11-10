package com.revature.testServices;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.revature.banking.dao.UserDAO;
import com.revature.banking.dao.UserLoginDAO;
import com.revature.banking.models.UserLogin;
import com.revature.banking.models.Users;
import com.revature.services.NotANewUser;

public class NewUserTest {

	@InjectMocks
	private NotANewUser nanu;
	
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
	public void isUser() {
		
		Mockito.when(udao.selectUserById(login.getLogin_id())).thenReturn(u);
		Users u1 = nanu.test(u.getUser_id());
		assertEquals(u1, u);
		System.out.println("isUser Test : Pass");
	}
}
	
